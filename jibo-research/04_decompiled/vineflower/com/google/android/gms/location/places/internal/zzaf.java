package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.List;

public final class zzaf extends zzbfm {
   public static final Creator<zzaf> CREATOR = new zzag();
   private final List<Integer> a;
   private final String b;
   private final Uri c;
   private final float d;
   private final int e;

   zzaf(List<Integer> var1, String var2, Uri var3, float var4, int var5) {
      this.a = Collections.unmodifiableList(var1);
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a, false);
      zzbfp.a(var1, 2, this.b, false);
      zzbfp.a(var1, 3, this.c, var2, false);
      zzbfp.a(var1, 4, this.d);
      zzbfp.a(var1, 5, this.e);
      zzbfp.a(var1, var3);
   }
}
