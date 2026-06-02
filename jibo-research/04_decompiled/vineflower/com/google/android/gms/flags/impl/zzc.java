package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzc implements Callable<Boolean> {
   private SharedPreferences a;
   private String b;
   private Boolean c;

   zzc(SharedPreferences var1, String var2, Boolean var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      super();
   }
}
