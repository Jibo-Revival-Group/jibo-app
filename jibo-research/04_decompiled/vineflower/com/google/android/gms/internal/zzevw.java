package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class zzevw implements ActivityLifecycleCallbacks {
   private static volatile zzevw a;
   private boolean b = false;
   private zzevz c;
   private final zzewk d;
   private boolean e = true;
   private final Set<Activity> f = new HashSet<>();
   private zzewn g;
   private zzewn h;
   private final Map<String, Long> i = new HashMap<>();
   private AtomicInteger j = new AtomicInteger(0);
   private int k = 2;
   private Set<WeakReference<zzevw.zza>> l = new HashSet<>();

   private zzevw(zzevz var1, zzewk var2) {
      this.c = null;
      this.d = var2;
   }

   public static zzevw a() {
      zzevw var0;
      if (a != null) {
         var0 = a;
      } else {
         var0 = a(null, new zzewk());
      }

      return var0;
   }

   private static zzevw a(zzevz param0, zzewk param1) {
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
      // 00: getstatic com/google/android/gms/internal/zzevw.a Lcom/google/android/gms/internal/zzevw;
      // 03: ifnonnull 20
      // 06: ldc com/google/android/gms/internal/zzevw
      // 08: monitorenter
      // 09: getstatic com/google/android/gms/internal/zzevw.a Lcom/google/android/gms/internal/zzevw;
      // 0c: ifnonnull 1d
      // 0f: new com/google/android/gms/internal/zzevw
      // 12: astore 0
      // 13: aload 0
      // 14: aconst_null
      // 15: aload 1
      // 16: invokespecial com/google/android/gms/internal/zzevw.<init> (Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewk;)V
      // 19: aload 0
      // 1a: putstatic com/google/android/gms/internal/zzevw.a Lcom/google/android/gms/internal/zzevw;
      // 1d: ldc com/google/android/gms/internal/zzevw
      // 1f: monitorexit
      // 20: getstatic com/google/android/gms/internal/zzevw.a Lcom/google/android/gms/internal/zzevw;
      // 23: areturn
      // 24: astore 0
      // 25: ldc com/google/android/gms/internal/zzevw
      // 27: monitorexit
      // 28: aload 0
      // 29: athrow
      // try (4 -> 14): 18 null
      // try (14 -> 16): 18 null
      // try (19 -> 21): 18 null
   }

   private final void a(String param1, zzewn param2, zzewn param3) {
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
      // 000: aload 0
      // 001: getfield com/google/android/gms/internal/zzevw.c Lcom/google/android/gms/internal/zzevz;
      // 004: ifnonnull 00e
      // 007: aload 0
      // 008: invokestatic com/google/android/gms/internal/zzevz.a ()Lcom/google/android/gms/internal/zzevz;
      // 00b: putfield com/google/android/gms/internal/zzevw.c Lcom/google/android/gms/internal/zzevz;
      // 00e: new com/google/android/gms/internal/zzewy
      // 011: dup
      // 012: invokespecial com/google/android/gms/internal/zzewy.<init> ()V
      // 015: astore 8
      // 017: aload 8
      // 019: aload 1
      // 01a: putfield com/google/android/gms/internal/zzewy.a Ljava/lang/String;
      // 01d: aload 8
      // 01f: aload 2
      // 020: invokevirtual com/google/android/gms/internal/zzewn.b ()J
      // 023: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 026: putfield com/google/android/gms/internal/zzewy.b Ljava/lang/Long;
      // 029: aload 8
      // 02b: aload 2
      // 02c: aload 3
      // 02d: invokevirtual com/google/android/gms/internal/zzewn.a (Lcom/google/android/gms/internal/zzewn;)J
      // 030: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 033: putfield com/google/android/gms/internal/zzewy.c Ljava/lang/Long;
      // 036: aload 0
      // 037: getfield com/google/android/gms/internal/zzevw.j Ljava/util/concurrent/atomic/AtomicInteger;
      // 03a: bipush 0
      // 03b: invokevirtual java/util/concurrent/atomic/AtomicInteger.getAndSet (I)I
      // 03e: istore 5
      // 040: aload 0
      // 041: getfield com/google/android/gms/internal/zzevw.i Ljava/util/Map;
      // 044: astore 1
      // 045: aload 1
      // 046: monitorenter
      // 047: aload 0
      // 048: getfield com/google/android/gms/internal/zzevw.i Ljava/util/Map;
      // 04b: invokeinterface java/util/Map.isEmpty ()Z 1
      // 050: ifeq 058
      // 053: iload 5
      // 055: ifeq 10b
      // 058: iload 5
      // 05a: ifeq 0d3
      // 05d: aload 0
      // 05e: getfield com/google/android/gms/internal/zzevw.i Ljava/util/Map;
      // 061: invokeinterface java/util/Map.size ()I 1
      // 066: bipush 1
      // 067: iadd
      // 068: istore 4
      // 06a: aload 8
      // 06c: iload 4
      // 06e: anewarray 126
      // 071: putfield com/google/android/gms/internal/zzewy.d [Lcom/google/android/gms/internal/zzewz;
      // 074: aload 0
      // 075: getfield com/google/android/gms/internal/zzevw.i Ljava/util/Map;
      // 078: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 07d: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 082: astore 3
      // 083: bipush 0
      // 084: istore 4
      // 086: aload 3
      // 087: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 08c: ifeq 0e1
      // 08f: aload 3
      // 090: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 095: checkcast java/lang/String
      // 098: astore 9
      // 09a: aload 0
      // 09b: getfield com/google/android/gms/internal/zzevw.i Ljava/util/Map;
      // 09e: aload 9
      // 0a0: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0a5: checkcast java/lang/Long
      // 0a8: invokevirtual java/lang/Long.longValue ()J
      // 0ab: lstore 6
      // 0ad: new com/google/android/gms/internal/zzewz
      // 0b0: astore 2
      // 0b1: aload 2
      // 0b2: invokespecial com/google/android/gms/internal/zzewz.<init> ()V
      // 0b5: aload 2
      // 0b6: aload 9
      // 0b8: putfield com/google/android/gms/internal/zzewz.a Ljava/lang/String;
      // 0bb: aload 2
      // 0bc: lload 6
      // 0be: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0c1: putfield com/google/android/gms/internal/zzewz.b Ljava/lang/Long;
      // 0c4: aload 8
      // 0c6: getfield com/google/android/gms/internal/zzewy.d [Lcom/google/android/gms/internal/zzewz;
      // 0c9: iload 4
      // 0cb: aload 2
      // 0cc: aastore
      // 0cd: iinc 4 1
      // 0d0: goto 086
      // 0d3: aload 0
      // 0d4: getfield com/google/android/gms/internal/zzevw.i Ljava/util/Map;
      // 0d7: invokeinterface java/util/Map.size ()I 1
      // 0dc: istore 4
      // 0de: goto 06a
      // 0e1: iload 5
      // 0e3: ifeq 10b
      // 0e6: new com/google/android/gms/internal/zzewz
      // 0e9: astore 2
      // 0ea: aload 2
      // 0eb: invokespecial com/google/android/gms/internal/zzewz.<init> ()V
      // 0ee: aload 2
      // 0ef: getstatic com/google/android/gms/internal/zzewl.zzoep Lcom/google/android/gms/internal/zzewl;
      // 0f2: invokevirtual com/google/android/gms/internal/zzewl.toString ()Ljava/lang/String;
      // 0f5: putfield com/google/android/gms/internal/zzewz.a Ljava/lang/String;
      // 0f8: aload 2
      // 0f9: iload 5
      // 0fb: i2l
      // 0fc: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0ff: putfield com/google/android/gms/internal/zzewz.b Ljava/lang/Long;
      // 102: aload 8
      // 104: getfield com/google/android/gms/internal/zzewy.d [Lcom/google/android/gms/internal/zzewz;
      // 107: iload 4
      // 109: aload 2
      // 10a: aastore
      // 10b: aload 0
      // 10c: getfield com/google/android/gms/internal/zzevw.i Ljava/util/Map;
      // 10f: invokeinterface java/util/Map.clear ()V 1
      // 114: aload 1
      // 115: monitorexit
      // 116: aload 0
      // 117: getfield com/google/android/gms/internal/zzevw.c Lcom/google/android/gms/internal/zzevz;
      // 11a: ifnull 127
      // 11d: aload 0
      // 11e: getfield com/google/android/gms/internal/zzevw.c Lcom/google/android/gms/internal/zzevz;
      // 121: aload 8
      // 123: bipush 3
      // 124: invokevirtual com/google/android/gms/internal/zzevz.a (Lcom/google/android/gms/internal/zzewy;I)V
      // 127: return
      // 128: astore 2
      // 129: aload 1
      // 12a: monitorexit
      // 12b: aload 2
      // 12c: athrow
      // try (34 -> 38): 130 null
      // try (42 -> 48): 130 null
      // try (48 -> 57): 130 null
      // try (59 -> 89): 130 null
      // try (91 -> 95): 130 null
      // try (98 -> 116): 130 null
      // try (116 -> 121): 130 null
      // try (131 -> 133): 130 null
   }

   private final void a(boolean var1) {
      if (this.c == null) {
         this.c = zzevz.a();
      }

      if (this.c != null) {
         this.c.a(var1);
      }
   }

   private final void b(int param1) {
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
      // 01: iload 1
      // 02: putfield com/google/android/gms/internal/zzevw.k I
      // 05: aload 0
      // 06: getfield com/google/android/gms/internal/zzevw.l Ljava/util/Set;
      // 09: astore 2
      // 0a: aload 2
      // 0b: monitorenter
      // 0c: aload 0
      // 0d: getfield com/google/android/gms/internal/zzevw.l Ljava/util/Set;
      // 10: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 15: astore 4
      // 17: aload 4
      // 19: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1e: ifeq 52
      // 21: aload 4
      // 23: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 28: checkcast java/lang/ref/WeakReference
      // 2b: invokevirtual java/lang/ref/WeakReference.get ()Ljava/lang/Object;
      // 2e: checkcast com/google/android/gms/internal/zzevw$zza
      // 31: astore 3
      // 32: aload 3
      // 33: ifnull 48
      // 36: aload 3
      // 37: aload 0
      // 38: getfield com/google/android/gms/internal/zzevw.k I
      // 3b: invokeinterface com/google/android/gms/internal/zzevw$zza.b (I)V 2
      // 40: goto 17
      // 43: astore 3
      // 44: aload 2
      // 45: monitorexit
      // 46: aload 3
      // 47: athrow
      // 48: aload 4
      // 4a: invokeinterface java/util/Iterator.remove ()V 1
      // 4f: goto 17
      // 52: aload 2
      // 53: monitorexit
      // 54: return
      // try (8 -> 12): 28 null
      // try (12 -> 21): 28 null
      // try (23 -> 27): 28 null
      // try (29 -> 31): 28 null
      // try (33 -> 35): 28 null
      // try (36 -> 38): 28 null
   }

   public final void a(int var1) {
      this.j.addAndGet(1);
   }

   public final void a(Context param1) {
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
      // 03: getfield com/google/android/gms/internal/zzevw.b Z
      // 06: istore 2
      // 07: iload 2
      // 08: ifeq 0e
      // 0b: aload 0
      // 0c: monitorexit
      // 0d: return
      // 0e: aload 1
      // 0f: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 12: astore 1
      // 13: aload 1
      // 14: instanceof android/app/Application
      // 17: ifeq 0b
      // 1a: aload 1
      // 1b: checkcast android/app/Application
      // 1e: aload 0
      // 1f: invokevirtual android/app/Application.registerActivityLifecycleCallbacks (Landroid/app/Application$ActivityLifecycleCallbacks;)V
      // 22: aload 0
      // 23: bipush 1
      // 24: putfield com/google/android/gms/internal/zzevw.b Z
      // 27: goto 0b
      // 2a: astore 1
      // 2b: aload 0
      // 2c: monitorexit
      // 2d: aload 1
      // 2e: athrow
      // try (2 -> 5): 24 null
      // try (10 -> 23): 24 null
   }

   public final void a(String param1, long param2) {
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
      // 01: getfield com/google/android/gms/internal/zzevw.i Ljava/util/Map;
      // 04: astore 4
      // 06: aload 4
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield com/google/android/gms/internal/zzevw.i Ljava/util/Map;
      // 0d: aload 1
      // 0e: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 13: checkcast java/lang/Long
      // 16: astore 5
      // 18: aload 5
      // 1a: ifnonnull 30
      // 1d: aload 0
      // 1e: getfield com/google/android/gms/internal/zzevw.i Ljava/util/Map;
      // 21: aload 1
      // 22: lconst_1
      // 23: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 26: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 2b: pop
      // 2c: aload 4
      // 2e: monitorexit
      // 2f: return
      // 30: aload 0
      // 31: getfield com/google/android/gms/internal/zzevw.i Ljava/util/Map;
      // 34: aload 1
      // 35: aload 5
      // 37: invokevirtual java/lang/Long.longValue ()J
      // 3a: lconst_1
      // 3b: ladd
      // 3c: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 3f: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 44: pop
      // 45: goto 2c
      // 48: astore 1
      // 49: aload 4
      // 4b: monitorexit
      // 4c: aload 1
      // 4d: athrow
      // try (5 -> 11): 34 null
      // try (13 -> 20): 34 null
      // try (20 -> 22): 34 null
      // try (23 -> 33): 34 null
      // try (35 -> 37): 34 null
   }

   public final void a(WeakReference<zzevw.zza> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/google/android/gms/internal/zzevw.l Ljava/util/Set;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/internal/zzevw.l Ljava/util/Set;
      // 0b: aload 1
      // 0c: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 11: pop
      // 12: aload 2
      // 13: monitorexit
      // 14: return
      // 15: astore 1
      // 16: aload 2
      // 17: monitorexit
      // 18: aload 1
      // 19: athrow
      // try (5 -> 12): 13 null
      // try (14 -> 16): 13 null
   }

   public final int b() {
      return this.k;
   }

   public final void b(WeakReference<zzevw.zza> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/google/android/gms/internal/zzevw.l Ljava/util/Set;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/internal/zzevw.l Ljava/util/Set;
      // 0b: aload 1
      // 0c: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 11: pop
      // 12: aload 2
      // 13: monitorexit
      // 14: return
      // 15: astore 1
      // 16: aload 2
      // 17: monitorexit
      // 18: aload 1
      // 19: athrow
      // try (5 -> 12): 13 null
      // try (14 -> 16): 13 null
   }

   public void onActivityCreated(Activity var1, Bundle var2) {
   }

   public void onActivityDestroyed(Activity var1) {
   }

   public void onActivityPaused(Activity var1) {
   }

   public void onActivityResumed(Activity var1) {
      synchronized (this) {
         if (this.f.isEmpty()) {
            zzewn var5 = new zzewn();
            this.h = var5;
            this.f.add(var1);
            if (this.e) {
               this.e = false;
               this.b(1);
               this.a(true);
            } else {
               if (zzewq.a(var1.getApplicationContext())) {
                  String var9 = String.valueOf(zzewm.zzoew);
                  long var3 = this.g.a(this.h);
                  int var2 = String.valueOf(var9).length();
                  StringBuilder var8 = new StringBuilder(var2 + 39);
                  Log.d("FirebasePerformance", var8.append("onActivityResumed ").append(var9).append(":").append(var3).toString());
               }

               this.b(1);
               this.a(true);
               this.a(zzewm.zzoew.toString(), this.g, this.h);
            }
         } else {
            this.f.add(var1);
         }
      }
   }

   public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
   }

   public void onActivityStarted(Activity var1) {
   }

   public void onActivityStopped(Activity var1) {
      synchronized (this) {
         if (this.f.contains(var1)) {
            this.f.remove(var1);
            if (this.f.isEmpty()) {
               zzewn var5 = new zzewn();
               this.g = var5;
               if (zzewq.a(var1.getApplicationContext())) {
                  String var8 = String.valueOf(zzewm.zzoev);
                  long var3 = this.h.a(this.g);
                  int var2 = String.valueOf(var8).length();
                  StringBuilder var9 = new StringBuilder(var2 + 39);
                  Log.d("FirebasePerformance", var9.append("onActivityStopped ").append(var8).append(":").append(var3).toString());
               }

               this.b(2);
               this.a(false);
               this.a(zzewm.zzoev.toString(), this.h, this.g);
            }
         }
      }
   }

   public interface zza {
      void b(int var1);
   }
}
