package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;

public final class zzavf extends zzbfm {
   public static final Creator<zzavf> CREATOR = new zzavg();
   private int a = 1;
   private String b;
   private int c;

   zzavf(int var1, String var2, int var3) {
      this.b = zzbq.a((String)var2);
      this.c = var3;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b, false);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, var2);
   }
}
