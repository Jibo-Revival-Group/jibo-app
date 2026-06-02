package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;

public final class zzawf extends zzbfm {
   public static final Creator<zzawf> CREATOR = new zzawg();
   private final Credential a;

   public zzawf(Credential var1) {
      this.a = var1;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a, var2, false);
      zzbfp.a(var1, var3);
   }
}
