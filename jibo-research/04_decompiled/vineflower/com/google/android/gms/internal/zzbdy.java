package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import java.util.ArrayList;

public final class zzbdy {
   @Deprecated
   public static final Api<Object> a = new Api<>("ClearcutLogger.API", zzbdy.c, zzbdy.b);
   private static Api.zzf<zzbeo> b = new Api.zzf<>();
   private static Api.zza<zzbeo, Object> c = new zzbdz();
   private static final zzctx[] d = new zzctx[0];
   private static final String[] e = new String[0];
   private static final byte[][] f = new byte[0][];
   private final String g;
   private final int h;
   private String i;
   private int j = -1;
   private String k;
   private String l;
   private final boolean m;
   private int n = 0;
   private final zzbee o;
   private final zzd p;
   private zzbed q;
   private final zzbeb r;

   public zzbdy(Context var1, int var2, String var3, String var4, String var5, boolean var6, zzbee var7, zzd var8, zzbed var9, zzbeb var10) {
      this.g = var1.getPackageName();
      this.h = a(var1);
      this.j = -1;
      this.i = var3;
      this.k = null;
      this.l = null;
      this.m = true;
      this.o = var7;
      this.p = var8;
      this.q = new zzbed();
      this.n = 0;
      this.r = var10;
      zzbq.b(true, "can't be anonymous with an upload account");
   }

   private static int a(Context var0) {
      byte var1 = 0;

      int var2;
      try {
         var2 = var0.getPackageManager().getPackageInfo(var0.getPackageName(), 0).versionCode;
      } catch (NameNotFoundException var3) {
         Log.wtf("ClearcutLogger", "This can't happen.");
         return var1;
      }

      return var2;
   }

   private static int[] b(ArrayList<Integer> var0) {
      int[] var6;
      if (var0 == null) {
         var6 = null;
      } else {
         int[] var4 = new int[var0.size()];
         ArrayList var5 = var0;
         int var3 = var5.size();
         int var2 = 0;

         for (int var1 = 0; var2 < var3; var1++) {
            Object var7 = var5.get(var2);
            var2++;
            var4[var1] = (Integer)var7;
         }

         var6 = var4;
      }

      return var6;
   }

   public final zzbea a(byte[] var1) {
      return new zzbea(this, var1, null);
   }
}
