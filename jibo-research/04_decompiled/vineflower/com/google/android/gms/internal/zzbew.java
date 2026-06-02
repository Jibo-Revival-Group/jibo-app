package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import java.util.Arrays;

public final class zzbew extends zzbfm {
   public static final Creator<zzbew> CREATOR = new zzbex();
   public final int a;
   public final String b;
   private String c;
   private int d;
   private String e;
   private String f;
   private boolean g;
   private boolean h;
   private int i;

   public zzbew(String var1, int var2, int var3, String var4, String var5, String var6, boolean var7, int var8) {
      this.c = zzbq.a((String)var1);
      this.d = var2;
      this.a = var3;
      this.b = var4;
      this.e = var5;
      this.f = var6;
      boolean var9;
      if (!var7) {
         var9 = true;
      } else {
         var9 = false;
      }

      this.g = var9;
      this.h = var7;
      this.i = var8;
   }

   public zzbew(String var1, int var2, int var3, String var4, String var5, boolean var6, String var7, boolean var8, int var9) {
      this.c = var1;
      this.d = var2;
      this.a = var3;
      this.e = var4;
      this.f = var5;
      this.g = var6;
      this.b = var7;
      this.h = var8;
      this.i = var9;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof zzbew) {
            var1 = var1;
            if (!zzbg.a(this.c, var1.c)
               || this.d != var1.d
               || this.a != var1.a
               || !zzbg.a(this.b, var1.b)
               || !zzbg.a(this.e, var1.e)
               || !zzbg.a(this.f, var1.f)
               || this.g != var1.g
               || this.h != var1.h
               || this.i != var1.i) {
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
      return Arrays.hashCode(new Object[]{this.c, this.d, this.a, this.b, this.e, this.f, this.g, this.h, this.i});
   }

   @Override
   public final String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("PlayLoggerContext[");
      var1.append("package=").append(this.c).append(',');
      var1.append("packageVersionCode=").append(this.d).append(',');
      var1.append("logSource=").append(this.a).append(',');
      var1.append("logSourceName=").append(this.b).append(',');
      var1.append("uploadAccount=").append(this.e).append(',');
      var1.append("loggingId=").append(this.f).append(',');
      var1.append("logAndroidId=").append(this.g).append(',');
      var1.append("isAnonymous=").append(this.h).append(',');
      var1.append("qosTier=").append(this.i);
      var1.append("]");
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.c, false);
      zzbfp.a(var1, 3, this.d);
      zzbfp.a(var1, 4, this.a);
      zzbfp.a(var1, 5, this.e, false);
      zzbfp.a(var1, 6, this.f, false);
      zzbfp.a(var1, 7, this.g);
      zzbfp.a(var1, 8, this.b, false);
      zzbfp.a(var1, 9, this.h);
      zzbfp.a(var1, 10, this.i);
      zzbfp.a(var1, var2);
   }
}
