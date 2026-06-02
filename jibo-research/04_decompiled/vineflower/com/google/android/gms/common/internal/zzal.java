package com.google.android.gms.common.internal;

public final class zzal {
   private static int a = 15;
   private static final String b = null;
   private final String c;
   private final String d;

   public zzal(String var1) {
      this(var1, null);
   }

   public zzal(String var1, String var2) {
      zzbq.a(var1, "log tag cannot be null");
      boolean var3;
      if (var1.length() <= 23) {
         var3 = true;
      } else {
         var3 = false;
      }

      zzbq.b(var3, "tag \"%s\" is longer than the %d character maximum", var1, 23);
      this.c = var1;
      if (var2 != null && var2.length() > 0) {
         this.d = var2;
      } else {
         this.d = null;
      }
   }
}
