package org.joda.time;

import java.io.Serializable;
import org.joda.convert.ToString;
import org.joda.time.base.BaseLocal;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.ISODateTimeFormat;

public final class LocalDateTime extends BaseLocal implements Serializable, ReadablePartial {
   private final long a;
   private final Chronology b;

   public LocalDateTime() {
      this(DateTimeUtils.a(), ISOChronology.O());
   }

   public LocalDateTime(long var1, Chronology var3) {
      var3 = DateTimeUtils.a(var3);
      this.a = var3.a().a(DateTimeZone.a, var1);
      this.b = var3.b();
   }

   private Object readResolve() {
      LocalDateTime var1;
      if (this.b == null) {
         var1 = new LocalDateTime(this.a, ISOChronology.N());
      } else {
         var1 = this;
         if (!DateTimeZone.a.equals(this.b.a())) {
            var1 = new LocalDateTime(this.a, this.b.b());
         }
      }

      return var1;
   }

   @Override
   public int a() {
      return 4;
   }

   @Override
   public int a(int var1) {
      switch (var1) {
         case 0:
            var1 = this.c().E().a(this.b());
            break;
         case 1:
            var1 = this.c().C().a(this.b());
            break;
         case 2:
            var1 = this.c().u().a(this.b());
            break;
         case 3:
            var1 = this.c().e().a(this.b());
            break;
         default:
            throw new IndexOutOfBoundsException("Invalid index: " + var1);
      }

      return var1;
   }

   @Override
   public int a(DateTimeFieldType var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("The DateTimeFieldType must not be null");
      } else {
         return var1.a(this.c()).a(this.b());
      }
   }

   @Override
   public int a(ReadablePartial var1) {
      int var2 = 0;
      if (this != var1) {
         if (var1 instanceof LocalDateTime) {
            LocalDateTime var3 = (LocalDateTime)var1;
            if (this.b.equals(var3.b)) {
               if (this.a < var3.a) {
                  return -1;
               }

               byte var5;
               if (this.a == var3.a) {
                  var5 = 0;
               } else {
                  var5 = 1;
               }

               return var5;
            }
         }

         var2 = super.a(var1);
      }

      return var2;
   }

   @Override
   protected DateTimeField a(int var1, Chronology var2) {
      DateTimeField var3;
      switch (var1) {
         case 0:
            var3 = var2.E();
            break;
         case 1:
            var3 = var2.C();
            break;
         case 2:
            var3 = var2.u();
            break;
         case 3:
            var3 = var2.e();
            break;
         default:
            throw new IndexOutOfBoundsException("Invalid index: " + var1);
      }

      return var3;
   }

   @Override
   protected long b() {
      return this.a;
   }

   @Override
   public boolean b(DateTimeFieldType var1) {
      boolean var2;
      if (var1 == null) {
         var2 = false;
      } else {
         var2 = var1.a(this.c()).c();
      }

      return var2;
   }

   @Override
   public Chronology c() {
      return this.b;
   }

   public LocalTime d() {
      return new LocalTime(this.b(), this.c());
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof LocalDateTime) {
            LocalDateTime var3 = (LocalDateTime)var1;
            if (this.b.equals(var3.b)) {
               if (this.a == var3.a) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               return var2;
            }
         }

         var2 = super.equals(var1);
      }

      return var2;
   }

   @ToString
   @Override
   public String toString() {
      return ISODateTimeFormat.d().a(this);
   }
}
