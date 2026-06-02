package android.arch.lifecycle;

import android.arch.core.executor.ArchTaskExecutor;
import android.arch.core.internal.SafeIterableMap;
import java.util.Map.Entry;

public abstract class LiveData<T> {
   private static final Object b = new Object();
   private final Object a = new Object();
   private SafeIterableMap<Observer<T>, LiveData<T>.ObserverWrapper> c = new SafeIterableMap<>();
   private int d = 0;
   private volatile Object e = b;
   private volatile Object f = b;
   private int g = -1;
   private boolean h;
   private boolean i;
   private final Runnable j = new Runnable(this) {
      final LiveData a;

      {
         this.a = var1;
      }

      @Override
      public void run() {
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
         // 01: getfield android/arch/lifecycle/LiveData$1.a Landroid/arch/lifecycle/LiveData;
         // 04: invokestatic android/arch/lifecycle/LiveData.a (Landroid/arch/lifecycle/LiveData;)Ljava/lang/Object;
         // 07: astore 1
         // 08: aload 1
         // 09: monitorenter
         // 0a: aload 0
         // 0b: getfield android/arch/lifecycle/LiveData$1.a Landroid/arch/lifecycle/LiveData;
         // 0e: invokestatic android/arch/lifecycle/LiveData.b (Landroid/arch/lifecycle/LiveData;)Ljava/lang/Object;
         // 11: astore 2
         // 12: aload 0
         // 13: getfield android/arch/lifecycle/LiveData$1.a Landroid/arch/lifecycle/LiveData;
         // 16: invokestatic android/arch/lifecycle/LiveData.e ()Ljava/lang/Object;
         // 19: invokestatic android/arch/lifecycle/LiveData.a (Landroid/arch/lifecycle/LiveData;Ljava/lang/Object;)Ljava/lang/Object;
         // 1c: pop
         // 1d: aload 1
         // 1e: monitorexit
         // 1f: aload 0
         // 20: getfield android/arch/lifecycle/LiveData$1.a Landroid/arch/lifecycle/LiveData;
         // 23: aload 2
         // 24: invokevirtual android/arch/lifecycle/LiveData.b (Ljava/lang/Object;)V
         // 27: return
         // 28: astore 2
         // 29: aload 1
         // 2a: monitorexit
         // 2b: aload 2
         // 2c: athrow
         // try (6 -> 17): 22 null
         // try (23 -> 25): 22 null
      }
   };

   private void a(LiveData<T>.ObserverWrapper var1) {
      if (var1.d) {
         if (!var1.a()) {
            var1.a(false);
         } else if (var1.e < this.g) {
            var1.e = this.g;
            var1.c.a((T)this.e);
         }
      }
   }

   private static void a(String var0) {
      if (!ArchTaskExecutor.a().b()) {
         throw new IllegalStateException("Cannot invoke " + var0 + " on a background" + " thread");
      }
   }

   private void b(LiveData<T>.ObserverWrapper var1) {
      if (this.h) {
         this.i = true;
      } else {
         this.h = true;

         do {
            this.i = false;
            LiveData.ObserverWrapper var2;
            if (var1 != null) {
               this.a(var1);
               var2 = null;
            } else {
               SafeIterableMap.IteratorWithAdditions var3 = this.c.c();

               while (true) {
                  var2 = var1;
                  if (!var3.hasNext()) {
                     break;
                  }

                  this.a((LiveData.ObserverWrapper)((Entry)var3.next()).getValue());
                  if (this.i) {
                     var2 = var1;
                     break;
                  }
               }
            }

            var1 = var2;
         } while (this.i);

         this.h = false;
      }
   }

   public T a() {
      Object var1 = this.e;
      if (var1 == b) {
         var1 = null;
      }

      return (T)var1;
   }

