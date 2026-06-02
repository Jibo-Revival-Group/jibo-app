package org.joda.time;

import java.util.Locale;

public abstract class DateTimeField {
   public abstract int a(long var1);

   public abstract int a(Locale var1);

   public abstract long a(long var1, int var3);

   public abstract long a(long var1, long var3);

   public abstract long a(long var1, String var3, Locale var4);

   public abstract String a(int var1, Locale var2);

   public abstract String a(long var1, Locale var3);

   public abstract String a(ReadablePartial var1, Locale var2);

   public abstract DateTimeFieldType a();

   public abstract long b(long var1, int var3);

   public abstract String b();

   public abstract String b(int var1, Locale var2);

   public abstract String b(long var1, Locale var3);

   public abstract String b(ReadablePartial var1, Locale var2);

   public abstract boolean b(long var1);

   public abstract int c(long var1);

   public long c(long var1, int var3) {
      return this.b(var1, var3);
   }

   public abstract boolean c();

   public abstract long d(long var1);

   public abstract DurationField d();

   public abstract long e(long var1);

   public abstract DurationField e();

   public abstract long f(long var1);

   public abstract DurationField f();

   public abstract int g();

   public abstract long g(long var1);

   public abstract int h();

   public abstract long h(long var1);

   public abstract long i(long var1);
}
