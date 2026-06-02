package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class LocationSettingsResult extends zzbfm implements Result {
   public static final Creator<LocationSettingsResult> CREATOR = new zzac();
   private final Status a;
   private final LocationSettingsStates b;

   public LocationSettingsResult(Status var1, LocationSettingsStates var2) {
      this.a = var1;
      this.b = var2;
   }

   @Override
   public final Status a() {
      return this.a;
   }

   public final LocationSettingsStates b() {
      return this.b;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a(), var2, false);
      zzbfp.a(var1, 2, this.b(), var2, false);
      zzbfp.a(var1, var3);
   }
}
