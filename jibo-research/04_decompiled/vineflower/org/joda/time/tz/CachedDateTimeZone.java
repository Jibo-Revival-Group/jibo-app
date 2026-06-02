package org.joda.time.tz;

import org.joda.time.DateTimeZone;

public class CachedDateTimeZone extends DateTimeZone {
   private static final int b;
   private final DateTimeZone c;
   private final transient CachedDateTimeZone.Info[] d;

   static {
      Integer var2;
      try {
         var2 = Integer.getInteger("org.joda.time.tz.CachedDateTimeZone.size");
      } catch (SecurityException var3) {
         var2 = null;
      }

      int var0;
      if (var2 == null) {
         var0 = 512;
      } else {
         var0 = var2 - 1;
         int var1 = 0;

         while (var0 > 0) {
            var1++;
            var0 >>= 1;
         }

         var0 = 1 << var1;
      }

      b = var0 - 1;
   }

   private CachedDateTimeZone(DateTimeZone var1) {
      super(var1.e());
      this.d = new CachedDateTimeZone.Info[b + 1];
      this.c = var1;
   }

   public static CachedDateTimeZone a(DateTimeZone var0) {
      if (var0 instanceof CachedDateTimeZone) {
         var0 = var0;
      } else {
         var0 = new CachedDateTimeZone(var0);
      }

      return var0;
   }

   private CachedDateTimeZone.Info i(long var1) {
      int var3 = (int)(var1 >> 32);
      CachedDateTimeZone.Info[] var7 = this.d;
      int var4 = var3 & b;
      CachedDateTimeZone.Info var6 = var7[var4];
      if (var6 != null) {
         CachedDateTimeZone.Info var5 = var6;
         if ((int)(var6.a >> 32) == var3) {
            return var5;
         }
      }

      CachedDateTimeZone.Info var8 = this.j(var1);
      var7[var4] = var8;
      return var8;
   }

   private CachedDateTimeZone.Info j(long var1) {
      long var3 = var1 & -4294967296L;
      CachedDateTimeZone.Info var8 = new CachedDateTimeZone.Info(this.c, var3);
      CachedDateTimeZone.Info var7 = var8;
      var1 = var3;

      while (true) {
         long var5 = var1;
         var1 = this.c.g(var5);
         if (var1 == var5 || var1 > (var3 | 4294967295L)) {
            return var8;
         }

         CachedDateTimeZone.Info var9 = new CachedDateTimeZone.Info(this.c, var1);
         var7.c = var9;
         var7 = var9;
      }
   }

   @Override
   public String a(long var1) {
      return this.i(var1).a(var1);
   }

   @Override
   public int b(long var1) {
      return this.i(var1).b(var1);
   }

   @Override
   public int c(long var1) {
      return this.i(var1).c(var1);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else if (var1 instanceof CachedDateTimeZone) {
         var2 = this.c.equals(((CachedDateTimeZone)var1).c);
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public boolean f() {
      return this.c.f();
   }

   @Override
   public long g(long var1) {
      return this.c.g(var1);
   }

   @Override
   public long h(long var1) {
      return this.c.h(var1);
   }

   @Override
   public int hashCode() {
      return this.c.hashCode();
   }

   private static final class Info {
      public final long a;
      public final DateTimeZone b;
      CachedDateTimeZone.Info c;
      private String d;
      private int e = Integer.MIN_VALUE;
      private int f = Integer.MIN_VALUE;

      Info(DateTimeZone var1, long var2) {
         this.a = var2;
         this.b = var1;
      }

      public String a(long var1) {
         String var3;
         if (this.c != null && var1 >= this.c.a) {
            var3 = this.c.a(var1);
         } else {
            if (this.d == null) {
               this.d = this.b.a(this.a);
            }

            var3 = this.d;
         }

         return var3;
      }

      public int b(long var1) {
         int var3;
         if (this.c != null && var1 >= this.c.a) {
            var3 = this.c.b(var1);
         } else {
            if (this.e == Integer.MIN_VALUE) {
               this.e = this.b.b(this.a);
            }

            var3 = this.e;
         }

         return var3;
      }

      public int c(long var1) {
         int var3;
         if (this.c != null && var1 >= this.c.a) {
            var3 = this.c.c(var1);
         } else {
            if (this.f == Integer.MIN_VALUE) {
               this.f = this.b.c(this.a);
            }

            var3 = this.f;
         }

         return var3;
      }
   }
}
