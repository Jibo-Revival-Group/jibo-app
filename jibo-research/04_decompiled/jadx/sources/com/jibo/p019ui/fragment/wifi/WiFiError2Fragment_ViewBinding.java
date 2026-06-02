package com.jibo.p019ui.fragment.wifi;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class WiFiError2Fragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private WiFiError2Fragment f11357b;

    /* JADX INFO: renamed from: c */
    private View f11358c;

    /* JADX INFO: renamed from: d */
    private View f11359d;

    /* JADX INFO: renamed from: e */
    private View f11360e;

    public WiFiError2Fragment_ViewBinding(final WiFiError2Fragment wiFiError2Fragment, View view) {
        super(wiFiError2Fragment, view);
        this.f11357b = wiFiError2Fragment;
        View viewM5158a = Utils.m5158a(view, R.id.btnSetupStatic, "method 'btnSetupStaticClick'");
        this.f11358c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiError2Fragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiError2Fragment.btnSetupStaticClick(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnMacFiltering, "method 'btnMacFilteringClick'");
        this.f11359d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiError2Fragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiError2Fragment.btnMacFilteringClick(view2);
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.btnSupport, "method 'btnSupportClick'");
        this.f11360e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiError2Fragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiError2Fragment.btnSupportClick(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        if (this.f11357b == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11357b = null;
        this.f11358c.setOnClickListener(null);
        this.f11358c = null;
        this.f11359d.setOnClickListener(null);
        this.f11359d = null;
        this.f11360e.setOnClickListener(null);
        this.f11360e = null;
        super.unbind();
    }
}
