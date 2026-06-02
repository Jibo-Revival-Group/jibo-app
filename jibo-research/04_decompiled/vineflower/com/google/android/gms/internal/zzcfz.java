package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;
import java.util.List;

@Deprecated
public final class zzcfz extends zzbfm {
   public static final Creator<zzcfz> CREATOR = new zzcgb();
   private final String a;
   private final String b;
   private final List<zzcfx> c;

   zzcfz(String var1, String var2, List<zzcfx> var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof zzcfz)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.a.equals(var1.a) || !this.b.equals(var1.b) || !this.c.equals(var1.c)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
   }

   @Override
   public final String toString() {
      return zzbg.a(this).a("accountName", this.a).a("placeId", this.b).a("placeAliases", this.c).toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a, false);
      zzbfp.a(var1, 2, this.b, false);
      zzbfp.c(var1, 6, this.c, false);
      zzbfp.a(var1, var2);
   }
}
