package org.joda.time;

import java.text.DateFormatSymbols;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.chrono.ISOChronology;

/* JADX INFO: loaded from: classes2.dex */
public class DateTimeUtils {

    /* JADX INFO: renamed from: a */
    public static final MillisProvider f15748a = new SystemMillisProvider();

    /* JADX INFO: renamed from: b */
    private static volatile MillisProvider f15749b = f15748a;

    /* JADX INFO: renamed from: c */
    private static final AtomicReference<Map<String, DateTimeZone>> f15750c = new AtomicReference<>();

    public interface MillisProvider {
        /* JADX INFO: renamed from: a */
        long mo16522a();
    }

    /* JADX INFO: renamed from: a */
    public static final long m16513a() {
        return f15749b.mo16522a();
    }

    /* JADX INFO: renamed from: a */
    public static final long m16514a(ReadableInstant readableInstant) {
        return readableInstant == null ? m16513a() : readableInstant.mo16580c();
    }

    /* JADX INFO: renamed from: b */
    public static final Chronology m16520b(ReadableInstant readableInstant) {
        if (readableInstant == null) {
            return ISOChronology.m16707O();
        }
        Chronology chronologyMo16581d = readableInstant.mo16581d();
        if (chronologyMo16581d == null) {
            return ISOChronology.m16707O();
        }
        return chronologyMo16581d;
    }

    /* JADX INFO: renamed from: a */
    public static final Chronology m16516a(Chronology chronology) {
        if (chronology == null) {
            return ISOChronology.m16707O();
        }
        return chronology;
    }

    /* JADX INFO: renamed from: a */
    public static final DateTimeZone m16517a(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            return DateTimeZone.m16523a();
        }
        return dateTimeZone;
    }

    /* JADX INFO: renamed from: a */
    public static final DateFormatSymbols m16515a(Locale locale) {
        try {
            return (DateFormatSymbols) DateFormatSymbols.class.getMethod("getInstance", Locale.class).invoke(null, locale);
        } catch (Exception e) {
            return new DateFormatSymbols(locale);
        }
    }

    /* JADX INFO: renamed from: b */
    public static final Map<String, DateTimeZone> m16519b() {
        Map<String, DateTimeZone> map = f15750c.get();
        if (map == null) {
            Map<String, DateTimeZone> mapM16521c = m16521c();
            if (!f15750c.compareAndSet(null, mapM16521c)) {
                return f15750c.get();
            }
            return mapM16521c;
        }
        return map;
    }

    /* JADX INFO: renamed from: c */
    private static Map<String, DateTimeZone> m16521c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("UT", DateTimeZone.f15751a);
        linkedHashMap.put("UTC", DateTimeZone.f15751a);
        linkedHashMap.put("GMT", DateTimeZone.f15751a);
        m16518a(linkedHashMap, "EST", "America/New_York");
        m16518a(linkedHashMap, "EDT", "America/New_York");
        m16518a(linkedHashMap, "CST", "America/Chicago");
        m16518a(linkedHashMap, "CDT", "America/Chicago");
        m16518a(linkedHashMap, "MST", "America/Denver");
        m16518a(linkedHashMap, "MDT", "America/Denver");
        m16518a(linkedHashMap, "PST", "America/Los_Angeles");
        m16518a(linkedHashMap, "PDT", "America/Los_Angeles");
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* JADX INFO: renamed from: a */
    private static void m16518a(Map<String, DateTimeZone> map, String str, String str2) {
        try {
            map.put(str, DateTimeZone.m16525a(str2));
        } catch (RuntimeException e) {
        }
    }

    static class SystemMillisProvider implements MillisProvider {
        SystemMillisProvider() {
        }

        @Override // org.joda.time.DateTimeUtils.MillisProvider
        /* JADX INFO: renamed from: a */
        public long mo16522a() {
            return System.currentTimeMillis();
        }
    }
}
