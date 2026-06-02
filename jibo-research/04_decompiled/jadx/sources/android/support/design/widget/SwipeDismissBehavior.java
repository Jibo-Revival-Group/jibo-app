package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a */
    private boolean f829a;

    /* JADX INFO: renamed from: b */
    ViewDragHelper f830b;

    /* JADX INFO: renamed from: c */
    OnDismissListener f831c;

    /* JADX INFO: renamed from: i */
    private boolean f837i;

    /* JADX INFO: renamed from: h */
    private float f836h = CropImageView.DEFAULT_ASPECT_RATIO;

    /* JADX INFO: renamed from: d */
    int f832d = 2;

    /* JADX INFO: renamed from: e */
    float f833e = 0.5f;

    /* JADX INFO: renamed from: f */
    float f834f = CropImageView.DEFAULT_ASPECT_RATIO;

    /* JADX INFO: renamed from: g */
    float f835g = 0.5f;

    /* JADX INFO: renamed from: j */
    private final ViewDragHelper.Callback f838j = new ViewDragHelper.Callback() { // from class: android.support.design.widget.SwipeDismissBehavior.1

        /* JADX INFO: renamed from: b */
        private int f840b;

        /* JADX INFO: renamed from: c */
        private int f841c = -1;

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo548a(View view, int i) {
            return this.f841c == -1 && SwipeDismissBehavior.this.mo511a(view);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: b */
        public void mo841b(View view, int i) {
            this.f841c = i;
            this.f840b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public void mo545a(int i) {
            if (SwipeDismissBehavior.this.f831c != null) {
                SwipeDismissBehavior.this.f831c.mo502a(i);
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public void mo546a(View view, float f, float f2) {
            int i;
            this.f841c = -1;
            int width = view.getWidth();
            boolean z = false;
            if (m839a(view, f)) {
                i = view.getLeft() < this.f840b ? this.f840b - width : this.f840b + width;
                z = true;
            } else {
                i = this.f840b;
            }
            if (SwipeDismissBehavior.this.f830b.m3151a(i, view.getTop())) {
                ViewCompat.m2586a(view, new SettleRunnable(view, z));
            } else if (z && SwipeDismissBehavior.this.f831c != null) {
                SwipeDismissBehavior.this.f831c.mo503a(view);
            }
        }

        /* JADX INFO: renamed from: a */
        private boolean m839a(View view, float f) {
            if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
                return Math.abs(view.getLeft() - this.f840b) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f833e);
            }
            boolean z = ViewCompat.m2601e(view) == 1;
            if (SwipeDismissBehavior.this.f832d == 2) {
                return true;
            }
            if (SwipeDismissBehavior.this.f832d == 0) {
                return z ? f < CropImageView.DEFAULT_ASPECT_RATIO : f > CropImageView.DEFAULT_ASPECT_RATIO;
            }
            if (SwipeDismissBehavior.this.f832d == 1) {
                return z ? f > CropImageView.DEFAULT_ASPECT_RATIO : f < CropImageView.DEFAULT_ASPECT_RATIO;
            }
            return false;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: b */
        public int mo840b(View view) {
            return view.getWidth();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: b */
        public int mo549b(View view, int i, int i2) {
            int width;
            int width2;
            boolean z = ViewCompat.m2601e(view) == 1;
            if (SwipeDismissBehavior.this.f832d == 0) {
                if (z) {
                    width = this.f840b - view.getWidth();
                    width2 = this.f840b;
                } else {
                    width = this.f840b;
                    width2 = this.f840b + view.getWidth();
                }
            } else if (SwipeDismissBehavior.this.f832d == 1) {
                if (z) {
                    width = this.f840b;
                    width2 = this.f840b + view.getWidth();
                } else {
                    width = this.f840b - view.getWidth();
                    width2 = this.f840b;
                }
            } else {
                width = this.f840b - view.getWidth();
                width2 = this.f840b + view.getWidth();
            }
            return SwipeDismissBehavior.m832a(width, i, width2);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public int mo544a(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public void mo547a(View view, int i, int i2, int i3, int i4) {
            float width = this.f840b + (view.getWidth() * SwipeDismissBehavior.this.f834f);
            float width2 = this.f840b + (view.getWidth() * SwipeDismissBehavior.this.f835g);
            if (i <= width) {
                view.setAlpha(1.0f);
            } else if (i >= width2) {
                view.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
            } else {
                view.setAlpha(SwipeDismissBehavior.m831a(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f - SwipeDismissBehavior.m834b(width, width2, i), 1.0f));
            }
        }
    };

    public interface OnDismissListener {
        /* JADX INFO: renamed from: a */
        void mo502a(int i);

        /* JADX INFO: renamed from: a */
        void mo503a(View view);
    }

    /* JADX INFO: renamed from: a */
    public void m837a(OnDismissListener onDismissListener) {
        this.f831c = onDismissListener;
    }

    /* JADX INFO: renamed from: a */
    public void m836a(int i) {
        this.f832d = i;
    }

    /* JADX INFO: renamed from: a */
    public void m835a(float f) {
        this.f834f = m831a(CropImageView.DEFAULT_ASPECT_RATIO, f, 1.0f);
    }

    /* JADX INFO: renamed from: b */
    public void m838b(float f) {
        this.f835g = m831a(CropImageView.DEFAULT_ASPECT_RATIO, f, 1.0f);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo510a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f829a;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f829a = coordinatorLayout.m660a(v, (int) motionEvent.getX(), (int) motionEvent.getY());
                z = this.f829a;
                break;
            case 1:
            case 3:
                this.f829a = false;
                break;
        }
        if (!z) {
            return false;
        }
        m833a((ViewGroup) coordinatorLayout);
        return this.f830b.m3152a(motionEvent);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: b */
    public boolean mo539b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f830b == null) {
            return false;
        }
        this.f830b.m3156b(motionEvent);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo511a(View view) {
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m833a(ViewGroup viewGroup) {
        ViewDragHelper viewDragHelperM3130a;
        if (this.f830b == null) {
            if (this.f837i) {
                viewDragHelperM3130a = ViewDragHelper.m3129a(viewGroup, this.f836h, this.f838j);
            } else {
                viewDragHelperM3130a = ViewDragHelper.m3130a(viewGroup, this.f838j);
            }
            this.f830b = viewDragHelperM3130a;
        }
    }

    private class SettleRunnable implements Runnable {

        /* JADX INFO: renamed from: b */
        private final View f843b;

        /* JADX INFO: renamed from: c */
        private final boolean f844c;

        SettleRunnable(View view, boolean z) {
            this.f843b = view;
            this.f844c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwipeDismissBehavior.this.f830b != null && SwipeDismissBehavior.this.f830b.m3154a(true)) {
                ViewCompat.m2586a(this.f843b, this);
            } else if (this.f844c && SwipeDismissBehavior.this.f831c != null) {
                SwipeDismissBehavior.this.f831c.mo503a(this.f843b);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static float m831a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    /* JADX INFO: renamed from: a */
    static int m832a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    /* JADX INFO: renamed from: b */
    static float m834b(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }
}
