package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.support.design.R;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
   static final Handler a;
   private static final boolean d;
   final BaseTransientBottomBar.SnackbarBaseLayout b;
   final SnackbarManager.Callback c = new SnackbarManager.Callback(this) {
      final BaseTransientBottomBar a;

      {
         this.a = var1;
      }

      @Override
      public void a() {
         BaseTransientBottomBar.a.sendMessage(BaseTransientBottomBar.a.obtainMessage(0, this.a));
      }

      @Override
      public void a(int var1) {
         BaseTransientBottomBar.a.sendMessage(BaseTransientBottomBar.a.obtainMessage(1, var1, 0, this.a));
      }
   };
   private final ViewGroup e;
   private final Context f;
   private final BaseTransientBottomBar.ContentViewCallback g;
   private int h;
   private List<BaseTransientBottomBar.BaseCallback<B>> i;
   private final AccessibilityManager j;

   static {
      boolean var0;
      if (VERSION.SDK_INT >= 16 && VERSION.SDK_INT <= 19) {
         var0 = true;
      } else {
         var0 = false;
      }

      d = var0;
      a = new Handler(Looper.getMainLooper(), new Callback() {
         public boolean handleMessage(Message var1) {
            boolean var2;
            switch (var1.what) {
               case 0:
                  ((BaseTransientBottomBar)var1.obj).g();
                  var2 = true;
                  break;
               case 1:
                  ((BaseTransientBottomBar)var1.obj).c(var1.arg1);
                  var2 = true;
                  break;
               default:
                  var2 = false;
            }

            return var2;
         }
      });
   }

   protected BaseTransientBottomBar(ViewGroup var1, View var2, BaseTransientBottomBar.ContentViewCallback var3) {
      if (var1 == null) {
         throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
      }

      if (var2 == null) {
         throw new IllegalArgumentException("Transient bottom bar must have non-null content");
      }

      if (var3 == null) {
         throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
      }

      this.e = var1;
      this.g = var3;
      this.f = var1.getContext();
      ThemeUtils.a(this.f);
      this.b = (BaseTransientBottomBar.SnackbarBaseLayout)LayoutInflater.from(this.f).inflate(R.layout.design_layout_snackbar, this.e, false);
      this.b.addView(var2);
      ViewCompat.b(this.b, 1);
      ViewCompat.a(this.b, 1);
      ViewCompat.b(this.b, true);
      ViewCompat.a(this.b, new OnApplyWindowInsetsListener(this) {
         final BaseTransientBottomBar a;

         {
            this.a = var1;
         }

         @Override
         public WindowInsetsCompat a(View var1, WindowInsetsCompat var2x) {
            var1.setPadding(var1.getPaddingLeft(), var1.getPaddingTop(), var1.getPaddingRight(), var2x.d());
            return var2x;
         }
      });
      this.j = (AccessibilityManager)this.f.getSystemService("accessibility");
   }

   private void e(int var1) {
      if (VERSION.SDK_INT >= 12) {
         ValueAnimator var2 = new ValueAnimator();
         var2.setIntValues(new int[]{0, this.b.getHeight()});
         var2.setInterpolator(AnimationUtils.b);
         var2.setDuration(250L);
         var2.addListener(new AnimatorListenerAdapter(this, var1) {
            final int a;
            final BaseTransientBottomBar b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public void onAnimationEnd(Animator var1) {
               this.b.d(this.a);
            }

            public void onAnimationStart(Animator var1) {
               this.b.g.b(0, 180);
            }
         });
         var2.addUpdateListener(new AnimatorUpdateListener(this) {
            final BaseTransientBottomBar a;
            private int b;

            {
               this.a = var1;
               this.b = 0;
            }

            public void onAnimationUpdate(ValueAnimator var1) {
               int var2x = (Integer)var1.getAnimatedValue();
               if (BaseTransientBottomBar.d) {
                  ViewCompat.c(this.a.b, var2x - this.b);
               } else {
                  this.a.b.setTranslationY(var2x);
               }

               this.b = var2x;
            }
         });
         var2.start();
      } else {
         Animation var3 = android.view.animation.AnimationUtils.loadAnimation(this.b.getContext(), R.anim.design_snackbar_out);
         var3.setInterpolator(AnimationUtils.b);
         var3.setDuration(250L);
         var3.setAnimationListener(new AnimationListener(this, var1) {
            final int a;
            final BaseTransientBottomBar b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void onAnimationEnd(Animation var1) {
               this.b.d(this.a);
            }

            public void onAnimationRepeat(Animation var1) {
            }

            public void onAnimationStart(Animation var1) {
            }
         });
         this.b.startAnimation(var3);
      }
   }

   public Context a() {
      return this.f;
   }

   public B a(int var1) {
      this.h = var1;
      return (B)this;
   }

   public B a(BaseTransientBottomBar.BaseCallback<B> var1) {
      if (var1 != null) {
         if (this.i == null) {
            this.i = new ArrayList<>();
         }

         this.i.add(var1);
      }

      return (B)this;
   }

   public View b() {
      return this.b;
   }

   void b(int var1) {
      SnackbarManager.a().a(this.c, var1);
   }

   public void c() {
      SnackbarManager.a().a(this.h, this.c);
   }

   final void c(int var1) {
      if (this.j() && this.b.getVisibility() == 0) {
         this.e(var1);
      } else {
         this.d(var1);
      }
   }

   public void d() {
      this.b(3);
   }

   void d(int var1) {
      SnackbarManager.a().a(this.c);
      if (this.i != null) {
         for (int var2 = this.i.size() - 1; var2 >= 0; var2--) {
            this.i.get(var2).a((B)this, var1);
         }
      }

      if (VERSION.SDK_INT < 11) {
         this.b.setVisibility(8);
      }

      ViewParent var3 = this.b.getParent();
      if (var3 instanceof ViewGroup) {
         ((ViewGroup)var3).removeView(this.b);
      }
   }

   public boolean e() {
      return SnackbarManager.a().e(this.c);
   }

   public boolean f() {
      return SnackbarManager.a().f(this.c);
   }

   final void g() {
      if (this.b.getParent() == null) {
         LayoutParams var1 = this.b.getLayoutParams();
         if (var1 instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.LayoutParams var3 = (CoordinatorLayout.LayoutParams)var1;
            BaseTransientBottomBar.Behavior var2 = new BaseTransientBottomBar.Behavior(this);
            var2.a(0.1F);
            var2.b(0.6F);
            var2.a(0);
            var2.a(new SwipeDismissBehavior.OnDismissListener(this) {
               final BaseTransientBottomBar a;

               {
                  this.a = var1;
               }

               @Override
               public void a(int var1) {
                  switch (var1) {
                     case 0:
                        SnackbarManager.a().d(this.a.c);
                        break;
                     case 1:
                     case 2:
                        SnackbarManager.a().c(this.a.c);
                  }
               }

               @Override
               public void a(View var1) {
                  var1.setVisibility(8);
                  this.a.b(0);
               }
            });
            var3.a(var2);
            var3.g = 80;
         }

         this.e.addView(this.b);
      }

      this.b.setOnAttachStateChangeListener(new BaseTransientBottomBar.OnAttachStateChangeListener(this) {
         final BaseTransientBottomBar a;

         {
            this.a = var1;
         }

         @Override
         public void a(View var1) {
         }

         @Override
         public void b(View var1) {
            if (this.a.f()) {
               BaseTransientBottomBar.a.post(new Runnable(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     this.a.a.d(3);
                  }
               });
            }
         }
      });
      if (ViewCompat.y(this.b)) {
         if (this.j()) {
            this.h();
         } else {
            this.i();
         }
      } else {
         this.b.setOnLayoutChangeListener(new BaseTransientBottomBar.OnLayoutChangeListener(this) {
            final BaseTransientBottomBar a;

            {
               this.a = var1;
            }

            @Override
            public void a(View var1, int var2, int var3, int var4, int var5) {
               this.a.b.setOnLayoutChangeListener(null);
               if (this.a.j()) {
                  this.a.h();
               } else {
                  this.a.i();
               }
            }
         });
      }
   }

   void h() {
      if (VERSION.SDK_INT >= 12) {
         int var1 = this.b.getHeight();
         if (d) {
            ViewCompat.c(this.b, var1);
         } else {
            this.b.setTranslationY(var1);
         }

         ValueAnimator var2 = new ValueAnimator();
         var2.setIntValues(new int[]{var1, 0});
         var2.setInterpolator(AnimationUtils.b);
         var2.setDuration(250L);
         var2.addListener(new AnimatorListenerAdapter(this) {
            final BaseTransientBottomBar a;

            {
               this.a = var1;
            }

            public void onAnimationEnd(Animator var1) {
               this.a.i();
            }

            public void onAnimationStart(Animator var1) {
               this.a.g.a(70, 180);
            }
         });
         var2.addUpdateListener(new AnimatorUpdateListener(this, var1) {
            final int a;
            final BaseTransientBottomBar b;
            private int c;

            {
               this.b = var1;
               this.a = var2x;
               this.c = this.a;
            }

            public void onAnimationUpdate(ValueAnimator var1) {
               int var2x = (Integer)var1.getAnimatedValue();
               if (BaseTransientBottomBar.d) {
                  ViewCompat.c(this.b.b, var2x - this.c);
               } else {
                  this.b.b.setTranslationY(var2x);
               }

               this.c = var2x;
            }
         });
         var2.start();
      } else {
         Animation var3 = android.view.animation.AnimationUtils.loadAnimation(this.b.getContext(), R.anim.design_snackbar_in);
         var3.setInterpolator(AnimationUtils.b);
         var3.setDuration(250L);
         var3.setAnimationListener(new AnimationListener(this) {
            final BaseTransientBottomBar a;

            {
               this.a = var1;
            }

            public void onAnimationEnd(Animation var1) {
               this.a.i();
            }

            public void onAnimationRepeat(Animation var1) {
            }

            public void onAnimationStart(Animation var1) {
            }
         });
         this.b.startAnimation(var3);
      }
   }

   void i() {
      SnackbarManager.a().b(this.c);
      if (this.i != null) {
         for (int var1 = this.i.size() - 1; var1 >= 0; var1--) {
            this.i.get(var1).a((B)this);
         }
      }
   }

   boolean j() {
      boolean var1;
      if (!this.j.isEnabled()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public abstract static class BaseCallback<B> {
      public void a(B var1) {
      }

      public void a(B var1, int var2) {
      }
   }

   final class Behavior extends SwipeDismissBehavior<BaseTransientBottomBar.SnackbarBaseLayout> {
      final BaseTransientBottomBar a;

      Behavior(BaseTransientBottomBar var1) {
         this.a = var1;
      }

      public boolean a(CoordinatorLayout var1, BaseTransientBottomBar.SnackbarBaseLayout var2, MotionEvent var3) {
         switch (var3.getActionMasked()) {
            case 0:
               if (var1.a(var2, (int)var3.getX(), (int)var3.getY())) {
                  SnackbarManager.a().c(this.a.c);
               }
               break;
            case 1:
            case 3:
               SnackbarManager.a().d(this.a.c);
            case 2:
         }

         return super.a(var1, var2, var3);
      }

      @Override
      public boolean a(View var1) {
         return var1 instanceof BaseTransientBottomBar.SnackbarBaseLayout;
      }
   }

   public interface ContentViewCallback {
      void a(int var1, int var2);

      void b(int var1, int var2);
   }

   interface OnAttachStateChangeListener {
      void a(View var1);

      void b(View var1);
   }

   interface OnLayoutChangeListener {
      void a(View var1, int var2, int var3, int var4, int var5);
   }

   static class SnackbarBaseLayout extends FrameLayout {
      private BaseTransientBottomBar.OnLayoutChangeListener a;
      private BaseTransientBottomBar.OnAttachStateChangeListener b;

      SnackbarBaseLayout(Context var1) {
         this(var1, null);
      }

      SnackbarBaseLayout(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.SnackbarLayout);
         if (var3.hasValue(R.styleable.SnackbarLayout_elevation)) {
            ViewCompat.a(this, var3.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
         }

         var3.recycle();
         this.setClickable(true);
      }

      protected void onAttachedToWindow() {
         super.onAttachedToWindow();
         if (this.b != null) {
            this.b.a(this);
         }

         ViewCompat.q(this);
      }

      protected void onDetachedFromWindow() {
         super.onDetachedFromWindow();
         if (this.b != null) {
            this.b.b(this);
         }
      }

      protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
         super.onLayout(var1, var2, var3, var4, var5);
         if (this.a != null) {
            this.a.a(this, var2, var3, var4, var5);
         }
      }

      void setOnAttachStateChangeListener(BaseTransientBottomBar.OnAttachStateChangeListener var1) {
         this.b = var1;
      }

      void setOnLayoutChangeListener(BaseTransientBottomBar.OnLayoutChangeListener var1) {
         this.a = var1;
      }
   }
}
