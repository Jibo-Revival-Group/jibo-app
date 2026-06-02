package bolts;

import android.content.Intent;
import android.os.Bundle;

public final class AppLinks {
   public static Bundle a(Intent var0) {
      return var0.getBundleExtra("al_applink_data");
   }

   public static Bundle b(Intent var0) {
      Bundle var1 = a(var0);
      Bundle var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = var1.getBundle("extras");
      }

      return var2;
   }
}
