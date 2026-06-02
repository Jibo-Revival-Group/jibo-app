package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

@Beta
@GwtCompatible(emulated = true)
public final class Enums {
   @GwtIncompatible("java.lang.ref.WeakReference")
   private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> enumConstantCache = new WeakHashMap<>();

   private Enums() {
   }

   @GwtIncompatible("java.lang.ref.WeakReference")
   static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> getEnumConstants(Class<T> param0) {
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
      // 00: getstatic com/google/api/client/repackaged/com/google/common/base/Enums.enumConstantCache Ljava/util/Map;
      // 03: astore 3
      // 04: aload 3
      // 05: monitorenter
      // 06: getstatic com/google/api/client/repackaged/com/google/common/base/Enums.enumConstantCache Ljava/util/Map;
      // 09: aload 0
      // 0a: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0f: checkcast java/util/Map
      // 12: astore 2
      // 13: aload 2
      // 14: astore 1
      // 15: aload 2
      // 16: ifnonnull 1e
      // 19: aload 0
      // 1a: invokestatic com/google/api/client/repackaged/com/google/common/base/Enums.populateCache (Ljava/lang/Class;)Ljava/util/Map;
      // 1d: astore 1
      // 1e: aload 3
      // 1f: monitorexit
      // 20: aload 1
      // 21: areturn
      // 22: astore 0
      // 23: aload 3
      // 24: monitorexit
      // 25: aload 0
      // 26: athrow
      // try (4 -> 9): 20 null
      // try (13 -> 16): 20 null
      // try (16 -> 18): 20 null
      // try (21 -> 23): 20 null
   }

   @GwtIncompatible("reflection")
   public static Field getField(Enum<?> var0) {
      Class var1 = var0.getDeclaringClass();

      try {
         return var1.getDeclaredField(var0.name());
      } catch (NoSuchFieldException var2) {
         throw new AssertionError(var2);
      }
   }

   public static <T extends Enum<T>> Optional<T> getIfPresent(Class<T> var0, String var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return Platform.getEnumIfPresent(var0, var1);
   }

   @GwtIncompatible("java.lang.ref.WeakReference")
   private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> populateCache(Class<T> var0) {
      HashMap var3 = new HashMap();

      for (Enum var2 : EnumSet.allOf(var0)) {
         var3.put(var2.name(), new WeakReference<>(var2));
      }

      enumConstantCache.put(var0, var3);
      return var3;
   }

   public static <T extends Enum<T>> Converter<String, T> stringConverter(Class<T> var0) {
      return new Enums.StringConverter<>(var0);
   }

   @Deprecated
   public static <T extends Enum<T>> Function<String, T> valueOfFunction(Class<T> var0) {
      return new Enums.ValueOfFunction<>(var0);
   }

   private static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
      private static final long serialVersionUID = 0L;
      private final Class<T> enumClass;

      StringConverter(Class<T> var1) {
         this.enumClass = Preconditions.checkNotNull(var1);
      }

      protected String doBackward(T var1) {
         return var1.name();
      }

      protected T doForward(String var1) {
         return Enum.valueOf(this.enumClass, var1);
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof Enums.StringConverter) {
            var1 = var1;
            var2 = this.enumClass.equals(var1.enumClass);
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return this.enumClass.hashCode();
      }

      @Override
      public String toString() {
         return "Enums.stringConverter(" + this.enumClass.getName() + ".class)";
      }
   }

   private static final class ValueOfFunction<T extends Enum<T>> implements Function<String, T>, Serializable {
      private static final long serialVersionUID = 0L;
      private final Class<T> enumClass;

      private ValueOfFunction(Class<T> var1) {
         this.enumClass = Preconditions.checkNotNull(var1);
      }

      public T apply(String var1) {
         try {
            var3 = Enum.valueOf(this.enumClass, var1);
         } catch (IllegalArgumentException var2) {
            var3 = null;
         }

         return (T)var3;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof Enums.ValueOfFunction && this.enumClass.equals(((Enums.ValueOfFunction)var1).enumClass)) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return this.enumClass.hashCode();
      }

      @Override
      public String toString() {
         return "Enums.valueOf(" + this.enumClass + ")";
      }
   }
}
