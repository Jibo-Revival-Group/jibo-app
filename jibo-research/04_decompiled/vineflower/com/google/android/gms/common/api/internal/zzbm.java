package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Handler.Callback;
import android.support.v4.util.ArraySet;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.tasks.Task;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzbm implements Callback {
   public static final Status a = new Status(4, "Sign-out occurred while this API call was in progress.");
   private static final Status b = new Status(4, "The user must be signed in to make this API call.");
   private static final Object f = new Object();
   private static zzbm g;
   private long c = 5000L;
   private long d = 120000L;
   private long e = 10000L;
   private final Context h;
   private final GoogleApiAvailability i;
   private int j = -1;
   private final AtomicInteger k = new AtomicInteger(1);
   private final AtomicInteger l = new AtomicInteger(0);
   private final Map<zzh<?>, zzbo<?>> m = new ConcurrentHashMap<>(5, 0.75F, 1);
   private zzah n = null;
   private final Set<zzh<?>> o = new ArraySet<>();
   private final Set<zzh<?>> p = new ArraySet<>();
   private final Handler q;

   private zzbm(Context var1, Looper var2, GoogleApiAvailability var3) {
      this.h = var1;
      this.q = new Handler(var2, this);
      this.i = var3;
      this.q.sendMessage(this.q.obtainMessage(6));
   }

   public static zzbm a() {
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
      // 00: getstatic com/google/android/gms/common/api/internal/zzbm.f Ljava/lang/Object;
      // 03: astore 0
      // 04: aload 0
      // 05: monitorenter
      // 06: getstatic com/google/android/gms/common/api/internal/zzbm.g Lcom/google/android/gms/common/api/internal/zzbm;
      // 09: ldc "Must guarantee manager is non-null before using getInstance"
      // 0b: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 0e: pop
      // 0f: getstatic com/google/android/gms/common/api/internal/zzbm.g Lcom/google/android/gms/common/api/internal/zzbm;
      // 12: astore 1
      // 13: aload 0
      // 14: monitorexit
      // 15: aload 1
      // 16: areturn
      // 17: astore 1
      // 18: aload 0
      // 19: monitorexit
      // 1a: aload 1
      // 1b: athrow
      // try (4 -> 12): 14 null
      // try (15 -> 17): 14 null
   }

   public static zzbm a(Context param0) {
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
      // 00: getstatic com/google/android/gms/common/api/internal/zzbm.f Ljava/lang/Object;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/google/android/gms/common/api/internal/zzbm.g Lcom/google/android/gms/common/api/internal/zzbm;
      // 09: ifnonnull 35
      // 0c: new android/os/HandlerThread
      // 0f: astore 2
      // 10: aload 2
      // 11: ldc "GoogleApiHandler"
      // 13: bipush 9
      // 15: invokespecial android/os/HandlerThread.<init> (Ljava/lang/String;I)V
      // 18: aload 2
      // 19: invokevirtual android/os/HandlerThread.start ()V
      // 1c: aload 2
      // 1d: invokevirtual android/os/HandlerThread.getLooper ()Landroid/os/Looper;
      // 20: astore 2
      // 21: new com/google/android/gms/common/api/internal/zzbm
      // 24: astore 3
      // 25: aload 3
      // 26: aload 0
      // 27: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 2a: aload 2
      // 2b: invokestatic com/google/android/gms/common/GoogleApiAvailability.a ()Lcom/google/android/gms/common/GoogleApiAvailability;
      // 2e: invokespecial com/google/android/gms/common/api/internal/zzbm.<init> (Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/common/GoogleApiAvailability;)V
      // 31: aload 3
      // 32: putstatic com/google/android/gms/common/api/internal/zzbm.g Lcom/google/android/gms/common/api/internal/zzbm;
      // 35: getstatic com/google/android/gms/common/api/internal/zzbm.g Lcom/google/android/gms/common/api/internal/zzbm;
      // 38: astore 0
      // 39: aload 1
      // 3a: monitorexit
      // 3b: aload 0
      // 3c: areturn
      // 3d: astore 0
      // 3e: aload 1
      // 3f: monitorexit
      // 40: aload 0
      // 41: athrow
      // try (4 -> 27): 33 null
      // try (27 -> 31): 33 null
      // try (34 -> 36): 33 null
   }

   public static void b() {
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
      // 00: getstatic com/google/android/gms/common/api/internal/zzbm.f Ljava/lang/Object;
      // 03: astore 0
      // 04: aload 0
      // 05: monitorenter
      // 06: getstatic com/google/android/gms/common/api/internal/zzbm.g Lcom/google/android/gms/common/api/internal/zzbm;
      // 09: ifnull 29
      // 0c: getstatic com/google/android/gms/common/api/internal/zzbm.g Lcom/google/android/gms/common/api/internal/zzbm;
      // 0f: astore 1
      // 10: aload 1
      // 11: getfield com/google/android/gms/common/api/internal/zzbm.l Ljava/util/concurrent/atomic/AtomicInteger;
      // 14: invokevirtual java/util/concurrent/atomic/AtomicInteger.incrementAndGet ()I
      // 17: pop
      // 18: aload 1
      // 19: getfield com/google/android/gms/common/api/internal/zzbm.q Landroid/os/Handler;
      // 1c: aload 1
      // 1d: getfield com/google/android/gms/common/api/internal/zzbm.q Landroid/os/Handler;
      // 20: bipush 10
      // 22: invokevirtual android/os/Handler.obtainMessage (I)Landroid/os/Message;
      // 25: invokevirtual android/os/Handler.sendMessageAtFrontOfQueue (Landroid/os/Message;)Z
      // 28: pop
      // 29: aload 0
      // 2a: monitorexit
      // 2b: return
      // 2c: astore 1
      // 2d: aload 0
      // 2e: monitorexit
      // 2f: aload 1
      // 30: athrow
      // try (4 -> 20): 23 null
      // try (20 -> 22): 23 null
      // try (24 -> 26): 23 null
   }

   private final void b(GoogleApi<?> var1) {
      zzh var4 = var1.b();
      zzbo var3 = this.m.get(var4);
      zzbo var2 = var3;
      if (var3 == null) {
         var2 = new zzbo(this, var1);
         this.m.put(var4, var2);
      }

      if (var2.k()) {
         this.p.add(var4);
      }

      var2.i();
   }

   private final void h() {
      for (zzh var2 : this.p) {
         this.m.remove(var2).a();
      }

      this.p.clear();
   }

   final PendingIntent a(zzh<?> var1, int var2) {
      zzbo var3 = this.m.get(var1);
      PendingIntent var4;
      if (var3 == null) {
         var4 = null;
      } else {
         zzcxd var5 = var3.m();
         if (var5 == null) {
            var4 = null;
         } else {
            var4 = PendingIntent.getActivity(this.h, var2, var5.d(), 134217728);
         }
      }

      return var4;
   }

   public final Task<Map<zzh<?>, String>> a(Iterable<? extends GoogleApi<?>> var1) {
      zzj var2 = new zzj(var1);
      Iterator var3 = var1.iterator();

      while (true) {
         if (var3.hasNext()) {
            GoogleApi var4 = (GoogleApi)var3.next();
            zzbo var6 = this.m.get(var4.b());
            if (var6 != null && var6.j()) {
               var2.a(var4.b(), ConnectionResult.a, var6.b().l());
               continue;
            }

            this.q.sendMessage(this.q.obtainMessage(2, var2));
            var5 = var2.b();
            break;
         }

         var5 = var2.b();
         break;
      }

      return var5;
   }

   public final void a(GoogleApi<?> var1) {
      this.q.sendMessage(this.q.obtainMessage(7, var1));
   }

   public final <O extends Api.ApiOptions> void a(GoogleApi<O> var1, int var2, zzm<? extends Result, Api.zzb> var3) {
      zzc var4 = new zzc(var2, var3);
      this.q.sendMessage(this.q.obtainMessage(4, new zzcp(var4, this.l.get(), var1)));
   }

   public final void a(zzah param1) {
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
      // 00: getstatic com/google/android/gms/common/api/internal/zzbm.f Ljava/lang/Object;
      // 03: astore 2
      // 04: aload 2
      // 05: monitorenter
      // 06: aload 0
      // 07: getfield com/google/android/gms/common/api/internal/zzbm.n Lcom/google/android/gms/common/api/internal/zzah;
      // 0a: aload 1
      // 0b: if_acmpeq 2a
      // 0e: aload 0
      // 0f: aload 1
      // 10: putfield com/google/android/gms/common/api/internal/zzbm.n Lcom/google/android/gms/common/api/internal/zzah;
      // 13: aload 0
      // 14: getfield com/google/android/gms/common/api/internal/zzbm.o Ljava/util/Set;
      // 17: invokeinterface java/util/Set.clear ()V 1
      // 1c: aload 0
      // 1d: getfield com/google/android/gms/common/api/internal/zzbm.o Ljava/util/Set;
      // 20: aload 1
      // 21: invokevirtual com/google/android/gms/common/api/internal/zzah.g ()Landroid/support/v4/util/ArraySet;
      // 24: invokeinterface java/util/Set.addAll (Ljava/util/Collection;)Z 2
      // 29: pop
      // 2a: aload 2
      // 2b: monitorexit
      // 2c: return
      // 2d: astore 1
      // 2e: aload 2
      // 2f: monitorexit
      // 30: aload 1
      // 31: athrow
      // try (4 -> 20): 23 null
      // try (20 -> 22): 23 null
      // try (24 -> 26): 23 null
   }

   final boolean a(ConnectionResult var1, int var2) {
      return this.i.a(this.h, var1, var2);
   }

   public final void b(ConnectionResult var1, int var2) {
      if (!this.a(var1, var2)) {
         this.q.sendMessage(this.q.obtainMessage(5, var2, 0, var1));
      }
   }

   final void b(zzah param1) {
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
      // 00: getstatic com/google/android/gms/common/api/internal/zzbm.f Ljava/lang/Object;
      // 03: astore 2
      // 04: aload 2
      // 05: monitorenter
      // 06: aload 0
      // 07: getfield com/google/android/gms/common/api/internal/zzbm.n Lcom/google/android/gms/common/api/internal/zzah;
      // 0a: aload 1
      // 0b: if_acmpne 1c
      // 0e: aload 0
      // 0f: aconst_null
      // 10: putfield com/google/android/gms/common/api/internal/zzbm.n Lcom/google/android/gms/common/api/internal/zzah;
      // 13: aload 0
      // 14: getfield com/google/android/gms/common/api/internal/zzbm.o Ljava/util/Set;
      // 17: invokeinterface java/util/Set.clear ()V 1
      // 1c: aload 2
      // 1d: monitorexit
      // 1e: return
      // 1f: astore 1
      // 20: aload 2
      // 21: monitorexit
      // 22: aload 1
      // 23: athrow
      // try (4 -> 14): 17 null
      // try (14 -> 16): 17 null
      // try (18 -> 20): 17 null
   }

   public final int c() {
      return this.k.getAndIncrement();
   }

   public final void d() {
      this.q.sendMessage(this.q.obtainMessage(3));
   }

   final void e() {
      this.l.incrementAndGet();
      this.q.sendMessage(this.q.obtainMessage(10));
   }

   public final boolean handleMessage(Message var1) {
      switch (var1.what) {
         case 1:
            long var4;
            if ((Boolean)var1.obj) {
               var4 = 10000L;
            } else {
               var4 = 300000L;
            }

            this.e = var4;
            this.q.removeMessages(12);

            for (zzh var13 : this.m.keySet()) {
               this.q.sendMessageDelayed(this.q.obtainMessage(12, var13), this.e);
            }
            break;
         case 2:
            zzj var18 = (zzj)var1.obj;

            for (zzh var22 : var18.a()) {
               zzbo var8 = this.m.get(var22);
               if (var8 == null) {
                  var18.a(var22, new ConnectionResult(13), null);
                  return true;
               }

               if (var8.j()) {
                  var18.a(var22, ConnectionResult.a, var8.b().l());
               } else if (var8.e() != null) {
                  var18.a(var22, var8.e(), null);
               } else {
                  var8.a(var18);
               }
            }
            break;
         case 3:
            for (zzbo var17 : this.m.values()) {
               var17.d();
               var17.i();
            }
            break;
         case 4:
         case 8:
         case 13:
            zzcp var21 = (zzcp)var1.obj;
            zzbo var16 = this.m.get(var21.c.b());
            zzbo var10 = var16;
            if (var16 == null) {
               this.b(var21.c);
               var10 = this.m.get(var21.c.b());
            }

            if (var10.k() && this.l.get() != var21.b) {
               var21.a.a(a);
               var10.a();
            } else {
               var10.a(var21.a);
            }
            break;
         case 5:
            int var14 = var1.arg1;
            ConnectionResult var6 = (ConnectionResult)var1.obj;
            Iterator var7 = this.m.values().iterator();

            do {
               if (!var7.hasNext()) {
                  var9 = null;
                  break;
               }

               var9 = (zzbo)var7.next();
            } while (var9.l() != var14);

            if (var9 != null) {
               String var20 = this.i.b(var6.c());
               String var15 = var6.e();
               var9.a(
                  new Status(
                     17,
                     new StringBuilder(String.valueOf(var20).length() + 69 + String.valueOf(var15).length())
                        .append("Error resolution was canceled by the user, original error message: ")
                        .append(var20)
                        .append(": ")
                        .append(var15)
                        .toString()
                  )
               );
            } else {
               Log.wtf(
                  "GoogleApiManager",
                  new StringBuilder(76).append("Could not find API instance ").append(var14).append(" while trying to fail enqueued calls.").toString(),
                  new Exception()
               );
            }
            break;
         case 6:
            if (this.h.getApplicationContext() instanceof Application) {
               zzk.a((Application)this.h.getApplicationContext());
               zzk.a().a(new zzbn(this));
               if (!zzk.a().a(true)) {
                  this.e = 300000L;
               }
            }
            break;
         case 7:
            this.b((GoogleApi<?>)var1.obj);
            break;
         case 9:
            if (this.m.containsKey(var1.obj)) {
               this.m.get(var1.obj).f();
            }
            break;
         case 10:
            this.h();
            break;
         case 11:
            if (this.m.containsKey(var1.obj)) {
               this.m.get(var1.obj).g();
            }
            break;
         case 12:
            if (this.m.containsKey(var1.obj)) {
               this.m.get(var1.obj).h();
            }
            break;
         default:
            int var2 = var1.what;
            Log.w("GoogleApiManager", new StringBuilder(31).append("Unknown message id: ").append(var2).toString());
            return false;
      }

      return true;
   }
}
