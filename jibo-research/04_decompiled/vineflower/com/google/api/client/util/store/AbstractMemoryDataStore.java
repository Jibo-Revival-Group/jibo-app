package com.google.api.client.util.store;

import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Maps;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AbstractMemoryDataStore<V extends Serializable> extends AbstractDataStore<V> {
   HashMap<String, byte[]> keyValueMap;
   private final Lock lock = new ReentrantLock();

   protected AbstractMemoryDataStore(DataStoreFactory var1, String var2) {
      super(var1, var2);
      this.keyValueMap = Maps.newHashMap();
   }

   @Override
   public final DataStore<V> clear() throws IOException {
      this.lock.lock();

      try {
         this.keyValueMap.clear();
         this.save();
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   @Override
   public boolean containsKey(String var1) throws IOException {
      boolean var2;
      if (var1 == null) {
         var2 = false;
      } else {
         this.lock.lock();

         try {
            var2 = this.keyValueMap.containsKey(var1);
         } finally {
            this.lock.unlock();
         }
      }

      return var2;
   }

   @Override
   public boolean containsValue(V param1) throws IOException {
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
      // 00: aload 1
      // 01: ifnonnull 08
      // 04: bipush 0
      // 05: istore 2
      // 06: iload 2
      // 07: ireturn
      // 08: aload 0
      // 09: getfield com/google/api/client/util/store/AbstractMemoryDataStore.lock Ljava/util/concurrent/locks/Lock;
      // 0c: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 11: aload 1
      // 12: invokestatic com/google/api/client/util/IOUtils.serialize (Ljava/lang/Object;)[B
      // 15: astore 1
      // 16: aload 0
      // 17: getfield com/google/api/client/util/store/AbstractMemoryDataStore.keyValueMap Ljava/util/HashMap;
      // 1a: invokevirtual java/util/HashMap.values ()Ljava/util/Collection;
      // 1d: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 22: astore 3
      // 23: aload 3
      // 24: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 29: ifeq 4c
      // 2c: aload 1
      // 2d: aload 3
      // 2e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 33: checkcast [B
      // 36: invokestatic java/util/Arrays.equals ([B[B)Z
      // 39: istore 2
      // 3a: iload 2
      // 3b: ifeq 23
      // 3e: bipush 1
      // 3f: istore 2
      // 40: aload 0
      // 41: getfield com/google/api/client/util/store/AbstractMemoryDataStore.lock Ljava/util/concurrent/locks/Lock;
      // 44: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 49: goto 06
      // 4c: aload 0
      // 4d: getfield com/google/api/client/util/store/AbstractMemoryDataStore.lock Ljava/util/concurrent/locks/Lock;
      // 50: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 55: bipush 0
      // 56: istore 2
      // 57: goto 06
      // 5a: astore 1
      // 5b: aload 0
      // 5c: getfield com/google/api/client/util/store/AbstractMemoryDataStore.lock Ljava/util/concurrent/locks/Lock;
      // 5f: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 64: aload 1
      // 65: athrow
      // try (9 -> 17): 40 null
      // try (17 -> 26): 40 null
   }

   @Override
   public DataStore<V> delete(String var1) throws IOException {
      if (var1 != null) {
         this.lock.lock();

         try {
            this.keyValueMap.remove(var1);
            this.save();
         } finally {
            this.lock.unlock();
         }
      }

      return this;
   }

   @Override
   public final V get(String var1) throws IOException {
      Serializable var4;
      if (var1 == null) {
         var4 = null;
      } else {
         this.lock.lock();

         try {
            var4 = IOUtils.deserialize(this.keyValueMap.get(var1));
         } finally {
            this.lock.unlock();
         }
      }

      return (V)var4;
   }

   @Override
   public boolean isEmpty() throws IOException {
      this.lock.lock();

      try {
         return this.keyValueMap.isEmpty();
      } finally {
         this.lock.unlock();
      }
   }

   @Override
   public final Set<String> keySet() throws IOException {
      this.lock.lock();

      try {
         return Collections.unmodifiableSet(this.keyValueMap.keySet());
      } finally {
         this.lock.unlock();
      }
   }

   void save() throws IOException {
   }

   @Override
   public final DataStore<V> set(String var1, V var2) throws IOException {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      this.lock.lock();

      try {
         this.keyValueMap.put(var1, IOUtils.serialize(var2));
         this.save();
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   @Override
   public int size() throws IOException {
      this.lock.lock();

      try {
         return this.keyValueMap.size();
      } finally {
         this.lock.unlock();
      }
   }

   @Override
   public String toString() {
      return DataStoreUtils.toString(this);
   }

   @Override
   public final Collection<V> values() throws IOException {
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
      // 00: aload 0
      // 01: getfield com/google/api/client/util/store/AbstractMemoryDataStore.lock Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: invokestatic com/google/api/client/util/Lists.newArrayList ()Ljava/util/ArrayList;
      // 0c: astore 2
      // 0d: aload 0
      // 0e: getfield com/google/api/client/util/store/AbstractMemoryDataStore.keyValueMap Ljava/util/HashMap;
      // 11: invokevirtual java/util/HashMap.values ()Ljava/util/Collection;
      // 14: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 19: astore 1
      // 1a: aload 1
      // 1b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 20: ifeq 45
      // 23: aload 2
      // 24: aload 1
      // 25: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2a: checkcast [B
      // 2d: invokestatic com/google/api/client/util/IOUtils.deserialize ([B)Ljava/io/Serializable;
      // 30: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 35: pop
      // 36: goto 1a
      // 39: astore 1
      // 3a: aload 0
      // 3b: getfield com/google/api/client/util/store/AbstractMemoryDataStore.lock Ljava/util/concurrent/locks/Lock;
      // 3e: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 43: aload 1
      // 44: athrow
      // 45: aload 2
      // 46: invokestatic java/util/Collections.unmodifiableList (Ljava/util/List;)Ljava/util/List;
      // 49: astore 1
      // 4a: aload 0
      // 4b: getfield com/google/api/client/util/store/AbstractMemoryDataStore.lock Ljava/util/concurrent/locks/Lock;
      // 4e: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 53: aload 1
      // 54: areturn
      // try (3 -> 10): 21 null
      // try (10 -> 20): 21 null
      // try (27 -> 30): 21 null
   }
}
