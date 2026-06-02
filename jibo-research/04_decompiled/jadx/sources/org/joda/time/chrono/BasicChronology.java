package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.MillisDurationField;
import org.joda.time.field.OffsetDateTimeField;
import org.joda.time.field.PreciseDateTimeField;
import org.joda.time.field.PreciseDurationField;
import org.joda.time.field.RemainderDateTimeField;
import org.joda.time.field.ZeroIsMaxDateTimeField;

/* JADX INFO: loaded from: classes2.dex */
abstract class BasicChronology extends AssembledChronology {

    /* JADX INFO: renamed from: a */
    private static final DurationField f15872a = MillisDurationField.f16010a;

    /* JADX INFO: renamed from: b */
    private static final DurationField f15873b = new PreciseDurationField(DurationFieldType.m16562b(), 1000);

    /* JADX INFO: renamed from: c */
    private static final DurationField f15874c = new PreciseDurationField(DurationFieldType.m16563c(), 60000);

    /* JADX INFO: renamed from: d */
    private static final DurationField f15875d = new PreciseDurationField(DurationFieldType.m16564d(), 3600000);

    /* JADX INFO: renamed from: e */
    private static final DurationField f15876e = new PreciseDurationField(DurationFieldType.m16565e(), 43200000);

    /* JADX INFO: renamed from: f */
    private static final DurationField f15877f = new PreciseDurationField(DurationFieldType.m16566f(), 86400000);

    /* JADX INFO: renamed from: g */
    private static final DurationField f15878g = new PreciseDurationField(DurationFieldType.m16567g(), 604800000);

    /* JADX INFO: renamed from: h */
    private static final DateTimeField f15879h = new PreciseDateTimeField(DateTimeFieldType.m16486a(), f15872a, f15873b);

    /* JADX INFO: renamed from: i */
    private static final DateTimeField f15880i = new PreciseDateTimeField(DateTimeFieldType.m16487b(), f15872a, f15877f);

    /* JADX INFO: renamed from: j */
    private static final DateTimeField f15881j = new PreciseDateTimeField(DateTimeFieldType.m16488c(), f15873b, f15874c);

    /* JADX INFO: renamed from: k */
    private static final DateTimeField f15882k = new PreciseDateTimeField(DateTimeFieldType.m16489d(), f15873b, f15877f);

    /* JADX INFO: renamed from: l */
    private static final DateTimeField f15883l = new PreciseDateTimeField(DateTimeFieldType.m16490e(), f15874c, f15875d);

    /* JADX INFO: renamed from: m */
    private static final DateTimeField f15884m = new PreciseDateTimeField(DateTimeFieldType.m16491f(), f15874c, f15877f);

    /* JADX INFO: renamed from: n */
    private static final DateTimeField f15885n = new PreciseDateTimeField(DateTimeFieldType.m16492g(), f15875d, f15877f);

    /* JADX INFO: renamed from: o */
    private static final DateTimeField f15886o = new PreciseDateTimeField(DateTimeFieldType.m16494i(), f15875d, f15876e);

    /* JADX INFO: renamed from: p */
    private static final DateTimeField f15887p = new ZeroIsMaxDateTimeField(f15885n, DateTimeFieldType.m16493h());

    /* JADX INFO: renamed from: q */
    private static final DateTimeField f15888q = new ZeroIsMaxDateTimeField(f15886o, DateTimeFieldType.m16495j());

    /* JADX INFO: renamed from: r */
    private static final DateTimeField f15889r = new HalfdayField();

    /* JADX INFO: renamed from: s */
    private final transient YearInfo[] f15890s;

    /* JADX INFO: renamed from: t */
    private final int f15891t;

    /* JADX INFO: renamed from: Q */
    abstract int mo16629Q();

    /* JADX INFO: renamed from: R */
    abstract int mo16630R();

    /* JADX INFO: renamed from: T */
    abstract long mo16632T();

    /* JADX INFO: renamed from: U */
    abstract long mo16633U();

    /* JADX INFO: renamed from: V */
    abstract long mo16634V();

    /* JADX INFO: renamed from: W */
    abstract long mo16635W();

    /* JADX INFO: renamed from: a */
    abstract int mo16638a(long j, int i);

    /* JADX INFO: renamed from: b */
    abstract int mo16643b(int i, int i2);

