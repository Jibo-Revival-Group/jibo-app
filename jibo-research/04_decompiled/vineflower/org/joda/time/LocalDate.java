package org.joda.time;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.joda.convert.ToString;
import org.joda.time.base.BaseLocal;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.ISODateTimeFormat;

public final class LocalDate extends BaseLocal implements Serializable, ReadablePartial {
   private static final Set<DurationFieldType> a = new HashSet<>();
   private final long b;
   private final Chronology c;
   private transient int d;

   static {
      a.add(DurationFieldType.f());
      a.add(DurationFieldType.g());
      a.add(DurationFieldType.i());
      a.add(DurationFieldType.h());
      a.add(DurationFieldType.j());
      a.add(DurationFieldType.k());
      a.add(DurationFieldType.l());
   }

   public LocalDate() {
      this(DateTimeUtils.a(), ISOChronology.O());
   }

   public LocalDate(long var1, Chronology var3) {
      var3 = DateTimeUtils.a(var3);
      var1 = var3.a().a(DateTimeZone.a, var1);
      var3 = var3.b();
      this.b = var3.u().d(var1);
      this.c = var3;
   }

   private Object readResolve() {
      LocalDate var1;
      if (this.c == null) {
         var1 = new LocalDate(this.b, ISOChronology.N());
      } else {
         var1 = this;
         if (!DateTimeZone.a.equals(this.c.a())) {
            var1 = new LocalDate(this.b, this.c.b());
         }
      }

      return var1;
   }

   @Override
   public int a() {
      return 3;
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
         default:
            throw new IndexOutOfBoundsException("Invalid index: " + var1);
      }

      return var1;
   }

   @Override
   public int a(DateTimeFieldType var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("The DateTimeFieldType must not be null");
      } else if (!this.b(var1)) {
         throw new IllegalArgumentException("Field '" + var1 + "' is not supported");
      } else {
         return var1.a(this.c()).a(this.b());
      }
   }

   @Override
   public int a(ReadablePartial var1) {
      int var2 = 0;
      if (this != var1) {
         if (var1 instanceof LocalDate) {
            LocalDate var3 = (LocalDate)var1;
            if (this.c.equals(var3.c)) {
               if (this.b < var3.b) {
                  return -1;
               }

               byte var5;
               if (this.b == var3.b) {
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
         default:
            throw new IndexOutOfBoundsException("Invalid index: " + var1);
      }

      return var3;
   }

   @Override
   protected long b() {
      return this.b;
   }

   @Override
   public boolean b(DateTimeFieldType var1) {
      boolean var2 = false;
      if (var1 != null) {
         DurationFieldType var3 = var1.y();
         if (a.contains(var3) || var3.a(this.c()).d() >= this.c().s().d()) {
            var2 = var1.a(this.c()).c();
         }
      }

      return var2;
   }

   @Override
   public Chronology c() {
      return this.c;
   }

   public int d() {
      return this.c().E().a(this.b());
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof LocalDate) {
            LocalDate var3 = (LocalDate)var1;
            if (this.c.equals(var3.c)) {
               if (this.b == var3.b) {
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

   @Override
   public int hashCode() {
      int var2 = this.d;
      int var1 = var2;
      if (var2 == 0) {
         var1 = super.hashCode();
         this.d = var1;
      }

      return var1;
   }

   @ToString
   @Override
   public String toString() {
      return ISODateTimeFormat.b().a(this);
   }
}
