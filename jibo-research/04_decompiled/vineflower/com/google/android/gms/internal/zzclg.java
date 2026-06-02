package com.google.android.gms.internal;

import android.os.Bundle;

final class zzclg extends zzcgs {
   private zzclf a;

   zzclg(zzclf var1, zzcim var2) {
      this.a = var1;
      super(var2);
   }

   @Override
   public final void a() {
      zzclf var3 = this.a;
      var3.c();
      long var1 = var3.k().b();
      var3.t().E().a("Session started, time", var1);
      var3.u().l.a(false);
      var3.f().a("auto", "_s", new Bundle());
      var3.u().m.a(var3.k().a());
   }
}
