package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseDurationField extends DurationField implements Serializable {

    /* JADX INFO: renamed from: a */
    private final DurationFieldType f15996a;

    protected BaseDurationField(DurationFieldType durationFieldType) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("The type must not be null");
        }
        this.f15996a = durationFieldType;
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: a */
    public final DurationFieldType mo16557a() {
        return this.f15996a;
    }

    /* JADX INFO: renamed from: e */
    public final String m16747e() {
        return this.f15996a.m16574m();
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: b */
    public final boolean mo16558b() {
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(DurationField durationField) {
        long jMo16560d = durationField.mo16560d();
        long jD = mo16560d();
        if (jD == jMo16560d) {
            return 0;
        }
        if (jD < jMo16560d) {
            return -1;
        }
        return 1;
    }

    public String toString() {
        return "DurationField[" + m16747e() + ']';
    }
}
