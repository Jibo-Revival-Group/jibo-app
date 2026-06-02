package org.joda.time.chrono;

import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.ReadableInstant;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DelegatedDateTimeField;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.OffsetDateTimeField;
import org.joda.time.field.RemainderDateTimeField;
import org.joda.time.field.SkipUndoDateTimeField;
import org.joda.time.field.UnsupportedDurationField;

/* JADX INFO: loaded from: classes2.dex */
public final class BuddhistChronology extends AssembledChronology {

    /* JADX INFO: renamed from: a */
    private static final DateTimeField f15907a = new BasicSingleEraDateTimeField("BE");

    /* JADX INFO: renamed from: b */
    private static final ConcurrentHashMap<DateTimeZone, BuddhistChronology> f15908b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c */
    private static final BuddhistChronology f15909c = m16667b(DateTimeZone.f15751a);

    /* JADX INFO: renamed from: N */
    public static BuddhistChronology m16666N() {
        return f15909c;
    }

    /* JADX INFO: renamed from: b */
    public static BuddhistChronology m16667b(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.m16523a();
        }
        BuddhistChronology buddhistChronology = f15908b.get(dateTimeZone);
        if (buddhistChronology == null) {
            BuddhistChronology buddhistChronology2 = new BuddhistChronology(GJChronology.m16671a(dateTimeZone, (ReadableInstant) null), null);
            BuddhistChronology buddhistChronology3 = new BuddhistChronology(LimitChronology.m16714a(buddhistChronology2, new DateTime(1, 1, 1, 0, 0, 0, 0, buddhistChronology2), null), "");
            BuddhistChronology buddhistChronologyPutIfAbsent = f15908b.putIfAbsent(dateTimeZone, buddhistChronology3);
            return buddhistChronologyPutIfAbsent != null ? buddhistChronologyPutIfAbsent : buddhistChronology3;
        }
        return buddhistChronology;
    }

    private BuddhistChronology(Chronology chronology, Object obj) {
        super(chronology, obj);
    }

    private Object readResolve() {
        Chronology chronologyL = m16616L();
        return chronologyL == null ? m16666N() : m16667b(chronologyL.mo16407a());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: b */
    public Chronology mo16408b() {
        return f15909c;
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public Chronology mo16406a(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.m16523a();
        }
        return dateTimeZone == mo16407a() ? this : m16667b(dateTimeZone);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BuddhistChronology) {
            return mo16407a().equals(((BuddhistChronology) obj).mo16407a());
        }
        return false;
    }

    public int hashCode() {
        return ("Buddhist".hashCode() * 11) + mo16407a().hashCode();
    }

    @Override // org.joda.time.Chronology
    public String toString() {
        DateTimeZone dateTimeZoneA = mo16407a();
        return dateTimeZoneA != null ? "BuddhistChronology[" + dateTimeZoneA.m16548e() + ']' : "BuddhistChronology";
    }

    @Override // org.joda.time.chrono.AssembledChronology
    /* JADX INFO: renamed from: a */
    protected void mo16618a(AssembledChronology.Fields fields) {
        if (m16617M() == null) {
            fields.f15857l = UnsupportedDurationField.m16764a(DurationFieldType.m16572l());
            fields.f15841E = new OffsetDateTimeField(new SkipUndoDateTimeField(this, fields.f15841E), 543);
            DateTimeField dateTimeField = fields.f15842F;
            fields.f15842F = new DelegatedDateTimeField(fields.f15841E, fields.f15857l, DateTimeFieldType.m16505t());
            fields.f15838B = new OffsetDateTimeField(new SkipUndoDateTimeField(this, fields.f15838B), 543);
            fields.f15844H = new DividedDateTimeField(new OffsetDateTimeField(fields.f15842F, 99), fields.f15857l, DateTimeFieldType.m16507v(), 100);
            fields.f15856k = fields.f15844H.mo16453d();
            fields.f15843G = new OffsetDateTimeField(new RemainderDateTimeField((DividedDateTimeField) fields.f15844H), DateTimeFieldType.m16506u(), 1);
            fields.f15839C = new OffsetDateTimeField(new RemainderDateTimeField(fields.f15838B, fields.f15856k, DateTimeFieldType.m16502q(), 100), DateTimeFieldType.m16502q(), 1);
            fields.f15845I = f15907a;
        }
    }
}
