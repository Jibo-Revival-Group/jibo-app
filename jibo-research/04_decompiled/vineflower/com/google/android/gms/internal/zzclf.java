package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Handler;

public final class zzclf extends zzcjl {
   private Handler a;
   private long b;
   private final zzcgs c = new zzclg(this, this.p);
   private final zzcgs d = new zzclh(this, this.p);

   zzclf(zzcim var1) {
      super(var1);
      this.b = this.k().b();
   }

   private final void a(long var1) {
      this.c();
      this.y();
      this.c.c();
      this.d.c();
      this.t().E().a("Activity resumed, time", var1);
      this.b = var1;
      if (this.k().a() - this.u().k.a() > this.u().m.a()) {
         this.u().l.a(true);
         this.u().n.a(0L);
      }

      if (this.u().l.a()) {
         this.c.a(Math.max(0L, this.u().j.a() - this.u().n.a()));
      } else {
         this.d.a(Math.max(0L, 3600000L - this.u().n.a()));
      }
   }

   private final void b(long var1) {
      this.c();
      this.y();
      this.c.c();
      this.d.c();
      this.t().E().a("Activity paused, time", var1);
      if (this.b != 0L) {
         this.u().n.a(this.u().n.a() + (var1 - this.b));
      }
   }

   private final void y() {
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
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/google/android/gms/internal/zzclf.a Landroid/os/Handler;
      // 06: ifnonnull 19
      // 09: new android/os/Handler
      // 0c: astore 1
      // 0d: aload 1
      // 0e: invokestatic android/os/Looper.getMainLooper ()Landroid/os/Looper;
      // 11: invokespecial android/os/Handler.<init> (Landroid/os/Looper;)V
      // 14: aload 0
      // 15: aload 1
      // 16: putfield com/google/android/gms/internal/zzclf.a Landroid/os/Handler;
      // 19: aload 0
      // 1a: monitorexit
      // 1b: return
      // 1c: astore 1
      // 1d: aload 0
      // 1e: monitorexit
      // 1f: aload 1
      // 20: athrow
      // try (2 -> 13): 16 null
      // try (13 -> 15): 16 null
      // try (17 -> 19): 16 null
   }

   private final void z() {
      this.c();
      this.a(false);
      this.d().a(this.k().b());
   }

   public final boolean a(boolean var1) {
      this.c();
      this.Q();
      long var4 = this.k().b();
      this.u().m.a(this.k().a());
      long var2 = var4 - this.b;
      if (!var1 && var2 < 1000L) {
         this.t().E().a("Screen exposed for less than 1000 ms. Event not sent. time", var2);
         var1 = false;
      } else {
         this.u().n.a(var2);
         this.t().E().a("Recording user engagement, ms", var2);
         Bundle var6 = new Bundle();
         var6.putLong("_et", var2);
         zzckc.a(this.j().y(), var6);
         this.f().a("auto", "_e", var6);
         this.b = var4;
         this.d.c();
         this.d.a(Math.max(0L, 3600000L - this.u().n.a()));
         var1 = true;
      }

      return var1;
   }

   @Override
   protected final boolean w() {
      return false;
   }
}
