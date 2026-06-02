package com.fasterxml.jackson.core.util;

import java.util.concurrent.ConcurrentHashMap;

public final class InternCache extends ConcurrentHashMap<String, String> {
   public static final InternCache a = new InternCache();
   private final Object b = new Object();

   private InternCache() {
      super(180, 0.8F, 4);
   }

   public String a(String param1) {
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
      // 01: aload 1
      // 02: invokevirtual com/fasterxml/jackson/core/util/InternCache.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 05: checkcast java/lang/String
      // 08: astore 2
      // 09: aload 2
      // 0a: ifnull 11
      // 0d: aload 2
      // 0e: astore 1
      // 0f: aload 1
      // 10: areturn
      // 11: aload 0
      // 12: invokevirtual com/fasterxml/jackson/core/util/InternCache.size ()I
      // 15: sipush 180
      // 18: if_icmplt 32
      // 1b: aload 0
      // 1c: getfield com/fasterxml/jackson/core/util/InternCache.b Ljava/lang/Object;
      // 1f: astore 2
      // 20: aload 2
      // 21: monitorenter
      // 22: aload 0
      // 23: invokevirtual com/fasterxml/jackson/core/util/InternCache.size ()I
      // 26: sipush 180
      // 29: if_icmplt 30
      // 2c: aload 0
      // 2d: invokevirtual com/fasterxml/jackson/core/util/InternCache.clear ()V
      // 30: aload 2
      // 31: monitorexit
      // 32: aload 1
      // 33: invokevirtual java/lang/String.intern ()Ljava/lang/String;
      // 36: astore 1
      // 37: aload 0
      // 38: aload 1
      // 39: aload 1
      // 3a: invokevirtual com/fasterxml/jackson/core/util/InternCache.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 3d: pop
      // 3e: goto 0f
      // 41: astore 1
      // 42: aload 2
      // 43: monitorexit
      // 44: aload 1
      // 45: athrow
      // try (20 -> 26): 37 null
      // try (26 -> 28): 37 null
      // try (38 -> 40): 37 null
   }
}
