package com.jibo.p019ui.fragment.account.skills;

import android.content.Context;
import android.graphics.Rect;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.jibo.R;
import com.jibo.api.iheart.IHeartApiServiceGenerator;
import com.jibo.api.iheart.IHeartFileHelper;
import com.jibo.api.iheart.model.Genre;
import com.jibo.api.iheart.model.LocationConfig;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient;
import com.jibo.aws.integration.aws.services.person.model.GetLoopPropertiesRequest;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.settings.LocationFragment;
import com.jibo.p019ui.helpers.AbstractItemRecycleViewAdapter;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.helpers.ViewHolders;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StationGenresFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    /* JADX INFO: renamed from: a */
    public static final String f10094a = StationGenresFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private JiboRobotPropertiesAsyncClient f10095b;

    /* JADX INFO: renamed from: c */
    private JiboPersonAsyncClient f10096c;

    /* JADX INFO: renamed from: d */
    private List<Items.Item> f10097d = new ArrayList();

    /* JADX INFO: renamed from: e */
    private AbstractItemRecycleViewAdapter.SimpleImplItemRecycleViewAdapter f10098e;

    @BindView
    View emptyView;

    @BindView
    ImageView emptyViewIcon;

    @BindView
    TextView emptyViewTextInfo;

    @BindView
    TextView emptyViewTitle;

    /* JADX INFO: renamed from: l */
    private Robot f10099l;

    @BindView
    RecyclerView list;

    /* JADX INFO: renamed from: m */
    private LocationConfig f10100m;

    /* JADX INFO: renamed from: n */
    private List<Genre> f10101n;

    /* JADX INFO: renamed from: o */
    private List<Genre> f10102o;

    /* JADX INFO: renamed from: p */
    private JsonObject f10103p;

    @BindView
    SwipeRefreshLayout swipeRefreshLayout;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_recyclerview_swiperefresh, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f9934k = SharedPreferencesUtil.m11443f(getActivity());
        this.f10098e = new AbstractItemRecycleViewAdapter.SimpleImplItemRecycleViewAdapter(this.f10097d);
        this.list.setHasFixedSize(true);
        this.list.setItemAnimator(new DefaultItemAnimator());
        this.list.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.list.addItemDecoration(new SpacesItemDecoration(getActivity(), R.dimen.section_header_margin_top, R.dimen.activity_double_vertical_margin, R.dimen.divider_thickness));
        this.list.setAdapter(this.f10098e);
        this.swipeRefreshLayout.setOnRefreshListener(this);
        this.swipeRefreshLayout.setColorSchemeResources(R.color.jibo_blue, R.color.accent_blue, R.color.accent_blue, R.color.accent_blue);
        this.emptyViewTitle.setText(R.string.text_waiting_for_your_list_of_stations);
        this.emptyViewIcon.setImageResource(R.drawable.ic_music_radio);
        this.emptyViewTextInfo.setText(R.string.text_iheart_radio_connection_problem);
        this.f10095b = EntityData.m10089a(getActivity()).m10132g();
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        JiboPersonAsyncClient jiboPersonAsyncClient = new JiboPersonAsyncClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
        this.f10096c = jiboPersonAsyncClient;
        m10336a(jiboPersonAsyncClient);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f10099l == null || this.f10100m == null || this.f10101n == null || this.f10101n.isEmpty() || TextUtils.isEmpty(RobotHelper.getCountryCode(this.f10099l))) {
            m10443r();
        } else if (this.f10103p == null) {
            m10442q();
        } else {
            m10444s();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.swipeRefreshLayout.setRefreshing(false);
        this.f10103p = null;
        this.f10102o = null;
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        this.f10099l = (Robot) bundle.getParcelable(Robot.class.getSimpleName());
        if (bundle.containsKey(LocationConfig.class.getSimpleName())) {
            this.f10100m = (LocationConfig) new Gson().m9355a(bundle.getString(LocationConfig.class.getSimpleName()), LocationConfig.class);
        }
        if (bundle.containsKey(Genre.class.getSimpleName())) {
            try {
                this.f10101n = (List) new Gson().m9356a(bundle.getString(Genre.class.getSimpleName()), new TypeToken<List<Genre>>() { // from class: com.jibo.ui.fragment.account.skills.StationGenresFragment.1
                }.getType());
            } catch (Exception e) {
            }
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(Robot.class.getSimpleName(), this.f10099l);
        if (this.f10100m != null) {
            bundle.putString(LocationConfig.class.getSimpleName(), new Gson().m9362b(this.f10100m).toString());
        }
        if (this.f10101n != null) {
            bundle.putString(Genre.class.getSimpleName(), new Gson().m9362b(this.f10101n).toString());
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
        return getString(R.string.title_music);
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    /* JADX INFO: renamed from: n_ */
    public void mo3115n_() {
        this.swipeRefreshLayout.setRefreshing(true);
        m10443r();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: g */
    public void mo10345g() {
        super.mo10345g();
        this.swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m10426b() throws Exception {
        if (IHeartApiServiceGenerator.m9882a(this.f10100m.m9892a(), null) == null) {
            throw new Exception("Empty iHeart apiUrl supplied");
        }
        this.f10101n = IHeartFileHelper.m9887a(getContext(), RobotHelper.getCountryCode(this.f10099l));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public void m10442q() {
        m10344f();
        this.f10103p = null;
        this.f10102o = null;
        this.f10101n = null;
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("com.jibo.music.stations");
            this.f10096c.getLoopProperties(this.f9934k.getId(), arrayList, new AsyncHandler<GetLoopPropertiesRequest, HashMap<String, JsonObject>>() { // from class: com.jibo.ui.fragment.account.skills.StationGenresFragment.2
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    StationGenresFragment.this.m10338a((Throwable) exc, "get account properties", false);
                    if (!ErrorHelper.m11385b((AmazonServiceException) exc) && !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                        try {
                            if (StationGenresFragment.this.m10342d()) {
                                StationGenresFragment.this.m10426b();
                            }
                        } catch (Exception e) {
                            StationGenresFragment.this.m10338a((Throwable) e, "error getting iHeart liveStationGenres", false);
                        }
                        StationGenresFragment.this.m10444s();
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x0065, code lost:
                
                    r5.f10105a.f10102o = (java.util.List) new com.google.gson.Gson().m9351a((com.google.gson.JsonElement) r2.m9382a(r0).m9395l().m9408d("genres"), new com.jibo.p019ui.fragment.account.skills.StationGenresFragment.C10762.AnonymousClass1(r5).getType());
                 */
                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onSuccess(com.jibo.aws.integration.aws.services.person.model.GetLoopPropertiesRequest r6, java.util.HashMap<java.lang.String, com.google.gson.JsonObject> r7) {
                    /*
                        r5 = this;
                        r1 = 0
                        if (r7 == 0) goto L8c
                        boolean r0 = r7.isEmpty()     // Catch: java.lang.Exception -> La2
                        if (r0 != 0) goto L8c
                        java.lang.String r0 = "com.jibo.music.stations"
                        boolean r0 = r7.containsKey(r0)     // Catch: java.lang.Exception -> La2
                        if (r0 == 0) goto L8c
                        java.lang.String r0 = "com.jibo.music.stations"
                        java.lang.Object r0 = r7.get(r0)     // Catch: java.lang.Exception -> La2
                        com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0     // Catch: java.lang.Exception -> La2
                        java.lang.String r2 = "loops"
                        boolean r0 = r0.m9406b(r2)     // Catch: java.lang.Exception -> La2
                        if (r0 == 0) goto L8c
                        com.jibo.ui.fragment.account.skills.StationGenresFragment r2 = com.jibo.p019ui.fragment.account.skills.StationGenresFragment.this     // Catch: java.lang.Exception -> La2
                        java.lang.String r0 = "com.jibo.music.stations"
                        java.lang.Object r0 = r7.get(r0)     // Catch: java.lang.Exception -> La2
                        com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0     // Catch: java.lang.Exception -> La2
                        com.jibo.p019ui.fragment.account.skills.StationGenresFragment.m10420a(r2, r0)     // Catch: java.lang.Exception -> La2
                        java.lang.String r0 = "com.jibo.music.stations"
                        java.lang.Object r0 = r7.get(r0)     // Catch: java.lang.Exception -> La2
                        com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0     // Catch: java.lang.Exception -> La2
                        java.lang.String r2 = "loops"
                        com.google.gson.JsonArray r2 = r0.m9408d(r2)     // Catch: java.lang.Exception -> La2
                        r0 = r1
                    L3d:
                        int r3 = r2.m9381a()     // Catch: java.lang.Exception -> La2
                        if (r0 >= r3) goto L8c
                        com.google.gson.JsonElement r3 = r2.m9382a(r0)     // Catch: java.lang.Exception -> La2
                        com.google.gson.JsonObject r3 = r3.m9395l()     // Catch: java.lang.Exception -> La2
                        java.lang.String r4 = "id"
                        com.google.gson.JsonElement r3 = r3.m9407c(r4)     // Catch: java.lang.Exception -> La2
                        java.lang.String r3 = r3.mo9385c()     // Catch: java.lang.Exception -> La2
                        com.jibo.ui.fragment.account.skills.StationGenresFragment r4 = com.jibo.p019ui.fragment.account.skills.StationGenresFragment.this     // Catch: java.lang.Exception -> La2
                        com.jibo.aws.integration.aws.services.loop.model.Loop r4 = com.jibo.p019ui.fragment.account.skills.StationGenresFragment.m10429c(r4)     // Catch: java.lang.Exception -> La2
                        java.lang.String r4 = r4.getId()     // Catch: java.lang.Exception -> La2
                        boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> La2
                        if (r3 == 0) goto L9f
                        com.jibo.ui.fragment.account.skills.StationGenresFragment r3 = com.jibo.p019ui.fragment.account.skills.StationGenresFragment.this     // Catch: java.lang.Exception -> La2
                        com.google.gson.Gson r4 = new com.google.gson.Gson     // Catch: java.lang.Exception -> La2
                        r4.<init>()     // Catch: java.lang.Exception -> La2
                        com.google.gson.JsonElement r0 = r2.m9382a(r0)     // Catch: java.lang.Exception -> La2
                        com.google.gson.JsonObject r0 = r0.m9395l()     // Catch: java.lang.Exception -> La2
                        java.lang.String r2 = "genres"
                        com.google.gson.JsonArray r0 = r0.m9408d(r2)     // Catch: java.lang.Exception -> La2
                        com.jibo.ui.fragment.account.skills.StationGenresFragment$2$1 r2 = new com.jibo.ui.fragment.account.skills.StationGenresFragment$2$1     // Catch: java.lang.Exception -> La2
                        r2.<init>()     // Catch: java.lang.Exception -> La2
                        java.lang.reflect.Type r2 = r2.getType()     // Catch: java.lang.Exception -> La2
                        java.lang.Object r0 = r4.m9351a(r0, r2)     // Catch: java.lang.Exception -> La2
                        java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Exception -> La2
                        com.jibo.p019ui.fragment.account.skills.StationGenresFragment.m10423a(r3, r0)     // Catch: java.lang.Exception -> La2
                    L8c:
                        com.jibo.ui.fragment.account.skills.StationGenresFragment r0 = com.jibo.p019ui.fragment.account.skills.StationGenresFragment.this     // Catch: java.lang.Exception -> Lab
                        boolean r0 = r0.m10342d()     // Catch: java.lang.Exception -> Lab
                        if (r0 == 0) goto L99
                        com.jibo.ui.fragment.account.skills.StationGenresFragment r0 = com.jibo.p019ui.fragment.account.skills.StationGenresFragment.this     // Catch: java.lang.Exception -> Lab
                        com.jibo.p019ui.fragment.account.skills.StationGenresFragment.m10424a(r0)     // Catch: java.lang.Exception -> Lab
                    L99:
                        com.jibo.ui.fragment.account.skills.StationGenresFragment r0 = com.jibo.p019ui.fragment.account.skills.StationGenresFragment.this
                        com.jibo.p019ui.fragment.account.skills.StationGenresFragment.m10427b(r0)
                        return
                    L9f:
                        int r0 = r0 + 1
                        goto L3d
                    La2:
                        r0 = move-exception
                        com.jibo.ui.fragment.account.skills.StationGenresFragment r2 = com.jibo.p019ui.fragment.account.skills.StationGenresFragment.this
                        java.lang.String r3 = "error parsing default for genres"
                        com.jibo.p019ui.fragment.account.skills.StationGenresFragment.m10430c(r2, r0, r3, r1)
                        goto L8c
                    Lab:
                        r0 = move-exception
                        com.jibo.ui.fragment.account.skills.StationGenresFragment r2 = com.jibo.p019ui.fragment.account.skills.StationGenresFragment.this
                        java.lang.String r3 = "error getting iHeart liveStationGenres"
                        com.jibo.p019ui.fragment.account.skills.StationGenresFragment.m10432d(r2, r0, r3, r1)
                        goto L99
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jibo.p019ui.fragment.account.skills.StationGenresFragment.C10762.onSuccess(com.jibo.aws.integration.aws.services.person.model.GetLoopPropertiesRequest, java.util.HashMap):void");
                }
            });
        } catch (Exception e) {
            m10338a((Throwable) e, "error get account properties", false);
        }
    }

    /* JADX INFO: renamed from: r */
    private void m10443r() {
        this.f10099l = null;
        m10344f();
        this.f10095b.getRobot(this.f9934k.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>() { // from class: com.jibo.ui.fragment.account.skills.StationGenresFragment.3
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                StationGenresFragment.this.m10338a((Throwable) exc, "get robot", false);
                if (!ErrorHelper.m11385b((AmazonServiceException) exc) && !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                    StationGenresFragment.this.m10444s();
                }
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(GetRobotRequest getRobotRequest, Robot robot) {
                String addressLine;
                Location latLon = RobotHelper.getLatLon(robot);
                if (latLon == null || !StationGenresFragment.this.m10342d()) {
                    StationGenresFragment.this.m10444s();
                    return;
                }
                try {
                    JsonObject jsonObjectM9409e = robot.getPayload().m9409e(RobotHelper.FIELD_LOCATION_OVERRIDE_OBJECT);
                    List<Address> fromLocation = new Geocoder(StationGenresFragment.this.getActivity()).getFromLocation(latLon.getLatitude(), latLon.getLongitude(), 1);
                    if (StationGenresFragment.this.m10342d() && fromLocation != null && !fromLocation.isEmpty()) {
                        Address address = fromLocation.get(0);
                        jsonObjectM9409e.m9405a(RobotHelper.FIELD_ZIPCODE, address.getPostalCode());
                        jsonObjectM9409e.m9405a(RobotHelper.FIELD_COUNTRY_CODE, address.getCountryCode());
                        if (address.getMaxAddressLineIndex() >= 2) {
                            addressLine = address.getAddressLine(1);
                        } else {
                            addressLine = jsonObjectM9409e.m9407c(RobotHelper.FIELD_CITY).mo9385c() + ", " + jsonObjectM9409e.m9407c("state").mo9385c() + " " + address.getPostalCode();
                        }
                        jsonObjectM9409e.m9405a(RobotHelper.FIELD_ADDRESS_LINE, addressLine);
                        StationGenresFragment.this.f10099l = robot;
                        StationGenresFragment.this.f10100m = new LocationConfig(address.getCountryCode().toUpperCase(), new LocationConfig.Config(IHeartApiServiceGenerator.m9883a(address.getCountryCode().toUpperCase())));
                    }
                    if (StationGenresFragment.this.m10342d()) {
                        StationGenresFragment.this.m10442q();
                    }
                } catch (Exception e) {
                    StationGenresFragment.this.f10099l = null;
                    StationGenresFragment.this.f10100m = null;
                    StationGenresFragment.this.m10338a((Throwable) e, "error during geocoding", false);
                    StationGenresFragment.this.m10444s();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s */
    public void m10444s() {
        m10337a(new Runnable() { // from class: com.jibo.ui.fragment.account.skills.StationGenresFragment.4
            @Override // java.lang.Runnable
            public void run() {
                StationGenresFragment.this.mo10345g();
                StationGenresFragment.this.emptyView.setVisibility(8);
                StationGenresFragment.this.f10097d.clear();
                StationGenresFragment.this.f10097d.add(new Items.SubheaderItem(StationGenresFragment.this.getString(R.string.text_customize_your_stations)));
                Loop loopM11443f = SharedPreferencesUtil.m11443f(StationGenresFragment.this.getActivity());
                Account accountM10134i = EntityData.m10089a(StationGenresFragment.this.getActivity()).m10134i();
                boolean z = accountM10134i != null && LoopHelper.isOwner(loopM11443f, accountM10134i.getId());
                if (StationGenresFragment.this.f10099l != null && !TextUtils.isEmpty(RobotHelper.getCountryCode(StationGenresFragment.this.f10099l))) {
                    if (StationGenresFragment.this.f10100m == null || !TextUtils.isEmpty(StationGenresFragment.this.f10100m.m9892a())) {
                        if (StationGenresFragment.this.f10101n != null && !StationGenresFragment.this.f10101n.isEmpty()) {
                            for (final Genre genre : StationGenresFragment.this.f10101n) {
                                Items.AvatarTwoRowsSimpleItem avatarTwoRowsSimpleItem = new Items.AvatarTwoRowsSimpleItem(new View.OnClickListener() { // from class: com.jibo.ui.fragment.account.skills.StationGenresFragment.4.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable(Robot.class.getSimpleName(), StationGenresFragment.this.f10099l);
                                        bundle.putString(JsonObject.class.getSimpleName(), new Gson().m9357a((JsonElement) StationGenresFragment.this.f10103p).toString());
                                        bundle.putString(Genre.class.getSimpleName(), new Gson().m9362b(genre).toString());
                                        bundle.putString(LocationConfig.class.getSimpleName(), new Gson().m9362b(StationGenresFragment.this.f10100m).toString());
                                        ((BaseActivity) StationGenresFragment.this.getActivity()).m10193c(StationsFragment.class, bundle);
                                    }
                                }, genre.m9890b(), "");
                                avatarTwoRowsSimpleItem.m11198a(R.drawable.radio_default);
                                if (StationGenresFragment.this.f10102o != null && !StationGenresFragment.this.f10102o.isEmpty() && StationGenresFragment.this.f10102o.indexOf(genre) >= 0) {
                                    int iIndexOf = StationGenresFragment.this.f10102o.indexOf(genre);
                                    avatarTwoRowsSimpleItem.m11218a((CharSequence) ((Genre) StationGenresFragment.this.f10102o.get(iIndexOf)).m9891c().m9895b());
                                    avatarTwoRowsSimpleItem.m11199a(((Genre) StationGenresFragment.this.f10102o.get(iIndexOf)).m9891c().m9896c());
                                }
                                StationGenresFragment.this.f10097d.add(avatarTwoRowsSimpleItem);
                            }
                        } else {
                            StationGenresFragment.this.emptyView.setVisibility(0);
                        }
                    } else if (!z) {
                        StationGenresFragment.this.f10097d.add(new Items.TwoRowsSimpleItem(StationGenresFragment.this.getString(R.string.text_country_notsupported_by_iheart), StationGenresFragment.this.getString(R.string.text_loop_owner_can_set_location)));
                    } else {
                        StationGenresFragment.this.f10097d.add(new Items.TwoRowsSimpleItem(StationGenresFragment.this.getString(R.string.text_country_notsupported_by_iheart), StationGenresFragment.this.m10418a(loopM11443f)));
                    }
                } else if (!z) {
                    StationGenresFragment.this.f10097d.add(new Items.TwoRowsSimpleItem(StationGenresFragment.this.getString(R.string.text_jibo_has_no_location_set), StationGenresFragment.this.getString(R.string.text_loop_owner_can_set_location)));
                } else {
                    StationGenresFragment.this.f10097d.add(new Items.TwoRowsSimpleItem(StationGenresFragment.this.getString(R.string.text_jibo_has_no_location_set), StationGenresFragment.this.m10418a(loopM11443f)));
                }
                StationGenresFragment.this.f10098e.notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public SpannableStringBuilder m10418a(final Loop loop) {
        String string = getString(R.string.text_set_your_location);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.f11651c), 0, string.length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.jibo_blue)), 0, string.length(), 33);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.jibo.ui.fragment.account.skills.StationGenresFragment.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(Loop.class.getSimpleName(), loop);
                bundle.putString("ARGS_LOCATION", RobotHelper.getLocation(StationGenresFragment.this.f10099l));
                bundle.putString(RobotHelper.FIELD_TIMEZONE, RobotHelper.getTimeZone(StationGenresFragment.this.f10099l));
                ((BaseActivity) StationGenresFragment.this.getActivity()).m10193c(LocationFragment.class, bundle);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 0, string.length(), 33);
        return spannableStringBuilder;
    }

    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a */
        private int f10113a;

        /* JADX INFO: renamed from: b */
        private int f10114b;

        /* JADX INFO: renamed from: c */
        private int f10115c;

        public SpacesItemDecoration(Context context, int i, int i2, int i3) {
            this.f10113a = i != -1 ? context.getResources().getDimensionPixelOffset(i) : 0;
            this.f10114b = i2 != -1 ? context.getResources().getDimensionPixelOffset(i2) : 0;
            this.f10115c = i3 != -1 ? context.getResources().getDimensionPixelOffset(i3) : 0;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        /* JADX INFO: renamed from: a */
        public void mo4460a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (recyclerView.getChildAdapterPosition(view) == 0 && !(recyclerView.findContainingViewHolder(view) instanceof ViewHolders.SubheaderViewHolder)) {
                rect.top = this.f10113a;
            }
            rect.bottom = this.f10115c;
            if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
                rect.bottom = this.f10114b / 2;
            }
        }
    }
}
