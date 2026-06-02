package com.jibo.p019ui.activity;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.common.GoogleApiAvailability;
import com.jibo.JiboApplication;
import com.jibo.R;
import com.jibo.p019ui.fragment.IBaseFragment;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.LogUtils;
import com.jibo.utils.NetworkStateReceiver;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.UIUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class BaseActivity extends AppCompatActivity implements DialogUtils.DialogFragmentWrapperClickListener {

    /* JADX INFO: renamed from: a */
    public static final String f9759a = BaseActivity.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    public static final String f9760b = BaseActivity.class.getName() + ".LAYOUT_ID";

    /* JADX INFO: renamed from: c */
    public static int f9761c = 100;

    /* JADX INFO: renamed from: d */
    public static int f9762d = f9761c + 1;

    /* JADX INFO: renamed from: e */
    Toolbar f9763e;

    /* JADX INFO: renamed from: f */
    Unbinder f9764f;

    @BindView
    View mDimmer;

    @BindView
    ProgressBar mProgressBar;

    @BindView
    View viewNetworkDown;

    /* JADX INFO: renamed from: h */
    private boolean f9766h = false;

    /* JADX INFO: renamed from: g */
    protected Handler f9765g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: i */
    private Runnable f9767i = new Runnable() { // from class: com.jibo.ui.activity.BaseActivity.1
        @Override // java.lang.Runnable
        public void run() {
            BaseActivity.this.f9766h = false;
            BaseActivity.this.f9765g.removeCallbacks(BaseActivity.this.f9767i);
        }
    };

    /* JADX INFO: renamed from: j */
    private Runnable f9768j = new Runnable() { // from class: com.jibo.ui.activity.BaseActivity.2
        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(BaseActivity.this, R.string.info_tap_backbutton_twice, 0).show();
            BaseActivity.this.f9765g.removeCallbacks(BaseActivity.this.f9768j);
        }
    };

    /* JADX INFO: renamed from: k */
    private NetworkStateReceiver f9769k = new NetworkStateReceiver() { // from class: com.jibo.ui.activity.BaseActivity.3
        @Override // com.jibo.utils.NetworkStateReceiver
        /* JADX INFO: renamed from: a */
        public void mo10207a(boolean z) {
            if (z) {
                BaseActivity.this.m10192c();
            } else {
                BaseActivity.this.m10190b();
            }
            BaseActivity.this.invalidateOptionsMenu();
        }
    };

    public interface OnDoubleBackButtonListener {
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(getIntent().getIntExtra(f9760b, R.layout.activity_common));
        this.f9764f = ButterKnife.m5152a(this);
        m10202l();
        if (findViewById(R.id.toolbar) instanceof Toolbar) {
            this.f9763e = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(this.f9763e);
            TextView textViewM10185a = m10185a();
            if (textViewM10185a != null) {
                ProximaHelper.m11356a(textViewM10185a);
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(this.f9769k, intentFilter);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f9765g.removeCallbacks(this.f9768j);
        this.f9765g.removeCallbacks(this.f9767i);
        unregisterReceiver(this.f9769k);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == f9762d) {
            setResult(f9762d);
            finish();
        }
        if (i2 == f9761c) {
            mo10195e();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        m10202l();
        m10196f();
        ComponentCallbacks componentCallbacksMo1468a = getSupportFragmentManager().mo1468a(R.id.fragment_container);
        if (componentCallbacksMo1468a == null || !(componentCallbacksMo1468a instanceof IBaseFragment) || !((IBaseFragment) componentCallbacksMo1468a).mo10346h()) {
            if (getSupportFragmentManager().mo1481e() > 1) {
                super.onBackPressed();
                return;
            }
            if ((this instanceof OnDoubleBackButtonListener) && getSupportFragmentManager().mo1481e() == 1 && !this.f9766h && (getIntent().getAction() == null || getIntent().getAction().equals("android.intent.action.MAIN") || getIntent().getAction().equals(OnBoardingActivity.f9821j))) {
                this.f9766h = true;
                this.f9765g.postDelayed(this.f9768j, 400L);
                this.f9765g.postDelayed(this.f9767i, 1200L);
                return;
            }
            finish();
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f9764f.unbind();
    }

    @Override // com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        if (100 == i) {
            setResult(f9762d);
            finish();
        }
    }

    /* JADX INFO: renamed from: a */
    protected TextView m10185a() {
        try {
            Field declaredField = getSupportActionBar().getClass().getDeclaredField("mDecorToolbar");
            declaredField.setAccessible(true);
            Toolbar toolbar = (Toolbar) ((ToolbarWidgetWrapper) declaredField.get(getSupportActionBar())).mo4047a();
            Field declaredField2 = toolbar.getClass().getDeclaredField("mTitleTextView");
            declaredField2.setAccessible(true);
            return (TextView) declaredField2.get(toolbar);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m10188a(final Exception exc, String str) {
        Crashlytics.m5597a((Throwable) exc);
        runOnUiThread(new Runnable() { // from class: com.jibo.ui.activity.BaseActivity.5
            @Override // java.lang.Runnable
            public void run() {
                ErrorHelper.m11383a(BaseActivity.this, null, exc);
            }
        });
    }

    /* JADX INFO: renamed from: b */
    protected void m10190b() {
        if (this.viewNetworkDown != null) {
            this.viewNetworkDown.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: c */
    protected void m10192c() {
        if (this.viewNetworkDown != null) {
            this.viewNetworkDown.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: d */
    protected void m10194d() {
        ((JiboApplication) getApplication()).mo9832b();
        SharedPreferencesUtil.m11434b(this);
        OnBoardingActivity.m10230a((Context) this, OnBoardingActivity.f9821j, true);
    }

    /* JADX INFO: renamed from: e */
    public void mo10195e() {
        setResult(TabbedActivity.f9761c);
        finish();
    }

    /* JADX INFO: renamed from: f */
    public void m10196f() {
        try {
            if (getWindow().getCurrentFocus() != null) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception e) {
            LogUtils.m11408a(f9759a, "hideSoftwareKeyboard", e);
        }
    }

    /* JADX INFO: renamed from: g */
    public Toolbar m10197g() {
        return this.f9763e;
    }

    /* JADX INFO: renamed from: h */
    public ProgressBar m10198h() {
        return this.mProgressBar;
    }

    /* JADX INFO: renamed from: i */
    public void mo10199i() {
        if (this.mDimmer != null) {
            this.mDimmer.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: j */
    public void mo10200j() {
        if (this.mDimmer != null) {
            this.mDimmer.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: k */
    public void m10201k() {
        runOnUiThread(new Runnable() { // from class: com.jibo.ui.activity.BaseActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (BaseActivity.this.mProgressBar != null) {
                    BaseActivity.this.mProgressBar.setVisibility(0);
                }
                BaseActivity.this.mo10199i();
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10189a(final boolean z) {
        runOnUiThread(new Runnable() { // from class: com.jibo.ui.activity.BaseActivity.7
            @Override // java.lang.Runnable
            public void run() {
                if (BaseActivity.this.mProgressBar != null) {
                    BaseActivity.this.mProgressBar.setVisibility(0);
                }
                if (BaseActivity.this.mDimmer != null) {
                    BaseActivity.this.mDimmer.setVisibility(z ? 0 : 8);
                }
            }
        });
    }

    /* JADX INFO: renamed from: l */
    public void m10202l() {
        runOnUiThread(new Runnable() { // from class: com.jibo.ui.activity.BaseActivity.8
            @Override // java.lang.Runnable
            public void run() {
                if (BaseActivity.this.mProgressBar != null) {
                    BaseActivity.this.mProgressBar.setVisibility(8);
                }
                BaseActivity.this.mo10200j();
            }
        });
    }

    /* JADX INFO: renamed from: m */
    public void m10203m() {
        FragmentManager.BackStackEntry backStackEntryMo1476b = getSupportFragmentManager().mo1481e() > 0 ? getSupportFragmentManager().mo1476b(0) : null;
        if (backStackEntryMo1476b != null) {
            getSupportFragmentManager().mo1478b(backStackEntryMo1476b.mo1359a(), 1);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10187a(Class cls, Bundle bundle) {
        getSupportFragmentManager().mo1471a().mo1379b(R.id.fragment_container, Fragment.instantiate(this, cls.getName(), bundle), cls.getSimpleName()).mo1368a(cls.getSimpleName()).mo1385d();
    }

    /* JADX INFO: renamed from: b */
    public void m10191b(Class cls, Bundle bundle) {
        getSupportFragmentManager().mo1471a().mo1365a(R.id.fragment_container, Fragment.instantiate(this, cls.getName(), bundle), cls.getSimpleName()).mo1368a(cls.getSimpleName()).mo1385d();
    }

    /* JADX INFO: renamed from: c */
    public void m10193c(Class cls, Bundle bundle) {
        getSupportFragmentManager().mo1471a().mo1363a(R.anim.slide_in_right, R.anim.slide_out_right, R.anim.slide_in_left, R.anim.slide_out_left).mo1379b(R.id.fragment_container, Fragment.instantiate(this, cls.getName(), bundle), cls.getSimpleName()).mo1368a(cls.getSimpleName()).mo1385d();
    }

    /* JADX INFO: renamed from: n */
    public Fragment m10204n() {
        return getSupportFragmentManager().mo1468a(R.id.fragment_container);
    }

    /* JADX INFO: renamed from: o */
    public AppBarLayout m10205o() {
        return (AppBarLayout) findViewById(R.id.app_bar);
    }

    /* JADX INFO: renamed from: p */
    protected boolean m10206p() {
        GoogleApiAvailability googleApiAvailabilityM6828a = GoogleApiAvailability.m6828a();
        int iMo6834a = googleApiAvailabilityM6828a.mo6834a(this);
        if (iMo6834a != 0) {
            if (googleApiAvailabilityM6828a.mo6840a(iMo6834a)) {
                googleApiAvailabilityM6828a.m6835a((Activity) this, iMo6834a, 9000).show();
            } else {
                UIUtils.m11475a(findViewById(R.id.fragment_container), "Play Services not available");
            }
            return false;
        }
        return true;
    }
}
