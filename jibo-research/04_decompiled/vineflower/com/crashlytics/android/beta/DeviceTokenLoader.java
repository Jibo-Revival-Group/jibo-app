package com.crashlytics.android.beta;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import io.fabric.sdk.android.services.cache.ValueLoader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DeviceTokenLoader implements ValueLoader<String> {
   public String a(Context param1) throws Exception {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: invokestatic java/lang/System.nanoTime ()J
      // 003: lstore 4
      // 005: ldc ""
      // 007: astore 8
      // 009: aconst_null
      // 00a: astore 6
      // 00c: aload 0
      // 00d: aload 1
      // 00e: ldc "io.crash.air"
      // 010: invokevirtual com/crashlytics/android/beta/DeviceTokenLoader.a (Landroid/content/Context;Ljava/lang/String;)Ljava/util/zip/ZipInputStream;
      // 013: astore 1
      // 014: aload 1
      // 015: astore 6
      // 017: aload 1
      // 018: astore 7
      // 01a: aload 0
      // 01b: aload 1
      // 01c: invokevirtual com/crashlytics/android/beta/DeviceTokenLoader.a (Ljava/util/zip/ZipInputStream;)Ljava/lang/String;
      // 01f: astore 9
      // 021: aload 9
      // 023: astore 6
      // 025: aload 6
      // 027: astore 7
      // 029: aload 1
      // 02a: ifnull 035
      // 02d: aload 1
      // 02e: invokevirtual java/util/zip/ZipInputStream.close ()V
      // 031: aload 6
      // 033: astore 7
      // 035: invokestatic java/lang/System.nanoTime ()J
      // 038: lload 4
      // 03a: lsub
      // 03b: l2d
      // 03c: ldc2_w 1000000.0
      // 03f: ddiv
      // 040: dstore 2
      // 041: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 044: ldc "Beta"
      // 046: new java/lang/StringBuilder
      // 049: dup
      // 04a: invokespecial java/lang/StringBuilder.<init> ()V
      // 04d: ldc "Beta device token load took "
      // 04f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 052: dload 2
      // 053: invokevirtual java/lang/StringBuilder.append (D)Ljava/lang/StringBuilder;
      // 056: ldc "ms"
      // 058: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 05b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 05e: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 063: aload 7
      // 065: areturn
      // 066: astore 1
      // 067: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 06a: ldc "Beta"
      // 06c: ldc "Failed to close the APK file"
      // 06e: aload 1
      // 06f: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 074: aload 6
      // 076: astore 7
      // 078: goto 035
      // 07b: astore 1
      // 07c: aload 6
      // 07e: astore 7
      // 080: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 083: ldc "Beta"
      // 085: ldc "Beta by Crashlytics app is not installed"
      // 087: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 08c: aload 8
      // 08e: astore 7
      // 090: aload 6
      // 092: ifnull 035
      // 095: aload 6
      // 097: invokevirtual java/util/zip/ZipInputStream.close ()V
      // 09a: aload 8
      // 09c: astore 7
      // 09e: goto 035
      // 0a1: astore 1
      // 0a2: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 0a5: ldc "Beta"
      // 0a7: ldc "Failed to close the APK file"
      // 0a9: aload 1
      // 0aa: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 0af: aload 8
      // 0b1: astore 7
      // 0b3: goto 035
      // 0b6: astore 7
      // 0b8: aconst_null
      // 0b9: astore 6
      // 0bb: aload 6
      // 0bd: astore 1
      // 0be: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 0c1: ldc "Beta"
      // 0c3: ldc "Failed to find the APK file"
      // 0c5: aload 7
      // 0c7: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 0cc: aload 8
      // 0ce: astore 7
      // 0d0: aload 6
      // 0d2: ifnull 035
      // 0d5: aload 6
      // 0d7: invokevirtual java/util/zip/ZipInputStream.close ()V
      // 0da: aload 8
      // 0dc: astore 7
      // 0de: goto 035
      // 0e1: astore 1
      // 0e2: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 0e5: ldc "Beta"
      // 0e7: ldc "Failed to close the APK file"
      // 0e9: aload 1
      // 0ea: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 0ef: aload 8
      // 0f1: astore 7
      // 0f3: goto 035
      // 0f6: astore 7
      // 0f8: aconst_null
      // 0f9: astore 6
      // 0fb: aload 6
      // 0fd: astore 1
      // 0fe: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 101: ldc "Beta"
      // 103: ldc "Failed to read the APK file"
      // 105: aload 7
      // 107: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 10c: aload 8
      // 10e: astore 7
      // 110: aload 6
      // 112: ifnull 035
      // 115: aload 6
      // 117: invokevirtual java/util/zip/ZipInputStream.close ()V
      // 11a: aload 8
      // 11c: astore 7
      // 11e: goto 035
      // 121: astore 1
      // 122: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 125: ldc "Beta"
      // 127: ldc "Failed to close the APK file"
      // 129: aload 1
      // 12a: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 12f: aload 8
      // 131: astore 7
      // 133: goto 035
      // 136: astore 6
      // 138: aconst_null
      // 139: astore 1
      // 13a: aload 1
      // 13b: ifnull 142
      // 13e: aload 1
      // 13f: invokevirtual java/util/zip/ZipInputStream.close ()V
      // 142: aload 6
      // 144: athrow
      // 145: astore 1
      // 146: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 149: ldc "Beta"
      // 14b: ldc "Failed to close the APK file"
      // 14d: aload 1
      // 14e: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 153: goto 142
      // 156: astore 6
      // 158: aload 7
      // 15a: astore 1
      // 15b: goto 13a
      // 15e: astore 6
      // 160: goto 13a
      // 163: astore 7
      // 165: aload 1
      // 166: astore 6
      // 168: goto 0fb
      // 16b: astore 7
      // 16d: aload 1
      // 16e: astore 6
      // 170: goto 0bb
      // try (6 -> 11): 60 android/content/pm/PackageManager$NameNotFoundException
      // try (6 -> 11): 85 java/io/FileNotFoundException
      // try (6 -> 11): 113 java/io/IOException
      // try (6 -> 11): 141 null
      // try (15 -> 19): 60 android/content/pm/PackageManager$NameNotFoundException
      // try (15 -> 19): 167 java/io/FileNotFoundException
      // try (15 -> 19): 163 java/io/IOException
      // try (15 -> 19): 157 null
      // try (25 -> 27): 51 java/io/IOException
      // try (63 -> 67): 157 null
      // try (71 -> 73): 76 java/io/IOException
      // try (90 -> 95): 161 null
      // try (99 -> 101): 104 java/io/IOException
      // try (118 -> 123): 161 null
      // try (127 -> 129): 132 java/io/IOException
      // try (146 -> 148): 150 java/io/IOException
   }

   String a(ZipInputStream var1) throws IOException {
      ZipEntry var2 = var1.getNextEntry();
      if (var2 != null) {
         String var3 = var2.getName();
         if (var3.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token=")) {
            return var3.substring("assets/com.crashlytics.android.beta/dirfactor-device-token=".length(), var3.length() - 1);
         }
      }

      return "";
   }

   ZipInputStream a(Context var1, String var2) throws NameNotFoundException, FileNotFoundException {
      return new ZipInputStream(new FileInputStream(var1.getPackageManager().getApplicationInfo(var2, 0).sourceDir));
   }
}
