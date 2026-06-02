package com.jibo.aws.integration.util;

import android.content.Context;
import android.text.TextUtils;
import com.amazonaws.services.cognitoidentity.model.InvalidParameterException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtils {
   public static String ANALYTICS_FORMAT = "yyyy-MM-dd";
   public static String CHILD_BIRTH_DATE_FORMAT = "MMMM d";
   public static String FULL_DATE_FORMAT = "MMMM d, yyyy";
   public static String SIMPLE_DATE_FORMAT = "MMM d, yyyy";

   public static int getAge(Long var0) {
      int var1;
      if (var0 != null && var0 > 0L) {
         Calendar var2 = Calendar.getInstance();
         var1 = yearsBetween(var0, var2.getTimeInMillis());
      } else {
         var1 = -1;
      }

      return var1;
   }

   public static String getBirthdayString(long var0, String var2) {
      String var3 = var2;
      if (TextUtils.isEmpty(var2)) {
         var3 = SIMPLE_DATE_FORMAT;
      }

      SimpleDateFormat var4 = new SimpleDateFormat(var3);
      var4.setTimeZone(TimeZone.getTimeZone("GMT"));
      return var4.format(new Date(var0));
   }

   public static String getCurrentDate(Context var0, String var1) {
      return new SimpleDateFormat(var1).format(Calendar.getInstance().getTime());
   }

   public static String[] getDateTimeParts(long var0, String var2, String var3, boolean var4, String... var5) {
      if (var5 != null && var5.length >= 3) {
         SimpleDateFormat[] var6 = new SimpleDateFormat[]{new SimpleDateFormat("EEEE"), new SimpleDateFormat(var2)};
         SimpleDateFormat var7 = new SimpleDateFormat(var3);
         String[] var8 = new String[2];
         Calendar var9 = Calendar.getInstance();
         var9.setTimeInMillis(var0);
         if (isYesterday(var0)) {
            var8[0] = var5[0];
            var8[1] = var7.format(var9.getTime());
         } else if (isToday(var0)) {
            var8[0] = var5[1];
            var8[1] = var7.format(var9.getTime());
         } else if (isTomorrow(var0)) {
            var8[0] = var5[2];
            var8[1] = var7.format(var9.getTime());
         } else if (var4 && System.currentTimeMillis() - var9.getTimeInMillis() > 0L && (System.currentTimeMillis() - var9.getTimeInMillis()) / 86400000L <= 6L
            )
          {
            var8[0] = var6[0].format(var9.getTime());
            var8[1] = var7.format(var9.getTime());
         } else {
            var8[0] = var6[1].format(var9.getTime());
            var8[1] = var7.format(var9.getTime());
         }

         return var8;
      } else {
         throw new InvalidParameterException("Three values for days must be provided");
      }
   }

   public static String getFormattedDate(long var0, String var2) {
      return new SimpleDateFormat(var2).format(var0);
   }

   public static String getHourOffset(int var0) {
      StringBuilder var4 = new StringBuilder();
      int var1 = var0 / 3600000;
      var0 = (var0 - var1 * 3600 * 1000) / 60000;
      StringBuilder var3 = var4.append(var1).append(':');
      Serializable var2;
      if (var0 > 0) {
         var2 = var0;
      } else {
         var2 = "00";
      }

      var3.append(var2);
      return var4.toString();
   }

   public static String getMessageDate(long var0, String... var2) {
      return getTodayYesterdayOrFormattedDateString(var0, SIMPLE_DATE_FORMAT, var2);
   }

   public static String getTodayYesterdayOrFormattedDateString(long var0, String var2, String... var3) {
      if (var3 != null && var3.length >= 3) {
         if (isYesterday(var0)) {
            var2 = var3[0];
         } else if (isToday(var0)) {
            var2 = var3[1];
         } else if (isTomorrow(var0)) {
            var2 = var3[2];
         } else if (!TextUtils.isEmpty(var2)) {
            var2 = new SimpleDateFormat(var2).format(new Date(var0));
         } else {
            var2 = new SimpleDateFormat(SIMPLE_DATE_FORMAT).format(new Date(var0));
         }

         return var2;
      } else {
         throw new InvalidParameterException("Three values for days must be provided");
      }
   }

   public static boolean isAdult(Long var0) {
      boolean var2 = true;
      boolean var1 = var2;
      if (var0 != null) {
         var1 = var2;
         if (var0 > 0L) {
            Calendar var3 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            var3.set(11, 0);
            var3.set(12, 0);
            var3.set(14, 0);
            var3.set(13, 0);
            if (yearsBetween(var0, var3.getTimeInMillis()) >= 13) {
               var1 = var2;
            } else {
               var1 = false;
            }
         }
      }

      return var1;
   }

   public static boolean isLessThanFiveMinutes(long var0, long var2) {
      boolean var4;
      if (var2 - var0 <= 300000L) {
         var4 = true;
      } else {
         var4 = false;
      }

      return var4;
   }

   public static boolean isToday(long var0) {
      boolean var5 = true;
      Calendar var6 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      int var4 = var6.get(1);
      int var2 = var6.get(6);
      var6.setTimeInMillis(var0);
      int var3 = var6.get(1);
      if (var4 * 100 + var2 != var6.get(6) + var3 * 100) {
         var5 = false;
      }

      return var5;
   }

   public static boolean isTomorrow(long var0) {
      boolean var5 = true;
      Calendar var6 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      var6.add(6, 1);
      int var2 = var6.get(1);
      int var3 = var6.get(6);
      var6.setTimeInMillis(var0);
      int var4 = var6.get(1);
      if (var2 * 100 + var3 != var6.get(6) + var4 * 100) {
         var5 = false;
      }

      return var5;
   }

   public static boolean isYesterday(long var0) {
      boolean var5 = true;
      Calendar var6 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      var6.add(6, -1);
      int var4 = var6.get(1);
      int var2 = var6.get(6);
      var6.setTimeInMillis(var0);
      int var3 = var6.get(1);
      if (var4 * 100 + var2 != var6.get(6) + var3 * 100) {
         var5 = false;
      }

      return var5;
   }

   public static int yearsBetween(long var0, long var2) {
      Calendar var6 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      var6.setTimeInMillis(var0);
      Calendar var7 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      if (var2 > 0L) {
         var7.setTimeInMillis(var2);
      }

      int var5 = var7.get(1) - var6.get(1);
      int var4;
      if (var7.get(2) < var6.get(2)) {
         var4 = var5 - 1;
      } else {
         var4 = var5;
         if (var7.get(2) == var6.get(2)) {
            var4 = var5;
            if (var7.get(5) < var6.get(5)) {
               var4 = var5 - 1;
            }
         }
      }

      return var4;
   }
}
