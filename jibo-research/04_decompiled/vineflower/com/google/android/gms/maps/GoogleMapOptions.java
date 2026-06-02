package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

public final class GoogleMapOptions extends zzbfm implements ReflectedParcelable {
   public static final Creator<GoogleMapOptions> CREATOR = new zzaa();
   private Boolean a;
   private Boolean b;
   private int c = -1;
   private CameraPosition d;
   private Boolean e;
   private Boolean f;
   private Boolean g;
   private Boolean h;
   private Boolean i;
   private Boolean j;
   private Boolean k;
   private Boolean l;
   private Boolean m;
   private Float n = null;
   private Float o = null;
   private LatLngBounds p = null;

   public GoogleMapOptions() {
   }

   GoogleMapOptions(
      byte var1,
      byte var2,
      int var3,
      CameraPosition var4,
      byte var5,
      byte var6,
      byte var7,
      byte var8,
      byte var9,
      byte var10,
      byte var11,
      byte var12,
      byte var13,
      Float var14,
      Float var15,
      LatLngBounds var16
   ) {
      this.a = zza.a(var1);
      this.b = zza.a(var2);
      this.c = var3;
      this.d = var4;
      this.e = zza.a(var5);
      this.f = zza.a(var6);
      this.g = zza.a(var7);
      this.h = zza.a(var8);
      this.i = zza.a(var9);
      this.j = zza.a(var10);
      this.k = zza.a(var11);
      this.l = zza.a(var12);
      this.m = zza.a(var13);
      this.n = var14;
      this.o = var15;
      this.p = var16;
   }

   public static GoogleMapOptions a(Context var0, AttributeSet var1) {
      GoogleMapOptions var4;
      if (var1 == null) {
         var4 = null;
      } else {
         TypedArray var3 = var0.getResources().obtainAttributes(var1, R.styleable.MapAttrs);
         GoogleMapOptions var2 = new GoogleMapOptions();
         if (var3.hasValue(R.styleable.MapAttrs_mapType)) {
            var2.a(var3.getInt(R.styleable.MapAttrs_mapType, -1));
         }

         if (var3.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
            var2.a(var3.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
         }

         if (var3.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
            var2.b(var3.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
         }

         if (var3.hasValue(R.styleable.MapAttrs_uiCompass)) {
            var2.d(var3.getBoolean(R.styleable.MapAttrs_uiCompass, true));
         }

         if (var3.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
            var2.h(var3.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
         }

         if (var3.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
            var2.e(var3.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
         }

         if (var3.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
            var2.g(var3.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
         }

         if (var3.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
            var2.f(var3.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
         }

         if (var3.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
            var2.c(var3.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
         }

         if (var3.hasValue(R.styleable.MapAttrs_liteMode)) {
            var2.i(var3.getBoolean(R.styleable.MapAttrs_liteMode, false));
         }

         if (var3.hasValue(R.styleable.MapAttrs_uiMapToolbar)) {
            var2.j(var3.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
         }

         if (var3.hasValue(R.styleable.MapAttrs_ambientEnabled)) {
            var2.k(var3.getBoolean(R.styleable.MapAttrs_ambientEnabled, false));
         }

         if (var3.hasValue(R.styleable.MapAttrs_cameraMinZoomPreference)) {
            var2.a(var3.getFloat(R.styleable.MapAttrs_cameraMinZoomPreference, Float.NEGATIVE_INFINITY));
         }

         if (var3.hasValue(R.styleable.MapAttrs_cameraMinZoomPreference)) {
            var2.b(var3.getFloat(R.styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
         }

         var2.a(LatLngBounds.a(var0, var1));
         var2.a(CameraPosition.a(var0, var1));
         var3.recycle();
         var4 = var2;
      }

      return var4;
   }

   public final int a() {
      return this.c;
   }

   public final GoogleMapOptions a(float var1) {
      this.n = var1;
      return this;
   }

   public final GoogleMapOptions a(int var1) {
      this.c = var1;
      return this;
   }

   public final GoogleMapOptions a(CameraPosition var1) {
      this.d = var1;
      return this;
   }

   public final GoogleMapOptions a(LatLngBounds var1) {
      this.p = var1;
      return this;
   }

   public final GoogleMapOptions a(boolean var1) {
      this.a = var1;
      return this;
   }

   public final GoogleMapOptions b(float var1) {
      this.o = var1;
      return this;
   }

   public final GoogleMapOptions b(boolean var1) {
      this.b = var1;
      return this;
   }

   public final CameraPosition b() {
      return this.d;
   }

   public final GoogleMapOptions c(boolean var1) {
      this.e = var1;
      return this;
   }

   public final Float c() {
      return this.n;
   }

   public final GoogleMapOptions d(boolean var1) {
      this.f = var1;
      return this;
   }

   public final Float d() {
      return this.o;
   }

   public final GoogleMapOptions e(boolean var1) {
      this.g = var1;
      return this;
   }

   public final LatLngBounds e() {
      return this.p;
   }

   public final GoogleMapOptions f(boolean var1) {
      this.h = var1;
      return this;
   }

   public final GoogleMapOptions g(boolean var1) {
      this.i = var1;
      return this;
   }

   public final GoogleMapOptions h(boolean var1) {
      this.j = var1;
      return this;
   }

   public final GoogleMapOptions i(boolean var1) {
      this.k = var1;
      return this;
   }

   public final GoogleMapOptions j(boolean var1) {
      this.l = var1;
      return this;
   }

   public final GoogleMapOptions k(boolean var1) {
      this.m = var1;
      return this;
   }

   @Override
   public final String toString() {
      return zzbg.a(this)
         .a("MapType", this.c)
         .a("LiteMode", this.k)
         .a("Camera", this.d)
         .a("CompassEnabled", this.f)
         .a("ZoomControlsEnabled", this.e)
         .a("ScrollGesturesEnabled", this.g)
         .a("ZoomGesturesEnabled", this.h)
         .a("TiltGesturesEnabled", this.i)
         .a("RotateGesturesEnabled", this.j)
         .a("MapToolbarEnabled", this.l)
         .a("AmbientEnabled", this.m)
         .a("MinZoomPreference", this.n)
         .a("MaxZoomPreference", this.o)
         .a("LatLngBoundsForCameraTarget", this.p)
         .a("ZOrderOnTop", this.a)
         .a("UseViewLifecycleInFragment", this.b)
         .toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 2, zza.a(this.a));
      zzbfp.a(var1, 3, zza.a(this.b));
      zzbfp.a(var1, 4, this.a());
      zzbfp.a(var1, 5, this.b(), var2, false);
      zzbfp.a(var1, 6, zza.a(this.e));
      zzbfp.a(var1, 7, zza.a(this.f));
      zzbfp.a(var1, 8, zza.a(this.g));
      zzbfp.a(var1, 9, zza.a(this.h));
      zzbfp.a(var1, 10, zza.a(this.i));
      zzbfp.a(var1, 11, zza.a(this.j));
      zzbfp.a(var1, 12, zza.a(this.k));
      zzbfp.a(var1, 14, zza.a(this.l));
      zzbfp.a(var1, 15, zza.a(this.m));
      zzbfp.a(var1, 16, this.c(), false);
      zzbfp.a(var1, 17, this.d(), false);
      zzbfp.a(var1, 18, this.e(), var2, false);
      zzbfp.a(var1, var3);
   }
}
