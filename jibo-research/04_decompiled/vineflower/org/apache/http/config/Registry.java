package org.apache.http.config;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public final class Registry<I> implements Lookup<I> {
   private final Map<String, I> map;

   Registry(Map<String, I> var1) {
      this.map = new ConcurrentHashMap<>(var1);
   }

   @Override
   public I lookup(String var1) {
      Object var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = this.map.get(var1.toLowerCase(Locale.ROOT));
      }

      return (I)var2;
   }

   @Override
   public String toString() {
      return this.map.toString();
   }
}
