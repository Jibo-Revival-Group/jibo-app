package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityRecord;

public class AccessibilityRecordCompat {
   private final AccessibilityRecord a;

   public static void a(AccessibilityRecord var0, int var1) {
      if (VERSION.SDK_INT >= 15) {
         var0.setMaxScrollX(var1);
      }
   }

   public static void b(AccessibilityRecord var0, int var1) {
      if (VERSION.SDK_INT >= 15) {
         var0.setMaxScrollY(var1);
      }
   }

   @Deprecated
   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 == null) {
            var2 = false;
         } else if (this.getClass() != var1.getClass()) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.a == null) {
               if (var1.a != null) {
                  var2 = false;
               }
            } else if (!this.a.equals(var1.a)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Deprecated
   @Override
   public int hashCode() {
      int var1;
      if (this.a == null) {
         var1 = 0;
      } else {
         var1 = this.a.hashCode();
      }

      return var1;
   }
}
