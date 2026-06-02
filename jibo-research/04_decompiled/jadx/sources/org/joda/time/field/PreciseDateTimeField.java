package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

/* JADX INFO: loaded from: classes2.dex */
public class PreciseDateTimeField extends PreciseDurationDateTimeField {

    /* JADX INFO: renamed from: b */
    private final int f16014b;

    /* JADX INFO: renamed from: c */
    private final DurationField f16015c;

    public PreciseDateTimeField(DateTimeFieldType dateTimeFieldType, DurationField durationField, DurationField durationField2) {
        super(dateTimeFieldType, durationField);
        if (!durationField2.mo16559c()) {
            throw new IllegalArgumentException("Range duration field must be precise");
        }
        this.f16014b = (int) (durationField2.mo16560d() / m16760i());
        if (this.f16014b < 2) {
            throw new IllegalArgumentException("The effective range must be at least 2");
        }
        this.f16015c = durationField2;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16434a(long j) {
        return j >= 0 ? (int) ((j / m16760i()) % ((long) this.f16014b)) : (this.f16014b - 1) + ((int) (((1 + j) / m16760i()) % ((long) this.f16014b)));
    }

    @Override // org.joda.time.field.PreciseDurationDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public long mo16443b(long j, int i) {
        FieldUtils.m16755a(this, i, mo16458g(), mo16460h());
        return (((long) (i - mo16434a(j))) * this.f16016a) + j;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public DurationField mo16455e() {
        return this.f16015c;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public int mo16460h() {
        return this.f16014b - 1;
    }
}
