package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzk implements Callable<SharedPreferences> {
   private Context a;

   zzk(Context var1) {
      this.a = var1;
      super();
   }
}
