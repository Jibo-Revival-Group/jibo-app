package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;

public final class zzah {
   private final String a;
   private final String b;
   private final ComponentName c;
   private final int d;

   public zzah(ComponentName var1, int var2) {
      this.a = null;
      this.b = null;
      this.c = zzbq.a(var1);
      this.d = 129;
   }

   public zzah(String var1, String var2, int var3) {
      this.a = zzbq.a(var1);
      this.b = zzbq.a(var2);
      this.c = null;
      this.d = var3;
   }

   public final String a() {
      return this.b;
   }

   public final ComponentName b() {
      return this.c;
   }

   public final int c() {
      return this.d;
   }

   public final Intent d() {
      Intent var1;
      if (this.a != null) {
         var1 = new Intent(this.a).setPackage(this.b);
      } else {
         var1 = new Intent().setComponent(this.c);
      }

      return var1;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof zzah)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!zzbg.a(this.a, var1.a) || !zzbg.a(this.b, var1.b) || !zzbg.a(this.c, var1.c) || this.d != var1.d) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d});
   }

   @Override
   public final String toString() {
      String var1;
      if (this.a == null) {
         var1 = this.c.flattenToString();
      } else {
         var1 = this.a;
      }

      return var1;
   }
}
