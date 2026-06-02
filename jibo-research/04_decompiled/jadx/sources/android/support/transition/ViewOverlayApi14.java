package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ViewOverlayApi14 implements ViewOverlayImpl {

    /* JADX INFO: renamed from: a */
    protected OverlayViewGroup f1349a;

    ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        this.f1349a = new OverlayViewGroup(context, viewGroup, view, this);
    }

    /* JADX INFO: renamed from: c */
    static ViewGroup m1289c(View view) {
        View view2 = view;
        while (view2 != null) {
            if (view2.getId() == 16908290 && (view2 instanceof ViewGroup)) {
                return (ViewGroup) view2;
            }
            if (view2.getParent() instanceof ViewGroup) {
                view2 = (ViewGroup) view2.getParent();
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    static ViewOverlayApi14 m1290d(View view) {
        ViewGroup viewGroupM1289c = m1289c(view);
        if (viewGroupM1289c != null) {
            int childCount = viewGroupM1289c.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroupM1289c.getChildAt(i);
                if (childAt instanceof OverlayViewGroup) {
                    return ((OverlayViewGroup) childAt).f1354e;
                }
            }
            return new ViewGroupOverlayApi14(viewGroupM1289c.getContext(), viewGroupM1289c, view);
        }
        return null;
    }

    @Override // android.support.transition.ViewOverlayImpl
    /* JADX INFO: renamed from: a */
    public void mo1281a(Drawable drawable) {
        this.f1349a.m1292a(drawable);
    }

    @Override // android.support.transition.ViewOverlayImpl
    /* JADX INFO: renamed from: b */
    public void mo1282b(Drawable drawable) {
        this.f1349a.m1295b(drawable);
    }

    static class OverlayViewGroup extends ViewGroup {

        /* JADX INFO: renamed from: a */
        static Method f1350a;

        /* JADX INFO: renamed from: b */
        ViewGroup f1351b;

        /* JADX INFO: renamed from: c */
        View f1352c;

        /* JADX INFO: renamed from: d */
        ArrayList<Drawable> f1353d;

        /* JADX INFO: renamed from: e */
        ViewOverlayApi14 f1354e;

        static {
            try {
                f1350a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException e) {
            }
        }

        OverlayViewGroup(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
            super(context);
            this.f1353d = null;
            this.f1351b = viewGroup;
            this.f1352c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f1354e = viewOverlayApi14;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public void m1292a(Drawable drawable) {
            if (this.f1353d == null) {
                this.f1353d = new ArrayList<>();
            }
            if (!this.f1353d.contains(drawable)) {
                this.f1353d.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        /* JADX INFO: renamed from: b */
        public void m1295b(Drawable drawable) {
            if (this.f1353d != null) {
                this.f1353d.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
            }
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            return super.verifyDrawable(drawable) || (this.f1353d != null && this.f1353d.contains(drawable));
        }

        /* JADX INFO: renamed from: a */
        public void m1293a(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f1351b && viewGroup.getParent() != null && ViewCompat.m2570B(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f1351b.getLocationOnScreen(iArr2);
                    ViewCompat.m2600d(view, iArr[0] - iArr2[0]);
                    ViewCompat.m2598c(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        /* JADX INFO: renamed from: b */
        public void m1296b(View view) {
            super.removeView(view);
            if (m1294a()) {
                this.f1351b.removeView(this);
            }
        }

        /* JADX INFO: renamed from: a */
        boolean m1294a() {
            return getChildCount() == 0 && (this.f1353d == null || this.f1353d.size() == 0);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            this.f1351b.getLocationOnScreen(new int[2]);
            this.f1352c.getLocationOnScreen(new int[2]);
            canvas.translate(r2[0] - r1[0], r2[1] - r1[1]);
            canvas.clipRect(new Rect(0, 0, this.f1352c.getWidth(), this.f1352c.getHeight()));
            super.dispatchDraw(canvas);
            int size = this.f1353d == null ? 0 : this.f1353d.size();
            for (int i = 0; i < size; i++) {
                this.f1353d.get(i).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        /* JADX INFO: renamed from: a */
        private void m1291a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f1351b.getLocationOnScreen(iArr2);
            this.f1352c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f1351b != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.f1351b instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    m1291a(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
            }
            return null;
        }
    }
}
