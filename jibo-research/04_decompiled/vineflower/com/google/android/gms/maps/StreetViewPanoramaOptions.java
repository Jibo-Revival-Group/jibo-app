package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions extends zzbfm implements ReflectedParcelable {
   public static final Creator<StreetViewPanoramaOptions> CREATOR = new zzai();
   private StreetViewPanoramaCamera a;
   private String b;
   private LatLng c;
   private Integer d;
   private Boolean e = true;
   private Boolean f = true;
   private Boolean g = true;
   private Boolean h = true;
   private Boolean i;

   public StreetViewPanoramaOptions() {
   }

   StreetViewPanoramaOptions(StreetViewPanoramaCamera var1, String var2, LatLng var3, Integer var4, byte var5, byte var6, byte var7, byte var8, byte var9) {
      this.a = var1;
      this.c = var3;
      this.d = var4;
      this.b = var2;
      this.e = zza.a(var5);
      this.f = zza.a(var6);
      this.g = zza.a(var7);
      this.h = zza.a(var8);
      this.i = zza.a(var9);
   }

   public final StreetViewPanoramaCamera a() {
      return this.a;
   }

   public final LatLng b() {
      return this.c;
   }

   public final Integer c() {
      return this.d;
   }

   public final String d() {
      return this.b;
   }

   @Override
   public final String toString() {
      return zzbg.a(this)
         .a("PanoramaId", this.b)
         .a("Position", this.c)
         .a("Radius", this.d)
         .a("StreetViewPanoramaCamera", this.a)
         .a("UserNavigationEnabled", this.e)
         .a("ZoomGesturesEnabled", this.f)
         .a("PanningGesturesEnabled", this.g)
         .a("StreetNamesEnabled", this.h)
         .a("UseViewLifecycleInFragment", this.i)
         .toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a(), var2, false);
      zzbfp.a(var1, 3, this.d(), false);
      zzbfp.a(var1, 4, this.b(), var2, false);
      zzbfp.a(var1, 5, this.c(), false);
      zzbfp.a(var1, 6, zza.a(this.e));
      zzbfp.a(var1, 7, zza.a(this.f));
      zzbfp.a(var1, 8, zza.a(this.g));
      zzbfp.a(var1, 9, zza.a(this.h));
      zzbfp.a(var1, 10, zza.a(this.i));
      zzbfp.a(var1, var3);
   }
}
