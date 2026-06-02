package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzfjs {
   protected volatile int I = -1;

   public static final <T extends zzfjs> T a(T var0, byte[] var1) throws zzfjr {
      return a((T)var0, var1, 0, var1.length);
   }

   private static <T extends zzfjs> T a(T var0, byte[] var1, int var2, int var3) throws zzfjr {
      try {
         zzfjj var6 = zzfjj.a(var1, 0, var3);
         var0.a(var6);
         var6.a(0);
         return (T)var0;
      } catch (zzfjr var4) {
         throw var4;
      } catch (IOException var5) {
         throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", var5);
      }
   }

   public static final byte[] a(zzfjs var0) {
      byte[] var3 = new byte[var0.f()];
      int var1 = var3.length;

      try {
         zzfjk var2 = zzfjk.a(var3, 0, var1);
         var0.a(var2);
         var2.a();
         return var3;
      } catch (IOException var4) {
         throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", var4);
      }
   }

   public abstract zzfjs a(zzfjj var1) throws IOException;

   public void a(zzfjk var1) throws IOException {
   }

   protected int b() {
      return 0;
   }

   public zzfjs d() throws CloneNotSupportedException {
      return (zzfjs)super.clone();
   }

   public final int e() {
      if (this.I < 0) {
         this.f();
      }

      return this.I;
   }

   public final int f() {
      int var1 = this.b();
      this.I = var1;
      return var1;
   }

   @Override
   public String toString() {
      return zzfjt.a(this);
   }
}
