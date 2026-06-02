package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

final class zzau extends zzay {
   private final ArrayList<Api.zze> a;
   private zzao b;

   public zzau(zzao var1, ArrayList var2) {
      this.b = var1;
      super(var1, null);
      this.a = var2;
   }

   @Override
   public final void a() {
      zzao.d(this.b).d.c = zzao.g(this.b);
      ArrayList var4 = this.a;
      int var2 = var4.size();
      int var1 = 0;

      while (var1 < var2) {
         Object var3 = var4.get(var1);
         var1++;
         ((Api.zze)var3).a(zzao.h(this.b), zzao.d(this.b).d.c);
      }
   }
}
