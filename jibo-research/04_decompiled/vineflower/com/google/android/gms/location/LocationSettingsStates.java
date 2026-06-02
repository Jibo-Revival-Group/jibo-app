package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class LocationSettingsStates extends zzbfm {
   public static final Creator<LocationSettingsStates> CREATOR = new zzad();
   private final boolean a;
   private final boolean b;
   private final boolean c;
   private final boolean d;
   private final boolean e;
   private final boolean f;

   public LocationSettingsStates(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
   }

   public final boolean a() {
      return this.a;
   }

   public final boolean b() {
      return this.d;
   }

   public final boolean c() {
      return this.b;
   }

   public final boolean d() {
      return this.e;
   }

   public final boolean e() {
      return this.c;
   }

   public final boolean f() {
      return this.f;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a());
      zzbfp.a(var1, 2, this.c());
      zzbfp.a(var1, 3, this.e());
      zzbfp.a(var1, 4, this.b());
      zzbfp.a(var1, 5, this.d());
      zzbfp.a(var1, 6, this.f());
      zzbfp.a(var1, var2);
   }
}
