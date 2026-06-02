package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public class MenuPopupHelper {

    /* JADX INFO: renamed from: a */
    private final Context f3423a;

    /* JADX INFO: renamed from: b */
    private final MenuBuilder f3424b;

    /* JADX INFO: renamed from: c */
    private final boolean f3425c;

    /* JADX INFO: renamed from: d */
    private final int f3426d;

    /* JADX INFO: renamed from: e */
    private final int f3427e;

    /* JADX INFO: renamed from: f */
    private View f3428f;

    /* JADX INFO: renamed from: g */
    private int f3429g;

    /* JADX INFO: renamed from: h */
    private boolean f3430h;

    /* JADX INFO: renamed from: i */
    private MenuPresenter.Callback f3431i;

    /* JADX INFO: renamed from: j */
    private MenuPopup f3432j;

    /* JADX INFO: renamed from: k */
    private PopupWindow.OnDismissListener f3433k;

    /* JADX INFO: renamed from: l */
    private final PopupWindow.OnDismissListener f3434l;

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.f3429g = 8388611;
        this.f3434l = new PopupWindow.OnDismissListener() { // from class: android.support.v7.view.menu.MenuPopupHelper.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MenuPopupHelper.this.mo3673e();
            }
        };
        this.f3423a = context;
        this.f3424b = menuBuilder;
        this.f3428f = view;
        this.f3425c = z;
        this.f3426d = i;
        this.f3427e = i2;
    }

    /* JADX INFO: renamed from: a */
    public void m3667a(PopupWindow.OnDismissListener onDismissListener) {
        this.f3433k = onDismissListener;
    }

    /* JADX INFO: renamed from: a */
    public void m3666a(View view) {
        this.f3428f = view;
    }

    /* JADX INFO: renamed from: a */
    public void m3668a(boolean z) {
        this.f3430h = z;
        if (this.f3432j != null) {
            this.f3432j.mo3543b(z);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3664a(int i) {
        this.f3429g = i;
    }

    /* JADX INFO: renamed from: a */
    public void m3663a() {
        if (!m3671c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* JADX INFO: renamed from: b */
    public MenuPopup m3670b() {
        if (this.f3432j == null) {
            this.f3432j = m3662g();
        }
        return this.f3432j;
    }

    /* JADX INFO: renamed from: c */
    public boolean m3671c() {
        if (m3674f()) {
            return true;
        }
        if (this.f3428f == null) {
            return false;
        }
        m3661a(0, 0, false, false);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean m3669a(int i, int i2) {
        if (m3674f()) {
            return true;
        }
        if (this.f3428f == null) {
            return false;
        }
        m3661a(i, i2, true, true);
        return true;
    }

    /* JADX INFO: renamed from: g */
    private MenuPopup m3662g() {
        MenuPopup standardMenuPopup;
        Display defaultDisplay = ((WindowManager) this.f3423a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.f3423a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
            standardMenuPopup = new CascadingMenuPopup(this.f3423a, this.f3428f, this.f3426d, this.f3427e, this.f3425c);
        } else {
            standardMenuPopup = new StandardMenuPopup(this.f3423a, this.f3424b, this.f3428f, this.f3426d, this.f3427e, this.f3425c);
        }
        standardMenuPopup.mo3539a(this.f3424b);
        standardMenuPopup.mo3541a(this.f3434l);
        standardMenuPopup.mo3540a(this.f3428f);
        standardMenuPopup.mo350a(this.f3431i);
        standardMenuPopup.mo3543b(this.f3430h);
        standardMenuPopup.mo3538a(this.f3429g);
        return standardMenuPopup;
    }

    /* JADX INFO: renamed from: a */
    private void m3661a(int i, int i2, boolean z, boolean z2) {
        MenuPopup menuPopupM3670b = m3670b();
        menuPopupM3670b.mo3545c(z2);
        if (z) {
            if ((GravityCompat.m2508a(this.f3429g, ViewCompat.m2601e(this.f3428f)) & 7) == 5) {
                i += this.f3428f.getWidth();
            }
            menuPopupM3670b.mo3542b(i);
            menuPopupM3670b.mo3544c(i2);
            int i3 = (int) ((this.f3423a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            menuPopupM3670b.m3659a(new Rect(i - i3, i2 - i3, i + i3, i3 + i2));
        }
        menuPopupM3670b.mo3546d();
    }

    /* JADX INFO: renamed from: d */
    public void m3672d() {
        if (m3674f()) {
            this.f3432j.mo3547e();
        }
    }

    /* JADX INFO: renamed from: e */
    protected void mo3673e() {
        this.f3432j = null;
        if (this.f3433k != null) {
            this.f3433k.onDismiss();
        }
    }

    /* JADX INFO: renamed from: f */
    public boolean m3674f() {
        return this.f3432j != null && this.f3432j.mo3548f();
    }

    /* JADX INFO: renamed from: a */
    public void m3665a(MenuPresenter.Callback callback) {
        this.f3431i = callback;
        if (this.f3432j != null) {
            this.f3432j.mo350a(callback);
        }
    }
}
