package com.jibo.p019ui.fragment.wifi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.OnClick;
import com.jibo.R;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class WiFiError2Fragment extends WiFiHelpAbstractFragment {

    /* JADX INFO: renamed from: a */
    public static final String f11356a = LogUtils.m11405a(WiFiError2Fragment.class);

    @Override // com.jibo.p019ui.fragment.wifi.WiFiHelpAbstractFragment, android.support.v4.app.Fragment
    public /* bridge */ /* synthetic */ void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiHelpAbstractFragment, android.support.v4.app.Fragment
    public /* bridge */ /* synthetic */ boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_wifi_error2, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_wifi_error2_screen);
    }

    @OnClick
    public void btnSetupStaticClick(View view) {
        ((BaseActivity) getActivity()).m10193c(NetworkPwdFragment.class, null);
    }

    @OnClick
    public void btnMacFilteringClick(View view) {
        ((BaseActivity) getActivity()).m10193c(MacAddressFragment.class, null);
    }

    @OnClick
    public void btnSupportClick(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.support_faq_error2_url))));
    }
}
