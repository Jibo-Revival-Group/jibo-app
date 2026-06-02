package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public final class zzcfo extends zzbfm {
   public static final Creator<zzcfo> CREATOR = new zzcfp();
   static final List<zzcdv> a = Collections.emptyList();
   private LocationRequest b;
   private List<zzcdv> c;
   private String d;
   private boolean e;
   private boolean f;
   private boolean g;
   private String h;
   private boolean i = true;

   zzcfo(LocationRequest var1, List<zzcdv> var2, String var3, boolean var4, boolean var5, boolean var6, String var7) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
      this.g = var6;
      this.h = var7;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (!(var1 instanceof zzcfo)) {
         var2 = var3;
      } else {
         var1 = var1;
         var2 = var3;
         if (zzbg.a(this.b, var1.b)) {
            var2 = var3;
            if (zzbg.a(this.c, var1.c)) {
               var2 = var3;
               if (zzbg.a(this.d, var1.d)) {
                  var2 = var3;
                  if (this.e == var1.e) {
                     var2 = var3;
                     if (this.f == var1.f) {
                        var2 = var3;
                        if (this.g == var1.g) {
                           var2 = var3;
                           if (zzbg.a(this.h, var1.h)) {
                              var2 = true;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return this.b.hashCode();
   }

   @Override
   public final String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.b.toString());
      if (this.d != null) {
         var1.append(" tag=").append(this.d);
      }

      if (this.h != null) {
         var1.append(" moduleId=").append(this.h);
      }

      var1.append(" hideAppOps=").append(this.e);
      var1.append(" clients=").append(this.c);
      var1.append(" forceCoarseLocation=").append(this.f);
      if (this.g) {
         var1.append(" exemptFromBackgroundThrottle");
      }

      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.b, var2, false);
      zzbfp.c(var1, 5, this.c, false);
      zzbfp.a(var1, 6, this.d, false);
      zzbfp.a(var1, 7, this.e);
      zzbfp.a(var1, 8, this.f);
      zzbfp.a(var1, 9, this.g);
      zzbfp.a(var1, 10, this.h, false);
      zzbfp.a(var1, var3);
   }
}
