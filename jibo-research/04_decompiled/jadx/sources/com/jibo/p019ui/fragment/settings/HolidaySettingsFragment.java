package com.jibo.p019ui.fragment.settings;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import butterknife.BindView;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.google.gson.JsonObject;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient;
import com.jibo.aws.integration.aws.services.person.model.GetLoopPropertiesRequest;
import com.jibo.aws.integration.aws.services.person.model.Holiday;
import com.jibo.aws.integration.aws.services.person.model.HolidaysSwitchRequest;
import com.jibo.aws.integration.aws.services.person.model.ListHolidaysRequest;
import com.jibo.aws.integration.aws.services.person.model.SetLoopPropertyRequest;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.helpers.ViewHolders;
import com.jibo.p019ui.view.RecyclerViewFastScroller;
import com.jibo.utils.CustomHolidaysUtils;
import com.jibo.utils.LoopHolidaysAlarmReceiver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HolidaySettingsFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10972a = HolidaySettingsFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    ArrayList<Holiday> f10973b = new ArrayList<>();

    /* JADX INFO: renamed from: c */
    private JiboPersonAsyncClient f10974c;

    /* JADX INFO: renamed from: d */
    private HolidaysAdapter f10975d;

    /* JADX INFO: renamed from: e */
    private Holiday f10976e;

    @BindView
    RecyclerViewFastScroller fastScroller;

    @BindView
    RecyclerView list;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_holiday_settings, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false) { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.1
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            /* JADX INFO: renamed from: c */
            public void mo4229c(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.mo4229c(recycler, state);
                int iM = m4325m();
                if (iM != 0) {
                    if (iM == -1) {
                        HolidaySettingsFragment.this.fastScroller.setVisibility(8);
                    }
                } else {
                    HolidaySettingsFragment.this.fastScroller.setVisibility(HolidaySettingsFragment.this.f10975d.getItemCount() > (m4326n() - iM) + 1 ? 0 : 8);
                }
            }
        };
        linearLayoutManager.m4300b(1);
        this.list.setHasFixedSize(true);
        this.list.addItemDecoration(new SpacesItemDecoration(getActivity(), R.dimen.activity_big_margin));
        this.list.setItemAnimator(new DefaultItemAnimator());
        this.list.setLayoutManager(linearLayoutManager);
        this.fastScroller.setRecyclerView(this.list);
        this.fastScroller.m11289a(R.layout.view_fast_scroller, R.id.fastscroller_bubble, R.id.fastscroller_handle);
        this.f10975d = new HolidaysAdapter();
        this.list.setAdapter(this.f10975d);
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        JiboPersonAsyncClient jiboPersonAsyncClient = new JiboPersonAsyncClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
        this.f10974c = jiboPersonAsyncClient;
        m10336a(jiboPersonAsyncClient);
        LoopHolidaysAlarmReceiver.m11414b(getActivity(), this.f9934k);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f9934k == null) {
            m10341c().postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    HolidaySettingsFragment.this.getActivity().onBackPressed();
                }
            }, 100L);
        } else {
            m10979a();
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("holidays", this.f10973b);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        if (bundle != null && bundle.containsKey("holidays")) {
            this.f10973b = bundle.getParcelableArrayList("holidays");
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
        return getString(R.string.title_holiday_setting);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        super.mo10186a(i, i2, obj);
        if (i == 124) {
            if (i2 == 0) {
                List<Holiday> listM10991b = m10991b(this.f10973b);
                int i3 = -1;
                for (int i4 = 0; i4 < listM10991b.size() && i3 == -1; i4++) {
                    Holiday holiday = listM10991b.get(i4);
                    if (this.f10976e.getName().equals(holiday.getName()) && this.f10976e.getDate().equals(holiday.getDate())) {
                        i3 = i4;
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
                bundle.putSerializable("args_custom_holidays", (ArrayList) listM10991b);
                bundle.putInt("args_custom_holidays_pos", i3);
                ((BaseActivity) getActivity()).m10187a(CustomHolidaySettingsFragment.class, bundle);
                return;
            }
            if (i2 == 1) {
                DialogUtils.m10524c(this, 125, getString(R.string.dialog_custom_holidays_body, this.f10976e.getName()), getString(R.string.remove), getString(R.string.dialog_custom_holidays_keep_button));
                return;
            }
            return;
        }
        if (i == 125) {
            m10980a(this.f10976e);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10979a() {
        if (this.f10974c != null && this.f9934k != null) {
            m10344f();
            this.f10974c.listHolidays(this.f9934k.getId(), new AsyncHandler<ListHolidaysRequest, List<Holiday>>() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.3
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    HolidaySettingsFragment.this.m10338a((Throwable) exc, "list holidays", true);
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(ListHolidaysRequest listHolidaysRequest, final List<Holiday> list) {
                    HolidaySettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HolidaySettingsFragment.this.m10986a((List<Holiday>) list);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10989a(final boolean z, final List<Holiday> list) {
        m10344f();
        ArrayList arrayList = new ArrayList();
        Iterator<Holiday> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getId());
        }
        this.f10974c.switchHolidays(z, arrayList, this.f9934k.getId(), new AsyncHandler<HolidaysSwitchRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.4
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                HolidaySettingsFragment.this.m10338a((Throwable) exc, "switch holidays", true);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(HolidaysSwitchRequest holidaysSwitchRequest, CommandResponse commandResponse) {
                HolidaySettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (Holiday holiday : list) {
                            holiday.setEnabled(Boolean.valueOf(z));
                            if (HolidaySettingsFragment.this.f10973b.indexOf(holiday) != -1 && !holiday.getCategory().equals(Holiday.CATEGORY_BIRTHDAY)) {
                                int iM10974a = HolidaySettingsFragment.this.m10974a(HolidaySettingsFragment.this.f10973b, holiday);
                                Items.Item itemM11010a = ((HolidaysAdapter) HolidaySettingsFragment.this.list.getAdapter()).m11010a(iM10974a);
                                if (itemM11010a != null) {
                                    ((Items.StateSwitchItem) itemM11010a).m11215a(z);
                                }
                                HolidaySettingsFragment.this.list.getAdapter().notifyItemChanged(iM10974a);
                            }
                            JiboAnalytics.m9840a(HolidaySettingsFragment.this.getActivity(), holiday.getName(), z);
                        }
                        ((Items.StateSwitchItem) ((HolidaysAdapter) HolidaySettingsFragment.this.list.getAdapter()).m11010a(0)).m11215a(HolidaySettingsFragment.this.m10993b());
                        HolidaySettingsFragment.this.list.getAdapter().notifyItemChanged(0);
                        HolidaySettingsFragment.this.mo10345g();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10987a(List<Holiday> list, List<Holiday> list2) {
        HashMap map = new HashMap();
        for (Holiday holiday : list) {
            map.put(holiday.getId(), holiday);
        }
        this.f10973b.clear();
        this.f10973b.addAll(map.values());
        this.f10973b.addAll(list2);
        Collections.sort(this.f10973b, new HolidayComparator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public ArrayList<Holiday> m10978a(String str) {
        ArrayList<Holiday> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str) || this.f10973b == null || this.f10973b.isEmpty()) {
            return arrayList;
        }
        for (Holiday holiday : this.f10973b) {
            if (str.equals(holiday.getCategory())) {
                arrayList.add(holiday);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public boolean m10993b() {
        ArrayList<Holiday> arrayListM10978a = m10978a(Holiday.CATEGORY_BIRTHDAY);
        if (arrayListM10978a == null || arrayListM10978a.isEmpty()) {
            return false;
        }
        return arrayListM10978a.get(0).getEnabled().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public void m11003q() {
        Items.SimpleItem checkboxDateItem;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view instanceof CompoundButton) {
                    HolidaySettingsFragment.this.m10989a(((CompoundButton) view).isChecked(), HolidaySettingsFragment.this.m10978a(Holiday.CATEGORY_BIRTHDAY));
                } else if (view.getTag() instanceof Items.SwitchRowItem) {
                    HolidaySettingsFragment.this.m10989a(!HolidaySettingsFragment.this.m10993b(), HolidaySettingsFragment.this.m10978a(Holiday.CATEGORY_BIRTHDAY));
                }
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List listM10991b = HolidaySettingsFragment.this.m10991b(HolidaySettingsFragment.this.f10973b);
                Bundle bundle = new Bundle();
                bundle.putParcelable(Loop.class.getSimpleName(), HolidaySettingsFragment.this.f9934k);
                bundle.putSerializable("args_custom_holidays", (ArrayList) listM10991b);
                ((BaseActivity) HolidaySettingsFragment.this.getActivity()).m10187a(CustomHolidaySettingsFragment.class, bundle);
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Items.SwitchRowItem(onClickListener, R.string.text_birthdays, m10993b()));
        arrayList.add(new Items.SimpleItem(Items.ItemType.add_custom_holiday, onClickListener2));
        for (final Holiday holiday : this.f10973b) {
            if (!TextUtils.isEmpty(holiday.getName())) {
                if (!holiday.getCategory().equalsIgnoreCase("custom")) {
                    checkboxDateItem = new Items.CheckboxItem(new View.OnClickListener() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(holiday);
                            HolidaySettingsFragment.this.m10989a(!holiday.getEnabled().booleanValue(), arrayList2);
                            HolidaySettingsFragment.this.f10976e = holiday;
                            HolidaySettingsFragment.this.m10988a(HolidaySettingsFragment.this.f10976e.getEnabled().booleanValue() ? false : true, HolidaySettingsFragment.this.f10976e);
                        }
                    }, holiday.getName(), holiday.getEnabled().booleanValue());
                } else {
                    checkboxDateItem = new Items.CheckboxDateItem(new View.OnClickListener() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HolidaySettingsFragment.this.f10976e = holiday;
                            HolidaySettingsFragment.this.m10988a(!HolidaySettingsFragment.this.f10976e.getEnabled().booleanValue(), HolidaySettingsFragment.this.f10976e);
                        }
                    }, new View.OnLongClickListener() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.9
                        @Override // android.view.View.OnLongClickListener
                        public boolean onLongClick(View view) {
                            HolidaySettingsFragment.this.f10976e = holiday;
                            DialogUtils.m10515a(HolidaySettingsFragment.this, 124, HolidaySettingsFragment.this.f10976e.getName(), new int[]{R.drawable.ic_pencil, R.drawable.ic_trash}, new String[]{HolidaySettingsFragment.this.getString(R.string.action_edit), HolidaySettingsFragment.this.getString(R.string.remove)});
                            return true;
                        }
                    }, holiday.getName(), holiday.getDate(), holiday.getEnabled().booleanValue());
                }
                arrayList.add(checkboxDateItem);
            }
        }
        this.f10975d.m11013a(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10986a(final List<Holiday> list) {
        if (this.f10974c != null && this.f9934k != null) {
            m10344f();
            this.f10974c.getLoopProperties(this.f9934k.getId(), Arrays.asList("customHolidays"), new AsyncHandler<GetLoopPropertiesRequest, HashMap<String, JsonObject>>() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.10
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    HolidaySettingsFragment.this.m10338a((Throwable) exc, "list custom holidays", false);
                    HolidaySettingsFragment.this.m10987a((List<Holiday>) list, new ArrayList());
                    HolidaySettingsFragment.this.m11003q();
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(GetLoopPropertiesRequest getLoopPropertiesRequest, final HashMap<String, JsonObject> map) {
                    HolidaySettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            List<Holiday> listM11380a = CustomHolidaysUtils.m11380a(map);
                            HolidaySettingsFragment.this.m10998c(listM11380a);
                            HolidaySettingsFragment.this.m10987a((List<Holiday>) list, listM11380a);
                            HolidaySettingsFragment.this.m11003q();
                            HolidaySettingsFragment.this.mo10345g();
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10980a(final Holiday holiday) {
        List<Holiday> listM10991b = m10991b(this.f10973b);
        listM10991b.remove(holiday);
        if (this.f10974c != null && this.f9934k != null) {
            m10344f();
            this.f10974c.setLoopProperty(this.f9934k.getId(), "customHolidays", CustomHolidaysUtils.m11378a(listM10991b), new AsyncHandler<SetLoopPropertyRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.11
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    HolidaySettingsFragment.this.m10338a((Throwable) exc, "remove custom holidays", true);
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(SetLoopPropertyRequest setLoopPropertyRequest, CommandResponse commandResponse) {
                    HolidaySettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int iM10974a = HolidaySettingsFragment.this.m10974a(HolidaySettingsFragment.this.f10973b, holiday);
                            HolidaySettingsFragment.this.f10973b.remove(holiday);
                            ((HolidaysAdapter) HolidaySettingsFragment.this.list.getAdapter()).m11014b(iM10974a);
                            HolidaySettingsFragment.this.list.getAdapter().notifyItemRemoved(iM10974a);
                            HolidaySettingsFragment.this.mo10345g();
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10988a(final boolean z, final Holiday holiday) {
        holiday.setEnabled(Boolean.valueOf(z));
        List<Holiday> listM10991b = m10991b(this.f10973b);
        if (this.f10974c != null && this.f9934k != null) {
            m10344f();
            this.f10974c.setLoopProperty(this.f9934k.getId(), "customHolidays", CustomHolidaysUtils.m11378a(listM10991b), new AsyncHandler<SetLoopPropertyRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.12
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    holiday.setEnabled(Boolean.valueOf(!z));
                    HolidaySettingsFragment.this.m10338a((Throwable) exc, "switch custom holidays", true);
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(SetLoopPropertyRequest setLoopPropertyRequest, CommandResponse commandResponse) {
                    HolidaySettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.HolidaySettingsFragment.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int iM10974a = HolidaySettingsFragment.this.m10974a(HolidaySettingsFragment.this.f10973b, holiday);
                            Items.Item itemM11010a = ((HolidaysAdapter) HolidaySettingsFragment.this.list.getAdapter()).m11010a(iM10974a);
                            if (itemM11010a != null) {
                                ((Items.StateSwitchItem) itemM11010a).m11215a(z);
                            }
                            HolidaySettingsFragment.this.list.getAdapter().notifyItemChanged(iM10974a);
                            HolidaySettingsFragment.this.mo10345g();
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public List<Holiday> m10991b(List<Holiday> list) {
        ArrayList arrayList = new ArrayList();
        for (Holiday holiday : list) {
            if (holiday.getCategory().equalsIgnoreCase("custom")) {
                arrayList.add(holiday);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public int m10974a(List<Holiday> list, Holiday holiday) {
        return list.indexOf(holiday) - (m10978a(Holiday.CATEGORY_BIRTHDAY).size() - 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m10998c(List<Holiday> list) {
        for (int size = list.size(); size > 0; size--) {
            if (list.get(size - 1).getCategory() == null) {
                list.remove(size - 1);
            }
        }
    }

    public static class HolidaysAdapter extends RecyclerView.Adapter<ViewHolders.AbstractViewHolder> implements RecyclerViewFastScroller.BubbleTextGetter {

        /* JADX INFO: renamed from: a */
        private List<Items.Item> f11006a = new ArrayList();

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.f11006a.get(i).getItemType().ordinal();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.f11006a == null) {
                return 0;
            }
            return this.f11006a.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ViewHolders.AbstractViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Items.ItemType itemType = Items.ItemType.values()[i];
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(itemType.getLayoutId(), viewGroup, false);
            switch (itemType) {
                case switch_row:
                case checkbox_row_leftsided:
                    return new ViewHolders.SwitchStateViewHolder(viewInflate);
                case checkbox_date_row_leftsided:
                    return new ViewHolders.SwitchStateWithDateViewHolder(viewInflate);
                default:
                    return new ViewHolders.SimpleViewHolder(viewInflate);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ViewHolders.AbstractViewHolder abstractViewHolder, int i) {
            abstractViewHolder.setData(this.f11006a.get(i));
        }

        /* JADX INFO: renamed from: a */
        public void m11013a(List<Items.Item> list) {
            this.f11006a.clear();
            this.f11006a.addAll(list);
            notifyDataSetChanged();
        }

        /* JADX INFO: renamed from: a */
        public Items.Item m11010a(int i) {
            if (i < 0 || i >= this.f11006a.size()) {
                return null;
            }
            return this.f11006a.get(i);
        }

        /* JADX INFO: renamed from: b */
        public void m11014b(int i) {
            if (i >= 0 && i < this.f11006a.size()) {
                this.f11006a.remove(i);
            }
        }

        @Override // com.jibo.ui.view.RecyclerViewFastScroller.BubbleTextGetter
        /* JADX INFO: renamed from: c */
        public String mo11015c(int i) {
            Items.Item item = (i <= 0 || i >= this.f11006a.size()) ? null : this.f11006a.get(i);
            if (item != null && (item instanceof Items.CheckboxItem)) {
                return ((Items.CheckboxItem) item).m11214e().toString().substring(0, 1);
            }
            return "";
        }
    }

    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a */
        private int f11007a;

        public SpacesItemDecoration(int i) {
            this.f11007a = i;
        }

        public SpacesItemDecoration(Context context, int i) {
            this(context.getResources().getDimensionPixelSize(i));
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        /* JADX INFO: renamed from: a */
        public void mo4460a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.mo4460a(rect, view, recyclerView, state);
            if (recyclerView.getChildAdapterPosition(view) == 0 || recyclerView.getChildAdapterPosition(view) == 1 || recyclerView.getChildAdapterPosition(view) == 2) {
                rect.set(0, this.f11007a, 0, 0);
            } else if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
                rect.set(0, 0, 0, this.f11007a);
            }
        }
    }

    public static class HolidayComparator implements Comparator<Holiday> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Holiday holiday, Holiday holiday2) {
            return (holiday.getName() != null ? holiday.getName() : "").compareTo(holiday2.getName() != null ? holiday2.getName() : "");
        }
    }
}
