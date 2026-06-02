package android.support.v4.view;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public final class ViewParentCompat {

    /* JADX INFO: renamed from: a */
    static final ViewParentCompatBaseImpl f2431a;

    static class ViewParentCompatBaseImpl {
        ViewParentCompatBaseImpl() {
        }

        /* JADX INFO: renamed from: a */
        public boolean mo2749a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        /* JADX INFO: renamed from: b */
        public void mo2750b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo2744a(ViewParent viewParent, View view) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onStopNestedScroll(view);
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo2745a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo2746a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        /* JADX INFO: renamed from: a */
        public boolean mo2748a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo2747a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    static class ViewParentCompatApi19Impl extends ViewParentCompatBaseImpl {
        ViewParentCompatApi19Impl() {
        }
    }

    static class ViewParentCompatApi21Impl extends ViewParentCompatApi19Impl {
        ViewParentCompatApi21Impl() {
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public boolean mo2749a(ViewParent viewParent, View view, View view2, int i) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
                return false;
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        /* JADX INFO: renamed from: b */
        public void mo2750b(ViewParent viewParent, View view, View view2, int i) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2744a(ViewParent viewParent, View view) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2745a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2746a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public boolean mo2748a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
                return false;
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public boolean mo2747a(ViewParent viewParent, View view, float f, float f2) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
                return false;
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f2431a = new ViewParentCompatApi21Impl();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f2431a = new ViewParentCompatApi19Impl();
        } else {
            f2431a = new ViewParentCompatBaseImpl();
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2742a(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).mo662a(view, view2, i, i2);
        }
        if (i2 == 0) {
            return f2431a.mo2749a(viewParent, view, view2, i);
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static void m2743b(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).mo667b(view, view2, i, i2);
        } else if (i2 == 0) {
            f2431a.mo2750b(viewParent, view, view2, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2737a(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).mo669c(view, i);
        } else if (i == 0) {
            f2431a.mo2744a(viewParent, view);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2738a(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).mo655a(view, i, i2, i3, i4, i5);
        } else if (i5 == 0) {
            f2431a.mo2745a(viewParent, view, i, i2, i3, i4);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2739a(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).mo656a(view, i, i2, iArr, i3);
        } else if (i3 == 0) {
            f2431a.mo2746a(viewParent, view, i, i2, iArr);
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2741a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f2431a.mo2748a(viewParent, view, f, f2, z);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2740a(ViewParent viewParent, View view, float f, float f2) {
        return f2431a.mo2747a(viewParent, view, f, f2);
    }
}
