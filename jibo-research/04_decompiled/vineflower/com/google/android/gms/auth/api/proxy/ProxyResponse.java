package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public class ProxyResponse extends zzbfm {
   public static final Creator<ProxyResponse> CREATOR = new zzb();
   public final int a;
   public final PendingIntent b;
   public final int c;
   public final byte[] d;
   private int e;
   private Bundle f;

   ProxyResponse(int var1, int var2, PendingIntent var3, int var4, Bundle var5, byte[] var6) {
      this.e = var1;
      this.a = var2;
      this.c = var4;
      this.f = var5;
      this.d = var6;
      this.b = var3;
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b, var2, false);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, 4, this.f, false);
      zzbfp.a(var1, 5, this.d, false);
      zzbfp.a(var1, 1000, this.e);
      zzbfp.a(var1, var3);
   }
}
