package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class MarkerOptions extends zzbfm {
   public static final Creator<MarkerOptions> CREATOR = new zzh();
   private LatLng a;
   private String b;
   private String c;
   private BitmapDescriptor d;
   private float e = 0.5F;
   private float f = 1.0F;
   private boolean g;
   private boolean h = true;
   private boolean i = false;
   private float j = 0.0F;
   private float k = 0.5F;
   private float l = 0.0F;
   private float m = 1.0F;
   private float n;

   public MarkerOptions() {
   }

   MarkerOptions(
      LatLng var1,
      String var2,
      String var3,
      IBinder var4,
      float var5,
      float var6,
      boolean var7,
      boolean var8,
      boolean var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14
   ) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      if (var4 == null) {
         this.d = null;
      } else {
         this.d = new BitmapDescriptor(IObjectWrapper.zza.a(var4));
      }

      this.e = var5;
      this.f = var6;
      this.g = var7;
      this.h = var8;
      this.i = var9;
      this.j = var10;
      this.k = var11;
      this.l = var12;
      this.m = var13;
      this.n = var14;
   }

   public final LatLng a() {
      return this.a;
   }

   public final String b() {
      return this.b;
   }

   public final String c() {
      return this.c;
   }

   public final float d() {
      return this.e;
   }

   public final float e() {
      return this.f;
   }

   public final boolean f() {
      return this.g;
   }

   public final boolean g() {
      return this.h;
   }

   public final boolean h() {
      return this.i;
   }

   public final float i() {
      return this.j;
   }

   public final float j() {
      return this.k;
   }

   public final float k() {
      return this.l;
   }

   public final float l() {
      return this.m;
   }

   public final float m() {
      return this.n;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a(), var2, false);
      zzbfp.a(var1, 3, this.b(), false);
      zzbfp.a(var1, 4, this.c(), false);
      IBinder var4;
      if (this.d == null) {
         var4 = null;
      } else {
         var4 = this.d.a().asBinder();
      }

      zzbfp.a(var1, 5, var4, false);
      zzbfp.a(var1, 6, this.d());
      zzbfp.a(var1, 7, this.e());
      zzbfp.a(var1, 8, this.f());
      zzbfp.a(var1, 9, this.g());
      zzbfp.a(var1, 10, this.h());
      zzbfp.a(var1, 11, this.i());
      zzbfp.a(var1, 12, this.j());
      zzbfp.a(var1, 13, this.k());
      zzbfp.a(var1, 14, this.l());
      zzbfp.a(var1, 15, this.m());
      zzbfp.a(var1, var3);
   }
}
