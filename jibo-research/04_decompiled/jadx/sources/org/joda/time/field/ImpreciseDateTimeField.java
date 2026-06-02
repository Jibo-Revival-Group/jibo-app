package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImpreciseDateTimeField extends BaseDateTimeField {

    /* JADX INFO: renamed from: a */
    private final DurationField f16007a;

    /* JADX INFO: renamed from: b */
    final long f16008b;

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public abstract long mo16436a(long j, int i);

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public abstract long mo16437a(long j, long j2);

    public ImpreciseDateTimeField(DateTimeFieldType dateTimeFieldType, long j) {
        super(dateTimeFieldType);
        this.f16008b = j;
        this.f16007a = new LinkedDurationField(dateTimeFieldType.mo16511y());
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public final DurationField mo16453d() {
        return this.f16007a;
    }

    private final class LinkedDurationField extends BaseDurationField {
        LinkedDurationField(DurationFieldType durationFieldType) {
            super(durationFieldType);
        }

        @Override // org.joda.time.DurationField
        /* JADX INFO: renamed from: c */
        public boolean mo16559c() {
            return false;
        }

        @Override // org.joda.time.DurationField
        /* JADX INFO: renamed from: d */
        public long mo16560d() {
            return ImpreciseDateTimeField.this.f16008b;
        }

        @Override // org.joda.time.DurationField
        /* JADX INFO: renamed from: a */
        public long mo16555a(long j, int i) {
            return ImpreciseDateTimeField.this.mo16436a(j, i);
        }

        @Override // org.joda.time.DurationField
        /* JADX INFO: renamed from: a */
        public long mo16556a(long j, long j2) {
            return ImpreciseDateTimeField.this.mo16437a(j, j2);
        }
    }
}
