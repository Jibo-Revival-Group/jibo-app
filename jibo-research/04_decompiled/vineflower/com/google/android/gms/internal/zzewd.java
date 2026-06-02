package com.google.android.gms.internal;

final class zzewd implements Runnable {
   private boolean a;
   private zzevz b;

   zzewd(zzevz var1, boolean var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      this.b.b(this.a);
   }
}
