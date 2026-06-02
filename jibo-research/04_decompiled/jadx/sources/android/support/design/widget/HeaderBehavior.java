package android.support.design.widget;

import android.content.Context;
import android.support.v4.math.MathUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* JADX INFO: renamed from: a */
    OverScroller f771a;

    /* JADX INFO: renamed from: b */
    private Runnable f772b;

    /* JADX INFO: renamed from: c */
    private boolean f773c;

    /* JADX INFO: renamed from: d */
    private int f774d;

    /* JADX INFO: renamed from: e */
    private int f775e;

    /* JADX INFO: renamed from: f */
    private int f776f;

    /* JADX INFO: renamed from: g */
    private VelocityTracker f777g;

    public HeaderBehavior() {
        this.f774d = -1;
        this.f776f = -1;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f774d = -1;
        this.f776f = -1;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo510a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f776f < 0) {
            this.f776f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f773c) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f773c = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (mo464c(v) && coordinatorLayout.m660a(v, x, y)) {
                    this.f775e = y;
                    this.f774d = motionEvent.getPointerId(0);
                    m775d();
                }
                break;
            case 1:
            case 3:
                this.f773c = false;
                this.f774d = -1;
                if (this.f777g != null) {
                    this.f777g.recycle();
                    this.f777g = null;
                }
                break;
            case 2:
                int i = this.f774d;
                if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                    int y2 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y2 - this.f775e) > this.f776f) {
                        this.f773c = true;
                        this.f775e = y2;
                    }
                }
                break;
        }
        if (this.f777g != null) {
            this.f777g.addMovement(motionEvent);
        }
        return this.f773c;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mo539b(android.support.design.widget.CoordinatorLayout r10, V r11, android.view.MotionEvent r12) {
        /*
            r9 = this;
            r7 = 1
            r8 = -1
            r5 = 0
            int r0 = r9.f776f
            if (r0 >= 0) goto L15
            android.content.Context r0 = r10.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r9.f776f = r0
        L15:
            int r0 = r12.getActionMasked()
            switch(r0) {
                case 0: goto L27;
                case 1: goto L82;
                case 2: goto L49;
                case 3: goto La5;
                default: goto L1c;
            }
        L1c:
            android.view.VelocityTracker r0 = r9.f777g
            if (r0 == 0) goto L25
            android.view.VelocityTracker r0 = r9.f777g
            r0.addMovement(r12)
        L25:
            r5 = r7
        L26:
            return r5
        L27:
            float r0 = r12.getX()
            int r0 = (int) r0
            float r1 = r12.getY()
            int r1 = (int) r1
            boolean r0 = r10.m660a(r11, r0, r1)
            if (r0 == 0) goto L26
            boolean r0 = r9.mo464c(r11)
            if (r0 == 0) goto L26
            r9.f775e = r1
            int r0 = r12.getPointerId(r5)
            r9.f774d = r0
            r9.m775d()
            goto L1c
        L49:
            int r0 = r9.f774d
            int r0 = r12.findPointerIndex(r0)
            if (r0 == r8) goto L26
            float r0 = r12.getY(r0)
            int r0 = (int) r0
            int r1 = r9.f775e
            int r3 = r1 - r0
            boolean r1 = r9.f773c
            if (r1 != 0) goto L6d
            int r1 = java.lang.Math.abs(r3)
            int r2 = r9.f776f
            if (r1 <= r2) goto L6d
            r9.f773c = r7
            if (r3 <= 0) goto L7e
            int r1 = r9.f776f
            int r3 = r3 - r1
        L6d:
            boolean r1 = r9.f773c
            if (r1 == 0) goto L1c
            r9.f775e = r0
            int r4 = r9.mo460b(r11)
            r0 = r9
            r1 = r10
            r2 = r11
            r0.m778b(r1, r2, r3, r4, r5)
            goto L1c
        L7e:
            int r1 = r9.f776f
            int r3 = r3 + r1
            goto L6d
        L82:
            android.view.VelocityTracker r0 = r9.f777g
            if (r0 == 0) goto La5
            android.view.VelocityTracker r0 = r9.f777g
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r9.f777g
            r1 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r1)
            android.view.VelocityTracker r0 = r9.f777g
            int r1 = r9.f774d
            float r6 = r0.getYVelocity(r1)
            int r0 = r9.mo439a(r11)
            int r4 = -r0
            r1 = r9
            r2 = r10
            r3 = r11
            r1.m776a(r2, r3, r4, r5, r6)
        La5:
            r9.f773c = r5
            r9.f774d = r8
            android.view.VelocityTracker r0 = r9.f777g
            if (r0 == 0) goto L1c
            android.view.VelocityTracker r0 = r9.f777g
            r0.recycle()
            r0 = 0
            r9.f777g = r0
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.HeaderBehavior.mo539b(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX INFO: renamed from: a_ */
    int m777a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return mo438a(coordinatorLayout, (View) v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* JADX INFO: renamed from: a */
    int mo438a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int iM2025a;
        int iB = mo458b();
        if (i2 == 0 || iB < i2 || iB > i3 || iB == (iM2025a = MathUtils.m2025a(i, i2, i3))) {
            return 0;
        }
        mo450a(iM2025a);
        return iB - iM2025a;
    }

    /* JADX INFO: renamed from: a */
    int mo436a() {
        return mo458b();
    }

    /* JADX INFO: renamed from: b */
    final int m778b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return mo438a(coordinatorLayout, (View) v, mo436a() - i, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    final boolean m776a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.f772b != null) {
            v.removeCallbacks(this.f772b);
            this.f772b = null;
        }
        if (this.f771a == null) {
            this.f771a = new OverScroller(v.getContext());
        }
        this.f771a.fling(0, mo458b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.f771a.computeScrollOffset()) {
            this.f772b = new FlingRunnable(coordinatorLayout, v);
            ViewCompat.m2586a(v, this.f772b);
            return true;
        }
        mo445a(coordinatorLayout, v);
        return false;
    }

    /* JADX INFO: renamed from: a */
    void mo445a(CoordinatorLayout coordinatorLayout, V v) {
    }

    /* JADX INFO: renamed from: c */
    boolean mo464c(V v) {
        return false;
    }

    /* JADX INFO: renamed from: b */
    int mo460b(V v) {
        return -v.getHeight();
    }

    /* JADX INFO: renamed from: a */
    int mo439a(V v) {
        return v.getHeight();
    }

    /* JADX INFO: renamed from: d */
    private void m775d() {
        if (this.f777g == null) {
            this.f777g = VelocityTracker.obtain();
        }
    }

    private class FlingRunnable implements Runnable {

        /* JADX INFO: renamed from: b */
        private final CoordinatorLayout f779b;

        /* JADX INFO: renamed from: c */
        private final V f780c;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v) {
            this.f779b = coordinatorLayout;
            this.f780c = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f780c != null && HeaderBehavior.this.f771a != null) {
                if (HeaderBehavior.this.f771a.computeScrollOffset()) {
                    HeaderBehavior.this.m777a_(this.f779b, this.f780c, HeaderBehavior.this.f771a.getCurrY());
                    ViewCompat.m2586a(this.f780c, this);
                } else {
                    HeaderBehavior.this.mo445a(this.f779b, this.f780c);
                }
            }
        }
    }
}