   public void a(LifecycleOwner var1, Observer<T> var2) {
      if (var1.getLifecycle().a() != Lifecycle.State.DESTROYED) {
         LiveData.LifecycleBoundObserver var3 = new LiveData.LifecycleBoundObserver(this, var1, var2);
         LiveData.ObserverWrapper var4 = this.c.a(var2, var3);
         if (var4 != null && !var4.a(var1)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
         }

         if (var4 == null) {
            var1.getLifecycle().a(var3);
         }
      }
   }

   public void a(Observer<T> var1) {
      a("removeObserver");
      LiveData.ObserverWrapper var2 = this.c.b(var1);
      if (var2 != null) {
         var2.b();
         var2.a(false);
      }
   }

   protected void a(T param1) {
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
      // 01: getfield android/arch/lifecycle/LiveData.a Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield android/arch/lifecycle/LiveData.f Ljava/lang/Object;
      // 0b: getstatic android/arch/lifecycle/LiveData.b Ljava/lang/Object;
      // 0e: if_acmpne 1f
      // 11: bipush 1
      // 12: istore 2
      // 13: aload 0
      // 14: aload 1
      // 15: putfield android/arch/lifecycle/LiveData.f Ljava/lang/Object;
      // 18: aload 3
      // 19: monitorexit
      // 1a: iload 2
      // 1b: ifne 29
      // 1e: return
      // 1f: bipush 0
      // 20: istore 2
      // 21: goto 13
      // 24: astore 1
      // 25: aload 3
      // 26: monitorexit
      // 27: aload 1
      // 28: athrow
      // 29: invokestatic android/arch/core/executor/ArchTaskExecutor.a ()Landroid/arch/core/executor/ArchTaskExecutor;
      // 2c: aload 0
      // 2d: getfield android/arch/lifecycle/LiveData.j Ljava/lang/Runnable;
      // 30: invokevirtual android/arch/core/executor/ArchTaskExecutor.b (Ljava/lang/Runnable;)V
      // 33: goto 1e
      // try (5 -> 9): 22 null
      // try (11 -> 16): 22 null
      // try (23 -> 25): 22 null
   }

   protected void b() {
   }

   protected void b(T var1) {
      a("setValue");
      this.g++;
      this.e = var1;
      this.b((LiveData<T>.ObserverWrapper)null);
   }

   protected void c() {
   }

   public boolean d() {
      boolean var1;
      if (this.d > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements GenericLifecycleObserver {
      final LifecycleOwner a;
      final LiveData b;

      LifecycleBoundObserver(LiveData var1, LifecycleOwner var2, Observer var3) {
         super(var1, var3);
         this.b = var1;
         this.a = var2;
      }

      @Override
      public void a(LifecycleOwner var1, Lifecycle.Event var2) {
         if (this.a.getLifecycle().a() == Lifecycle.State.DESTROYED) {
            this.b.a(this.c);
         } else {
            this.a(this.a());
         }
      }

      @Override
      boolean a() {
         return this.a.getLifecycle().a().isAtLeast(Lifecycle.State.STARTED);
      }

      @Override
      boolean a(LifecycleOwner var1) {
         boolean var2;
         if (this.a == var1) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      void b() {
         this.a.getLifecycle().b(this);
      }
   }

   private abstract class ObserverWrapper {
      final Observer<T> c;
      boolean d;
      int e;
      final LiveData f;

      ObserverWrapper(LiveData var1, Observer var2) {
         this.f = var1;
         this.e = -1;
         this.c = var2;
      }

      void a(boolean var1) {
         byte var3 = 1;
         if (var1 != this.d) {
            this.d = var1;
            boolean var2;
            if (this.f.d == 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            LiveData var5 = this.f;
            int var4 = var5.d;
            if (!this.d) {
               var3 = -1;
            }

            var5.d = var3 + var4;
            if (var2 && this.d) {
               this.f.b();
            }

            if (this.f.d == 0 && !this.d) {
               this.f.c();
            }

            if (this.d) {
               this.f.b(this);
            }
         }
      }

      abstract boolean a();

      boolean a(LifecycleOwner var1) {
         return false;
      }

      void b() {
      }
   }
}
