package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzh;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.perf.FirebasePerformance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public class zzevz {
   private static volatile zzevz a;
   private final ThreadPoolExecutor b;
   private FirebaseApp c;
   private FirebasePerformance d;
   private Context e;
   private zzbdy f;
   private String g;
   private zzews h;
   private zzewh i;
   private zzevw j;
   private boolean k;

   private zzevz(ThreadPoolExecutor var1) {
      this.b = var1;
      this.b.execute(new zzewa(this));
   }

   public static zzevz a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: getstatic com/google/android/gms/internal/zzevz.a Lcom/google/android/gms/internal/zzevz;
      // 03: ifnonnull 45
      // 06: ldc com/google/android/gms/internal/zzevz
      // 08: monitorenter
      // 09: getstatic com/google/android/gms/internal/zzevz.a Lcom/google/android/gms/internal/zzevz;
      // 0c: astore 0
      // 0d: aload 0
      // 0e: ifnonnull 42
      // 11: invokestatic com/google/firebase/FirebaseApp.d ()Lcom/google/firebase/FirebaseApp;
      // 14: pop
      // 15: new java/util/concurrent/ThreadPoolExecutor
      // 18: astore 0
      // 19: getstatic java/util/concurrent/TimeUnit.SECONDS Ljava/util/concurrent/TimeUnit;
      // 1c: astore 2
      // 1d: new java/util/concurrent/LinkedBlockingQueue
      // 20: astore 1
      // 21: aload 1
      // 22: invokespecial java/util/concurrent/LinkedBlockingQueue.<init> ()V
      // 25: aload 0
      // 26: bipush 1
      // 27: bipush 1
      // 28: ldc2_w 10
      // 2b: aload 2
      // 2c: aload 1
      // 2d: invokespecial java/util/concurrent/ThreadPoolExecutor.<init> (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V
      // 30: aload 0
      // 31: bipush 1
      // 32: invokevirtual java/util/concurrent/ThreadPoolExecutor.allowCoreThreadTimeOut (Z)V
      // 35: new com/google/android/gms/internal/zzevz
      // 38: astore 1
      // 39: aload 1
      // 3a: aload 0
      // 3b: invokespecial com/google/android/gms/internal/zzevz.<init> (Ljava/util/concurrent/ThreadPoolExecutor;)V
      // 3e: aload 1
      // 3f: putstatic com/google/android/gms/internal/zzevz.a Lcom/google/android/gms/internal/zzevz;
      // 42: ldc com/google/android/gms/internal/zzevz
      // 44: monitorexit
      // 45: getstatic com/google/android/gms/internal/zzevz.a Lcom/google/android/gms/internal/zzevz;
      // 48: astore 0
      // 49: aload 0
      // 4a: areturn
      // 4b: astore 0
      // 4c: aconst_null
      // 4d: astore 0
      // 4e: ldc com/google/android/gms/internal/zzevz
      // 50: monitorexit
      // 51: goto 49
      // 54: astore 0
      // 55: ldc com/google/android/gms/internal/zzevz
      // 57: monitorexit
      // 58: aload 0
      // 59: athrow
      // try (4 -> 6): 47 null
      // try (8 -> 10): 41 java/lang/IllegalStateException
      // try (8 -> 10): 47 null
      // try (10 -> 35): 47 null
      // try (35 -> 37): 47 null
      // try (44 -> 46): 47 null
      // try (48 -> 50): 47 null
   }

   private static String a(Context var0) {
      try {
         var2 = var0.getPackageManager().getPackageInfo(var0.getPackageName(), 0).versionName;
      } catch (NameNotFoundException var1) {
         var2 = "";
      }

      return var2;
   }

   private final void a(zzewx var1) {
      if (this.f != null) {
         if (this.h.b == null) {
            this.h.b = FirebaseInstanceId.a().c();
         }

         boolean var2;
         if (this.h.b == null) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         if (var2) {
            Log.w("FirebasePerformance", "App Instance ID is null, dropping the log.");
         } else if (this.d.b()) {
            ArrayList var4 = new ArrayList();
            if (var1.b != null) {
               var4.add(new zzewf(var1.b));
            }

            if (var1.c != null) {
               var4.add(new zzewe(var1.c));
            }

            if (var1.a != null) {
               var4.add(new zzevy(var1.a));
            }

            if (var4.isEmpty()) {
               Log.d("FirebasePerformance", "No validators found for PerfMetric.");
               var2 = (boolean)0;
            } else {
               ArrayList var5 = var4;
               int var3 = var5.size();
               var2 = 0;

               while (true) {
                  if (var2 >= var3) {
                     var2 = (boolean)1;
                     break;
                  }

                  Object var9 = var5.get(var2);
                  var2++;
                  if (!((zzewg)var9).a()) {
                     var2 = (boolean)0;
                     break;
                  }
               }
            }

            if (!var2) {
               Log.i(
                  "FirebasePerformance",
                  "Unable to process an HTTP request/response due to missing or invalid values. See earlier log statements for additional information on the specific invalid/missing values."
               );
            } else if (!this.i.a(var1)) {
               if (var1.c != null) {
                  this.j.a(zzewl.zzoeo.toString(), 1L);
               } else if (var1.b != null) {
                  this.j.a(zzewl.zzoen.toString(), 1L);
               }
            } else {
               byte[] var6 = zzfjs.a(var1);
               this.f.a(var6).a();
            }
         }
      }
   }

   private final void b() {
      this.c = FirebaseApp.d();
      this.d = FirebasePerformance.a();
      this.e = this.c.a();
      this.g = this.c.c().a();
      this.h = new zzews();
      this.h.a = this.g;
      this.h.b = FirebaseInstanceId.a().c();
      this.h.c = new zzewr();
      this.h.c.a = this.e.getPackageName();
      this.h.c.b = "1.0.0.178131943";
      this.h.c.c = a(this.e);

      try {
         Context var1 = this.e;
         zzbee var4 = zzbej.a(var1);
         zzd var5 = zzh.d();
         zzbeu var2 = new zzbeu(var1);
         zzbdy var3 = new zzbdy(var1, -1, "FIREPERF", null, null, true, var4, var5, null, var2);
         this.f = var3;
      } catch (SecurityException var6) {
         Log.i("FirebasePerformance", "Caught SecurityException while init ClearcutLogger.");
         this.f = null;
      }

      this.i = new zzewh(this.e, this.g, 100L, 500L);
      this.j = zzevw.a();
      this.k = zzewq.a(this.e);
   }

   private final void b(zzewv var1, int var2) {
      long var5 = 0L;
      if (this.d.b()) {
         if (this.k) {
            long var3;
            if (var1.k == null) {
               var3 = 0L;
            } else {
               var3 = var1.k;
            }

            if (var1.d != null) {
               var5 = var1.d;
            }

            Log.i("FirebasePerformance", String.format("Logging NetworkRequestMetric - %s %db %dms,", var1.a, var5, var3 / 1000L));
         }

         zzewx var7 = new zzewx();
         var7.a = this.h;
         var7.a.d = var2;
         var7.c = var1;
         this.a(var7);
      }
   }

   private final void b(zzewy var1, int var2) {
      byte var3 = 0;
      if (this.d.b()) {
         if (this.k) {
            long var4;
            if (var1.c == null) {
               var4 = 0L;
            } else {
               var4 = var1.c;
            }

            Log.i("FirebasePerformance", String.format("Logging TraceMetric - %s %dms", var1.a, var4 / 1000L));
         }

         zzewx var6 = new zzewx();
         var6.a = this.h;
         var6.a.d = var2;
         var6.b = var1;
         Map var11 = FirebasePerformance.a().c();
         if (!var11.isEmpty()) {
            var6.a.e = new zzewt[var11.size()];
            Iterator var8 = var11.keySet().iterator();

            for (int var12 = var3; var8.hasNext(); var12++) {
               String var7 = (String)var8.next();
               String var9 = (String)var11.get(var7);
               zzewt var10 = new zzewt();
               var10.a = var7;
               var10.b = var9;
               var6.a.e[var12] = var10;
            }
         }

         this.a(var6);
      }
   }

   public final void a(zzewv var1, int var2) {
      try {
         byte[] var3 = zzfjs.a(var1);
         var1 = new zzewv();
         zzfjs.a(var1, var3);
         ThreadPoolExecutor var7 = this.b;
         zzewc var4 = new zzewc(this, var1, var2);
         var7.execute(var4);
      } catch (zzfjr var5) {
         Log.w("FirebasePerformance", "Clone NetworkRequestMetric throws exception", var5);
      }
   }

   public final void a(zzewy var1, int var2) {
      try {
         byte[] var3 = zzfjs.a(var1);
         var1 = new zzewy();
         zzfjs.a(var1, var3);
         ThreadPoolExecutor var8 = this.b;
         zzewb var4 = new zzewb(this, var1, var2);
         var8.execute(var4);
      } catch (zzfjr var5) {
         String var6 = String.valueOf(var5);
         Log.w(
            "FirebasePerformance", new StringBuilder(String.valueOf(var6).length() + 35).append("Clone TraceMetric throws exception ").append(var6).toString()
         );
      }
   }

   public final void a(boolean var1) {
      this.b.execute(new zzewd(this, var1));
   }

   public final void b(boolean var1) {
      this.i.a(var1);
   }
}
