package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;

public final class zzcdv extends zzbfm {
   public static final Creator<zzcdv> CREATOR = new zzcdw();
   private int a;
   private String b;

   public zzcdv(int var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 != this) {
         if (var1 != null && var1 instanceof zzcdv) {
            var1 = var1;
            if (var1.a != this.a || !zzbg.a(var1.b, this.b)) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return this.a;
   }

   @Override
   public final String toString() {
      return String.format("%d:%s", this.a, this.b);
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b, false);
      zzbfp.a(var1, var2);
   }
}
