package org.joda.time.base;

import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.ReadablePartial;
import org.joda.time.field.FieldUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractPartial implements Comparable<ReadablePartial>, ReadablePartial {
    /* JADX INFO: renamed from: a */
    protected abstract DateTimeField mo16587a(int i, Chronology chronology);

    protected AbstractPartial() {
    }

    @Override // org.joda.time.ReadablePartial
    /* JADX INFO: renamed from: b */
    public DateTimeFieldType mo16604b(int i) {
        return mo16587a(i, mo16590c()).mo16442a();
    }

    /* JADX INFO: renamed from: a */
    public int mo16585a(DateTimeFieldType dateTimeFieldType) {
        return mo16584a(m16611d(dateTimeFieldType));
    }

    /* JADX INFO: renamed from: b */
    public boolean mo16589b(DateTimeFieldType dateTimeFieldType) {
        return m16610c(dateTimeFieldType) != -1;
    }

    /* JADX INFO: renamed from: c */
    public int m16610c(DateTimeFieldType dateTimeFieldType) {
        int iA = mo16583a();
        for (int i = 0; i < iA; i++) {
            if (mo16604b(i) == dateTimeFieldType) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: d */
    protected int m16611d(DateTimeFieldType dateTimeFieldType) {
        int iM16610c = m16610c(dateTimeFieldType);
        if (iM16610c == -1) {
            throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
        }
        return iM16610c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReadablePartial)) {
            return false;
        }
        ReadablePartial readablePartial = (ReadablePartial) obj;
        if (mo16583a() != readablePartial.mo16583a()) {
            return false;
        }
        int iA = mo16583a();
        for (int i = 0; i < iA; i++) {
            if (mo16584a(i) != readablePartial.mo16584a(i) || mo16604b(i) != readablePartial.mo16604b(i)) {
                return false;
            }
        }
        return FieldUtils.m16757a(mo16590c(), readablePartial.mo16590c());
    }

    public int hashCode() {
        int iA = 157;
        int iA2 = mo16583a();
        for (int i = 0; i < iA2; i++) {
            iA = (((iA * 23) + mo16584a(i)) * 23) + mo16604b(i).hashCode();
        }
        return mo16590c().hashCode() + iA;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ReadablePartial readablePartial) {
        if (this == readablePartial) {
            return 0;
        }
        if (mo16583a() != readablePartial.mo16583a()) {
            throw new ClassCastException("ReadablePartial objects must have matching field types");
        }
        int iA = mo16583a();
        for (int i = 0; i < iA; i++) {
            if (mo16604b(i) != readablePartial.mo16604b(i)) {
                throw new ClassCastException("ReadablePartial objects must have matching field types");
            }
        }
        int iA2 = mo16583a();
        for (int i2 = 0; i2 < iA2; i2++) {
            if (mo16584a(i2) > readablePartial.mo16584a(i2)) {
                return 1;
            }
            if (mo16584a(i2) < readablePartial.mo16584a(i2)) {
                return -1;
            }
        }
        return 0;
    }
}
