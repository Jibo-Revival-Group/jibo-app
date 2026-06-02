package android.support.graphics.drawable;

import android.animation.TypeEvaluator;

public class ArgbEvaluator implements TypeEvaluator {
   private static final ArgbEvaluator a = new ArgbEvaluator();

   public static ArgbEvaluator a() {
      return a;
   }

   public Object evaluate(float var1, Object var2, Object var3) {
      int var12 = (Integer)var2;
      float var4 = (var12 >> 24 & 0xFF) / 255.0F;
      float var8 = (var12 >> 16 & 0xFF) / 255.0F;
      float var6 = (var12 >> 8 & 0xFF) / 255.0F;
      float var7 = (var12 & 0xFF) / 255.0F;
      var12 = (Integer)var3;
      float var5 = (var12 >> 24 & 0xFF) / 255.0F;
      float var11 = (var12 >> 16 & 0xFF) / 255.0F;
      float var10 = (var12 >> 8 & 0xFF) / 255.0F;
      float var9 = (var12 & 0xFF) / 255.0F;
      var8 = (float)Math.pow(var8, 2.2);
      var6 = (float)Math.pow(var6, 2.2);
      var7 = (float)Math.pow(var7, 2.2);
      var11 = (float)Math.pow(var11, 2.2);
      var10 = (float)Math.pow(var10, 2.2);
      var9 = (float)Math.pow(var9, 2.2);
      var8 = (float)Math.pow(var8 + (var11 - var8) * var1, 0.45454545454545453);
      var6 = (float)Math.pow(var6 + (var10 - var6) * var1, 0.45454545454545453);
      var7 = (float)Math.pow(var7 + (var9 - var7) * var1, 0.45454545454545453);
      int var13 = Math.round((var4 + (var5 - var4) * var1) * 255.0F);
      int var14 = Math.round(var8 * 255.0F);
      var12 = Math.round(var6 * 255.0F);
      return Math.round(var7 * 255.0F) | var13 << 24 | var14 << 16 | var12 << 8;
   }
}
