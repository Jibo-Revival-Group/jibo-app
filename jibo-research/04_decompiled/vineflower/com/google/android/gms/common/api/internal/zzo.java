package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzo extends LifecycleCallback implements OnCancelListener {
   protected volatile boolean b;
   protected final AtomicReference<zzp> c = new AtomicReference<>(null);
   protected final GoogleApiAvailability d;
   private final Handler e = new Handler(Looper.getMainLooper());

   protected zzo(zzcf var1) {
      this(var1, GoogleApiAvailability.a());
   }

   private zzo(zzcf var1, GoogleApiAvailability var2) {
      super(var1);
      this.d = var2;
   }

   private static int a(zzp var0) {
      int var1;
      if (var0 == null) {
         var1 = -1;
      } else {
         var1 = var0.a();
      }

      return var1;
   }

   @Override
   public final void a(int var1, int var2, Intent var3) {
      int var4 = 13;
      zzp var5 = this.c.get();
      boolean var6;
      zzp var9;
      switch (var1) {
         case 1:
            if (var2 == -1) {
               var6 = 1;
               var9 = var5;
               break;
            } else if (var2 == 0) {
               var6 = var4;
               if (var3 != null) {
                  var6 = var3.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
               }

               var9 = new zzp(new ConnectionResult(var6, null), a(var5));
               this.c.set(var9);
               var6 = 0;
               break;
            }
         default:
            var6 = 0;
            var9 = var5;
            break;
         case 2:
            var4 = this.d.a(this.a());
            boolean var8;
            if (var4 == 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            if (var5 == null) {
               return;
            }

            var9 = var5;
            var6 = var8;
            if (var5.b().c() == 18) {
               var9 = var5;
               var6 = var8;
               if (var4 == 18) {
                  return;
               }
            }
      }

      if (var6) {
         this.h();
      } else if (var9 != null) {
         this.a(var9.b(), var9.a());
      }
   }

   @Override
   public final void a(Bundle var1) {
      super.a(var1);
      if (var1 != null) {
         AtomicReference var2 = this.c;
         zzp var3;
         if (var1.getBoolean("resolving_error", false)) {
            var3 = new zzp(
               new ConnectionResult(var1.getInt("failed_status"), (PendingIntent)var1.getParcelable("failed_resolution")), var1.getInt("failed_client_id", -1)
            );
         } else {
            var3 = null;
         }

         var2.set(var3);
      }
   }

   protected abstract void a(ConnectionResult var1, int var2);

   @Override
   public void b() {
      super.b();
      this.b = true;
   }

   @Override
   public final void b(Bundle var1) {
      super.b(var1);
      zzp var2 = this.c.get();
      if (var2 != null) {
         var1.putBoolean("resolving_error", true);
         var1.putInt("failed_client_id", var2.a());
         var1.putInt("failed_status", var2.b().c());
         var1.putParcelable("failed_resolution", var2.b().d());
      }
   }

   public final void b(ConnectionResult var1, int var2) {
      zzp var3 = new zzp(var1, var2);
      if (this.c.compareAndSet(null, var3)) {
         this.e.post(new zzq(this, var3));
      }
   }

   @Override
   public void d() {
      super.d();
      this.b = false;
   }

   protected abstract void f();

   protected final void h() {
      this.c.set(null);
      this.f();
   }

   public void onCancel(DialogInterface var1) {
      this.a(new ConnectionResult(13, null), a(this.c.get()));
      this.h();
   }
}
