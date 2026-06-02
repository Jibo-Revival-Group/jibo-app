package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.util.List;
import java.util.Map;

final class zzcht implements Runnable {
   private final zzchs a;
   private final int b;
   private final Throwable c;
   private final byte[] d;
   private final String e;
   private final Map<String, List<String>> f;

   private zzcht(String var1, zzchs var2, int var3, Throwable var4, byte[] var5, Map<String, List<String>> var6) {
      zzbq.a(var2);
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var1;
      this.f = var6;
   }

   @Override
   public final void run() {
      this.a.a(this.e, this.b, this.c, this.d, this.f);
   }
}
