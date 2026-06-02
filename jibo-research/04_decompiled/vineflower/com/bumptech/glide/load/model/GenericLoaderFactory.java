package com.bumptech.glide.load.model;

import android.content.Context;
import com.bumptech.glide.load.data.DataFetcher;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GenericLoaderFactory {
   private static final ModelLoader NULL_MODEL_LOADER = new ModelLoader() {
      @Override
      public DataFetcher getResourceFetcher(Object var1, int var2, int var3) {
         throw new NoSuchMethodError("This should never be called!");
      }

      @Override
      public String toString() {
         return "NULL_MODEL_LOADER";
      }
   };
   private final Map<Class, Map<Class, ModelLoader>> cachedModelLoaders;
   private final Context context;
   private final Map<Class, Map<Class, ModelLoaderFactory>> modelClassToResourceFactories = new HashMap<>();

   public GenericLoaderFactory(Context var1) {
      this.cachedModelLoaders = new HashMap<>();
      this.context = var1.getApplicationContext();
   }

   private <T, Y> void cacheModelLoader(Class<T> var1, Class<Y> var2, ModelLoader<T, Y> var3) {
      Map var5 = this.cachedModelLoaders.get(var1);
      Map var4 = var5;
      if (var5 == null) {
         var4 = new HashMap();
         this.cachedModelLoaders.put(var1, var4);
      }

      var4.put(var2, var3);
   }

   private <T, Y> void cacheNullLoader(Class<T> var1, Class<Y> var2) {
      this.cacheModelLoader(var1, var2, NULL_MODEL_LOADER);
   }

   private <T, Y> ModelLoader<T, Y> getCachedLoader(Class<T> var1, Class<Y> var2) {
      Map var3 = this.cachedModelLoaders.get(var1);
      ModelLoader var4;
      if (var3 != null) {
         var4 = (ModelLoader)var3.get(var2);
      } else {
         var4 = null;
      }

      return var4;
   }

   private <T, Y> ModelLoaderFactory<T, Y> getFactory(Class<T> var1, Class<Y> var2) {
      Map var3 = this.modelClassToResourceFactories.get(var1);
      ModelLoaderFactory var6;
      if (var3 != null) {
         var6 = (ModelLoaderFactory)var3.get(var2);
      } else {
         var6 = null;
      }

      ModelLoaderFactory var4 = var6;
      if (var6 == null) {
         Iterator var5 = this.modelClassToResourceFactories.keySet().iterator();

         while (true) {
            if (!var5.hasNext()) {
               var4 = var6;
               break;
            }

            Class var7 = (Class)var5.next();
            if (var7.isAssignableFrom(var1)) {
               Map var8 = this.modelClassToResourceFactories.get(var7);
               if (var8 != null) {
                  var4 = (ModelLoaderFactory)var8.get(var2);
                  var6 = var4;
                  if (var4 != null) {
                     break;
                  }
               }
            }
         }
      }

      return var4;
   }

   public <T, Y> ModelLoader<T, Y> buildModelLoader(Class<T> param1, Class<Y> param2) {
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
      // 04: aload 2
      // 05: invokespecial com/bumptech/glide/load/model/GenericLoaderFactory.getCachedLoader (Ljava/lang/Class;Ljava/lang/Class;)Lcom/bumptech/glide/load/model/ModelLoader;
      // 08: astore 4
      // 0a: aload 4
      // 0c: ifnull 25
      // 0f: getstatic com/bumptech/glide/load/model/GenericLoaderFactory.NULL_MODEL_LOADER Lcom/bumptech/glide/load/model/ModelLoader;
      // 12: aload 4
      // 14: invokevirtual java/lang/Object.equals (Ljava/lang/Object;)Z
      // 17: istore 3
      // 18: aload 4
      // 1a: astore 1
      // 1b: iload 3
      // 1c: ifeq 21
      // 1f: aconst_null
      // 20: astore 1
      // 21: aload 0
      // 22: monitorexit
      // 23: aload 1
      // 24: areturn
      // 25: aload 0
      // 26: aload 1
      // 27: aload 2
      // 28: invokespecial com/bumptech/glide/load/model/GenericLoaderFactory.getFactory (Ljava/lang/Class;Ljava/lang/Class;)Lcom/bumptech/glide/load/model/ModelLoaderFactory;
      // 2b: astore 5
      // 2d: aload 5
      // 2f: ifnull 53
      // 32: aload 5
      // 34: aload 0
      // 35: getfield com/bumptech/glide/load/model/GenericLoaderFactory.context Landroid/content/Context;
      // 38: aload 0
      // 39: invokeinterface com/bumptech/glide/load/model/ModelLoaderFactory.build (Landroid/content/Context;Lcom/bumptech/glide/load/model/GenericLoaderFactory;)Lcom/bumptech/glide/load/model/ModelLoader; 3
      // 3e: astore 4
      // 40: aload 0
      // 41: aload 1
      // 42: aload 2
      // 43: aload 4
      // 45: invokespecial com/bumptech/glide/load/model/GenericLoaderFactory.cacheModelLoader (Ljava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoader;)V
      // 48: aload 4
      // 4a: astore 1
      // 4b: goto 21
      // 4e: astore 1
      // 4f: aload 0
      // 50: monitorexit
      // 51: aload 1
      // 52: athrow
      // 53: aload 0
      // 54: aload 1
      // 55: aload 2
      // 56: invokespecial com/bumptech/glide/load/model/GenericLoaderFactory.cacheNullLoader (Ljava/lang/Class;Ljava/lang/Class;)V
      // 59: aload 4
      // 5b: astore 1
      // 5c: goto 21
      // try (2 -> 7): 44 null
      // try (9 -> 13): 44 null
      // try (23 -> 28): 44 null
      // try (30 -> 41): 44 null
      // try (49 -> 53): 44 null
   }

   public <T, Y> ModelLoaderFactory<T, Y> register(Class<T> param1, Class<Y> param2, ModelLoaderFactory<T, Y> param3) {
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
      // 03: getfield com/bumptech/glide/load/model/GenericLoaderFactory.cachedModelLoaders Ljava/util/Map;
      // 06: invokeinterface java/util/Map.clear ()V 1
      // 0b: aload 0
      // 0c: getfield com/bumptech/glide/load/model/GenericLoaderFactory.modelClassToResourceFactories Ljava/util/Map;
      // 0f: aload 1
      // 10: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 15: checkcast java/util/Map
      // 18: astore 6
      // 1a: aload 6
      // 1c: astore 5
      // 1e: aload 6
      // 20: ifnonnull 3a
      // 23: new java/util/HashMap
      // 26: astore 5
      // 28: aload 5
      // 2a: invokespecial java/util/HashMap.<init> ()V
      // 2d: aload 0
      // 2e: getfield com/bumptech/glide/load/model/GenericLoaderFactory.modelClassToResourceFactories Ljava/util/Map;
      // 31: aload 1
      // 32: aload 5
      // 34: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 39: pop
      // 3a: aload 5
      // 3c: aload 2
      // 3d: aload 3
      // 3e: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 43: checkcast com/bumptech/glide/load/model/ModelLoaderFactory
      // 46: astore 2
      // 47: aload 2
      // 48: astore 1
      // 49: aload 2
      // 4a: ifnull 7f
      // 4d: aload 0
      // 4e: getfield com/bumptech/glide/load/model/GenericLoaderFactory.modelClassToResourceFactories Ljava/util/Map;
      // 51: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 56: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 5b: astore 3
      // 5c: aload 2
      // 5d: astore 1
      // 5e: aload 3
      // 5f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 64: ifeq 7f
      // 67: aload 3
      // 68: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 6d: checkcast java/util/Map
      // 70: aload 2
      // 71: invokeinterface java/util/Map.containsValue (Ljava/lang/Object;)Z 2
      // 76: istore 4
      // 78: iload 4
      // 7a: ifeq 5c
      // 7d: aconst_null
      // 7e: astore 1
      // 7f: aload 0
      // 80: monitorexit
      // 81: aload 1
      // 82: areturn
      // 83: astore 1
      // 84: aload 0
      // 85: monitorexit
      // 86: aload 1
      // 87: athrow
      // try (2 -> 11): 59 null
      // try (15 -> 25): 59 null
      // try (25 -> 31): 59 null
      // try (35 -> 40): 59 null
      // try (42 -> 51): 59 null
   }
}
