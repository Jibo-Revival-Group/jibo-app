package com.google.android.gms.common.util;

import android.os.Process;

public final class zzs {
   private static String a = null;
   private static final int b = Process.myPid();

   public static String a() {
      if (a == null) {
         a = a(b);
      }

      return a;
   }

   private static String a(int param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 2
      // 02: iload 0
      // 03: ifgt 08
      // 06: aload 2
      // 07: areturn
      // 08: invokestatic android/os/StrictMode.allowThreadDiskReads ()Landroid/os/StrictMode$ThreadPolicy;
      // 0b: astore 3
      // 0c: new java/io/BufferedReader
      // 0f: astore 1
      // 10: new java/io/FileReader
      // 13: astore 5
      // 15: new java/lang/StringBuilder
      // 18: astore 4
      // 1a: aload 4
      // 1c: bipush 25
      // 1e: invokespecial java/lang/StringBuilder.<init> (I)V
      // 21: aload 5
      // 23: aload 4
      // 25: ldc "/proc/"
      // 27: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2a: iload 0
      // 2b: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 2e: ldc "/cmdline"
      // 30: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 33: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 36: invokespecial java/io/FileReader.<init> (Ljava/lang/String;)V
      // 39: aload 1
      // 3a: aload 5
      // 3c: invokespecial java/io/BufferedReader.<init> (Ljava/io/Reader;)V
      // 3f: aload 3
      // 40: invokestatic android/os/StrictMode.setThreadPolicy (Landroid/os/StrictMode$ThreadPolicy;)V
      // 43: aload 1
      // 44: invokevirtual java/io/BufferedReader.readLine ()Ljava/lang/String;
      // 47: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 4a: astore 3
      // 4b: aload 3
      // 4c: astore 2
      // 4d: aload 1
      // 4e: invokestatic com/google/android/gms/common/util/zzn.a (Ljava/io/Closeable;)V
      // 51: goto 06
      // 54: astore 1
      // 55: aload 3
      // 56: invokestatic android/os/StrictMode.setThreadPolicy (Landroid/os/StrictMode$ThreadPolicy;)V
      // 59: aload 1
      // 5a: athrow
      // 5b: astore 1
      // 5c: aconst_null
      // 5d: astore 1
      // 5e: aload 1
      // 5f: invokestatic com/google/android/gms/common/util/zzn.a (Ljava/io/Closeable;)V
      // 62: goto 06
      // 65: astore 2
      // 66: aconst_null
      // 67: astore 1
      // 68: aload 1
      // 69: invokestatic com/google/android/gms/common/util/zzn.a (Ljava/io/Closeable;)V
      // 6c: aload 2
      // 6d: athrow
      // 6e: astore 2
      // 6f: goto 68
      // 72: astore 3
      // 73: goto 5e
      // try (6 -> 8): 46 java/io/IOException
      // try (6 -> 8): 52 null
      // try (8 -> 30): 41 null
      // try (30 -> 36): 61 java/io/IOException
      // try (30 -> 36): 59 null
      // try (42 -> 46): 46 java/io/IOException
      // try (42 -> 46): 52 null
   }
}
