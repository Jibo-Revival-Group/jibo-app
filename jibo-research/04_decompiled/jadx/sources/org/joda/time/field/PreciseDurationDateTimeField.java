package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PreciseDurationDateTimeField extends BaseDateTimeField {

    /* JADX INFO: renamed from: a */
    final long f16016a;

    /* JADX INFO: renamed from: b */
    private final DurationField f16017b;

    public PreciseDurationDateTimeField(DateTimeFieldType dateTimeFieldType, DurationField durationField) {
        super(dateTimeFieldType);
        if (!durationField.mo16559c()) {
            throw new IllegalArgumentException("Unit duration field must be precise");
        }
        this.f16016a = durationField.mo16560d();
        if (this.f16016a < 1) {
            throw new IllegalArgumentException("The unit milliseconds must be at least 1");
        }
        this.f16017b = durationField;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public long mo16443b(long j, int i) {
        FieldUtils.m16755a(this, i, mo16458g(), mo16665d(j, i));
        return (((long) (i - mo16434a(j))) * this.f16016a) + j;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public long mo16452d(long j) {
        if (j >= 0) {
            return j - (j % this.f16016a);
        }
        long j2 = 1 + j;
        return (j2 - (j2 % this.f16016a)) - this.f16016a;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public long mo16454e(long j) {
        if (j <= 0) {
            return j - (j % this.f16016a);
        }
        long j2 = j - 1;
        return (j2 - (j2 % this.f16016a)) + this.f16016a;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: i */
    public long mo16462i(long j) {
        return j >= 0 ? j % this.f16016a : (((j + 1) % this.f16016a) + this.f16016a) - 1;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public DurationField mo16453d() {
        return this.f16017b;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public int mo16458g() {
        return 0;
    }

    /* JADX INFO: renamed from: i */
    public final long m16760i() {
        return this.f16016a;
    }

    /* JADX INFO: renamed from: d */
    protected int mo16665d(long j, int i) {
        return mo16449c(j);
    }
}
