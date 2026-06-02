package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class zzx implements zzcd {
   private zzv a;

   private zzx(zzv var1) {
      this.a = var1;
      super();
   }

   @Override
   public final void a(int var1, boolean var2) {
      zzv.a(this.a).lock();

      try {
         if (!zzv.c(this.a) && zzv.d(this.a) != null && zzv.d(this.a).b()) {
            zzv.a(this.a, true);
            zzv.e(this.a).a(var1);
         } else {
            zzv.a(this.a, false);
            zzv.a(this.a, var1, var2);
         }
      } finally {
         zzv.a(this.a).unlock();
      }
   }

   @Override
   public final void a(Bundle var1) {
      zzv.a(this.a).lock();

      try {
         zzv.a(this.a, var1);
         zzv.a(this.a, ConnectionResult.a);
         zzv.b(this.a);
      } finally {
         zzv.a(this.a).unlock();
      }
   }

   @Override
   public final void a(ConnectionResult var1) {
      zzv.a(this.a).lock();

      try {
         zzv.a(this.a, var1);
         zzv.b(this.a);
      } finally {
         zzv.a(this.a).unlock();
      }
   }
}
