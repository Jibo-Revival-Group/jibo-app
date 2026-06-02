package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zzceo extends zzbfm implements Result {
   public static final Creator<zzceo> CREATOR = new zzcep();
   private static zzceo a = new zzceo(Status.a);
   private final Status b;

   public zzceo(Status var1) {
      this.b = var1;
   }

   @Override
   public final Status a() {
      return this.b;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a(), var2, false);
      zzbfp.a(var1, var3);
   }
}
