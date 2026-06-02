package com.jibo.p019ui.fragment.jibos;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.auth.BasicAWSCredentials;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.p018db.DatabaseContract;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.LoopInviteDetailsActivity;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.activity.TabbedActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.account.AccountSettingsDetailsFragment;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.fragment.jibos.adapter.JibosListAdapter;
import com.jibo.p019ui.view.LoopSelectionListView;
import com.jibo.service.SyncHelper;
import com.jibo.utils.ImageUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JibosListFragment extends BaseFragment implements LoaderManager.LoaderCallbacks<Cursor>, SwipeRefreshLayout.OnRefreshListener, LoopSelectionListView.OnLoopSelectedListener {

    /* JADX INFO: renamed from: a */
    private static int f10599a = 1000;

    /* JADX INFO: renamed from: b */
    private static int f10600b = 1001;

    /* JADX INFO: renamed from: c */
    private JibosListAdapter f10601c;

    /* JADX INFO: renamed from: d */
    private JiboRobotPropertiesAsyncClient f10602d;

    /* JADX INFO: renamed from: e */
    private boolean f10603e;

    @BindView
    View emptyView;

    @BindView
    View fab;

    /* JADX INFO: renamed from: l */
    private Loop f10604l;

    @BindView
    RecyclerView list;

    /* JADX INFO: renamed from: m */
    private List<Loop> f10605m;

    @BindView
    SwipeRefreshLayout swipeRefreshLayout;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_loops_list, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.swipeRefreshLayout.setOnRefreshListener(this);
        this.swipeRefreshLayout.setColorSchemeResources(R.color.jibo_blue, R.color.accent_blue, R.color.accent_blue, R.color.accent_blue);
        this.f10601c = new JibosListAdapter(null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
        getLoaderManager().mo1683a(R.id.loader_loops, null, this);
        this.list.setHasFixedSize(true);
        this.list.setItemAnimator(new DefaultItemAnimator());
        this.list.setLayoutManager(linearLayoutManager);
        this.list.setAdapter(this.f10601c);
        if (getArguments() != null && getArguments().getString("ARG_MESSAGE") != null) {
            m10341c().postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.jibos.JibosListFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    DialogUtils.m10526d(JibosListFragment.this, 1, JibosListFragment.this.getString(R.string.msg_getting_invited_into_right_loop_title), JibosListFragment.this.getArguments().getString("ARG_MESSAGE"));
                    JibosListFragment.this.getArguments().remove("ARG_MESSAGE");
                }
            }, 100L);
        }
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        if (accountM10134i != null) {
            JiboRobotPropertiesAsyncClient jiboRobotPropertiesAsyncClient = new JiboRobotPropertiesAsyncClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
            this.f10602d = jiboRobotPropertiesAsyncClient;
            m10336a(jiboRobotPropertiesAsyncClient);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_settings, menu);
        ImageUtils.m11393a(getActivity(), menu);
        menu.findItem(R.id.action_settings).setVisible(true);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_settings) {
            return super.onOptionsItemSelected(menuItem);
        }
        m10809b();
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == f10599a && i2 == -1 && intent != null) {
            Bundle bundle = new Bundle();
            this.f10604l = (Loop) intent.getParcelableExtra(Loop.class.getSimpleName());
            int intExtra = intent.getIntExtra("ARG_TAB_SELECTED", 0);
            if (this.f10601c != null && this.f10601c.m10810a() + this.f10601c.m10814b() == 0) {
                if (this.f10604l != null) {
                    bundle.putString("ARG_ENTITY_SELECTED", this.f10604l.getId());
                }
                bundle.putInt("ARG_TAB_SELECTED", intExtra);
                getActivity().getIntent().putExtra("ARG_EXTRAS", bundle);
                return;
            }
            if (this.f10601c != null && this.f10601c.m10810a() + this.f10601c.m10814b() > 0 && intExtra == 2 && getParentFragment() != null) {
                this.f10604l = null;
                ((TabbedActivity) getActivity()).m10306u();
            }
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f10604l != null && m10342d() && this.f10601c != null && this.f10601c.m10810a() + this.f10601c.m10814b() > 0) {
            mo10808a(this.f10604l);
            this.f10604l = null;
        }
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    /* JADX INFO: renamed from: n_ */
    public void mo3115n_() {
        SyncHelper.m10178b(getActivity());
        getView().postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.jibos.JibosListFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (JibosListFragment.this.m10342d()) {
                    JibosListFragment.this.swipeRefreshLayout.setRefreshing(false);
                }
            }
        }, 1500L);
    }

    @Override // com.jibo.ui.view.LoopSelectionListView.OnLoopSelectedListener
    /* JADX INFO: renamed from: a */
    public void mo10808a(Loop loop) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), loop);
        if (LoopHelper.isMemberInvited(loop, EntityData.m10089a(getActivity()).m10134i().getId())) {
            m10806b(loop);
        } else {
            ((TabbedActivity) getActivity()).m10187a(JiboDetailsFragment.class, bundle);
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: a */
    public Loader<Cursor> mo1689a(int i, Bundle bundle) {
        switch (i) {
            case R.id.loader_loops /* 2131296709 */:
                return new CursorLoader(getActivity(), DatabaseContract.EntityEntry.m10079a(8), DatabaseContract.EntityEntry.f9694a, null, null, "name");
            default:
                return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c2  */
    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo1691a(android.support.v4.content.Loader<android.database.Cursor> r13, android.database.Cursor r14) {
        /*
            r12 = this;
            r11 = 8
            r2 = 1
            r1 = 0
            int r0 = r13.m1864n()
            r3 = 2131296709(0x7f0901c5, float:1.8211342E38)
            if (r0 != r3) goto L9d
            android.support.v4.app.FragmentActivity r0 = r12.getActivity()
            com.jibo.db.EntityData r5 = com.jibo.p018db.EntityData.m10089a(r0)
            if (r14 == 0) goto L2f
            boolean r0 = r14.isClosed()
            if (r0 != 0) goto L2f
            int r0 = r14.getCount()
            if (r0 == 0) goto L2f
            boolean r0 = r14.moveToFirst()
            if (r0 == 0) goto L2f
            com.jibo.aws.integration.aws.services.account.model.Account r0 = r5.m10134i()
            if (r0 != 0) goto L72
        L2f:
            r0 = r2
        L30:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r4 = 0
            if (r0 != 0) goto L7c
            com.jibo.aws.integration.aws.services.account.model.Account r3 = r5.m10134i()
            java.lang.String r7 = r3.getId()
        L40:
            boolean r3 = r14.isAfterLast()
            if (r3 != 0) goto L74
            com.jibo.aws.integration.aws.services.loop.model.Loop r3 = com.jibo.p018db.EntityData.m10088a(r14)
            boolean r8 = com.jibo.aws.integration.helpers.LoopHelper.isMemberDeclined(r3, r7)
            if (r8 != 0) goto Lc2
            r6.add(r3)
            android.os.Bundle r8 = r12.getArguments()
            if (r8 == 0) goto Lc2
            java.lang.String r8 = r3.getId()
            android.os.Bundle r9 = r12.getArguments()
            java.lang.String r10 = "ARG_ENTITY_SELECTED"
            java.lang.String r9 = r9.getString(r10)
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto Lc2
        L6d:
            r14.moveToNext()
            r4 = r3
            goto L40
        L72:
            r0 = r1
            goto L30
        L74:
            int r3 = r6.size()
            if (r3 != 0) goto L9e
            r3 = r2
        L7b:
            r0 = r0 | r3
        L7c:
            if (r0 == 0) goto La0
            android.view.View r0 = r12.emptyView
            r0.setVisibility(r1)
            android.support.v7.widget.RecyclerView r0 = r12.list
            r0.setVisibility(r11)
            android.view.View r0 = r12.fab
            r0.setVisibility(r11)
            r12.f10603e = r1
        L8f:
            android.support.v4.app.FragmentActivity r0 = r12.getActivity()
            com.jibo.ui.activity.TabbedActivity r0 = (com.jibo.p019ui.activity.TabbedActivity) r0
            r0.m10308w()
            if (r4 == 0) goto L9d
            r12.mo10808a(r4)
        L9d:
            return
        L9e:
            r3 = r1
            goto L7b
        La0:
            android.view.View r0 = r12.emptyView
            r0.setVisibility(r11)
            android.support.v7.widget.RecyclerView r0 = r12.list
            r0.setVisibility(r1)
            android.view.View r0 = r12.fab
            r0.setVisibility(r1)
            r12.f10603e = r2
            com.jibo.ui.fragment.jibos.adapter.JibosListAdapter r0 = r12.f10601c
            com.jibo.aws.integration.aws.services.account.model.Account r1 = r5.m10134i()
            r0.m10812a(r1, r6)
            com.jibo.ui.fragment.jibos.adapter.JibosListAdapter r0 = r12.f10601c
            r0.notifyDataSetChanged()
            r12.f10605m = r6
            goto L8f
        Lc2:
            r3 = r4
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p019ui.fragment.jibos.JibosListFragment.mo1691a(android.support.v4.content.Loader, android.database.Cursor):void");
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: a */
    public void mo1690a(Loader<Cursor> loader) {
        this.f10601c.m10812a(EntityData.m10089a(getActivity()).m10134i(), (List<Loop>) null);
        this.f10601c.notifyDataSetChanged();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    public String mo10353o() {
        return getString(R.string.title_jibos);
    }

    @OnClick
    public void onConnectWifi(View view) {
    }

    @OnClick
    public void onInviteInfo(View view) {
        DialogUtils.m10526d(this, 1, getString(R.string.msg_getting_invited_into_right_loop_title), String.format(getString(R.string.msg_getting_invited_into_right_loop_text), EntityData.m10089a(getActivity()).m10134i().getEmail()));
    }

    /* JADX INFO: renamed from: b */
    private void m10806b(Loop loop) {
        Intent intent = new Intent();
        intent.putExtra(" ARGS_LOOPS_LIST", m10807c(loop));
        intent.putExtra(" ARGS_HAS_ACCEPTED_LOOPS", true);
        intent.setClass(getContext(), LoopInviteDetailsActivity.class);
        startActivity(intent);
    }

    /* JADX INFO: renamed from: c */
    private ArrayList<Loop> m10807c(Loop loop) {
        ArrayList<Loop> arrayList = new ArrayList<>();
        String email = EntityData.m10089a(getContext()).m10134i().getEmail();
        arrayList.add(loop);
        for (Loop loop2 : this.f10605m) {
            if (!loop2.equals(loop) && LoopHelper.isMemberInvited(loop2, email)) {
                arrayList.add(loop2);
            }
        }
        return arrayList;
    }

    @OnClick
    public void setUpNewJibo(View view) {
        onConnectWifi(view);
    }

    /* JADX INFO: renamed from: b */
    public void m10809b() {
        new SingleFragmentActivity.Builder(getActivity(), AccountSettingsDetailsFragment.class.getName()).m10275a(f10600b);
    }
}
