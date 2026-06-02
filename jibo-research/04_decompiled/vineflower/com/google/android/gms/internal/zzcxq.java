package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbt;

public final class zzcxq extends zzbfm {
   public static final Creator<zzcxq> CREATOR = new zzcxr();
   private int a;
   private final ConnectionResult b;
   private final zzbt c;

   public zzcxq(int var1) {
      this(new ConnectionResult(8, null), null);
   }

   zzcxq(int var1, ConnectionResult var2, zzbt var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   private zzcxq(ConnectionResult var1, zzbt var2) {
      this(1, var1, null);
   }

   public final ConnectionResult a() {
      return this.b;
   }

   public final zzbt b() {
      return this.c;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b, var2, false);
      zzbfp.a(var1, 3, this.c, var2, false);
      zzbfp.a(var1, var3);
   }
}
