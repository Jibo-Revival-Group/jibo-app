package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.List;

public class TokenData extends zzbfm implements ReflectedParcelable {
   public static final Creator<TokenData> CREATOR = new zzk();
   private int a;
   private final String b;
   private final Long c;
   private final boolean d;
   private final boolean e;
   private final List<String> f;

   TokenData(int var1, String var2, Long var3, boolean var4, boolean var5, List<String> var6) {
      this.a = var1;
      this.b = zzbq.a(var2);
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
   }

   public static TokenData a(Bundle var0, String var1) {
      var0.setClassLoader(TokenData.class.getClassLoader());
      var0 = var0.getBundle(var1);
      TokenData var3;
      if (var0 == null) {
         var3 = null;
      } else {
         var0.setClassLoader(TokenData.class.getClassLoader());
         var3 = (TokenData)var0.getParcelable("TokenData");
      }

      return var3;
   }

   public final String a() {
      return this.b;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (!(var1 instanceof TokenData)) {
         var2 = var3;
      } else {
         var1 = var1;
         var2 = var3;
         if (TextUtils.equals(this.b, var1.b)) {
            var2 = var3;
            if (zzbg.a(this.c, var1.c)) {
               var2 = var3;
               if (this.d == var1.d) {
                  var2 = var3;
                  if (this.e == var1.e) {
                     var2 = var3;
                     if (zzbg.a(this.f, var1.f)) {
                        var2 = true;
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return Arrays.hashCode(new Object[]{this.b, this.c, this.d, this.e, this.f});
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b, false);
      zzbfp.a(var1, 3, this.c, false);
      zzbfp.a(var1, 4, this.d);
      zzbfp.a(var1, 5, this.e);
      zzbfp.b(var1, 6, this.f, false);
      zzbfp.a(var1, var2);
   }
}
