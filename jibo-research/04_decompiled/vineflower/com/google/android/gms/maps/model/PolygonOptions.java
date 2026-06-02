package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.ArrayList;
import java.util.List;

public final class PolygonOptions extends zzbfm {
   public static final Creator<PolygonOptions> CREATOR = new zzk();
   private final List<LatLng> a;
   private final List<List<LatLng>> b;
   private float c = 10.0F;
   private int d = -16777216;
   private int e = 0;
   private float f = 0.0F;
   private boolean g = true;
   private boolean h = false;
   private boolean i = false;
   private int j = 0;
   private List<PatternItem> k = null;

   public PolygonOptions() {
      this.a = new ArrayList<>();
      this.b = new ArrayList<>();
   }

   PolygonOptions(
      List<LatLng> var1, List var2, float var3, int var4, int var5, float var6, boolean var7, boolean var8, boolean var9, int var10, List<PatternItem> var11
   ) {
      this.a = var1;
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
   }

   public final List<LatLng> a() {
      return this.a;
   }

   public final float b() {
      return this.c;
   }

   public final int c() {
      return this.d;
   }

   public final int d() {
      return this.j;
   }

   public final List<PatternItem> e() {
      return this.k;
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

   public final boolean j() {
      return this.i;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.c(var1, 2, this.a(), false);
      zzbfp.d(var1, 3, this.b, false);
      zzbfp.a(var1, 4, this.b());
      zzbfp.a(var1, 5, this.c());
      zzbfp.a(var1, 6, this.f());
      zzbfp.a(var1, 7, this.g());
      zzbfp.a(var1, 8, this.h());
      zzbfp.a(var1, 9, this.i());
      zzbfp.a(var1, 10, this.j());
      zzbfp.a(var1, 11, this.d());
      zzbfp.c(var1, 12, this.e(), false);
      zzbfp.a(var1, var2);
   }
}
