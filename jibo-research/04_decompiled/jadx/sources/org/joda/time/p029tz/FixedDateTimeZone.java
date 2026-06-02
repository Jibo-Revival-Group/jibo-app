package org.joda.time.p029tz;

import org.joda.time.DateTimeZone;

/* JADX INFO: loaded from: classes2.dex */
public final class FixedDateTimeZone extends DateTimeZone {

    /* JADX INFO: renamed from: b */
    private final String f16188b;

    /* JADX INFO: renamed from: c */
    private final int f16189c;

    /* JADX INFO: renamed from: d */
    private final int f16190d;

    public FixedDateTimeZone(String str, String str2, int i, int i2) {
        super(str);
        this.f16188b = str2;
        this.f16189c = i;
        this.f16190d = i2;
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: a */
    public String mo16541a(long j) {
        return this.f16188b;
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: b */
    public int mo16543b(long j) {
        return this.f16189c;
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: c */
    public int mo16545c(long j) {
        return this.f16190d;
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: e */
    public int mo16547e(long j) {
        return this.f16189c;
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: f */
    public boolean mo16550f() {
        return true;
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: g */
    public long mo16551g(long j) {
        return j;
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: h */
    public long mo16552h(long j) {
        return j;
    }

    @Override // org.joda.time.DateTimeZone
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FixedDateTimeZone)) {
            return false;
        }
        FixedDateTimeZone fixedDateTimeZone = (FixedDateTimeZone) obj;
        return m16548e().equals(fixedDateTimeZone.m16548e()) && this.f16190d == fixedDateTimeZone.f16190d && this.f16189c == fixedDateTimeZone.f16189c;
    }

    @Override // org.joda.time.DateTimeZone
    public int hashCode() {
        return m16548e().hashCode() + (this.f16190d * 37) + (this.f16189c * 31);
    }
}
