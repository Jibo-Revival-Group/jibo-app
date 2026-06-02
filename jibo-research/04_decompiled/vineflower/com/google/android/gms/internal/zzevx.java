package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

public class zzevx implements zzevw.zza {
   private zzevw a;
   private int b = 0;
   private boolean c = false;
   private WeakReference<zzevw.zza> d;

   protected zzevx(zzevw var1) {
      this.a = var1;
      this.d = new WeakReference<>(this);
   }

   @Override
   public final void b(int var1) {
      this.b |= var1;
   }

   protected final void c(int var1) {
      this.a.a(1);
   }

   protected final void e() {
      if (!this.c) {
         this.b = this.a.b();
         this.a.a(this.d);
         this.c = true;
      }
   }

   protected final void f() {
      if (this.c) {
         this.a.b(this.d);
         this.c = false;
      }
   }

   public final int g() {
      return this.b;
   }
}
