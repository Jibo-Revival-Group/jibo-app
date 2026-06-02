package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* JADX INFO: renamed from: a */
    SparseArray<View> f70a;

    /* JADX INFO: renamed from: b */
    ConstraintWidgetContainer f71b;

    /* JADX INFO: renamed from: c */
    private final ArrayList<ConstraintWidget> f72c;

    /* JADX INFO: renamed from: d */
    private int f73d;

    /* JADX INFO: renamed from: e */
    private int f74e;

    /* JADX INFO: renamed from: f */
    private int f75f;

    /* JADX INFO: renamed from: g */
    private int f76g;

    /* JADX INFO: renamed from: h */
    private boolean f77h;

    /* JADX INFO: renamed from: i */
    private int f78i;

    /* JADX INFO: renamed from: j */
    private ConstraintSet f79j;

    public ConstraintLayout(Context context) {
        super(context);
        this.f70a = new SparseArray<>();
        this.f72c = new ArrayList<>(100);
        this.f71b = new ConstraintWidgetContainer();
        this.f73d = 0;
        this.f74e = 0;
        this.f75f = Integer.MAX_VALUE;
        this.f76g = Integer.MAX_VALUE;
        this.f77h = true;
        this.f78i = 2;
        this.f79j = null;
        m107b(null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f70a = new SparseArray<>();
        this.f72c = new ArrayList<>(100);
        this.f71b = new ConstraintWidgetContainer();
        this.f73d = 0;
        this.f74e = 0;
        this.f75f = Integer.MAX_VALUE;
        this.f76g = Integer.MAX_VALUE;
        this.f77h = true;
        this.f78i = 2;
        this.f79j = null;
        m107b(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f70a = new SparseArray<>();
        this.f72c = new ArrayList<>(100);
        this.f71b = new ConstraintWidgetContainer();
        this.f73d = 0;
        this.f74e = 0;
        this.f75f = Integer.MAX_VALUE;
        this.f76g = Integer.MAX_VALUE;
        this.f77h = true;
        this.f78i = 2;
        this.f79j = null;
        m107b(attributeSet);
    }

    @Override // android.view.View
    public void setId(int i) {
        this.f70a.remove(getId());
        super.setId(i);
        this.f70a.put(getId(), this);
    }

    /* JADX INFO: renamed from: b */
    private void m107b(AttributeSet attributeSet) {
        this.f71b.m230a(this);
        this.f70a.put(getId(), this);
        this.f79j = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f73d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f73d);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.f74e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f74e);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f75f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f75f);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f76g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f76g);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f78i = typedArrayObtainStyledAttributes.getInt(index, this.f78i);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    this.f79j = new ConstraintSet();
                    this.f79j.m117a(getContext(), resourceId);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f71b.m294m(this.f78i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget constraintWidgetM104a = m104a(view);
        if ((view instanceof Guideline) && !(constraintWidgetM104a instanceof android.support.constraint.solver.widgets.Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f105Z = new android.support.constraint.solver.widgets.Guideline();
            layoutParams.f97R = true;
            ((android.support.constraint.solver.widgets.Guideline) layoutParams.f105Z).m300m(layoutParams.f93N);
            ConstraintWidget constraintWidget = layoutParams.f105Z;
        }
        this.f70a.put(view.getId(), view);
        this.f77h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f70a.remove(view.getId());
        this.f71b.m315c(m104a(view));
        this.f77h = true;
    }

    public void setMinWidth(int i) {
        if (i != this.f73d) {
            this.f73d = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.f74e) {
            this.f74e = i;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.f73d;
    }

    public int getMinHeight() {
        return this.f74e;
    }

    public void setMaxWidth(int i) {
        if (i != this.f75f) {
            this.f75f = i;
            requestLayout();
        }
    }

    public void setMaxHeight(int i) {
        if (i != this.f76g) {
            this.f76g = i;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.f75f;
    }

    public int getMaxHeight() {
        return this.f76g;
    }

    /* JADX INFO: renamed from: c */
    private void m108c() {
        boolean z = false;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (!getChildAt(i).isLayoutRequested()) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            this.f72c.clear();
            m109d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02f0 A[PHI: r1 r2 r3 r4 r5 r6 r7
      0x02f0: PHI (r1v8 float) = (r1v7 float), (r1v84 float), (r1v84 float), (r1v84 float) binds: [B:53:0x00c5, B:62:0x00e3, B:64:0x00e6, B:131:0x0258] A[DONT_GENERATE, DONT_INLINE]
      0x02f0: PHI (r2v3 int) = (r2v2 int), (r2v37 int), (r2v37 int), (r2v37 int) binds: [B:53:0x00c5, B:62:0x00e3, B:64:0x00e6, B:131:0x0258] A[DONT_GENERATE, DONT_INLINE]
      0x02f0: PHI (r3v1 int) = (r3v0 int), (r3v19 int), (r3v19 int), (r3v19 int) binds: [B:53:0x00c5, B:62:0x00e3, B:64:0x00e6, B:131:0x0258] A[DONT_GENERATE, DONT_INLINE]
      0x02f0: PHI (r4v1 int) = (r4v0 int), (r4v11 int), (r4v11 int), (r4v11 int) binds: [B:53:0x00c5, B:62:0x00e3, B:64:0x00e6, B:131:0x0258] A[DONT_GENERATE, DONT_INLINE]
      0x02f0: PHI (r5v1 int) = (r5v0 int), (r5v10 int), (r5v10 int), (r5v10 int) binds: [B:53:0x00c5, B:62:0x00e3, B:64:0x00e6, B:131:0x0258] A[DONT_GENERATE, DONT_INLINE]
      0x02f0: PHI (r6v1 int) = (r6v0 int), (r6v6 int), (r6v6 int), (r6v6 int) binds: [B:53:0x00c5, B:62:0x00e3, B:64:0x00e6, B:131:0x0258] A[DONT_GENERATE, DONT_INLINE]
      0x02f0: PHI (r7v1 int) = (r7v0 int), (r7v6 int), (r7v6 int), (r7v6 int) binds: [B:53:0x00c5, B:62:0x00e3, B:64:0x00e6, B:131:0x0258] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x014f  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m109d() {
        /*
            Method dump skipped, instruction units count: 760
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.m109d():void");
    }

    /* JADX INFO: renamed from: a */
    private final ConstraintWidget m103a(int i) {
        if (i == 0) {
            return this.f71b;
        }
        View view = this.f70a.get(i);
        if (view == this) {
            return this.f71b;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f105Z;
    }

    /* JADX INFO: renamed from: a */
    private final ConstraintWidget m104a(View view) {
        if (view == this) {
            return this.f71b;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f105Z;
    }

    /* JADX INFO: renamed from: a */
    private void m105a(int i, int i2) {
        int measuredWidth;
        int measuredHeight;
        int baseline;
        boolean z;
        int childMeasureSpec;
        int childMeasureSpec2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = layoutParams.f105Z;
                if (!layoutParams.f97R) {
                    int i4 = layoutParams.width;
                    int i5 = layoutParams.height;
                    boolean z2 = false;
                    boolean z3 = false;
                    if (layoutParams.f94O || layoutParams.f95P || (!layoutParams.f94O && layoutParams.f85F == 1) || layoutParams.width == -1 || (!layoutParams.f95P && (layoutParams.f86G == 1 || layoutParams.height == -1))) {
                        if (i4 == 0 || i4 == -1) {
                            z = true;
                            childMeasureSpec = getChildMeasureSpec(i, paddingLeft, -2);
                        } else {
                            childMeasureSpec = getChildMeasureSpec(i, paddingLeft, i4);
                            z = false;
                        }
                        if (i5 == 0 || i5 == -1) {
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, -2);
                            z3 = true;
                        } else {
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, i5);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        measuredWidth = childAt.getMeasuredWidth();
                        boolean z4 = z;
                        measuredHeight = childAt.getMeasuredHeight();
                        z2 = z4;
                    } else {
                        measuredWidth = i4;
                        measuredHeight = i5;
                    }
                    constraintWidget.m245d(measuredWidth);
                    constraintWidget.m248e(measuredHeight);
                    if (z2) {
                        constraintWidget.m254h(measuredWidth);
                    }
                    if (z3) {
                        constraintWidget.m256i(measuredHeight);
                    }
                    if (layoutParams.f96Q && (baseline = childAt.getBaseline()) != -1) {
                        constraintWidget.m258j(baseline);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        boolean z;
        int iCombineMeasuredStates;
        int baseline;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.f71b.m233b(paddingLeft);
        this.f71b.m241c(paddingTop);
        m106b(i, i2);
        if (this.f77h) {
            this.f77h = false;
            m108c();
        }
        m105a(i, i2);
        if (getChildCount() > 0) {
            m111a();
        }
        int i3 = 0;
        int size = this.f72c.size();
        int paddingBottom = paddingTop + getPaddingBottom();
        int paddingRight = paddingLeft + getPaddingRight();
        if (size > 0) {
            boolean z2 = false;
            boolean z3 = this.f71b.m216B() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z4 = this.f71b.m217C() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            int i4 = 0;
            while (i4 < size) {
                ConstraintWidget constraintWidget = this.f72c.get(i4);
                if (constraintWidget instanceof android.support.constraint.solver.widgets.Guideline) {
                    iCombineMeasuredStates = i3;
                } else {
                    View view = (View) constraintWidget.m274x();
                    if (view == null) {
                        iCombineMeasuredStates = i3;
                    } else if (view.getVisibility() == 8) {
                        iCombineMeasuredStates = i3;
                    } else {
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        if (layoutParams.width == -2) {
                            iMakeMeasureSpec = getChildMeasureSpec(i, paddingRight, layoutParams.width);
                        } else {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.m253h(), 1073741824);
                        }
                        if (layoutParams.height == -2) {
                            iMakeMeasureSpec2 = getChildMeasureSpec(i2, paddingBottom, layoutParams.height);
                        } else {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.m261l(), 1073741824);
                        }
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        int measuredWidth = view.getMeasuredWidth();
                        int measuredHeight = view.getMeasuredHeight();
                        if (measuredWidth != constraintWidget.m253h()) {
                            constraintWidget.m245d(measuredWidth);
                            if (z3 && constraintWidget.m270t() > this.f71b.m253h()) {
                                this.f71b.m245d(Math.max(this.f73d, constraintWidget.m270t() + constraintWidget.mo218a(ConstraintAnchor.Type.RIGHT).m206d()));
                            }
                            z = true;
                        } else {
                            z = z2;
                        }
                        if (measuredHeight != constraintWidget.m261l()) {
                            constraintWidget.m248e(measuredHeight);
                            if (z4 && constraintWidget.m271u() > this.f71b.m261l()) {
                                this.f71b.m248e(Math.max(this.f74e, constraintWidget.m271u() + constraintWidget.mo218a(ConstraintAnchor.Type.BOTTOM).m206d()));
                            }
                            z = true;
                        }
                        if (layoutParams.f96Q && (baseline = view.getBaseline()) != -1 && baseline != constraintWidget.m273w()) {
                            constraintWidget.m258j(baseline);
                            z = true;
                        }
                        if (Build.VERSION.SDK_INT >= 11) {
                            iCombineMeasuredStates = combineMeasuredStates(i3, view.getMeasuredState());
                            z2 = z;
                        } else {
                            z2 = z;
                            iCombineMeasuredStates = i3;
                        }
                    }
                }
                i4++;
                i3 = iCombineMeasuredStates;
            }
            if (z2) {
                m111a();
            }
        }
        int iH = this.f71b.m253h() + paddingRight;
        int iL = this.f71b.m261l() + paddingBottom;
        if (Build.VERSION.SDK_INT >= 11) {
            int iResolveSizeAndState = resolveSizeAndState(iH, i, i3);
            int iResolveSizeAndState2 = resolveSizeAndState(iL, i2, i3 << 16);
            int iMin = Math.min(this.f75f, iResolveSizeAndState) & 16777215;
            int iMin2 = Math.min(this.f76g, iResolveSizeAndState2) & 16777215;
            if (this.f71b.m284D()) {
                iMin |= 16777216;
            }
            if (this.f71b.m285E()) {
                iMin2 |= 16777216;
            }
            setMeasuredDimension(iMin, iMin2);
            return;
        }
        setMeasuredDimension(iH, iL);
    }

    /* JADX INFO: renamed from: b */
    private void m106b(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        getLayoutParams();
        switch (mode) {
            case Integer.MIN_VALUE:
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                break;
            case 0:
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                size = 0;
                break;
            case 1073741824:
                size = Math.min(this.f75f, size) - paddingLeft;
                break;
            default:
                size = 0;
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                break;
            case 0:
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                size2 = 0;
                break;
            case 1073741824:
                size2 = Math.min(this.f76g, size2) - paddingTop;
                break;
            default:
                size2 = 0;
                break;
        }
        this.f71b.m250f(0);
        this.f71b.m252g(0);
        this.f71b.m228a(dimensionBehaviour);
        this.f71b.m245d(size);
        this.f71b.m237b(dimensionBehaviour2);
        this.f71b.m248e(size2);
        this.f71b.m250f((this.f73d - getPaddingLeft()) - getPaddingRight());
        this.f71b.m252g((this.f74e - getPaddingTop()) - getPaddingBottom());
    }

    /* JADX INFO: renamed from: a */
    protected void m111a() {
        this.f71b.mo286F();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || layoutParams.f97R || zIsInEditMode) {
                ConstraintWidget constraintWidget = layoutParams.f105Z;
                int iM264n = constraintWidget.m264n();
                int iM265o = constraintWidget.m265o();
                childAt.layout(iM264n, iM265o, constraintWidget.m253h() + iM264n, constraintWidget.m261l() + iM265o);
            }
        }
    }

    public void setOptimizationLevel(int i) {
        this.f71b.m294m(i);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.f79j = constraintSet;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: A */
        int f80A;

        /* JADX INFO: renamed from: B */
        public float f81B;

        /* JADX INFO: renamed from: C */
        public float f82C;

        /* JADX INFO: renamed from: D */
        public int f83D;

        /* JADX INFO: renamed from: E */
        public int f84E;

        /* JADX INFO: renamed from: F */
        public int f85F;

        /* JADX INFO: renamed from: G */
        public int f86G;

        /* JADX INFO: renamed from: H */
        public int f87H;

        /* JADX INFO: renamed from: I */
        public int f88I;

        /* JADX INFO: renamed from: J */
        public int f89J;

        /* JADX INFO: renamed from: K */
        public int f90K;

        /* JADX INFO: renamed from: L */
        public int f91L;

        /* JADX INFO: renamed from: M */
        public int f92M;

        /* JADX INFO: renamed from: N */
        public int f93N;

        /* JADX INFO: renamed from: O */
        boolean f94O;

        /* JADX INFO: renamed from: P */
        boolean f95P;

        /* JADX INFO: renamed from: Q */
        boolean f96Q;

        /* JADX INFO: renamed from: R */
        boolean f97R;

        /* JADX INFO: renamed from: S */
        int f98S;

        /* JADX INFO: renamed from: T */
        int f99T;

        /* JADX INFO: renamed from: U */
        int f100U;

        /* JADX INFO: renamed from: V */
        int f101V;

        /* JADX INFO: renamed from: W */
        int f102W;

        /* JADX INFO: renamed from: X */
        int f103X;

        /* JADX INFO: renamed from: Y */
        float f104Y;

        /* JADX INFO: renamed from: Z */
        ConstraintWidget f105Z;

        /* JADX INFO: renamed from: a */
        public int f106a;

        /* JADX INFO: renamed from: b */
        public int f107b;

        /* JADX INFO: renamed from: c */
        public float f108c;

        /* JADX INFO: renamed from: d */
        public int f109d;

        /* JADX INFO: renamed from: e */
        public int f110e;

        /* JADX INFO: renamed from: f */
        public int f111f;

        /* JADX INFO: renamed from: g */
        public int f112g;

        /* JADX INFO: renamed from: h */
        public int f113h;

        /* JADX INFO: renamed from: i */
        public int f114i;

        /* JADX INFO: renamed from: j */
        public int f115j;

        /* JADX INFO: renamed from: k */
        public int f116k;

        /* JADX INFO: renamed from: l */
        public int f117l;

        /* JADX INFO: renamed from: m */
        public int f118m;

        /* JADX INFO: renamed from: n */
        public int f119n;

        /* JADX INFO: renamed from: o */
        public int f120o;

        /* JADX INFO: renamed from: p */
        public int f121p;

        /* JADX INFO: renamed from: q */
        public int f122q;

        /* JADX INFO: renamed from: r */
        public int f123r;

        /* JADX INFO: renamed from: s */
        public int f124s;

        /* JADX INFO: renamed from: t */
        public int f125t;

        /* JADX INFO: renamed from: u */
        public int f126u;

        /* JADX INFO: renamed from: v */
        public int f127v;

        /* JADX INFO: renamed from: w */
        public float f128w;

        /* JADX INFO: renamed from: x */
        public float f129x;

        /* JADX INFO: renamed from: y */
        public String f130y;

        /* JADX INFO: renamed from: z */
        float f131z;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            int i;
            super(context, attributeSet);
            this.f106a = -1;
            this.f107b = -1;
            this.f108c = -1.0f;
            this.f109d = -1;
            this.f110e = -1;
            this.f111f = -1;
            this.f112g = -1;
            this.f113h = -1;
            this.f114i = -1;
            this.f115j = -1;
            this.f116k = -1;
            this.f117l = -1;
            this.f118m = -1;
            this.f119n = -1;
            this.f120o = -1;
            this.f121p = -1;
            this.f122q = -1;
            this.f123r = -1;
            this.f124s = -1;
            this.f125t = -1;
            this.f126u = -1;
            this.f127v = -1;
            this.f128w = 0.5f;
            this.f129x = 0.5f;
            this.f130y = null;
            this.f131z = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f80A = 1;
            this.f81B = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f82C = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f83D = 0;
            this.f84E = 0;
            this.f85F = 0;
            this.f86G = 0;
            this.f87H = 0;
            this.f88I = 0;
            this.f89J = 0;
            this.f90K = 0;
            this.f91L = -1;
            this.f92M = -1;
            this.f93N = -1;
            this.f94O = true;
            this.f95P = true;
            this.f96Q = false;
            this.f97R = false;
            this.f98S = -1;
            this.f99T = -1;
            this.f100U = -1;
            this.f101V = -1;
            this.f102W = -1;
            this.f103X = -1;
            this.f104Y = 0.5f;
            this.f105Z = new ConstraintWidget();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf) {
                    this.f109d = typedArrayObtainStyledAttributes.getResourceId(index, this.f109d);
                    if (this.f109d == -1) {
                        this.f109d = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf) {
                    this.f110e = typedArrayObtainStyledAttributes.getResourceId(index, this.f110e);
                    if (this.f110e == -1) {
                        this.f110e = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf) {
                    this.f111f = typedArrayObtainStyledAttributes.getResourceId(index, this.f111f);
                    if (this.f111f == -1) {
                        this.f111f = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf) {
                    this.f112g = typedArrayObtainStyledAttributes.getResourceId(index, this.f112g);
                    if (this.f112g == -1) {
                        this.f112g = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf) {
                    this.f113h = typedArrayObtainStyledAttributes.getResourceId(index, this.f113h);
                    if (this.f113h == -1) {
                        this.f113h = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf) {
                    this.f114i = typedArrayObtainStyledAttributes.getResourceId(index, this.f114i);
                    if (this.f114i == -1) {
                        this.f114i = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf) {
                    this.f115j = typedArrayObtainStyledAttributes.getResourceId(index, this.f115j);
                    if (this.f115j == -1) {
                        this.f115j = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf) {
                    this.f116k = typedArrayObtainStyledAttributes.getResourceId(index, this.f116k);
                    if (this.f116k == -1) {
                        this.f116k = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf) {
                    this.f117l = typedArrayObtainStyledAttributes.getResourceId(index, this.f117l);
                    if (this.f117l == -1) {
                        this.f117l = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX) {
                    this.f91L = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f91L);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY) {
                    this.f92M = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f92M);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin) {
                    this.f106a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f106a);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end) {
                    this.f107b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f107b);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent) {
                    this.f108c = typedArrayObtainStyledAttributes.getFloat(index, this.f108c);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_orientation) {
                    this.f93N = typedArrayObtainStyledAttributes.getInt(index, this.f93N);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf) {
                    this.f118m = typedArrayObtainStyledAttributes.getResourceId(index, this.f118m);
                    if (this.f118m == -1) {
                        this.f118m = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf) {
                    this.f119n = typedArrayObtainStyledAttributes.getResourceId(index, this.f119n);
                    if (this.f119n == -1) {
                        this.f119n = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf) {
                    this.f120o = typedArrayObtainStyledAttributes.getResourceId(index, this.f120o);
                    if (this.f120o == -1) {
                        this.f120o = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf) {
                    this.f121p = typedArrayObtainStyledAttributes.getResourceId(index, this.f121p);
                    if (this.f121p == -1) {
                        this.f121p = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft) {
                    this.f122q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f122q);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_goneMarginTop) {
                    this.f123r = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f123r);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_goneMarginRight) {
                    this.f124s = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f124s);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom) {
                    this.f125t = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f125t);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_goneMarginStart) {
                    this.f126u = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f126u);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd) {
                    this.f127v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f127v);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias) {
                    this.f128w = typedArrayObtainStyledAttributes.getFloat(index, this.f128w);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias) {
                    this.f129x = typedArrayObtainStyledAttributes.getFloat(index, this.f129x);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio) {
                    this.f130y = typedArrayObtainStyledAttributes.getString(index);
                    this.f131z = Float.NaN;
                    this.f80A = -1;
                    if (this.f130y != null) {
                        int length = this.f130y.length();
                        int iIndexOf = this.f130y.indexOf(44);
                        if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                            i = 0;
                        } else {
                            String strSubstring = this.f130y.substring(0, iIndexOf);
                            if (strSubstring.equalsIgnoreCase("W")) {
                                this.f80A = 0;
                            } else if (strSubstring.equalsIgnoreCase("H")) {
                                this.f80A = 1;
                            }
                            i = iIndexOf + 1;
                        }
                        int iIndexOf2 = this.f130y.indexOf(58);
                        if (iIndexOf2 >= 0 && iIndexOf2 < length - 1) {
                            String strSubstring2 = this.f130y.substring(i, iIndexOf2);
                            String strSubstring3 = this.f130y.substring(iIndexOf2 + 1);
                            if (strSubstring2.length() > 0 && strSubstring3.length() > 0) {
                                try {
                                    float f = Float.parseFloat(strSubstring2);
                                    float f2 = Float.parseFloat(strSubstring3);
                                    if (f > CropImageView.DEFAULT_ASPECT_RATIO && f2 > CropImageView.DEFAULT_ASPECT_RATIO) {
                                        if (this.f80A == 1) {
                                            this.f131z = Math.abs(f2 / f);
                                        } else {
                                            this.f131z = Math.abs(f / f2);
                                        }
                                    }
                                } catch (NumberFormatException e) {
                                }
                            }
                        } else {
                            String strSubstring4 = this.f130y.substring(i);
                            if (strSubstring4.length() > 0) {
                                try {
                                    this.f131z = Float.parseFloat(strSubstring4);
                                } catch (NumberFormatException e2) {
                                }
                            }
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight) {
                    this.f81B = typedArrayObtainStyledAttributes.getFloat(index, CropImageView.DEFAULT_ASPECT_RATIO);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight) {
                    this.f82C = typedArrayObtainStyledAttributes.getFloat(index, CropImageView.DEFAULT_ASPECT_RATIO);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle) {
                    this.f83D = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle) {
                    this.f84E = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default) {
                    this.f85F = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default) {
                    this.f86G = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min) {
                    this.f87H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f87H);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max) {
                    this.f89J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f89J);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min) {
                    this.f88I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f88I);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max) {
                    this.f90K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f90K);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator || index == R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator || index == R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator || index == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator || index == R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator) {
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            m113a();
        }

        /* JADX INFO: renamed from: a */
        public void m113a() {
            this.f97R = false;
            this.f94O = true;
            this.f95P = true;
            if (this.width == 0 || this.width == -1) {
                this.f94O = false;
            }
            if (this.height == 0 || this.height == -1) {
                this.f95P = false;
            }
            if (this.f108c != -1.0f || this.f106a != -1 || this.f107b != -1) {
                this.f97R = true;
                this.f94O = true;
                this.f95P = true;
                if (!(this.f105Z instanceof android.support.constraint.solver.widgets.Guideline)) {
                    this.f105Z = new android.support.constraint.solver.widgets.Guideline();
                }
                ((android.support.constraint.solver.widgets.Guideline) this.f105Z).m300m(this.f93N);
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f106a = -1;
            this.f107b = -1;
            this.f108c = -1.0f;
            this.f109d = -1;
            this.f110e = -1;
            this.f111f = -1;
            this.f112g = -1;
            this.f113h = -1;
            this.f114i = -1;
            this.f115j = -1;
            this.f116k = -1;
            this.f117l = -1;
            this.f118m = -1;
            this.f119n = -1;
            this.f120o = -1;
            this.f121p = -1;
            this.f122q = -1;
            this.f123r = -1;
            this.f124s = -1;
            this.f125t = -1;
            this.f126u = -1;
            this.f127v = -1;
            this.f128w = 0.5f;
            this.f129x = 0.5f;
            this.f130y = null;
            this.f131z = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f80A = 1;
            this.f81B = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f82C = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f83D = 0;
            this.f84E = 0;
            this.f85F = 0;
            this.f86G = 0;
            this.f87H = 0;
            this.f88I = 0;
            this.f89J = 0;
            this.f90K = 0;
            this.f91L = -1;
            this.f92M = -1;
            this.f93N = -1;
            this.f94O = true;
            this.f95P = true;
            this.f96Q = false;
            this.f97R = false;
            this.f98S = -1;
            this.f99T = -1;
            this.f100U = -1;
            this.f101V = -1;
            this.f102W = -1;
            this.f103X = -1;
            this.f104Y = 0.5f;
            this.f105Z = new ConstraintWidget();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f106a = -1;
            this.f107b = -1;
            this.f108c = -1.0f;
            this.f109d = -1;
            this.f110e = -1;
            this.f111f = -1;
            this.f112g = -1;
            this.f113h = -1;
            this.f114i = -1;
            this.f115j = -1;
            this.f116k = -1;
            this.f117l = -1;
            this.f118m = -1;
            this.f119n = -1;
            this.f120o = -1;
            this.f121p = -1;
            this.f122q = -1;
            this.f123r = -1;
            this.f124s = -1;
            this.f125t = -1;
            this.f126u = -1;
            this.f127v = -1;
            this.f128w = 0.5f;
            this.f129x = 0.5f;
            this.f130y = null;
            this.f131z = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f80A = 1;
            this.f81B = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f82C = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f83D = 0;
            this.f84E = 0;
            this.f85F = 0;
            this.f86G = 0;
            this.f87H = 0;
            this.f88I = 0;
            this.f89J = 0;
            this.f90K = 0;
            this.f91L = -1;
            this.f92M = -1;
            this.f93N = -1;
            this.f94O = true;
            this.f95P = true;
            this.f96Q = false;
            this.f97R = false;
            this.f98S = -1;
            this.f99T = -1;
            this.f100U = -1;
            this.f101V = -1;
            this.f102W = -1;
            this.f103X = -1;
            this.f104Y = 0.5f;
            this.f105Z = new ConstraintWidget();
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        public void resolveLayoutDirection(int i) {
            super.resolveLayoutDirection(i);
            this.f100U = -1;
            this.f101V = -1;
            this.f98S = -1;
            this.f99T = -1;
            this.f102W = -1;
            this.f103X = -1;
            this.f102W = this.f122q;
            this.f103X = this.f124s;
            this.f104Y = this.f128w;
            if (1 == getLayoutDirection()) {
                if (this.f118m != -1) {
                    this.f100U = this.f118m;
                } else if (this.f119n != -1) {
                    this.f101V = this.f119n;
                }
                if (this.f120o != -1) {
                    this.f99T = this.f120o;
                }
                if (this.f121p != -1) {
                    this.f98S = this.f121p;
                }
                if (this.f126u != -1) {
                    this.f103X = this.f126u;
                }
                if (this.f127v != -1) {
                    this.f102W = this.f127v;
                }
                this.f104Y = 1.0f - this.f128w;
            } else {
                if (this.f118m != -1) {
                    this.f99T = this.f118m;
                }
                if (this.f119n != -1) {
                    this.f98S = this.f119n;
                }
                if (this.f120o != -1) {
                    this.f100U = this.f120o;
                }
                if (this.f121p != -1) {
                    this.f101V = this.f121p;
                }
                if (this.f126u != -1) {
                    this.f102W = this.f126u;
                }
                if (this.f127v != -1) {
                    this.f103X = this.f127v;
                }
            }
            if (this.f120o == -1 && this.f121p == -1) {
                if (this.f111f != -1) {
                    this.f100U = this.f111f;
                } else if (this.f112g != -1) {
                    this.f101V = this.f112g;
                }
            }
            if (this.f119n == -1 && this.f118m == -1) {
                if (this.f109d != -1) {
                    this.f98S = this.f109d;
                } else if (this.f110e != -1) {
                    this.f99T = this.f110e;
                }
            }
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.f77h = true;
    }
}
