package org.joda.time.chrono;

import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.SkipDateTimeField;

/* JADX INFO: loaded from: classes2.dex */
public final class JulianChronology extends BasicGJChronology {

    /* JADX INFO: renamed from: b */
    private static final ConcurrentHashMap<DateTimeZone, JulianChronology[]> f15955b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a */
    private static final JulianChronology f15954a = m16710b(DateTimeZone.f15751a);

    /* JADX INFO: renamed from: h */
    static int m16711h(int i) {
        if (i <= 0) {
            if (i == 0) {
                throw new IllegalFieldValueException(DateTimeFieldType.m16504s(), Integer.valueOf(i), null, null);
            }
            return i + 1;
        }
        return i;
    }

    /* JADX INFO: renamed from: b */
    public static JulianChronology m16710b(DateTimeZone dateTimeZone) {
        return m16709a(dateTimeZone, 4);
    }

    /* JADX INFO: renamed from: a */
    public static JulianChronology m16709a(DateTimeZone dateTimeZone, int i) {
        JulianChronology[] julianChronologyArr;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.m16523a();
        }
        JulianChronology[] julianChronologyArr2 = f15955b.get(dateTimeZone);
        if (julianChronologyArr2 == null) {
            julianChronologyArr = new JulianChronology[7];
            JulianChronology[] julianChronologyArrPutIfAbsent = f15955b.putIfAbsent(dateTimeZone, julianChronologyArr);
            if (julianChronologyArrPutIfAbsent != null) {
                julianChronologyArr = julianChronologyArrPutIfAbsent;
            }
        } else {
            julianChronologyArr = julianChronologyArr2;
        }
        try {
            JulianChronology julianChronology = julianChronologyArr[i - 1];
            if (julianChronology == null) {
                synchronized (julianChronologyArr) {
                    julianChronology = julianChronologyArr[i - 1];
                    if (julianChronology == null) {
                        if (dateTimeZone == DateTimeZone.f15751a) {
                            julianChronology = new JulianChronology(null, null, i);
                        } else {
                            julianChronology = new JulianChronology(ZonedChronology.m16721a(m16709a(DateTimeZone.f15751a, i), dateTimeZone), null, i);
                        }
                        julianChronologyArr[i - 1] = julianChronology;
                    }
                }
            }
            return julianChronology;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid min days in first week: " + i);
        }
    }

    JulianChronology(Chronology chronology, Object obj, int i) {
        super(chronology, obj, i);
    }

    private Object readResolve() {
        Chronology chronologyL = m16616L();
        int iN = m16626N();
        if (iN == 0) {
            iN = 4;
        }
        return chronologyL == null ? m16709a(DateTimeZone.f15751a, iN) : m16709a(chronologyL.mo16407a(), iN);
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: b */
    public Chronology mo16408b() {
        return f15954a;
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public Chronology mo16406a(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.m16523a();
        }
        return dateTimeZone == mo16407a() ? this : m16710b(dateTimeZone);
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: b */
    long mo16646b(int i, int i2, int i3) throws IllegalArgumentException {
        return super.mo16646b(m16711h(i), i2, i3);
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: e */
    boolean mo16656e(int i) {
        return (i & 3) == 0;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: f */
    long mo16658f(int i) {
        int i2;
        int i3 = i - 1968;
        if (i3 <= 0) {
            i2 = (i3 + 3) >> 2;
        } else {
            i2 = i3 >> 2;
            if (!mo16656e(i)) {
                i2++;
            }
        }
        return ((((long) i2) + (((long) i3) * 365)) * 86400000) - 62035200000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: Q */
    int mo16629Q() {
        return -292269054;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: R */
    int mo16630R() {
        return 292272992;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: T */
    long mo16632T() {
        return 31557600000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: U */
    long mo16633U() {
        return 15778800000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: V */
    long mo16634V() {
        return 2629800000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    /* JADX INFO: renamed from: W */
    long mo16635W() {
        return 31083663600000L;
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.AssembledChronology
    /* JADX INFO: renamed from: a */
    protected void mo16618a(AssembledChronology.Fields fields) {
        if (m16616L() == null) {
            super.mo16618a(fields);
            fields.f15841E = new SkipDateTimeField(this, fields.f15841E);
            fields.f15838B = new SkipDateTimeField(this, fields.f15838B);
        }
    }
}
