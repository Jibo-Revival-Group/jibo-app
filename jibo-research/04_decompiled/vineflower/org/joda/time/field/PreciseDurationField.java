package org.joda.time.field;

import org.joda.time.DurationFieldType;

public class PreciseDurationField extends BaseDurationField {
   private final long a;

   public PreciseDurationField(DurationFieldType var1, long var2) {
      super(var1);
      this.a = var2;
   }

   @Override
   public long a(long var1, int var3) {
      return FieldUtils.a(var1, var3 * this.a);
   }

   @Override
   public long a(long var1, long var3) {
      return FieldUtils.a(var1, FieldUtils.b(var3, this.a));
   }

   @Override
   public final boolean c() {
      return true;
   }

   @Override
   public final long d() {
      return this.a;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof PreciseDurationField) {
            var1 = var1;
            if (this.a() != var1.a() || this.a != var1.a) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      long var1 = this.a;
      return (int)(var1 ^ var1 >>> 32) + this.a().hashCode();
   }
}
