package com.jibo.p019ui.fragment.account.skills;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.google.gson.Gson;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient;
import com.jibo.aws.integration.aws.services.skills.model.DeleteSettingsRequest;
import com.jibo.aws.integration.aws.services.skills.model.UpdateSettingsRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.Commons;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.dialog.skills.MaterialTimePickerDialogFragment;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.helpers.ViewHolders;
import com.jibo.p019ui.helpers.skills.DataItems;
import com.jibo.p019ui.helpers.skills.ItemFactory;
import com.jibo.p019ui.helpers.skills.Items;
import com.jibo.p019ui.helpers.skills.SkillBasedRecycleViewAdapter;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SkillSettingsFragment extends BaseFragment implements MaterialTimePickerDialogFragment.DataChangedListener {

    /* JADX INFO: renamed from: a */
    public static final String f10075a = SkillSettingsFragment.class.getSimpleName();

    /* JADX INFO: renamed from: c */
    private SkillBasedRecycleViewAdapter f10077c;

    /* JADX INFO: renamed from: d */
    private int[] f10078d;

    /* JADX INFO: renamed from: e */
    private String f10079e;

    /* JADX INFO: renamed from: l */
    private JiboSkillsAsyncClient f10080l;

    @BindView
    RecyclerView list;

    /* JADX INFO: renamed from: b */
    private List<Items.Item> f10076b = new ArrayList();

    /* JADX INFO: renamed from: m */
    private DataPublisher f10081m = new DataPublisher() { // from class: com.jibo.ui.fragment.account.skills.SkillSettingsFragment.1
        @Override // com.jibo.ui.fragment.account.skills.SkillSettingsFragment.DataPublisher
        /* JADX INFO: renamed from: a */
        public void mo10406a(final DataItems.DataItem dataItem, final DataItems.DataValue dataValue, Commons.AsyncCallback<DataItems.DataValue> asyncCallback) {
            if (dataItem != null && dataValue != null) {
                SkillSettingsFragment.this.m10344f();
                SkillSettingsFragment.this.f10080l.updateSkill(SharedPreferencesUtil.m11443f(SkillSettingsFragment.this.getActivity()).getId(), new UpdateSettingsRequest.UpdateSettingData(dataItem.getValueDefinition().getKey(), new UpdateSettingsRequest.UpdateSettingData.UpdateSettingValue(SkillsJsonParser.getInstance().getCurrentSkill().getSkillId(), dataItem.getValueDefinition().getTarget(), new Gson().m9343a(dataValue))), new AsyncHandler<UpdateSettingsRequest, UpdateSettingsRequest.UpdateSettingData>() { // from class: com.jibo.ui.fragment.account.skills.SkillSettingsFragment.1.1
                    @Override // com.amazonaws.handlers.AsyncHandler
                    public void onError(Exception exc) {
                        SkillSettingsFragment.this.m10338a((Throwable) exc, "skills update skill", true);
                    }

                    @Override // com.amazonaws.handlers.AsyncHandler
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(UpdateSettingsRequest updateSettingsRequest, UpdateSettingsRequest.UpdateSettingData updateSettingData) {
                        SkillsJsonParser.getInstance().updateData(dataItem.getValueDefinition().getKey(), dataValue);
                        SkillsJsonParser.getInstance().setItemDataValue(((Items.SkillSimpleItem) SkillSettingsFragment.this.f10076b.get(dataItem.getIndex())).getDataItem());
                        SkillSettingsFragment.this.f10077c.notifyItemChanged(dataItem.getIndex());
                        SkillSettingsFragment.this.mo10345g();
                    }
                });
            }
        }
    };

    /* JADX INFO: renamed from: n */
    private DataPublisher f10082n = new DataPublisher() { // from class: com.jibo.ui.fragment.account.skills.SkillSettingsFragment.2
        @Override // com.jibo.ui.fragment.account.skills.SkillSettingsFragment.DataPublisher
        /* JADX INFO: renamed from: a */
        public void mo10406a(final DataItems.DataItem dataItem, DataItems.DataValue dataValue, Commons.AsyncCallback<DataItems.DataValue> asyncCallback) {
            if (dataItem != null) {
                SkillSettingsFragment.this.m10344f();
                String str = "*:workCalendar:*";
                if (dataItem.getValueDefinition().getKey().contains("personal")) {
                    str = "*:personalCalendar:*";
                }
                SkillSettingsFragment.this.f10080l.deleteSettings(SharedPreferencesUtil.m11443f(SkillSettingsFragment.this.getActivity()).getId(), new DeleteSettingsRequest.DeleteSettingData(str, new DeleteSettingsRequest.DeleteSettingData.DeleteSettingValue(SkillsJsonParser.getInstance().getCurrentSkill().getSkillId(), dataItem.getValueDefinition().getTarget())), new AsyncHandler<DeleteSettingsRequest, DeleteSettingsRequest.DeleteSettingData>() { // from class: com.jibo.ui.fragment.account.skills.SkillSettingsFragment.2.1
                    @Override // com.amazonaws.handlers.AsyncHandler
                    public void onError(Exception exc) {
                        SkillSettingsFragment.this.m10338a((Throwable) exc, "skills delete skill", true);
                    }

                    @Override // com.amazonaws.handlers.AsyncHandler
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(DeleteSettingsRequest deleteSettingsRequest, DeleteSettingsRequest.DeleteSettingData deleteSettingData) {
                        DataItems.ConnectableDataValue connectableDataValue = new DataItems.ConnectableDataValue();
                        connectableDataValue.setConnected(false);
                        SkillsJsonParser.getInstance().updateData(dataItem.getValueDefinition().getKey(), connectableDataValue);
                        SkillsJsonParser.getInstance().setItemDataValue(((Items.SkillSimpleItem) SkillSettingsFragment.this.f10076b.get(dataItem.getIndex())).getDataItem());
                        SkillSettingsFragment.this.f10077c.notifyItemChanged(dataItem.getIndex());
                        SkillSettingsFragment.this.mo10345g();
                    }
                });
            }
        }
    };

    public interface DataPublisher {
        /* JADX INFO: renamed from: a */
        void mo10406a(DataItems.DataItem dataItem, DataItems.DataValue dataValue, Commons.AsyncCallback<DataItems.DataValue> asyncCallback);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(true);
        return layoutInflater.inflate(R.layout.fragment_recyclerview, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f9934k = SharedPreferencesUtil.m11443f(getActivity());
        this.f10077c = new SkillBasedRecycleViewAdapter(this.f10076b, LoopHelper.isOwner(this.f9934k, EntityData.m10089a(getContext()).m10134i().getId()));
        this.list.setHasFixedSize(true);
        this.list.setItemAnimator(new DefaultItemAnimator());
        this.list.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.list.addItemDecoration(new SpacesItemDecoration(getActivity(), R.dimen.section_header_margin_top, R.dimen.activity_double_vertical_margin, R.dimen.divider_thickness));
        this.list.setAdapter(this.f10077c);
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        if (accountM10134i != null) {
            JiboSkillsAsyncClient jiboSkillsAsyncClient = new JiboSkillsAsyncClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
            this.f10080l = jiboSkillsAsyncClient;
            m10336a(jiboSkillsAsyncClient);
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m10411b();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        this.f10078d = bundle.getIntArray("PARAM_PATH");
        this.f10079e = bundle.getString("PARAM_TITLE");
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putIntArray("PARAM_PATH", this.f10078d);
        bundle.putString("PARAM_TITLE", this.f10079e);
        bundle.putBoolean("ARGS_SKILL_FRAGMENT", true);
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
        return this.f10079e;
    }

    /* JADX INFO: renamed from: b */
    private void m10411b() {
        this.f10076b.clear();
        List<Items.Item> items = new ItemFactory(this.f10078d, this.f10081m, this.f10082n).getItems(SkillsJsonParser.getInstance().getViews(this.f10078d));
        if (!items.isEmpty()) {
            this.f10076b.addAll(items);
        }
        this.f10077c.notifyDataSetChanged();
    }

    @Override // com.jibo.ui.fragment.dialog.skills.MaterialTimePickerDialogFragment.DataChangedListener
    /* JADX INFO: renamed from: a */
    public void mo10414a(DataItems.DataItem dataItem, DataItems.DataValue dataValue) {
        this.f10081m.mo10406a(dataItem, dataValue, null);
    }

    /* JADX INFO: renamed from: a */
    public int[] m10415a() {
        return this.f10078d;
    }

    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a */
        private int f10090a;

        /* JADX INFO: renamed from: b */
        private int f10091b;

        /* JADX INFO: renamed from: c */
        private int f10092c;

        public SpacesItemDecoration(Context context, int i, int i2, int i3) {
            this.f10090a = i != -1 ? context.getResources().getDimensionPixelOffset(i) : 0;
            this.f10091b = i2 != -1 ? context.getResources().getDimensionPixelOffset(i2) : 0;
            this.f10092c = i3 != -1 ? context.getResources().getDimensionPixelOffset(i3) : 0;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        /* JADX INFO: renamed from: a */
        public void mo4460a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (recyclerView.getChildAdapterPosition(view) == 0 && !(recyclerView.findContainingViewHolder(view) instanceof ViewHolders.SubheaderViewHolder)) {
                rect.top = this.f10090a;
            }
            rect.bottom = this.f10092c;
            if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
                rect.bottom = this.f10091b / 2;
            }
        }
    }
}
