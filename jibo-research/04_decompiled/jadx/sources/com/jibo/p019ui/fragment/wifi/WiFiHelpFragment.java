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
public class WiFiHelpFragment extends WiFiHelpAbstractFragment {

    /* JADX INFO: renamed from: a */
    public static final String f11368a = LogUtils.m11405a(WiFiHelpFragment.class);

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
        return layoutInflater.inflate(R.layout.fragment_wifi_help, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_wifi_help_screen);
    }

    @OnClick
    public void btnWiFiError1Click(View view) {
        ((BaseActivity) getActivity()).m10193c(WiFiError1Fragment.class, null);
    }

    @OnClick
    public void btnWiFiError2Click(View view) {
        ((BaseActivity) getActivity()).m10193c(WiFiError2Fragment.class, null);
    }

    @OnClick
    public void btnWiFiError3Click(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.support_different_error_msg))));
    }

    @OnClick
    public void btnWiFiError4Click(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.support_faq_qrccode_problem_url))));
    }
}
