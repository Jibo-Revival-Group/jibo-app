package android.support.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public class PathInterpolatorCompat implements Interpolator {
   private float[] a;
   private float[] b;

   public PathInterpolatorCompat(Context var1, AttributeSet var2, XmlPullParser var3) {
      this(var1.getResources(), var1.getTheme(), var2, var3);
   }

   public PathInterpolatorCompat(Resources var1, Theme var2, AttributeSet var3, XmlPullParser var4) {
      TypedArray var5 = TypedArrayUtils.a(var1, var2, var3, AndroidResources.l);
      this.a(var5, var4);
      var5.recycle();
   }

   private void a(float var1, float var2) {
      Path var3 = new Path();
      var3.moveTo(0.0F, 0.0F);
      var3.quadTo(var1, var2, 1.0F, 1.0F);
      this.a(var3);
   }

   private void a(float var1, float var2, float var3, float var4) {
      Path var5 = new Path();
      var5.moveTo(0.0F, 0.0F);
      var5.cubicTo(var1, var2, var3, var4, 1.0F, 1.0F);
      this.a(var5);
   }

   private void a(TypedArray var1, XmlPullParser var2) {
      if (TypedArrayUtils.a(var2, "pathData")) {
         String var6 = TypedArrayUtils.a(var1, var2, "pathData", 4);
         Path var7 = PathParser.a(var6);
         if (var7 == null) {
            throw new InflateException("The path is null, which is created from " + var6);
         }

         this.a(var7);
      } else {
         if (!TypedArrayUtils.a(var2, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
         }

         if (!TypedArrayUtils.a(var2, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
         }

         float var3 = TypedArrayUtils.a(var1, var2, "controlX1", 0, 0.0F);
         float var4 = TypedArrayUtils.a(var1, var2, "controlY1", 1, 0.0F);
         boolean var5 = TypedArrayUtils.a(var2, "controlX2");
         if (var5 != TypedArrayUtils.a(var2, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
         }

         if (!var5) {
            this.a(var3, var4);
         } else {
            this.a(var3, var4, TypedArrayUtils.a(var1, var2, "controlX2", 2, 0.0F), TypedArrayUtils.a(var1, var2, "controlY2", 3, 0.0F));
         }
      }
   }

   private void a(Path var1) {
      int var5 = 0;
      PathMeasure var8 = new PathMeasure(var1, false);
      float var2 = var8.getLength();
      int var6 = Math.min(3000, (int)(var2 / 0.002F) + 1);
      if (var6 <= 0) {
         throw new IllegalArgumentException("The Path has a invalid length " + var2);
      }

      this.a = new float[var6];
      this.b = new float[var6];
      float[] var7 = new float[2];

      for (int var4 = 0; var4 < var6; var4++) {
         var8.getPosTan(var4 * var2 / (var6 - 1), var7, null);
         this.a[var4] = var7[0];
         this.b[var4] = var7[1];
      }

      if (!(Math.abs(this.a[0]) > 1.0E-5)
         && !(Math.abs(this.b[0]) > 1.0E-5)
         && !(Math.abs(this.a[var6 - 1] - 1.0F) > 1.0E-5)
         && !(Math.abs(this.b[var6 - 1] - 1.0F) > 1.0E-5)) {
         var2 = 0.0F;

         for (int var10 = 0; var5 < var6; var10++) {
            float var3 = this.a[var10];
            if (var3 < var2) {
               throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + var3);
            }

            this.a[var5] = var3;
            var5++;
            var2 = var3;
         }

         if (var8.nextContour()) {
            throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
         }
      } else {
         throw new IllegalArgumentException(
            "The Path must start at (0,0) and end at (1,1) start: " + this.a[0] + "," + this.b[0] + " end:" + this.a[var6 - 1] + "," + this.b[var6 - 1]
         );
      }
   }

   public float getInterpolation(float var1) {
      float var2 = 1.0F;
      if (var1 <= 0.0F) {
         var2 = 0.0F;
      } else if (!(var1 >= 1.0F)) {
         int var4 = 0;
         int var3 = this.a.length - 1;

         while (var3 - var4 > 1) {
            int var5 = (var4 + var3) / 2;
            if (var1 < this.a[var5]) {
               var3 = var5;
            } else {
               var4 = var5;
            }
         }

         var2 = this.a[var3] - this.a[var4];
         if (var2 == 0.0F) {
            var2 = this.b[var4];
         } else {
            var1 = (var1 - this.a[var4]) / var2;
            var2 = this.b[var4];
            var2 = var1 * (this.b[var3] - var2) + var2;
         }
      }

      return var2;
   }
}
