package org.joda.time.base;

import org.joda.convert.ToString;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.ISODateTimeFormat;

public abstract class AbstractInstant implements ReadableInstant {
   protected AbstractInstant() {
   }

   public DateTime a() {
      return new DateTime(this.c(), this.h());
   }

   @Override
   public boolean a(ReadableInstant var1) {
      return this.b(DateTimeUtils.a(var1));
   }

   public int b(ReadableInstant var1) {
      byte var2 = 0;
      if (this != var1) {
         long var3 = var1.c();
         long var5 = this.c();
         if (var5 != var3) {
            if (var5 < var3) {
               var2 = -1;
            } else {
               var2 = 1;
            }
         }
      }

      return var2;
   }

   @Override
   public Instant b() {
      return new Instant(this.c());
   }

   public boolean b(long var1) {
      boolean var3;
      if (this.c() < var1) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public MutableDateTime e() {
      return new MutableDateTime(this.c(), this.h());
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof ReadableInstant)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.c() != var1.c() || !FieldUtils.a(this.d(), var1.d())) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public DateTimeZone h() {
      return this.d().a();
   }

   @Override
   public int hashCode() {
      return (int)(this.c() ^ this.c() >>> 32) + this.d().hashCode();
   }

   @ToString
   @Override
   public String toString() {
      return ISODateTimeFormat.d().a(this);
   }
}
