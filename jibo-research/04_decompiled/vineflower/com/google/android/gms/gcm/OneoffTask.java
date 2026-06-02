package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask extends Task {
   public static final Creator<OneoffTask> CREATOR = new zzf();
   private final long a;
   private final long b;

   @Deprecated
   private OneoffTask(Parcel var1) {
      super(var1);
      this.a = var1.readLong();
      this.b = var1.readLong();
   }

   public long a() {
      return this.a;
   }

   public long b() {
      return this.b;
   }

   @Override
   public String toString() {
      String var5 = super.toString();
      long var1 = this.a();
      long var3 = this.b();
      return new StringBuilder(String.valueOf(var5).length() + 64)
         .append(var5)
         .append(" windowStart=")
         .append(var1)
         .append(" windowEnd=")
         .append(var3)
         .toString();
   }

   @Override
   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeLong(this.a);
      var1.writeLong(this.b);
   }
}
