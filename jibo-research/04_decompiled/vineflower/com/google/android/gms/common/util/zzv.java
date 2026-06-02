package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;

public final class zzv {
   @TargetApi(21)
   public static File a(Context var0) {
      File var1;
      if (zzq.f()) {
         var1 = var0.getNoBackupFilesDir();
      } else {
         var1 = a(new File(var0.getApplicationInfo().dataDir, "no_backup"));
      }

      return var1;
   }

   private static File a(File param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: ldc com/google/android/gms/common/util/zzv
      // 02: monitorenter
      // 03: aload 0
      // 04: astore 2
      // 05: aload 0
      // 06: invokevirtual java/io/File.exists ()Z
      // 09: ifne 20
      // 0c: aload 0
      // 0d: astore 2
      // 0e: aload 0
      // 0f: invokevirtual java/io/File.mkdirs ()Z
      // 12: ifne 20
      // 15: aload 0
      // 16: invokevirtual java/io/File.exists ()Z
      // 19: istore 1
      // 1a: iload 1
      // 1b: ifeq 25
      // 1e: aload 0
      // 1f: astore 2
      // 20: ldc com/google/android/gms/common/util/zzv
      // 22: monitorexit
      // 23: aload 2
      // 24: areturn
      // 25: aload 0
      // 26: invokevirtual java/io/File.getPath ()Ljava/lang/String;
      // 29: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 2c: astore 0
      // 2d: aload 0
      // 2e: invokevirtual java/lang/String.length ()I
      // 31: ifeq 47
      // 34: ldc "Unable to create no-backup dir "
      // 36: aload 0
      // 37: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 3a: astore 0
      // 3b: ldc "SupportV4Utils"
      // 3d: aload 0
      // 3e: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 41: pop
      // 42: aconst_null
      // 43: astore 2
      // 44: goto 20
      // 47: new java/lang/String
      // 4a: dup
      // 4b: ldc "Unable to create no-backup dir "
      // 4d: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 50: astore 0
      // 51: goto 3b
      // 54: astore 0
      // 55: ldc com/google/android/gms/common/util/zzv
      // 57: monitorexit
      // 58: aload 0
      // 59: athrow
      // try (4 -> 7): 47 null
      // try (9 -> 15): 47 null
      // try (23 -> 34): 47 null
      // try (34 -> 38): 47 null
      // try (41 -> 46): 47 null
   }
}
