package org.joda.time.tz;

import org.joda.time.DateTimeZone;

public final class FixedDateTimeZone extends DateTimeZone {
   private final String b;
   private final int c;
   private final int d;

   public FixedDateTimeZone(String var1, String var2, int var3, int var4) {
      super(var1);
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   @Override
   public String a(long var1) {
      return this.b;
   }

   @Override
   public int b(long var1) {
      return this.c;
   }

   @Override
   public int c(long var1) {
      return this.d;
   }

   @Override
   public int e(long var1) {
      return this.c;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof FixedDateTimeZone) {
            var1 = var1;
            if (!this.e().equals(var1.e()) || this.d != var1.d || this.c != var1.c) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public boolean f() {
      return true;
   }

   @Override
   public long g(long var1) {
      return var1;
   }

   @Override
   public long h(long var1) {
      return var1;
   }

   @Override
   public int hashCode() {
      return this.e().hashCode() + this.d * 37 + this.c * 31;
   }
}
