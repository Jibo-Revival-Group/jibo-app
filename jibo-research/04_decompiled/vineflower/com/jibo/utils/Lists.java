package com.jibo.utils;

import java.util.ArrayList;
import java.util.Collections;

public class Lists {
   public static <E> ArrayList<E> a() {
      return new ArrayList<>();
   }

   public static <E> ArrayList<E> a(E... var0) {
      ArrayList var1 = new ArrayList(var0.length * 110 / 100 + 5);
      Collections.addAll(var1, (E[])var0);
      return var1;
   }
}
