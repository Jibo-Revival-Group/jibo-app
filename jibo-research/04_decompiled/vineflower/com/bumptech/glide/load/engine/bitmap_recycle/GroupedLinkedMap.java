package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupedLinkedMap<K extends Poolable, V> {
   private final GroupedLinkedMap.LinkedEntry<K, V> head = new GroupedLinkedMap.LinkedEntry<>();
   private final Map<K, GroupedLinkedMap.LinkedEntry<K, V>> keyToEntry = new HashMap<>();

   private void makeHead(GroupedLinkedMap.LinkedEntry<K, V> var1) {
      removeEntry(var1);
      var1.prev = this.head;
      var1.next = this.head.next;
      updateEntry(var1);
   }

   private void makeTail(GroupedLinkedMap.LinkedEntry<K, V> var1) {
      removeEntry(var1);
      var1.prev = this.head.prev;
      var1.next = this.head;
      updateEntry(var1);
   }

   private static <K, V> void removeEntry(GroupedLinkedMap.LinkedEntry<K, V> var0) {
      var0.prev.next = var0.next;
      var0.next.prev = var0.prev;
   }

   private static <K, V> void updateEntry(GroupedLinkedMap.LinkedEntry<K, V> var0) {
      var0.next.prev = var0;
      var0.prev.next = var0;
   }

   public V get(K var1) {
      GroupedLinkedMap.LinkedEntry var2 = this.keyToEntry.get(var1);
      GroupedLinkedMap.LinkedEntry var3;
      if (var2 == null) {
         var2 = new GroupedLinkedMap.LinkedEntry<>(var1);
         this.keyToEntry.put((K)var1, var2);
         var3 = var2;
      } else {
         var1.offer();
         var3 = var2;
      }

      this.makeHead(var3);
      return (V)var3.removeLast();
   }

   public void put(K var1, V var2) {
      GroupedLinkedMap.LinkedEntry var3 = this.keyToEntry.get(var1);
      GroupedLinkedMap.LinkedEntry var4;
      if (var3 == null) {
         var3 = new GroupedLinkedMap.LinkedEntry<>(var1);
         this.makeTail(var3);
         this.keyToEntry.put((K)var1, var3);
         var4 = var3;
      } else {
         var1.offer();
         var4 = var3;
      }

      var4.add(var2);
   }

   public V removeLast() {
      GroupedLinkedMap.LinkedEntry var1 = this.head.prev;

      while (true) {
         if (var1.equals(this.head)) {
            var3 = null;
            break;
         }

         Object var2 = var1.removeLast();
         if (var2 != null) {
            var3 = var2;
            break;
         }

         removeEntry(var1);
         this.keyToEntry.remove(var1.key);
         var1.key.offer();
         var1 = var1.prev;
      }

      return (V)var3;
   }

   @Override
   public String toString() {
      StringBuilder var3 = new StringBuilder("GroupedLinkedMap( ");
      GroupedLinkedMap.LinkedEntry var2 = this.head.next;
      boolean var1 = false;

      while (!var2.equals(this.head)) {
         var1 = true;
         var3.append('{').append(var2.key).append(':').append(var2.size()).append("}, ");
         var2 = var2.next;
      }

      if (var1) {
         var3.delete(var3.length() - 2, var3.length());
      }

      return var3.append(" )").toString();
   }

   private static class LinkedEntry<K, V> {
      private final K key;
      GroupedLinkedMap.LinkedEntry<K, V> next;
      GroupedLinkedMap.LinkedEntry<K, V> prev = this;
      private List<V> values;

      public LinkedEntry() {
         this(null);
      }

      public LinkedEntry(K var1) {
         this.next = this;
         this.key = (K)var1;
      }

      public void add(V var1) {
         if (this.values == null) {
            this.values = new ArrayList<>();
         }

         this.values.add((V)var1);
      }

      public V removeLast() {
         int var1 = this.size();
         Object var2;
         if (var1 > 0) {
            var2 = this.values.remove(var1 - 1);
         } else {
            var2 = null;
         }

         return (V)var2;
      }

      public int size() {
         int var1;
         if (this.values != null) {
            var1 = this.values.size();
         } else {
            var1 = 0;
         }

         return var1;
      }
   }
}
