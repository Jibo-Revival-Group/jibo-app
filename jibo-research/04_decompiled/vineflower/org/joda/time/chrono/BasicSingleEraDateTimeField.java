package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.field.BaseDateTimeField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.UnsupportedDurationField;

final class BasicSingleEraDateTimeField extends BaseDateTimeField {
   private final String a;

   BasicSingleEraDateTimeField(String var1) {
      super(DateTimeFieldType.w());
      this.a = var1;
   }

   @Override
   public int a(long var1) {
      return 1;
   }

   @Override
   public int a(Locale var1) {
      return this.a.length();
   }

   @Override
   public long a(long var1, String var3, Locale var4) {
      if (!this.a.equals(var3) && !"1".equals(var3)) {
         throw new IllegalFieldValueException(DateTimeFieldType.w(), var3);
      } else {
         return var1;
      }
   }

   @Override
   public String a(int var1, Locale var2) {
      return this.a;
   }

   @Override
   public long b(long var1, int var3) {
      FieldUtils.a(this, var3, 1, 1);
      return var1;
   }

   @Override
   public long d(long var1) {
      return Long.MIN_VALUE;
   }

   @Override
   public DurationField d() {
      return UnsupportedDurationField.a(DurationFieldType.l());
   }

   @Override
   public long e(long var1) {
      return Long.MAX_VALUE;
   }

   @Override
   public DurationField e() {
      return null;
   }

   @Override
   public long f(long var1) {
      return Long.MIN_VALUE;
   }

   @Override
   public int g() {
      return 1;
   }

   @Override
   public long g(long var1) {
      return Long.MIN_VALUE;
   }

   @Override
   public int h() {
      return 1;
   }

   @Override
   public long h(long var1) {
      return Long.MIN_VALUE;
   }
}
