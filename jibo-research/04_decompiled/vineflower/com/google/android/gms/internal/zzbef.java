package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class zzbef extends zzbfm {
   public static final Creator<zzbef> CREATOR = new zzbeg();
   private boolean a;
   private long b;
   private long c;

   public zzbef(boolean var1, long var2, long var4) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof zzbef) {
            var1 = var1;
            if (this.a != var1.a || this.b != var1.b || this.c != var1.c) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
   }

   @Override
   public final String toString() {
      return "CollectForDebugParcelable[skipPersistentStorage: "
         + this.a
         + ",collectForDebugStartTimeMillis: "
         + this.b
         + ",collectForDebugExpiryTimeMillis: "
         + this.c
         + "]";
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.c);
      zzbfp.a(var1, 3, this.b);
      zzbfp.a(var1, var2);
   }
}
