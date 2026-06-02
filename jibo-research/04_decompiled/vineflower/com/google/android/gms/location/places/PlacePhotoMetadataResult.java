package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public class PlacePhotoMetadataResult extends zzbfm implements Result {
   public static final Creator<PlacePhotoMetadataResult> CREATOR = new zzj();
   private final Status a;
   private DataHolder b;
   private final PlacePhotoMetadataBuffer c;

   public PlacePhotoMetadataResult(Status var1, DataHolder var2) {
      this.a = var1;
      this.b = var2;
      if (var2 == null) {
         this.c = null;
      } else {
         this.c = new PlacePhotoMetadataBuffer(this.b);
      }
   }

   @Override
   public Status a() {
      return this.a;
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a(), var2, false);
      zzbfp.a(var1, 2, this.b, var2, false);
      zzbfp.a(var1, var3);
   }
}
