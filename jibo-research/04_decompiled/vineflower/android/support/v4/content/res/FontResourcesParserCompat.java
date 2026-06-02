package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.compat.R;
import android.support.v4.provider.FontRequest;
import android.util.Base64;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class FontResourcesParserCompat {
   public static FontResourcesParserCompat.FamilyResourceEntry a(XmlPullParser var0, Resources var1) throws XmlPullParserException, IOException {
      int var2;
      do {
         var2 = var0.next();
      } while (var2 != 2 && var2 != 1);

      if (var2 != 2) {
         throw new XmlPullParserException("No start tag found");
      } else {
         return b(var0, var1);
      }
   }

   public static List<List<byte[]>> a(Resources var0, int var1) {
      List var3 = null;
      Object var4 = null;
      if (var1 != 0) {
         TypedArray var5 = var0.obtainTypedArray(var1);
         var3 = (List)var4;
         if (var5.length() > 0) {
            var3 = new ArrayList();
            boolean var2;
            if (var5.getResourceId(0, 0) != 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            if (var2) {
               for (int var6 = 0; var6 < var5.length(); var6++) {
                  var3.add(a(var0.getStringArray(var5.getResourceId(var6, 0))));
               }
            } else {
               var3.add(a(var0.getStringArray(var1)));
            }
         }

         var5.recycle();
      }

      if (var3 == null) {
         var3 = Collections.emptyList();
      }

      return var3;
   }

   private static List<byte[]> a(String[] var0) {
      ArrayList var3 = new ArrayList();
      int var2 = var0.length;

      for (int var1 = 0; var1 < var2; var1++) {
         var3.add(Base64.decode(var0[var1], 0));
      }

      return var3;
   }

   private static void a(XmlPullParser var0) throws XmlPullParserException, IOException {
      int var1 = 1;

      while (var1 > 0) {
         switch (var0.next()) {
            case 2:
               var1++;
               break;
            case 3:
               var1--;
         }
      }
   }

   private static FontResourcesParserCompat.FamilyResourceEntry b(XmlPullParser var0, Resources var1) throws XmlPullParserException, IOException {
      Object var2 = null;
      var0.require(2, null, "font-family");
      FontResourcesParserCompat.FamilyResourceEntry var3;
      if (var0.getName().equals("font-family")) {
         var3 = c(var0, var1);
      } else {
         a(var0);
         var3 = (FontResourcesParserCompat.FamilyResourceEntry)var2;
      }

      return var3;
   }

   private static FontResourcesParserCompat.FamilyResourceEntry c(XmlPullParser var0, Resources var1) throws XmlPullParserException, IOException {
      TypedArray var8 = var1.obtainAttributes(Xml.asAttributeSet(var0), R.styleable.FontFamily);
      String var6 = var8.getString(R.styleable.FontFamily_fontProviderAuthority);
      String var7 = var8.getString(R.styleable.FontFamily_fontProviderPackage);
      String var5 = var8.getString(R.styleable.FontFamily_fontProviderQuery);
      int var3 = var8.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
      int var4 = var8.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
      int var2 = var8.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
      var8.recycle();
      FontResourcesParserCompat.FamilyResourceEntry var9;
      if (var6 != null && var7 != null && var5 != null) {
         while (true) {
            if (var0.next() == 3) {
               var9 = new FontResourcesParserCompat.ProviderResourceEntry(new FontRequest(var6, var7, var5, a(var1, var3)), var4, var2);
               break;
            }

            a(var0);
         }
      } else {
         ArrayList var10 = new ArrayList();

         while (var0.next() != 3) {
            if (var0.getEventType() == 2) {
               if (var0.getName().equals("font")) {
                  var10.add(d(var0, var1));
               } else {
                  a(var0);
               }
            }
         }

         if (var10.isEmpty()) {
            var9 = null;
         } else {
            var9 = new FontResourcesParserCompat.FontFamilyFilesResourceEntry(var10.toArray(new FontResourcesParserCompat.FontFileResourceEntry[var10.size()]));
         }
      }

      return var9;
   }

   private static FontResourcesParserCompat.FontFileResourceEntry d(XmlPullParser var0, Resources var1) throws XmlPullParserException, IOException {
      TypedArray var6 = var1.obtainAttributes(Xml.asAttributeSet(var0), R.styleable.FontFamilyFont);
      int var2;
      if (var6.hasValue(R.styleable.FontFamilyFont_fontWeight)) {
         var2 = R.styleable.FontFamilyFont_fontWeight;
      } else {
         var2 = R.styleable.FontFamilyFont_android_fontWeight;
      }

      int var3 = var6.getInt(var2, 400);
      if (var6.hasValue(R.styleable.FontFamilyFont_fontStyle)) {
         var2 = R.styleable.FontFamilyFont_fontStyle;
      } else {
         var2 = R.styleable.FontFamilyFont_android_fontStyle;
      }

      boolean var5;
      if (1 == var6.getInt(var2, 0)) {
         var5 = true;
      } else {
         var5 = false;
      }

      if (var6.hasValue(R.styleable.FontFamilyFont_font)) {
         var2 = R.styleable.FontFamilyFont_font;
      } else {
         var2 = R.styleable.FontFamilyFont_android_font;
      }

      int var4 = var6.getResourceId(var2, 0);
      String var7 = var6.getString(var2);
      var6.recycle();

      while (var0.next() != 3) {
         a(var0);
      }

      return new FontResourcesParserCompat.FontFileResourceEntry(var7, var3, var5, var4);
   }

   public interface FamilyResourceEntry {
   }

   public static final class FontFamilyFilesResourceEntry implements FontResourcesParserCompat.FamilyResourceEntry {
      private final FontResourcesParserCompat.FontFileResourceEntry[] a;

      public FontFamilyFilesResourceEntry(FontResourcesParserCompat.FontFileResourceEntry[] var1) {
         this.a = var1;
      }

      public FontResourcesParserCompat.FontFileResourceEntry[] a() {
         return this.a;
      }
   }

   public static final class FontFileResourceEntry {
      private final String a;
      private int b;
      private boolean c;
      private int d;

      public FontFileResourceEntry(String var1, int var2, boolean var3, int var4) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
      }

      public String a() {
         return this.a;
      }

      public int b() {
         return this.b;
      }

      public boolean c() {
         return this.c;
      }

      public int d() {
         return this.d;
      }
   }

   public static final class ProviderResourceEntry implements FontResourcesParserCompat.FamilyResourceEntry {
      private final FontRequest a;
      private final int b;
      private final int c;

      public ProviderResourceEntry(FontRequest var1, int var2, int var3) {
         this.a = var1;
         this.c = var2;
         this.b = var3;
      }

      public FontRequest a() {
         return this.a;
      }

      public int b() {
         return this.c;
      }

      public int c() {
         return this.b;
      }
   }
}
