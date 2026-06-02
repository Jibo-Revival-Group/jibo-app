package com.google.android.gms.internal;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzbz;
import com.google.firebase.iid.FirebaseInstanceId;
import java.math.BigInteger;
import java.util.Locale;

public final class zzchh extends zzcjl {
   private String a;
   private String b;
   private int c;
   private String d;
   private String e;
   private long f;
   private long g;
   private int h;
   private String i;

   zzchh(zzcim var1) {
      super(var1);
   }

   private final String D() {
      this.c();

      String var1;
      try {
         var1 = FirebaseInstanceId.a().c();
      } catch (IllegalStateException var2) {
         this.t().A().a("Failed to retrieve Firebase Instance Id");
         var1 = null;
      }

      return var1;
   }

   final String A() {
      this.Q();
      return this.i;
   }

   final int B() {
      this.Q();
      return this.c;
   }

   final int C() {
      this.Q();
      return this.h;
   }

   final zzcgi a(String var1) {
      this.c();
      String var15 = this.z();
      String var17 = this.A();
      this.Q();
      String var14 = this.b;
      long var5 = this.B();
      this.Q();
      String var13 = this.d;
      this.Q();
      this.c();
      if (this.f == 0L) {
         this.f = this.p.o().b(this.l(), this.l().getPackageName());
      }

      long var7 = this.f;
      boolean var11 = this.p.B();
      boolean var9;
      if (!this.u().o) {
         var9 = true;
      } else {
         var9 = false;
      }

      String var12 = this.D();
      this.Q();
      long var3 = this.p.C();
      int var2 = this.C();
      Boolean var16 = this.v().b("google_analytics_adid_collection_enabled");
      boolean var10;
      if (var16 != null && !var16) {
         var10 = false;
      } else {
         var10 = true;
      }

      return new zzcgi(var15, var17, var14, var5, var13, 11910L, var7, var1, var11, var9, var12, 0L, var3, var2, Boolean.valueOf(var10));
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   protected final void d_() {
      byte var2 = 1;
      String var5 = "unknown";
      String var9 = "Unknown";
      int var3 = Integer.MIN_VALUE;
      String var6 = "Unknown";
      String var10 = this.l().getPackageName();
      PackageManager var11 = this.l().getPackageManager();
      int var1;
      String var7;
      String var8;
      if (var11 == null) {
         this.t().y().a("PackageManager is null, app identity information might be inaccurate. appId", zzchm.a(var10));
         var8 = var5;
         var7 = var9;
         var1 = var3;
         var5 = var6;
      } else {
         label159: {
            label154: {
               String var4;
               try {
                  var4 = var11.getInstallerPackageName(var10);
               } catch (IllegalArgumentException var23) {
                  this.t().y().a("Error retrieving app installer package name. appId", zzchm.a(var10));
                  break label154;
               }

               var5 = var4;
            }

            String var27;
            if (var5 == null) {
               var27 = "manual_install";
            } else {
               var27 = var5;
               if ("com.android.vending".equals(var5)) {
                  var27 = "";
               }
            }

            var8 = var6;
            var7 = var9;

            PackageInfo var12;
            try {
               var12 = var11.getPackageInfo(this.l().getPackageName(), 0);
            } catch (NameNotFoundException var22) {
               this.t().y().a("Error retrieving package info. appId, appName", zzchm.a(var10), var8);
               var5 = var8;
               var1 = var3;
               var8 = var27;
               break label159;
            }

            var5 = var6;
            var1 = var3;
            var7 = var9;
            var8 = var27;
            label147:
            if (var12 != null) {
               var8 = var6;
               var7 = var9;

               try {
                  var40 = var11.getApplicationLabel(var12.applicationInfo);
               } catch (NameNotFoundException var21) {
                  this.t().y().a("Error retrieving package info. appId, appName", zzchm.a(var10), var8);
                  var5 = var8;
                  var1 = var3;
                  var8 = var27;
                  break label147;
               }

               var5 = var6;
               var8 = var6;
               var7 = var9;

               label161: {
                  try {
                     if (TextUtils.isEmpty(var40)) {
                        break label161;
                     }
                  } catch (NameNotFoundException var20) {
                     this.t().y().a("Error retrieving package info. appId, appName", zzchm.a(var10), var8);
                     var5 = var8;
                     var1 = var3;
                     var8 = var27;
                     break label147;
                  }

                  var8 = var6;
                  var7 = var9;

                  try {
                     var5 = var40.toString();
                  } catch (NameNotFoundException var19) {
                     this.t().y().a("Error retrieving package info. appId, appName", zzchm.a(var10), var8);
                     var5 = var8;
                     var1 = var3;
                     var8 = var27;
                     break label147;
                  }
               }

               var8 = var5;
               var7 = var9;

               try {
                  var6 = var12.versionName;
               } catch (NameNotFoundException var18) {
                  this.t().y().a("Error retrieving package info. appId, appName", zzchm.a(var10), var8);
                  var5 = var8;
                  var1 = var3;
                  var8 = var27;
                  break label147;
               }

               var8 = var5;
               var7 = var6;

               try {
                  var1 = var12.versionCode;
               } catch (NameNotFoundException var17) {
                  this.t().y().a("Error retrieving package info. appId, appName", zzchm.a(var10), var8);
                  var5 = var8;
                  var1 = var3;
                  var8 = var27;
                  break label147;
               }

               var7 = var6;
               var8 = var27;
            }
         }
      }

      this.a = var10;
      this.d = var8;
      this.b = var7;
      this.c = var1;
      this.e = var5;
      this.f = 0L;
      Status var28 = zzbz.a(this.l());
      boolean var24;
      if (var28 != null && var28.c()) {
         var24 = 1;
      } else {
         var24 = 0;
      }

      if (!var24) {
         if (var28 == null) {
            this.t().y().a("GoogleService failed to initialize (no status)");
         } else {
            this.t().y().a("GoogleService failed to initialize, status", var28.d(), var28.b());
         }
      }

      if (var24) {
         Boolean var29 = this.v().b("firebase_analytics_collection_enabled");
         if (this.v().x()) {
            this.t().C().a("Collection disabled with firebase_analytics_collection_deactivated=1");
            var24 = (boolean)0;
         } else if (var29 != null && !var29) {
            this.t().C().a("Collection disabled with firebase_analytics_collection_enabled=0");
            var24 = (boolean)0;
         } else if (var29 == null && zzbz.b()) {
            this.t().C().a("Collection disabled with google_app_measurement_enable=0");
            var24 = (boolean)0;
         } else {
            this.t().E().a("Collection enabled");
            var24 = (boolean)1;
         }
      } else {
         var24 = (boolean)0;
      }

      this.i = "";
      this.g = 0L;

      label163: {
         try {
            var5 = zzbz.a();
         } catch (IllegalStateException var16) {
            this.t().y().a("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzchm.a(var10), var16);
            break label163;
         }

         String var30 = var5;

         label101: {
            try {
               if (!TextUtils.isEmpty(var5)) {
                  break label101;
               }
            } catch (IllegalStateException var15) {
               this.t().y().a("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzchm.a(var10), var15);
               break label163;
            }

            var30 = "";
         }

         try {
            this.i = var30;
         } catch (IllegalStateException var14) {
            this.t().y().a("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzchm.a(var10), var14);
            break label163;
         }

         if (var24) {
            try {
               this.t().E().a("App package, google app id", this.a, this.i);
            } catch (IllegalStateException var13) {
               this.t().y().a("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzchm.a(var10), var13);
            }
         }
      }

      if (VERSION.SDK_INT >= 16) {
         if (zzbhd.a(this.l())) {
            var24 = var2;
         } else {
            var24 = 0;
         }

         this.h = var24;
      } else {
         this.h = 0;
      }
   }

   @Override
   protected final boolean w() {
      return true;
   }

   final String y() {
      byte[] var1 = new byte[16];
      this.p().z().nextBytes(var1);
      return String.format(Locale.US, "%032x", new BigInteger(1, var1));
   }

   final String z() {
      this.Q();
      return this.a;
   }
}
