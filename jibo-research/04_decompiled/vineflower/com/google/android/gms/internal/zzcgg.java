package com.google.android.gms.internal;

final class zzcgg implements Runnable {
   private long a;
   private zzcgd b;

   zzcgg(zzcgd var1, long var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      zzcgd.a(this.b, this.a);
   }
}
