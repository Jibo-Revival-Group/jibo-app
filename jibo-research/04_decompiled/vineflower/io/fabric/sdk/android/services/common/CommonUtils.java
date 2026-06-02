package io.fabric.sdk.android.services.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class CommonUtils {
   public static final Comparator<File> a = new Comparator<File>() {
      public int a(File var1, File var2) {
         return (int)(var1.lastModified() - var2.lastModified());
      }
   };
   private static Boolean b = null;
   private static final char[] c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
   private static long d = -1L;

   public static int a() {
      return CommonUtils.Architecture.getValue().ordinal();
   }

   public static int a(Context var0, String var1, String var2) {
      return var0.getResources().getIdentifier(var1, var2, j(var0));
   }

   public static int a(Context var0, boolean var1) {
      Float var3 = c(var0);
      byte var2;
      if (var1 && var3 != null) {
         if (var3.floatValue() >= 99.0) {
            var2 = 3;
         } else if (var3.floatValue() < 99.0) {
            var2 = 2;
         } else {
            var2 = 0;
         }
      } else {
         var2 = 1;
      }

      return var2;
   }

   static long a(String var0, String var1, int var2) {
      return Long.parseLong(var0.split(var1)[0].trim()) * var2;
   }

   public static RunningAppProcessInfo a(String var0, Context var1) {
      List var4 = ((ActivityManager)var1.getSystemService("activity")).getRunningAppProcesses();
      if (var4 != null) {
         for (RunningAppProcessInfo var5 : var4) {
            if (var5.processName.equals(var0)) {
               return var5;
            }
         }
      }

      return null;
   }

   public static SharedPreferences a(Context var0) {
      return var0.getSharedPreferences("com.crashlytics.prefs", 0);
   }

   public static String a(int var0) {
      if (var0 < 0) {
         throw new IllegalArgumentException("value must be zero or greater");
      } else {
         return String.format(Locale.US, "%1$10s", var0).replace(' ', '0');
      }
   }

   public static String a(File param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 5
      // 03: aconst_null
      // 04: astore 4
      // 06: aload 5
      // 08: astore 2
      // 09: aload 0
      // 0a: invokevirtual java/io/File.exists ()Z
      // 0d: ifeq 65
      // 10: new java/io/BufferedReader
      // 13: astore 3
      // 14: new java/io/FileReader
      // 17: astore 2
      // 18: aload 2
      // 19: aload 0
      // 1a: invokespecial java/io/FileReader.<init> (Ljava/io/File;)V
      // 1d: aload 3
      // 1e: aload 2
      // 1f: sipush 1024
      // 22: invokespecial java/io/BufferedReader.<init> (Ljava/io/Reader;I)V
      // 25: aload 3
      // 26: astore 2
      // 27: aload 3
      // 28: invokevirtual java/io/BufferedReader.readLine ()Ljava/lang/String;
      // 2b: astore 6
      // 2d: aload 4
      // 2f: astore 2
      // 30: aload 6
      // 32: ifnull 5f
      // 35: aload 3
      // 36: astore 2
      // 37: ldc "\\s*:\\s*"
      // 39: invokestatic java/util/regex/Pattern.compile (Ljava/lang/String;)Ljava/util/regex/Pattern;
      // 3c: aload 6
      // 3e: bipush 2
      // 3f: invokevirtual java/util/regex/Pattern.split (Ljava/lang/CharSequence;I)[Ljava/lang/String;
      // 42: astore 6
      // 44: aload 3
      // 45: astore 2
      // 46: aload 6
      // 48: arraylength
      // 49: bipush 1
      // 4a: if_icmple 25
      // 4d: aload 3
      // 4e: astore 2
      // 4f: aload 6
      // 51: bipush 0
      // 52: aaload
      // 53: aload 1
      // 54: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 57: ifeq 25
      // 5a: aload 6
      // 5c: bipush 1
      // 5d: aaload
      // 5e: astore 2
      // 5f: aload 3
      // 60: ldc "Failed to close system file reader."
      // 62: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 65: aload 2
      // 66: areturn
      // 67: astore 4
      // 69: aconst_null
      // 6a: astore 1
      // 6b: aload 1
      // 6c: astore 2
      // 6d: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 70: astore 3
      // 71: aload 1
      // 72: astore 2
      // 73: new java/lang/StringBuilder
      // 76: astore 6
      // 78: aload 1
      // 79: astore 2
      // 7a: aload 6
      // 7c: invokespecial java/lang/StringBuilder.<init> ()V
      // 7f: aload 1
      // 80: astore 2
      // 81: aload 3
      // 82: ldc "Fabric"
      // 84: aload 6
      // 86: ldc "Error parsing "
      // 88: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 8b: aload 0
      // 8c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 8f: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 92: aload 4
      // 94: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 99: aload 1
      // 9a: ldc "Failed to close system file reader."
      // 9c: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 9f: aload 5
      // a1: astore 2
      // a2: goto 65
      // a5: astore 0
      // a6: aconst_null
      // a7: astore 2
      // a8: aload 2
      // a9: ldc "Failed to close system file reader."
      // ab: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // ae: aload 0
      // af: athrow
      // b0: astore 0
      // b1: goto a8
      // b4: astore 4
      // b6: aload 3
      // b7: astore 1
      // b8: goto 6b
      // try (9 -> 20): 60 java/lang/Exception
      // try (9 -> 20): 93 null
      // try (22 -> 25): 103 java/lang/Exception
      // try (22 -> 25): 101 null
      // try (31 -> 37): 103 java/lang/Exception
      // try (31 -> 37): 101 null
      // try (39 -> 43): 103 java/lang/Exception
      // try (39 -> 43): 101 null
      // try (45 -> 51): 103 java/lang/Exception
      // try (45 -> 51): 101 null
      // try (65 -> 67): 101 null
      // try (69 -> 71): 101 null
      // try (73 -> 75): 101 null
      // try (77 -> 87): 101 null
   }

   public static String a(InputStream var0) throws IOException {
      Scanner var1 = new Scanner(var0).useDelimiter("\\A");
      String var2;
      if (var1.hasNext()) {
         var2 = var1.next();
      } else {
         var2 = "";
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static String a(InputStream var0, String var1) {
      MessageDigest var3;
      try {
         var3 = MessageDigest.getInstance("SHA-1");
         var9 = new byte[1024];
      } catch (Exception var7) {
         Fabric.h().e("Fabric", "Could not calculate hash for app icon.", var7);
         return "";
      }

      while (true) {
         int var2;
         try {
            var2 = var0.read(var9);
         } catch (Exception var5) {
            Fabric.h().e("Fabric", "Could not calculate hash for app icon.", var5);
            var8 = "";
            break;
         }

         if (var2 == -1) {
            try {
               var8 = a(var3.digest());
            } catch (Exception var4) {
               Fabric.h().e("Fabric", "Could not calculate hash for app icon.", var4);
               var8 = "";
            }
            break;
         }

         try {
            var3.update(var9, 0, var2);
         } catch (Exception var6) {
            Fabric.h().e("Fabric", "Could not calculate hash for app icon.", var6);
            var8 = "";
            break;
         }
      }

      return var8;
   }

   public static String a(String var0) {
      return a(var0, "SHA-1");
   }

   private static String a(String var0, String var1) {
      return a(var0.getBytes(), var1);
   }

   public static String a(byte[] var0) {
      char[] var3 = new char[var0.length * 2];

      for (int var1 = 0; var1 < var0.length; var1++) {
         int var2 = var0[var1] & 255;
         var3[var1 * 2] = c[var2 >>> 4];
         var3[var1 * 2 + 1] = c[var2 & 15];
      }

      return new String(var3);
   }

   private static String a(byte[] var0, String var1) {
      MessageDigest var2;
      try {
         var2 = MessageDigest.getInstance(var1);
      } catch (NoSuchAlgorithmException var3) {
         Fabric.h().e("Fabric", "Could not create hashing algorithm: " + var1 + ", returning empty string.", var3);
         return "";
      }

      var2.update(var0);
      return a(var2.digest());
   }

   public static String a(String... var0) {
      String var5;
      if (var0 != null && var0.length != 0) {
         ArrayList var3 = new ArrayList();

         for (String var4 : var0) {
            if (var4 != null) {
               var3.add(var4.replace("-", "").toLowerCase(Locale.US));
            }
         }

         Collections.sort(var3);
         StringBuilder var6 = new StringBuilder();
         Iterator var8 = var3.iterator();

         while (var8.hasNext()) {
            var6.append((String)var8.next());
         }

         String var7 = var6.toString();
         if (var7.length() > 0) {
            var5 = a(var7);
         } else {
            var5 = null;
         }
      } else {
         var5 = null;
      }

      return var5;
   }

   public static void a(Context var0, int var1, String var2, String var3) {
      if (e(var0)) {
         Fabric.h().a(var1, "Fabric", var3);
      }
   }

   public static void a(Context var0, String var1) {
      if (e(var0)) {
         Fabric.h().a("Fabric", var1);
      }
   }

   public static void a(Context var0, String var1, Throwable var2) {
      if (e(var0)) {
         Fabric.h().e("Fabric", var1);
      }
   }

   public static void a(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (RuntimeException var1) {
            throw var1;
         } catch (Exception var2) {
         }
      }
   }

   public static void a(Closeable var0, String var1) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            Fabric.h().e("Fabric", var1, var2);
         }
      }
   }

   public static void a(Flushable var0, String var1) {
      if (var0 != null) {
         try {
            var0.flush();
         } catch (IOException var2) {
            Fabric.h().e("Fabric", var1, var2);
         }
      }
   }

   public static void a(InputStream var0, OutputStream var1, byte[] var2) throws IOException {
      while (true) {
         int var3 = var0.read(var2);
         if (var3 == -1) {
            return;
         }

         var1.write(var2, 0, var3);
      }
   }

   public static boolean a(Context var0, String var1, boolean var2) {
      boolean var4 = var2;
      if (var0 != null) {
         Resources var5 = var0.getResources();
         var4 = var2;
         if (var5 != null) {
            int var3 = a(var0, var1, "bool");
            if (var3 > 0) {
               var4 = var5.getBoolean(var3);
            } else {
               var3 = a(var0, var1, "string");
               var4 = var2;
               if (var3 > 0) {
                  var4 = Boolean.parseBoolean(var0.getString(var3));
               }
            }
         }
      }

      return var4;
   }

   public static long b() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc io/fabric/sdk/android/services/common/CommonUtils
      // 02: monitorenter
      // 03: getstatic io/fabric/sdk/android/services/common/CommonUtils.d J
      // 06: ldc2_w -1
      // 09: lcmp
      // 0a: ifne 55
      // 0d: lconst_0
      // 0e: lstore 2
      // 0f: new java/io/File
      // 12: astore 4
      // 14: aload 4
      // 16: ldc_w "/proc/meminfo"
      // 19: invokespecial java/io/File.<init> (Ljava/lang/String;)V
      // 1c: aload 4
      // 1e: ldc_w "MemTotal"
      // 21: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
      // 24: astore 4
      // 26: lload 2
      // 27: lstore 0
      // 28: aload 4
      // 2a: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 2d: ifne 51
      // 30: aload 4
      // 32: getstatic java/util/Locale.US Ljava/util/Locale;
      // 35: invokevirtual java/lang/String.toUpperCase (Ljava/util/Locale;)Ljava/lang/String;
      // 38: astore 4
      // 3a: aload 4
      // 3c: ldc_w "KB"
      // 3f: invokevirtual java/lang/String.endsWith (Ljava/lang/String;)Z
      // 42: ifeq 5e
      // 45: aload 4
      // 47: ldc_w "KB"
      // 4a: sipush 1024
      // 4d: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/lang/String;Ljava/lang/String;I)J
      // 50: lstore 0
      // 51: lload 0
      // 52: putstatic io/fabric/sdk/android/services/common/CommonUtils.d J
      // 55: getstatic io/fabric/sdk/android/services/common/CommonUtils.d J
      // 58: lstore 0
      // 59: ldc io/fabric/sdk/android/services/common/CommonUtils
      // 5b: monitorexit
      // 5c: lload 0
      // 5d: lreturn
      // 5e: aload 4
      // 60: ldc_w "MB"
      // 63: invokevirtual java/lang/String.endsWith (Ljava/lang/String;)Z
      // 66: ifeq 78
      // 69: aload 4
      // 6b: ldc_w "MB"
      // 6e: ldc_w 1048576
      // 71: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/lang/String;Ljava/lang/String;I)J
      // 74: lstore 0
      // 75: goto 51
      // 78: aload 4
      // 7a: ldc_w "GB"
      // 7d: invokevirtual java/lang/String.endsWith (Ljava/lang/String;)Z
      // 80: ifeq 92
      // 83: aload 4
      // 85: ldc_w "GB"
      // 88: ldc_w 1073741824
      // 8b: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/lang/String;Ljava/lang/String;I)J
      // 8e: lstore 0
      // 8f: goto 51
      // 92: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 95: astore 5
      // 97: new java/lang/StringBuilder
      // 9a: astore 6
      // 9c: aload 6
      // 9e: invokespecial java/lang/StringBuilder.<init> ()V
      // a1: aload 5
      // a3: ldc "Fabric"
      // a5: aload 6
      // a7: ldc_w "Unexpected meminfo format while computing RAM: "
      // aa: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // ad: aload 4
      // af: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // b2: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // b5: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // ba: lload 2
      // bb: lstore 0
      // bc: goto 51
      // bf: astore 5
      // c1: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // c4: astore 7
      // c6: new java/lang/StringBuilder
      // c9: astore 6
      // cb: aload 6
      // cd: invokespecial java/lang/StringBuilder.<init> ()V
      // d0: aload 7
      // d2: ldc "Fabric"
      // d4: aload 6
      // d6: ldc_w "Unexpected meminfo format while computing RAM: "
      // d9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // dc: aload 4
      // de: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // e1: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // e4: aload 5
      // e6: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // eb: lload 2
      // ec: lstore 0
      // ed: goto 51
      // f0: astore 4
      // f2: ldc io/fabric/sdk/android/services/common/CommonUtils
      // f4: monitorexit
      // f5: aload 4
      // f7: athrow
      // try (2 -> 6): 101 null
      // try (8 -> 17): 101 null
      // try (19 -> 26): 101 null
      // try (26 -> 35): 81 java/lang/NumberFormatException
      // try (26 -> 35): 101 null
      // try (35 -> 37): 101 null
      // try (37 -> 39): 101 null
      // try (43 -> 52): 81 java/lang/NumberFormatException
      // try (43 -> 52): 101 null
      // try (53 -> 62): 81 java/lang/NumberFormatException
      // try (53 -> 62): 101 null
      // try (63 -> 78): 81 java/lang/NumberFormatException
      // try (63 -> 78): 101 null
      // try (82 -> 98): 101 null
   }

   public static long b(Context var0) {
      MemoryInfo var1 = new MemoryInfo();
      ((ActivityManager)var0.getSystemService("activity")).getMemoryInfo(var1);
      return var1.availMem;
   }

   public static long b(String var0) {
      StatFs var3 = new StatFs(var0);
      long var1 = var3.getBlockSize();
      return var3.getBlockCount() * var1 - var3.getAvailableBlocks() * var1;
   }

   public static String b(Context var0, String var1) {
      int var2 = a(var0, var1, "string");
      String var3;
      if (var2 > 0) {
         var3 = var0.getString(var2);
      } else {
         var3 = "";
      }

      return var3;
   }

   public static String b(InputStream var0) {
      return a(var0, "SHA-1");
   }

   public static Float c(Context var0) {
      Object var3 = null;
      Intent var4 = var0.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      Float var5;
      if (var4 == null) {
         var5 = (Float)var3;
      } else {
         int var1 = var4.getIntExtra("level", -1);
         int var2 = var4.getIntExtra("scale", -1);
         var5 = (float)var1 / var2;
      }

      return var5;
   }

   public static boolean c() {
      boolean var0;
      if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger()) {
         var0 = false;
      } else {
         var0 = true;
      }

      return var0;
   }

   public static boolean c(Context var0, String var1) {
      boolean var2;
      if (var0.checkCallingOrSelfPermission(var1) == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public static boolean c(String var0) {
      boolean var1;
      if (var0 != null && var0.length() != 0) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean d(Context var0) {
      boolean var1 = false;
      if (!f(var0)) {
         if (((SensorManager)var0.getSystemService("sensor")).getDefaultSensor(8) != null) {
            var1 = true;
         } else {
            var1 = false;
         }
      }

      return var1;
   }

   public static boolean e(Context var0) {
      if (b == null) {
         b = a(var0, "com.crashlytics.Trace", false);
      }

      return b;
   }

   public static boolean f(Context var0) {
      String var2 = Secure.getString(var0.getContentResolver(), "android_id");
      boolean var1;
      if (!"sdk".equals(Build.PRODUCT) && !"google_sdk".equals(Build.PRODUCT) && var2 != null) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean g(Context var0) {
      boolean var2 = true;
      boolean var3 = f(var0);
      String var4 = Build.TAGS;
      boolean var1;
      if (!var3 && var4 != null && var4.contains("test-keys")) {
         var1 = var2;
      } else {
         var1 = var2;
         if (!new File("/system/app/Superuser.apk").exists()) {
            File var5 = new File("/system/xbin/su");
            if (!var3) {
               var1 = var2;
               if (var5.exists()) {
                  return var1;
               }
            }

            var1 = false;
         }
      }

      return var1;
   }

   public static int h(Context var0) {
      int var2 = 0;
      if (f(var0)) {
         var2 = 1;
      }

      int var1 = var2;
      if (g(var0)) {
         var1 = var2 | 2;
      }

      var2 = var1;
      if (c()) {
         var2 = var1 | 4;
      }

      return var2;
   }

   public static boolean i(Context var0) {
      boolean var1;
      if ((var0.getApplicationInfo().flags & 2) != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static String j(Context var0) {
      int var1 = var0.getApplicationContext().getApplicationInfo().icon;
      String var2;
      if (var1 > 0) {
         var2 = var0.getResources().getResourcePackageName(var1);
      } else {
         var2 = var0.getPackageName();
      }

      return var2;
   }

   public static String k(Context param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 4
      // 03: aconst_null
      // 04: astore 3
      // 05: aload 0
      // 06: invokevirtual android/content/Context.getResources ()Landroid/content/res/Resources;
      // 09: aload 0
      // 0a: invokestatic io/fabric/sdk/android/services/common/CommonUtils.l (Landroid/content/Context;)I
      // 0d: invokevirtual android/content/res/Resources.openRawResource (I)Ljava/io/InputStream;
      // 10: astore 2
      // 11: aload 2
      // 12: astore 0
      // 13: aload 2
      // 14: invokestatic io/fabric/sdk/android/services/common/CommonUtils.b (Ljava/io/InputStream;)Ljava/lang/String;
      // 17: astore 5
      // 19: aload 2
      // 1a: astore 0
      // 1b: aload 5
      // 1d: invokestatic io/fabric/sdk/android/services/common/CommonUtils.c (Ljava/lang/String;)Z
      // 20: istore 1
      // 21: iload 1
      // 22: ifeq 30
      // 25: aload 3
      // 26: astore 0
      // 27: aload 2
      // 28: ldc_w "Failed to close icon input stream."
      // 2b: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 2e: aload 0
      // 2f: areturn
      // 30: aload 5
      // 32: astore 0
      // 33: goto 27
      // 36: astore 3
      // 37: aconst_null
      // 38: astore 2
      // 39: aload 2
      // 3a: astore 0
      // 3b: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 3e: ldc "Fabric"
      // 40: ldc_w "Could not calculate hash for app icon."
      // 43: aload 3
      // 44: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 49: aload 2
      // 4a: ldc_w "Failed to close icon input stream."
      // 4d: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 50: aload 4
      // 52: astore 0
      // 53: goto 2e
      // 56: astore 0
      // 57: aconst_null
      // 58: astore 3
      // 59: aload 0
      // 5a: astore 2
      // 5b: aload 3
      // 5c: ldc_w "Failed to close icon input stream."
      // 5f: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 62: aload 2
      // 63: athrow
      // 64: astore 2
      // 65: aload 0
      // 66: astore 3
      // 67: goto 5b
      // 6a: astore 3
      // 6b: goto 39
      // try (4 -> 10): 32 java/lang/Exception
      // try (4 -> 10): 48 null
      // try (12 -> 15): 62 java/lang/Exception
      // try (12 -> 15): 58 null
      // try (17 -> 20): 62 java/lang/Exception
      // try (17 -> 20): 58 null
      // try (37 -> 42): 58 null
   }

   public static int l(Context var0) {
      return var0.getApplicationContext().getApplicationInfo().icon;
   }

   public static String m(Context var0) {
      String var3 = null;
      int var2 = a(var0, "io.fabric.android.build_id", "string");
      int var1 = var2;
      if (var2 == 0) {
         var1 = a(var0, "com.crashlytics.android.build_id", "string");
      }

      if (var1 != 0) {
         var3 = var0.getResources().getString(var1);
         Fabric.h().a("Fabric", "Build ID is: " + var3);
      }

      return var3;
   }

   public static boolean n(Context var0) {
      boolean var1;
      if (c(var0, "android.permission.ACCESS_NETWORK_STATE")) {
         NetworkInfo var2 = ((ConnectivityManager)var0.getSystemService("connectivity")).getActiveNetworkInfo();
         if (var2 != null && var2.isConnectedOrConnecting()) {
            var1 = true;
         } else {
            var1 = false;
         }
      } else {
         var1 = true;
      }

      return var1;
   }

   enum Architecture {
      ARM64,
      ARMV6,
      ARMV7,
      ARMV7S,
      ARM_UNKNOWN,
      PPC,
      PPC64,
      UNKNOWN,
      X86_32,
      X86_64;

      private static final CommonUtils.Architecture[] $VALUES = new CommonUtils.Architecture[]{
         CommonUtils.Architecture.X86_32,
         CommonUtils.Architecture.X86_64,
         CommonUtils.Architecture.ARM_UNKNOWN,
         CommonUtils.Architecture.PPC,
         CommonUtils.Architecture.PPC64,
         CommonUtils.Architecture.ARMV6,
         CommonUtils.Architecture.ARMV7,
         CommonUtils.Architecture.UNKNOWN,
         CommonUtils.Architecture.ARMV7S,
         CommonUtils.Architecture.ARM64
      };
      private static final Map<String, CommonUtils.Architecture> matcher = new HashMap<>(4);

      static {
         matcher.put("armeabi-v7a", ARMV7);
         matcher.put("armeabi", ARMV6);
         matcher.put("arm64-v8a", ARM64);
         matcher.put("x86", X86_32);
      }

      static CommonUtils.Architecture getValue() {
         String var0 = Build.CPU_ABI;
         CommonUtils.Architecture var2;
         if (TextUtils.isEmpty(var0)) {
            Fabric.h().a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
            var2 = UNKNOWN;
         } else {
            var0 = var0.toLowerCase(Locale.US);
            CommonUtils.Architecture var1 = matcher.get(var0);
            var2 = var1;
            if (var1 == null) {
               var2 = UNKNOWN;
            }
         }

         return var2;
      }
   }
}
