package com.jibo.p019ui.fragment.wifi;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class WiFiHelpFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private WiFiHelpFragment f11369b;

    /* JADX INFO: renamed from: c */
    private View f11370c;

    /* JADX INFO: renamed from: d */
    private View f11371d;

    /* JADX INFO: renamed from: e */
    private View f11372e;

    /* JADX INFO: renamed from: f */
    private View f11373f;

    public WiFiHelpFragment_ViewBinding(final WiFiHelpFragment wiFiHelpFragment, View view) {
        super(wiFiHelpFragment, view);
        this.f11369b = wiFiHelpFragment;
        View viewM5158a = Utils.m5158a(view, R.id.btnWiFiError1, "method 'btnWiFiError1Click'");
        this.f11370c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiHelpFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiHelpFragment.btnWiFiError1Click(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnWiFiError2, "method 'btnWiFiError2Click'");
        this.f11371d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiHelpFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiHelpFragment.btnWiFiError2Click(view2);
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.btnWiFiError3, "method 'btnWiFiError3Click'");
        this.f11372e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiHelpFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiHelpFragment.btnWiFiError3Click(view2);
            }
        });
        View viewM5158a4 = Utils.m5158a(view, R.id.btnWiFiError4, "method 'btnWiFiError4Click'");
        this.f11373f = viewM5158a4;
        viewM5158a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiHelpFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiHelpFragment.btnWiFiError4Click(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        if (this.f11369b == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11369b = null;
        this.f11370c.setOnClickListener(null);
        this.f11370c = null;
        this.f11371d.setOnClickListener(null);
        this.f11371d = null;
        this.f11372e.setOnClickListener(null);
        this.f11372e = null;
        this.f11373f.setOnClickListener(null);
        this.f11373f = null;
        super.unbind();
    }
}
