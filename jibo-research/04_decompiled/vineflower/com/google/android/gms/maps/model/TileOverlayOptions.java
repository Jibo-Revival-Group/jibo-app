package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.maps.model.internal.zzaa;
import com.google.android.gms.maps.model.internal.zzz;

public final class TileOverlayOptions extends zzbfm {
   public static final Creator<TileOverlayOptions> CREATOR = new zzt();
   private zzz a;
   private TileProvider b;
   private boolean c = true;
   private float d;
   private boolean e = true;
   private float f = 0.0F;

   public TileOverlayOptions() {
   }

   TileOverlayOptions(IBinder var1, boolean var2, float var3, boolean var4, float var5) {
      this.a = zzaa.a(var1);
      zzr var6;
      if (this.a == null) {
         var6 = null;
      } else {
         var6 = new zzr(this);
      }

      this.b = var6;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
   }

   public final float a() {
      return this.d;
   }

   public final boolean b() {
      return this.c;
   }

   public final boolean c() {
      return this.e;
   }

   public final float d() {
      return this.f;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a.asBinder(), false);
      zzbfp.a(var1, 3, this.b());
      zzbfp.a(var1, 4, this.a());
      zzbfp.a(var1, 5, this.c());
      zzbfp.a(var1, 6, this.d());
      zzbfp.a(var1, var2);
   }
}
