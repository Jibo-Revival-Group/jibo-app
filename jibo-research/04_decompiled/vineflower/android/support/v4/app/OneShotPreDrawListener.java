package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;

class OneShotPreDrawListener implements OnAttachStateChangeListener, OnPreDrawListener {
   private final View a;
   private ViewTreeObserver b;
   private final Runnable c;

   private OneShotPreDrawListener(View var1, Runnable var2) {
      this.a = var1;
      this.b = var1.getViewTreeObserver();
      this.c = var2;
   }

   public static OneShotPreDrawListener a(View var0, Runnable var1) {
      OneShotPreDrawListener var2 = new OneShotPreDrawListener(var0, var1);
      var0.getViewTreeObserver().addOnPreDrawListener(var2);
      var0.addOnAttachStateChangeListener(var2);
      return var2;
   }

   public void a() {
      if (this.b.isAlive()) {
         this.b.removeOnPreDrawListener(this);
      } else {
         this.a.getViewTreeObserver().removeOnPreDrawListener(this);
      }

      this.a.removeOnAttachStateChangeListener(this);
   }

   public boolean onPreDraw() {
      this.a();
      this.c.run();
      return true;
   }

   public void onViewAttachedToWindow(View var1) {
      this.b = var1.getViewTreeObserver();
   }

   public void onViewDetachedFromWindow(View var1) {
      this.a();
   }
}
