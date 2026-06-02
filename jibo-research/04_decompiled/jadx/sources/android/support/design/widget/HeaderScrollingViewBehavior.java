package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.math.MathUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* JADX INFO: renamed from: a */
    final Rect f781a;

    /* JADX INFO: renamed from: b */
    final Rect f782b;

    /* JADX INFO: renamed from: c */
    private int f783c;

    /* JADX INFO: renamed from: d */
    private int f784d;

    /* JADX INFO: renamed from: b */
    abstract View mo480b(List<View> list);

    public HeaderScrollingViewBehavior() {
        this.f781a = new Rect();
        this.f782b = new Rect();
        this.f783c = 0;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f781a = new Rect();
        this.f782b = new Rect();
        this.f783c = 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo456a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View viewMo480b;
        int i5 = view.getLayoutParams().height;
        if ((i5 == -1 || i5 == -2) && (viewMo480b = mo480b(coordinatorLayout.m668c(view))) != null) {
            if (ViewCompat.m2614r(viewMo480b) && !ViewCompat.m2614r(view)) {
                ViewCompat.m2595b(view, true);
                if (ViewCompat.m2614r(view)) {
                    view.requestLayout();
                    return true;
                }
            }
            int size = View.MeasureSpec.getSize(i3);
            if (size == 0) {
                size = coordinatorLayout.getHeight();
            }
            coordinatorLayout.m654a(view, i, i2, View.MeasureSpec.makeMeasureSpec(mo479b(viewMo480b) + (size - viewMo480b.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
            return true;
        }
        return false;
    }

    @Override // android.support.design.widget.ViewOffsetBehavior
    /* JADX INFO: renamed from: b */
    protected void mo782b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View viewMo480b = mo480b(coordinatorLayout.m668c(view));
        if (viewMo480b != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.f781a;
            rect.set(coordinatorLayout.getPaddingLeft() + layoutParams.leftMargin, viewMo480b.getBottom() + layoutParams.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - layoutParams.rightMargin, ((coordinatorLayout.getHeight() + viewMo480b.getBottom()) - coordinatorLayout.getPaddingBottom()) - layoutParams.bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.m2614r(coordinatorLayout) && !ViewCompat.m2614r(view)) {
                rect.left += lastWindowInsets.m2768a();
                rect.right -= lastWindowInsets.m2771c();
            }
            Rect rect2 = this.f782b;
            GravityCompat.m2509a(m779c(layoutParams.f697c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int iM783c = m783c(viewMo480b);
            view.layout(rect2.left, rect2.top - iM783c, rect2.right, rect2.bottom - iM783c);
            this.f783c = rect2.top - viewMo480b.getBottom();
            return;
        }
        super.mo782b(coordinatorLayout, view, i);
        this.f783c = 0;
    }

    /* JADX INFO: renamed from: a */
    float mo475a(View view) {
        return 1.0f;
    }

    /* JADX INFO: renamed from: c */
    final int m783c(View view) {
        if (this.f784d == 0) {
            return 0;
        }
        return MathUtils.m2025a((int) (mo475a(view) * this.f784d), 0, this.f784d);
    }

    /* JADX INFO: renamed from: c */
    private static int m779c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    /* JADX INFO: renamed from: b */
    int mo479b(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: renamed from: a */
    final int m780a() {
        return this.f783c;
    }

    /* JADX INFO: renamed from: b */
    public final void m781b(int i) {
        this.f784d = i;
    }

    /* JADX INFO: renamed from: d */
    public final int m784d() {
        return this.f784d;
    }
}
