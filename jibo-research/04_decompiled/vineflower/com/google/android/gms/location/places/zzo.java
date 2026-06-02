package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Set;

public final class zzo extends zzbfm {
   public static final Creator<zzo> CREATOR = new zzp();
   private static zzo a = a("test_type", 1);
   private static zzo b = a("labeled_place", 6);
   private static zzo c = a("here_content", 7);
   private static Set<zzo> d = zze.a(a, b, c);
   private String e;
   private int f;

   zzo(String var1, int var2) {
      zzbq.a(var1);
      this.e = var1;
      this.f = var2;
   }

   private static zzo a(String var0, int var1) {
      return new zzo(var0, var1);
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof zzo)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.e.equals(var1.e) || this.f != var1.f) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return this.e.hashCode();
   }

   @Override
   public final String toString() {
      return this.e;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.e, false);
      zzbfp.a(var1, 2, this.f);
      zzbfp.a(var1, var2);
   }
}
