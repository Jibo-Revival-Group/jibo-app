package org.joda.time.field;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;

/* JADX INFO: loaded from: classes2.dex */
public final class UnsupportedDateTimeField extends DateTimeField implements Serializable {

    /* JADX INFO: renamed from: a */
    private static HashMap<DateTimeFieldType, UnsupportedDateTimeField> f16029a;

    /* JADX INFO: renamed from: b */
    private final DateTimeFieldType f16030b;

    /* JADX INFO: renamed from: c */
    private final DurationField f16031c;

    /* JADX INFO: renamed from: a */
    public static synchronized UnsupportedDateTimeField m16762a(DateTimeFieldType dateTimeFieldType, DurationField durationField) {
        UnsupportedDateTimeField unsupportedDateTimeField;
        if (f16029a == null) {
            f16029a = new HashMap<>(7);
            unsupportedDateTimeField = null;
        } else {
            unsupportedDateTimeField = f16029a.get(dateTimeFieldType);
            if (unsupportedDateTimeField != null && unsupportedDateTimeField.mo16453d() != durationField) {
                unsupportedDateTimeField = null;
            }
        }
        if (unsupportedDateTimeField == null) {
            unsupportedDateTimeField = new UnsupportedDateTimeField(dateTimeFieldType, durationField);
            f16029a.put(dateTimeFieldType, unsupportedDateTimeField);
        }
        return unsupportedDateTimeField;
    }

    private UnsupportedDateTimeField(DateTimeFieldType dateTimeFieldType, DurationField durationField) {
        if (dateTimeFieldType == null || durationField == null) {
            throw new IllegalArgumentException();
        }
        this.f16030b = dateTimeFieldType;
        this.f16031c = durationField;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public DateTimeFieldType mo16442a() {
        return this.f16030b;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public String mo16444b() {
        return this.f16030b.m16510x();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: c */
    public boolean mo16451c() {
        return false;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16434a(long j) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public String mo16440a(long j, Locale locale) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public String mo16441a(ReadablePartial readablePartial, Locale locale) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public String mo16439a(int i, Locale locale) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public String mo16446b(long j, Locale locale) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public String mo16447b(ReadablePartial readablePartial, Locale locale) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public String mo16445b(int i, Locale locale) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16436a(long j, int i) {
        return mo16453d().mo16555a(j, i);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16437a(long j, long j2) {
        return mo16453d().mo16556a(j, j2);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public long mo16443b(long j, int i) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16438a(long j, String str, Locale locale) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public DurationField mo16453d() {
        return this.f16031c;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public DurationField mo16455e() {
        return null;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public boolean mo16448b(long j) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: f */
    public DurationField mo16457f() {
        return null;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public int mo16458g() {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public int mo16460h() {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: c */
    public int mo16449c(long j) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16435a(Locale locale) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public long mo16452d(long j) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public long mo16454e(long j) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: f */
    public long mo16456f(long j) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public long mo16459g(long j) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public long mo16461h(long j) {
        throw m16763i();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: i */
    public long mo16462i(long j) {
        throw m16763i();
    }

    public String toString() {
        return "UnsupportedDateTimeField";
    }

    private Object readResolve() {
        return m16762a(this.f16030b, this.f16031c);
    }

    /* JADX INFO: renamed from: i */
    private UnsupportedOperationException m16763i() {
        return new UnsupportedOperationException(this.f16030b + " field is unsupported");
    }
}
