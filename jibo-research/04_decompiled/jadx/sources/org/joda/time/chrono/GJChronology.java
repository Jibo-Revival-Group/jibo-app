package org.joda.time.chrono;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.ReadableInstant;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.BaseDateTimeField;
import org.joda.time.field.DecoratedDurationField;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/* JADX INFO: loaded from: classes2.dex */
public final class GJChronology extends AssembledChronology {

    /* JADX INFO: renamed from: a */
    static final Instant f15913a = new Instant(-12219292800000L);

    /* JADX INFO: renamed from: b */
    private static final ConcurrentHashMap<GJCacheKey, GJChronology> f15914b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c */
    private JulianChronology f15915c;

    /* JADX INFO: renamed from: d */
    private GregorianChronology f15916d;

    /* JADX INFO: renamed from: e */
    private Instant f15917e;

    /* JADX INFO: renamed from: f */
    private long f15918f;

    /* JADX INFO: renamed from: g */
    private long f15919g;

    /* JADX INFO: renamed from: a */
    private static long m16668a(long j, Chronology chronology, Chronology chronology2) {
        return chronology2.mo16402a(chronology.mo16395E().mo16434a(j), chronology.mo16393C().mo16434a(j), chronology.mo16427u().mo16434a(j), chronology.mo16411e().mo16434a(j));
    }

    /* JADX INFO: renamed from: b */
    private static long m16673b(long j, Chronology chronology, Chronology chronology2) {
        return chronology2.mo16411e().mo16443b(chronology2.mo16426t().mo16443b(chronology2.mo16430x().mo16443b(chronology2.mo16432z().mo16443b(0L, chronology.mo16432z().mo16434a(j)), chronology.mo16430x().mo16434a(j)), chronology.mo16426t().mo16434a(j)), chronology.mo16411e().mo16434a(j));
    }

    /* JADX INFO: renamed from: a */
    public static GJChronology m16671a(DateTimeZone dateTimeZone, ReadableInstant readableInstant) {
        return m16672a(dateTimeZone, readableInstant, 4);
    }

    /* JADX INFO: renamed from: a */
    public static GJChronology m16672a(DateTimeZone dateTimeZone, ReadableInstant readableInstant, int i) {
        Instant instant;
        GJChronology gJChronology;
        DateTimeZone dateTimeZoneM16517a = DateTimeUtils.m16517a(dateTimeZone);
        if (readableInstant == null) {
            instant = f15913a;
        } else {
            Instant instantMo16579b = readableInstant.mo16579b();
            if (new LocalDate(instantMo16579b.mo16580c(), GregorianChronology.m16705b(dateTimeZoneM16517a)).m16591d() <= 0) {
                throw new IllegalArgumentException("Cutover too early. Must be on or after 0001-01-01.");
            }
            instant = instantMo16579b;
        }
        GJCacheKey gJCacheKey = new GJCacheKey(dateTimeZoneM16517a, instant, i);
        GJChronology gJChronology2 = f15914b.get(gJCacheKey);
        if (gJChronology2 == null) {
            if (dateTimeZoneM16517a == DateTimeZone.f15751a) {
                gJChronology = new GJChronology(JulianChronology.m16709a(dateTimeZoneM16517a, i), GregorianChronology.m16704a(dateTimeZoneM16517a, i), instant);
            } else {
                GJChronology gJChronologyM16672a = m16672a(DateTimeZone.f15751a, instant, i);
                gJChronology = new GJChronology(ZonedChronology.m16721a(gJChronologyM16672a, dateTimeZoneM16517a), gJChronologyM16672a.f15915c, gJChronologyM16672a.f15916d, gJChronologyM16672a.f15917e);
            }
            GJChronology gJChronologyPutIfAbsent = f15914b.putIfAbsent(gJCacheKey, gJChronology);
            return gJChronologyPutIfAbsent != null ? gJChronologyPutIfAbsent : gJChronology;
        }
        return gJChronology2;
    }

