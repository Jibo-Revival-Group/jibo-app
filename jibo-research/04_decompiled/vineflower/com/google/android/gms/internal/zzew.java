package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class zzew {
   private static final ClassLoader a = zzew.class.getClassLoader();

   private zzew() {
   }

   public static <T extends Parcelable> T a(Parcel var0, Creator<T> var1) {
      Parcelable var2;
      if (var0.readInt() == 0) {
         var2 = null;
      } else {
         var2 = (Parcelable)var1.createFromParcel(var0);
      }

      return (T)var2;
   }

   public static void a(Parcel var0, IInterface var1) {
      if (var1 == null) {
         var0.writeStrongBinder(null);
      } else {
         var0.writeStrongBinder(var1.asBinder());
      }
   }

   public static void a(Parcel var0, Parcelable var1) {
      if (var1 == null) {
         var0.writeInt(0);
      } else {
         var0.writeInt(1);
         var1.writeToParcel(var0, 0);
      }
   }

   public static void a(Parcel var0, boolean var1) {
      byte var2;
      if (var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      var0.writeInt(var2);
   }

   public static boolean a(Parcel var0) {
      boolean var1;
      if (var0.readInt() != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static void b(Parcel var0, Parcelable var1) {
      if (var1 == null) {
         var0.writeInt(0);
      } else {
         var0.writeInt(1);
         var1.writeToParcel(var0, 1);
      }
   }
}
