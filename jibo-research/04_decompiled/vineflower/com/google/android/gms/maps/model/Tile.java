package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class Tile extends zzbfm {
   public static final Creator<Tile> CREATOR = new zzq();
   public final int a;
   public final int b;
   public final byte[] c;

   public Tile(int var1, int var2, byte[] var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a);
      zzbfp.a(var1, 3, this.b);
      zzbfp.a(var1, 4, this.c, false);
      zzbfp.a(var1, var2);
   }
}
