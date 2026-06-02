package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask extends Task {
   public static final Creator<PeriodicTask> CREATOR = new zzh();
   protected long a = -1L;
   protected long b = -1L;

   @Deprecated
   private PeriodicTask(Parcel var1) {
      super(var1);
      this.a = var1.readLong();
      this.b = Math.min(var1.readLong(), this.a);
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
      return new StringBuilder(String.valueOf(var5).length() + 54).append(var5).append(" period=").append(var1).append(" flex=").append(var3).toString();
   }

   @Override
   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeLong(this.a);
      var1.writeLong(this.b);
   }
}
