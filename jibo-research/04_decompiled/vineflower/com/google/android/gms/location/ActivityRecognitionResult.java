package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ActivityRecognitionResult extends zzbfm implements ReflectedParcelable {
   public static final Creator<ActivityRecognitionResult> CREATOR = new zzb();
   private List<DetectedActivity> a;
   private long b;
   private long c;
   private int d;
   private Bundle e;

   public ActivityRecognitionResult(List<DetectedActivity> var1, long var2, long var4, int var6, Bundle var7) {
      boolean var9 = true;
      super();
      boolean var8;
      if (var1 != null && var1.size() > 0) {
         var8 = true;
      } else {
         var8 = false;
      }

      zzbq.b(var8, "Must have at least 1 detected activity");
      if (var2 > 0L && var4 > 0L) {
         var8 = var9;
      } else {
         var8 = false;
      }

      zzbq.b(var8, "Must set times");
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var6;
      this.e = var7;
   }

   private static boolean a(Bundle var0, Bundle var1) {
      boolean var2;
      if (var0 == null && var1 == null) {
         var2 = true;
      } else if ((var0 != null || var1 == null) && (var0 == null || var1 != null)) {
         if (var0.size() != var1.size()) {
            var2 = false;
         } else {
            Iterator var3 = var0.keySet().iterator();

            while (true) {
               if (!var3.hasNext()) {
                  var2 = true;
                  break;
               }

               String var4 = (String)var3.next();
               if (!var1.containsKey(var4)) {
                  var2 = false;
                  break;
               }

               if (var0.get(var4) == null) {
                  if (var1.get(var4) != null) {
                     var2 = false;
                     break;
                  }
               } else if (var0.get(var4) instanceof Bundle) {
                  if (!a(var0.getBundle(var4), var1.getBundle(var4))) {
                     var2 = false;
                     break;
                  }
               } else if (!var0.get(var4).equals(var1.get(var4))) {
                  var2 = false;
                  break;
               }
            }
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 != null && this.getClass() == var1.getClass()) {
            var1 = var1;
            if (this.b != var1.b || this.c != var1.c || this.d != var1.d || !zzbg.a(this.a, var1.a) || !a(this.e, var1.e)) {
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
      return Arrays.hashCode(new Object[]{this.b, this.c, this.d, this.a, this.e});
   }

   @Override
   public String toString() {
      String var5 = String.valueOf(this.a);
      long var1 = this.b;
      long var3 = this.c;
      return new StringBuilder(String.valueOf(var5).length() + 124)
         .append("ActivityRecognitionResult [probableActivities=")
         .append(var5)
         .append(", timeMillis=")
         .append(var1)
         .append(", elapsedRealtimeMillis=")
         .append(var3)
         .append("]")
         .toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.c(var1, 1, this.a, false);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, 4, this.d);
      zzbfp.a(var1, 5, this.e, false);
      zzbfp.a(var1, var2);
   }
}
