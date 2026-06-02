package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.concurrent.TimeUnit;

public class zzewn implements Parcelable {
   public static final Creator<zzewn> CREATOR = new zzewo();
   private long a;
   private long b;

   public zzewn() {
      this.a = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
      this.b = System.nanoTime();
   }

   private zzewn(Parcel var1) {
      this.a = var1.readLong();
      this.b = var1.readLong();
   }

   public final long a(zzewn var1) {
      return TimeUnit.NANOSECONDS.toMicros(var1.b - this.b);
   }

   public final void a() {
      this.a = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
      this.b = System.nanoTime();
   }

   public final long b() {
      return this.a;
   }

   public final long c() {
      return TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - this.b);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeLong(this.a);
      var1.writeLong(this.b);
   }
}
