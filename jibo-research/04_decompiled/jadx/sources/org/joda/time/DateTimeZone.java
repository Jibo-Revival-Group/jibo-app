package org.joda.time;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.chrono.BaseChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.FormatUtils;
import org.joda.time.p029tz.DefaultNameProvider;
import org.joda.time.p029tz.FixedDateTimeZone;
import org.joda.time.p029tz.NameProvider;
import org.joda.time.p029tz.Provider;
import org.joda.time.p029tz.UTCProvider;
import org.joda.time.p029tz.ZoneInfoProvider;

/* JADX INFO: loaded from: classes.dex */
public abstract class DateTimeZone implements Serializable {

    /* JADX INFO: renamed from: a */
    public static final DateTimeZone f15751a = UTCDateTimeZone.f15796b;

    /* JADX INFO: renamed from: b */
    private static final AtomicReference<Provider> f15752b = new AtomicReference<>();

    /* JADX INFO: renamed from: c */
    private static final AtomicReference<NameProvider> f15753c = new AtomicReference<>();

    /* JADX INFO: renamed from: d */
    private static final AtomicReference<DateTimeZone> f15754d = new AtomicReference<>();

    /* JADX INFO: renamed from: e */
    private final String f15755e;

    /* JADX INFO: renamed from: a */
    public abstract String mo16541a(long j);

    /* JADX INFO: renamed from: b */
    public abstract int mo16543b(long j);

    /* JADX INFO: renamed from: c */
    public abstract int mo16545c(long j);

    public abstract boolean equals(Object obj);

    /* JADX INFO: renamed from: f */
    public abstract boolean mo16550f();

    /* JADX INFO: renamed from: g */
    public abstract long mo16551g(long j);

    /* JADX INFO: renamed from: h */
    public abstract long mo16552h(long j);

    /* JADX INFO: renamed from: a */
    public static DateTimeZone m16523a() {
        DateTimeZone dateTimeZoneM16527a = f15754d.get();
        if (dateTimeZoneM16527a == null) {
            try {
                try {
                    String property = System.getProperty("user.timezone");
                    if (property != null) {
                        dateTimeZoneM16527a = m16525a(property);
                    }
                } catch (RuntimeException e) {
                }
                if (dateTimeZoneM16527a == null) {
                    dateTimeZoneM16527a = m16527a(TimeZone.getDefault());
                }
            } catch (IllegalArgumentException e2) {
            }
            if (dateTimeZoneM16527a == null) {
                dateTimeZoneM16527a = f15751a;
            }
            if (!f15754d.compareAndSet(null, dateTimeZoneM16527a)) {
                return f15754d.get();
            }
            return dateTimeZoneM16527a;
        }
        return dateTimeZoneM16527a;
    }

    @FromString
    /* JADX INFO: renamed from: a */
    public static DateTimeZone m16525a(String str) {
        if (str == null) {
            return m16523a();
        }
        if (str.equals("UTC")) {
            return f15751a;
        }
        DateTimeZone dateTimeZoneMo17009a = m16533c().mo17009a(str);
        if (dateTimeZoneMo17009a == null) {
            if (str.startsWith("+") || str.startsWith("-")) {
                int iM16534d = m16534d(str);
                if (iM16534d == 0) {
                    return f15751a;
                }
                return m16526a(m16529b(iM16534d), iM16534d);
            }
            throw new IllegalArgumentException("The datetime zone id '" + str + "' is not recognised");
        }
        return dateTimeZoneMo17009a;
    }

    /* JADX INFO: renamed from: a */
    public static DateTimeZone m16524a(int i) {
        if (i < -86399999 || i > 86399999) {
            throw new IllegalArgumentException("Millis out of range: " + i);
        }
        return m16526a(m16529b(i), i);
    }

    /* JADX INFO: renamed from: a */
    public static DateTimeZone m16527a(TimeZone timeZone) {
        char cCharAt;
        if (timeZone == null) {
            return m16523a();
        }
        String id = timeZone.getID();
        if (id == null) {
            throw new IllegalArgumentException("The TimeZone id must not be null");
        }
        if (id.equals("UTC")) {
            return f15751a;
        }
        DateTimeZone dateTimeZoneMo17009a = null;
        String strM16532c = m16532c(id);
        Provider providerM16533c = m16533c();
        if (strM16532c != null) {
            dateTimeZoneMo17009a = providerM16533c.mo17009a(strM16532c);
        }
        if (dateTimeZoneMo17009a == null) {
            dateTimeZoneMo17009a = providerM16533c.mo17009a(id);
        }
        if (dateTimeZoneMo17009a == null) {
            if (strM16532c == null && (id.startsWith("GMT+") || id.startsWith("GMT-"))) {
                String strSubstring = id.substring(3);
                if (strSubstring.length() > 2 && (cCharAt = strSubstring.charAt(1)) > '9' && Character.isDigit(cCharAt)) {
                    strSubstring = m16530b(strSubstring);
                }
                int iM16534d = m16534d(strSubstring);
                if (iM16534d == 0) {
                    return f15751a;
                }
                return m16526a(m16529b(iM16534d), iM16534d);
            }
            throw new IllegalArgumentException("The datetime zone id '" + id + "' is not recognised");
        }
        return dateTimeZoneMo17009a;
    }

