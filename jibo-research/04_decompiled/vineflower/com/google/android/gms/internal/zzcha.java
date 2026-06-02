package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;

public final class zzcha extends zzbfm {
   public static final Creator<zzcha> CREATOR = new zzchb();
   public final String a;
   public final zzcgx b;
   public final String c;
   public final long d;

   zzcha(zzcha var1, long var2) {
      zzbq.a(var1);
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var2;
   }

   public zzcha(String var1, zzcgx var2, String var3, long var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   @Override
   public final String toString() {
      String var1 = this.c;
      String var2 = this.a;
      String var3 = String.valueOf(this.b);
      return new StringBuilder(String.valueOf(var1).length() + 21 + String.valueOf(var2).length() + String.valueOf(var3).length())
         .append("origin=")
         .append(var1)
         .append(",name=")
         .append(var2)
         .append(",params=")
         .append(var3)
         .toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a, false);
      zzbfp.a(var1, 3, this.b, var2, false);
      zzbfp.a(var1, 4, this.c, false);
      zzbfp.a(var1, 5, this.d);
      zzbfp.a(var1, var3);
   }
}
