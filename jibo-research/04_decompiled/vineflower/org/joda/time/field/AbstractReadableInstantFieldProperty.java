package org.joda.time.field;

import java.io.Serializable;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;

public abstract class AbstractReadableInstantFieldProperty implements Serializable {
   public String a(Locale var1) {
      return this.a().a(this.b(), var1);
   }

   public abstract DateTimeField a();

   protected abstract long b();

   public String b(Locale var1) {
      return this.a().b(this.b(), var1);
   }

   public int c(Locale var1) {
      return this.a().a(var1);
   }

   protected Chronology c() {
      throw new UnsupportedOperationException(
         "The method getChronology() was added in v1.4 and needs to be implemented by subclasses of AbstractReadableInstantFieldProperty"
      );
   }

   public DateTimeFieldType d() {
      return this.a().a();
   }

   public String e() {
      return this.a().b();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof AbstractReadableInstantFieldProperty)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.f() != var1.f() || !this.d().equals(var1.d()) || !FieldUtils.a(this.c(), var1.c())) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public int f() {
      return this.a().a(this.b());
   }

   public int g() {
      return this.a().g();
   }

   public int h() {
      return this.a().h();
   }

   @Override
   public int hashCode() {
      return this.f() * 17 + this.d().hashCode() + this.c().hashCode();
   }

   @Override
   public String toString() {
      return "Property[" + this.e() + "]";
   }
}
