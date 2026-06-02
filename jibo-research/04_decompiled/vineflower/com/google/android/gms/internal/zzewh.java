package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.provider.Settings.Secure;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzewh {
   private final int a;
   private final int b;
   private final boolean c;
   private boolean d = false;
   private zzewj e = null;
   private zzewj f = null;

   private zzewh(long var1, long var3, zzewk var5, int var6, List<String> var7) {
      this.a = var6;
      Map var11 = a(var7);
      if (var11.containsKey("sampling")) {
         this.b = ((Long)var11.get("sampling")).intValue();
      } else {
         this.b = 100;
      }

      if (this.b != 100) {
         int var8 = this.b;
         var6 = this.a;
         Log.d("FirebasePerformance", new StringBuilder(59).append("RateLimiter sampling rate:").append(var8).append(" bucketId: ").append(var6).toString());
      }

      boolean var9;
      if (this.a <= this.b) {
         var9 = true;
      } else {
         var9 = false;
      }

      this.c = var9;
      if (!this.c) {
         Log.d("FirebasePerformance", "logging is disabled because device sampling");
      } else {
         this.e = new zzewj(100L, 500L, var5, var11, zzewi.zzocp, this.d);
         this.f = new zzewj(100L, 500L, var5, var11, zzewi.zzoco, this.d);
      }
   }

   public zzewh(Context var1, String var2, long var3, long var5) {
      this(100L, 500L, new zzewk(), a(Secure.getString(var1.getContentResolver(), "android_id")), a(var1, var2));
      this.d = zzewq.a(var1);
   }

   private static int a(Context var0) {
      byte var2 = 0;

      int var1;
      try {
         var1 = var0.getPackageManager().getPackageInfo(var0.getPackageName(), 0).versionCode;
      } catch (NameNotFoundException var3) {
         var1 = var2;
      }

      return var1;
   }

   private static int a(String var0) {
      int var1;
      try {
         var1 = zzewq.a(MessageDigest.getInstance("SHA-1").digest(var0.getBytes()));
      } catch (NoSuchAlgorithmException var3) {
         var1 = zzewq.a(var0.getBytes());
      }

      return (var1 % 100 + 100) % 100 + 1;
   }

   private static List<String> a(Context var0, String var1) {
      ArrayList var5 = new ArrayList();
      int var2 = a(var0);
      String var4 = new StringBuilder(String.valueOf(var1).length() + 12).append(var1).append(":").append(var2).toString();

      for (int var7 = 0; var7 < 3; var7++) {
         String var6 = new String[]{var4, var1, "1.0.0.178131943"}[var7];
         String var3 = String.valueOf("_fireperf1:");
         var6 = String.valueOf(var6);
         if (var6.length() != 0) {
            var3 = var3.concat(var6);
         } else {
            var3 = new String(var3);
         }

         var3 = b(var3);
         var3 = new StringBuilder(String.valueOf(var3).length() + 16).append("fireperf:").append(var3).append("_limits").toString();
         var3 = zzdmf.a(var0.getContentResolver(), var3, null);
         if (var3 != null) {
            var5.add(var3);
         }
      }

      return var5;
   }

   private static Map<String, Long> a(List<String> var0) {
      HashMap var5 = new HashMap();
      if (var0 != null) {
         Iterator var6 = var0.iterator();

         while (var6.hasNext()) {
            String[] var10 = ((String)var6.next()).split(",");
            int var2 = var10.length;

            for (int var1 = 0; var1 < var2; var1++) {
               String[] var7 = var10[var1].split(":");
               if (var7.length >= 2) {
                  String var8 = var7[0].trim();
                  if (!var8.isEmpty() && !var5.containsKey(var8)) {
                     long var3;
                     try {
                        var3 = Long.parseLong(var7[1].trim());
                     } catch (NumberFormatException var9) {
                        continue;
                     }

                     if (var3 >= 0L) {
                        var5.put(var8, var3);
                     }
                  }
               }
            }
         }
      }

      return var5;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static String b(String var0) {
      Object var3 = null;
      int var1 = 0;
      if (var0 == null) {
         var0 = (String)var3;
      } else {
         int var2;
         byte[] var4;
         try {
            var4 = MessageDigest.getInstance("SHA-1").digest(var0.getBytes());
            var9 = new StringBuilder();
            var2 = var4.length;
         } catch (NoSuchAlgorithmException var7) {
            var0 = (String)var3;
            return var0;
         }

         for (; var1 < var2; var1++) {
            try {
               var9.append(String.format("%02x", var4[var1]));
            } catch (NoSuchAlgorithmException var6) {
               var0 = (String)var3;
               return var0;
            }
         }

         try {
            var0 = var9.toString();
         } catch (NoSuchAlgorithmException var5) {
            var0 = (String)var3;
         }
      }

      return var0;
   }

   final void a(boolean var1) {
      if (this.c) {
         this.e.a(var1);
         this.f.a(var1);
      }
   }

   final boolean a(zzewx var1) {
      boolean var3 = false;
      if (this.c) {
         boolean var2;
         if (var1.b != null
            && var1.b.a != null
            && (var1.b.a.equals(zzewm.zzoev.toString()) || var1.b.a.equals(zzewm.zzoew.toString()))
            && var1.b.d != null
            && var1.b.d.length > 0) {
            var2 = false;
         } else {
            var2 = true;
         }

         if (!var2) {
            var3 = true;
         } else if (var1.c != null) {
            var3 = this.f.a(var1);
         } else if (var1.b != null) {
            var3 = this.e.a(var1);
         }
      }

      return var3;
   }
}
