package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

/* JADX INFO: loaded from: classes2.dex */
public class DividedDateTimeField extends DecoratedDateTimeField {

    /* JADX INFO: renamed from: a */
    final int f16002a;

    /* JADX INFO: renamed from: b */
    final DurationField f16003b;

    /* JADX INFO: renamed from: c */
    final DurationField f16004c;

    /* JADX INFO: renamed from: d */
    private final int f16005d;

    /* JADX INFO: renamed from: e */
    private final int f16006e;

    public DividedDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType, int i) {
        this(dateTimeField, dateTimeField.mo16455e(), dateTimeFieldType, i);
    }

    public DividedDateTimeField(DateTimeField dateTimeField, DurationField durationField, DateTimeFieldType dateTimeFieldType, int i) {
        super(dateTimeField, dateTimeFieldType);
        if (i < 2) {
            throw new IllegalArgumentException("The divisor must be at least 2");
        }
        DurationField durationFieldMo16453d = dateTimeField.mo16453d();
        if (durationFieldMo16453d == null) {
            this.f16003b = null;
        } else {
            this.f16003b = new ScaledDurationField(durationFieldMo16453d, dateTimeFieldType.mo16511y(), i);
        }
        this.f16004c = durationField;
        this.f16002a = i;
        int iMo16458g = dateTimeField.mo16458g();
        int i2 = iMo16458g >= 0 ? iMo16458g / i : ((iMo16458g + 1) / i) - 1;
        int iMo16460h = dateTimeField.mo16460h();
        int i3 = iMo16460h >= 0 ? iMo16460h / i : ((iMo16460h + 1) / i) - 1;
        this.f16005d = i2;
        this.f16006e = i3;
    }

    @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public DurationField mo16455e() {
        return this.f16004c != null ? this.f16004c : super.mo16455e();
    }

    @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16434a(long j) {
        int iMo16434a = m16748i().mo16434a(j);
        return iMo16434a >= 0 ? iMo16434a / this.f16002a : ((iMo16434a + 1) / this.f16002a) - 1;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16436a(long j, int i) {
        return m16748i().mo16436a(j, this.f16002a * i);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16437a(long j, long j2) {
        return m16748i().mo16437a(j, ((long) this.f16002a) * j2);
    }

    @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public long mo16443b(long j, int i) {
        FieldUtils.m16755a(this, i, this.f16005d, this.f16006e);
        return m16748i().mo16443b(j, m16750a(m16748i().mo16434a(j)) + (this.f16002a * i));
    }

    @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public DurationField mo16453d() {
        return this.f16003b;
    }

    @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public int mo16458g() {
        return this.f16005d;
    }

    @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public int mo16460h() {
        return this.f16006e;
    }

    @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public long mo16452d(long j) {
        DateTimeField dateTimeFieldI = m16748i();
        return dateTimeFieldI.mo16452d(dateTimeFieldI.mo16443b(j, mo16434a(j) * this.f16002a));
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: i */
    public long mo16462i(long j) {
        return mo16443b(j, mo16434a(m16748i().mo16462i(j)));
    }

    /* JADX INFO: renamed from: a */
    private int m16750a(int i) {
        return i >= 0 ? i % this.f16002a : (this.f16002a - 1) + ((i + 1) % this.f16002a);
    }
}
