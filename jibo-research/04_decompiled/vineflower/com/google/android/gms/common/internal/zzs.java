package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.support.v4.util.ArraySet;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzcxe;
import java.util.Collection;

public final class zzs {
   private Account a;
   private ArraySet<Scope> b;
   private int c = 0;
   private String d;
   private String e;
   private zzcxe f = zzcxe.a;

   public final zzr a() {
      return new zzr(this.a, this.b, null, 0, null, this.d, this.e, this.f);
   }

   public final zzs a(Account var1) {
      this.a = var1;
      return this;
   }

   public final zzs a(String var1) {
      this.d = var1;
      return this;
   }

   public final zzs a(Collection<Scope> var1) {
      if (this.b == null) {
         this.b = new ArraySet<>();
      }

      this.b.addAll(var1);
      return this;
   }

   public final zzs b(String var1) {
      this.e = var1;
      return this;
   }
}
