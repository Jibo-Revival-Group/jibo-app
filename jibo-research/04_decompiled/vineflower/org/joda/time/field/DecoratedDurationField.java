package org.joda.time.field;

import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public class DecoratedDurationField extends BaseDurationField {
   private final DurationField a;

   public DecoratedDurationField(DurationField var1, DurationFieldType var2) {
      super(var2);
      if (var1 == null) {
         throw new IllegalArgumentException("The field must not be null");
      }

      if (!var1.b()) {
         throw new IllegalArgumentException("The field must be supported");
      }

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
      return this.a.c();
   }

   @Override
   public long d() {
      return this.a.d();
   }

   public final DurationField f() {
      return this.a;
   }
}
