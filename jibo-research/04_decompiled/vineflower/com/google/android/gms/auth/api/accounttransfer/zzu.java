package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArraySet;
import com.google.android.gms.internal.zzaxc;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzbgo;
import java.util.HashMap;
import java.util.Set;

public class zzu extends zzaxc {
   public static final Creator<zzu> CREATOR = new zzv();
   private static final HashMap<String, zzbgo<?, ?>> a;
   private Set<Integer> b;
   private int c;
   private String d;
   private int e;
   private byte[] f;
   private PendingIntent g;
   private DeviceMetaData h;

   static {
      HashMap var0 = new HashMap();
      a = var0;
      var0.put("accountType", zzbgo.b("accountType", 2));
      a.put("status", zzbgo.a("status", 3));
      a.put("transferBytes", zzbgo.d("transferBytes", 4));
   }

   public zzu() {
      this.b = new ArraySet<>(3);
      this.c = 1;
   }

   zzu(Set<Integer> var1, int var2, String var3, int var4, byte[] var5, PendingIntent var6, DeviceMetaData var7) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
      this.g = var6;
      this.h = var7;
   }

   @Override
   protected final boolean a(zzbgo var1) {
      return this.b.contains(var1.a());
   }

   @Override
   protected final Object b(zzbgo var1) {
      Object var3;
      switch (var1.a()) {
         case 1:
            var3 = this.c;
            break;
         case 2:
            var3 = this.d;
            break;
         case 3:
            var3 = this.e;
            break;
         case 4:
            var3 = this.f;
            break;
         default:
            int var2 = var1.a();
            throw new IllegalStateException(new StringBuilder(37).append("Unknown SafeParcelable id=").append(var2).toString());
      }

      return var3;
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      Set var4 = this.b;
      if (var4.contains(1)) {
         zzbfp.a(var1, 1, this.c);
      }

      if (var4.contains(2)) {
         zzbfp.a(var1, 2, this.d, true);
      }

      if (var4.contains(3)) {
         zzbfp.a(var1, 3, this.e);
      }

      if (var4.contains(4)) {
         zzbfp.a(var1, 4, this.f, true);
      }

      if (var4.contains(5)) {
         zzbfp.a(var1, 5, this.g, var2, true);
      }

      if (var4.contains(6)) {
         zzbfp.a(var1, 6, this.h, var2, true);
      }

      zzbfp.a(var1, var3);
   }
}
