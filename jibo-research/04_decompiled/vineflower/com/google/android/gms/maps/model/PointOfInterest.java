package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class PointOfInterest extends zzbfm {
   public static final Creator<PointOfInterest> CREATOR = new zzj();
   public final LatLng a;
   public final String b;
   public final String c;

   public PointOfInterest(LatLng var1, String var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a, var2, false);
      zzbfp.a(var1, 3, this.b, false);
      zzbfp.a(var1, 4, this.c, false);
      zzbfp.a(var1, var3);
   }
}
