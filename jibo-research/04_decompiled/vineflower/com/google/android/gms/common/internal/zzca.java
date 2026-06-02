package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.R;

public final class zzca {
   private final Resources a;
   private final String b;

   public zzca(Context var1) {
      zzbq.a(var1);
      this.a = var1.getResources();
      this.b = this.a.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
   }

   public final String a(String var1) {
      int var2 = this.a.getIdentifier(var1, "string", this.b);
      if (var2 == 0) {
         var1 = null;
      } else {
         var1 = this.a.getString(var2);
      }

      return var1;
   }
}
