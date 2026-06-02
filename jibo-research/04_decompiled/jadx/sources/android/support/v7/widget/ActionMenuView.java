package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {

    /* JADX INFO: renamed from: a */
    MenuBuilder.Callback f3559a;

    /* JADX INFO: renamed from: b */
    OnMenuItemClickListener f3560b;

    /* JADX INFO: renamed from: c */
    private MenuBuilder f3561c;

    /* JADX INFO: renamed from: d */
    private Context f3562d;

    /* JADX INFO: renamed from: e */
    private int f3563e;

    /* JADX INFO: renamed from: f */
    private boolean f3564f;

    /* JADX INFO: renamed from: g */
    private ActionMenuPresenter f3565g;

    /* JADX INFO: renamed from: h */
    private MenuPresenter.Callback f3566h;

    /* JADX INFO: renamed from: i */
    private boolean f3567i;

    /* JADX INFO: renamed from: j */
    private int f3568j;

    /* JADX INFO: renamed from: k */
    private int f3569k;

    /* JADX INFO: renamed from: l */
    private int f3570l;

    public interface ActionMenuChildView {
        /* JADX INFO: renamed from: c */
        boolean mo3509c();

        /* JADX INFO: renamed from: d */
        boolean mo3510d();
    }

    public interface OnMenuItemClickListener {
        /* JADX INFO: renamed from: a */
        boolean mo3762a(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f3569k = (int) (56.0f * f);
        this.f3570l = (int) (f * 4.0f);
        this.f3562d = context;
        this.f3563e = 0;
    }

    public void setPopupTheme(int i) {
        if (this.f3563e != i) {
            this.f3563e = i;
            if (i == 0) {
                this.f3562d = getContext();
            } else {
                this.f3562d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f3563e;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f3565g = actionMenuPresenter;
        this.f3565g.m3731a(this);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f3565g != null) {
            this.f3565g.mo351a(false);
            if (this.f3565g.m3739j()) {
                this.f3565g.m3736g();
                this.f3565g.m3735f();
            }
        }
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f3560b = onMenuItemClickListener;
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z = this.f3567i;
        this.f3567i = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f3567i) {
            this.f3568j = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.f3567i && this.f3561c != null && size != this.f3568j) {
            this.f3568j = size;
            this.f3561c.mo394a(true);
        }
        int childCount = getChildCount();
        if (this.f3567i && childCount > 0) {
            m3745c(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0302 A[PHI: r7
      0x0302: PHI (r7v9 float) = (r7v8 float), (r7v17 float), (r7v17 float) binds: [B:72:0x0187, B:79:0x01b0, B:81:0x01c2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01dc  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m3745c(int r35, int r36) {
        /*
            Method dump skipped, instruction units count: 802
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionMenuView.m3745c(int, int):void");
    }

    /* JADX INFO: renamed from: a */
    static int m3744a(View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.m3508b();
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z2 && i5 < 2) {
                i5 = 2;
            }
        }
        if (!layoutParams.f3571a && z2) {
            z = true;
        }
        layoutParams.f3574d = z;
        layoutParams.f3572b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), iMakeMeasureSpec);
        return i5;
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        int width;
        int paddingLeft;
        if (!this.f3567i) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i10 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i11 = 0;
        int i12 = 0;
        int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
        boolean z3 = false;
        boolean zM5031a = ViewUtils.m5031a(this);
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                z2 = z3;
                i8 = i12;
                i7 = paddingRight;
                i9 = i11;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f3571a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (m3750a(i13)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zM5031a) {
                        paddingLeft = layoutParams.leftMargin + getPaddingLeft();
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i14 = i10 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i14, width, measuredHeight + i14);
                    i7 = paddingRight - measuredWidth;
                    z2 = true;
                    i8 = i12;
                    i9 = i11;
                } else {
                    int measuredWidth2 = childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                    int i15 = i11 + measuredWidth2;
                    int i16 = paddingRight - measuredWidth2;
                    if (m3750a(i13)) {
                        i15 += dividerWidth;
                    }
                    boolean z4 = z3;
                    i7 = i16;
                    i8 = i12 + 1;
                    i9 = i15;
                    z2 = z4;
                }
            }
            i13++;
            i11 = i9;
            paddingRight = i7;
            i12 = i8;
            z3 = z2;
        }
        if (childCount == 1 && !z3) {
            View childAt2 = getChildAt(0);
            int measuredWidth3 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i17 = ((i3 - i) / 2) - (measuredWidth3 / 2);
            int i18 = i10 - (measuredHeight2 / 2);
            childAt2.layout(i17, i18, measuredWidth3 + i17, measuredHeight2 + i18);
            return;
        }
        int i19 = i12 - (z3 ? 0 : 1);
        int iMax = Math.max(0, i19 > 0 ? paddingRight / i19 : 0);
        if (zM5031a) {
            int width2 = getWidth() - getPaddingRight();
            int i20 = 0;
            while (i20 < childCount) {
                View childAt3 = getChildAt(i20);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    i6 = width2;
                } else if (layoutParams2.f3571a) {
                    i6 = width2;
                } else {
                    int i21 = width2 - layoutParams2.rightMargin;
                    int measuredWidth4 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i22 = i10 - (measuredHeight3 / 2);
                    childAt3.layout(i21 - measuredWidth4, i22, i21, measuredHeight3 + i22);
                    i6 = i21 - ((layoutParams2.leftMargin + measuredWidth4) + iMax);
                }
                i20++;
                width2 = i6;
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        int i23 = 0;
        while (i23 < childCount) {
            View childAt4 = getChildAt(i23);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() == 8) {
                i5 = paddingLeft2;
            } else if (layoutParams3.f3571a) {
                i5 = paddingLeft2;
            } else {
                int i24 = paddingLeft2 + layoutParams3.leftMargin;
                int measuredWidth5 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i25 = i10 - (measuredHeight4 / 2);
                childAt4.layout(i24, i25, i24 + measuredWidth5, measuredHeight4 + i25);
                i5 = layoutParams3.rightMargin + measuredWidth5 + iMax + i24;
            }
            i23++;
            paddingLeft2 = i5;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3760i();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f3565g.m3730a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f3565g.m3734e();
    }

    /* JADX INFO: renamed from: a */
    public boolean m3749a() {
        return this.f3564f;
    }

    public void setOverflowReserved(boolean z) {
        this.f3564f = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.f3956h = 16;
        return layoutParams;
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
            if (layoutParams2.f3956h <= 0) {
                layoutParams2.f3956h = 16;
                return layoutParams2;
            }
            return layoutParams2;
        }
        return generateDefaultLayoutParams();
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    /* JADX INFO: renamed from: c */
    public LayoutParams m3754c() {
        LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.f3571a = true;
        return layoutParamsGenerateDefaultLayoutParams;
    }

    @Override // android.support.v7.view.menu.MenuBuilder.ItemInvoker
    /* JADX INFO: renamed from: a */
    public boolean mo3554a(MenuItemImpl menuItemImpl) {
        return this.f3561c.m3594a(menuItemImpl, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.support.v7.view.menu.MenuView
    /* JADX INFO: renamed from: a */
    public void mo343a(MenuBuilder menuBuilder) {
        this.f3561c = menuBuilder;
    }

    public Menu getMenu() {
        if (this.f3561c == null) {
            Context context = getContext();
            this.f3561c = new MenuBuilder(context);
            this.f3561c.mo3587a(new MenuBuilderCallback());
            this.f3565g = new ActionMenuPresenter(context);
            this.f3565g.m3732c(true);
            this.f3565g.mo350a(this.f3566h != null ? this.f3566h : new ActionMenuPresenterCallback());
            this.f3561c.m3590a(this.f3565g, this.f3562d);
            this.f3565g.m3731a(this);
        }
        return this.f3561c;
    }

    /* JADX INFO: renamed from: a */
    public void m3748a(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f3566h = callback;
        this.f3559a = callback2;
    }

    /* JADX INFO: renamed from: d */
    public MenuBuilder m3755d() {
        return this.f3561c;
    }

    /* JADX INFO: renamed from: e */
    public boolean m3756e() {
        return this.f3565g != null && this.f3565g.m3735f();
    }

    /* JADX INFO: renamed from: f */
    public boolean m3757f() {
        return this.f3565g != null && this.f3565g.m3736g();
    }

    /* JADX INFO: renamed from: g */
    public boolean m3758g() {
        return this.f3565g != null && this.f3565g.m3739j();
    }

    /* JADX INFO: renamed from: h */
    public boolean m3759h() {
        return this.f3565g != null && this.f3565g.m3740k();
    }

    /* JADX INFO: renamed from: i */
    public void m3760i() {
        if (this.f3565g != null) {
            this.f3565g.m3737h();
        }
    }

    /* JADX INFO: renamed from: a */
    protected boolean m3750a(int i) {
        boolean zMo3510d = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            zMo3510d = false | ((ActionMenuChildView) childAt).mo3510d();
        }
        return (i <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? zMo3510d : ((ActionMenuChildView) childAt2).mo3509c() | zMo3510d;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f3565g.m3733d(z);
    }

    private class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo518a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return ActionMenuView.this.f3560b != null && ActionMenuView.this.f3560b.mo3762a(menuItem);
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        /* JADX INFO: renamed from: a */
        public void mo517a(MenuBuilder menuBuilder) {
            if (ActionMenuView.this.f3559a != null) {
                ActionMenuView.this.f3559a.mo517a(menuBuilder);
            }
        }
    }

    private static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        /* JADX INFO: renamed from: a */
        public void mo3327a(MenuBuilder menuBuilder, boolean z) {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo3328a(MenuBuilder menuBuilder) {
            return false;
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* JADX INFO: renamed from: a */
        @ViewDebug.ExportedProperty
        public boolean f3571a;

        /* JADX INFO: renamed from: b */
        @ViewDebug.ExportedProperty
        public int f3572b;

        /* JADX INFO: renamed from: c */
        @ViewDebug.ExportedProperty
        public int f3573c;

        /* JADX INFO: renamed from: d */
        @ViewDebug.ExportedProperty
        public boolean f3574d;

        /* JADX INFO: renamed from: e */
        @ViewDebug.ExportedProperty
        public boolean f3575e;

        /* JADX INFO: renamed from: f */
        boolean f3576f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f3571a = layoutParams.f3571a;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f3571a = false;
        }
    }
}
