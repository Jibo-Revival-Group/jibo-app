package com.jibo.p019ui.fragment.wifi;

import android.R;
import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class WiFiTokenGetterFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private WiFiTokenGetterFragment f11422b;

    /* JADX INFO: renamed from: c */
    private View f11423c;

    /* JADX INFO: renamed from: d */
    private View f11424d;

    /* JADX INFO: renamed from: e */
    private View f11425e;

    public WiFiTokenGetterFragment_ViewBinding(final WiFiTokenGetterFragment wiFiTokenGetterFragment, View view) {
        super(wiFiTokenGetterFragment, view);
        this.f11422b = wiFiTokenGetterFragment;
        View viewM5158a = Utils.m5158a(view, R.id.closeButton, "method 'onCloseClick'");
        this.f11423c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiTokenGetterFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiTokenGetterFragment.onCloseClick(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, com.jibo.R.id.btnHelp, "method 'onBtnHelpClick'");
        this.f11424d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiTokenGetterFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiTokenGetterFragment.onBtnHelpClick(view2);
            }
        });
        View viewM5158a3 = Utils.m5158a(view, com.jibo.R.id.btnContinue, "method 'onBtnContinueClick'");
        this.f11425e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiTokenGetterFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiTokenGetterFragment.onBtnContinueClick(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        if (this.f11422b == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11422b = null;
        this.f11423c.setOnClickListener(null);
        this.f11423c = null;
        this.f11424d.setOnClickListener(null);
        this.f11424d = null;
        this.f11425e.setOnClickListener(null);
        this.f11425e = null;
        super.unbind();
    }
}
