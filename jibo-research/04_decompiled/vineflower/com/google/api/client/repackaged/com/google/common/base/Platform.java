package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;

@GwtCompatible(emulated = true)
final class Platform {
   private Platform() {
   }

   static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> var0, String var1) {
      WeakReference var3 = Enums.getEnumConstants(var0).get(var1);
      Optional var2;
      if (var3 == null) {
         var2 = Optional.absent();
      } else {
         var2 = Optional.of(var0.cast(var3.get()));
      }

      return var2;
   }

   static CharMatcher precomputeCharMatcher(CharMatcher var0) {
      return var0.precomputedInternal();
   }

   static long systemNanoTime() {
      return System.nanoTime();
   }
}
