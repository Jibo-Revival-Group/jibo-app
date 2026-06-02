package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;

final class zzctw extends ContentObserver {
   private zzctv a;

   zzctw(zzctv var1, Handler var2) {
      this.a = var1;
      super(null);
   }

   public final void onChange(boolean var1) {
      this.a.b();
   }
}
