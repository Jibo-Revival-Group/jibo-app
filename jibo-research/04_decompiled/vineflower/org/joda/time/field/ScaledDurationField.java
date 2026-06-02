package org.joda.time.field;

import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public class ScaledDurationField extends DecoratedDurationField {
   private final int a;

   public ScaledDurationField(DurationField var1, DurationFieldType var2, int var3) {
      super(var1, var2);
      if (var3 != 0 && var3 != 1) {
         this.a = var3;
      } else {
         throw new IllegalArgumentException("The scalar must not be 0 or 1");
      }
   }

   @Override
   public long a(long var1, int var3) {
      long var4 = var3;
      long var6 = this.a;
      return this.f().a(var1, var4 * var6);
   }

   @Override
   public long a(long var1, long var3) {
      var3 = FieldUtils.a(var3, this.a);
      return this.f().a(var1, var3);
   }

   @Override
   public long d() {
      return this.f().d() * this.a;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof ScaledDurationField) {
            var1 = var1;
            if (!this.f().equals(var1.f()) || this.a() != var1.a() || this.a != var1.a) {
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
      return (int)(var1 ^ var1 >>> 32) + this.a().hashCode() + this.f().hashCode();
   }
}
