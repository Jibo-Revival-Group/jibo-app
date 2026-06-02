package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
   static final boolean f;
   private static final Comparator<Comparable> g;
   Comparator<? super K> a;
   LinkedTreeMap.Node<K, V> b;
   int c = 0;
   int d = 0;
   final LinkedTreeMap.Node<K, V> e = new LinkedTreeMap.Node<>();
   private LinkedTreeMap<K, V>.EntrySet h;
   private LinkedTreeMap<K, V>.KeySet i;

   static {
      boolean var0;
      if (!LinkedTreeMap.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      f = var0;
      g = new Comparator<Comparable>() {
         public int a(Comparable var1, Comparable var2) {
            return var1.compareTo(var2);
         }
      };
   }

   public LinkedTreeMap() {
      this(g);
   }

   public LinkedTreeMap(Comparator<? super K> var1) {
      if (var1 == null) {
         var1 = g;
      }

      this.a = var1;
   }

   private void a(LinkedTreeMap.Node<K, V> var1) {
      byte var4 = 0;
      LinkedTreeMap.Node var6 = var1.b;
      LinkedTreeMap.Node var8 = var1.c;
      LinkedTreeMap.Node var7 = var8.b;
      LinkedTreeMap.Node var5 = var8.c;
      var1.c = var7;
      if (var7 != null) {
         var7.a = var1;
      }

      this.a(var1, var8);
      var8.b = var1;
      var1.a = var8;
      int var2;
      if (var6 != null) {
         var2 = var6.h;
      } else {
         var2 = 0;
      }

      int var3;
      if (var7 != null) {
         var3 = var7.h;
      } else {
         var3 = 0;
      }

      var1.h = Math.max(var2, var3) + 1;
      var3 = var1.h;
      var2 = var4;
      if (var5 != null) {
         var2 = var5.h;
      }

      var8.h = Math.max(var3, var2) + 1;
   }

   private void a(LinkedTreeMap.Node<K, V> var1, LinkedTreeMap.Node<K, V> var2) {
      LinkedTreeMap.Node var3 = var1.a;
      var1.a = null;
      if (var2 != null) {
         var2.a = var3;
      }

      if (var3 != null) {
         if (var3.b == var1) {
            var3.b = var2;
         } else {
            if (!f && var3.c != var1) {
               throw new AssertionError();
            }

            var3.c = var2;
         }
      } else {
         this.b = var2;
      }
   }

   private boolean a(Object var1, Object var2) {
      boolean var3;
      if (var1 != var2 && (var1 == null || !var1.equals(var2))) {
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   private void b(LinkedTreeMap.Node<K, V> var1) {
      byte var4 = 0;
      LinkedTreeMap.Node var5 = var1.b;
      LinkedTreeMap.Node var7 = var1.c;
      LinkedTreeMap.Node var6 = var5.b;
      LinkedTreeMap.Node var8 = var5.c;
      var1.b = var8;
      if (var8 != null) {
         var8.a = var1;
      }

      this.a(var1, var5);
      var5.c = var1;
      var1.a = var5;
      int var2;
      if (var7 != null) {
         var2 = var7.h;
      } else {
         var2 = 0;
      }

      int var3;
      if (var8 != null) {
         var3 = var8.h;
      } else {
         var3 = 0;
      }

      var1.h = Math.max(var2, var3) + 1;
      var3 = var1.h;
      var2 = var4;
      if (var6 != null) {
         var2 = var6.h;
      }

      var5.h = Math.max(var3, var2) + 1;
   }

   private void b(LinkedTreeMap.Node<K, V> var1, boolean var2) {
      while (var1 != null) {
         LinkedTreeMap.Node var7 = var1.b;
         LinkedTreeMap.Node var6 = var1.c;
         int var3;
         if (var7 != null) {
            var3 = var7.h;
         } else {
            var3 = 0;
         }

         int var4;
         if (var6 != null) {
            var4 = var6.h;
         } else {
            var4 = 0;
         }

         int var5 = var3 - var4;
         if (var5 == -2) {
            var7 = var6.b;
            LinkedTreeMap.Node var8 = var6.c;
            if (var8 != null) {
               var3 = var8.h;
            } else {
               var3 = 0;
            }

            if (var7 != null) {
               var4 = var7.h;
            } else {
               var4 = 0;
            }

            var3 = var4 - var3;
            if (var3 != -1 && (var3 != 0 || var2)) {
               if (!f && var3 != 1) {
                  throw new AssertionError();
               }

               this.b(var6);
               this.a(var1);
            } else {
               this.a(var1);
            }

            if (var2) {
               break;
            }
         } else if (var5 == 2) {
            LinkedTreeMap.Node var17 = var7.b;
            var6 = var7.c;
            if (var6 != null) {
               var3 = var6.h;
            } else {
               var3 = 0;
            }

            if (var17 != null) {
               var4 = var17.h;
            } else {
               var4 = 0;
            }

            var3 = var4 - var3;
            if (var3 != 1 && (var3 != 0 || var2)) {
               if (!f && var3 != -1) {
                  throw new AssertionError();
               }

               this.a(var7);
               this.b(var1);
            } else {
               this.b(var1);
            }

            if (var2) {
               break;
            }
         } else if (var5 == 0) {
            var1.h = var3 + 1;
            if (var2) {
               break;
            }
         } else {
            if (!f && var5 != -1 && var5 != 1) {
               throw new AssertionError();
            }

            var1.h = Math.max(var3, var4) + 1;
            if (!var2) {
               break;
            }
         }

         var1 = var1.a;
      }
   }

   private Object writeReplace() throws ObjectStreamException {
      return new LinkedHashMap<>(this);
   }

   LinkedTreeMap.Node<K, V> a(Object var1) {
      Object var3 = null;
      LinkedTreeMap.Node var2 = (LinkedTreeMap.Node)var3;
      if (var1 != null) {
         try {
            var2 = this.a((K)var1, false);
         } catch (ClassCastException var4) {
            var2 = (LinkedTreeMap.Node)var3;
         }
      }

      return var2;
   }

   LinkedTreeMap.Node<K, V> a(K var1, boolean var2) {
      Object var7 = null;
      Comparator var8 = this.a;
      LinkedTreeMap.Node var4 = this.b;
      int var3;
      LinkedTreeMap.Node var11;
      if (var4 != null) {
         Comparable var6;
         if (var8 == g) {
            var6 = (Comparable)var1;
         } else {
            var6 = null;
         }

         while (true) {
            if (var6 != null) {
               var3 = var6.compareTo(var4.f);
            } else {
               var3 = var8.compare(var1, var4.f);
            }

            if (var3 == 0) {
               return var4;
            }

            if (var3 < 0) {
               var11 = var4.b;
            } else {
               var11 = var4.c;
            }

            if (var11 == null) {
               var11 = var4;
               break;
            }

            var4 = var11;
         }
      } else {
         var3 = 0;
         var11 = var4;
      }

      var4 = (LinkedTreeMap.Node)var7;
      if (var2) {
         var4 = this.e;
         LinkedTreeMap.Node var9;
         if (var11 == null) {
            if (var8 == g && !(var1 instanceof Comparable)) {
               throw new ClassCastException(var1.getClass().getName() + " is not Comparable");
            }

            var9 = new LinkedTreeMap.Node<>(var11, var1, var4, var4.e);
            this.b = var9;
         } else {
            var9 = new LinkedTreeMap.Node<>(var11, var1, var4, var4.e);
            if (var3 < 0) {
               var11.b = var9;
            } else {
               var11.c = var9;
            }

            this.b(var11, true);
         }

         this.c++;
         this.d++;
         var4 = var9;
      }

      return var4;
   }

   LinkedTreeMap.Node<K, V> a(Entry<?, ?> var1) {
      LinkedTreeMap.Node var3 = this.a(var1.getKey());
      boolean var2;
      if (var3 != null && this.a(var3.g, var1.getValue())) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (var2) {
         var1 = var3;
      } else {
         var1 = null;
      }

      return var1;
   }

   void a(LinkedTreeMap.Node<K, V> var1, boolean var2) {
      int var4 = 0;
      if (var2) {
         var1.e.d = var1.d;
         var1.d.e = var1.e;
      }

      LinkedTreeMap.Node var6 = var1.b;
      LinkedTreeMap.Node var7 = var1.c;
      LinkedTreeMap.Node var5 = var1.a;
      if (var6 != null && var7 != null) {
         if (var6.h > var7.h) {
            var5 = var6.b();
         } else {
            var5 = var7.a();
         }

         this.a(var5, false);
         var6 = var1.b;
         int var3;
         if (var6 != null) {
            var3 = var6.h;
            var5.b = var6;
            var6.a = var5;
            var1.b = null;
         } else {
            var3 = 0;
         }

         var6 = var1.c;
         if (var6 != null) {
            var4 = var6.h;
            var5.c = var6;
            var6.a = var5;
            var1.c = null;
         }

         var5.h = Math.max(var3, var4) + 1;
         this.a(var1, var5);
      } else {
         if (var6 != null) {
            this.a(var1, var6);
            var1.b = null;
         } else if (var7 != null) {
            this.a(var1, var7);
            var1.c = null;
         } else {
            this.a(var1, null);
         }

         this.b(var5, false);
         this.c--;
         this.d++;
      }
   }

   LinkedTreeMap.Node<K, V> b(Object var1) {
      var1 = this.a((Object)var1);
      if (var1 != null) {
         this.a(var1, true);
      }

      return var1;
   }

   @Override
   public void clear() {
      this.b = null;
      this.c = 0;
      this.d++;
      LinkedTreeMap.Node var1 = this.e;
      var1.e = var1;
      var1.d = var1;
   }

   @Override
   public boolean containsKey(Object var1) {
      boolean var2;
      if (this.a(var1) != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public Set<Entry<K, V>> entrySet() {
      LinkedTreeMap.EntrySet var1 = this.h;
      if (var1 == null) {
         var1 = new LinkedTreeMap.EntrySet(this);
         this.h = var1;
      }

      return var1;
   }

   @Override
   public V get(Object var1) {
      var1 = this.a(var1);
      if (var1 != null) {
         var1 = var1.g;
      } else {
         var1 = null;
      }

      return (V)var1;
   }

   @Override
   public Set<K> keySet() {
      LinkedTreeMap.KeySet var1 = this.i;
      if (var1 == null) {
         var1 = new LinkedTreeMap.KeySet(this);
         this.i = var1;
      }

      return var1;
   }

   @Override
   public V put(K var1, V var2) {
      if (var1 == null) {
         throw new NullPointerException("key == null");
      }

      var1 = this.a((K)var1, true);
      Object var3 = var1.g;
      var1.g = (V)var2;
      return (V)var3;
   }

   @Override
   public V remove(Object var1) {
      var1 = this.b(var1);
      if (var1 != null) {
         var1 = var1.g;
      } else {
         var1 = null;
      }

      return (V)var1;
   }

   @Override
   public int size() {
      return this.c;
   }

   class EntrySet extends AbstractSet<Entry<K, V>> {
      final LinkedTreeMap a;

      EntrySet(LinkedTreeMap var1) {
         this.a = var1;
      }

      @Override
      public void clear() {
         this.a.clear();
      }

      @Override
      public boolean contains(Object var1) {
         boolean var2;
         if (var1 instanceof Entry && this.a.a((Entry<?, ?>)var1) != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public Iterator<Entry<K, V>> iterator() {
         return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<Entry<K, V>>(this) {
            final LinkedTreeMap.EntrySet a;

            {
               this.a = var1;
            }

            public Entry<K, V> a() {
               return this.b();
            }
         };
      }

      @Override
      public boolean remove(Object var1) {
         boolean var2 = false;
         if (var1 instanceof Entry) {
            var1 = this.a.a(var1);
            if (var1 != null) {
               this.a.a(var1, true);
               var2 = true;
            }
         }

         return var2;
      }

      @Override
      public int size() {
         return this.a.c;
      }
   }

   final class KeySet extends AbstractSet<K> {
      final LinkedTreeMap a;

      KeySet(LinkedTreeMap var1) {
         this.a = var1;
      }

      @Override
      public void clear() {
         this.a.clear();
      }

      @Override
      public boolean contains(Object var1) {
         return this.a.containsKey(var1);
      }

      @Override
      public Iterator<K> iterator() {
         return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>(this) {
            final LinkedTreeMap.KeySet a;

            {
               this.a = var1;
            }

            @Override
            public K next() {
               return this.b().f;
            }
         };
      }

      @Override
      public boolean remove(Object var1) {
         boolean var2;
         if (this.a.b(var1) != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public int size() {
         return this.a.c;
      }
   }

   private abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
      LinkedTreeMap.Node<K, V> b;
      LinkedTreeMap.Node<K, V> c;
      int d;
      final LinkedTreeMap e;

      LinkedTreeMapIterator(LinkedTreeMap var1) {
         this.e = var1;
         this.b = this.e.e.d;
         this.c = null;
         this.d = this.e.d;
      }

      final LinkedTreeMap.Node<K, V> b() {
         LinkedTreeMap.Node var1 = this.b;
         if (var1 == this.e.e) {
            throw new NoSuchElementException();
         }

         if (this.e.d != this.d) {
            throw new ConcurrentModificationException();
         }

         this.b = var1.d;
         this.c = var1;
         return var1;
      }

      @Override
      public final boolean hasNext() {
         boolean var1;
         if (this.b != this.e.e) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      @Override
      public final void remove() {
         if (this.c == null) {
            throw new IllegalStateException();
         }

         this.e.a(this.c, true);
         this.c = null;
         this.d = this.e.d;
      }
   }

   static final class Node<K, V> implements Entry<K, V> {
      LinkedTreeMap.Node<K, V> a;
      LinkedTreeMap.Node<K, V> b;
      LinkedTreeMap.Node<K, V> c;
      LinkedTreeMap.Node<K, V> d;
      LinkedTreeMap.Node<K, V> e;
      final K f;
      V g;
      int h;

      Node() {
         this.f = null;
         this.e = this;
         this.d = this;
      }

      Node(LinkedTreeMap.Node<K, V> var1, K var2, LinkedTreeMap.Node<K, V> var3, LinkedTreeMap.Node<K, V> var4) {
         this.a = var1;
         this.f = (K)var2;
         this.h = 1;
         this.d = var3;
         this.e = var4;
         var4.d = this;
         var3.e = this;
      }

      public LinkedTreeMap.Node<K, V> a() {
         LinkedTreeMap.Node var1 = this.b;
         LinkedTreeMap.Node var2 = this;

         while (var1 != null) {
            LinkedTreeMap.Node var3 = var1.b;
            var2 = var1;
            var1 = var3;
         }

         return var2;
      }

      public LinkedTreeMap.Node<K, V> b() {
         LinkedTreeMap.Node var1 = this.c;
         LinkedTreeMap.Node var2 = this;

         while (var1 != null) {
            LinkedTreeMap.Node var3 = var1.c;
            var2 = var1;
            var1 = var3;
         }

         return var2;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2 = var3;
         if (var1 instanceof Entry) {
            var1 = var1;
            if (this.f == null) {
               var2 = var3;
               if (var1.getKey() != null) {
                  return var2;
               }
            } else {
               var2 = var3;
               if (!this.f.equals(var1.getKey())) {
                  return var2;
               }
            }

            if (this.g == null) {
               var2 = var3;
               if (var1.getValue() != null) {
                  return var2;
               }
            } else {
               var2 = var3;
               if (!this.g.equals(var1.getValue())) {
                  return var2;
               }
            }

            var2 = true;
         }

         return var2;
      }

      @Override
      public K getKey() {
         return this.f;
      }

      @Override
      public V getValue() {
         return this.g;
      }

      @Override
      public int hashCode() {
         int var2 = 0;
         int var1;
         if (this.f == null) {
            var1 = 0;
         } else {
            var1 = this.f.hashCode();
         }

         if (this.g != null) {
            var2 = this.g.hashCode();
         }

         return var1 ^ var2;
      }

      @Override
      public V setValue(V var1) {
         Object var2 = this.g;
         this.g = (V)var1;
         return (V)var2;
      }

      @Override
      public String toString() {
         return this.f + "=" + this.g;
      }
   }
}
