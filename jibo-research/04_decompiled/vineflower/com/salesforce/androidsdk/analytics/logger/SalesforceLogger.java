package com.salesforce.androidsdk.analytics.logger;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SalesforceLogger {
   private static final ExecutorService a = Executors.newFixedThreadPool(1);
   private static Map<String, SalesforceLogger> b;
   private FileLogger c;
   private Context d;
   private String e;
   private SalesforceLogger.Level f;

   private SalesforceLogger(String var1, Context var2) {
      this.d = var2;
      this.e = var1;
      this.c();

      try {
         FileLogger var3 = new FileLogger(var2, var1);
         this.c = var3;
      } catch (IOException var4) {
         Log.e("SalesforceLogger", "Couldn't create file logger", var4);
      }
   }

   public static SalesforceLogger a(String var0, Context var1) {
      synchronized (SalesforceLogger.class) {
         if (b == null) {
            HashMap var2 = new HashMap();
            b = var2;
         }

         if (!b.containsKey(var0)) {
            SalesforceLogger var5 = new SalesforceLogger(var0, var1);
            b.put(var0, var5);
         }

         return b.get(var0);
      }
   }

   private void a(SalesforceLogger.Level var1) {
      synchronized (this) {
         Editor var2 = this.d.getSharedPreferences("sf_logger_prefs", 0).edit();
         var2.putString(this.e, var1.toString());
         var2.commit();
         this.f = var1;
      }
   }

   private void a(String var1, SalesforceLogger.Level var2, String var3, String var4, Throwable var5) {
      a.execute(
         new Runnable(this, var5, var1, var2, var3, var4) {
            final Throwable a;
            final String b;
            final SalesforceLogger.Level c;
            final String d;
            final String e;
            final SalesforceLogger f;

            {
               this.f = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4x;
               this.d = var5x;
               this.e = var6;
            }

            @Override
            public void run() {
               if (this.f.c != null) {
                  String var1x;
                  if (this.a != null) {
                     var1x = String.format(
                        "TIME: %s, LEVEL: %s, TAG: %s, MESSAGE: %s, EXCEPTION: %s", this.b, this.c, this.d, this.e, Log.getStackTraceString(this.a)
                     );
                  } else {
                     var1x = String.format("TIME: %s, LEVEL: %s, TAG: %s, MESSAGE: %s", this.b, this.c, this.d, this.e);
                  }

                  this.f.c.a(var1x);
               }
            }
         }
      );
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private boolean a() {
      boolean var2 = false;

      PackageManager var3;
      try {
         var3 = this.d.getPackageManager();
      } catch (NameNotFoundException var7) {
         var2 = true;
         return var2;
      }

      if (var3 != null) {
         try {
            var8 = var3.getPackageInfo(this.d.getPackageName(), 0);
         } catch (NameNotFoundException var6) {
            var2 = true;
            return var2;
         }

         if (var8 != null) {
            try {
               var9 = var8.applicationInfo;
            } catch (NameNotFoundException var5) {
               var2 = true;
               return var2;
            }

            if (var9 != null) {
               int var1;
               try {
                  var1 = var9.flags;
               } catch (NameNotFoundException var4) {
                  var2 = true;
                  return var2;
               }

               if ((var1 & 2) == 0) {
                  return var2;
               }
            }
         }
      }

      return true;
   }

   private String b() {
      Date var1 = new Date(System.currentTimeMillis());
      return new SimpleDateFormat("MM-dd HH:mm:ss.SSS").format(var1);
   }

   private void c() {
      SharedPreferences var2 = this.d.getSharedPreferences("sf_logger_prefs", 0);
      SalesforceLogger.Level var1 = SalesforceLogger.Level.DEBUG;
      if (!this.a()) {
         var1 = SalesforceLogger.Level.ERROR;
      }

      if (!var2.contains(this.e)) {
         this.a(var1);
      }

      this.f = SalesforceLogger.Level.valueOf(var2.getString(this.e, var1.toString()));
   }

   public void a(SalesforceLogger.Level var1, String var2, String var3) {
      switch (<unrepresentable>.a[var1.ordinal()]) {
         case 1:
            break;
         case 2:
            Log.e(var2, var3);
            break;
         case 3:
            Log.w(var2, var3);
            break;
         case 4:
            Log.i(var2, var3);
            break;
         case 5:
            Log.d(var2, var3);
            break;
         case 6:
            Log.v(var2, var3);
            break;
         default:
            Log.d(var2, var3);
      }

      if (var1 != SalesforceLogger.Level.OFF) {
         this.a(this.b(), var1, var2, var3, null);
      }
   }

   public void a(SalesforceLogger.Level var1, String var2, String var3, Throwable var4) {
      switch (<unrepresentable>.a[var1.ordinal()]) {
         case 1:
            break;
         case 2:
            Log.e(var2, var3, var4);
            break;
         case 3:
            Log.w(var2, var3, var4);
            break;
         case 4:
            Log.i(var2, var3, var4);
            break;
         case 5:
            Log.d(var2, var3, var4);
            break;
         case 6:
            Log.v(var2, var3, var4);
            break;
         default:
            Log.d(var2, var3, var4);
      }

      if (var1 != SalesforceLogger.Level.OFF) {
         this.a(this.b(), var1, var2, var3, var4);
      }
   }

   public void a(String var1, String var2) {
      this.a(SalesforceLogger.Level.ERROR, var1, var2);
   }

   public void a(String var1, String var2, Throwable var3) {
      this.a(SalesforceLogger.Level.ERROR, var1, var2, var3);
   }

   public void b(String var1, String var2) {
      this.a(SalesforceLogger.Level.WARN, var1, var2);
   }

   public void b(String var1, String var2, Throwable var3) {
      this.a(SalesforceLogger.Level.WARN, var1, var2, var3);
   }

   public void c(String var1, String var2) {
      this.a(SalesforceLogger.Level.INFO, var1, var2);
   }

   public void c(String var1, String var2, Throwable var3) {
      this.a(SalesforceLogger.Level.INFO, var1, var2, var3);
   }

   public void d(String var1, String var2) {
      this.a(SalesforceLogger.Level.DEBUG, var1, var2);
   }

   public void d(String var1, String var2, Throwable var3) {
      this.a(SalesforceLogger.Level.DEBUG, var1, var2, var3);
   }

   public enum Level {
      DEBUG,
      ERROR,
      INFO,
      OFF,
      VERBOSE,
      WARN;

      private static final SalesforceLogger.Level[] $VALUES = new SalesforceLogger.Level[]{
         SalesforceLogger.Level.OFF,
         SalesforceLogger.Level.ERROR,
         SalesforceLogger.Level.WARN,
         SalesforceLogger.Level.INFO,
         SalesforceLogger.Level.DEBUG,
         SalesforceLogger.Level.VERBOSE
      };
   }
}
