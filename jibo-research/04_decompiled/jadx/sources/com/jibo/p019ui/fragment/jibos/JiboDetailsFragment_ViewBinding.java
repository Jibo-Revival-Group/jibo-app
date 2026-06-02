package com.jibo.p019ui.fragment.jibos;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class JiboDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private JiboDetailsFragment f10592b;

    /* JADX INFO: renamed from: c */
    private View f10593c;

    /* JADX INFO: renamed from: d */
    private View f10594d;

    public JiboDetailsFragment_ViewBinding(final JiboDetailsFragment jiboDetailsFragment, View view) {
        this.f10592b = jiboDetailsFragment;
        jiboDetailsFragment.swipeRefreshLayout = (SwipeRefreshLayout) Utils.m5161b(view, R.id.swipeRefreshLayout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
        jiboDetailsFragment.list = (RecyclerView) Utils.m5161b(view, android.R.id.list, "field 'list'", RecyclerView.class);
        jiboDetailsFragment.loopSuspendedView = Utils.m5158a(view, R.id.loop_suspended_view, "field 'loopSuspendedView'");
        View viewM5158a = Utils.m5158a(view, R.id.btnReconnectToJibo, "field 'btnReconnectToJibo' and method 'reconnectToJiboClick'");
        jiboDetailsFragment.btnReconnectToJibo = viewM5158a;
        this.f10593c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                jiboDetailsFragment.reconnectToJiboClick();
            }
        });
        jiboDetailsFragment.tutorialTitleContainer = Utils.m5158a(view, R.id.tutorial_title_container, "field 'tutorialTitleContainer'");
        jiboDetailsFragment.tutorialTitle = (TextView) Utils.m5161b(view, R.id.tutorial_title, "field 'tutorialTitle'", TextView.class);
        View viewM5158a2 = Utils.m5158a(view, R.id.customerCare, "method 'onCustomerCareClick'");
        this.f10594d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.jibos.JiboDetailsFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                jiboDetailsFragment.onCustomerCareClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        JiboDetailsFragment jiboDetailsFragment = this.f10592b;
        if (jiboDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10592b = null;
        jiboDetailsFragment.swipeRefreshLayout = null;
        jiboDetailsFragment.list = null;
        jiboDetailsFragment.loopSuspendedView = null;
        jiboDetailsFragment.btnReconnectToJibo = null;
        jiboDetailsFragment.tutorialTitleContainer = null;
        jiboDetailsFragment.tutorialTitle = null;
        this.f10593c.setOnClickListener(null);
        this.f10593c = null;
        this.f10594d.setOnClickListener(null);
        this.f10594d = null;
    }
}
