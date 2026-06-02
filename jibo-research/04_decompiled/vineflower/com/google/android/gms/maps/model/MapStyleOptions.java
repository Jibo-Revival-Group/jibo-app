package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class MapStyleOptions extends zzbfm {
   public static final Creator<MapStyleOptions> CREATOR = new zzg();
   private static final String a = MapStyleOptions.class.getSimpleName();
   private String b;

   public MapStyleOptions(String var1) {
      this.b = var1;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.b, false);
      zzbfp.a(var1, var2);
   }
}
