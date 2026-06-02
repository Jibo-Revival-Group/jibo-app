package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.lang.ref.WeakReference;

final class zzaq implements com.google.android.gms.common.internal.zzj {
   private final WeakReference<zzao> a;
   private final Api<?> b;
   private final boolean c;

   public zzaq(zzao var1, Api<?> var2, boolean var3) {
      this.a = new WeakReference<>(var1);
      this.b = var2;
      this.c = var3;
   }

   @Override
   public final void a(ConnectionResult param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: aload 0
      // 03: getfield com/google/android/gms/common/api/internal/zzaq.a Ljava/lang/ref/WeakReference;
      // 06: invokevirtual java/lang/ref/WeakReference.get ()Ljava/lang/Object;
      // 09: checkcast com/google/android/gms/common/api/internal/zzao
      // 0c: astore 3
      // 0d: aload 3
      // 0e: ifnonnull 12
      // 11: return
      // 12: invokestatic android/os/Looper.myLooper ()Landroid/os/Looper;
      // 15: aload 3
      // 16: invokestatic com/google/android/gms/common/api/internal/zzao.d (Lcom/google/android/gms/common/api/internal/zzao;)Lcom/google/android/gms/common/api/internal/zzbi;
      // 19: getfield com/google/android/gms/common/api/internal/zzbi.d Lcom/google/android/gms/common/api/internal/zzba;
      // 1c: invokevirtual com/google/android/gms/common/api/GoogleApiClient.c ()Landroid/os/Looper;
      // 1f: if_acmpne 24
      // 22: bipush 1
      // 23: istore 2
      // 24: iload 2
      // 25: ldc "onReportServiceBinding must be called on the GoogleApiClient handler thread"
      // 27: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 2a: aload 3
      // 2b: invokestatic com/google/android/gms/common/api/internal/zzao.c (Lcom/google/android/gms/common/api/internal/zzao;)Ljava/util/concurrent/locks/Lock;
      // 2e: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 33: aload 3
      // 34: bipush 0
      // 35: invokestatic com/google/android/gms/common/api/internal/zzao.a (Lcom/google/android/gms/common/api/internal/zzao;I)Z
      // 38: istore 2
      // 39: iload 2
      // 3a: ifne 49
      // 3d: aload 3
      // 3e: invokestatic com/google/android/gms/common/api/internal/zzao.c (Lcom/google/android/gms/common/api/internal/zzao;)Ljava/util/concurrent/locks/Lock;
      // 41: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 46: goto 11
      // 49: aload 1
      // 4a: invokevirtual com/google/android/gms/common/ConnectionResult.b ()Z
      // 4d: ifne 5d
      // 50: aload 3
      // 51: aload 1
      // 52: aload 0
      // 53: getfield com/google/android/gms/common/api/internal/zzaq.b Lcom/google/android/gms/common/api/Api;
      // 56: aload 0
      // 57: getfield com/google/android/gms/common/api/internal/zzaq.c Z
      // 5a: invokestatic com/google/android/gms/common/api/internal/zzao.a (Lcom/google/android/gms/common/api/internal/zzao;Lcom/google/android/gms/common/ConnectionResult;Lcom/google/android/gms/common/api/Api;Z)V
      // 5d: aload 3
      // 5e: invokestatic com/google/android/gms/common/api/internal/zzao.k (Lcom/google/android/gms/common/api/internal/zzao;)Z
      // 61: ifeq 68
      // 64: aload 3
      // 65: invokestatic com/google/android/gms/common/api/internal/zzao.j (Lcom/google/android/gms/common/api/internal/zzao;)V
      // 68: aload 3
      // 69: invokestatic com/google/android/gms/common/api/internal/zzao.c (Lcom/google/android/gms/common/api/internal/zzao;)Ljava/util/concurrent/locks/Lock;
      // 6c: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 71: goto 11
      // 74: astore 1
      // 75: aload 3
      // 76: invokestatic com/google/android/gms/common/api/internal/zzao.c (Lcom/google/android/gms/common/api/internal/zzao;)Ljava/util/concurrent/locks/Lock;
      // 79: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 7e: aload 1
      // 7f: athrow
      // try (24 -> 28): 53 null
      // try (34 -> 44): 53 null
      // try (44 -> 49): 53 null
   }
}
