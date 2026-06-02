package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

/* JADX INFO: loaded from: classes2.dex */
public final class MillisDurationField extends DurationField implements Serializable {

    /* JADX INFO: renamed from: a */
    public static final DurationField f16010a = new MillisDurationField();

    private MillisDurationField() {
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: a */
    public DurationFieldType mo16557a() {
        return DurationFieldType.m16561a();
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: b */
    public boolean mo16558b() {
        return true;
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: c */
    public final boolean mo16559c() {
        return true;
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: d */
    public final long mo16560d() {
        return 1L;
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: a */
    public long mo16555a(long j, int i) {
        return FieldUtils.m16754a(j, i);
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: a */
    public long mo16556a(long j, long j2) {
        return FieldUtils.m16754a(j, j2);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(DurationField durationField) {
        long jMo16560d = durationField.mo16560d();
        long jMo16560d2 = mo16560d();
        if (jMo16560d2 == jMo16560d) {
            return 0;
        }
        if (jMo16560d2 < jMo16560d) {
            return -1;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MillisDurationField) && mo16560d() == ((MillisDurationField) obj).mo16560d();
    }

    public int hashCode() {
        return (int) mo16560d();
    }

    public String toString() {
        return "DurationField[millis]";
    }

    private Object readResolve() {
        return f16010a;
    }
}
