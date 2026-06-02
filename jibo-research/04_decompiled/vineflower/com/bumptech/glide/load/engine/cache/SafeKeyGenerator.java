package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;

class SafeKeyGenerator {
   private final LruCache<Key, String> loadIdToSafeHash = new LruCache<>(1000);

   public String getSafeKey(Key param1) {
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
      // 01: getfield com/bumptech/glide/load/engine/cache/SafeKeyGenerator.loadIdToSafeHash Lcom/bumptech/glide/util/LruCache;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/bumptech/glide/load/engine/cache/SafeKeyGenerator.loadIdToSafeHash Lcom/bumptech/glide/util/LruCache;
      // 0b: aload 1
      // 0c: invokevirtual com/bumptech/glide/util/LruCache.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 0f: checkcast java/lang/String
      // 12: astore 2
      // 13: aload 3
      // 14: monitorexit
      // 15: aload 2
      // 16: astore 3
      // 17: aload 2
      // 18: ifnonnull 47
      // 1b: ldc "SHA-256"
      // 1d: invokestatic java/security/MessageDigest.getInstance (Ljava/lang/String;)Ljava/security/MessageDigest;
      // 20: astore 3
      // 21: aload 1
      // 22: aload 3
      // 23: invokeinterface com/bumptech/glide/load/Key.updateDiskCacheKey (Ljava/security/MessageDigest;)V 2
      // 28: aload 3
      // 29: invokevirtual java/security/MessageDigest.digest ()[B
      // 2c: invokestatic com/bumptech/glide/util/Util.a ([B)Ljava/lang/String;
      // 2f: astore 3
      // 30: aload 3
      // 31: astore 2
      // 32: aload 0
      // 33: getfield com/bumptech/glide/load/engine/cache/SafeKeyGenerator.loadIdToSafeHash Lcom/bumptech/glide/util/LruCache;
      // 36: astore 3
      // 37: aload 3
      // 38: monitorenter
      // 39: aload 0
      // 3a: getfield com/bumptech/glide/load/engine/cache/SafeKeyGenerator.loadIdToSafeHash Lcom/bumptech/glide/util/LruCache;
      // 3d: aload 1
      // 3e: aload 2
      // 3f: invokevirtual com/bumptech/glide/util/LruCache.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 42: pop
      // 43: aload 3
      // 44: monitorexit
      // 45: aload 2
      // 46: astore 3
      // 47: aload 3
      // 48: areturn
      // 49: astore 1
      // 4a: aload 3
      // 4b: monitorexit
      // 4c: aload 1
      // 4d: athrow
      // 4e: astore 3
      // 4f: aload 3
      // 50: invokevirtual java/io/UnsupportedEncodingException.printStackTrace ()V
      // 53: goto 32
      // 56: astore 3
      // 57: aload 3
      // 58: invokevirtual java/security/NoSuchAlgorithmException.printStackTrace ()V
      // 5b: goto 32
      // 5e: astore 1
      // 5f: aload 3
      // 60: monitorexit
      // 61: aload 1
      // 62: athrow
      // try (5 -> 13): 46 null
      // try (17 -> 27): 51 java/io/UnsupportedEncodingException
      // try (17 -> 27): 55 java/security/NoSuchAlgorithmException
      // try (34 -> 42): 59 null
      // try (47 -> 49): 46 null
      // try (60 -> 62): 59 null
   }
}
