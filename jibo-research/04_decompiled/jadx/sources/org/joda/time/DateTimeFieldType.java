package org.joda.time;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DateTimeFieldType implements Serializable {

    /* JADX INFO: renamed from: a */
    private static final DateTimeFieldType f15721a = new StandardDateTimeFieldType("era", (byte) 1, DurationFieldType.m16572l(), null);

    /* JADX INFO: renamed from: b */
    private static final DateTimeFieldType f15722b = new StandardDateTimeFieldType("yearOfEra", (byte) 2, DurationFieldType.m16570j(), DurationFieldType.m16572l());

    /* JADX INFO: renamed from: c */
    private static final DateTimeFieldType f15723c = new StandardDateTimeFieldType("centuryOfEra", (byte) 3, DurationFieldType.m16571k(), DurationFieldType.m16572l());

    /* JADX INFO: renamed from: d */
    private static final DateTimeFieldType f15724d = new StandardDateTimeFieldType("yearOfCentury", (byte) 4, DurationFieldType.m16570j(), DurationFieldType.m16571k());

    /* JADX INFO: renamed from: e */
    private static final DateTimeFieldType f15725e = new StandardDateTimeFieldType("year", (byte) 5, DurationFieldType.m16570j(), null);

    /* JADX INFO: renamed from: f */
    private static final DateTimeFieldType f15726f = new StandardDateTimeFieldType("dayOfYear", (byte) 6, DurationFieldType.m16566f(), DurationFieldType.m16570j());

    /* JADX INFO: renamed from: g */
    private static final DateTimeFieldType f15727g = new StandardDateTimeFieldType("monthOfYear", (byte) 7, DurationFieldType.m16569i(), DurationFieldType.m16570j());

    /* JADX INFO: renamed from: h */
    private static final DateTimeFieldType f15728h = new StandardDateTimeFieldType("dayOfMonth", (byte) 8, DurationFieldType.m16566f(), DurationFieldType.m16569i());

    /* JADX INFO: renamed from: i */
    private static final DateTimeFieldType f15729i = new StandardDateTimeFieldType("weekyearOfCentury", (byte) 9, DurationFieldType.m16568h(), DurationFieldType.m16571k());

    /* JADX INFO: renamed from: j */
    private static final DateTimeFieldType f15730j = new StandardDateTimeFieldType("weekyear", (byte) 10, DurationFieldType.m16568h(), null);

    /* JADX INFO: renamed from: k */
    private static final DateTimeFieldType f15731k = new StandardDateTimeFieldType("weekOfWeekyear", (byte) 11, DurationFieldType.m16567g(), DurationFieldType.m16568h());

    /* JADX INFO: renamed from: l */
    private static final DateTimeFieldType f15732l = new StandardDateTimeFieldType("dayOfWeek", (byte) 12, DurationFieldType.m16566f(), DurationFieldType.m16567g());

    /* JADX INFO: renamed from: m */
    private static final DateTimeFieldType f15733m = new StandardDateTimeFieldType("halfdayOfDay", (byte) 13, DurationFieldType.m16565e(), DurationFieldType.m16566f());

    /* JADX INFO: renamed from: n */
    private static final DateTimeFieldType f15734n = new StandardDateTimeFieldType("hourOfHalfday", (byte) 14, DurationFieldType.m16564d(), DurationFieldType.m16565e());

    /* JADX INFO: renamed from: o */
    private static final DateTimeFieldType f15735o = new StandardDateTimeFieldType("clockhourOfHalfday", (byte) 15, DurationFieldType.m16564d(), DurationFieldType.m16565e());

    /* JADX INFO: renamed from: p */
    private static final DateTimeFieldType f15736p = new StandardDateTimeFieldType("clockhourOfDay", (byte) 16, DurationFieldType.m16564d(), DurationFieldType.m16566f());

    /* JADX INFO: renamed from: q */
    private static final DateTimeFieldType f15737q = new StandardDateTimeFieldType("hourOfDay", (byte) 17, DurationFieldType.m16564d(), DurationFieldType.m16566f());

    /* JADX INFO: renamed from: r */
    private static final DateTimeFieldType f15738r = new StandardDateTimeFieldType("minuteOfDay", (byte) 18, DurationFieldType.m16563c(), DurationFieldType.m16566f());

    /* JADX INFO: renamed from: s */
    private static final DateTimeFieldType f15739s = new StandardDateTimeFieldType("minuteOfHour", (byte) 19, DurationFieldType.m16563c(), DurationFieldType.m16564d());

    /* JADX INFO: renamed from: t */
    private static final DateTimeFieldType f15740t = new StandardDateTimeFieldType("secondOfDay", (byte) 20, DurationFieldType.m16562b(), DurationFieldType.m16566f());

    /* JADX INFO: renamed from: u */
    private static final DateTimeFieldType f15741u = new StandardDateTimeFieldType("secondOfMinute", (byte) 21, DurationFieldType.m16562b(), DurationFieldType.m16563c());

    /* JADX INFO: renamed from: v */
    private static final DateTimeFieldType f15742v = new StandardDateTimeFieldType("millisOfDay", (byte) 22, DurationFieldType.m16561a(), DurationFieldType.m16566f());

    /* JADX INFO: renamed from: w */
    private static final DateTimeFieldType f15743w = new StandardDateTimeFieldType("millisOfSecond", (byte) 23, DurationFieldType.m16561a(), DurationFieldType.m16562b());

    /* JADX INFO: renamed from: x */
    private final String f15744x;

    /* JADX INFO: renamed from: a */
    public abstract DateTimeField mo16509a(Chronology chronology);

    /* JADX INFO: renamed from: y */
    public abstract DurationFieldType mo16511y();

    /* JADX INFO: renamed from: z */
    public abstract DurationFieldType mo16512z();

    protected DateTimeFieldType(String str) {
        this.f15744x = str;
    }

    /* JADX INFO: renamed from: a */
    public static DateTimeFieldType m16486a() {
        return f15743w;
    }

    /* JADX INFO: renamed from: b */
    public static DateTimeFieldType m16487b() {
        return f15742v;
    }

    /* JADX INFO: renamed from: c */
    public static DateTimeFieldType m16488c() {
        return f15741u;
    }

    /* JADX INFO: renamed from: d */
    public static DateTimeFieldType m16489d() {
        return f15740t;
    }

    /* JADX INFO: renamed from: e */
    public static DateTimeFieldType m16490e() {
        return f15739s;
    }

    /* JADX INFO: renamed from: f */
    public static DateTimeFieldType m16491f() {
        return f15738r;
    }

    /* JADX INFO: renamed from: g */
    public static DateTimeFieldType m16492g() {
        return f15737q;
    }

    /* JADX INFO: renamed from: h */
    public static DateTimeFieldType m16493h() {
        return f15736p;
    }

    /* JADX INFO: renamed from: i */
    public static DateTimeFieldType m16494i() {
        return f15734n;
    }

    /* JADX INFO: renamed from: j */
    public static DateTimeFieldType m16495j() {
        return f15735o;
    }

    /* JADX INFO: renamed from: k */
    public static DateTimeFieldType m16496k() {
        return f15733m;
    }

    /* JADX INFO: renamed from: l */
    public static DateTimeFieldType m16497l() {
        return f15732l;
    }

    /* JADX INFO: renamed from: m */
    public static DateTimeFieldType m16498m() {
        return f15728h;
    }

    /* JADX INFO: renamed from: n */
    public static DateTimeFieldType m16499n() {
        return f15726f;
    }

    /* JADX INFO: renamed from: o */
    public static DateTimeFieldType m16500o() {
        return f15731k;
    }

    /* JADX INFO: renamed from: p */
    public static DateTimeFieldType m16501p() {
        return f15730j;
    }

    /* JADX INFO: renamed from: q */
    public static DateTimeFieldType m16502q() {
        return f15729i;
    }

    /* JADX INFO: renamed from: r */
    public static DateTimeFieldType m16503r() {
        return f15727g;
    }

    /* JADX INFO: renamed from: s */
    public static DateTimeFieldType m16504s() {
        return f15725e;
    }

    /* JADX INFO: renamed from: t */
    public static DateTimeFieldType m16505t() {
        return f15722b;
    }

    /* JADX INFO: renamed from: u */
    public static DateTimeFieldType m16506u() {
        return f15724d;
    }

    /* JADX INFO: renamed from: v */
    public static DateTimeFieldType m16507v() {
        return f15723c;
    }

    /* JADX INFO: renamed from: w */
    public static DateTimeFieldType m16508w() {
        return f15721a;
    }

    /* JADX INFO: renamed from: x */
    public String m16510x() {
        return this.f15744x;
    }

    public String toString() {
        return m16510x();
    }

    private static class StandardDateTimeFieldType extends DateTimeFieldType {

        /* JADX INFO: renamed from: a */
        private final byte f15745a;

        /* JADX INFO: renamed from: b */
        private final transient DurationFieldType f15746b;

        /* JADX INFO: renamed from: c */
        private final transient DurationFieldType f15747c;

        StandardDateTimeFieldType(String str, byte b, DurationFieldType durationFieldType, DurationFieldType durationFieldType2) {
            super(str);
            this.f15745a = b;
            this.f15746b = durationFieldType;
            this.f15747c = durationFieldType2;
        }

        @Override // org.joda.time.DateTimeFieldType
        /* JADX INFO: renamed from: y */
        public DurationFieldType mo16511y() {
            return this.f15746b;
        }

        @Override // org.joda.time.DateTimeFieldType
        /* JADX INFO: renamed from: z */
        public DurationFieldType mo16512z() {
            return this.f15747c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StandardDateTimeFieldType) && this.f15745a == ((StandardDateTimeFieldType) obj).f15745a;
        }

        public int hashCode() {
            return 1 << this.f15745a;
        }

        @Override // org.joda.time.DateTimeFieldType
        /* JADX INFO: renamed from: a */
        public DateTimeField mo16509a(Chronology chronology) {
            Chronology chronologyM16516a = DateTimeUtils.m16516a(chronology);
            switch (this.f15745a) {
                case 1:
                    return chronologyM16516a.mo16401K();
                case 2:
                    return chronologyM16516a.mo16396F();
                case 3:
                    return chronologyM16516a.mo16399I();
                case 4:
                    return chronologyM16516a.mo16397G();
                case 5:
                    return chronologyM16516a.mo16395E();
                case 6:
                    return chronologyM16516a.mo16428v();
                case 7:
                    return chronologyM16516a.mo16393C();
                case 8:
                    return chronologyM16516a.mo16427u();
                case 9:
                    return chronologyM16516a.mo16391A();
                case 10:
                    return chronologyM16516a.mo16432z();
                case 11:
                    return chronologyM16516a.mo16430x();
                case 12:
                    return chronologyM16516a.mo16426t();
                case 13:
                    return chronologyM16516a.mo16424r();
                case 14:
                    return chronologyM16516a.mo16422p();
                case 15:
                    return chronologyM16516a.mo16423q();
                case 16:
                    return chronologyM16516a.mo16420n();
                case 17:
                    return chronologyM16516a.mo16419m();
                case 18:
                    return chronologyM16516a.mo16417k();
                case 19:
                    return chronologyM16516a.mo16416j();
                case 20:
                    return chronologyM16516a.mo16414h();
                case 21:
                    return chronologyM16516a.mo16413g();
                case 22:
                    return chronologyM16516a.mo16411e();
                case 23:
                    return chronologyM16516a.mo16410d();
                default:
                    throw new InternalError();
            }
        }

        private Object readResolve() {
            switch (this.f15745a) {
                case 1:
                    return DateTimeFieldType.f15721a;
                case 2:
                    return DateTimeFieldType.f15722b;
                case 3:
                    return DateTimeFieldType.f15723c;
                case 4:
                    return DateTimeFieldType.f15724d;
                case 5:
                    return DateTimeFieldType.f15725e;
                case 6:
                    return DateTimeFieldType.f15726f;
                case 7:
                    return DateTimeFieldType.f15727g;
                case 8:
                    return DateTimeFieldType.f15728h;
                case 9:
                    return DateTimeFieldType.f15729i;
                case 10:
                    return DateTimeFieldType.f15730j;
                case 11:
                    return DateTimeFieldType.f15731k;
                case 12:
                    return DateTimeFieldType.f15732l;
                case 13:
                    return DateTimeFieldType.f15733m;
                case 14:
                    return DateTimeFieldType.f15734n;
                case 15:
                    return DateTimeFieldType.f15735o;
                case 16:
                    return DateTimeFieldType.f15736p;
                case 17:
                    return DateTimeFieldType.f15737q;
                case 18:
                    return DateTimeFieldType.f15738r;
                case 19:
                    return DateTimeFieldType.f15739s;
                case 20:
                    return DateTimeFieldType.f15740t;
                case 21:
                    return DateTimeFieldType.f15741u;
                case 22:
                    return DateTimeFieldType.f15742v;
                case 23:
                    return DateTimeFieldType.f15743w;
                default:
                    return this;
            }
        }
    }
}
