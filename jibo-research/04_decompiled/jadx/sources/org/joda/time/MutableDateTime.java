package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.joda.time.base.BaseDateTime;
import org.joda.time.field.AbstractReadableInstantFieldProperty;

/* JADX INFO: loaded from: classes2.dex */
public class MutableDateTime extends BaseDateTime implements Serializable, Cloneable, ReadWritableDateTime {

    /* JADX INFO: renamed from: a */
    private DateTimeField f15792a;

    /* JADX INFO: renamed from: b */
    private int f15793b;

    public MutableDateTime() {
    }

    public MutableDateTime(long j, DateTimeZone dateTimeZone) {
        super(j, dateTimeZone);
    }

    public MutableDateTime(long j, Chronology chronology) {
        super(j, chronology);
    }

    @Override // org.joda.time.base.BaseDateTime
    /* JADX INFO: renamed from: a */
    public void mo16596a(long j) {
        switch (this.f15793b) {
            case 1:
                j = this.f15792a.mo16452d(j);
                break;
            case 2:
                j = this.f15792a.mo16454e(j);
                break;
            case 3:
                j = this.f15792a.mo16456f(j);
                break;
            case 4:
                j = this.f15792a.mo16459g(j);
                break;
            case 5:
                j = this.f15792a.mo16461h(j);
                break;
        }
        super.mo16596a(j);
    }

    @Override // org.joda.time.base.BaseDateTime
    /* JADX INFO: renamed from: a */
    public void mo16597a(Chronology chronology) {
        super.mo16597a(chronology);
    }

    /* JADX INFO: renamed from: a */
    public void m16598a(DateTimeZone dateTimeZone) {
        DateTimeZone dateTimeZoneM16517a = DateTimeUtils.m16517a(dateTimeZone);
        DateTimeZone dateTimeZoneM16517a2 = DateTimeUtils.m16517a(m16609h());
        if (dateTimeZoneM16517a != dateTimeZoneM16517a2) {
            long jM16540a = dateTimeZoneM16517a2.m16540a(dateTimeZoneM16517a, mo16580c());
            mo16597a(mo16581d().mo16406a(dateTimeZoneM16517a));
            mo16596a(jM16540a);
        }
    }

    /* JADX INFO: renamed from: a */
    public Property m16595a(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        }
        DateTimeField dateTimeFieldMo16509a = dateTimeFieldType.mo16509a(mo16581d());
        if (!dateTimeFieldMo16509a.mo16451c()) {
            throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
        }
        return new Property(this, dateTimeFieldMo16509a);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError("Clone error");
        }
    }

    public static final class Property extends AbstractReadableInstantFieldProperty {

        /* JADX INFO: renamed from: a */
        private MutableDateTime f15794a;

        /* JADX INFO: renamed from: b */
        private DateTimeField f15795b;

        Property(MutableDateTime mutableDateTime, DateTimeField dateTimeField) {
            this.f15794a = mutableDateTime;
            this.f15795b = dateTimeField;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.f15794a);
            objectOutputStream.writeObject(this.f15795b.mo16442a());
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.f15794a = (MutableDateTime) objectInputStream.readObject();
            this.f15795b = ((DateTimeFieldType) objectInputStream.readObject()).mo16509a(this.f15794a.mo16581d());
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        /* JADX INFO: renamed from: a */
        public DateTimeField mo16599a() {
            return this.f15795b;
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        /* JADX INFO: renamed from: b */
        protected long mo16601b() {
            return this.f15794a.mo16580c();
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        /* JADX INFO: renamed from: c */
        protected Chronology mo16602c() {
            return this.f15794a.mo16581d();
        }

        /* JADX INFO: renamed from: a */
        public MutableDateTime m16600a(int i) {
            this.f15794a.mo16596a(mo16599a().mo16443b(this.f15794a.mo16580c(), i));
            return this.f15794a;
        }
    }
}
