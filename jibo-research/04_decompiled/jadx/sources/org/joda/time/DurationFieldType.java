package org.joda.time;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DurationFieldType implements Serializable {

    /* JADX INFO: renamed from: a */
    static final DurationFieldType f15759a = new StandardDurationFieldType("eras", (byte) 1);

    /* JADX INFO: renamed from: b */
    static final DurationFieldType f15760b = new StandardDurationFieldType("centuries", (byte) 2);

    /* JADX INFO: renamed from: c */
    static final DurationFieldType f15761c = new StandardDurationFieldType("weekyears", (byte) 3);

    /* JADX INFO: renamed from: d */
    static final DurationFieldType f15762d = new StandardDurationFieldType("years", (byte) 4);

    /* JADX INFO: renamed from: e */
    static final DurationFieldType f15763e = new StandardDurationFieldType("months", (byte) 5);

    /* JADX INFO: renamed from: f */
    static final DurationFieldType f15764f = new StandardDurationFieldType("weeks", (byte) 6);

    /* JADX INFO: renamed from: g */
    static final DurationFieldType f15765g = new StandardDurationFieldType("days", (byte) 7);

    /* JADX INFO: renamed from: h */
    static final DurationFieldType f15766h = new StandardDurationFieldType("halfdays", (byte) 8);

    /* JADX INFO: renamed from: i */
    static final DurationFieldType f15767i = new StandardDurationFieldType("hours", (byte) 9);

    /* JADX INFO: renamed from: j */
    static final DurationFieldType f15768j = new StandardDurationFieldType("minutes", (byte) 10);

    /* JADX INFO: renamed from: k */
    static final DurationFieldType f15769k = new StandardDurationFieldType("seconds", (byte) 11);

    /* JADX INFO: renamed from: l */
    static final DurationFieldType f15770l = new StandardDurationFieldType("millis", (byte) 12);

    /* JADX INFO: renamed from: m */
    private final String f15771m;

    /* JADX INFO: renamed from: a */
    public abstract DurationField mo16573a(Chronology chronology);

    protected DurationFieldType(String str) {
        this.f15771m = str;
    }

    /* JADX INFO: renamed from: a */
    public static DurationFieldType m16561a() {
        return f15770l;
    }

    /* JADX INFO: renamed from: b */
    public static DurationFieldType m16562b() {
        return f15769k;
    }

    /* JADX INFO: renamed from: c */
    public static DurationFieldType m16563c() {
        return f15768j;
    }

    /* JADX INFO: renamed from: d */
    public static DurationFieldType m16564d() {
        return f15767i;
    }

    /* JADX INFO: renamed from: e */
    public static DurationFieldType m16565e() {
        return f15766h;
    }

    /* JADX INFO: renamed from: f */
    public static DurationFieldType m16566f() {
        return f15765g;
    }

    /* JADX INFO: renamed from: g */
    public static DurationFieldType m16567g() {
        return f15764f;
    }

    /* JADX INFO: renamed from: h */
    public static DurationFieldType m16568h() {
        return f15761c;
    }

    /* JADX INFO: renamed from: i */
    public static DurationFieldType m16569i() {
        return f15763e;
    }

    /* JADX INFO: renamed from: j */
    public static DurationFieldType m16570j() {
        return f15762d;
    }

    /* JADX INFO: renamed from: k */
    public static DurationFieldType m16571k() {
        return f15760b;
    }

    /* JADX INFO: renamed from: l */
    public static DurationFieldType m16572l() {
        return f15759a;
    }

    /* JADX INFO: renamed from: m */
    public String m16574m() {
        return this.f15771m;
    }

    public String toString() {
        return m16574m();
    }

    private static class StandardDurationFieldType extends DurationFieldType {

        /* JADX INFO: renamed from: m */
        private final byte f15772m;

        StandardDurationFieldType(String str, byte b) {
            super(str);
            this.f15772m = b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StandardDurationFieldType) && this.f15772m == ((StandardDurationFieldType) obj).f15772m;
        }

        public int hashCode() {
            return 1 << this.f15772m;
        }

        @Override // org.joda.time.DurationFieldType
        /* JADX INFO: renamed from: a */
        public DurationField mo16573a(Chronology chronology) {
            Chronology chronologyM16516a = DateTimeUtils.m16516a(chronology);
            switch (this.f15772m) {
                case 1:
                    return chronologyM16516a.mo16400J();
                case 2:
                    return chronologyM16516a.mo16398H();
                case 3:
                    return chronologyM16516a.mo16431y();
                case 4:
                    return chronologyM16516a.mo16394D();
                case 5:
                    return chronologyM16516a.mo16392B();
                case 6:
                    return chronologyM16516a.mo16429w();
                case 7:
                    return chronologyM16516a.mo16425s();
                case 8:
                    return chronologyM16516a.mo16421o();
                case 9:
                    return chronologyM16516a.mo16418l();
                case 10:
                    return chronologyM16516a.mo16415i();
                case 11:
                    return chronologyM16516a.mo16412f();
                case 12:
                    return chronologyM16516a.mo16409c();
                default:
                    throw new InternalError();
            }
        }

        private Object readResolve() {
            switch (this.f15772m) {
                case 1:
                    return f15759a;
                case 2:
                    return f15760b;
                case 3:
                    return f15761c;
                case 4:
                    return f15762d;
                case 5:
                    return f15763e;
                case 6:
                    return f15764f;
                case 7:
                    return f15765g;
                case 8:
                    return f15766h;
                case 9:
                    return f15767i;
                case 10:
                    return f15768j;
                case 11:
                    return f15769k;
                case 12:
                    return f15770l;
                default:
                    return this;
            }
        }
    }
}
