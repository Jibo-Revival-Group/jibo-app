package android.support.v7.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ViewPropertyAnimatorCompatSet {

    /* JADX INFO: renamed from: b */
    ViewPropertyAnimatorListener f3219b;

    /* JADX INFO: renamed from: d */
    private Interpolator f3221d;

    /* JADX INFO: renamed from: e */
    private boolean f3222e;

    /* JADX INFO: renamed from: c */
    private long f3220c = -1;

    /* JADX INFO: renamed from: f */
    private final ViewPropertyAnimatorListenerAdapter f3223f = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.view.ViewPropertyAnimatorCompatSet.1

        /* JADX INFO: renamed from: b */
        private boolean f3225b = false;

        /* JADX INFO: renamed from: c */
        private int f3226c = 0;

        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        /* JADX INFO: renamed from: a */
        public void mo2762a(View view) {
            if (!this.f3225b) {
                this.f3225b = true;
                if (ViewPropertyAnimatorCompatSet.this.f3219b != null) {
                    ViewPropertyAnimatorCompatSet.this.f3219b.mo2762a(null);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m3501a() {
            this.f3226c = 0;
            this.f3225b = false;
            ViewPropertyAnimatorCompatSet.this.m3499b();
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        /* JADX INFO: renamed from: b */
        public void mo2763b(View view) {
            int i = this.f3226c + 1;
            this.f3226c = i;
            if (i == ViewPropertyAnimatorCompatSet.this.f3218a.size()) {
                if (ViewPropertyAnimatorCompatSet.this.f3219b != null) {
                    ViewPropertyAnimatorCompatSet.this.f3219b.mo2763b(null);
                }
                m3501a();
            }
        }
    };

    /* JADX INFO: renamed from: a */
    final ArrayList<ViewPropertyAnimatorCompat> f3218a = new ArrayList<>();

    /* JADX INFO: renamed from: a */
    public ViewPropertyAnimatorCompatSet m3494a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f3222e) {
            this.f3218a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ViewPropertyAnimatorCompatSet m3495a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f3218a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.m2759b(viewPropertyAnimatorCompat.m2752a());
        this.f3218a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m3498a() {
        if (!this.f3222e) {
            for (ViewPropertyAnimatorCompat viewPropertyAnimatorCompat : this.f3218a) {
                if (this.f3220c >= 0) {
                    viewPropertyAnimatorCompat.m2754a(this.f3220c);
                }
                if (this.f3221d != null) {
                    viewPropertyAnimatorCompat.m2757a(this.f3221d);
                }
                if (this.f3219b != null) {
                    viewPropertyAnimatorCompat.m2755a(this.f3223f);
                }
                viewPropertyAnimatorCompat.m2761c();
            }
            this.f3222e = true;
        }
    }

    /* JADX INFO: renamed from: b */
    void m3499b() {
        this.f3222e = false;
    }

    /* JADX INFO: renamed from: c */
    public void m3500c() {
        if (this.f3222e) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f3218a.iterator();
            while (it.hasNext()) {
                it.next().m2760b();
            }
            this.f3222e = false;
        }
    }

    /* JADX INFO: renamed from: a */
    public ViewPropertyAnimatorCompatSet m3493a(long j) {
        if (!this.f3222e) {
            this.f3220c = j;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ViewPropertyAnimatorCompatSet m3497a(Interpolator interpolator) {
        if (!this.f3222e) {
            this.f3221d = interpolator;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ViewPropertyAnimatorCompatSet m3496a(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f3222e) {
            this.f3219b = viewPropertyAnimatorListener;
        }
        return this;
    }
}
