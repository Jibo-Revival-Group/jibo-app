package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {

    /* JADX INFO: renamed from: a */
    Runnable f2432a = null;

    /* JADX INFO: renamed from: b */
    Runnable f2433b = null;

    /* JADX INFO: renamed from: c */
    int f2434c = -1;

    /* JADX INFO: renamed from: d */
    private WeakReference<View> f2435d;

    ViewPropertyAnimatorCompat(View view) {
        this.f2435d = new WeakReference<>(view);
    }

    static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {

        /* JADX INFO: renamed from: a */
        ViewPropertyAnimatorCompat f2442a;

        /* JADX INFO: renamed from: b */
        boolean f2443b;

        ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.f2442a = viewPropertyAnimatorCompat;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        /* JADX INFO: renamed from: a */
        public void mo2762a(View view) {
            this.f2443b = false;
            if (this.f2442a.f2434c > -1) {
                view.setLayerType(2, null);
            }
            if (this.f2442a.f2432a != null) {
                Runnable runnable = this.f2442a.f2432a;
                this.f2442a.f2432a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.mo2762a(view);
            }
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        /* JADX INFO: renamed from: b */
        public void mo2763b(View view) {
            if (this.f2442a.f2434c > -1) {
                view.setLayerType(this.f2442a.f2434c, null);
                this.f2442a.f2434c = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f2443b) {
                if (this.f2442a.f2433b != null) {
                    Runnable runnable = this.f2442a.f2433b;
                    this.f2442a.f2433b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.mo2763b(view);
                }
                this.f2443b = true;
            }
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        /* JADX INFO: renamed from: c */
        public void mo2764c(View view) {
            ViewPropertyAnimatorListener viewPropertyAnimatorListener;
            Object tag = view.getTag(2113929216);
            if (!(tag instanceof ViewPropertyAnimatorListener)) {
                viewPropertyAnimatorListener = null;
            } else {
                viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.mo2764c(view);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public ViewPropertyAnimatorCompat m2754a(long j) {
        View view = this.f2435d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ViewPropertyAnimatorCompat m2753a(float f) {
        View view = this.f2435d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public ViewPropertyAnimatorCompat m2758b(float f) {
        View view = this.f2435d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public long m2752a() {
        View view = this.f2435d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    /* JADX INFO: renamed from: a */
    public ViewPropertyAnimatorCompat m2757a(Interpolator interpolator) {
        View view = this.f2435d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public ViewPropertyAnimatorCompat m2759b(long j) {
        View view = this.f2435d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public void m2760b() {
        View view = this.f2435d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m2761c() {
        View view = this.f2435d.get();
        if (view != null) {
            view.animate().start();
        }
    }

    /* JADX INFO: renamed from: a */
    public ViewPropertyAnimatorCompat m2755a(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.f2435d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                m2751a(view, viewPropertyAnimatorListener);
            } else {
                view.setTag(2113929216, viewPropertyAnimatorListener);
                m2751a(view, new ViewPropertyAnimatorListenerApi14(this));
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    private void m2751a(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: android.support.v4.view.ViewPropertyAnimatorCompat.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.mo2764c(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.mo2763b(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.mo2762a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    /* JADX INFO: renamed from: a */
    public ViewPropertyAnimatorCompat m2756a(final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        final View view = this.f2435d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
            if (viewPropertyAnimatorUpdateListener != null) {
                animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.v4.view.ViewPropertyAnimatorCompat.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        viewPropertyAnimatorUpdateListener.mo2765a(view);
                    }
                };
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }
}
