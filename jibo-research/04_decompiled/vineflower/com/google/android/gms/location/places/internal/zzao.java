package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.List;

public final class zzao extends zzbfm {
   public static final Creator<zzao> CREATOR = new zzf();
   private int a;
   private int b;
   private int c;
   private int d;
   private int e;
   private int f;
   private List<zzan> g;

   zzao(int var1, int var2, int var3, int var4, int var5, int var6, List<zzan> var7) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = Collections.unmodifiableList(var7);
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, 4, this.d);
      zzbfp.a(var1, 5, this.e);
      zzbfp.a(var1, 6, this.f);
      zzbfp.c(var1, 7, this.g, false);
      zzbfp.a(var1, var2);
   }
}
