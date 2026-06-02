package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest extends zzbfm {
   public static final Creator<LocationSettingsRequest> CREATOR = new zzab();
   private final List<LocationRequest> a;
   private final boolean b;
   private final boolean c;
   private zzz d;

   LocationSettingsRequest(List<LocationRequest> var1, boolean var2, boolean var3, zzz var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.c(var1, 1, Collections.unmodifiableList(this.a), false);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, 5, this.d, var2, false);
      zzbfp.a(var1, var3);
   }
}
