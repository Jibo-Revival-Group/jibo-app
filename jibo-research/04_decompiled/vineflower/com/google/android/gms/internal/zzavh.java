package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;

public final class zzavh extends zzbfm {
   public static final Creator<zzavh> CREATOR = new zzavi();
   private int a = 1;
   private String b;

   zzavh(int var1, String var2) {
      this.b = zzbq.a((String)var2);
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b, false);
      zzbfp.a(var1, var2);
   }
}
