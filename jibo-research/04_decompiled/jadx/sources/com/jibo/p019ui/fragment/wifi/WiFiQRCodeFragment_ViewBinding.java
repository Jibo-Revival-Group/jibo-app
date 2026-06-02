package com.jibo.p019ui.fragment.wifi;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class WiFiQRCodeFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private WiFiQRCodeFragment f11398b;

    /* JADX INFO: renamed from: c */
    private View f11399c;

    /* JADX INFO: renamed from: d */
    private View f11400d;

    /* JADX INFO: renamed from: e */
    private View f11401e;

    /* JADX INFO: renamed from: f */
    private View f11402f;

    /* JADX INFO: renamed from: g */
    private View f11403g;

    public WiFiQRCodeFragment_ViewBinding(final WiFiQRCodeFragment wiFiQRCodeFragment, View view) {
        super(wiFiQRCodeFragment, view);
        this.f11398b = wiFiQRCodeFragment;
        wiFiQRCodeFragment.singleCodeToolbar = Utils.m5158a(view, R.id.singleCodeToolbar, "field 'singleCodeToolbar'");
        wiFiQRCodeFragment.multiCodeToolbar = Utils.m5158a(view, R.id.multiCodeToolbar, "field 'multiCodeToolbar'");
        wiFiQRCodeFragment.txtSingleCodeTitle = Utils.m5158a(view, R.id.txtSingleCodeTitle, "field 'txtSingleCodeTitle'");
        View viewM5158a = Utils.m5158a(view, R.id.btnPrevCode, "field 'btnPrevCode' and method 'onBtnPrevCodeClick'");
        wiFiQRCodeFragment.btnPrevCode = (TextView) Utils.m5162c(viewM5158a, R.id.btnPrevCode, "field 'btnPrevCode'", TextView.class);
        this.f11399c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiQRCodeFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiQRCodeFragment.onBtnPrevCodeClick(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnNextCode, "field 'btnNextCode' and method 'onBtnNextCodeClick'");
        wiFiQRCodeFragment.btnNextCode = (TextView) Utils.m5162c(viewM5158a2, R.id.btnNextCode, "field 'btnNextCode'", TextView.class);
        this.f11400d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiQRCodeFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiQRCodeFragment.onBtnNextCodeClick(view2);
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.btnDone, "field 'btnDone' and method 'onBtnDoneClick'");
        wiFiQRCodeFragment.btnDone = (ImageView) Utils.m5162c(viewM5158a3, R.id.btnDone, "field 'btnDone'", ImageView.class);
        this.f11401e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiQRCodeFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiQRCodeFragment.onBtnDoneClick(view2);
            }
        });
        View viewM5158a4 = Utils.m5158a(view, R.id.btnDone1, "field 'btnDone1' and method 'onBtnDoneClick'");
        wiFiQRCodeFragment.btnDone1 = (ImageView) Utils.m5162c(viewM5158a4, R.id.btnDone1, "field 'btnDone1'", ImageView.class);
        this.f11402f = viewM5158a4;
        viewM5158a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiQRCodeFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiQRCodeFragment.onBtnDoneClick(view2);
            }
        });
        wiFiQRCodeFragment.txtProgress = (TextView) Utils.m5161b(view, android.R.id.progress, "field 'txtProgress'", TextView.class);
        wiFiQRCodeFragment.buttonsPanel = Utils.m5158a(view, R.id.buttonsPanel, "field 'buttonsPanel'");
        wiFiQRCodeFragment.brightnessPanel = Utils.m5158a(view, R.id.brightness_panel, "field 'brightnessPanel'");
        wiFiQRCodeFragment.brightnessSeekbar = (SeekBar) Utils.m5161b(view, R.id.brightnessSeekbar, "field 'brightnessSeekbar'", SeekBar.class);
        wiFiQRCodeFragment.brightnessLess = Utils.m5158a(view, R.id.brightness_less, "field 'brightnessLess'");
        wiFiQRCodeFragment.brightnessMore = Utils.m5158a(view, R.id.brightness_more, "field 'brightnessMore'");
        View viewM5158a5 = Utils.m5158a(view, android.R.id.closeButton, "method 'onCloseClick'");
        this.f11403g = viewM5158a5;
        viewM5158a5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiQRCodeFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                wiFiQRCodeFragment.onCloseClick();
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        WiFiQRCodeFragment wiFiQRCodeFragment = this.f11398b;
        if (wiFiQRCodeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11398b = null;
        wiFiQRCodeFragment.singleCodeToolbar = null;
        wiFiQRCodeFragment.multiCodeToolbar = null;
        wiFiQRCodeFragment.txtSingleCodeTitle = null;
        wiFiQRCodeFragment.btnPrevCode = null;
        wiFiQRCodeFragment.btnNextCode = null;
        wiFiQRCodeFragment.btnDone = null;
        wiFiQRCodeFragment.btnDone1 = null;
        wiFiQRCodeFragment.txtProgress = null;
        wiFiQRCodeFragment.buttonsPanel = null;
        wiFiQRCodeFragment.brightnessPanel = null;
        wiFiQRCodeFragment.brightnessSeekbar = null;
        wiFiQRCodeFragment.brightnessLess = null;
        wiFiQRCodeFragment.brightnessMore = null;
        this.f11399c.setOnClickListener(null);
        this.f11399c = null;
        this.f11400d.setOnClickListener(null);
        this.f11400d = null;
        this.f11401e.setOnClickListener(null);
        this.f11401e = null;
        this.f11402f.setOnClickListener(null);
        this.f11402f = null;
        this.f11403g.setOnClickListener(null);
        this.f11403g = null;
        super.unbind();
    }
}
