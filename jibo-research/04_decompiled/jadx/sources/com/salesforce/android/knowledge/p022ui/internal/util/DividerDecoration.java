package com.salesforce.android.knowledge.p022ui.internal.util;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class DividerDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a */
    private final Drawable f13420a;

    public DividerDecoration(Drawable drawable) {
        this.f13420a = drawable;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    /* JADX INFO: renamed from: a */
    public void mo4460a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.mo4460a(rect, view, recyclerView, state);
        rect.top = this.f13420a.getIntrinsicHeight();
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    /* JADX INFO: renamed from: b */
    public void mo4462b(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int width = recyclerView.getWidth();
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            View childAt = recyclerView.getChildAt(i);
            int top = childAt.getTop() - ((RecyclerView.LayoutParams) childAt.getLayoutParams()).topMargin;
            this.f13420a.setBounds(0, top - this.f13420a.getIntrinsicHeight(), width, top);
            this.f13420a.draw(canvas);
        }
    }
}
