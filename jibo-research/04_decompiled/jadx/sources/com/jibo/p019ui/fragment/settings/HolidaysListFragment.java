package com.jibo.p019ui.fragment.settings;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient;
import com.jibo.aws.integration.aws.services.person.model.Holiday;
import com.jibo.aws.integration.aws.services.person.model.HolidaysSwitchRequest;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.BaseFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HolidaysListFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f11009a = HolidaysListFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private JiboPersonAsyncClient f11010b;

    /* JADX INFO: renamed from: c */
    private List<Holiday> f11011c;

    /* JADX INFO: renamed from: d */
    private boolean f11012d;

    @BindView
    RecyclerView list;

    enum ItemType {
        empty,
        holiday
    }

    public class HolidayViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private HolidayViewHolder f11021b;

        public HolidayViewHolder_ViewBinding(HolidayViewHolder holidayViewHolder, View view) {
            this.f11021b = holidayViewHolder;
            holidayViewHolder.text1 = (TextView) Utils.m5161b(view, R.id.text1, "field 'text1'", TextView.class);
            holidayViewHolder.checkbox = (CheckBox) Utils.m5161b(view, R.id.checkbox, "field 'checkbox'", CheckBox.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            HolidayViewHolder holidayViewHolder = this.f11021b;
            if (holidayViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11021b = null;
            holidayViewHolder.text1 = null;
            holidayViewHolder.checkbox = null;
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f11011c = bundle.getParcelableArrayList("ARG_ARRAY");
        } else if (getArguments() != null) {
            this.f11011c = getArguments().getParcelableArrayList("ARG_ARRAY");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(true);
        return layoutInflater.inflate(com.jibo.R.layout.fragment_recyclerview, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.m4300b(1);
        this.list.setHasFixedSize(true);
        this.list.setItemAnimator(new DefaultItemAnimator());
        this.list.addItemDecoration(new SpacesItemDecoration(getActivity(), com.jibo.R.dimen.activity_big_margin));
        this.list.setLayoutManager(linearLayoutManager);
        this.list.setAdapter(new HolidaysAdapter(this, this.f11011c));
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        JiboPersonAsyncClient jiboPersonAsyncClient = new JiboPersonAsyncClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
        this.f11010b = jiboPersonAsyncClient;
        m10336a(jiboPersonAsyncClient);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (getArguments() == null || !getArguments().containsKey("ARG_ARRAY") || !getArguments().containsKey("ARG_TITLE") || this.f11011c.isEmpty()) {
            getActivity().onBackPressed();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        String string;
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(com.jibo.R.menu.menu_holidays, menu);
        if (this.f11011c != null && !this.f11011c.isEmpty()) {
            this.f11012d = true;
            Iterator<Holiday> it = this.f11011c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!it.next().getEnabled().booleanValue()) {
                    this.f11012d = false;
                    break;
                }
            }
            MenuItem menuItemFindItem = menu.findItem(com.jibo.R.id.action_mark);
            if (this.f11012d) {
                string = getString(com.jibo.R.string.menu_none);
            } else {
                string = getString(com.jibo.R.string.menu_all);
            }
            menuItemFindItem.setTitle(string);
            menu.findItem(com.jibo.R.id.action_mark).setEnabled(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == com.jibo.R.id.action_mark) {
            m11018a(!this.f11012d, this.f11011c);
            menuItem.setEnabled(false);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("ARG_ARRAY", (ArrayList) this.f11011c);
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
        return getString(getArguments().getInt("ARG_TITLE"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11018a(final boolean z, final List<Holiday> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Holiday> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getId());
        }
        m10344f();
        this.f11010b.switchHolidays(z, arrayList, this.f9934k.getId(), new AsyncHandler<HolidaysSwitchRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.settings.HolidaysListFragment.1
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                HolidaysListFragment.this.m10338a((Throwable) exc, "switch holidays", true);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(HolidaysSwitchRequest holidaysSwitchRequest, CommandResponse commandResponse) {
                HolidaysListFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.HolidaysListFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (Holiday holiday : list) {
                            holiday.setEnabled(Boolean.valueOf(z));
                            JiboAnalytics.m9840a(HolidaysListFragment.this.getActivity(), holiday.getName(), z);
                        }
                        HolidaysListFragment.this.getActivity().invalidateOptionsMenu();
                        HolidaysListFragment.this.list.getAdapter().notifyDataSetChanged();
                        HolidaysListFragment.this.mo10345g();
                    }
                });
            }
        });
    }

    private static class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View view) {
            super(view);
        }
    }

    static class HolidayViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        private HolidaysListFragment f11017a;

        /* JADX INFO: renamed from: b */
        private Holiday f11018b;

        /* JADX INFO: renamed from: c */
        private View.OnClickListener f11019c;

        @BindView
        public CheckBox checkbox;

        @BindView
        public TextView text1;

        public HolidayViewHolder(View view, HolidaysListFragment holidaysListFragment) {
            super(view);
            this.f11019c = new View.OnClickListener() { // from class: com.jibo.ui.fragment.settings.HolidaysListFragment.HolidayViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(HolidayViewHolder.this.f11018b);
                    HolidayViewHolder.this.f11017a.m11018a(!HolidayViewHolder.this.f11018b.getEnabled().booleanValue(), arrayList);
                }
            };
            this.f11017a = holidaysListFragment;
            ButterKnife.m5154a(this, view);
            this.itemView.setOnClickListener(this.f11019c);
            this.checkbox.setOnClickListener(this.f11019c);
        }

        /* JADX INFO: renamed from: a */
        public void m11022a(Holiday holiday) {
            this.f11018b = holiday;
            this.checkbox.setChecked(this.f11018b.getEnabled().booleanValue());
            this.text1.setText(holiday.getName());
        }
    }

    public static class HolidaysAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a */
        private HolidaysListFragment f11022a;

        /* JADX INFO: renamed from: b */
        private List<Holiday> f11023b;

        public HolidaysAdapter(HolidaysListFragment holidaysListFragment, List<Holiday> list) {
            this.f11022a = holidaysListFragment;
            this.f11023b = list;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (TextUtils.isEmpty(this.f11023b.get(i).getId())) {
                return ItemType.empty.ordinal();
            }
            return ItemType.holiday.ordinal();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == ItemType.empty.ordinal()) {
                View view = new View(this.f11022a.getActivity());
                view.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f11022a.getResources().getDimensionPixelOffset(com.jibo.R.dimen.activity_big_margin)));
                return new EmptyViewHolder(view);
            }
            return new HolidayViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(com.jibo.R.layout.item_checkbox_leftsided, viewGroup, false), this.f11022a);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder instanceof HolidayViewHolder) {
                ((HolidayViewHolder) viewHolder).m11022a(this.f11023b.get(i));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f11023b.size();
        }

        /* JADX INFO: renamed from: a */
        public Holiday m11023a(int i) {
            return this.f11023b.get(i);
        }
    }

    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a */
        private int f11024a;

        public SpacesItemDecoration(int i) {
            this.f11024a = i;
        }

        public SpacesItemDecoration(Context context, int i) {
            this(context.getResources().getDimensionPixelSize(i));
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        /* JADX INFO: renamed from: a */
        public void mo4460a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.mo4460a(rect, view, recyclerView, state);
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.set(0, this.f11024a, 0, 0);
                return;
            }
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            Holiday holidayM11023a = ((HolidaysAdapter) recyclerView.getAdapter()).m11023a(childAdapterPosition);
            Holiday holidayM11023a2 = ((HolidaysAdapter) recyclerView.getAdapter()).m11023a(childAdapterPosition - 1);
            int i = (holidayM11023a.getSubcategory() == null || holidayM11023a2.getSubcategory() == null || holidayM11023a.getSubcategory().equals(holidayM11023a2.getSubcategory())) ? 0 : this.f11024a;
            if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
                rect.set(0, i, 0, this.f11024a);
            } else {
                rect.set(0, i, 0, 0);
            }
        }
    }
}
