package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class HintRequest extends zzbfm implements ReflectedParcelable {
   public static final Creator<HintRequest> CREATOR = new zzh();
   private int a;
   private final CredentialPickerConfig b;
   private final boolean c;
   private final boolean d;
   private final String[] e;
   private final boolean f;
   private final String g;
   private final String h;

   HintRequest(int var1, CredentialPickerConfig var2, boolean var3, boolean var4, String[] var5, boolean var6, String var7, String var8) {
      this.a = var1;
      this.b = zzbq.a(var2);
      this.c = var3;
      this.d = var4;
      this.e = zzbq.a(var5);
      if (this.a < 2) {
         this.f = true;
         this.g = null;
         this.h = null;
      } else {
         this.f = var6;
         this.g = var7;
         this.h = var8;
      }
   }

   public final CredentialPickerConfig a() {
      return this.b;
   }

   public final boolean b() {
      return this.c;
   }

   public final String[] c() {
      return this.e;
   }

   public final boolean d() {
      return this.f;
   }

   public final String e() {
      return this.g;
   }

   public final String f() {
      return this.h;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a(), var2, false);
      zzbfp.a(var1, 2, this.b());
      zzbfp.a(var1, 3, this.d);
      zzbfp.a(var1, 4, this.c(), false);
      zzbfp.a(var1, 5, this.d());
      zzbfp.a(var1, 6, this.e(), false);
      zzbfp.a(var1, 7, this.f(), false);
      zzbfp.a(var1, 1000, this.a);
      zzbfp.a(var1, var3);
   }
}
