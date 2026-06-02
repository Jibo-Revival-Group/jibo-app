package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.Map.Entry;

public final class ClassInfo {
   private static final Map<Class<?>, ClassInfo> CACHE = new WeakHashMap<>();
   private static final Map<Class<?>, ClassInfo> CACHE_IGNORE_CASE = new WeakHashMap<>();
   private final Class<?> clazz;
   private final boolean ignoreCase;
   private final IdentityHashMap<String, FieldInfo> nameToFieldInfoMap = new IdentityHashMap<>();
   final List<String> names;

   private ClassInfo(Class<?> var1, boolean var2) {
      this.clazz = var1;
      this.ignoreCase = var2;
      boolean var5;
      if (var2 && var1.isEnum()) {
         var5 = false;
      } else {
         var5 = true;
      }

      String var6 = String.valueOf(String.valueOf(var1));
      Preconditions.checkArgument(var5, new StringBuilder(var6.length() + 31).append("cannot ignore case on an enum: ").append(var6).toString());
      TreeSet var9 = new TreeSet<>(new Comparator<String>(this) {
         final ClassInfo this$0;

         {
            this.this$0 = var1;
         }

         public int compare(String var1, String var2x) {
            int var3;
            if (var1 == var2x) {
               var3 = 0;
            } else if (var1 == null) {
               var3 = -1;
            } else if (var2x == null) {
               var3 = 1;
            } else {
               var3 = var1.compareTo(var2x);
            }

            return var3;
         }
      });

      for (Field var12 : var1.getDeclaredFields()) {
         FieldInfo var10 = FieldInfo.of(var12);
         if (var10 != null) {
            var6 = var10.getName();
            if (var2) {
               var6 = var6.toLowerCase().intern();
            }

            FieldInfo var8 = this.nameToFieldInfoMap.get(var6);
            if (var8 == null) {
               var5 = true;
            } else {
               var5 = false;
            }

            String var7;
            if (var2) {
               var7 = "case-insensitive ";
            } else {
               var7 = "";
            }

            Field var21;
            if (var8 == null) {
               var21 = null;
            } else {
               var21 = var8.getField();
            }

            Preconditions.checkArgument(var5, "two fields have the same %sname <%s>: %s and %s", var7, var6, var12, var21);
            this.nameToFieldInfoMap.put(var6, var10);
            var9.add(var6);
         }
      }

      var1 = var1.getSuperclass();
      if (var1 != null) {
         ClassInfo var14 = of(var1, var2);
         var9.addAll(var14.names);

         for (Entry var19 : var14.nameToFieldInfoMap.entrySet()) {
            String var20 = (String)var19.getKey();
            if (!this.nameToFieldInfoMap.containsKey(var20)) {
               this.nameToFieldInfoMap.put(var20, (FieldInfo)var19.getValue());
            }
         }
      }

      List var16;
      if (var9.isEmpty()) {
         var16 = Collections.emptyList();
      } else {
         var16 = Collections.unmodifiableList(new ArrayList(var9));
      }

      this.names = var16;
   }

   public static ClassInfo of(Class<?> var0) {
      return of(var0, false);
   }

   public static ClassInfo of(Class<?> param0, boolean param1) {
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
      // 01: ifnonnull 08
      // 04: aconst_null
      // 05: astore 2
      // 06: aload 2
      // 07: areturn
      // 08: iload 1
      // 09: ifeq 43
      // 0c: getstatic com/google/api/client/util/ClassInfo.CACHE_IGNORE_CASE Ljava/util/Map;
      // 0f: astore 3
      // 10: aload 3
      // 11: monitorenter
      // 12: aload 3
      // 13: aload 0
      // 14: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 19: checkcast com/google/api/client/util/ClassInfo
      // 1c: astore 4
      // 1e: aload 4
      // 20: astore 2
      // 21: aload 4
      // 23: ifnonnull 39
      // 26: new com/google/api/client/util/ClassInfo
      // 29: astore 2
      // 2a: aload 2
      // 2b: aload 0
      // 2c: iload 1
      // 2d: invokespecial com/google/api/client/util/ClassInfo.<init> (Ljava/lang/Class;Z)V
      // 30: aload 3
      // 31: aload 0
      // 32: aload 2
      // 33: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 38: pop
      // 39: aload 3
      // 3a: monitorexit
      // 3b: goto 06
      // 3e: astore 0
      // 3f: aload 3
      // 40: monitorexit
      // 41: aload 0
      // 42: athrow
      // 43: getstatic com/google/api/client/util/ClassInfo.CACHE Ljava/util/Map;
      // 46: astore 3
      // 47: goto 10
      // try (12 -> 17): 35 null
      // try (21 -> 32): 35 null
      // try (32 -> 34): 35 null
      // try (36 -> 38): 35 null
   }

   public Field getField(String var1) {
      FieldInfo var2 = this.getFieldInfo(var1);
      Field var3;
      if (var2 == null) {
         var3 = null;
      } else {
         var3 = var2.getField();
      }

      return var3;
   }

   public FieldInfo getFieldInfo(String var1) {
      String var2 = var1;
      if (var1 != null) {
         var2 = var1;
         if (this.ignoreCase) {
            var2 = var1.toLowerCase();
         }

         var2 = var2.intern();
      }

      return this.nameToFieldInfoMap.get(var2);
   }

   public Collection<FieldInfo> getFieldInfos() {
      return Collections.unmodifiableCollection(this.nameToFieldInfoMap.values());
   }

   public final boolean getIgnoreCase() {
      return this.ignoreCase;
   }

   public Collection<String> getNames() {
      return this.names;
   }

   public Class<?> getUnderlyingClass() {
      return this.clazz;
   }

   public boolean isEnum() {
      return this.clazz.isEnum();
   }
}
