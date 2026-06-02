package com.jibo.p019ui.fragment.account.skills;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jibo.R;
import com.jibo.api.iheart.IHeartApiServiceGenerator;
import com.jibo.api.iheart.model.Genre;
import com.jibo.api.iheart.model.LocationConfig;
import com.jibo.api.iheart.model.Station;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient;
import com.jibo.aws.integration.aws.services.person.model.SetLoopPropertyRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.helpers.AbstractItemRecycleViewAdapter;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.helpers.ViewHolders;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes.dex */
public class StationsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    /* JADX INFO: renamed from: a */
    public static final String f10117a = StationsFragment.class.getSimpleName();

    /* JADX INFO: renamed from: c */
    private AbstractItemRecycleViewAdapter.SimpleImplItemRecycleViewAdapter f10119c;

    /* JADX INFO: renamed from: d */
    private Robot f10120d;

    /* JADX INFO: renamed from: e */
    private LocationConfig f10121e;

    @BindView
    View emptyView;

    @BindView
    ImageView emptyViewIcon;

    @BindView
    TextView emptyViewTextInfo;

    @BindView
    TextView emptyViewTitle;

    /* JADX INFO: renamed from: l */
    private List<Station> f10122l;

    @BindView
    RecyclerView list;

    /* JADX INFO: renamed from: m */
    private List<Station> f10123m;

    /* JADX INFO: renamed from: n */
    private Genre f10124n;

    /* JADX INFO: renamed from: o */
    private JsonObject f10125o;

    /* JADX INFO: renamed from: q */
    private JiboPersonAsyncClient f10127q;

    @BindView
    SwipeRefreshLayout swipeRefreshLayout;

    /* JADX INFO: renamed from: b */
    private List<Items.Item> f10118b = new ArrayList();

    /* JADX INFO: renamed from: p */
    private View.OnClickListener f10126p = new View.OnClickListener() { // from class: com.jibo.ui.fragment.account.skills.StationsFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StationItem stationItem = (StationItem) view.getTag();
            final String string = StationsFragment.this.f10125o.toString();
            JsonObject jsonObjectM10467q = StationsFragment.this.m10467q();
            if (jsonObjectM10467q != null) {
                StationsFragment.this.m10344f();
                jsonObjectM10467q.m9402a("station", new Gson().m9343a(new Station(stationItem.m10473a().m9894a(), stationItem.m10473a().m9895b(), stationItem.m10473a().m9896c(), stationItem.m10473a().m9900g())));
                StationsFragment.this.f10127q.setLoopProperty(StationsFragment.this.f9934k.getId(), "com.jibo.music.stations", StationsFragment.this.f10125o, new AsyncHandler<SetLoopPropertyRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.account.skills.StationsFragment.1.1
                    @Override // com.amazonaws.handlers.AsyncHandler
                    public void onError(Exception exc) {
                        StationsFragment.this.m10338a((Throwable) exc, "set account properties", false);
                        if (!ErrorHelper.m11385b((AmazonServiceException) exc) && !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                            try {
                                StationsFragment.this.f10125o = (JsonObject) new JsonParser().m9413a(string);
                            } catch (Exception e) {
                                StationsFragment.this.f10125o = null;
                            }
                            StationsFragment.this.m10469s();
                        }
                    }

                    @Override // com.amazonaws.handlers.AsyncHandler
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(SetLoopPropertyRequest setLoopPropertyRequest, CommandResponse commandResponse) {
                        StationsFragment.this.m10469s();
                    }
                });
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_recyclerview_swiperefresh, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f10119c = new AbstractItemRecycleViewAdapter.SimpleImplItemRecycleViewAdapter(this.f10118b);
        this.list.setHasFixedSize(true);
        this.list.setItemAnimator(new DefaultItemAnimator());
        this.list.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.list.addItemDecoration(new SpacesItemDecoration(getActivity(), R.dimen.section_header_margin_top, R.dimen.activity_double_vertical_margin, R.dimen.divider_thickness));
        this.list.setAdapter(this.f10119c);
        this.swipeRefreshLayout.setOnRefreshListener(this);
        this.swipeRefreshLayout.setColorSchemeResources(R.color.jibo_blue, R.color.accent_blue, R.color.accent_blue, R.color.accent_blue);
        this.emptyViewTitle.setText(R.string.text_waiting_for_your_list_of_stations);
        this.emptyViewIcon.setImageResource(R.drawable.ic_music_radio);
        this.emptyViewTextInfo.setText(R.string.text_iheart_radio_connection_problem);
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        JiboPersonAsyncClient jiboPersonAsyncClient = new JiboPersonAsyncClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
        this.f10127q = jiboPersonAsyncClient;
        m10336a(jiboPersonAsyncClient);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f10122l == null || (this.f10122l.isEmpty() && this.f10124n != null && this.f10124n.m9889a() != 0)) {
            m10468r();
        } else {
            m10469s();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.swipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        JsonObject jsonObjectM10451b;
        super.mo10340b(bundle);
        this.f9934k = this.f9934k == null ? SharedPreferencesUtil.m11443f(getActivity()) : this.f9934k;
        this.f10120d = (Robot) bundle.getParcelable(Robot.class.getSimpleName());
        this.f10121e = (LocationConfig) new Gson().m9355a(bundle.getString(LocationConfig.class.getSimpleName()), LocationConfig.class);
        this.f10124n = (Genre) new Gson().m9355a(bundle.getString(Genre.class.getSimpleName()), Genre.class);
        this.f10124n = this.f10124n == null ? new Genre(0, null) : this.f10124n;
        if (bundle.containsKey("PARAM_STATIONS_LOCAL")) {
            try {
                this.f10122l = (List) new Gson().m9356a(bundle.getString("PARAM_STATIONS_LOCAL"), new TypeToken<List<Station>>() { // from class: com.jibo.ui.fragment.account.skills.StationsFragment.2
                }.getType());
            } catch (Exception e) {
            }
        }
        if (bundle.containsKey("PARAM_STATIONS_ALL")) {
            try {
                this.f10123m = (List) new Gson().m9356a(bundle.getString("PARAM_STATIONS_ALL"), new TypeToken<List<Station>>() { // from class: com.jibo.ui.fragment.account.skills.StationsFragment.3
                }.getType());
            } catch (Exception e2) {
            }
        }
        String string = bundle.getString(JsonObject.class.getSimpleName());
        if (!TextUtils.isEmpty(string) && !string.equals("null")) {
            try {
                this.f10125o = (JsonObject) new JsonParser().m9413a(bundle.getString(JsonObject.class.getSimpleName()));
            } catch (Exception e3) {
            }
        }
        String str = "{'id':'" + this.f9934k.getId() + "', 'genres':[]}";
        if (this.f10125o == null) {
            this.f10125o = (JsonObject) new JsonParser().m9413a("{'loops':[" + str + "]}");
        }
        if (!this.f10125o.m9406b("loops")) {
            this.f10125o.m9402a("loops", new JsonParser().m9413a("[" + str + "]"));
        }
        if (m10451b() == null) {
            this.f10125o.m9407c("loops").m9396m().m9383a(new JsonParser().m9413a(str));
        }
        if (m10467q() == null && (jsonObjectM10451b = m10451b()) != null) {
            jsonObjectM10451b.m9408d("genres").m9383a(new Gson().m9343a(this.f10124n));
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(Robot.class.getSimpleName(), this.f10120d);
        bundle.putString(LocationConfig.class.getSimpleName(), new Gson().m9362b(this.f10121e).toString());
        bundle.putString(Genre.class.getSimpleName(), new Gson().m9362b(this.f10124n).toString());
        bundle.putString(JsonObject.class.getSimpleName(), this.f10125o.toString());
        if (this.f10122l != null) {
            bundle.putString("PARAM_STATIONS_LOCAL", new Gson().m9362b(this.f10122l));
        }
        if (this.f10123m != null) {
            bundle.putString("PARAM_STATIONS_ALL", new Gson().m9362b(this.f10123m));
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return this.f10124n.m9890b();
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    /* JADX INFO: renamed from: n_ */
    public void mo3115n_() {
        this.swipeRefreshLayout.setRefreshing(true);
        m10468r();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: g */
    public void mo10345g() {
        super.mo10345g();
        this.swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: renamed from: b */
    private JsonObject m10451b() {
        JsonArray jsonArrayM9408d;
        if (this.f10125o != null && this.f10125o.m9406b("loops") && this.f10125o.m9407c("loops").m9391h() && this.f10125o.m9407c("loops").m9396m().m9381a() > 0 && (jsonArrayM9408d = this.f10125o.m9408d("loops")) != null) {
            for (int i = 0; i < jsonArrayM9408d.m9381a(); i++) {
                JsonObject jsonObjectM9395l = jsonArrayM9408d.m9382a(i).m9395l();
                if (jsonObjectM9395l.m9406b(ShareConstants.WEB_DIALOG_PARAM_ID) && this.f9934k.getId().equals(jsonObjectM9395l.m9407c(ShareConstants.WEB_DIALOG_PARAM_ID).mo9385c())) {
                    return jsonObjectM9395l;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public JsonObject m10467q() {
        if (this.f10125o != null && this.f10125o.m9406b("loops") && this.f10125o.m9407c("loops").m9391h() && this.f10125o.m9407c("loops").m9396m().m9381a() > 0) {
            JsonObject jsonObjectM10451b = m10451b();
            JsonArray jsonArrayM9408d = jsonObjectM10451b != null ? jsonObjectM10451b.m9408d("genres") : null;
            if (jsonArrayM9408d != null) {
                for (int i = 0; i < jsonArrayM9408d.m9381a(); i++) {
                    JsonObject jsonObjectM9395l = jsonArrayM9408d.m9382a(i).m9395l();
                    if (jsonObjectM9395l.m9406b(ShareConstants.WEB_DIALOG_PARAM_ID) && this.f10124n.m9889a() == jsonObjectM9395l.m9407c(ShareConstants.WEB_DIALOG_PARAM_ID).mo9388f()) {
                        return jsonObjectM9395l;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: r */
    private void m10468r() {
        m10344f();
        this.f10122l = null;
        this.f10123m = null;
        final IHeartApiServiceGenerator.IHeartStationsApiService iHeartStationsApiServiceM9882a = IHeartApiServiceGenerator.m9882a(this.f10121e.m9892a(), null);
        iHeartStationsApiServiceM9882a.m9885a(RobotHelper.getCountryCode(this.f10120d), RobotHelper.getZipcode(this.f10120d), this.f10124n.m9889a()).mo17078a(new Callback<List<Station>>() { // from class: com.jibo.ui.fragment.account.skills.StationsFragment.4
            @Override // retrofit2.Callback
            /* JADX INFO: renamed from: a */
            public void mo10472a(Call<List<Station>> call, Response<List<Station>> response) {
                if (StationsFragment.this.m10342d()) {
                    if (!response.m17121a()) {
                        StationsFragment.this.m10469s();
                        return;
                    }
                    StationsFragment.this.f10122l = response.m17122b();
                    iHeartStationsApiServiceM9882a.m9884a(RobotHelper.getCountryCode(StationsFragment.this.f10120d), StationsFragment.this.f10124n.m9889a()).mo17078a(new Callback<List<Station>>() { // from class: com.jibo.ui.fragment.account.skills.StationsFragment.4.1
                        @Override // retrofit2.Callback
                        /* JADX INFO: renamed from: a */
                        public void mo10472a(Call<List<Station>> call2, Response<List<Station>> response2) {
                            boolean z;
                            if (StationsFragment.this.m10342d()) {
                                try {
                                    if (response2.m17121a()) {
                                        StationsFragment.this.f10123m = new ArrayList();
                                        for (Station station : response2.m17122b()) {
                                            Iterator it = StationsFragment.this.f10122l.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    if (((Station) it.next()).m9894a() == station.m9894a()) {
                                                        z = true;
                                                        break;
                                                    }
                                                } else {
                                                    z = false;
                                                    break;
                                                }
                                            }
                                            if (!z) {
                                                StationsFragment.this.f10123m.add(station);
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    StationsFragment.this.m10338a((Throwable) e, "error getting iHeart liveStations", false);
                                }
                                StationsFragment.this.m10469s();
                            }
                        }

                        @Override // retrofit2.Callback
                        /* JADX INFO: renamed from: a */
                        public void mo10471a(Call<List<Station>> call2, Throwable th) {
                            StationsFragment.this.m10338a(th, "error getting iHeart liveStations", false);
                            StationsFragment.this.m10469s();
                        }
                    });
                }
            }

            @Override // retrofit2.Callback
            /* JADX INFO: renamed from: a */
            public void mo10471a(Call<List<Station>> call, Throwable th) {
                StationsFragment.this.m10338a(th, "error getting iHeart liveStations", false);
                StationsFragment.this.m10469s();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s */
    public void m10469s() {
        m10337a(new Runnable() { // from class: com.jibo.ui.fragment.account.skills.StationsFragment.5
            @Override // java.lang.Runnable
            public void run() {
                Station stationM9891c;
                StationsFragment.this.mo10345g();
                StationsFragment.this.emptyView.setVisibility(8);
                StationsFragment.this.f10118b.clear();
                JsonObject jsonObjectM10467q = StationsFragment.this.m10467q();
                if (jsonObjectM10467q == null) {
                    stationM9891c = null;
                } else {
                    stationM9891c = ((Genre) new Gson().m9350a((JsonElement) jsonObjectM10467q, Genre.class)).m9891c();
                }
                if (StationsFragment.this.f10122l != null && StationsFragment.this.f10123m != null && StationsFragment.this.f10124n != null && StationsFragment.this.f10124n.m9889a() != 0 && jsonObjectM10467q != null) {
                    StationsFragment.this.f10118b.add(new Items.SubheaderItem(StationsFragment.this.getString(R.string.text_your_local_stations)));
                    if (!StationsFragment.this.f10122l.isEmpty()) {
                        for (Station station : StationsFragment.this.f10122l) {
                            StationItem stationItem = new StationItem(StationsFragment.this.f10126p, station, station.equals(stationM9891c));
                            stationItem.m11199a(station.m9896c());
                            StationsFragment.this.f10118b.add(stationItem);
                        }
                    } else {
                        Loop loopM11443f = SharedPreferencesUtil.m11443f(StationsFragment.this.getActivity());
                        Account accountM10134i = EntityData.m10089a(StationsFragment.this.getActivity()).m10134i();
                        if (accountM10134i != null && LoopHelper.isOwner(loopM11443f, accountM10134i.getId())) {
                            List list = StationsFragment.this.f10118b;
                            Items.ItemType itemType = Items.ItemType.text_greyed_row;
                            StationsFragment stationsFragment = StationsFragment.this;
                            Object[] objArr = new Object[2];
                            objArr[0] = StationsFragment.this.f10124n.m9890b();
                            objArr[1] = TextUtils.isEmpty(RobotHelper.getAddressLine(StationsFragment.this.f10120d)) ? RobotHelper.getLocation(StationsFragment.this.f10120d) : RobotHelper.getAddressLine(StationsFragment.this.f10120d);
                            list.add(new Items.SimpleItem(itemType, stationsFragment.getString(R.string.text_no_alternative_stations, objArr)));
                        } else {
                            StationsFragment.this.f10118b.add(new Items.TwoRowsSimpleItem(Items.ItemType.text_double_greyed_row, StationsFragment.this.getString(R.string.text_no_alternative_stations_member, StationsFragment.this.f10124n.m9890b()), StationsFragment.this.getString(R.string.text_loop_owner_can_set_location)));
                        }
                    }
                    if (StationsFragment.this.f10123m != null && !StationsFragment.this.f10123m.isEmpty()) {
                        StationsFragment.this.f10118b.add(new Items.SubheaderItem(StationsFragment.this.getString(R.string.text_all_available_stations)));
                        for (Station station2 : StationsFragment.this.f10123m) {
                            StationItem stationItem2 = new StationItem(StationsFragment.this.f10126p, station2, station2.equals(stationM9891c));
                            stationItem2.m11199a(station2.m9896c());
                            StationsFragment.this.f10118b.add(stationItem2);
                        }
                    }
                } else {
                    StationsFragment.this.emptyView.setVisibility(0);
                }
                StationsFragment.this.f10119c.notifyDataSetChanged();
            }
        });
    }

    private static class StationItem extends Items.AvatarRadioTwoRowsSimpleItem {

        /* JADX INFO: renamed from: a */
        private Station f10140a;

        public StationItem(View.OnClickListener onClickListener, Station station, boolean z) {
            super(onClickListener, station.m9895b(), station.m9899f(), z);
            this.f10140a = station;
        }

        /* JADX INFO: renamed from: a */
        public Station m10473a() {
            return this.f10140a;
        }
    }

    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a */
        private int f10137a;

        /* JADX INFO: renamed from: b */
        private int f10138b;

        /* JADX INFO: renamed from: c */
        private int f10139c;

        public SpacesItemDecoration(Context context, int i, int i2, int i3) {
            this.f10137a = i != -1 ? context.getResources().getDimensionPixelOffset(i) : 0;
            this.f10138b = i2 != -1 ? context.getResources().getDimensionPixelOffset(i2) : 0;
            this.f10139c = i3 != -1 ? context.getResources().getDimensionPixelOffset(i3) : 0;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        /* JADX INFO: renamed from: a */
        public void mo4460a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (recyclerView.getChildAdapterPosition(view) == 0 && !(recyclerView.findContainingViewHolder(view) instanceof ViewHolders.SubheaderViewHolder)) {
                rect.top = this.f10137a;
            }
            rect.bottom = this.f10139c;
            if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
                rect.bottom = this.f10138b / 2;
            }
        }
    }
}
