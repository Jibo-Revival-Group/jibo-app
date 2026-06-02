package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class zzae extends zzbfm {
   public static final Creator<zzae> CREATOR = new zzaf();
   private int a;
   private int b;
   private long c;
   private long d;

   zzae(int var1, int var2, long var3, long var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var5;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 != null && this.getClass() == var1.getClass()) {
            var1 = var1;
            if (this.a != var1.a || this.b != var1.b || this.c != var1.c || this.d != var1.d) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.b, this.a, this.d, this.c});
   }

   @Override
   public final String toString() {
      StringBuilder var1 = new StringBuilder("NetworkLocationStatus:");
      var1.append(" Wifi status: ")
         .append(this.a)
         .append(" Cell status: ")
         .append(this.b)
         .append(" elapsed time NS: ")
         .append(this.d)
         .append(" system time ms: ")
         .append(this.c);
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, 4, this.d);
      zzbfp.a(var1, var2);
   }
}
