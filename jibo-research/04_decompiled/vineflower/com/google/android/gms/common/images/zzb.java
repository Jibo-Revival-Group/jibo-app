package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

final class zzb {
   public final Uri a;

   public zzb(Uri var1) {
      this.a = var1;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2;
      if (!(var1 instanceof zzb)) {
         var2 = false;
      } else if (this == var1) {
         var2 = true;
      } else {
         var2 = zzbg.a(((zzb)var1).a, this.a);
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.a});
   }
}
