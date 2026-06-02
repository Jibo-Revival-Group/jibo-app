package org.joda.time.convert;

public final class ConverterManager {
   private static ConverterManager a;
   private ConverterSet b = new ConverterSet(
      new Converter[]{ReadableInstantConverter.a, StringConverter.a, CalendarConverter.a, DateConverter.a, LongConverter.a, NullConverter.a}
   );
   private ConverterSet c = new ConverterSet(
      new Converter[]{
         ReadablePartialConverter.a, ReadableInstantConverter.a, StringConverter.a, CalendarConverter.a, DateConverter.a, LongConverter.a, NullConverter.a
      }
   );
   private ConverterSet d = new ConverterSet(
      new Converter[]{ReadableDurationConverter.a, ReadableIntervalConverter.a, StringConverter.a, LongConverter.a, NullConverter.a}
   );
   private ConverterSet e = new ConverterSet(
      new Converter[]{ReadableDurationConverter.a, ReadablePeriodConverter.a, ReadableIntervalConverter.a, StringConverter.a, NullConverter.a}
   );
   private ConverterSet f = new ConverterSet(new Converter[]{ReadableIntervalConverter.a, StringConverter.a, NullConverter.a});

   protected ConverterManager() {
   }

   public static ConverterManager a() {
      if (a == null) {
         a = new ConverterManager();
      }

      return a;
   }

   public InstantConverter a(Object var1) {
      ConverterSet var3 = this.b;
      Class var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = var1.getClass();
      }

      InstantConverter var5 = (InstantConverter)var3.a(var2);
      if (var5 != null) {
         return var5;
      }

      StringBuilder var6 = new StringBuilder().append("No instant converter found for type: ");
      if (var1 == null) {
         var1 = "null";
      } else {
         var1 = var1.getClass().getName();
      }

      throw new IllegalArgumentException(var6.append(var1).toString());
   }

   @Override
   public String toString() {
      return "ConverterManager["
         + this.b.a()
         + " instant,"
         + this.c.a()
         + " partial,"
         + this.d.a()
         + " duration,"
         + this.e.a()
         + " period,"
         + this.f.a()
         + " interval]";
   }
}
