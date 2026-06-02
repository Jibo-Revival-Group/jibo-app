package com.google.android.gms.internal;

final class zzewc implements Runnable {
   private zzewv a;
   private int b;
   private zzevz c;

   zzewc(zzevz var1, zzewv var2, int var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
      super();
   }

   @Override
   public final void run() {
      zzevz.a(this.c, this.a, this.b);
   }
}
