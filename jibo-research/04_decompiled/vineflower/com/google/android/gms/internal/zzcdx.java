package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.location.zze;
import java.util.Collections;
import java.util.List;

public final class zzcdx extends zzbfm {
   public static final Creator<zzcdx> CREATOR = new zzcdy();
   static final List<zzcdv> a = Collections.emptyList();
   static final zze b = new zze();
   private zze c;
   private List<zzcdv> d;
   private String e;

   zzcdx(zze var1, List<zzcdv> var2, String var3) {
      this.c = var1;
      this.d = var2;
      this.e = var3;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (!(var1 instanceof zzcdx)) {
         var2 = var3;
      } else {
         var1 = var1;
         var2 = var3;
         if (zzbg.a(this.c, var1.c)) {
            var2 = var3;
            if (zzbg.a(this.d, var1.d)) {
               var2 = var3;
               if (zzbg.a(this.e, var1.e)) {
                  var2 = true;
               }
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return this.c.hashCode();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.c, var2, false);
      zzbfp.c(var1, 2, this.d, false);
      zzbfp.a(var1, 3, this.e, false);
      zzbfp.a(var1, var3);
   }
}
