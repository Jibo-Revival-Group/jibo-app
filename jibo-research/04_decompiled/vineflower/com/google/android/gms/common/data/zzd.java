package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfq;

public class zzd<T extends zzbfq> extends AbstractDataBuffer<T> {
   private static final String[] b = new String[]{"data"};
   private final Creator<T> c;

   public zzd(DataHolder var1, Creator<T> var2) {
      super(var1);
      this.c = var2;
   }

   public T b(int var1) {
      byte[] var3 = this.a.d("data", var1, this.a.a(var1));
      Parcel var2 = Parcel.obtain();
      var2.unmarshall(var3, 0, var3.length);
      var2.setDataPosition(0);
      zzbfq var4 = (zzbfq)this.c.createFromParcel(var2);
      var2.recycle();
      return (T)var4;
   }
}
