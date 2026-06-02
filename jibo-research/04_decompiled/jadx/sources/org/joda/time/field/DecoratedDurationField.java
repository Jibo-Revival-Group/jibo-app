package org.joda.time.field;

import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

/* JADX INFO: loaded from: classes2.dex */
public class DecoratedDurationField extends BaseDurationField {

    /* JADX INFO: renamed from: a */
    private final DurationField f15998a;

    public DecoratedDurationField(DurationField durationField, DurationFieldType durationFieldType) {
        super(durationFieldType);
        if (durationField == null) {
            throw new IllegalArgumentException("The field must not be null");
        }
        if (!durationField.mo16558b()) {
            throw new IllegalArgumentException("The field must be supported");
        }
        this.f15998a = durationField;
    }

    /* JADX INFO: renamed from: f */
    public final DurationField m16749f() {
        return this.f15998a;
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: c */
    public boolean mo16559c() {
        return this.f15998a.mo16559c();
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: a */
    public long mo16555a(long j, int i) {
        return this.f15998a.mo16555a(j, i);
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: a */
    public long mo16556a(long j, long j2) {
        return this.f15998a.mo16556a(j, j2);
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: d */
    public long mo16560d() {
        return this.f15998a.mo16560d();
    }
}
