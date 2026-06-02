package com.google.android.gms.internal;

import android.content.Intent;

// $VF: synthetic class
final class zzclb implements Runnable {
   private final zzcla a;
   private final int b;
   private final zzchm c;
   private final Intent d;

   zzclb(zzcla var1, int var2, zzchm var3, Intent var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   @Override
   public final void run() {
      this.a.a(this.b, this.c, this.d);
   }
}
