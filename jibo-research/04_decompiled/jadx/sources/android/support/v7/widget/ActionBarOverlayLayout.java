package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements NestedScrollingParent, DecorContentParent {

    /* JADX INFO: renamed from: e */
    static final int[] f3495e = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};

    /* JADX INFO: renamed from: A */
    private final Runnable f3496A;

    /* JADX INFO: renamed from: B */
    private final Runnable f3497B;

    /* JADX INFO: renamed from: C */
    private final NestedScrollingParentHelper f3498C;

    /* JADX INFO: renamed from: a */
    ActionBarContainer f3499a;

    /* JADX INFO: renamed from: b */
    boolean f3500b;

    /* JADX INFO: renamed from: c */
    ViewPropertyAnimator f3501c;

    /* JADX INFO: renamed from: d */
    final AnimatorListenerAdapter f3502d;

    /* JADX INFO: renamed from: f */
    private int f3503f;

    /* JADX INFO: renamed from: g */
    private int f3504g;

    /* JADX INFO: renamed from: h */
    private ContentFrameLayout f3505h;

    /* JADX INFO: renamed from: i */
    private DecorToolbar f3506i;

    /* JADX INFO: renamed from: j */
    private Drawable f3507j;

    /* JADX INFO: renamed from: k */
    private boolean f3508k;

    /* JADX INFO: renamed from: l */
    private boolean f3509l;

    /* JADX INFO: renamed from: m */
    private boolean f3510m;

    /* JADX INFO: renamed from: n */
    private boolean f3511n;

    /* JADX INFO: renamed from: o */
    private int f3512o;

    /* JADX INFO: renamed from: p */
    private int f3513p;

    /* JADX INFO: renamed from: q */
    private final Rect f3514q;

    /* JADX INFO: renamed from: r */
    private final Rect f3515r;

    /* JADX INFO: renamed from: s */
    private final Rect f3516s;

    /* JADX INFO: renamed from: t */
    private final Rect f3517t;

    /* JADX INFO: renamed from: u */
    private final Rect f3518u;

    /* JADX INFO: renamed from: v */
    private final Rect f3519v;

    /* JADX INFO: renamed from: w */
    private final Rect f3520w;

    /* JADX INFO: renamed from: x */
    private ActionBarVisibilityCallback f3521x;

    /* JADX INFO: renamed from: y */
    private final int f3522y;

    /* JADX INFO: renamed from: z */
    private OverScroller f3523z;

    public interface ActionBarVisibilityCallback {
        /* JADX INFO: renamed from: a */
        void mo3392a(int i);

        /* JADX INFO: renamed from: a */
        void mo3393a(boolean z);

        /* JADX INFO: renamed from: b */
        void mo3394b();

        /* JADX INFO: renamed from: c */
        void mo3396c();

        /* JADX INFO: renamed from: d */
        void mo3398d();

        /* JADX INFO: renamed from: e */
        void mo3400e();
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3504g = 0;
        this.f3514q = new Rect();
        this.f3515r = new Rect();
        this.f3516s = new Rect();
        this.f3517t = new Rect();
        this.f3518u = new Rect();
        this.f3519v = new Rect();
        this.f3520w = new Rect();
        this.f3522y = 600;
        this.f3502d = new AnimatorListenerAdapter() { // from class: android.support.v7.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout.this.f3501c = null;
                ActionBarOverlayLayout.this.f3500b = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout.this.f3501c = null;
                ActionBarOverlayLayout.this.f3500b = false;
            }
        };
        this.f3496A = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.m3714e();
                ActionBarOverlayLayout.this.f3501c = ActionBarOverlayLayout.this.f3499a.animate().translationY(CropImageView.DEFAULT_ASPECT_RATIO).setListener(ActionBarOverlayLayout.this.f3502d);
            }
        };
        this.f3497B = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.m3714e();
                ActionBarOverlayLayout.this.f3501c = ActionBarOverlayLayout.this.f3499a.animate().translationY(-ActionBarOverlayLayout.this.f3499a.getHeight()).setListener(ActionBarOverlayLayout.this.f3502d);
            }
        };
        m3700a(context);
        this.f3498C = new NestedScrollingParentHelper(this);
    }

    /* JADX INFO: renamed from: a */
    private void m3700a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f3495e);
        this.f3503f = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f3507j = typedArrayObtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f3507j == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f3508k = context.getApplicationInfo().targetSdkVersion < 19;
        this.f3523z = new OverScroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3714e();
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.f3521x = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.f3521x.mo3392a(this.f3504g);
            if (this.f3513p != 0) {
                onWindowSystemUiVisibilityChanged(this.f3513p);
                ViewCompat.m2613q(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.f3509l = z;
        this.f3508k = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    /* JADX INFO: renamed from: a */
    public boolean m3710a() {
        return this.f3509l;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f3510m = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3700a(getContext());
        ViewCompat.m2613q(this);
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m3712c();
        int i2 = this.f3513p ^ i;
        this.f3513p = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        if (this.f3521x != null) {
            this.f3521x.mo3393a(z2 ? false : true);
            if (z || !z2) {
                this.f3521x.mo3394b();
            } else {
                this.f3521x.mo3396c();
            }
        }
        if ((i2 & 256) != 0 && this.f3521x != null) {
            ViewCompat.m2613q(this);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f3504g = i;
        if (this.f3521x != null) {
            this.f3521x.mo3392a(i);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3702a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z && layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || layoutParams.bottomMargin == rect.bottom) {
            return z5;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        m3712c();
        if ((ViewCompat.m2612p(this) & 256) != 0) {
        }
        boolean zM3702a = m3702a(this.f3499a, rect, true, true, false, true);
        this.f3517t.set(rect);
        ViewUtils.m5030a(this, this.f3517t, this.f3514q);
        if (!this.f3518u.equals(this.f3517t)) {
            this.f3518u.set(this.f3517t);
            zM3702a = true;
        }
        if (!this.f3515r.equals(this.f3514q)) {
            this.f3515r.set(this.f3514q);
            zM3702a = true;
        }
        if (zM3702a) {
            requestLayout();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        m3712c();
        measureChildWithMargins(this.f3499a, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f3499a.getLayoutParams();
        int iMax = Math.max(0, this.f3499a.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int iMax2 = Math.max(0, layoutParams.bottomMargin + this.f3499a.getMeasuredHeight() + layoutParams.topMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f3499a.getMeasuredState());
        boolean z = (ViewCompat.m2612p(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f3503f;
            if (this.f3510m && this.f3499a.getTabContainer() != null) {
                measuredHeight += this.f3503f;
            }
        } else {
            measuredHeight = this.f3499a.getVisibility() != 8 ? this.f3499a.getMeasuredHeight() : 0;
        }
        this.f3516s.set(this.f3514q);
        this.f3519v.set(this.f3517t);
        if (!this.f3509l && !z) {
            Rect rect = this.f3516s;
            rect.top = measuredHeight + rect.top;
            this.f3516s.bottom += 0;
        } else {
            Rect rect2 = this.f3519v;
            rect2.top = measuredHeight + rect2.top;
            this.f3519v.bottom += 0;
        }
        m3702a(this.f3505h, this.f3516s, true, true, true, true);
        if (!this.f3520w.equals(this.f3519v)) {
            this.f3520w.set(this.f3519v);
            this.f3505h.m4045a(this.f3519v);
        }
        measureChildWithMargins(this.f3505h, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f3505h.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f3505h.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int iMax4 = Math.max(iMax2, layoutParams2.bottomMargin + this.f3505h.getMeasuredHeight() + layoutParams2.topMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f3505h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f3507j != null && !this.f3508k) {
            int bottom = this.f3499a.getVisibility() == 0 ? (int) (this.f3499a.getBottom() + this.f3499a.getTranslationY() + 0.5f) : 0;
            this.f3507j.setBounds(0, bottom, getWidth(), this.f3507j.getIntrinsicHeight() + bottom);
            this.f3507j.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f3499a.getVisibility() != 0) {
            return false;
        }
        return this.f3511n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f3498C.m2548a(view, view2, i);
        this.f3512o = getActionBarHideOffset();
        m3714e();
        if (this.f3521x != null) {
            this.f3521x.mo3398d();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f3512o += i2;
        setActionBarHideOffset(this.f3512o);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        if (this.f3511n && !this.f3500b) {
            if (this.f3512o <= this.f3499a.getHeight()) {
                m3703m();
            } else {
                m3704n();
            }
        }
        if (this.f3521x != null) {
            this.f3521x.mo3400e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f3511n || !z) {
            return false;
        }
        if (m3701a(f, f2)) {
            m3706p();
        } else {
            m3705o();
        }
        this.f3500b = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3498C.m2545a();
    }

    /* JADX INFO: renamed from: c */
    void m3712c() {
        if (this.f3505h == null) {
            this.f3505h = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f3499a = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.f3506i = m3699a(findViewById(R.id.action_bar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private DecorToolbar m3699a(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f3511n) {
            this.f3511n = z;
            if (!z) {
                m3714e();
                setActionBarHideOffset(0);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public boolean m3713d() {
        return this.f3511n;
    }

    public int getActionBarHideOffset() {
        if (this.f3499a != null) {
            return -((int) this.f3499a.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        m3714e();
        this.f3499a.setTranslationY(-Math.max(0, Math.min(i, this.f3499a.getHeight())));
    }

    /* JADX INFO: renamed from: e */
    void m3714e() {
        removeCallbacks(this.f3496A);
        removeCallbacks(this.f3497B);
        if (this.f3501c != null) {
            this.f3501c.cancel();
        }
    }

    /* JADX INFO: renamed from: m */
    private void m3703m() {
        m3714e();
        postDelayed(this.f3496A, 600L);
    }

    /* JADX INFO: renamed from: n */
    private void m3704n() {
        m3714e();
        postDelayed(this.f3497B, 600L);
    }

    /* JADX INFO: renamed from: o */
    private void m3705o() {
        m3714e();
        this.f3496A.run();
    }

    /* JADX INFO: renamed from: p */
    private void m3706p() {
        m3714e();
        this.f3497B.run();
    }

    /* JADX INFO: renamed from: a */
    private boolean m3701a(float f, float f2) {
        this.f3523z.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f3523z.getFinalY() > this.f3499a.getHeight();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        m3712c();
        this.f3506i.mo4054a(callback);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        m3712c();
        this.f3506i.mo4056a(charSequence);
    }

    public CharSequence getTitle() {
        m3712c();
        return this.f3506i.mo4071e();
    }

    @Override // android.support.v7.widget.DecorContentParent
    /* JADX INFO: renamed from: a */
    public void mo3708a(int i) {
        m3712c();
        switch (i) {
            case 2:
                this.f3506i.mo4075g();
                break;
            case 5:
                this.f3506i.mo4077h();
                break;
            case 109:
                setOverlayMode(true);
                break;
        }
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(int i) {
        m3712c();
        this.f3506i.mo4048a(i);
    }

    public void setIcon(Drawable drawable) {
        m3712c();
        this.f3506i.mo4049a(drawable);
    }

    public void setLogo(int i) {
        m3712c();
        this.f3506i.mo4059b(i);
    }

    @Override // android.support.v7.widget.DecorContentParent
    /* JADX INFO: renamed from: f */
    public boolean mo3715f() {
        m3712c();
        return this.f3506i.mo4079i();
    }

    @Override // android.support.v7.widget.DecorContentParent
    /* JADX INFO: renamed from: g */
    public boolean mo3716g() {
        m3712c();
        return this.f3506i.mo4080j();
    }

    @Override // android.support.v7.widget.DecorContentParent
    /* JADX INFO: renamed from: h */
    public boolean mo3717h() {
        m3712c();
        return this.f3506i.mo4081k();
    }

    @Override // android.support.v7.widget.DecorContentParent
    /* JADX INFO: renamed from: i */
    public boolean mo3718i() {
        m3712c();
        return this.f3506i.mo4082l();
    }

    @Override // android.support.v7.widget.DecorContentParent
    /* JADX INFO: renamed from: j */
    public boolean mo3719j() {
        m3712c();
        return this.f3506i.mo4083m();
    }

    @Override // android.support.v7.widget.DecorContentParent
    /* JADX INFO: renamed from: k */
    public void mo3720k() {
        m3712c();
        this.f3506i.mo4084n();
    }

    @Override // android.support.v7.widget.DecorContentParent
    /* JADX INFO: renamed from: a */
    public void mo3709a(Menu menu, MenuPresenter.Callback callback) {
        m3712c();
        this.f3506i.mo4052a(menu, callback);
    }

    @Override // android.support.v7.widget.DecorContentParent
    /* JADX INFO: renamed from: l */
    public void mo3721l() {
        m3712c();
        this.f3506i.mo4085o();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
