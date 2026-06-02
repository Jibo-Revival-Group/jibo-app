package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollingChildHelper {

    /* JADX INFO: renamed from: a */
    private ViewParent f2290a;

    /* JADX INFO: renamed from: b */
    private ViewParent f2291b;

    /* JADX INFO: renamed from: c */
    private final View f2292c;

    /* JADX INFO: renamed from: d */
    private boolean f2293d;

    /* JADX INFO: renamed from: e */
    private int[] f2294e;

    public NestedScrollingChildHelper(View view) {
        this.f2292c = view;
    }

    /* JADX INFO: renamed from: a */
    public void m2531a(boolean z) {
        if (this.f2293d) {
            ViewCompat.m2620x(this.f2292c);
        }
        this.f2293d = z;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2532a() {
        return this.f2293d;
    }

    /* JADX INFO: renamed from: b */
    public boolean m2541b() {
        return m2535a(0);
    }

    /* JADX INFO: renamed from: a */
    public boolean m2535a(int i) {
        return m2530d(i) != null;
    }

    /* JADX INFO: renamed from: b */
    public boolean m2542b(int i) {
        return m2536a(i, 0);
    }

    /* JADX INFO: renamed from: a */
    public boolean m2536a(int i, int i2) {
        if (m2535a(i2)) {
            return true;
        }
        if (m2532a()) {
            View view = this.f2292c;
            for (ViewParent parent = this.f2292c.getParent(); parent != null; parent = parent.getParent()) {
                if (ViewParentCompat.m2742a(parent, view, this.f2292c, i, i2)) {
                    m2529a(i2, parent);
                    ViewParentCompat.m2743b(parent, view, this.f2292c, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    public void m2543c() {
        m2544c(0);
    }

    /* JADX INFO: renamed from: c */
    public void m2544c(int i) {
        ViewParent viewParentM2530d = m2530d(i);
        if (viewParentM2530d != null) {
            ViewParentCompat.m2737a(viewParentM2530d, this.f2292c, i);
            m2529a(i, (ViewParent) null);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m2537a(int i, int i2, int i3, int i4, int[] iArr) {
        return m2538a(i, i2, i3, i4, iArr, 0);
    }

    /* JADX INFO: renamed from: a */
    public boolean m2538a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent viewParentM2530d;
        int i6;
        int i7;
        if (!m2532a() || (viewParentM2530d = m2530d(i5)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            if (iArr == null) {
                i6 = 0;
                i7 = 0;
            } else {
                this.f2292c.getLocationInWindow(iArr);
                int i8 = iArr[0];
                i6 = iArr[1];
                i7 = i8;
            }
            ViewParentCompat.m2738a(viewParentM2530d, this.f2292c, i, i2, i3, i4, i5);
            if (iArr != null) {
                this.f2292c.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i7;
                iArr[1] = iArr[1] - i6;
            }
            return true;
        }
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2539a(int i, int i2, int[] iArr, int[] iArr2) {
        return m2540a(i, i2, iArr, iArr2, 0);
    }

    /* JADX INFO: renamed from: a */
    public boolean m2540a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentM2530d;
        int i4;
        int i5;
        int[] iArr3;
        if (!m2532a() || (viewParentM2530d = m2530d(i3)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            if (iArr2 != null) {
                this.f2292c.getLocationInWindow(iArr2);
                int i6 = iArr2[0];
                i4 = iArr2[1];
                i5 = i6;
            } else {
                i4 = 0;
                i5 = 0;
            }
            if (iArr == null) {
                if (this.f2294e == null) {
                    this.f2294e = new int[2];
                }
                iArr3 = this.f2294e;
            } else {
                iArr3 = iArr;
            }
            iArr3[0] = 0;
            iArr3[1] = 0;
            ViewParentCompat.m2739a(viewParentM2530d, this.f2292c, i, i2, iArr3, i3);
            if (iArr2 != null) {
                this.f2292c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i5;
                iArr2[1] = iArr2[1] - i4;
            }
            return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
        }
        if (iArr2 == null) {
            return false;
        }
        iArr2[0] = 0;
        iArr2[1] = 0;
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2534a(float f, float f2, boolean z) {
        ViewParent viewParentM2530d;
        if (!m2532a() || (viewParentM2530d = m2530d(0)) == null) {
            return false;
        }
        return ViewParentCompat.m2741a(viewParentM2530d, this.f2292c, f, f2, z);
    }

    /* JADX INFO: renamed from: a */
    public boolean m2533a(float f, float f2) {
        ViewParent viewParentM2530d;
        if (!m2532a() || (viewParentM2530d = m2530d(0)) == null) {
            return false;
        }
        return ViewParentCompat.m2740a(viewParentM2530d, this.f2292c, f, f2);
    }

    /* JADX INFO: renamed from: d */
    private ViewParent m2530d(int i) {
        switch (i) {
            case 0:
                return this.f2290a;
            case 1:
                return this.f2291b;
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2529a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.f2290a = viewParent;
                break;
            case 1:
                this.f2291b = viewParent;
                break;
        }
    }
}
