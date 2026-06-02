package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.List;

public final class zzag extends zzbfm {
   public static final Creator<zzag> CREATOR = new zzah();
   private final List<String> a;
   private final PendingIntent b;
   private final String c;

   zzag(List<String> var1, PendingIntent var2, String var3) {
      if (var1 == null) {
         var1 = Collections.emptyList();
      } else {
         var1 = Collections.unmodifiableList(var1);
      }

      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.b(var1, 1, this.a, false);
      zzbfp.a(var1, 2, this.b, var2, false);
      zzbfp.a(var1, 3, this.c, false);
      zzbfp.a(var1, var3);
   }
}
