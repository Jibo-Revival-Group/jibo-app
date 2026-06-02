package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.field.BaseDateTimeField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.UnsupportedDurationField;

final class GJEraDateTimeField extends BaseDateTimeField {
   private final BasicChronology a;

   GJEraDateTimeField(BasicChronology var1) {
      super(DateTimeFieldType.w());
      this.a = var1;
   }

   @Override
   public int a(long var1) {
      byte var3;
      if (this.a.a(var1) <= 0) {
         var3 = 0;
      } else {
         var3 = 1;
      }

      return var3;
   }

   @Override
   public int a(Locale var1) {
      return GJLocaleSymbols.a(var1).a();
   }

   @Override
   public long a(long var1, String var3, Locale var4) {
      return this.b(var1, GJLocaleSymbols.a(var4).a(var3));
   }

   @Override
   public String a(int var1, Locale var2) {
      return GJLocaleSymbols.a(var2).a(var1);
   }

   @Override
   public long b(long var1, int var3) {
      FieldUtils.a(this, var3, 0, 1);
      long var4 = var1;
      if (this.a(var1) != var3) {
         var3 = this.a.a(var1);
         var4 = this.a.f(var1, -var3);
      }

      return var4;
   }

   @Override
   public long d(long var1) {
      if (this.a(var1) == 1) {
         var1 = this.a.f(0L, 1);
      } else {
         var1 = Long.MIN_VALUE;
      }

      return var1;
   }

   @Override
   public DurationField d() {
      return UnsupportedDurationField.a(DurationFieldType.l());
   }

   @Override
   public long e(long var1) {
      if (this.a(var1) == 0) {
         var1 = this.a.f(0L, 1);
      } else {
         var1 = Long.MAX_VALUE;
      }

      return var1;
   }

   @Override
   public DurationField e() {
      return null;
   }

   @Override
   public long f(long var1) {
      return this.d(var1);
   }

   @Override
   public int g() {
      return 0;
   }

   @Override
   public long g(long var1) {
      return this.d(var1);
   }

   @Override
   public int h() {
      return 1;
   }

   @Override
   public long h(long var1) {
      return this.d(var1);
   }
}
