package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.appcompat.R;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
class DropDownListView extends ListView {

    /* JADX INFO: renamed from: a */
    private final Rect f3839a;

    /* JADX INFO: renamed from: b */
    private int f3840b;

    /* JADX INFO: renamed from: c */
    private int f3841c;

    /* JADX INFO: renamed from: d */
    private int f3842d;

    /* JADX INFO: renamed from: e */
    private int f3843e;

    /* JADX INFO: renamed from: f */
    private int f3844f;

    /* JADX INFO: renamed from: g */
    private Field f3845g;

    /* JADX INFO: renamed from: h */
    private GateKeeperDrawable f3846h;

    /* JADX INFO: renamed from: i */
    private boolean f3847i;

    /* JADX INFO: renamed from: j */
    private boolean f3848j;

    /* JADX INFO: renamed from: k */
    private boolean f3849k;

    /* JADX INFO: renamed from: l */
    private ViewPropertyAnimatorCompat f3850l;

    /* JADX INFO: renamed from: m */
    private ListViewAutoScrollHelper f3851m;

    /* JADX INFO: renamed from: n */
    private ResolveHoverRunnable f3852n;

    DropDownListView(Context context, boolean z) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f3839a = new Rect();
        this.f3840b = 0;
        this.f3841c = 0;
        this.f3842d = 0;
        this.f3843e = 0;
        this.f3848j = z;
        setCacheColorHint(0);
        try {
            this.f3845g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f3845g.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f3848j && this.f3847i) || super.isInTouchMode();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f3848j || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f3848j || super.isFocused();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f3848j || super.hasFocus();
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        this.f3846h = drawable != null ? new GateKeeperDrawable(drawable) : null;
        super.setSelector(this.f3846h);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f3840b = rect.left;
        this.f3841c = rect.top;
        this.f3842d = rect.right;
        this.f3843e = rect.bottom;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f3852n == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            m4120a();
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        m4123a(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f3844f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        if (this.f3852n != null) {
            this.f3852n.m4132a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: renamed from: a */
    public int mo4129a(int i, int i2, int i3, int i4, int i5) {
        View view;
        int iMakeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingBottom + listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i7 = 0;
        View view2 = null;
        int i8 = 0;
        int count = adapter.getCount();
        int i9 = 0;
        while (i9 < count) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            } else {
                view = view2;
            }
            view2 = adapter.getView(i9, view, this);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view2.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view2.measure(i, iMakeMeasureSpec);
            view2.forceLayout();
            int measuredHeight = (i9 > 0 ? i6 + dividerHeight : i6) + view2.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i9 <= i5 || i7 <= 0 || measuredHeight == i4) ? i4 : i7;
            }
            if (i5 >= 0 && i9 >= i5) {
                i7 = measuredHeight;
            }
            i9++;
            i6 = measuredHeight;
        }
        return i6;
    }

    private void setSelectorEnabled(boolean z) {
        if (this.f3846h != null) {
            this.f3846h.m4131a(z);
        }
    }

    private static class GateKeeperDrawable extends DrawableWrapper {

        /* JADX INFO: renamed from: a */
        private boolean f3853a;

        GateKeeperDrawable(Drawable drawable) {
            super(drawable);
            this.f3853a = true;
        }

        /* JADX INFO: renamed from: a */
        void m4131a(boolean z) {
            this.f3853a = z;
        }

        @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f3853a) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f3853a) {
                super.draw(canvas);
            }
        }

        @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            if (this.f3853a) {
                super.setHotspot(f, f2);
            }
        }

        @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f3853a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f3853a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f3852n == null) {
            this.f3852n = new ResolveHoverRunnable();
            this.f3852n.m4133b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
                m4120a();
                return zOnHoverEvent;
            }
            return zOnHoverEvent;
        }
        setSelection(-1);
        return zOnHoverEvent;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f3852n = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mo4130a(android.view.MotionEvent r9, int r10) {
        /*
            r8 = this;
            r2 = 1
            r1 = 0
            int r3 = r9.getActionMasked()
            switch(r3) {
                case 1: goto L2d;
                case 2: goto L6a;
                case 3: goto L2a;
                default: goto L9;
            }
        L9:
            r0 = r1
            r3 = r2
        Lb:
            if (r3 == 0) goto Lf
            if (r0 == 0) goto L12
        Lf:
            r8.m4126b()
        L12:
            if (r3 == 0) goto L60
            android.support.v4.widget.ListViewAutoScrollHelper r0 = r8.f3851m
            if (r0 != 0) goto L1f
            android.support.v4.widget.ListViewAutoScrollHelper r0 = new android.support.v4.widget.ListViewAutoScrollHelper
            r0.<init>(r8)
            r8.f3851m = r0
        L1f:
            android.support.v4.widget.ListViewAutoScrollHelper r0 = r8.f3851m
            r0.m2852a(r2)
            android.support.v4.widget.ListViewAutoScrollHelper r0 = r8.f3851m
            r0.onTouch(r8, r9)
        L29:
            return r3
        L2a:
            r0 = r1
            r3 = r1
            goto Lb
        L2d:
            r0 = r1
        L2e:
            int r4 = r9.findPointerIndex(r10)
            if (r4 >= 0) goto L37
            r0 = r1
            r3 = r1
            goto Lb
        L37:
            float r5 = r9.getX(r4)
            int r5 = (int) r5
            float r4 = r9.getY(r4)
            int r4 = (int) r4
            int r6 = r8.pointToPosition(r5, r4)
            r7 = -1
            if (r6 != r7) goto L4b
            r3 = r0
            r0 = r2
            goto Lb
        L4b:
            int r0 = r8.getFirstVisiblePosition()
            int r0 = r6 - r0
            android.view.View r0 = r8.getChildAt(r0)
            float r5 = (float) r5
            float r4 = (float) r4
            r8.m4125a(r0, r6, r5, r4)
            if (r3 != r2) goto L9
            r8.m4124a(r0, r6)
            goto L9
        L60:
            android.support.v4.widget.ListViewAutoScrollHelper r0 = r8.f3851m
            if (r0 == 0) goto L29
            android.support.v4.widget.ListViewAutoScrollHelper r0 = r8.f3851m
            r0.m2852a(r1)
            goto L29
        L6a:
            r0 = r2
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.DropDownListView.mo4130a(android.view.MotionEvent, int):boolean");
    }

    /* JADX INFO: renamed from: a */
    private void m4124a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    void setListSelectionHidden(boolean z) {
        this.f3847i = z;
    }

    /* JADX INFO: renamed from: a */
    private void m4120a() {
        Drawable selector = getSelector();
        if (selector != null && m4128c() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4123a(Canvas canvas) {
        Drawable selector;
        if (!this.f3839a.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f3839a);
            selector.draw(canvas);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4122a(int i, View view, float f, float f2) {
        m4121a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            DrawableCompat.m1986a(selector, f, f2);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4121a(int i, View view) {
        Drawable selector = getSelector();
        boolean z = (selector == null || i == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        m4127b(i, view);
        if (z) {
            Rect rect = this.f3839a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            DrawableCompat.m1986a(selector, fExactCenterX, fExactCenterY);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4127b(int i, View view) {
        Rect rect = this.f3839a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f3840b;
        rect.top -= this.f3841c;
        rect.right += this.f3842d;
        rect.bottom += this.f3843e;
        try {
            boolean z = this.f3845g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f3845g.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4126b() {
        this.f3849k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f3844f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.f3850l != null) {
            this.f3850l.m2760b();
            this.f3850l = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4125a(View view, int i, float f, float f2) {
        View childAt;
        this.f3849k = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.f3844f != -1 && (childAt = getChildAt(this.f3844f - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f3844f = i;
        float left = f - view.getLeft();
        float top = f2 - view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m4122a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    /* JADX INFO: renamed from: c */
    private boolean m4128c() {
        return this.f3849k;
    }

    private class ResolveHoverRunnable implements Runnable {
        private ResolveHoverRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView.this.f3852n = null;
            DropDownListView.this.drawableStateChanged();
        }

        /* JADX INFO: renamed from: a */
        public void m4132a() {
            DropDownListView.this.f3852n = null;
            DropDownListView.this.removeCallbacks(this);
        }

        /* JADX INFO: renamed from: b */
        public void m4133b() {
            DropDownListView.this.post(this);
        }
    }
}
