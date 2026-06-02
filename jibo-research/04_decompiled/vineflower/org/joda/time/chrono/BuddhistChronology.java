package org.joda.time.chrono;

import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.field.DelegatedDateTimeField;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.OffsetDateTimeField;
import org.joda.time.field.RemainderDateTimeField;
import org.joda.time.field.SkipUndoDateTimeField;
import org.joda.time.field.UnsupportedDurationField;

public final class BuddhistChronology extends AssembledChronology {
   private static final DateTimeField a = new BasicSingleEraDateTimeField("BE");
   private static final ConcurrentHashMap<DateTimeZone, BuddhistChronology> b = new ConcurrentHashMap<>();
   private static final BuddhistChronology c = b(DateTimeZone.a);

   private BuddhistChronology(Chronology var1, Object var2) {
      super(var1, var2);
   }

   public static BuddhistChronology N() {
      return c;
   }

   public static BuddhistChronology b(DateTimeZone var0) {
      DateTimeZone var1 = var0;
      if (var0 == null) {
         var1 = DateTimeZone.a();
      }

      BuddhistChronology var2 = b.get(var1);
      BuddhistChronology var3 = var2;
      if (var2 == null) {
         BuddhistChronology var4 = new BuddhistChronology(GJChronology.a(var1, null), null);
         var3 = new BuddhistChronology(LimitChronology.a(var4, new DateTime(1, 1, 1, 0, 0, 0, 0, var4), null), "");
         BuddhistChronology var5 = b.putIfAbsent(var1, var3);
         if (var5 != null) {
            var3 = var5;
         }
      }

      return var3;
   }

   private Object readResolve() {
      Chronology var1 = this.L();
      BuddhistChronology var2;
      if (var1 == null) {
         var2 = N();
      } else {
         var2 = b(var1.a());
      }

      return var2;
   }

   @Override
   public Chronology a(DateTimeZone var1) {
      DateTimeZone var2 = var1;
      if (var1 == null) {
         var2 = DateTimeZone.a();
      }

      BuddhistChronology var3;
      if (var2 == this.a()) {
         var3 = this;
      } else {
         var3 = b(var2);
      }

      return var3;
   }

   @Override
   protected void a(AssembledChronology.Fields var1) {
      if (this.M() == null) {
         var1.l = UnsupportedDurationField.a(DurationFieldType.l());
         var1.E = new OffsetDateTimeField(new SkipUndoDateTimeField(this, var1.E), 543);
         DateTimeField var2 = var1.F;
         var1.F = new DelegatedDateTimeField(var1.E, var1.l, DateTimeFieldType.t());
         var1.B = new OffsetDateTimeField(new SkipUndoDateTimeField(this, var1.B), 543);
         var1.H = new DividedDateTimeField(new OffsetDateTimeField(var1.F, 99), var1.l, DateTimeFieldType.v(), 100);
         var1.k = var1.H.d();
         var1.G = new OffsetDateTimeField(new RemainderDateTimeField((DividedDateTimeField)var1.H), DateTimeFieldType.u(), 1);
         var1.C = new OffsetDateTimeField(new RemainderDateTimeField(var1.B, var1.k, DateTimeFieldType.q(), 100), DateTimeFieldType.q(), 1);
         var1.I = a;
      }
   }

   @Override
   public Chronology b() {
      return c;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else if (var1 instanceof BuddhistChronology) {
         var1 = var1;
         var2 = this.a().equals(var1.a());
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return "Buddhist".hashCode() * 11 + this.a().hashCode();
   }

   @Override
   public String toString() {
      String var1 = "BuddhistChronology";
      DateTimeZone var2 = this.a();
      if (var2 != null) {
         var1 = "BuddhistChronology" + '[' + var2.e() + ']';
      }

      return var1;
   }
}
