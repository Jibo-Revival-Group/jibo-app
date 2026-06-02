package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;
import java.io.Serializable;

public final class zzcln extends zzbfm {
   public static final Creator<zzcln> CREATOR = new zzclo();
   public final String a;
   public final long b;
   public final String c;
   private int d;
   private Long e;
   private Float f;
   private String g;
   private Double h;

   zzcln(int var1, String var2, long var3, Long var5, Float var6, String var7, String var8, Double var9) {
      Object var10 = null;
      super();
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.e = var5;
      this.f = null;
      if (var1 == 1) {
         Double var11 = (Double)var10;
         if (var6 != null) {
            var11 = var6.doubleValue();
         }

         this.h = var11;
      } else {
         this.h = var9;
      }

      this.g = var7;
      this.c = var8;
   }

   zzcln(zzclp var1) {
      this(var1.c, var1.d, var1.e, var1.b);
   }

   zzcln(String var1, long var2, Object var4, String var5) {
      zzbq.a(var1);
      this.d = 2;
      this.a = var1;
      this.b = var2;
      this.c = var5;
      if (var4 == null) {
         this.e = null;
         this.f = null;
         this.h = null;
         this.g = null;
      } else if (var4 instanceof Long) {
         this.e = (Long)var4;
         this.f = null;
         this.h = null;
         this.g = null;
      } else if (var4 instanceof String) {
         this.e = null;
         this.f = null;
         this.h = null;
         this.g = (String)var4;
      } else {
         if (!(var4 instanceof Double)) {
            throw new IllegalArgumentException("User attribute given of un-supported type");
         }

         this.e = null;
         this.f = null;
         this.h = (Double)var4;
         this.g = null;
      }
   }

   public final Object a() {
      Serializable var1;
      if (this.e != null) {
         var1 = this.e;
      } else if (this.h != null) {
         var1 = this.h;
      } else if (this.g != null) {
         var1 = this.g;
      } else {
         var1 = null;
      }

      return var1;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.d);
      zzbfp.a(var1, 2, this.a, false);
      zzbfp.a(var1, 3, this.b);
      zzbfp.a(var1, 4, this.e, false);
      zzbfp.a(var1, 5, (Float)null, false);
      zzbfp.a(var1, 6, this.g, false);
      zzbfp.a(var1, 7, this.c, false);
      zzbfp.a(var1, 8, this.h, false);
      zzbfp.a(var1, var2);
   }
}
