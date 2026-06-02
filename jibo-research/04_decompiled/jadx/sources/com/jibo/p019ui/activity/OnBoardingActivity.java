package com.jibo.p019ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.crashlytics.android.Crashlytics;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.JiboAnalytics;
import com.jibo.JiboApplication;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.Commons;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.SplashFragment;
import com.jibo.p019ui.fragment.onboarding.AboutYouFragment;
import com.jibo.p019ui.fragment.onboarding.DevSettingsFragment;
import com.jibo.p019ui.fragment.onboarding.LoginFragment;
import com.jibo.p019ui.fragment.onboarding.ResetPasswordFragment;
import com.jibo.p019ui.fragment.onboarding.ResetPasswordNewPasswordFragment;
import com.jibo.p019ui.fragment.onboarding.ResetPasswordSentFragment;
import com.jibo.p019ui.fragment.onboarding.SignupCompleteFragment;
import com.jibo.p019ui.fragment.onboarding.SignupFragment;
import com.jibo.p019ui.fragment.onboarding.WelcomeFragment;
import com.jibo.p019ui.fragment.phone.PhoneFillFragment;
import com.jibo.service.SyncHelper;
import com.jibo.utils.SharedPreferencesUtil;
import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OnBoardingActivity extends BaseActivity implements BaseActivity.OnDoubleBackButtonListener {

    /* JADX INFO: renamed from: h */
    public static final String f9819h = OnBoardingActivity.class.getSimpleName();

    /* JADX INFO: renamed from: i */
    public static final String f9820i = OnBoardingActivity.class.getName() + ".ACTION_RESET_PASSWORD";

    /* JADX INFO: renamed from: j */
    public static final String f9821j = OnBoardingActivity.class.getName() + ".ACTION_LOGIN_OR_SIGNUP";

    /* JADX INFO: renamed from: k */
    public static final String f9822k = OnBoardingActivity.class.getName() + ".ACTION_CUSTOMER_SUPPORT";

    /* JADX INFO: renamed from: l */
    public static final String f9823l = OnBoardingActivity.class.getName() + ".ACTION_DEV_SETTINGS";

    /* JADX INFO: renamed from: n */
    public static String f9824n = null;

    /* JADX INFO: renamed from: m */
    public Bundle f9825m = new Bundle();

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.OnBoardingActivity");
        super.onResume();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.OnBoardingActivity");
        super.onStart();
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.OnBoardingActivity");
        getIntent().putExtra(BaseActivity.f9760b, R.layout.activity_onboarding);
        super.onCreate(bundle);
        Fabric.m15075a(this, new Crashlytics());
        if (!"jibo".equals("netposa")) {
            SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name), 0);
            Commons.setRootEndpoint(Commons.ALLOWED_ENDPOINTS[2]);
            sharedPreferences.edit().putString("PREF_END_POINT", Commons.ALLOWED_ENDPOINTS[2]).apply();
        }
        if (bundle == null) {
            m10238a(getIntent());
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        if (!m10238a(intent)) {
            super.onNewIntent(intent);
        }
    }

    @Override // android.support.v4.app.FragmentActivity
    protected void onResumeFragments() {
        super.onResumeFragments();
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        m10202l();
        if (getSupportFragmentManager().mo1481e() == 1) {
            if (getSupportFragmentManager().mo1470a(SignupCompleteFragment.f10761a) != null || getSupportFragmentManager().mo1470a(LoginFragment.f10728a) != null || getSupportFragmentManager().mo1470a(AboutYouFragment.f10646n) != null) {
                m10243q();
                return;
            } else if (getSupportFragmentManager().mo1470a(ResetPasswordSentFragment.f10748a) != null || getSupportFragmentManager().mo1470a(ResetPasswordNewPasswordFragment.f10741a) != null) {
                m10203m();
                m10235a((String) null);
                return;
            }
        }
        super.onBackPressed();
    }

    @Override // com.jibo.p019ui.activity.BaseActivity
    /* JADX INFO: renamed from: e */
    public void mo10195e() {
    }

    /* JADX INFO: renamed from: a */
    protected boolean m10238a(Intent intent) {
        if (!SharedPreferencesUtil.m11438c(this)) {
            if (intent.getData() != null && intent.getData().toString() != null) {
                JiboAnalytics.m9841a((Context) this, true);
            } else {
                JiboAnalytics.m9841a((Context) this, false);
            }
            SharedPreferencesUtil.m11439d(this);
        }
        if (f9820i.equals(intent.getAction())) {
            m10242c(EntityData.m10089a(this).m10134i().getEmail(), "");
        } else if (f9821j.equals(intent.getAction())) {
            m10243q();
        } else if (!f9822k.equals(intent.getAction())) {
            if (f9823l.equals(intent.getAction())) {
                m10246t();
            } else if (intent.getData() != null && intent.getData().toString().contains(getString(R.string.link_account_activate))) {
                ((JiboApplication) getApplication()).mo9832b();
                m10240b(intent.getData().getQueryParameter("email"), intent.getData().getQueryParameter("code"));
            } else if (intent.getData() != null && intent.getData().toString().contains(getString(R.string.link_reset_password))) {
                ((JiboApplication) getApplication()).mo9832b();
                m10242c(intent.getData().getQueryParameter("email"), intent.getData().getQueryParameter("code"));
            } else if (intent.getData() != null && intent.getData().toString().contains(getString(R.string.link_create))) {
                m10233b(intent.getData());
            } else if (intent.getData() != null && intent.getData().toString().contains(getString(R.string.link_home))) {
                m10233b(intent.getData());
            } else if (intent.getData() != null && intent.getData().toString().contains(getString(R.string.link_settings))) {
                m10231a(intent.getData());
            } else if (intent.getData() != null && intent.getData().toString().contains(getString(R.string.google_auth_callback))) {
                f9824n = intent.getData().toString();
                setResult(-1, intent);
                finish();
            } else {
                m10234u();
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private void m10231a(Uri uri) {
        String queryParameter = uri.getQueryParameter("loopId");
        if (EntityData.m10089a(this).m10134i() == null) {
            ((JiboApplication) getApplication()).mo9832b();
            m10243q();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_TAB_SELECTED", 0);
        bundle.putBoolean("ARG_SETTINGS", true);
        bundle.putString("ARG_LOOP_ID", queryParameter);
        getIntent().putExtra("ARG_EXTRAS", bundle);
        m10234u();
    }

    /* JADX INFO: renamed from: b */
    private void m10233b(Uri uri) {
        String queryParameter = uri.getQueryParameter("email");
        String queryParameter2 = uri.getQueryParameter("code");
        Account accountM10134i = EntityData.m10089a(this).m10134i();
        if (accountM10134i == null) {
            ((JiboApplication) getApplication()).mo9832b();
            if (TextUtils.isEmpty(queryParameter2)) {
                m10243q();
                return;
            } else {
                m10236a(queryParameter, queryParameter2);
                return;
            }
        }
        if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals(accountM10134i.getEmail())) {
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_TAB_SELECTED", 0);
            getIntent().putExtra("ARG_EXTRAS", bundle);
            m10234u();
            return;
        }
        if (!TextUtils.isEmpty(queryParameter) && !queryParameter.equals(accountM10134i.getEmail())) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("ARG_TAB_SELECTED", 0);
            bundle2.putString("ARG_TITLE", getString(R.string.msg_getting_invited_into_right_loop_title));
            bundle2.putString("ARG_MESSAGE", String.format(getString(R.string.msg_getting_invited_into_right_loop_text), queryParameter));
            getIntent().putExtra("ARG_EXTRAS", bundle2);
            this.f9825m.putAll(bundle2);
            m10234u();
            return;
        }
        m10234u();
    }

    /* JADX INFO: renamed from: u */
    private void m10234u() {
        m10203m();
        m10187a(SplashFragment.class, this.f9825m);
    }

    /* JADX INFO: renamed from: q */
    public void m10243q() {
        m10203m();
        m10187a(WelcomeFragment.class, this.f9825m);
    }

    /* JADX INFO: renamed from: a */
    public void m10235a(String str) {
        this.f9825m.putString("email", str);
        m10187a(LoginFragment.class, this.f9825m);
    }

    /* JADX INFO: renamed from: a */
    public void m10236a(String str, String str2) {
        this.f9825m.putString("email", str);
        this.f9825m.putString("code", str2);
        getSupportFragmentManager().mo1471a().mo1379b(R.id.fragment_container, Fragment.instantiate(this, SignupFragment.class.getName(), this.f9825m), SignupFragment.f10773a).mo1368a(SignupFragment.f10773a).mo1385d();
    }

    /* JADX INFO: renamed from: b */
    public void m10240b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            m10234u();
            return;
        }
        this.f9825m.putString("email", str);
        this.f9825m.putString("code", str2);
        getSupportFragmentManager().mo1480d();
        this.f9763e.postDelayed(new Runnable() { // from class: com.jibo.ui.activity.OnBoardingActivity.1
            @Override // java.lang.Runnable
            public void run() {
                OnBoardingActivity.this.getSupportFragmentManager().mo1471a().mo1379b(R.id.fragment_container, Fragment.instantiate(OnBoardingActivity.this, SignupCompleteFragment.class.getName(), OnBoardingActivity.this.f9825m), SignupCompleteFragment.f10761a).mo1368a(SignupCompleteFragment.f10761a).mo1385d();
            }
        }, 500L);
    }

    /* JADX INFO: renamed from: b */
    public void m10239b(String str) {
        this.f9825m.putString("email", str);
        getSupportFragmentManager().mo1471a().mo1379b(R.id.fragment_container, Fragment.instantiate(this, ResetPasswordFragment.class.getName(), this.f9825m), ResetPasswordFragment.f10733a).mo1368a(ResetPasswordFragment.f10733a).mo1385d();
    }

    /* JADX INFO: renamed from: c */
    public void m10242c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            m10234u();
            return;
        }
        this.f9825m.putString("email", str);
        this.f9825m.putString("code", str2);
        getSupportFragmentManager().mo1471a().mo1379b(R.id.fragment_container, Fragment.instantiate(this, ResetPasswordSentFragment.class.getName(), this.f9825m), ResetPasswordSentFragment.f10748a).mo1368a(ResetPasswordSentFragment.f10748a).mo1385d();
    }

    /* JADX INFO: renamed from: c */
    public void m10241c(String str) {
        this.f9825m.putString("code", str);
        getSupportFragmentManager().mo1471a().mo1379b(R.id.fragment_container, Fragment.instantiate(this, ResetPasswordNewPasswordFragment.class.getName(), this.f9825m), ResetPasswordNewPasswordFragment.f10741a).mo1368a(ResetPasswordNewPasswordFragment.f10741a).mo1385d();
    }

    /* JADX INFO: renamed from: a */
    public void m10237a(List<Loop> list, BaseFragment baseFragment) {
        Account accountM10134i = EntityData.m10089a(this).m10134i();
        if (accountM10134i == null) {
            m10243q();
            return;
        }
        if (!accountM10134i.isActive().booleanValue()) {
            m10240b(accountM10134i.getEmail(), (String) null);
            return;
        }
        if (baseFragment != null && (baseFragment instanceof SignupCompleteFragment)) {
            m10244r();
            return;
        }
        if (accountM10134i.isIncomplete()) {
            m10244r();
            return;
        }
        if (LoopHelper.hasInvitationsOnly(list, accountM10134i.getEmail())) {
            m10232a(list);
            return;
        }
        if (SharedPreferencesUtil.m11446g(getApplicationContext())) {
            SyncHelper.m10175a(getApplicationContext());
        }
        SyncHelper.m10180c(getApplicationContext());
        TabbedActivity.m10284a(this, getIntent().getExtras().getBundle("ARG_EXTRAS"));
    }

    /* JADX INFO: renamed from: a */
    private void m10232a(List<Loop> list) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(list);
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra(" ARGS_LOOPS_LIST", arrayList);
        intent.putExtra(" ARGS_HAS_ACCEPTED_LOOPS", false);
        intent.putExtra("ARG_EXTRAS", getIntent().getExtras().getBundle("ARG_EXTRAS"));
        intent.setClass(this, LoopInviteDetailsActivity.class);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: renamed from: r */
    public void m10244r() {
        m10203m();
        m10187a(PhoneFillFragment.class, this.f9825m);
    }

    /* JADX INFO: renamed from: s */
    public void m10245s() {
        m10203m();
        m10187a(AboutYouFragment.class, this.f9825m);
    }

    /* JADX INFO: renamed from: t */
    public void m10246t() {
        getSupportFragmentManager().mo1471a().mo1379b(R.id.fragment_container, Fragment.instantiate(this, DevSettingsFragment.class.getName(), this.f9825m), DevSettingsFragment.f10676a).mo1368a(DevSettingsFragment.f10676a).mo1385d();
    }

    /* JADX INFO: renamed from: a */
    public static void m10230a(Context context, String str, boolean z) {
        Intent intent = new Intent(context, (Class<?>) OnBoardingActivity.class);
        intent.setAction(str);
        context.startActivity(intent);
        if (z && (context instanceof Activity)) {
            ((Activity) context).finish();
        }
    }
}
