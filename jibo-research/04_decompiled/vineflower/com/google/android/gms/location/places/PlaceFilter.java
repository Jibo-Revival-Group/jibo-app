package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbi;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class PlaceFilter extends zza {
   public static final Creator<PlaceFilter> CREATOR = new zzh();
   private static final PlaceFilter a = new PlaceFilter();
   private List<Integer> b;
   private boolean c;
   private List<zzo> d;
   private List<String> e;
   private final Set<Integer> f;
   private final Set<zzo> g;
   private final Set<String> h;

   public PlaceFilter() {
      this(false, null);
   }

   private PlaceFilter(Collection<Integer> var1, boolean var2, Collection<String> var3, Collection<zzo> var4) {
      this(a((Collection<Integer>)null), var2, a(var3), a((Collection<zzo>)null));
   }

   PlaceFilter(List<Integer> var1, boolean var2, List<String> var3, List<zzo> var4) {
      if (var1 == null) {
         var1 = Collections.emptyList();
      } else {
         var1 = Collections.unmodifiableList(var1);
      }

      this.b = var1;
      this.c = var2;
      if (var4 == null) {
         var1 = Collections.emptyList();
      } else {
         var1 = Collections.unmodifiableList(var4);
      }

      this.d = var1;
      if (var3 == null) {
         var1 = Collections.emptyList();
      } else {
         var1 = Collections.unmodifiableList(var3);
      }

      this.e = var1;
      this.f = a(this.b);
      this.g = a(this.d);
      this.h = a(this.e);
   }

   public PlaceFilter(boolean var1, Collection<String> var2) {
      this(null, var1, var2, null);
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof PlaceFilter)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.f.equals(var1.f) || this.c != var1.c || !this.g.equals(var1.g) || !this.h.equals(var1.h)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.f, this.c, this.g, this.h});
   }

   @Override
   public final String toString() {
      zzbi var1 = zzbg.a(this);
      if (!this.f.isEmpty()) {
         var1.a("types", this.f);
      }

      var1.a("requireOpenNow", this.c);
      if (!this.h.isEmpty()) {
         var1.a("placeIds", this.h);
      }

      if (!this.g.isEmpty()) {
         var1.a("requestedUserDataTypes", this.g);
      }

      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.b, false);
      zzbfp.a(var1, 3, this.c);
      zzbfp.c(var1, 4, this.d, false);
      zzbfp.b(var1, 6, this.e, false);
      zzbfp.a(var1, var2);
   }
}
