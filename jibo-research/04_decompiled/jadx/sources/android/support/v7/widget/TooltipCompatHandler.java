package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: classes.dex */
class TooltipCompatHandler implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: i */
    private static TooltipCompatHandler f4467i;

    /* JADX INFO: renamed from: j */
    private static TooltipCompatHandler f4468j;

    /* JADX INFO: renamed from: a */
    private final View f4469a;

    /* JADX INFO: renamed from: b */
    private final CharSequence f4470b;

    /* JADX INFO: renamed from: c */
    private final Runnable f4471c = new Runnable() { // from class: android.support.v7.widget.TooltipCompatHandler.1
        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.m4990a(false);
        }
    };

    /* JADX INFO: renamed from: d */
    private final Runnable f4472d = new Runnable() { // from class: android.support.v7.widget.TooltipCompatHandler.2
        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.m4986a();
        }
    };

    /* JADX INFO: renamed from: e */
    private int f4473e;

    /* JADX INFO: renamed from: f */
    private int f4474f;

    /* JADX INFO: renamed from: g */
    private TooltipPopup f4475g;

    /* JADX INFO: renamed from: h */
    private boolean f4476h;

    /* JADX INFO: renamed from: a */
    public static void m4989a(View view, CharSequence charSequence) {
        if (f4467i != null && f4467i.f4469a == view) {
            m4992b(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            if (f4468j != null && f4468j.f4469a == view) {
                f4468j.m4986a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new TooltipCompatHandler(view, charSequence);
    }

    private TooltipCompatHandler(View view, CharSequence charSequence) {
        this.f4469a = view;
        this.f4470b = charSequence;
        this.f4469a.setOnLongClickListener(this);
        this.f4469a.setOnHoverListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f4473e = view.getWidth() / 2;
        this.f4474f = view.getHeight() / 2;
        m4990a(true);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f4475g == null || !this.f4476h) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.f4469a.getContext().getSystemService("accessibility");
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
                switch (motionEvent.getAction()) {
                    case 7:
                        if (this.f4469a.isEnabled() && this.f4475g == null) {
                            this.f4473e = (int) motionEvent.getX();
                            this.f4474f = (int) motionEvent.getY();
                            m4992b(this);
                        }
                        break;
                    case 10:
                        m4986a();
                        break;
                }
            }
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m4986a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m4990a(boolean z) {
        long longPressTimeout;
        if (ViewCompat.m2570B(this.f4469a)) {
            m4992b(null);
            if (f4468j != null) {
                f4468j.m4986a();
            }
            f4468j = this;
            this.f4476h = z;
            this.f4475g = new TooltipPopup(this.f4469a.getContext());
            this.f4475g.m4997a(this.f4469a, this.f4473e, this.f4474f, this.f4476h, this.f4470b);
            this.f4469a.addOnAttachStateChangeListener(this);
            if (this.f4476h) {
                longPressTimeout = 2500;
            } else if ((ViewCompat.m2612p(this.f4469a) & 1) == 1) {
                longPressTimeout = 3000 - ((long) ViewConfiguration.getLongPressTimeout());
            } else {
                longPressTimeout = 15000 - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.f4469a.removeCallbacks(this.f4472d);
            this.f4469a.postDelayed(this.f4472d, longPressTimeout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m4986a() {
        if (f4468j == this) {
            f4468j = null;
            if (this.f4475g != null) {
                this.f4475g.m4996a();
                this.f4475g = null;
                this.f4469a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f4467i == this) {
            m4992b(null);
        }
        this.f4469a.removeCallbacks(this.f4472d);
    }

    /* JADX INFO: renamed from: b */
    private static void m4992b(TooltipCompatHandler tooltipCompatHandler) {
        if (f4467i != null) {
            f4467i.m4993c();
        }
        f4467i = tooltipCompatHandler;
        if (f4467i != null) {
            f4467i.m4991b();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4991b() {
        this.f4469a.postDelayed(this.f4471c, ViewConfiguration.getLongPressTimeout());
    }

    /* JADX INFO: renamed from: c */
    private void m4993c() {
        this.f4469a.removeCallbacks(this.f4471c);
    }
}
