package com.salesforce.android.knowledge.p022ui.internal.util;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class InfiniteScrollListener extends ScrollPositionListener {

    /* JADX INFO: renamed from: a */
    private final LinearLayoutManager f13426a;

    /* JADX INFO: renamed from: b */
    private BehaviorListener f13427b;

    /* JADX INFO: renamed from: c */
    private int f13428c;

    /* JADX INFO: renamed from: d */
    private boolean f13429d = true;

    public interface BehaviorListener {
        /* JADX INFO: renamed from: s_ */
        void mo13478s_();
    }

    /* JADX INFO: renamed from: a */
    public static InfiniteScrollListener m13699a(LinearLayoutManager linearLayoutManager) {
        return new InfiniteScrollListener(linearLayoutManager);
    }

    private InfiniteScrollListener(LinearLayoutManager linearLayoutManager) {
        this.f13426a = linearLayoutManager;
    }

    /* JADX INFO: renamed from: a */
    public InfiniteScrollListener m13703a(BehaviorListener behaviorListener) {
        this.f13427b = behaviorListener;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public InfiniteScrollListener m13702a(int i) {
        this.f13428c = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m13704a(boolean z) {
        this.f13429d = z;
    }

    /* JADX INFO: renamed from: a */
    public LinearLayoutManager m13701a() {
        return this.f13426a;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.util.ScrollPositionListener, android.support.v7.widget.RecyclerView.OnScrollListener
    /* JADX INFO: renamed from: a */
    public void mo4164a(RecyclerView recyclerView, int i, int i2) {
        super.mo4164a(recyclerView, i, i2);
        if (this.f13427b != null && this.f13429d) {
            boolean zM13700a = m13700a(i, i2);
            int iM4325m = this.f13426a.m4325m() + recyclerView.getChildCount();
            int iF = (this.f13426a.m4479F() - 1) - this.f13428c;
            if (zM13700a && iM4325m > iF) {
                this.f13427b.mo13478s_();
                this.f13429d = false;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m13700a(int i, int i2) {
        return this.f13426a.mo4316f() ? i2 > 0 : i > 0;
    }
}
