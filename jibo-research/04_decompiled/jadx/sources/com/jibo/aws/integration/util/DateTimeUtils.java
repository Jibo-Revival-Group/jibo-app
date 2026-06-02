package com.jibo.aws.integration.util;

import android.content.Context;
import android.text.TextUtils;
import com.amazonaws.services.cognitoidentity.model.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class DateTimeUtils {
    public static String SIMPLE_DATE_FORMAT = "MMM d, yyyy";
    public static String FULL_DATE_FORMAT = "MMMM d, yyyy";
    public static String CHILD_BIRTH_DATE_FORMAT = "MMMM d";
    public static String ANALYTICS_FORMAT = "yyyy-MM-dd";

    public static int getAge(Long l) {
        if (l == null || l.longValue() <= 0) {
            return -1;
        }
        return yearsBetween(l.longValue(), Calendar.getInstance().getTimeInMillis());
    }

    public static String getBirthdayString(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            str = SIMPLE_DATE_FORMAT;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(new Date(j));
    }

    public static String getCurrentDate(Context context, String str) {
        return new SimpleDateFormat(str).format(Calendar.getInstance().getTime());
    }

    public static String[] getDateTimeParts(long j, String str, String str2, boolean z, String... strArr) {
        if (strArr == null || strArr.length < 3) {
            throw new InvalidParameterException("Three values for days must be provided");
        }
        SimpleDateFormat[] simpleDateFormatArr = {new SimpleDateFormat("EEEE"), new SimpleDateFormat(str)};
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        String[] strArr2 = new String[2];
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        if (isYesterday(j)) {
            strArr2[0] = strArr[0];
            strArr2[1] = simpleDateFormat.format(calendar.getTime());
        } else if (isToday(j)) {
            strArr2[0] = strArr[1];
            strArr2[1] = simpleDateFormat.format(calendar.getTime());
        } else if (isTomorrow(j)) {
            strArr2[0] = strArr[2];
            strArr2[1] = simpleDateFormat.format(calendar.getTime());
        } else if (!z || System.currentTimeMillis() - calendar.getTimeInMillis() <= 0 || (System.currentTimeMillis() - calendar.getTimeInMillis()) / 86400000 > 6) {
            strArr2[0] = simpleDateFormatArr[1].format(calendar.getTime());
            strArr2[1] = simpleDateFormat.format(calendar.getTime());
        } else {
            strArr2[0] = simpleDateFormatArr[0].format(calendar.getTime());
            strArr2[1] = simpleDateFormat.format(calendar.getTime());
        }
        return strArr2;
    }

    public static String getFormattedDate(long j, String str) {
        return new SimpleDateFormat(str).format(Long.valueOf(j));
    }

    public static String getHourOffset(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i / 3600000;
        int i3 = (i - ((i2 * 3600) * 1000)) / 60000;
        sb.append(i2).append(':').append(i3 > 0 ? Integer.valueOf(i3) : "00");
        return sb.toString();
    }

    public static String getMessageDate(long j, String... strArr) {
        return getTodayYesterdayOrFormattedDateString(j, SIMPLE_DATE_FORMAT, strArr);
    }

    public static String getTodayYesterdayOrFormattedDateString(long j, String str, String... strArr) {
        if (strArr == null || strArr.length < 3) {
            throw new InvalidParameterException("Three values for days must be provided");
        }
        return isYesterday(j) ? strArr[0] : isToday(j) ? strArr[1] : isTomorrow(j) ? strArr[2] : !TextUtils.isEmpty(str) ? new SimpleDateFormat(str).format(new Date(j)) : new SimpleDateFormat(SIMPLE_DATE_FORMAT).format(new Date(j));
    }

    public static boolean isAdult(Long l) {
        if (l == null || l.longValue() <= 0) {
            return true;
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        calendar.set(13, 0);
        return yearsBetween(l.longValue(), calendar.getTimeInMillis()) >= 13;
    }

    public static boolean isLessThanFiveMinutes(long j, long j2) {
        return j2 - j <= 300000;
    }

    public static boolean isToday(long j) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        int i = (calendar.get(1) * 100) + calendar.get(6);
        calendar.setTimeInMillis(j);
        return i == calendar.get(6) + (calendar.get(1) * 100);
    }

    public static boolean isTomorrow(long j) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.add(6, 1);
        int i = (calendar.get(1) * 100) + calendar.get(6);
        calendar.setTimeInMillis(j);
        return i == calendar.get(6) + (calendar.get(1) * 100);
    }

    public static boolean isYesterday(long j) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.add(6, -1);
        int i = (calendar.get(1) * 100) + calendar.get(6);
        calendar.setTimeInMillis(j);
        return i == calendar.get(6) + (calendar.get(1) * 100);
    }

    public static int yearsBetween(long j, long j2) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.setTimeInMillis(j);
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        if (j2 > 0) {
            calendar2.setTimeInMillis(j2);
        }
        int i = calendar2.get(1) - calendar.get(1);
        return calendar2.get(2) < calendar.get(2) ? i - 1 : (calendar2.get(2) != calendar.get(2) || calendar2.get(5) >= calendar.get(5)) ? i : i - 1;
    }
}
