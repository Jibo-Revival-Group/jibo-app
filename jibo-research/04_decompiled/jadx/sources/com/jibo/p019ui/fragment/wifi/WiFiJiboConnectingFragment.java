package com.jibo.p019ui.fragment.wifi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.OnClick;
import com.jibo.R;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class WiFiJiboConnectingFragment extends WiFiBaseQRCodeFragment {

    /* JADX INFO: renamed from: p */
    public static final String f11382p = LogUtils.m11405a(WiFiJiboConnectingFragment.class);

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_wifi_jibo_connecting, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseQRCodeFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m11175q();
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseQRCodeFragment, com.jibo.p019ui.fragment.BaseFragment, com.jibo.p019ui.fragment.IBaseFragment
    /* JADX INFO: renamed from: h */
    public boolean mo10346h() {
        getActivity().getSupportFragmentManager().mo1475a(WiFiQRCodeFragment.class.getSimpleName(), 1);
        return true;
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
    public void onBtnNoScreenClick(View view) {
        mo10346h();
    }

    @OnClick
    public void onBtnEditWifiClick(View view) {
        getActivity().getSupportFragmentManager().mo1475a(WaitForTapFragment.class.getSimpleName(), 1);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseQRCodeFragment
    /* JADX INFO: renamed from: s */
    protected void mo11177s() {
    }
}
