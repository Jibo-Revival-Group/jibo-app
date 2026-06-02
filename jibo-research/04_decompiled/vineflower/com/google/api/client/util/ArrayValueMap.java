package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public final class ArrayValueMap {
   private final Object destination;
   private final Map<Field, ArrayValueMap.ArrayValue> fieldMap;
   private final Map<String, ArrayValueMap.ArrayValue> keyMap = ArrayMap.create();

   public ArrayValueMap(Object var1) {
      this.fieldMap = ArrayMap.create();
      this.destination = var1;
   }

   public void put(String var1, Class<?> var2, Object var3) {
      ArrayValueMap.ArrayValue var5 = this.keyMap.get(var1);
      ArrayValueMap.ArrayValue var4 = var5;
      if (var5 == null) {
         var4 = new ArrayValueMap.ArrayValue(var2);
         this.keyMap.put(var1, var4);
      }

      var4.addValue(var2, var3);
   }

   public void put(Field var1, Class<?> var2, Object var3) {
      ArrayValueMap.ArrayValue var5 = this.fieldMap.get(var1);
      ArrayValueMap.ArrayValue var4 = var5;
      if (var5 == null) {
         var4 = new ArrayValueMap.ArrayValue(var2);
         this.fieldMap.put(var1, var4);
      }

      var4.addValue(var2, var3);
   }

   public void setValues() {
      for (Entry var1 : this.keyMap.entrySet()) {
         ((Map)this.destination).put(var1.getKey(), ((ArrayValueMap.ArrayValue)var1.getValue()).toArray());
      }

      for (Entry var4 : this.fieldMap.entrySet()) {
         FieldInfo.setFieldValue((Field)var4.getKey(), this.destination, ((ArrayValueMap.ArrayValue)var4.getValue()).toArray());
      }
   }

   static class ArrayValue {
      final Class<?> componentType;
      final ArrayList<Object> values = new ArrayList<>();

      ArrayValue(Class<?> var1) {
         this.componentType = var1;
      }

      void addValue(Class<?> var1, Object var2) {
         boolean var3;
         if (var1 == this.componentType) {
            var3 = true;
         } else {
            var3 = false;
         }

         Preconditions.checkArgument(var3);
         this.values.add(var2);
      }

      Object toArray() {
         return Types.toArray(this.values, this.componentType);
      }
   }
}
