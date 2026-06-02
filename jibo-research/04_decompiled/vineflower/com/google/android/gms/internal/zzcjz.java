package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzcjz implements Runnable {
   private AtomicReference a;
   private zzcjn b;

   zzcjz(zzcjn var1, AtomicReference var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      this.b.i().a(this.a);
   }
}
