package io.fabric.sdk.android;

import android.os.SystemClock;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class FabricKitsFinder implements Callable<Map<String, KitInfo>> {
   final String a;

   FabricKitsFinder(String var1) {
      this.a = var1;
   }

   private KitInfo a(ZipEntry param1, ZipFile param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 2
      // 01: aload 1
      // 02: invokevirtual java/util/zip/ZipFile.getInputStream (Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
      // 05: astore 3
      // 06: aload 3
      // 07: astore 2
      // 08: new java/util/Properties
      // 0b: astore 6
      // 0d: aload 3
      // 0e: astore 2
      // 0f: aload 6
      // 11: invokespecial java/util/Properties.<init> ()V
      // 14: aload 3
      // 15: astore 2
      // 16: aload 6
      // 18: aload 3
      // 19: invokevirtual java/util/Properties.load (Ljava/io/InputStream;)V
      // 1c: aload 3
      // 1d: astore 2
      // 1e: aload 6
      // 20: ldc "fabric-identifier"
      // 22: invokevirtual java/util/Properties.getProperty (Ljava/lang/String;)Ljava/lang/String;
      // 25: astore 4
      // 27: aload 3
      // 28: astore 2
      // 29: aload 6
      // 2b: ldc "fabric-version"
      // 2d: invokevirtual java/util/Properties.getProperty (Ljava/lang/String;)Ljava/lang/String;
      // 30: astore 5
      // 32: aload 3
      // 33: astore 2
      // 34: aload 6
      // 36: ldc "fabric-build-type"
      // 38: invokevirtual java/util/Properties.getProperty (Ljava/lang/String;)Ljava/lang/String;
      // 3b: astore 6
      // 3d: aload 3
      // 3e: astore 2
      // 3f: aload 4
      // 41: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 44: ifne 51
      // 47: aload 3
      // 48: astore 2
      // 49: aload 5
      // 4b: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 4e: ifeq c0
      // 51: aload 3
      // 52: astore 2
      // 53: new java/lang/IllegalStateException
      // 56: astore 4
      // 58: aload 3
      // 59: astore 2
      // 5a: new java/lang/StringBuilder
      // 5d: astore 5
      // 5f: aload 3
      // 60: astore 2
      // 61: aload 5
      // 63: invokespecial java/lang/StringBuilder.<init> ()V
      // 66: aload 3
      // 67: astore 2
      // 68: aload 4
      // 6a: aload 5
      // 6c: ldc "Invalid format of fabric file,"
      // 6e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 71: aload 1
      // 72: invokevirtual java/util/zip/ZipEntry.getName ()Ljava/lang/String;
      // 75: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 78: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 7b: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 7e: aload 3
      // 7f: astore 2
      // 80: aload 4
      // 82: athrow
      // 83: astore 4
      // 85: aload 3
      // 86: astore 2
      // 87: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 8a: astore 6
      // 8c: aload 3
      // 8d: astore 2
      // 8e: new java/lang/StringBuilder
      // 91: astore 5
      // 93: aload 3
      // 94: astore 2
      // 95: aload 5
      // 97: invokespecial java/lang/StringBuilder.<init> ()V
      // 9a: aload 3
      // 9b: astore 2
      // 9c: aload 6
      // 9e: ldc "Fabric"
      // a0: aload 5
      // a2: ldc "Error when parsing fabric properties "
      // a4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // a7: aload 1
      // a8: invokevirtual java/util/zip/ZipEntry.getName ()Ljava/lang/String;
      // ab: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // ae: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // b1: aload 4
      // b3: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // b8: aload 3
      // b9: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;)V
      // bc: aconst_null
      // bd: astore 1
      // be: aload 1
      // bf: areturn
      // c0: aload 3
      // c1: astore 2
      // c2: new io/fabric/sdk/android/KitInfo
      // c5: dup
      // c6: aload 4
      // c8: aload 5
      // ca: aload 6
      // cc: invokespecial io/fabric/sdk/android/KitInfo.<init> (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      // cf: astore 4
      // d1: aload 3
      // d2: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;)V
      // d5: aload 4
      // d7: astore 1
      // d8: goto be
      // db: astore 1
      // dc: aconst_null
      // dd: astore 2
      // de: aload 2
      // df: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;)V
      // e2: aload 1
      // e3: athrow
      // e4: astore 1
      // e5: goto de
      // e8: astore 4
      // ea: aconst_null
      // eb: astore 3
      // ec: goto 85
      // try (0 -> 4): 127 java/io/IOException
      // try (0 -> 4): 118 null
      // try (6 -> 8): 72 java/io/IOException
      // try (6 -> 8): 125 null
      // try (10 -> 12): 72 java/io/IOException
      // try (10 -> 12): 125 null
      // try (14 -> 17): 72 java/io/IOException
      // try (14 -> 17): 125 null
      // try (19 -> 23): 72 java/io/IOException
      // try (19 -> 23): 125 null
      // try (25 -> 29): 72 java/io/IOException
      // try (25 -> 29): 125 null
      // try (31 -> 35): 72 java/io/IOException
      // try (31 -> 35): 125 null
      // try (37 -> 40): 72 java/io/IOException
      // try (37 -> 40): 125 null
      // try (42 -> 45): 72 java/io/IOException
      // try (42 -> 45): 125 null
      // try (47 -> 49): 72 java/io/IOException
      // try (47 -> 49): 125 null
      // try (51 -> 53): 72 java/io/IOException
      // try (51 -> 53): 125 null
      // try (55 -> 57): 72 java/io/IOException
      // try (55 -> 57): 125 null
      // try (59 -> 68): 72 java/io/IOException
      // try (59 -> 68): 125 null
      // try (70 -> 72): 72 java/io/IOException
      // try (70 -> 72): 125 null
      // try (75 -> 77): 125 null
      // try (79 -> 81): 125 null
      // try (83 -> 85): 125 null
      // try (87 -> 98): 125 null
      // try (106 -> 113): 72 java/io/IOException
      // try (106 -> 113): 125 null
   }

   private Map<String, KitInfo> c() {
      HashMap var1 = new HashMap();

      try {
         Class.forName("com.google.android.gms.ads.AdView");
         KitInfo var2 = new KitInfo("com.google.firebase.firebase-ads", "0.0.0", "binary");
         var1.put(var2.a(), var2);
         Fabric.h().b("Fabric", "Found kit: com.google.firebase.firebase-ads");
      } catch (Exception var3) {
      }

      return var1;
   }

   private Map<String, KitInfo> d() throws Exception {
      HashMap var1 = new HashMap();
      ZipFile var3 = this.b();
      Enumeration var2 = var3.entries();

      while (var2.hasMoreElements()) {
         ZipEntry var4 = (ZipEntry)var2.nextElement();
         if (var4.getName().startsWith("fabric/") && var4.getName().length() > "fabric/".length()) {
            KitInfo var6 = this.a(var4, var3);
            if (var6 != null) {
               var1.put(var6.a(), var6);
               Fabric.h().b("Fabric", String.format("Found kit:[%s] version:[%s]", var6.a(), var6.b()));
            }
         }
      }

      if (var3 != null) {
         try {
            var3.close();
         } catch (IOException var5) {
         }
      }

      return var1;
   }

   public Map<String, KitInfo> a() throws Exception {
      HashMap var3 = new HashMap();
      long var1 = SystemClock.elapsedRealtime();
      var3.putAll(this.c());
      var3.putAll(this.d());
      Fabric.h().b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - var1));
      return var3;
   }

   protected ZipFile b() throws IOException {
      return new ZipFile(this.a);
   }
}
