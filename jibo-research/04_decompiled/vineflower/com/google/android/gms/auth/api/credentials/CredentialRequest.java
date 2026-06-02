package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class CredentialRequest extends zzbfm {
   public static final Creator<CredentialRequest> CREATOR = new zze();
   private int a;
   private final boolean b;
   private final String[] c;
   private final CredentialPickerConfig d;
   private final CredentialPickerConfig e;
   private final boolean f;
   private final String g;
   private final String h;
   private final boolean i;

   CredentialRequest(
      int var1, boolean var2, String[] var3, CredentialPickerConfig var4, CredentialPickerConfig var5, boolean var6, String var7, String var8, boolean var9
   ) {
      this.a = var1;
      this.b = var2;
      this.c = zzbq.a(var3);
      CredentialPickerConfig var10 = var4;
      if (var4 == null) {
         var10 = new CredentialPickerConfig.Builder().a();
      }

      this.d = var10;
      CredentialPickerConfig var11 = var5;
      if (var5 == null) {
         var11 = new CredentialPickerConfig.Builder().a();
      }

      this.e = var11;
      if (var1 < 3) {
         this.f = true;
         this.g = null;
         this.h = null;
      } else {
         this.f = var6;
         this.g = var7;
         this.h = var8;
      }

      this.i = var9;
   }

   public final boolean a() {
      return this.b;
   }

   public final String[] b() {
      return this.c;
   }

   public final CredentialPickerConfig c() {
      return this.d;
   }

   public final CredentialPickerConfig d() {
      return this.e;
   }

   public final boolean e() {
      return this.f;
   }

   public final String f() {
      return this.g;
   }

   public final String g() {
      return this.h;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a());
      zzbfp.a(var1, 2, this.b(), false);
      zzbfp.a(var1, 3, this.c(), var2, false);
      zzbfp.a(var1, 4, this.d(), var2, false);
      zzbfp.a(var1, 5, this.e());
      zzbfp.a(var1, 6, this.f(), false);
      zzbfp.a(var1, 7, this.g(), false);
      zzbfp.a(var1, 1000, this.a);
      zzbfp.a(var1, 8, this.i);
      zzbfp.a(var1, var3);
   }
}
