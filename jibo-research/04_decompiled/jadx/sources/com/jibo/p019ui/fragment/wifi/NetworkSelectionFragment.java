package com.jibo.p019ui.fragment.wifi;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.utils.LogUtils;
import com.jibo.utils.Util;

/* JADX INFO: loaded from: classes.dex */
public class NetworkSelectionFragment extends WiFiBaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f11250a = LogUtils.m11405a(NetworkSelectionFragment.class);

    @BindView
    TextView btnSelectCurrentNetwork;

    @BindView
    ViewGroup cntNetworkOn;

    @BindView
    ViewGroup cntNoNetwork;

    @BindView
    TextView textStep2Message;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_wifi_network_selection, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m11132q();
        f11313e.clear();
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_wifi_network);
    }

    @OnClick
    public void onEnterNetworkManually(View view) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        ((BaseActivity) getActivity()).m10193c(NetworkNameFragment.class, bundle);
    }

    @OnClick
    public void onSelectCurrentNetwork(View view) {
        f11313e.putString("ARG_SSID", m11131a());
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        ((BaseActivity) getActivity()).m10193c(NetworkPwdFragment.class, bundle);
    }

    @OnClick
    public void onSelectOtherNetwork(View view) {
        startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), 1000);
    }

    @OnClick
    public void onShowMacFilteringInfo(View view) {
        ((BaseActivity) getActivity()).m10193c(MacAddressFragment.class, null);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1000:
                m11132q();
                break;
            default:
                super.onActivityResult(i, i2, intent);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private String m11131a() {
        WifiManager wifiManager = (WifiManager) getActivity().getApplicationContext().getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService("connectivity");
        return (!wifiManager.isWifiEnabled() || connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID()) || connectionInfo.getSSID().equals("0x") || "<unknown ssid>".equals(connectionInfo.getSSID()) || connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnected() || !connectivityManager.getActiveNetworkInfo().isAvailable()) ? "" : Util.m11489a(connectionInfo.getSSID());
    }

    /* JADX INFO: renamed from: q */
    private void m11132q() {
        try {
            String strM11131a = m11131a();
            this.cntNoNetwork.setVisibility(TextUtils.isEmpty(strM11131a) ? 0 : 8);
            this.cntNetworkOn.setVisibility(TextUtils.isEmpty(strM11131a) ? 8 : 0);
            this.textStep2Message.setText(Html.fromHtml(String.format(getString(R.string.label_you_currently_connected_to), strM11131a)));
            this.btnSelectCurrentNetwork.setText(Html.fromHtml(String.format(getString(R.string.yes_use_network), strM11131a)));
        } catch (Exception e) {
        }
    }
}
