package org.joda.time;

import java.io.Serializable;
import org.joda.convert.ToString;
import org.joda.time.base.BaseLocal;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.ISODateTimeFormat;

/* JADX INFO: loaded from: classes.dex */
public final class LocalDateTime extends BaseLocal implements Serializable, ReadablePartial {

    /* JADX INFO: renamed from: a */
    private final long f15786a;

    /* JADX INFO: renamed from: b */
    private final Chronology f15787b;

    public LocalDateTime() {
        this(DateTimeUtils.m16513a(), ISOChronology.m16707O());
    }

    public LocalDateTime(long j, Chronology chronology) {
        Chronology chronologyM16516a = DateTimeUtils.m16516a(chronology);
        this.f15786a = chronologyM16516a.mo16407a().m16540a(DateTimeZone.f15751a, j);
        this.f15787b = chronologyM16516a.mo16408b();
    }

    private Object readResolve() {
        if (this.f15787b == null) {
            return new LocalDateTime(this.f15786a, ISOChronology.m16706N());
        }
        if (!DateTimeZone.f15751a.equals(this.f15787b.mo16407a())) {
            return new LocalDateTime(this.f15786a, this.f15787b.mo16408b());
        }
        return this;
    }

    @Override // org.joda.time.ReadablePartial
    /* JADX INFO: renamed from: a */
    public int mo16583a() {
        return 4;
    }

    @Override // org.joda.time.base.AbstractPartial
    /* JADX INFO: renamed from: a */
    protected DateTimeField mo16587a(int i, Chronology chronology) {
        switch (i) {
            case 0:
                return chronology.mo16395E();
            case 1:
                return chronology.mo16393C();
            case 2:
                return chronology.mo16427u();
            case 3:
                return chronology.mo16411e();
            default:
                throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    @Override // org.joda.time.ReadablePartial
    /* JADX INFO: renamed from: a */
    public int mo16584a(int i) {
        switch (i) {
            case 0:
                return mo16590c().mo16395E().mo16434a(mo16588b());
            case 1:
                return mo16590c().mo16393C().mo16434a(mo16588b());
            case 2:
                return mo16590c().mo16427u().mo16434a(mo16588b());
            case 3:
                return mo16590c().mo16411e().mo16434a(mo16588b());
            default:
                throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    @Override // org.joda.time.base.AbstractPartial, org.joda.time.ReadablePartial
    /* JADX INFO: renamed from: a */
    public int mo16585a(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        }
        return dateTimeFieldType.mo16509a(mo16590c()).mo16434a(mo16588b());
    }

    @Override // org.joda.time.base.AbstractPartial, org.joda.time.ReadablePartial
    /* JADX INFO: renamed from: b */
    public boolean mo16589b(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            return false;
        }
        return dateTimeFieldType.mo16509a(mo16590c()).mo16451c();
    }

    @Override // org.joda.time.base.BaseLocal
    /* JADX INFO: renamed from: b */
    protected long mo16588b() {
        return this.f15786a;
    }

    @Override // org.joda.time.ReadablePartial
    /* JADX INFO: renamed from: c */
    public Chronology mo16590c() {
        return this.f15787b;
    }

    @Override // org.joda.time.base.AbstractPartial
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.f15787b.equals(localDateTime.f15787b)) {
                return this.f15786a == localDateTime.f15786a;
            }
        }
        return super.equals(obj);
    }

    @Override // org.joda.time.base.AbstractPartial, java.lang.Comparable
    /* JADX INFO: renamed from: a */
    public int compareTo(ReadablePartial readablePartial) {
        if (this == readablePartial) {
            return 0;
        }
        if (readablePartial instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) readablePartial;
            if (this.f15787b.equals(localDateTime.f15787b)) {
                return this.f15786a < localDateTime.f15786a ? -1 : this.f15786a == localDateTime.f15786a ? 0 : 1;
            }
        }
        return super.compareTo(readablePartial);
    }

    /* JADX INFO: renamed from: d */
    public LocalTime m16592d() {
        return new LocalTime(mo16588b(), mo16590c());
    }

    @ToString
    public String toString() {
        return ISODateTimeFormat.m16907d().m16779a(this);
    }
}
