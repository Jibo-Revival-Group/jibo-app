package com.fasterxml.jackson.core.sym;

import java.util.concurrent.atomic.AtomicReference;

@Deprecated
public final class BytesToNameCanonicalizer {
   protected final BytesToNameCanonicalizer a;
   protected final AtomicReference<BytesToNameCanonicalizer.TableInfo> b;
   protected boolean c;
   protected final boolean d;
   private final int e;

   private BytesToNameCanonicalizer(int var1, boolean var2, int var3, boolean var4) {
      byte var5 = 16;
      super();
      this.a = null;
      this.e = var3;
      this.c = var2;
      this.d = var4;
      if (var1 < 16) {
         var3 = 16;
      } else {
         var3 = var1;
         if ((var1 - 1 & var1) != 0) {
            var3 = var5;

            while (var3 < var1) {
               var3 += var3;
            }
         }
      }

      this.b = new AtomicReference<>(this.b(var3));
   }

   public static BytesToNameCanonicalizer a() {
      long var1 = System.currentTimeMillis();
      int var0 = (int)var1;
      return a((int)(var1 >>> 32) + var0 | 1);
   }

   protected static BytesToNameCanonicalizer a(int var0) {
      return new BytesToNameCanonicalizer(64, true, var0, true);
   }

   private BytesToNameCanonicalizer.TableInfo b(int var1) {
      return new BytesToNameCanonicalizer.TableInfo(0, var1 - 1, new int[var1], new Name[var1], null, 0, 0, 0);
   }

   private static final class Bucket {
   }

   private static final class TableInfo {
      public final int a;
      public final int b;
      public final int[] c;
      public final Name[] d;
      public final BytesToNameCanonicalizer.Bucket[] e;
      public final int f;
      public final int g;
      public final int h;

      public TableInfo(int var1, int var2, int[] var3, Name[] var4, BytesToNameCanonicalizer.Bucket[] var5, int var6, int var7, int var8) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
         this.g = var7;
         this.h = var8;
      }
   }
}