    /* JADX INFO: renamed from: a */
    public static GJChronology m16670a(DateTimeZone dateTimeZone, long j, int i) {
        Instant instant;
        if (j == f15913a.mo16580c()) {
            instant = null;
        } else {
            instant = new Instant(j);
        }
        return m16672a(dateTimeZone, instant, i);
    }

    private GJChronology(JulianChronology julianChronology, GregorianChronology gregorianChronology, Instant instant) {
        super(null, new Object[]{julianChronology, gregorianChronology, instant});
    }

    private GJChronology(Chronology chronology, JulianChronology julianChronology, GregorianChronology gregorianChronology, Instant instant) {
        super(chronology, new Object[]{julianChronology, gregorianChronology, instant});
    }

    private Object readResolve() {
        return m16672a(mo16407a(), this.f15917e, m16675N());
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public DateTimeZone mo16407a() {
        Chronology chronologyL = m16616L();
        return chronologyL != null ? chronologyL.mo16407a() : DateTimeZone.f15751a;
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: b */
    public Chronology mo16408b() {
        return mo16406a(DateTimeZone.f15751a);
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public Chronology mo16406a(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.m16523a();
        }
        return dateTimeZone == mo16407a() ? this : m16672a(dateTimeZone, this.f15917e, m16675N());
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16402a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        Chronology chronologyL = m16616L();
        if (chronologyL != null) {
            return chronologyL.mo16402a(i, i2, i3, i4);
        }
        long jA = this.f15916d.mo16402a(i, i2, i3, i4);
        if (jA < this.f15918f) {
            long jA2 = this.f15915c.mo16402a(i, i2, i3, i4);
            if (jA2 >= this.f15918f) {
                throw new IllegalArgumentException("Specified date does not exist");
            }
            return jA2;
        }
        return jA;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16403a(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        long jA;
        Chronology chronologyL = m16616L();
        if (chronologyL != null) {
            return chronologyL.mo16403a(i, i2, i3, i4, i5, i6, i7);
        }
        try {
            jA = this.f15916d.mo16403a(i, i2, i3, i4, i5, i6, i7);
        } catch (IllegalFieldValueException e) {
            if (i2 != 2 || i3 != 29) {
                throw e;
            }
            jA = this.f15916d.mo16403a(i, i2, 28, i4, i5, i6, i7);
            if (jA >= this.f15918f) {
                throw e;
            }
        }
        if (jA < this.f15918f) {
            long jA2 = this.f15915c.mo16403a(i, i2, i3, i4, i5, i6, i7);
            if (jA2 >= this.f15918f) {
                throw new IllegalArgumentException("Specified date does not exist");
            }
            return jA2;
        }
        return jA;
    }

    /* JADX INFO: renamed from: N */
    public int m16675N() {
        return this.f15916d.m16626N();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GJChronology)) {
            return false;
        }
        GJChronology gJChronology = (GJChronology) obj;
        return this.f15918f == gJChronology.f15918f && m16675N() == gJChronology.m16675N() && mo16407a().equals(gJChronology.mo16407a());
    }

    public int hashCode() {
        return ("GJ".hashCode() * 11) + mo16407a().hashCode() + m16675N() + this.f15917e.hashCode();
    }

    @Override // org.joda.time.Chronology
    public String toString() {
        DateTimeFormatter dateTimeFormatterM16907d;
        StringBuffer stringBuffer = new StringBuffer(60);
        stringBuffer.append("GJChronology");
        stringBuffer.append('[');
        stringBuffer.append(mo16407a().m16548e());
        if (this.f15918f != f15913a.mo16580c()) {
            stringBuffer.append(",cutover=");
            if (mo16408b().mo16428v().mo16462i(this.f15918f) == 0) {
                dateTimeFormatterM16907d = ISODateTimeFormat.m16905b();
            } else {
                dateTimeFormatterM16907d = ISODateTimeFormat.m16907d();
            }
            dateTimeFormatterM16907d.m16780a(mo16408b()).m16786a(stringBuffer, this.f15918f);
        }
        if (m16675N() != 4) {
            stringBuffer.append(",mdfw=");
            stringBuffer.append(m16675N());
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    @Override // org.joda.time.chrono.AssembledChronology
    /* JADX INFO: renamed from: a */
    protected void mo16618a(AssembledChronology.Fields fields) {
        Object[] objArr = (Object[]) m16617M();
        JulianChronology julianChronology = (JulianChronology) objArr[0];
        GregorianChronology gregorianChronology = (GregorianChronology) objArr[1];
        Instant instant = (Instant) objArr[2];
        this.f15918f = instant.mo16580c();
        this.f15915c = julianChronology;
        this.f15916d = gregorianChronology;
        this.f15917e = instant;
        if (m16616L() == null) {
            if (julianChronology.m16626N() != gregorianChronology.m16626N()) {
                throw new IllegalArgumentException();
            }
            this.f15919g = this.f15918f - m16676a(this.f15918f);
            fields.m16621a(gregorianChronology);
            if (gregorianChronology.mo16411e().mo16434a(this.f15918f) == 0) {
                fields.f15858m = new CutoverField(this, julianChronology.mo16410d(), fields.f15858m, this.f15918f);
                fields.f15859n = new CutoverField(this, julianChronology.mo16411e(), fields.f15859n, this.f15918f);
                fields.f15860o = new CutoverField(this, julianChronology.mo16413g(), fields.f15860o, this.f15918f);
                fields.f15861p = new CutoverField(this, julianChronology.mo16414h(), fields.f15861p, this.f15918f);
                fields.f15862q = new CutoverField(this, julianChronology.mo16416j(), fields.f15862q, this.f15918f);
                fields.f15863r = new CutoverField(this, julianChronology.mo16417k(), fields.f15863r, this.f15918f);
                fields.f15864s = new CutoverField(this, julianChronology.mo16419m(), fields.f15864s, this.f15918f);
                fields.f15866u = new CutoverField(this, julianChronology.mo16422p(), fields.f15866u, this.f15918f);
                fields.f15865t = new CutoverField(this, julianChronology.mo16420n(), fields.f15865t, this.f15918f);
                fields.f15867v = new CutoverField(this, julianChronology.mo16423q(), fields.f15867v, this.f15918f);
                fields.f15868w = new CutoverField(this, julianChronology.mo16424r(), fields.f15868w, this.f15918f);
            }
            fields.f15845I = new CutoverField(this, julianChronology.mo16401K(), fields.f15845I, this.f15918f);
            fields.f15841E = new ImpreciseCutoverField(this, julianChronology.mo16395E(), fields.f15841E, this.f15918f);
            fields.f15855j = fields.f15841E.mo16453d();
            fields.f15842F = new ImpreciseCutoverField(this, julianChronology.mo16396F(), fields.f15842F, fields.f15855j, this.f15918f);
            fields.f15844H = new ImpreciseCutoverField(this, julianChronology.mo16399I(), fields.f15844H, this.f15918f);
            fields.f15856k = fields.f15844H.mo16453d();
            fields.f15843G = new ImpreciseCutoverField(this, julianChronology.mo16397G(), fields.f15843G, fields.f15855j, fields.f15856k, this.f15918f);
            fields.f15840D = new ImpreciseCutoverField(this, julianChronology.mo16393C(), fields.f15840D, (DurationField) null, fields.f15855j, this.f15918f);
            fields.f15854i = fields.f15840D.mo16453d();
            fields.f15838B = new ImpreciseCutoverField(julianChronology.mo16432z(), fields.f15838B, (DurationField) null, this.f15918f, true);
            fields.f15853h = fields.f15838B.mo16453d();
            fields.f15839C = new ImpreciseCutoverField(this, julianChronology.mo16391A(), fields.f15839C, fields.f15853h, fields.f15856k, this.f15918f);
            fields.f15871z = new CutoverField(julianChronology.mo16428v(), fields.f15871z, fields.f15855j, gregorianChronology.mo16395E().mo16454e(this.f15918f), false);
            fields.f15837A = new CutoverField(julianChronology.mo16430x(), fields.f15837A, fields.f15853h, gregorianChronology.mo16432z().mo16454e(this.f15918f), true);
            CutoverField cutoverField = new CutoverField(this, julianChronology.mo16427u(), fields.f15870y, this.f15918f);
            cutoverField.f15925f = fields.f15854i;
            fields.f15870y = cutoverField;
        }
    }

    /* JADX INFO: renamed from: a */
    long m16676a(long j) {
        return m16668a(j, this.f15915c, this.f15916d);
    }

    /* JADX INFO: renamed from: b */
    long m16677b(long j) {
        return m16668a(j, this.f15916d, this.f15915c);
    }

    /* JADX INFO: renamed from: c */
    long m16678c(long j) {
        return m16673b(j, this.f15915c, this.f15916d);
    }

    /* JADX INFO: renamed from: d */
    long m16679d(long j) {
        return m16673b(j, this.f15916d, this.f15915c);
    }

    private class CutoverField extends BaseDateTimeField {

        /* JADX INFO: renamed from: a */
        final DateTimeField f15920a;

        /* JADX INFO: renamed from: b */
        final DateTimeField f15921b;

        /* JADX INFO: renamed from: c */
        final long f15922c;

        /* JADX INFO: renamed from: d */
        final boolean f15923d;

        /* JADX INFO: renamed from: e */
        protected DurationField f15924e;

        /* JADX INFO: renamed from: f */
        protected DurationField f15925f;

        CutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, long j) {
            this(gJChronology, dateTimeField, dateTimeField2, j, false);
        }

        CutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, long j, boolean z) {
            this(dateTimeField, dateTimeField2, null, j, z);
        }

        CutoverField(DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, long j, boolean z) {
            super(dateTimeField2.mo16442a());
            this.f15920a = dateTimeField;
            this.f15921b = dateTimeField2;
            this.f15922c = j;
            this.f15923d = z;
            this.f15924e = dateTimeField2.mo16453d();
            if (durationField == null && (durationField = dateTimeField2.mo16455e()) == null) {
                durationField = dateTimeField.mo16455e();
            }
            this.f15925f = durationField;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public int mo16434a(long j) {
            return j >= this.f15922c ? this.f15921b.mo16434a(j) : this.f15920a.mo16434a(j);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public String mo16440a(long j, Locale locale) {
            return j >= this.f15922c ? this.f15921b.mo16440a(j, locale) : this.f15920a.mo16440a(j, locale);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public String mo16439a(int i, Locale locale) {
            return this.f15921b.mo16439a(i, locale);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: b */
        public String mo16446b(long j, Locale locale) {
            return j >= this.f15922c ? this.f15921b.mo16446b(j, locale) : this.f15920a.mo16446b(j, locale);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: b */
        public String mo16445b(int i, Locale locale) {
            return this.f15921b.mo16445b(i, locale);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public long mo16436a(long j, int i) {
            return this.f15921b.mo16436a(j, i);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public long mo16437a(long j, long j2) {
            return this.f15921b.mo16437a(j, j2);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: b */
        public long mo16443b(long j, int i) {
            long jMo16443b;
            if (j >= this.f15922c) {
                jMo16443b = this.f15921b.mo16443b(j, i);
                if (jMo16443b < this.f15922c) {
                    if (GJChronology.this.f15919g + jMo16443b < this.f15922c) {
                        jMo16443b = m16681k(jMo16443b);
                    }
                    if (mo16434a(jMo16443b) != i) {
                        throw new IllegalFieldValueException(this.f15921b.mo16442a(), Integer.valueOf(i), null, null);
                    }
                }
            } else {
                jMo16443b = this.f15920a.mo16443b(j, i);
                if (jMo16443b >= this.f15922c) {
                    if (jMo16443b - GJChronology.this.f15919g >= this.f15922c) {
                        jMo16443b = m16680j(jMo16443b);
                    }
                    if (mo16434a(jMo16443b) != i) {
                        throw new IllegalFieldValueException(this.f15920a.mo16442a(), Integer.valueOf(i), null, null);
                    }
                }
            }
            return jMo16443b;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public long mo16438a(long j, String str, Locale locale) {
            if (j >= this.f15922c) {
                long jMo16438a = this.f15921b.mo16438a(j, str, locale);
                if (jMo16438a < this.f15922c && GJChronology.this.f15919g + jMo16438a < this.f15922c) {
                    return m16681k(jMo16438a);
                }
                return jMo16438a;
            }
            long jMo16438a2 = this.f15920a.mo16438a(j, str, locale);
            if (jMo16438a2 >= this.f15922c && jMo16438a2 - GJChronology.this.f15919g >= this.f15922c) {
                return m16680j(jMo16438a2);
            }
            return jMo16438a2;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: d */
        public DurationField mo16453d() {
            return this.f15924e;
        }

        @Override // org.joda.time.DateTimeField
        /* JADX INFO: renamed from: e */
        public DurationField mo16455e() {
            return this.f15925f;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: b */
        public boolean mo16448b(long j) {
            return j >= this.f15922c ? this.f15921b.mo16448b(j) : this.f15920a.mo16448b(j);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: f */
        public DurationField mo16457f() {
            return this.f15921b.mo16457f();
        }

        @Override // org.joda.time.DateTimeField
        /* JADX INFO: renamed from: g */
        public int mo16458g() {
            return this.f15920a.mo16458g();
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: h */
        public int mo16460h() {
            return this.f15921b.mo16460h();
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: c */
        public int mo16449c(long j) {
            if (j >= this.f15922c) {
                return this.f15921b.mo16449c(j);
            }
            int iMo16449c = this.f15920a.mo16449c(j);
            if (this.f15920a.mo16443b(j, iMo16449c) >= this.f15922c) {
                return this.f15920a.mo16434a(this.f15920a.mo16436a(this.f15922c, -1));
            }
            return iMo16449c;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: d */
        public long mo16452d(long j) {
            if (j >= this.f15922c) {
                long jMo16452d = this.f15921b.mo16452d(j);
                if (jMo16452d < this.f15922c && GJChronology.this.f15919g + jMo16452d < this.f15922c) {
                    return m16681k(jMo16452d);
                }
                return jMo16452d;
            }
            return this.f15920a.mo16452d(j);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: e */
        public long mo16454e(long j) {
            if (j >= this.f15922c) {
                return this.f15921b.mo16454e(j);
            }
            long jMo16454e = this.f15920a.mo16454e(j);
            if (jMo16454e >= this.f15922c && jMo16454e - GJChronology.this.f15919g >= this.f15922c) {
                return m16680j(jMo16454e);
            }
            return jMo16454e;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public int mo16435a(Locale locale) {
            return Math.max(this.f15920a.mo16435a(locale), this.f15921b.mo16435a(locale));
        }

        /* JADX INFO: renamed from: j */
        protected long m16680j(long j) {
            return this.f15923d ? GJChronology.this.m16678c(j) : GJChronology.this.m16676a(j);
        }

        /* JADX INFO: renamed from: k */
        protected long m16681k(long j) {
            return this.f15923d ? GJChronology.this.m16679d(j) : GJChronology.this.m16677b(j);
        }
    }

    private final class ImpreciseCutoverField extends CutoverField {
        ImpreciseCutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, long j) {
            this(dateTimeField, dateTimeField2, (DurationField) null, j, false);
        }

        ImpreciseCutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, long j) {
            this(dateTimeField, dateTimeField2, durationField, j, false);
        }

        ImpreciseCutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, DurationField durationField2, long j) {
            this(dateTimeField, dateTimeField2, durationField, j, false);
            this.f15925f = durationField2;
        }

        ImpreciseCutoverField(DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, long j, boolean z) {
            super(GJChronology.this, dateTimeField, dateTimeField2, j, z);
            this.f15924e = durationField == null ? new LinkedDurationField(this.f15924e, this) : durationField;
        }

        @Override // org.joda.time.chrono.GJChronology.CutoverField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public long mo16436a(long j, int i) {
            if (j >= this.f15922c) {
                long jMo16436a = this.f15921b.mo16436a(j, i);
                if (jMo16436a < this.f15922c && GJChronology.this.f15919g + jMo16436a < this.f15922c) {
                    if (this.f15923d) {
                        if (GJChronology.this.f15916d.mo16432z().mo16434a(jMo16436a) <= 0) {
                            jMo16436a = GJChronology.this.f15916d.mo16432z().mo16436a(jMo16436a, -1);
                        }
                    } else if (GJChronology.this.f15916d.mo16395E().mo16434a(jMo16436a) <= 0) {
                        jMo16436a = GJChronology.this.f15916d.mo16395E().mo16436a(jMo16436a, -1);
                    }
                    return m16681k(jMo16436a);
                }
                return jMo16436a;
            }
            long jMo16436a2 = this.f15920a.mo16436a(j, i);
            if (jMo16436a2 >= this.f15922c && jMo16436a2 - GJChronology.this.f15919g >= this.f15922c) {
                return m16680j(jMo16436a2);
            }
            return jMo16436a2;
        }

        @Override // org.joda.time.chrono.GJChronology.CutoverField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public long mo16437a(long j, long j2) {
            if (j >= this.f15922c) {
                long jMo16437a = this.f15921b.mo16437a(j, j2);
                if (jMo16437a < this.f15922c && GJChronology.this.f15919g + jMo16437a < this.f15922c) {
                    if (this.f15923d) {
                        if (GJChronology.this.f15916d.mo16432z().mo16434a(jMo16437a) <= 0) {
                            jMo16437a = GJChronology.this.f15916d.mo16432z().mo16436a(jMo16437a, -1);
                        }
                    } else if (GJChronology.this.f15916d.mo16395E().mo16434a(jMo16437a) <= 0) {
                        jMo16437a = GJChronology.this.f15916d.mo16395E().mo16436a(jMo16437a, -1);
                    }
                    return m16681k(jMo16437a);
                }
                return jMo16437a;
            }
            long jMo16437a2 = this.f15920a.mo16437a(j, j2);
            if (jMo16437a2 >= this.f15922c && jMo16437a2 - GJChronology.this.f15919g >= this.f15922c) {
                return m16680j(jMo16437a2);
            }
            return jMo16437a2;
        }

        @Override // org.joda.time.chrono.GJChronology.CutoverField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: c */
        public int mo16449c(long j) {
            return j >= this.f15922c ? this.f15921b.mo16449c(j) : this.f15920a.mo16449c(j);
        }
    }

    private static class LinkedDurationField extends DecoratedDurationField {

        /* JADX INFO: renamed from: a */
        private final ImpreciseCutoverField f15928a;

        LinkedDurationField(DurationField durationField, ImpreciseCutoverField impreciseCutoverField) {
            super(durationField, durationField.mo16557a());
            this.f15928a = impreciseCutoverField;
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.DurationField
        /* JADX INFO: renamed from: a */
        public long mo16555a(long j, int i) {
            return this.f15928a.mo16436a(j, i);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.DurationField
        /* JADX INFO: renamed from: a */
        public long mo16556a(long j, long j2) {
            return this.f15928a.mo16437a(j, j2);
        }
    }
}
