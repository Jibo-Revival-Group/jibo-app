package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class zzb extends zzbfm {
   public static final Creator<zzb> CREATOR = new zzaw();
   final int a;
   final int b;

   public zzb(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof zzb)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!zzbg.a(this.a, var1.a) || !zzbg.a(this.b, var1.b)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, this.b});
   }

   @Override
   public final String toString() {
      return zzbg.a(this).a("offset", this.a).a("length", this.b).toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, var2);
   }
}
