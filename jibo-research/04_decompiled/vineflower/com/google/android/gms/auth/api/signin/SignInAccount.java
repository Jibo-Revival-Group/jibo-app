package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public class SignInAccount extends zzbfm implements ReflectedParcelable {
   public static final Creator<SignInAccount> CREATOR = new zzf();
   @Deprecated
   private String a;
   private GoogleSignInAccount b;
   @Deprecated
   private String c;

   SignInAccount(String var1, GoogleSignInAccount var2, String var3) {
      this.b = var2;
      this.a = zzbq.a(var1, "8.3 and 8.4 SDKs require non-null email");
      this.c = zzbq.a(var3, "8.3 and 8.4 SDKs require non-null userId");
   }

   public final GoogleSignInAccount a() {
      return this.b;
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 4, this.a, false);
      zzbfp.a(var1, 7, this.b, var2, false);
      zzbfp.a(var1, 8, this.c, false);
      zzbfp.a(var1, var3);
   }
}
