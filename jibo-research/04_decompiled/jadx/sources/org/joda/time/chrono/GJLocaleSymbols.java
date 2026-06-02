package org.joda.time.chrono;

import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.IllegalFieldValueException;

/* JADX INFO: loaded from: classes2.dex */
class GJLocaleSymbols {

    /* JADX INFO: renamed from: a */
    private static ConcurrentMap<Locale, GJLocaleSymbols> f15931a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b */
    private final String[] f15932b;

    /* JADX INFO: renamed from: c */
    private final String[] f15933c;

    /* JADX INFO: renamed from: d */
    private final String[] f15934d;

    /* JADX INFO: renamed from: e */
    private final String[] f15935e;

    /* JADX INFO: renamed from: f */
    private final String[] f15936f;

    /* JADX INFO: renamed from: g */
    private final String[] f15937g;

    /* JADX INFO: renamed from: h */
    private final TreeMap<String, Integer> f15938h;

    /* JADX INFO: renamed from: i */
    private final TreeMap<String, Integer> f15939i;

    /* JADX INFO: renamed from: j */
    private final TreeMap<String, Integer> f15940j;

    /* JADX INFO: renamed from: k */
    private final int f15941k;

    /* JADX INFO: renamed from: l */
    private final int f15942l;

    /* JADX INFO: renamed from: m */
    private final int f15943m;

    /* JADX INFO: renamed from: n */
    private final int f15944n;

    /* JADX INFO: renamed from: o */
    private final int f15945o;

    /* JADX INFO: renamed from: p */
    private final int f15946p;

    /* JADX INFO: renamed from: a */
    static GJLocaleSymbols m16683a(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        GJLocaleSymbols gJLocaleSymbols = f15931a.get(locale);
        if (gJLocaleSymbols == null) {
            GJLocaleSymbols gJLocaleSymbols2 = new GJLocaleSymbols(locale);
            GJLocaleSymbols gJLocaleSymbolsPutIfAbsent = f15931a.putIfAbsent(locale, gJLocaleSymbols2);
            return gJLocaleSymbolsPutIfAbsent != null ? gJLocaleSymbolsPutIfAbsent : gJLocaleSymbols2;
        }
        return gJLocaleSymbols;
    }

    /* JADX INFO: renamed from: a */
    private static String[] m16686a(String[] strArr) {
        String[] strArr2 = new String[13];
        for (int i = 1; i < 13; i++) {
            strArr2[i] = strArr[i - 1];
        }
        return strArr2;
    }

    /* JADX INFO: renamed from: b */
    private static String[] m16687b(String[] strArr) {
        String[] strArr2 = new String[8];
        int i = 1;
        while (i < 8) {
            strArr2[i] = strArr[i < 7 ? i + 1 : 1];
            i++;
        }
        return strArr2;
    }

    /* JADX INFO: renamed from: a */
    private static void m16685a(TreeMap<String, Integer> treeMap, String[] strArr, Integer[] numArr) {
        int length = strArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                String str = strArr[length];
                if (str != null) {
                    treeMap.put(str, numArr[length]);
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m16684a(TreeMap<String, Integer> treeMap, int i, int i2, Integer[] numArr) {
        while (i <= i2) {
            treeMap.put(String.valueOf(i).intern(), numArr[i]);
            i++;
        }
    }

    /* JADX INFO: renamed from: c */
    private static int m16688c(String[] strArr) {
        int length;
        int i = 0;
        int length2 = strArr.length;
        while (true) {
            int i2 = length2 - 1;
            if (i2 >= 0) {
                String str = strArr[i2];
                if (str == null || (length = str.length()) <= i) {
                    length = i;
                }
                i = length;
                length2 = i2;
            } else {
                return i;
            }
        }
    }

    private GJLocaleSymbols(Locale locale) {
        DateFormatSymbols dateFormatSymbolsM16515a = DateTimeUtils.m16515a(locale);
        this.f15932b = dateFormatSymbolsM16515a.getEras();
        this.f15933c = m16687b(dateFormatSymbolsM16515a.getWeekdays());
        this.f15934d = m16687b(dateFormatSymbolsM16515a.getShortWeekdays());
        this.f15935e = m16686a(dateFormatSymbolsM16515a.getMonths());
        this.f15936f = m16686a(dateFormatSymbolsM16515a.getShortMonths());
        this.f15937g = dateFormatSymbolsM16515a.getAmPmStrings();
        Integer[] numArr = new Integer[13];
        for (int i = 0; i < 13; i++) {
            numArr[i] = Integer.valueOf(i);
        }
        this.f15938h = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        m16685a(this.f15938h, this.f15932b, numArr);
        if ("en".equals(locale.getLanguage())) {
            this.f15938h.put("BCE", numArr[0]);
            this.f15938h.put("CE", numArr[1]);
        }
        this.f15939i = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        m16685a(this.f15939i, this.f15933c, numArr);
        m16685a(this.f15939i, this.f15934d, numArr);
        m16684a(this.f15939i, 1, 7, numArr);
        this.f15940j = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        m16685a(this.f15940j, this.f15935e, numArr);
        m16685a(this.f15940j, this.f15936f, numArr);
        m16684a(this.f15940j, 1, 12, numArr);
        this.f15941k = m16688c(this.f15932b);
        this.f15942l = m16688c(this.f15933c);
        this.f15943m = m16688c(this.f15934d);
        this.f15944n = m16688c(this.f15935e);
        this.f15945o = m16688c(this.f15936f);
        this.f15946p = m16688c(this.f15937g);
    }

    /* JADX INFO: renamed from: a */
    public String m16691a(int i) {
        return this.f15932b[i];
    }

    /* JADX INFO: renamed from: a */
    public int m16690a(String str) {
        Integer num = this.f15938h.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(DateTimeFieldType.m16508w(), str);
    }

    /* JADX INFO: renamed from: a */
    public int m16689a() {
        return this.f15941k;
    }

    /* JADX INFO: renamed from: b */
    public String m16694b(int i) {
        return this.f15935e[i];
    }

    /* JADX INFO: renamed from: c */
    public String m16697c(int i) {
        return this.f15936f[i];
    }

    /* JADX INFO: renamed from: b */
    public int m16693b(String str) {
        Integer num = this.f15940j.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(DateTimeFieldType.m16503r(), str);
    }

    /* JADX INFO: renamed from: b */
    public int m16692b() {
        return this.f15944n;
    }

    /* JADX INFO: renamed from: d */
    public String m16700d(int i) {
        return this.f15933c[i];
    }

    /* JADX INFO: renamed from: e */
    public String m16701e(int i) {
        return this.f15934d[i];
    }

    /* JADX INFO: renamed from: c */
    public int m16696c(String str) {
        Integer num = this.f15939i.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(DateTimeFieldType.m16497l(), str);
    }

    /* JADX INFO: renamed from: c */
    public int m16695c() {
        return this.f15942l;
    }

    /* JADX INFO: renamed from: f */
    public String m16702f(int i) {
        return this.f15937g[i];
    }

    /* JADX INFO: renamed from: d */
    public int m16699d(String str) {
        String[] strArr = this.f15937g;
        int length = strArr.length;
        do {
            length--;
            if (length < 0) {
                throw new IllegalFieldValueException(DateTimeFieldType.m16496k(), str);
            }
        } while (!strArr[length].equalsIgnoreCase(str));
        return length;
    }

    /* JADX INFO: renamed from: d */
    public int m16698d() {
        return this.f15946p;
    }
}
