package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzz extends zzbfm {
   public static final Creator<zzz> CREATOR = new zzaa();
   private final String a;
   private final String b;
   private final int c;
   private final boolean d;
   private final String e;

   zzz(String var1, String var2, String var3, int var4, boolean var5) {
      this.e = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a, false);
      zzbfp.a(var1, 2, this.b, false);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, 4, this.d);
      zzbfp.a(var1, 5, this.e, false);
      zzbfp.a(var1, var2);
   }
}
