package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public abstract class ForwardingListener implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a */
    private final float f3893a;

    /* JADX INFO: renamed from: b */
    private final int f3894b;

    /* JADX INFO: renamed from: c */
    final View f3895c;

    /* JADX INFO: renamed from: d */
    private final int f3896d;

    /* JADX INFO: renamed from: e */
    private Runnable f3897e;

    /* JADX INFO: renamed from: f */
    private Runnable f3898f;

    /* JADX INFO: renamed from: g */
    private boolean f3899g;

    /* JADX INFO: renamed from: h */
    private int f3900h;

    /* JADX INFO: renamed from: i */
    private final int[] f3901i = new int[2];

    /* JADX INFO: renamed from: a */
    public abstract ShowableListMenu mo3511a();

    public ForwardingListener(View view) {
        this.f3895c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f3893a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f3894b = ViewConfiguration.getTapTimeout();
        this.f3896d = (this.f3894b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f3899g;
        if (z2) {
            z = m4168b(motionEvent) || !mo3741c();
        } else {
            boolean z3 = m4165a(motionEvent) && mo3512b();
            if (z3) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0);
                this.f3895c.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
            z = z3;
        }
        this.f3899g = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f3899g = false;
        this.f3900h = -1;
        if (this.f3897e != null) {
            this.f3895c.removeCallbacks(this.f3897e);
        }
    }

    /* JADX INFO: renamed from: b */
    protected boolean mo3512b() {
        ShowableListMenu showableListMenuMo3511a = mo3511a();
        if (showableListMenuMo3511a != null && !showableListMenuMo3511a.mo3548f()) {
            showableListMenuMo3511a.mo3546d();
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    protected boolean mo3741c() {
        ShowableListMenu showableListMenuMo3511a = mo3511a();
        if (showableListMenuMo3511a != null && showableListMenuMo3511a.mo3548f()) {
            showableListMenuMo3511a.mo3547e();
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m4165a(MotionEvent motionEvent) {
        View view = this.f3895c;
        if (!view.isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f3900h = motionEvent.getPointerId(0);
                if (this.f3897e == null) {
                    this.f3897e = new DisallowIntercept();
                }
                view.postDelayed(this.f3897e, this.f3894b);
                if (this.f3898f == null) {
                    this.f3898f = new TriggerLongPress();
                }
                view.postDelayed(this.f3898f, this.f3896d);
                break;
            case 1:
            case 3:
                m4170e();
                break;
            case 2:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f3900h);
                if (iFindPointerIndex >= 0 && !m4166a(view, motionEvent.getX(iFindPointerIndex), motionEvent.getY(iFindPointerIndex), this.f3893a)) {
                    m4170e();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
        }
        return false;
    }

    /* JADX INFO: renamed from: e */
    private void m4170e() {
        if (this.f3898f != null) {
            this.f3895c.removeCallbacks(this.f3898f);
        }
        if (this.f3897e != null) {
            this.f3895c.removeCallbacks(this.f3897e);
        }
    }

    /* JADX INFO: renamed from: d */
    void m4171d() {
        m4170e();
        View view = this.f3895c;
        if (view.isEnabled() && !view.isLongClickable() && mo3512b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f3899g = true;
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m4168b(MotionEvent motionEvent) {
        DropDownListView dropDownListView;
        View view = this.f3895c;
        ShowableListMenu showableListMenuMo3511a = mo3511a();
        if (showableListMenuMo3511a == null || !showableListMenuMo3511a.mo3548f() || (dropDownListView = (DropDownListView) showableListMenuMo3511a.mo3549g()) == null || !dropDownListView.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m4169b(view, motionEventObtainNoHistory);
        m4167a(dropDownListView, motionEventObtainNoHistory);
        boolean zMo4130a = dropDownListView.mo4130a(motionEventObtainNoHistory, this.f3900h);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zMo4130a && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m4166a(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    /* JADX INFO: renamed from: a */
    private boolean m4167a(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f3901i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    /* JADX INFO: renamed from: b */
    private boolean m4169b(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f3901i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    private class DisallowIntercept implements Runnable {
        DisallowIntercept() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = ForwardingListener.this.f3895c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class TriggerLongPress implements Runnable {
        TriggerLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ForwardingListener.this.m4171d();
        }
    }
}
