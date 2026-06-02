package com.jibo.p019ui.fragment.wifi;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class WiFiJiboConnectingFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private WiFiJiboConnectingFragment f11383b;

    /* JADX INFO: renamed from: c */
    private View f11384c;

    /* JADX INFO: renamed from: d */
    private View f11385d;

    public WiFiJiboConnectingFragment_ViewBinding(final WiFiJiboConnectingFragment wiFiJiboConnectingFragment, View view) {
        super(wiFiJiboConnectingFragment, view);
        this.f11383b = wiFiJiboConnectingFragment;
        View viewM5158a = Utils.m5158a(view, R.id.btnNoScreen, "method 'onBtnNoScreenClick'");
        this.f11384c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiJiboConnectingFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiJiboConnectingFragment.onBtnNoScreenClick(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnEditWifi, "method 'onBtnEditWifiClick'");
        this.f11385d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiJiboConnectingFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiJiboConnectingFragment.onBtnEditWifiClick(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        if (this.f11383b == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11383b = null;
        this.f11384c.setOnClickListener(null);
        this.f11384c = null;
        this.f11385d.setOnClickListener(null);
        this.f11385d = null;
        super.unbind();
    }
}
