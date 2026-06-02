package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Iterator;

public final class zzcgx extends zzbfm implements Iterable<String> {
   public static final Creator<zzcgx> CREATOR = new zzcgz();
   private final Bundle a;

   zzcgx(Bundle var1) {
      this.a = var1;
   }

   public final int a() {
      return this.a.size();
   }

   final Object a(String var1) {
      return this.a.get(var1);
   }

   public final Bundle b() {
      return new Bundle(this.a);
   }

   final Long b(String var1) {
      return this.a.getLong(var1);
   }

   final Double c(String var1) {
      return this.a.getDouble(var1);
   }

   final String d(String var1) {
      return this.a.getString(var1);
   }

   @Override
   public final Iterator<String> iterator() {
      return new zzcgy(this);
   }

   @Override
   public final String toString() {
      return this.a.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.b(), false);
      zzbfp.a(var1, var2);
   }
}
