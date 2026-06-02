package com.jibo.p019ui.fragment.wifi;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class WiFiError1Fragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private WiFiError1Fragment f11349b;

    /* JADX INFO: renamed from: c */
    private View f11350c;

    /* JADX INFO: renamed from: d */
    private View f11351d;

    public WiFiError1Fragment_ViewBinding(final WiFiError1Fragment wiFiError1Fragment, View view) {
        super(wiFiError1Fragment, view);
        this.f11349b = wiFiError1Fragment;
        wiFiError1Fragment.editSSID = (EditText) Utils.m5161b(view, R.id.editSSID, "field 'editSSID'", EditText.class);
        wiFiError1Fragment.editPassword = (EditText) Utils.m5161b(view, R.id.editPassword, "field 'editPassword'", EditText.class);
        wiFiError1Fragment.txtPasswordHint = (TextView) Utils.m5161b(view, R.id.txtPasswordHint, "field 'txtPasswordHint'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnTryAgain, "field 'btnTryAgain' and method 'btnTryAgainClick'");
        wiFiError1Fragment.btnTryAgain = (TextView) Utils.m5162c(viewM5158a, R.id.btnTryAgain, "field 'btnTryAgain'", TextView.class);
        this.f11350c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiError1Fragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiError1Fragment.btnTryAgainClick(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnSupport, "method 'btnSupportClick'");
        this.f11351d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiError1Fragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiError1Fragment.btnSupportClick(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        WiFiError1Fragment wiFiError1Fragment = this.f11349b;
        if (wiFiError1Fragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11349b = null;
        wiFiError1Fragment.editSSID = null;
        wiFiError1Fragment.editPassword = null;
        wiFiError1Fragment.txtPasswordHint = null;
        wiFiError1Fragment.btnTryAgain = null;
        this.f11350c.setOnClickListener(null);
        this.f11350c = null;
        this.f11351d.setOnClickListener(null);
        this.f11351d = null;
        super.unbind();
    }
}
