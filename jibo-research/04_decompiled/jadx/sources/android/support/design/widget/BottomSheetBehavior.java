package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.math.MathUtils;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a */
    int f541a;

    /* JADX INFO: renamed from: b */
    int f542b;

    /* JADX INFO: renamed from: c */
    boolean f543c;

    /* JADX INFO: renamed from: d */
    int f544d;

    /* JADX INFO: renamed from: e */
    ViewDragHelper f545e;

    /* JADX INFO: renamed from: f */
    int f546f;

    /* JADX INFO: renamed from: g */
    WeakReference<V> f547g;

    /* JADX INFO: renamed from: h */
    WeakReference<View> f548h;

    /* JADX INFO: renamed from: i */
    int f549i;

    /* JADX INFO: renamed from: j */
    boolean f550j;

    /* JADX INFO: renamed from: k */
    private float f551k;

    /* JADX INFO: renamed from: l */
    private int f552l;

    /* JADX INFO: renamed from: m */
    private boolean f553m;

    /* JADX INFO: renamed from: n */
    private int f554n;

    /* JADX INFO: renamed from: o */
    private boolean f555o;

    /* JADX INFO: renamed from: p */
    private boolean f556p;

    /* JADX INFO: renamed from: q */
    private int f557q;

    /* JADX INFO: renamed from: r */
    private boolean f558r;

    /* JADX INFO: renamed from: s */
    private BottomSheetCallback f559s;

    /* JADX INFO: renamed from: t */
    private VelocityTracker f560t;

    /* JADX INFO: renamed from: u */
    private int f561u;

    /* JADX INFO: renamed from: v */
    private final ViewDragHelper.Callback f562v;

    public static abstract class BottomSheetCallback {
        /* JADX INFO: renamed from: a */
        public abstract void mo550a(View view, float f);

        /* JADX INFO: renamed from: a */
        public abstract void mo551a(View view, int i);
    }

    public BottomSheetBehavior() {
        this.f544d = 4;
        this.f562v = new ViewDragHelper.Callback() { // from class: android.support.design.widget.BottomSheetBehavior.2
            @Override // android.support.v4.widget.ViewDragHelper.Callback
            /* JADX INFO: renamed from: a */
            public boolean mo548a(View view, int i) {
                View view2;
                if (BottomSheetBehavior.this.f544d == 1 || BottomSheetBehavior.this.f550j) {
                    return false;
                }
                if (BottomSheetBehavior.this.f544d == 3 && BottomSheetBehavior.this.f549i == i && (view2 = BottomSheetBehavior.this.f548h.get()) != null && view2.canScrollVertically(-1)) {
                    return false;
                }
                return BottomSheetBehavior.this.f547g != null && BottomSheetBehavior.this.f547g.get() == view;
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            /* JADX INFO: renamed from: a */
            public void mo547a(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.m542d(i2);
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            /* JADX INFO: renamed from: a */
            public void mo545a(int i) {
                if (i == 1) {
                    BottomSheetBehavior.this.m540c(1);
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            /* JADX INFO: renamed from: a */
            public void mo546a(View view, float f, float f2) {
                int i;
                int i2 = 3;
                if (f2 < CropImageView.DEFAULT_ASPECT_RATIO) {
                    i = BottomSheetBehavior.this.f541a;
                } else if (BottomSheetBehavior.this.f543c && BottomSheetBehavior.this.m536a(view, f2)) {
                    i = BottomSheetBehavior.this.f546f;
                    i2 = 5;
                } else if (f2 == CropImageView.DEFAULT_ASPECT_RATIO) {
                    int top = view.getTop();
                    if (Math.abs(top - BottomSheetBehavior.this.f541a) < Math.abs(top - BottomSheetBehavior.this.f542b)) {
                        i = BottomSheetBehavior.this.f541a;
                    } else {
                        i = BottomSheetBehavior.this.f542b;
                        i2 = 4;
                    }
                } else {
                    i = BottomSheetBehavior.this.f542b;
                    i2 = 4;
                }
                if (BottomSheetBehavior.this.f545e.m3151a(view.getLeft(), i)) {
                    BottomSheetBehavior.this.m540c(2);
                    ViewCompat.m2586a(view, new SettleRunnable(view, i2));
                } else {
                    BottomSheetBehavior.this.m540c(i2);
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            /* JADX INFO: renamed from: a */
            public int mo544a(View view, int i, int i2) {
                return MathUtils.m2025a(i, BottomSheetBehavior.this.f541a, BottomSheetBehavior.this.f543c ? BottomSheetBehavior.this.f546f : BottomSheetBehavior.this.f542b);
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            /* JADX INFO: renamed from: b */
            public int mo549b(View view, int i, int i2) {
                return view.getLeft();
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            /* JADX INFO: renamed from: a */
            public int mo543a(View view) {
                return BottomSheetBehavior.this.f543c ? BottomSheetBehavior.this.f546f - BottomSheetBehavior.this.f541a : BottomSheetBehavior.this.f542b - BottomSheetBehavior.this.f541a;
            }
        };
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f544d = 4;
        this.f562v = new ViewDragHelper.Callback() { // from class: android.support.design.widget.BottomSheetBehavior.2
            @Override // android.support.v4.widget.ViewDragHelper.Callback
            /* JADX INFO: renamed from: a */
            public boolean mo548a(View view, int i) {
                View view2;
                if (BottomSheetBehavior.this.f544d == 1 || BottomSheetBehavior.this.f550j) {
                    return false;
                }
                if (BottomSheetBehavior.this.f544d == 3 && BottomSheetBehavior.this.f549i == i && (view2 = BottomSheetBehavior.this.f548h.get()) != null && view2.canScrollVertically(-1)) {
                    return false;
                }
                return BottomSheetBehavior.this.f547g != null && BottomSheetBehavior.this.f547g.get() == view;
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            /* JADX INFO: renamed from: a */
            public void mo547a(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.m542d(i2);
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            /* JADX INFO: renamed from: a */
            public void mo545a(int i) {
                if (i == 1) {
                    BottomSheetBehavior.this.m540c(1);
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            /* JADX INFO: renamed from: a */
            public void mo546a(View view, float f, float f2) {
                int i;
                int i2 = 3;
                if (f2 < CropImageView.DEFAULT_ASPECT_RATIO) {
                    i = BottomSheetBehavior.this.f541a;
                } else if (BottomSheetBehavior.this.f543c && BottomSheetBehavior.this.m536a(view, f2)) {
                    i = BottomSheetBehavior.this.f546f;
                    i2 = 5;
                } else if (f2 == CropImageView.DEFAULT_ASPECT_RATIO) {
                    int top = view.getTop();
                    if (Math.abs(top - BottomSheetBehavior.this.f541a) < Math.abs(top - BottomSheetBehavior.this.f542b)) {
                        i = BottomSheetBehavior.this.f541a;
                    } else {
                        i = BottomSheetBehavior.this.f542b;
                        i2 = 4;
                    }
                } else {
                    i = BottomSheetBehavior.this.f542b;
                    i2 = 4;
                }
                if (BottomSheetBehavior.this.f545e.m3151a(view.getLeft(), i)) {
                    BottomSheetBehavior.this.m540c(2);
                    ViewCompat.m2586a(view, new SettleRunnable(view, i2));
                } else {
                    BottomSheetBehavior.this.m540c(i2);
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            /* JADX INFO: renamed from: a */
            public int mo544a(View view, int i, int i2) {
                return MathUtils.m2025a(i, BottomSheetBehavior.this.f541a, BottomSheetBehavior.this.f543c ? BottomSheetBehavior.this.f546f : BottomSheetBehavior.this.f542b);
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            /* JADX INFO: renamed from: b */
            public int mo549b(View view, int i, int i2) {
                return view.getLeft();
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            /* JADX INFO: renamed from: a */
            public int mo543a(View view) {
                return BottomSheetBehavior.this.f543c ? BottomSheetBehavior.this.f546f - BottomSheetBehavior.this.f541a : BottomSheetBehavior.this.f542b - BottomSheetBehavior.this.f541a;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && typedValuePeekValue.data == -1) {
            m529a(typedValuePeekValue.data);
        } else {
            m529a(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        m533a(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        m538b(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f551k = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: b */
    public Parcelable mo462b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.mo462b(coordinatorLayout, v), this.f544d);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public void mo446a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.mo446a(coordinatorLayout, v, savedState.m2474a());
        if (savedState.f567a == 1 || savedState.f567a == 2) {
            this.f544d = 4;
        } else {
            this.f544d = savedState.f567a;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo455a(CoordinatorLayout coordinatorLayout, V v, int i) {
        int iMax;
        if (ViewCompat.m2614r(coordinatorLayout) && !ViewCompat.m2614r(v)) {
            ViewCompat.m2595b((View) v, true);
        }
        int top = v.getTop();
        coordinatorLayout.m653a(v, i);
        this.f546f = coordinatorLayout.getHeight();
        if (this.f553m) {
            if (this.f554n == 0) {
                this.f554n = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            }
            iMax = Math.max(this.f554n, this.f546f - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            iMax = this.f552l;
        }
        this.f541a = Math.max(0, this.f546f - v.getHeight());
        this.f542b = Math.max(this.f546f - iMax, this.f541a);
        if (this.f544d == 3) {
            ViewCompat.m2598c(v, this.f541a);
        } else if (this.f543c && this.f544d == 5) {
            ViewCompat.m2598c(v, this.f546f);
        } else if (this.f544d == 4) {
            ViewCompat.m2598c(v, this.f542b);
        } else if (this.f544d == 1 || this.f544d == 2) {
            ViewCompat.m2598c(v, top - v.getTop());
        }
        if (this.f545e == null) {
            this.f545e = ViewDragHelper.m3130a(coordinatorLayout, this.f562v);
        }
        this.f547g = new WeakReference<>(v);
        this.f548h = new WeakReference<>(m528a(v));
        return true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo510a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            this.f556p = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m525a();
        }
        if (this.f560t == null) {
            this.f560t = VelocityTracker.obtain();
        }
        this.f560t.addMovement(motionEvent);
        switch (actionMasked) {
            case 0:
                int x = (int) motionEvent.getX();
                this.f561u = (int) motionEvent.getY();
                View view = this.f548h != null ? this.f548h.get() : null;
                if (view != null && coordinatorLayout.m660a(view, x, this.f561u)) {
                    this.f549i = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f550j = true;
                }
                this.f556p = this.f549i == -1 && !coordinatorLayout.m660a(v, x, this.f561u);
                break;
            case 1:
            case 3:
                this.f550j = false;
                this.f549i = -1;
                if (this.f556p) {
                    this.f556p = false;
                    return false;
                }
                break;
        }
        if (!this.f556p && this.f545e.m3152a(motionEvent)) {
            return true;
        }
        View view2 = this.f548h.get();
        return (actionMasked != 2 || view2 == null || this.f556p || this.f544d == 1 || coordinatorLayout.m660a(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.f561u) - motionEvent.getY()) <= ((float) this.f545e.m3164d())) ? false : true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: b */
    public boolean mo539b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f544d == 1 && actionMasked == 0) {
            return true;
        }
        if (this.f545e != null) {
            this.f545e.m3156b(motionEvent);
        }
        if (actionMasked == 0) {
            m525a();
        }
        if (this.f560t == null) {
            this.f560t = VelocityTracker.obtain();
        }
        this.f560t.addMovement(motionEvent);
        if (actionMasked == 2 && !this.f556p && Math.abs(this.f561u - motionEvent.getY()) > this.f545e.m3164d()) {
            this.f545e.m3150a(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f556p;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo535a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.f557q = 0;
        this.f558r = false;
        return (i & 2) != 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public void mo531a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == this.f548h.get()) {
            int top = v.getTop();
            int i3 = top - i2;
            if (i2 > 0) {
                if (i3 < this.f541a) {
                    iArr[1] = top - this.f541a;
                    ViewCompat.m2598c(v, -iArr[1]);
                    m540c(3);
                } else {
                    iArr[1] = i2;
                    ViewCompat.m2598c(v, -i2);
                    m540c(1);
                }
            } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                if (i3 <= this.f542b || this.f543c) {
                    iArr[1] = i2;
                    ViewCompat.m2598c(v, -i2);
                    m540c(1);
                } else {
                    iArr[1] = top - this.f542b;
                    ViewCompat.m2598c(v, -iArr[1]);
                    m540c(4);
                }
            }
            m542d(v.getTop());
            this.f557q = i2;
            this.f558r = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: c */
    public void mo541c(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i;
        int i2 = 3;
        if (v.getTop() == this.f541a) {
            m540c(3);
            return;
        }
        if (this.f548h != null && view == this.f548h.get() && this.f558r) {
            if (this.f557q > 0) {
                i = this.f541a;
            } else if (this.f543c && m536a(v, m526b())) {
                i = this.f546f;
                i2 = 5;
            } else if (this.f557q == 0) {
                int top = v.getTop();
                if (Math.abs(top - this.f541a) < Math.abs(top - this.f542b)) {
                    i = this.f541a;
                } else {
                    i = this.f542b;
                    i2 = 4;
                }
            } else {
                i = this.f542b;
                i2 = 4;
            }
            if (this.f545e.m3153a((View) v, v.getLeft(), i)) {
                m540c(2);
                ViewCompat.m2586a(v, new SettleRunnable(v, i2));
            } else {
                m540c(i2);
            }
            this.f558r = false;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo534a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.f548h.get() && (this.f544d != 3 || super.mo534a(coordinatorLayout, v, view, f, f2));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m529a(int r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L24
            boolean r2 = r3.f553m
            if (r2 != 0) goto L3a
            r3.f553m = r0
        Lb:
            if (r0 == 0) goto L23
            int r0 = r3.f544d
            r1 = 4
            if (r0 != r1) goto L23
            java.lang.ref.WeakReference<V extends android.view.View> r0 = r3.f547g
            if (r0 == 0) goto L23
            java.lang.ref.WeakReference<V extends android.view.View> r0 = r3.f547g
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            if (r0 == 0) goto L23
            r0.requestLayout()
        L23:
            return
        L24:
            boolean r2 = r3.f553m
            if (r2 != 0) goto L2c
            int r2 = r3.f552l
            if (r2 == r4) goto L3a
        L2c:
            r3.f553m = r1
            int r1 = java.lang.Math.max(r1, r4)
            r3.f552l = r1
            int r1 = r3.f546f
            int r1 = r1 - r4
            r3.f542b = r1
            goto Lb
        L3a:
            r0 = r1
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.BottomSheetBehavior.m529a(int):void");
    }

    /* JADX INFO: renamed from: a */
    public void m533a(boolean z) {
        this.f543c = z;
    }

    /* JADX INFO: renamed from: b */
    public void m538b(boolean z) {
        this.f555o = z;
    }

    /* JADX INFO: renamed from: a */
    public void m530a(BottomSheetCallback bottomSheetCallback) {
        this.f559s = bottomSheetCallback;
    }

    /* JADX INFO: renamed from: b */
    public final void m537b(final int i) {
        if (i != this.f544d) {
            if (this.f547g == null) {
                if (i == 4 || i == 3 || (this.f543c && i == 5)) {
                    this.f544d = i;
                    return;
                }
                return;
            }
            final V v = this.f547g.get();
            if (v != null) {
                ViewParent parent = v.getParent();
                if (parent != null && parent.isLayoutRequested() && ViewCompat.m2570B(v)) {
                    v.post(new Runnable() { // from class: android.support.design.widget.BottomSheetBehavior.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BottomSheetBehavior.this.m532a(v, i);
                        }
                    });
                } else {
                    m532a((View) v, i);
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    void m540c(int i) {
        if (this.f544d != i) {
            this.f544d = i;
            V v = this.f547g.get();
            if (v != null && this.f559s != null) {
                this.f559s.mo551a((View) v, i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m525a() {
        this.f549i = -1;
        if (this.f560t != null) {
            this.f560t.recycle();
            this.f560t = null;
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m536a(View view, float f) {
        if (this.f555o) {
            return true;
        }
        return view.getTop() >= this.f542b && Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.f542b)) / ((float) this.f552l) > 0.5f;
    }

    /* JADX INFO: renamed from: a */
    View m528a(View view) {
        if (!ViewCompat.m2619w(view)) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View viewM528a = m528a(viewGroup.getChildAt(i));
                    if (viewM528a != null) {
                        return viewM528a;
                    }
                }
            }
            return null;
        }
        return view;
    }

    /* JADX INFO: renamed from: b */
    private float m526b() {
        this.f560t.computeCurrentVelocity(1000, this.f551k);
        return this.f560t.getYVelocity(this.f549i);
    }

    /* JADX INFO: renamed from: a */
    void m532a(View view, int i) {
        int i2;
        if (i == 4) {
            i2 = this.f542b;
        } else if (i == 3) {
            i2 = this.f541a;
        } else if (this.f543c && i == 5) {
            i2 = this.f546f;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i);
        }
        if (this.f545e.m3153a(view, view.getLeft(), i2)) {
            m540c(2);
            ViewCompat.m2586a(view, new SettleRunnable(view, i));
        } else {
            m540c(i);
        }
    }

    /* JADX INFO: renamed from: d */
    void m542d(int i) {
        V v = this.f547g.get();
        if (v != null && this.f559s != null) {
            if (i > this.f542b) {
                this.f559s.mo550a(v, (this.f542b - i) / (this.f546f - this.f542b));
            } else {
                this.f559s.mo550a(v, (this.f542b - i) / (this.f542b - this.f541a));
            }
        }
    }

    private class SettleRunnable implements Runnable {

        /* JADX INFO: renamed from: b */
        private final View f569b;

        /* JADX INFO: renamed from: c */
        private final int f570c;

        SettleRunnable(View view, int i) {
            this.f569b = view;
            this.f570c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BottomSheetBehavior.this.f545e != null && BottomSheetBehavior.this.f545e.m3154a(true)) {
                ViewCompat.m2586a(this.f569b, this);
            } else {
                BottomSheetBehavior.this.m540c(this.f570c);
            }
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.design.widget.BottomSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        final int f567a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f567a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f567a = i;
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f567a);
        }
    }

    /* JADX INFO: renamed from: b */
    public static <V extends View> BottomSheetBehavior<V> m527b(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behaviorM699b = ((CoordinatorLayout.LayoutParams) layoutParams).m699b();
        if (!(behaviorM699b instanceof BottomSheetBehavior)) {
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        return (BottomSheetBehavior) behaviorM699b;
    }
}
