package com.jibo.p019ui.fragment.jibos;

import android.R;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class NoLoopsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private NoLoopsFragment f10618b;

    /* JADX INFO: renamed from: c */
    private View f10619c;

    /* JADX INFO: renamed from: d */
    private View f10620d;

    public NoLoopsFragment_ViewBinding(final NoLoopsFragment noLoopsFragment, View view) {
        this.f10618b = noLoopsFragment;
        noLoopsFragment.icon = Utils.m5158a(view, R.id.icon, "field 'icon'");
        View viewM5158a = Utils.m5158a(view, com.jibo.R.id.btnConnectJiboWifi, "method 'onConnectWifi'");
        this.f10619c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.jibos.NoLoopsFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                noLoopsFragment.onConnectWifi(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, com.jibo.R.id.btnInviteInfo, "method 'onInviteInfo'");
        this.f10620d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.jibos.NoLoopsFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                noLoopsFragment.onInviteInfo(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NoLoopsFragment noLoopsFragment = this.f10618b;
        if (noLoopsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10618b = null;
        noLoopsFragment.icon = null;
        this.f10619c.setOnClickListener(null);
        this.f10619c = null;
        this.f10620d.setOnClickListener(null);
        this.f10620d = null;
    }
}
