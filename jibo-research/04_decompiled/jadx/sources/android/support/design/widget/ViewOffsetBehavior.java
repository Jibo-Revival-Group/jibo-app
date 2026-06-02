package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a */
    private ViewOffsetHelper f970a;

    /* JADX INFO: renamed from: b */
    private int f971b;

    /* JADX INFO: renamed from: c */
    private int f972c;

    public ViewOffsetBehavior() {
        this.f971b = 0;
        this.f972c = 0;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f971b = 0;
        this.f972c = 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo455a(CoordinatorLayout coordinatorLayout, V v, int i) {
        mo782b(coordinatorLayout, v, i);
        if (this.f970a == null) {
            this.f970a = new ViewOffsetHelper(v);
        }
        this.f970a.m942a();
        if (this.f971b != 0) {
            this.f970a.m943a(this.f971b);
            this.f971b = 0;
        }
        if (this.f972c != 0) {
            this.f970a.m945b(this.f972c);
            this.f972c = 0;
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    protected void mo782b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.m653a(v, i);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo450a(int i) {
        if (this.f970a != null) {
            return this.f970a.m943a(i);
        }
        this.f971b = i;
        return false;
    }

    /* JADX INFO: renamed from: b */
    public int mo458b() {
        if (this.f970a != null) {
            return this.f970a.m944b();
        }
        return 0;
    }
}
