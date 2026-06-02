package com.jibo.p019ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.android.gms.common.GoogleApiAvailability;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.exception.UnauthorizedRequestException;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.activity.TabbedActivity;
import com.jibo.p019ui.fragment.dialog.CircleProgressFragment;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import com.jibo.service.DeviceRegistrationService;
import com.jibo.service.SyncHelper;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.LogUtils;
import com.jibo.utils.ServiceUtils;
import com.jibo.utils.UIUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseFragment extends Fragment implements IBaseFragment, DialogUtils.DialogFragmentWrapperClickListener {

    /* JADX INFO: renamed from: f */
    public static final String f9929f = BaseFragment.class.getSimpleName();

    /* JADX INFO: renamed from: g */
    Unbinder f9930g;

    /* JADX INFO: renamed from: k */
    protected Loop f9934k;

    /* JADX INFO: renamed from: i */
    protected List<AbstractJiboAsyncClient> f9932i = new ArrayList();

    /* JADX INFO: renamed from: j */
    protected CircleProgressFragment f9933j = null;

    /* JADX INFO: renamed from: h */
    protected Handler f9931h = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: o */
    protected abstract String mo10353o();

    /* JADX INFO: renamed from: c */
    public Handler m10341c() {
        return this.f9931h;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            mo10340b(bundle);
        } else if (getArguments() != null) {
            mo10340b(getArguments());
        }
        m10350l();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f9930g = ButterKnife.m5154a(this, view);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() != null && (getActivity() instanceof BaseActivity)) {
            ((BaseActivity) getActivity()).m10202l();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f9934k != null) {
            bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f9930g.unbind();
        m10341c().removeCallbacksAndMessages(null);
        for (AbstractJiboAsyncClient abstractJiboAsyncClient : this.f9932i) {
            if (abstractJiboAsyncClient != null) {
                try {
                    abstractJiboAsyncClient.shutdown();
                } catch (Exception e) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        if (bundle.containsKey(Loop.class.getSimpleName())) {
            this.f9934k = (Loop) bundle.getParcelable(Loop.class.getSimpleName());
        }
        if (bundle.getBoolean("ARGS_SKILL_FRAGMENT", false) && !SkillsJsonParser.isCreated()) {
            if (getActivity().getSupportFragmentManager().mo1481e() <= 1) {
                getActivity().finish();
            } else {
                getActivity().getSupportFragmentManager().mo1479c();
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public boolean m10342d() {
        return (getActivity() == null || !(getActivity() instanceof BaseActivity) || getActivity().isFinishing() || isDetached() || isRemoving() || !isResumed()) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public void m10337a(Runnable runnable) {
        if (m10342d()) {
            getActivity().runOnUiThread(runnable);
        }
    }

    /* JADX INFO: renamed from: e */
    public void m10343e() {
        try {
            if (m10342d() && getActivity().getWindow().getCurrentFocus() != null) {
                ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception e) {
            LogUtils.m11408a(f9929f, "hideSoftwareKeyboard", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10335a(EditText editText) {
        try {
            if (m10342d()) {
                ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(editText, 1);
            }
        } catch (Exception e) {
            LogUtils.m11408a(f9929f, "showSoftwareKeyboard", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10336a(AbstractJiboAsyncClient abstractJiboAsyncClient) {
        Iterator<AbstractJiboAsyncClient> it = this.f9932i.iterator();
        while (it.hasNext()) {
            if (it.next() == abstractJiboAsyncClient) {
                return;
            }
        }
        this.f9932i.add(abstractJiboAsyncClient);
    }

    /* JADX INFO: renamed from: f */
    public void m10344f() {
        if (m10342d()) {
            ((BaseActivity) getActivity()).m10201k();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10339a(boolean z) {
        if (m10342d()) {
            ((BaseActivity) getActivity()).m10189a(z);
        }
    }

    /* JADX INFO: renamed from: g */
    public void mo10345g() {
        if (m10342d()) {
            ((BaseActivity) getActivity()).m10202l();
        }
    }

    @Override // com.jibo.p019ui.fragment.IBaseFragment
    /* JADX INFO: renamed from: h */
    public boolean mo10346h() {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        if (100 == i) {
            getActivity().setResult(BaseActivity.f9762d);
            getActivity().finish();
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m10333a() {
        GoogleApiAvailability googleApiAvailabilityM6828a = GoogleApiAvailability.m6828a();
        int iMo6834a = googleApiAvailabilityM6828a.mo6834a(getActivity());
        if (iMo6834a == 0) {
            return true;
        }
        if (googleApiAvailabilityM6828a.mo6840a(iMo6834a)) {
            googleApiAvailabilityM6828a.m6835a((Activity) getActivity(), iMo6834a, 9000).show();
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private void m10332a(float f) {
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setElevation(f);
        }
        if (((BaseActivity) getActivity()).m10205o() != null && Build.VERSION.SDK_INT >= 21) {
            ((BaseActivity) getActivity()).m10205o().setElevation(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a */
    public void m10338a(final Throwable th, String str, final boolean z) {
        m10337a(new Runnable() { // from class: com.jibo.ui.fragment.BaseFragment.1
            @Override // java.lang.Runnable
            public void run() {
                BaseFragment.this.mo10345g();
                if (ErrorHelper.m11383a(null, BaseFragment.this, th) || !z) {
                    return;
                }
                UIUtils.m11476a(BaseFragment.this.getView(), th);
            }
        });
    }

    /* JADX INFO: renamed from: i */
    protected void m10347i() {
        if (m10333a() && TextUtils.isEmpty(getActivity().getSharedPreferences(getString(R.string.app_name), 0).getString("PREF_PUSH_SERVICE_TOKEN", null))) {
            ServiceUtils.m11427a(getActivity(), new Intent(getActivity(), (Class<?>) DeviceRegistrationService.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: j */
    public void m10348j() {
        if (m10342d()) {
            KeyManager.getInstance(getActivity(), EntityData.m10089a(getActivity()).m10134i().getId());
            final List<Loop> listM10112a = null;
            try {
                listM10112a = EntityData.m10089a(getActivity()).m10112a(true);
            } catch (Exception e) {
                m10338a((Throwable) e, "list loops", false);
                if (e instanceof UnauthorizedRequestException) {
                    m10337a(new Runnable() { // from class: com.jibo.ui.fragment.BaseFragment.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (((UnauthorizedRequestException) e).getErrorMessage().contains("Clock skew")) {
                                Toast.makeText(BaseFragment.this.getActivity(), R.string.error_clock_skew, 0).show();
                            }
                            OnBoardingActivity.m10230a((Context) BaseFragment.this.getActivity(), OnBoardingActivity.f9821j, false);
                        }
                    });
                    return;
                } else if (m10342d()) {
                    SyncHelper.m10178b(getActivity());
                }
            }
            m10337a(new Runnable() { // from class: com.jibo.ui.fragment.BaseFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    ((OnBoardingActivity) BaseFragment.this.getActivity()).m10202l();
                    ((OnBoardingActivity) BaseFragment.this.getActivity()).m10237a(listM10112a, BaseFragment.this);
                }
            });
        }
    }

    /* JADX INFO: renamed from: k */
    protected void m10349k() {
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        }
    }

    /* JADX INFO: renamed from: l */
    protected void m10350l() {
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        }
    }

    /* JADX INFO: renamed from: m */
    protected void m10351m() {
        m10332a(CropImageView.DEFAULT_ASPECT_RATIO);
    }

    /* JADX INFO: renamed from: n */
    protected void m10352n() {
        m10332a(getResources().getDimension(R.dimen.actionbar_elevation));
    }

    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        actionBar.setTitle(mo10353o());
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (getActivity() != null && ((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            mo10334a(((AppCompatActivity) getActivity()).getSupportActionBar());
        }
    }

    /* JADX INFO: renamed from: p */
    protected TabbedActivity m10354p() {
        return (TabbedActivity) getActivity();
    }
}
