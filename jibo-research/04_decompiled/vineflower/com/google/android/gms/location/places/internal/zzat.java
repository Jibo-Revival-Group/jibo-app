package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.Locale;

public final class zzat extends zzbfm {
   public static final Creator<zzat> CREATOR = new zzau();
   private static zzat a = new zzat("com.google.android.gms", Locale.getDefault(), null);
   private String b;
   private String c;
   private String d;
   private String e;
   private int f;
   private int g;

   public zzat(String var1, String var2, String var3, String var4, int var5, int var6) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
      this.g = var6;
   }

   private zzat(String var1, Locale var2, String var3) {
      this(var1, var2.toString(), null, null, GoogleApiAvailability.a, 0);
   }

   public zzat(String var1, Locale var2, String var3, String var4, int var5) {
      this(var1, var2.toString(), var3, var4, GoogleApiAvailability.a, var5);
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 != null && var1 instanceof zzat) {
            var1 = var1;
            if (this.f != var1.f || this.g != var1.g || !this.c.equals(var1.c) || !this.b.equals(var1.b) || !zzbg.a(this.d, var1.d) || !zzbg.a(this.e, var1.e)) {
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
      return Arrays.hashCode(new Object[]{this.b, this.c, this.d, this.e, this.f, this.g});
   }

   @SuppressLint("DefaultLocale")
   @Override
   public final String toString() {
      return zzbg.a(this).a("clientPackageName", this.b).a("locale", this.c).a("accountName", this.d).a("gCoreClientName", this.e).toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.b, false);
      zzbfp.a(var1, 2, this.c, false);
      zzbfp.a(var1, 3, this.d, false);
      zzbfp.a(var1, 4, this.e, false);
      zzbfp.a(var1, 6, this.f);
      zzbfp.a(var1, 7, this.g);
      zzbfp.a(var1, var2);
   }
}
