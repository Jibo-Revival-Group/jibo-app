package com.fasterxml.jackson.core.util;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class ByteArrayBuilder extends OutputStream {
   public static final byte[] a = new byte[0];
   private final BufferRecycler b;
   private final LinkedList<byte[]> c = new LinkedList<>();
   private int d;
   private byte[] e;
   private int f;

   public ByteArrayBuilder() {
      this(null);
   }

   public ByteArrayBuilder(BufferRecycler var1) {
      this(var1, 500);
   }

   public ByteArrayBuilder(BufferRecycler var1, int var2) {
      this.b = var1;
      byte[] var3;
      if (var1 == null) {
         var3 = new byte[var2];
      } else {
         var3 = var1.a(2);
      }

      this.e = var3;
   }

   private void e() {
      int var1 = 262144;
      this.d = this.d + this.e.length;
      int var2 = Math.max(this.d >> 1, 1000);
      if (var2 <= 262144) {
         var1 = var2;
      }

      this.c.add(this.e);
      this.e = new byte[var1];
      this.f = 0;
   }

   public void a() {
      this.d = 0;
      this.f = 0;
      if (!this.c.isEmpty()) {
         this.c.clear();
      }
   }

   public void a(int var1) {
      if (this.f >= this.e.length) {
         this.e();
      }

      byte[] var3 = this.e;
      int var2 = this.f++;
      var3[var2] = (byte)var1;
   }

   public byte[] b() {
      int var2 = this.d + this.f;
      byte[] var4;
      if (var2 == 0) {
         var4 = a;
      } else {
         var4 = new byte[var2];
         Iterator var5 = this.c.iterator();
         int var1 = 0;

         while (var5.hasNext()) {
            byte[] var6 = (byte[])var5.next();
            int var3 = var6.length;
            System.arraycopy(var6, 0, var4, var1, var3);
            var1 += var3;
         }

         System.arraycopy(this.e, 0, var4, var1, this.f);
         var1 = this.f + var1;
         if (var1 != var2) {
            throw new RuntimeException("Internal error: total len assumed to be " + var2 + ", copied " + var1 + " bytes");
         }

         if (!this.c.isEmpty()) {
            this.a();
         }
      }

      return var4;
   }

   public byte[] b(int var1) {
      this.f = var1;
      return this.b();
   }

   public byte[] c() {
      this.a();
      return this.e;
   }

   @Override
   public void close() {
   }

   public byte[] d() {
      this.e();
      return this.e;
   }

   @Override
   public void flush() {
   }

   @Override
   public void write(int var1) {
      this.a(var1);
   }

   @Override
   public void write(byte[] var1) {
      this.write(var1, 0, var1.length);
   }

   @Override
   public void write(byte[] var1, int var2, int var3) {
      int var4 = var2;

      while (true) {
         int var6 = Math.min(this.e.length - this.f, var3);
         int var5 = var4;
         var2 = var3;
         if (var6 > 0) {
            System.arraycopy(var1, var4, this.e, this.f, var6);
            var5 = var4 + var6;
            this.f += var6;
            var2 = var3 - var6;
         }

         if (var2 <= 0) {
            return;
         }

         this.e();
         var4 = var5;
         var3 = var2;
      }
   }
}
