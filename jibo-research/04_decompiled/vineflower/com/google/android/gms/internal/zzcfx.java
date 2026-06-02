package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

@Deprecated
public final class zzcfx extends zzbfm {
   public static final Creator<zzcfx> CREATOR = new zzcfy();
   private static zzcfx a = new zzcfx("Home");
   private static zzcfx b = new zzcfx("Work");
   private final String c;

   zzcfx(String var1) {
      this.c = var1;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else if (!(var1 instanceof zzcfx)) {
         var2 = false;
      } else {
         var1 = var1;
         var2 = zzbg.a(this.c, var1.c);
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.c});
   }

   @Override
   public final String toString() {
      return zzbg.a(this).a("alias", this.c).toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.c, false);
      zzbfp.a(var1, var2);
   }
}
