package com.jibo.p019ui.fragment.wifi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.jibo.R;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
abstract class WiFiHelpAbstractFragment extends WiFiBaseFragment {

    /* JADX INFO: renamed from: l */
    public static final String f11367l = LogUtils.m11405a(WiFiHelpAbstractFragment.class);

    WiFiHelpAbstractFragment() {
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setHomeAsUpIndicator(R.drawable.arrow_white);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_action_help, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.findItem(R.id.action_help).setTitle(getString(R.string.menu_support));
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_help != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.support_url))));
        return true;
    }
}
