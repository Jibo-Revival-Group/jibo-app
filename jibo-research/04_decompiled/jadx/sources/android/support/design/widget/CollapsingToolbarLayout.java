package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.ViewGroupUtils;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {

    /* JADX INFO: renamed from: a */
    final CollapsingTextHelper f641a;

    /* JADX INFO: renamed from: b */
    Drawable f642b;

    /* JADX INFO: renamed from: c */
    int f643c;

    /* JADX INFO: renamed from: d */
    WindowInsetsCompat f644d;

    /* JADX INFO: renamed from: e */
    private boolean f645e;

    /* JADX INFO: renamed from: f */
    private int f646f;

    /* JADX INFO: renamed from: g */
    private Toolbar f647g;

    /* JADX INFO: renamed from: h */
    private View f648h;

    /* JADX INFO: renamed from: i */
    private View f649i;

    /* JADX INFO: renamed from: j */
    private int f650j;

    /* JADX INFO: renamed from: k */
    private int f651k;

    /* JADX INFO: renamed from: l */
    private int f652l;

    /* JADX INFO: renamed from: m */
    private int f653m;

    /* JADX INFO: renamed from: n */
    private final Rect f654n;

    /* JADX INFO: renamed from: o */
    private boolean f655o;

    /* JADX INFO: renamed from: p */
    private boolean f656p;

    /* JADX INFO: renamed from: q */
    private Drawable f657q;

    /* JADX INFO: renamed from: r */
    private int f658r;

    /* JADX INFO: renamed from: s */
    private boolean f659s;

    /* JADX INFO: renamed from: t */
    private ValueAnimator f660t;

    /* JADX INFO: renamed from: u */
    private long f661u;

    /* JADX INFO: renamed from: v */
    private int f662v;

    /* JADX INFO: renamed from: w */
    private AppBarLayout.OnOffsetChangedListener f663w;

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f645e = true;
        this.f654n = new Rect();
        this.f662v = -1;
        ThemeUtils.m940a(context);
        this.f641a = new CollapsingTextHelper(this);
        this.f641a.m589a(AnimationUtils.f474e);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout, i, R.style.Widget_Design_CollapsingToolbar);
        this.f641a.m584a(typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.f641a.m594b(typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f653m = dimensionPixelSize;
        this.f652l = dimensionPixelSize;
        this.f651k = dimensionPixelSize;
        this.f650j = dimensionPixelSize;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f650j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.f652l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.f651k = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.f653m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.f655o = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayObtainStyledAttributes.getText(R.styleable.CollapsingToolbarLayout_title));
        this.f641a.m603d(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.f641a.m600c(android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.f641a.m603d(typedArrayObtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.f641a.m600c(typedArrayObtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.f662v = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.f661u = typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(typedArrayObtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayObtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        this.f646f = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        ViewCompat.m2584a(this, new OnApplyWindowInsetsListener() { // from class: android.support.design.widget.CollapsingToolbarLayout.1
            @Override // android.support.v4.view.OnApplyWindowInsetsListener
            /* JADX INFO: renamed from: a */
            public WindowInsetsCompat mo399a(View view, WindowInsetsCompat windowInsetsCompat) {
                return CollapsingToolbarLayout.this.m619a(windowInsetsCompat);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.m2595b(this, ViewCompat.m2614r((View) parent));
            if (this.f663w == null) {
                this.f663w = new OffsetUpdateListener();
            }
            ((AppBarLayout) parent).m419a(this.f663w);
            ViewCompat.m2613q(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.f663w != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).m422b(this.f663w);
        }
        super.onDetachedFromWindow();
    }

    /* JADX INFO: renamed from: a */
    WindowInsetsCompat m619a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.m2614r(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.m2436a(this.f644d, windowInsetsCompat2)) {
            this.f644d = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.m2775g();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        m613c();
        if (this.f647g == null && this.f657q != null && this.f658r > 0) {
            this.f657q.mutate().setAlpha(this.f658r);
            this.f657q.draw(canvas);
        }
        if (this.f655o && this.f656p) {
            this.f641a.m587a(canvas);
        }
        if (this.f642b != null && this.f658r > 0) {
            int iM2770b = this.f644d != null ? this.f644d.m2770b() : 0;
            if (iM2770b > 0) {
                this.f642b.setBounds(0, -this.f643c, getWidth(), iM2770b - this.f643c);
                this.f642b.mutate().setAlpha(this.f658r);
                this.f642b.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.f657q == null || this.f658r <= 0 || !m614c(view)) {
            z = false;
        } else {
            this.f657q.mutate().setAlpha(this.f658r);
            this.f657q.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j) || z;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f657q != null) {
            this.f657q.setBounds(0, 0, i, i2);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m613c() {
        Toolbar toolbar;
        if (this.f645e) {
            this.f647g = null;
            this.f648h = null;
            if (this.f646f != -1) {
                this.f647g = (Toolbar) findViewById(this.f646f);
                if (this.f647g != null) {
                    this.f648h = m615d(this.f647g);
                }
            }
            if (this.f647g == null) {
                int childCount = getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        toolbar = null;
                        break;
                    }
                    View childAt = getChildAt(i);
                    if (!(childAt instanceof Toolbar)) {
                        i++;
                    } else {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                }
                this.f647g = toolbar;
            }
            m616d();
            this.f645e = false;
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m614c(View view) {
        return (this.f648h == null || this.f648h == this) ? view == this.f647g : view == this.f648h;
    }

    /* JADX INFO: renamed from: d */
    private View m615d(View view) {
        View view2 = view;
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view2 = parent;
            }
        }
        return view2;
    }

    /* JADX INFO: renamed from: d */
    private void m616d() {
        if (!this.f655o && this.f649i != null) {
            ViewParent parent = this.f649i.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f649i);
            }
        }
        if (this.f655o && this.f647g != null) {
            if (this.f649i == null) {
                this.f649i = new View(getContext());
            }
            if (this.f649i.getParent() == null) {
                this.f647g.addView(this.f649i, -1, -1);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        m613c();
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int iM2770b = this.f644d != null ? this.f644d.m2770b() : 0;
        if (mode == 0 && iM2770b > 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(iM2770b + getMeasuredHeight(), 1073741824));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int titleMarginStart;
        int titleMarginEnd;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f644d != null) {
            int iM2770b = this.f644d.m2770b();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!ViewCompat.m2614r(childAt) && childAt.getTop() < iM2770b) {
                    ViewCompat.m2598c(childAt, iM2770b);
                }
            }
        }
        if (this.f655o && this.f649i != null) {
            this.f656p = ViewCompat.m2570B(this.f649i) && this.f649i.getVisibility() == 0;
            if (this.f656p) {
                boolean z2 = ViewCompat.m2601e(this) == 1;
                int iM622b = m622b(this.f648h != null ? this.f648h : this.f647g);
                ViewGroupUtils.m3172b(this, this.f649i, this.f654n);
                CollapsingTextHelper collapsingTextHelper = this.f641a;
                int i6 = this.f654n.left;
                if (z2) {
                    titleMarginStart = this.f647g.getTitleMarginEnd();
                } else {
                    titleMarginStart = this.f647g.getTitleMarginStart();
                }
                int i7 = i6 + titleMarginStart;
                int titleMarginTop = this.f647g.getTitleMarginTop() + this.f654n.top + iM622b;
                int i8 = this.f654n.right;
                if (z2) {
                    titleMarginEnd = this.f647g.getTitleMarginStart();
                } else {
                    titleMarginEnd = this.f647g.getTitleMarginEnd();
                }
                collapsingTextHelper.m595b(i7, titleMarginTop, titleMarginEnd + i8, (iM622b + this.f654n.bottom) - this.f647g.getTitleMarginBottom());
                this.f641a.m585a(z2 ? this.f652l : this.f650j, this.f654n.top + this.f651k, (i3 - i) - (z2 ? this.f650j : this.f652l), (i4 - i2) - this.f653m);
                this.f641a.m608i();
            }
        }
        int childCount2 = getChildCount();
        for (int i9 = 0; i9 < childCount2; i9++) {
            m611a(getChildAt(i9)).m942a();
        }
        if (this.f647g != null) {
            if (this.f655o && TextUtils.isEmpty(this.f641a.m609j())) {
                this.f641a.m590a(this.f647g.getTitle());
            }
            if (this.f648h == null || this.f648h == this) {
                setMinimumHeight(m617e(this.f647g));
            } else {
                setMinimumHeight(m617e(this.f648h));
            }
        }
        m623b();
    }

    /* JADX INFO: renamed from: e */
    private static int m617e(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + view.getHeight() + marginLayoutParams.topMargin;
    }

    /* JADX INFO: renamed from: a */
    static ViewOffsetHelper m611a(View view) {
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(R.id.view_offset_helper);
        if (viewOffsetHelper == null) {
            ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
            view.setTag(R.id.view_offset_helper, viewOffsetHelper2);
            return viewOffsetHelper2;
        }
        return viewOffsetHelper;
    }

    public void setTitle(CharSequence charSequence) {
        this.f641a.m590a(charSequence);
    }

    public CharSequence getTitle() {
        if (this.f655o) {
            return this.f641a.m609j();
        }
        return null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f655o) {
            this.f655o = z;
            m616d();
            requestLayout();
        }
    }

    public void setScrimsShown(boolean z) {
        mo621a(z, ViewCompat.m2621y(this) && !isInEditMode());
    }

    /* JADX INFO: renamed from: a */
    public void mo621a(boolean z, boolean z2) {
        if (this.f659s != z) {
            if (z2) {
                m612a(z ? 255 : 0);
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.f659s = z;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m612a(int i) {
        m613c();
        if (this.f660t == null) {
            this.f660t = new ValueAnimator();
            this.f660t.setDuration(this.f661u);
            this.f660t.setInterpolator(i > this.f658r ? AnimationUtils.f472c : AnimationUtils.f473d);
            this.f660t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.CollapsingToolbarLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else if (this.f660t.isRunning()) {
            this.f660t.cancel();
        }
        this.f660t.setIntValues(this.f658r, i);
        this.f660t.start();
    }

    void setScrimAlpha(int i) {
        if (i != this.f658r) {
            if (this.f657q != null && this.f647g != null) {
                ViewCompat.m2597c(this.f647g);
            }
            this.f658r = i;
            ViewCompat.m2597c(this);
        }
    }

    int getScrimAlpha() {
        return this.f658r;
    }

    public void setContentScrim(Drawable drawable) {
        if (this.f657q != drawable) {
            if (this.f657q != null) {
                this.f657q.setCallback(null);
            }
            this.f657q = drawable != null ? drawable.mutate() : null;
            if (this.f657q != null) {
                this.f657q.setBounds(0, 0, getWidth(), getHeight());
                this.f657q.setCallback(this);
                this.f657q.setAlpha(this.f658r);
            }
            ViewCompat.m2597c(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(ContextCompat.m1832a(getContext(), i));
    }

    public Drawable getContentScrim() {
        return this.f657q;
    }

    public void setStatusBarScrim(Drawable drawable) {
        if (this.f642b != drawable) {
            if (this.f642b != null) {
                this.f642b.setCallback(null);
            }
            this.f642b = drawable != null ? drawable.mutate() : null;
            if (this.f642b != null) {
                if (this.f642b.isStateful()) {
                    this.f642b.setState(getDrawableState());
                }
                DrawableCompat.m1995b(this.f642b, ViewCompat.m2601e(this));
                this.f642b.setVisible(getVisibility() == 0, false);
                this.f642b.setCallback(this);
                this.f642b.setAlpha(this.f658r);
            }
            ViewCompat.m2597c(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        boolean zM591a = false;
        Drawable drawable = this.f642b;
        if (drawable != null && drawable.isStateful()) {
            zM591a = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f657q;
        if (drawable2 != null && drawable2.isStateful()) {
            zM591a |= drawable2.setState(drawableState);
        }
        if (this.f641a != null) {
            zM591a |= this.f641a.m591a(drawableState);
        }
        if (zM591a) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f657q || drawable == this.f642b;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f642b != null && this.f642b.isVisible() != z) {
            this.f642b.setVisible(z, false);
        }
        if (this.f657q != null && this.f657q.isVisible() != z) {
            this.f657q.setVisible(z, false);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(ContextCompat.m1832a(getContext(), i));
    }

    public Drawable getStatusBarScrim() {
        return this.f642b;
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.f641a.m600c(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f641a.m586a(colorStateList);
    }

    public void setCollapsedTitleGravity(int i) {
        this.f641a.m594b(i);
    }

    public int getCollapsedTitleGravity() {
        return this.f641a.m599c();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.f641a.m603d(i);
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f641a.m596b(colorStateList);
    }

    public void setExpandedTitleGravity(int i) {
        this.f641a.m584a(i);
    }

    public int getExpandedTitleGravity() {
        return this.f641a.m592b();
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f641a.m588a(typeface);
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f641a.m602d();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f641a.m597b(typeface);
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f641a.m604e();
    }

    public int getExpandedTitleMarginStart() {
        return this.f650j;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f650j = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.f651k;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.f651k = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.f652l;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.f652l = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f653m;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.f653m = i;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.f662v != i) {
            this.f662v = i;
            m623b();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        if (this.f662v >= 0) {
            return this.f662v;
        }
        int iM2770b = this.f644d != null ? this.f644d.m2770b() : 0;
        int iM2607k = ViewCompat.m2607k(this);
        if (iM2607k > 0) {
            return Math.min(iM2770b + (iM2607k * 2), getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j) {
        this.f661u = j;
    }

    public long getScrimAnimationDuration() {
        return this.f661u;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a */
        int f666a;

        /* JADX INFO: renamed from: b */
        float f667b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f666a = 0;
            this.f667b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.f666a = typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            m624a(typedArrayObtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f666a = 0;
            this.f667b = 0.5f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f666a = 0;
            this.f667b = 0.5f;
        }

        /* JADX INFO: renamed from: a */
        public void m624a(float f) {
            this.f667b = f;
        }
    }

    /* JADX INFO: renamed from: b */
    final void m623b() {
        if (this.f657q != null || this.f642b != null) {
            setScrimsShown(getHeight() + this.f643c < getScrimVisibleHeightTrigger());
        }
    }

    /* JADX INFO: renamed from: b */
    final int m622b(View view) {
        return ((getHeight() - m611a(view).m946c()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        /* JADX INFO: renamed from: a */
        public void mo472a(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout.this.f643c = i;
            int iM2770b = CollapsingToolbarLayout.this.f644d != null ? CollapsingToolbarLayout.this.f644d.m2770b() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper viewOffsetHelperM611a = CollapsingToolbarLayout.m611a(childAt);
                switch (layoutParams.f666a) {
                    case 1:
                        viewOffsetHelperM611a.m943a(MathUtils.m2025a(-i, 0, CollapsingToolbarLayout.this.m622b(childAt)));
                        break;
                    case 2:
                        viewOffsetHelperM611a.m943a(Math.round(layoutParams.f667b * (-i)));
                        break;
                }
            }
            CollapsingToolbarLayout.this.m623b();
            if (CollapsingToolbarLayout.this.f642b != null && iM2770b > 0) {
                ViewCompat.m2597c(CollapsingToolbarLayout.this);
            }
            CollapsingToolbarLayout.this.f641a.m593b(Math.abs(i) / ((CollapsingToolbarLayout.this.getHeight() - ViewCompat.m2607k(CollapsingToolbarLayout.this)) - iM2770b));
        }
    }
}
