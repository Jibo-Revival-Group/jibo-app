package android.support.transition;

import android.os.IBinder;

class WindowIdApi14 implements WindowIdImpl {
   private final IBinder a;

   WindowIdApi14(IBinder var1) {
      this.a = var1;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof WindowIdApi14 && ((WindowIdApi14)var1).a.equals(this.a)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.a.hashCode();
   }
}
