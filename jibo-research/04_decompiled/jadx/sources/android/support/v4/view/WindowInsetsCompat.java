package android.support.v4.view;

import android.os.Build;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsCompat {

    /* JADX INFO: renamed from: a */
    private final Object f2444a;

    private WindowInsetsCompat(Object obj) {
        this.f2444a = obj;
    }

    /* JADX INFO: renamed from: a */
    public int m2768a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2444a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    /* JADX INFO: renamed from: b */
    public int m2770b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2444a).getSystemWindowInsetTop();
        }
        return 0;
    }

    /* JADX INFO: renamed from: c */
    public int m2771c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2444a).getSystemWindowInsetRight();
        }
        return 0;
    }

    /* JADX INFO: renamed from: d */
    public int m2772d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2444a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    /* JADX INFO: renamed from: e */
    public boolean m2773e() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2444a).hasSystemWindowInsets();
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    public boolean m2774f() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f2444a).isConsumed();
        }
        return false;
    }

    /* JADX INFO: renamed from: g */
    public WindowInsetsCompat m2775g() {
        if (Build.VERSION.SDK_INT >= 20) {
            return new WindowInsetsCompat(((WindowInsets) this.f2444a).consumeSystemWindowInsets());
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public WindowInsetsCompat m2769a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new WindowInsetsCompat(((WindowInsets) this.f2444a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WindowInsetsCompat windowInsetsCompat = (WindowInsetsCompat) obj;
        return this.f2444a == null ? windowInsetsCompat.f2444a == null : this.f2444a.equals(windowInsetsCompat.f2444a);
    }

    public int hashCode() {
        if (this.f2444a == null) {
            return 0;
        }
        return this.f2444a.hashCode();
    }

    /* JADX INFO: renamed from: a */
    static WindowInsetsCompat m2766a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new WindowInsetsCompat(obj);
    }

    /* JADX INFO: renamed from: a */
    static Object m2767a(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat == null) {
            return null;
        }
        return windowInsetsCompat.f2444a;
    }
}
