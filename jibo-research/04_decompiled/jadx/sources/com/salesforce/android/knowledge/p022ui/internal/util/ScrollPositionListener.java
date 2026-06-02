package com.salesforce.android.knowledge.p022ui.internal.util;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class ScrollPositionListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a */
    private int f13432a = 0;

    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
    /* JADX INFO: renamed from: a */
    public void mo4164a(RecyclerView recyclerView, int i, int i2) {
        super.mo4164a(recyclerView, i, i2);
        this.f13432a += i2;
    }

    /* JADX INFO: renamed from: a */
    public void m13708a(Bundle bundle) {
        bundle.putInt("scroll_position_y_state", this.f13432a);
    }

    /* JADX INFO: renamed from: b */
    public void m13710b(Bundle bundle) {
        this.f13432a = bundle.getInt("scroll_position_y_state");
    }

    /* JADX INFO: renamed from: b */
    public int m13709b() {
        return this.f13432a;
    }
}
