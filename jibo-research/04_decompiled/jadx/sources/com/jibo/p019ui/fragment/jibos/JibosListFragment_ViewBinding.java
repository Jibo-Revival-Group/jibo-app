package com.jibo.p019ui.fragment.jibos;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class JibosListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private JibosListFragment f10608b;

    /* JADX INFO: renamed from: c */
    private View f10609c;

    /* JADX INFO: renamed from: d */
    private View f10610d;

    /* JADX INFO: renamed from: e */
    private View f10611e;

    public JibosListFragment_ViewBinding(final JibosListFragment jibosListFragment, View view) {
        this.f10608b = jibosListFragment;
        jibosListFragment.swipeRefreshLayout = (SwipeRefreshLayout) Utils.m5161b(view, R.id.swipeRefreshLayout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
        jibosListFragment.list = (RecyclerView) Utils.m5161b(view, android.R.id.list, "field 'list'", RecyclerView.class);
        jibosListFragment.emptyView = Utils.m5158a(view, android.R.id.empty, "field 'emptyView'");
        View viewM5158a = Utils.m5158a(view, R.id.newFAB, "field 'fab' and method 'setUpNewJibo'");
        jibosListFragment.fab = viewM5158a;
        this.f10609c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.jibos.JibosListFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                jibosListFragment.setUpNewJibo(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnConnectJiboWifi, "method 'onConnectWifi'");
        this.f10610d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.jibos.JibosListFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                jibosListFragment.onConnectWifi(view2);
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.btnInviteInfo, "method 'onInviteInfo'");
        this.f10611e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.jibos.JibosListFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                jibosListFragment.onInviteInfo(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        JibosListFragment jibosListFragment = this.f10608b;
        if (jibosListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10608b = null;
        jibosListFragment.swipeRefreshLayout = null;
        jibosListFragment.list = null;
        jibosListFragment.emptyView = null;
        jibosListFragment.fab = null;
        this.f10609c.setOnClickListener(null);
        this.f10609c = null;
        this.f10610d.setOnClickListener(null);
        this.f10610d = null;
        this.f10611e.setOnClickListener(null);
        this.f10611e = null;
    }
}
