package org.joda.time.p029tz;

import org.joda.time.DateTimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class CachedDateTimeZone extends DateTimeZone {

    /* JADX INFO: renamed from: b */
    private static final int f16160b;

    /* JADX INFO: renamed from: c */
    private final DateTimeZone f16161c;

    /* JADX INFO: renamed from: d */
    private final transient Info[] f16162d;

    static {
        Integer integer;
        int i;
        try {
            integer = Integer.getInteger("org.joda.time.tz.CachedDateTimeZone.size");
        } catch (SecurityException e) {
            integer = null;
        }
        if (integer == null) {
            i = 512;
        } else {
            int i2 = 0;
            for (int iIntValue = integer.intValue() - 1; iIntValue > 0; iIntValue >>= 1) {
                i2++;
            }
            i = 1 << i2;
        }
        f16160b = i - 1;
    }

    /* JADX INFO: renamed from: a */
    public static CachedDateTimeZone m16977a(DateTimeZone dateTimeZone) {
        return dateTimeZone instanceof CachedDateTimeZone ? (CachedDateTimeZone) dateTimeZone : new CachedDateTimeZone(dateTimeZone);
    }

    private CachedDateTimeZone(DateTimeZone dateTimeZone) {
        super(dateTimeZone.m16548e());
        this.f16162d = new Info[f16160b + 1];
        this.f16161c = dateTimeZone;
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: a */
    public String mo16541a(long j) {
        return m16978i(j).m16980a(j);
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: b */
    public int mo16543b(long j) {
        return m16978i(j).m16981b(j);
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: c */
    public int mo16545c(long j) {
        return m16978i(j).m16982c(j);
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: f */
    public boolean mo16550f() {
        return this.f16161c.mo16550f();
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: g */
    public long mo16551g(long j) {
        return this.f16161c.mo16551g(j);
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: h */
    public long mo16552h(long j) {
        return this.f16161c.mo16552h(j);
    }

    @Override // org.joda.time.DateTimeZone
    public int hashCode() {
        return this.f16161c.hashCode();
    }

    @Override // org.joda.time.DateTimeZone
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CachedDateTimeZone) {
            return this.f16161c.equals(((CachedDateTimeZone) obj).f16161c);
        }
        return false;
    }

    /* JADX INFO: renamed from: i */
    private Info m16978i(long j) {
        int i = (int) (j >> 32);
        Info[] infoArr = this.f16162d;
        int i2 = i & f16160b;
        Info info = infoArr[i2];
        if (info == null || ((int) (info.f16163a >> 32)) != i) {
            Info infoM16979j = m16979j(j);
            infoArr[i2] = infoM16979j;
            return infoM16979j;
        }
        return info;
    }

    /* JADX INFO: renamed from: j */
    private Info m16979j(long j) {
        long j2 = j & (-4294967296L);
        Info info = new Info(this.f16161c, j2);
        long j3 = j2 | 4294967295L;
        Info info2 = info;
        while (true) {
            long jMo16551g = this.f16161c.mo16551g(j2);
            if (jMo16551g == j2 || jMo16551g > j3) {
                break;
            }
            Info info3 = new Info(this.f16161c, jMo16551g);
            info2.f16165c = info3;
            info2 = info3;
            j2 = jMo16551g;
        }
        return info;
    }

    private static final class Info {

        /* JADX INFO: renamed from: a */
        public final long f16163a;

        /* JADX INFO: renamed from: b */
        public final DateTimeZone f16164b;

        /* JADX INFO: renamed from: c */
        Info f16165c;

        /* JADX INFO: renamed from: d */
        private String f16166d;

        /* JADX INFO: renamed from: e */
        private int f16167e = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: f */
        private int f16168f = Integer.MIN_VALUE;

        Info(DateTimeZone dateTimeZone, long j) {
            this.f16163a = j;
            this.f16164b = dateTimeZone;
        }

        /* JADX INFO: renamed from: a */
        public String m16980a(long j) {
            if (this.f16165c != null && j >= this.f16165c.f16163a) {
                return this.f16165c.m16980a(j);
            }
            if (this.f16166d == null) {
                this.f16166d = this.f16164b.mo16541a(this.f16163a);
            }
            return this.f16166d;
        }

        /* JADX INFO: renamed from: b */
        public int m16981b(long j) {
            if (this.f16165c != null && j >= this.f16165c.f16163a) {
                return this.f16165c.m16981b(j);
            }
            if (this.f16167e == Integer.MIN_VALUE) {
                this.f16167e = this.f16164b.mo16543b(this.f16163a);
            }
            return this.f16167e;
        }

        /* JADX INFO: renamed from: c */
        public int m16982c(long j) {
            if (this.f16165c != null && j >= this.f16165c.f16163a) {
                return this.f16165c.m16982c(j);
            }
            if (this.f16168f == Integer.MIN_VALUE) {
                this.f16168f = this.f16164b.mo16545c(this.f16163a);
            }
            return this.f16168f;
        }
    }
}
