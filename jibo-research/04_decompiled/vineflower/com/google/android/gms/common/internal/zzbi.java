package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzbi {
   private final List<String> a;
   private final Object b;

   private zzbi(Object var1) {
      this.b = zzbq.a(var1);
      this.a = new ArrayList<>();
   }

   public final zzbi a(String var1, Object var2) {
      List var3 = this.a;
      var1 = zzbq.a((String)var1);
      var2 = String.valueOf(var2);
      var3.add(new StringBuilder(String.valueOf(var1).length() + 1 + String.valueOf(var2).length()).append(var1).append("=").append(var2).toString());
      return this;
   }

   @Override
   public final String toString() {
      StringBuilder var3 = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
      int var2 = this.a.size();

      for (int var1 = 0; var1 < var2; var1++) {
         var3.append(this.a.get(var1));
         if (var1 < var2 - 1) {
            var3.append(", ");
         }
      }

      return var3.append('}').toString();
   }
}
