package org.joda.time.field;

import java.io.Serializable;
import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;

public class DelegatedDateTimeField extends DateTimeField implements Serializable {
   private final DateTimeField a;
   private final DurationField b;
   private final DateTimeFieldType c;

   public DelegatedDateTimeField(DateTimeField var1) {
      this(var1, null);
   }

   public DelegatedDateTimeField(DateTimeField var1, DateTimeFieldType var2) {
      this(var1, null, var2);
   }

   public DelegatedDateTimeField(DateTimeField var1, DurationField var2, DateTimeFieldType var3) {
      if (var1 == null) {
         throw new IllegalArgumentException("The field must not be null");
      }

      this.a = var1;
      this.b = var2;
      DateTimeFieldType var4 = var3;
      if (var3 == null) {
         var4 = var1.a();
      }

      this.c = var4;
   }

   @Override
   public int a(long var1) {
      return this.a.a(var1);
   }

   @Override
   public int a(Locale var1) {
      return this.a.a(var1);
   }

   @Override
   public long a(long var1, int var3) {
      return this.a.a(var1, var3);
   }

   @Override
   public long a(long var1, long var3) {
      return this.a.a(var1, var3);
   }

   @Override
   public long a(long var1, String var3, Locale var4) {
      return this.a.a(var1, var3, var4);
   }

   @Override
   public String a(int var1, Locale var2) {
      return this.a.a(var1, var2);
   }

   @Override
   public String a(long var1, Locale var3) {
      return this.a.a(var1, var3);
   }

   @Override
   public String a(ReadablePartial var1, Locale var2) {
      return this.a.a(var1, var2);
   }

   @Override
   public DateTimeFieldType a() {
      return this.c;
   }

   @Override
   public long b(long var1, int var3) {
      return this.a.b(var1, var3);
   }

   @Override
   public String b() {
      return this.c.x();
   }

   @Override
   public String b(int var1, Locale var2) {
      return this.a.b(var1, var2);
   }

   @Override
   public String b(long var1, Locale var3) {
      return this.a.b(var1, var3);
   }

   @Override
   public String b(ReadablePartial var1, Locale var2) {
      return this.a.b(var1, var2);
   }

   @Override
   public boolean b(long var1) {
      return this.a.b(var1);
   }

   @Override
   public int c(long var1) {
      return this.a.c(var1);
   }

   @Override
   public boolean c() {
      return this.a.c();
   }

   @Override
   public long d(long var1) {
      return this.a.d(var1);
   }

   @Override
   public DurationField d() {
      return this.a.d();
   }

   @Override
   public long e(long var1) {
      return this.a.e(var1);
   }

   @Override
   public DurationField e() {
      DurationField var1;
      if (this.b != null) {
         var1 = this.b;
      } else {
         var1 = this.a.e();
      }

      return var1;
   }

   @Override
   public long f(long var1) {
      return this.a.f(var1);
   }

   @Override
   public DurationField f() {
      return this.a.f();
   }

   @Override
   public int g() {
      return this.a.g();
   }

   @Override
   public long g(long var1) {
      return this.a.g(var1);
   }

   @Override
   public int h() {
      return this.a.h();
   }

   @Override
   public long h(long var1) {
      return this.a.h(var1);
   }

   @Override
   public long i(long var1) {
      return this.a.i(var1);
   }

   @Override
   public String toString() {
      return "DateTimeField[" + this.b() + ']';
   }
}
