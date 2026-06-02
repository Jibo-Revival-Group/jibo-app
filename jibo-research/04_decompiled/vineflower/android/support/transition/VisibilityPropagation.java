package android.support.transition;

import android.view.View;

public abstract class VisibilityPropagation extends TransitionPropagation {
   private static final String[] a = new String[]{"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

   private static int a(TransitionValues var0, int var1) {
      if (var0 == null) {
         var1 = -1;
      } else {
         int[] var2 = (int[])var0.a.get("android:visibilityPropagation:center");
         if (var2 == null) {
            var1 = -1;
         } else {
            var1 = var2[var1];
         }
      }

      return var1;
   }

   @Override
   public void a(TransitionValues var1) {
      View var5 = var1.b;
      Integer var4 = (Integer)var1.a.get("android:visibility:visibility");
      Integer var3 = var4;
      if (var4 == null) {
         var3 = var5.getVisibility();
      }

      var1.a.put("android:visibilityPropagation:visibility", var3);
      int[] var6 = new int[2];
      var5.getLocationOnScreen(var6);
      var6[0] += Math.round(var5.getTranslationX());
      var6[0] += var5.getWidth() / 2;
      var6[1] += Math.round(var5.getTranslationY());
      int var2 = var6[1];
      var6[1] = var5.getHeight() / 2 + var2;
      var1.a.put("android:visibilityPropagation:center", var6);
   }

   @Override
   public String[] a() {
      return a;
   }

   public int b(TransitionValues var1) {
      int var2;
      if (var1 == null) {
         var2 = 8;
      } else {
         Integer var3 = (Integer)var1.a.get("android:visibilityPropagation:visibility");
         if (var3 == null) {
            var2 = 8;
         } else {
            var2 = var3;
         }
      }

      return var2;
   }

   public int c(TransitionValues var1) {
      return a(var1, 0);
   }

   public int d(TransitionValues var1) {
      return a(var1, 1);
   }
}
