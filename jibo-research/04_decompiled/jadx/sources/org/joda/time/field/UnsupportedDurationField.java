package org.joda.time.field;

import java.io.Serializable;
import java.util.HashMap;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

/* JADX INFO: loaded from: classes2.dex */
public final class UnsupportedDurationField extends DurationField implements Serializable {

    /* JADX INFO: renamed from: a */
    private static HashMap<DurationFieldType, UnsupportedDurationField> f16032a;

    /* JADX INFO: renamed from: b */
    private final DurationFieldType f16033b;

    /* JADX INFO: renamed from: a */
    public static synchronized UnsupportedDurationField m16764a(DurationFieldType durationFieldType) {
        UnsupportedDurationField unsupportedDurationField;
        if (f16032a == null) {
            f16032a = new HashMap<>(7);
            unsupportedDurationField = null;
        } else {
            unsupportedDurationField = f16032a.get(durationFieldType);
        }
        if (unsupportedDurationField == null) {
            unsupportedDurationField = new UnsupportedDurationField(durationFieldType);
            f16032a.put(durationFieldType, unsupportedDurationField);
        }
        return unsupportedDurationField;
    }

    private UnsupportedDurationField(DurationFieldType durationFieldType) {
        this.f16033b = durationFieldType;
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: a */
    public final DurationFieldType mo16557a() {
        return this.f16033b;
    }

    /* JADX INFO: renamed from: e */
    public String m16767e() {
        return this.f16033b.m16574m();
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: b */
    public boolean mo16558b() {
        return false;
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: c */
    public boolean mo16559c() {
        return true;
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: a */
    public long mo16555a(long j, int i) {
        throw m16765f();
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: a */
    public long mo16556a(long j, long j2) {
        throw m16765f();
    }

    @Override // org.joda.time.DurationField
    /* JADX INFO: renamed from: d */
    public long mo16560d() {
        return 0L;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(DurationField durationField) {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnsupportedDurationField)) {
            return false;
        }
        UnsupportedDurationField unsupportedDurationField = (UnsupportedDurationField) obj;
        if (unsupportedDurationField.m16767e() == null) {
            return m16767e() == null;
        }
        return unsupportedDurationField.m16767e().equals(m16767e());
    }

    public int hashCode() {
        return m16767e().hashCode();
    }

    public String toString() {
        return "UnsupportedDurationField[" + m16767e() + ']';
    }

    private Object readResolve() {
        return m16764a(this.f16033b);
    }

    /* JADX INFO: renamed from: f */
    private UnsupportedOperationException m16765f() {
        return new UnsupportedOperationException(this.f16033b + " field is unsupported");
    }
}
