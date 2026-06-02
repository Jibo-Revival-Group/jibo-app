package org.joda.time;

import java.io.Serializable;
import org.joda.time.base.AbstractInstant;
import org.joda.time.chrono.ISOChronology;

/* JADX INFO: loaded from: classes2.dex */
public final class Instant extends AbstractInstant implements Serializable, ReadableInstant {

    /* JADX INFO: renamed from: a */
    private final long f15781a;

    public Instant() {
        this.f15781a = DateTimeUtils.m16513a();
    }

    public Instant(long j) {
        this.f15781a = j;
    }

    @Override // org.joda.time.base.AbstractInstant, org.joda.time.ReadableInstant
    /* JADX INFO: renamed from: b */
    public Instant mo16579b() {
        return this;
    }

    @Override // org.joda.time.ReadableInstant
    /* JADX INFO: renamed from: c */
    public long mo16580c() {
        return this.f15781a;
    }

    @Override // org.joda.time.ReadableInstant
    /* JADX INFO: renamed from: d */
    public Chronology mo16581d() {
        return ISOChronology.m16706N();
    }

    @Override // org.joda.time.base.AbstractInstant, org.joda.time.ReadableDateTime
    /* JADX INFO: renamed from: a */
    public DateTime mo16433a() {
        return new DateTime(mo16580c(), ISOChronology.m16707O());
    }

    @Override // org.joda.time.base.AbstractInstant
    /* JADX INFO: renamed from: e */
    public MutableDateTime mo16582e() {
        return new MutableDateTime(mo16580c(), ISOChronology.m16707O());
    }
}
