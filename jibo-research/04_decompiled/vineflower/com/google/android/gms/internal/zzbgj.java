package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;

public final class zzbgj extends zzbfm implements zzbgp<String, Integer> {
   public static final Creator<zzbgj> CREATOR = new zzbgl();
   private int a;
   private final HashMap<String, Integer> b;
   private final SparseArray<String> c;
   private final ArrayList<zzbgk> d;

   public zzbgj() {
      this.a = 1;
      this.b = new HashMap<>();
      this.c = new SparseArray();
      this.d = null;
   }

   zzbgj(int var1, ArrayList<zzbgk> var2) {
      this.a = var1;
      this.b = new HashMap<>();
      this.c = new SparseArray();
      this.d = null;
      this.a(var2);
   }

   private final void a(ArrayList<zzbgk> var1) {
      var1 = var1;
      int var3 = var1.size();
      int var2 = 0;

      while (var2 < var3) {
         zzbgk var4 = (zzbgk)var1.get(var2);
         var2++;
         var4 = var4;
         this.a(var4.a, var4.b);
      }
   }

   public final zzbgj a(String var1, int var2) {
      this.b.put(var1, var2);
      this.c.put(var2, var1);
      return this;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      ArrayList var5 = new ArrayList();

      for (String var3 : this.b.keySet()) {
         var5.add(new zzbgk(var3, this.b.get(var3)));
      }

      zzbfp.c(var1, 2, var5, false);
      zzbfp.a(var1, var2);
   }
}
