package org.joda.time;

/* JADX INFO: loaded from: classes2.dex */
final class UTCDateTimeZone extends DateTimeZone {

    /* JADX INFO: renamed from: b */
    static final DateTimeZone f15796b = new UTCDateTimeZone();

    public UTCDateTimeZone() {
        super("UTC");
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: a */
    public String mo16541a(long j) {
        return "UTC";
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: b */
    public int mo16543b(long j) {
        return 0;
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: c */
    public int mo16545c(long j) {
        return 0;
    }

    @Override // org.joda.time.DateTimeZone
    /* JADX INFO: renamed from: e */
    public int mo16547e(long j) {
        return 0;
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
        return obj instanceof UTCDateTimeZone;
    }

    @Override // org.joda.time.DateTimeZone
    public int hashCode() {
        return m16548e().hashCode();
    }
}
