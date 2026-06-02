package me.relex.circleindicator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class CircleIndicator extends LinearLayout {

    /* JADX INFO: renamed from: a */
    private ViewPager f14809a;

    /* JADX INFO: renamed from: b */
    private int f14810b;

    /* JADX INFO: renamed from: c */
    private int f14811c;

    /* JADX INFO: renamed from: d */
    private int f14812d;

    /* JADX INFO: renamed from: e */
    private int f14813e;

    /* JADX INFO: renamed from: f */
    private int f14814f;

    /* JADX INFO: renamed from: g */
    private int f14815g;

    /* JADX INFO: renamed from: h */
    private int f14816h;

    /* JADX INFO: renamed from: i */
    private Animator f14817i;

    /* JADX INFO: renamed from: j */
    private Animator f14818j;

    /* JADX INFO: renamed from: k */
    private Animator f14819k;

    /* JADX INFO: renamed from: l */
    private Animator f14820l;

    /* JADX INFO: renamed from: m */
    private int f14821m;

    /* JADX INFO: renamed from: n */
    private final ViewPager.OnPageChangeListener f14822n;

    /* JADX INFO: renamed from: o */
    private DataSetObserver f14823o;

    public CircleIndicator(Context context) {
        super(context);
        this.f14810b = -1;
        this.f14811c = -1;
        this.f14812d = -1;
        this.f14813e = R.animator.scale_with_alpha;
        this.f14814f = 0;
        this.f14815g = R.drawable.white_radius;
        this.f14816h = R.drawable.white_radius;
        this.f14821m = -1;
        this.f14822n = new ViewPager.OnPageChangeListener() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: a */
            public void mo907a(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: b */
            public void mo908b(int i) {
                View childAt;
                if (CircleIndicator.this.f14809a.getAdapter() != null && CircleIndicator.this.f14809a.getAdapter().mo2555b() > 0) {
                    if (CircleIndicator.this.f14818j.isRunning()) {
                        CircleIndicator.this.f14818j.end();
                        CircleIndicator.this.f14818j.cancel();
                    }
                    if (CircleIndicator.this.f14817i.isRunning()) {
                        CircleIndicator.this.f14817i.end();
                        CircleIndicator.this.f14817i.cancel();
                    }
                    if (CircleIndicator.this.f14821m >= 0 && (childAt = CircleIndicator.this.getChildAt(CircleIndicator.this.f14821m)) != null) {
                        childAt.setBackgroundResource(CircleIndicator.this.f14816h);
                        CircleIndicator.this.f14818j.setTarget(childAt);
                        CircleIndicator.this.f14818j.start();
                    }
                    View childAt2 = CircleIndicator.this.getChildAt(i);
                    if (childAt2 != null) {
                        childAt2.setBackgroundResource(CircleIndicator.this.f14815g);
                        CircleIndicator.this.f14817i.setTarget(childAt2);
                        CircleIndicator.this.f14817i.start();
                    }
                    CircleIndicator.this.f14821m = i;
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: a */
            public void mo906a(int i) {
            }
        };
        this.f14823o = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int iMo2555b;
                super.onChanged();
                if (CircleIndicator.this.f14809a != null && (iMo2555b = CircleIndicator.this.f14809a.getAdapter().mo2555b()) != CircleIndicator.this.getChildCount()) {
                    if (CircleIndicator.this.f14821m < iMo2555b) {
                        CircleIndicator.this.f14821m = CircleIndicator.this.f14809a.getCurrentItem();
                    } else {
                        CircleIndicator.this.f14821m = -1;
                    }
                    CircleIndicator.this.m15465a();
                }
            }
        };
        m15468a(context, (AttributeSet) null);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14810b = -1;
        this.f14811c = -1;
        this.f14812d = -1;
        this.f14813e = R.animator.scale_with_alpha;
        this.f14814f = 0;
        this.f14815g = R.drawable.white_radius;
        this.f14816h = R.drawable.white_radius;
        this.f14821m = -1;
        this.f14822n = new ViewPager.OnPageChangeListener() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: a */
            public void mo907a(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: b */
            public void mo908b(int i) {
                View childAt;
                if (CircleIndicator.this.f14809a.getAdapter() != null && CircleIndicator.this.f14809a.getAdapter().mo2555b() > 0) {
                    if (CircleIndicator.this.f14818j.isRunning()) {
                        CircleIndicator.this.f14818j.end();
                        CircleIndicator.this.f14818j.cancel();
                    }
                    if (CircleIndicator.this.f14817i.isRunning()) {
                        CircleIndicator.this.f14817i.end();
                        CircleIndicator.this.f14817i.cancel();
                    }
                    if (CircleIndicator.this.f14821m >= 0 && (childAt = CircleIndicator.this.getChildAt(CircleIndicator.this.f14821m)) != null) {
                        childAt.setBackgroundResource(CircleIndicator.this.f14816h);
                        CircleIndicator.this.f14818j.setTarget(childAt);
                        CircleIndicator.this.f14818j.start();
                    }
                    View childAt2 = CircleIndicator.this.getChildAt(i);
                    if (childAt2 != null) {
                        childAt2.setBackgroundResource(CircleIndicator.this.f14815g);
                        CircleIndicator.this.f14817i.setTarget(childAt2);
                        CircleIndicator.this.f14817i.start();
                    }
                    CircleIndicator.this.f14821m = i;
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: a */
            public void mo906a(int i) {
            }
        };
        this.f14823o = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int iMo2555b;
                super.onChanged();
                if (CircleIndicator.this.f14809a != null && (iMo2555b = CircleIndicator.this.f14809a.getAdapter().mo2555b()) != CircleIndicator.this.getChildCount()) {
                    if (CircleIndicator.this.f14821m < iMo2555b) {
                        CircleIndicator.this.f14821m = CircleIndicator.this.f14809a.getCurrentItem();
                    } else {
                        CircleIndicator.this.f14821m = -1;
                    }
                    CircleIndicator.this.m15465a();
                }
            }
        };
        m15468a(context, attributeSet);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14810b = -1;
        this.f14811c = -1;
        this.f14812d = -1;
        this.f14813e = R.animator.scale_with_alpha;
        this.f14814f = 0;
        this.f14815g = R.drawable.white_radius;
        this.f14816h = R.drawable.white_radius;
        this.f14821m = -1;
        this.f14822n = new ViewPager.OnPageChangeListener() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: a */
            public void mo907a(int i2, float f, int i22) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: b */
            public void mo908b(int i2) {
                View childAt;
                if (CircleIndicator.this.f14809a.getAdapter() != null && CircleIndicator.this.f14809a.getAdapter().mo2555b() > 0) {
                    if (CircleIndicator.this.f14818j.isRunning()) {
                        CircleIndicator.this.f14818j.end();
                        CircleIndicator.this.f14818j.cancel();
                    }
                    if (CircleIndicator.this.f14817i.isRunning()) {
                        CircleIndicator.this.f14817i.end();
                        CircleIndicator.this.f14817i.cancel();
                    }
                    if (CircleIndicator.this.f14821m >= 0 && (childAt = CircleIndicator.this.getChildAt(CircleIndicator.this.f14821m)) != null) {
                        childAt.setBackgroundResource(CircleIndicator.this.f14816h);
                        CircleIndicator.this.f14818j.setTarget(childAt);
                        CircleIndicator.this.f14818j.start();
                    }
                    View childAt2 = CircleIndicator.this.getChildAt(i2);
                    if (childAt2 != null) {
                        childAt2.setBackgroundResource(CircleIndicator.this.f14815g);
                        CircleIndicator.this.f14817i.setTarget(childAt2);
                        CircleIndicator.this.f14817i.start();
                    }
                    CircleIndicator.this.f14821m = i2;
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: a */
            public void mo906a(int i2) {
            }
        };
        this.f14823o = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int iMo2555b;
                super.onChanged();
                if (CircleIndicator.this.f14809a != null && (iMo2555b = CircleIndicator.this.f14809a.getAdapter().mo2555b()) != CircleIndicator.this.getChildCount()) {
                    if (CircleIndicator.this.f14821m < iMo2555b) {
                        CircleIndicator.this.f14821m = CircleIndicator.this.f14809a.getCurrentItem();
                    } else {
                        CircleIndicator.this.f14821m = -1;
                    }
                    CircleIndicator.this.m15465a();
                }
            }
        };
        m15468a(context, attributeSet);
    }

    @TargetApi(21)
    public CircleIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f14810b = -1;
        this.f14811c = -1;
        this.f14812d = -1;
        this.f14813e = R.animator.scale_with_alpha;
        this.f14814f = 0;
        this.f14815g = R.drawable.white_radius;
        this.f14816h = R.drawable.white_radius;
        this.f14821m = -1;
        this.f14822n = new ViewPager.OnPageChangeListener() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: a */
            public void mo907a(int i22, float f, int i222) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: b */
            public void mo908b(int i22) {
                View childAt;
                if (CircleIndicator.this.f14809a.getAdapter() != null && CircleIndicator.this.f14809a.getAdapter().mo2555b() > 0) {
                    if (CircleIndicator.this.f14818j.isRunning()) {
                        CircleIndicator.this.f14818j.end();
                        CircleIndicator.this.f14818j.cancel();
                    }
                    if (CircleIndicator.this.f14817i.isRunning()) {
                        CircleIndicator.this.f14817i.end();
                        CircleIndicator.this.f14817i.cancel();
                    }
                    if (CircleIndicator.this.f14821m >= 0 && (childAt = CircleIndicator.this.getChildAt(CircleIndicator.this.f14821m)) != null) {
                        childAt.setBackgroundResource(CircleIndicator.this.f14816h);
                        CircleIndicator.this.f14818j.setTarget(childAt);
                        CircleIndicator.this.f14818j.start();
                    }
                    View childAt2 = CircleIndicator.this.getChildAt(i22);
                    if (childAt2 != null) {
                        childAt2.setBackgroundResource(CircleIndicator.this.f14815g);
                        CircleIndicator.this.f14817i.setTarget(childAt2);
                        CircleIndicator.this.f14817i.start();
                    }
                    CircleIndicator.this.f14821m = i22;
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: a */
            public void mo906a(int i22) {
            }
        };
        this.f14823o = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int iMo2555b;
                super.onChanged();
                if (CircleIndicator.this.f14809a != null && (iMo2555b = CircleIndicator.this.f14809a.getAdapter().mo2555b()) != CircleIndicator.this.getChildCount()) {
                    if (CircleIndicator.this.f14821m < iMo2555b) {
                        CircleIndicator.this.f14821m = CircleIndicator.this.f14809a.getCurrentItem();
                    } else {
                        CircleIndicator.this.f14821m = -1;
                    }
                    CircleIndicator.this.m15465a();
                }
            }
        };
        m15468a(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m15468a(Context context, AttributeSet attributeSet) {
        m15471b(context, attributeSet);
        m15467a(context);
    }

    /* JADX INFO: renamed from: b */
    private void m15471b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleIndicator);
            this.f14811c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_width, -1);
            this.f14812d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_height, -1);
            this.f14810b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_margin, -1);
            this.f14813e = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_animator, R.animator.scale_with_alpha);
            this.f14814f = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_animator_reverse, 0);
            this.f14815g = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_drawable, R.drawable.white_radius);
            this.f14816h = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_drawable_unselected, this.f14815g);
            setOrientation(typedArrayObtainStyledAttributes.getInt(R.styleable.CircleIndicator_ci_orientation, -1) != 1 ? 0 : 1);
            int i = typedArrayObtainStyledAttributes.getInt(R.styleable.CircleIndicator_ci_gravity, -1);
            if (i < 0) {
                i = 17;
            }
            setGravity(i);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m15467a(Context context) {
        this.f14811c = this.f14811c < 0 ? m15478a(5.0f) : this.f14811c;
        this.f14812d = this.f14812d < 0 ? m15478a(5.0f) : this.f14812d;
        this.f14810b = this.f14810b < 0 ? m15478a(5.0f) : this.f14810b;
        this.f14813e = this.f14813e == 0 ? R.animator.scale_with_alpha : this.f14813e;
        this.f14817i = m15469b(context);
        this.f14819k = m15469b(context);
        this.f14819k.setDuration(0L);
        this.f14818j = m15472c(context);
        this.f14820l = m15472c(context);
        this.f14820l.setDuration(0L);
        this.f14815g = this.f14815g == 0 ? R.drawable.white_radius : this.f14815g;
        this.f14816h = this.f14816h == 0 ? this.f14815g : this.f14816h;
    }

    /* JADX INFO: renamed from: b */
    private Animator m15469b(Context context) {
        return AnimatorInflater.loadAnimator(context, this.f14813e);
    }

    /* JADX INFO: renamed from: c */
    private Animator m15472c(Context context) {
        if (this.f14814f == 0) {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, this.f14813e);
            animatorLoadAnimator.setInterpolator(new ReverseInterpolator());
            return animatorLoadAnimator;
        }
        return AnimatorInflater.loadAnimator(context, this.f14814f);
    }

    public void setViewPager(ViewPager viewPager) {
        this.f14809a = viewPager;
        if (this.f14809a != null && this.f14809a.getAdapter() != null) {
            this.f14821m = -1;
            m15465a();
            this.f14809a.m2724b(this.f14822n);
            this.f14809a.m2715a(this.f14822n);
            this.f14822n.mo908b(this.f14809a.getCurrentItem());
        }
    }

    public DataSetObserver getDataSetObserver() {
        return this.f14823o;
    }

    @Deprecated
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.f14809a == null) {
            throw new NullPointerException("can not find Viewpager , setViewPager first");
        }
        this.f14809a.m2724b(onPageChangeListener);
        this.f14809a.m2715a(onPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m15465a() {
        removeAllViews();
        int iMo2555b = this.f14809a.getAdapter().mo2555b();
        if (iMo2555b > 0) {
            int currentItem = this.f14809a.getCurrentItem();
            int orientation = getOrientation();
            for (int i = 0; i < iMo2555b; i++) {
                if (currentItem == i) {
                    m15466a(orientation, this.f14815g, this.f14819k);
                } else {
                    m15466a(orientation, this.f14816h, this.f14820l);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m15466a(int i, int i2, Animator animator) {
        if (animator.isRunning()) {
            animator.end();
            animator.cancel();
        }
        View view = new View(getContext());
        view.setBackgroundResource(i2);
        addView(view, this.f14811c, this.f14812d);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (i == 0) {
            layoutParams.leftMargin = this.f14810b;
            layoutParams.rightMargin = this.f14810b;
        } else {
            layoutParams.topMargin = this.f14810b;
            layoutParams.bottomMargin = this.f14810b;
        }
        view.setLayoutParams(layoutParams);
        animator.setTarget(view);
        animator.start();
    }

    /* JADX INFO: loaded from: classes2.dex */
    private class ReverseInterpolator implements Interpolator {
        private ReverseInterpolator() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }
    }

    /* JADX INFO: renamed from: a */
    public int m15478a(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
