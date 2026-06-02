package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
   private static final Class a;
   private static final Constructor b;
   private static final Method c;
   private static final Method d;

   static {
      Method var1 = null;

      Class var2;
      Constructor var3;
      Method var7;
      label18: {
         Method var4;
         label17: {
            try {
               var2 = Class.forName("android.graphics.FontFamily");
               var3 = var2.getConstructor();
               var4 = var2.getMethod("addFontWeightStyle", ByteBuffer.class, int.class, List.class, int.class, boolean.class);
               var7 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(var2, 1).getClass());
               break label17;
            } catch (ClassNotFoundException var5) {
               var0 = var5;
            } catch (NoSuchMethodException var6) {
               var0 = var6;
            }

            Log.e("TypefaceCompatApi24Impl", var0.getClass().getName(), var0);
            var7 = null;
            var3 = null;
            var2 = null;
            break label18;
         }

         var1 = var4;
      }

      b = var3;
      a = var2;
      c = var1;
      d = var7;
   }

   private static Typeface a(Object var0) {
      try {
         Object var1 = Array.newInstance(a, 1);
         Array.set(var1, 0, var0);
         return (Typeface)d.invoke(null, var1);
      } catch (IllegalAccessException var2) {
         var0 = var2;
      } catch (InvocationTargetException var3) {
         var0 = var3;
      }

      throw new RuntimeException(var0);
   }

   public static boolean a() {
      if (c == null) {
         Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
      }

      boolean var0;
      if (c != null) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   private static boolean a(Object var0, ByteBuffer var1, int var2, int var3, boolean var4) {
      try {
         return (Boolean)c.invoke(var0, var1, var2, null, var3, var4);
      } catch (IllegalAccessException var5) {
         var0 = var5;
      } catch (InvocationTargetException var6) {
         var0 = var6;
      }

      throw new RuntimeException(var0);
   }

   private static Object b() {
      ReflectiveOperationException var0;
      try {
         return b.newInstance();
      } catch (IllegalAccessException var1) {
         var0 = var1;
      } catch (InstantiationException var2) {
         var0 = var2;
      } catch (InvocationTargetException var3) {
         var0 = var3;
      }

      throw new RuntimeException(var0);
   }

   @Override
   public Typeface a(Context var1, CancellationSignal var2, FontsContractCompat.FontInfo[] var3, int var4) {
      Object var10 = b();
      SimpleArrayMap var11 = new SimpleArrayMap();
      int var6 = var3.length;
      int var5 = 0;

      while (true) {
         if (var5 >= var6) {
            var13 = Typeface.create(a(var10), var4);
            break;
         }

         FontsContractCompat.FontInfo var9 = var3[var5];
         Uri var12 = var9.a();
         ByteBuffer var8 = (ByteBuffer)var11.get(var12);
         ByteBuffer var7 = var8;
         if (var8 == null) {
            var7 = TypefaceCompatUtil.a(var1, var2, var12);
            var11.put(var12, var7);
         }

         if (!a(var10, var7, var9.b(), var9.c(), var9.d())) {
            var13 = null;
            break;
         }

         var5++;
      }

      return var13;
   }

   @Override
   public Typeface a(Context var1, FontResourcesParserCompat.FontFamilyFilesResourceEntry var2, Resources var3, int var4) {
      Object var6 = null;
      Object var7 = b();
      FontResourcesParserCompat.FontFileResourceEntry[] var10 = var2.a();
      int var5 = var10.length;
      var4 = 0;

      while (true) {
         if (var4 >= var5) {
            var11 = a(var7);
            break;
         }

         FontResourcesParserCompat.FontFileResourceEntry var8 = var10[var4];
         ByteBuffer var9 = TypefaceCompatUtil.a(var1, var3, var8.d());
         if (var9 == null) {
            var11 = (Typeface)var6;
            break;
         }

         var11 = (Typeface)var6;
         if (!a(var7, var9, 0, var8.b(), var8.c())) {
            break;
         }

         var4++;
      }

      return var11;
   }
}
