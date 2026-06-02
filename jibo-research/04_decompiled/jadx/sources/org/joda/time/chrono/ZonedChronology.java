package org.joda.time.chrono;

import java.util.HashMap;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.BaseDateTimeField;
import org.joda.time.field.BaseDurationField;

/* JADX INFO: loaded from: classes2.dex */
public final class ZonedChronology extends AssembledChronology {
    /* JADX INFO: renamed from: a */
    public static ZonedChronology m16721a(Chronology chronology, DateTimeZone dateTimeZone) {
        if (chronology == null) {
            throw new IllegalArgumentException("Must supply a chronology");
        }
        Chronology chronologyMo16408b = chronology.mo16408b();
        if (chronologyMo16408b == null) {
            throw new IllegalArgumentException("UTC chronology must not be null");
        }
        if (dateTimeZone == null) {
            throw new IllegalArgumentException("DateTimeZone must not be null");
        }
        return new ZonedChronology(chronologyMo16408b, dateTimeZone);
    }

    /* JADX INFO: renamed from: a */
    static boolean m16722a(DurationField durationField) {
        return durationField != null && durationField.mo16560d() < 43200000;
    }

    private ZonedChronology(Chronology chronology, DateTimeZone dateTimeZone) {
        super(chronology, dateTimeZone);
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public DateTimeZone mo16407a() {
        return (DateTimeZone) m16617M();
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: b */
    public Chronology mo16408b() {
        return m16616L();
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public Chronology mo16406a(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.m16523a();
        }
        if (dateTimeZone != m16617M()) {
            if (dateTimeZone == DateTimeZone.f15751a) {
                return m16616L();
            }
            return new ZonedChronology(m16616L(), dateTimeZone);
        }
        return this;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16402a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        return m16718a(m16616L().mo16402a(i, i2, i3, i4));
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16403a(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        return m16718a(m16616L().mo16403a(i, i2, i3, i4, i5, i6, i7));
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16404a(long j, int i, int i2, int i3, int i4) throws IllegalArgumentException {
        return m16718a(m16616L().mo16404a(((long) mo16407a().mo16543b(j)) + j, i, i2, i3, i4));
    }

    /* JADX INFO: renamed from: a */
    private long m16718a(long j) {
        if (j == Long.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        if (j == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        DateTimeZone dateTimeZoneMo16407a = mo16407a();
        int iMo16547e = dateTimeZoneMo16407a.mo16547e(j);
        long j2 = j - ((long) iMo16547e);
        if (j > 604800000 && j2 < 0) {
            return Long.MAX_VALUE;
        }
        if (j < -604800000 && j2 > 0) {
            return Long.MIN_VALUE;
        }
        if (iMo16547e != dateTimeZoneMo16407a.mo16543b(j2)) {
            throw new IllegalInstantException(j, dateTimeZoneMo16407a.m16548e());
        }
        return j2;
    }

    @Override // org.joda.time.chrono.AssembledChronology
    /* JADX INFO: renamed from: a */
    protected void mo16618a(AssembledChronology.Fields fields) {
        HashMap<Object, Object> map = new HashMap<>();
        fields.f15857l = m16720a(fields.f15857l, map);
        fields.f15856k = m16720a(fields.f15856k, map);
        fields.f15855j = m16720a(fields.f15855j, map);
        fields.f15854i = m16720a(fields.f15854i, map);
        fields.f15853h = m16720a(fields.f15853h, map);
        fields.f15852g = m16720a(fields.f15852g, map);
        fields.f15851f = m16720a(fields.f15851f, map);
        fields.f15850e = m16720a(fields.f15850e, map);
        fields.f15849d = m16720a(fields.f15849d, map);
        fields.f15848c = m16720a(fields.f15848c, map);
        fields.f15847b = m16720a(fields.f15847b, map);
        fields.f15846a = m16720a(fields.f15846a, map);
        fields.f15841E = m16719a(fields.f15841E, map);
        fields.f15842F = m16719a(fields.f15842F, map);
        fields.f15843G = m16719a(fields.f15843G, map);
        fields.f15844H = m16719a(fields.f15844H, map);
        fields.f15845I = m16719a(fields.f15845I, map);
        fields.f15869x = m16719a(fields.f15869x, map);
        fields.f15870y = m16719a(fields.f15870y, map);
        fields.f15871z = m16719a(fields.f15871z, map);
        fields.f15840D = m16719a(fields.f15840D, map);
        fields.f15837A = m16719a(fields.f15837A, map);
        fields.f15838B = m16719a(fields.f15838B, map);
        fields.f15839C = m16719a(fields.f15839C, map);
        fields.f15858m = m16719a(fields.f15858m, map);
        fields.f15859n = m16719a(fields.f15859n, map);
        fields.f15860o = m16719a(fields.f15860o, map);
        fields.f15861p = m16719a(fields.f15861p, map);
        fields.f15862q = m16719a(fields.f15862q, map);
        fields.f15863r = m16719a(fields.f15863r, map);
        fields.f15864s = m16719a(fields.f15864s, map);
        fields.f15866u = m16719a(fields.f15866u, map);
        fields.f15865t = m16719a(fields.f15865t, map);
        fields.f15867v = m16719a(fields.f15867v, map);
        fields.f15868w = m16719a(fields.f15868w, map);
    }

    /* JADX INFO: renamed from: a */
    private DurationField m16720a(DurationField durationField, HashMap<Object, Object> map) {
        if (durationField == null || !durationField.mo16558b()) {
            return durationField;
        }
        if (map.containsKey(durationField)) {
            return (DurationField) map.get(durationField);
        }
        ZonedDurationField zonedDurationField = new ZonedDurationField(durationField, mo16407a());
        map.put(durationField, zonedDurationField);
        return zonedDurationField;
    }

    /* JADX INFO: renamed from: a */
    private DateTimeField m16719a(DateTimeField dateTimeField, HashMap<Object, Object> map) {
        if (dateTimeField == null || !dateTimeField.mo16451c()) {
            return dateTimeField;
        }
        if (map.containsKey(dateTimeField)) {
            return (DateTimeField) map.get(dateTimeField);
        }
        ZonedDateTimeField zonedDateTimeField = new ZonedDateTimeField(dateTimeField, mo16407a(), m16720a(dateTimeField.mo16453d(), map), m16720a(dateTimeField.mo16455e(), map), m16720a(dateTimeField.mo16457f(), map));
        map.put(dateTimeField, zonedDateTimeField);
        return zonedDateTimeField;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedChronology)) {
            return false;
        }
        ZonedChronology zonedChronology = (ZonedChronology) obj;
        return m16616L().equals(zonedChronology.m16616L()) && mo16407a().equals(zonedChronology.mo16407a());
    }

    public int hashCode() {
        return 326565 + (mo16407a().hashCode() * 11) + (m16616L().hashCode() * 7);
    }

    @Override // org.joda.time.Chronology
    public String toString() {
        return "ZonedChronology[" + m16616L() + ", " + mo16407a().m16548e() + ']';
    }

    static class ZonedDurationField extends BaseDurationField {

        /* JADX INFO: renamed from: a */
        final DurationField f15972a;

        /* JADX INFO: renamed from: b */
        final boolean f15973b;

        /* JADX INFO: renamed from: c */
        final DateTimeZone f15974c;

        ZonedDurationField(DurationField durationField, DateTimeZone dateTimeZone) {
            super(durationField.mo16557a());
            if (!durationField.mo16558b()) {
                throw new IllegalArgumentException();
            }
            this.f15972a = durationField;
            this.f15973b = ZonedChronology.m16722a(durationField);
            this.f15974c = dateTimeZone;
        }

        @Override // org.joda.time.DurationField
        /* JADX INFO: renamed from: c */
        public boolean mo16559c() {
            return this.f15973b ? this.f15972a.mo16559c() : this.f15972a.mo16559c() && this.f15974c.mo16550f();
        }

        @Override // org.joda.time.DurationField
        /* JADX INFO: renamed from: d */
        public long mo16560d() {
            return this.f15972a.mo16560d();
        }

        @Override // org.joda.time.DurationField
        /* JADX INFO: renamed from: a */
        public long mo16555a(long j, int i) {
            int iM16724a = m16724a(j);
            long jMo16555a = this.f15972a.mo16555a(((long) iM16724a) + j, i);
            if (!this.f15973b) {
                iM16724a = m16725b(jMo16555a);
            }
            return jMo16555a - ((long) iM16724a);
        }

        @Override // org.joda.time.DurationField
        /* JADX INFO: renamed from: a */
        public long mo16556a(long j, long j2) {
            int iM16724a = m16724a(j);
            long jMo16556a = this.f15972a.mo16556a(((long) iM16724a) + j, j2);
            if (!this.f15973b) {
                iM16724a = m16725b(jMo16556a);
            }
            return jMo16556a - ((long) iM16724a);
        }

        /* JADX INFO: renamed from: a */
        private int m16724a(long j) {
            int iMo16543b = this.f15974c.mo16543b(j);
            if (((((long) iMo16543b) + j) ^ j) < 0 && (((long) iMo16543b) ^ j) >= 0) {
                throw new ArithmeticException("Adding time zone offset caused overflow");
            }
            return iMo16543b;
        }

        /* JADX INFO: renamed from: b */
        private int m16725b(long j) {
            int iMo16547e = this.f15974c.mo16547e(j);
            if (((j - ((long) iMo16547e)) ^ j) < 0 && (((long) iMo16547e) ^ j) < 0) {
                throw new ArithmeticException("Subtracting time zone offset caused overflow");
            }
            return iMo16547e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ZonedDurationField)) {
                return false;
            }
            ZonedDurationField zonedDurationField = (ZonedDurationField) obj;
            return this.f15972a.equals(zonedDurationField.f15972a) && this.f15974c.equals(zonedDurationField.f15974c);
        }

        public int hashCode() {
            return this.f15972a.hashCode() ^ this.f15974c.hashCode();
        }
    }

    static final class ZonedDateTimeField extends BaseDateTimeField {

        /* JADX INFO: renamed from: a */
        final DateTimeField f15966a;

        /* JADX INFO: renamed from: b */
        final DateTimeZone f15967b;

        /* JADX INFO: renamed from: c */
        final DurationField f15968c;

        /* JADX INFO: renamed from: d */
        final boolean f15969d;

        /* JADX INFO: renamed from: e */
        final DurationField f15970e;

        /* JADX INFO: renamed from: f */
        final DurationField f15971f;

        ZonedDateTimeField(DateTimeField dateTimeField, DateTimeZone dateTimeZone, DurationField durationField, DurationField durationField2, DurationField durationField3) {
            super(dateTimeField.mo16442a());
            if (!dateTimeField.mo16451c()) {
                throw new IllegalArgumentException();
            }
            this.f15966a = dateTimeField;
            this.f15967b = dateTimeZone;
            this.f15968c = durationField;
            this.f15969d = ZonedChronology.m16722a(durationField);
            this.f15970e = durationField2;
            this.f15971f = durationField3;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public int mo16434a(long j) {
            return this.f15966a.mo16434a(this.f15967b.m16549f(j));
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public String mo16440a(long j, Locale locale) {
            return this.f15966a.mo16440a(this.f15967b.m16549f(j), locale);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: b */
        public String mo16446b(long j, Locale locale) {
            return this.f15966a.mo16446b(this.f15967b.m16549f(j), locale);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public String mo16439a(int i, Locale locale) {
            return this.f15966a.mo16439a(i, locale);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: b */
        public String mo16445b(int i, Locale locale) {
            return this.f15966a.mo16445b(i, locale);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public long mo16436a(long j, int i) {
            if (this.f15969d) {
                int iM16723j = m16723j(j);
                return this.f15966a.mo16436a(((long) iM16723j) + j, i) - ((long) iM16723j);
            }
            return this.f15967b.m16539a(this.f15966a.mo16436a(this.f15967b.m16549f(j), i), false, j);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public long mo16437a(long j, long j2) {
            if (this.f15969d) {
                int iM16723j = m16723j(j);
                return this.f15966a.mo16437a(((long) iM16723j) + j, j2) - ((long) iM16723j);
            }
            return this.f15967b.m16539a(this.f15966a.mo16437a(this.f15967b.m16549f(j), j2), false, j);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: b */
        public long mo16443b(long j, int i) {
            long jMo16443b = this.f15966a.mo16443b(this.f15967b.m16549f(j), i);
            long jM16539a = this.f15967b.m16539a(jMo16443b, false, j);
            if (mo16434a(jM16539a) != i) {
                IllegalInstantException illegalInstantException = new IllegalInstantException(jMo16443b, this.f15967b.m16548e());
                IllegalFieldValueException illegalFieldValueException = new IllegalFieldValueException(this.f15966a.mo16442a(), Integer.valueOf(i), illegalInstantException.getMessage());
                illegalFieldValueException.initCause(illegalInstantException);
                throw illegalFieldValueException;
            }
            return jM16539a;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public long mo16438a(long j, String str, Locale locale) {
            return this.f15967b.m16539a(this.f15966a.mo16438a(this.f15967b.m16549f(j), str, locale), false, j);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: d */
        public final DurationField mo16453d() {
            return this.f15968c;
        }

        @Override // org.joda.time.DateTimeField
        /* JADX INFO: renamed from: e */
        public final DurationField mo16455e() {
            return this.f15970e;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: b */
        public boolean mo16448b(long j) {
            return this.f15966a.mo16448b(this.f15967b.m16549f(j));
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: f */
        public final DurationField mo16457f() {
            return this.f15971f;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: d */
        public long mo16452d(long j) {
            if (this.f15969d) {
                int iM16723j = m16723j(j);
                return this.f15966a.mo16452d(((long) iM16723j) + j) - ((long) iM16723j);
            }
            return this.f15967b.m16539a(this.f15966a.mo16452d(this.f15967b.m16549f(j)), false, j);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: e */
        public long mo16454e(long j) {
            if (this.f15969d) {
                int iM16723j = m16723j(j);
                return this.f15966a.mo16454e(((long) iM16723j) + j) - ((long) iM16723j);
            }
            return this.f15967b.m16539a(this.f15966a.mo16454e(this.f15967b.m16549f(j)), false, j);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: i */
        public long mo16462i(long j) {
            return this.f15966a.mo16462i(this.f15967b.m16549f(j));
        }

        @Override // org.joda.time.DateTimeField
        /* JADX INFO: renamed from: g */
        public int mo16458g() {
            return this.f15966a.mo16458g();
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: h */
        public int mo16460h() {
            return this.f15966a.mo16460h();
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: c */
        public int mo16449c(long j) {
            return this.f15966a.mo16449c(this.f15967b.m16549f(j));
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public int mo16435a(Locale locale) {
            return this.f15966a.mo16435a(locale);
        }

        /* JADX INFO: renamed from: j */
        private int m16723j(long j) {
            int iMo16543b = this.f15967b.mo16543b(j);
            if (((((long) iMo16543b) + j) ^ j) < 0 && (((long) iMo16543b) ^ j) >= 0) {
                throw new ArithmeticException("Adding time zone offset caused overflow");
            }
            return iMo16543b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ZonedDateTimeField)) {
                return false;
            }
            ZonedDateTimeField zonedDateTimeField = (ZonedDateTimeField) obj;
            return this.f15966a.equals(zonedDateTimeField.f15966a) && this.f15967b.equals(zonedDateTimeField.f15967b) && this.f15968c.equals(zonedDateTimeField.f15968c) && this.f15970e.equals(zonedDateTimeField.f15970e);
        }

        public int hashCode() {
            return this.f15966a.hashCode() ^ this.f15967b.hashCode();
        }
    }
}
