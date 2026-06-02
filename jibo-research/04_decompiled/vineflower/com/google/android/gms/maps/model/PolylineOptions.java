package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.ArrayList;
import java.util.List;

public final class PolylineOptions extends zzbfm {
   public static final Creator<PolylineOptions> CREATOR = new zzl();
   private final List<LatLng> a;
   private float b = 10.0F;
   private int c = -16777216;
   private float d = 0.0F;
   private boolean e = true;
   private boolean f = false;
   private boolean g = false;
   private Cap h = new ButtCap();
   private Cap i = new ButtCap();
   private int j = 0;
   private List<PatternItem> k = null;

   public PolylineOptions() {
      this.a = new ArrayList<>();
   }

   PolylineOptions(
      List var1, float var2, int var3, float var4, boolean var5, boolean var6, boolean var7, Cap var8, Cap var9, int var10, List<PatternItem> var11
   ) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
      if (var8 != null) {
         this.h = var8;
      }

      if (var9 != null) {
         this.i = var9;
      }

      this.j = var10;
      this.k = var11;
   }

   public final List<LatLng> a() {
      return this.a;
   }

   public final float b() {
      return this.b;
   }

   public final int c() {
      return this.c;
   }

   public final Cap d() {
      return this.h;
   }

   public final Cap e() {
      return this.i;
   }

   public final int f() {
      return this.j;
   }

   public final List<PatternItem> g() {
      return this.k;
   }

   public final float h() {
      return this.d;
   }

   public final boolean i() {
      return this.e;
   }

   public final boolean j() {
      return this.f;
   }

   public final boolean k() {
      return this.g;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.c(var1, 2, this.a(), false);
      zzbfp.a(var1, 3, this.b());
      zzbfp.a(var1, 4, this.c());
      zzbfp.a(var1, 5, this.h());
      zzbfp.a(var1, 6, this.i());
      zzbfp.a(var1, 7, this.j());
      zzbfp.a(var1, 8, this.k());
      zzbfp.a(var1, 9, this.d(), var2, false);
      zzbfp.a(var1, 10, this.e(), var2, false);
      zzbfp.a(var1, 11, this.f());
      zzbfp.c(var1, 12, this.g(), false);
      zzbfp.a(var1, var3);
   }
}
