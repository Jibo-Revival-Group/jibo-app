package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzbgk extends zzbfm {
   public static final Creator<zzbgk> CREATOR = new zzbgm();
   final String a;
   final int b;
   private int c;

   zzbgk(int var1, String var2, int var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   zzbgk(String var1, int var2) {
      this.c = 1;
      this.a = var1;
      this.b = var2;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.c);
      zzbfp.a(var1, 2, this.a, false);
      zzbfp.a(var1, 3, this.b);
      zzbfp.a(var1, var2);
   }
}
