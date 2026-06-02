package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@CoordinatorLayout.DefaultBehavior(m687a = Behavior.class)
public class AppBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a */
    private int f475a;

    /* JADX INFO: renamed from: b */
    private int f476b;

    /* JADX INFO: renamed from: c */
    private int f477c;

    /* JADX INFO: renamed from: d */
    private boolean f478d;

    /* JADX INFO: renamed from: e */
    private int f479e;

    /* JADX INFO: renamed from: f */
    private WindowInsetsCompat f480f;

    /* JADX INFO: renamed from: g */
    private List<OnOffsetChangedListener> f481g;

    /* JADX INFO: renamed from: h */
    private boolean f482h;

    /* JADX INFO: renamed from: i */
    private boolean f483i;

    /* JADX INFO: renamed from: j */
    private int[] f484j;

    public interface OnOffsetChangedListener {
        /* JADX INFO: renamed from: a */
        void mo472a(AppBarLayout appBarLayout, int i);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f475a = -1;
        this.f476b = -1;
        this.f477c = -1;
        this.f479e = 0;
        setOrientation(1);
        ThemeUtils.m940a(context);
        if (Build.VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.m948a(this);
            ViewUtilsLollipop.m950a(this, attributeSet, 0, R.style.Widget_Design_AppBarLayout);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout, 0, R.style.Widget_Design_AppBarLayout);
        ViewCompat.m2582a(this, typedArrayObtainStyledAttributes.getDrawable(R.styleable.AppBarLayout_android_background));
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppBarLayout_expanded)) {
            m410a(typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && typedArrayObtainStyledAttributes.hasValue(R.styleable.AppBarLayout_elevation)) {
            ViewUtilsLollipop.m949a(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        ViewCompat.m2584a(this, new OnApplyWindowInsetsListener() { // from class: android.support.design.widget.AppBarLayout.1
            @Override // android.support.v4.view.OnApplyWindowInsetsListener
            /* JADX INFO: renamed from: a */
            public WindowInsetsCompat mo399a(View view, WindowInsetsCompat windowInsetsCompat) {
                return AppBarLayout.this.m417a(windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m419a(OnOffsetChangedListener onOffsetChangedListener) {
        if (this.f481g == null) {
            this.f481g = new ArrayList();
        }
        if (onOffsetChangedListener != null && !this.f481g.contains(onOffsetChangedListener)) {
            this.f481g.add(onOffsetChangedListener);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m422b(OnOffsetChangedListener onOffsetChangedListener) {
        if (this.f481g != null && onOffsetChangedListener != null) {
            this.f481g.remove(onOffsetChangedListener);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m413f();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m413f();
        this.f478d = false;
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            if (((LayoutParams) getChildAt(i5).getLayoutParams()).m470b() == null) {
                i5++;
            } else {
                this.f478d = true;
                break;
            }
        }
        m412e();
    }

    /* JADX INFO: renamed from: e */
    private void m412e() {
        boolean z;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = false;
                break;
            } else if (!((LayoutParams) getChildAt(i).getLayoutParams()).m471c()) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        m411b(z);
    }

    /* JADX INFO: renamed from: f */
    private void m413f() {
        this.f475a = -1;
        this.f476b = -1;
        this.f477c = -1;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setExpanded(boolean z) {
        m420a(z, ViewCompat.m2621y(this));
    }

    /* JADX INFO: renamed from: a */
    public void m420a(boolean z, boolean z2) {
        m410a(z, z2, true);
    }

    /* JADX INFO: renamed from: a */
    private void m410a(boolean z, boolean z2, boolean z3) {
        this.f479e = (z3 ? 8 : 0) | (z2 ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: renamed from: b */
    boolean m423b() {
        return this.f478d;
    }

    public final int getTotalScrollRange() {
        int iM2607k;
        if (this.f475a != -1) {
            return this.f475a;
        }
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.f499a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += layoutParams.bottomMargin + measuredHeight + layoutParams.topMargin;
            if ((i3 & 2) != 0) {
                iM2607k = i - ViewCompat.m2607k(childAt);
                break;
            }
        }
        iM2607k = i;
        int iMax = Math.max(0, iM2607k - getTopInset());
        this.f475a = iMax;
        return iMax;
    }

    /* JADX INFO: renamed from: c */
    boolean m424c() {
        return getTotalScrollRange() != 0;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    int getDownNestedPreScrollRange() {
        int topInset;
        if (this.f476b != -1) {
            return this.f476b;
        }
        int childCount = getChildCount() - 1;
        int i = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i2 = layoutParams.f499a;
            if ((i2 & 5) == 5) {
                int i3 = layoutParams.bottomMargin + layoutParams.topMargin + i;
                if ((i2 & 8) != 0) {
                    topInset = i3 + ViewCompat.m2607k(childAt);
                } else if ((i2 & 2) != 0) {
                    topInset = i3 + (measuredHeight - ViewCompat.m2607k(childAt));
                } else {
                    topInset = i3 + (measuredHeight - getTopInset());
                }
            } else {
                if (i > 0) {
                    break;
                }
                topInset = i;
            }
            childCount--;
            i = topInset;
        }
        int iMax = Math.max(0, i);
        this.f476b = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        int iM2607k;
        if (this.f477c != -1) {
            return this.f477c;
        }
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int i3 = layoutParams.f499a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += measuredHeight;
            if ((i3 & 2) != 0) {
                iM2607k = i - (ViewCompat.m2607k(childAt) + getTopInset());
                break;
            }
        }
        iM2607k = i;
        int iMax = Math.max(0, iM2607k);
        this.f477c = iMax;
        return iMax;
    }

    /* JADX INFO: renamed from: a */
    void m418a(int i) {
        if (this.f481g != null) {
            int size = this.f481g.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnOffsetChangedListener onOffsetChangedListener = this.f481g.get(i2);
                if (onOffsetChangedListener != null) {
                    onOffsetChangedListener.mo472a(this, i);
                }
            }
        }
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iM2607k = ViewCompat.m2607k(this);
        if (iM2607k != 0) {
            return (iM2607k * 2) + topInset;
        }
        int childCount = getChildCount();
        int iM2607k2 = childCount >= 1 ? ViewCompat.m2607k(getChildAt(childCount - 1)) : 0;
        if (iM2607k2 != 0) {
            return (iM2607k2 * 2) + topInset;
        }
        return getHeight() / 3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.f484j == null) {
            this.f484j = new int[2];
        }
        int[] iArr = this.f484j;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(iArr.length + i);
        iArr[0] = this.f482h ? R.attr.state_collapsible : -R.attr.state_collapsible;
        iArr[1] = (this.f482h && this.f483i) ? R.attr.state_collapsed : -R.attr.state_collapsed;
        return mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    /* JADX INFO: renamed from: b */
    private boolean m411b(boolean z) {
        if (this.f482h == z) {
            return false;
        }
        this.f482h = z;
        refreshDrawableState();
        return true;
    }

    /* JADX INFO: renamed from: a */
    boolean m421a(boolean z) {
        if (this.f483i == z) {
            return false;
        }
        this.f483i = z;
        refreshDrawableState();
        return true;
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.m949a(this, f);
        }
    }

    @Deprecated
    public float getTargetElevation() {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    int getPendingAction() {
        return this.f479e;
    }

    /* JADX INFO: renamed from: d */
    void m425d() {
        this.f479e = 0;
    }

    final int getTopInset() {
        if (this.f480f != null) {
            return this.f480f.m2770b();
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    WindowInsetsCompat m417a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.m2614r(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.m2436a(this.f480f, windowInsetsCompat2)) {
            this.f480f = windowInsetsCompat2;
            m413f();
        }
        return windowInsetsCompat;
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a */
        int f499a;

        /* JADX INFO: renamed from: b */
        Interpolator f500b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f499a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.f499a = typedArrayObtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f500b = android.view.animation.AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f499a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f499a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f499a = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f499a = 1;
        }

        /* JADX INFO: renamed from: a */
        public int m469a() {
            return this.f499a;
        }

        /* JADX INFO: renamed from: b */
        public Interpolator m470b() {
            return this.f500b;
        }

        /* JADX INFO: renamed from: c */
        boolean m471c() {
            return (this.f499a & 1) == 1 && (this.f499a & 10) != 0;
        }
    }

    public static class Behavior extends HeaderBehavior<AppBarLayout> {

        /* JADX INFO: renamed from: b */
        private int f486b;

        /* JADX INFO: renamed from: c */
        private ValueAnimator f487c;

        /* JADX INFO: renamed from: d */
        private int f488d;

        /* JADX INFO: renamed from: e */
        private boolean f489e;

        /* JADX INFO: renamed from: f */
        private float f490f;

        /* JADX INFO: renamed from: g */
        private WeakReference<View> f491g;

        /* JADX INFO: renamed from: h */
        private DragCallback f492h;

        public static abstract class DragCallback {
            /* JADX INFO: renamed from: a */
            public abstract boolean m465a(AppBarLayout appBarLayout);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo450a(int i) {
            return super.mo450a(i);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        /* JADX INFO: renamed from: b */
        public /* bridge */ /* synthetic */ int mo458b() {
            return super.mo458b();
        }

        public Behavior() {
            this.f488d = -1;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f488d = -1;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo457a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            boolean z = (i & 2) != 0 && appBarLayout.m424c() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.f487c != null) {
                this.f487c.cancel();
            }
            this.f491g = null;
            return z;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo449a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int downNestedPreScrollRange;
            if (i2 != 0) {
                if (i2 < 0) {
                    i4 = -appBarLayout.getTotalScrollRange();
                    downNestedPreScrollRange = i4 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i4 = -appBarLayout.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                if (i4 != downNestedPreScrollRange) {
                    iArr[1] = m778b(coordinatorLayout, appBarLayout, i2, i4, downNestedPreScrollRange);
                }
            }
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo448a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                m778b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
            }
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo447a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            if (i == 0) {
                m434c(coordinatorLayout, appBarLayout);
            }
            this.f491g = new WeakReference<>(view);
        }

        /* JADX INFO: renamed from: a */
        private void m428a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int height;
            int iAbs = Math.abs(mo436a() - i);
            float fAbs = Math.abs(f);
            if (fAbs > CropImageView.DEFAULT_ASPECT_RATIO) {
                height = Math.round((iAbs / fAbs) * 1000.0f) * 3;
            } else {
                height = (int) (((iAbs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            }
            m429a(coordinatorLayout, appBarLayout, i, height);
        }

        /* JADX INFO: renamed from: a */
        private void m429a(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i, int i2) {
            int iMo436a = mo436a();
            if (iMo436a == i) {
                if (this.f487c != null && this.f487c.isRunning()) {
                    this.f487c.cancel();
                    return;
                }
                return;
            }
            if (this.f487c == null) {
                this.f487c = new ValueAnimator();
                this.f487c.setInterpolator(AnimationUtils.f474e);
                this.f487c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.AppBarLayout.Behavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Behavior.this.m777a_(coordinatorLayout, appBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                this.f487c.cancel();
            }
            this.f487c.setDuration(Math.min(i2, 600));
            this.f487c.setIntValues(iMo436a, i);
            this.f487c.start();
        }

        /* JADX INFO: renamed from: a */
        private int m427a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return i2;
                }
            }
            return -1;
        }

        /* JADX INFO: renamed from: c */
        private void m434c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int iM2607k;
            int iMo436a = mo436a();
            int iM427a = m427a(appBarLayout, iMo436a);
            if (iM427a >= 0) {
                View childAt = appBarLayout.getChildAt(iM427a);
                int iM469a = ((LayoutParams) childAt.getLayoutParams()).m469a();
                if ((iM469a & 17) == 17) {
                    int i = -childAt.getTop();
                    int iM2607k2 = -childAt.getBottom();
                    if (iM427a == appBarLayout.getChildCount() - 1) {
                        iM2607k2 += appBarLayout.getTopInset();
                    }
                    if (m431a(iM469a, 2)) {
                        iM2607k2 += ViewCompat.m2607k(childAt);
                        iM2607k = i;
                    } else if (m431a(iM469a, 5)) {
                        iM2607k = ViewCompat.m2607k(childAt) + iM2607k2;
                        if (iMo436a >= iM2607k) {
                            iM2607k2 = iM2607k;
                            iM2607k = i;
                        }
                    } else {
                        iM2607k = i;
                    }
                    if (iMo436a >= (iM2607k2 + iM2607k) / 2) {
                        iM2607k2 = iM2607k;
                    }
                    m428a(coordinatorLayout, appBarLayout, MathUtils.m2025a(iM2607k2, -appBarLayout.getTotalScrollRange(), 0), CropImageView.DEFAULT_ASPECT_RATIO);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private static boolean m431a(int i, int i2) {
            return (i & i2) == i2;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo456a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).height != -2) {
                return super.mo456a(coordinatorLayout, appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.m654a(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        @Override // android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo455a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int iRound;
            boolean zA = super.mo455a(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            if (this.f488d >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(this.f488d);
                int i2 = -childAt.getBottom();
                if (this.f489e) {
                    iRound = ViewCompat.m2607k(childAt) + appBarLayout.getTopInset() + i2;
                } else {
                    iRound = Math.round(childAt.getHeight() * this.f490f) + i2;
                }
                m777a_(coordinatorLayout, appBarLayout, iRound);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i3 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        m428a(coordinatorLayout, appBarLayout, i3, CropImageView.DEFAULT_ASPECT_RATIO);
                    } else {
                        m777a_(coordinatorLayout, appBarLayout, i3);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        m428a(coordinatorLayout, appBarLayout, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                    } else {
                        m777a_(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.m425d();
            this.f488d = -1;
            mo450a(MathUtils.m2025a(mo458b(), -appBarLayout.getTotalScrollRange(), 0));
            m430a(coordinatorLayout, appBarLayout, mo458b(), 0, true);
            appBarLayout.m418a(mo458b());
            return zA;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo464c(AppBarLayout appBarLayout) {
            if (this.f492h != null) {
                return this.f492h.m465a(appBarLayout);
            }
            if (this.f491g == null) {
                return true;
            }
            View view = this.f491g.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo445a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            m434c(coordinatorLayout, appBarLayout);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int mo460b(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int mo439a(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.design.widget.HeaderBehavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int mo438a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int iMo436a = mo436a();
            if (i2 != 0 && iMo436a >= i2 && iMo436a <= i3) {
                int iM2025a = MathUtils.m2025a(i, i2, i3);
                if (iMo436a == iM2025a) {
                    return 0;
                }
                int iM432b = appBarLayout.m423b() ? m432b(appBarLayout, iM2025a) : iM2025a;
                boolean zMo450a = mo450a(iM432b);
                int i4 = iMo436a - iM2025a;
                this.f486b = iM2025a - iM432b;
                if (!zMo450a && appBarLayout.m423b()) {
                    coordinatorLayout.m664b(appBarLayout);
                }
                appBarLayout.m418a(mo458b());
                m430a(coordinatorLayout, appBarLayout, iM2025a, iM2025a < iMo436a ? -1 : 1, false);
                return i4;
            }
            this.f486b = 0;
            return 0;
        }

        /* JADX INFO: renamed from: b */
        private int m432b(AppBarLayout appBarLayout, int i) {
            int topInset;
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator interpolatorM470b = layoutParams.m470b();
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    if (interpolatorM470b != null) {
                        int iM469a = layoutParams.m469a();
                        if ((iM469a & 1) != 0) {
                            topInset = layoutParams.bottomMargin + childAt.getHeight() + layoutParams.topMargin + 0;
                            if ((iM469a & 2) != 0) {
                                topInset -= ViewCompat.m2607k(childAt);
                            }
                        } else {
                            topInset = 0;
                        }
                        if (ViewCompat.m2614r(childAt)) {
                            topInset -= appBarLayout.getTopInset();
                        }
                        if (topInset > 0) {
                            return Integer.signum(i) * (Math.round(interpolatorM470b.getInterpolation((iAbs - childAt.getTop()) / topInset) * topInset) + childAt.getTop());
                        }
                        return i;
                    }
                    return i;
                }
            }
            return i;
        }

        /* JADX INFO: renamed from: a */
        private void m430a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, boolean z) {
            boolean z2 = false;
            View viewM433c = m433c(appBarLayout, i);
            if (viewM433c != null) {
                int iM469a = ((LayoutParams) viewM433c.getLayoutParams()).m469a();
                if ((iM469a & 1) != 0) {
                    int iM2607k = ViewCompat.m2607k(viewM433c);
                    if (i2 > 0 && (iM469a & 12) != 0) {
                        z2 = (-i) >= (viewM433c.getBottom() - iM2607k) - appBarLayout.getTopInset();
                    } else if ((iM469a & 2) != 0) {
                        z2 = (-i) >= (viewM433c.getBottom() - iM2607k) - appBarLayout.getTopInset();
                    }
                }
                boolean zM421a = appBarLayout.m421a(z2);
                if (Build.VERSION.SDK_INT >= 11) {
                    if (z || (zM421a && m435d(coordinatorLayout, appBarLayout))) {
                        appBarLayout.jumpDrawablesToCurrentState();
                    }
                }
            }
        }

        /* JADX INFO: renamed from: d */
        private boolean m435d(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List<View> listM672d = coordinatorLayout.m672d(appBarLayout);
            int size = listM672d.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.Behavior behaviorM699b = ((CoordinatorLayout.LayoutParams) listM672d.get(i).getLayoutParams()).m699b();
                if (behaviorM699b instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behaviorM699b).m784d() != 0;
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: c */
        private static View m433c(AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // android.support.design.widget.HeaderBehavior
        /* JADX INFO: renamed from: a */
        int mo436a() {
            return mo458b() + this.f486b;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable mo462b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            Parcelable parcelableB = super.mo462b(coordinatorLayout, appBarLayout);
            int iMo458b = mo458b();
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + iMo458b;
                if (childAt.getTop() + iMo458b <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(parcelableB);
                    savedState.f496a = i;
                    savedState.f498c = bottom == ViewCompat.m2607k(childAt) + appBarLayout.getTopInset();
                    savedState.f497b = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return parcelableB;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo446a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.mo446a(coordinatorLayout, appBarLayout, savedState.m2474a());
                this.f488d = savedState.f496a;
                this.f490f = savedState.f497b;
                this.f489e = savedState.f498c;
                return;
            }
            super.mo446a(coordinatorLayout, appBarLayout, parcelable);
            this.f488d = -1;
        }

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.design.widget.AppBarLayout.Behavior.SavedState.1
                @Override // android.os.Parcelable.ClassLoaderCreator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };

            /* JADX INFO: renamed from: a */
            int f496a;

            /* JADX INFO: renamed from: b */
            float f497b;

            /* JADX INFO: renamed from: c */
            boolean f498c;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f496a = parcel.readInt();
                this.f497b = parcel.readFloat();
                this.f498c = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f496a);
                parcel.writeFloat(this.f497b);
                parcel.writeByte((byte) (this.f498c ? 1 : 0));
            }
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        @Override // android.support.design.widget.ViewOffsetBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo450a(int i) {
            return super.mo450a(i);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo455a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.mo455a(coordinatorLayout, view, i);
        }

        @Override // android.support.design.widget.HeaderScrollingViewBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo456a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.mo456a(coordinatorLayout, view, i, i2, i3, i4);
        }

        @Override // android.support.design.widget.ViewOffsetBehavior
        /* JADX INFO: renamed from: b */
        public /* bridge */ /* synthetic */ int mo458b() {
            return super.mo458b();
        }

        @Override // android.support.design.widget.HeaderScrollingViewBehavior
        /* JADX INFO: renamed from: b */
        /* synthetic */ View mo480b(List list) {
            return m476a((List<View>) list);
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            m781b(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a */
        public boolean mo478a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: b */
        public boolean mo481b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m474e(coordinatorLayout, view, view2);
            return false;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a */
        public boolean mo477a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayoutM476a = m476a(coordinatorLayout.m668c(view));
            if (appBarLayoutM476a != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f781a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutM476a.m420a(false, !z);
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: e */
        private void m474e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            CoordinatorLayout.Behavior behaviorM699b = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).m699b();
            if (behaviorM699b instanceof Behavior) {
                ViewCompat.m2598c(view, ((((Behavior) behaviorM699b).f486b + (view2.getBottom() - view.getTop())) + m780a()) - m783c(view2));
            }
        }

        @Override // android.support.design.widget.HeaderScrollingViewBehavior
        /* JADX INFO: renamed from: a */
        float mo475a(View view) {
            int i;
            if (!(view instanceof AppBarLayout)) {
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            int iM473a = m473a(appBarLayout);
            return ((downNestedPreScrollRange == 0 || totalScrollRange + iM473a > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) ? 1.0f + (iM473a / i) : CropImageView.DEFAULT_ASPECT_RATIO;
        }

        /* JADX INFO: renamed from: a */
        private static int m473a(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behaviorM699b = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).m699b();
            if (behaviorM699b instanceof Behavior) {
                return ((Behavior) behaviorM699b).mo436a();
            }
            return 0;
        }

        /* JADX INFO: renamed from: a */
        AppBarLayout m476a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // android.support.design.widget.HeaderScrollingViewBehavior
        /* JADX INFO: renamed from: b */
        int mo479b(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.mo479b(view);
        }
    }
}
