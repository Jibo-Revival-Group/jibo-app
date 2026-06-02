package android.support.customtabs;

import android.os.IBinder;

public class CustomTabsSessionToken {
   private final ICustomTabsCallback a;
   private final CustomTabsCallback b;

   CustomTabsSessionToken(ICustomTabsCallback var1) {
      this.a = var1;
      this.b = new CustomTabsCallback(this) {
         final CustomTabsSessionToken a;

         {
            this.a = var1;
         }
      };
   }

   IBinder a() {
      return this.a.asBinder();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (!(var1 instanceof CustomTabsSessionToken)) {
         var2 = false;
      } else {
         var2 = ((CustomTabsSessionToken)var1).a().equals(this.a.asBinder());
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.a().hashCode();
   }
}
