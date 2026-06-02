package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class Lists {
   public static <E> ArrayList<E> a() {
      return new ArrayList<>();
   }

   public static <E> ArrayList<E> a(Iterable<? extends E> var0) {
      Preconditions.a(var0);
      if (var0 instanceof Collection) {
         var0 = new ArrayList<>(Collections2.a(var0));
      } else {
         var0 = a(var0.iterator());
      }

      return var0;
   }

   public static <E> ArrayList<E> a(Iterator<? extends E> var0) {
      ArrayList var1 = a();
      Iterators.a(var1, var0);
      return var1;
   }
}
