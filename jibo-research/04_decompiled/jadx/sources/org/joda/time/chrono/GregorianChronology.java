package org.joda.time.chrono;

import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;

/* JADX INFO: loaded from: classes2.dex */
public final class GregorianChronology extends BasicGJChronology {

    /* JADX INFO: renamed from: b */
    private static final ConcurrentHashMap<DateTimeZone, GregorianChronology[]> f15949b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a */
    private static final GregorianChronology f15948a = m16705b(DateTimeZone.f15751a);

    /* JADX INFO: renamed from: Z */
    public static GregorianChronology m16703Z() {
        return f15948a;
    }

    /* JADX INFO: renamed from: b */
    public static GregorianChronology m16705b(DateTimeZone dateTimeZone) {
        return m16704a(dateTimeZone, 4);
    }

    /* JADX INFO: renamed from: a */
    public static GregorianChronology m16704a(DateTimeZone dateTimeZone, int i) {
        GregorianChronology[] gregorianChronologyArr;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.m16523a();
        }
        GregorianChronology[] gregorianChronologyArr2 = f15949b.get(dateTimeZone);
        if (gregorianChronologyArr2 == null) {
            gregorianChronologyArr = new GregorianChronology[7];
            GregorianChronology[] gregorianChronologyArrPutIfAbsent = f15949b.putIfAbsent(dateTimeZone, gregorianChronologyArr);
            if (gregorianChronologyArrPutIfAbsent != null) {
                gregorianChronologyArr = gregorianChronologyArrPutIfAbsent;
            }
        } else {
            gregorianChronologyArr = gregorianChronologyArr2;
        }
        try {
            GregorianChronology gregorianChronology = gregorianChronologyArr[i - 1];
            if (gregorianChronology == null) {
                synchronized (gregorianChronologyArr) {
                    gregorianChronology = gregorianChronologyArr[i - 1];
                    if (gregorianChronology == null) {
                        if (dateTimeZone == DateTimeZone.f15751a) {
                            gregorianChronology = new GregorianChronology(null, null, i);
                        } else {
                            gregorianChronology = new GregorianChronology(ZonedChronology.m16721a(m16704a(DateTimeZone.f15751a, i), dateTimeZone), null, i);
                        }
                        gregorianChronologyArr[i - 1] = gregorianChronology;
                    }
                }
            }
            return gregorianChronology;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid min days in first week: " + i);
        }
    }

    private GregorianChronology(Chronology chronology, Object obj, int i) {
        super(chronology, obj, i);
    }

    private Object readResolve() {
        Chronology chronologyL = m16616L();
        int iN = m16626N();
        if (iN == 0) {
            iN = 4;
        }
        return chronologyL == null ? m16704a(DateTimeZone.f15751a, iN) : m16704a(chronologyL.mo16407a(), iN);
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: b */
    public Chronology mo16408b() {
        return f15948a;
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public Chronology mo16406a(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.m16523a();
        }
        return dateTimeZone == mo16407a() ? this : m16705b(dateTimeZone);
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.AssembledChronology
    /* JADX INFO: renamed from: a */
    protected void mo16618a(AssembledChronology.Fields fields) {
        if (m16616L() == null) {
            super.mo16618a(fields);
        }
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: e */
    boolean mo16656e(int i) {
        return (i & 3) == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: f */
    long mo16658f(int i) {
        int i2;
        int i3 = i / 100;
        if (i < 0) {
            i2 = (((i3 + 3) >> 2) + (((i + 3) >> 2) - i3)) - 1;
        } else {
            i2 = (i3 >> 2) + ((i >> 2) - i3);
            if (mo16656e(i)) {
                i2--;
            }
        }
        return (((long) (i2 - 719527)) + (((long) i) * 365)) * 86400000;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: Q */
    int mo16629Q() {
        return -292275054;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: R */
    int mo16630R() {
        return 292278993;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: T */
    long mo16632T() {
        return 31556952000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: U */
    long mo16633U() {
        return 15778476000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: V */
    long mo16634V() {
        return 2629746000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: W */
    long mo16635W() {
        return 31083597720000L;
    }
}
