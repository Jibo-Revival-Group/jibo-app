package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzbgv extends zzbfm {
   public static final Creator<zzbgv> CREATOR = new zzbgs();
   final String a;
   final zzbgo<?, ?> b;
   private int c;

   zzbgv(int var1, String var2, zzbgo<?, ?> var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   zzbgv(String var1, zzbgo<?, ?> var2) {
      this.c = 1;
      this.a = var1;
      this.b = var2;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.c);
      zzbfp.a(var1, 2, this.a, false);
      zzbfp.a(var1, 3, this.b, var2, false);
      zzbfp.a(var1, var3);
   }
}
