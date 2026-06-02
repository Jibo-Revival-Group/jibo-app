package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public class PlacePhotoResult extends zzbfm implements Result {
   public static final Creator<PlacePhotoResult> CREATOR = new zzk();
   private final Status a;
   private BitmapTeleporter b;
   private final Bitmap c;

   public PlacePhotoResult(Status var1, BitmapTeleporter var2) {
      this.a = var1;
      this.b = var2;
      if (this.b != null) {
         this.c = var2.a();
      } else {
         this.c = null;
      }
   }

   @Override
   public Status a() {
      return this.a;
   }

   @Override
   public String toString() {
      return zzbg.a(this).a("status", this.a).a("bitmap", this.c).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a(), var2, false);
      zzbfp.a(var1, 2, this.b, var2, false);
      zzbfp.a(var1, var3);
   }
}
