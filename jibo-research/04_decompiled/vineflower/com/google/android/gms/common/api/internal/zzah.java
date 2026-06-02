package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArraySet;
import com.google.android.gms.common.ConnectionResult;

public class zzah extends zzo {
   private final ArraySet<zzh<?>> e;
   private zzbm f;

   private final void i() {
      if (!this.e.isEmpty()) {
         this.f.a(this);
      }
   }

   @Override
   protected final void a(ConnectionResult var1, int var2) {
      this.f.b(var1, var2);
   }

   @Override
   public final void b() {
      super.b();
      this.i();
   }

   @Override
   public final void c() {
      super.c();
      this.i();
   }

   @Override
   public final void d() {
      super.d();
      this.f.b(this);
   }

   @Override
   protected final void f() {
      this.f.d();
   }

   final ArraySet<zzh<?>> g() {
      return this.e;
   }
}
