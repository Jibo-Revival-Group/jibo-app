package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class zzbg extends zzby {
   private WeakReference<zzba> a;

   zzbg(zzba var1) {
      this.a = new WeakReference<>(var1);
   }

   @Override
   public final void a() {
      zzba var1 = this.a.get();
      if (var1 != null) {
         zzba.a(var1);
      }
   }
}
