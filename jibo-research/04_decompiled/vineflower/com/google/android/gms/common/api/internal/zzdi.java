package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Message;

final class zzdi extends Handler {
   private zzdg a;

   public final void handleMessage(Message param1) {
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
      // 00: aload 1
      // 01: getfield android/os/Message.what I
      // 04: tableswitch 24 0 1 57 158
      // 1c: aload 1
      // 1d: getfield android/os/Message.what I
      // 20: istore 2
      // 21: ldc "TransformedResultImpl"
      // 23: new java/lang/StringBuilder
      // 26: dup
      // 27: bipush 70
      // 29: invokespecial java/lang/StringBuilder.<init> (I)V
      // 2c: ldc "TransformationResultHandler received unknown message type: "
      // 2e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 31: iload 2
      // 32: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 35: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 38: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 3b: pop
      // 3c: return
      // 3d: aload 1
      // 3e: getfield android/os/Message.obj Ljava/lang/Object;
      // 41: checkcast com/google/android/gms/common/api/PendingResult
      // 44: astore 3
      // 45: aload 0
      // 46: getfield com/google/android/gms/common/api/internal/zzdi.a Lcom/google/android/gms/common/api/internal/zzdg;
      // 49: invokestatic com/google/android/gms/common/api/internal/zzdg.d (Lcom/google/android/gms/common/api/internal/zzdg;)Ljava/lang/Object;
      // 4c: astore 1
      // 4d: aload 1
      // 4e: monitorenter
      // 4f: aload 3
      // 50: ifnonnull 79
      // 53: aload 0
      // 54: getfield com/google/android/gms/common/api/internal/zzdi.a Lcom/google/android/gms/common/api/internal/zzdg;
      // 57: invokestatic com/google/android/gms/common/api/internal/zzdg.e (Lcom/google/android/gms/common/api/internal/zzdg;)Lcom/google/android/gms/common/api/internal/zzdg;
      // 5a: astore 3
      // 5b: new com/google/android/gms/common/api/Status
      // 5e: astore 4
      // 60: aload 4
      // 62: bipush 13
      // 64: ldc "Transform returned null"
      // 66: invokespecial com/google/android/gms/common/api/Status.<init> (ILjava/lang/String;)V
      // 69: aload 3
      // 6a: aload 4
      // 6c: invokestatic com/google/android/gms/common/api/internal/zzdg.a (Lcom/google/android/gms/common/api/internal/zzdg;Lcom/google/android/gms/common/api/Status;)V
      // 6f: aload 1
      // 70: monitorexit
      // 71: goto 3c
      // 74: astore 3
      // 75: aload 1
      // 76: monitorexit
      // 77: aload 3
      // 78: athrow
      // 79: aload 3
      // 7a: instanceof com/google/android/gms/common/api/internal/zzct
      // 7d: ifeq 94
      // 80: aload 0
      // 81: getfield com/google/android/gms/common/api/internal/zzdi.a Lcom/google/android/gms/common/api/internal/zzdg;
      // 84: invokestatic com/google/android/gms/common/api/internal/zzdg.e (Lcom/google/android/gms/common/api/internal/zzdg;)Lcom/google/android/gms/common/api/internal/zzdg;
      // 87: aload 3
      // 88: checkcast com/google/android/gms/common/api/internal/zzct
      // 8b: invokevirtual com/google/android/gms/common/api/internal/zzct.d ()Lcom/google/android/gms/common/api/Status;
      // 8e: invokestatic com/google/android/gms/common/api/internal/zzdg.a (Lcom/google/android/gms/common/api/internal/zzdg;Lcom/google/android/gms/common/api/Status;)V
      // 91: goto 6f
      // 94: aload 0
      // 95: getfield com/google/android/gms/common/api/internal/zzdi.a Lcom/google/android/gms/common/api/internal/zzdg;
      // 98: invokestatic com/google/android/gms/common/api/internal/zzdg.e (Lcom/google/android/gms/common/api/internal/zzdg;)Lcom/google/android/gms/common/api/internal/zzdg;
      // 9b: aload 3
      // 9c: invokevirtual com/google/android/gms/common/api/internal/zzdg.a (Lcom/google/android/gms/common/api/PendingResult;)V
      // 9f: goto 6f
      // a2: aload 1
      // a3: getfield android/os/Message.obj Ljava/lang/Object;
      // a6: checkcast java/lang/RuntimeException
      // a9: astore 3
      // aa: aload 3
      // ab: invokevirtual java/lang/RuntimeException.getMessage ()Ljava/lang/String;
      // ae: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // b1: astore 1
      // b2: aload 1
      // b3: invokevirtual java/lang/String.length ()I
      // b6: ifeq c9
      // b9: ldc "Runtime exception on the transformation worker thread: "
      // bb: aload 1
      // bc: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // bf: astore 1
      // c0: ldc "TransformedResultImpl"
      // c2: aload 1
      // c3: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // c6: pop
      // c7: aload 3
      // c8: athrow
      // c9: new java/lang/String
      // cc: dup
      // cd: ldc "Runtime exception on the transformation worker thread: "
      // cf: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // d2: astore 1
      // d3: goto c0
      // try (31 -> 44): 47 null
      // try (44 -> 46): 47 null
      // try (48 -> 50): 47 null
      // try (52 -> 62): 47 null
      // try (63 -> 68): 47 null
   }
}
