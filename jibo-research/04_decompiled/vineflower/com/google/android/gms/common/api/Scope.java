package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class Scope extends zzbfm implements ReflectedParcelable {
   public static final Creator<Scope> CREATOR = new zzf();
   private int a;
   private final String b;

   Scope(int var1, String var2) {
      zzbq.a(var2, "scopeUri must not be null or empty");
      this.a = var1;
      this.b = var2;
   }

   public Scope(String var1) {
      this(1, var1);
   }

   public final String a() {
      return this.b;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else if (!(var1 instanceof Scope)) {
         var2 = false;
      } else {
         var2 = this.b.equals(((Scope)var1).b);
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return this.b.hashCode();
   }

   @Override
   public final String toString() {
      return this.b;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b, false);
      zzbfp.a(var1, var2);
   }
}
