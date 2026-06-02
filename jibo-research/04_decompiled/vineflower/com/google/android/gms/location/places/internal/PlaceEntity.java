package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class PlaceEntity extends zzbfm implements ReflectedParcelable, Place {
   public static final Creator<PlaceEntity> CREATOR = new zzae();
   private final String a;
   private final Bundle b;
   @Deprecated
   private final zzak c;
   private final LatLng d;
   private final float e;
   private final LatLngBounds f;
   private final String g;
   private final Uri h;
   private final boolean i;
   private final float j;
   private final int k;
   private final List<Integer> l;
   private final List<Integer> m;
   private final String n;
   private final String o;
   private final String p;
   private final String q;
   private final List<String> r;
   private final zzam s;
   private final zzaf t;
   private final String u;
   private final Map<Integer, String> v;
   private final TimeZone w;
   private Locale x;

   PlaceEntity(
      String var1,
      List<Integer> var2,
      List<Integer> var3,
      Bundle var4,
      String var5,
      String var6,
      String var7,
      String var8,
      List<String> var9,
      LatLng var10,
      float var11,
      LatLngBounds var12,
      String var13,
      Uri var14,
      boolean var15,
      float var16,
      int var17,
      zzak var18,
      zzam var19,
      zzaf var20,
      String var21
   ) {
      this.a = var1;
      this.m = Collections.unmodifiableList(var2);
      this.l = var3;
      if (var4 == null) {
         var4 = new Bundle();
      }

      this.b = var4;
      this.n = var5;
      this.o = var6;
      this.p = var7;
      this.q = var8;
      if (var9 == null) {
         var9 = Collections.emptyList();
      }

      this.r = var9;
      this.d = var10;
      this.e = var11;
      this.f = var12;
      if (var13 == null) {
         var13 = "UTC";
      }

      this.g = var13;
      this.h = var14;
      this.i = var15;
      this.j = var16;
      this.k = var17;
      this.v = Collections.unmodifiableMap(new HashMap<>());
      this.w = null;
      this.x = null;
      this.c = var18;
      this.s = var19;
      this.t = var20;
      this.u = var21;
   }

   @Override
   public final LatLng a() {
      return this.d;
   }

   public final String b() {
      return this.a;
   }

   public final List<Integer> c() {
      return this.m;
   }

   public final LatLngBounds d() {
      return this.f;
   }

   public final Uri e() {
      return this.h;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof PlaceEntity)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.a.equals(var1.a) || !zzbg.a(this.x, var1.x)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public final float f() {
      return this.j;
   }

   public final int g() {
      return this.k;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, this.x});
   }

   @SuppressLint("DefaultLocale")
   @Override
   public final String toString() {
      return zzbg.a(this)
         .a("id", this.a)
         .a("placeTypes", this.m)
         .a("locale", this.x)
         .a("name", this.n)
         .a("address", this.o)
         .a("phoneNumber", this.p)
         .a("latlng", this.d)
         .a("viewport", this.f)
         .a("websiteUri", this.h)
         .a("isPermanentlyClosed", this.i)
         .a("priceLevel", this.k)
         .toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.b(), false);
      zzbfp.a(var1, 2, this.b, false);
      zzbfp.a(var1, 3, this.c, var2, false);
      zzbfp.a(var1, 4, this.a(), var2, false);
      zzbfp.a(var1, 5, this.e);
      zzbfp.a(var1, 6, this.d(), var2, false);
      zzbfp.a(var1, 7, this.g, false);
      zzbfp.a(var1, 8, this.e(), var2, false);
      zzbfp.a(var1, 9, this.i);
      zzbfp.a(var1, 10, this.f());
      zzbfp.a(var1, 11, this.g());
      zzbfp.a(var1, 13, this.l, false);
      zzbfp.a(var1, 14, (String)this.j(), false);
      zzbfp.a(var1, 15, (String)this.h(), false);
      zzbfp.a(var1, 16, this.q, false);
      zzbfp.b(var1, 17, this.r, false);
      zzbfp.a(var1, 19, (String)this.i(), false);
      zzbfp.a(var1, 20, this.c(), false);
      zzbfp.a(var1, 21, this.s, var2, false);
      zzbfp.a(var1, 22, this.t, var2, false);
      zzbfp.a(var1, 23, this.u, false);
      zzbfp.a(var1, var3);
   }
}
