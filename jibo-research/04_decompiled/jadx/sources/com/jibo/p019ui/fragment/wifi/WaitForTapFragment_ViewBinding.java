package com.jibo.p019ui.fragment.wifi;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class WaitForTapFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private WaitForTapFragment f11305b;

    /* JADX INFO: renamed from: c */
    private View f11306c;

    /* JADX INFO: renamed from: d */
    private View f11307d;

    public WaitForTapFragment_ViewBinding(final WaitForTapFragment waitForTapFragment, View view) {
        super(waitForTapFragment, view);
        this.f11305b = waitForTapFragment;
        View viewM5158a = Utils.m5158a(view, R.id.btnJiboOk, "method 'btnJiboOkClick'");
        this.f11306c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WaitForTapFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                waitForTapFragment.btnJiboOkClick(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnNoScreen, "method 'btnNoScreenClick'");
        this.f11307d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WaitForTapFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                waitForTapFragment.btnNoScreenClick(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        if (this.f11305b == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11305b = null;
        this.f11306c.setOnClickListener(null);
        this.f11306c = null;
        this.f11307d.setOnClickListener(null);
        this.f11307d = null;
        super.unbind();
    }
}
