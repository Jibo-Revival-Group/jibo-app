package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.Comparator;

public class DetectedActivity extends zzbfm {
   public static final Creator<DetectedActivity> CREATOR = new zzd();
   private static Comparator<DetectedActivity> a = new zzc();
   private static int[] b = new int[]{9, 10};
   private static int[] c = new int[]{0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17};
   private int d;
   private int e;

   public DetectedActivity(int var1, int var2) {
      this.d = var1;
      this.e = var2;
   }

   public int a() {
      int var2 = this.d;
      int var1 = var2;
      if (var2 > 17) {
         var1 = 4;
      }

      return var1;
   }

   public int b() {
      return this.e;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 != null && this.getClass() == var1.getClass()) {
            var1 = var1;
            if (this.d != var1.d || this.e != var1.e) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return Arrays.hashCode(new Object[]{this.d, this.e});
   }

   @Override
   public String toString() {
      int var1 = this.a();
      String var2;
      switch (var1) {
         case 0:
            var2 = "IN_VEHICLE";
            break;
         case 1:
            var2 = "ON_BICYCLE";
            break;
         case 2:
            var2 = "ON_FOOT";
            break;
         case 3:
            var2 = "STILL";
            break;
         case 4:
            var2 = "UNKNOWN";
            break;
         case 5:
            var2 = "TILTING";
            break;
         case 6:
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         default:
            var2 = Integer.toString(var1);
            break;
         case 7:
            var2 = "WALKING";
            break;
         case 8:
            var2 = "RUNNING";
            break;
         case 16:
            var2 = "IN_ROAD_VEHICLE";
            break;
         case 17:
            var2 = "IN_RAIL_VEHICLE";
      }

      var1 = this.e;
      return new StringBuilder(String.valueOf(var2).length() + 48)
         .append("DetectedActivity [type=")
         .append(var2)
         .append(", confidence=")
         .append(var1)
         .append("]")
         .toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.d);
      zzbfp.a(var1, 2, this.e);
      zzbfp.a(var1, var2);
   }
}
