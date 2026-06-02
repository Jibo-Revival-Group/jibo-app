package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.common.util.zzx;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class zzp {
   @Deprecated
   public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
   @Deprecated
   public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 11910000;
   public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
   private static boolean zzflj = false;
   private static boolean zzflk = false;
   private static boolean zzfll = false;
   private static boolean zzflm = false;
   static final AtomicBoolean zzfln = new AtomicBoolean();
   private static final AtomicBoolean zzflo = new AtomicBoolean();

   zzp() {
   }

   @Deprecated
   public static PendingIntent getErrorPendingIntent(int var0, Context var1, int var2) {
      return zzf.b().a(var1, var0, var2);
   }

   @Deprecated
   public static String getErrorString(int var0) {
      return ConnectionResult.a(var0);
   }

   public static Context getRemoteContext(Context var0) {
      try {
         var0 = var0.createPackageContext("com.google.android.gms", 3);
      } catch (NameNotFoundException var1) {
         var0 = null;
      }

      return var0;
   }

   public static Resources getRemoteResource(Context var0) {
      try {
         var2 = var0.getPackageManager().getResourcesForApplication("com.google.android.gms");
      } catch (NameNotFoundException var1) {
         var2 = null;
      }

      return var2;
   }

   @Deprecated
   public static int isGooglePlayServicesAvailable(Context var0) {
      int var2 = 9;
      PackageManager var4 = var0.getPackageManager();

      try {
         var0.getResources().getString(R.string.common_google_play_services_unknown_issue);
      } catch (Throwable var6) {
         Log.e(
            "GooglePlayServicesUtil",
            "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included."
         );
      }

      if (!"com.google.android.gms".equals(var0.getPackageName()) && !zzflo.get()) {
         int var1 = zzbf.b(var0);
         if (var1 == 0) {
            throw new IllegalStateException(
               "A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />"
            );
         }

         if (var1 != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
            var2 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
            throw new IllegalStateException(
               new StringBuilder(String.valueOf("com.google.android.gms.version").length() + 290)
                  .append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ")
                  .append(var2)
                  .append(" but found ")
                  .append(var1)
                  .append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"")
                  .append("com.google.android.gms.version")
                  .append("\" android:value=\"@integer/google_play_services_version\" />")
                  .toString()
            );
         }
      }

      boolean var12;
      if (!com.google.android.gms.common.util.zzi.b(var0) && !com.google.android.gms.common.util.zzi.d(var0)) {
         var12 = 1;
      } else {
         var12 = 0;
      }

      PackageInfo var3 = null;
      if (var12) {
         try {
            var3 = var4.getPackageInfo("com.android.vending", 8256);
         } catch (NameNotFoundException var9) {
            Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
            return var2;
         }
      }

      PackageInfo var5;
      try {
         var5 = var4.getPackageInfo("com.google.android.gms", 64);
      } catch (NameNotFoundException var8) {
         Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
         return 1;
      }

      zzq.a(var0);
      if (var12) {
         zzh var10 = zzq.a(var3, zzk.a);
         if (var10 == null) {
            Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
            return var2;
         }

         if (zzq.a(var5, var10) == null) {
            Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
            return var2;
         }
      } else if (zzq.a(var5, zzk.a) == null) {
         Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
         var12 = (byte)var2;
         return var12;
      }

      var12 = GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000;
      byte var13;
      if (var5.versionCode / 1000 < var12) {
         var2 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
         var13 = var5.versionCode;
         Log.w(
            "GooglePlayServicesUtil",
            new StringBuilder(77).append("Google Play services out of date.  Requires ").append(var2).append(" but found ").append(var13).toString()
         );
         var13 = 2;
      } else {
         ApplicationInfo var18 = var5.applicationInfo;
         ApplicationInfo var11 = var18;
         if (var18 == null) {
            try {
               var11 = var4.getApplicationInfo("com.google.android.gms", 0);
            } catch (NameNotFoundException var7) {
               Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", var7);
               byte var19 = 1;
               return var19;
            }
         }

         if (!var11.enabled) {
            var13 = 3;
         } else {
            var13 = 0;
         }
      }

      return var13;
   }

   @Deprecated
   public static boolean isUserRecoverableError(int var0) {
      boolean var1;
      switch (var0) {
         case 1:
         case 2:
         case 3:
         case 9:
            var1 = true;
            break;
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         default:
            var1 = false;
      }

      return var1;
   }

   @Deprecated
   @TargetApi(19)
   public static boolean zzb(Context var0, int var1, String var2) {
      return zzx.a(var0, var1, var2);
   }

   @Deprecated
   public static void zzbp(Context var0) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
      int var1 = zzf.b().a(var0);
      if (var1 != 0) {
         zzf.b();
         Intent var2 = zzf.a(var0, var1, "e");
         Log.e("GooglePlayServicesUtil", new StringBuilder(57).append("GooglePlayServices not available due to error ").append(var1).toString());
         if (var2 == null) {
            throw new GooglePlayServicesNotAvailableException(var1);
         } else {
            throw new GooglePlayServicesRepairableException(var1, "Google Play Services not available", var2);
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Deprecated
   public static void zzce(Context var0) {
      if (!zzfln.getAndSet(true)) {
         try {
            var3 = (NotificationManager)var0.getSystemService("notification");
         } catch (SecurityException var2) {
            return;
         }

         if (var3 != null) {
            try {
               var3.cancel(10436);
            } catch (SecurityException var1) {
            }
         }
      }
   }

   @Deprecated
   public static int zzcf(Context var0) {
      byte var1 = 0;

      try {
         var3 = var0.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      } catch (NameNotFoundException var2) {
         Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
         return var1;
      }

      return var3.versionCode;
   }

   public static boolean zzch(Context param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: getstatic com/google/android/gms/common/zzp.zzflm Z
      // 05: ifne 38
      // 08: aload 0
      // 09: invokestatic com/google/android/gms/internal/zzbhf.a (Landroid/content/Context;)Lcom/google/android/gms/internal/zzbhe;
      // 0c: ldc "com.google.android.gms"
      // 0e: bipush 64
      // 10: invokevirtual com/google/android/gms/internal/zzbhe.b (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
      // 13: astore 2
      // 14: aload 2
      // 15: ifnull 4e
      // 18: aload 0
      // 19: invokestatic com/google/android/gms/common/zzq.a (Landroid/content/Context;)Lcom/google/android/gms/common/zzq;
      // 1c: pop
      // 1d: aload 2
      // 1e: bipush 1
      // 1f: anewarray 209
      // 22: dup
      // 23: bipush 0
      // 24: getstatic com/google/android/gms/common/zzk.a [Lcom/google/android/gms/common/zzh;
      // 27: bipush 1
      // 28: aaload
      // 29: aastore
      // 2a: invokestatic com/google/android/gms/common/zzq.a (Landroid/content/pm/PackageInfo;[Lcom/google/android/gms/common/zzh;)Lcom/google/android/gms/common/zzh;
      // 2d: ifnull 4e
      // 30: bipush 1
      // 31: putstatic com/google/android/gms/common/zzp.zzfll Z
      // 34: bipush 1
      // 35: putstatic com/google/android/gms/common/zzp.zzflm Z
      // 38: getstatic com/google/android/gms/common/zzp.zzfll Z
      // 3b: ifne 4a
      // 3e: ldc_w "user"
      // 41: getstatic android/os/Build.TYPE Ljava/lang/String;
      // 44: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 47: ifne 4c
      // 4a: bipush 1
      // 4b: istore 1
      // 4c: iload 1
      // 4d: ireturn
      // 4e: bipush 0
      // 4f: putstatic com/google/android/gms/common/zzp.zzfll Z
      // 52: goto 34
      // 55: astore 0
      // 56: ldc "GooglePlayServicesUtil"
      // 58: ldc_w "Cannot find Google Play services package name."
      // 5b: aload 0
      // 5c: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 5f: pop
      // 60: bipush 1
      // 61: putstatic com/google/android/gms/common/zzp.zzflm Z
      // 64: goto 38
      // 67: astore 0
      // 68: bipush 1
      // 69: putstatic com/google/android/gms/common/zzp.zzflm Z
      // 6c: aload 0
      // 6d: athrow
      // try (4 -> 10): 43 android/content/pm/PackageManager$NameNotFoundException
      // try (4 -> 10): 52 null
      // try (12 -> 28): 43 android/content/pm/PackageManager$NameNotFoundException
      // try (12 -> 28): 52 null
      // try (40 -> 42): 43 android/content/pm/PackageManager$NameNotFoundException
      // try (40 -> 42): 52 null
      // try (44 -> 49): 52 null
   }

   @Deprecated
   public static boolean zze(Context var0, int var1) {
      boolean var2 = true;
      if (var1 != 18) {
         if (var1 == 1) {
            var2 = zzv(var0, "com.google.android.gms");
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Deprecated
   public static boolean zzf(Context var0, int var1) {
      return zzx.a(var0, var1);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @TargetApi(21)
   static boolean zzv(Context var0, String var1) {
      boolean var3 = var1.equals("com.google.android.gms");
      if (com.google.android.gms.common.util.zzq.f()) {
         List var4;
         try {
            var4 = var0.getPackageManager().getPackageInstaller().getAllSessions();
         } catch (Exception var9) {
            return false;
         }

         Iterator var14 = var4.iterator();

         while (var14.hasNext()) {
            if (var1.equals(((SessionInfo)var14.next()).getAppPackageName())) {
               var3 = true;
               return var3;
            }
         }
      }

      PackageManager var15 = var0.getPackageManager();

      try {
         var11 = var15.getApplicationInfo(var1, 8192);
      } catch (NameNotFoundException var8) {
         return false;
      }

      if (var3) {
         try {
            var3 = var11.enabled;
         } catch (NameNotFoundException var5) {
            var3 = false;
         }
      } else {
         label55: {
            boolean var2;
            label54: {
               label53: {
                  try {
                     if (!var11.enabled) {
                        break label55;
                     }

                     if (!com.google.android.gms.common.util.zzq.c()) {
                        break label53;
                     }

                     var10 = ((UserManager)var0.getSystemService("user")).getApplicationRestrictions(var0.getPackageName());
                  } catch (NameNotFoundException var7) {
                     var3 = false;
                     return var3;
                  }

                  if (var10 != null) {
                     try {
                        var3 = "true".equals(var10.getString("restricted_profile"));
                     } catch (NameNotFoundException var6) {
                        var3 = false;
                        return var3;
                     }

                     if (var3) {
                        var2 = true;
                        break label54;
                     }
                  }
               }

               var2 = false;
            }

            if (!var2) {
               var3 = true;
               return var3;
            }
         }

         var3 = false;
      }

      return var3;
   }
}
