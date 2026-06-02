package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class zzbeu implements zzbeb {
   private static final Charset a = Charset.forName("UTF-8");
   private static final zzcup b = new zzcup(zzcue.a("com.google.android.gms.clearcut.public")).a("gms:playlog:service:sampling_").b("LogSampling__");
   private static Map<String, zzcui<String>> d = null;
   private static Boolean e = null;
   private static Long f = null;
   private final Context c;

   public zzbeu(Context var1) {
      this.c = var1;
      if (d == null) {
         d = new HashMap<>();
      }

      if (this.c != null) {
         zzcui.a(this.c);
      }
   }

   private static zzbev a(String var0) {
      int var1 = 0;
      zzbev var9;
      if (var0 == null) {
         var9 = null;
      } else {
         String var7 = "";
         int var2 = var0.indexOf(44);
         if (var2 >= 0) {
            var7 = var0.substring(0, var2);
            var1 = var2 + 1;
         }

         var2 = var0.indexOf(47, var1);
         if (var2 <= 0) {
            var0 = String.valueOf(var0);
            if (var0.length() != 0) {
               var0 = "Failed to parse the rule: ".concat(var0);
            } else {
               var0 = new String("Failed to parse the rule: ");
            }

            Log.e("LogSamplerImpl", var0);
            var9 = null;
         } else {
            long var3;
            long var5;
            try {
               var3 = Long.parseLong(var0.substring(var1, var2));
               var5 = Long.parseLong(var0.substring(var2 + 1));
            } catch (NumberFormatException var8) {
               var0 = String.valueOf(var0);
               if (var0.length() != 0) {
                  var0 = "parseLong() failed while parsing: ".concat(var0);
               } else {
                  var0 = new String("parseLong() failed while parsing: ");
               }

               Log.e("LogSamplerImpl", var0, var8);
               Object var15 = null;
               return (zzbev)var15;
            }

            if (var3 >= 0L && var5 >= 0L) {
               var9 = new zzbev(var7, var3, var5);
            } else {
               Log.e("LogSamplerImpl", new StringBuilder(72).append("negative values not supported: ").append(var3).append("/").append(var5).toString());
               var9 = null;
            }
         }
      }

      return var9;
   }

   private static boolean a(Context var0) {
      if (e == null) {
         boolean var1;
         if (zzbhf.a(var0).a("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         e = var1;
      }

      return e;
   }

   @Override
   public final boolean a(String var1, int var2) {
      if (var1 == null || var1.isEmpty()) {
         if (var2 >= 0) {
            var1 = String.valueOf(var2);
         } else {
            var1 = null;
         }
      }

      boolean var9;
      if (var1 == null) {
         var9 = true;
      } else {
         if (this.c != null && a(this.c)) {
            zzcui var11 = d.get(var1);
            zzcui var10 = var11;
            if (var11 == null) {
               var10 = b.a(var1, null);
               d.put(var1, var10);
            }

            var1 = (String)var10.a();
         } else {
            var1 = null;
         }

         zzbev var13 = a(var1);
         if (var13 == null) {
            var9 = true;
         } else {
            long var3;
            String var18;
            label67: {
               var18 = var13.a;
               Context var16 = this.c;
               if (f == null) {
                  if (var16 == null) {
                     var3 = 0L;
                     break label67;
                  }

                  if (a(var16)) {
                     f = zzdmf.a(var16.getContentResolver(), "android_id", 0L);
                  } else {
                     f = 0L;
                  }
               }

               var3 = f;
            }

            if (var18 != null && !var18.isEmpty()) {
               byte[] var17 = var18.getBytes(a);
               ByteBuffer var19 = ByteBuffer.allocate(var17.length + 8);
               var19.put(var17);
               var19.putLong(var3);
               var3 = zzbep.a(var19.array());
            } else {
               var3 = zzbep.a(ByteBuffer.allocate(8).putLong(var3).array());
            }

            long var5 = var13.b;
            long var7 = var13.c;
            if (var5 < 0L || var7 < 0L) {
               throw new IllegalArgumentException(
                  new StringBuilder(72).append("negative values not supported: ").append(var5).append("/").append(var7).toString()
               );
            }

            if (var7 > 0L) {
               if (var3 >= 0L) {
                  var3 %= var7;
               } else {
                  var3 = ((var3 & Long.MAX_VALUE) % var7 + Long.MAX_VALUE % var7 + 1L) % var7;
               }

               if (var3 < var5) {
                  var9 = true;
                  return var9;
               }
            }

            var9 = false;
         }
      }

      return var9;
   }
}
