package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzbhb implements ThreadFactory {
   private final String a;
   private final int b;
   private final AtomicInteger c = new AtomicInteger();
   private final ThreadFactory d = Executors.defaultThreadFactory();

   public zzbhb(String var1) {
      this(var1, 0);
   }

   private zzbhb(String var1, int var2) {
      this.a = zzbq.a(var1, "Name must not be null");
      this.b = 0;
   }

   @Override
   public final Thread newThread(Runnable var1) {
      var1 = this.d.newThread(new zzbhc(var1, 0));
      String var3 = this.a;
      int var2 = this.c.getAndIncrement();
      var1.setName(new StringBuilder(String.valueOf(var3).length() + 13).append(var3).append("[").append(var2).append("]").toString());
      return var1;
   }
}
