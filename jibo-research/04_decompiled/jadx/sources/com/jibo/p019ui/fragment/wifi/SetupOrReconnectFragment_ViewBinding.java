package com.jibo.p019ui.fragment.wifi;

import android.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class SetupOrReconnectFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private SetupOrReconnectFragment f11295b;

    public SetupOrReconnectFragment_ViewBinding(SetupOrReconnectFragment setupOrReconnectFragment, View view) {
        super(setupOrReconnectFragment, view);
        this.f11295b = setupOrReconnectFragment;
        setupOrReconnectFragment.list = (RecyclerView) Utils.m5161b(view, R.id.list, "field 'list'", RecyclerView.class);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        SetupOrReconnectFragment setupOrReconnectFragment = this.f11295b;
        if (setupOrReconnectFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11295b = null;
        setupOrReconnectFragment.list = null;
        super.unbind();
    }
}
