package com.jibo.p019ui.fragment.invite;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.jibos.adapter.LoopMembersListAdapter;
import com.jibo.p019ui.helpers.Items;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LoopMembersFragment extends BaseLoopInviteFragment {

    /* JADX INFO: renamed from: a */
    private List<Items.Item> f10457a = new ArrayList();

    @BindView
    RecyclerView list;

    /* JADX INFO: renamed from: r */
    private LoopMembersListAdapter f10458r;

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(false);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_recyclerview, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: a */
    public void mo10660a() {
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        Member memberForAccount = LoopHelper.getMemberForAccount(this.f9934k, accountM10134i);
        this.f10457a.clear();
        Iterator<Member> it = LoopHelper.sortMembers(this.f9934k, memberForAccount).iterator();
        while (it.hasNext()) {
            this.f10457a.add(new Items.MemberItem(this.f9934k, it.next()));
        }
        this.f10458r = new LoopMembersListAdapter(this.f10457a, this.f9934k, accountM10134i);
        this.list.setHasFixedSize(true);
        this.list.setItemAnimator(new DefaultItemAnimator());
        this.list.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.list.addItemDecoration(new LoopMembersListAdapter.SpacesItemDecoration(getActivity(), R.dimen.activity_double_vertical_margin, R.dimen.activity_double_vertical_margin, R.dimen.divider_thickness));
        this.list.setAdapter(this.f10458r);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: b */
    public void mo10661b() {
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setHomeAsUpIndicator(R.drawable.x_white);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    public String mo10353o() {
        return getString(R.string.title_your_loop);
    }
}
