package com.jibo.p019ui.fragment.phone;

import android.os.Bundle;
import android.view.MenuItem;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.account.model.SendPhoneVerificationCodeRequest;
import com.jibo.aws.integration.aws.services.common.model.IdResponse;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.view.proxima.CustomFontTextView;

/* JADX INFO: loaded from: classes.dex */
public abstract class PhoneBaseFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10816a = PhoneBaseFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    protected MenuItem f10817b;

    /* JADX INFO: renamed from: c */
    protected CustomFontTextView f10818c;

    /* JADX INFO: renamed from: d */
    protected boolean f10819d;

    /* JADX INFO: renamed from: e */
    protected Runnable f10820e = new Runnable() { // from class: com.jibo.ui.fragment.phone.PhoneBaseFragment.1
        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle = new Bundle();
            bundle.putString("PARAM_PHONENUMBER", PhoneBaseFragment.this.m10871a(PhoneBaseFragment.this.mo10873b()));
            ((BaseActivity) PhoneBaseFragment.this.getActivity()).m10187a(PhoneConfirmFragment.class, bundle);
        }
    };

    /* JADX INFO: renamed from: a */
    protected abstract void mo10872a();

    /* JADX INFO: renamed from: b */
    protected abstract String mo10873b();

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.f10819d = getActivity() instanceof OnBoardingActivity ? false : true;
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        mo10872a();
    }

    /* JADX INFO: renamed from: b */
    protected void m10874b(final Runnable runnable) {
        m10344f();
        m10343e();
        EntityData.m10089a(getActivity()).m10110a().sendPhoneVerificationCode("+1" + m10871a(mo10873b()), new AsyncHandler<SendPhoneVerificationCodeRequest, IdResponse>() { // from class: com.jibo.ui.fragment.phone.PhoneBaseFragment.2
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                PhoneBaseFragment.this.m10338a((Throwable) exc, "send phone verification code", true);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(SendPhoneVerificationCodeRequest sendPhoneVerificationCodeRequest, IdResponse idResponse) {
                PhoneBaseFragment.this.mo10345g();
                PhoneBaseFragment.this.m10337a(runnable);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    protected String m10871a(String str) {
        return str.replaceAll(" |\\-|\\(|\\)", "");
    }
}
