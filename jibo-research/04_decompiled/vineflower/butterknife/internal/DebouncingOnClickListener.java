package butterknife.internal;

import android.view.View;
import android.view.View.OnClickListener;

public abstract class DebouncingOnClickListener implements OnClickListener {
   static boolean a = true;
   private static final Runnable b = new Runnable() {
      @Override
      public void run() {
         DebouncingOnClickListener.a = true;
      }
   };

   public abstract void a(View var1);

   public final void onClick(View var1) {
      if (a) {
         a = false;
         var1.post(b);
         this.a(var1);
      }
   }
}
