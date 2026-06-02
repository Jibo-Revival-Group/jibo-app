package com.jibo.p019ui.activity;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.exception.ResourceNotFoundException;
import com.jibo.aws.integration.aws.services.loop.model.AcceptLoopInvitationRequest;
import com.jibo.aws.integration.aws.services.loop.model.DeclineLoopInvitationRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.dialog.CircleProgressFragment;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.fragment.jibos.adapter.LoopMembersListAdapter;
import com.jibo.p019ui.helpers.Items;
import com.jibo.service.SyncHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LoopInviteDetailsActivity extends BaseActivity {

    @BindView
    View buttonAccept;

    @BindView
    View buttonDecline;

    /* JADX INFO: renamed from: h */
    private LoopMembersListAdapter f9801h;

    /* JADX INFO: renamed from: i */
    private Loop f9802i;

    /* JADX INFO: renamed from: k */
    private CircleProgressFragment f9804k;

    /* JADX INFO: renamed from: l */
    private List<Loop> f9805l;

    /* JADX INFO: renamed from: m */
    private boolean f9806m;

    @BindView
    RecyclerView recyclerView;

    /* JADX INFO: renamed from: j */
    private List<Items.Item> f9803j = new ArrayList();

    /* JADX INFO: renamed from: n */
    private boolean f9807n = false;

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.LoopInviteDetailsActivity");
        super.onResume();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.LoopInviteDetailsActivity");
        super.onStart();
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.LoopInviteDetailsActivity");
        getIntent().putExtra(f9760b, R.layout.activity_loop_invite_details);
        super.onCreate(bundle);
        ArrayList parcelableArrayList = null;
        if (getIntent() != null) {
            this.f9802i = (Loop) getIntent().getParcelableExtra(Loop.class.getSimpleName());
            parcelableArrayList = getIntent().getParcelableArrayListExtra(" ARGS_LOOPS_LIST");
            this.f9806m = getIntent().getBooleanExtra(" ARGS_HAS_ACCEPTED_LOOPS", false);
        } else if (bundle != null) {
            this.f9802i = (Loop) bundle.getParcelable(Loop.class.getSimpleName());
            parcelableArrayList = bundle.getParcelableArrayList(" ARGS_LOOPS_LIST");
            this.f9806m = bundle.getBoolean(" ARGS_HAS_ACCEPTED_LOOPS", false);
        }
        this.f9807n = this.f9806m ? false : true;
        if (parcelableArrayList != null) {
            this.f9805l = new LinkedList(parcelableArrayList);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.addItemDecoration(new LoopMembersListAdapter.SpacesItemDecoration(this, -1, R.dimen.activity_double_vertical_margin, R.dimen.divider_thickness));
        m10224r();
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @OnClick
    public void onJoinClick(View view) {
        if (this.f9802i.isSuspended().booleanValue()) {
            m10223q();
            return;
        }
        this.buttonAccept.setClickable(false);
        this.buttonDecline.setClickable(false);
        m10226t();
        if (this.f9804k == null) {
            this.f9804k = new CircleProgressFragment();
            this.f9804k.m10509c(getString(R.string.joining_loop_suffix, new Object[]{this.f9802i.getName()}));
            this.f9804k.show(getSupportFragmentManager(), "CircleFragment");
            this.f9804k.m10504a(new CircleProgressFragment.OnDismissListener() { // from class: com.jibo.ui.activity.LoopInviteDetailsActivity.1
                @Override // com.jibo.ui.fragment.dialog.CircleProgressFragment.OnDismissListener
                /* JADX INFO: renamed from: a */
                public void mo10227a(CircleProgressFragment.Status status) {
                    if (status == CircleProgressFragment.Status.Success) {
                        LoopInviteDetailsActivity.this.m10225s();
                    } else {
                        LoopInviteDetailsActivity.this.buttonAccept.setClickable(true);
                        LoopInviteDetailsActivity.this.buttonDecline.setClickable(true);
                    }
                }
            });
        }
        EntityData.m10089a(this).m10122b().acceptInvitation(this.f9802i.getId(), new AsyncHandler<AcceptLoopInvitationRequest, Loop>() { // from class: com.jibo.ui.activity.LoopInviteDetailsActivity.2
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                LoopInviteDetailsActivity.this.f9804k.m10507b(LoopInviteDetailsActivity.this.getString(R.string.joining_loop_fail));
                LoopInviteDetailsActivity.this.m10188a(exc, "accept invitation");
                LoopInviteDetailsActivity.this.buttonAccept.setClickable(true);
                LoopInviteDetailsActivity.this.buttonDecline.setClickable(true);
                if ((exc instanceof ResourceNotFoundException) && "LOOP_NOT_FOUND".equals(((ResourceNotFoundException) exc).getErrorCode())) {
                    SyncHelper.m10179b(LoopInviteDetailsActivity.this, LoopInviteDetailsActivity.this.f9802i.getId());
                    LoopInviteDetailsActivity.this.finish();
                }
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(AcceptLoopInvitationRequest acceptLoopInvitationRequest, Loop loop) throws Throwable {
                LoopInviteDetailsActivity.this.f9806m = true;
                LoopInviteDetailsActivity.this.setResult(-1);
                JiboAnalytics.m9847c((Context) LoopInviteDetailsActivity.this, true);
                EntityData.m10089a(LoopInviteDetailsActivity.this).m10118a(loop, true);
                SyncHelper.m10179b(LoopInviteDetailsActivity.this, LoopInviteDetailsActivity.this.f9802i.getId());
                LoopInviteDetailsActivity.this.f9804k.m10505a(LoopInviteDetailsActivity.this.getString(R.string.joining_loop_success));
                LoopInviteDetailsActivity.this.f9804k = null;
            }
        });
    }

    /* JADX INFO: renamed from: q */
    private void m10223q() {
        DialogUtils.m10525c((Fragment) null, getSupportFragmentManager(), 103, getString(R.string.loop_is_suspended), getString(R.string.loop_is_suspended_text, new Object[]{this.f9802i.getName()}));
    }

    @OnClick
    public void onDeclineClick(View view) {
        if (this.f9802i.isSuspended().booleanValue()) {
            m10223q();
            return;
        }
        this.buttonAccept.setClickable(false);
        this.buttonDecline.setClickable(false);
        m10226t();
        if (this.f9804k == null) {
            this.f9804k = new CircleProgressFragment();
            this.f9804k.m10509c(getString(R.string.declining_loop_suffix, new Object[]{this.f9802i.getName()}));
            this.f9804k.show(getSupportFragmentManager(), "CircleFragment");
            this.f9804k.m10504a(new CircleProgressFragment.OnDismissListener() { // from class: com.jibo.ui.activity.LoopInviteDetailsActivity.3
                @Override // com.jibo.ui.fragment.dialog.CircleProgressFragment.OnDismissListener
                /* JADX INFO: renamed from: a */
                public void mo10227a(CircleProgressFragment.Status status) {
                    if (status == CircleProgressFragment.Status.Success) {
                        LoopInviteDetailsActivity.this.m10225s();
                    } else {
                        LoopInviteDetailsActivity.this.buttonAccept.setClickable(true);
                        LoopInviteDetailsActivity.this.buttonDecline.setClickable(true);
                    }
                }
            });
        }
        EntityData.m10089a(this).m10122b().declineInvitation(this.f9802i.getId(), new AsyncHandler<DeclineLoopInvitationRequest, Loop>() { // from class: com.jibo.ui.activity.LoopInviteDetailsActivity.4
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                LoopInviteDetailsActivity.this.f9804k.m10507b(LoopInviteDetailsActivity.this.getString(R.string.declining_loop_fail));
                LoopInviteDetailsActivity.this.m10188a(exc, "decline invitation");
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(DeclineLoopInvitationRequest declineLoopInvitationRequest, Loop loop) throws Throwable {
                LoopInviteDetailsActivity.this.setResult(0);
                JiboAnalytics.m9843b(LoopInviteDetailsActivity.this, loop.getRobot());
                EntityData.m10089a(LoopInviteDetailsActivity.this).m10123b(loop.getId());
                LoopInviteDetailsActivity.this.f9804k.m10505a(LoopInviteDetailsActivity.this.getString(R.string.declining_loop_success));
                LoopInviteDetailsActivity.this.f9804k = null;
            }
        });
    }

    /* JADX INFO: renamed from: r */
    private void m10224r() {
        this.buttonAccept.setClickable(true);
        this.buttonDecline.setClickable(true);
        this.f9802i = (this.f9805l == null || this.f9805l.isEmpty()) ? this.f9802i : this.f9805l.get(0);
        Account accountM10134i = EntityData.m10089a(this).m10134i();
        Member memberByIdOrEmail = LoopHelper.getMemberByIdOrEmail(this.f9802i, accountM10134i.getId());
        this.f9803j.clear();
        this.f9803j.add(new Items.SubheaderItem(R.string.header_loop_members));
        List<Member> listSortMembers = LoopHelper.sortMembers(this.f9802i, memberByIdOrEmail);
        listSortMembers.remove(memberByIdOrEmail);
        Iterator<Member> it = listSortMembers.iterator();
        while (it.hasNext()) {
            this.f9803j.add(new Items.MemberItem(this.f9802i, it.next()));
        }
        this.f9803j.add(new Items.FooterItem(getString(R.string.loop_invite_footer2)));
        this.f9801h = new LoopMembersListAdapter(this.f9803j, this.f9802i, accountM10134i);
        this.recyclerView.setAdapter(this.f9801h);
        if (this.f9806m) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.x_white);
        } else {
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setHomeAsUpIndicator(0);
        }
        getSupportActionBar().setTitle(getString(R.string.title_loop_invite_details, new Object[]{this.f9802i.getName()}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s */
    public void m10225s() {
        if (this.f9805l != null && this.f9805l.size() > 1) {
            this.f9805l.remove(0);
            m10224r();
        } else {
            if (this.f9807n) {
                TabbedActivity.m10284a(this, getIntent().getExtras().getBundle("ARG_EXTRAS"));
            }
            onBackPressed();
        }
    }

    /* JADX INFO: renamed from: t */
    private void m10226t() {
        ((NotificationManager) getSystemService("notification")).cancel(this.f9802i.getId(), 2);
    }
}
