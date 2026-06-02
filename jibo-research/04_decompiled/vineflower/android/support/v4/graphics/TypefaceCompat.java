package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Build.VERSION;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.util.LruCache;

public class TypefaceCompat {
   private static final TypefaceCompat.TypefaceCompatImpl a;
   private static final LruCache<String, Typeface> b;

   static {
      if (VERSION.SDK_INT >= 26) {
         a = new TypefaceCompatApi26Impl();
      } else if (VERSION.SDK_INT >= 24 && TypefaceCompatApi24Impl.a()) {
         a = new TypefaceCompatApi24Impl();
      } else if (VERSION.SDK_INT >= 21) {
         a = new TypefaceCompatApi21Impl();
      } else {
         a = new TypefaceCompatBaseImpl();
      }

      b = new LruCache<>(16);
   }

   public static Typeface a(Context var0, Resources var1, int var2, String var3, int var4) {
      Typeface var5 = a.a(var0, var1, var2, var3, var4);
      if (var5 != null) {
         String var6 = b(var1, var2, var4);
         b.a(var6, var5);
      }

      return var5;
   }

   public static Typeface a(Context var0, CancellationSignal var1, FontsContractCompat.FontInfo[] var2, int var3) {
      return a.a(var0, var1, var2, var3);
   }

   public static Typeface a(
      Context var0,
      FontResourcesParserCompat.FamilyResourceEntry var1,
      Resources var2,
      int var3,
      int var4,
      ResourcesCompat.FontCallback var5,
      Handler var6,
      boolean var7
   ) {
      boolean var9 = true;
      Typeface var10;
      if (var1 instanceof FontResourcesParserCompat.ProviderResourceEntry) {
         FontResourcesParserCompat.ProviderResourceEntry var11 = (FontResourcesParserCompat.ProviderResourceEntry)var1;
         if (var7) {
            if (var11.b() != 0) {
               var9 = false;
            }
         } else if (var5 != null) {
            var9 = false;
         }

         int var8;
         if (var7) {
            var8 = var11.c();
         } else {
            var8 = -1;
         }

         var10 = FontsContractCompat.a(var0, var11.a(), var5, var6, var9, var8, var4);
      } else {
         Typeface var12 = a.a(var0, (FontResourcesParserCompat.FontFamilyFilesResourceEntry)var1, var2, var4);
         var10 = var12;
         if (var5 != null) {
            if (var12 != null) {
               var5.a(var12, var6);
               var10 = var12;
            } else {
               var5.a(-3, var6);
               var10 = var12;
            }
         }
      }

      if (var10 != null) {
         b.a(b(var2, var3, var4), var10);
      }

      return var10;
   }

   public static Typeface a(Resources var0, int var1, int var2) {
      return b.a(b(var0, var1, var2));
   }

   private static String b(Resources var0, int var1, int var2) {
      return var0.getResourcePackageName(var1) + "-" + var1 + "-" + var2;
   }

   interface TypefaceCompatImpl {
      Typeface a(Context var1, Resources var2, int var3, String var4, int var5);

      Typeface a(Context var1, CancellationSignal var2, FontsContractCompat.FontInfo[] var3, int var4);

      Typeface a(Context var1, FontResourcesParserCompat.FontFamilyFilesResourceEntry var2, Resources var3, int var4);
   }
}
