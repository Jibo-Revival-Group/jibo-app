package com.fasterxml.jackson.core.util;

public class BufferRecycler {
   private static final int[] c = new int[]{8000, 8000, 2000, 2000};
   private static final int[] d = new int[]{4000, 4000, 200, 200};
   protected final byte[][] a;
   protected final char[][] b;

   public BufferRecycler() {
      this(4, 4);
   }

   protected BufferRecycler(int var1, int var2) {
      this.a = new byte[var1][];
      this.b = new char[var2][];
   }

   public final void a(int var1, byte[] var2) {
      this.a[var1] = var2;
   }

   public void a(int var1, char[] var2) {
      this.b[var1] = var2;
   }

   public final byte[] a(int var1) {
      return this.a(var1, 0);
   }

   public byte[] a(int var1, int var2) {
      int var4 = this.c(var1);
      int var3 = var2;
      if (var2 < var4) {
         var3 = var4;
      }

      byte[] var5 = this.a[var1];
      if (var5 != null && var5.length >= var3) {
         this.a[var1] = null;
      } else {
         var5 = this.e(var3);
      }

      return var5;
   }

   public final char[] b(int var1) {
      return this.b(var1, 0);
   }

   public char[] b(int var1, int var2) {
      int var4 = this.d(var1);
      int var3 = var2;
      if (var2 < var4) {
         var3 = var4;
      }

      char[] var5 = this.b[var1];
      if (var5 != null && var5.length >= var3) {
         this.b[var1] = null;
      } else {
         var5 = this.f(var3);
      }

      return var5;
   }

   protected int c(int var1) {
      return c[var1];
   }

   protected int d(int var1) {
      return d[var1];
   }

   protected byte[] e(int var1) {
      return new byte[var1];
   }

   protected char[] f(int var1) {
      return new char[var1];
   }
}
