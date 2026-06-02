package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.List;

public class AutocompleteFilter extends zzbfm implements ReflectedParcelable {
   public static final Creator<AutocompleteFilter> CREATOR = new zzc();
   private int a;
   private boolean b;
   private List<Integer> c;
   private String d;
   private int e;

   AutocompleteFilter(int var1, boolean var2, List<Integer> var3, String var4) {
      boolean var5 = false;
      super();
      this.a = var1;
      this.c = var3;
      if (var3 != null && !var3.isEmpty()) {
         var1 = (Integer)var3.iterator().next();
      } else {
         var1 = 0;
      }

      this.e = var1;
      this.d = var4;
      if (this.a <= 0) {
         if (!var2) {
            var5 = true;
         }

         this.b = var5;
      } else {
         this.b = var2;
      }
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof AutocompleteFilter)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.e != var1.e || this.b != var1.b || this.d != var1.d) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return Arrays.hashCode(new Object[]{this.b, this.e, this.d});
   }

   @Override
   public String toString() {
      return zzbg.a(this).a("includeQueryPredictions", this.b).a("typeFilter", this.e).a("country", this.d).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.b);
      zzbfp.a(var1, 2, this.c, false);
      zzbfp.a(var1, 3, this.d, false);
      zzbfp.a(var1, 1000, this.a);
      zzbfp.a(var1, var2);
   }

   public static final class Builder {
      private boolean a = false;
      private int b = 0;
      private String c = "";

      public final AutocompleteFilter a() {
         return new AutocompleteFilter(1, false, Arrays.asList(this.b), this.c);
      }
   }
}
