package org.joda.time.field;

import org.joda.time.DurationFieldType;

/* JADX INFO: loaded from: classes2.dex */
public class PreciseDurationField extends BaseDurationField {

    /* JADX INFO: renamed from: a */
    private final long f16018a;

    public PreciseDurationField(DurationFieldType durationFieldType, long j) {
        super(durationFieldType);
        this.f16018a = j;
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: c */
    public final boolean mo16559c() {
        return true;
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: d */
    public final long mo16560d() {
        return this.f16018a;
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: a */
    public long mo16555a(long j, int i) {
        return FieldUtils.m16754a(j, ((long) i) * this.f16018a);
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: a */
    public long mo16556a(long j, long j2) {
        return FieldUtils.m16754a(j, FieldUtils.m16758b(j2, this.f16018a));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreciseDurationField)) {
            return false;
        }
        PreciseDurationField preciseDurationField = (PreciseDurationField) obj;
        return mo16557a() == preciseDurationField.mo16557a() && this.f16018a == preciseDurationField.f16018a;
    }

    public int hashCode() {
        long j = this.f16018a;
        return ((int) (j ^ (j >>> 32))) + mo16557a().hashCode();
    }
}
