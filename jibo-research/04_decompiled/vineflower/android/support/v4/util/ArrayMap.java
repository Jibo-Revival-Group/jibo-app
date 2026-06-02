package android.support.v4.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
   MapCollections<K, V> a;

   public ArrayMap() {
   }

   public ArrayMap(int var1) {
      super(var1);
   }

   public ArrayMap(SimpleArrayMap var1) {
      super(var1);
   }

   private MapCollections<K, V> b() {
      if (this.a == null) {
         this.a = new MapCollections<K, V>(this) {
            final ArrayMap a;

            {
               this.a = var1;
            }

            @Override
            protected int a() {
               return this.a.h;
            }

            @Override
            protected int a(Object var1) {
               return this.a.a(var1);
            }

            @Override
            protected Object a(int var1, int var2) {
               return this.a.g[(var1 << 1) + var2];
            }

            @Override
            protected V a(int var1, V var2) {
               return (V)this.a.a(var1, var2);
            }

            @Override
            protected void a(int var1) {
               this.a.d(var1);
            }

            @Override
            protected void a(K var1, V var2) {
               this.a.put(var1, var2);
            }

            @Override
            protected int b(Object var1) {
               return this.a.b(var1);
            }

            @Override
            protected Map<K, V> b() {
               return this.a;
            }

            @Override
            protected void c() {
               this.a.clear();
            }
         };
      }

      return this.a;
   }

   public boolean a(Collection<?> var1) {
      return MapCollections.c(this, var1);
   }

   @Override
   public Set<Entry<K, V>> entrySet() {
      return this.b().d();
   }

   @Override
   public Set<K> keySet() {
      return this.b().e();
   }

   @Override
   public void putAll(Map<? extends K, ? extends V> var1) {
      this.a(this.h + var1.size());

      for (Entry var3 : var1.entrySet()) {
         this.put((K)var3.getKey(), (V)var3.getValue());
      }
   }

   @Override
   public Collection<V> values() {
      return this.b().f();
   }
}
