package io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.PriorityThreadPoolExecutor;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class Fabric {
   static volatile Fabric a;
   static final Logger b = new DefaultLogger();
   final Logger c;
   final boolean d;
   private final Context e;
   private final Map<Class<? extends Kit>, Kit> f;
   private final ExecutorService g;
   private final Handler h;
   private final InitializationCallback<Fabric> i;
   private final InitializationCallback<?> j;
   private final IdManager k;
   private ActivityLifecycleManager l;
   private WeakReference<Activity> m;
   private AtomicBoolean n;

   Fabric(
      Context var1,
      Map<Class<? extends Kit>, Kit> var2,
      PriorityThreadPoolExecutor var3,
      Handler var4,
      Logger var5,
      boolean var6,
      InitializationCallback var7,
      IdManager var8,
      Activity var9
   ) {
      this.e = var1;
      this.f = var2;
      this.g = var3;
      this.h = var4;
      this.c = var5;
      this.d = var6;
      this.i = var7;
      this.n = new AtomicBoolean(false);
      this.j = this.a(var2.size());
      this.k = var8;
      this.a(var9);
   }

   static Fabric a() {
      if (a == null) {
         throw new IllegalStateException("Must Initialize Fabric before using singleton()");
      } else {
         return a;
      }
   }

   public static Fabric a(Context param0, Kit... param1) {
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
      // 00: getstatic io/fabric/sdk/android/Fabric.a Lio/fabric/sdk/android/Fabric;
      // 03: ifnonnull 26
      // 06: ldc io/fabric/sdk/android/Fabric
      // 08: monitorenter
      // 09: getstatic io/fabric/sdk/android/Fabric.a Lio/fabric/sdk/android/Fabric;
      // 0c: ifnonnull 23
      // 0f: new io/fabric/sdk/android/Fabric$Builder
      // 12: astore 2
      // 13: aload 2
      // 14: aload 0
      // 15: invokespecial io/fabric/sdk/android/Fabric$Builder.<init> (Landroid/content/Context;)V
      // 18: aload 2
      // 19: aload 1
      // 1a: invokevirtual io/fabric/sdk/android/Fabric$Builder.a ([Lio/fabric/sdk/android/Kit;)Lio/fabric/sdk/android/Fabric$Builder;
      // 1d: invokevirtual io/fabric/sdk/android/Fabric$Builder.a ()Lio/fabric/sdk/android/Fabric;
      // 20: invokestatic io/fabric/sdk/android/Fabric.c (Lio/fabric/sdk/android/Fabric;)V
      // 23: ldc io/fabric/sdk/android/Fabric
      // 25: monitorexit
      // 26: getstatic io/fabric/sdk/android/Fabric.a Lio/fabric/sdk/android/Fabric;
      // 29: areturn
      // 2a: astore 0
      // 2b: ldc io/fabric/sdk/android/Fabric
      // 2d: monitorexit
      // 2e: aload 0
      // 2f: athrow
      // try (4 -> 16): 20 null
      // try (16 -> 18): 20 null
      // try (21 -> 23): 20 null
   }

   public static <T extends Kit> T a(Class<T> var0) {
      return (T)a().f.get(var0);
   }

   private static void a(Map<Class<? extends Kit>, Kit> var0, Collection<? extends Kit> var1) {
      for (Kit var3 : var1) {
         var0.put(var3.getClass(), var3);
         if (var3 instanceof KitGroup) {
            a(var0, ((KitGroup)var3).c());
         }
      }
   }

   private static Map<Class<? extends Kit>, Kit> b(Collection<? extends Kit> var0) {
      HashMap var1 = new HashMap(var0.size());
      a(var1, var0);
      return var1;
   }

   private static void c(Fabric var0) {
      a = var0;
      var0.j();
   }

   private static Activity d(Context var0) {
      Activity var1;
      if (var0 instanceof Activity) {
         var1 = (Activity)var0;
      } else {
         var1 = null;
      }

      return var1;
   }

   public static Logger h() {
      Logger var0;
      if (a == null) {
         var0 = b;
      } else {
         var0 = a.c;
      }

      return var0;
   }

   public static boolean i() {
      boolean var0;
      if (a == null) {
         var0 = false;
      } else {
         var0 = a.d;
      }

      return var0;
   }

   private void j() {
      this.l = new ActivityLifecycleManager(this.e);
      this.l.a(new ActivityLifecycleManager.Callbacks(this) {
         final Fabric a;

         {
            this.a = var1;
         }

         @Override
         public void a(Activity var1) {
            this.a.a(var1);
         }

         @Override
         public void a(Activity var1, Bundle var2) {
            this.a.a(var1);
         }

         @Override
         public void b(Activity var1) {
            this.a.a(var1);
         }
      });
      this.a(this.e);
   }

   public Fabric a(Activity var1) {
      this.m = new WeakReference<>(var1);
      return this;
   }

   InitializationCallback<?> a(int var1) {
      return new InitializationCallback(this, var1) {
         final CountDownLatch a;
         final int b;
         final Fabric c;

         {
            this.c = var1;
            this.b = var2;
            this.a = new CountDownLatch(this.b);
         }

         @Override
         public void a(Exception var1) {
            this.c.i.a(var1);
         }

         @Override
         public void a(Object var1) {
            this.a.countDown();
            if (this.a.getCount() == 0L) {
               this.c.n.set(true);
               this.c.i.a(this.c);
            }
         }
      };
   }

   void a(Context var1) {
      Future var2 = this.b(var1);
      ArrayList var3 = this.g();
      Onboarding var6 = new Onboarding(var2, var3);
      var3 = new ArrayList(var3);
      Collections.sort(var3);
      var6.a(var1, this, InitializationCallback.d, this.k);
      Iterator var4 = var3.iterator();

      while (var4.hasNext()) {
         ((Kit)var4.next()).a(var1, this, this.j, this.k);
      }

      var6.p();
      StringBuilder var5;
      if (h().a("Fabric", 3)) {
         var5 = new StringBuilder("Initializing ").append(this.d()).append(" [Version: ").append(this.c()).append("], with the following kits:\n");
      } else {
         var5 = null;
      }

      for (Kit var9 : var3) {
         var9.f.a(var6.f);
         this.a(this.f, var9);
         var9.p();
         if (var5 != null) {
            var5.append(var9.b()).append(" [Version: ").append(var9.a()).append("]\n");
         }
      }

      if (var5 != null) {
         h().a("Fabric", var5.toString());
      }
   }

   void a(Map<Class<? extends Kit>, Kit> var1, Kit var2) {
      DependsOn var5 = var2.j;
      if (var5 != null) {
         for (Class var7 : var5.a()) {
            if (var7.isInterface()) {
               for (Kit var6 : var1.values()) {
                  if (var7.isAssignableFrom(var6.getClass())) {
                     var2.f.a(var6.f);
                  }
               }
            } else {
               if ((Kit)var1.get(var7) == null) {
                  throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
               }

               var2.f.a(((Kit)var1.get(var7)).f);
            }
         }
      }
   }

   public Activity b() {
      Activity var1;
      if (this.m != null) {
         var1 = this.m.get();
      } else {
         var1 = null;
      }

      return var1;
   }

   Future<Map<String, KitInfo>> b(Context var1) {
      FabricKitsFinder var2 = new FabricKitsFinder(var1.getPackageCodePath());
      return this.f().submit(var2);
   }

   public String c() {
      return "1.3.17.dev";
   }

   public String d() {
      return "io.fabric.sdk.android:fabric";
   }

   public ActivityLifecycleManager e() {
      return this.l;
   }

   public ExecutorService f() {
      return this.g;
   }

   public Collection<Kit> g() {
      return this.f.values();
   }

   public static class Builder {
      private final Context a;
      private Kit[] b;
      private PriorityThreadPoolExecutor c;
      private Handler d;
      private Logger e;
      private boolean f;
      private String g;
      private String h;
      private InitializationCallback<Fabric> i;

      public Builder(Context var1) {
         if (var1 == null) {
            throw new IllegalArgumentException("Context must not be null.");
         }

         this.a = var1;
      }

      public Fabric.Builder a(Kit... var1) {
         if (this.b != null) {
            throw new IllegalStateException("Kits already set.");
         }

         this.b = var1;
         return this;
      }

      public Fabric a() {
         if (this.c == null) {
            this.c = PriorityThreadPoolExecutor.a();
         }

         if (this.d == null) {
            this.d = new Handler(Looper.getMainLooper());
         }

         if (this.e == null) {
            if (this.f) {
               this.e = new DefaultLogger(3);
            } else {
               this.e = new DefaultLogger();
            }
         }

         if (this.h == null) {
            this.h = this.a.getPackageName();
         }

         if (this.i == null) {
            this.i = InitializationCallback.d;
         }

         Map var1;
         if (this.b == null) {
            var1 = new HashMap();
         } else {
            var1 = Fabric.b(Arrays.asList(this.b));
         }

         Context var2 = this.a.getApplicationContext();
         IdManager var3 = new IdManager(var2, this.h, this.g, var1.values());
         return new Fabric(var2, var1, this.c, this.d, this.e, this.f, this.i, var3, Fabric.d(this.a));
      }
   }
}
