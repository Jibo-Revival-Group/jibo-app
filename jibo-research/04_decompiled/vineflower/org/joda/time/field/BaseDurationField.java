package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public abstract class BaseDurationField extends DurationField implements Serializable {
   private final DurationFieldType a;

   protected BaseDurationField(DurationFieldType var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("The type must not be null");
      }

      this.a = var1;
   }

   public int a(DurationField var1) {
      long var3 = var1.d();
      long var5 = this.d();
      byte var2;
      if (var5 == var3) {
         var2 = 0;
      } else if (var5 < var3) {
         var2 = -1;
      } else {
         var2 = 1;
      }

      return var2;
   }

   @Override
   public final DurationFieldType a() {
      return this.a;
   }

   @Override
   public final boolean b() {
      return true;
   }

   public final String e() {
      return this.a.m();
   }

   @Override
   public String toString() {
      return "DurationField[" + this.e() + ']';
   }
}
