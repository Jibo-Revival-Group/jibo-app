package com.google.firebase.iid;

import android.os.Bundle;

final class zzt extends zzr<Bundle> {
   zzt(int var1, int var2, Bundle var3) {
      super(var1, 1, var3);
   }

   @Override
   final void a(Bundle var1) {
      Bundle var2 = var1.getBundle("data");
      var1 = var2;
      if (var2 == null) {
         var1 = Bundle.EMPTY;
      }

      this.a((Bundle)var1);
   }

   @Override
   final boolean a() {
      return false;
   }
}
