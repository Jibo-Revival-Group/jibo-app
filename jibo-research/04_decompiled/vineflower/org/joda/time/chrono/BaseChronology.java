package org.joda.time.chrono;

import java.io.Serializable;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.ReadablePartial;
import org.joda.time.field.UnsupportedDateTimeField;
import org.joda.time.field.UnsupportedDurationField;

public abstract class BaseChronology extends Chronology implements Serializable {
   protected BaseChronology() {
   }

   @Override
   public DateTimeField A() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.q(), this.y());
   }

   @Override
   public DurationField B() {
      return UnsupportedDurationField.a(DurationFieldType.i());
   }

   @Override
   public DateTimeField C() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.r(), this.B());
   }

   @Override
   public DurationField D() {
      return UnsupportedDurationField.a(DurationFieldType.j());
   }

   @Override
   public DateTimeField E() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.s(), this.D());
   }

   @Override
   public DateTimeField F() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.t(), this.D());
   }

   @Override
   public DateTimeField G() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.u(), this.D());
   }

   @Override
   public DurationField H() {
      return UnsupportedDurationField.a(DurationFieldType.k());
   }

   @Override
   public DateTimeField I() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.v(), this.H());
   }

   @Override
   public DurationField J() {
      return UnsupportedDurationField.a(DurationFieldType.l());
   }

   @Override
   public DateTimeField K() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.w(), this.J());
   }

   @Override
   public long a(int var1, int var2, int var3, int var4) throws IllegalArgumentException {
      long var5 = this.E().b(0L, var1);
      var5 = this.C().b(var5, var2);
      var5 = this.u().b(var5, var3);
      return this.e().b(var5, var4);
   }

   @Override
   public long a(int var1, int var2, int var3, int var4, int var5, int var6, int var7) throws IllegalArgumentException {
      long var8 = this.E().b(0L, var1);
      var8 = this.C().b(var8, var2);
      var8 = this.u().b(var8, var3);
      var8 = this.m().b(var8, var4);
      var8 = this.j().b(var8, var5);
      var8 = this.g().b(var8, var6);
      return this.d().b(var8, var7);
   }

   @Override
   public long a(long var1, int var3, int var4, int var5, int var6) throws IllegalArgumentException {
      var1 = this.m().b(var1, var3);
      var1 = this.j().b(var1, var4);
      var1 = this.g().b(var1, var5);
      return this.d().b(var1, var6);
   }

   @Override
   public long a(ReadablePartial var1, long var2) {
      int var4 = 0;

      for (int var5 = var1.a(); var4 < var5; var4++) {
         var2 = var1.b(var4).a(this).b(var2, var1.a(var4));
      }

      return var2;
   }

   @Override
   public DurationField c() {
      return UnsupportedDurationField.a(DurationFieldType.a());
   }

   @Override
   public DateTimeField d() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.a(), this.c());
   }

   @Override
   public DateTimeField e() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.b(), this.c());
   }

   @Override
   public DurationField f() {
      return UnsupportedDurationField.a(DurationFieldType.b());
   }

   @Override
   public DateTimeField g() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.c(), this.f());
   }

   @Override
   public DateTimeField h() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.d(), this.f());
   }

   @Override
   public DurationField i() {
      return UnsupportedDurationField.a(DurationFieldType.c());
   }

   @Override
   public DateTimeField j() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.e(), this.i());
   }

   @Override
   public DateTimeField k() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.f(), this.i());
   }

   @Override
   public DurationField l() {
      return UnsupportedDurationField.a(DurationFieldType.d());
   }

   @Override
   public DateTimeField m() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.g(), this.l());
   }

   @Override
   public DateTimeField n() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.h(), this.l());
   }

   @Override
   public DurationField o() {
      return UnsupportedDurationField.a(DurationFieldType.e());
   }

   @Override
   public DateTimeField p() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.i(), this.l());
   }

   @Override
   public DateTimeField q() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.j(), this.l());
   }

   @Override
   public DateTimeField r() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.k(), this.o());
   }

   @Override
   public DurationField s() {
      return UnsupportedDurationField.a(DurationFieldType.f());
   }

   @Override
   public DateTimeField t() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.l(), this.s());
   }

   @Override
   public DateTimeField u() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.m(), this.s());
   }

   @Override
   public DateTimeField v() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.n(), this.s());
   }

   @Override
   public DurationField w() {
      return UnsupportedDurationField.a(DurationFieldType.g());
   }

   @Override
   public DateTimeField x() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.o(), this.w());
   }

   @Override
   public DurationField y() {
      return UnsupportedDurationField.a(DurationFieldType.h());
   }

   @Override
   public DateTimeField z() {
      return UnsupportedDateTimeField.a(DateTimeFieldType.p(), this.y());
   }
}
