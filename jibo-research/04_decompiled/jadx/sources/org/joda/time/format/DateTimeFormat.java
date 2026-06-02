package org.joda.time.format;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class DateTimeFormat {

    /* JADX INFO: renamed from: a */
    private static final ConcurrentHashMap<String, DateTimeFormatter> f16034a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b */
    private static final AtomicReferenceArray<DateTimeFormatter> f16035b = new AtomicReferenceArray<>(25);

    /* JADX INFO: renamed from: a */
    public static DateTimeFormatter m16769a(String str) {
        return m16772c(str);
    }

    /* JADX INFO: renamed from: a */
    private static void m16770a(DateTimeFormatterBuilder dateTimeFormatterBuilder, String str) {
        int length = str.length();
        int[] iArr = new int[1];
        int i = 0;
        while (i < length) {
            iArr[0] = i;
            String strM16768a = m16768a(str, iArr);
            int i2 = iArr[0];
            int length2 = strM16768a.length();
            if (length2 != 0) {
                char cCharAt = strM16768a.charAt(0);
                switch (cCharAt) {
                    case '\'':
                        String strSubstring = strM16768a.substring(1);
                        if (strSubstring.length() == 1) {
                            dateTimeFormatterBuilder.m16803a(strSubstring.charAt(0));
                        } else {
                            dateTimeFormatterBuilder.m16807a(new String(strSubstring));
                        }
                        break;
                    case 'C':
                        dateTimeFormatterBuilder.m16839g(length2, length2);
                        break;
                    case 'D':
                        dateTimeFormatterBuilder.m16843i(length2);
                        break;
                    case 'E':
                        if (length2 >= 4) {
                            dateTimeFormatterBuilder.m16828d();
                        } else {
                            dateTimeFormatterBuilder.m16831e();
                        }
                        break;
                    case 'G':
                        dateTimeFormatterBuilder.m16840h();
                        break;
                    case 'H':
                        dateTimeFormatterBuilder.m16825c(length2);
                        break;
                    case 'K':
                        dateTimeFormatterBuilder.m16832e(length2);
                        break;
                    case 'M':
                        if (length2 >= 3) {
                            if (length2 >= 4) {
                                dateTimeFormatterBuilder.m16834f();
                            } else {
                                dateTimeFormatterBuilder.m16837g();
                            }
                        } else {
                            dateTimeFormatterBuilder.m16846k(length2);
                        }
                        break;
                    case 'S':
                        dateTimeFormatterBuilder.m16805a(length2, length2);
                        break;
                    case 'Y':
                    case 'x':
                    case 'y':
                        if (length2 == 2) {
                            boolean z = true;
                            if (i2 + 1 < length) {
                                iArr[0] = iArr[0] + 1;
                                if (m16771b(m16768a(str, iArr))) {
                                    z = false;
                                }
                                iArr[0] = iArr[0] - 1;
                            }
                            switch (cCharAt) {
                                case 'x':
                                    dateTimeFormatterBuilder.m16819b(new DateTime().m16606g() - 30, z);
                                    break;
                                default:
                                    dateTimeFormatterBuilder.m16806a(new DateTime().m16605f() - 30, z);
                                    break;
                            }
                        } else {
                            if (i2 + 1 < length) {
                                iArr[0] = iArr[0] + 1;
                                i = m16771b(m16768a(str, iArr)) ? length2 : 9;
                                iArr[0] = iArr[0] - 1;
                            }
                            switch (cCharAt) {
                                case 'Y':
                                    dateTimeFormatterBuilder.m16836f(length2, i);
                                    break;
                                case 'x':
                                    dateTimeFormatterBuilder.m16830d(length2, i);
                                    break;
                                case 'y':
                                    dateTimeFormatterBuilder.m16833e(length2, i);
                                    break;
                            }
                        }
                        break;
                    case 'Z':
                        if (length2 == 1) {
                            dateTimeFormatterBuilder.m16808a(null, "Z", false, 2, 2);
                        } else if (length2 == 2) {
                            dateTimeFormatterBuilder.m16808a(null, "Z", true, 2, 2);
                        } else {
                            dateTimeFormatterBuilder.m16844j();
                        }
                        break;
                    case 'a':
                        dateTimeFormatterBuilder.m16824c();
                        break;
                    case 'd':
                        dateTimeFormatterBuilder.m16841h(length2);
                        break;
                    case 'e':
                        dateTimeFormatterBuilder.m16838g(length2);
                        break;
                    case 'h':
                        dateTimeFormatterBuilder.m16835f(length2);
                        break;
                    case 'k':
                        dateTimeFormatterBuilder.m16829d(length2);
                        break;
                    case 'm':
                        dateTimeFormatterBuilder.m16817b(length2);
                        break;
                    case 's':
                        dateTimeFormatterBuilder.m16804a(length2);
                        break;
                    case 'w':
                        dateTimeFormatterBuilder.m16845j(length2);
                        break;
                    case 'z':
                        if (length2 >= 4) {
                            dateTimeFormatterBuilder.m16842i();
                        } else {
                            dateTimeFormatterBuilder.m16810a((Map<String, DateTimeZone>) null);
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Illegal pattern component: " + strM16768a);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m16768a(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i = iArr[0];
        int length = str.length();
        char cCharAt = str.charAt(i);
        if ((cCharAt >= 'A' && cCharAt <= 'Z') || (cCharAt >= 'a' && cCharAt <= 'z')) {
            sb.append(cCharAt);
            while (i + 1 < length && str.charAt(i + 1) == cCharAt) {
                sb.append(cCharAt);
                i++;
            }
        } else {
            sb.append('\'');
            boolean z = false;
            while (i < length) {
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 == '\'') {
                    if (i + 1 < length && str.charAt(i + 1) == '\'') {
                        i++;
                        sb.append(cCharAt2);
                    } else {
                        z = !z;
                    }
                } else {
                    if (!z && ((cCharAt2 >= 'A' && cCharAt2 <= 'Z') || (cCharAt2 >= 'a' && cCharAt2 <= 'z'))) {
                        i--;
                        break;
                    }
                    sb.append(cCharAt2);
                }
                i++;
            }
        }
        iArr[0] = i;
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    private static boolean m16771b(String str) {
        int length = str.length();
        if (length <= 0) {
            return false;
        }
        switch (str.charAt(0)) {
            case 'C':
            case 'D':
            case 'F':
            case 'H':
            case 'K':
            case 'S':
            case 'W':
            case 'Y':
            case 'c':
            case 'd':
            case 'e':
            case 'h':
            case 'k':
            case 'm':
            case 's':
            case 'w':
            case 'x':
            case 'y':
                return true;
            case 'M':
                return length <= 2;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: c */
    private static DateTimeFormatter m16772c(String str) {
        DateTimeFormatter dateTimeFormatterPutIfAbsent;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid pattern specification");
        }
        DateTimeFormatter dateTimeFormatter = f16034a.get(str);
        if (dateTimeFormatter == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
            m16770a(dateTimeFormatterBuilder, str);
            DateTimeFormatter dateTimeFormatterM16802a = dateTimeFormatterBuilder.m16802a();
            return (f16034a.size() >= 500 || (dateTimeFormatterPutIfAbsent = f16034a.putIfAbsent(str, dateTimeFormatterM16802a)) == null) ? dateTimeFormatterM16802a : dateTimeFormatterPutIfAbsent;
        }
        return dateTimeFormatter;
    }
}
