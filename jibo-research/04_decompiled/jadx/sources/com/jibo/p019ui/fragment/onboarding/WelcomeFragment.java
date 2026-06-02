package com.jibo.p019ui.fragment.onboarding;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnLongClick;
import com.jibo.R;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.fragment.BaseFragment;

/* JADX INFO: loaded from: classes.dex */
public class WelcomeFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10805a = WelcomeFragment.class.getSimpleName();

    @BindView
    TextView btnLogin;

    @BindView
    Button btnSignUp;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_welcome, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.btnLogin.setText(Html.fromHtml(getString(R.string.textlink_have_an_account_sign_in2)));
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

    @OnLongClick
    public boolean onDevSettings(View view) {
        return true;
    }
}
