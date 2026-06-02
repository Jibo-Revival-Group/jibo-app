package org.joda.time.field;

import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

/* JADX INFO: loaded from: classes2.dex */
public class ScaledDurationField extends DecoratedDurationField {

    /* JADX INFO: renamed from: a */
    private final int f16022a;

    public ScaledDurationField(DurationField durationField, DurationFieldType durationFieldType, int i) {
        super(durationField, durationFieldType);
        if (i == 0 || i == 1) {
            throw new IllegalArgumentException("The scalar must not be 0 or 1");
        }
        this.f16022a = i;
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.DurationField
    /* JADX INFO: renamed from: a */
    public long mo16555a(long j, int i) {
        return m16749f().mo16556a(j, ((long) i) * ((long) this.f16022a));
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.DurationField
    /* JADX INFO: renamed from: a */
    public long mo16556a(long j, long j2) {
        return m16749f().mo16556a(j, FieldUtils.m16753a(j2, this.f16022a));
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.DurationField
    /* JADX INFO: renamed from: d */
    public long mo16560d() {
        return m16749f().mo16560d() * ((long) this.f16022a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScaledDurationField)) {
            return false;
        }
        ScaledDurationField scaledDurationField = (ScaledDurationField) obj;
        return m16749f().equals(scaledDurationField.m16749f()) && mo16557a() == scaledDurationField.mo16557a() && this.f16022a == scaledDurationField.f16022a;
    }

    public int hashCode() {
        long j = this.f16022a;
        return ((int) (j ^ (j >>> 32))) + mo16557a().hashCode() + m16749f().hashCode();
    }
}
