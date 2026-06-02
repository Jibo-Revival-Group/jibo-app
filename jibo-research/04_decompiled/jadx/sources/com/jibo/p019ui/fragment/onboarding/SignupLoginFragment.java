package com.jibo.p019ui.fragment.onboarding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnLongClick;
import com.jibo.R;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.fragment.BaseFragment;

/* JADX INFO: loaded from: classes.dex */
public class SignupLoginFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10781a = SignupLoginFragment.class.getSimpleName();

    @BindView
    View btnLearnMore;

    @BindView
    Button btnLogin;

    @BindView
    Button btnSignUp;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_signuplogin, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        m10349k();
        actionBar.setDisplayHomeAsUpEnabled(false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return "";
    }

    @OnClick
    public void openLoginScreen(View view) {
        ((OnBoardingActivity) getActivity()).m10235a((String) null);
    }

    @OnClick
    public void openSignupScreen(View view) {
        ((OnBoardingActivity) getActivity()).m10236a((String) null, (String) null);
    }

    @OnClick
    public void openLearnMoreLink(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://www.jibo.com"));
        startActivity(intent);
    }

    @OnLongClick
    public boolean onDevSettings(View view) {
        return true;
    }
}
