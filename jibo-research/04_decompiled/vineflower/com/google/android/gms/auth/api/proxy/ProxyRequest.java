package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public class ProxyRequest extends zzbfm {
   public static final Creator<ProxyRequest> CREATOR = new zza();
   public static final int a = 0;
   public static final int b = 1;
   public static final int c = 2;
   public static final int d = 3;
   public static final int e = 4;
   public static final int f = 5;
   public static final int g = 6;
   public static final int h = 7;
   public static final int i = 7;
   public final String j;
   public final int k;
   public final long l;
   public final byte[] m;
   private int n;
   private Bundle o;

   ProxyRequest(int var1, String var2, int var3, long var4, byte[] var6, Bundle var7) {
      this.n = var1;
      this.j = var2;
      this.k = var3;
      this.l = var4;
      this.m = var6;
      this.o = var7;
   }

   @Override
   public String toString() {
      String var2 = this.j;
      int var1 = this.k;
      return new StringBuilder(String.valueOf(var2).length() + 42)
         .append("ProxyRequest[ url: ")
         .append(var2)
         .append(", method: ")
         .append(var1)
         .append(" ]")
         .toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.j, false);
      zzbfp.a(var1, 2, this.k);
      zzbfp.a(var1, 3, this.l);
      zzbfp.a(var1, 4, this.m, false);
      zzbfp.a(var1, 5, this.o, false);
      zzbfp.a(var1, 1000, this.n);
      zzbfp.a(var1, var2);
   }
}
