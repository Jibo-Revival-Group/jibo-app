package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class zzbgu extends zzbfm {
   public static final Creator<zzbgu> CREATOR = new zzbgx();
   final String a;
   private int b;
   private ArrayList<zzbgv> c;

   zzbgu(int var1, String var2, ArrayList<zzbgv> var3) {
      this.b = var1;
      this.a = var2;
      this.c = var3;
   }

   zzbgu(String var1, Map<String, zzbgo<?, ?>> var2) {
      this.b = 1;
      this.a = var1;
      ArrayList var5;
      if (var2 == null) {
         var5 = null;
      } else {
         var5 = new ArrayList();

         for (String var4 : var2.keySet()) {
            var5.add(new zzbgv(var4, (zzbgo<?, ?>)var2.get(var4)));
         }
      }

      this.c = var5;
   }

   final HashMap<String, zzbgo<?, ?>> a() {
      HashMap var4 = new HashMap();
      int var2 = this.c.size();

      for (int var1 = 0; var1 < var2; var1++) {
         zzbgv var3 = this.c.get(var1);
         var4.put(var3.a, var3.b);
      }

      return var4;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.b);
      zzbfp.a(var1, 2, this.a, false);
      zzbfp.c(var1, 3, this.c, false);
      zzbfp.a(var1, var2);
   }
}
