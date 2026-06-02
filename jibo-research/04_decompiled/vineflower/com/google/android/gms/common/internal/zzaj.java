package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import java.util.HashSet;
import java.util.Set;

final class zzaj implements ServiceConnection {
   private final Set<ServiceConnection> a;
   private int b;
   private boolean c;
   private IBinder d;
   private final zzah e;
   private ComponentName f;
   private zzai g;

   public zzaj(zzai var1, zzah var2) {
      this.g = var1;
      super();
      this.e = var2;
      this.a = new HashSet<>();
      this.b = 2;
   }

   public final void a(ServiceConnection var1, String var2) {
      zzai.d(this.g);
      zzai.c(this.g);
      this.e.d();
      this.a.add(var1);
   }

   public final void a(String var1) {
      this.b = 3;
      this.c = zzai.d(this.g).a(zzai.c(this.g), var1, this.e.d(), this, this.e.c());
      if (this.c) {
         Message var3 = zzai.b(this.g).obtainMessage(1, this.e);
         zzai.b(this.g).sendMessageDelayed(var3, zzai.e(this.g));
      } else {
         this.b = 2;

         try {
            zzai.d(this.g);
            zzai.c(this.g).unbindService(this);
         } catch (IllegalArgumentException var2) {
         }
      }
   }

   public final boolean a() {
      return this.c;
   }

   public final boolean a(ServiceConnection var1) {
      return this.a.contains(var1);
   }

   public final int b() {
      return this.b;
   }

   public final void b(ServiceConnection var1, String var2) {
      zzai.d(this.g);
      zzai.c(this.g);
      this.a.remove(var1);
   }

   public final void b(String var1) {
      zzai.b(this.g).removeMessages(1, this.e);
      zzai.d(this.g);
      zzai.c(this.g).unbindService(this);
      this.c = false;
      this.b = 2;
   }

   public final boolean c() {
      return this.a.isEmpty();
   }

   public final IBinder d() {
      return this.d;
   }

   public final ComponentName e() {
      return this.f;
   }

   public final void onServiceConnected(ComponentName param1, IBinder param2) {
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
      // 01: getfield com/google/android/gms/common/internal/zzaj.g Lcom/google/android/gms/common/internal/zzai;
      // 04: invokestatic com/google/android/gms/common/internal/zzai.a (Lcom/google/android/gms/common/internal/zzai;)Ljava/util/HashMap;
      // 07: astore 3
      // 08: aload 3
      // 09: monitorenter
      // 0a: aload 0
      // 0b: getfield com/google/android/gms/common/internal/zzaj.g Lcom/google/android/gms/common/internal/zzai;
      // 0e: invokestatic com/google/android/gms/common/internal/zzai.b (Lcom/google/android/gms/common/internal/zzai;)Landroid/os/Handler;
      // 11: bipush 1
      // 12: aload 0
      // 13: getfield com/google/android/gms/common/internal/zzaj.e Lcom/google/android/gms/common/internal/zzah;
      // 16: invokevirtual android/os/Handler.removeMessages (ILjava/lang/Object;)V
      // 19: aload 0
      // 1a: aload 2
      // 1b: putfield com/google/android/gms/common/internal/zzaj.d Landroid/os/IBinder;
      // 1e: aload 0
      // 1f: aload 1
      // 20: putfield com/google/android/gms/common/internal/zzaj.f Landroid/content/ComponentName;
      // 23: aload 0
      // 24: getfield com/google/android/gms/common/internal/zzaj.a Ljava/util/Set;
      // 27: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 2c: astore 4
      // 2e: aload 4
      // 30: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 35: ifeq 51
      // 38: aload 4
      // 3a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 3f: checkcast android/content/ServiceConnection
      // 42: aload 1
      // 43: aload 2
      // 44: invokeinterface android/content/ServiceConnection.onServiceConnected (Landroid/content/ComponentName;Landroid/os/IBinder;)V 3
      // 49: goto 2e
      // 4c: astore 1
      // 4d: aload 3
      // 4e: monitorexit
      // 4f: aload 1
      // 50: athrow
      // 51: aload 0
      // 52: bipush 1
      // 53: putfield com/google/android/gms/common/internal/zzaj.b I
      // 56: aload 3
      // 57: monitorexit
      // 58: return
      // try (6 -> 23): 33 null
      // try (23 -> 32): 33 null
      // try (34 -> 36): 33 null
      // try (38 -> 43): 33 null
   }

   public final void onServiceDisconnected(ComponentName param1) {
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
      // 01: getfield com/google/android/gms/common/internal/zzaj.g Lcom/google/android/gms/common/internal/zzai;
      // 04: invokestatic com/google/android/gms/common/internal/zzai.a (Lcom/google/android/gms/common/internal/zzai;)Ljava/util/HashMap;
      // 07: astore 2
      // 08: aload 2
      // 09: monitorenter
      // 0a: aload 0
      // 0b: getfield com/google/android/gms/common/internal/zzaj.g Lcom/google/android/gms/common/internal/zzai;
      // 0e: invokestatic com/google/android/gms/common/internal/zzai.b (Lcom/google/android/gms/common/internal/zzai;)Landroid/os/Handler;
      // 11: bipush 1
      // 12: aload 0
      // 13: getfield com/google/android/gms/common/internal/zzaj.e Lcom/google/android/gms/common/internal/zzah;
      // 16: invokevirtual android/os/Handler.removeMessages (ILjava/lang/Object;)V
      // 19: aload 0
      // 1a: aconst_null
      // 1b: putfield com/google/android/gms/common/internal/zzaj.d Landroid/os/IBinder;
      // 1e: aload 0
      // 1f: aload 1
      // 20: putfield com/google/android/gms/common/internal/zzaj.f Landroid/content/ComponentName;
      // 23: aload 0
      // 24: getfield com/google/android/gms/common/internal/zzaj.a Ljava/util/Set;
      // 27: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 2c: astore 3
      // 2d: aload 3
      // 2e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 33: ifeq 4d
      // 36: aload 3
      // 37: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 3c: checkcast android/content/ServiceConnection
      // 3f: aload 1
      // 40: invokeinterface android/content/ServiceConnection.onServiceDisconnected (Landroid/content/ComponentName;)V 2
      // 45: goto 2d
      // 48: astore 1
      // 49: aload 2
      // 4a: monitorexit
      // 4b: aload 1
      // 4c: athrow
      // 4d: aload 0
      // 4e: bipush 2
      // 4f: putfield com/google/android/gms/common/internal/zzaj.b I
      // 52: aload 2
      // 53: monitorexit
      // 54: return
      // try (6 -> 23): 32 null
      // try (23 -> 31): 32 null
      // try (33 -> 35): 32 null
      // try (37 -> 42): 32 null
   }
}
