package com.google.android.gms.internal;

import android.os.Parcel;

public final class zzbfo extends RuntimeException {
   public zzbfo(String var1, Parcel var2) {
      int var4 = var2.dataPosition();
      int var3 = var2.dataSize();
      super(new StringBuilder(String.valueOf(var1).length() + 41).append(var1).append(" Parcel: pos=").append(var4).append(" size=").append(var3).toString());
   }
}
