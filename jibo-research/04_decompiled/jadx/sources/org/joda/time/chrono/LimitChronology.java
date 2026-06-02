package org.joda.time.chrono;

import java.util.HashMap;
import java.util.Locale;
import org.apache.http.message.TokenParser;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadableDateTime;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DecoratedDateTimeField;
import org.joda.time.field.DecoratedDurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/* JADX INFO: loaded from: classes2.dex */
public final class LimitChronology extends AssembledChronology {

    /* JADX INFO: renamed from: a */
    final DateTime f15956a;

    /* JADX INFO: renamed from: b */
    final DateTime f15957b;

    /* JADX INFO: renamed from: c */
    private transient LimitChronology f15958c;

    /* JADX INFO: renamed from: a */
    public static LimitChronology m16714a(Chronology chronology, ReadableDateTime readableDateTime, ReadableDateTime readableDateTime2) {
        if (chronology == null) {
            throw new IllegalArgumentException("Must supply a chronology");
        }
        DateTime dateTimeMo16433a = readableDateTime == null ? null : readableDateTime.mo16433a();
        DateTime dateTimeMo16433a2 = readableDateTime2 != null ? readableDateTime2.mo16433a() : null;
        if (dateTimeMo16433a != null && dateTimeMo16433a2 != null && !dateTimeMo16433a.mo16603a(dateTimeMo16433a2)) {
            throw new IllegalArgumentException("The lower limit must be come before than the upper limit");
        }
        return new LimitChronology(chronology, dateTimeMo16433a, dateTimeMo16433a2);
    }

    private LimitChronology(Chronology chronology, DateTime dateTime, DateTime dateTime2) {
        super(chronology, null);
        this.f15956a = dateTime;
        this.f15957b = dateTime2;
    }

    /* JADX INFO: renamed from: N */
    public DateTime m16715N() {
        return this.f15956a;
    }

