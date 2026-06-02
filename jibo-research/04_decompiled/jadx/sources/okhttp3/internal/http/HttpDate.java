package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.internal.Util;
import org.apache.http.protocol.HttpDateGenerator;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpDate {

    /* JADX INFO: renamed from: a */
    private static final ThreadLocal<DateFormat> f15365a = new ThreadLocal<DateFormat>() { // from class: okhttp3.internal.http.HttpDate.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(Util.f15242f);
            return simpleDateFormat;
        }
    };

    /* JADX INFO: renamed from: b */
    private static final String[] f15366b = {HttpDateGenerator.PATTERN_RFC1123, "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};

    /* JADX INFO: renamed from: c */
    private static final DateFormat[] f15367c = new DateFormat[f15366b.length];

    /* JADX INFO: renamed from: a */
    public static Date m15966a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = f15365a.get().parse(str, parsePosition);
        if (parsePosition.getIndex() != str.length()) {
            synchronized (f15366b) {
                int length = f15366b.length;
                for (int i = 0; i < length; i++) {
                    DateFormat simpleDateFormat = f15367c[i];
                    if (simpleDateFormat == null) {
                        simpleDateFormat = new SimpleDateFormat(f15366b[i], Locale.US);
                        simpleDateFormat.setTimeZone(Util.f15242f);
                        f15367c[i] = simpleDateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date date2 = simpleDateFormat.parse(str, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return date2;
                    }
                }
                return null;
            }
        }
        return date;
    }

    /* JADX INFO: renamed from: a */
    public static String m15965a(Date date) {
        return f15365a.get().format(date);
    }
}
