package android.arch.core.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {
   private SafeIterableMap.Entry<K, V> a;
   private SafeIterableMap.Entry<K, V> b;
   private WeakHashMap<SafeIterableMap.SupportRemove<K, V>, Boolean> c = new WeakHashMap<>();
   private int d = 0;

   public int a() {
      return this.d;
   }

   protected SafeIterableMap.Entry<K, V> a(K var1) {
      SafeIterableMap.Entry var2 = this.a;

      while (var2 != null && !var2.a.equals(var1)) {
         var2 = var2.c;
      }

      return var2;
   }

   public V a(K var1, V var2) {
      SafeIterableMap.Entry var3 = this.a((K)var1);
      if (var3 != null) {
         var1 = var3.b;
      } else {
         this.b((K)var1, (V)var2);
         var1 = null;
      }

      return (V)var1;
   }

   protected SafeIterableMap.Entry<K, V> b(K var1, V var2) {
      var1 = new SafeIterableMap.Entry<>(var1, var2);
      this.d++;
      if (this.b == null) {
         this.a = var1;
         this.b = this.a;
      } else {
         this.b.c = var1;
         var1.d = this.b;
         this.b = var1;
      }

      return var1;
   }

   public V b(K var1) {
      SafeIterableMap.Entry var2 = this.a((K)var1);
      if (var2 == null) {
         var1 = null;
      } else {
         this.d--;
         if (!this.c.isEmpty()) {
            var1 = this.c.keySet().iterator();

            while (var1.hasNext()) {
               ((SafeIterableMap.SupportRemove)var1.next()).a_(var2);
            }
         }

         if (var2.d != null) {
            var2.d.c = var2.c;
         } else {
            this.a = var2.c;
         }

         if (var2.c != null) {
            var2.c.d = var2.d;
         } else {
            this.b = var2.d;
         }

         var2.c = null;
         var2.d = null;
         var1 = var2.b;
      }

      return (V)var1;
   }

   public Iterator<Map.Entry<K, V>> b() {
      SafeIterableMap.DescendingIterator var1 = new SafeIterableMap.DescendingIterator<>(this.b, this.a);
      this.c.put(var1, false);
      return var1;
   }

   public SafeIterableMap<K, V>.IteratorWithAdditions c() {
      SafeIterableMap.IteratorWithAdditions var1 = new SafeIterableMap.IteratorWithAdditions(this);
      this.c.put(var1, false);
      return var1;
   }

   public Map.Entry<K, V> d() {
      return this.a;
   }

   public Map.Entry<K, V> e() {
      return this.b;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (var1 == this) {
         var2 = true;
      } else {
         var2 = var3;
         if (var1 instanceof SafeIterableMap) {
            SafeIterableMap var4 = (SafeIterableMap)var1;
            var2 = var3;
            if (this.a() == var4.a()) {
               Iterator var7 = this.iterator();
               Iterator var5 = var4.iterator();

               while (var7.hasNext() && var5.hasNext()) {
                  Map.Entry var6 = (Map.Entry)var7.next();
                  Object var8 = var5.next();
                  if (var6 == null) {
                     var2 = var3;
                     if (var8 != null) {
                        return var2;
                     }
                  }

                  if (var6 != null && !var6.equals(var8)) {
                     var2 = var3;
                     return var2;
                  }
               }

               if (!var7.hasNext() && !var5.hasNext()) {
                  var2 = true;
               } else {
                  var2 = false;
               }
            }
         }
      }

      return var2;
   }

   @Override
   public Iterator<Map.Entry<K, V>> iterator() {
      SafeIterableMap.AscendingIterator var1 = new SafeIterableMap.AscendingIterator<>(this.a, this.b);
      this.c.put(var1, false);
      return var1;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[");
      Iterator var2 = this.iterator();

      while (var2.hasNext()) {
         var1.append(((Map.Entry)var2.next()).toString());
         if (var2.hasNext()) {
            var1.append(", ");
         }
      }

      var1.append("]");
      return var1.toString();
   }

   static class AscendingIterator<K, V> extends SafeIterableMap.ListIterator<K, V> {
      AscendingIterator(SafeIterableMap.Entry<K, V> var1, SafeIterableMap.Entry<K, V> var2) {
         super(var1, var2);
      }

      @Override
      SafeIterableMap.Entry<K, V> a(SafeIterableMap.Entry<K, V> var1) {
         return var1.c;
      }

      @Override
      SafeIterableMap.Entry<K, V> b(SafeIterableMap.Entry<K, V> var1) {
         return var1.d;
      }
   }

   private static class DescendingIterator<K, V> extends SafeIterableMap.ListIterator<K, V> {
      DescendingIterator(SafeIterableMap.Entry<K, V> var1, SafeIterableMap.Entry<K, V> var2) {
         super(var1, var2);
      }

      @Override
      SafeIterableMap.Entry<K, V> a(SafeIterableMap.Entry<K, V> var1) {
         return var1.d;
      }

      @Override
      SafeIterableMap.Entry<K, V> b(SafeIterableMap.Entry<K, V> var1) {
         return var1.c;
      }
   }

   static class Entry<K, V> implements Map.Entry<K, V> {
      final K a;
      final V b;
      SafeIterableMap.Entry<K, V> c;
      SafeIterableMap.Entry<K, V> d;

      Entry(K var1, V var2) {
         this.a = (K)var1;
         this.b = (V)var2;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (var1 != this) {
            if (!(var1 instanceof SafeIterableMap.Entry)) {
               var2 = false;
            } else {
               var1 = var1;
               if (!this.a.equals(var1.a) || !this.b.equals(var1.b)) {
                  var2 = false;
               }
            }
         }

         return var2;
      }

      @Override
      public K getKey() {
         return this.a;
      }

      @Override
      public V getValue() {
         return this.b;
      }

      @Override
      public V setValue(V var1) {
         throw new UnsupportedOperationException("An entry modification is not supported");
      }

      @Override
      public String toString() {
         return this.a + "=" + this.b;
      }
   }

   private class IteratorWithAdditions implements SafeIterableMap.SupportRemove<K, V>, Iterator<Map.Entry<K, V>> {
      final SafeIterableMap a;
      private SafeIterableMap.Entry<K, V> b;
      private boolean c;

      private IteratorWithAdditions(SafeIterableMap var1) {
         this.a = var1;
         this.c = true;
      }

      public Map.Entry<K, V> a() {
         if (this.c) {
            this.c = false;
            this.b = this.a.a;
         } else {
            SafeIterableMap.Entry var1;
            if (this.b != null) {
               var1 = this.b.c;
            } else {
               var1 = null;
            }

            this.b = var1;
         }

         return this.b;
      }

      @Override
      public void a_(SafeIterableMap.Entry<K, V> var1) {
         if (var1 == this.b) {
            this.b = this.b.d;
            boolean var2;
            if (this.b == null) {
               var2 = true;
            } else {
               var2 = false;
            }

            this.c = var2;
         }
      }

      @Override
      public boolean hasNext() {
         boolean var1 = true;
         if (this.c) {
            if (this.a.a == null) {
               var1 = false;
            }
         } else if (this.b == null || this.b.c == null) {
            var1 = false;
         }

         return var1;
      }
   }

   private abstract static class ListIterator<K, V> implements SafeIterableMap.SupportRemove<K, V>, Iterator<Map.Entry<K, V>> {
      SafeIterableMap.Entry<K, V> a;
      SafeIterableMap.Entry<K, V> b;

      ListIterator(SafeIterableMap.Entry<K, V> var1, SafeIterableMap.Entry<K, V> var2) {
         this.a = var2;
         this.b = var1;
      }

      private SafeIterableMap.Entry<K, V> b() {
         SafeIterableMap.Entry var1;
         if (this.b != this.a && this.a != null) {
            var1 = this.a(this.b);
         } else {
            var1 = null;
         }

         return var1;
      }

      abstract SafeIterableMap.Entry<K, V> a(SafeIterableMap.Entry<K, V> var1);

      public Map.Entry<K, V> a() {
         SafeIterableMap.Entry var1 = this.b;
         this.b = this.b();
         return var1;
      }

      @Override
      public void a_(SafeIterableMap.Entry<K, V> var1) {
         if (this.a == var1 && var1 == this.b) {
            this.b = null;
            this.a = null;
         }

         if (this.a == var1) {
            this.a = this.b(this.a);
         }

         if (this.b == var1) {
            this.b = this.b();
         }
      }

      abstract SafeIterableMap.Entry<K, V> b(SafeIterableMap.Entry<K, V> var1);

      @Override
      public boolean hasNext() {
         boolean var1;
         if (this.b != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }
   }

   interface SupportRemove<K, V> {
      void a_(SafeIterableMap.Entry<K, V> var1);
   }
}
