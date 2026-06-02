package com.jibo.p019ui.fragment;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amazonaws.AmazonServiceException;
import com.jibo.JiboAnalytics;
import com.jibo.JiboApplication;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.util.Commons;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.LogUtils;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SplashFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f9945a = SplashFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private Runnable f9946b = new RunnableC10321();

    /* JADX INFO: renamed from: com.jibo.ui.fragment.SplashFragment$1 */
    class RunnableC10321 implements Runnable {
        RunnableC10321() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SplashFragment.this.m10342d()) {
                final Account accountM10134i = EntityData.m10089a(SplashFragment.this.getActivity()).m10134i();
                if (accountM10134i != null && !TextUtils.isEmpty(accountM10134i.getAccessKeyId()) && !TextUtils.isEmpty(accountM10134i.getSecretAccessKey())) {
                    JiboAnalytics.m9835a(SplashFragment.this.getActivity(), accountM10134i);
                    SplashFragment.this.m10347i();
                    EntityData.m10089a(SplashFragment.this.getActivity()).m10119a(new Commons.AsyncCallback<Object>() { // from class: com.jibo.ui.fragment.SplashFragment.1.1
                        @Override // com.jibo.aws.integration.util.Commons.AsyncCallback
                        public void onError(Exception exc) {
                            SplashFragment.this.m10338a((Throwable) exc, "pull crutial data from server", true);
                            if (!(exc instanceof AmazonServiceException)) {
                                SplashFragment.this.m10361a();
                                return;
                            }
                            AmazonServiceException amazonServiceException = (AmazonServiceException) exc;
                            if (ErrorHelper.m11384a(amazonServiceException)) {
                                SplashFragment.this.m10361a();
                                return;
                            }
                            if (ErrorHelper.m11385b(amazonServiceException) || ErrorHelper.m11386c(amazonServiceException)) {
                                ((JiboApplication) SplashFragment.this.getActivity().getApplication()).mo9832b();
                                SplashFragment.this.m10361a();
                            } else if (!ErrorHelper.m11387d(amazonServiceException)) {
                                SplashFragment.this.m10361a();
                            } else {
                                SplashFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.SplashFragment.1.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((OnBoardingActivity) SplashFragment.this.getActivity()).m10240b(accountM10134i.getEmail(), (String) null);
                                    }
                                });
                            }
                        }

                        @Override // com.jibo.aws.integration.util.Commons.AsyncCallback
                        public void onSuccess(Object obj) {
                            if (SplashFragment.this.m10342d()) {
                                Account accountM10134i2 = EntityData.m10089a(SplashFragment.this.getActivity()).m10134i();
                                if (!accountM10134i2.isActive().booleanValue() || (obj instanceof Account)) {
                                    ((OnBoardingActivity) SplashFragment.this.getActivity()).m10240b(accountM10134i2.getEmail(), (String) null);
                                    return;
                                }
                                KeyManager.getInstance(SplashFragment.this.getActivity(), accountM10134i2.getId());
                                final List list = (List) obj;
                                SplashFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.SplashFragment.1.1.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((OnBoardingActivity) SplashFragment.this.getActivity()).m10237a(list, SplashFragment.this);
                                    }
                                });
                            }
                        }
                    });
                } else {
                    SharedPreferencesUtil.m11429a(SplashFragment.this.getActivity());
                    SplashFragment.this.m10361a();
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_splash, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m10341c().removeCallbacks(this.f9946b);
        m10341c().postDelayed(this.f9946b, 500L);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        m10341c().removeCallbacks(this.f9946b);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        m10349k();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10361a() {
        m10337a(new Runnable() { // from class: com.jibo.ui.fragment.SplashFragment.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((OnBoardingActivity) SplashFragment.this.getActivity()).m10243q();
                } catch (Exception e) {
                    LogUtils.m11408a(SplashFragment.f9945a, "gotoSignupLoginFragment", e);
                }
            }
        });
    }
}
