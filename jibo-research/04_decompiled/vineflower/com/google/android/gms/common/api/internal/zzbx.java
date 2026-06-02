package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zzbx extends BroadcastReceiver {
   private Context a;
   private final zzby b;

   public zzbx(zzby var1) {
      this.b = var1;
   }

   public final void a() {
      synchronized (this) {
         if (this.a != null) {
            this.a.unregisterReceiver(this);
         }

         this.a = null;
      }
   }

   public final void a(Context var1) {
      this.a = var1;
   }

   public final void onReceive(Context var1, Intent var2) {
      Uri var4 = var2.getData();
      String var3 = null;
      if (var4 != null) {
         var3 = var4.getSchemeSpecificPart();
      }

      if ("com.google.android.gms".equals(var3)) {
         this.b.a();
         this.a();
      }
   }
}
