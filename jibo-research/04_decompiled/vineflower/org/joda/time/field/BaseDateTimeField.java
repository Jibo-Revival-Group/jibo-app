package org.joda.time.field;

import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.ReadablePartial;

public abstract class BaseDateTimeField extends DateTimeField {
   private final DateTimeFieldType a;

   protected BaseDateTimeField(DateTimeFieldType var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("The type must not be null");
      }

      this.a = var1;
   }

   @Override
   public abstract int a(long var1);

   protected int a(String var1, Locale var2) {
      try {
         return Integer.parseInt(var1);
      } catch (NumberFormatException var4) {
         throw new IllegalFieldValueException(this.a(), var1);
      }
   }

   @Override
   public int a(Locale var1) {
      int var2 = this.h();
      if (var2 >= 0) {
         if (var2 < 10) {
            return 1;
         }

         if (var2 < 100) {
            return 2;
         }

         if (var2 < 1000) {
            return 3;
         }
      }

      return Integer.toString(var2).length();
   }

   @Override
   public long a(long var1, int var3) {
      return this.d().a(var1, var3);
   }

   @Override
   public long a(long var1, long var3) {
      return this.d().a(var1, var3);
   }

   @Override
   public long a(long var1, String var3, Locale var4) {
      return this.b(var1, this.a(var3, var4));
   }

   @Override
   public String a(int var1, Locale var2) {
      return Integer.toString(var1);
   }

   @Override
   public String a(long var1, Locale var3) {
      return this.a(this.a(var1), var3);
   }

   public String a(ReadablePartial var1, int var2, Locale var3) {
      return this.a(var2, var3);
   }

   @Override
   public final String a(ReadablePartial var1, Locale var2) {
      return this.a(var1, var1.a(this.a()), var2);
   }

   @Override
   public final DateTimeFieldType a() {
      return this.a;
   }

   @Override
   public abstract long b(long var1, int var3);

   @Override
   public final String b() {
      return this.a.x();
   }

   @Override
   public String b(int var1, Locale var2) {
      return this.a(var1, var2);
   }

   @Override
   public String b(long var1, Locale var3) {
      return this.b(this.a(var1), var3);
   }

   public String b(ReadablePartial var1, int var2, Locale var3) {
      return this.b(var2, var3);
   }

   @Override
   public final String b(ReadablePartial var1, Locale var2) {
      return this.b(var1, var1.a(this.a()), var2);
   }

   @Override
   public boolean b(long var1) {
      return false;
   }

   @Override
   public int c(long var1) {
      return this.h();
   }

   @Override
   public final boolean c() {
      return true;
   }

   @Override
   public abstract long d(long var1);

   @Override
   public abstract DurationField d();

   @Override
   public long e(long var1) {
      long var5 = this.d(var1);
      long var3 = var1;
      if (var5 != var1) {
         var3 = this.a(var5, 1);
      }

      return var3;
   }

   @Override
   public long f(long var1) {
      long var5 = this.d(var1);
      long var3 = this.e(var1);
      if (var1 - var5 <= var3 - var1) {
         var1 = var5;
      } else {
         var1 = var3;
      }

      return var1;
   }

   @Override
   public DurationField f() {
      return null;
   }

   @Override
   public long g(long var1) {
      long var3 = this.d(var1);
      long var5 = this.e(var1);
      if (var5 - var1 <= var1 - var3) {
         var1 = var5;
      } else {
         var1 = var3;
      }

      return var1;
   }

   @Override
   public abstract int h();

   @Override
   public long h(long var1) {
      long var5 = this.d(var1);
      long var3 = this.e(var1);
      long var7 = var1 - var5;
      var1 = var3 - var1;
      if (var7 < var1) {
         var1 = var5;
      } else if (var1 < var7) {
         var1 = var3;
      } else {
         var1 = var5;
         if ((this.a(var3) & 1) == 0) {
            var1 = var3;
         }
      }

      return var1;
   }

   @Override
   public long i(long var1) {
      return var1 - this.d(var1);
   }

   @Override
   public String toString() {
      return "DateTimeField[" + this.b() + ']';
   }
}
