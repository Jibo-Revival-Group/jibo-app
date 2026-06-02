package org.joda.time;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.joda.convert.ToString;
import org.joda.time.base.BaseLocal;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.ISODateTimeFormat;

/* JADX INFO: loaded from: classes.dex */
public final class LocalDate extends BaseLocal implements Serializable, ReadablePartial {

    /* JADX INFO: renamed from: a */
    private static final Set<DurationFieldType> f15782a = new HashSet();

    /* JADX INFO: renamed from: b */
    private final long f15783b;

    /* JADX INFO: renamed from: c */
    private final Chronology f15784c;

    /* JADX INFO: renamed from: d */
    private transient int f15785d;

    static {
        f15782a.add(DurationFieldType.m16566f());
        f15782a.add(DurationFieldType.m16567g());
        f15782a.add(DurationFieldType.m16569i());
        f15782a.add(DurationFieldType.m16568h());
        f15782a.add(DurationFieldType.m16570j());
        f15782a.add(DurationFieldType.m16571k());
        f15782a.add(DurationFieldType.m16572l());
    }

    public LocalDate() {
        this(DateTimeUtils.m16513a(), ISOChronology.m16707O());
    }

    public LocalDate(long j, Chronology chronology) {
        Chronology chronologyM16516a = DateTimeUtils.m16516a(chronology);
        long jM16540a = chronologyM16516a.mo16407a().m16540a(DateTimeZone.f15751a, j);
        Chronology chronologyMo16408b = chronologyM16516a.mo16408b();
        this.f15783b = chronologyMo16408b.mo16427u().mo16452d(jM16540a);
        this.f15784c = chronologyMo16408b;
    }

    private Object readResolve() {
        if (this.f15784c == null) {
            return new LocalDate(this.f15783b, ISOChronology.m16706N());
        }
        if (!DateTimeZone.f15751a.equals(this.f15784c.mo16407a())) {
            return new LocalDate(this.f15783b, this.f15784c.mo16408b());
        }
        return this;
    }

    @Override // org.joda.time.ReadablePartial
    /* JADX INFO: renamed from: a */
    public int mo16583a() {
        return 3;
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
        if (dateTimeFieldType == null) {
            return false;
        }
        DurationFieldType durationFieldTypeMo16511y = dateTimeFieldType.mo16511y();
        if (f15782a.contains(durationFieldTypeMo16511y) || durationFieldTypeMo16511y.mo16573a(mo16590c()).mo16560d() >= mo16590c().mo16425s().mo16560d()) {
            return dateTimeFieldType.mo16509a(mo16590c()).mo16451c();
        }
        return false;
    }

    @Override // org.joda.time.base.BaseLocal
    /* JADX INFO: renamed from: b */
    protected long mo16588b() {
        return this.f15783b;
    }

    @Override // org.joda.time.ReadablePartial
    /* JADX INFO: renamed from: c */
    public Chronology mo16590c() {
        return this.f15784c;
    }

    @Override // org.joda.time.base.AbstractPartial
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDate) {
            LocalDate localDate = (LocalDate) obj;
            if (this.f15784c.equals(localDate.f15784c)) {
                return this.f15783b == localDate.f15783b;
            }
        }
        return super.equals(obj);
    }

    @Override // org.joda.time.base.AbstractPartial
    public int hashCode() {
        int i = this.f15785d;
        if (i == 0) {
            int iHashCode = super.hashCode();
            this.f15785d = iHashCode;
            return iHashCode;
        }
        return i;
    }

    @Override // org.joda.time.base.AbstractPartial, java.lang.Comparable
    /* JADX INFO: renamed from: a */
    public int compareTo(ReadablePartial readablePartial) {
        if (this == readablePartial) {
            return 0;
        }
        if (readablePartial instanceof LocalDate) {
            LocalDate localDate = (LocalDate) readablePartial;
            if (this.f15784c.equals(localDate.f15784c)) {
                return this.f15783b < localDate.f15783b ? -1 : this.f15783b == localDate.f15783b ? 0 : 1;
            }
        }
        return super.compareTo(readablePartial);
    }

    /* JADX INFO: renamed from: d */
    public int m16591d() {
        return mo16590c().mo16395E().mo16434a(mo16588b());
    }

    @ToString
    public String toString() {
        return ISODateTimeFormat.m16905b().m16779a(this);
    }
}
