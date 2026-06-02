package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.internal.zzaxc;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzbgo;
import java.util.List;
import java.util.Map;

public class zzp extends zzaxc {
   public static final Creator<zzp> CREATOR = new zzq();
   private static final ArrayMap<String, zzbgo<?, ?>> a;
   private int b;
   private List<String> c;
   private List<String> d;
   private List<String> e;
   private List<String> f;
   private List<String> g;

   static {
      ArrayMap var0 = new ArrayMap();
      a = var0;
      var0.put("registered", zzbgo.c("registered", 2));
      a.put("in_progress", zzbgo.c("in_progress", 3));
      a.put("success", zzbgo.c("success", 4));
      a.put("failed", zzbgo.c("failed", 5));
      a.put("escrowed", zzbgo.c("escrowed", 6));
   }

   public zzp() {
      this.b = 1;
   }

   zzp(int var1, List<String> var2, List<String> var3, List<String> var4, List<String> var5, List<String> var6) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
      this.g = var6;
   }

   @Override
   public final Map<String, zzbgo<?, ?>> a() {
      return a;
   }

   @Override
   protected final boolean a(zzbgo var1) {
      return true;
   }

   @Override
   protected final Object b(zzbgo var1) {
      Object var3;
      switch (var1.a()) {
         case 1:
            var3 = this.b;
            break;
         case 2:
            var3 = this.c;
            break;
         case 3:
            var3 = this.d;
            break;
         case 4:
            var3 = this.e;
            break;
         case 5:
            var3 = this.f;
            break;
         case 6:
            var3 = this.g;
            break;
         default:
            int var2 = var1.a();
            throw new IllegalStateException(new StringBuilder(37).append("Unknown SafeParcelable id=").append(var2).toString());
      }

      return var3;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.b);
      zzbfp.b(var1, 2, this.c, false);
      zzbfp.b(var1, 3, this.d, false);
      zzbfp.b(var1, 4, this.e, false);
      zzbfp.b(var1, 5, this.f, false);
      zzbfp.b(var1, 6, this.g, false);
      zzbfp.a(var1, var2);
   }
}