    /* JADX INFO: renamed from: O */
    public DateTime m16716O() {
        return this.f15957b;
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
        if (dateTimeZone != mo16407a()) {
            if (dateTimeZone == DateTimeZone.f15751a && this.f15958c != null) {
                return this.f15958c;
            }
            DateTime dateTimeA = this.f15956a;
            if (dateTimeA != null) {
                MutableDateTime mutableDateTimeE = dateTimeA.mo16582e();
                mutableDateTimeE.m16598a(dateTimeZone);
                dateTimeA = mutableDateTimeE.mo16433a();
            }
            DateTime dateTimeA2 = this.f15957b;
            if (dateTimeA2 != null) {
                MutableDateTime mutableDateTimeE2 = dateTimeA2.mo16582e();
                mutableDateTimeE2.m16598a(dateTimeZone);
                dateTimeA2 = mutableDateTimeE2.mo16433a();
            }
            LimitChronology limitChronologyM16714a = m16714a(m16616L().mo16406a(dateTimeZone), dateTimeA, dateTimeA2);
            if (dateTimeZone == DateTimeZone.f15751a) {
                this.f15958c = limitChronologyM16714a;
            }
            return limitChronologyM16714a;
        }
        return this;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16402a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        long jMo16402a = m16616L().mo16402a(i, i2, i3, i4);
        m16717a(jMo16402a, "resulting");
        return jMo16402a;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16403a(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        long jMo16403a = m16616L().mo16403a(i, i2, i3, i4, i5, i6, i7);
        m16717a(jMo16403a, "resulting");
        return jMo16403a;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16404a(long j, int i, int i2, int i3, int i4) throws IllegalArgumentException {
        m16717a(j, (String) null);
        long jMo16404a = m16616L().mo16404a(j, i, i2, i3, i4);
        m16717a(jMo16404a, "resulting");
        return jMo16404a;
    }

    @Override // org.joda.time.chrono.AssembledChronology
    /* JADX INFO: renamed from: a */
    protected void mo16618a(AssembledChronology.Fields fields) {
        HashMap<Object, Object> map = new HashMap<>();
        fields.f15857l = m16713a(fields.f15857l, map);
        fields.f15856k = m16713a(fields.f15856k, map);
        fields.f15855j = m16713a(fields.f15855j, map);
        fields.f15854i = m16713a(fields.f15854i, map);
        fields.f15853h = m16713a(fields.f15853h, map);
        fields.f15852g = m16713a(fields.f15852g, map);
        fields.f15851f = m16713a(fields.f15851f, map);
        fields.f15850e = m16713a(fields.f15850e, map);
        fields.f15849d = m16713a(fields.f15849d, map);
        fields.f15848c = m16713a(fields.f15848c, map);
        fields.f15847b = m16713a(fields.f15847b, map);
        fields.f15846a = m16713a(fields.f15846a, map);
        fields.f15841E = m16712a(fields.f15841E, map);
        fields.f15842F = m16712a(fields.f15842F, map);
        fields.f15843G = m16712a(fields.f15843G, map);
        fields.f15844H = m16712a(fields.f15844H, map);
        fields.f15845I = m16712a(fields.f15845I, map);
        fields.f15869x = m16712a(fields.f15869x, map);
        fields.f15870y = m16712a(fields.f15870y, map);
        fields.f15871z = m16712a(fields.f15871z, map);
        fields.f15840D = m16712a(fields.f15840D, map);
        fields.f15837A = m16712a(fields.f15837A, map);
        fields.f15838B = m16712a(fields.f15838B, map);
        fields.f15839C = m16712a(fields.f15839C, map);
        fields.f15858m = m16712a(fields.f15858m, map);
        fields.f15859n = m16712a(fields.f15859n, map);
        fields.f15860o = m16712a(fields.f15860o, map);
        fields.f15861p = m16712a(fields.f15861p, map);
        fields.f15862q = m16712a(fields.f15862q, map);
        fields.f15863r = m16712a(fields.f15863r, map);
        fields.f15864s = m16712a(fields.f15864s, map);
        fields.f15866u = m16712a(fields.f15866u, map);
        fields.f15865t = m16712a(fields.f15865t, map);
        fields.f15867v = m16712a(fields.f15867v, map);
        fields.f15868w = m16712a(fields.f15868w, map);
    }

    /* JADX INFO: renamed from: a */
    private DurationField m16713a(DurationField durationField, HashMap<Object, Object> map) {
        if (durationField == null || !durationField.mo16558b()) {
            return durationField;
        }
        if (map.containsKey(durationField)) {
            return (DurationField) map.get(durationField);
        }
        LimitDurationField limitDurationField = new LimitDurationField(durationField);
        map.put(durationField, limitDurationField);
        return limitDurationField;
    }

    /* JADX INFO: renamed from: a */
    private DateTimeField m16712a(DateTimeField dateTimeField, HashMap<Object, Object> map) {
        if (dateTimeField == null || !dateTimeField.mo16451c()) {
            return dateTimeField;
        }
        if (map.containsKey(dateTimeField)) {
            return (DateTimeField) map.get(dateTimeField);
        }
        LimitDateTimeField limitDateTimeField = new LimitDateTimeField(dateTimeField, m16713a(dateTimeField.mo16453d(), map), m16713a(dateTimeField.mo16455e(), map), m16713a(dateTimeField.mo16457f(), map));
        map.put(dateTimeField, limitDateTimeField);
        return limitDateTimeField;
    }

    /* JADX INFO: renamed from: a */
    void m16717a(long j, String str) {
        DateTime dateTime = this.f15956a;
        if (dateTime != null && j < dateTime.mo16580c()) {
            throw new LimitException(str, true);
        }
        DateTime dateTime2 = this.f15957b;
        if (dateTime2 != null && j >= dateTime2.mo16580c()) {
            throw new LimitException(str, false);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitChronology)) {
            return false;
        }
        LimitChronology limitChronology = (LimitChronology) obj;
        return m16616L().equals(limitChronology.m16616L()) && FieldUtils.m16757a(m16715N(), limitChronology.m16715N()) && FieldUtils.m16757a(m16716O(), limitChronology.m16716O());
    }

    public int hashCode() {
        return (m16715N() != null ? m16715N().hashCode() : 0) + 317351877 + (m16716O() != null ? m16716O().hashCode() : 0) + (m16616L().hashCode() * 7);
    }

    @Override // org.joda.time.Chronology
    public String toString() {
        return "LimitChronology[" + m16616L().toString() + ", " + (m16715N() == null ? "NoLimit" : m16715N().toString()) + ", " + (m16716O() == null ? "NoLimit" : m16716O().toString()) + ']';
    }

    private class LimitException extends IllegalArgumentException {

        /* JADX INFO: renamed from: b */
        private final boolean f15965b;

        LimitException(String str, boolean z) {
            super(str);
            this.f15965b = z;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuffer stringBuffer = new StringBuffer(85);
            stringBuffer.append("The");
            String message = super.getMessage();
            if (message != null) {
                stringBuffer.append(TokenParser.f15715SP);
                stringBuffer.append(message);
            }
            stringBuffer.append(" instant is ");
            DateTimeFormatter dateTimeFormatterM16780a = ISODateTimeFormat.m16907d().m16780a(LimitChronology.this.m16616L());
            if (this.f15965b) {
                stringBuffer.append("below the supported minimum of ");
                dateTimeFormatterM16780a.m16786a(stringBuffer, LimitChronology.this.m16715N().mo16580c());
            } else {
                stringBuffer.append("above the supported maximum of ");
                dateTimeFormatterM16780a.m16786a(stringBuffer, LimitChronology.this.m16716O().mo16580c());
            }
            stringBuffer.append(" (");
            stringBuffer.append(LimitChronology.this.m16616L());
            stringBuffer.append(')');
            return stringBuffer.toString();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "IllegalArgumentException: " + getMessage();
        }
    }

    private class LimitDurationField extends DecoratedDurationField {
        LimitDurationField(DurationField durationField) {
            super(durationField, durationField.mo16557a());
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.DurationField
        /* JADX INFO: renamed from: a */
        public long mo16555a(long j, int i) {
            LimitChronology.this.m16717a(j, (String) null);
            long jMo16555a = m16749f().mo16555a(j, i);
            LimitChronology.this.m16717a(jMo16555a, "resulting");
            return jMo16555a;
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.DurationField
        /* JADX INFO: renamed from: a */
        public long mo16556a(long j, long j2) {
            LimitChronology.this.m16717a(j, (String) null);
            long jMo16556a = m16749f().mo16556a(j, j2);
            LimitChronology.this.m16717a(jMo16556a, "resulting");
            return jMo16556a;
        }
    }

    private class LimitDateTimeField extends DecoratedDateTimeField {

        /* JADX INFO: renamed from: b */
        private final DurationField f15960b;

        /* JADX INFO: renamed from: c */
        private final DurationField f15961c;

        /* JADX INFO: renamed from: d */
        private final DurationField f15962d;

        LimitDateTimeField(DateTimeField dateTimeField, DurationField durationField, DurationField durationField2, DurationField durationField3) {
            super(dateTimeField, dateTimeField.mo16442a());
            this.f15960b = durationField;
            this.f15961c = durationField2;
            this.f15962d = durationField3;
        }

        @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public int mo16434a(long j) {
            LimitChronology.this.m16717a(j, (String) null);
            return m16748i().mo16434a(j);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public String mo16440a(long j, Locale locale) {
            LimitChronology.this.m16717a(j, (String) null);
            return m16748i().mo16440a(j, locale);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: b */
        public String mo16446b(long j, Locale locale) {
            LimitChronology.this.m16717a(j, (String) null);
            return m16748i().mo16446b(j, locale);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public long mo16436a(long j, int i) {
            LimitChronology.this.m16717a(j, (String) null);
            long jMo16436a = m16748i().mo16436a(j, i);
            LimitChronology.this.m16717a(jMo16436a, "resulting");
            return jMo16436a;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public long mo16437a(long j, long j2) {
            LimitChronology.this.m16717a(j, (String) null);
            long jMo16437a = m16748i().mo16437a(j, j2);
            LimitChronology.this.m16717a(jMo16437a, "resulting");
            return jMo16437a;
        }

        @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: b */
        public long mo16443b(long j, int i) {
            LimitChronology.this.m16717a(j, (String) null);
            long jMo16443b = m16748i().mo16443b(j, i);
            LimitChronology.this.m16717a(jMo16443b, "resulting");
            return jMo16443b;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public long mo16438a(long j, String str, Locale locale) {
            LimitChronology.this.m16717a(j, (String) null);
            long jMo16438a = m16748i().mo16438a(j, str, locale);
            LimitChronology.this.m16717a(jMo16438a, "resulting");
            return jMo16438a;
        }

        @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: d */
        public final DurationField mo16453d() {
            return this.f15960b;
        }

        @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: e */
        public final DurationField mo16455e() {
            return this.f15961c;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: b */
        public boolean mo16448b(long j) {
            LimitChronology.this.m16717a(j, (String) null);
            return m16748i().mo16448b(j);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: f */
        public final DurationField mo16457f() {
            return this.f15962d;
        }

        @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: d */
        public long mo16452d(long j) {
            LimitChronology.this.m16717a(j, (String) null);
            long jMo16452d = m16748i().mo16452d(j);
            LimitChronology.this.m16717a(jMo16452d, "resulting");
            return jMo16452d;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: e */
        public long mo16454e(long j) {
            LimitChronology.this.m16717a(j, (String) null);
            long jMo16454e = m16748i().mo16454e(j);
            LimitChronology.this.m16717a(jMo16454e, "resulting");
            return jMo16454e;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: f */
        public long mo16456f(long j) {
            LimitChronology.this.m16717a(j, (String) null);
            long jMo16456f = m16748i().mo16456f(j);
            LimitChronology.this.m16717a(jMo16456f, "resulting");
            return jMo16456f;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: g */
        public long mo16459g(long j) {
            LimitChronology.this.m16717a(j, (String) null);
            long jMo16459g = m16748i().mo16459g(j);
            LimitChronology.this.m16717a(jMo16459g, "resulting");
            return jMo16459g;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: h */
        public long mo16461h(long j) {
            LimitChronology.this.m16717a(j, (String) null);
            long jMo16461h = m16748i().mo16461h(j);
            LimitChronology.this.m16717a(jMo16461h, "resulting");
            return jMo16461h;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: i */
        public long mo16462i(long j) {
            LimitChronology.this.m16717a(j, (String) null);
            long jMo16462i = m16748i().mo16462i(j);
            LimitChronology.this.m16717a(jMo16462i, "resulting");
            return jMo16462i;
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: c */
        public int mo16449c(long j) {
            LimitChronology.this.m16717a(j, (String) null);
            return m16748i().mo16449c(j);
        }

        @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
        /* JADX INFO: renamed from: a */
        public int mo16435a(Locale locale) {
            return m16748i().mo16435a(locale);
        }
    }
}
