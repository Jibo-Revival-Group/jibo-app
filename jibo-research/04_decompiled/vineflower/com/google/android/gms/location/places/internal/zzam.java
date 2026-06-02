package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.List;

public final class zzam extends zzbfm {
   public static final Creator<zzam> CREATOR = new zzap();
   private List<zzan> a;
   private List<zzao> b;

   zzam(List<zzan> var1, List<zzao> var2) {
      this.a = Collections.unmodifiableList(var1);
      this.b = Collections.unmodifiableList(var2);
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.c(var1, 1, this.a, false);
      zzbfp.c(var1, 2, this.b, false);
      zzbfp.a(var1, var2);
   }
}
