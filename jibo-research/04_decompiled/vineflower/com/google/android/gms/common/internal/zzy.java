package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.zzcf;

final class zzy extends zzv {
   private Intent a;
   private zzcf b;
   private int c;

   zzy(Intent var1, zzcf var2, int var3) {
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
