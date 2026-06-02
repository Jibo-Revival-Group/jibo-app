package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButtonImpl;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewGroupUtils;
import android.support.v7.widget.AppCompatImageHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@CoordinatorLayout.DefaultBehavior(m687a = Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton {

    /* JADX INFO: renamed from: a */
    int f717a;

    /* JADX INFO: renamed from: b */
    boolean f718b;

    /* JADX INFO: renamed from: c */
    final Rect f719c;

    /* JADX INFO: renamed from: d */
    private ColorStateList f720d;

    /* JADX INFO: renamed from: e */
    private PorterDuff.Mode f721e;

    /* JADX INFO: renamed from: f */
    private int f722f;

    /* JADX INFO: renamed from: g */
    private int f723g;

    /* JADX INFO: renamed from: h */
    private int f724h;

    /* JADX INFO: renamed from: i */
    private int f725i;

    /* JADX INFO: renamed from: j */
    private int f726j;

    /* JADX INFO: renamed from: k */
    private final Rect f727k;

    /* JADX INFO: renamed from: l */
    private AppCompatImageHelper f728l;

    /* JADX INFO: renamed from: m */
    private FloatingActionButtonImpl f729m;

    @Override // android.support.design.widget.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public static abstract class OnVisibilityChangedListener {
        /* JADX INFO: renamed from: a */
        public void m736a(FloatingActionButton floatingActionButton) {
        }

        /* JADX INFO: renamed from: b */
        public void m737b(FloatingActionButton floatingActionButton) {
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f719c = new Rect();
        this.f727k = new Rect();
        ThemeUtils.m940a(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton, i, R.style.Widget_Design_FloatingActionButton);
        this.f720d = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.FloatingActionButton_backgroundTint);
        this.f721e = ViewUtils.m947a(typedArrayObtainStyledAttributes.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.f723g = typedArrayObtainStyledAttributes.getColor(R.styleable.FloatingActionButton_rippleColor, 0);
        this.f724h = typedArrayObtainStyledAttributes.getInt(R.styleable.FloatingActionButton_fabSize, -1);
        this.f725i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
        this.f722f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayObtainStyledAttributes.getDimension(R.styleable.FloatingActionButton_elevation, CropImageView.DEFAULT_ASPECT_RATIO);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f718b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
        typedArrayObtainStyledAttributes.recycle();
        this.f728l = new AppCompatImageHelper(this);
        this.f728l.m3896a(attributeSet, i);
        this.f726j = (int) getResources().getDimension(R.dimen.design_fab_image_size);
        getImpl().mo753a(this.f720d, this.f721e, this.f723g, this.f722f);
        getImpl().m749a(dimension);
        getImpl().m759b(dimension2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.f717a = (sizeDimension - this.f726j) / 2;
        getImpl().m764e();
        int iMin = Math.min(m715a(sizeDimension, i), m715a(sizeDimension, i2));
        setMeasuredDimension(this.f719c.left + iMin + this.f719c.right, iMin + this.f719c.top + this.f719c.bottom);
    }

    public int getRippleColor() {
        return this.f723g;
    }

    public void setRippleColor(int i) {
        if (this.f723g != i) {
            this.f723g = i;
            getImpl().mo751a(i);
        }
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f720d;
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f720d != colorStateList) {
            this.f720d = colorStateList;
            getImpl().m752a(colorStateList);
        }
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f721e;
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f721e != mode) {
            this.f721e = mode;
            getImpl().m754a(mode);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f728l.m3893a(i);
    }

    /* JADX INFO: renamed from: a */
    public void m719a() {
        m720a((OnVisibilityChangedListener) null);
    }

    /* JADX INFO: renamed from: a */
    public void m720a(OnVisibilityChangedListener onVisibilityChangedListener) {
        m721a(onVisibilityChangedListener, true);
    }

    /* JADX INFO: renamed from: a */
    void m721a(OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        getImpl().m761b(m717c(onVisibilityChangedListener), z);
    }

    /* JADX INFO: renamed from: b */
    public void m723b() {
        m724b(null);
    }

    /* JADX INFO: renamed from: b */
    public void m724b(OnVisibilityChangedListener onVisibilityChangedListener) {
        m725b(onVisibilityChangedListener, true);
    }

    /* JADX INFO: renamed from: b */
    void m725b(OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        getImpl().m756a(m717c(onVisibilityChangedListener), z);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f718b != z) {
            this.f718b = z;
            getImpl().mo763d();
        }
    }

    public boolean getUseCompatPadding() {
        return this.f718b;
    }

    public void setSize(int i) {
        if (i != this.f724h) {
            this.f724h = i;
            requestLayout();
        }
    }

    public int getSize() {
        return this.f724h;
    }

    /* JADX INFO: renamed from: c */
    private FloatingActionButtonImpl.InternalVisibilityChangedListener m717c(final OnVisibilityChangedListener onVisibilityChangedListener) {
        if (onVisibilityChangedListener == null) {
            return null;
        }
        return new FloatingActionButtonImpl.InternalVisibilityChangedListener() { // from class: android.support.design.widget.FloatingActionButton.1
            @Override // android.support.design.widget.FloatingActionButtonImpl.InternalVisibilityChangedListener
            /* JADX INFO: renamed from: a */
            public void mo726a() {
                onVisibilityChangedListener.m736a(FloatingActionButton.this);
            }

            @Override // android.support.design.widget.FloatingActionButtonImpl.InternalVisibilityChangedListener
            /* JADX INFO: renamed from: b */
            public void mo727b() {
                onVisibilityChangedListener.m737b(FloatingActionButton.this);
            }
        };
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size should be non-negative.");
        }
        this.f725i = i;
    }

    public int getCustomSize() {
        return this.f725i;
    }

    int getSizeDimension() {
        return m714a(this.f724h);
    }

    /* JADX INFO: renamed from: a */
    private int m714a(int i) {
        Resources resources = getResources();
        if (this.f725i != 0) {
            return this.f725i;
        }
        switch (i) {
            case -1:
                if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
                    return m714a(1);
                }
                return m714a(0);
            case 0:
            default:
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
            case 1:
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m765f();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().m766g();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo757a(getDrawableState());
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo758b();
    }

    /* JADX INFO: renamed from: a */
    public boolean m722a(Rect rect) {
        if (!ViewCompat.m2621y(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        rect.left += this.f719c.left;
        rect.top += this.f719c.top;
        rect.right -= this.f719c.right;
        rect.bottom -= this.f719c.bottom;
        return true;
    }

    public Drawable getContentBackground() {
        return getImpl().m762c();
    }

    /* JADX INFO: renamed from: a */
    private static int m715a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 0:
            default:
                return i;
            case 1073741824:
                return size;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (m722a(this.f727k) && !this.f727k.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return false;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public static class Behavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

        /* JADX INFO: renamed from: a */
        private Rect f732a;

        /* JADX INFO: renamed from: b */
        private OnVisibilityChangedListener f733b;

        /* JADX INFO: renamed from: c */
        private boolean f734c;

        public Behavior() {
            this.f734c = true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.f734c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a */
        public void mo676a(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.f702h == 0) {
                layoutParams.f702h = 80;
            }
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo481b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                m729a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (m730a(view)) {
                m732b(view, floatingActionButton);
                return false;
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        private static boolean m730a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).m699b() instanceof BottomSheetBehavior;
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        private boolean m731a(View view, FloatingActionButton floatingActionButton) {
            return this.f734c && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).m691a() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        /* JADX INFO: renamed from: a */
        private boolean m729a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!m731a(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f732a == null) {
                this.f732a = new Rect();
            }
            Rect rect = this.f732a;
            ViewGroupUtils.m3172b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m725b(this.f733b, false);
            } else {
                floatingActionButton.m721a(this.f733b, false);
            }
            return true;
        }

        /* JADX INFO: renamed from: b */
        private boolean m732b(View view, FloatingActionButton floatingActionButton) {
            if (!m731a(view, floatingActionButton)) {
                return false;
            }
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            if (view.getTop() < layoutParams.topMargin + (floatingActionButton.getHeight() / 2)) {
                floatingActionButton.m725b(this.f733b, false);
            } else {
                floatingActionButton.m721a(this.f733b, false);
            }
            return true;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo455a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> listM668c = coordinatorLayout.m668c(floatingActionButton);
            int size = listM668c.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = listM668c.get(i2);
                if (view instanceof AppBarLayout) {
                    if (m729a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (m730a(view) && m732b(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.m653a(floatingActionButton, i);
            m728a(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo678a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f719c;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        /* JADX INFO: renamed from: a */
        private void m728a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            int i2 = 0;
            Rect rect = floatingActionButton.f719c;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - layoutParams.rightMargin) {
                    i = rect.right;
                } else {
                    i = floatingActionButton.getLeft() <= layoutParams.leftMargin ? -rect.left : 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - layoutParams.bottomMargin) {
                    i2 = rect.bottom;
                } else if (floatingActionButton.getTop() <= layoutParams.topMargin) {
                    i2 = -rect.top;
                }
                if (i2 != 0) {
                    ViewCompat.m2598c(floatingActionButton, i2);
                }
                if (i != 0) {
                    ViewCompat.m2600d(floatingActionButton, i);
                }
            }
        }
    }

    public float getCompatElevation() {
        return getImpl().mo747a();
    }

    public void setCompatElevation(float f) {
        getImpl().m749a(f);
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.f729m == null) {
            this.f729m = m718c();
        }
        return this.f729m;
    }

    /* JADX INFO: renamed from: c */
    private FloatingActionButtonImpl m718c() {
        return Build.VERSION.SDK_INT >= 21 ? new FloatingActionButtonLollipop(this, new ShadowDelegateImpl()) : new FloatingActionButtonImpl(this, new ShadowDelegateImpl());
    }

    private class ShadowDelegateImpl implements ShadowViewDelegate {
        ShadowDelegateImpl() {
        }

        @Override // android.support.design.widget.ShadowViewDelegate
        /* JADX INFO: renamed from: a */
        public float mo738a() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // android.support.design.widget.ShadowViewDelegate
        /* JADX INFO: renamed from: a */
        public void mo739a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.f719c.set(i, i2, i3, i4);
            FloatingActionButton.this.setPadding(FloatingActionButton.this.f717a + i, FloatingActionButton.this.f717a + i2, FloatingActionButton.this.f717a + i3, FloatingActionButton.this.f717a + i4);
        }

        @Override // android.support.design.widget.ShadowViewDelegate
        /* JADX INFO: renamed from: a */
        public void mo740a(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // android.support.design.widget.ShadowViewDelegate
        /* JADX INFO: renamed from: b */
        public boolean mo741b() {
            return FloatingActionButton.this.f718b;
        }
    }
}
