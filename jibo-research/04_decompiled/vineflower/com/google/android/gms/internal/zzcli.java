package com.google.android.gms.internal;

final class zzcli implements Runnable {
   private long a;
   private zzclf b;

   zzcli(zzclf var1, long var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      zzclf.a(this.b, this.a);
   }
}
