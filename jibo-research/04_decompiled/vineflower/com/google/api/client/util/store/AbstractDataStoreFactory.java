package com.google.api.client.util.store;

import com.google.api.client.util.Maps;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public abstract class AbstractDataStoreFactory implements DataStoreFactory {
   private static final Pattern ID_PATTERN = Pattern.compile("\\w{1,30}");
   private final Map<String, DataStore<? extends Serializable>> dataStoreMap;
   private final Lock lock = new ReentrantLock();

   public AbstractDataStoreFactory() {
      this.dataStoreMap = Maps.newHashMap();
   }

   protected abstract <V extends Serializable> DataStore<V> createDataStore(String var1) throws IOException;

   @Override
   public final <V extends Serializable> DataStore<V> getDataStore(String param1) throws IOException {
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
      // 00: getstatic com/google/api/client/util/store/AbstractDataStoreFactory.ID_PATTERN Ljava/util/regex/Pattern;
      // 03: aload 1
      // 04: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 07: invokevirtual java/util/regex/Matcher.matches ()Z
      // 0a: ldc "%s does not match pattern %s"
      // 0c: bipush 2
      // 0d: anewarray 4
      // 10: dup
      // 11: bipush 0
      // 12: aload 1
      // 13: aastore
      // 14: dup
      // 15: bipush 1
      // 16: getstatic com/google/api/client/util/store/AbstractDataStoreFactory.ID_PATTERN Ljava/util/regex/Pattern;
      // 19: aastore
      // 1a: invokestatic com/google/api/client/util/Preconditions.checkArgument (ZLjava/lang/String;[Ljava/lang/Object;)V
      // 1d: aload 0
      // 1e: getfield com/google/api/client/util/store/AbstractDataStoreFactory.lock Ljava/util/concurrent/locks/Lock;
      // 21: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 26: aload 0
      // 27: getfield com/google/api/client/util/store/AbstractDataStoreFactory.dataStoreMap Ljava/util/Map;
      // 2a: aload 1
      // 2b: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 30: checkcast com/google/api/client/util/store/DataStore
      // 33: astore 3
      // 34: aload 3
      // 35: astore 2
      // 36: aload 3
      // 37: ifnonnull 4c
      // 3a: aload 0
      // 3b: aload 1
      // 3c: invokevirtual com/google/api/client/util/store/AbstractDataStoreFactory.createDataStore (Ljava/lang/String;)Lcom/google/api/client/util/store/DataStore;
      // 3f: astore 2
      // 40: aload 0
      // 41: getfield com/google/api/client/util/store/AbstractDataStoreFactory.dataStoreMap Ljava/util/Map;
      // 44: aload 1
      // 45: aload 2
      // 46: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 4b: pop
      // 4c: aload 0
      // 4d: getfield com/google/api/client/util/store/AbstractDataStoreFactory.lock Ljava/util/concurrent/locks/Lock;
      // 50: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 55: aload 2
      // 56: areturn
      // 57: astore 1
      // 58: aload 0
      // 59: getfield com/google/api/client/util/store/AbstractDataStoreFactory.lock Ljava/util/concurrent/locks/Lock;
      // 5c: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 61: aload 1
      // 62: athrow
      // try (19 -> 25): 44 null
      // try (29 -> 39): 44 null
   }
}
