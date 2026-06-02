package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zzcxi;
import com.google.android.gms.internal.zzcxq;
import java.lang.ref.WeakReference;

final class zzav extends zzcxi {
   private final WeakReference<zzao> a;

   zzav(zzao var1) {
      this.a = new WeakReference<>(var1);
   }

   @Override
   public final void a(zzcxq var1) {
      zzao var2 = this.a.get();
      if (var2 != null) {
         zzao.d(var2).a(new zzaw(this, var2, var2, var1));
      }
   }
}
