package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.zzbq;

class zzchv extends BroadcastReceiver {
   private static String a = zzchv.class.getName();
   private final zzcim b;
   private boolean c;
   private boolean d;

   zzchv(zzcim var1) {
      zzbq.a(var1);
      this.b = var1;
   }

   public final void a() {
      this.b.a();
      this.b.h().c();
      if (!this.c) {
         this.b.t().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
         this.d = this.b.s().y();
         this.b.f().E().a("Registering connectivity change receiver. Network connected", this.d);
         this.c = true;
      }
   }

   public final void b() {
      this.b.a();
      this.b.h().c();
      this.b.h().c();
      if (this.c) {
         this.b.f().E().a("Unregistering connectivity change receiver");
         this.c = false;
         this.d = false;
         Context var1 = this.b.t();

         try {
            var1.unregisterReceiver(this);
         } catch (IllegalArgumentException var2) {
            this.b.f().y().a("Failed to unregister the network broadcast receiver", var2);
         }
      }
   }

   public void onReceive(Context var1, Intent var2) {
      this.b.a();
      String var4 = var2.getAction();
      this.b.f().E().a("NetworkBroadcastReceiver received action", var4);
      if ("android.net.conn.CONNECTIVITY_CHANGE".equals(var4)) {
         boolean var3 = this.b.s().y();
         if (this.d != var3) {
            this.d = var3;
            this.b.h().a(new zzchw(this, var3));
         }
      } else {
         this.b.f().A().a("NetworkBroadcastReceiver received unknown action", var4);
      }
   }
}
