package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zze implements Callable<Integer> {
   private SharedPreferences a;
   private String b;
   private Integer c;

   zze(SharedPreferences var1, String var2, Integer var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      super();
   }
}
