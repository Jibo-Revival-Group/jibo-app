package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.mixpanel.android.util.MPLog;
import java.lang.reflect.InvocationTargetException;

class SystemInformation {
   private static SystemInformation h;
   private static final Object i = new Object();
   private final Context a;
   private final Boolean b;
   private final Boolean c;
   private final DisplayMetrics d;
   private final String e;
   private final Integer f;
   private final String g;

   private SystemInformation(Context var1) {
      Object var5 = null;
      super();
      this.a = var1;
      PackageManager var6 = this.a.getPackageManager();

      String var3;
      Integer var21;
      label63: {
         int var2;
         label62: {
            label61: {
               try {
                  var4 = var6.getPackageInfo(this.a.getPackageName(), 0);
                  var3 = var4.versionName;
               } catch (NameNotFoundException var14) {
                  var3 = null;
                  break label61;
               }

               try {
                  var2 = var4.versionCode;
                  break label62;
               } catch (NameNotFoundException var13) {
               }
            }

            MPLog.d("MixpanelAPI.SysInfo", "System information constructed with a context that apparently doesn't exist.");
            var21 = null;
            break label63;
         }

         var21 = var2;
      }

      ApplicationInfo var7 = var1.getApplicationInfo();
      int var18 = var7.labelRes;
      this.e = var3;
      this.f = var21;
      String var15;
      if (var18 == 0) {
         if (var7.nonLocalizedLabel == null) {
            var15 = "Misc";
         } else {
            var15 = var7.nonLocalizedLabel.toString();
         }
      } else {
         var15 = var1.getString(var18);
      }

      this.g = var15;
      Class var16 = var6.getClass();

      try {
         var19 = var16.getMethod("hasSystemFeature", String.class);
      } catch (NoSuchMethodException var8) {
         var19 = null;
      }

      label52:
      if (var19 != null) {
         label50: {
            label49: {
               try {
                  var17 = (Boolean)var19.invoke(var6, "android.hardware.nfc");
               } catch (InvocationTargetException var11) {
                  var17 = null;
                  break label50;
               } catch (IllegalAccessException var12) {
                  var17 = null;
                  break label49;
               }

               try {
                  var20 = (Boolean)var19.invoke(var6, "android.hardware.telephony");
                  break label52;
               } catch (InvocationTargetException var9) {
                  break label50;
               } catch (IllegalAccessException var10) {
               }
            }

            MPLog.d("MixpanelAPI.SysInfo", "System version appeared to support PackageManager.hasSystemFeature, but we were unable to call it.");
            var20 = (Boolean)var5;
            break label52;
         }

         MPLog.d("MixpanelAPI.SysInfo", "System version appeared to support PackageManager.hasSystemFeature, but we were unable to call it.");
         var20 = (Boolean)var5;
      } else {
         var17 = null;
         var20 = (Boolean)var5;
      }

      this.b = var17;
      this.c = var20;
      this.d = new DisplayMetrics();
      ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay().getMetrics(this.d);
   }

   static SystemInformation a(Context param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/mixpanel/android/mpmetrics/SystemInformation.i Ljava/lang/Object;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/mixpanel/android/mpmetrics/SystemInformation.h Lcom/mixpanel/android/mpmetrics/SystemInformation;
      // 09: ifnonnull 1e
      // 0c: aload 0
      // 0d: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 10: astore 0
      // 11: new com/mixpanel/android/mpmetrics/SystemInformation
      // 14: astore 2
      // 15: aload 2
      // 16: aload 0
      // 17: invokespecial com/mixpanel/android/mpmetrics/SystemInformation.<init> (Landroid/content/Context;)V
      // 1a: aload 2
      // 1b: putstatic com/mixpanel/android/mpmetrics/SystemInformation.h Lcom/mixpanel/android/mpmetrics/SystemInformation;
      // 1e: aload 1
      // 1f: monitorexit
      // 20: getstatic com/mixpanel/android/mpmetrics/SystemInformation.h Lcom/mixpanel/android/mpmetrics/SystemInformation;
      // 23: areturn
      // 24: astore 0
      // 25: aload 1
      // 26: monitorexit
      // 27: aload 0
      // 28: athrow
      // try (4 -> 16): 20 null
      // try (16 -> 18): 20 null
      // try (21 -> 23): 20 null
   }

   public String a() {
      return this.e;
   }

   public Integer b() {
      return this.f;
   }

   public String c() {
      return this.g;
   }

   public boolean d() {
      return this.b;
   }

   public boolean e() {
      return this.c;
   }

   public DisplayMetrics f() {
      return this.d;
   }

   public String g() {
      TelephonyManager var1 = (TelephonyManager)this.a.getSystemService("phone");
      String var2;
      if (var1 != null) {
         var2 = var1.getNetworkOperatorName();
      } else {
         var2 = null;
      }

      return var2;
   }

   public Boolean h() {
      Boolean var2 = null;
      if (this.a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
         NetworkInfo var3 = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
         boolean var1;
         if (var3 != null && var3.getType() == 1 && var3.isConnected()) {
            var1 = true;
         } else {
            var1 = false;
         }

         var2 = var1;
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @SuppressLint("MissingPermission")
   public Boolean i() {
      Object var3 = null;
      Boolean var2 = (Boolean)var3;

      BluetoothAdapter var4;
      try {
         if (this.a.getPackageManager().checkPermission("android.permission.BLUETOOTH", this.a.getPackageName()) != 0) {
            return var2;
         }

         var4 = BluetoothAdapter.getDefaultAdapter();
      } catch (SecurityException var7) {
         var2 = var3;
         return (Boolean)var2;
      } catch (NoClassDefFoundError var8) {
         var2 = var3;
         return (Boolean)var2;
      }

      var2 = (Boolean)var3;
      if (var4 != null) {
         boolean var1;
         try {
            var1 = var4.isEnabled();
         } catch (SecurityException var5) {
            var2 = (Boolean)var3;
            return var2;
         } catch (NoClassDefFoundError var6) {
            var2 = (Boolean)var3;
            return var2;
         }

         var2 = var1;
      }

      return var2;
   }

   public String j() {
      String var1 = "none";
      if (VERSION.SDK_INT >= 18 && this.a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
         var1 = "ble";
      } else if (this.a.getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
         var1 = "classic";
      }

      return var1;
   }
}
