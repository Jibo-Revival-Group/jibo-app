package com.jibo.p019ui.fragment.wifi;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.jibo.R;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
abstract class WiFiValidatedFragment extends WiFiBaseFragment {

    /* JADX INFO: renamed from: c */
    public static final String f11432c = LogUtils.m11405a(WiFiValidatedFragment.class);

    /* JADX INFO: renamed from: a */
    protected abstract void mo11125a();

    /* JADX INFO: renamed from: a */
    protected abstract void mo11126a(MenuItem menuItem);

    WiFiValidatedFragment() {
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_action_done, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
        ImageUtils.m11393a(getActivity(), menu);
        mo11126a(menu.findItem(R.id.action_done));
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_done != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        mo11125a();
        return true;
    }
}
