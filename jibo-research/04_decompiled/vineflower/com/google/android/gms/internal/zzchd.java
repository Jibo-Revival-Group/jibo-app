package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;

public final class zzchd<V> {
   private final V a;
   private final zzbey<V> b;
   private final String c;

   private zzchd(String var1, zzbey<V> var2, V var3) {
      zzbq.a(var2);
      this.b = var2;
      this.a = (V)var3;
      this.c = var1;
   }

   static zzchd<Integer> a(String var0, int var1, int var2) {
      return new zzchd<>(var0, zzbey.a(var0, var2), var1);
   }

   static zzchd<Long> a(String var0, long var1, long var3) {
      return new zzchd<>(var0, zzbey.a(var0, var3), var1);
   }

   static zzchd<String> a(String var0, String var1, String var2) {
      return new zzchd<>(var0, zzbey.a(var0, var2), var1);
   }

   static zzchd<Boolean> a(String var0, boolean var1, boolean var2) {
      return new zzchd<>(var0, zzbey.a(var0, var2), var1);
   }

   public final V a(V var1) {
      if (var1 == null) {
         var1 = this.a;
      }

      return (V)var1;
   }

   public final String a() {
      return this.c;
   }

   public final V b() {
      return this.a;
   }
}
