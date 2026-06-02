package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzan extends zzbfm {
   public static final Creator<zzan> CREATOR = new zze();
   private int a;
   private int b;

   zzan(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, var2);
   }
}
