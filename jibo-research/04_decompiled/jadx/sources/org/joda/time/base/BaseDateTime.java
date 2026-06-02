package org.joda.time.base;

import java.io.Serializable;
import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.InstantConverter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseDateTime extends AbstractDateTime implements Serializable, ReadableDateTime {

    /* JADX INFO: renamed from: a */
    private volatile long f15797a;

    /* JADX INFO: renamed from: b */
    private volatile Chronology f15798b;

    public BaseDateTime() {
        this(DateTimeUtils.m16513a(), ISOChronology.m16707O());
    }

    public BaseDateTime(long j, DateTimeZone dateTimeZone) {
        this(j, ISOChronology.m16708b(dateTimeZone));
    }

    public BaseDateTime(long j, Chronology chronology) {
        this.f15798b = m16614b(chronology);
        this.f15797a = m16613a(j, this.f15798b);
        m16612i();
    }

    public BaseDateTime(Object obj, Chronology chronology) {
        InstantConverter instantConverterM16731a = ConverterManager.m16730a().m16731a(obj);
        this.f15798b = m16614b(instantConverterM16731a.mo16728b(obj, chronology));
        this.f15797a = m16613a(instantConverterM16731a.mo16726a(obj, chronology), this.f15798b);
        m16612i();
    }

    public BaseDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7, Chronology chronology) {
        this.f15798b = m16614b(chronology);
        this.f15797a = m16613a(this.f15798b.mo16403a(i, i2, i3, i4, i5, i6, i7), this.f15798b);
        m16612i();
    }

    /* JADX INFO: renamed from: i */
    private void m16612i() {
        if (this.f15797a == Long.MIN_VALUE || this.f15797a == Long.MAX_VALUE) {
            this.f15798b = this.f15798b.mo16408b();
        }
    }

    /* JADX INFO: renamed from: b */
    protected Chronology m16614b(Chronology chronology) {
        return DateTimeUtils.m16516a(chronology);
    }

    /* JADX INFO: renamed from: a */
    protected long m16613a(long j, Chronology chronology) {
        return j;
    }

    @Override // org.joda.time.ReadableInstant
    /* JADX INFO: renamed from: c */
    public long mo16580c() {
        return this.f15797a;
    }

    @Override // org.joda.time.ReadableInstant
    /* JADX INFO: renamed from: d */
    public Chronology mo16581d() {
        return this.f15798b;
    }

    /* JADX INFO: renamed from: a */
    protected void mo16596a(long j) {
        this.f15797a = m16613a(j, this.f15798b);
    }

    /* JADX INFO: renamed from: a */
    protected void mo16597a(Chronology chronology) {
        this.f15798b = m16614b(chronology);
    }
}
