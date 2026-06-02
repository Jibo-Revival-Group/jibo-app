package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public final class MillisDurationField extends DurationField implements Serializable {
   public static final DurationField a = new MillisDurationField();

   private MillisDurationField() {
   }

   private Object readResolve() {
      return a;
   }

   public int a(DurationField var1) {
      long var5 = var1.d();
      long var3 = this.d();
      byte var2;
      if (var3 == var5) {
         var2 = 0;
      } else if (var3 < var5) {
         var2 = -1;
      } else {
         var2 = 1;
      }

      return var2;
   }

   @Override
   public long a(long var1, int var3) {
      return FieldUtils.a((long)var1, (long)var3);
   }

   @Override
   public long a(long var1, long var3) {
      return FieldUtils.a(var1, var3);
   }

   @Override
   public DurationFieldType a() {
      return DurationFieldType.a();
   }

   @Override
   public boolean b() {
      return true;
   }

   @Override
   public final boolean c() {
      return true;
   }

   @Override
   public final long d() {
      return 1L;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if (var1 instanceof MillisDurationField) {
         var2 = var3;
         if (this.d() == ((MillisDurationField)var1).d()) {
            var2 = true;
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return (int)this.d();
   }

   @Override
   public String toString() {
      return "DurationField[millis]";
   }
}
