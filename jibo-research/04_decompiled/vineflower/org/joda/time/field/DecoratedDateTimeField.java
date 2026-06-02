package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public abstract class DecoratedDateTimeField extends BaseDateTimeField {
   private final DateTimeField a;

   protected DecoratedDateTimeField(DateTimeField var1, DateTimeFieldType var2) {
      super(var2);
      if (var1 == null) {
         throw new IllegalArgumentException("The field must not be null");
      }

      if (!var1.c()) {
         throw new IllegalArgumentException("The field must be supported");
      }

      this.a = var1;
   }

   @Override
   public int a(long var1) {
      return this.a.a(var1);
   }

   @Override
   public long b(long var1, int var3) {
      return this.a.b(var1, var3);
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
   public DurationField e() {
      return this.a.e();
   }

   @Override
   public int g() {
      return this.a.g();
   }

   @Override
   public int h() {
      return this.a.h();
   }

   public final DateTimeField i() {
      return this.a;
   }
}
