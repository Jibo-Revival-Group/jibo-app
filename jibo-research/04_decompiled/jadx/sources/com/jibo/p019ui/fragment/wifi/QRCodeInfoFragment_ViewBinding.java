package com.jibo.p019ui.fragment.wifi;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class QRCodeInfoFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private QRCodeInfoFragment f11270b;

    /* JADX INFO: renamed from: c */
    private View f11271c;

    public QRCodeInfoFragment_ViewBinding(final QRCodeInfoFragment qRCodeInfoFragment, View view) {
        super(qRCodeInfoFragment, view);
        this.f11270b = qRCodeInfoFragment;
        View viewM5158a = Utils.m5158a(view, R.id.btnContinue, "method 'onContinue'");
        this.f11271c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.QRCodeInfoFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                qRCodeInfoFragment.onContinue(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        if (this.f11270b == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11270b = null;
        this.f11271c.setOnClickListener(null);
        this.f11271c = null;
        super.unbind();
    }
}
