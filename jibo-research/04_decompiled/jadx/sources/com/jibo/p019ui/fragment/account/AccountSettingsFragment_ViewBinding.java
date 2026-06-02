package com.jibo.p019ui.fragment.account;

import android.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class AccountSettingsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private AccountSettingsFragment f10046b;

    public AccountSettingsFragment_ViewBinding(AccountSettingsFragment accountSettingsFragment, View view) {
        this.f10046b = accountSettingsFragment;
        accountSettingsFragment.list = (RecyclerView) Utils.m5161b(view, R.id.list, "field 'list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AccountSettingsFragment accountSettingsFragment = this.f10046b;
        if (accountSettingsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10046b = null;
        accountSettingsFragment.list = null;
    }
}
