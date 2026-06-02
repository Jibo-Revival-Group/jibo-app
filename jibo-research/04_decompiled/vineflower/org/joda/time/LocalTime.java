package org.joda.time;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.joda.convert.ToString;
import org.joda.time.base.BaseLocal;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class LocalTime extends BaseLocal implements Serializable, ReadablePartial {
   public static final LocalTime a = new LocalTime(0, 0, 0, 0);
   private static final Set<DurationFieldType> b = new HashSet<>();
   private final long c;
   private final Chronology d;

   static {
      b.add(DurationFieldType.a());
      b.add(DurationFieldType.b());
      b.add(DurationFieldType.c());
      b.add(DurationFieldType.d());
   }

   public LocalTime() {
      this(DateTimeUtils.a(), ISOChronology.O());
   }

   public LocalTime(int var1, int var2, int var3, int var4) {
      this(var1, var2, var3, var4, ISOChronology.N());
   }

   public LocalTime(int var1, int var2, int var3, int var4, Chronology var5) {
      var5 = DateTimeUtils.a(var5).b();
      long var6 = var5.a(0L, var1, var2, var3, var4);
      this.d = var5;
      this.c = var6;
   }

   public LocalTime(long var1, Chronology var3) {
      var3 = DateTimeUtils.a(var3);
      var1 = var3.a().a(DateTimeZone.a, var1);
      var3 = var3.b();
      this.c = var3.e().a(var1);
      this.d = var3;
   }

   public static LocalTime a(String var0, DateTimeFormatter var1) {
      return var1.b(var0);
   }

   private Object readResolve() {
      LocalTime var1;
      if (this.d == null) {
         var1 = new LocalTime(this.c, ISOChronology.N());
      } else {
         var1 = this;
         if (!DateTimeZone.a.equals(this.d.a())) {
            var1 = new LocalTime(this.c, this.d.b());
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
            var1 = this.c().m().a(this.b());
            break;
         case 1:
            var1 = this.c().j().a(this.b());
            break;
         case 2:
            var1 = this.c().g().a(this.b());
            break;
         case 3:
            var1 = this.c().d().a(this.b());
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
         if (var1 instanceof LocalTime) {
            LocalTime var3 = (LocalTime)var1;
            if (this.d.equals(var3.d)) {
               if (this.c < var3.c) {
                  return -1;
               }

               byte var5;
               if (this.c == var3.c) {
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
            var3 = var2.m();
            break;
         case 1:
            var3 = var2.j();
            break;
         case 2:
            var3 = var2.g();
            break;
         case 3:
            var3 = var2.d();
            break;
         default:
            throw new IndexOutOfBoundsException("Invalid index: " + var1);
      }

      return var3;
   }

   public boolean a(DurationFieldType var1) {
      boolean var2 = false;
      if (var1 != null) {
         DurationField var3 = var1.a(this.c());
         if (b.contains(var1) || var3.d() < this.c().s().d()) {
            var2 = var3.b();
         }
      }

      return var2;
   }

   @Override
   protected long b() {
      return this.c;
   }

   @Override
   public boolean b(DateTimeFieldType var1) {
      boolean var3 = false;
      boolean var2;
      if (var1 == null) {
         var2 = var3;
      } else {
         var2 = var3;
         if (this.a(var1.y())) {
            DurationFieldType var4 = var1.z();
            if (!this.a(var4)) {
               var2 = var3;
               if (var4 != DurationFieldType.f()) {
                  return var2;
               }
            }

            var2 = true;
         }
      }

      return var2;
   }

   @Override
   public Chronology c() {
      return this.d;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof LocalTime) {
            LocalTime var3 = (LocalTime)var1;
            if (this.d.equals(var3.d)) {
               if (this.c == var3.c) {
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
      return ISODateTimeFormat.c().a(this);
   }
}
