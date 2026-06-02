package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class DataMap extends AbstractMap<String, Object> {
   final ClassInfo classInfo;
   final Object object;

   DataMap(Object var1, boolean var2) {
      this.object = var1;
      this.classInfo = ClassInfo.of(var1.getClass(), var2);
      if (!this.classInfo.isEnum()) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
   }

   @Override
   public boolean containsKey(Object var1) {
      boolean var2;
      if (this.get(var1) != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public DataMap.EntrySet entrySet() {
      return new DataMap.EntrySet(this);
   }

   @Override
   public Object get(Object var1) {
      Object var2 = null;
      if (!(var1 instanceof String)) {
         var1 = var2;
      } else {
         FieldInfo var3 = this.classInfo.getFieldInfo((String)var1);
         var1 = var2;
         if (var3 != null) {
            var1 = var3.getValue(this.object);
         }
      }

      return var1;
   }

   public Object put(String var1, Object var2) {
      FieldInfo var3 = this.classInfo.getFieldInfo(var1);
      var1 = String.valueOf(var1);
      if (var1.length() != 0) {
         var1 = "no field of key ".concat(var1);
      } else {
         var1 = new String("no field of key ");
      }

      Preconditions.checkNotNull(var3, var1);
      Object var6 = var3.getValue(this.object);
      var3.setValue(this.object, Preconditions.checkNotNull(var2));
      return var6;
   }

   final class Entry implements java.util.Map.Entry<String, Object> {
      private final FieldInfo fieldInfo;
      private Object fieldValue;
      final DataMap this$0;

      Entry(DataMap var1, FieldInfo var2, Object var3) {
         this.this$0 = var1;
         this.fieldInfo = var2;
         this.fieldValue = Preconditions.checkNotNull(var3);
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this != var1) {
            if (!(var1 instanceof java.util.Map.Entry)) {
               var2 = false;
            } else {
               var1 = var1;
               if (!this.getKey().equals(var1.getKey()) || !this.getValue().equals(var1.getValue())) {
                  var2 = false;
               }
            }
         }

         return var2;
      }

      public String getKey() {
         String var2 = this.fieldInfo.getName();
         String var1 = var2;
         if (this.this$0.classInfo.getIgnoreCase()) {
            var1 = var2.toLowerCase();
         }

         return var1;
      }

      @Override
      public Object getValue() {
         return this.fieldValue;
      }

      @Override
      public int hashCode() {
         return this.getKey().hashCode() ^ this.getValue().hashCode();
      }

      @Override
      public Object setValue(Object var1) {
         Object var2 = this.fieldValue;
         this.fieldValue = Preconditions.checkNotNull(var1);
         this.fieldInfo.setValue(this.this$0.object, var1);
         return var2;
      }
   }

   final class EntryIterator implements Iterator<java.util.Map.Entry<String, Object>> {
      private FieldInfo currentFieldInfo;
      private boolean isComputed;
      private boolean isRemoved;
      private FieldInfo nextFieldInfo;
      private Object nextFieldValue;
      private int nextKeyIndex;
      final DataMap this$0;

      EntryIterator(DataMap var1) {
         this.this$0 = var1;
         this.nextKeyIndex = -1;
      }

      @Override
      public boolean hasNext() {
         if (!this.isComputed) {
            this.isComputed = true;

            for (this.nextFieldValue = null; this.nextFieldValue == null; this.nextFieldValue = this.nextFieldInfo.getValue(this.this$0.object)) {
               int var1 = this.nextKeyIndex + 1;
               this.nextKeyIndex = var1;
               if (var1 >= this.this$0.classInfo.names.size()) {
                  break;
               }

               this.nextFieldInfo = this.this$0.classInfo.getFieldInfo(this.this$0.classInfo.names.get(this.nextKeyIndex));
            }
         }

         boolean var2;
         if (this.nextFieldValue != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public java.util.Map.Entry<String, Object> next() {
         if (!this.hasNext()) {
            throw new NoSuchElementException();
         }

         this.currentFieldInfo = this.nextFieldInfo;
         Object var1 = this.nextFieldValue;
         this.isComputed = false;
         this.isRemoved = false;
         this.nextFieldInfo = null;
         this.nextFieldValue = null;
         return this.this$0.new Entry(this.this$0, this.currentFieldInfo, var1);
      }

      @Override
      public void remove() {
         boolean var1;
         if (this.currentFieldInfo != null && !this.isRemoved) {
            var1 = true;
         } else {
            var1 = false;
         }

         Preconditions.checkState(var1);
         this.isRemoved = true;
         this.currentFieldInfo.setValue(this.this$0.object, null);
      }
   }

   final class EntrySet extends AbstractSet<java.util.Map.Entry<String, Object>> {
      final DataMap this$0;

      EntrySet(DataMap var1) {
         this.this$0 = var1;
      }

      @Override
      public void clear() {
         for (String var1 : this.this$0.classInfo.names) {
            this.this$0.classInfo.getFieldInfo(var1).setValue(this.this$0.object, null);
         }
      }

      @Override
      public boolean isEmpty() {
         Iterator var2 = this.this$0.classInfo.names.iterator();

         boolean var1;
         while (true) {
            if (var2.hasNext()) {
               String var3 = (String)var2.next();
               if (this.this$0.classInfo.getFieldInfo(var3).getValue(this.this$0.object) == null) {
                  continue;
               }

               var1 = false;
               break;
            }

            var1 = true;
            break;
         }

         return var1;
      }

      public DataMap.EntryIterator iterator() {
         return this.this$0.new EntryIterator(this.this$0);
      }

      @Override
      public int size() {
         Iterator var2 = this.this$0.classInfo.names.iterator();
         int var1 = 0;

         while (var2.hasNext()) {
            String var3 = (String)var2.next();
            if (this.this$0.classInfo.getFieldInfo(var3).getValue(this.this$0.object) != null) {
               var1++;
            }
         }

         return var1;
      }
   }
}
