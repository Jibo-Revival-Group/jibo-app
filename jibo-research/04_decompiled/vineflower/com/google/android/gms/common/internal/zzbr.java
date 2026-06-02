package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzbr extends zzbfm {
   public static final Creator<zzbr> CREATOR = new zzbs();
   private int a;
   private final Account b;
   private final int c;
   private final GoogleSignInAccount d;

   zzbr(int var1, Account var2, int var3, GoogleSignInAccount var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public zzbr(Account var1, int var2, GoogleSignInAccount var3) {
      this(2, var1, var2, var3);
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b, var2, false);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, 4, this.d, var2, false);
      zzbfp.a(var1, var3);
   }
}
