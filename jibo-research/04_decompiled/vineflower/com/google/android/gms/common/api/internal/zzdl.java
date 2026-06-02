package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.zze;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

final class zzdl implements DeathRecipient, zzdm {
   private final WeakReference<BasePendingResult<?>> a;
   private final WeakReference<zze> b;
   private final WeakReference<IBinder> c;

   private zzdl(BasePendingResult<?> var1, zze var2, IBinder var3) {
      this.b = new WeakReference<>(var2);
      this.a = new WeakReference<>(var1);
      this.c = new WeakReference<>(var3);
   }

   private final void a() {
      BasePendingResult var2 = this.a.get();
      zze var1 = this.b.get();
      if (var1 != null && var2 != null) {
         var1.a(var2.c());
      }

      IBinder var4 = this.c.get();
      if (var4 != null) {
         try {
            var4.unlinkToDeath(this, 0);
         } catch (NoSuchElementException var3) {
         }
      }
   }

   @Override
   public final void a(BasePendingResult<?> var1) {
      this.a();
   }

   public final void binderDied() {
      this.a();
   }
}
