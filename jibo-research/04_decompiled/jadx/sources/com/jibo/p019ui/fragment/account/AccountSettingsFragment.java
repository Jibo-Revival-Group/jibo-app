package com.jibo.p019ui.fragment.account;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.JiboAnalytics;
import com.jibo.JiboSupport;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;
import com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient;
import com.jibo.aws.integration.aws.services.skills.model.GetSettingsRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.activity.TabbedActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.dialog.CantDeleteDialog;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.helpers.ViewHolders;
import com.jibo.p019ui.helpers.skills.ItemFactory;
import com.jibo.p019ui.helpers.skills.SkillBasedRecycleViewAdapter;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import com.jibo.p019ui.view.RoundedImageView;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.Util;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccountSettingsFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10023a = AccountSettingsFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private List<Items.Item> f10024b = new ArrayList();

    /* JADX INFO: renamed from: c */
    private ArrayList<Loop> f10025c;

    /* JADX INFO: renamed from: d */
    private SettingsItemsAdapter f10026d;

    /* JADX INFO: renamed from: e */
    private Account f10027e;

    /* JADX INFO: renamed from: l */
    private JiboSkillsAsyncClient f10028l;

    @BindView
    RecyclerView list;

    public static class SettingsItemsAdapter extends SkillBasedRecycleViewAdapter {

        public class LoopMemberSimpleViewHolder_ViewBinding implements Unbinder {

            /* JADX INFO: renamed from: b */
            private LoopMemberSimpleViewHolder f10043b;

            public LoopMemberSimpleViewHolder_ViewBinding(LoopMemberSimpleViewHolder loopMemberSimpleViewHolder, View view) {
                this.f10043b = loopMemberSimpleViewHolder;
                loopMemberSimpleViewHolder.avatar = (RoundedImageView) Utils.m5161b(view, R.id.icon, "field 'avatar'", RoundedImageView.class);
                loopMemberSimpleViewHolder.name = (TextView) Utils.m5161b(view, R.id.text1, "field 'name'", TextView.class);
                loopMemberSimpleViewHolder.nickName = (TextView) Utils.m5161b(view, R.id.text2, "field 'nickName'", TextView.class);
            }

            @Override // butterknife.Unbinder
            public void unbind() {
                LoopMemberSimpleViewHolder loopMemberSimpleViewHolder = this.f10043b;
                if (loopMemberSimpleViewHolder == null) {
                    throw new IllegalStateException("Bindings already cleared.");
                }
                this.f10043b = null;
                loopMemberSimpleViewHolder.avatar = null;
                loopMemberSimpleViewHolder.name = null;
                loopMemberSimpleViewHolder.nickName = null;
            }
        }

        public SettingsItemsAdapter(List<Items.Item> list, boolean z) {
            super(list, z);
        }

        @Override // com.jibo.p019ui.helpers.skills.SkillBasedRecycleViewAdapter, com.jibo.p019ui.helpers.AbstractItemRecycleViewAdapter
        protected ViewHolders.AbstractViewHolder getViewHolderByItem(View view, Items.ItemType itemType) {
            switch (itemType) {
                case text_avatar_double_row:
                    return new AvatarTwoRowsSimpleViewHolder(view);
                case member:
                    return new LoopMemberSimpleViewHolder(view);
                default:
                    return super.getViewHolderByItem(view, itemType);
            }
        }

        public static class AvatarTwoRowsSimpleViewHolder extends ViewHolders.AvatarTwoRowsSimpleViewHolder {
            public AvatarTwoRowsSimpleViewHolder(View view) {
                super(view);
                ProximaHelper.m11358b(this.subtitle);
            }
        }

        public static class LoopMemberSimpleViewHolder extends ViewHolders.AbstractViewHolder {

            @BindView
            public RoundedImageView avatar;

            @BindView
            public TextView name;

            @BindView
            public TextView nickName;

            public LoopMemberSimpleViewHolder(View view) {
                super(view);
                this.nickName.setVisibility(0);
            }

            @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
            public void invalidateView() {
                Member memberM11211b = ((Items.MemberItem) this.mItem).m11211b();
                try {
                    MemberAccount account = memberM11211b.getAccount();
                    if (!TextUtils.isEmpty(memberM11211b.getNickname())) {
                        Util.m11491a(this.name, memberM11211b.getNickname());
                    } else if (account == null) {
                        this.name.setText("");
                    } else {
                        Util.m11491a(this.name, account.getFirstName());
                    }
                } catch (Exception e) {
                    Crashlytics.m5597a((Throwable) e);
                }
                this.nickName.setText(((Items.MemberItem) this.mItem).m11212c().getString("string"));
                Util.m11490a(this.itemView.getContext(), this.avatar, memberM11211b);
            }
        }

        public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {

            /* JADX INFO: renamed from: a */
            private int f10044a;

            /* JADX INFO: renamed from: b */
            private int f10045b;

            public SpacesItemDecoration(Context context, int i, int i2) {
                this.f10044a = i != -1 ? context.getResources().getDimensionPixelOffset(i) : 0;
                this.f10045b = i2 != -1 ? context.getResources().getDimensionPixelOffset(i2) : 0;
            }

            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            /* JADX INFO: renamed from: a */
            public void mo4460a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 6) {
                    rect.top = this.f10044a;
                }
                if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 5) {
                    rect.top = this.f10044a / 2;
                }
                if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 2) {
                    rect.top = this.f10044a / 2;
                }
                rect.bottom = this.f10045b;
                if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
                    rect.top = this.f10044a / 2;
                    rect.bottom = this.f10044a / 2;
                }
            }
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments().containsKey("ARG_LOOPS")) {
            this.f10025c = getArguments().getParcelableArrayList("ARG_LOOPS");
        }
        this.f10027e = EntityData.m10089a(getActivity()).m10134i();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.jibo.R.layout.fragment_recyclerview, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f10026d = new SettingsItemsAdapter(this.f10024b, LoopHelper.isOwner(SharedPreferencesUtil.m11443f(getActivity()), EntityData.m10089a(getContext()).m10134i().getId()));
        this.list.setHasFixedSize(true);
        this.list.setItemAnimator(new DefaultItemAnimator());
        this.list.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.list.addItemDecoration(new SettingsItemsAdapter.SpacesItemDecoration(getActivity(), com.jibo.R.dimen.activity_double_vertical_margin, com.jibo.R.dimen.divider_thickness));
        this.list.setAdapter(this.f10026d);
        if (this.f10027e != null) {
            JiboSkillsAsyncClient jiboSkillsAsyncClient = new JiboSkillsAsyncClient(new BasicAWSCredentials(this.f10027e.getAccessKeyId(), this.f10027e.getSecretAccessKey()));
            this.f10028l = jiboSkillsAsyncClient;
            m10336a(jiboSkillsAsyncClient);
        }
        m10383q();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m10382b();
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
        return getString(com.jibo.R.string.title_account_settings);
    }

    /* JADX INFO: renamed from: a */
    public void m10384a() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this.f10025c != null) {
            z = false;
            z2 = false;
            for (Loop loop : this.f10025c) {
                if (!LoopHelper.isOwner(loop, EntityData.m10089a(getContext()).m10134i().getId())) {
                    z3 = z;
                    z4 = z2;
                } else if (loop.isSuspended().booleanValue()) {
                    z3 = z;
                    z4 = true;
                } else {
                    z3 = true;
                    z4 = z2;
                }
                z2 = z4;
                z = z3;
            }
        } else {
            z = false;
            z2 = false;
        }
        if (z) {
            new CantDeleteDialog().show(getActivity().getSupportFragmentManager(), CantDeleteDialog.class.getSimpleName());
            return;
        }
        JiboAnalytics.m9834a(getActivity());
        SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(this, AccountDeleteFragment.class.getName());
        builder.m10274a("ARG_IS_OWNER_AND_SUSPENDED", z2);
        builder.m10275a(1002);
    }

    /* JADX INFO: renamed from: b */
    private void m10382b() {
        Loop loopM11443f = SharedPreferencesUtil.m11443f(getActivity());
        if ((SkillsJsonParser.getInstance().getViews(null) == null || SkillsJsonParser.getInstance().getViews(null).isEmpty()) && this.f10028l != null && loopM11443f != null) {
            m10344f();
            this.f10028l.getSkillsJson(loopM11443f.getId(), new AsyncHandler<GetSettingsRequest, String>() { // from class: com.jibo.ui.fragment.account.AccountSettingsFragment.1
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    AccountSettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.account.AccountSettingsFragment.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AccountSettingsFragment.this.mo10345g();
                        }
                    });
                    AccountSettingsFragment.this.m10338a((Throwable) exc, "skills get skills json", false);
                    if (ErrorHelper.m11385b((AmazonServiceException) exc) || !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                    }
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(GetSettingsRequest getSettingsRequest, String str) {
                    SkillsJsonParser.getInstance().parseSkills(str);
                    final List<Items.Item> items = new ItemFactory(null, null).getItems(SkillsJsonParser.getInstance().getViews(null));
                    AccountSettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.account.AccountSettingsFragment.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AccountSettingsFragment.this.mo10345g();
                            if (!items.isEmpty()) {
                                AccountSettingsFragment.this.f10024b.addAll(3, items);
                                AccountSettingsFragment.this.f10026d.notifyDataSetChanged();
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: renamed from: q */
    private void m10383q() {
        this.f10024b.clear();
        Loop loopM11443f = SharedPreferencesUtil.m11443f(getActivity());
        this.f10024b.add(new Items.SubheaderItem(com.jibo.R.string.settings_about_you));
        Member memberForAccount = LoopHelper.getMemberForAccount(SharedPreferencesUtil.m11443f(getActivity()), this.f10027e);
        if (memberForAccount == null) {
            memberForAccount = new Member();
            MemberAccount memberAccount = new MemberAccount();
            memberAccount.setBirthday(this.f10027e.getBirthday());
            memberAccount.setEmail(this.f10027e.getEmail());
            memberAccount.setFirstName(this.f10027e.getFirstName());
            memberAccount.setGender(this.f10027e.getGender());
            memberAccount.setLastName(this.f10027e.getLastName());
            memberAccount.setNickName(this.f10027e.getFullName());
            memberAccount.setPhotoUrl(this.f10027e.getPhotoUrl());
            memberForAccount.setAccount(memberAccount);
            memberForAccount.setNickname(memberAccount.getNickName());
        }
        Bundle bundle = new Bundle();
        bundle.putString("string", getString(com.jibo.R.string.text_change_your_profile_information));
        this.f10024b.add(new Items.MemberItem(new View.OnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((BaseActivity) AccountSettingsFragment.this.getActivity()).m10193c(AccountSettingsDetailsFragment.class, null);
            }
        }, loopM11443f, memberForAccount, bundle));
        this.f10024b.add(new Items.SubheaderItem(com.jibo.R.string.subheader_your_jibo_skills));
        if (loopM11443f != null && SkillsJsonParser.getInstance().getViews(null) != null && !SkillsJsonParser.getInstance().getViews(null).isEmpty()) {
            List<Items.Item> items = new ItemFactory(null, null).getItems(SkillsJsonParser.getInstance().getViews(null));
            if (!items.isEmpty()) {
                this.f10024b.addAll(items);
            }
        }
        this.f10024b.add(new Items.SubheaderItem(com.jibo.R.string.text_push_notifications));
        this.f10024b.add(new Items.SwitchRowItem(new View.OnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SharedPreferencesUtil.m11433a(AccountSettingsFragment.this.getActivity(), !SharedPreferencesUtil.m11456p(AccountSettingsFragment.this.getActivity()));
                for (Items.Item item : AccountSettingsFragment.this.f10024b) {
                    if (item instanceof Items.SwitchRowItem) {
                        ((Items.SwitchRowItem) item).m11215a(SharedPreferencesUtil.m11456p(AccountSettingsFragment.this.getActivity()));
                        AccountSettingsFragment.this.f10026d.notifyItemChanged(AccountSettingsFragment.this.f10024b.indexOf(item));
                        return;
                    }
                }
            }
        }, com.jibo.R.string.text_new_content_in_gallery, SharedPreferencesUtil.m11456p(getActivity())));
        this.f10024b.add(new Items.SubheaderItem(com.jibo.R.string.text_support));
        this.f10024b.add(new Items.SimpleItem(Items.ItemType.text_bold_single_row, new View.OnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JiboAnalytics.m9856h(AccountSettingsFragment.this.getActivity());
                JiboSupport.m9868a((Activity) AccountSettingsFragment.this.getActivity());
            }
        }, com.jibo.R.string.text_help));
        this.f10024b.add(new Items.SimpleItem(Items.ItemType.text_bold_single_row, new View.OnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JiboAnalytics.m9851e(AccountSettingsFragment.this.getActivity(), JiboAnalytics.f9209aJ);
                JiboSupport.m9870b(AccountSettingsFragment.this.getActivity());
            }
        }, com.jibo.R.string.text_report_a_problem));
        this.f10024b.add(new Items.SimpleItem(Items.ItemType.text_bold_single_row, new View.OnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AccountSettingsFragment.this.getActivity().setResult(TabbedActivity.f9761c);
                AccountSettingsFragment.this.getActivity().finish();
            }
        }, com.jibo.R.string.text_log_out));
        this.f10024b.add(new Items.SimpleItem(Items.ItemType.text_button_small, new View.OnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AccountSettingsFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(AccountSettingsFragment.this.getString(com.jibo.R.string.privacy_policy_link))));
            }
        }, com.jibo.R.string.text_privacy_policy));
        this.f10024b.add(new Items.SimpleItem(Items.ItemType.text_button_small, new View.OnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AccountSettingsFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(AccountSettingsFragment.this.getString(com.jibo.R.string.terms_link))));
            }
        }, com.jibo.R.string.text_terms));
        this.f10024b.add(new Items.SimpleItem(Items.ItemType.text_button_small, new View.OnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AccountSettingsFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(AccountSettingsFragment.this.getString(com.jibo.R.string.jibo_com_link))));
            }
        }, com.jibo.R.string.text_jibo_com));
        try {
            this.f10024b.add(new Items.FooterItem(getString(com.jibo.R.string.text_app_version, getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName)));
        } catch (PackageManager.NameNotFoundException e) {
            Crashlytics.m5597a((Throwable) e);
        }
        this.f10024b.add(new Items.SimpleItem(Items.ItemType.text_button_small_red, new View.OnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AccountSettingsFragment.this.m10384a();
            }
        }, com.jibo.R.string.button_delete_account));
        this.f10026d.notifyDataSetChanged();
    }
}
