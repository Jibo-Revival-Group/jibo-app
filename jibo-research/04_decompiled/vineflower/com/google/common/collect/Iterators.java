package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;

public final class Iterators {
   public static <T> boolean a(Collection<T> var0, Iterator<? extends T> var1) {
      Preconditions.a(var0);
      Preconditions.a(var1);
      boolean var2 = false;

      while (var1.hasNext()) {
         var2 |= var0.add(var1.next());
      }

      return var2;
   }
}
