package android.arch.core.internal;

import java.util.HashMap;
import java.util.Map;

public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
   private HashMap<K, SafeIterableMap.Entry<K, V>> a = new HashMap<>();

   @Override
   protected SafeIterableMap.Entry<K, V> a(K var1) {
      return this.a.get(var1);
   }

   @Override
   public V a(K var1, V var2) {
      SafeIterableMap.Entry var3 = this.a((K)var1);
      if (var3 != null) {
         var1 = var3.b;
      } else {
         this.a.put((K)var1, this.b((K)var1, (V)var2));
         var1 = null;
      }

      return (V)var1;
   }

   @Override
   public V b(K var1) {
      Object var2 = super.b((K)var1);
      this.a.remove(var1);
      return (V)var2;
   }

   public boolean c(K var1) {
      return this.a.containsKey(var1);
   }

   public Map.Entry<K, V> d(K var1) {
      if (this.c((K)var1)) {
         var1 = this.a.get(var1).d;
      } else {
         var1 = null;
      }

      return var1;
   }
}
