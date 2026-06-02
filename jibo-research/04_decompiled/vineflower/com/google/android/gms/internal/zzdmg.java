package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;

final class zzdmg extends ContentObserver {
   zzdmg(Handler var1) {
      super(null);
   }

   public final void onChange(boolean var1) {
      zzdmf.a().set(true);
   }
}
