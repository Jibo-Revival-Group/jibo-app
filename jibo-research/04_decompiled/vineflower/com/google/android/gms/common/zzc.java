package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzc extends zzbfm {
   public static final Creator<zzc> CREATOR = new zzd();
   private String a;
   private int b;

   public zzc(String var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a, false);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, var2);
   }
}
