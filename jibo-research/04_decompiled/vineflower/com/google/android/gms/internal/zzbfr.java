package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;

public final class zzbfr {
   public static <T extends zzbfq> T a(byte[] var0, Creator<T> var1) {
      zzbq.a(var1);
      Parcel var2 = Parcel.obtain();
      var2.unmarshall(var0, 0, var0.length);
      var2.setDataPosition(0);
      zzbfq var3 = (zzbfq)var1.createFromParcel(var2);
      var2.recycle();
      return (T)var3;
   }
}
