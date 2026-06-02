package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbr;

public final class zzcxo extends zzbfm {
   public static final Creator<zzcxo> CREATOR = new zzcxp();
   private int a;
   private zzbr b;

   zzcxo(int var1, zzbr var2) {
      this.a = var1;
      this.b = var2;
   }

   public zzcxo(zzbr var1) {
      this(1, var1);
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b, var2, false);
      zzbfp.a(var1, var3);
   }
}
