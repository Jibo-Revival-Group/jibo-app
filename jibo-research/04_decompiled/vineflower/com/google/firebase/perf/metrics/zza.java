package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;

public class zza implements Parcelable {
   public static final Creator<zza> CREATOR = new zzb();
   private static final Map<String, zza> c = new HashMap<>();
   private final String a;
   private long b;

   private zza(Parcel var1) {
      this.a = var1.readString();
      this.b = var1.readLong();
   }

   public zza(String var1) {
      this.a = var1;
   }

   final long a() {
      return this.b;
   }

   public final void a(long var1) {
      this.b += var1;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.a);
      var1.writeLong(this.b);
   }
}
