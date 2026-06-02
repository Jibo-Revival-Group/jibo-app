package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

public class TypedArrayUtils {
   public static float a(TypedArray var0, XmlPullParser var1, String var2, int var3, float var4) {
      if (a(var1, var2)) {
         var4 = var0.getFloat(var3, var4);
      }

      return var4;
   }

   public static int a(TypedArray var0, XmlPullParser var1, String var2, int var3, int var4) {
      if (a(var1, var2)) {
         var4 = var0.getInt(var3, var4);
      }

      return var4;
   }

   public static TypedArray a(Resources var0, Theme var1, AttributeSet var2, int[] var3) {
      TypedArray var4;
      if (var1 == null) {
         var4 = var0.obtainAttributes(var2, var3);
      } else {
         var4 = var1.obtainStyledAttributes(var2, var3, 0, 0);
      }

      return var4;
   }

   public static String a(TypedArray var0, XmlPullParser var1, String var2, int var3) {
      String var4;
      if (!a(var1, var2)) {
         var4 = null;
      } else {
         var4 = var0.getString(var3);
      }

      return var4;
   }

   public static boolean a(TypedArray var0, XmlPullParser var1, String var2, int var3, boolean var4) {
      if (a(var1, var2)) {
         var4 = var0.getBoolean(var3, var4);
      }

      return var4;
   }

   public static boolean a(XmlPullParser var0, String var1) {
      boolean var2;
      if (var0.getAttributeValue("http://schemas.android.com/apk/res/android", var1) != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public static int b(TypedArray var0, XmlPullParser var1, String var2, int var3, int var4) {
      if (a(var1, var2)) {
         var4 = var0.getColor(var3, var4);
      }

      return var4;
   }

   public static TypedValue b(TypedArray var0, XmlPullParser var1, String var2, int var3) {
      TypedValue var4;
      if (!a(var1, var2)) {
         var4 = null;
      } else {
         var4 = var0.peekValue(var3);
      }

      return var4;
   }

   public static int c(TypedArray var0, XmlPullParser var1, String var2, int var3, int var4) {
      if (a(var1, var2)) {
         var4 = var0.getResourceId(var3, var4);
      }

      return var4;
   }
}
