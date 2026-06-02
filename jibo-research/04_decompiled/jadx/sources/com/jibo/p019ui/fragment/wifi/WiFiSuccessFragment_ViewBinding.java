package com.jibo.p019ui.fragment.wifi;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.p019ui.view.proxima.CustomFontButton;

/* JADX INFO: loaded from: classes.dex */
public class WiFiSuccessFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private WiFiSuccessFragment f11417b;

    /* JADX INFO: renamed from: c */
    private View f11418c;

    public WiFiSuccessFragment_ViewBinding(final WiFiSuccessFragment wiFiSuccessFragment, View view) {
        super(wiFiSuccessFragment, view);
        this.f11417b = wiFiSuccessFragment;
        wiFiSuccessFragment.txtTitle = (TextView) Utils.m5161b(view, R.id.title, "field 'txtTitle'", TextView.class);
        wiFiSuccessFragment.txtInfo = (TextView) Utils.m5161b(view, com.jibo.R.id.txtInfo, "field 'txtInfo'", TextView.class);
        View viewM5158a = Utils.m5158a(view, com.jibo.R.id.btnContinue, "field 'btnContinue' and method 'onBtnContinueClick'");
        wiFiSuccessFragment.btnContinue = (CustomFontButton) Utils.m5162c(viewM5158a, com.jibo.R.id.btnContinue, "field 'btnContinue'", CustomFontButton.class);
        this.f11418c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiSuccessFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiSuccessFragment.onBtnContinueClick(view2);
            }
        });
        wiFiSuccessFragment.jiboImage = (ImageView) Utils.m5161b(view, com.jibo.R.id.jibo_image, "field 'jiboImage'", ImageView.class);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        WiFiSuccessFragment wiFiSuccessFragment = this.f11417b;
        if (wiFiSuccessFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11417b = null;
        wiFiSuccessFragment.txtTitle = null;
        wiFiSuccessFragment.txtInfo = null;
        wiFiSuccessFragment.btnContinue = null;
        wiFiSuccessFragment.jiboImage = null;
        this.f11418c.setOnClickListener(null);
        this.f11418c = null;
        super.unbind();
    }
}
