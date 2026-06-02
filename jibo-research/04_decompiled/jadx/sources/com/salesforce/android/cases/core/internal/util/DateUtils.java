package com.salesforce.android.cases.core.internal.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class DateUtils {

    /* JADX INFO: renamed from: a */
    public static final DateFormat f12562a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());

    /* JADX INFO: renamed from: b */
    private static final ThreadLocal<DateFormat> f12563b;

    static {
        f12562a.setTimeZone(TimeZone.getTimeZone("UTC"));
        f12563b = new ThreadLocal<DateFormat>() { // from class: com.salesforce.android.cases.core.internal.util.DateUtils.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public DateFormat initialValue() {
                return DateUtils.f12562a;
            }
        };
    }

    /* JADX INFO: renamed from: a */
    public static Date m12608a(String str) {
        if (str != null) {
            try {
                return f12563b.get().parse(str);
            } catch (ParseException e) {
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static String m12607a(Date date) {
        return f12563b.get().format(date);
    }
}
