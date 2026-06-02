package com.jibo.p019ui.fragment.invite;

import android.content.Intent;
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
import butterknife.BindView;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.fragment.invite.EmailFragment;
import com.jibo.p019ui.fragment.jibos.adapter.LoopMembersListAdapter;
import com.jibo.p019ui.helpers.Items;
import com.jibo.utils.UIUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SelectGuardianFragment extends BaseLoopInviteFragment implements DialogUtils.DialogFragmentWrapperClickListener {

    @BindView
    RecyclerView list;

    /* JADX INFO: renamed from: r */
    private LoopMembersListAdapter f10530r;

    /* JADX INFO: renamed from: a */
    private List<Items.Item> f10529a = new ArrayList();

    /* JADX INFO: renamed from: s */
    private boolean f10531s = false;

    /* JADX INFO: renamed from: t */
    private View.OnClickListener f10532t = new View.OnClickListener() { // from class: com.jibo.ui.fragment.invite.SelectGuardianFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Items.MemberItem memberItem = (Items.MemberItem) view.getTag();
            if (memberItem.m11211b().getAccount() != null) {
                if (TextUtils.isEmpty(memberItem.m11211b().getAccount().getEmail()) || memberItem.m11211b().getStatus() != Member.InvitationStatus.accepted) {
                    SelectGuardianFragment.this.f10402m = memberItem.m11211b();
                    DialogUtils.m10518a(SelectGuardianFragment.this, SelectGuardianFragment.this.getFragmentManager(), 119, SelectGuardianFragment.this.getString(R.string.dialog_title_app_access), SelectGuardianFragment.this.getString(R.string.dialog_msg_app_access, SelectGuardianFragment.this.f10402m.getAccount().getFirstName()), SelectGuardianFragment.this.getString(R.string.button_add_email), SelectGuardianFragment.this.getString(android.R.string.cancel));
                } else {
                    SelectGuardianFragment.this.f10402m = memberItem.m11211b();
                    SelectGuardianFragment.this.f10404o = true;
                    SelectGuardianFragment.this.m10673a(LegalGuardianFragment.class);
                }
            }
        }
    };

    /* JADX INFO: renamed from: u */
    private View.OnClickListener f10533u = new View.OnClickListener() { // from class: com.jibo.ui.fragment.invite.SelectGuardianFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            JiboAnalytics.m9858i(SelectGuardianFragment.this.getActivity());
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.consumer.ftc.gov/articles/0031-protecting-your-childs-privacy-online"));
            if (intent.resolveActivity(SelectGuardianFragment.this.getActivity().getPackageManager()) != null) {
                SelectGuardianFragment.this.getActivity().startActivity(intent);
            } else {
                UIUtils.m11475a(SelectGuardianFragment.this.list, SelectGuardianFragment.this.getString(R.string.no_app_message));
            }
        }
    };

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f10531s = bundle.getBoolean("ARG_DIALOGSHOWN", false);
        }
        setHasOptionsMenu(false);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_recyclerview, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.f10531s) {
            this.f10531s = true;
            DialogUtils.m10526d(this, 103, getString(R.string.dialog_title_children_13), getString(R.string.dialog_msg_children_13));
        }
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("ARG_DIALOGSHOWN", this.f10531s);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        super.mo10186a(i, i2, obj);
        if (i == 119 && i2 == -1) {
            this.f10397b = false;
            Bundle bundle = new Bundle();
            bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
            bundle.putParcelable(Account.class.getSimpleName(), EntityData.m10089a(getActivity()).m10111a(this.f10402m.getAccountId()));
            bundle.putString("ARG_NICKNAME", this.f10402m.getNickname());
            bundle.putParcelable(Member.class.getSimpleName(), this.f10402m);
            bundle.putBoolean("ARG_IS_PARENT", true);
            bundle.putInt("ARG_MODE", EmailFragment.LaunchMode.set_email.ordinal());
            ((BaseActivity) getActivity()).m10193c(EmailFragment.class, bundle);
        }
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: a */
    public void mo10660a() {
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        Member memberForAccount = LoopHelper.getMemberForAccount(this.f9934k, accountM10134i);
        boolean zIsOwner = LoopHelper.isOwner(this.f9934k, accountM10134i.getId());
        this.f10529a.clear();
        this.f10529a.add(new Items.SubheaderItem(R.string.header_adults_in_your_loop));
        for (Member member : LoopHelper.sortMembers(this.f9934k, memberForAccount)) {
            if (DateTimeUtils.isAdult(member.getAccount().getBirthday()) && (member.getStatus() == Member.InvitationStatus.accepted || TextUtils.isEmpty(member.getAccount().getEmail()))) {
                this.f10529a.add(new Items.MemberItem(this.f10532t, this.f9934k, member));
            }
        }
        int activeMembersCount = LoopHelper.getActiveMembersCount(this.f9934k);
        if (zIsOwner && activeMembersCount < 16) {
            this.f10529a.add(new Items.SimpleItem(Items.ItemType.invite, new View.OnClickListener() { // from class: com.jibo.ui.fragment.invite.SelectGuardianFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SelectGuardianFragment.this.f10397b = false;
                    SelectGuardianFragment.this.f10404o = true;
                    SelectGuardianFragment.this.f10398c = new Account();
                    SelectGuardianFragment.this.f10399d = null;
                    SelectGuardianFragment.this.m10673a(NameBirthdayGenderFragment.class);
                }
            }, R.string.text_invite_parent_tothe_loop));
        }
        this.f10529a.add(new Items.FooterItem(getString(R.string.loop_invite_footer3)));
        this.f10529a.add(new Items.SimpleItem(Items.ItemType.text_button, this.f10533u, R.string.dialog_age_group_coppa));
        this.f10530r = new LoopMembersListAdapter(this.f10529a, this.f9934k, accountM10134i);
        this.list.setHasFixedSize(true);
        this.list.setItemAnimator(new DefaultItemAnimator());
        this.list.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.list.addItemDecoration(new LoopMembersListAdapter.SpacesItemDecoration(getActivity(), -1, R.dimen.activity_double_vertical_margin, R.dimen.divider_thickness));
        this.list.setAdapter(this.f10530r);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: b */
    public void mo10661b() {
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setHomeAsUpIndicator(R.drawable.arrow_white);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowCustomEnabled(false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    public String mo10353o() {
        return getString(R.string.title_select_guardian);
    }
}
