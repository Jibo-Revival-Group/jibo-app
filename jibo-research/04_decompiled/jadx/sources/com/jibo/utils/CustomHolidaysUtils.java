package com.jibo.utils;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.jibo.aws.integration.aws.services.person.model.Holiday;
import com.jibo.aws.integration.util.DateTimeUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class CustomHolidaysUtils {
    /* JADX INFO: renamed from: a */
    public static Holiday m11379a(String str, String str2, String str3, Long l) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.m9405a(ShareConstants.WEB_DIALOG_PARAM_ID, "");
        jsonObject.m9405a("name", str);
        jsonObject.m9405a("category", "custom");
        jsonObject.m9405a("subcategory", "");
        jsonObject.m9405a("loopId", str2);
        jsonObject.m9405a("memberId", str3);
        jsonObject.m9405a("date", DateTimeUtils.getBirthdayString(l.longValue(), "yyyy-MM-dd"));
        jsonObject.m9405a("created", String.valueOf(System.currentTimeMillis()));
        jsonObject.m9403a("isEnabled", (Boolean) true);
        return (Holiday) new Gson().m9350a((JsonElement) jsonObject, Holiday.class);
    }

    /* JADX INFO: renamed from: a */
    public static JsonObject m11378a(List<Holiday> list) {
        CustomHolidays customHolidays = new CustomHolidays();
        customHolidays.sHolidays = list;
        return (JsonObject) new Gson().m9343a(customHolidays);
    }

    /* JADX INFO: renamed from: a */
    public static List<Holiday> m11380a(Map<String, JsonObject> map) {
        CustomHolidays customHolidays = (CustomHolidays) new Gson().m9350a((JsonElement) map.get("customHolidays"), CustomHolidays.class);
        return (customHolidays == null || customHolidays.sHolidays == null) ? new ArrayList() : customHolidays.sHolidays;
    }

    /* JADX INFO: renamed from: a */
    public static long m11377a(String str) {
        String[] strArrSplit = str.split("-");
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(1, Integer.valueOf(strArrSplit[0]).intValue());
        calendar.set(2, Integer.valueOf(strArrSplit[1]).intValue() - 1);
        calendar.set(5, Integer.valueOf(strArrSplit[2]).intValue());
        return calendar.getTimeInMillis();
    }

    static class CustomHolidays {

        @SerializedName(m9428a = "holidays")
        List<Holiday> sHolidays;

        CustomHolidays() {
        }
    }
}
