package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;
import java.util.Locale;

public final class PlacesOptions implements Api.ApiOptions.Optional {
   public final String a = null;
   public final String b = null;
   public final int c = 0;
   public final String d = null;
   public final Locale e = null;

   private PlacesOptions(PlacesOptions.Builder var1) {
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if (var1 instanceof PlacesOptions) {
         var2 = var3;
         if (zzbg.a(null, null)) {
            var2 = var3;
            if (zzbg.a(null, null)) {
               var2 = var3;
               if (zzbg.a(0, 0)) {
                  var2 = var3;
                  if (zzbg.a(null, null)) {
                     var2 = var3;
                     if (zzbg.a(null, null)) {
                        var2 = true;
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{null, null, 0, null, null});
   }

   public static class Builder {
      private int a = 0;

      public PlacesOptions a() {
         return new PlacesOptions(this, null);
      }
   }
}
