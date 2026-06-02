package com.amazonaws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class DateUtils {
    private static final TimeZone GMT_TIMEZONE = TimeZone.getTimeZone("GMT");
    private static final Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap();

    public static String format(String str, Date date) {
        return getSimpleDateFormat(str).get().format(date);
    }

    public static String formatRFC822Date(Date date) {
        return format("EEE, dd MMM yyyy HH:mm:ss z", date);
    }

    private static ThreadLocal<SimpleDateFormat> getSimpleDateFormat(final String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = sdfMap.get(str);
        if (threadLocal == null) {
            synchronized (sdfMap) {
                threadLocal = sdfMap.get(str);
                if (threadLocal == null) {
                    threadLocal = new ThreadLocal<SimpleDateFormat>() { // from class: com.amazonaws.util.DateUtils.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // java.lang.ThreadLocal
                        public SimpleDateFormat initialValue() {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
                            simpleDateFormat.setTimeZone(DateUtils.GMT_TIMEZONE);
                            simpleDateFormat.setLenient(false);
                            return simpleDateFormat;
                        }
                    };
                    sdfMap.put(str, threadLocal);
                }
            }
        }
        return threadLocal;
    }

    public static Date parse(String str, String str2) {
        try {
            return getSimpleDateFormat(str).get().parse(str2);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Date parseCompressedISO8601Date(String str) {
        return parse("yyyyMMdd'T'HHmmss'Z'", str);
    }

    public static Date parseRFC822Date(String str) {
        return parse("EEE, dd MMM yyyy HH:mm:ss z", str);
    }
}
