package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class IdToken extends zzbfm implements ReflectedParcelable {
   public static final Creator<IdToken> CREATOR = new zzi();
   private final String a;
   private final String b;

   public IdToken(String var1, String var2) {
      boolean var4 = true;
      super();
      boolean var3;
      if (!TextUtils.isEmpty(var1)) {
         var3 = true;
      } else {
         var3 = false;
      }

      zzbq.b(var3, "account type string cannot be null or empty");
      if (!TextUtils.isEmpty(var2)) {
         var3 = var4;
      } else {
         var3 = false;
      }

      zzbq.b(var3, "id token string cannot be null or empty");
      this.a = var1;
      this.b = var2;
   }

   public final String a() {
      return this.a;
   }

   public final String b() {
      return this.b;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a(), false);
      zzbfp.a(var1, 2, this.b(), false);
      zzbfp.a(var1, var2);
   }
}
