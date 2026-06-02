package android.support.v4.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.DecorView
public class PagerTitleStrip extends ViewGroup {

    /* JADX INFO: renamed from: n */
    private static final int[] f2317n = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* JADX INFO: renamed from: o */
    private static final int[] f2318o = {R.attr.textAllCaps};

    /* JADX INFO: renamed from: a */
    ViewPager f2319a;

    /* JADX INFO: renamed from: b */
    TextView f2320b;

    /* JADX INFO: renamed from: c */
    TextView f2321c;

    /* JADX INFO: renamed from: d */
    TextView f2322d;

    /* JADX INFO: renamed from: e */
    float f2323e;

    /* JADX INFO: renamed from: f */
    int f2324f;

    /* JADX INFO: renamed from: g */
    private int f2325g;

    /* JADX INFO: renamed from: h */
    private int f2326h;

    /* JADX INFO: renamed from: i */
    private int f2327i;

    /* JADX INFO: renamed from: j */
    private boolean f2328j;

    /* JADX INFO: renamed from: k */
    private boolean f2329k;

    /* JADX INFO: renamed from: l */
    private final PageListener f2330l;

    /* JADX INFO: renamed from: m */
    private WeakReference<PagerAdapter> f2331m;

    /* JADX INFO: renamed from: p */
    private int f2332p;

    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {

        /* JADX INFO: renamed from: a */
        private Locale f2335a;

        SingleLineAllCapsTransform(Context context) {
            this.f2335a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f2335a);
            }
            return null;
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = false;
        this.f2325g = -1;
        this.f2323e = -1.0f;
        this.f2330l = new PageListener();
        TextView textView = new TextView(context);
        this.f2320b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f2321c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f2322d = textView3;
        addView(textView3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2317n);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.m3117a(this.f2320b, resourceId);
            TextViewCompat.m3117a(this.f2321c, resourceId);
            TextViewCompat.m3117a(this.f2322d, resourceId);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            m2564a(0, dimensionPixelSize);
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            int color = typedArrayObtainStyledAttributes.getColor(2, 0);
            this.f2320b.setTextColor(color);
            this.f2321c.setTextColor(color);
            this.f2322d.setTextColor(color);
        }
        this.f2327i = typedArrayObtainStyledAttributes.getInteger(3, 80);
        typedArrayObtainStyledAttributes.recycle();
        this.f2324f = this.f2321c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f2320b.setEllipsize(TextUtils.TruncateAt.END);
        this.f2321c.setEllipsize(TextUtils.TruncateAt.END);
        this.f2322d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f2318o);
            z = typedArrayObtainStyledAttributes2.getBoolean(0, false);
            typedArrayObtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.f2320b);
            setSingleLineAllCaps(this.f2321c);
            setSingleLineAllCaps(this.f2322d);
        } else {
            this.f2320b.setSingleLine();
            this.f2321c.setSingleLine();
            this.f2322d.setSingleLine();
        }
        this.f2326h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i) {
        this.f2326h = i;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.f2326h;
    }

    public void setNonPrimaryAlpha(float f) {
        this.f2332p = ((int) (255.0f * f)) & 255;
        int i = (this.f2332p << 24) | (this.f2324f & 16777215);
        this.f2320b.setTextColor(i);
        this.f2322d.setTextColor(i);
    }

    public void setTextColor(int i) {
        this.f2324f = i;
        this.f2321c.setTextColor(i);
        int i2 = (this.f2332p << 24) | (this.f2324f & 16777215);
        this.f2320b.setTextColor(i2);
        this.f2322d.setTextColor(i2);
    }

    /* JADX INFO: renamed from: a */
    public void m2564a(int i, float f) {
        this.f2320b.setTextSize(i, f);
        this.f2321c.setTextSize(i, f);
        this.f2322d.setTextSize(i, f);
    }

    public void setGravity(int i) {
        this.f2327i = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        PagerAdapter adapter = viewPager.getAdapter();
        viewPager.m2725c(this.f2330l);
        viewPager.m2714a((ViewPager.OnAdapterChangeListener) this.f2330l);
        this.f2319a = viewPager;
        m2566a(this.f2331m != null ? this.f2331m.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2319a != null) {
            m2566a(this.f2319a.getAdapter(), (PagerAdapter) null);
            this.f2319a.m2725c((ViewPager.OnPageChangeListener) null);
            this.f2319a.m2723b((ViewPager.OnAdapterChangeListener) this.f2330l);
            this.f2319a = null;
        }
    }

    /* JADX INFO: renamed from: a */
    void m2565a(int i, PagerAdapter pagerAdapter) {
        CharSequence charSequenceM2559c = null;
        int iMo2555b = pagerAdapter != null ? pagerAdapter.mo2555b() : 0;
        this.f2328j = true;
        this.f2320b.setText((i < 1 || pagerAdapter == null) ? null : pagerAdapter.m2559c(i - 1));
        this.f2321c.setText((pagerAdapter == null || i >= iMo2555b) ? null : pagerAdapter.m2559c(i));
        if (i + 1 < iMo2555b && pagerAdapter != null) {
            charSequenceM2559c = pagerAdapter.m2559c(i + 1);
        }
        this.f2322d.setText(charSequenceM2559c);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f2320b.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f2321c.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f2322d.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f2325g = i;
        if (!this.f2329k) {
            mo2563a(i, this.f2323e, false);
        }
        this.f2328j = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f2328j) {
            super.requestLayout();
        }
    }

    /* JADX INFO: renamed from: a */
    void m2566a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.m2556b(this.f2330l);
            this.f2331m = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.m2552a((DataSetObserver) this.f2330l);
            this.f2331m = new WeakReference<>(pagerAdapter2);
        }
        if (this.f2319a != null) {
            this.f2325g = -1;
            this.f2323e = -1.0f;
            m2565a(this.f2319a.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    /* JADX INFO: renamed from: a */
    void mo2563a(int i, float f, boolean z) {
        int i2;
        int i3;
        int i4;
        if (i != this.f2325g) {
            m2565a(i, this.f2319a.getAdapter());
        } else if (!z && f == this.f2323e) {
            return;
        }
        this.f2329k = true;
        int measuredWidth = this.f2320b.getMeasuredWidth();
        int measuredWidth2 = this.f2321c.getMeasuredWidth();
        int measuredWidth3 = this.f2322d.getMeasuredWidth();
        int i5 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i6 = paddingRight + i5;
        int i7 = (width - (paddingLeft + i5)) - i6;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        int i8 = ((width - i6) - ((int) (f2 * i7))) - (measuredWidth2 / 2);
        int i9 = i8 + measuredWidth2;
        int baseline = this.f2320b.getBaseline();
        int baseline2 = this.f2321c.getBaseline();
        int baseline3 = this.f2322d.getBaseline();
        int iMax = Math.max(Math.max(baseline, baseline2), baseline3);
        int i10 = iMax - baseline;
        int i11 = iMax - baseline2;
        int i12 = iMax - baseline3;
        int iMax2 = Math.max(Math.max(this.f2320b.getMeasuredHeight() + i10, this.f2321c.getMeasuredHeight() + i11), this.f2322d.getMeasuredHeight() + i12);
        switch (this.f2327i & 112) {
            case 16:
                int i13 = (((height - paddingTop) - paddingBottom) - iMax2) / 2;
                i2 = i13 + i10;
                i3 = i11 + i13;
                i4 = i13 + i12;
                break;
            case 80:
                int i14 = (height - paddingBottom) - iMax2;
                i2 = i14 + i10;
                i3 = i11 + i14;
                i4 = i14 + i12;
                break;
            default:
                i2 = paddingTop + i10;
                i3 = i11 + paddingTop;
                i4 = paddingTop + i12;
                break;
        }
        this.f2321c.layout(i8, i3, i9, this.f2321c.getMeasuredHeight() + i3);
        int iMin = Math.min(paddingLeft, (i8 - this.f2326h) - measuredWidth);
        this.f2320b.layout(iMin, i2, measuredWidth + iMin, this.f2320b.getMeasuredHeight() + i2);
        int iMax3 = Math.max((width - paddingRight) - measuredWidth3, this.f2326h + i9);
        this.f2322d.layout(iMax3, i4, iMax3 + measuredWidth3, this.f2322d.getMeasuredHeight() + i4);
        this.f2323e = f;
        this.f2329k = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iMax;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i);
        int childMeasureSpec2 = getChildMeasureSpec(i, (int) (size * 0.2f), -2);
        this.f2320b.measure(childMeasureSpec2, childMeasureSpec);
        this.f2321c.measure(childMeasureSpec2, childMeasureSpec);
        this.f2322d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            iMax = View.MeasureSpec.getSize(i2);
        } else {
            iMax = Math.max(getMinHeight(), paddingTop + this.f2321c.getMeasuredHeight());
        }
        setMeasuredDimension(size, View.resolveSizeAndState(iMax, i2, this.f2321c.getMeasuredState() << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = CropImageView.DEFAULT_ASPECT_RATIO;
        if (this.f2319a != null) {
            if (this.f2323e >= CropImageView.DEFAULT_ASPECT_RATIO) {
                f = this.f2323e;
            }
            mo2563a(this.f2325g, f, true);
        }
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background == null) {
            return 0;
        }
        return background.getIntrinsicHeight();
    }

    private class PageListener extends DataSetObserver implements ViewPager.OnAdapterChangeListener, ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: b */
        private int f2334b;

        PageListener() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        /* JADX INFO: renamed from: a */
        public void mo907a(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.mo2563a(i, f, false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        /* JADX INFO: renamed from: b */
        public void mo908b(int i) {
            float f = CropImageView.DEFAULT_ASPECT_RATIO;
            if (this.f2334b == 0) {
                PagerTitleStrip.this.m2565a(PagerTitleStrip.this.f2319a.getCurrentItem(), PagerTitleStrip.this.f2319a.getAdapter());
                if (PagerTitleStrip.this.f2323e >= CropImageView.DEFAULT_ASPECT_RATIO) {
                    f = PagerTitleStrip.this.f2323e;
                }
                PagerTitleStrip.this.mo2563a(PagerTitleStrip.this.f2319a.getCurrentItem(), f, true);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        /* JADX INFO: renamed from: a */
        public void mo906a(int i) {
            this.f2334b = i;
        }

        @Override // android.support.v4.view.ViewPager.OnAdapterChangeListener
        /* JADX INFO: renamed from: a */
        public void mo877a(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.m2566a(pagerAdapter, pagerAdapter2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            float f = CropImageView.DEFAULT_ASPECT_RATIO;
            PagerTitleStrip.this.m2565a(PagerTitleStrip.this.f2319a.getCurrentItem(), PagerTitleStrip.this.f2319a.getAdapter());
            if (PagerTitleStrip.this.f2323e >= CropImageView.DEFAULT_ASPECT_RATIO) {
                f = PagerTitleStrip.this.f2323e;
            }
            PagerTitleStrip.this.mo2563a(PagerTitleStrip.this.f2319a.getCurrentItem(), f, true);
        }
    }
}
