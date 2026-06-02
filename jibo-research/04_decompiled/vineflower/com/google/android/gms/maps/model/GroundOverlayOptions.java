package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class GroundOverlayOptions extends zzbfm {
   public static final Creator<GroundOverlayOptions> CREATOR = new zzd();
   private BitmapDescriptor a;
   private LatLng b;
   private float c;
   private float d;
   private LatLngBounds e;
   private float f;
   private float g;
   private boolean h = true;
   private float i = 0.0F;
   private float j = 0.5F;
   private float k = 0.5F;
   private boolean l = false;

   public GroundOverlayOptions() {
   }

   GroundOverlayOptions(
      IBinder var1,
      LatLng var2,
      float var3,
      float var4,
      LatLngBounds var5,
      float var6,
      float var7,
      boolean var8,
      float var9,
      float var10,
      float var11,
      boolean var12
   ) {
      this.a = new BitmapDescriptor(IObjectWrapper.zza.a(var1));
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
      this.h = var8;
      this.i = var9;
      this.j = var10;
      this.k = var11;
      this.l = var12;
   }

   public final LatLng a() {
      return this.b;
   }

   public final float b() {
      return this.c;
   }

   public final float c() {
      return this.d;
   }

   public final LatLngBounds d() {
      return this.e;
   }

   public final float e() {
      return this.f;
   }

   public final float f() {
      return this.g;
   }

   public final float g() {
      return this.i;
   }

   public final float h() {
      return this.j;
   }

   public final float i() {
      return this.k;
   }

   public final boolean j() {
      return this.h;
   }

   public final boolean k() {
      return this.l;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a.a().asBinder(), false);
      zzbfp.a(var1, 3, this.a(), var2, false);
      zzbfp.a(var1, 4, this.b());
      zzbfp.a(var1, 5, this.c());
      zzbfp.a(var1, 6, this.d(), var2, false);
      zzbfp.a(var1, 7, this.e());
      zzbfp.a(var1, 8, this.f());
      zzbfp.a(var1, 9, this.j());
      zzbfp.a(var1, 10, this.g());
      zzbfp.a(var1, 11, this.h());
      zzbfp.a(var1, 12, this.i());
      zzbfp.a(var1, 13, this.k());
      zzbfp.a(var1, var3);
   }
}
