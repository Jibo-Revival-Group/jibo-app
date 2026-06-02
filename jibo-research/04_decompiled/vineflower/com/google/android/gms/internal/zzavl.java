package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;

public final class zzavl extends zzbfm {
   public static final Creator<zzavl> CREATOR = new zzavm();
   private int a = 1;
   private String b;
   private PendingIntent c;

   zzavl(int var1, String var2, PendingIntent var3) {
      this.b = zzbq.a((String)var2);
      this.c = zzbq.a(var3);
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b, false);
      zzbfp.a(var1, 3, this.c, var2, false);
      zzbfp.a(var1, var3);
   }
}
