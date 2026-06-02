package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.List;

public final class CircleOptions extends zzbfm {
   public static final Creator<CircleOptions> CREATOR = new zzc();
   private LatLng a = null;
   private double b = 0.0;
   private float c = 10.0F;
   private int d = -16777216;
   private int e = 0;
   private float f = 0.0F;
   private boolean g = true;
   private boolean h = false;
   private List<PatternItem> i = null;

   public CircleOptions() {
   }

   CircleOptions(LatLng var1, double var2, float var4, int var5, int var6, float var7, boolean var8, boolean var9, List<PatternItem> var10) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var5;
      this.e = var6;
      this.f = var7;
      this.g = var8;
      this.h = var9;
      this.i = var10;
   }

   public final LatLng a() {
      return this.a;
   }

   public final double b() {
      return this.b;
   }

   public final float c() {
      return this.c;
   }

   public final int d() {
      return this.d;
   }

   public final List<PatternItem> e() {
      return this.i;
   }

   public final int f() {
      return this.e;
   }

   public final float g() {
      return this.f;
   }

   public final boolean h() {
      return this.g;
   }

   public final boolean i() {
      return this.h;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a(), var2, false);
      zzbfp.a(var1, 3, this.b());
      zzbfp.a(var1, 4, this.c());
      zzbfp.a(var1, 5, this.d());
      zzbfp.a(var1, 6, this.f());
      zzbfp.a(var1, 7, this.g());
      zzbfp.a(var1, 8, this.h());
      zzbfp.a(var1, 9, this.i());
      zzbfp.c(var1, 10, this.e(), false);
      zzbfp.a(var1, var3);
   }
}
