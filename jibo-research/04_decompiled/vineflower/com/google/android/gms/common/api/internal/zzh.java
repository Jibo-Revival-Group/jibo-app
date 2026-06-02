package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;

public final class zzh<O extends Api.ApiOptions> {
   private final boolean a;
   private final int b;
   private final Api<O> c;
   private final O d;

   private zzh(Api<O> var1) {
      this.a = true;
      this.c = var1;
      this.d = null;
      this.b = System.identityHashCode(this);
   }

   private zzh(Api<O> var1, O var2) {
      this.a = false;
      this.c = var1;
      this.d = (O)var2;
      this.b = Arrays.hashCode(new Object[]{this.c, this.d});
   }

   public static <O extends Api.ApiOptions> zzh<O> a(Api<O> var0) {
      return new zzh<>(var0);
   }

   public static <O extends Api.ApiOptions> zzh<O> a(Api<O> var0, O var1) {
      return new zzh<>(var0, (O)var1);
   }

   public final String a() {
      return this.c.d();
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 != this) {
         if (!(var1 instanceof zzh)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.a
               || var1.a
               || !com.google.android.gms.common.internal.zzbg.a(this.c, var1.c)
               || !com.google.android.gms.common.internal.zzbg.a(this.d, var1.d)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return this.b;
   }
}
