package org.joda.time;

import java.text.DateFormatSymbols;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.chrono.ISOChronology;

public class DateTimeUtils {
   public static final DateTimeUtils.MillisProvider a = new DateTimeUtils.SystemMillisProvider();
   private static volatile DateTimeUtils.MillisProvider b = a;
   private static final AtomicReference<Map<String, DateTimeZone>> c = new AtomicReference<>();

   public static final long a() {
      return b.a();
   }

   public static final long a(ReadableInstant var0) {
      long var1;
      if (var0 == null) {
         var1 = a();
      } else {
         var1 = var0.c();
      }

      return var1;
   }

   public static final DateFormatSymbols a(Locale var0) {
      DateFormatSymbols var1;
      try {
         var1 = (DateFormatSymbols)DateFormatSymbols.class.getMethod("getInstance", Locale.class).invoke(null, var0);
      } catch (Exception var2) {
         return new DateFormatSymbols(var0);
      }

      return var1;
   }

   public static final Chronology a(Chronology var0) {
      Chronology var1 = var0;
      if (var0 == null) {
         var1 = ISOChronology.O();
      }

      return var1;
   }

   public static final DateTimeZone a(DateTimeZone var0) {
      DateTimeZone var1 = var0;
      if (var0 == null) {
         var1 = DateTimeZone.a();
      }

      return var1;
   }

   private static void a(Map<String, DateTimeZone> var0, String var1, String var2) {
      try {
         var0.put(var1, DateTimeZone.a(var2));
      } catch (RuntimeException var3) {
      }
   }

   public static final Map<String, DateTimeZone> b() {
      Map var1 = c.get();
      Map var0 = var1;
      if (var1 == null) {
         var1 = c();
         var0 = var1;
         if (!c.compareAndSet(null, var1)) {
            var0 = c.get();
         }
      }

      return var0;
   }

   public static final Chronology b(ReadableInstant var0) {
      Chronology var2;
      if (var0 == null) {
         var2 = ISOChronology.O();
      } else {
         Chronology var1 = var0.d();
         var2 = var1;
         if (var1 == null) {
            var2 = ISOChronology.O();
         }
      }

      return var2;
   }

   private static Map<String, DateTimeZone> c() {
      LinkedHashMap var0 = new LinkedHashMap();
      var0.put("UT", DateTimeZone.a);
      var0.put("UTC", DateTimeZone.a);
      var0.put("GMT", DateTimeZone.a);
      a(var0, "EST", "America/New_York");
      a(var0, "EDT", "America/New_York");
      a(var0, "CST", "America/Chicago");
      a(var0, "CDT", "America/Chicago");
      a(var0, "MST", "America/Denver");
      a(var0, "MDT", "America/Denver");
      a(var0, "PST", "America/Los_Angeles");
      a(var0, "PDT", "America/Los_Angeles");
      return Collections.unmodifiableMap(var0);
   }

   public interface MillisProvider {
      long a();
   }

   static class SystemMillisProvider implements DateTimeUtils.MillisProvider {
      @Override
      public long a() {
         return System.currentTimeMillis();
      }
   }
}
