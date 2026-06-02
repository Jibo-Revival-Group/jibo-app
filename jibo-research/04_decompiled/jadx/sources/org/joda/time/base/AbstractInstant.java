package org.joda.time.base;

import org.joda.convert.ToString;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.ISODateTimeFormat;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractInstant implements ReadableInstant {
    protected AbstractInstant() {
    }

    /* JADX INFO: renamed from: h */
    public DateTimeZone m16609h() {
        return mo16581d().mo16407a();
    }

    @Override // org.joda.time.ReadableInstant
    /* JADX INFO: renamed from: b */
    public Instant mo16579b() {
        return new Instant(mo16580c());
    }

    /* JADX INFO: renamed from: a */
    public DateTime mo16433a() {
        return new DateTime(mo16580c(), m16609h());
    }

    /* JADX INFO: renamed from: e */
    public MutableDateTime mo16582e() {
        return new MutableDateTime(mo16580c(), m16609h());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReadableInstant)) {
            return false;
        }
        ReadableInstant readableInstant = (ReadableInstant) obj;
        return mo16580c() == readableInstant.mo16580c() && FieldUtils.m16757a(mo16581d(), readableInstant.mo16581d());
    }

    public int hashCode() {
        return ((int) (mo16580c() ^ (mo16580c() >>> 32))) + mo16581d().hashCode();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(ReadableInstant readableInstant) {
        if (this == readableInstant) {
            return 0;
        }
        long jMo16580c = readableInstant.mo16580c();
        long jC = mo16580c();
        if (jC == jMo16580c) {
            return 0;
        }
        if (jC < jMo16580c) {
            return -1;
        }
        return 1;
    }

    /* JADX INFO: renamed from: b */
    public boolean m16608b(long j) {
        return mo16580c() < j;
    }

    @Override // org.joda.time.ReadableInstant
    /* JADX INFO: renamed from: a */
    public boolean mo16603a(ReadableInstant readableInstant) {
        return m16608b(DateTimeUtils.m16514a(readableInstant));
    }

    @ToString
    public String toString() {
        return ISODateTimeFormat.m16907d().m16778a(this);
    }
}
