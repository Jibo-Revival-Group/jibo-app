package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzbv extends zzbfm {
   public static final Creator<zzbv> CREATOR = new zzbw();
   private int a;
   private final int b;
   private final int c;
   @Deprecated
   private final Scope[] d;

   zzbv(int var1, int var2, int var3, Scope[] var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public zzbv(int var1, int var2, Scope[] var3) {
      this(1, var1, var2, null);
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, 4, this.d, var2, false);
      zzbfp.a(var1, var3);
   }
}
