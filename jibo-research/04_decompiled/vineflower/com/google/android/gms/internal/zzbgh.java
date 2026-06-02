package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzbgh extends zzbfm {
   public static final Creator<zzbgh> CREATOR = new zzbgi();
   private int a;
   private final zzbgj b;

   zzbgh(int var1, zzbgj var2) {
      this.a = var1;
      this.b = var2;
   }

   private zzbgh(zzbgj var1) {
      this.a = 1;
      this.b = var1;
   }

   public static zzbgh a(zzbgp<?, ?> var0) {
      if (var0 instanceof zzbgj) {
         return new zzbgh((zzbgj)var0);
      } else {
         throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
      }
   }

   public final zzbgp<?, ?> a() {
      if (this.b != null) {
         return this.b;
      } else {
         throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
      }
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b, var2, false);
      zzbfp.a(var1, var3);
   }
}
