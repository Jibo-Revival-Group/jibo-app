package com.crashlytics.android.core;

import android.os.Process;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

class CLSUUID {
   private static final AtomicLong a = new AtomicLong(0L);
   private static String b;

   public CLSUUID(IdManager var1) {
      byte[] var2 = new byte[10];
      this.a(var2);
      this.b(var2);
      this.c(var2);
      String var3 = CommonUtils.a(var1.b());
      String var4 = CommonUtils.a(var2);
      b = String.format(Locale.US, "%s-%s-%s-%s", var4.substring(0, 12), var4.substring(12, 16), var4.subSequence(16, 20), var3.substring(0, 12))
         .toUpperCase(Locale.US);
   }

   private void a(byte[] var1) {
      long var2 = new Date().getTime();
      byte[] var4 = a(var2 / 1000L);
      var1[0] = var4[0];
      var1[1] = var4[1];
      var1[2] = var4[2];
      var1[3] = var4[3];
      var4 = b(var2 % 1000L);
      var1[4] = var4[0];
      var1[5] = var4[1];
   }

   private static byte[] a(long var0) {
      ByteBuffer var2 = ByteBuffer.allocate(4);
      var2.putInt((int)var0);
      var2.order(ByteOrder.BIG_ENDIAN);
      ((Buffer)var2).position(0);
      return var2.array();
   }

   private void b(byte[] var1) {
      byte[] var2 = b(a.incrementAndGet());
      var1[6] = var2[0];
      var1[7] = var2[1];
   }

   private static byte[] b(long var0) {
      ByteBuffer var2 = ByteBuffer.allocate(2);
      var2.putShort((short)var0);
      var2.order(ByteOrder.BIG_ENDIAN);
      ((Buffer)var2).position(0);
      return var2.array();
   }

   private void c(byte[] var1) {
      byte[] var2 = b(Integer.valueOf(Process.myPid()).shortValue());
      var1[8] = var2[0];
      var1[9] = var2[1];
   }

   @Override
   public String toString() {
      return b;
   }
}
