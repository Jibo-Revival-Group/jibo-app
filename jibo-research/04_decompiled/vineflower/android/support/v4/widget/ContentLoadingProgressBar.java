package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
   long a = -1L;
   boolean b = false;
   boolean c = false;
   boolean d = false;
   private final Runnable e = new Runnable(this) {
      final ContentLoadingProgressBar a;

      {
         this.a = var1;
      }

      @Override
      public void run() {
         this.a.b = false;
         this.a.a = -1L;
         this.a.setVisibility(8);
      }
   };
   private final Runnable f = new Runnable(this) {
      final ContentLoadingProgressBar a;

      {
         this.a = var1;
      }

      @Override
      public void run() {
         this.a.c = false;
         if (!this.a.d) {
            this.a.a = System.currentTimeMillis();
            this.a.setVisibility(0);
         }
      }
   };

   public ContentLoadingProgressBar(Context var1, AttributeSet var2) {
      super(var1, var2, 0);
   }

   private void a() {
      this.removeCallbacks(this.e);
      this.removeCallbacks(this.f);
   }

   public void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.a();
   }

   public void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.a();
   }
}
