package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;

abstract class MapCollections<K, V> {
   MapCollections<K, V>.EntrySet b;
   MapCollections<K, V>.KeySet c;
   MapCollections<K, V>.ValuesCollection d;

   public static <K, V> boolean a(Map<K, V> var0, Collection<?> var1) {
      Iterator var3 = var1.iterator();

      boolean var2;
      while (true) {
         if (var3.hasNext()) {
            if (var0.containsKey(var3.next())) {
               continue;
            }

            var2 = false;
            break;
         }

         var2 = true;
         break;
      }

      return var2;
   }

   public static <T> boolean a(Set<T> var0, Object var1) {
      boolean var4 = true;
      boolean var3 = false;
      boolean var2;
      if (var0 == var1) {
         var2 = true;
      } else {
         var2 = var3;
         if (var1 instanceof Set) {
            var1 = var1;

            label26: {
               try {
                  if (var0.size() != var1.size()) {
                     break label26;
                  }

                  var2 = var0.containsAll(var1);
               } catch (NullPointerException var5) {
                  var2 = var3;
                  return var2;
               } catch (ClassCastException var6) {
                  var2 = var3;
                  return var2;
               }

               if (var2) {
                  var2 = var4;
                  return var2;
               }
            }

            var2 = false;
         }
      }

      return var2;
   }

