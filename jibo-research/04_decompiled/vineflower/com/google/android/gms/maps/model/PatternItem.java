package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public class PatternItem extends zzbfm {
   public static final Creator<PatternItem> CREATOR = new zzi();
   private static final String a = PatternItem.class.getSimpleName();
   private final int b;
   private final Float c;

   public PatternItem(int var1, Float var2) {
      boolean var4 = true;
      super();
      boolean var3 = var4;
      if (var1 != 1) {
         if (var2 != null && var2 >= 0.0F) {
            var3 = var4;
         } else {
            var3 = false;
         }
      }

      String var5 = String.valueOf(var2);
      zzbq.b(
         var3,
         new StringBuilder(String.valueOf(var5).length() + 45).append("Invalid PatternItem: type=").append(var1).append(" length=").append(var5).toString()
      );
      this.b = var1;
      this.c = var2;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof PatternItem)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.b != var1.b || !zzbg.a(this.c, var1.c)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return Arrays.hashCode(new Object[]{this.b, this.c});
   }

   @Override
   public String toString() {
      int var1 = this.b;
      String var2 = String.valueOf(this.c);
      return new StringBuilder(String.valueOf(var2).length() + 39)
         .append("[PatternItem: type=")
         .append(var1)
         .append(" length=")
         .append(var2)
         .append("]")
         .toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, 3, this.c, false);
      zzbfp.a(var1, var2);
   }
}
