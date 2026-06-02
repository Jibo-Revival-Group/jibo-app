package android.support.v7.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class AppCompatColorStateListInflater {
   private static int a(int var0, float var1) {
      return ColorUtils.b(var0, Math.round(Color.alpha(var0) * var1));
   }

   public static ColorStateList a(Resources var0, XmlPullParser var1, Theme var2) throws XmlPullParserException, IOException {
      AttributeSet var4 = Xml.asAttributeSet(var1);

      int var3;
      do {
         var3 = var1.next();
      } while (var3 != 2 && var3 != 1);

      if (var3 != 2) {
         throw new XmlPullParserException("No start tag found");
      } else {
         return a(var0, var1, var4, var2);
      }
   }

   private static ColorStateList a(Resources var0, XmlPullParser var1, AttributeSet var2, Theme var3) throws XmlPullParserException, IOException {
      String var4 = var1.getName();
      if (!var4.equals("selector")) {
         throw new XmlPullParserException(var1.getPositionDescription() + ": invalid color state list tag " + var4);
      } else {
         return b(var0, var1, var2, var3);
      }
   }

   private static TypedArray a(Resources var0, Theme var1, AttributeSet var2, int[] var3) {
      TypedArray var4;
      if (var1 == null) {
         var4 = var0.obtainAttributes(var2, var3);
      } else {
         var4 = var1.obtainStyledAttributes(var2, var3, 0, 0);
      }

      return var4;
   }

   private static ColorStateList b(Resources var0, XmlPullParser var1, AttributeSet var2, Theme var3) throws XmlPullParserException, IOException {
      int var9 = var1.getDepth() + 1;
      int[][] var12 = new int[20][];
      int[] var13 = new int[var12.length];
      int var6 = 0;

      while (true) {
         int var5 = var1.next();
         if (var5 == 1) {
            break;
         }

         int var7 = var1.getDepth();
         if (var7 < var9 && var5 == 3) {
            break;
         }

         if (var5 == 2 && var7 <= var9 && var1.getName().equals("item")) {
            TypedArray var14 = a(var0, var3, var2, R.styleable.ColorStateListItem);
            int var11 = var14.getColor(R.styleable.ColorStateListItem_android_color, -65281);
            float var4 = 1.0F;
            if (var14.hasValue(R.styleable.ColorStateListItem_android_alpha)) {
               var4 = var14.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0F);
            } else if (var14.hasValue(R.styleable.ColorStateListItem_alpha)) {
               var4 = var14.getFloat(R.styleable.ColorStateListItem_alpha, 1.0F);
            }

            var14.recycle();
            var5 = 0;
            int var10 = var2.getAttributeCount();
            int[] var20 = new int[var10];

            for (int var19 = 0; var19 < var10; var19++) {
               int var8 = var2.getAttributeNameResource(var19);
               if (var8 != 16843173 && var8 != 16843551 && var8 != R.attr.alpha) {
                  if (!var2.getAttributeBooleanValue(var19, false)) {
                     var8 = -var8;
                  }

                  var20[var5] = var8;
                  var5++;
               }
            }

            int[] var21 = StateSet.trimStateSet(var20, var5);
            var5 = a(var11, var4);
            if (var6 != 0 && var21.length == 0) {
            }

            var13 = GrowingArrayUtils.a(var13, var6, var5);
            var12 = GrowingArrayUtils.a(var12, var6, var21);
            var6++;
         }
      }

      int[] var15 = new int[var6];
      int[][] var16 = new int[var6][];
      System.arraycopy(var13, 0, var15, 0, var6);
      System.arraycopy(var12, 0, var16, 0, var6);
      return new ColorStateList(var16, var15);
   }
}
