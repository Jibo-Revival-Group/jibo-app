package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.util.MultiClassKey;
import java.util.HashMap;
import java.util.Map;

public class TranscoderRegistry {
   private static final MultiClassKey GET_KEY = new MultiClassKey();
   private final Map<MultiClassKey, ResourceTranscoder<?, ?>> factories = new HashMap<>();

   public <Z, R> ResourceTranscoder<Z, R> get(Class<Z> param1, Class<R> param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
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
      // 00: aload 1
      // 01: aload 2
      // 02: invokevirtual java/lang/Object.equals (Ljava/lang/Object;)Z
      // 05: ifeq 0e
      // 08: invokestatic com/bumptech/glide/load/resource/transcode/UnitTranscoder.get ()Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;
      // 0b: astore 3
      // 0c: aload 3
      // 0d: areturn
      // 0e: getstatic com/bumptech/glide/load/resource/transcode/TranscoderRegistry.GET_KEY Lcom/bumptech/glide/util/MultiClassKey;
      // 11: astore 3
      // 12: aload 3
      // 13: monitorenter
      // 14: getstatic com/bumptech/glide/load/resource/transcode/TranscoderRegistry.GET_KEY Lcom/bumptech/glide/util/MultiClassKey;
      // 17: aload 1
      // 18: aload 2
      // 19: invokevirtual com/bumptech/glide/util/MultiClassKey.a (Ljava/lang/Class;Ljava/lang/Class;)V
      // 1c: aload 0
      // 1d: getfield com/bumptech/glide/load/resource/transcode/TranscoderRegistry.factories Ljava/util/Map;
      // 20: getstatic com/bumptech/glide/load/resource/transcode/TranscoderRegistry.GET_KEY Lcom/bumptech/glide/util/MultiClassKey;
      // 23: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 28: checkcast com/bumptech/glide/load/resource/transcode/ResourceTranscoder
      // 2b: astore 4
      // 2d: aload 3
      // 2e: monitorexit
      // 2f: aload 4
      // 31: astore 3
      // 32: aload 4
      // 34: ifnonnull 0c
      // 37: new java/lang/IllegalArgumentException
      // 3a: dup
      // 3b: new java/lang/StringBuilder
      // 3e: dup
      // 3f: invokespecial java/lang/StringBuilder.<init> ()V
      // 42: ldc "No transcoder registered for "
      // 44: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 47: aload 1
      // 48: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 4b: ldc " and "
      // 4d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 50: aload 2
      // 51: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 54: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 57: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 5a: athrow
      // 5b: astore 1
      // 5c: aload 3
      // 5d: monitorexit
      // 5e: aload 1
      // 5f: athrow
      // try (12 -> 24): 44 null
      // try (45 -> 47): 44 null
   }

   public <Z, R> void register(Class<Z> var1, Class<R> var2, ResourceTranscoder<Z, R> var3) {
      this.factories.put(new MultiClassKey(var1, var2), var3);
   }
}
