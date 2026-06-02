package com.bumptech.glide.provider;

import com.bumptech.glide.util.MultiClassKey;
import java.util.HashMap;
import java.util.Map;

public class DataLoadProviderRegistry {
   private static final MultiClassKey a = new MultiClassKey();
   private final Map<MultiClassKey, DataLoadProvider<?, ?>> b = new HashMap<>();

   public <T, Z> DataLoadProvider<T, Z> a(Class<T> param1, Class<Z> param2) {
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
      // 00: getstatic com/bumptech/glide/provider/DataLoadProviderRegistry.a Lcom/bumptech/glide/util/MultiClassKey;
      // 03: astore 3
      // 04: aload 3
      // 05: monitorenter
      // 06: getstatic com/bumptech/glide/provider/DataLoadProviderRegistry.a Lcom/bumptech/glide/util/MultiClassKey;
      // 09: aload 1
      // 0a: aload 2
      // 0b: invokevirtual com/bumptech/glide/util/MultiClassKey.a (Ljava/lang/Class;Ljava/lang/Class;)V
      // 0e: aload 0
      // 0f: getfield com/bumptech/glide/provider/DataLoadProviderRegistry.b Ljava/util/Map;
      // 12: getstatic com/bumptech/glide/provider/DataLoadProviderRegistry.a Lcom/bumptech/glide/util/MultiClassKey;
      // 15: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 1a: checkcast com/bumptech/glide/provider/DataLoadProvider
      // 1d: astore 2
      // 1e: aload 3
      // 1f: monitorexit
      // 20: aload 2
      // 21: astore 1
      // 22: aload 2
      // 23: ifnonnull 2a
      // 26: invokestatic com/bumptech/glide/provider/EmptyDataLoadProvider.a ()Lcom/bumptech/glide/provider/DataLoadProvider;
      // 29: astore 1
      // 2a: aload 1
      // 2b: areturn
      // 2c: astore 1
      // 2d: aload 3
      // 2e: monitorexit
      // 2f: aload 1
      // 30: athrow
      // try (4 -> 16): 24 null
      // try (25 -> 27): 24 null
   }

   public <T, Z> void a(Class<T> var1, Class<Z> var2, DataLoadProvider<T, Z> var3) {
      this.b.put(new MultiClassKey(var1, var2), var3);
   }
}
