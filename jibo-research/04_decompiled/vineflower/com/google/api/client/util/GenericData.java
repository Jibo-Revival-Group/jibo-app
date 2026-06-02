package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class GenericData extends AbstractMap<String, Object> implements Cloneable {
   final ClassInfo classInfo;
   Map<String, Object> unknownFields = ArrayMap.create();

   public GenericData() {
      this(EnumSet.noneOf(GenericData.Flags.class));
   }

   public GenericData(EnumSet<GenericData.Flags> var1) {
      this.classInfo = ClassInfo.of(this.getClass(), var1.contains(GenericData.Flags.IGNORE_CASE));
   }

   public GenericData clone() {
      try {
         GenericData var1 = (GenericData)super.clone();
         Data.deepCopy(this, var1);
         var1.unknownFields = Data.clone(this.unknownFields);
         return var1;
      } catch (CloneNotSupportedException var2) {
         throw new IllegalStateException(var2);
      }
   }

   @Override
   public Set<Entry<String, Object>> entrySet() {
      return new GenericData.EntrySet(this);
   }

   @Override
   public final Object get(Object var1) {
      if (!(var1 instanceof String)) {
         var1 = null;
      } else {
         String var2 = (String)var1;
         FieldInfo var4 = this.classInfo.getFieldInfo(var2);
         if (var4 != null) {
            var1 = var4.getValue(this);
         } else {
            String var5 = var2;
            if (this.classInfo.getIgnoreCase()) {
               var5 = var2.toLowerCase();
            }

            var1 = this.unknownFields.get(var5);
         }
      }

      return var1;
   }

   public final ClassInfo getClassInfo() {
      return this.classInfo;
   }

   public final Map<String, Object> getUnknownKeys() {
      return this.unknownFields;
   }

   public final Object put(String var1, Object var2) {
      FieldInfo var3 = this.classInfo.getFieldInfo(var1);
      Object var4;
      if (var3 != null) {
         var4 = var3.getValue(this);
         var3.setValue(this, var2);
      } else {
         String var5 = var1;
         if (this.classInfo.getIgnoreCase()) {
            var5 = var1.toLowerCase();
         }

         var4 = this.unknownFields.put(var5, var2);
      }

      return var4;
   }

   @Override
   public final void putAll(Map<? extends String, ?> var1) {
      for (Entry var2 : var1.entrySet()) {
         this.set((String)var2.getKey(), var2.getValue());
      }
   }

   @Override
   public final Object remove(Object var1) {
      if (!(var1 instanceof String)) {
         var1 = null;
      } else {
         String var2 = (String)var1;
         if (this.classInfo.getFieldInfo(var2) != null) {
            throw new UnsupportedOperationException();
         }

         String var4 = var2;
         if (this.classInfo.getIgnoreCase()) {
            var4 = var2.toLowerCase();
         }

         var1 = this.unknownFields.remove(var4);
      }

      return var1;
   }

   public GenericData set(String var1, Object var2) {
      FieldInfo var3 = this.classInfo.getFieldInfo(var1);
      if (var3 != null) {
         var3.setValue(this, var2);
      } else {
         String var4 = var1;
         if (this.classInfo.getIgnoreCase()) {
            var4 = var1.toLowerCase();
         }

         this.unknownFields.put(var4, var2);
      }

      return this;
   }

   public final void setUnknownKeys(Map<String, Object> var1) {
      this.unknownFields = var1;
   }

   final class EntryIterator implements Iterator<Entry<String, Object>> {
      private final Iterator<Entry<String, Object>> fieldIterator;
      private boolean startedUnknown;
      final GenericData this$0;
      private final Iterator<Entry<String, Object>> unknownIterator;

      EntryIterator(GenericData var1, DataMap.EntrySet var2) {
         this.this$0 = var1;
         this.fieldIterator = var2.iterator();
         this.unknownIterator = var1.unknownFields.entrySet().iterator();
      }

      @Override
      public boolean hasNext() {
         boolean var1;
         if (!this.fieldIterator.hasNext() && !this.unknownIterator.hasNext()) {
            var1 = false;
         } else {
            var1 = true;
         }

         return var1;
      }

      public Entry<String, Object> next() {
         if (!this.startedUnknown) {
            if (this.fieldIterator.hasNext()) {
               return this.fieldIterator.next();
            }

            this.startedUnknown = true;
         }

         return this.unknownIterator.next();
      }

      @Override
      public void remove() {
         if (this.startedUnknown) {
            this.unknownIterator.remove();
         }

         this.fieldIterator.remove();
      }
   }

   final class EntrySet extends AbstractSet<Entry<String, Object>> {
      private final DataMap.EntrySet dataEntrySet;
      final GenericData this$0;

      EntrySet(GenericData var1) {
         this.this$0 = var1;
         this.dataEntrySet = new DataMap(var1, var1.classInfo.getIgnoreCase()).entrySet();
      }

      @Override
      public void clear() {
         this.this$0.unknownFields.clear();
         this.dataEntrySet.clear();
      }

      @Override
      public Iterator<Entry<String, Object>> iterator() {
         return this.this$0.new EntryIterator(this.this$0, this.dataEntrySet);
      }

      @Override
      public int size() {
         return this.this$0.unknownFields.size() + this.dataEntrySet.size();
      }
   }

   public enum Flags {
      IGNORE_CASE;

      private static final GenericData.Flags[] $VALUES = new GenericData.Flags[]{GenericData.Flags.IGNORE_CASE};
   }
}
