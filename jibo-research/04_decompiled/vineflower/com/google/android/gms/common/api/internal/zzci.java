package com.google.android.gms.common.api.internal;

import android.os.Message;

public final class zzci<L> {
   private final zzcj a;
   private volatile L b;

   public final void a() {
      this.b = null;
   }

   public final void a(zzcl<? super L> var1) {
      com.google.android.gms.common.internal.zzbq.a(var1, "Notifier must not be null");
      Message var2 = this.a.obtainMessage(1, var1);
      this.a.sendMessage(var2);
   }

   final void b(zzcl<? super L> var1) {
      Object var2 = this.b;
      if (var2 == null) {
         var1.a();
      } else {
         try {
            var1.a(var2);
         } catch (RuntimeException var3) {
            var1.a();
            throw var3;
         }
      }
   }
}
