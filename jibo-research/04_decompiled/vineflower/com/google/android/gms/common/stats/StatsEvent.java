package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;

public abstract class StatsEvent extends zzbfm implements ReflectedParcelable {
   public abstract long a();

   public abstract int b();

   public abstract long c();

   public abstract String d();

   @Override
   public String toString() {
      long var2 = this.a();
      int var1 = this.b();
      long var4 = this.c();
      String var6 = this.d();
      return new StringBuilder(String.valueOf("\t").length() + 51 + String.valueOf("\t").length() + String.valueOf(var6).length())
         .append(var2)
         .append("\t")
         .append(var1)
         .append("\t")
         .append(var4)
         .append(var6)
         .toString();
   }
}
