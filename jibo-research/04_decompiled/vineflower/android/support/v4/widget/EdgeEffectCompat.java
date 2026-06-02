package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class EdgeEffectCompat {
   private static final EdgeEffectCompat.EdgeEffectBaseImpl a;

   static {
      if (VERSION.SDK_INT >= 21) {
         a = new EdgeEffectCompat.EdgeEffectApi21Impl();
      } else {
         a = new EdgeEffectCompat.EdgeEffectBaseImpl();
      }
   }

   public static void a(EdgeEffect var0, float var1, float var2) {
      a.a(var0, var1, var2);
   }

   static class EdgeEffectApi21Impl extends EdgeEffectCompat.EdgeEffectBaseImpl {
      @Override
      public void a(EdgeEffect var1, float var2, float var3) {
         var1.onPull(var2, var3);
      }
   }

   static class EdgeEffectBaseImpl {
      public void a(EdgeEffect var1, float var2, float var3) {
         var1.onPull(var2);
      }
   }
}
