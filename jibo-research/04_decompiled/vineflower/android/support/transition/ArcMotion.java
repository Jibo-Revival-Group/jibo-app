package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {
   private static final float a = (float)Math.tan(Math.toRadians(35.0));
   private float b = 0.0F;
   private float c = 0.0F;
   private float d = 70.0F;
   private float e = 0.0F;
   private float f = 0.0F;
   private float g = a;

   public ArcMotion() {
   }

   public ArcMotion(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, Styleable.j);
      XmlPullParser var4 = (XmlPullParser)var2;
      this.b(TypedArrayUtils.a(var3, var4, "minimumVerticalAngle", 1, 0.0F));
      this.a(TypedArrayUtils.a(var3, var4, "minimumHorizontalAngle", 0, 0.0F));
      this.c(TypedArrayUtils.a(var3, var4, "maximumAngle", 2, 70.0F));
      var3.recycle();
   }

   private static float d(float var0) {
      if (!(var0 < 0.0F) && !(var0 > 90.0F)) {
         return (float)Math.tan(Math.toRadians(var0 / 2.0F));
      } else {
         throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
      }
   }

   @Override
   public Path a(float var1, float var2, float var3, float var4) {
      Path var14 = new Path();
      var14.moveTo(var1, var2);
      float var6 = var3 - var1;
      float var7 = var4 - var2;
      float var5 = var7 * var7 + var6 * var6;
      float var10 = (var1 + var3) / 2.0F;
      float var9 = (var2 + var4) / 2.0F;
      float var11 = var5 * 0.25F;
      boolean var13;
      if (var2 > var4) {
         var13 = true;
      } else {
         var13 = false;
      }

      if (Math.abs(var6) < Math.abs(var7)) {
         var5 = Math.abs(var5 / (2.0F * var7));
         if (var13) {
            var5 = var4 + var5;
            var6 = var3;
         } else {
            var5 = var2 + var5;
            var6 = var1;
         }

         float var8 = this.f;
         float var12 = this.f;
         var7 = var6;
         var6 = var5;
         var8 = var8 * var11 * var12;
         var5 = var7;
         var7 = var8;
      } else {
         var5 /= var6 * 2.0F;
         if (var13) {
            var6 = var1 + var5;
            var5 = var2;
         } else {
            var6 = var3 - var5;
            var5 = var4;
         }

         float var31 = this.e;
         var7 = this.e;
         float var28 = var6;
         var7 = var31 * var11 * var7;
         var6 = var5;
         var5 = var28;
      }

      float var29 = var10 - var5;
      float var32 = var9 - var6;
      var32 = var32 * var32 + var29 * var29;
      var29 = this.g * var11 * this.g;
      if (!(var32 < var7)) {
         if (var32 > var29) {
            var7 = var29;
         } else {
            var7 = 0.0F;
         }
      }

      if (var7 != 0.0F) {
         var7 = (float)Math.sqrt(var7 / var32);
         var5 = (var5 - var10) * var7 + var10;
         var6 = var9 + var7 * (var6 - var9);
      }

      var14.cubicTo((var1 + var5) / 2.0F, (var2 + var6) / 2.0F, (var5 + var3) / 2.0F, (var6 + var4) / 2.0F, var3, var4);
      return var14;
   }

   public void a(float var1) {
      this.b = var1;
      this.e = d(var1);
   }

   public void b(float var1) {
      this.c = var1;
      this.f = d(var1);
   }

   public void c(float var1) {
      this.d = var1;
      this.g = d(var1);
   }
}
