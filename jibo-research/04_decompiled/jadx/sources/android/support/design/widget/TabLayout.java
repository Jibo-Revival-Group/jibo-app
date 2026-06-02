package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.R;
import android.support.v4.util.Pools;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.TooltipCompat;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: n */
    private static final Pools.Pool<Tab> f848n = new Pools.SynchronizedPool(16);

    /* JADX INFO: renamed from: A */
    private DataSetObserver f849A;

    /* JADX INFO: renamed from: B */
    private TabLayoutOnPageChangeListener f850B;

    /* JADX INFO: renamed from: C */
    private AdapterChangeListener f851C;

    /* JADX INFO: renamed from: D */
    private boolean f852D;

    /* JADX INFO: renamed from: E */
    private final Pools.Pool<TabView> f853E;

    /* JADX INFO: renamed from: a */
    int f854a;

    /* JADX INFO: renamed from: b */
    int f855b;

    /* JADX INFO: renamed from: c */
    int f856c;

    /* JADX INFO: renamed from: d */
    int f857d;

    /* JADX INFO: renamed from: e */
    int f858e;

    /* JADX INFO: renamed from: f */
    ColorStateList f859f;

    /* JADX INFO: renamed from: g */
    float f860g;

    /* JADX INFO: renamed from: h */
    float f861h;

    /* JADX INFO: renamed from: i */
    final int f862i;

    /* JADX INFO: renamed from: j */
    int f863j;

    /* JADX INFO: renamed from: k */
    int f864k;

    /* JADX INFO: renamed from: l */
    int f865l;

    /* JADX INFO: renamed from: m */
    ViewPager f866m;

    /* JADX INFO: renamed from: o */
    private final ArrayList<Tab> f867o;

    /* JADX INFO: renamed from: p */
    private Tab f868p;

    /* JADX INFO: renamed from: q */
    private final SlidingTabStrip f869q;

    /* JADX INFO: renamed from: r */
    private final int f870r;

    /* JADX INFO: renamed from: s */
    private final int f871s;

    /* JADX INFO: renamed from: t */
    private final int f872t;

    /* JADX INFO: renamed from: u */
    private int f873u;

    /* JADX INFO: renamed from: v */
    private OnTabSelectedListener f874v;

    /* JADX INFO: renamed from: w */
    private final ArrayList<OnTabSelectedListener> f875w;

    /* JADX INFO: renamed from: x */
    private OnTabSelectedListener f876x;

    /* JADX INFO: renamed from: y */
    private ValueAnimator f877y;

    /* JADX INFO: renamed from: z */
    private PagerAdapter f878z;

    public interface OnTabSelectedListener {
        /* JADX INFO: renamed from: a */
        void mo879a(Tab tab);

        /* JADX INFO: renamed from: b */
        void mo880b(Tab tab);

        /* JADX INFO: renamed from: c */
        void mo881c(Tab tab);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f867o = new ArrayList<>();
        this.f863j = Integer.MAX_VALUE;
        this.f875w = new ArrayList<>();
        this.f853E = new Pools.SimplePool(12);
        ThemeUtils.m940a(context);
        setHorizontalScrollBarEnabled(false);
        this.f869q = new SlidingTabStrip(context);
        super.addView(this.f869q, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TabLayout, i, R.style.Widget_Design_TabLayout);
        this.f869q.m888b(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, 0));
        this.f869q.m883a(typedArrayObtainStyledAttributes.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.f857d = dimensionPixelSize;
        this.f856c = dimensionPixelSize;
        this.f855b = dimensionPixelSize;
        this.f854a = dimensionPixelSize;
        this.f854a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.f854a);
        this.f855b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.f855b);
        this.f856c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.f856c);
        this.f857d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.f857d);
        this.f858e = typedArrayObtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(this.f858e, android.support.v7.appcompat.R.styleable.TextAppearance);
        try {
            this.f860g = typedArrayObtainStyledAttributes2.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.f859f = typedArrayObtainStyledAttributes2.getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes2.recycle();
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.TabLayout_tabTextColor)) {
                this.f859f = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.TabLayout_tabTextColor);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
                this.f859f = m843a(this.f859f.getDefaultColor(), typedArrayObtainStyledAttributes.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.f870r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.f871s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.f862i = typedArrayObtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.f873u = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.f865l = typedArrayObtainStyledAttributes.getInt(R.styleable.TabLayout_tabMode, 1);
            this.f864k = typedArrayObtainStyledAttributes.getInt(R.styleable.TabLayout_tabGravity, 0);
            typedArrayObtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.f861h = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.f872t = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            m858g();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.f869q.m883a(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.f869q.m888b(i);
    }

    /* JADX INFO: renamed from: a */
    public void m862a(int i, float f, boolean z) {
        m863a(i, f, z, true);
    }

    /* JADX INFO: renamed from: a */
    void m863a(int i, float f, boolean z, boolean z2) {
        int iRound = Math.round(i + f);
        if (iRound >= 0 && iRound < this.f869q.getChildCount()) {
            if (z2) {
                this.f869q.m884a(i, f);
            }
            if (this.f877y != null && this.f877y.isRunning()) {
                this.f877y.cancel();
            }
            scrollTo(m842a(i, f), 0);
            if (z) {
                setSelectedTabView(iRound);
            }
        }
    }

    private float getScrollPosition() {
        return this.f869q.m887b();
    }

    /* JADX INFO: renamed from: a */
    public void m865a(Tab tab) {
        m867a(tab, this.f867o.isEmpty());
    }

    /* JADX INFO: renamed from: a */
    public void m867a(Tab tab, boolean z) {
        m866a(tab, this.f867o.size(), z);
    }

    /* JADX INFO: renamed from: a */
    public void m866a(Tab tab, int i, boolean z) {
        if (tab.f899a != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        m845a(tab, i);
        m853d(tab);
        if (z) {
            tab.m900e();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m844a(TabItem tabItem) {
        Tab tabM860a = m860a();
        if (tabItem.f845a != null) {
            tabM860a.m893a(tabItem.f845a);
        }
        if (tabItem.f846b != null) {
            tabM860a.m891a(tabItem.f846b);
        }
        if (tabItem.f847c != 0) {
            tabM860a.m890a(tabItem.f847c);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            tabM860a.m896b(tabItem.getContentDescription());
        }
        m865a(tabM860a);
    }

    @Deprecated
    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        if (this.f874v != null) {
            m873b(this.f874v);
        }
        this.f874v = onTabSelectedListener;
        if (onTabSelectedListener != null) {
            m864a(onTabSelectedListener);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m864a(OnTabSelectedListener onTabSelectedListener) {
        if (!this.f875w.contains(onTabSelectedListener)) {
            this.f875w.add(onTabSelectedListener);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m873b(OnTabSelectedListener onTabSelectedListener) {
        this.f875w.remove(onTabSelectedListener);
    }

    /* JADX INFO: renamed from: a */
    public Tab m860a() {
        Tab tabMo2438a = f848n.mo2438a();
        if (tabMo2438a == null) {
            tabMo2438a = new Tab();
        }
        tabMo2438a.f899a = this;
        tabMo2438a.f900b = m849c(tabMo2438a);
        return tabMo2438a;
    }

    public int getTabCount() {
        return this.f867o.size();
    }

    /* JADX INFO: renamed from: a */
    public Tab m861a(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.f867o.get(i);
    }

    public int getSelectedTabPosition() {
        if (this.f868p != null) {
            return this.f868p.m898c();
        }
        return -1;
    }

    /* JADX INFO: renamed from: b */
    public void m872b() {
        for (int childCount = this.f869q.getChildCount() - 1; childCount >= 0; childCount--) {
            m850c(childCount);
        }
        Iterator<Tab> it = this.f867o.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.m904i();
            f848n.mo2439a(next);
        }
        this.f868p = null;
    }

    public void setTabMode(int i) {
        if (i != this.f865l) {
            this.f865l = i;
            m858g();
        }
    }

    public int getTabMode() {
        return this.f865l;
    }

    public void setTabGravity(int i) {
        if (this.f864k != i) {
            this.f864k = i;
            m858g();
        }
    }

    public int getTabGravity() {
        return this.f864k;
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f859f != colorStateList) {
            this.f859f = colorStateList;
            m851d();
        }
    }

    public ColorStateList getTabTextColors() {
        return this.f859f;
    }

    public void setupWithViewPager(ViewPager viewPager) {
        m869a(viewPager, true);
    }

    /* JADX INFO: renamed from: a */
    public void m869a(ViewPager viewPager, boolean z) {
        m846a(viewPager, z, false);
    }

    /* JADX INFO: renamed from: a */
    private void m846a(ViewPager viewPager, boolean z, boolean z2) {
        if (this.f866m != null) {
            if (this.f850B != null) {
                this.f866m.m2724b(this.f850B);
            }
            if (this.f851C != null) {
                this.f866m.m2723b(this.f851C);
            }
        }
        if (this.f876x != null) {
            m873b(this.f876x);
            this.f876x = null;
        }
        if (viewPager != null) {
            this.f866m = viewPager;
            if (this.f850B == null) {
                this.f850B = new TabLayoutOnPageChangeListener(this);
            }
            this.f850B.m905a();
            viewPager.m2715a(this.f850B);
            this.f876x = new ViewPagerOnTabSelectedListener(viewPager);
            m864a(this.f876x);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                m868a(adapter, z);
            }
            if (this.f851C == null) {
                this.f851C = new AdapterChangeListener();
            }
            this.f851C.m878a(z);
            viewPager.m2714a(this.f851C);
            m862a(viewPager.getCurrentItem(), CropImageView.DEFAULT_ASPECT_RATIO, true);
        } else {
            this.f866m = null;
            m868a((PagerAdapter) null, false);
        }
        this.f852D = z2;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        m868a(pagerAdapter, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f866m == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                m846a((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f852D) {
            setupWithViewPager(null);
            this.f852D = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f869q.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    /* JADX INFO: renamed from: a */
    void m868a(PagerAdapter pagerAdapter, boolean z) {
        if (this.f878z != null && this.f849A != null) {
            this.f878z.m2556b(this.f849A);
        }
        this.f878z = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.f849A == null) {
                this.f849A = new PagerAdapterObserver();
            }
            pagerAdapter.m2552a(this.f849A);
        }
        m876c();
    }

    /* JADX INFO: renamed from: c */
    void m876c() {
        int currentItem;
        m872b();
        if (this.f878z != null) {
            int iMo2555b = this.f878z.mo2555b();
            for (int i = 0; i < iMo2555b; i++) {
                m867a(m860a().m893a(this.f878z.m2559c(i)), false);
            }
            if (this.f866m != null && iMo2555b > 0 && (currentItem = this.f866m.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                m874b(m861a(currentItem));
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m851d() {
        int size = this.f867o.size();
        for (int i = 0; i < size; i++) {
            this.f867o.get(i).m903h();
        }
    }

    /* JADX INFO: renamed from: c */
    private TabView m849c(Tab tab) {
        TabView tabViewMo2438a = this.f853E != null ? this.f853E.mo2438a() : null;
        if (tabViewMo2438a == null) {
            tabViewMo2438a = new TabView(getContext());
        }
        tabViewMo2438a.m912a(tab);
        tabViewMo2438a.setFocusable(true);
        tabViewMo2438a.setMinimumWidth(getTabMinWidth());
        return tabViewMo2438a;
    }

    /* JADX INFO: renamed from: a */
    private void m845a(Tab tab, int i) {
        tab.m897b(i);
        this.f867o.add(i, tab);
        int size = this.f867o.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            this.f867o.get(i2).m897b(i2);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m853d(Tab tab) {
        this.f869q.addView(tab.f900b, tab.m898c(), m854e());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        m847a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        m847a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m847a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        m847a(view);
    }

    /* JADX INFO: renamed from: a */
    private void m847a(View view) {
        if (view instanceof TabItem) {
            m844a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    /* JADX INFO: renamed from: e */
    private LinearLayout.LayoutParams m854e() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        m848a(layoutParams);
        return layoutParams;
    }

    /* JADX INFO: renamed from: a */
    private void m848a(LinearLayout.LayoutParams layoutParams) {
        if (this.f865l == 1 && this.f864k == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = CropImageView.DEFAULT_ASPECT_RATIO;
        }
    }

    /* JADX INFO: renamed from: b */
    int m871b(int i) {
        return Math.round(getResources().getDisplayMetrics().density * i);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int iM871b = m871b(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        switch (View.MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(iM871b, View.MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = View.MeasureSpec.makeMeasureSpec(iM871b, 1073741824);
                break;
        }
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            this.f863j = this.f871s > 0 ? this.f871s : size - m871b(56);
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.f865l) {
                case 0:
                    z = childAt.getMeasuredWidth() < getMeasuredWidth();
                    break;
                case 1:
                    z = childAt.getMeasuredWidth() != getMeasuredWidth();
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m850c(int i) {
        TabView tabView = (TabView) this.f869q.getChildAt(i);
        this.f869q.removeViewAt(i);
        if (tabView != null) {
            tabView.m911a();
            this.f853E.mo2439a(tabView);
        }
        requestLayout();
    }

    /* JADX INFO: renamed from: d */
    private void m852d(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !ViewCompat.m2621y(this) || this.f869q.m886a()) {
                m862a(i, CropImageView.DEFAULT_ASPECT_RATIO, true);
                return;
            }
            int scrollX = getScrollX();
            int iM842a = m842a(i, CropImageView.DEFAULT_ASPECT_RATIO);
            if (scrollX != iM842a) {
                m856f();
                this.f877y.setIntValues(scrollX, iM842a);
                this.f877y.start();
            }
            this.f869q.m889b(i, 300);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m856f() {
        if (this.f877y == null) {
            this.f877y = new ValueAnimator();
            this.f877y.setInterpolator(AnimationUtils.f471b);
            this.f877y.setDuration(300L);
            this.f877y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.TabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        m856f();
        this.f877y.addListener(animatorListener);
    }

    private void setSelectedTabView(int i) {
        int childCount = this.f869q.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                this.f869q.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m874b(Tab tab) {
        m875b(tab, true);
    }

    /* JADX INFO: renamed from: b */
    void m875b(Tab tab, boolean z) {
        Tab tab2 = this.f868p;
        if (tab2 == tab) {
            if (tab2 != null) {
                m859g(tab);
                m852d(tab.m898c());
                return;
            }
            return;
        }
        int iM898c = tab != null ? tab.m898c() : -1;
        if (z) {
            if ((tab2 == null || tab2.m898c() == -1) && iM898c != -1) {
                m862a(iM898c, CropImageView.DEFAULT_ASPECT_RATIO, true);
            } else {
                m852d(iM898c);
            }
            if (iM898c != -1) {
                setSelectedTabView(iM898c);
            }
        }
        if (tab2 != null) {
            m857f(tab2);
        }
        this.f868p = tab;
        if (tab != null) {
            m855e(tab);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m855e(Tab tab) {
        for (int size = this.f875w.size() - 1; size >= 0; size--) {
            this.f875w.get(size).mo879a(tab);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m857f(Tab tab) {
        for (int size = this.f875w.size() - 1; size >= 0; size--) {
            this.f875w.get(size).mo880b(tab);
        }
    }

    /* JADX INFO: renamed from: g */
    private void m859g(Tab tab) {
        for (int size = this.f875w.size() - 1; size >= 0; size--) {
            this.f875w.get(size).mo881c(tab);
        }
    }

    /* JADX INFO: renamed from: a */
    private int m842a(int i, float f) {
        if (this.f865l != 0) {
            return 0;
        }
        View childAt = this.f869q.getChildAt(i);
        View childAt2 = i + 1 < this.f869q.getChildCount() ? this.f869q.getChildAt(i + 1) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i2 = (int) ((width2 + width) * 0.5f * f);
        return ViewCompat.m2601e(this) == 0 ? i2 + left : left - i2;
    }

    /* JADX INFO: renamed from: g */
    private void m858g() {
        ViewCompat.m2594b(this.f869q, this.f865l == 0 ? Math.max(0, this.f873u - this.f854a) : 0, 0, 0, 0);
        switch (this.f865l) {
            case 0:
                this.f869q.setGravity(8388611);
                break;
            case 1:
                this.f869q.setGravity(1);
                break;
        }
        m870a(true);
    }

    /* JADX INFO: renamed from: a */
    void m870a(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f869q.getChildCount()) {
                View childAt = this.f869q.getChildAt(i2);
                childAt.setMinimumWidth(getTabMinWidth());
                m848a((LinearLayout.LayoutParams) childAt.getLayoutParams());
                if (z) {
                    childAt.requestLayout();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public static final class Tab {

        /* JADX INFO: renamed from: a */
        TabLayout f899a;

        /* JADX INFO: renamed from: b */
        TabView f900b;

        /* JADX INFO: renamed from: c */
        private Object f901c;

        /* JADX INFO: renamed from: d */
        private Drawable f902d;

        /* JADX INFO: renamed from: e */
        private CharSequence f903e;

        /* JADX INFO: renamed from: f */
        private CharSequence f904f;

        /* JADX INFO: renamed from: g */
        private int f905g = -1;

        /* JADX INFO: renamed from: h */
        private View f906h;

        Tab() {
        }

        /* JADX INFO: renamed from: a */
        public View m894a() {
            return this.f906h;
        }

        /* JADX INFO: renamed from: a */
        public Tab m892a(View view) {
            this.f906h = view;
            m903h();
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Tab m890a(int i) {
            return m892a(LayoutInflater.from(this.f900b.getContext()).inflate(i, (ViewGroup) this.f900b, false));
        }

        /* JADX INFO: renamed from: b */
        public Drawable m895b() {
            return this.f902d;
        }

        /* JADX INFO: renamed from: c */
        public int m898c() {
            return this.f905g;
        }

        /* JADX INFO: renamed from: b */
        void m897b(int i) {
            this.f905g = i;
        }

        /* JADX INFO: renamed from: d */
        public CharSequence m899d() {
            return this.f903e;
        }

        /* JADX INFO: renamed from: a */
        public Tab m891a(Drawable drawable) {
            this.f902d = drawable;
            m903h();
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Tab m893a(CharSequence charSequence) {
            this.f903e = charSequence;
            m903h();
            return this;
        }

        /* JADX INFO: renamed from: e */
        public void m900e() {
            if (this.f899a == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.f899a.m874b(this);
        }

        /* JADX INFO: renamed from: f */
        public boolean m901f() {
            if (this.f899a == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return this.f899a.getSelectedTabPosition() == this.f905g;
        }

        /* JADX INFO: renamed from: b */
        public Tab m896b(CharSequence charSequence) {
            this.f904f = charSequence;
            m903h();
            return this;
        }

        /* JADX INFO: renamed from: g */
        public CharSequence m902g() {
            return this.f904f;
        }

        /* JADX INFO: renamed from: h */
        void m903h() {
            if (this.f900b != null) {
                this.f900b.m913b();
            }
        }

        /* JADX INFO: renamed from: i */
        void m904i() {
            this.f899a = null;
            this.f900b = null;
            this.f901c = null;
            this.f902d = null;
            this.f903e = null;
            this.f904f = null;
            this.f905g = -1;
            this.f906h = null;
        }
    }

    class TabView extends LinearLayout {

        /* JADX INFO: renamed from: b */
        private Tab f911b;

        /* JADX INFO: renamed from: c */
        private TextView f912c;

        /* JADX INFO: renamed from: d */
        private ImageView f913d;

        /* JADX INFO: renamed from: e */
        private View f914e;

        /* JADX INFO: renamed from: f */
        private TextView f915f;

        /* JADX INFO: renamed from: g */
        private ImageView f916g;

        /* JADX INFO: renamed from: h */
        private int f917h;

        public TabView(Context context) {
            super(context);
            this.f917h = 2;
            if (TabLayout.this.f862i != 0) {
                ViewCompat.m2582a(this, AppCompatResources.m3426b(context, TabLayout.this.f862i));
            }
            ViewCompat.m2594b(this, TabLayout.this.f854a, TabLayout.this.f855b, TabLayout.this.f856c, TabLayout.this.f857d);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.m2585a(this, PointerIconCompat.m2567a(getContext(), 1002));
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f911b != null) {
                if (!zPerformClick) {
                    playSoundEffect(0);
                }
                this.f911b.m900e();
                return true;
            }
            return zPerformClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            if (this.f912c != null) {
                this.f912c.setSelected(z);
            }
            if (this.f913d != null) {
                this.f913d.setSelected(z);
            }
            if (this.f914e != null) {
                this.f914e.setSelected(z);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            boolean z = true;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f863j, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.f912c != null) {
                getResources();
                float f = TabLayout.this.f860g;
                int i3 = this.f917h;
                if (this.f913d != null && this.f913d.getVisibility() == 0) {
                    i3 = 1;
                } else if (this.f912c != null && this.f912c.getLineCount() > 1) {
                    f = TabLayout.this.f861h;
                }
                float textSize = this.f912c.getTextSize();
                int lineCount = this.f912c.getLineCount();
                int iM3116a = TextViewCompat.m3116a(this.f912c);
                if (f != textSize || (iM3116a >= 0 && i3 != iM3116a)) {
                    if (TabLayout.this.f865l == 1 && f > textSize && lineCount == 1 && ((layout = this.f912c.getLayout()) == null || m909a(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.f912c.setTextSize(0, f);
                        this.f912c.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m912a(Tab tab) {
            if (tab != this.f911b) {
                this.f911b = tab;
                m913b();
            }
        }

        /* JADX INFO: renamed from: a */
        void m911a() {
            m912a(null);
            setSelected(false);
        }

        /* JADX INFO: renamed from: b */
        final void m913b() {
            Tab tab = this.f911b;
            View viewM894a = tab != null ? tab.m894a() : null;
            if (viewM894a != null) {
                ViewParent parent = viewM894a.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewM894a);
                    }
                    addView(viewM894a);
                }
                this.f914e = viewM894a;
                if (this.f912c != null) {
                    this.f912c.setVisibility(8);
                }
                if (this.f913d != null) {
                    this.f913d.setVisibility(8);
                    this.f913d.setImageDrawable(null);
                }
                this.f915f = (TextView) viewM894a.findViewById(android.R.id.text1);
                if (this.f915f != null) {
                    this.f917h = TextViewCompat.m3116a(this.f915f);
                }
                this.f916g = (ImageView) viewM894a.findViewById(android.R.id.icon);
            } else {
                if (this.f914e != null) {
                    removeView(this.f914e);
                    this.f914e = null;
                }
                this.f915f = null;
                this.f916g = null;
            }
            if (this.f914e == null) {
                if (this.f913d == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView, 0);
                    this.f913d = imageView;
                }
                if (this.f912c == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView);
                    this.f912c = textView;
                    this.f917h = TextViewCompat.m3116a(this.f912c);
                }
                TextViewCompat.m3117a(this.f912c, TabLayout.this.f858e);
                if (TabLayout.this.f859f != null) {
                    this.f912c.setTextColor(TabLayout.this.f859f);
                }
                m910a(this.f912c, this.f913d);
            } else if (this.f915f != null || this.f916g != null) {
                m910a(this.f915f, this.f916g);
            }
            setSelected(tab != null && tab.m901f());
        }

        /* JADX INFO: renamed from: a */
        private void m910a(TextView textView, ImageView imageView) {
            Drawable drawableM895b = this.f911b != null ? this.f911b.m895b() : null;
            CharSequence charSequenceM899d = this.f911b != null ? this.f911b.m899d() : null;
            CharSequence charSequenceM902g = this.f911b != null ? this.f911b.m902g() : null;
            if (imageView != null) {
                if (drawableM895b != null) {
                    imageView.setImageDrawable(drawableM895b);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(charSequenceM902g);
            }
            boolean z = !TextUtils.isEmpty(charSequenceM899d);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequenceM899d);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
                textView.setContentDescription(charSequenceM902g);
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iM871b = (z && imageView.getVisibility() == 0) ? TabLayout.this.m871b(8) : 0;
                if (iM871b != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iM871b;
                    imageView.requestLayout();
                }
            }
            TooltipCompat.m4985a(this, z ? null : charSequenceM902g);
        }

        /* JADX INFO: renamed from: a */
        private float m909a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }
    }

    private class SlidingTabStrip extends LinearLayout {

        /* JADX INFO: renamed from: a */
        int f883a;

        /* JADX INFO: renamed from: b */
        float f884b;

        /* JADX INFO: renamed from: d */
        private int f886d;

        /* JADX INFO: renamed from: e */
        private final Paint f887e;

        /* JADX INFO: renamed from: f */
        private int f888f;

        /* JADX INFO: renamed from: g */
        private int f889g;

        /* JADX INFO: renamed from: h */
        private int f890h;

        /* JADX INFO: renamed from: i */
        private ValueAnimator f891i;

        SlidingTabStrip(Context context) {
            super(context);
            this.f883a = -1;
            this.f888f = -1;
            this.f889g = -1;
            this.f890h = -1;
            setWillNotDraw(false);
            this.f887e = new Paint();
        }

        /* JADX INFO: renamed from: a */
        void m883a(int i) {
            if (this.f887e.getColor() != i) {
                this.f887e.setColor(i);
                ViewCompat.m2597c(this);
            }
        }

        /* JADX INFO: renamed from: b */
        void m888b(int i) {
            if (this.f886d != i) {
                this.f886d = i;
                ViewCompat.m2597c(this);
            }
        }

        /* JADX INFO: renamed from: a */
        boolean m886a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        void m884a(int i, float f) {
            if (this.f891i != null && this.f891i.isRunning()) {
                this.f891i.cancel();
            }
            this.f883a = i;
            this.f884b = f;
            m882c();
        }

        /* JADX INFO: renamed from: b */
        float m887b() {
            return this.f883a + this.f884b;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT < 23 && this.f888f != i) {
                requestLayout();
                this.f888f = i;
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            boolean z;
            boolean z2 = false;
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824 && TabLayout.this.f865l == 1 && TabLayout.this.f864k == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                int iMax = 0;
                while (i3 < childCount) {
                    View childAt = getChildAt(i3);
                    i3++;
                    iMax = childAt.getVisibility() == 0 ? Math.max(iMax, childAt.getMeasuredWidth()) : iMax;
                }
                if (iMax > 0) {
                    if (iMax * childCount <= getMeasuredWidth() - (TabLayout.this.m871b(16) * 2)) {
                        int i4 = 0;
                        while (i4 < childCount) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                            if (layoutParams.width == iMax && layoutParams.weight == CropImageView.DEFAULT_ASPECT_RATIO) {
                                z = z2;
                            } else {
                                layoutParams.width = iMax;
                                layoutParams.weight = CropImageView.DEFAULT_ASPECT_RATIO;
                                z = true;
                            }
                            i4++;
                            z2 = z;
                        }
                    } else {
                        TabLayout.this.f864k = 0;
                        TabLayout.this.m870a(false);
                        z2 = true;
                    }
                    if (z2) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f891i != null && this.f891i.isRunning()) {
                this.f891i.cancel();
                m889b(this.f883a, Math.round(this.f891i.getDuration() * (1.0f - this.f891i.getAnimatedFraction())));
                return;
            }
            m882c();
        }

        /* JADX INFO: renamed from: c */
        private void m882c() {
            int right;
            int left;
            View childAt = getChildAt(this.f883a);
            if (childAt != null && childAt.getWidth() > 0) {
                left = childAt.getLeft();
                right = childAt.getRight();
                if (this.f884b > CropImageView.DEFAULT_ASPECT_RATIO && this.f883a < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f883a + 1);
                    left = (int) ((left * (1.0f - this.f884b)) + (this.f884b * childAt2.getLeft()));
                    right = (int) ((right * (1.0f - this.f884b)) + (childAt2.getRight() * this.f884b));
                }
            } else {
                right = -1;
                left = -1;
            }
            m885a(left, right);
        }

        /* JADX INFO: renamed from: a */
        void m885a(int i, int i2) {
            if (i != this.f889g || i2 != this.f890h) {
                this.f889g = i;
                this.f890h = i2;
                ViewCompat.m2597c(this);
            }
        }

        /* JADX INFO: renamed from: b */
        void m889b(final int i, int i2) {
            final int i3;
            final int i4;
            if (this.f891i != null && this.f891i.isRunning()) {
                this.f891i.cancel();
            }
            boolean z = ViewCompat.m2601e(this) == 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                m882c();
                return;
            }
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (Math.abs(i - this.f883a) <= 1) {
                i4 = this.f889g;
                i3 = this.f890h;
            } else {
                int iM871b = TabLayout.this.m871b(24);
                if (i < this.f883a) {
                    if (z) {
                        i3 = left - iM871b;
                        i4 = i3;
                    } else {
                        i3 = right + iM871b;
                        i4 = i3;
                    }
                } else if (z) {
                    i3 = right + iM871b;
                    i4 = i3;
                } else {
                    i3 = left - iM871b;
                    i4 = i3;
                }
            }
            if (i4 != left || i3 != right) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f891i = valueAnimator;
                valueAnimator.setInterpolator(AnimationUtils.f471b);
                valueAnimator.setDuration(i2);
                valueAnimator.setFloatValues(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.TabLayout.SlidingTabStrip.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        float animatedFraction = valueAnimator2.getAnimatedFraction();
                        SlidingTabStrip.this.m885a(AnimationUtils.m409a(i4, left, animatedFraction), AnimationUtils.m409a(i3, right, animatedFraction));
                    }
                });
                valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.TabLayout.SlidingTabStrip.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        SlidingTabStrip.this.f883a = i;
                        SlidingTabStrip.this.f884b = CropImageView.DEFAULT_ASPECT_RATIO;
                    }
                });
                valueAnimator.start();
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.f889g >= 0 && this.f890h > this.f889g) {
                canvas.drawRect(this.f889g, getHeight() - this.f886d, this.f890h, getHeight(), this.f887e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static ColorStateList m843a(int i, int i2) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i});
    }

    private int getDefaultHeight() {
        boolean z;
        int size = this.f867o.size();
        int i = 0;
        while (true) {
            if (i < size) {
                Tab tab = this.f867o.get(i);
                if (tab == null || tab.m895b() == null || TextUtils.isEmpty(tab.m899d())) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        return z ? 72 : 48;
    }

    private int getTabMinWidth() {
        if (this.f870r != -1) {
            return this.f870r;
        }
        if (this.f865l == 0) {
            return this.f872t;
        }
        return 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.f863j;
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a */
        private final WeakReference<TabLayout> f907a;

        /* JADX INFO: renamed from: b */
        private int f908b;

        /* JADX INFO: renamed from: c */
        private int f909c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.f907a = new WeakReference<>(tabLayout);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        /* JADX INFO: renamed from: a */
        public void mo906a(int i) {
            this.f908b = this.f909c;
            this.f909c = i;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        /* JADX INFO: renamed from: a */
        public void mo907a(int i, float f, int i2) {
            TabLayout tabLayout = this.f907a.get();
            if (tabLayout != null) {
                tabLayout.m863a(i, f, this.f909c != 2 || this.f908b == 1, (this.f909c == 2 && this.f908b == 0) ? false : true);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        /* JADX INFO: renamed from: b */
        public void mo908b(int i) {
            TabLayout tabLayout = this.f907a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                tabLayout.m875b(tabLayout.m861a(i), this.f909c == 0 || (this.f909c == 2 && this.f908b == 0));
            }
        }

        /* JADX INFO: renamed from: a */
        void m905a() {
            this.f909c = 0;
            this.f908b = 0;
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {

        /* JADX INFO: renamed from: a */
        private final ViewPager f918a;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.f918a = viewPager;
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        /* JADX INFO: renamed from: a */
        public void mo879a(Tab tab) {
            this.f918a.setCurrentItem(tab.m898c());
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        /* JADX INFO: renamed from: b */
        public void mo880b(Tab tab) {
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        /* JADX INFO: renamed from: c */
        public void mo881c(Tab tab) {
        }
    }

    private class PagerAdapterObserver extends DataSetObserver {
        PagerAdapterObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.m876c();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.m876c();
        }
    }

    private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {

        /* JADX INFO: renamed from: b */
        private boolean f881b;

        AdapterChangeListener() {
        }

        @Override // android.support.v4.view.ViewPager.OnAdapterChangeListener
        /* JADX INFO: renamed from: a */
        public void mo877a(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            if (TabLayout.this.f866m == viewPager) {
                TabLayout.this.m868a(pagerAdapter2, this.f881b);
            }
        }

        /* JADX INFO: renamed from: a */
        void m878a(boolean z) {
            this.f881b = z;
        }
    }
}
