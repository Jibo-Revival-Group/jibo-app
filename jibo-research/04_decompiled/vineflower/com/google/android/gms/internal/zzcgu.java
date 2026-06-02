package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzcgu extends zzcjl {
   private long a;
   private String b;
   private Boolean c;

   zzcgu(zzcim var1) {
      super(var1);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public final boolean a(Context var1) {
      if (this.c == null) {
         this.c = false;

         try {
            var4 = var1.getPackageManager();
         } catch (NameNotFoundException var3) {
            return this.c;
         }

         if (var4 != null) {
            try {
               var4.getPackageInfo("com.google.android.gms", 128);
               this.c = true;
            } catch (NameNotFoundException var2) {
            }
         }
      }

      return this.c;
   }

   @Override
   protected final boolean w() {
      Calendar var2 = Calendar.getInstance();
      TimeUnit var3 = TimeUnit.MINUTES;
      int var1 = var2.get(15);
      this.a = var3.convert(var2.get(16) + var1, TimeUnit.MILLISECONDS);
      Locale var5 = Locale.getDefault();
      String var4 = var5.getLanguage().toLowerCase(Locale.ENGLISH);
      String var6 = var5.getCountry().toLowerCase(Locale.ENGLISH);
      this.b = new StringBuilder(String.valueOf(var4).length() + 1 + String.valueOf(var6).length()).append(var4).append("-").append(var6).toString();
      return false;
   }

   public final long x() {
      this.Q();
      return this.a;
   }

   public final String y() {
      this.Q();
      return this.b;
   }
}
