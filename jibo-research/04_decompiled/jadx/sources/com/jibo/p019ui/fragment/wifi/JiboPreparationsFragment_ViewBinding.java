package com.jibo.p019ui.fragment.wifi;

import android.R;
import android.view.View;
import android.widget.ImageView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class JiboPreparationsFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private JiboPreparationsFragment f11218b;

    /* JADX INFO: renamed from: c */
    private View f11219c;

    /* JADX INFO: renamed from: d */
    private View f11220d;

    /* JADX INFO: renamed from: e */
    private View f11221e;

    /* JADX INFO: renamed from: f */
    private View f11222f;

    /* JADX INFO: renamed from: g */
    private View f11223g;

    public JiboPreparationsFragment_ViewBinding(final JiboPreparationsFragment jiboPreparationsFragment, View view) {
        super(jiboPreparationsFragment, view);
        this.f11218b = jiboPreparationsFragment;
        View viewM5158a = Utils.m5158a(view, R.id.closeButton, "field 'closeButton' and method 'onCloseClick'");
        jiboPreparationsFragment.closeButton = (ImageView) Utils.m5162c(viewM5158a, R.id.closeButton, "field 'closeButton'", ImageView.class);
        this.f11219c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.JiboPreparationsFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                jiboPreparationsFragment.onCloseClick(view2);
            }
        });
        jiboPreparationsFragment.progressView = Utils.m5158a(view, R.id.progress, "field 'progressView'");
        jiboPreparationsFragment.checkmarkImage = (ImageView) Utils.m5161b(view, R.id.icon, "field 'checkmarkImage'", ImageView.class);
        View viewM5158a2 = Utils.m5158a(view, com.jibo.R.id.btnCoverRemoved, "method 'btnNextScreenClick'");
        this.f11220d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.JiboPreparationsFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                jiboPreparationsFragment.btnNextScreenClick(view2);
            }
        });
        View viewM5158a3 = Utils.m5158a(view, com.jibo.R.id.btnPluggedIn, "method 'btnNextScreenClick'");
        this.f11221e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.JiboPreparationsFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                jiboPreparationsFragment.btnNextScreenClick(view2);
            }
        });
        View viewM5158a4 = Utils.m5158a(view, com.jibo.R.id.btnPoweredUp, "method 'btnNextScreenClick'");
        this.f11222f = viewM5158a4;
        viewM5158a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.JiboPreparationsFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                jiboPreparationsFragment.btnNextScreenClick(view2);
            }
        });
        View viewM5158a5 = Utils.m5158a(view, com.jibo.R.id.btnImReady, "method 'btnNextScreenClick'");
        this.f11223g = viewM5158a5;
        viewM5158a5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.JiboPreparationsFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                jiboPreparationsFragment.btnNextScreenClick(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        JiboPreparationsFragment jiboPreparationsFragment = this.f11218b;
        if (jiboPreparationsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11218b = null;
        jiboPreparationsFragment.closeButton = null;
        jiboPreparationsFragment.progressView = null;
        jiboPreparationsFragment.checkmarkImage = null;
        this.f11219c.setOnClickListener(null);
        this.f11219c = null;
        this.f11220d.setOnClickListener(null);
        this.f11220d = null;
        this.f11221e.setOnClickListener(null);
        this.f11221e = null;
        this.f11222f.setOnClickListener(null);
        this.f11222f = null;
        this.f11223g.setOnClickListener(null);
        this.f11223g = null;
        super.unbind();
    }
}
