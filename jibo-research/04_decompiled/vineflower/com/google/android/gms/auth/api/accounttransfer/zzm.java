package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzaxc;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzbgo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class zzm extends zzaxc {
   public static final Creator<zzm> CREATOR = new zzn();
   private static final HashMap<String, zzbgo<?, ?>> a;
   private Set<Integer> b;
   private int c;
   private ArrayList<zzs> d;
   private int e;
   private zzp f;

   static {
      HashMap var0 = new HashMap();
      a = var0;
      var0.put("authenticatorData", zzbgo.b("authenticatorData", 2, zzs.class));
      a.put("progress", zzbgo.a("progress", 4, zzp.class));
   }

   public zzm() {
      this.b = new HashSet<>(1);
      this.c = 1;
   }

   zzm(Set<Integer> var1, int var2, ArrayList<zzs> var3, int var4, zzp var5) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
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
         default:
            int var2 = var1.a();
            throw new IllegalStateException(new StringBuilder(37).append("Unknown SafeParcelable id=").append(var2).toString());
         case 4:
            var3 = this.f;
      }

      return var3;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      Set var4 = this.b;
      if (var4.contains(1)) {
         zzbfp.a(var1, 1, this.c);
      }

      if (var4.contains(2)) {
         zzbfp.c(var1, 2, this.d, true);
      }

      if (var4.contains(3)) {
         zzbfp.a(var1, 3, this.e);
      }

      if (var4.contains(4)) {
         zzbfp.a(var1, 4, this.f, var2, true);
      }

      zzbfp.a(var1, var3);
   }
}
