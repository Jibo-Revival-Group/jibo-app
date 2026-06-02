package com.mixpanel.android.mpmetrics;

import android.R.drawable;
import android.R.id;
import android.content.Context;
import android.util.SparseArray;
import com.mixpanel.android.util.MPLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class ResourceReader implements ResourceIds {
   private final Context a;
   private final Map<String, Integer> b;
   private final SparseArray<String> c;

   protected ResourceReader(Context var1) {
      this.a = var1;
      this.b = new HashMap<>();
      this.c = new SparseArray();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void a(Class<?> var0, String var1, Map<String, Integer> var2) {
      Field[] var6;
      try {
         var6 = var0.getFields();
      } catch (IllegalAccessException var12) {
         MPLog.e("MixpanelAPI.RsrcReader", "Can't read built-in id names from " + var0.getName(), var12);
         return;
      }

      int var3 = 0;

      while (true) {
         try {
            if (var3 >= var6.length) {
               break;
            }
         } catch (IllegalAccessException var10) {
            MPLog.e("MixpanelAPI.RsrcReader", "Can't read built-in id names from " + var0.getName(), var10);
            break;
         }

         Field var7 = var6[var3];

         label55: {
            int var4;
            String var5;
            try {
               if (!Modifier.isStatic(var7.getModifiers()) || var7.getType() != int.class) {
                  break label55;
               }

               var5 = var7.getName();
               var4 = var7.getInt(null);
            } catch (IllegalAccessException var11) {
               MPLog.e("MixpanelAPI.RsrcReader", "Can't read built-in id names from " + var0.getName(), var11);
               break;
            }

            if (var1 != null) {
               try {
                  StringBuilder var13 = new StringBuilder();
                  var5 = var13.append(var1).append(":").append(var5).toString();
               } catch (IllegalAccessException var9) {
                  MPLog.e("MixpanelAPI.RsrcReader", "Can't read built-in id names from " + var0.getName(), var9);
                  break;
               }
            }

            try {
               var2.put(var5, var4);
            } catch (IllegalAccessException var8) {
               MPLog.e("MixpanelAPI.RsrcReader", "Can't read built-in id names from " + var0.getName(), var8);
               break;
            }
         }

         var3++;
      }
   }

   protected abstract Class<?> a();

   @Override
   public String a(int var1) {
      return (String)this.c.get(var1);
   }

   protected abstract String a(Context var1);

   @Override
   public boolean a(String var1) {
      return this.b.containsKey(var1);
   }

   @Override
   public int b(String var1) {
      return this.b.get(var1);
   }

   protected void b() {
      this.b.clear();
      this.c.clear();
      a(this.a(), "android", this.b);
      String var1 = this.a(this.a);

      try {
         a(Class.forName(var1), null, this.b);
      } catch (ClassNotFoundException var3) {
         MPLog.d("MixpanelAPI.RsrcReader", "Can't load names for Android view ids from '" + var1 + "', ids by name will not be available in the events editor.");
         MPLog.c(
            "MixpanelAPI.RsrcReader",
            "You may be missing a Resources class for your package due to your proguard configuration, or you may be using an applicationId in your build that isn't the same as the package declared in your AndroidManifest.xml file.\nIf you're using proguard, you can fix this issue by adding the following to your proguard configuration:\n\n-keep class **.R$* {\n    <fields>;\n}\n\nIf you're not using proguard, or if your proguard configuration already contains the directive above, you can add the following to your AndroidManifest.xml file to explicitly point the Mixpanel library to the appropriate library for your resources class:\n\n<meta-data android:name=\"com.mixpanel.android.MPConfig.ResourcePackageName\" android:value=\"YOUR_PACKAGE_NAME\" />\n\nwhere YOUR_PACKAGE_NAME is the same string you use for the \"package\" attribute in your <manifest> tag."
         );
      }

      for (Entry var4 : this.b.entrySet()) {
         this.c.put((Integer)var4.getValue(), var4.getKey());
      }
   }

   public static class Drawables extends ResourceReader {
      private final String a;

      protected Drawables(String var1, Context var2) {
         super(var2);
         this.a = var1;
         this.b();
      }

      @Override
      protected Class<?> a() {
         return drawable.class;
      }

      @Override
      protected String a(Context var1) {
         return this.a + ".R$drawable";
      }
   }

   public static class Ids extends ResourceReader {
      private final String a;

      public Ids(String var1, Context var2) {
         super(var2);
         this.a = var1;
         this.b();
      }

      @Override
      protected Class<?> a() {
         return id.class;
      }

      @Override
      protected String a(Context var1) {
         return this.a + ".R$id";
      }
   }
}
