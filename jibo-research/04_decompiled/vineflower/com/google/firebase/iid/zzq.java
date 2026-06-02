package com.google.firebase.iid;

import android.os.Bundle;

final class zzq extends zzr<Void> {
   zzq(int var1, int var2, Bundle var3) {
      super(var1, 2, var3);
   }

   @Override
   final void a(Bundle var1) {
      if (var1.getBoolean("ack", false)) {
         this.a((Object)null);
      } else {
         this.a(new zzs(4, "Invalid response to one way request"));
      }
   }

   @Override
   final boolean a() {
      return true;
   }
}
