package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzn extends zzbfm {
   public static final Creator<zzn> CREATOR = new zzm();
   private int a;
   private int b;
   private Bundle c;

   zzn(int var1, int var2, Bundle var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final int a() {
      return this.b;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, 3, this.c, false);
      zzbfp.a(var1, var2);
   }
}
