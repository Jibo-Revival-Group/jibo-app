package io.fabric.sdk.android.services.common;

import android.util.Log;

public class TimingMetric {
   private final String a;
   private final String b;
   private final boolean c;
   private long d;
   private long e;

   public TimingMetric(String var1, String var2) {
      this.a = var1;
      this.b = var2;
      boolean var3;
      if (!Log.isLoggable(var2, 2)) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.c = var3;
   }

   private void c() {
      Log.v(this.b, this.a + ": " + this.e + "ms");
   }

   public void a() {
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
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield io/fabric/sdk/android/services/common/TimingMetric.c Z
      // 06: istore 1
      // 07: iload 1
      // 08: ifeq 0e
      // 0b: aload 0
      // 0c: monitorexit
      // 0d: return
      // 0e: aload 0
      // 0f: invokestatic android/os/SystemClock.elapsedRealtime ()J
      // 12: putfield io/fabric/sdk/android/services/common/TimingMetric.d J
      // 15: aload 0
      // 16: lconst_0
      // 17: putfield io/fabric/sdk/android/services/common/TimingMetric.e J
      // 1a: goto 0b
      // 1d: astore 2
      // 1e: aload 0
      // 1f: monitorexit
      // 20: aload 2
      // 21: athrow
      // try (2 -> 5): 17 null
      // try (10 -> 16): 17 null
   }

   public void b() {
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
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield io/fabric/sdk/android/services/common/TimingMetric.c Z
      // 06: istore 1
      // 07: iload 1
      // 08: ifeq 0e
      // 0b: aload 0
      // 0c: monitorexit
      // 0d: return
      // 0e: aload 0
      // 0f: getfield io/fabric/sdk/android/services/common/TimingMetric.e J
      // 12: lconst_0
      // 13: lcmp
      // 14: ifne 0b
      // 17: aload 0
      // 18: invokestatic android/os/SystemClock.elapsedRealtime ()J
      // 1b: aload 0
      // 1c: getfield io/fabric/sdk/android/services/common/TimingMetric.d J
      // 1f: lsub
      // 20: putfield io/fabric/sdk/android/services/common/TimingMetric.e J
      // 23: aload 0
      // 24: invokespecial io/fabric/sdk/android/services/common/TimingMetric.c ()V
      // 27: goto 0b
      // 2a: astore 2
      // 2b: aload 0
      // 2c: monitorexit
      // 2d: aload 2
      // 2e: athrow
      // try (2 -> 5): 24 null
      // try (10 -> 23): 24 null
   }
}
