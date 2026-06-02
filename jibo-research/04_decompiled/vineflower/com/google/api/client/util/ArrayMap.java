package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class ArrayMap<K, V> extends AbstractMap<K, V> implements Cloneable {
   private Object[] data;
   int size;

   public static <K, V> ArrayMap<K, V> create() {
      return new ArrayMap<>();
   }

   public static <K, V> ArrayMap<K, V> create(int var0) {
      ArrayMap var1 = create();
      var1.ensureCapacity(var0);
      return var1;
   }

   private int getDataIndexOfKey(Object var1) {
      int var4 = this.size;
      Object[] var5 = this.data;
      byte var2 = 0;

      byte var3;
      while (true) {
         if (var2 >= var4 << 1) {
            var3 = -2;
            break;
         }

         Object var6 = var5[var2];
         if (var1 == null) {
            if (var6 == null) {
               var3 = var2;
               break;
            }
         } else {
            var3 = var2;
            if (var1.equals(var6)) {
               break;
            }
         }

         var2 += 2;
      }

      return var3;
   }

   public static <K, V> ArrayMap<K, V> of(Object... var0) {
      ArrayMap var2 = create(1);
      int var1 = var0.length;
      if (1 == var1 % 2) {
         String var4 = String.valueOf(String.valueOf(var0[var1 - 1]));
         throw new IllegalArgumentException(new StringBuilder(var4.length() + 28).append("missing value for last key: ").append(var4).toString());
      } else {
         var2.size = var0.length / 2;
         Object[] var3 = new Object[var1];
         var2.data = var3;
         System.arraycopy(var0, 0, var3, 0, var1);
         return var2;
      }
   }

   private V removeFromDataIndexOfKey(int var1) {
      int var2 = this.size << 1;
      Object var4;
      if (var1 >= 0 && var1 < var2) {
         var4 = this.valueAtDataIndex(var1 + 1);
         Object[] var5 = this.data;
         int var3 = var2 - var1 - 2;
         if (var3 != 0) {
            System.arraycopy(var5, var1 + 2, var5, var1, var3);
         }

         this.size--;
         this.setData(var2 - 2, null, null);
      } else {
         var4 = null;
      }

      return (V)var4;
   }

   private void setData(int var1, K var2, V var3) {
      Object[] var4 = this.data;
      var4[var1] = var2;
      var4[var1 + 1] = var3;
   }

   private void setDataCapacity(int var1) {
      if (var1 == 0) {
         this.data = null;
      } else {
         int var2 = this.size;
         Object[] var3 = this.data;
         if (var2 == 0 || var1 != var3.length) {
            Object[] var4 = new Object[var1];
            this.data = var4;
            if (var2 != 0) {
               System.arraycopy(var3, 0, var4, 0, var2 << 1);
            }
         }
      }
   }

   private V valueAtDataIndex(int var1) {
      Object var2;
      if (var1 < 0) {
         var2 = null;
      } else {
         var2 = this.data[var1];
      }

      return (V)var2;
   }

   public final void add(K var1, V var2) {
      this.set(this.size, (K)var1, (V)var2);
   }

   @Override
   public void clear() {
      this.size = 0;
      this.data = null;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public ArrayMap<K, V> clone() {
      ArrayMap var3;
      Object[] var4;
      try {
         var3 = (ArrayMap)super.clone();
         var4 = this.data;
      } catch (CloneNotSupportedException var6) {
         return null;
      }

      ArrayMap var2 = var3;
      if (var4 != null) {
         try {
            int var1 = var4.length;
            Object[] var7 = new Object[var1];
            var3.data = var7;
            System.arraycopy(var4, 0, var7, 0, var1);
         } catch (CloneNotSupportedException var5) {
            var2 = null;
            return var2;
         }

         var2 = var3;
      }

      return var2;
   }

   @Override
   public final boolean containsKey(Object var1) {
      boolean var2;
      if (-2 != this.getDataIndexOfKey(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public final boolean containsValue(Object var1) {
      boolean var5 = true;
      int var3 = this.size;
      Object[] var7 = this.data;
      byte var2 = 1;

      boolean var4;
      while (true) {
         if (var2 >= var3 << 1) {
            var4 = false;
            break;
         }

         Object var6 = var7[var2];
         if (var1 == null) {
            if (var6 == null) {
               var4 = var5;
               break;
            }
         } else {
            var4 = var5;
            if (var1.equals(var6)) {
               break;
            }
         }

         var2 += 2;
      }

      return var4;
   }

   public final void ensureCapacity(int var1) {
      if (var1 < 0) {
         throw new IndexOutOfBoundsException();
      }

      Object[] var4 = this.data;
      int var2 = var1 << 1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.length;
      }

      if (var2 > var1) {
         int var3 = var1 / 2 * 3 + 1;
         var1 = var3;
         if (var3 % 2 != 0) {
            var1 = var3 + 1;
         }

         if (var1 < var2) {
            var1 = var2;
         }

         this.setDataCapacity(var1);
      }
   }

   @Override
   public final Set<java.util.Map.Entry<K, V>> entrySet() {
      return new ArrayMap.EntrySet(this);
   }

   @Override
   public final V get(Object var1) {
      return this.valueAtDataIndex(this.getDataIndexOfKey(var1) + 1);
   }

   public final int getIndexOfKey(K var1) {
      return this.getDataIndexOfKey(var1) >> 1;
   }

   public final K getKey(int var1) {
      Object var2;
      if (var1 >= 0 && var1 < this.size) {
         var2 = this.data[var1 << 1];
      } else {
         var2 = null;
      }

      return (K)var2;
   }

   public final V getValue(int var1) {
      Object var2;
      if (var1 >= 0 && var1 < this.size) {
         var2 = this.valueAtDataIndex((var1 << 1) + 1);
      } else {
         var2 = null;
      }

      return (V)var2;
   }

   @Override
   public final V put(K var1, V var2) {
      int var4 = this.getIndexOfKey((K)var1);
      int var3 = var4;
      if (var4 == -1) {
         var3 = this.size;
      }

      return this.set(var3, (K)var1, (V)var2);
   }

   public final V remove(int var1) {
      return this.removeFromDataIndexOfKey(var1 << 1);
   }

   @Override
   public final V remove(Object var1) {
      return this.removeFromDataIndexOfKey(this.getDataIndexOfKey(var1));
   }

   public final V set(int var1, V var2) {
      int var3 = this.size;
      if (var1 >= 0 && var1 < var3) {
         var1 = (var1 << 1) + 1;
         Object var4 = this.valueAtDataIndex(var1);
         this.data[var1] = var2;
         return (V)var4;
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public final V set(int var1, K var2, V var3) {
      if (var1 < 0) {
         throw new IndexOutOfBoundsException();
      }

      int var4 = var1 + 1;
      this.ensureCapacity(var4);
      var1 <<= 1;
      Object var5 = this.valueAtDataIndex(var1 + 1);
      this.setData(var1, (K)var2, (V)var3);
      if (var4 > this.size) {
         this.size = var4;
      }

      return (V)var5;
   }

   @Override
   public final int size() {
      return this.size;
   }

   public final void trim() {
      this.setDataCapacity(this.size << 1);
   }

   final class Entry implements java.util.Map.Entry<K, V> {
      private int index;
      final ArrayMap this$0;

      Entry(ArrayMap var1, int var2) {
         this.this$0 = var1;
         this.index = var2;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this != var1) {
            if (!(var1 instanceof java.util.Map.Entry)) {
               var2 = false;
            } else {
               var1 = var1;
               if (!Objects.equal(this.getKey(), var1.getKey()) || !Objects.equal(this.getValue(), var1.getValue())) {
                  var2 = false;
               }
            }
         }

         return var2;
      }

      @Override
      public K getKey() {
         return (K)this.this$0.getKey(this.index);
      }

      @Override
      public V getValue() {
         return (V)this.this$0.getValue(this.index);
      }

      @Override
      public int hashCode() {
         return this.getKey().hashCode() ^ this.getValue().hashCode();
      }

      @Override
      public V setValue(V var1) {
         return (V)this.this$0.set(this.index, var1);
      }
   }

   final class EntryIterator implements Iterator<java.util.Map.Entry<K, V>> {
      private int nextIndex;
      private boolean removed;
      final ArrayMap this$0;

      EntryIterator(ArrayMap var1) {
         this.this$0 = var1;
      }

      @Override
      public boolean hasNext() {
         boolean var1;
         if (this.nextIndex < this.this$0.size) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public java.util.Map.Entry<K, V> next() {
         int var1 = this.nextIndex;
         if (var1 == this.this$0.size) {
            throw new NoSuchElementException();
         }

         this.nextIndex++;
         return this.this$0.new Entry(this.this$0, var1);
      }

      @Override
      public void remove() {
         int var1 = this.nextIndex - 1;
         if (!this.removed && var1 >= 0) {
            this.this$0.remove(var1);
            this.removed = true;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   final class EntrySet extends AbstractSet<java.util.Map.Entry<K, V>> {
      final ArrayMap this$0;

      EntrySet(ArrayMap var1) {
         this.this$0 = var1;
      }

      @Override
      public Iterator<java.util.Map.Entry<K, V>> iterator() {
         return this.this$0.new EntryIterator(this.this$0);
      }

      @Override
      public int size() {
         return this.this$0.size;
      }
   }
}
