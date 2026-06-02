package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzi implements Callable<String> {
   private SharedPreferences a;
   private String b;
   private String c;

   zzi(SharedPreferences var1, String var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      super();
   }
}
