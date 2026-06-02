package com.salesforce.android.knowledge.p022ui.internal.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class KnowledgeRecyclerView extends RecyclerView {
    public KnowledgeRecyclerView(Context context) {
        super(context);
    }

    public KnowledgeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KnowledgeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() { // from class: com.salesforce.android.knowledge.ui.internal.views.KnowledgeRecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                KnowledgeRecyclerView.this.requestLayout();
            }
        });
    }
}
