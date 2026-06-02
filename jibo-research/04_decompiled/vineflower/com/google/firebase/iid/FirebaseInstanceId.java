package com.google.firebase.iid;

import android.os.Bundle;
import android.os.Looper;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FirebaseInstanceId {
   private static final long a = TimeUnit.HOURS.toSeconds(8L);
   private static Map<String, FirebaseInstanceId> b = new ArrayMap<>();
   private static zzy c;
   private static ScheduledThreadPoolExecutor d;
   private final FirebaseApp e;
   private final zzu f;
   private final zzv g;
   private KeyPair h;
   private boolean i = false;

   private FirebaseInstanceId(FirebaseApp var1) {
      this.e = var1;
      if (zzu.a(var1) == null) {
         throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
      }

      this.f = new zzu(var1.a());
      this.g = new zzv(var1.a(), this.f);
      zzz var2 = this.e();
      if (var2 == null || var2.b(this.f.b()) || c.a() != null) {
         this.k();
      }
   }

   public static FirebaseInstanceId a() {
      return getInstance(FirebaseApp.d());
   }

   private final String a(String var1, String var2, Bundle var3) throws IOException {
      var3.putString("scope", var2);
      var3.putString("sender", var1);
      var3.putString("subtype", var1);
      var3.putString("appid", this.c());
      var3.putString("gmp_app_id", this.e.c().a());
      var3.putString("gmsv", Integer.toString(this.f.d()));
      var3.putString("osv", Integer.toString(VERSION.SDK_INT));
      var3.putString("app_ver", this.f.b());
      var3.putString("app_ver_name", this.f.c());
      var3.putString("cliv", "fiid-11910000");
      var3 = this.g.a(var3);
      if (var3 == null) {
         throw new IOException("SERVICE_NOT_AVAILABLE");
      }

      var1 = var3.getString("registration_id");
      if (var1 == null) {
         var2 = var3.getString("unregistered");
         var1 = var2;
         if (var2 == null) {
            var1 = var3.getString("error");
            if (var1 != null) {
               throw new IOException(var1);
            }

            var1 = String.valueOf(var3);
            Log.w(
               "FirebaseInstanceId",
               new StringBuilder(String.valueOf(var1).length() + 20).append("Unexpected response ").append(var1).toString(),
               new Throwable()
            );
            throw new IOException("SERVICE_NOT_AVAILABLE");
         }
      }

      if (!"RST".equals(var1) && !var1.startsWith("RST|")) {
         return var1;
      }

      this.i();
      throw new IOException("SERVICE_NOT_AVAILABLE");
   }

   static void a(Runnable param0, long param1) {
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
      // 00: ldc com/google/firebase/iid/FirebaseInstanceId
      // 02: monitorenter
      // 03: getstatic com/google/firebase/iid/FirebaseInstanceId.d Ljava/util/concurrent/ScheduledThreadPoolExecutor;
      // 06: ifnonnull 16
      // 09: new java/util/concurrent/ScheduledThreadPoolExecutor
      // 0c: astore 3
      // 0d: aload 3
      // 0e: bipush 1
      // 0f: invokespecial java/util/concurrent/ScheduledThreadPoolExecutor.<init> (I)V
      // 12: aload 3
      // 13: putstatic com/google/firebase/iid/FirebaseInstanceId.d Ljava/util/concurrent/ScheduledThreadPoolExecutor;
      // 16: getstatic com/google/firebase/iid/FirebaseInstanceId.d Ljava/util/concurrent/ScheduledThreadPoolExecutor;
      // 19: aload 0
      // 1a: lload 1
      // 1b: getstatic java/util/concurrent/TimeUnit.SECONDS Ljava/util/concurrent/TimeUnit;
      // 1e: invokevirtual java/util/concurrent/ScheduledThreadPoolExecutor.schedule (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
      // 21: pop
      // 22: ldc com/google/firebase/iid/FirebaseInstanceId
      // 24: monitorexit
      // 25: return
      // 26: astore 0
      // 27: ldc com/google/firebase/iid/FirebaseInstanceId
      // 29: monitorexit
      // 2a: aload 0
      // 2b: athrow
      // try (2 -> 11): 20 null
      // try (11 -> 19): 20 null
      // try (21 -> 23): 20 null
   }

   static zzy g() {
      return c;
   }

   @Keep
   public static FirebaseInstanceId getInstance(FirebaseApp param0) {
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
      // 00: ldc com/google/firebase/iid/FirebaseInstanceId
      // 02: monitorenter
      // 03: getstatic com/google/firebase/iid/FirebaseInstanceId.b Ljava/util/Map;
      // 06: aload 0
      // 07: invokevirtual com/google/firebase/FirebaseApp.c ()Lcom/google/firebase/FirebaseOptions;
      // 0a: invokevirtual com/google/firebase/FirebaseOptions.a ()Ljava/lang/String;
      // 0d: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 12: checkcast com/google/firebase/iid/FirebaseInstanceId
      // 15: astore 2
      // 16: aload 2
      // 17: astore 1
      // 18: aload 2
      // 19: ifnonnull 4c
      // 1c: getstatic com/google/firebase/iid/FirebaseInstanceId.c Lcom/google/firebase/iid/zzy;
      // 1f: ifnonnull 32
      // 22: new com/google/firebase/iid/zzy
      // 25: astore 1
      // 26: aload 1
      // 27: aload 0
      // 28: invokevirtual com/google/firebase/FirebaseApp.a ()Landroid/content/Context;
      // 2b: invokespecial com/google/firebase/iid/zzy.<init> (Landroid/content/Context;)V
      // 2e: aload 1
      // 2f: putstatic com/google/firebase/iid/FirebaseInstanceId.c Lcom/google/firebase/iid/zzy;
      // 32: new com/google/firebase/iid/FirebaseInstanceId
      // 35: astore 1
      // 36: aload 1
      // 37: aload 0
      // 38: invokespecial com/google/firebase/iid/FirebaseInstanceId.<init> (Lcom/google/firebase/FirebaseApp;)V
      // 3b: getstatic com/google/firebase/iid/FirebaseInstanceId.b Ljava/util/Map;
      // 3e: aload 0
      // 3f: invokevirtual com/google/firebase/FirebaseApp.c ()Lcom/google/firebase/FirebaseOptions;
      // 42: invokevirtual com/google/firebase/FirebaseOptions.a ()Ljava/lang/String;
      // 45: aload 1
      // 46: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 4b: pop
      // 4c: ldc com/google/firebase/iid/FirebaseInstanceId
      // 4e: monitorexit
      // 4f: aload 1
      // 50: areturn
      // 51: astore 0
      // 52: ldc com/google/firebase/iid/FirebaseInstanceId
      // 54: monitorexit
      // 55: aload 0
      // 56: athrow
      // try (2 -> 9): 39 null
      // try (13 -> 23): 39 null
      // try (23 -> 35): 39 null
   }

   static boolean h() {
      boolean var0;
      if (!Log.isLoggable("FirebaseInstanceId", 3) && (VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseInstanceId", 3))) {
         var0 = false;
      } else {
         var0 = true;
      }

      return var0;
   }

   private final void k() {
      synchronized (this) {
         if (!this.i) {
            this.a(0L);
         }
      }
   }

   private final void l() {
      c.c("");
      this.h = null;
   }

   public String a(String var1, String var2) throws IOException {
      if (Looper.getMainLooper() == Looper.myLooper()) {
         throw new IOException("MAIN_THREAD");
      }

      zzz var3 = c.a("", var1, var2);
      String var5;
      if (var3 != null && !var3.b(this.f.b())) {
         var5 = var3.a;
      } else {
         String var4 = this.a(var1, var2, new Bundle());
         var5 = var4;
         if (var4 != null) {
            c.a("", var1, var2, var4, this.f.b());
            var5 = var4;
         }
      }

      return var5;
   }

   final void a(long var1) {
      synchronized (this) {
         long var3 = Math.min(Math.max(30L, var1 << 1), a);
         zzaa var5 = new zzaa(this, this.f, var3);
         a(var5, var1);
         this.i = true;
      }
   }

   final void a(String var1) throws IOException {
      zzz var4 = this.e();
      if (var4 != null && !var4.b(this.f.b())) {
         Bundle var3 = new Bundle();
         String var2 = String.valueOf("/topics/");
         String var5 = String.valueOf(var1);
         if (var5.length() != 0) {
            var2 = var2.concat(var5);
         } else {
            var2 = new String(var2);
         }

         var3.putString("gcm.topic", var2);
         var2 = var4.a;
         String var10 = String.valueOf("/topics/");
         var1 = String.valueOf(var1);
         if (var1.length() != 0) {
            var1 = var10.concat(var1);
         } else {
            var1 = new String(var10);
         }

         this.a(var2, var1, var3);
      } else {
         throw new IOException("token not available");
      }
   }

   final void a(boolean var1) {
      synchronized (this) {
         this.i = var1;
      }
   }

   final FirebaseApp b() {
      return this.e;
   }

   final void b(String var1) throws IOException {
      zzz var4 = this.e();
      if (var4 != null && !var4.b(this.f.b())) {
         Bundle var3 = new Bundle();
         String var5 = String.valueOf("/topics/");
         String var2 = String.valueOf(var1);
         if (var2.length() != 0) {
            var2 = var5.concat(var2);
         } else {
            var2 = new String(var5);
         }

         var3.putString("gcm.topic", var2);
         var3.putString("delete", "1");
         var2 = var4.a;
         String var10 = String.valueOf("/topics/");
         var1 = String.valueOf(var1);
         if (var1.length() != 0) {
            var1 = var10.concat(var1);
         } else {
            var1 = new String(var10);
         }

         this.a(var2, var1, var3);
      } else {
         throw new IOException("token not available");
      }
   }

   public String c() {
      if (this.h == null) {
         this.h = c.e("");
      }

      if (this.h == null) {
         this.h = c.b("");
      }

      return zzu.a(this.h);
   }

   public String d() {
      zzz var1 = this.e();
      if (var1 == null || var1.b(this.f.b())) {
         this.k();
      }

      String var2;
      if (var1 != null) {
         var2 = var1.a;
      } else {
         var2 = null;
      }

      return var2;
   }

   final zzz e() {
      return c.a("", zzu.a(this.e), "*");
   }

   final String f() throws IOException {
      return this.a(zzu.a(this.e), "*");
   }

   final void i() {
      c.b();
      this.l();
      this.k();
   }

   final void j() {
      c.d("");
      this.k();
   }
}
