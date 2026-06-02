package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.R;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SnackbarManager;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* JADX INFO: renamed from: a */
    static final Handler f501a;

    /* JADX INFO: renamed from: d */
    private static final boolean f502d;

    /* JADX INFO: renamed from: b */
    final SnackbarBaseLayout f503b;

    /* JADX INFO: renamed from: c */
    final SnackbarManager.Callback f504c = new SnackbarManager.Callback() { // from class: android.support.design.widget.BaseTransientBottomBar.3
        @Override // android.support.design.widget.SnackbarManager.Callback
        /* JADX INFO: renamed from: a */
        public void mo500a() {
            BaseTransientBottomBar.f501a.sendMessage(BaseTransientBottomBar.f501a.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // android.support.design.widget.SnackbarManager.Callback
        /* JADX INFO: renamed from: a */
        public void mo501a(int i) {
            BaseTransientBottomBar.f501a.sendMessage(BaseTransientBottomBar.f501a.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }
    };

    /* JADX INFO: renamed from: e */
    private final ViewGroup f505e;

    /* JADX INFO: renamed from: f */
    private final Context f506f;

    /* JADX INFO: renamed from: g */
    private final ContentViewCallback f507g;

    /* JADX INFO: renamed from: h */
    private int f508h;

    /* JADX INFO: renamed from: i */
    private List<BaseCallback<B>> f509i;

    /* JADX INFO: renamed from: j */
    private final AccessibilityManager f510j;

    public interface ContentViewCallback {
        /* JADX INFO: renamed from: a */
        void mo402a(int i, int i2);

        /* JADX INFO: renamed from: b */
        void mo403b(int i, int i2);
    }

    interface OnAttachStateChangeListener {
        /* JADX INFO: renamed from: a */
        void mo504a(View view);

        /* JADX INFO: renamed from: b */
        void mo505b(View view);
    }

    interface OnLayoutChangeListener {
        /* JADX INFO: renamed from: a */
        void mo506a(View view, int i, int i2, int i3, int i4);
    }

    public static abstract class BaseCallback<B> {
        /* JADX INFO: renamed from: a */
        public void mo508a(B b, int i) {
        }

        /* JADX INFO: renamed from: a */
        public void mo507a(B b) {
        }
    }

    static {
        f502d = Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19;
        f501a = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: android.support.design.widget.BaseTransientBottomBar.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        ((BaseTransientBottomBar) message.obj).m496g();
                        break;
                    case 1:
                        ((BaseTransientBottomBar) message.obj).m491c(message.arg1);
                        break;
                }
                return true;
            }
        });
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (contentViewCallback == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f505e = viewGroup;
        this.f507g = contentViewCallback;
        this.f506f = viewGroup.getContext();
        ThemeUtils.m940a(this.f506f);
        this.f503b = (SnackbarBaseLayout) LayoutInflater.from(this.f506f).inflate(R.layout.design_layout_snackbar, this.f505e, false);
        this.f503b.addView(view);
        ViewCompat.m2593b((View) this.f503b, 1);
        ViewCompat.m2575a((View) this.f503b, 1);
        ViewCompat.m2595b((View) this.f503b, true);
        ViewCompat.m2584a(this.f503b, new OnApplyWindowInsetsListener() { // from class: android.support.design.widget.BaseTransientBottomBar.2
            @Override // android.support.v4.view.OnApplyWindowInsetsListener
            /* JADX INFO: renamed from: a */
            public WindowInsetsCompat mo399a(View view2, WindowInsetsCompat windowInsetsCompat) {
                view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), view2.getPaddingRight(), windowInsetsCompat.m2772d());
                return windowInsetsCompat;
            }
        });
        this.f510j = (AccessibilityManager) this.f506f.getSystemService("accessibility");
    }

    /* JADX INFO: renamed from: a */
    public B m486a(int i) {
        this.f508h = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public Context m485a() {
        return this.f506f;
    }

    /* JADX INFO: renamed from: b */
    public View m488b() {
        return this.f503b;
    }

    /* JADX INFO: renamed from: c */
    public void m490c() {
        SnackbarManager.m810a().m816a(this.f508h, this.f504c);
    }

    /* JADX INFO: renamed from: d */
    public void m492d() {
        m489b(3);
    }

    /* JADX INFO: renamed from: b */
    void m489b(int i) {
        SnackbarManager.m810a().m818a(this.f504c, i);
    }

    /* JADX INFO: renamed from: a */
    public B m487a(BaseCallback<B> baseCallback) {
        if (baseCallback != null) {
            if (this.f509i == null) {
                this.f509i = new ArrayList();
            }
            this.f509i.add(baseCallback);
        }
        return this;
    }

    /* JADX INFO: renamed from: e */
    public boolean m494e() {
        return SnackbarManager.m810a().m823e(this.f504c);
    }

    /* JADX INFO: renamed from: f */
    public boolean m495f() {
        return SnackbarManager.m810a().m824f(this.f504c);
    }

    /* JADX INFO: renamed from: g */
    final void m496g() {
        if (this.f503b.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f503b.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                Behavior behavior = new Behavior();
                behavior.m835a(0.1f);
                behavior.m838b(0.6f);
                behavior.m836a(0);
                behavior.m837a(new SwipeDismissBehavior.OnDismissListener() { // from class: android.support.design.widget.BaseTransientBottomBar.4
                    @Override // android.support.design.widget.SwipeDismissBehavior.OnDismissListener
                    /* JADX INFO: renamed from: a */
                    public void mo503a(View view) {
                        view.setVisibility(8);
                        BaseTransientBottomBar.this.m489b(0);
                    }

                    @Override // android.support.design.widget.SwipeDismissBehavior.OnDismissListener
                    /* JADX INFO: renamed from: a */
                    public void mo502a(int i) {
                        switch (i) {
                            case 0:
                                SnackbarManager.m810a().m822d(BaseTransientBottomBar.this.f504c);
                                break;
                            case 1:
                            case 2:
                                SnackbarManager.m810a().m821c(BaseTransientBottomBar.this.f504c);
                                break;
                        }
                    }
                });
                layoutParams2.m695a(behavior);
                layoutParams2.f701g = 80;
            }
            this.f505e.addView(this.f503b);
        }
        this.f503b.setOnAttachStateChangeListener(new OnAttachStateChangeListener() { // from class: android.support.design.widget.BaseTransientBottomBar.5
            @Override // android.support.design.widget.BaseTransientBottomBar.OnAttachStateChangeListener
            /* JADX INFO: renamed from: a */
            public void mo504a(View view) {
            }

            @Override // android.support.design.widget.BaseTransientBottomBar.OnAttachStateChangeListener
            /* JADX INFO: renamed from: b */
            public void mo505b(View view) {
                if (BaseTransientBottomBar.this.m495f()) {
                    BaseTransientBottomBar.f501a.post(new Runnable() { // from class: android.support.design.widget.BaseTransientBottomBar.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseTransientBottomBar.this.m493d(3);
                        }
                    });
                }
            }
        });
        if (ViewCompat.m2621y(this.f503b)) {
            if (m499j()) {
                m497h();
                return;
            } else {
                m498i();
                return;
            }
        }
        this.f503b.setOnLayoutChangeListener(new OnLayoutChangeListener() { // from class: android.support.design.widget.BaseTransientBottomBar.6
            @Override // android.support.design.widget.BaseTransientBottomBar.OnLayoutChangeListener
            /* JADX INFO: renamed from: a */
            public void mo506a(View view, int i, int i2, int i3, int i4) {
                BaseTransientBottomBar.this.f503b.setOnLayoutChangeListener(null);
                if (BaseTransientBottomBar.this.m499j()) {
                    BaseTransientBottomBar.this.m497h();
                } else {
                    BaseTransientBottomBar.this.m498i();
                }
            }
        });
    }

    /* JADX INFO: renamed from: h */
    void m497h() {
        if (Build.VERSION.SDK_INT >= 12) {
            final int height = this.f503b.getHeight();
            if (f502d) {
                ViewCompat.m2598c(this.f503b, height);
            } else {
                this.f503b.setTranslationY(height);
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(height, 0);
            valueAnimator.setInterpolator(AnimationUtils.f471b);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.BaseTransientBottomBar.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    BaseTransientBottomBar.this.f507g.mo402a(70, 180);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BaseTransientBottomBar.this.m498i();
                }
            });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.BaseTransientBottomBar.8

                /* JADX INFO: renamed from: c */
                private int f526c;

                {
                    this.f526c = height;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    int iIntValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                    if (BaseTransientBottomBar.f502d) {
                        ViewCompat.m2598c(BaseTransientBottomBar.this.f503b, iIntValue - this.f526c);
                    } else {
                        BaseTransientBottomBar.this.f503b.setTranslationY(iIntValue);
                    }
                    this.f526c = iIntValue;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation animationLoadAnimation = android.view.animation.AnimationUtils.loadAnimation(this.f503b.getContext(), R.anim.design_snackbar_in);
        animationLoadAnimation.setInterpolator(AnimationUtils.f471b);
        animationLoadAnimation.setDuration(250L);
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: android.support.design.widget.BaseTransientBottomBar.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BaseTransientBottomBar.this.m498i();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.f503b.startAnimation(animationLoadAnimation);
    }

    /* JADX INFO: renamed from: e */
    private void m483e(final int i) {
        if (Build.VERSION.SDK_INT >= 12) {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(0, this.f503b.getHeight());
            valueAnimator.setInterpolator(AnimationUtils.f471b);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.BaseTransientBottomBar.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    BaseTransientBottomBar.this.f507g.mo403b(0, 180);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BaseTransientBottomBar.this.m493d(i);
                }
            });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.BaseTransientBottomBar.11

                /* JADX INFO: renamed from: b */
                private int f514b = 0;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    int iIntValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                    if (BaseTransientBottomBar.f502d) {
                        ViewCompat.m2598c(BaseTransientBottomBar.this.f503b, iIntValue - this.f514b);
                    } else {
                        BaseTransientBottomBar.this.f503b.setTranslationY(iIntValue);
                    }
                    this.f514b = iIntValue;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation animationLoadAnimation = android.view.animation.AnimationUtils.loadAnimation(this.f503b.getContext(), R.anim.design_snackbar_out);
        animationLoadAnimation.setInterpolator(AnimationUtils.f471b);
        animationLoadAnimation.setDuration(250L);
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: android.support.design.widget.BaseTransientBottomBar.12
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BaseTransientBottomBar.this.m493d(i);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.f503b.startAnimation(animationLoadAnimation);
    }

    /* JADX INFO: renamed from: c */
    final void m491c(int i) {
        if (m499j() && this.f503b.getVisibility() == 0) {
            m483e(i);
        } else {
            m493d(i);
        }
    }

    /* JADX INFO: renamed from: i */
    void m498i() {
        SnackbarManager.m810a().m820b(this.f504c);
        if (this.f509i != null) {
            for (int size = this.f509i.size() - 1; size >= 0; size--) {
                this.f509i.get(size).mo507a(this);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    void m493d(int i) {
        SnackbarManager.m810a().m817a(this.f504c);
        if (this.f509i != null) {
            for (int size = this.f509i.size() - 1; size >= 0; size--) {
                this.f509i.get(size).mo508a(this, i);
            }
        }
        if (Build.VERSION.SDK_INT < 11) {
            this.f503b.setVisibility(8);
        }
        ViewParent parent = this.f503b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f503b);
        }
    }

    /* JADX INFO: renamed from: j */
    boolean m499j() {
        return !this.f510j.isEnabled();
    }

    static class SnackbarBaseLayout extends FrameLayout {

        /* JADX INFO: renamed from: a */
        private OnLayoutChangeListener f529a;

        /* JADX INFO: renamed from: b */
        private OnAttachStateChangeListener f530b;

        SnackbarBaseLayout(Context context) {
            this(context, null);
        }

        SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                ViewCompat.m2574a(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
            setClickable(true);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f529a != null) {
                this.f529a.mo506a(this, i, i2, i3, i4);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f530b != null) {
                this.f530b.mo504a(this);
            }
            ViewCompat.m2613q(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f530b != null) {
                this.f530b.mo505b(this);
            }
        }

        void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            this.f529a = onLayoutChangeListener;
        }

        void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
            this.f530b = onAttachStateChangeListener;
        }
    }

    final class Behavior extends SwipeDismissBehavior<SnackbarBaseLayout> {
        Behavior() {
        }

        @Override // android.support.design.widget.SwipeDismissBehavior
        /* JADX INFO: renamed from: a */
        public boolean mo511a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        @Override // android.support.design.widget.SwipeDismissBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo510a(CoordinatorLayout coordinatorLayout, SnackbarBaseLayout snackbarBaseLayout, MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (coordinatorLayout.m660a(snackbarBaseLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                        SnackbarManager.m810a().m821c(BaseTransientBottomBar.this.f504c);
                    }
                    break;
                case 1:
                case 3:
                    SnackbarManager.m810a().m822d(BaseTransientBottomBar.this.f504c);
                    break;
            }
            return super.mo510a(coordinatorLayout, snackbarBaseLayout, motionEvent);
        }
    }
}
