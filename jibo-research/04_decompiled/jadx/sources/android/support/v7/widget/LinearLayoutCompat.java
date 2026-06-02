package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* JADX INFO: renamed from: a */
    private boolean f3940a;

    /* JADX INFO: renamed from: b */
    private int f3941b;

    /* JADX INFO: renamed from: c */
    private int f3942c;

    /* JADX INFO: renamed from: d */
    private int f3943d;

    /* JADX INFO: renamed from: e */
    private int f3944e;

    /* JADX INFO: renamed from: f */
    private int f3945f;

    /* JADX INFO: renamed from: g */
    private float f3946g;

    /* JADX INFO: renamed from: h */
    private boolean f3947h;

    /* JADX INFO: renamed from: i */
    private int[] f3948i;

    /* JADX INFO: renamed from: j */
    private int[] f3949j;

    /* JADX INFO: renamed from: k */
    private Drawable f3950k;

    /* JADX INFO: renamed from: l */
    private int f3951l;

    /* JADX INFO: renamed from: m */
    private int f3952m;

    /* JADX INFO: renamed from: n */
    private int f3953n;

    /* JADX INFO: renamed from: o */
    private int f3954o;

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3940a = true;
        this.f3941b = -1;
        this.f3942c = 0;
        this.f3944e = 8388659;
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(context, attributeSet, R.styleable.LinearLayoutCompat, i, 0);
        int iM4957a = tintTypedArrayM4955a.m4957a(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (iM4957a >= 0) {
            setOrientation(iM4957a);
        }
        int iM4957a2 = tintTypedArrayM4955a.m4957a(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (iM4957a2 >= 0) {
            setGravity(iM4957a2);
        }
        boolean zM4961a = tintTypedArrayM4955a.m4961a(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!zM4961a) {
            setBaselineAligned(zM4961a);
        }
        this.f3946g = tintTypedArrayM4955a.m4956a(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f3941b = tintTypedArrayM4955a.m4957a(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f3947h = tintTypedArrayM4955a.m4961a(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(tintTypedArrayM4955a.m4959a(R.styleable.LinearLayoutCompat_divider));
        this.f3953n = tintTypedArrayM4955a.m4957a(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.f3954o = tintTypedArrayM4955a.m4968e(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        tintTypedArrayM4955a.m4960a();
    }

    public void setShowDividers(int i) {
        if (i != this.f3953n) {
            requestLayout();
        }
        this.f3953n = i;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.f3953n;
    }

    public Drawable getDividerDrawable() {
        return this.f3950k;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.f3950k) {
            this.f3950k = drawable;
            if (drawable != null) {
                this.f3951l = drawable.getIntrinsicWidth();
                this.f3952m = drawable.getIntrinsicHeight();
            } else {
                this.f3951l = 0;
                this.f3952m = 0;
            }
            setWillNotDraw(drawable == null);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f3954o = i;
    }

    public int getDividerPadding() {
        return this.f3954o;
    }

    public int getDividerWidth() {
        return this.f3951l;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f3950k != null) {
            if (this.f3943d == 1) {
                m4247a(canvas);
            } else {
                m4254b(canvas);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m4247a(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View viewM4251b = m4251b(i);
            if (viewM4251b != null && viewM4251b.getVisibility() != 8 && m4256c(i)) {
                m4248a(canvas, (viewM4251b.getTop() - ((LayoutParams) viewM4251b.getLayoutParams()).topMargin) - this.f3952m);
            }
        }
        if (m4256c(virtualChildCount)) {
            View viewM4251b2 = m4251b(virtualChildCount - 1);
            if (viewM4251b2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.f3952m;
            } else {
                bottom = ((LayoutParams) viewM4251b2.getLayoutParams()).bottomMargin + viewM4251b2.getBottom();
            }
            m4248a(canvas, bottom);
        }
    }

    /* JADX INFO: renamed from: b */
    void m4254b(Canvas canvas) {
        int right;
        int left;
        int virtualChildCount = getVirtualChildCount();
        boolean zM5031a = ViewUtils.m5031a(this);
        for (int i = 0; i < virtualChildCount; i++) {
            View viewM4251b = m4251b(i);
            if (viewM4251b != null && viewM4251b.getVisibility() != 8 && m4256c(i)) {
                LayoutParams layoutParams = (LayoutParams) viewM4251b.getLayoutParams();
                if (zM5031a) {
                    left = layoutParams.rightMargin + viewM4251b.getRight();
                } else {
                    left = (viewM4251b.getLeft() - layoutParams.leftMargin) - this.f3951l;
                }
                m4255b(canvas, left);
            }
        }
        if (m4256c(virtualChildCount)) {
            View viewM4251b2 = m4251b(virtualChildCount - 1);
            if (viewM4251b2 == null) {
                if (zM5031a) {
                    right = getPaddingLeft();
                } else {
                    right = (getWidth() - getPaddingRight()) - this.f3951l;
                }
            } else {
                LayoutParams layoutParams2 = (LayoutParams) viewM4251b2.getLayoutParams();
                if (zM5031a) {
                    right = (viewM4251b2.getLeft() - layoutParams2.leftMargin) - this.f3951l;
                } else {
                    right = layoutParams2.rightMargin + viewM4251b2.getRight();
                }
            }
            m4255b(canvas, right);
        }
    }

    /* JADX INFO: renamed from: a */
    void m4248a(Canvas canvas, int i) {
        this.f3950k.setBounds(getPaddingLeft() + this.f3954o, i, (getWidth() - getPaddingRight()) - this.f3954o, this.f3952m + i);
        this.f3950k.draw(canvas);
    }

    /* JADX INFO: renamed from: b */
    void m4255b(Canvas canvas, int i) {
        this.f3950k.setBounds(i, getPaddingTop() + this.f3954o, this.f3951l + i, (getHeight() - getPaddingBottom()) - this.f3954o);
        this.f3950k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.f3940a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f3947h = z;
    }

    @Override // android.view.View
    public int getBaseline() {
        int bottom;
        int i;
        if (this.f3941b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f3941b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f3941b);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f3941b != 0) {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            return -1;
        }
        int i2 = this.f3942c;
        if (this.f3943d == 1 && (i = this.f3944e & 112) != 48) {
            switch (i) {
                case 16:
                    bottom = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f3945f) / 2);
                    break;
                case 80:
                    bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f3945f;
                    break;
                default:
                    bottom = i2;
                    break;
            }
        } else {
            bottom = i2;
        }
        return ((LayoutParams) childAt.getLayoutParams()).topMargin + bottom + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f3941b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f3941b = i;
    }

    /* JADX INFO: renamed from: b */
    View m4251b(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f3946g;
    }

    public void setWeightSum(float f) {
        this.f3946g = Math.max(CropImageView.DEFAULT_ASPECT_RATIO, f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f3943d == 1) {
            m4245a(i, i2);
        } else {
            m4252b(i, i2);
        }
    }

    /* JADX INFO: renamed from: c */
    protected boolean m4256c(int i) {
        if (i == 0) {
            return (this.f3953n & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.f3953n & 4) != 0;
        }
        if ((this.f3953n & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    void m4245a(int i, int i2) {
        int i3;
        int i4;
        float f;
        int i5;
        int iCombineMeasuredStates;
        boolean z;
        int i6;
        int i7;
        int i8;
        int iM4244a;
        boolean z2;
        boolean z3;
        int iMax;
        int iMax2;
        boolean z4;
        int i9;
        int i10;
        int i11;
        this.f3945f = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        boolean z5 = true;
        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z6 = false;
        boolean z7 = false;
        int i16 = this.f3941b;
        boolean z8 = this.f3947h;
        int iMax3 = 0;
        int iM4244a2 = 0;
        while (iM4244a2 < virtualChildCount) {
            View viewM4251b = m4251b(iM4244a2);
            if (viewM4251b == null) {
                this.f3945f += m4257d(iM4244a2);
                i10 = iMax3;
                z4 = z7;
                z3 = z5;
                i11 = i13;
                i9 = i12;
            } else if (viewM4251b.getVisibility() == 8) {
                iM4244a2 += m4244a(viewM4251b, iM4244a2);
                i10 = iMax3;
                z4 = z7;
                z3 = z5;
                i11 = i13;
                i9 = i12;
            } else {
                if (m4256c(iM4244a2)) {
                    this.f3945f += this.f3952m;
                }
                LayoutParams layoutParams = (LayoutParams) viewM4251b.getLayoutParams();
                float f3 = f2 + layoutParams.f3955g;
                if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.f3955g > CropImageView.DEFAULT_ASPECT_RATIO) {
                    int i17 = this.f3945f;
                    this.f3945f = Math.max(i17, layoutParams.topMargin + i17 + layoutParams.bottomMargin);
                    z7 = true;
                } else {
                    int i18 = Integer.MIN_VALUE;
                    if (layoutParams.height == 0 && layoutParams.f3955g > CropImageView.DEFAULT_ASPECT_RATIO) {
                        i18 = 0;
                        layoutParams.height = -2;
                    }
                    int i19 = i18;
                    m4249a(viewM4251b, iM4244a2, i, 0, i2, f3 == CropImageView.DEFAULT_ASPECT_RATIO ? this.f3945f : 0);
                    if (i19 != Integer.MIN_VALUE) {
                        layoutParams.height = i19;
                    }
                    int measuredHeight = viewM4251b.getMeasuredHeight();
                    int i20 = this.f3945f;
                    this.f3945f = Math.max(i20, i20 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + m4250b(viewM4251b));
                    if (z8) {
                        iMax3 = Math.max(measuredHeight, iMax3);
                    }
                }
                if (i16 >= 0 && i16 == iM4244a2 + 1) {
                    this.f3942c = this.f3945f;
                }
                if (iM4244a2 < i16 && layoutParams.f3955g > CropImageView.DEFAULT_ASPECT_RATIO) {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
                boolean z9 = false;
                if (mode == 1073741824 || layoutParams.width != -1) {
                    z2 = z6;
                } else {
                    z2 = true;
                    z9 = true;
                }
                int i21 = layoutParams.rightMargin + layoutParams.leftMargin;
                int measuredWidth = viewM4251b.getMeasuredWidth() + i21;
                int iMax4 = Math.max(i12, measuredWidth);
                int iCombineMeasuredStates2 = View.combineMeasuredStates(i13, viewM4251b.getMeasuredState());
                z3 = z5 && layoutParams.width == -1;
                if (layoutParams.f3955g > CropImageView.DEFAULT_ASPECT_RATIO) {
                    iMax2 = Math.max(i15, z9 ? i21 : measuredWidth);
                    iMax = i14;
                } else {
                    if (!z9) {
                        i21 = measuredWidth;
                    }
                    iMax = Math.max(i14, i21);
                    iMax2 = i15;
                }
                iM4244a2 += m4244a(viewM4251b, iM4244a2);
                z4 = z7;
                i15 = iMax2;
                i14 = iMax;
                i9 = iMax4;
                i10 = iMax3;
                i11 = iCombineMeasuredStates2;
                z6 = z2;
                f2 = f3;
            }
            iM4244a2++;
            iMax3 = i10;
            z7 = z4;
            z5 = z3;
            i13 = i11;
            i12 = i9;
        }
        if (this.f3945f > 0 && m4256c(virtualChildCount)) {
            this.f3945f += this.f3952m;
        }
        if (z8 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f3945f = 0;
            int i22 = 0;
            while (i22 < virtualChildCount) {
                View viewM4251b2 = m4251b(i22);
                if (viewM4251b2 == null) {
                    this.f3945f += m4257d(i22);
                    iM4244a = i22;
                } else if (viewM4251b2.getVisibility() == 8) {
                    iM4244a = m4244a(viewM4251b2, i22) + i22;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) viewM4251b2.getLayoutParams();
                    int i23 = this.f3945f;
                    this.f3945f = Math.max(i23, layoutParams2.bottomMargin + i23 + iMax3 + layoutParams2.topMargin + m4250b(viewM4251b2));
                    iM4244a = i22;
                }
                i22 = iM4244a + 1;
            }
        }
        this.f3945f += getPaddingTop() + getPaddingBottom();
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(this.f3945f, getSuggestedMinimumHeight()), i2, 0);
        int i24 = (16777215 & iResolveSizeAndState) - this.f3945f;
        if (z7 || (i24 != 0 && f2 > CropImageView.DEFAULT_ASPECT_RATIO)) {
            if (this.f3946g > CropImageView.DEFAULT_ASPECT_RATIO) {
                f2 = this.f3946g;
            }
            this.f3945f = 0;
            int i25 = 0;
            float f4 = f2;
            boolean z10 = z5;
            int i26 = i14;
            int i27 = i13;
            int i28 = i12;
            int i29 = i24;
            while (i25 < virtualChildCount) {
                View viewM4251b3 = m4251b(i25);
                if (viewM4251b3.getVisibility() == 8) {
                    i6 = i26;
                    i8 = i27;
                    i7 = i28;
                    z = z10;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) viewM4251b3.getLayoutParams();
                    float f5 = layoutParams3.f3955g;
                    if (f5 > CropImageView.DEFAULT_ASPECT_RATIO) {
                        int i30 = (int) ((i29 * f5) / f4);
                        float f6 = f4 - f5;
                        int i31 = i29 - i30;
                        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width);
                        if (layoutParams3.height != 0 || mode2 != 1073741824) {
                            int measuredHeight2 = i30 + viewM4251b3.getMeasuredHeight();
                            if (measuredHeight2 < 0) {
                                measuredHeight2 = 0;
                            }
                            viewM4251b3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
                        } else {
                            if (i30 <= 0) {
                                i30 = 0;
                            }
                            viewM4251b3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i30, 1073741824));
                        }
                        i5 = i31;
                        iCombineMeasuredStates = View.combineMeasuredStates(i27, viewM4251b3.getMeasuredState() & (-256));
                        f = f6;
                    } else {
                        f = f4;
                        i5 = i29;
                        iCombineMeasuredStates = i27;
                    }
                    int i32 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                    int measuredWidth2 = viewM4251b3.getMeasuredWidth() + i32;
                    int iMax5 = Math.max(i28, measuredWidth2);
                    if (!(mode != 1073741824 && layoutParams3.width == -1)) {
                        i32 = measuredWidth2;
                    }
                    int iMax6 = Math.max(i26, i32);
                    z = z10 && layoutParams3.width == -1;
                    int i33 = this.f3945f;
                    this.f3945f = Math.max(i33, layoutParams3.bottomMargin + viewM4251b3.getMeasuredHeight() + i33 + layoutParams3.topMargin + m4250b(viewM4251b3));
                    i6 = iMax6;
                    i7 = iMax5;
                    float f7 = f;
                    i8 = iCombineMeasuredStates;
                    i29 = i5;
                    f4 = f7;
                }
                i25++;
                i26 = i6;
                i28 = i7;
                z10 = z;
                i27 = i8;
            }
            this.f3945f += getPaddingTop() + getPaddingBottom();
            z5 = z10;
            i3 = i26;
            i13 = i27;
            i4 = i28;
        } else {
            int iMax7 = Math.max(i14, i15);
            if (z8 && mode2 != 1073741824) {
                int i34 = 0;
                while (true) {
                    int i35 = i34;
                    if (i35 >= virtualChildCount) {
                        break;
                    }
                    View viewM4251b4 = m4251b(i35);
                    if (viewM4251b4 != null && viewM4251b4.getVisibility() != 8 && ((LayoutParams) viewM4251b4.getLayoutParams()).f3955g > CropImageView.DEFAULT_ASPECT_RATIO) {
                        viewM4251b4.measure(View.MeasureSpec.makeMeasureSpec(viewM4251b4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(iMax3, 1073741824));
                    }
                    i34 = i35 + 1;
                }
            }
            i3 = iMax7;
            i4 = i12;
        }
        if (z5 || mode == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, i13), iResolveSizeAndState);
        if (z6) {
            m4241c(virtualChildCount, i2);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m4241c(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View viewM4251b = m4251b(i3);
            if (viewM4251b.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) viewM4251b.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = viewM4251b.getMeasuredHeight();
                    measureChildWithMargins(viewM4251b, iMakeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m4252b(int i, int i2) {
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        int i7;
        boolean z;
        int i8;
        int iCombineMeasuredStates;
        float f2;
        int baseline;
        int iM4244a;
        boolean z2;
        boolean z3;
        int iMax;
        int iMax2;
        boolean z4;
        int i9;
        int i10;
        int i11;
        this.f3945f = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        boolean z5 = true;
        float f3 = CropImageView.DEFAULT_ASPECT_RATIO;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z6 = false;
        boolean z7 = false;
        if (this.f3948i == null || this.f3949j == null) {
            this.f3948i = new int[4];
            this.f3949j = new int[4];
        }
        int[] iArr = this.f3948i;
        int[] iArr2 = this.f3949j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z8 = this.f3940a;
        boolean z9 = this.f3947h;
        boolean z10 = mode == 1073741824;
        int iMax3 = 0;
        int iM4244a2 = 0;
        while (iM4244a2 < virtualChildCount) {
            View viewM4251b = m4251b(iM4244a2);
            if (viewM4251b == null) {
                this.f3945f += m4257d(iM4244a2);
                i10 = iMax3;
                z4 = z7;
                z3 = z5;
                i11 = i13;
                i9 = i12;
            } else if (viewM4251b.getVisibility() == 8) {
                iM4244a2 += m4244a(viewM4251b, iM4244a2);
                i10 = iMax3;
                z4 = z7;
                z3 = z5;
                i11 = i13;
                i9 = i12;
            } else {
                if (m4256c(iM4244a2)) {
                    this.f3945f += this.f3951l;
                }
                LayoutParams layoutParams = (LayoutParams) viewM4251b.getLayoutParams();
                float f4 = f3 + layoutParams.f3955g;
                if (mode == 1073741824 && layoutParams.width == 0 && layoutParams.f3955g > CropImageView.DEFAULT_ASPECT_RATIO) {
                    if (z10) {
                        this.f3945f += layoutParams.leftMargin + layoutParams.rightMargin;
                    } else {
                        int i16 = this.f3945f;
                        this.f3945f = Math.max(i16, layoutParams.leftMargin + i16 + layoutParams.rightMargin);
                    }
                    if (z8) {
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        viewM4251b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    } else {
                        z7 = true;
                    }
                } else {
                    int i17 = Integer.MIN_VALUE;
                    if (layoutParams.width == 0 && layoutParams.f3955g > CropImageView.DEFAULT_ASPECT_RATIO) {
                        i17 = 0;
                        layoutParams.width = -2;
                    }
                    int i18 = i17;
                    m4249a(viewM4251b, iM4244a2, i, f4 == CropImageView.DEFAULT_ASPECT_RATIO ? this.f3945f : 0, i2, 0);
                    if (i18 != Integer.MIN_VALUE) {
                        layoutParams.width = i18;
                    }
                    int measuredWidth = viewM4251b.getMeasuredWidth();
                    if (z10) {
                        this.f3945f += layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + m4250b(viewM4251b);
                    } else {
                        int i19 = this.f3945f;
                        this.f3945f = Math.max(i19, i19 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + m4250b(viewM4251b));
                    }
                    if (z9) {
                        iMax3 = Math.max(measuredWidth, iMax3);
                    }
                }
                boolean z11 = false;
                if (mode2 == 1073741824 || layoutParams.height != -1) {
                    z2 = z6;
                } else {
                    z2 = true;
                    z11 = true;
                }
                int i20 = layoutParams.bottomMargin + layoutParams.topMargin;
                int measuredHeight = viewM4251b.getMeasuredHeight() + i20;
                int iCombineMeasuredStates2 = View.combineMeasuredStates(i13, viewM4251b.getMeasuredState());
                if (z8) {
                    int baseline2 = viewM4251b.getBaseline();
                    if (baseline2 != -1) {
                        int i21 = ((((layoutParams.f3956h < 0 ? this.f3944e : layoutParams.f3956h) & 112) >> 4) & (-2)) >> 1;
                        iArr[i21] = Math.max(iArr[i21], baseline2);
                        iArr2[i21] = Math.max(iArr2[i21], measuredHeight - baseline2);
                    }
                }
                int iMax4 = Math.max(i12, measuredHeight);
                z3 = z5 && layoutParams.height == -1;
                if (layoutParams.f3955g > CropImageView.DEFAULT_ASPECT_RATIO) {
                    iMax2 = Math.max(i15, z11 ? i20 : measuredHeight);
                    iMax = i14;
                } else {
                    if (!z11) {
                        i20 = measuredHeight;
                    }
                    iMax = Math.max(i14, i20);
                    iMax2 = i15;
                }
                iM4244a2 += m4244a(viewM4251b, iM4244a2);
                z4 = z7;
                i15 = iMax2;
                i14 = iMax;
                i9 = iMax4;
                i10 = iMax3;
                i11 = iCombineMeasuredStates2;
                z6 = z2;
                f3 = f4;
            }
            iM4244a2++;
            iMax3 = i10;
            z7 = z4;
            z5 = z3;
            i13 = i11;
            i12 = i9;
        }
        if (this.f3945f > 0 && m4256c(virtualChildCount)) {
            this.f3945f += this.f3951l;
        }
        int iMax5 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i12 : Math.max(i12, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        if (z9 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f3945f = 0;
            int i22 = 0;
            while (i22 < virtualChildCount) {
                View viewM4251b2 = m4251b(i22);
                if (viewM4251b2 == null) {
                    this.f3945f += m4257d(i22);
                    iM4244a = i22;
                } else if (viewM4251b2.getVisibility() == 8) {
                    iM4244a = m4244a(viewM4251b2, i22) + i22;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) viewM4251b2.getLayoutParams();
                    if (z10) {
                        this.f3945f = layoutParams2.rightMargin + layoutParams2.leftMargin + iMax3 + m4250b(viewM4251b2) + this.f3945f;
                        iM4244a = i22;
                    } else {
                        int i23 = this.f3945f;
                        this.f3945f = Math.max(i23, layoutParams2.rightMargin + i23 + iMax3 + layoutParams2.leftMargin + m4250b(viewM4251b2));
                        iM4244a = i22;
                    }
                }
                i22 = iM4244a + 1;
            }
        }
        this.f3945f += getPaddingLeft() + getPaddingRight();
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(this.f3945f, getSuggestedMinimumWidth()), i, 0);
        int i24 = (16777215 & iResolveSizeAndState) - this.f3945f;
        if (z7 || (i24 != 0 && f3 > CropImageView.DEFAULT_ASPECT_RATIO)) {
            if (this.f3946g > CropImageView.DEFAULT_ASPECT_RATIO) {
                f3 = this.f3946g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f3945f = 0;
            int i25 = 0;
            float f5 = f3;
            boolean z12 = z5;
            int i26 = i14;
            int i27 = i13;
            int i28 = i24;
            int iMax6 = -1;
            while (i25 < virtualChildCount) {
                View viewM4251b3 = m4251b(i25);
                if (viewM4251b3 == null) {
                    f = f5;
                    i5 = i28;
                    i6 = iMax6;
                    i7 = i26;
                    z = z12;
                } else if (viewM4251b3.getVisibility() == 8) {
                    f = f5;
                    i5 = i28;
                    i6 = iMax6;
                    i7 = i26;
                    z = z12;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) viewM4251b3.getLayoutParams();
                    float f6 = layoutParams3.f3955g;
                    if (f6 > CropImageView.DEFAULT_ASPECT_RATIO) {
                        int i29 = (int) ((i28 * f6) / f5);
                        float f7 = f5 - f6;
                        i8 = i28 - i29;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin, layoutParams3.height);
                        if (layoutParams3.width != 0 || mode != 1073741824) {
                            int measuredWidth2 = i29 + viewM4251b3.getMeasuredWidth();
                            if (measuredWidth2 < 0) {
                                measuredWidth2 = 0;
                            }
                            viewM4251b3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), childMeasureSpec);
                        } else {
                            if (i29 <= 0) {
                                i29 = 0;
                            }
                            viewM4251b3.measure(View.MeasureSpec.makeMeasureSpec(i29, 1073741824), childMeasureSpec);
                        }
                        iCombineMeasuredStates = View.combineMeasuredStates(i27, viewM4251b3.getMeasuredState() & (-16777216));
                        f2 = f7;
                    } else {
                        i8 = i28;
                        iCombineMeasuredStates = i27;
                        f2 = f5;
                    }
                    if (z10) {
                        this.f3945f += viewM4251b3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin + m4250b(viewM4251b3);
                    } else {
                        int i30 = this.f3945f;
                        this.f3945f = Math.max(i30, viewM4251b3.getMeasuredWidth() + i30 + layoutParams3.leftMargin + layoutParams3.rightMargin + m4250b(viewM4251b3));
                    }
                    boolean z13 = mode2 != 1073741824 && layoutParams3.height == -1;
                    int i31 = layoutParams3.topMargin + layoutParams3.bottomMargin;
                    int measuredHeight2 = viewM4251b3.getMeasuredHeight() + i31;
                    int iMax7 = Math.max(iMax6, measuredHeight2);
                    int iMax8 = Math.max(i26, z13 ? i31 : measuredHeight2);
                    boolean z14 = z12 && layoutParams3.height == -1;
                    if (z8 && (baseline = viewM4251b3.getBaseline()) != -1) {
                        int i32 = ((((layoutParams3.f3956h < 0 ? this.f3944e : layoutParams3.f3956h) & 112) >> 4) & (-2)) >> 1;
                        iArr[i32] = Math.max(iArr[i32], baseline);
                        iArr2[i32] = Math.max(iArr2[i32], measuredHeight2 - baseline);
                    }
                    f = f2;
                    i7 = iMax8;
                    z = z14;
                    i27 = iCombineMeasuredStates;
                    i5 = i8;
                    i6 = iMax7;
                }
                i25++;
                i26 = i7;
                iMax6 = i6;
                z12 = z;
                i28 = i5;
                f5 = f;
            }
            this.f3945f += getPaddingLeft() + getPaddingRight();
            if (iArr[1] != -1 || iArr[0] != -1 || iArr[2] != -1 || iArr[3] != -1) {
                iMax6 = Math.max(iMax6, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            z5 = z12;
            i3 = i26;
            i13 = i27;
            i4 = iMax6;
        } else {
            int iMax9 = Math.max(i14, i15);
            if (z9 && mode != 1073741824) {
                int i33 = 0;
                while (true) {
                    int i34 = i33;
                    if (i34 >= virtualChildCount) {
                        break;
                    }
                    View viewM4251b4 = m4251b(i34);
                    if (viewM4251b4 != null && viewM4251b4.getVisibility() != 8 && ((LayoutParams) viewM4251b4.getLayoutParams()).f3955g > CropImageView.DEFAULT_ASPECT_RATIO) {
                        viewM4251b4.measure(View.MeasureSpec.makeMeasureSpec(iMax3, 1073741824), View.MeasureSpec.makeMeasureSpec(viewM4251b4.getMeasuredHeight(), 1073741824));
                    }
                    i33 = i34 + 1;
                }
            }
            i3 = iMax9;
            i4 = iMax5;
        }
        if (z5 || mode2 == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension(((-16777216) & i13) | iResolveSizeAndState, View.resolveSizeAndState(Math.max(i3 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i13 << 16));
        if (z6) {
            m4242d(virtualChildCount, i);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m4242d(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View viewM4251b = m4251b(i3);
            if (viewM4251b.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) viewM4251b.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = viewM4251b.getMeasuredWidth();
                    measureChildWithMargins(viewM4251b, i2, 0, iMakeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    int m4244a(View view, int i) {
        return 0;
    }

    /* JADX INFO: renamed from: d */
    int m4257d(int i) {
        return 0;
    }

    /* JADX INFO: renamed from: a */
    void m4249a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX INFO: renamed from: a */
    int m4243a(View view) {
        return 0;
    }

    /* JADX INFO: renamed from: b */
    int m4250b(View view) {
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f3943d == 1) {
            m4246a(i, i2, i3, i4);
        } else {
            m4253b(i, i2, i3, i4);
        }
    }

    /* JADX INFO: renamed from: a */
    void m4246a(int i, int i2, int i3, int i4) {
        int paddingTop;
        int iM4244a;
        int i5;
        int paddingLeft = getPaddingLeft();
        int i6 = i3 - i;
        int paddingRight = i6 - getPaddingRight();
        int paddingRight2 = (i6 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i7 = this.f3944e & 112;
        int i8 = this.f3944e & 8388615;
        switch (i7) {
            case 16:
                paddingTop = getPaddingTop() + (((i4 - i2) - this.f3945f) / 2);
                break;
            case 80:
                paddingTop = ((getPaddingTop() + i4) - i2) - this.f3945f;
                break;
            default:
                paddingTop = getPaddingTop();
                break;
        }
        int i9 = 0;
        int iM4250b = paddingTop;
        while (i9 < virtualChildCount) {
            View viewM4251b = m4251b(i9);
            if (viewM4251b == null) {
                iM4250b += m4257d(i9);
                iM4244a = i9;
            } else if (viewM4251b.getVisibility() != 8) {
                int measuredWidth = viewM4251b.getMeasuredWidth();
                int measuredHeight = viewM4251b.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) viewM4251b.getLayoutParams();
                int i10 = layoutParams.f3956h;
                if (i10 < 0) {
                    i10 = i8;
                }
                switch (GravityCompat.m2508a(i10, ViewCompat.m2601e(this)) & 7) {
                    case 1:
                        i5 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case 5:
                        i5 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                        break;
                    default:
                        i5 = paddingLeft + layoutParams.leftMargin;
                        break;
                }
                int i11 = (m4256c(i9) ? this.f3952m + iM4250b : iM4250b) + layoutParams.topMargin;
                m4240a(viewM4251b, i5, i11 + m4243a(viewM4251b), measuredWidth, measuredHeight);
                iM4250b = i11 + layoutParams.bottomMargin + measuredHeight + m4250b(viewM4251b);
                iM4244a = m4244a(viewM4251b, i9) + i9;
            } else {
                iM4244a = i9;
            }
            i9 = iM4244a + 1;
        }
    }

    /* JADX INFO: renamed from: b */
    void m4253b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int iM4244a;
        int baseline;
        int measuredHeight;
        boolean zM5031a = ViewUtils.m5031a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i8 = this.f3944e & 8388615;
        int i9 = this.f3944e & 112;
        boolean z = this.f3940a;
        int[] iArr = this.f3948i;
        int[] iArr2 = this.f3949j;
        switch (GravityCompat.m2508a(i8, ViewCompat.m2601e(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f3945f) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f3945f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (!zM5031a) {
            i5 = 1;
            i6 = 0;
        } else {
            i5 = -1;
            i6 = virtualChildCount - 1;
        }
        int i10 = 0;
        while (i10 < virtualChildCount) {
            int i11 = i6 + (i5 * i10);
            View viewM4251b = m4251b(i11);
            if (viewM4251b == null) {
                paddingLeft += m4257d(i11);
                iM4244a = i10;
            } else if (viewM4251b.getVisibility() != 8) {
                int measuredWidth = viewM4251b.getMeasuredWidth();
                int measuredHeight2 = viewM4251b.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) viewM4251b.getLayoutParams();
                if (!z || layoutParams.height == -1) {
                    baseline = -1;
                } else {
                    baseline = viewM4251b.getBaseline();
                }
                int i12 = layoutParams.f3956h;
                if (i12 < 0) {
                    i12 = i9;
                }
                switch (i12 & 112) {
                    case 16:
                        measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        break;
                    case 48:
                        measuredHeight = paddingTop + layoutParams.topMargin;
                        if (baseline != -1) {
                            measuredHeight += iArr[1] - baseline;
                        }
                        break;
                    case 80:
                        measuredHeight = (paddingBottom - measuredHeight2) - layoutParams.bottomMargin;
                        if (baseline != -1) {
                            measuredHeight -= iArr2[2] - (viewM4251b.getMeasuredHeight() - baseline);
                        }
                        break;
                    default:
                        measuredHeight = paddingTop;
                        break;
                }
                int i13 = (m4256c(i11) ? this.f3951l + paddingLeft : paddingLeft) + layoutParams.leftMargin;
                m4240a(viewM4251b, i13 + m4243a(viewM4251b), measuredHeight, measuredWidth, measuredHeight2);
                paddingLeft = i13 + layoutParams.rightMargin + measuredWidth + m4250b(viewM4251b);
                iM4244a = m4244a(viewM4251b, i11) + i10;
            } else {
                iM4244a = i10;
            }
            i10 = iM4244a + 1;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4240a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.f3943d != i) {
            this.f3943d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.f3943d;
    }

    public void setGravity(int i) {
        if (this.f3944e != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f3944e = i2;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.f3944e;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.f3944e & 8388615) != i2) {
            this.f3944e = i2 | (this.f3944e & (-8388616));
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f3944e & 112) != i2) {
            this.f3944e = i2 | (this.f3944e & (-113));
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        if (this.f3943d == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.f3943d == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: g */
        public float f3955g;

        /* JADX INFO: renamed from: h */
        public int f3956h;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3956h = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.f3955g = typedArrayObtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, CropImageView.DEFAULT_ASPECT_RATIO);
            this.f3956h = typedArrayObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f3956h = -1;
            this.f3955g = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.f3956h = -1;
            this.f3955g = f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3956h = -1;
        }
    }
}
