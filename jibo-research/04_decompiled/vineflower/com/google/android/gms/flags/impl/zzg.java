package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzg implements Callable<Long> {
   private SharedPreferences a;
   private String b;
   private Long c;

   zzg(SharedPreferences var1, String var2, Long var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      super();
   }
}