    /* JADX INFO: renamed from: b */
    private static String m16530b(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            int iDigit = Character.digit(sb.charAt(i), 10);
            if (iDigit >= 0) {
                sb.setCharAt(i, (char) (iDigit + 48));
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private static DateTimeZone m16526a(String str, int i) {
        return i == 0 ? f15751a : new FixedDateTimeZone(str, null, i, i);
    }

    /* JADX INFO: renamed from: b */
    public static Set<String> m16531b() {
        return m16533c().mo17008a();
    }

    /* JADX INFO: renamed from: c */
    public static Provider m16533c() {
        Provider provider = f15752b.get();
        if (provider == null) {
            Provider providerM16536g = m16536g();
            if (!f15752b.compareAndSet(null, providerM16536g)) {
                return f15752b.get();
            }
            return providerM16536g;
        }
        return provider;
    }

    /* JADX INFO: renamed from: a */
    private static Provider m16528a(Provider provider) {
        Set<String> setMo17008a = provider.mo17008a();
        if (setMo17008a == null || setMo17008a.size() == 0) {
            throw new IllegalArgumentException("The provider doesn't have any available ids");
        }
        if (!setMo17008a.contains("UTC")) {
            throw new IllegalArgumentException("The provider doesn't support UTC");
        }
        if (!f15751a.equals(provider.mo17009a("UTC"))) {
            throw new IllegalArgumentException("Invalid UTC zone provided");
        }
        return provider;
    }

    /* JADX INFO: renamed from: g */
    private static Provider m16536g() {
        try {
            String property = System.getProperty("org.joda.time.DateTimeZone.Provider");
            if (property != null) {
                try {
                    return m16528a((Provider) Class.forName(property).newInstance());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SecurityException e2) {
        }
        try {
            String property2 = System.getProperty("org.joda.time.DateTimeZone.Folder");
            if (property2 != null) {
                try {
                    return m16528a(new ZoneInfoProvider(new File(property2)));
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
        } catch (SecurityException e4) {
        }
        try {
            return m16528a(new ZoneInfoProvider("org/joda/time/tz/data"));
        } catch (Exception e5) {
            e5.printStackTrace();
            return new UTCProvider();
        }
    }

    /* JADX INFO: renamed from: d */
    public static NameProvider m16535d() {
        NameProvider nameProvider = f15753c.get();
        if (nameProvider == null) {
            NameProvider nameProviderM16537h = m16537h();
            if (!f15753c.compareAndSet(null, nameProviderM16537h)) {
                return f15753c.get();
            }
            return nameProviderM16537h;
        }
        return nameProvider;
    }

    /* JADX INFO: renamed from: h */
    private static NameProvider m16537h() {
        NameProvider nameProvider;
        try {
            String property = System.getProperty("org.joda.time.DateTimeZone.NameProvider");
            if (property == null) {
                nameProvider = null;
            } else {
                try {
                    nameProvider = (NameProvider) Class.forName(property).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SecurityException e2) {
            nameProvider = null;
        }
        if (nameProvider == null) {
            return new DefaultNameProvider();
        }
        return nameProvider;
    }

    /* JADX INFO: renamed from: c */
    private static String m16532c(String str) {
        return LazyInit.f15756a.get(str);
    }

    /* JADX INFO: renamed from: d */
    private static int m16534d(String str) {
        return -((int) LazyInit.f15757b.m16777a(str));
    }

    /* JADX INFO: renamed from: b */
    private static String m16529b(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i >= 0) {
            stringBuffer.append('+');
        } else {
            stringBuffer.append('-');
            i = -i;
        }
        int i2 = i / 3600000;
        FormatUtils.m16903a(stringBuffer, i2, 2);
        int i3 = i - (i2 * 3600000);
        int i4 = i3 / 60000;
        stringBuffer.append(':');
        FormatUtils.m16903a(stringBuffer, i4, 2);
        int i5 = i3 - (i4 * 60000);
        if (i5 == 0) {
            return stringBuffer.toString();
        }
        int i6 = i5 / 1000;
        stringBuffer.append(':');
        FormatUtils.m16903a(stringBuffer, i6, 2);
        int i7 = i5 - (i6 * 1000);
        if (i7 == 0) {
            return stringBuffer.toString();
        }
        stringBuffer.append('.');
        FormatUtils.m16903a(stringBuffer, i7, 3);
        return stringBuffer.toString();
    }

    protected DateTimeZone(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        this.f15755e = str;
    }

    @ToString
    /* JADX INFO: renamed from: e */
    public final String m16548e() {
        return this.f15755e;
    }

    /* JADX INFO: renamed from: a */
    public String m16542a(long j, Locale locale) {
        String strMo17004a;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String strMo16541a = mo16541a(j);
        if (strMo16541a == null) {
            return this.f15755e;
        }
        NameProvider nameProviderM16535d = m16535d();
        if (nameProviderM16535d instanceof DefaultNameProvider) {
            strMo17004a = ((DefaultNameProvider) nameProviderM16535d).m17005a(locale, this.f15755e, strMo16541a, m16546d(j));
        } else {
            strMo17004a = nameProviderM16535d.mo17004a(locale, this.f15755e, strMo16541a);
        }
        return strMo17004a == null ? m16529b(mo16543b(j)) : strMo17004a;
    }

    /* JADX INFO: renamed from: b */
    public String m16544b(long j, Locale locale) {
        String strMo17006b;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String strMo16541a = mo16541a(j);
        if (strMo16541a == null) {
            return this.f15755e;
        }
        NameProvider nameProviderM16535d = m16535d();
        if (nameProviderM16535d instanceof DefaultNameProvider) {
            strMo17006b = ((DefaultNameProvider) nameProviderM16535d).m17007b(locale, this.f15755e, strMo16541a, m16546d(j));
        } else {
            strMo17006b = nameProviderM16535d.mo17006b(locale, this.f15755e, strMo16541a);
        }
        return strMo17006b == null ? m16529b(mo16543b(j)) : strMo17006b;
    }

    /* JADX INFO: renamed from: d */
    public boolean m16546d(long j) {
        return mo16543b(j) == mo16545c(j);
    }

    /* JADX INFO: renamed from: e */
    public int mo16547e(long j) {
        int iMo16543b = mo16543b(j);
        long j2 = j - ((long) iMo16543b);
        int iMo16543b2 = mo16543b(j2);
        if (iMo16543b != iMo16543b2) {
            if (iMo16543b - iMo16543b2 < 0) {
                long jMo16551g = mo16551g(j2);
                if (jMo16551g == j - ((long) iMo16543b)) {
                    jMo16551g = Long.MAX_VALUE;
                }
                long jMo16551g2 = mo16551g(j - ((long) iMo16543b2));
                if (jMo16551g != (jMo16551g2 != j - ((long) iMo16543b2) ? jMo16551g2 : Long.MAX_VALUE)) {
                    return iMo16543b;
                }
            }
        } else if (iMo16543b >= 0) {
            long jMo16552h = mo16552h(j2);
            if (jMo16552h < j2) {
                int iMo16543b3 = mo16543b(jMo16552h);
                if (j2 - jMo16552h <= iMo16543b3 - iMo16543b) {
                    return iMo16543b3;
                }
            }
        }
        return iMo16543b2;
    }

    /* JADX INFO: renamed from: f */
    public long m16549f(long j) {
        int iMo16543b = mo16543b(j);
        long j2 = ((long) iMo16543b) + j;
        if ((j ^ j2) < 0 && (((long) iMo16543b) ^ j) >= 0) {
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }
        return j2;
    }

    /* JADX INFO: renamed from: a */
    public long m16539a(long j, boolean z, long j2) {
        int iMo16543b = mo16543b(j2);
        long j3 = j - ((long) iMo16543b);
        return mo16543b(j3) == iMo16543b ? j3 : m16538a(j, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long m16538a(long r14, boolean r16) {
        /*
            r13 = this;
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10 = 0
            int r5 = r13.mo16543b(r14)
            long r0 = (long) r5
            long r0 = r14 - r0
            int r4 = r13.mo16543b(r0)
            if (r5 == r4) goto L5e
            if (r16 != 0) goto L18
            if (r5 >= 0) goto L5e
        L18:
            long r0 = (long) r5
            long r0 = r14 - r0
            long r0 = r13.mo16551g(r0)
            long r6 = (long) r5
            long r6 = r14 - r6
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 != 0) goto L27
            r0 = r2
        L27:
            long r6 = (long) r4
            long r6 = r14 - r6
            long r6 = r13.mo16551g(r6)
            long r8 = (long) r4
            long r8 = r14 - r8
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 != 0) goto L60
        L35:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L5e
            if (r16 == 0) goto L45
            org.joda.time.IllegalInstantException r0 = new org.joda.time.IllegalInstantException
            java.lang.String r1 = r13.m16548e()
            r0.<init>(r14, r1)
            throw r0
        L45:
            r0 = r5
        L46:
            long r2 = (long) r0
            long r2 = r14 - r2
            long r4 = r14 ^ r2
            int r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r1 >= 0) goto L5d
            long r0 = (long) r0
            long r0 = r0 ^ r14
            int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r0 >= 0) goto L5d
            java.lang.ArithmeticException r0 = new java.lang.ArithmeticException
            java.lang.String r1 = "Subtracting time zone offset caused overflow"
            r0.<init>(r1)
            throw r0
        L5d:
            return r2
        L5e:
            r0 = r4
            goto L46
        L60:
            r2 = r6
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeZone.m16538a(long, boolean):long");
    }

    /* JADX INFO: renamed from: a */
    public long m16540a(DateTimeZone dateTimeZone, long j) {
        DateTimeZone dateTimeZoneM16523a = dateTimeZone == null ? m16523a() : dateTimeZone;
        return dateTimeZoneM16523a == this ? j : dateTimeZoneM16523a.m16539a(m16549f(j), false, j);
    }

    public int hashCode() {
        return m16548e().hashCode() + 57;
    }

    public String toString() {
        return m16548e();
    }

    protected Object writeReplace() throws ObjectStreamException {
        return new Stub(this.f15755e);
    }

    /* JADX INFO: loaded from: classes2.dex */
    private static final class Stub implements Serializable {

        /* JADX INFO: renamed from: a */
        private transient String f15758a;

        Stub(String str) {
            this.f15758a = str;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeUTF(this.f15758a);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            this.f15758a = objectInputStream.readUTF();
        }

        private Object readResolve() throws ObjectStreamException {
            return DateTimeZone.m16525a(this.f15758a);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    static final class LazyInit {

        /* JADX INFO: renamed from: a */
        static final Map<String, String> f15756a = m16554b();

        /* JADX INFO: renamed from: b */
        static final DateTimeFormatter f15757b = m16553a();

        /* JADX INFO: renamed from: a */
        private static DateTimeFormatter m16553a() {
            return new DateTimeFormatterBuilder().m16809a(null, true, 2, 4).m16802a().m16780a(new BaseChronology() { // from class: org.joda.time.DateTimeZone.LazyInit.1
                @Override // org.joda.time.Chronology
                /* JADX INFO: renamed from: a */
                public DateTimeZone mo16407a() {
                    return null;
                }

                @Override // org.joda.time.Chronology
                /* JADX INFO: renamed from: b */
                public Chronology mo16408b() {
                    return this;
                }

                @Override // org.joda.time.Chronology
                /* JADX INFO: renamed from: a */
                public Chronology mo16406a(DateTimeZone dateTimeZone) {
                    return this;
                }

                @Override // org.joda.time.Chronology
                public String toString() {
                    return getClass().getName();
                }
            });
        }

        /* JADX INFO: renamed from: b */
        private static Map<String, String> m16554b() {
            HashMap map = new HashMap();
            map.put("GMT", "UTC");
            map.put("WET", "WET");
            map.put("CET", "CET");
            map.put("MET", "CET");
            map.put("ECT", "CET");
            map.put("EET", "EET");
            map.put("MIT", "Pacific/Apia");
            map.put("HST", "Pacific/Honolulu");
            map.put("AST", "America/Anchorage");
            map.put("PST", "America/Los_Angeles");
            map.put("MST", "America/Denver");
            map.put("PNT", "America/Phoenix");
            map.put("CST", "America/Chicago");
            map.put("EST", "America/New_York");
            map.put("IET", "America/Indiana/Indianapolis");
            map.put("PRT", "America/Puerto_Rico");
            map.put("CNT", "America/St_Johns");
            map.put("AGT", "America/Argentina/Buenos_Aires");
            map.put("BET", "America/Sao_Paulo");
            map.put("ART", "Africa/Cairo");
            map.put("CAT", "Africa/Harare");
            map.put("EAT", "Africa/Addis_Ababa");
            map.put("NET", "Asia/Yerevan");
            map.put("PLT", "Asia/Karachi");
            map.put("IST", "Asia/Kolkata");
            map.put("BST", "Asia/Dhaka");
            map.put("VST", "Asia/Ho_Chi_Minh");
            map.put("CTT", "Asia/Shanghai");
            map.put("JST", "Asia/Tokyo");
            map.put("ACT", "Australia/Darwin");
            map.put("AET", "Australia/Sydney");
            map.put("SST", "Pacific/Guadalcanal");
            map.put("NST", "Pacific/Auckland");
            return Collections.unmodifiableMap(map);
        }
    }
}
