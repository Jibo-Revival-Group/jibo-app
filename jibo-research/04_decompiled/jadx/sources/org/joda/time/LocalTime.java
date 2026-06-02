package org.joda.time;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.joda.convert.ToString;
import org.joda.time.base.BaseLocal;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/* JADX INFO: loaded from: classes.dex */
public final class LocalTime extends BaseLocal implements Serializable, ReadablePartial {

    /* JADX INFO: renamed from: a */
    public static final LocalTime f15788a = new LocalTime(0, 0, 0, 0);

    /* JADX INFO: renamed from: b */
    private static final Set<DurationFieldType> f15789b = new HashSet();

    /* JADX INFO: renamed from: c */
    private final long f15790c;

    /* JADX INFO: renamed from: d */
    private final Chronology f15791d;

    static {
        f15789b.add(DurationFieldType.m16561a());
        f15789b.add(DurationFieldType.m16562b());
        f15789b.add(DurationFieldType.m16563c());
        f15789b.add(DurationFieldType.m16564d());
    }

    /* JADX INFO: renamed from: a */
    public static LocalTime m16593a(String str, DateTimeFormatter dateTimeFormatter) {
        return dateTimeFormatter.m16787b(str);
    }

    public LocalTime() {
        this(DateTimeUtils.m16513a(), ISOChronology.m16707O());
    }

    public LocalTime(long j, Chronology chronology) {
        Chronology chronologyM16516a = DateTimeUtils.m16516a(chronology);
        long jM16540a = chronologyM16516a.mo16407a().m16540a(DateTimeZone.f15751a, j);
        Chronology chronologyMo16408b = chronologyM16516a.mo16408b();
        this.f15790c = chronologyMo16408b.mo16411e().mo16434a(jM16540a);
        this.f15791d = chronologyMo16408b;
    }

    public LocalTime(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, ISOChronology.m16706N());
    }

    public LocalTime(int i, int i2, int i3, int i4, Chronology chronology) {
        Chronology chronologyMo16408b = DateTimeUtils.m16516a(chronology).mo16408b();
        long jMo16404a = chronologyMo16408b.mo16404a(0L, i, i2, i3, i4);
        this.f15791d = chronologyMo16408b;
        this.f15790c = jMo16404a;
    }

    private Object readResolve() {
        if (this.f15791d == null) {
            return new LocalTime(this.f15790c, ISOChronology.m16706N());
        }
        if (!DateTimeZone.f15751a.equals(this.f15791d.mo16407a())) {
            return new LocalTime(this.f15790c, this.f15791d.mo16408b());
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
                return chronology.mo16419m();
            case 1:
                return chronology.mo16416j();
            case 2:
                return chronology.mo16413g();
            case 3:
                return chronology.mo16410d();
            default:
                throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    @Override // org.joda.time.ReadablePartial
    /* JADX INFO: renamed from: a */
    public int mo16584a(int i) {
        switch (i) {
            case 0:
                return mo16590c().mo16419m().mo16434a(mo16588b());
            case 1:
                return mo16590c().mo16416j().mo16434a(mo16588b());
            case 2:
                return mo16590c().mo16413g().mo16434a(mo16588b());
            case 3:
                return mo16590c().mo16410d().mo16434a(mo16588b());
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
        if (!mo16589b(dateTimeFieldType)) {
            throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
        }
        return dateTimeFieldType.mo16509a(mo16590c()).mo16434a(mo16588b());
    }

    @Override // org.joda.time.base.AbstractPartial, org.joda.time.ReadablePartial
    /* JADX INFO: renamed from: b */
    public boolean mo16589b(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null || !m16594a(dateTimeFieldType.mo16511y())) {
            return false;
        }
        DurationFieldType durationFieldTypeMo16512z = dateTimeFieldType.mo16512z();
        return m16594a(durationFieldTypeMo16512z) || durationFieldTypeMo16512z == DurationFieldType.m16566f();
    }

    /* JADX INFO: renamed from: a */
    public boolean m16594a(DurationFieldType durationFieldType) {
        if (durationFieldType == null) {
            return false;
        }
        DurationField durationFieldMo16573a = durationFieldType.mo16573a(mo16590c());
        if (f15789b.contains(durationFieldType) || durationFieldMo16573a.mo16560d() < mo16590c().mo16425s().mo16560d()) {
            return durationFieldMo16573a.mo16558b();
        }
        return false;
    }

    @Override // org.joda.time.base.BaseLocal
    /* JADX INFO: renamed from: b */
    protected long mo16588b() {
        return this.f15790c;
    }

    @Override // org.joda.time.ReadablePartial
    /* JADX INFO: renamed from: c */
    public Chronology mo16590c() {
        return this.f15791d;
    }

    @Override // org.joda.time.base.AbstractPartial
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalTime) {
            LocalTime localTime = (LocalTime) obj;
            if (this.f15791d.equals(localTime.f15791d)) {
                return this.f15790c == localTime.f15790c;
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
        if (readablePartial instanceof LocalTime) {
            LocalTime localTime = (LocalTime) readablePartial;
            if (this.f15791d.equals(localTime.f15791d)) {
                return this.f15790c < localTime.f15790c ? -1 : this.f15790c == localTime.f15790c ? 0 : 1;
            }
        }
        return super.compareTo(readablePartial);
    }

    @ToString
    public String toString() {
        return ISODateTimeFormat.m16906c().m16779a(this);
    }
}
