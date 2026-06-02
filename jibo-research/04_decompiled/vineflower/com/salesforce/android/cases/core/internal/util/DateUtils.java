package com.salesforce.android.cases.core.internal.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
   public static final DateFormat a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
   private static final ThreadLocal<DateFormat> b = new ThreadLocal<DateFormat>() {
      protected DateFormat a() {
         return DateUtils.a;
      }
   };

   static {
      a.setTimeZone(TimeZone.getTimeZone("UTC"));
   }

   public static String a(Date var0) {
      return b.get().format(var0);
   }

   public static Date a(String var0) {
      if (var0 != null) {
         try {
            return b.get().parse(var0);
         } catch (ParseException var1) {
         }
      }

      return null;
   }
}
