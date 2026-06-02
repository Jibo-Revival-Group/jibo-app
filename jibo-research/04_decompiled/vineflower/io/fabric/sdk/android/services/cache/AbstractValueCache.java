package io.fabric.sdk.android.services.cache;

import android.content.Context;

public abstract class AbstractValueCache<T> implements ValueCache<T> {
   private final ValueCache<T> a;

   public AbstractValueCache(ValueCache<T> var1) {
      this.a = var1;
   }

   private void b(Context var1, T var2) {
      if (var2 == null) {
         throw new NullPointerException();
      }

      this.a(var1, (T)var2);
   }

   protected abstract T a(Context var1);

   @Override
   public final T a(Context param1, ValueLoader<T> param2) throws Exception {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: aload 1
      // 04: invokevirtual io/fabric/sdk/android/services/cache/AbstractValueCache.a (Landroid/content/Context;)Ljava/lang/Object;
      // 07: astore 4
      // 09: aload 4
      // 0b: astore 3
      // 0c: aload 4
      // 0e: ifnonnull 2c
      // 11: aload 0
      // 12: getfield io/fabric/sdk/android/services/cache/AbstractValueCache.a Lio/fabric/sdk/android/services/cache/ValueCache;
      // 15: ifnull 30
      // 18: aload 0
      // 19: getfield io/fabric/sdk/android/services/cache/AbstractValueCache.a Lio/fabric/sdk/android/services/cache/ValueCache;
      // 1c: aload 1
      // 1d: aload 2
      // 1e: invokeinterface io/fabric/sdk/android/services/cache/ValueCache.a (Landroid/content/Context;Lio/fabric/sdk/android/services/cache/ValueLoader;)Ljava/lang/Object; 3
      // 23: astore 2
      // 24: aload 0
      // 25: aload 1
      // 26: aload 2
      // 27: invokespecial io/fabric/sdk/android/services/cache/AbstractValueCache.b (Landroid/content/Context;Ljava/lang/Object;)V
      // 2a: aload 2
      // 2b: astore 3
      // 2c: aload 0
      // 2d: monitorexit
      // 2e: aload 3
      // 2f: areturn
      // 30: aload 2
      // 31: aload 1
      // 32: invokeinterface io/fabric/sdk/android/services/cache/ValueLoader.b (Landroid/content/Context;)Ljava/lang/Object; 2
      // 37: astore 2
      // 38: goto 24
      // 3b: astore 1
      // 3c: aload 0
      // 3d: monitorexit
      // 3e: aload 1
      // 3f: athrow
      // try (2 -> 6): 34 null
      // try (10 -> 19): 34 null
      // try (19 -> 23): 34 null
      // try (29 -> 33): 34 null
   }

   protected abstract void a(Context var1, T var2);
}
