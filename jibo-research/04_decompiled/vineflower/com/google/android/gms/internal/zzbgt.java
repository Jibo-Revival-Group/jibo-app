package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzbgt extends zzbfm {
   public static final Creator<zzbgt> CREATOR = new zzbgw();
   private int a;
   private final HashMap<String, Map<String, zzbgo<?, ?>>> b;
   private final ArrayList<zzbgu> c;
   private final String d;

   zzbgt(int var1, ArrayList<zzbgu> var2, String var3) {
      this.a = var1;
      this.c = null;
      HashMap var6 = new HashMap();
      int var4 = var2.size();

      for (int var7 = 0; var7 < var4; var7++) {
         zzbgu var5 = (zzbgu)var2.get(var7);
         var6.put(var5.a, var5.a());
      }

      this.b = var6;
      this.d = zzbq.a((String)var3);
      this.b();
   }

   private final void b() {
      for (String var2 : this.b.keySet()) {
         Map var3 = this.b.get(var2);
         Iterator var4 = var3.keySet().iterator();

         while (var4.hasNext()) {
            ((zzbgo)var3.get((String)var4.next())).a(this);
         }
      }
   }

   public final String a() {
      return this.d;
   }

   public final Map<String, zzbgo<?, ?>> a(String var1) {
      return this.b.get(var1);
   }

   @Override
   public final String toString() {
      StringBuilder var1 = new StringBuilder();

      for (String var3 : this.b.keySet()) {
         var1.append(var3).append(":\n");
         Map var4 = this.b.get(var3);

         for (String var5 : var4.keySet()) {
            var1.append("  ").append(var5).append(": ");
            var1.append(var4.get(var5));
         }
      }

      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      ArrayList var5 = new ArrayList();

      for (String var4 : this.b.keySet()) {
         var5.add(new zzbgu(var4, this.b.get(var4)));
      }

      zzbfp.c(var1, 2, var5, false);
      zzbfp.a(var1, 3, this.d, false);
      zzbfp.a(var1, var2);
   }
}
