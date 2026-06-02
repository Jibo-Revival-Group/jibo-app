package com.jibo.p019ui.fragment.wifi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.OnClick;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.oobe.model.TokenContainer;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class WiFiTokenGetterFragment extends WiFiBaseQRCodeFragment {

    /* JADX INFO: renamed from: p */
    public static final String f11421p = LogUtils.m11405a(WiFiTokenGetterFragment.class);

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_wifi_qr_info, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setVisibility(4);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseQRCodeFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m11174a();
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseQRCodeFragment, com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return "";
    }

    @OnClick
    public void onCloseClick(View view) {
        mo10346h();
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment
    @OnClick
    public void onBtnHelpClick(View view) {
        ((BaseActivity) getActivity()).m10193c(WiFiHelpFragment.class, null);
    }

    @OnClick
    public void onBtnContinueClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        bundle.putSerializable(TokenContainer.class.getSimpleName(), this.f11326n);
        ((BaseActivity) getActivity()).m10193c(WiFiQRCodeFragment.class, bundle);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseQRCodeFragment
    /* JADX INFO: renamed from: s */
    protected void mo11177s() {
        if (m10342d()) {
            m11176r();
            if (this.f11325m.size() > 1) {
                getView().setVisibility(0);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
            bundle.putSerializable(TokenContainer.class.getSimpleName(), this.f11326n);
            ((BaseActivity) getActivity()).m10187a(WiFiQRCodeFragment.class, bundle);
        }
    }
}
