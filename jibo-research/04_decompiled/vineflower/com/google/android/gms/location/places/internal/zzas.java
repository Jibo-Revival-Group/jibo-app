package com.google.android.gms.location.places.internal;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import java.util.Collections;
import java.util.List;

public final class zzas extends zzav implements Place {
   private final String c;
   private final zzaf d;

   public zzas(DataHolder var1, int var2) {
      Object var3 = null;
      super(var1, var2);
      this.c = this.a("place_id", "");
      boolean var7;
      if (this.c().size() <= 0
         && (this.b() == null || this.b().length() <= 0)
         && (this.f() == null || this.f().equals(Uri.EMPTY))
         && !(this.e() >= 0.0F)
         && this.d() < 0) {
         var7 = false;
      } else {
         var7 = true;
      }

      zzaf var6;
      if (var7) {
         List var4 = this.c();
         String var5 = (String)var3;
         if (this.b() != null) {
            var5 = this.b().toString();
         }

         var6 = new zzaf(var4, var5, this.f(), this.e(), this.d());
      } else {
         var6 = null;
      }

      this.d = var6;
   }

   @Override
   public final LatLng a() {
      return this.a("place_lat_lng", LatLng.CREATOR);
   }

   public final CharSequence b() {
      return this.a("place_phone_number", "");
   }

   public final List<Integer> c() {
      return this.a("place_types", Collections.emptyList());
   }

   public final int d() {
      return this.a("place_price_level", -1);
   }

   public final float e() {
      return this.a("place_rating", -1.0F);
   }

   public final Uri f() {
      Uri var1 = null;
      String var2 = this.a("place_website_uri", (String)null);
      if (var2 != null) {
         var1 = Uri.parse(var2);
      }

      return var1;
   }
}
