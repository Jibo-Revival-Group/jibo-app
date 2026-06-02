package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

final class zzq implements Runnable {
   final zzo a;
   private final zzp b;

   zzq(zzo var1, zzp var2) {
      this.a = var1;
      this.b = var2;
   }

   @Override
   public final void run() {
      if (this.a.b) {
         ConnectionResult var1 = this.b.b();
         if (var1.a()) {
            this.a.a.startActivityForResult(GoogleApiActivity.a(this.a.a(), var1.d(), this.b.a(), false), 1);
         } else if (this.a.d.a(var1.c())) {
            this.a.d.a(this.a.a(), this.a.a, var1.c(), 2, this.a);
         } else if (var1.c() == 18) {
            Dialog var2 = GoogleApiAvailability.a(this.a.a(), this.a);
            GoogleApiAvailability.a(this.a.a().getApplicationContext(), new zzr(this, var2));
         } else {
            this.a.a(var1, this.b.a());
         }
      }
   }
}
