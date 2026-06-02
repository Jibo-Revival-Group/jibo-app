package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class AddPlaceRequest extends zzbfm {
   public static final Creator<AddPlaceRequest> CREATOR = new zzb();
   private final String a;
   private final LatLng b;
   private final String c;
   private final List<Integer> d;
   private final String e;
   private final Uri f;

   public AddPlaceRequest(String var1, LatLng var2, String var3, List<Integer> var4, String var5, Uri var6) {
      boolean var8 = false;
      super();
      this.a = zzbq.a(var1);
      this.b = zzbq.a(var2);
      this.c = zzbq.a(var3);
      this.d = new ArrayList<>(zzbq.a(var4));
      boolean var7;
      if (!this.d.isEmpty()) {
         var7 = true;
      } else {
         var7 = false;
      }

      label15: {
         zzbq.b(var7, "At least one place type should be provided.");
         if (TextUtils.isEmpty(var5)) {
            var7 = var8;
            if (var6 == null) {
               break label15;
            }
         }

         var7 = true;
      }

      zzbq.b(var7, "One of phone number or URI should be provided.");
      this.e = var5;
      this.f = var6;
   }

   public String a() {
      return this.a;
   }

   public LatLng b() {
      return this.b;
   }

   public String c() {
      return this.c;
   }

   public List<Integer> d() {
      return this.d;
   }

   public String e() {
      return this.e;
   }

   public Uri f() {
      return this.f;
   }

   @Override
   public String toString() {
      return zzbg.a(this)
         .a("name", this.a)
         .a("latLng", this.b)
         .a("address", this.c)
         .a("placeTypes", this.d)
         .a("phoneNumer", this.e)
         .a("websiteUri", this.f)
         .toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a(), false);
      zzbfp.a(var1, 2, this.b(), var2, false);
      zzbfp.a(var1, 3, this.c(), false);
      zzbfp.a(var1, 4, this.d(), false);
      zzbfp.a(var1, 5, this.e(), false);
      zzbfp.a(var1, 6, this.f(), var2, false);
      zzbfp.a(var1, var3);
   }
}
