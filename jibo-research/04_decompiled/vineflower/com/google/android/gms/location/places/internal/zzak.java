package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.List;

@Deprecated
public final class zzak extends zzbfm {
   public static final Creator<zzak> CREATOR = new zzal();
   private String a;
   private String b;
   private String c;
   private String d;
   private List<String> e;

   public zzak(String var1, String var2, String var3, String var4, List<String> var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof zzak)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!zzbg.a(this.a, var1.a) || !zzbg.a(this.b, var1.b) || !zzbg.a(this.c, var1.c) || !zzbg.a(this.d, var1.d) || !zzbg.a(this.e, var1.e)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d});
   }

   @Override
   public final String toString() {
      return zzbg.a(this)
         .a("name", this.a)
         .a("address", this.b)
         .a("internationalPhoneNumber", this.c)
         .a("regularOpenHours", this.d)
         .a("attributions", this.e)
         .toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a, false);
      zzbfp.a(var1, 2, this.b, false);
      zzbfp.a(var1, 3, this.c, false);
      zzbfp.a(var1, 4, this.d, false);
      zzbfp.b(var1, 5, this.e, false);
      zzbfp.a(var1, var2);
   }
}
