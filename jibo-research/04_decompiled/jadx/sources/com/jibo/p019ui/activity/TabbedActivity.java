package com.jibo.p019ui.activity;

import android.animation.Animator;
import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.handlers.AsyncHandler;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.JiboAnalytics;
import com.jibo.JiboSupport;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.p018db.DatabaseContract;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.fragment.AvatarBaseFragment;
import com.jibo.p019ui.fragment.home.MediaFragment;
import com.jibo.p019ui.fragment.jibos.JiboDetailsFragment;
import com.jibo.p019ui.fragment.jibos.NoLoopsFragment;
import com.jibo.p019ui.fragment.jibos.adapter.JibosListAdapter;
import com.jibo.p019ui.fragment.settings.AvatarSelectionFragment;
import com.jibo.p019ui.fragment.tips.TipsListFragment;
import com.jibo.p019ui.view.BottomPanelButton;
import com.jibo.service.DeviceRegistrationService;
import com.jibo.service.SyncHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.SharedPreferencesUtil;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TabbedActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<Cursor>, BaseActivity.OnDoubleBackButtonListener {

    /* JADX INFO: renamed from: h */
    private static final boolean[] f9868h = {true, true, true, true};

    /* JADX INFO: renamed from: i */
    private static final boolean[] f9869i = {true, true, true, true};

    /* JADX INFO: renamed from: l */
    private static boolean[] f9870l = f9869i;

    /* JADX INFO: renamed from: m */
    private static boolean[] f9871m = {true, false, true, true};

    /* JADX INFO: renamed from: n */
    private static String[] f9872n = {JiboDetailsFragment.class.getName(), MediaFragment.class.getName(), TipsListFragment.class.getName(), TipsListFragment.class.getName()};

    /* JADX INFO: renamed from: o */
    private static String[] f9873o = {NoLoopsFragment.class.getName(), MediaFragment.class.getName(), TipsListFragment.class.getName()};

    /* JADX INFO: renamed from: j */
    private ArrayList<Loop> f9874j;

    @BindView
    RecyclerView jiboList;

    @BindView
    View jiboListContainer;

    /* JADX INFO: renamed from: k */
    private CountDownTimer f9875k;

    @BindView
    View mSelectorDimmer;

    /* JADX INFO: renamed from: r */
    private Fragment f9878r;

    @BindView
    LinearLayout tabs;

    /* JADX INFO: renamed from: u */
    private JibosListAdapter f9881u;

    /* JADX INFO: renamed from: v */
    private ActionMode f9882v;

    /* JADX INFO: renamed from: w */
    private boolean f9883w;

    /* JADX INFO: renamed from: p */
    private int f9876p = -1;

    /* JADX INFO: renamed from: q */
    private TabsState f9877q = null;

    /* JADX INFO: renamed from: s */
    private String f9879s = null;

    /* JADX INFO: renamed from: t */
    private Loop f9880t = null;

    /* JADX INFO: renamed from: x */
    private View.OnClickListener f9884x = new View.OnClickListener() { // from class: com.jibo.ui.activity.TabbedActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TabbedActivity.this.m10277B();
        }
    };

    /* JADX INFO: renamed from: y */
    private View.OnClickListener f9885y = new View.OnClickListener() { // from class: com.jibo.ui.activity.TabbedActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TabbedActivity.this.m10296d((Loop) view.getTag());
        }
    };

    /* JADX INFO: renamed from: z */
    private View.OnClickListener f9886z = new View.OnClickListener() { // from class: com.jibo.ui.activity.TabbedActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TabbedActivity.this.m10283a(((Integer) view.getTag()).intValue(), false);
        }
    };

    private enum TabsState {
        initial,
        complete
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.TabbedActivity");
        super.onStart();
    }

    /* JADX INFO: renamed from: a */
    public static void m10284a(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, (Class<?>) TabbedActivity.class);
        intent.setFlags(335577088);
        intent.putExtra("ARG_EXTRAS", bundle);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Bundle extras;
        Bundle bundle2;
        AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.TabbedActivity");
        getIntent().putExtra(BaseActivity.f9760b, R.layout.activity_tabs);
        super.onCreate(bundle);
        this.f9763e.setContentInsetsAbsolute(getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin), getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setIcon((Drawable) null);
        }
        if (getIntent() != null && getIntent().getExtras() != null && (extras = getIntent().getExtras()) != null && extras.containsKey("ARG_EXTRAS") && (bundle2 = extras.getBundle("ARG_EXTRAS")) != null) {
            if (bundle2.containsKey(AvatarBaseFragment.f9914a)) {
                this.f9883w = bundle2.getBoolean(AvatarBaseFragment.f9914a, false);
                extras.remove("ARG_EXTRAS");
            }
            if (bundle2.containsKey("ARG_FROM_NOTIFICATION")) {
                JiboAnalytics.m9846c(this, JiboAnalytics.f9201aB);
            }
            if (bundle2.containsKey("ARG_LOOP_ID")) {
                this.f9879s = bundle2.getString("ARG_LOOP_ID");
            }
        }
        this.f9876p = -1;
        if (bundle == null) {
            if (getIntent() != null && getIntent().getExtras() != null) {
                this.f9876p = getIntent().getExtras().getInt("ARG_CURRENT_TAB", -1);
            }
        } else {
            this.f9876p = bundle.getInt("ARG_CURRENT_TAB", 0);
            this.f9877q = bundle.getInt("ARG_TABS_STATE", -1) == -1 ? null : TabsState.values()[bundle.getInt("ARG_TABS_STATE", 0)];
            m10283a(this.f9876p, true);
        }
        this.f9881u = new JibosListAdapter(this.f9885y);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        this.jiboList.setItemAnimator(new DefaultItemAnimator());
        this.jiboList.addItemDecoration(new JibosListAdapter.SpacesItemDecoration(this, R.dimen.divider_thickness));
        this.jiboList.setLayoutManager(linearLayoutManager);
        this.jiboList.setAdapter(this.f9881u);
        getLoaderManager().initLoader(R.id.loader_default_account, null, this);
        getLoaderManager().initLoader(R.id.loader_loops, null, this);
        getLoaderManager().initLoader(R.id.loader_jots_unread, null, this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.TabbedActivity");
        super.onResume();
        m10307v();
    }

    /* JADX INFO: renamed from: q */
    public Bundle m10302q() {
        return getIntent().getExtras().getBundle("ARG_EXTRAS");
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.jiboList.isShown()) {
            m10279D();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (intent != null && intent.hasExtra("ARG_TAB_SELECTED")) {
                m10283a(intent.getIntExtra("ARG_TAB_SELECTED", 0), true);
            }
            if (i == 1001) {
                SyncHelper.m10178b(this);
                return;
            }
            if (i == 1003 && intent != null && intent.getAction().equals(AvatarSelectionFragment.class.getSimpleName())) {
                m10285a(this.f9880t);
            } else if (i == 1006) {
                m10278C();
                m10297y();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.jibo.ui.activity.TabbedActivity$3] */
    /* JADX INFO: renamed from: y */
    private void m10297y() {
        long j = 3000;
        this.f9875k = new CountDownTimer(j, j) { // from class: com.jibo.ui.activity.TabbedActivity.3
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                TabbedActivity.this.m10279D();
            }
        }.start();
    }

    /* JADX INFO: renamed from: z */
    private void m10298z() {
        if (this.f9875k != null) {
            this.f9875k.cancel();
            this.f9875k = null;
        }
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        switch (i) {
            case R.id.loader_default_account /* 2131296705 */:
                return new CursorLoader(this, DatabaseContract.EntityEntry.m10079a(1), DatabaseContract.EntityEntry.f9694a, null, null, null);
            case R.id.loader_jots /* 2131296706 */:
            case R.id.loader_loop /* 2131296708 */:
            default:
                return null;
            case R.id.loader_jots_unread /* 2131296707 */:
                return new CursorLoader(this, DatabaseContract.JotEntry.f9696a, new String[]{"_id"}, "is_read = 0", null, null);
            case R.id.loader_loops /* 2131296709 */:
                return new CursorLoader(this, DatabaseContract.EntityEntry.m10079a(8), DatabaseContract.EntityEntry.f9694a, null, null, "_id");
        }
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (loader.getId() == R.id.loader_jots_unread) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.moveToFirst();
                int i = 0;
                while (!cursor.isAfterLast()) {
                    if (!cursor.getString(0).contains("TEMP_SENDING") && !cursor.getString(0).contains("TEMP_FAILED")) {
                        i++;
                    }
                    cursor.moveToNext();
                }
                ((BottomPanelButton) this.tabs.getChildAt(0)).setBadgeNumber(i);
                return;
            }
            return;
        }
        if (loader.getId() == R.id.loader_default_account) {
            if ((cursor == null || cursor.isClosed() || !cursor.moveToFirst()) && !isFinishing()) {
                OnBoardingActivity.m10230a((Context) this, OnBoardingActivity.f9821j, true);
                return;
            }
            return;
        }
        if (loader.getId() == R.id.loader_loops) {
            ArrayList<Loop> arrayList = new ArrayList<>();
            Account accountM10134i = EntityData.m10089a(this).m10134i();
            this.f9880t = SharedPreferencesUtil.m11443f(this);
            final Loop loop = null;
            if (cursor != null && !cursor.isClosed() && cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    EntityData.m10089a(this);
                    Loop loopM10088a = EntityData.m10088a(cursor);
                    arrayList.add(loopM10088a);
                    if (this.f9879s != null && this.f9879s.equalsIgnoreCase(loopM10088a.getId())) {
                        this.f9880t = loopM10088a;
                        SharedPreferencesUtil.m11430a(this, this.f9880t);
                    }
                    cursor.moveToNext();
                    if (m10302q() != null && loopM10088a.getId().equals(m10302q().getString("ARG_ENTITY_SELECTED")) && LoopHelper.isMemberInvited(loopM10088a, EntityData.m10089a(this).m10134i().getId())) {
                        loop = loopM10088a;
                    }
                }
            }
            this.f9874j = arrayList;
            this.f9881u.m10812a(accountM10134i, arrayList);
            this.f9881u.notifyDataSetChanged();
            m10281F();
            m10286a(this.f9880t == null ? TabsState.initial : TabsState.complete);
            if (loop != null) {
                m10302q().remove("ARG_ENTITY_SELECTED");
                this.jiboList.postDelayed(new Runnable() { // from class: com.jibo.ui.activity.TabbedActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        TabbedActivity.this.m10291b(loop);
                    }
                }, 500L);
            }
            if (m10305t()) {
                JiboAnalytics.m9836a(this, EntityData.m10089a(this).m10134i(), loop == null, SharedPreferencesUtil.m11441e(this));
                m10301b(false);
            }
        }
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    @Override // com.jibo.p019ui.activity.BaseActivity
    /* JADX INFO: renamed from: e */
    public void mo10195e() {
        m10194d();
    }

    /* JADX INFO: renamed from: a */
    private void m10286a(TabsState tabsState) {
        int i;
        if (!isFinishing()) {
            boolean[] zArr = tabsState == TabsState.initial ? f9871m : f9870l;
            if (this.f9876p == -1) {
                if (tabsState == TabsState.initial) {
                }
                i = 0;
            } else {
                i = this.f9876p;
            }
            if (tabsState != this.f9877q) {
                this.f9877q = tabsState;
                if (m10302q() != null) {
                    i = m10302q().getInt("ARG_TAB_SELECTED", i);
                }
                m10283a(i, true);
            }
            for (int i2 = 0; i2 < f9872n.length; i2++) {
                this.tabs.getChildAt(i2).setVisibility(zArr[i2] ? 0 : 8);
                this.tabs.getChildAt(i2).setTag(Integer.valueOf(i2));
                this.tabs.getChildAt(i2).setOnClickListener(this.f9886z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10283a(int i, boolean z) {
        if (i == 3) {
            JiboAnalytics.m9851e(this, JiboAnalytics.f9208aI);
            JiboSupport.m9868a((Activity) this);
        } else if (this.f9876p != i || z) {
            m10196f();
            m10282a(i);
            this.f9876p = i;
            m10276A();
        }
    }

    /* JADX INFO: renamed from: A */
    private void m10276A() {
        if (this.f9882v != null) {
            this.f9882v.mo3409c();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10300a(ActionMode actionMode) {
        this.f9882v = actionMode;
    }

    /* JADX INFO: renamed from: r */
    public ActionMode m10303r() {
        return this.f9882v;
    }

    /* JADX INFO: renamed from: s */
    public void m10304s() {
        if (this.f9882v != null) {
            this.f9882v.mo3410d();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10282a(int i) {
        this.mSelectorDimmer.setOnClickListener(null);
        TextView textViewA = m10185a();
        getSupportActionBar().setSubtitle("");
        if (textViewA != null) {
            if (i == 0) {
                textViewA.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.default_padding));
                textViewA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ImageUtils.m11392a(this, R.drawable.ic_chevron_down, R.color.white), (Drawable) null);
                if (textViewA.getParent() != null) {
                    ((View) textViewA.getParent()).setOnClickListener(this.f9884x);
                }
                this.mSelectorDimmer.setOnClickListener(this.f9884x);
            } else {
                textViewA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                ((View) textViewA.getParent()).setOnClickListener(null);
            }
        }
        m10290b(i);
        for (int i2 = 0; i2 < f9872n.length; i2++) {
            this.tabs.getChildAt(i2).setSelected(false);
        }
        this.tabs.getChildAt(i).setSelected(true);
    }

    /* JADX INFO: renamed from: b */
    private void m10290b(int i) {
        if (i == 1) {
            JiboAnalytics.m9848d(this);
        } else if (i == 2) {
            JiboAnalytics.m9854g(this);
        }
        FragmentTransaction fragmentTransactionMo1471a = getSupportFragmentManager().mo1471a();
        if (this.f9877q == TabsState.complete) {
            this.f9878r = Fragment.instantiate(this, f9872n[i], getIntent().getExtras());
        } else {
            this.f9878r = Fragment.instantiate(this, f9873o[i], getIntent().getExtras());
        }
        fragmentTransactionMo1471a.mo1379b(R.id.fragment_container, this.f9878r, this.f9878r.getClass().getSimpleName()).mo1385d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: B */
    public void m10277B() {
        m10298z();
        if (this.jiboList.getTag() == null || !((Boolean) this.jiboList.getTag()).booleanValue()) {
            if (this.jiboListContainer.isShown()) {
                m10279D();
            } else {
                m10278C();
            }
        }
    }

    /* JADX INFO: renamed from: C */
    private void m10278C() {
        this.jiboList.setTag(true);
        if (this.mSelectorDimmer != null) {
            this.mSelectorDimmer.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
            this.mSelectorDimmer.setVisibility(0);
            this.mSelectorDimmer.animate().alpha(1.0f).setListener(null).setDuration(500L).start();
        }
        this.jiboListContainer.setY((-this.f9881u.getItemCount()) * getResources().getDimensionPixelOffset(R.dimen.default_extended_list_item_height));
        this.jiboListContainer.setVisibility(0);
        this.jiboListContainer.animate().y(CropImageView.DEFAULT_ASPECT_RATIO).setDuration(600L).setListener(null).setInterpolator(new DecelerateInterpolator()).start();
        this.jiboList.postDelayed(new Runnable() { // from class: com.jibo.ui.activity.TabbedActivity.6
            @Override // java.lang.Runnable
            public void run() {
                TabbedActivity.this.jiboList.setTag(false);
            }
        }, 600L);
        TextView textViewA = m10185a();
        if (textViewA != null) {
            textViewA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ImageUtils.m11392a(this, R.drawable.ic_chevron_up, R.color.white), (Drawable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: D */
    public void m10279D() {
        this.jiboList.setTag(true);
        if (this.mSelectorDimmer != null) {
            this.mSelectorDimmer.setAlpha(1.0f);
            this.mSelectorDimmer.animate().alpha(CropImageView.DEFAULT_ASPECT_RATIO).setDuration(500L).setListener(new Animator.AnimatorListener() { // from class: com.jibo.ui.activity.TabbedActivity.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    TabbedActivity.this.mSelectorDimmer.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    TabbedActivity.this.mSelectorDimmer.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
        this.jiboListContainer.animate().y((-this.f9881u.getItemCount()) * getResources().getDimensionPixelOffset(R.dimen.default_extended_list_item_height)).setDuration(400L).setListener(new Animator.AnimatorListener() { // from class: com.jibo.ui.activity.TabbedActivity.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TabbedActivity.this.jiboListContainer.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TabbedActivity.this.jiboListContainer.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        }).setInterpolator(new AccelerateInterpolator()).start();
        this.jiboList.postDelayed(new Runnable() { // from class: com.jibo.ui.activity.TabbedActivity.9
            @Override // java.lang.Runnable
            public void run() {
                TabbedActivity.this.jiboList.setTag(false);
            }
        }, 600L);
        TextView textViewA = m10185a();
        if (textViewA != null) {
            textViewA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ImageUtils.m11392a(this, R.drawable.ic_chevron_down, R.color.white), (Drawable) null);
        }
    }

    /* JADX INFO: renamed from: E */
    private void m10280E() {
        this.mSelectorDimmer.setVisibility(8);
        this.jiboListContainer.setVisibility(8);
        TextView textViewA = m10185a();
        if (textViewA != null) {
            textViewA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ImageUtils.m11392a(this, R.drawable.ic_chevron_down, R.color.white), (Drawable) null);
        }
    }

    /* JADX INFO: renamed from: F */
    private void m10281F() {
        if (this.f9874j != null && !this.f9874j.isEmpty()) {
            Iterator<Loop> it = this.f9874j.iterator();
            while (it.hasNext()) {
                m10285a(it.next());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10285a(Loop loop) {
        if (loop != null) {
            EntityData.m10089a(this).m10132g().getRobot(loop.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>() { // from class: com.jibo.ui.activity.TabbedActivity.10
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    TabbedActivity.this.m10188a(exc, "get robot");
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(final GetRobotRequest getRobotRequest, final Robot robot) {
                    TabbedActivity.this.runOnUiThread(new Runnable() { // from class: com.jibo.ui.activity.TabbedActivity.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TabbedActivity.this.f9881u.m10813a(getRobotRequest.getId(), robot);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m10291b(Loop loop) {
        m10202l();
        Intent intent = new Intent();
        intent.putExtra(" ARGS_LOOPS_LIST", m10295c(loop));
        intent.putExtra(" ARGS_HAS_ACCEPTED_LOOPS", true);
        intent.setClass(this, LoopInviteDetailsActivity.class);
        startActivityForResult(intent, 1006);
    }

    /* JADX INFO: renamed from: c */
    private ArrayList<Loop> m10295c(Loop loop) {
        ArrayList<Loop> arrayList = new ArrayList<>();
        String email = EntityData.m10089a(this).m10134i().getEmail();
        arrayList.add(loop);
        for (Loop loop2 : this.f9881u.m10815c()) {
            if (!loop2.equals(loop) && LoopHelper.isMemberInvited(loop2, email)) {
                arrayList.add(loop2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m10296d(Loop loop) {
        if (loop != null) {
            m10279D();
            new Bundle().putParcelable(Loop.class.getSimpleName(), loop);
            if (LoopHelper.isMemberInvited(loop, EntityData.m10089a(this).m10134i().getId())) {
                m10291b(loop);
                return;
            } else {
                EntityData.m10089a(this).m10117a(loop);
                return;
            }
        }
        m10280E();
        WifiActivity.m10316a(this, this.f9874j);
    }

    /* JADX INFO: renamed from: t */
    public boolean m10305t() {
        return this.f9883w;
    }

    /* JADX INFO: renamed from: b */
    public void m10301b(boolean z) {
        this.f9883w = z;
    }

    /* JADX INFO: renamed from: u */
    public void m10306u() {
        m10283a(2, false);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ARG_CURRENT_TAB", this.f9876p);
        bundle.putInt("ARG_TABS_STATE", this.f9877q != null ? this.f9877q.ordinal() : -1);
    }

    /* JADX INFO: renamed from: v */
    protected void m10307v() {
        if (m10206p() && TextUtils.isEmpty(getSharedPreferences(getString(R.string.app_name), 0).getString("PREF_PUSH_SERVICE_TOKEN", null))) {
            startService(new Intent(this, (Class<?>) DeviceRegistrationService.class));
        }
    }

    /* JADX INFO: renamed from: w */
    public void m10308w() {
    }

    /* JADX INFO: renamed from: x */
    public ArrayList<Loop> m10309x() {
        return this.f9874j;
    }
}
