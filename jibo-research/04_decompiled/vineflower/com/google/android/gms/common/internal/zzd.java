package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzd<T extends IInterface> {
   private static String[] A = new String[]{"service_esmobile", "service_googleme"};
   final Handler a;
   protected zzj b;
   protected AtomicInteger c;
   private int d;
   private long e;
   private long f;
   private int g;
   private long h;
   private zzam i;
   private final Context j;
   private final Looper k;
   private final zzag l;
   private final com.google.android.gms.common.zzf m;
   private final Object n = new Object();
   private final Object o = new Object();
   private zzay p;
   private T q;
   private final ArrayList<zzi<?>> r = new ArrayList<>();
   private zzl s;
   private int t = 1;
   private final zzf u;
   private final zzg v;
   private final int w;
   private final String x;
   private ConnectionResult y = null;
   private boolean z = false;

   protected zzd(Context var1, Looper var2, int var3, zzf var4, zzg var5, String var6) {
      this(var1, var2, zzag.a(var1), com.google.android.gms.common.zzf.b(), var3, zzbq.a(var4), zzbq.a(var5), null);
   }

   protected zzd(Context var1, Looper var2, zzag var3, com.google.android.gms.common.zzf var4, int var5, zzf var6, zzg var7, String var8) {
      this.c = new AtomicInteger(0);
      this.j = zzbq.a(var1, "Context must not be null");
      this.k = zzbq.a(var2, "Looper must not be null");
      this.l = zzbq.a(var3, "Supervisor must not be null");
      this.m = zzbq.a(var4, "API availability must not be null");
      this.a = new zzh(this, var2);
      this.w = var5;
      this.u = var6;
      this.v = var7;
      this.x = var8;
   }

   private final void a(int param1, T param2) {
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
      // 000: bipush 1
      // 001: istore 5
      // 003: iload 1
      // 004: bipush 4
      // 005: if_icmpne 054
      // 008: bipush 1
      // 009: istore 3
      // 00a: aload 2
      // 00b: ifnull 059
      // 00e: bipush 1
      // 00f: istore 4
      // 011: iload 3
      // 012: iload 4
      // 014: if_icmpne 05f
      // 017: iload 5
      // 019: invokestatic com/google/android/gms/common/internal/zzbq.b (Z)V
      // 01c: aload 0
      // 01d: getfield com/google/android/gms/common/internal/zzd.n Ljava/lang/Object;
      // 020: astore 6
      // 022: aload 6
      // 024: monitorenter
      // 025: aload 0
      // 026: iload 1
      // 027: putfield com/google/android/gms/common/internal/zzd.t I
      // 02a: aload 0
      // 02b: aload 2
      // 02c: putfield com/google/android/gms/common/internal/zzd.q Landroid/os/IInterface;
      // 02f: iload 1
      // 030: tableswitch 32 1 4 419 53 53 411
      // 050: aload 6
      // 052: monitorexit
      // 053: return
      // 054: bipush 0
      // 055: istore 3
      // 056: goto 00a
      // 059: bipush 0
      // 05a: istore 4
      // 05c: goto 011
      // 05f: bipush 0
      // 060: istore 5
      // 062: goto 017
      // 065: aload 0
      // 066: getfield com/google/android/gms/common/internal/zzd.s Lcom/google/android/gms/common/internal/zzl;
      // 069: ifnull 0ef
      // 06c: aload 0
      // 06d: getfield com/google/android/gms/common/internal/zzd.i Lcom/google/android/gms/common/internal/zzam;
      // 070: ifnull 0ef
      // 073: aload 0
      // 074: getfield com/google/android/gms/common/internal/zzd.i Lcom/google/android/gms/common/internal/zzam;
      // 077: invokevirtual com/google/android/gms/common/internal/zzam.a ()Ljava/lang/String;
      // 07a: astore 7
      // 07c: aload 0
      // 07d: getfield com/google/android/gms/common/internal/zzd.i Lcom/google/android/gms/common/internal/zzam;
      // 080: invokevirtual com/google/android/gms/common/internal/zzam.b ()Ljava/lang/String;
      // 083: astore 8
      // 085: aload 7
      // 087: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 08a: invokevirtual java/lang/String.length ()I
      // 08d: istore 3
      // 08e: aload 8
      // 090: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 093: invokevirtual java/lang/String.length ()I
      // 096: istore 1
      // 097: new java/lang/StringBuilder
      // 09a: astore 2
      // 09b: aload 2
      // 09c: iload 3
      // 09d: bipush 70
      // 09f: iadd
      // 0a0: iload 1
      // 0a1: iadd
      // 0a2: invokespecial java/lang/StringBuilder.<init> (I)V
      // 0a5: ldc "GmsClient"
      // 0a7: aload 2
      // 0a8: ldc "Calling connect() while still connected, missing disconnect() for "
      // 0aa: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ad: aload 7
      // 0af: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0b2: ldc " on "
      // 0b4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0b7: aload 8
      // 0b9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0bc: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0bf: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 0c2: pop
      // 0c3: aload 0
      // 0c4: getfield com/google/android/gms/common/internal/zzd.l Lcom/google/android/gms/common/internal/zzag;
      // 0c7: aload 0
      // 0c8: getfield com/google/android/gms/common/internal/zzd.i Lcom/google/android/gms/common/internal/zzam;
      // 0cb: invokevirtual com/google/android/gms/common/internal/zzam.a ()Ljava/lang/String;
      // 0ce: aload 0
      // 0cf: getfield com/google/android/gms/common/internal/zzd.i Lcom/google/android/gms/common/internal/zzam;
      // 0d2: invokevirtual com/google/android/gms/common/internal/zzam.b ()Ljava/lang/String;
      // 0d5: aload 0
      // 0d6: getfield com/google/android/gms/common/internal/zzd.i Lcom/google/android/gms/common/internal/zzam;
      // 0d9: invokevirtual com/google/android/gms/common/internal/zzam.c ()I
      // 0dc: aload 0
      // 0dd: getfield com/google/android/gms/common/internal/zzd.s Lcom/google/android/gms/common/internal/zzl;
      // 0e0: aload 0
      // 0e1: invokespecial com/google/android/gms/common/internal/zzd.e ()Ljava/lang/String;
      // 0e4: invokevirtual com/google/android/gms/common/internal/zzag.a (Ljava/lang/String;Ljava/lang/String;ILandroid/content/ServiceConnection;Ljava/lang/String;)V
      // 0e7: aload 0
      // 0e8: getfield com/google/android/gms/common/internal/zzd.c Ljava/util/concurrent/atomic/AtomicInteger;
      // 0eb: invokevirtual java/util/concurrent/atomic/AtomicInteger.incrementAndGet ()I
      // 0ee: pop
      // 0ef: new com/google/android/gms/common/internal/zzl
      // 0f2: astore 2
      // 0f3: aload 2
      // 0f4: aload 0
      // 0f5: aload 0
      // 0f6: getfield com/google/android/gms/common/internal/zzd.c Ljava/util/concurrent/atomic/AtomicInteger;
      // 0f9: invokevirtual java/util/concurrent/atomic/AtomicInteger.get ()I
      // 0fc: invokespecial com/google/android/gms/common/internal/zzl.<init> (Lcom/google/android/gms/common/internal/zzd;I)V
      // 0ff: aload 0
      // 100: aload 2
      // 101: putfield com/google/android/gms/common/internal/zzd.s Lcom/google/android/gms/common/internal/zzl;
      // 104: new com/google/android/gms/common/internal/zzam
      // 107: astore 2
      // 108: aload 2
      // 109: aload 0
      // 10a: invokevirtual com/google/android/gms/common/internal/zzd.q ()Ljava/lang/String;
      // 10d: aload 0
      // 10e: invokevirtual com/google/android/gms/common/internal/zzd.b_ ()Ljava/lang/String;
      // 111: bipush 0
      // 112: sipush 129
      // 115: invokespecial com/google/android/gms/common/internal/zzam.<init> (Ljava/lang/String;Ljava/lang/String;ZI)V
      // 118: aload 0
      // 119: aload 2
      // 11a: putfield com/google/android/gms/common/internal/zzd.i Lcom/google/android/gms/common/internal/zzam;
      // 11d: aload 0
      // 11e: getfield com/google/android/gms/common/internal/zzd.l Lcom/google/android/gms/common/internal/zzag;
      // 121: astore 11
      // 123: aload 0
      // 124: getfield com/google/android/gms/common/internal/zzd.i Lcom/google/android/gms/common/internal/zzam;
      // 127: invokevirtual com/google/android/gms/common/internal/zzam.a ()Ljava/lang/String;
      // 12a: astore 8
      // 12c: aload 0
      // 12d: getfield com/google/android/gms/common/internal/zzd.i Lcom/google/android/gms/common/internal/zzam;
      // 130: invokevirtual com/google/android/gms/common/internal/zzam.b ()Ljava/lang/String;
      // 133: astore 9
      // 135: aload 0
      // 136: getfield com/google/android/gms/common/internal/zzd.i Lcom/google/android/gms/common/internal/zzam;
      // 139: invokevirtual com/google/android/gms/common/internal/zzam.c ()I
      // 13c: istore 1
      // 13d: aload 0
      // 13e: getfield com/google/android/gms/common/internal/zzd.s Lcom/google/android/gms/common/internal/zzl;
      // 141: astore 2
      // 142: aload 0
      // 143: invokespecial com/google/android/gms/common/internal/zzd.e ()Ljava/lang/String;
      // 146: astore 10
      // 148: new com/google/android/gms/common/internal/zzah
      // 14b: astore 7
      // 14d: aload 7
      // 14f: aload 8
      // 151: aload 9
      // 153: iload 1
      // 154: invokespecial com/google/android/gms/common/internal/zzah.<init> (Ljava/lang/String;Ljava/lang/String;I)V
      // 157: aload 11
      // 159: aload 7
      // 15b: aload 2
      // 15c: aload 10
      // 15e: invokevirtual com/google/android/gms/common/internal/zzag.a (Lcom/google/android/gms/common/internal/zzah;Landroid/content/ServiceConnection;Ljava/lang/String;)Z
      // 161: ifne 050
      // 164: aload 0
      // 165: getfield com/google/android/gms/common/internal/zzd.i Lcom/google/android/gms/common/internal/zzam;
      // 168: invokevirtual com/google/android/gms/common/internal/zzam.a ()Ljava/lang/String;
      // 16b: astore 8
      // 16d: aload 0
      // 16e: getfield com/google/android/gms/common/internal/zzd.i Lcom/google/android/gms/common/internal/zzam;
      // 171: invokevirtual com/google/android/gms/common/internal/zzam.b ()Ljava/lang/String;
      // 174: astore 7
      // 176: aload 8
      // 178: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 17b: invokevirtual java/lang/String.length ()I
      // 17e: istore 1
      // 17f: aload 7
      // 181: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 184: invokevirtual java/lang/String.length ()I
      // 187: istore 3
      // 188: new java/lang/StringBuilder
      // 18b: astore 2
      // 18c: aload 2
      // 18d: iload 1
      // 18e: bipush 34
      // 190: iadd
      // 191: iload 3
      // 192: iadd
      // 193: invokespecial java/lang/StringBuilder.<init> (I)V
      // 196: ldc "GmsClient"
      // 198: aload 2
      // 199: ldc "unable to connect to service: "
      // 19b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 19e: aload 8
      // 1a0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1a3: ldc " on "
      // 1a5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1a8: aload 7
      // 1aa: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1ad: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1b0: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 1b3: pop
      // 1b4: aload 0
      // 1b5: bipush 16
      // 1b7: aconst_null
      // 1b8: aload 0
      // 1b9: getfield com/google/android/gms/common/internal/zzd.c Ljava/util/concurrent/atomic/AtomicInteger;
      // 1bc: invokevirtual java/util/concurrent/atomic/AtomicInteger.get ()I
      // 1bf: invokevirtual com/google/android/gms/common/internal/zzd.a (ILandroid/os/Bundle;I)V
      // 1c2: goto 050
      // 1c5: astore 2
      // 1c6: aload 6
      // 1c8: monitorexit
      // 1c9: aload 2
      // 1ca: athrow
      // 1cb: aload 0
      // 1cc: aload 2
      // 1cd: invokevirtual com/google/android/gms/common/internal/zzd.a (Landroid/os/IInterface;)V
      // 1d0: goto 050
      // 1d3: aload 0
      // 1d4: getfield com/google/android/gms/common/internal/zzd.s Lcom/google/android/gms/common/internal/zzl;
      // 1d7: ifnull 050
      // 1da: aload 0
      // 1db: getfield com/google/android/gms/common/internal/zzd.l Lcom/google/android/gms/common/internal/zzag;
      // 1de: aload 0
      // 1df: invokevirtual com/google/android/gms/common/internal/zzd.b_ ()Ljava/lang/String;
      // 1e2: aload 0
      // 1e3: invokevirtual com/google/android/gms/common/internal/zzd.q ()Ljava/lang/String;
      // 1e6: sipush 129
      // 1e9: aload 0
      // 1ea: getfield com/google/android/gms/common/internal/zzd.s Lcom/google/android/gms/common/internal/zzl;
      // 1ed: aload 0
      // 1ee: invokespecial com/google/android/gms/common/internal/zzd.e ()Ljava/lang/String;
      // 1f1: invokevirtual com/google/android/gms/common/internal/zzag.a (Ljava/lang/String;Ljava/lang/String;ILandroid/content/ServiceConnection;Ljava/lang/String;)V
      // 1f4: aload 0
      // 1f5: aconst_null
      // 1f6: putfield com/google/android/gms/common/internal/zzd.s Lcom/google/android/gms/common/internal/zzl;
      // 1f9: goto 050
      // try (21 -> 27): 209 null
      // try (29 -> 31): 209 null
      // try (41 -> 105): 209 null
      // try (105 -> 208): 209 null
      // try (210 -> 212): 209 null
      // try (214 -> 217): 209 null
      // try (218 -> 236): 209 null
   }

   private final boolean a(int param1, int param2, T param3) {
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
      // 01: getfield com/google/android/gms/common/internal/zzd.n Ljava/lang/Object;
      // 04: astore 5
      // 06: aload 5
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield com/google/android/gms/common/internal/zzd.t I
      // 0d: iload 1
      // 0e: if_icmpeq 1a
      // 11: bipush 0
      // 12: istore 4
      // 14: aload 5
      // 16: monitorexit
      // 17: iload 4
      // 19: ireturn
      // 1a: aload 0
      // 1b: iload 2
      // 1c: aload 3
      // 1d: invokespecial com/google/android/gms/common/internal/zzd.a (ILandroid/os/IInterface;)V
      // 20: bipush 1
      // 21: istore 4
      // 23: aload 5
      // 25: monitorexit
      // 26: goto 17
      // 29: astore 3
      // 2a: aload 5
      // 2c: monitorexit
      // 2d: aload 3
      // 2e: athrow
      // try (5 -> 9): 24 null
      // try (11 -> 13): 24 null
      // try (15 -> 19): 24 null
      // try (21 -> 23): 24 null
      // try (25 -> 27): 24 null
   }

   private final void c(int var1) {
      byte var2;
      if (this.n()) {
         var2 = 5;
         this.z = true;
      } else {
         var2 = 4;
      }

      this.a.sendMessage(this.a.obtainMessage(var2, this.c.get(), 16));
   }

   private final String e() {
      String var1;
      if (this.x == null) {
         var1 = this.j.getClass().getName();
      } else {
         var1 = this.x;
      }

      return var1;
   }

   private final boolean n() {
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
      // 01: getfield com/google/android/gms/common/internal/zzd.n Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/common/internal/zzd.t I
      // 0b: bipush 3
      // 0c: if_icmpne 15
      // 0f: bipush 1
      // 10: istore 1
      // 11: aload 3
      // 12: monitorexit
      // 13: iload 1
      // 14: ireturn
      // 15: bipush 0
      // 16: istore 1
      // 17: goto 11
      // 1a: astore 2
      // 1b: aload 3
      // 1c: monitorexit
      // 1d: aload 2
      // 1e: athrow
      // try (5 -> 9): 18 null
      // try (11 -> 13): 18 null
      // try (19 -> 21): 18 null
   }

   private final boolean x() {
      boolean var2 = false;
      boolean var1;
      if (this.z) {
         var1 = var2;
      } else {
         var1 = var2;
         if (!TextUtils.isEmpty(this.b())) {
            var1 = var2;
            if (!TextUtils.isEmpty(null)) {
               try {
                  Class.forName(this.b());
               } catch (ClassNotFoundException var4) {
                  var1 = var2;
                  return var1;
               }

               var1 = true;
            }
         }
      }

      return var1;
   }

   public Bundle a() {
      return null;
   }

   protected abstract T a(IBinder var1);

   protected void a(int var1) {
      this.d = var1;
      this.e = System.currentTimeMillis();
   }

   protected final void a(int var1, Bundle var2, int var3) {
      this.a.sendMessage(this.a.obtainMessage(7, var3, -1, new zzo(this, var1, null)));
   }

   protected void a(int var1, IBinder var2, Bundle var3, int var4) {
      this.a.sendMessage(this.a.obtainMessage(1, var4, -1, new zzn(this, var1, var2, var3)));
   }

   protected void a(T var1) {
      this.f = System.currentTimeMillis();
   }

   protected void a(ConnectionResult var1) {
      this.g = var1.c();
      this.h = System.currentTimeMillis();
   }

   public final void a(zzan param1, Set<Scope> param2) {
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
      // 000: aload 0
      // 001: invokevirtual com/google/android/gms/common/internal/zzd.t ()Landroid/os/Bundle;
      // 004: astore 4
      // 006: new com/google/android/gms/common/internal/zzz
      // 009: dup
      // 00a: aload 0
      // 00b: getfield com/google/android/gms/common/internal/zzd.w I
      // 00e: invokespecial com/google/android/gms/common/internal/zzz.<init> (I)V
      // 011: astore 3
      // 012: aload 3
      // 013: aload 0
      // 014: getfield com/google/android/gms/common/internal/zzd.j Landroid/content/Context;
      // 017: invokevirtual android/content/Context.getPackageName ()Ljava/lang/String;
      // 01a: putfield com/google/android/gms/common/internal/zzz.a Ljava/lang/String;
      // 01d: aload 3
      // 01e: aload 4
      // 020: putfield com/google/android/gms/common/internal/zzz.d Landroid/os/Bundle;
      // 023: aload 2
      // 024: ifnull 03d
      // 027: aload 3
      // 028: aload 2
      // 029: aload 2
      // 02a: invokeinterface java/util/Collection.size ()I 1
      // 02f: anewarray 367
      // 032: invokeinterface java/util/Collection.toArray ([Ljava/lang/Object;)[Ljava/lang/Object; 2
      // 037: checkcast [Lcom/google/android/gms/common/api/Scope;
      // 03a: putfield com/google/android/gms/common/internal/zzz.c [Lcom/google/android/gms/common/api/Scope;
      // 03d: aload 0
      // 03e: invokevirtual com/google/android/gms/common/internal/zzd.i ()Z
      // 041: ifeq 0ad
      // 044: aload 0
      // 045: invokevirtual com/google/android/gms/common/internal/zzd.e_ ()Landroid/accounts/Account;
      // 048: ifnull 09c
      // 04b: aload 0
      // 04c: invokevirtual com/google/android/gms/common/internal/zzd.e_ ()Landroid/accounts/Account;
      // 04f: astore 2
      // 050: aload 3
      // 051: aload 2
      // 052: putfield com/google/android/gms/common/internal/zzz.e Landroid/accounts/Account;
      // 055: aload 1
      // 056: ifnull 063
      // 059: aload 3
      // 05a: aload 1
      // 05b: invokeinterface com/google/android/gms/common/internal/zzan.asBinder ()Landroid/os/IBinder; 1
      // 060: putfield com/google/android/gms/common/internal/zzz.b Landroid/os/IBinder;
      // 063: aload 3
      // 064: aload 0
      // 065: invokevirtual com/google/android/gms/common/internal/zzd.p ()[Lcom/google/android/gms/common/zzc;
      // 068: putfield com/google/android/gms/common/internal/zzz.f [Lcom/google/android/gms/common/zzc;
      // 06b: aload 0
      // 06c: getfield com/google/android/gms/common/internal/zzd.o Ljava/lang/Object;
      // 06f: astore 1
      // 070: aload 1
      // 071: monitorenter
      // 072: aload 0
      // 073: getfield com/google/android/gms/common/internal/zzd.p Lcom/google/android/gms/common/internal/zzay;
      // 076: ifnull 0bf
      // 079: aload 0
      // 07a: getfield com/google/android/gms/common/internal/zzd.p Lcom/google/android/gms/common/internal/zzay;
      // 07d: astore 2
      // 07e: new com/google/android/gms/common/internal/zzk
      // 081: astore 4
      // 083: aload 4
      // 085: aload 0
      // 086: aload 0
      // 087: getfield com/google/android/gms/common/internal/zzd.c Ljava/util/concurrent/atomic/AtomicInteger;
      // 08a: invokevirtual java/util/concurrent/atomic/AtomicInteger.get ()I
      // 08d: invokespecial com/google/android/gms/common/internal/zzk.<init> (Lcom/google/android/gms/common/internal/zzd;I)V
      // 090: aload 2
      // 091: aload 4
      // 093: aload 3
      // 094: invokeinterface com/google/android/gms/common/internal/zzay.a (Lcom/google/android/gms/common/internal/zzaw;Lcom/google/android/gms/common/internal/zzz;)V 3
      // 099: aload 1
      // 09a: monitorexit
      // 09b: return
      // 09c: new android/accounts/Account
      // 09f: dup
      // 0a0: ldc_w "<<default account>>"
      // 0a3: ldc_w "com.google"
      // 0a6: invokespecial android/accounts/Account.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 0a9: astore 2
      // 0aa: goto 050
      // 0ad: aload 0
      // 0ae: invokevirtual com/google/android/gms/common/internal/zzd.w ()Z
      // 0b1: ifeq 063
      // 0b4: aload 3
      // 0b5: aload 0
      // 0b6: invokevirtual com/google/android/gms/common/internal/zzd.e_ ()Landroid/accounts/Account;
      // 0b9: putfield com/google/android/gms/common/internal/zzz.e Landroid/accounts/Account;
      // 0bc: goto 063
      // 0bf: ldc "GmsClient"
      // 0c1: ldc_w "mServiceBroker is null, client disconnected"
      // 0c4: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 0c7: pop
      // 0c8: goto 099
      // 0cb: astore 2
      // 0cc: aload 1
      // 0cd: monitorexit
      // 0ce: aload 2
      // 0cf: athrow
      // 0d0: astore 1
      // 0d1: ldc "GmsClient"
      // 0d3: ldc_w "IGmsServiceBroker.getService failed"
      // 0d6: aload 1
      // 0d7: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 0da: pop
      // 0db: aload 0
      // 0dc: bipush 1
      // 0dd: invokevirtual com/google/android/gms/common/internal/zzd.b (I)V
      // 0e0: goto 09b
      // 0e3: astore 1
      // 0e4: aload 1
      // 0e5: athrow
      // 0e6: astore 1
      // 0e7: ldc "GmsClient"
      // 0e9: ldc_w "IGmsServiceBroker.getService failed"
      // 0ec: aload 1
      // 0ed: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 0f0: pop
      // 0f1: aload 0
      // 0f2: bipush 8
      // 0f4: aconst_null
      // 0f5: aconst_null
      // 0f6: aload 0
      // 0f7: getfield com/google/android/gms/common/internal/zzd.c Ljava/util/concurrent/atomic/AtomicInteger;
      // 0fa: invokevirtual java/util/concurrent/atomic/AtomicInteger.get ()I
      // 0fd: invokevirtual com/google/android/gms/common/internal/zzd.a (ILandroid/os/IBinder;Landroid/os/Bundle;I)V
      // 100: goto 09b
      // 103: astore 1
      // 104: goto 0e7
      // try (49 -> 54): 100 android/os/DeadObjectException
      // try (49 -> 54): 110 java/lang/SecurityException
      // try (49 -> 54): 113 android/os/RemoteException
      // try (49 -> 54): 128 java/lang/RuntimeException
      // try (54 -> 72): 95 null
      // try (72 -> 74): 95 null
      // try (90 -> 94): 95 null
      // try (96 -> 98): 95 null
      // try (98 -> 100): 100 android/os/DeadObjectException
      // try (98 -> 100): 110 java/lang/SecurityException
      // try (98 -> 100): 113 android/os/RemoteException
      // try (98 -> 100): 128 java/lang/RuntimeException
   }

   public void a(zzj var1) {
      this.b = zzbq.a(var1, "Connection progress callbacks cannot be null.");
      this.a(2, null);
   }

   protected final void a(zzj var1, int var2, PendingIntent var3) {
      this.b = zzbq.a(var1, "Connection progress callbacks cannot be null.");
      this.a.sendMessage(this.a.obtainMessage(3, this.c.get(), var2, var3));
   }

   public void a(zzp var1) {
      var1.a();
   }

   public final void a(String param1, FileDescriptor param2, PrintWriter param3, String[] param4) {
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
      // 000: aload 0
      // 001: getfield com/google/android/gms/common/internal/zzd.n Ljava/lang/Object;
      // 004: astore 4
      // 006: aload 4
      // 008: monitorenter
      // 009: aload 0
      // 00a: getfield com/google/android/gms/common/internal/zzd.t I
      // 00d: istore 5
      // 00f: aload 0
      // 010: getfield com/google/android/gms/common/internal/zzd.q Landroid/os/IInterface;
      // 013: astore 2
      // 014: aload 4
      // 016: monitorexit
      // 017: aload 0
      // 018: getfield com/google/android/gms/common/internal/zzd.o Ljava/lang/Object;
      // 01b: astore 4
      // 01d: aload 4
      // 01f: monitorenter
      // 020: aload 0
      // 021: getfield com/google/android/gms/common/internal/zzd.p Lcom/google/android/gms/common/internal/zzay;
      // 024: astore 8
      // 026: aload 4
      // 028: monitorexit
      // 029: aload 3
      // 02a: aload 1
      // 02b: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 02e: ldc_w "mConnectState="
      // 031: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 034: pop
      // 035: iload 5
      // 037: tableswitch 33 1 5 468 428 438 448 458
      // 058: aload 3
      // 059: ldc_w "UNKNOWN"
      // 05c: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 05f: aload 3
      // 060: ldc_w " mService="
      // 063: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 066: pop
      // 067: aload 2
      // 068: ifnonnull 215
      // 06b: aload 3
      // 06c: ldc_w "null"
      // 06f: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 072: pop
      // 073: aload 3
      // 074: ldc_w " mServiceBroker="
      // 077: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 07a: pop
      // 07b: aload 8
      // 07d: ifnonnull 236
      // 080: aload 3
      // 081: ldc_w "null"
      // 084: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 087: new java/text/SimpleDateFormat
      // 08a: dup
      // 08b: ldc_w "yyyy-MM-dd HH:mm:ss.SSS"
      // 08e: getstatic java/util/Locale.US Ljava/util/Locale;
      // 091: invokespecial java/text/SimpleDateFormat.<init> (Ljava/lang/String;Ljava/util/Locale;)V
      // 094: astore 2
      // 095: aload 0
      // 096: getfield com/google/android/gms/common/internal/zzd.f J
      // 099: lconst_0
      // 09a: lcmp
      // 09b: ifle 0ec
      // 09e: aload 3
      // 09f: aload 1
      // 0a0: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 0a3: ldc_w "lastConnectedTime="
      // 0a6: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 0a9: astore 4
      // 0ab: aload 0
      // 0ac: getfield com/google/android/gms/common/internal/zzd.f J
      // 0af: lstore 6
      // 0b1: aload 2
      // 0b2: new java/util/Date
      // 0b5: dup
      // 0b6: aload 0
      // 0b7: getfield com/google/android/gms/common/internal/zzd.f J
      // 0ba: invokespecial java/util/Date.<init> (J)V
      // 0bd: invokevirtual java/text/SimpleDateFormat.format (Ljava/util/Date;)Ljava/lang/String;
      // 0c0: astore 8
      // 0c2: aload 4
      // 0c4: new java/lang/StringBuilder
      // 0c7: dup
      // 0c8: aload 8
      // 0ca: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0cd: invokevirtual java/lang/String.length ()I
      // 0d0: bipush 21
      // 0d2: iadd
      // 0d3: invokespecial java/lang/StringBuilder.<init> (I)V
      // 0d6: lload 6
      // 0d8: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 0db: ldc_w " "
      // 0de: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e1: aload 8
      // 0e3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e6: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0e9: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 0ec: aload 0
      // 0ed: getfield com/google/android/gms/common/internal/zzd.e J
      // 0f0: lconst_0
      // 0f1: lcmp
      // 0f2: ifle 172
      // 0f5: aload 3
      // 0f6: aload 1
      // 0f7: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 0fa: ldc_w "lastSuspendedCause="
      // 0fd: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 100: pop
      // 101: aload 0
      // 102: getfield com/google/android/gms/common/internal/zzd.d I
      // 105: tableswitch 23 1 2 331 342
      // 11c: aload 3
      // 11d: aload 0
      // 11e: getfield com/google/android/gms/common/internal/zzd.d I
      // 121: invokestatic java/lang/String.valueOf (I)Ljava/lang/String;
      // 124: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 127: pop
      // 128: aload 3
      // 129: ldc_w " lastSuspendedTime="
      // 12c: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 12f: astore 4
      // 131: aload 0
      // 132: getfield com/google/android/gms/common/internal/zzd.e J
      // 135: lstore 6
      // 137: aload 2
      // 138: new java/util/Date
      // 13b: dup
      // 13c: aload 0
      // 13d: getfield com/google/android/gms/common/internal/zzd.e J
      // 140: invokespecial java/util/Date.<init> (J)V
      // 143: invokevirtual java/text/SimpleDateFormat.format (Ljava/util/Date;)Ljava/lang/String;
      // 146: astore 8
      // 148: aload 4
      // 14a: new java/lang/StringBuilder
      // 14d: dup
      // 14e: aload 8
      // 150: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 153: invokevirtual java/lang/String.length ()I
      // 156: bipush 21
      // 158: iadd
      // 159: invokespecial java/lang/StringBuilder.<init> (I)V
      // 15c: lload 6
      // 15e: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 161: ldc_w " "
      // 164: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 167: aload 8
      // 169: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 16c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 16f: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 172: aload 0
      // 173: getfield com/google/android/gms/common/internal/zzd.h J
      // 176: lconst_0
      // 177: lcmp
      // 178: ifle 1d6
      // 17b: aload 3
      // 17c: aload 1
      // 17d: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 180: ldc_w "lastFailedStatus="
      // 183: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 186: aload 0
      // 187: getfield com/google/android/gms/common/internal/zzd.g I
      // 18a: invokestatic com/google/android/gms/common/api/CommonStatusCodes.a (I)Ljava/lang/String;
      // 18d: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 190: pop
      // 191: aload 3
      // 192: ldc_w " lastFailedTime="
      // 195: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 198: astore 1
      // 199: aload 0
      // 19a: getfield com/google/android/gms/common/internal/zzd.h J
      // 19d: lstore 6
      // 19f: aload 2
      // 1a0: new java/util/Date
      // 1a3: dup
      // 1a4: aload 0
      // 1a5: getfield com/google/android/gms/common/internal/zzd.h J
      // 1a8: invokespecial java/util/Date.<init> (J)V
      // 1ab: invokevirtual java/text/SimpleDateFormat.format (Ljava/util/Date;)Ljava/lang/String;
      // 1ae: astore 2
      // 1af: aload 1
      // 1b0: new java/lang/StringBuilder
      // 1b3: dup
      // 1b4: aload 2
      // 1b5: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1b8: invokevirtual java/lang/String.length ()I
      // 1bb: bipush 21
      // 1bd: iadd
      // 1be: invokespecial java/lang/StringBuilder.<init> (I)V
      // 1c1: lload 6
      // 1c3: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 1c6: ldc_w " "
      // 1c9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1cc: aload 2
      // 1cd: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1d0: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1d3: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 1d6: return
      // 1d7: astore 1
      // 1d8: aload 4
      // 1da: monitorexit
      // 1db: aload 1
      // 1dc: athrow
      // 1dd: astore 1
      // 1de: aload 4
      // 1e0: monitorexit
      // 1e1: aload 1
      // 1e2: athrow
      // 1e3: aload 3
      // 1e4: ldc_w "REMOTE_CONNECTING"
      // 1e7: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 1ea: goto 05f
      // 1ed: aload 3
      // 1ee: ldc_w "LOCAL_CONNECTING"
      // 1f1: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 1f4: goto 05f
      // 1f7: aload 3
      // 1f8: ldc_w "CONNECTED"
      // 1fb: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 1fe: goto 05f
      // 201: aload 3
      // 202: ldc_w "DISCONNECTING"
      // 205: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 208: goto 05f
      // 20b: aload 3
      // 20c: ldc_w "DISCONNECTED"
      // 20f: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 212: goto 05f
      // 215: aload 3
      // 216: aload 0
      // 217: invokevirtual com/google/android/gms/common/internal/zzd.b ()Ljava/lang/String;
      // 21a: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 21d: ldc_w "@"
      // 220: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 223: aload 2
      // 224: invokeinterface android/os/IInterface.asBinder ()Landroid/os/IBinder; 1
      // 229: invokestatic java/lang/System.identityHashCode (Ljava/lang/Object;)I
      // 22c: invokestatic java/lang/Integer.toHexString (I)Ljava/lang/String;
      // 22f: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 232: pop
      // 233: goto 073
      // 236: aload 3
      // 237: ldc_w "IGmsServiceBroker@"
      // 23a: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 23d: aload 8
      // 23f: invokeinterface com/google/android/gms/common/internal/zzay.asBinder ()Landroid/os/IBinder; 1
      // 244: invokestatic java/lang/System.identityHashCode (Ljava/lang/Object;)I
      // 247: invokestatic java/lang/Integer.toHexString (I)Ljava/lang/String;
      // 24a: invokevirtual java/io/PrintWriter.println (Ljava/lang/String;)V
      // 24d: goto 087
      // 250: aload 3
      // 251: ldc_w "CAUSE_SERVICE_DISCONNECTED"
      // 254: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 257: pop
      // 258: goto 128
      // 25b: aload 3
      // 25c: ldc_w "CAUSE_NETWORK_LOST"
      // 25f: invokevirtual java/io/PrintWriter.append (Ljava/lang/CharSequence;)Ljava/io/PrintWriter;
      // 262: pop
      // 263: goto 128
      // try (5 -> 13): 198 null
      // try (18 -> 23): 203 null
      // try (199 -> 201): 198 null
      // try (204 -> 206): 203 null
   }

   protected abstract String b();

   public final void b(int var1) {
      this.a.sendMessage(this.a.obtainMessage(6, this.c.get(), var1));
   }

   protected abstract String b_();

   public boolean c() {
      return false;
   }

   public Intent d() {
      throw new UnsupportedOperationException("Not a sign in API");
   }

   public Account e_() {
      return null;
   }

   public void f() {
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
      // 01: getfield com/google/android/gms/common/internal/zzd.c Ljava/util/concurrent/atomic/AtomicInteger;
      // 04: invokevirtual java/util/concurrent/atomic/AtomicInteger.incrementAndGet ()I
      // 07: pop
      // 08: aload 0
      // 09: getfield com/google/android/gms/common/internal/zzd.r Ljava/util/ArrayList;
      // 0c: astore 4
      // 0e: aload 4
      // 10: monitorenter
      // 11: aload 0
      // 12: getfield com/google/android/gms/common/internal/zzd.r Ljava/util/ArrayList;
      // 15: invokevirtual java/util/ArrayList.size ()I
      // 18: istore 2
      // 19: bipush 0
      // 1a: istore 1
      // 1b: iload 1
      // 1c: iload 2
      // 1d: if_icmpge 34
      // 20: aload 0
      // 21: getfield com/google/android/gms/common/internal/zzd.r Ljava/util/ArrayList;
      // 24: iload 1
      // 25: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 28: checkcast com/google/android/gms/common/internal/zzi
      // 2b: invokevirtual com/google/android/gms/common/internal/zzi.d ()V
      // 2e: iinc 1 1
      // 31: goto 1b
      // 34: aload 0
      // 35: getfield com/google/android/gms/common/internal/zzd.r Ljava/util/ArrayList;
      // 38: invokevirtual java/util/ArrayList.clear ()V
      // 3b: aload 4
      // 3d: monitorexit
      // 3e: aload 0
      // 3f: getfield com/google/android/gms/common/internal/zzd.o Ljava/lang/Object;
      // 42: astore 3
      // 43: aload 3
      // 44: monitorenter
      // 45: aload 0
      // 46: aconst_null
      // 47: putfield com/google/android/gms/common/internal/zzd.p Lcom/google/android/gms/common/internal/zzay;
      // 4a: aload 3
      // 4b: monitorexit
      // 4c: aload 0
      // 4d: bipush 1
      // 4e: aconst_null
      // 4f: invokespecial com/google/android/gms/common/internal/zzd.a (ILandroid/os/IInterface;)V
      // 52: return
      // 53: astore 3
      // 54: aload 4
      // 56: monitorexit
      // 57: aload 3
      // 58: athrow
      // 59: astore 4
      // 5b: aload 3
      // 5c: monitorexit
      // 5d: aload 4
      // 5f: athrow
      // try (9 -> 13): 46 null
      // try (18 -> 24): 46 null
      // try (26 -> 31): 46 null
      // try (36 -> 41): 51 null
      // try (47 -> 49): 46 null
      // try (52 -> 54): 51 null
   }

   public final boolean g() {
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
      // 01: getfield com/google/android/gms/common/internal/zzd.n Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/common/internal/zzd.t I
      // 0b: bipush 4
      // 0c: if_icmpne 15
      // 0f: bipush 1
      // 10: istore 1
      // 11: aload 2
      // 12: monitorexit
      // 13: iload 1
      // 14: ireturn
      // 15: bipush 0
      // 16: istore 1
      // 17: goto 11
      // 1a: astore 3
      // 1b: aload 2
      // 1c: monitorexit
      // 1d: aload 3
      // 1e: athrow
      // try (5 -> 9): 18 null
      // try (11 -> 13): 18 null
      // try (19 -> 21): 18 null
   }

   public final boolean h() {
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
      // 01: getfield com/google/android/gms/common/internal/zzd.n Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/common/internal/zzd.t I
      // 0b: bipush 2
      // 0c: if_icmpeq 17
      // 0f: aload 0
      // 10: getfield com/google/android/gms/common/internal/zzd.t I
      // 13: bipush 3
      // 14: if_icmpne 1d
      // 17: bipush 1
      // 18: istore 1
      // 19: aload 3
      // 1a: monitorexit
      // 1b: iload 1
      // 1c: ireturn
      // 1d: bipush 0
      // 1e: istore 1
      // 1f: goto 19
      // 22: astore 2
      // 23: aload 3
      // 24: monitorexit
      // 25: aload 2
      // 26: athrow
      // try (5 -> 13): 22 null
      // try (15 -> 17): 22 null
      // try (23 -> 25): 22 null
   }

   public boolean i() {
      return false;
   }

   public boolean j() {
      return true;
   }

   public final IBinder k() {
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
      // 01: getfield com/google/android/gms/common/internal/zzd.o Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/common/internal/zzd.p Lcom/google/android/gms/common/internal/zzay;
      // 0b: ifnonnull 14
      // 0e: aconst_null
      // 0f: astore 1
      // 10: aload 2
      // 11: monitorexit
      // 12: aload 1
      // 13: areturn
      // 14: aload 0
      // 15: getfield com/google/android/gms/common/internal/zzd.p Lcom/google/android/gms/common/internal/zzay;
      // 18: invokeinterface com/google/android/gms/common/internal/zzay.asBinder ()Landroid/os/IBinder; 1
      // 1d: astore 1
      // 1e: aload 2
      // 1f: monitorexit
      // 20: goto 12
      // 23: astore 1
      // 24: aload 2
      // 25: monitorexit
      // 26: aload 1
      // 27: athrow
      // try (5 -> 8): 21 null
      // try (10 -> 12): 21 null
      // try (14 -> 20): 21 null
      // try (22 -> 24): 21 null
   }

   public final String l() {
      if (this.g() && this.i != null) {
         return this.i.b();
      } else {
         throw new RuntimeException("Failed to connect when checking package");
      }
   }

   protected Set<Scope> o() {
      return Collections.EMPTY_SET;
   }

   public com.google.android.gms.common.zzc[] p() {
      return new com.google.android.gms.common.zzc[0];
   }

   protected String q() {
      return "com.google.android.gms";
   }

   public final void r() {
      int var1 = this.m.a(this.j);
      if (var1 != 0) {
         this.a(1, null);
         this.a(new zzm(this), var1, null);
      } else {
         this.a(new zzm(this));
      }
   }

   public final Context s() {
      return this.j;
   }

   protected Bundle t() {
      return new Bundle();
   }

   protected final void u() {
      if (!this.g()) {
         throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
      }
   }

   public final T v() throws DeadObjectException {
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
      // 01: getfield com/google/android/gms/common/internal/zzd.n Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/common/internal/zzd.t I
      // 0b: bipush 5
      // 0c: if_icmpne 1e
      // 0f: new android/os/DeadObjectException
      // 12: astore 3
      // 13: aload 3
      // 14: invokespecial android/os/DeadObjectException.<init> ()V
      // 17: aload 3
      // 18: athrow
      // 19: astore 3
      // 1a: aload 2
      // 1b: monitorexit
      // 1c: aload 3
      // 1d: athrow
      // 1e: aload 0
      // 1f: invokevirtual com/google/android/gms/common/internal/zzd.u ()V
      // 22: aload 0
      // 23: getfield com/google/android/gms/common/internal/zzd.q Landroid/os/IInterface;
      // 26: ifnull 3b
      // 29: bipush 1
      // 2a: istore 1
      // 2b: iload 1
      // 2c: ldc_w "Client is connected but service is null"
      // 2f: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 32: aload 0
      // 33: getfield com/google/android/gms/common/internal/zzd.q Landroid/os/IInterface;
      // 36: astore 3
      // 37: aload 2
      // 38: monitorexit
      // 39: aload 3
      // 3a: areturn
      // 3b: bipush 0
      // 3c: istore 1
      // 3d: goto 2b
      // try (5 -> 15): 15 null
      // try (16 -> 18): 15 null
      // try (20 -> 25): 15 null
      // try (27 -> 35): 15 null
   }

   public boolean w() {
      return false;
   }
}
