package com.google.android.gms.internal;

final class zzclj implements Runnable {
   private long a;
   private zzclf b;

   zzclj(zzclf var1, long var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      zzclf.b(this.b, this.a);
   }
}
