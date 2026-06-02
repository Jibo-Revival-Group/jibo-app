package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public abstract class ImpreciseDateTimeField extends BaseDateTimeField {
   private final DurationField a;
   final long b;

   public ImpreciseDateTimeField(DateTimeFieldType var1, long var2) {
      super(var1);
      this.b = var2;
      this.a = new ImpreciseDateTimeField.LinkedDurationField(this, var1.y());
   }

   @Override
   public abstract long a(long var1, int var3);

   @Override
   public abstract long a(long var1, long var3);

   @Override
   public final DurationField d() {
      return this.a;
   }

   private final class LinkedDurationField extends BaseDurationField {
      final ImpreciseDateTimeField a;

      LinkedDurationField(ImpreciseDateTimeField var1, DurationFieldType var2) {
         super(var2);
         this.a = var1;
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
      public boolean c() {
         return false;
      }

      @Override
      public long d() {
         return this.a.b;
      }
   }
}
