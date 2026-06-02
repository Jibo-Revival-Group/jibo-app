package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public class AccountChangeEventsRequest extends zzbfm {
   public static final Creator<AccountChangeEventsRequest> CREATOR = new zzb();
   private int a;
   private int b;
   @Deprecated
   private String c;
   private Account d;

   public AccountChangeEventsRequest() {
      this.a = 1;
   }

   AccountChangeEventsRequest(int var1, int var2, String var3, Account var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      if (var4 == null && !TextUtils.isEmpty(var3)) {
         this.d = new Account(var3, "com.google");
      } else {
         this.d = var4;
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, 3, this.c, false);
      zzbfp.a(var1, 4, this.d, var2, false);
      zzbfp.a(var1, var3);
   }
}
