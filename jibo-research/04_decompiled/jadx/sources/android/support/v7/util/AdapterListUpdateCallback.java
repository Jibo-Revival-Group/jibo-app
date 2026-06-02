package android.support.v7.util;

import android.support.v7.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {

    /* JADX INFO: renamed from: a */
    private final RecyclerView.Adapter f3130a;

    public AdapterListUpdateCallback(RecyclerView.Adapter adapter) {
        this.f3130a = adapter;
    }

    @Override // android.support.v7.util.ListUpdateCallback
    /* JADX INFO: renamed from: a */
    public void mo3438a(int i, int i2) {
        this.f3130a.notifyItemRangeInserted(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    /* JADX INFO: renamed from: b */
    public void mo3440b(int i, int i2) {
        this.f3130a.notifyItemRangeRemoved(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    /* JADX INFO: renamed from: c */
    public void mo3441c(int i, int i2) {
        this.f3130a.notifyItemMoved(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    /* JADX INFO: renamed from: a */
    public void mo3439a(int i, int i2, Object obj) {
        this.f3130a.notifyItemRangeChanged(i, i2, obj);
    }
}
