package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public class AccountChangeEvent extends zzbfm {
   public static final Creator<AccountChangeEvent> CREATOR = new zza();
   private int a;
   private long b;
   private String c;
   private int d;
   private int e;
   private String f;

   AccountChangeEvent(int var1, long var2, String var4, int var5, int var6, String var7) {
      this.a = var1;
      this.b = var2;
      this.c = zzbq.a((String)var4);
      this.d = var5;
      this.e = var6;
      this.f = var7;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 != this) {
         if (var1 instanceof AccountChangeEvent) {
            var1 = var1;
            if (this.a != var1.a || this.b != var1.b || !zzbg.a(this.c, var1.c) || this.d != var1.d || this.e != var1.e || !zzbg.a(this.f, var1.f)) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d, this.e, this.f});
   }

   @Override
   public String toString() {
      String var2 = "UNKNOWN";
      switch (this.d) {
         case 1:
            var2 = "ADDED";
            break;
         case 2:
            var2 = "REMOVED";
            break;
         case 3:
            var2 = "RENAMED_FROM";
            break;
         case 4:
            var2 = "RENAMED_TO";
      }

      String var3 = this.c;
      String var4 = this.f;
      int var1 = this.e;
      return new StringBuilder(String.valueOf(var3).length() + 91 + String.valueOf(var2).length() + String.valueOf(var4).length())
         .append("AccountChangeEvent {accountName = ")
         .append(var3)
         .append(", changeType = ")
         .append(var2)
         .append(", changeData = ")
         .append(var4)
         .append(", eventIndex = ")
         .append(var1)
         .append("}")
         .toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, 3, this.c, false);
      zzbfp.a(var1, 4, this.d);
      zzbfp.a(var1, 5, this.e);
      zzbfp.a(var1, 6, this.f, false);
      zzbfp.a(var1, var2);
   }
}
