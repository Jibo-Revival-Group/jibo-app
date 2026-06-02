package android.support.v4.util;

public final class Pools {
   public interface Pool<T> {
      T a();

      boolean a(T var1);
   }

   public static class SimplePool<T> implements Pools.Pool<T> {
      private final Object[] a;
      private int b;

      public SimplePool(int var1) {
         if (var1 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
         }

         this.a = new Object[var1];
      }

      private boolean b(T var1) {
         boolean var4 = false;
         int var2 = 0;

         boolean var3;
         while (true) {
            var3 = var4;
            if (var2 >= this.b) {
               break;
            }

            if (this.a[var2] == var1) {
               var3 = true;
               break;
            }

            var2++;
         }

         return var3;
      }

      @Override
      public T a() {
         Object var2;
         if (this.b > 0) {
            int var1 = this.b - 1;
            var2 = this.a[var1];
            this.a[var1] = null;
            this.b--;
         } else {
            var2 = null;
         }

         return (T)var2;
      }

      @Override
      public boolean a(T var1) {
         if (this.b((T)var1)) {
            throw new IllegalStateException("Already in the pool!");
         }

         boolean var2;
         if (this.b < this.a.length) {
            this.a[this.b] = var1;
            this.b++;
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }
   }

   public static class SynchronizedPool<T> extends Pools.SimplePool<T> {
      private final Object a = new Object();

      public SynchronizedPool(int var1) {
         super(var1);
      }

      @Override
      public T a() {
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
         // 01: getfield android/support/v4/util/Pools$SynchronizedPool.a Ljava/lang/Object;
         // 04: astore 1
         // 05: aload 1
         // 06: monitorenter
         // 07: aload 0
         // 08: invokespecial android/support/v4/util/Pools$SimplePool.a ()Ljava/lang/Object;
         // 0b: astore 2
         // 0c: aload 1
         // 0d: monitorexit
         // 0e: aload 2
         // 0f: areturn
         // 10: astore 2
         // 11: aload 1
         // 12: monitorexit
         // 13: aload 2
         // 14: athrow
         // try (5 -> 10): 12 null
         // try (13 -> 15): 12 null
      }

      @Override
      public boolean a(T param1) {
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
         // 01: getfield android/support/v4/util/Pools$SynchronizedPool.a Ljava/lang/Object;
         // 04: astore 3
         // 05: aload 3
         // 06: monitorenter
         // 07: aload 0
         // 08: aload 1
         // 09: invokespecial android/support/v4/util/Pools$SimplePool.a (Ljava/lang/Object;)Z
         // 0c: istore 2
         // 0d: aload 3
         // 0e: monitorexit
         // 0f: iload 2
         // 10: ireturn
         // 11: astore 1
         // 12: aload 3
         // 13: monitorexit
         // 14: aload 1
         // 15: athrow
         // try (5 -> 11): 13 null
         // try (14 -> 16): 13 null
      }
   }
}
