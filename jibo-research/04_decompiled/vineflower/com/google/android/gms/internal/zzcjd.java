package com.google.android.gms.internal;

final class zzcjd implements Runnable {
   private zzcha a;
   private String b;
   private zzcir c;

   zzcjd(zzcir var1, zzcha var2, String var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
      super();
   }

   @Override
   public final void run() {
      zzcir.a(this.c).G();
      zzcir.a(this.c).a(this.a, this.b);
   }
}
