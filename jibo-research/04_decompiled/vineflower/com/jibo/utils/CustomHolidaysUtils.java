package com.jibo.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.jibo.aws.integration.aws.services.person.model.Holiday;
import com.jibo.aws.integration.util.DateTimeUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class CustomHolidaysUtils {
   public static long a(String var0) {
      String[] var2 = var0.split("-");
      Calendar var1 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      var1.set(1, Integer.valueOf(var2[0]));
      var1.set(2, Integer.valueOf(var2[1]) - 1);
      var1.set(5, Integer.valueOf(var2[2]));
      return var1.getTimeInMillis();
   }

   public static JsonObject a(List<Holiday> var0) {
      CustomHolidaysUtils.CustomHolidays var1 = new CustomHolidaysUtils.CustomHolidays();
      var1.sHolidays = var0;
      return (JsonObject)new Gson().a(var1);
   }

   public static Holiday a(String var0, String var1, String var2, Long var3) {
      JsonObject var4 = new JsonObject();
      var4.a("id", "");
      var4.a("name", var0);
      var4.a("category", "custom");
      var4.a("subcategory", "");
      var4.a("loopId", var1);
      var4.a("memberId", var2);
      var4.a("date", DateTimeUtils.getBirthdayString(var3, "yyyy-MM-dd"));
      var4.a("created", String.valueOf(System.currentTimeMillis()));
      var4.a("isEnabled", true);
      return new Gson().a(var4, Holiday.class);
   }

   public static List<Holiday> a(Map<String, JsonObject> var0) {
      JsonObject var1 = (JsonObject)var0.get("customHolidays");
      CustomHolidaysUtils.CustomHolidays var2 = new Gson().a(var1, CustomHolidaysUtils.CustomHolidays.class);
      List var3;
      if (var2 != null && var2.sHolidays != null) {
         var3 = var2.sHolidays;
      } else {
         var3 = new ArrayList();
      }

      return var3;
   }

   static class CustomHolidays {
      @SerializedName(a = "holidays")
      List<Holiday> sHolidays;
   }
}
