package com.jibo.p019ui.fragment.wifi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.OnClick;
import com.jibo.R;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class MacAddressFragment extends WiFiBaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f11234a = LogUtils.m11405a(MacAddressFragment.class);

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_wifi_support_mac, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_mac_address_filtering);
    }

    @OnClick
    public void btnRestartSetup(View view) {
        getActivity().getSupportFragmentManager().mo1475a(NetworkSelectionFragment.f11250a, 0);
    }
}
