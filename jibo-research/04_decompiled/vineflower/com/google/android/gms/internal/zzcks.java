package com.google.android.gms.internal;

final class zzcks implements Runnable {
   private boolean a;
   private zzcln b;
   private zzcgi c;
   private zzckg d;

   zzcks(zzckg var1, boolean var2, zzcln var3, zzcgi var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      super();
   }

   @Override
   public final void run() {
      zzche var3 = zzckg.d(this.d);
      if (var3 == null) {
         this.d.t().y().a("Discarding data. Failed to set user attribute");
      } else {
         zzckg var2 = this.d;
         zzcln var1;
         if (this.a) {
            var1 = null;
         } else {
            var1 = this.b;
         }

         var2.a(var3, var1, this.c);
         zzckg.e(this.d);
      }
   }
}
