package org.joda.time.chrono;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.RemainderDateTimeField;

/* JADX INFO: loaded from: classes2.dex */
public final class ISOChronology extends AssembledChronology {

    /* JADX INFO: renamed from: b */
    private static final ConcurrentHashMap<DateTimeZone, ISOChronology> f15951b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a */
    private static final ISOChronology f15950a = new ISOChronology(GregorianChronology.m16703Z());

    static {
        f15951b.put(DateTimeZone.f15751a, f15950a);
    }

    /* JADX INFO: renamed from: N */
    public static ISOChronology m16706N() {
        return f15950a;
    }

    /* JADX INFO: renamed from: O */
    public static ISOChronology m16707O() {
        return m16708b(DateTimeZone.m16523a());
    }

    /* JADX INFO: renamed from: b */
    public static ISOChronology m16708b(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.m16523a();
        }
        ISOChronology iSOChronology = f15951b.get(dateTimeZone);
        if (iSOChronology == null) {
            ISOChronology iSOChronology2 = new ISOChronology(ZonedChronology.m16721a(f15950a, dateTimeZone));
            ISOChronology iSOChronologyPutIfAbsent = f15951b.putIfAbsent(dateTimeZone, iSOChronology2);
            return iSOChronologyPutIfAbsent != null ? iSOChronologyPutIfAbsent : iSOChronology2;
        }
        return iSOChronology;
    }

    private ISOChronology(Chronology chronology) {
        super(chronology, null);
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: b */
    public Chronology mo16408b() {
        return f15950a;
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public Chronology mo16406a(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.m16523a();
        }
        return dateTimeZone == mo16407a() ? this : m16708b(dateTimeZone);
    }

    @Override // org.joda.time.Chronology
    public String toString() {
        DateTimeZone dateTimeZoneA = mo16407a();
        return dateTimeZoneA != null ? "ISOChronology[" + dateTimeZoneA.m16548e() + ']' : "ISOChronology";
    }

    @Override // org.joda.time.chrono.AssembledChronology
    /* JADX INFO: renamed from: a */
    protected void mo16618a(AssembledChronology.Fields fields) {
        if (m16616L().mo16407a() == DateTimeZone.f15751a) {
            fields.f15844H = new DividedDateTimeField(ISOYearOfEraDateTimeField.f15953a, DateTimeFieldType.m16507v(), 100);
            fields.f15856k = fields.f15844H.mo16453d();
            fields.f15843G = new RemainderDateTimeField((DividedDateTimeField) fields.f15844H, DateTimeFieldType.m16506u());
            fields.f15839C = new RemainderDateTimeField((DividedDateTimeField) fields.f15844H, fields.f15853h, DateTimeFieldType.m16502q());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ISOChronology) {
            return mo16407a().equals(((ISOChronology) obj).mo16407a());
        }
        return false;
    }

    public int hashCode() {
        return ("ISO".hashCode() * 11) + mo16407a().hashCode();
    }

    private Object writeReplace() {
        return new Stub(mo16407a());
    }

    private static final class Stub implements Serializable {

        /* JADX INFO: renamed from: a */
        private transient DateTimeZone f15952a;

        Stub(DateTimeZone dateTimeZone) {
            this.f15952a = dateTimeZone;
        }

        private Object readResolve() {
            return ISOChronology.m16708b(this.f15952a);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.f15952a);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.f15952a = (DateTimeZone) objectInputStream.readObject();
        }
    }
}
