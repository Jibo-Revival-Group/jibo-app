package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zzcxg extends zzbfm implements Result {
   public static final Creator<zzcxg> CREATOR = new zzcxh();
   private int a;
   private int b;
   private Intent c;

   public zzcxg() {
      this(0, null);
   }

   zzcxg(int var1, int var2, Intent var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   private zzcxg(int var1, Intent var2) {
      this(2, 0, null);
   }

   @Override
   public final Status a() {
      Status var1;
      if (this.b == 0) {
         var1 = Status.a;
      } else {
         var1 = Status.e;
      }

      return var1;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, 3, this.c, var2, false);
      zzbfp.a(var1, var3);
   }
}