   public static <K, V> boolean b(Map<K, V> var0, Collection<?> var1) {
      int var2 = var0.size();
      Iterator var4 = var1.iterator();

      while (var4.hasNext()) {
         var0.remove(var4.next());
      }

      boolean var3;
      if (var2 != var0.size()) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public static <K, V> boolean c(Map<K, V> var0, Collection<?> var1) {
      int var2 = var0.size();
      Iterator var4 = var0.keySet().iterator();

      while (var4.hasNext()) {
         if (!var1.contains(var4.next())) {
            var4.remove();
         }
      }

      boolean var3;
      if (var2 != var0.size()) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   protected abstract int a();

   protected abstract int a(Object var1);

   protected abstract Object a(int var1, int var2);

   protected abstract V a(int var1, V var2);

   protected abstract void a(int var1);

   protected abstract void a(K var1, V var2);

   public <T> T[] a(T[] var1, int var2) {
      int var4 = this.a();
      if (var1.length < var4) {
         var1 = (Object[])Array.newInstance(var1.getClass().getComponentType(), var4);
      }

      for (int var3 = 0; var3 < var4; var3++) {
         var1[var3] = this.a(var3, var2);
      }

      if (var1.length > var4) {
         var1[var4] = null;
      }

      return (T[])var1;
   }

   protected abstract int b(Object var1);

   protected abstract Map<K, V> b();

   public Object[] b(int var1) {
      int var3 = this.a();
      Object[] var4 = new Object[var3];

      for (int var2 = 0; var2 < var3; var2++) {
         var4[var2] = this.a(var2, var1);
      }

      return var4;
   }

   protected abstract void c();

   public Set<Entry<K, V>> d() {
      if (this.b == null) {
         this.b = new MapCollections.EntrySet(this);
      }

      return this.b;
   }

   public Set<K> e() {
      if (this.c == null) {
         this.c = new MapCollections.KeySet(this);
      }

      return this.c;
   }

   public Collection<V> f() {
      if (this.d == null) {
         this.d = new MapCollections.ValuesCollection(this);
      }

      return this.d;
   }

   final class ArrayIterator<T> implements Iterator<T> {
      final int a;
      int b;
      int c;
      boolean d;
      final MapCollections e;

      ArrayIterator(MapCollections var1, int var2) {
         this.e = var1;
         this.d = false;
         this.a = var2;
         this.b = var1.a();
      }

      @Override
      public boolean hasNext() {
         boolean var1;
         if (this.c < this.b) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      @Override
      public T next() {
         if (!this.hasNext()) {
            throw new NoSuchElementException();
         }

         Object var1 = this.e.a(this.c, this.a);
         this.c++;
         this.d = true;
         return (T)var1;
      }

      @Override
      public void remove() {
         if (!this.d) {
            throw new IllegalStateException();
         }

         this.c--;
         this.b--;
         this.d = false;
         this.e.a(this.c);
      }
   }

   final class EntrySet implements Set<Entry<K, V>> {
      final MapCollections a;

      EntrySet(MapCollections var1) {
         this.a = var1;
      }

      public boolean a(Entry<K, V> var1) {
         throw new UnsupportedOperationException();
      }

      @Override
      public boolean addAll(Collection<? extends Entry<K, V>> var1) {
         int var2 = this.a.a();

         for (Entry var4 : var1) {
            this.a.a(var4.getKey(), var4.getValue());
         }

         boolean var3;
         if (var2 != this.a.a()) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      @Override
      public void clear() {
         this.a.c();
      }

      @Override
      public boolean contains(Object var1) {
         boolean var3 = false;
         if (var1 instanceof Entry) {
            var1 = var1;
            int var2 = this.a.a(var1.getKey());
            if (var2 >= 0) {
               var3 = ContainerHelpers.a(this.a.a(var2, 1), var1.getValue());
            }
         }

         return var3;
      }

      @Override
      public boolean containsAll(Collection<?> var1) {
         Iterator var3 = var1.iterator();

         boolean var2;
         while (true) {
            if (var3.hasNext()) {
               if (this.contains(var3.next())) {
                  continue;
               }

               var2 = false;
               break;
            }

            var2 = true;
            break;
         }

         return var2;
      }

      @Override
      public boolean equals(Object var1) {
         return MapCollections.a(this, var1);
      }

      @Override
      public int hashCode() {
         int var2 = this.a.a() - 1;
         int var1 = 0;

         while (var2 >= 0) {
            Object var6 = this.a.a(var2, 0);
            Object var5 = this.a.a(var2, 1);
            int var3;
            if (var6 == null) {
               var3 = 0;
            } else {
               var3 = var6.hashCode();
            }

            int var4;
            if (var5 == null) {
               var4 = 0;
            } else {
               var4 = var5.hashCode();
            }

            var2--;
            var1 += var4 ^ var3;
         }

         return var1;
      }

      @Override
      public boolean isEmpty() {
         boolean var1;
         if (this.a.a() == 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      @Override
      public Iterator<Entry<K, V>> iterator() {
         return this.a.new MapIterator(this.a);
      }

      @Override
      public boolean remove(Object var1) {
         throw new UnsupportedOperationException();
      }

      @Override
      public boolean removeAll(Collection<?> var1) {
         throw new UnsupportedOperationException();
      }

      @Override
      public boolean retainAll(Collection<?> var1) {
         throw new UnsupportedOperationException();
      }

      @Override
      public int size() {
         return this.a.a();
      }

      @Override
      public Object[] toArray() {
         throw new UnsupportedOperationException();
      }

      @Override
      public <T> T[] toArray(T[] var1) {
         throw new UnsupportedOperationException();
      }
   }

   final class KeySet implements Set<K> {
      final MapCollections a;

      KeySet(MapCollections var1) {
         this.a = var1;
      }

      @Override
      public boolean add(K var1) {
         throw new UnsupportedOperationException();
      }

      @Override
      public boolean addAll(Collection<? extends K> var1) {
         throw new UnsupportedOperationException();
      }

      @Override
      public void clear() {
         this.a.c();
      }

      @Override
      public boolean contains(Object var1) {
         boolean var2;
         if (this.a.a(var1) >= 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public boolean containsAll(Collection<?> var1) {
         return MapCollections.a(this.a.b(), var1);
      }

      @Override
      public boolean equals(Object var1) {
         return MapCollections.a(this, var1);
      }

      @Override
      public int hashCode() {
         int var1 = this.a.a() - 1;
         int var2 = 0;

         while (var1 >= 0) {
            Object var4 = this.a.a(var1, 0);
            int var3;
            if (var4 == null) {
               var3 = 0;
            } else {
               var3 = var4.hashCode();
            }

            var2 += var3;
            var1--;
         }

         return var2;
      }

      @Override
      public boolean isEmpty() {
         boolean var1;
         if (this.a.a() == 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      @Override
      public Iterator<K> iterator() {
         return this.a.new ArrayIterator<>(this.a, 0);
      }

      @Override
      public boolean remove(Object var1) {
         int var2 = this.a.a(var1);
         boolean var3;
         if (var2 >= 0) {
            this.a.a(var2);
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      @Override
      public boolean removeAll(Collection<?> var1) {
         return MapCollections.b(this.a.b(), var1);
      }

      @Override
      public boolean retainAll(Collection<?> var1) {
         return MapCollections.c(this.a.b(), var1);
      }

      @Override
      public int size() {
         return this.a.a();
      }

      @Override
      public Object[] toArray() {
         return this.a.b(0);
      }

      @Override
      public <T> T[] toArray(T[] var1) {
         return (T[])this.a.a(var1, 0);
      }
   }

   final class MapIterator implements Iterator<Entry<K, V>>, Entry<K, V> {
      int a;
      int b;
      boolean c;
      final MapCollections d;

      MapIterator(MapCollections var1) {
         this.d = var1;
         this.c = false;
         this.a = var1.a() - 1;
         this.b = -1;
      }

      public Entry<K, V> a() {
         if (!this.hasNext()) {
            throw new NoSuchElementException();
         }

         this.b++;
         this.c = true;
         return this;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         boolean var3 = false;
         if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         }

         if (!(var1 instanceof Entry)) {
            var2 = var3;
         } else {
            var1 = var1;
            if (!ContainerHelpers.a(var1.getKey(), this.d.a(this.b, 0)) || !ContainerHelpers.a(var1.getValue(), this.d.a(this.b, 1))) {
               var2 = false;
            }
         }

         return var2;
      }

      @Override
      public K getKey() {
         if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         } else {
            return (K)this.d.a(this.b, 0);
         }
      }

      @Override
      public V getValue() {
         if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         } else {
            return (V)this.d.a(this.b, 1);
         }
      }

      @Override
      public boolean hasNext() {
         boolean var1;
         if (this.b < this.a) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      @Override
      public int hashCode() {
         int var2 = 0;
         if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         }

         Object var3 = this.d.a(this.b, 0);
         Object var4 = this.d.a(this.b, 1);
         int var1;
         if (var3 == null) {
            var1 = 0;
         } else {
            var1 = var3.hashCode();
         }

         if (var4 != null) {
            var2 = var4.hashCode();
         }

         return var2 ^ var1;
      }

      @Override
      public void remove() {
         if (!this.c) {
            throw new IllegalStateException();
         }

         this.d.a(this.b);
         this.b--;
         this.a--;
         this.c = false;
      }

      @Override
      public V setValue(V var1) {
         if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         } else {
            return (V)this.d.a(this.b, var1);
         }
      }

      @Override
      public String toString() {
         return this.getKey() + "=" + this.getValue();
      }
   }

   final class ValuesCollection implements Collection<V> {
      final MapCollections a;

      ValuesCollection(MapCollections var1) {
         this.a = var1;
      }

      @Override
      public boolean add(V var1) {
         throw new UnsupportedOperationException();
      }

      @Override
      public boolean addAll(Collection<? extends V> var1) {
         throw new UnsupportedOperationException();
      }

      @Override
      public void clear() {
         this.a.c();
      }

      @Override
      public boolean contains(Object var1) {
         boolean var2;
         if (this.a.b(var1) >= 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public boolean containsAll(Collection<?> var1) {
         Iterator var3 = var1.iterator();

         boolean var2;
         while (true) {
            if (var3.hasNext()) {
               if (this.contains(var3.next())) {
                  continue;
               }

               var2 = false;
               break;
            }

            var2 = true;
            break;
         }

         return var2;
      }

      @Override
      public boolean isEmpty() {
         boolean var1;
         if (this.a.a() == 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      @Override
      public Iterator<V> iterator() {
         return this.a.new ArrayIterator<>(this.a, 1);
      }

      @Override
      public boolean remove(Object var1) {
         int var2 = this.a.b(var1);
         boolean var3;
         if (var2 >= 0) {
            this.a.a(var2);
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      @Override
      public boolean removeAll(Collection<?> var1) {
         int var2 = 0;
         int var3 = this.a.a();
         boolean var6 = false;

         while (var2 < var3) {
            int var5 = var2;
            int var4 = var3;
            if (var1.contains(this.a.a(var2, 1))) {
               this.a.a(var2);
               var5 = var2 - 1;
               var4 = var3 - 1;
               var6 = true;
            }

            var2 = var5 + 1;
            var3 = var4;
         }

         return var6;
      }

      @Override
      public boolean retainAll(Collection<?> var1) {
         int var2 = 0;
         int var3 = this.a.a();
         boolean var6 = false;

         while (var2 < var3) {
            int var5 = var2;
            int var4 = var3;
            if (!var1.contains(this.a.a(var2, 1))) {
               this.a.a(var2);
               var5 = var2 - 1;
               var4 = var3 - 1;
               var6 = true;
            }

            var2 = var5 + 1;
            var3 = var4;
         }

         return var6;
      }

      @Override
      public int size() {
         return this.a.a();
      }

      @Override
      public Object[] toArray() {
         return this.a.b(1);
      }

      @Override
      public <T> T[] toArray(T[] var1) {
         return (T[])this.a.a(var1, 1);
      }
   }
}
