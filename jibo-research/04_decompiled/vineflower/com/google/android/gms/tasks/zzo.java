package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

final class zzo implements Runnable {
   private zzn a;
   private Callable b;

   zzo(zzn var1, Callable var2) {
      this.a = var1;
      this.b = var2;
      super();
   }

   @Override
   public final void run() {
      try {
         this.a.a(this.b.call());
      } catch (Exception var2) {
         this.a.a(var2);
      }
   }
}
