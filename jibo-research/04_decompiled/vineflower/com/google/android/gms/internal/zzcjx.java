package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzcjx implements Runnable {
   private AtomicReference a;
   private boolean b;
   private zzcjn c;

   zzcjx(zzcjn var1, AtomicReference var2, boolean var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
      super();
   }

   @Override
   public final void run() {
      this.c.i().a(this.a, this.b);
   }
}
