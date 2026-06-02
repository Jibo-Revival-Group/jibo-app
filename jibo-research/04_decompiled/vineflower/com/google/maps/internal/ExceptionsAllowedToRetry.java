package com.google.maps.internal;

import com.google.maps.errors.ApiException;
import java.util.HashSet;

public final class ExceptionsAllowedToRetry extends HashSet<Class<? extends ApiException>> {
   @Override
   public String toString() {
      StringBuilder var3 = new StringBuilder().append("ExceptionsAllowedToRetry[");
      Object[] var2 = this.toArray();

      for (int var1 = 0; var1 < var2.length; var1++) {
         var3.append(var2[var1]);
         if (var1 < var2.length - 1) {
            var3.append(", ");
         }
      }

      var3.append(']');
      return var3.toString();
   }
}
