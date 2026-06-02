package org.joda.time.chrono;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.RemainderDateTimeField;

public final class ISOChronology extends AssembledChronology {
   private static final ISOChronology a = new ISOChronology(GregorianChronology.Z());
   private static final ConcurrentHashMap<DateTimeZone, ISOChronology> b = new ConcurrentHashMap<>();

   static {
      b.put(DateTimeZone.a, a);
   }

   private ISOChronology(Chronology var1) {
      super(var1, null);
   }

   public static ISOChronology N() {
      return a;
   }

   public static ISOChronology O() {
      return b(DateTimeZone.a());
   }

   public static ISOChronology b(DateTimeZone var0) {
      DateTimeZone var1 = var0;
      if (var0 == null) {
         var1 = DateTimeZone.a();
      }

      ISOChronology var2 = b.get(var1);
      ISOChronology var3 = var2;
      if (var2 == null) {
         var3 = new ISOChronology(ZonedChronology.a(a, var1));
         ISOChronology var4 = b.putIfAbsent(var1, var3);
         if (var4 != null) {
            var3 = var4;
         }
      }

      return var3;
   }

   private Object writeReplace() {
      return new ISOChronology.Stub(this.a());
   }

   @Override
   public Chronology a(DateTimeZone var1) {
      DateTimeZone var2 = var1;
      if (var1 == null) {
         var2 = DateTimeZone.a();
      }

      ISOChronology var3;
      if (var2 == this.a()) {
         var3 = this;
      } else {
         var3 = b(var2);
      }

      return var3;
   }

   @Override
   protected void a(AssembledChronology.Fields var1) {
      if (this.L().a() == DateTimeZone.a) {
         var1.H = new DividedDateTimeField(ISOYearOfEraDateTimeField.a, DateTimeFieldType.v(), 100);
         var1.k = var1.H.d();
         var1.G = new RemainderDateTimeField((DividedDateTimeField)var1.H, DateTimeFieldType.u());
         var1.C = new RemainderDateTimeField((DividedDateTimeField)var1.H, var1.h, DateTimeFieldType.q());
      }
   }

   @Override
   public Chronology b() {
      return a;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else if (var1 instanceof ISOChronology) {
         var1 = var1;
         var2 = this.a().equals(var1.a());
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return "ISO".hashCode() * 11 + this.a().hashCode();
   }

   @Override
   public String toString() {
      String var1 = "ISOChronology";
      DateTimeZone var2 = this.a();
      if (var2 != null) {
         var1 = "ISOChronology" + '[' + var2.e() + ']';
      }

      return var1;
   }

   private static final class Stub implements Serializable {
      private transient DateTimeZone a;

      Stub(DateTimeZone var1) {
         this.a = var1;
      }

      private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
         this.a = (DateTimeZone)var1.readObject();
      }

      private Object readResolve() {
         return ISOChronology.b(this.a);
      }

      private void writeObject(ObjectOutputStream var1) throws IOException {
         var1.writeObject(this.a);
      }
   }
}
