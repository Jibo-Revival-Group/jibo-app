package okio;

final class SegmentPool {
   static Segment a;
   static long b;

   private SegmentPool() {
   }

   static Segment a() {
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
      // 00: ldc okio/SegmentPool
      // 02: monitorenter
      // 03: getstatic okio/SegmentPool.a Lokio/Segment;
      // 06: ifnull 28
      // 09: getstatic okio/SegmentPool.a Lokio/Segment;
      // 0c: astore 0
      // 0d: aload 0
      // 0e: getfield okio/Segment.f Lokio/Segment;
      // 11: putstatic okio/SegmentPool.a Lokio/Segment;
      // 14: aload 0
      // 15: aconst_null
      // 16: putfield okio/Segment.f Lokio/Segment;
      // 19: getstatic okio/SegmentPool.b J
      // 1c: ldc2_w 8192
      // 1f: lsub
      // 20: putstatic okio/SegmentPool.b J
      // 23: ldc okio/SegmentPool
      // 25: monitorexit
      // 26: aload 0
      // 27: areturn
      // 28: ldc okio/SegmentPool
      // 2a: monitorexit
      // 2b: new okio/Segment
      // 2e: dup
      // 2f: invokespecial okio/Segment.<init> ()V
      // 32: astore 0
      // 33: goto 26
      // 36: astore 0
      // 37: ldc okio/SegmentPool
      // 39: monitorexit
      // 3a: aload 0
      // 3b: athrow
      // try (2 -> 18): 27 null
      // try (20 -> 22): 27 null
      // try (28 -> 30): 27 null
   }

   static void a(Segment param0) {
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
      // 00: aload 0
      // 01: getfield okio/Segment.f Lokio/Segment;
      // 04: ifnonnull 0e
      // 07: aload 0
      // 08: getfield okio/Segment.g Lokio/Segment;
      // 0b: ifnull 16
      // 0e: new java/lang/IllegalArgumentException
      // 11: dup
      // 12: invokespecial java/lang/IllegalArgumentException.<init> ()V
      // 15: athrow
      // 16: aload 0
      // 17: getfield okio/Segment.d Z
      // 1a: ifeq 1e
      // 1d: return
      // 1e: ldc okio/SegmentPool
      // 20: monitorenter
      // 21: getstatic okio/SegmentPool.b J
      // 24: ldc2_w 8192
      // 27: ladd
      // 28: ldc2_w 65536
      // 2b: lcmp
      // 2c: ifle 3b
      // 2f: ldc okio/SegmentPool
      // 31: monitorexit
      // 32: goto 1d
      // 35: astore 0
      // 36: ldc okio/SegmentPool
      // 38: monitorexit
      // 39: aload 0
      // 3a: athrow
      // 3b: getstatic okio/SegmentPool.b J
      // 3e: ldc2_w 8192
      // 41: ladd
      // 42: putstatic okio/SegmentPool.b J
      // 45: aload 0
      // 46: getstatic okio/SegmentPool.a Lokio/Segment;
      // 49: putfield okio/Segment.f Lokio/Segment;
      // 4c: aload 0
      // 4d: bipush 0
      // 4e: putfield okio/Segment.c I
      // 51: aload 0
      // 52: bipush 0
      // 53: putfield okio/Segment.b I
      // 56: aload 0
      // 57: putstatic okio/SegmentPool.a Lokio/Segment;
      // 5a: ldc okio/SegmentPool
      // 5c: monitorexit
      // 5d: goto 1d
      // try (16 -> 24): 25 null
      // try (26 -> 28): 25 null
      // try (30 -> 47): 25 null
   }
}
