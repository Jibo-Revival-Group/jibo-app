package com.jibo.p019ui.fragment.jibos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.gqa.model.Attribution;
import com.jibo.aws.integration.aws.services.gqa.model.AttributionListResponse;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.RemoveMemberRequest;
import com.jibo.aws.integration.aws.services.notification.JiboNotificationAsyncClient;
import com.jibo.aws.integration.aws.services.notification.model.GetStatusRequest;
import com.jibo.aws.integration.aws.services.notification.model.StatusContainer;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient;
import com.jibo.aws.integration.aws.services.skills.model.GetSettingsRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.p018db.DatabaseContract;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.activity.TabbedActivity;
import com.jibo.p019ui.activity.WifiActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.account.AccountSettingsFragment;
import com.jibo.p019ui.fragment.account.skills.SkillSettingsFragment;
import com.jibo.p019ui.fragment.dialog.CircleProgressFragment;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.fragment.dialog.HolidaysPopupFragment;
import com.jibo.p019ui.fragment.dialog.LoopInfoDialog;
import com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseRestoreDialog;
import com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseUtils;
import com.jibo.p019ui.fragment.invite.NameBirthdayGenderFragment;
import com.jibo.p019ui.fragment.jibos.adapter.LoopMembersListAdapter;
import com.jibo.p019ui.fragment.profile.ProfileFragment;
import com.jibo.p019ui.fragment.settings.RobotSettingsFragment;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.helpers.skills.DataItems;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import com.jibo.service.SyncHelper;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.SharedPreferencesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JiboDetailsFragment extends BaseFragment implements LoaderManager.LoaderCallbacks<Cursor>, SwipeRefreshLayout.OnRefreshListener, LoopPassphraseRestoreDialog.BackupKeyRestoredListener {

    /* JADX INFO: renamed from: b */
    CircleProgressFragment f10539b;

    @BindView
    View btnReconnectToJibo;

    /* JADX INFO: renamed from: e */
    private List<Attribution> f10542e;

    /* JADX INFO: renamed from: l */
    private LoopMembersListAdapter f10543l;

    @BindView
    RecyclerView list;

    @BindView
    View loopSuspendedView;

    /* JADX INFO: renamed from: n */
    private JiboNotificationAsyncClient f10545n;

    /* JADX INFO: renamed from: o */
    private JiboSkillsAsyncClient f10546o;

    /* JADX INFO: renamed from: s */
    private JiboRobotPropertiesAsyncClient f10550s;

    @BindView
    SwipeRefreshLayout swipeRefreshLayout;

    /* JADX INFO: renamed from: t */
    private Robot f10551t;

    @BindView
    TextView tutorialTitle;

    @BindView
    View tutorialTitleContainer;

    /* JADX INFO: renamed from: a */
    boolean f10538a = false;

    /* JADX INFO: renamed from: c */
    private List<Items.Item> f10540c = new ArrayList();

    /* JADX INFO: renamed from: d */
    private LoadAttributionsAsyncTask f10541d = new LoadAttributionsAsyncTask();

    /* JADX INFO: renamed from: m */
    private Member f10544m = null;

    /* JADX INFO: renamed from: p */
    private Member f10547p = null;

    /* JADX INFO: renamed from: q */
    private View.OnClickListener f10548q = new View.OnClickListener() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Items.MemberItem memberItem = (Items.MemberItem) view.getTag();
            if (memberItem.m11211b().getAccount() != null) {
                JiboDetailsFragment.this.m10759a(memberItem.m11211b());
            }
        }
    };

    /* JADX INFO: renamed from: r */
    private View.OnLongClickListener f10549r = new View.OnLongClickListener() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.2
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Items.MemberItem memberItem = (Items.MemberItem) view.getTag();
            if (memberItem.m11211b().getAccount() == null) {
                return false;
            }
            JiboDetailsFragment.this.f10547p = memberItem.m11211b();
            DialogUtils.m10514a(JiboDetailsFragment.this, 116, JiboDetailsFragment.this.getString(R.string.dialog_title_remove_from_loop, JiboDetailsFragment.this.f10547p.getAccount().getFirstName()), JiboDetailsFragment.this.getString(R.string.dialog_msg_remove_from_loop, JiboDetailsFragment.this.f10547p.getAccount().getFirstName(), JiboDetailsFragment.this.f10547p.getAccount().getFirstName()), JiboDetailsFragment.this.getString(R.string.remove));
            return true;
        }
    };

    /* JADX INFO: renamed from: u */
    private BroadcastReceiver f10552u = new BroadcastReceiver() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("LOOP_HOLIDAYS_ALARM_ACTION".equals(intent.getAction()) && JiboDetailsFragment.this.f9934k.getId().equals(intent.getStringExtra(Loop.class.getSimpleName()))) {
                HolidaysPopupFragment.m10554a(JiboDetailsFragment.this.getFragmentManager(), JiboDetailsFragment.this.f9934k);
            }
        }
    };

    /* JADX INFO: renamed from: v */
    private View.OnClickListener f10553v = new View.OnClickListener() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new LoopInfoDialog().show(JiboDetailsFragment.this.getFragmentManager(), LoopInfoDialog.class.getSimpleName());
        }
    };

    /* JADX INFO: renamed from: w */
    private LoopPassphraseUtils.KeyBackupCheckListener f10554w = new LoopPassphraseUtils.KeyBackupCheckListener() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.17
        @Override // com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseUtils.KeyBackupCheckListener
        /* JADX INFO: renamed from: a */
        public void mo10588a() {
            JiboDetailsFragment.this.mo10345g();
        }

        @Override // com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseUtils.KeyBackupCheckListener
        /* JADX INFO: renamed from: b */
        public void mo10589b() {
            JiboDetailsFragment.this.mo10345g();
            LoopPassphraseUtils.m10581a(JiboDetailsFragment.this, LoopPassphraseUtils.DialogType.ON_RECONNECT_TO_JIBO_NO_BACKUP);
        }
    };

    /* JADX INFO: renamed from: x */
    private LoopPassphraseUtils.KeyBackupCheckListener f10555x = new LoopPassphraseUtils.KeyBackupCheckListener() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.18
        @Override // com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseUtils.KeyBackupCheckListener
        /* JADX INFO: renamed from: a */
        public void mo10588a() {
            JiboDetailsFragment.this.mo10345g();
            LoopPassphraseUtils.m10582a(JiboDetailsFragment.this, LoopPassphraseUtils.DialogType.ON_RECONNECT_TO_JIBO, JiboDetailsFragment.this.f9934k);
        }

        @Override // com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseUtils.KeyBackupCheckListener
        /* JADX INFO: renamed from: b */
        public void mo10589b() {
            JiboDetailsFragment.this.mo10345g();
            WifiActivity.m10315a(JiboDetailsFragment.this.getActivity(), JiboDetailsFragment.this.f9934k);
        }
    };

    /* JADX INFO: renamed from: y */
    private View.OnClickListener f10556y = new View.OnClickListener() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.findViewById(R.id.firstCard).getVisibility() == 0) {
                JiboDetailsFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((Items.AttributionItem) view.getTag()).m11196a().getUrl())));
            }
        }
    };

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (bundle != null) {
            this.f10538a = bundle.getBoolean("ARGS_IS_IN_TUTORIAL_MODE");
        } else if (getArguments() != null) {
            this.f10538a = getArguments().getBoolean("ARGS_IS_IN_TUTORIAL_MODE");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_loop_details, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        super.onViewCreated(view, bundle);
        this.f9934k = SharedPreferencesUtil.m11443f(getActivity());
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        if (accountM10134i != null) {
            JiboNotificationAsyncClient jiboNotificationAsyncClient = new JiboNotificationAsyncClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
            this.f10545n = jiboNotificationAsyncClient;
            m10336a(jiboNotificationAsyncClient);
            JiboSkillsAsyncClient jiboSkillsAsyncClient = new JiboSkillsAsyncClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
            this.f10546o = jiboSkillsAsyncClient;
            m10336a(jiboSkillsAsyncClient);
        }
        this.f10543l = new LoopMembersListAdapter(this.f10540c, this.f9934k, accountM10134i);
        this.f10543l.m10819a(this.f10549r);
        this.list.setHasFixedSize(true);
        this.list.setItemAnimator(new DefaultItemAnimator());
        this.list.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.list.addItemDecoration(new LoopMembersListAdapter.SpacesItemDecoration(getActivity(), -1, R.dimen.activity_double_vertical_margin, R.dimen.divider_thickness));
        this.list.setAdapter(this.f10543l);
        this.swipeRefreshLayout.setOnRefreshListener(this);
        this.swipeRefreshLayout.setColorSchemeResources(R.color.jibo_blue, R.color.accent_blue, R.color.accent_blue, R.color.accent_blue);
        getLoaderManager().mo1683a(R.id.loader_loops, null, this);
        if (getArguments() != null && getArguments().getBundle("ARG_EXTRAS") != null) {
            final Bundle bundle3 = getArguments().getBundle("ARG_EXTRAS");
            if (bundle3.getString("ARG_MESSAGE") != null) {
                m10341c().postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DialogUtils.m10526d(JiboDetailsFragment.this, 103, bundle3.getString("ARG_TITLE"), bundle3.getString("ARG_MESSAGE"));
                        bundle3.remove("ARG_MESSAGE");
                        bundle3.remove("ARG_TITLE");
                    }
                }, 200L);
            }
        }
        if (accountM10134i != null && LoopHelper.isOwner(this.f9934k, accountM10134i.getId())) {
            this.f10550s = EntityData.m10089a(getActivity()).m10132g();
        }
        if (getArguments().containsKey("ARG_EXTRAS") && (bundle2 = getArguments().getBundle("ARG_EXTRAS")) != null && bundle2.containsKey("ARG_SETTINGS") && LoopHelper.isOwner(this.f9934k, accountM10134i.getId())) {
            view.postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    new SingleFragmentActivity.Builder(JiboDetailsFragment.this.getActivity(), RobotSettingsFragment.class.getName()).m10272a(Loop.class.getSimpleName(), (Parcelable) JiboDetailsFragment.this.f9934k).m10275a(1003);
                }
            }, 750L);
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        this.f10538a = bundle.getBoolean("ARGS_IS_IN_TUTORIAL_MODE");
    }

    /* JADX INFO: renamed from: b */
    private void m10767b() {
        this.tutorialTitleContainer.setVisibility(0);
        this.tutorialTitle.setText(this.f9934k != null ? this.f9934k.getName() : "");
    }

    /* JADX INFO: renamed from: a */
    private void m10763a(Collection<Items.Item> collection) {
        collection.add(new Items.SubheaderItem(R.string.header_your_robot));
        if (LoopHelper.isOwner(this.f9934k, EntityData.m10089a(getActivity()).m10134i().getId())) {
            collection.add(new Items.JiboSettingsItem(new View.OnClickListener() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    new SingleFragmentActivity.Builder(JiboDetailsFragment.this.getActivity(), RobotSettingsFragment.class.getName()).m10272a(Loop.class.getSimpleName(), (Parcelable) JiboDetailsFragment.this.f9934k).m10275a(1003);
                }
            }, this.f10551t));
        } else {
            collection.add(new Items.WifiSettingsItem(new View.OnClickListener() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WifiActivity.m10315a(JiboDetailsFragment.this.getActivity(), JiboDetailsFragment.this.f9934k);
                }
            }));
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("LOOP_HOLIDAYS_ALARM_ACTION");
        LocalBroadcastManager.m1878a(getActivity()).m1882a(this.f10552u, intentFilter);
        if (this.f10544m != null) {
            DialogUtils.m10521b(this, 103, getString(R.string.dialog_title_parent_invited, this.f10544m.getAccount().getFirstName()), getString(R.string.dialog_msg_parent_invited, this.f10544m.getAccount().getFirstName(), this.f10544m.getAccount().getFirstName()), getString(R.string.okay_gotit));
            this.f10544m = null;
        } else {
            m10790r();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.m1878a(getActivity()).m1881a(this.f10552u);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 1007 || i == 1005) {
                mo3115n_();
                if (i == 1005 && intent != null && intent.getExtras() != null && intent.getExtras().containsKey(Member.class.getSimpleName())) {
                    this.f10544m = (Member) intent.getExtras().getParcelable(Member.class.getSimpleName());
                    return;
                }
                return;
            }
            if (i == 1015) {
                getActivity().getContentResolver().notifyChange(DatabaseContract.EntityEntry.m10079a(8), null);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_settings, menu);
        ImageUtils.m11393a(getActivity(), menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_settings) {
            return super.onOptionsItemSelected(menuItem);
        }
        m10788q();
        return true;
    }

    /* JADX INFO: renamed from: q */
    private void m10788q() {
        SkillsJsonParser.getInstance().clearSkills();
        SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(getActivity(), AccountSettingsFragment.class.getName());
        builder.m10273a("ARG_LOOPS", ((TabbedActivity) getActivity()).m10309x());
        builder.m10275a(1001);
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    /* JADX INFO: renamed from: n_ */
    public void mo3115n_() {
        if (this.f9934k == null) {
            SyncHelper.m10178b(getActivity());
        } else {
            SyncHelper.m10176a(getActivity(), this.f9934k.getId());
        }
        getView().postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.8
            @Override // java.lang.Runnable
            public void run() {
                if (JiboDetailsFragment.this.m10342d()) {
                    JiboDetailsFragment.this.swipeRefreshLayout.setRefreshing(false);
                }
            }
        }, 1500L);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: a */
    public Loader<Cursor> mo1689a(int i, Bundle bundle) {
        switch (i) {
            case R.id.loader_accounts /* 2131296704 */:
                StringBuilder sbAppend = new StringBuilder("_id").append(" IN (");
                Loop loop = this.f9934k;
                String[] strArr = new String[1];
                strArr[0] = this.f9934k.getRobot() != null ? this.f9934k.getRobot() : "";
                List<String> accountIds = LoopHelper.getAccountIds(loop, null, strArr);
                if (accountIds.size() > 0) {
                    sbAppend.append("'").append(TextUtils.join("','", accountIds)).append("')");
                } else {
                    sbAppend.append("'')");
                }
                return new CursorLoader(getActivity(), DatabaseContract.EntityEntry.m10079a(2), DatabaseContract.EntityEntry.f9694a, sbAppend.toString(), null, "_id");
            case R.id.loader_loops /* 2131296709 */:
                return new CursorLoader(getActivity(), DatabaseContract.EntityEntry.m10079a(8), DatabaseContract.EntityEntry.f9694a, null, null, "_id");
            default:
                return null;
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1691a(Loader<Cursor> loader, Cursor cursor) {
        if (loader.m1864n() == R.id.loader_loops && m10342d()) {
            this.f9934k = SharedPreferencesUtil.m11443f(getActivity());
            if (m10342d() && ((BaseActivity) getActivity()).getSupportActionBar() != null) {
                ((BaseActivity) getActivity()).getSupportActionBar().setTitle(mo10353o());
            }
            if (this.f9934k != null) {
                if (getLoaderManager().mo1687b(R.id.loader_accounts) != null) {
                    getLoaderManager().mo1688b(R.id.loader_accounts, null, this);
                } else {
                    getLoaderManager().mo1683a(R.id.loader_accounts, null, this);
                }
                if (this.f9934k.isSuspended().booleanValue()) {
                    m10769b(LoopHelper.isOwner(this.f9934k, EntityData.m10089a(getContext()).m10134i().getId()));
                    return;
                }
                m10794v();
                this.f10543l.m10820a(this.f9934k);
                m10795w();
                m10754A();
                if (!m10790r() && getFragmentManager().mo1470a(HolidaysPopupFragment.class.getSimpleName()) == null) {
                    ArrayList arrayList = new ArrayList();
                    Collections.addAll(arrayList, SharedPreferencesUtil.m11455o(getActivity()));
                    if (arrayList.indexOf(this.f9934k.getId()) > -1) {
                        m10341c().postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.9
                            @Override // java.lang.Runnable
                            public void run() {
                                HolidaysPopupFragment.m10554a(JiboDetailsFragment.this.getFragmentManager(), JiboDetailsFragment.this.f9934k);
                            }
                        }, 500L);
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: a */
    public void mo1690a(Loader<Cursor> loader) {
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    public String mo10353o() {
        return this.f9934k != null ? this.f9934k.getName() : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [int[], java.io.Serializable] */
    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        super.mo10186a(i, i2, obj);
        if (i == 120 && i2 == -1 && obj != null) {
            SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(this, NameBirthdayGenderFragment.class.getName());
            builder.m10274a("ARG_IS_CHILD", true);
            builder.m10272a(Loop.class.getSimpleName(), (Parcelable) this.f9934k);
            builder.m10272a(Member.class.getSimpleName(), (Parcelable) obj);
            builder.m10275a(1005);
            return;
        }
        if (i == 116) {
            m10762a(this.f9934k.getId(), this.f10547p.getId(), this.f10547p.getAccount().getFirstName());
            return;
        }
        if (i == 124) {
            DataItems.DataItem dataItem = SkillsJsonParser.getInstance().getViews(null).get(0);
            if (!(dataItem instanceof DataItems.GroupDataItem) || (((DataItems.GroupDataItem) dataItem).getChildViews() != null && !((DataItems.GroupDataItem) dataItem).getChildViews().isEmpty())) {
                SkillsJsonParser.getInstance().selectSkill(0);
                new SingleFragmentActivity.Builder(getContext(), SkillSettingsFragment.class.getName()).m10273a("PARAM_PATH", (Serializable) new int[]{0}).m10273a("PARAM_TITLE", dataItem.getTitle()).m10275a(1001);
            }
        }
    }

    @OnClick
    public void reconnectToJiboClick() {
        if (!m10793u()) {
            m10344f();
            LoopPassphraseUtils.m10584a(this.f9934k.getId(), this, this.f10555x);
        } else {
            WifiActivity.m10315a(getActivity(), this.f9934k);
        }
    }

    @OnClick
    public void onCustomerCareClick(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.support_restore_suspended_loop_url))));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        r0 = true;
        com.jibo.utils.SharedPreferencesUtil.m11435b(getActivity(), r5);
        m10341c().postDelayed(new com.jibo.p019ui.fragment.jibos.JiboDetailsFragment.RunnableC118910(r9), 500);
     */
    /* JADX INFO: renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized boolean m10790r() {
        /*
            r9 = this;
            r0 = 0
            monitor-enter(r9)
            com.jibo.aws.integration.aws.services.loop.model.Loop r2 = r9.f9934k     // Catch: java.lang.Throwable -> L5d
            if (r2 == 0) goto L58
            android.support.v4.app.FragmentActivity r1 = r9.getActivity()     // Catch: java.lang.Throwable -> L5d
            com.jibo.db.EntityData r1 = com.jibo.p018db.EntityData.m10089a(r1)     // Catch: java.lang.Throwable -> L5d
            com.jibo.aws.integration.aws.services.account.model.Account r1 = r1.m10134i()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r1 = r1.getId()     // Catch: java.lang.Throwable -> L5d
            boolean r1 = com.jibo.aws.integration.helpers.LoopHelper.isOwner(r2, r1)     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L58
            android.support.v4.app.FragmentActivity r1 = r9.getActivity()     // Catch: java.lang.Throwable -> L5d
            java.lang.String[] r3 = com.jibo.utils.SharedPreferencesUtil.m11448h(r1)     // Catch: java.lang.Throwable -> L5d
            int r4 = r3.length     // Catch: java.lang.Throwable -> L5d
            r1 = r0
        L26:
            if (r1 >= r4) goto L58
            r5 = r3[r1]     // Catch: java.lang.Throwable -> L5d
            com.jibo.aws.integration.aws.services.loop.model.Member r6 = com.jibo.aws.integration.helpers.LoopHelper.getMemberByIdOrEmail(r2, r5)     // Catch: java.lang.Throwable -> L5d
            if (r6 == 0) goto L5a
            com.jibo.aws.integration.aws.services.loop.model.Member$InvitationStatus r7 = r6.getStatus()     // Catch: java.lang.Throwable -> L5d
            com.jibo.aws.integration.aws.services.loop.model.Member$InvitationStatus r8 = com.jibo.aws.integration.aws.services.loop.model.Member.InvitationStatus.accepted     // Catch: java.lang.Throwable -> L5d
            if (r7 != r8) goto L5a
            android.support.v4.app.FragmentManager r7 = r9.getFragmentManager()     // Catch: java.lang.Throwable -> L5d
            boolean r7 = com.jibo.p019ui.fragment.dialog.DialogUtils.m10519a(r7)     // Catch: java.lang.Throwable -> L5d
            if (r7 != 0) goto L5a
            r0 = 1
            android.support.v4.app.FragmentActivity r1 = r9.getActivity()     // Catch: java.lang.Throwable -> L5d
            com.jibo.utils.SharedPreferencesUtil.m11435b(r1, r5)     // Catch: java.lang.Throwable -> L5d
            android.os.Handler r1 = r9.m10341c()     // Catch: java.lang.Throwable -> L5d
            com.jibo.ui.fragment.jibos.JiboDetailsFragment$10 r2 = new com.jibo.ui.fragment.jibos.JiboDetailsFragment$10     // Catch: java.lang.Throwable -> L5d
            r2.<init>()     // Catch: java.lang.Throwable -> L5d
            r4 = 500(0x1f4, double:2.47E-321)
            r1.postDelayed(r2, r4)     // Catch: java.lang.Throwable -> L5d
        L58:
            monitor-exit(r9)
            return r0
        L5a:
            int r1 = r1 + 1
            goto L26
        L5d:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p019ui.fragment.jibos.JiboDetailsFragment.m10790r():boolean");
    }

    /* JADX INFO: renamed from: s */
    private void m10791s() {
        try {
            if (this.f9934k != null && this.f10545n != null) {
                m10344f();
                this.f10545n.getStatus(this.f9934k.getRobot(), new C119011());
            } else if (this.f9934k != null) {
                EntityData.m10089a(getActivity()).m10132g().getRobot(this.f9934k.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.12
                    @Override // com.amazonaws.handlers.AsyncHandler
                    public void onError(Exception exc) {
                        JiboDetailsFragment.this.m10338a((Throwable) exc, "get robot", false);
                    }

                    @Override // com.amazonaws.handlers.AsyncHandler
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(GetRobotRequest getRobotRequest, Robot robot) {
                        JiboDetailsFragment.this.f10551t = robot;
                        JiboDetailsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                JiboDetailsFragment.this.mo10345g();
                                JiboDetailsFragment.this.m10792t();
                            }
                        });
                    }
                });
            }
        } catch (Exception e) {
            mo10345g();
        }
    }

    /* JADX INFO: renamed from: com.jibo.ui.fragment.jibos.JiboDetailsFragment$11 */
    class C119011 implements AsyncHandler<GetStatusRequest, StatusContainer> {
        C119011() {
        }

        @Override // com.amazonaws.handlers.AsyncHandler
        public void onError(Exception exc) {
            JiboDetailsFragment.this.m10338a((Throwable) exc, "notification get status", false);
            if (!ErrorHelper.m11385b((AmazonServiceException) exc) && !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                JiboDetailsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!JiboDetailsFragment.this.f9934k.isSuspended().booleanValue() && JiboDetailsFragment.this.f10540c.get(0) != null && (JiboDetailsFragment.this.f10540c.get(0) instanceof Items.WifiSettingsItem)) {
                            ((Items.WifiSettingsItem) JiboDetailsFragment.this.f10540c.get(0)).m11223a((Robot) null);
                            ((Items.WifiSettingsItem) JiboDetailsFragment.this.f10540c.get(0)).m11222a((StatusContainer) null);
                            JiboDetailsFragment.this.f10543l.notifyItemChanged(0);
                        }
                    }
                });
            }
        }

        @Override // com.amazonaws.handlers.AsyncHandler
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(GetStatusRequest getStatusRequest, final StatusContainer statusContainer) {
            EntityData.m10089a(JiboDetailsFragment.this.getActivity()).m10132g().getRobot(JiboDetailsFragment.this.f9934k.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.11.2
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    JiboDetailsFragment.this.m10338a((Throwable) exc, "get robot", false);
                    if (!ErrorHelper.m11385b((AmazonServiceException) exc) && !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                        JiboDetailsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.11.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                for (Items.Item item : JiboDetailsFragment.this.f10540c) {
                                    if (item instanceof Items.WifiSettingsItem) {
                                        ((Items.WifiSettingsItem) item).m11223a((Robot) null);
                                        ((Items.WifiSettingsItem) item).m11222a((StatusContainer) null);
                                        JiboDetailsFragment.this.f10543l.notifyItemChanged(JiboDetailsFragment.this.f10540c.indexOf(item));
                                        return;
                                    }
                                }
                            }
                        });
                    }
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(GetRobotRequest getRobotRequest, final Robot robot) {
                    JiboDetailsFragment.this.f10551t = robot;
                    JiboDetailsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.11.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            JiboDetailsFragment.this.mo10345g();
                            for (Items.Item item : JiboDetailsFragment.this.f10540c) {
                                if (item instanceof Items.WifiSettingsItem) {
                                    ((Items.WifiSettingsItem) item).m11223a(robot);
                                    ((Items.WifiSettingsItem) item).m11222a(statusContainer);
                                    JiboDetailsFragment.this.f10543l.notifyItemChanged(JiboDetailsFragment.this.f10540c.indexOf(item));
                                    return;
                                } else if (item instanceof Items.JiboSettingsItem) {
                                    JiboDetailsFragment.this.m10792t();
                                    return;
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: t */
    public void m10792t() {
        Iterator<Items.Item> it = this.f10540c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Items.Item next = it.next();
            if (next instanceof Items.JiboSettingsItem) {
                ((Items.JiboSettingsItem) next).m11209a(this.f10551t);
                break;
            }
        }
        this.f10543l.notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: b */
    private void m10769b(boolean z) {
        this.loopSuspendedView.setVisibility(0);
        this.btnReconnectToJibo.setVisibility(z ? 0 : 8);
        this.list.setVisibility(8);
        if (z && m10793u()) {
            m10344f();
            LoopPassphraseUtils.m10584a(this.f9934k.getId(), this, this.f10554w);
        }
    }

    /* JADX INFO: renamed from: u */
    private boolean m10793u() {
        KeyManager.SymmetricKeyHolder symmetricKeyHolderObtainKeyHolder;
        try {
            symmetricKeyHolderObtainKeyHolder = KeyManager.getInstance(getContext(), EntityData.m10089a(getActivity()).m10134i().getId()).obtainKeyHolder(getContext(), this.f9934k.getId());
        } catch (Exception e) {
            symmetricKeyHolderObtainKeyHolder = null;
        }
        return symmetricKeyHolderObtainKeyHolder != null;
    }

    /* JADX INFO: renamed from: v */
    private void m10794v() {
        this.loopSuspendedView.setVisibility(8);
        this.list.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10759a(Member member) {
        SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(this, ProfileFragment.class.getName());
        builder.m10272a(Member.class.getSimpleName(), (Parcelable) member).m10272a(Loop.class.getSimpleName(), (Parcelable) this.f9934k).m10273a("ARG_LOOPS", ((TabbedActivity) getActivity()).m10309x());
        builder.m10275a(1007);
    }

    /* JADX INFO: renamed from: w */
    private void m10795w() {
        String string;
        if (this.f9934k != null) {
            try {
                Member owner = LoopHelper.getOwner(this.f9934k);
                Member memberForAccount = LoopHelper.getMemberForAccount(this.f9934k, EntityData.m10089a(getActivity()).m10134i());
                boolean zIsOwner = LoopHelper.isOwner(this.f9934k, memberForAccount.getAccountId());
                List<Member> listSortMembers = LoopHelper.sortMembers(this.f9934k, memberForAccount);
                int unenrolledMembersCount = LoopHelper.getUnenrolledMembersCount(this.f9934k);
                Member firstUnenrolledMember = LoopHelper.getFirstUnenrolledMember(this.f9934k);
                ArrayList arrayList = new ArrayList();
                Iterator<Member> it = listSortMembers.iterator();
                while (it.hasNext()) {
                    arrayList.add(new Items.MemberItem(this.f10548q, this.f9934k, it.next()));
                }
                if (m10342d()) {
                    ArrayList arrayList2 = new ArrayList();
                    int activeMembersCount = LoopHelper.getActiveMembersCount(this.f9934k);
                    if (zIsOwner) {
                        if (unenrolledMembersCount > 0) {
                            if (firstUnenrolledMember == null) {
                                owner.getAccount().getFirstName();
                            } else {
                                firstUnenrolledMember.getAccount().getFirstName();
                            }
                        }
                        if (activeMembersCount >= 16) {
                            string = getString(R.string.jibo_details_footer_no_place);
                        } else {
                            arrayList.add(new Items.SimpleItem(Items.ItemType.invite, new View.OnClickListener() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.13
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(JiboDetailsFragment.this, NameBirthdayGenderFragment.class.getName());
                                    builder.m10272a(Loop.class.getSimpleName(), (Parcelable) JiboDetailsFragment.this.f9934k);
                                    builder.m10275a(1005);
                                }
                            }));
                            string = String.format(getString(R.string.jibo_details_footer_more_place), String.valueOf(16 - activeMembersCount));
                        }
                        new SpannableStringBuilder(string).setSpan(new WhyTextClickableSpan(getActivity().getApplicationContext(), new View.OnClickListener() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                JiboDetailsFragment.this.m10796x();
                            }
                        }), string.length() - 4, string.length(), 18);
                    } else if (!memberForAccount.isEnrolled()) {
                    }
                    if (this.f10538a) {
                        m10767b();
                    }
                    if (m10342d()) {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(new Items.FooterItem((CharSequence) it2.next()));
                        }
                        this.f10540c.clear();
                        m10763a(this.f10540c);
                        this.f10540c.add(new Items.SubheaderItem(R.string.header_loop_members));
                        this.f10540c.addAll(arrayList);
                        this.f10543l.notifyDataSetChanged();
                        m10791s();
                        m10798z();
                    }
                }
            } catch (Exception e) {
                LogUtils.m11408a(f9929f, "Exception: ", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: x */
    public void m10796x() {
        DialogUtils.m10526d(this, 110, getString(R.string.dialog_why_loop_is_limited_title), getString(R.string.dialog_why_loop_is_limited_description));
    }

    /* JADX INFO: renamed from: a */
    private void m10762a(String str, String str2, String str3) {
        this.f10539b = new CircleProgressFragment();
        this.f10539b.m10509c(getString(R.string.removing_member, str3));
        this.f10539b.show(getActivity().getSupportFragmentManager(), CircleProgressFragment.class.getSimpleName());
        EntityData.m10089a(getActivity()).m10122b().removeMember(str, str2, new AsyncHandler<RemoveMemberRequest, Loop>() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.15
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(final Exception exc) {
                if (!JiboDetailsFragment.this.m10342d()) {
                    JiboDetailsFragment.this.f10539b.m10507b(JiboDetailsFragment.this.getString(R.string.remove_failure));
                } else if (!ErrorHelper.m11385b((AmazonServiceException) exc) && !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                    JiboDetailsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            JiboDetailsFragment.this.f10539b.m10507b(ErrorHelper.m11382a(JiboDetailsFragment.this.getActivity().getApplicationContext(), exc));
                        }
                    });
                }
                JiboDetailsFragment.this.m10338a((Throwable) exc, "remove member", false);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(RemoveMemberRequest removeMemberRequest, Loop loop) throws Throwable {
                EntityData.m10089a(JiboDetailsFragment.this.getActivity()).m10118a(loop, true);
                JiboDetailsFragment.this.f10539b.m10505a(JiboDetailsFragment.this.f10539b.getString(R.string.remove_success));
            }
        });
    }

    private static class WhyTextClickableSpan extends ClickableSpan {

        /* JADX INFO: renamed from: a */
        Context f10590a;

        /* JADX INFO: renamed from: b */
        private View.OnClickListener f10591b;

        public WhyTextClickableSpan(Context context, View.OnClickListener onClickListener) {
            this.f10590a = context;
            this.f10591b = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ImageUtils.m11399b(this.f10590a, R.color.jibo_blue));
            textPaint.setFakeBoldText(true);
            textPaint.setTextSize(this.f10590a.getResources().getDimension(R.dimen.text_size_12sp));
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.f10591b != null) {
                this.f10591b.onClick(view);
            }
        }
    }

    @Override // com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseRestoreDialog.BackupKeyRestoredListener
    /* JADX INFO: renamed from: a */
    public void mo10576a(Loop loop) {
        WifiActivity.m10315a(getActivity(), this.f9934k);
    }

    /* JADX INFO: renamed from: y */
    private long m10797y() {
        return 0L;
    }

    /* JADX INFO: renamed from: z */
    private void m10798z() {
        if (this.f10541d != null) {
            this.f10541d.cancel(true);
        }
        this.f10541d = new LoadAttributionsAsyncTask();
        this.f10541d.execute(Long.valueOf(m10797y()));
    }

    private class LoadAttributionsAsyncTask extends AsyncTask<Long, Void, AttributionListResponse> {

        /* JADX INFO: renamed from: b */
        private long f10589b;

        private LoadAttributionsAsyncTask() {
            this.f10589b = 0L;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AttributionListResponse doInBackground(Long... lArr) {
            this.f10589b = lArr[0].longValue();
            try {
                return EntityData.m10089a(JiboDetailsFragment.this.getContext()).m10124c().listAttributions(JiboDetailsFragment.this.f9934k.getRobotFriendlyId(), this.f10589b);
            } catch (Exception e) {
                Crashlytics.m5597a((Throwable) e);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(AttributionListResponse attributionListResponse) {
            super.onPostExecute(attributionListResponse);
            if (!isCancelled() && JiboDetailsFragment.this.m10342d()) {
                if (JiboDetailsFragment.this.f10542e != null) {
                    JiboDetailsFragment.this.f10542e.clear();
                }
                if (attributionListResponse != null) {
                    if (this.f10589b != 0) {
                        JiboDetailsFragment.this.f10542e.addAll(attributionListResponse.getData());
                    } else {
                        JiboDetailsFragment.this.f10542e = attributionListResponse.getData();
                    }
                }
                List listM10758a = JiboDetailsFragment.this.m10758a((List<Attribution>) JiboDetailsFragment.this.f10542e);
                if (JiboDetailsFragment.this.f10543l != null && !listM10758a.isEmpty()) {
                    JiboDetailsFragment.this.f10540c.add(new Items.SubheaderItem(R.string.text_search_recap));
                    JiboDetailsFragment.this.f10540c.addAll(listM10758a);
                    JiboDetailsFragment.this.f10543l.notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public List<Items.Item> m10758a(List<Attribution> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Date date = null;
            for (Attribution attribution : list) {
                if (date == null) {
                    date = new Date(attribution.getTimestamp());
                    arrayList.add(new Items.DateItem(DateTimeUtils.getBirthdayString(attribution.getTimestamp(), DateTimeUtils.FULL_DATE_FORMAT)));
                } else {
                    Date date2 = new Date(attribution.getTimestamp());
                    if (date2.getDate() != date.getDate() || date2.getMonth() != date.getMonth() || date2.getYear() != date.getYear()) {
                        arrayList.add(new Items.DateItem(DateTimeUtils.getBirthdayString(attribution.getTimestamp(), DateTimeUtils.FULL_DATE_FORMAT)));
                        date = date2;
                    }
                }
                arrayList.add(new Items.AttributionItem(attribution, this.f10556y));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: A */
    private void m10754A() {
        if (!SharedPreferencesUtil.m11457q(getActivity()) && this.f10546o != null && this.f9934k != null && this.f10546o != null && this.f9934k != null && !this.f10538a) {
            m10344f();
            this.f10546o.getSkillsJson(this.f9934k.getId(), new AsyncHandler<GetSettingsRequest, String>() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment.20
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    JiboDetailsFragment.this.m10338a((Throwable) exc, "skills get skills json", false);
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(GetSettingsRequest getSettingsRequest, String str) {
                    SkillsJsonParser.getInstance().clearSkills();
                    SkillsJsonParser.getInstance().parseSkills(str);
                    boolean z = !SkillsJsonParser.getInstance().isConfigured();
                    JiboDetailsFragment.this.mo10345g();
                    if (z) {
                        SharedPreferencesUtil.m11436b((Context) JiboDetailsFragment.this.getActivity(), true);
                        DialogUtils.m10514a(JiboDetailsFragment.this, 124, JiboDetailsFragment.this.getString(R.string.personal_report_dialog_title), JiboDetailsFragment.this.getString(R.string.personal_report_dialog_body), JiboDetailsFragment.this.getString(R.string.personal_report_dialog_button_yes));
                    }
                }
            });
        }
    }
}
