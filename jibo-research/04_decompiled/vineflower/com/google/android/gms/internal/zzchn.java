package com.google.android.gms.internal;

final class zzchn implements Runnable {
   private String a;
   private zzchm b;

   zzchn(zzchm var1, String var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      zzchx var1 = this.b.p.e();
      if (!var1.P()) {
         this.b.a(6, "Persisted config not initialized. Not logging error/warn");
      } else {
         var1.b.a(this.a, 1L);
      }
   }
}
