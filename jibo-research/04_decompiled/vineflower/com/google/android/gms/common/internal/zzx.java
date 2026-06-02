package com.google.android.gms.common.internal;

import android.content.Intent;
import android.support.v4.app.Fragment;

final class zzx extends zzv {
   private Intent a;
   private Fragment b;
   private int c;

   zzx(Intent var1, Fragment var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      super();
   }

   @Override
   public final void a() {
      if (this.a != null) {
         this.b.startActivityForResult(this.a, this.c);
      }
   }
}
