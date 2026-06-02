package com.jibo.p019ui.fragment.wifi;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class MacAddressFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private MacAddressFragment f11235b;

    /* JADX INFO: renamed from: c */
    private View f11236c;

    public MacAddressFragment_ViewBinding(final MacAddressFragment macAddressFragment, View view) {
        super(macAddressFragment, view);
        this.f11235b = macAddressFragment;
        View viewM5158a = Utils.m5158a(view, R.id.btnRestartSetup, "method 'btnRestartSetup'");
        this.f11236c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.MacAddressFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                macAddressFragment.btnRestartSetup(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        if (this.f11235b == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11235b = null;
        this.f11236c.setOnClickListener(null);
        this.f11236c = null;
        super.unbind();
    }
}
