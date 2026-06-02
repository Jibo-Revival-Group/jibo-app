package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat {
   private final Object a;

   public AccessibilityNodeProviderCompat() {
      if (VERSION.SDK_INT >= 19) {
         this.a = new AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi19(this);
      } else if (VERSION.SDK_INT >= 16) {
         this.a = new AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi16(this);
      } else {
         this.a = null;
      }
   }

   public AccessibilityNodeProviderCompat(Object var1) {
      this.a = var1;
   }

   public AccessibilityNodeInfoCompat a(int var1) {
      return null;
   }

   public Object a() {
      return this.a;
   }

   public List<AccessibilityNodeInfoCompat> a(String var1, int var2) {
      return null;
   }

   public boolean a(int var1, int var2, Bundle var3) {
      return false;
   }

   public AccessibilityNodeInfoCompat b(int var1) {
      return null;
   }

   static class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {
      final AccessibilityNodeProviderCompat a;

      AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat var1) {
         this.a = var1;
      }

      public AccessibilityNodeInfo createAccessibilityNodeInfo(int var1) {
         AccessibilityNodeInfoCompat var2 = this.a.a(var1);
         AccessibilityNodeInfo var3;
         if (var2 == null) {
            var3 = null;
         } else {
            var3 = var2.a();
         }

         return var3;
      }

      public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String var1, int var2) {
         List var4 = this.a.a(var1, var2);
         ArrayList var5;
         if (var4 == null) {
            var5 = null;
         } else {
            var5 = new ArrayList();
            int var3 = var4.size();

            for (int var6 = 0; var6 < var3; var6++) {
               var5.add(((AccessibilityNodeInfoCompat)var4.get(var6)).a());
            }
         }

         return var5;
      }

      public boolean performAction(int var1, int var2, Bundle var3) {
         return this.a.a(var1, var2, var3);
      }
   }

   static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi16 {
      AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat var1) {
         super(var1);
      }

      public AccessibilityNodeInfo findFocus(int var1) {
         AccessibilityNodeInfoCompat var2 = this.a.b(var1);
         AccessibilityNodeInfo var3;
         if (var2 == null) {
            var3 = null;
         } else {
            var3 = var2.a();
         }

         return var3;
      }
   }
}
