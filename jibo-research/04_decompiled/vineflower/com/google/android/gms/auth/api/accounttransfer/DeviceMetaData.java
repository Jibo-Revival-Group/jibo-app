package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public class DeviceMetaData extends zzbfm {
   public static final Creator<DeviceMetaData> CREATOR = new zzw();
   private int a;
   private boolean b;
   private long c;
   private final boolean d;

   DeviceMetaData(int var1, boolean var2, long var3, boolean var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var5;
   }

   public boolean a() {
      return this.b;
   }

   public long b() {
      return this.c;
   }

   public boolean c() {
      return this.d;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.a());
      zzbfp.a(var1, 3, this.b());
      zzbfp.a(var1, 4, this.c());
      zzbfp.a(var1, var2);
   }
}