    /* JADX INFO: renamed from: c */
    abstract long mo16650c(int i, int i2);

    /* JADX INFO: renamed from: e */
    abstract boolean mo16656e(int i);

    /* JADX INFO: renamed from: f */
    abstract long mo16658f(int i);

    /* JADX INFO: renamed from: f */
    abstract long mo16659f(long j, int i);

    BasicChronology(Chronology chronology, Object obj, int i) {
        super(chronology, obj);
        this.f15890s = new YearInfo[1024];
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("Invalid min days in first week: " + i);
        }
        this.f15891t = i;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public DateTimeZone mo16407a() {
        Chronology chronologyL = m16616L();
        return chronologyL != null ? chronologyL.mo16407a() : DateTimeZone.f15751a;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16402a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        Chronology chronologyL = m16616L();
        if (chronologyL != null) {
            return chronologyL.mo16402a(i, i2, i3, i4);
        }
        FieldUtils.m16756a(DateTimeFieldType.m16487b(), i4, 0, 86399999);
        return m16624b(i, i2, i3, i4);
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16403a(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        Chronology chronologyL = m16616L();
        if (chronologyL != null) {
            return chronologyL.mo16403a(i, i2, i3, i4, i5, i6, i7);
        }
        FieldUtils.m16756a(DateTimeFieldType.m16492g(), i4, 0, 23);
        FieldUtils.m16756a(DateTimeFieldType.m16490e(), i5, 0, 59);
        FieldUtils.m16756a(DateTimeFieldType.m16488c(), i6, 0, 59);
        FieldUtils.m16756a(DateTimeFieldType.m16486a(), i7, 0, 999);
        return m16624b(i, i2, i3, (3600000 * i4) + (60000 * i5) + (i6 * 1000) + i7);
    }

    /* JADX INFO: renamed from: b */
    private long m16624b(int i, int i2, int i3, int i4) {
        long jMo16646b;
        long jMo16646b2 = mo16646b(i, i2, i3);
        if (jMo16646b2 == Long.MIN_VALUE) {
            i4 -= 86400000;
            jMo16646b = mo16646b(i, i2, i3 + 1);
        } else {
            jMo16646b = jMo16646b2;
        }
        long j = ((long) i4) + jMo16646b;
        if (j < 0 && jMo16646b > 0) {
            return Long.MAX_VALUE;
        }
        if (j <= 0 || jMo16646b >= 0) {
            return j;
        }
        return Long.MIN_VALUE;
    }

    /* JADX INFO: renamed from: N */
    public int m16626N() {
        return this.f15891t;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BasicChronology basicChronology = (BasicChronology) obj;
        return m16626N() == basicChronology.m16626N() && mo16407a().equals(basicChronology.mo16407a());
    }

    public int hashCode() {
        return (getClass().getName().hashCode() * 11) + mo16407a().hashCode() + m16626N();
    }

    @Override // org.joda.time.Chronology
    public String toString() {
        StringBuilder sb = new StringBuilder(60);
        String name = getClass().getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            name = name.substring(iLastIndexOf + 1);
        }
        sb.append(name);
        sb.append('[');
        DateTimeZone dateTimeZoneMo16407a = mo16407a();
        if (dateTimeZoneMo16407a != null) {
            sb.append(dateTimeZoneMo16407a.m16548e());
        }
        if (m16626N() != 4) {
            sb.append(",mdfw=");
            sb.append(m16626N());
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // org.joda.time.chrono.AssembledChronology
    /* JADX INFO: renamed from: a */
    protected void mo16618a(AssembledChronology.Fields fields) {
        fields.f15846a = f15872a;
        fields.f15847b = f15873b;
        fields.f15848c = f15874c;
        fields.f15849d = f15875d;
        fields.f15850e = f15876e;
        fields.f15851f = f15877f;
        fields.f15852g = f15878g;
        fields.f15858m = f15879h;
        fields.f15859n = f15880i;
        fields.f15860o = f15881j;
        fields.f15861p = f15882k;
        fields.f15862q = f15883l;
        fields.f15863r = f15884m;
        fields.f15864s = f15885n;
        fields.f15866u = f15886o;
        fields.f15865t = f15887p;
        fields.f15867v = f15888q;
        fields.f15868w = f15889r;
        fields.f15841E = new BasicYearDateTimeField(this);
        fields.f15842F = new GJYearOfEraDateTimeField(fields.f15841E, this);
        fields.f15844H = new DividedDateTimeField(new OffsetDateTimeField(fields.f15842F, 99), DateTimeFieldType.m16507v(), 100);
        fields.f15856k = fields.f15844H.mo16453d();
        fields.f15843G = new OffsetDateTimeField(new RemainderDateTimeField((DividedDateTimeField) fields.f15844H), DateTimeFieldType.m16506u(), 1);
        fields.f15845I = new GJEraDateTimeField(this);
        fields.f15869x = new GJDayOfWeekDateTimeField(this, fields.f15851f);
        fields.f15870y = new BasicDayOfMonthDateTimeField(this, fields.f15851f);
        fields.f15871z = new BasicDayOfYearDateTimeField(this, fields.f15851f);
        fields.f15840D = new GJMonthOfYearDateTimeField(this);
        fields.f15838B = new BasicWeekyearDateTimeField(this);
        fields.f15837A = new BasicWeekOfWeekyearDateTimeField(this, fields.f15852g);
        fields.f15839C = new OffsetDateTimeField(new RemainderDateTimeField(fields.f15838B, fields.f15856k, DateTimeFieldType.m16502q(), 100), DateTimeFieldType.m16502q(), 1);
        fields.f15855j = fields.f15841E.mo16453d();
        fields.f15854i = fields.f15840D.mo16453d();
        fields.f15853h = fields.f15838B.mo16453d();
    }

    /* JADX INFO: renamed from: O */
    int m16627O() {
        return 366;
    }

    /* JADX INFO: renamed from: a */
    int m16636a(int i) {
        return mo16656e(i) ? 366 : 365;
    }

    /* JADX INFO: renamed from: b */
    int m16642b(int i) {
        return (int) ((m16649c(i + 1) - m16649c(i)) / 604800000);
    }

    /* JADX INFO: renamed from: c */
    long m16649c(int i) {
        long jM16653d = m16653d(i);
        int iM16661g = m16661g(jM16653d);
        return iM16661g > 8 - this.f15891t ? jM16653d + (((long) (8 - iM16661g)) * 86400000) : jM16653d - (((long) (iM16661g - 1)) * 86400000);
    }

    /* JADX INFO: renamed from: d */
    long m16653d(int i) {
        return m16625h(i).f15893b;
    }

    /* JADX INFO: renamed from: a */
    long m16640a(int i, int i2) {
        return m16653d(i) + mo16650c(i, i2);
    }

    /* JADX INFO: renamed from: a */
    long m16641a(int i, int i2, int i3) {
        return m16653d(i) + mo16650c(i, i2) + (((long) (i3 - 1)) * 86400000);
    }

    /* JADX INFO: renamed from: a */
    int m16637a(long j) {
        long jMo16633U = mo16633U();
        long jMo16635W = (j >> 1) + mo16635W();
        if (jMo16635W < 0) {
            jMo16635W = (jMo16635W - jMo16633U) + 1;
        }
        int i = (int) (jMo16635W / jMo16633U);
        long jM16653d = m16653d(i);
        long j2 = j - jM16653d;
        if (j2 < 0) {
            return i - 1;
        }
        if (j2 < 31536000000L) {
            return i;
        }
        if ((mo16656e(i) ? 31622400000L : 31536000000L) + jM16653d <= j) {
            return i + 1;
        }
        return i;
    }

    /* JADX INFO: renamed from: b */
    int m16644b(long j) {
        return mo16638a(j, m16637a(j));
    }

    /* JADX INFO: renamed from: c */
    int m16647c(long j) {
        int iM16637a = m16637a(j);
        return m16639a(j, iM16637a, mo16638a(j, iM16637a));
    }

    /* JADX INFO: renamed from: b */
    int m16645b(long j, int i) {
        return m16639a(j, i, mo16638a(j, i));
    }

    /* JADX INFO: renamed from: a */
    int m16639a(long j, int i, int i2) {
        return ((int) ((j - (m16653d(i) + mo16650c(i, i2))) / 86400000)) + 1;
    }

    /* JADX INFO: renamed from: d */
    int m16651d(long j) {
        return m16648c(j, m16637a(j));
    }

    /* JADX INFO: renamed from: c */
    int m16648c(long j, int i) {
        return ((int) ((j - m16653d(i)) / 86400000)) + 1;
    }

    /* JADX INFO: renamed from: e */
    int m16654e(long j) {
        int iM16637a = m16637a(j);
        int iM16652d = m16652d(j, iM16637a);
        if (iM16652d == 1) {
            return m16637a(604800000 + j);
        }
        if (iM16652d > 51) {
            return m16637a(j - 1209600000);
        }
        return iM16637a;
    }

    /* JADX INFO: renamed from: f */
    int m16657f(long j) {
        return m16652d(j, m16637a(j));
    }

    /* JADX INFO: renamed from: d */
    int m16652d(long j, int i) {
        long jM16649c = m16649c(i);
        if (j < jM16649c) {
            return m16642b(i - 1);
        }
        if (j >= m16649c(i + 1)) {
            return 1;
        }
        return ((int) ((j - jM16649c) / 604800000)) + 1;
    }

    /* JADX INFO: renamed from: g */
    int m16661g(long j) {
        long j2;
        if (j >= 0) {
            j2 = j / 86400000;
        } else {
            j2 = (j - 86399999) / 86400000;
            if (j2 < -3) {
                return ((int) ((j2 + 4) % 7)) + 7;
            }
        }
        return ((int) ((j2 + 3) % 7)) + 1;
    }

    /* JADX INFO: renamed from: h */
    int m16662h(long j) {
        return j >= 0 ? (int) (j % 86400000) : 86399999 + ((int) ((1 + j) % 86400000));
    }

    /* JADX INFO: renamed from: P */
    int m16628P() {
        return 31;
    }

    /* JADX INFO: renamed from: i */
    int m16663i(long j) {
        int iM16637a = m16637a(j);
        return mo16643b(iM16637a, mo16638a(j, iM16637a));
    }

    /* JADX INFO: renamed from: e */
    int mo16655e(long j, int i) {
        return m16663i(j);
    }

    /* JADX INFO: renamed from: b */
    long mo16646b(int i, int i2, int i3) {
        FieldUtils.m16756a(DateTimeFieldType.m16504s(), i, mo16629Q() - 1, mo16630R() + 1);
        FieldUtils.m16756a(DateTimeFieldType.m16503r(), i2, 1, m16660g(i));
        FieldUtils.m16756a(DateTimeFieldType.m16498m(), i3, 1, mo16643b(i, i2));
        long jM16641a = m16641a(i, i2, i3);
        if (jM16641a < 0 && i == mo16630R() + 1) {
            return Long.MAX_VALUE;
        }
        if (jM16641a > 0 && i == mo16629Q() - 1) {
            return Long.MIN_VALUE;
        }
        return jM16641a;
    }

    /* JADX INFO: renamed from: j */
    boolean mo16664j(long j) {
        return false;
    }

    /* JADX INFO: renamed from: g */
    int m16660g(int i) {
        return m16631S();
    }

    /* JADX INFO: renamed from: S */
    int m16631S() {
        return 12;
    }

    /* JADX INFO: renamed from: h */
    private YearInfo m16625h(int i) {
        YearInfo yearInfo = this.f15890s[i & 1023];
        if (yearInfo == null || yearInfo.f15892a != i) {
            YearInfo yearInfo2 = new YearInfo(i, mo16658f(i));
            this.f15890s[i & 1023] = yearInfo2;
            return yearInfo2;
        }
        return yearInfo;
    }

    private static class HalfdayField extends PreciseDateTimeField {
        HalfdayField() {
            super(DateTimeFieldType.m16496k(), BasicChronology.f15876e, BasicChronology.f15877f);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public String mo16439a(int i, Locale locale) {
            return GJLocaleSymbols.m16683a(locale).m16702f(i);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public long mo16438a(long j, String str, Locale locale) {
            return mo16443b(j, GJLocaleSymbols.m16683a(locale).m16699d(str));
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public int mo16435a(Locale locale) {
            return GJLocaleSymbols.m16683a(locale).m16698d();
        }
    }

    private static class YearInfo {

        /* JADX INFO: renamed from: a */
        public final int f15892a;

        /* JADX INFO: renamed from: b */
        public final long f15893b;

        YearInfo(int i, long j) {
            this.f15892a = i;
            this.f15893b = j;
        }
    }
}
