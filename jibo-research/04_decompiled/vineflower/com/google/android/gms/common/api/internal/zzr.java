package com.google.android.gms.common.api.internal;

import android.app.Dialog;

final class zzr extends zzby {
   private Dialog a;
   private zzq b;

   zzr(zzq var1, Dialog var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void a() {
      this.b.a.h();
      if (this.a.isShowing()) {
         this.a.dismiss();
      }
   }
}
