package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class zzw extends zzv {
   private Intent a;
   private Activity b;
   private int c;

   zzw(Intent var1, Activity var2, int var3) {
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
