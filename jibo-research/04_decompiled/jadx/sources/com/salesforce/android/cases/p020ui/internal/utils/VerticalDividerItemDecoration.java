package com.salesforce.android.cases.p020ui.internal.utils;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class VerticalDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a */
    private Drawable f12866a;

    /* JADX INFO: renamed from: b */
    private int f12867b;

    /* JADX INFO: renamed from: c */
    private int f12868c;

    public VerticalDividerItemDecoration(Drawable drawable, int i, int i2) {
        this.f12866a = drawable;
        this.f12867b = i;
        this.f12868c = i2;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    /* JADX INFO: renamed from: b */
    public void mo4462b(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        m13056c(canvas, recyclerView);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    /* JADX INFO: renamed from: a */
    public void mo4460a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.mo4460a(rect, view, recyclerView, state);
        if (recyclerView.getChildAdapterPosition(view) != 0) {
            rect.top = this.f12866a.getIntrinsicHeight();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m13056c(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < childCount - 1) {
                View childAt = recyclerView.getChildAt(i2);
                int bottom = ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom();
                this.f12866a.setBounds(this.f12867b + paddingLeft, bottom, width - this.f12868c, this.f12866a.getIntrinsicHeight() + bottom);
                this.f12866a.draw(canvas);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
