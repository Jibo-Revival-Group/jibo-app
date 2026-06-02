package com.google.android.gms.common.util;

import android.support.v4.util.ArraySet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class zze {
   private static <T> Set<T> a(int var0, boolean var1) {
      Collection var2;
      if (var0 <= 256) {
         var2 = new ArraySet(var0);
      } else {
         var2 = new HashSet(var0, 1.0F);
      }

      return var2;
   }

   public static <T> Set<T> a(T var0, T var1, T var2) {
      Set var3 = a(3, false);
      var3.add(var0);
      var3.add(var1);
      var3.add(var2);
      return Collections.unmodifiableSet(var3);
   }
}
