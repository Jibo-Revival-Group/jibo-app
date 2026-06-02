package com.bumptech.glide.request.target;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.request.Request;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {

    /* JADX INFO: renamed from: b */
    private static boolean f4986b = false;

    /* JADX INFO: renamed from: c */
    private static Integer f4987c = null;

    /* JADX INFO: renamed from: a */
    protected final T f4988a;

    /* JADX INFO: renamed from: d */
    private final SizeDeterminer f4989d;

    public ViewTarget(T t) {
        if (t == null) {
            throw new NullPointerException("View must not be null!");
        }
        this.f4988a = t;
        this.f4989d = new SizeDeterminer(t);
    }

    /* JADX INFO: renamed from: a */
    public T m5558a() {
        return this.f4988a;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback sizeReadyCallback) {
        this.f4989d.m5567a(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void setRequest(Request request) {
        m5556a(request);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public Request getRequest() {
        Object objM5557c = m5557c();
        if (objM5557c == null) {
            return null;
        }
        if (objM5557c instanceof Request) {
            return (Request) objM5557c;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    /* JADX INFO: renamed from: a */
    private void m5556a(Object obj) {
        if (f4987c == null) {
            f4986b = true;
            this.f4988a.setTag(obj);
        } else {
            this.f4988a.setTag(f4987c.intValue(), obj);
        }
    }

    /* JADX INFO: renamed from: c */
    private Object m5557c() {
        return f4987c == null ? this.f4988a.getTag() : this.f4988a.getTag(f4987c.intValue());
    }

    public String toString() {
        return "Target for: " + this.f4988a;
    }

    private static class SizeDeterminer {

        /* JADX INFO: renamed from: a */
        private final View f4990a;

        /* JADX INFO: renamed from: b */
        private final List<SizeReadyCallback> f4991b = new ArrayList();

        /* JADX INFO: renamed from: c */
        private SizeDeterminerLayoutListener f4992c;

        /* JADX INFO: renamed from: d */
        private Point f4993d;

        public SizeDeterminer(View view) {
            this.f4990a = view;
        }

        /* JADX INFO: renamed from: a */
        private void m5561a(int i, int i2) {
            Iterator<SizeReadyCallback> it = this.f4991b.iterator();
            while (it.hasNext()) {
                it.next().mo5518a(i, i2);
            }
            this.f4991b.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m5560a() {
            if (!this.f4991b.isEmpty()) {
                int iM5565c = m5565c();
                int iM5564b = m5564b();
                if (m5563a(iM5565c) && m5563a(iM5564b)) {
                    m5561a(iM5565c, iM5564b);
                    ViewTreeObserver viewTreeObserver = this.f4990a.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(this.f4992c);
                    }
                    this.f4992c = null;
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public void m5567a(SizeReadyCallback sizeReadyCallback) {
            int iM5565c = m5565c();
            int iM5564b = m5564b();
            if (m5563a(iM5565c) && m5563a(iM5564b)) {
                sizeReadyCallback.mo5518a(iM5565c, iM5564b);
                return;
            }
            if (!this.f4991b.contains(sizeReadyCallback)) {
                this.f4991b.add(sizeReadyCallback);
            }
            if (this.f4992c == null) {
                ViewTreeObserver viewTreeObserver = this.f4990a.getViewTreeObserver();
                this.f4992c = new SizeDeterminerLayoutListener(this);
                viewTreeObserver.addOnPreDrawListener(this.f4992c);
            }
        }

        /* JADX INFO: renamed from: b */
        private int m5564b() {
            ViewGroup.LayoutParams layoutParams = this.f4990a.getLayoutParams();
            if (m5563a(this.f4990a.getHeight())) {
                return this.f4990a.getHeight();
            }
            if (layoutParams != null) {
                return m5559a(layoutParams.height, true);
            }
            return 0;
        }

        /* JADX INFO: renamed from: c */
        private int m5565c() {
            ViewGroup.LayoutParams layoutParams = this.f4990a.getLayoutParams();
            if (m5563a(this.f4990a.getWidth())) {
                return this.f4990a.getWidth();
            }
            if (layoutParams != null) {
                return m5559a(layoutParams.width, false);
            }
            return 0;
        }

        /* JADX INFO: renamed from: a */
        private int m5559a(int i, boolean z) {
            if (i != -2) {
                return i;
            }
            Point pointM5566d = m5566d();
            return z ? pointM5566d.y : pointM5566d.x;
        }

        @TargetApi(13)
        /* JADX INFO: renamed from: d */
        private Point m5566d() {
            if (this.f4993d != null) {
                return this.f4993d;
            }
            Display defaultDisplay = ((WindowManager) this.f4990a.getContext().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                this.f4993d = new Point();
                defaultDisplay.getSize(this.f4993d);
            } else {
                this.f4993d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
            }
            return this.f4993d;
        }

        /* JADX INFO: renamed from: a */
        private boolean m5563a(int i) {
            return i > 0 || i == -2;
        }

        private static class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a */
            private final WeakReference<SizeDeterminer> f4994a;

            public SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.f4994a = new WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
                }
                SizeDeterminer sizeDeterminer = this.f4994a.get();
                if (sizeDeterminer != null) {
                    sizeDeterminer.m5560a();
                    return true;
                }
                return true;
            }
        }
    }
}
