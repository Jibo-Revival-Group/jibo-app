package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.accessibility.AccessibilityManager;

class TooltipCompatHandler implements OnAttachStateChangeListener, OnHoverListener, OnLongClickListener {
   private static TooltipCompatHandler i;
   private static TooltipCompatHandler j;
   private final View a;
   private final CharSequence b;
   private final Runnable c = new Runnable(this) {
      final TooltipCompatHandler a;

      {
         this.a = var1;
      }

      @Override
      public void run() {
         this.a.a(false);
      }
   };
   private final Runnable d = new Runnable(this) {
      final TooltipCompatHandler a;

      {
         this.a = var1;
      }

      @Override
      public void run() {
         this.a.a();
      }
   };
   private int e;
   private int f;
   private TooltipPopup g;
   private boolean h;

   private TooltipCompatHandler(View var1, CharSequence var2) {
      this.a = var1;
      this.b = var2;
      this.a.setOnLongClickListener(this);
      this.a.setOnHoverListener(this);
   }

   private void a() {
      if (j == this) {
         j = null;
         if (this.g != null) {
            this.g.a();
            this.g = null;
            this.a.removeOnAttachStateChangeListener(this);
         } else {
            Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
         }
      }

      if (i == this) {
         b(null);
      }

      this.a.removeCallbacks(this.d);
   }

   public static void a(View var0, CharSequence var1) {
      if (i != null && i.a == var0) {
         b(null);
      }

      if (TextUtils.isEmpty(var1)) {
         if (j != null && j.a == var0) {
            j.a();
         }

         var0.setOnLongClickListener(null);
         var0.setLongClickable(false);
         var0.setOnHoverListener(null);
      } else {
         new TooltipCompatHandler(var0, var1);
      }
   }

   private void a(boolean var1) {
      if (ViewCompat.B(this.a)) {
         b(null);
         if (j != null) {
            j.a();
         }

         j = this;
         this.h = var1;
         this.g = new TooltipPopup(this.a.getContext());
         this.g.a(this.a, this.e, this.f, this.h, this.b);
         this.a.addOnAttachStateChangeListener(this);
         long var2;
         if (this.h) {
            var2 = 2500L;
         } else if ((ViewCompat.p(this.a) & 1) == 1) {
            var2 = 3000L - ViewConfiguration.getLongPressTimeout();
         } else {
            var2 = 15000L - ViewConfiguration.getLongPressTimeout();
         }

         this.a.removeCallbacks(this.d);
         this.a.postDelayed(this.d, var2);
      }
   }

   private void b() {
      this.a.postDelayed(this.c, ViewConfiguration.getLongPressTimeout());
   }

   private static void b(TooltipCompatHandler var0) {
      if (i != null) {
         i.c();
      }

      i = var0;
      if (i != null) {
         i.b();
      }
   }

   private void c() {
      this.a.removeCallbacks(this.c);
   }

   public boolean onHover(View var1, MotionEvent var2) {
      if (this.g == null || !this.h) {
         AccessibilityManager var3 = (AccessibilityManager)this.a.getContext().getSystemService("accessibility");
         if (!var3.isEnabled() || !var3.isTouchExplorationEnabled()) {
            switch (var2.getAction()) {
               case 7:
                  if (this.a.isEnabled() && this.g == null) {
                     this.e = (int)var2.getX();
                     this.f = (int)var2.getY();
                     b(this);
                  }
               case 8:
               case 9:
               default:
                  break;
               case 10:
                  this.a();
            }
         }
      }

      return false;
   }

   public boolean onLongClick(View var1) {
      this.e = var1.getWidth() / 2;
      this.f = var1.getHeight() / 2;
      this.a(true);
      return true;
   }

   public void onViewAttachedToWindow(View var1) {
   }

   public void onViewDetachedFromWindow(View var1) {
      this.a();
   }
}
