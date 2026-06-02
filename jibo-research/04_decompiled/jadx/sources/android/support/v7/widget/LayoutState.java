package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class LayoutState {

    /* JADX INFO: renamed from: b */
    int f3932b;

    /* JADX INFO: renamed from: c */
    int f3933c;

    /* JADX INFO: renamed from: d */
    int f3934d;

    /* JADX INFO: renamed from: e */
    int f3935e;

    /* JADX INFO: renamed from: h */
    boolean f3938h;

    /* JADX INFO: renamed from: i */
    boolean f3939i;

    /* JADX INFO: renamed from: a */
    boolean f3931a = true;

    /* JADX INFO: renamed from: f */
    int f3936f = 0;

    /* JADX INFO: renamed from: g */
    int f3937g = 0;

    LayoutState() {
    }

    /* JADX INFO: renamed from: a */
    boolean m4239a(RecyclerView.State state) {
        return this.f3933c >= 0 && this.f3933c < state.m4662e();
    }

    /* JADX INFO: renamed from: a */
    View m4238a(RecyclerView.Recycler recycler) {
        View viewM4614c = recycler.m4614c(this.f3933c);
        this.f3933c += this.f3934d;
        return viewM4614c;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f3932b + ", mCurrentPosition=" + this.f3933c + ", mItemDirection=" + this.f3934d + ", mLayoutDirection=" + this.f3935e + ", mStartLine=" + this.f3936f + ", mEndLine=" + this.f3937g + '}';
    }
}
