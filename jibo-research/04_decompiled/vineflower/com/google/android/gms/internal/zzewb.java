package com.google.android.gms.internal;

final class zzewb implements Runnable {
   private zzewy a;
   private int b;
   private zzevz c;

   zzewb(zzevz var1, zzewy var2, int var3) {
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
