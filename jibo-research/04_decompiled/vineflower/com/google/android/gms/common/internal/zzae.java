package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzae implements Callback {
   private final zzaf a;
   private final ArrayList<GoogleApiClient.ConnectionCallbacks> b = new ArrayList<>();
   private ArrayList<GoogleApiClient.ConnectionCallbacks> c = new ArrayList<>();
   private final ArrayList<GoogleApiClient.OnConnectionFailedListener> d = new ArrayList<>();
   private volatile boolean e = false;
   private final AtomicInteger f = new AtomicInteger(0);
   private boolean g = false;
   private final Handler h;
   private final Object i = new Object();

   public zzae(Looper var1, zzaf var2) {
      this.a = var2;
      this.h = new Handler(var1, this);
   }

   public final void a() {
      this.e = false;
      this.f.incrementAndGet();
   }

   public final void a(int param1) {
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
      // 00: bipush 0
      // 01: istore 2
      // 02: invokestatic android/os/Looper.myLooper ()Landroid/os/Looper;
      // 05: aload 0
      // 06: getfield com/google/android/gms/common/internal/zzae.h Landroid/os/Handler;
      // 09: invokevirtual android/os/Handler.getLooper ()Landroid/os/Looper;
      // 0c: if_acmpne a3
      // 0f: bipush 1
      // 10: istore 6
      // 12: iload 6
      // 14: ldc "onUnintentionalDisconnection must only be called on the Handler thread"
      // 16: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 19: aload 0
      // 1a: getfield com/google/android/gms/common/internal/zzae.h Landroid/os/Handler;
      // 1d: bipush 1
      // 1e: invokevirtual android/os/Handler.removeMessages (I)V
      // 21: aload 0
      // 22: getfield com/google/android/gms/common/internal/zzae.i Ljava/lang/Object;
      // 25: astore 7
      // 27: aload 7
      // 29: monitorenter
      // 2a: aload 0
      // 2b: bipush 1
      // 2c: putfield com/google/android/gms/common/internal/zzae.g Z
      // 2f: new java/util/ArrayList
      // 32: astore 8
      // 34: aload 8
      // 36: aload 0
      // 37: getfield com/google/android/gms/common/internal/zzae.b Ljava/util/ArrayList;
      // 3a: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 3d: aload 0
      // 3e: getfield com/google/android/gms/common/internal/zzae.f Ljava/util/concurrent/atomic/AtomicInteger;
      // 41: invokevirtual java/util/concurrent/atomic/AtomicInteger.get ()I
      // 44: istore 4
      // 46: aload 8
      // 48: checkcast java/util/ArrayList
      // 4b: astore 8
      // 4d: aload 8
      // 4f: invokevirtual java/util/ArrayList.size ()I
      // 52: istore 5
      // 54: iload 2
      // 55: iload 5
      // 57: if_icmpge a9
      // 5a: aload 8
      // 5c: iload 2
      // 5d: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 60: astore 9
      // 62: iload 2
      // 63: bipush 1
      // 64: iadd
      // 65: istore 3
      // 66: aload 9
      // 68: checkcast com/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks
      // 6b: astore 9
      // 6d: aload 0
      // 6e: getfield com/google/android/gms/common/internal/zzae.e Z
      // 71: ifeq a9
      // 74: aload 0
      // 75: getfield com/google/android/gms/common/internal/zzae.f Ljava/util/concurrent/atomic/AtomicInteger;
      // 78: invokevirtual java/util/concurrent/atomic/AtomicInteger.get ()I
      // 7b: iload 4
      // 7d: if_icmpne a9
      // 80: iload 3
      // 81: istore 2
      // 82: aload 0
      // 83: getfield com/google/android/gms/common/internal/zzae.b Ljava/util/ArrayList;
      // 86: aload 9
      // 88: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 8b: ifeq 54
      // 8e: aload 9
      // 90: iload 1
      // 91: invokeinterface com/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks.a (I)V 2
      // 96: iload 3
      // 97: istore 2
      // 98: goto 54
      // 9b: astore 8
      // 9d: aload 7
      // 9f: monitorexit
      // a0: aload 8
      // a2: athrow
      // a3: bipush 0
      // a4: istore 6
      // a6: goto 12
      // a9: aload 0
      // aa: getfield com/google/android/gms/common/internal/zzae.c Ljava/util/ArrayList;
      // ad: invokevirtual java/util/ArrayList.clear ()V
      // b0: aload 0
      // b1: bipush 0
      // b2: putfield com/google/android/gms/common/internal/zzae.g Z
      // b5: aload 7
      // b7: monitorexit
      // b8: return
      // try (21 -> 40): 75 null
      // try (43 -> 47): 75 null
      // try (51 -> 62): 75 null
      // try (64 -> 72): 75 null
      // try (76 -> 78): 75 null
      // try (83 -> 91): 75 null
   }

   public final void a(Bundle param1) {
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
      // 00: bipush 1
      // 01: istore 7
      // 03: bipush 0
      // 04: istore 2
      // 05: invokestatic android/os/Looper.myLooper ()Landroid/os/Looper;
      // 08: aload 0
      // 09: getfield com/google/android/gms/common/internal/zzae.h Landroid/os/Handler;
      // 0c: invokevirtual android/os/Handler.getLooper ()Landroid/os/Looper;
      // 0f: if_acmpne d2
      // 12: bipush 1
      // 13: istore 6
      // 15: iload 6
      // 17: ldc "onConnectionSuccess must only be called on the Handler thread"
      // 19: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 1c: aload 0
      // 1d: getfield com/google/android/gms/common/internal/zzae.i Ljava/lang/Object;
      // 20: astore 8
      // 22: aload 8
      // 24: monitorenter
      // 25: aload 0
      // 26: getfield com/google/android/gms/common/internal/zzae.g Z
      // 29: ifne d8
      // 2c: bipush 1
      // 2d: istore 6
      // 2f: iload 6
      // 31: invokestatic com/google/android/gms/common/internal/zzbq.a (Z)V
      // 34: aload 0
      // 35: getfield com/google/android/gms/common/internal/zzae.h Landroid/os/Handler;
      // 38: bipush 1
      // 39: invokevirtual android/os/Handler.removeMessages (I)V
      // 3c: aload 0
      // 3d: bipush 1
      // 3e: putfield com/google/android/gms/common/internal/zzae.g Z
      // 41: aload 0
      // 42: getfield com/google/android/gms/common/internal/zzae.c Ljava/util/ArrayList;
      // 45: invokevirtual java/util/ArrayList.size ()I
      // 48: ifne de
      // 4b: iload 7
      // 4d: istore 6
      // 4f: iload 6
      // 51: invokestatic com/google/android/gms/common/internal/zzbq.a (Z)V
      // 54: new java/util/ArrayList
      // 57: astore 9
      // 59: aload 9
      // 5b: aload 0
      // 5c: getfield com/google/android/gms/common/internal/zzae.b Ljava/util/ArrayList;
      // 5f: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 62: aload 0
      // 63: getfield com/google/android/gms/common/internal/zzae.f Ljava/util/concurrent/atomic/AtomicInteger;
      // 66: invokevirtual java/util/concurrent/atomic/AtomicInteger.get ()I
      // 69: istore 4
      // 6b: aload 9
      // 6d: checkcast java/util/ArrayList
      // 70: astore 9
      // 72: aload 9
      // 74: invokevirtual java/util/ArrayList.size ()I
      // 77: istore 5
      // 79: iload 2
      // 7a: iload 5
      // 7c: if_icmpge e4
      // 7f: aload 9
      // 81: iload 2
      // 82: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 85: astore 10
      // 87: iload 2
      // 88: bipush 1
      // 89: iadd
      // 8a: istore 3
      // 8b: aload 10
      // 8d: checkcast com/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks
      // 90: astore 10
      // 92: aload 0
      // 93: getfield com/google/android/gms/common/internal/zzae.e Z
      // 96: ifeq e4
      // 99: aload 0
      // 9a: getfield com/google/android/gms/common/internal/zzae.a Lcom/google/android/gms/common/internal/zzaf;
      // 9d: invokeinterface com/google/android/gms/common/internal/zzaf.g ()Z 1
      // a2: ifeq e4
      // a5: aload 0
      // a6: getfield com/google/android/gms/common/internal/zzae.f Ljava/util/concurrent/atomic/AtomicInteger;
      // a9: invokevirtual java/util/concurrent/atomic/AtomicInteger.get ()I
      // ac: iload 4
      // ae: if_icmpne e4
      // b1: iload 3
      // b2: istore 2
      // b3: aload 0
      // b4: getfield com/google/android/gms/common/internal/zzae.c Ljava/util/ArrayList;
      // b7: aload 10
      // b9: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // bc: ifne 79
      // bf: aload 10
      // c1: aload 1
      // c2: invokeinterface com/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks.a (Landroid/os/Bundle;)V 2
      // c7: iload 3
      // c8: istore 2
      // c9: goto 79
      // cc: astore 1
      // cd: aload 8
      // cf: monitorexit
      // d0: aload 1
      // d1: athrow
      // d2: bipush 0
      // d3: istore 6
      // d5: goto 15
      // d8: bipush 0
      // d9: istore 6
      // db: goto 2f
      // de: bipush 0
      // df: istore 6
      // e1: goto 4f
      // e4: aload 0
      // e5: getfield com/google/android/gms/common/internal/zzae.c Ljava/util/ArrayList;
      // e8: invokevirtual java/util/ArrayList.clear ()V
      // eb: aload 0
      // ec: bipush 0
      // ed: putfield com/google/android/gms/common/internal/zzae.g Z
      // f0: aload 8
      // f2: monitorexit
      // f3: return
      // try (19 -> 22): 96 null
      // try (24 -> 37): 96 null
      // try (39 -> 57): 96 null
      // try (60 -> 64): 96 null
      // try (68 -> 83): 96 null
      // try (85 -> 93): 96 null
      // try (97 -> 99): 96 null
      // try (110 -> 118): 96 null
   }

   public final void a(ConnectionResult param1) {
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
      // 00: bipush 0
      // 01: istore 2
      // 02: invokestatic android/os/Looper.myLooper ()Landroid/os/Looper;
      // 05: aload 0
      // 06: getfield com/google/android/gms/common/internal/zzae.h Landroid/os/Handler;
      // 09: invokevirtual android/os/Handler.getLooper ()Landroid/os/Looper;
      // 0c: if_acmpne 7f
      // 0f: bipush 1
      // 10: istore 6
      // 12: iload 6
      // 14: ldc "onConnectionFailure must only be called on the Handler thread"
      // 16: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 19: aload 0
      // 1a: getfield com/google/android/gms/common/internal/zzae.h Landroid/os/Handler;
      // 1d: bipush 1
      // 1e: invokevirtual android/os/Handler.removeMessages (I)V
      // 21: aload 0
      // 22: getfield com/google/android/gms/common/internal/zzae.i Ljava/lang/Object;
      // 25: astore 7
      // 27: aload 7
      // 29: monitorenter
      // 2a: new java/util/ArrayList
      // 2d: astore 8
      // 2f: aload 8
      // 31: aload 0
      // 32: getfield com/google/android/gms/common/internal/zzae.d Ljava/util/ArrayList;
      // 35: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 38: aload 0
      // 39: getfield com/google/android/gms/common/internal/zzae.f Ljava/util/concurrent/atomic/AtomicInteger;
      // 3c: invokevirtual java/util/concurrent/atomic/AtomicInteger.get ()I
      // 3f: istore 4
      // 41: aload 8
      // 43: checkcast java/util/ArrayList
      // 46: astore 8
      // 48: aload 8
      // 4a: invokevirtual java/util/ArrayList.size ()I
      // 4d: istore 5
      // 4f: iload 2
      // 50: iload 5
      // 52: if_icmpge a6
      // 55: aload 8
      // 57: iload 2
      // 58: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 5b: astore 9
      // 5d: iload 2
      // 5e: bipush 1
      // 5f: iadd
      // 60: istore 3
      // 61: aload 9
      // 63: checkcast com/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener
      // 66: astore 9
      // 68: aload 0
      // 69: getfield com/google/android/gms/common/internal/zzae.e Z
      // 6c: ifeq 7b
      // 6f: aload 0
      // 70: getfield com/google/android/gms/common/internal/zzae.f Ljava/util/concurrent/atomic/AtomicInteger;
      // 73: invokevirtual java/util/concurrent/atomic/AtomicInteger.get ()I
      // 76: iload 4
      // 78: if_icmpeq 85
      // 7b: aload 7
      // 7d: monitorexit
      // 7e: return
      // 7f: bipush 0
      // 80: istore 6
      // 82: goto 12
      // 85: iload 3
      // 86: istore 2
      // 87: aload 0
      // 88: getfield com/google/android/gms/common/internal/zzae.d Ljava/util/ArrayList;
      // 8b: aload 9
      // 8d: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 90: ifeq 4f
      // 93: aload 9
      // 95: aload 1
      // 96: invokeinterface com/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener.a (Lcom/google/android/gms/common/ConnectionResult;)V 2
      // 9b: iload 3
      // 9c: istore 2
      // 9d: goto 4f
      // a0: astore 1
      // a1: aload 7
      // a3: monitorexit
      // a4: aload 1
      // a5: athrow
      // a6: aload 7
      // a8: monitorexit
      // a9: goto 7e
      // try (21 -> 37): 78 null
      // try (40 -> 44): 78 null
      // try (48 -> 59): 78 null
      // try (59 -> 61): 78 null
      // try (67 -> 75): 78 null
      // try (79 -> 81): 78 null
      // try (83 -> 85): 78 null
   }

   public final void a(GoogleApiClient.ConnectionCallbacks param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 1
      // 01: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 04: pop
      // 05: aload 0
      // 06: getfield com/google/android/gms/common/internal/zzae.i Ljava/lang/Object;
      // 09: astore 3
      // 0a: aload 3
      // 0b: monitorenter
      // 0c: aload 0
      // 0d: getfield com/google/android/gms/common/internal/zzae.b Ljava/util/ArrayList;
      // 10: aload 1
      // 11: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 14: ifeq 6e
      // 17: aload 1
      // 18: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1b: astore 5
      // 1d: aload 5
      // 1f: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 22: invokevirtual java/lang/String.length ()I
      // 25: istore 2
      // 26: new java/lang/StringBuilder
      // 29: astore 4
      // 2b: aload 4
      // 2d: iload 2
      // 2e: bipush 62
      // 30: iadd
      // 31: invokespecial java/lang/StringBuilder.<init> (I)V
      // 34: ldc "GmsClientEvents"
      // 36: aload 4
      // 38: ldc "registerConnectionCallbacks(): listener "
      // 3a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3d: aload 5
      // 3f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 42: ldc " is already registered"
      // 44: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 47: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 4a: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 4d: pop
      // 4e: aload 3
      // 4f: monitorexit
      // 50: aload 0
      // 51: getfield com/google/android/gms/common/internal/zzae.a Lcom/google/android/gms/common/internal/zzaf;
      // 54: invokeinterface com/google/android/gms/common/internal/zzaf.g ()Z 1
      // 59: ifeq 6d
      // 5c: aload 0
      // 5d: getfield com/google/android/gms/common/internal/zzae.h Landroid/os/Handler;
      // 60: aload 0
      // 61: getfield com/google/android/gms/common/internal/zzae.h Landroid/os/Handler;
      // 64: bipush 1
      // 65: aload 1
      // 66: invokevirtual android/os/Handler.obtainMessage (ILjava/lang/Object;)Landroid/os/Message;
      // 69: invokevirtual android/os/Handler.sendMessage (Landroid/os/Message;)Z
      // 6c: pop
      // 6d: return
      // 6e: aload 0
      // 6f: getfield com/google/android/gms/common/internal/zzae.b Ljava/util/ArrayList;
      // 72: aload 1
      // 73: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 76: pop
      // 77: goto 4e
      // 7a: astore 1
      // 7b: aload 3
      // 7c: monitorexit
      // 7d: aload 1
      // 7e: athrow
      // try (8 -> 38): 60 null
      // try (38 -> 40): 60 null
      // try (54 -> 59): 60 null
      // try (61 -> 63): 60 null
   }

   public final void a(GoogleApiClient.OnConnectionFailedListener param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 1
      // 01: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 04: pop
      // 05: aload 0
      // 06: getfield com/google/android/gms/common/internal/zzae.i Ljava/lang/Object;
      // 09: astore 3
      // 0a: aload 3
      // 0b: monitorenter
      // 0c: aload 0
      // 0d: getfield com/google/android/gms/common/internal/zzae.d Ljava/util/ArrayList;
      // 10: aload 1
      // 11: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 14: ifeq 4e
      // 17: aload 1
      // 18: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1b: astore 4
      // 1d: aload 4
      // 1f: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 22: invokevirtual java/lang/String.length ()I
      // 25: istore 2
      // 26: new java/lang/StringBuilder
      // 29: astore 1
      // 2a: aload 1
      // 2b: iload 2
      // 2c: bipush 67
      // 2e: iadd
      // 2f: invokespecial java/lang/StringBuilder.<init> (I)V
      // 32: ldc "GmsClientEvents"
      // 34: aload 1
      // 35: ldc "registerConnectionFailedListener(): listener "
      // 37: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3a: aload 4
      // 3c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3f: ldc " is already registered"
      // 41: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 44: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 47: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 4a: pop
      // 4b: aload 3
      // 4c: monitorexit
      // 4d: return
      // 4e: aload 0
      // 4f: getfield com/google/android/gms/common/internal/zzae.d Ljava/util/ArrayList;
      // 52: aload 1
      // 53: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 56: pop
      // 57: goto 4b
      // 5a: astore 1
      // 5b: aload 3
      // 5c: monitorexit
      // 5d: aload 1
      // 5e: athrow
      // try (8 -> 38): 47 null
      // try (38 -> 40): 47 null
      // try (41 -> 46): 47 null
      // try (48 -> 50): 47 null
   }

   public final void b() {
      this.e = true;
   }

   public final void b(GoogleApiClient.OnConnectionFailedListener param1) {
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
      // 01: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 04: pop
      // 05: aload 0
      // 06: getfield com/google/android/gms/common/internal/zzae.i Ljava/lang/Object;
      // 09: astore 3
      // 0a: aload 3
      // 0b: monitorenter
      // 0c: aload 0
      // 0d: getfield com/google/android/gms/common/internal/zzae.d Ljava/util/ArrayList;
      // 10: aload 1
      // 11: invokevirtual java/util/ArrayList.remove (Ljava/lang/Object;)Z
      // 14: ifne 4b
      // 17: aload 1
      // 18: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1b: astore 1
      // 1c: aload 1
      // 1d: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 20: invokevirtual java/lang/String.length ()I
      // 23: istore 2
      // 24: new java/lang/StringBuilder
      // 27: astore 4
      // 29: aload 4
      // 2b: iload 2
      // 2c: bipush 57
      // 2e: iadd
      // 2f: invokespecial java/lang/StringBuilder.<init> (I)V
      // 32: ldc "GmsClientEvents"
      // 34: aload 4
      // 36: ldc "unregisterConnectionFailedListener(): listener "
      // 38: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3b: aload 1
      // 3c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3f: ldc " not found"
      // 41: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 44: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 47: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 4a: pop
      // 4b: aload 3
      // 4c: monitorexit
      // 4d: return
      // 4e: astore 1
      // 4f: aload 3
      // 50: monitorexit
      // 51: aload 1
      // 52: athrow
      // try (8 -> 38): 41 null
      // try (38 -> 40): 41 null
      // try (42 -> 44): 41 null
   }

   public final boolean handleMessage(Message param1) {
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
      // 04: bipush 1
      // 05: if_icmpne 54
      // 08: aload 1
      // 09: getfield android/os/Message.obj Ljava/lang/Object;
      // 0c: checkcast com/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks
      // 0f: astore 4
      // 11: aload 0
      // 12: getfield com/google/android/gms/common/internal/zzae.i Ljava/lang/Object;
      // 15: astore 1
      // 16: aload 1
      // 17: monitorenter
      // 18: aload 0
      // 19: getfield com/google/android/gms/common/internal/zzae.e Z
      // 1c: ifeq 47
      // 1f: aload 0
      // 20: getfield com/google/android/gms/common/internal/zzae.a Lcom/google/android/gms/common/internal/zzaf;
      // 23: invokeinterface com/google/android/gms/common/internal/zzaf.g ()Z 1
      // 28: ifeq 47
      // 2b: aload 0
      // 2c: getfield com/google/android/gms/common/internal/zzae.b Ljava/util/ArrayList;
      // 2f: aload 4
      // 31: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 34: ifeq 47
      // 37: aload 4
      // 39: aload 0
      // 3a: getfield com/google/android/gms/common/internal/zzae.a Lcom/google/android/gms/common/internal/zzaf;
      // 3d: invokeinterface com/google/android/gms/common/internal/zzaf.a ()Landroid/os/Bundle; 1
      // 42: invokeinterface com/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks.a (Landroid/os/Bundle;)V 2
      // 47: aload 1
      // 48: monitorexit
      // 49: bipush 1
      // 4a: istore 3
      // 4b: iload 3
      // 4c: ireturn
      // 4d: astore 4
      // 4f: aload 1
      // 50: monitorexit
      // 51: aload 4
      // 53: athrow
      // 54: aload 1
      // 55: getfield android/os/Message.what I
      // 58: istore 2
      // 59: ldc "GmsClientEvents"
      // 5b: new java/lang/StringBuilder
      // 5e: dup
      // 5f: bipush 45
      // 61: invokespecial java/lang/StringBuilder.<init> (I)V
      // 64: ldc "Don't know how to handle message: "
      // 66: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 69: iload 2
      // 6a: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 6d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 70: new java/lang/Exception
      // 73: dup
      // 74: invokespecial java/lang/Exception.<init> ()V
      // 77: invokestatic android/util/Log.wtf (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 7a: pop
      // 7b: bipush 0
      // 7c: istore 3
      // 7d: goto 4b
      // try (13 -> 30): 36 null
      // try (30 -> 32): 36 null
      // try (37 -> 39): 36 null
   }
}
