package org.joda.time.field;

import java.io.Serializable;
import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;

/* JADX INFO: loaded from: classes2.dex */
public class DelegatedDateTimeField extends DateTimeField implements Serializable {

    /* JADX INFO: renamed from: a */
    private final DateTimeField f15999a;

    /* JADX INFO: renamed from: b */
    private final DurationField f16000b;

    /* JADX INFO: renamed from: c */
    private final DateTimeFieldType f16001c;

    public DelegatedDateTimeField(DateTimeField dateTimeField) {
        this(dateTimeField, null);
    }

    public DelegatedDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType) {
        this(dateTimeField, null, dateTimeFieldType);
    }

    public DelegatedDateTimeField(DateTimeField dateTimeField, DurationField durationField, DateTimeFieldType dateTimeFieldType) {
        if (dateTimeField == null) {
            throw new IllegalArgumentException("The field must not be null");
        }
        this.f15999a = dateTimeField;
        this.f16000b = durationField;
        this.f16001c = dateTimeFieldType == null ? dateTimeField.mo16442a() : dateTimeFieldType;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public DateTimeFieldType mo16442a() {
        return this.f16001c;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public String mo16444b() {
        return this.f16001c.m16510x();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: c */
    public boolean mo16451c() {
        return this.f15999a.mo16451c();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16434a(long j) {
        return this.f15999a.mo16434a(j);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public String mo16440a(long j, Locale locale) {
        return this.f15999a.mo16440a(j, locale);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public String mo16441a(ReadablePartial readablePartial, Locale locale) {
        return this.f15999a.mo16441a(readablePartial, locale);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public String mo16439a(int i, Locale locale) {
        return this.f15999a.mo16439a(i, locale);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public String mo16446b(long j, Locale locale) {
        return this.f15999a.mo16446b(j, locale);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public String mo16447b(ReadablePartial readablePartial, Locale locale) {
        return this.f15999a.mo16447b(readablePartial, locale);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public String mo16445b(int i, Locale locale) {
        return this.f15999a.mo16445b(i, locale);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16436a(long j, int i) {
        return this.f15999a.mo16436a(j, i);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16437a(long j, long j2) {
        return this.f15999a.mo16437a(j, j2);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public long mo16443b(long j, int i) {
        return this.f15999a.mo16443b(j, i);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16438a(long j, String str, Locale locale) {
        return this.f15999a.mo16438a(j, str, locale);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public DurationField mo16453d() {
        return this.f15999a.mo16453d();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public DurationField mo16455e() {
        return this.f16000b != null ? this.f16000b : this.f15999a.mo16455e();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public boolean mo16448b(long j) {
        return this.f15999a.mo16448b(j);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: f */
    public DurationField mo16457f() {
        return this.f15999a.mo16457f();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public int mo16458g() {
        return this.f15999a.mo16458g();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public int mo16460h() {
        return this.f15999a.mo16460h();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: c */
    public int mo16449c(long j) {
        return this.f15999a.mo16449c(j);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16435a(Locale locale) {
        return this.f15999a.mo16435a(locale);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public long mo16452d(long j) {
        return this.f15999a.mo16452d(j);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public long mo16454e(long j) {
        return this.f15999a.mo16454e(j);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: f */
    public long mo16456f(long j) {
        return this.f15999a.mo16456f(j);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public long mo16459g(long j) {
        return this.f15999a.mo16459g(j);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public long mo16461h(long j) {
        return this.f15999a.mo16461h(j);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: i */
    public long mo16462i(long j) {
        return this.f15999a.mo16462i(j);
    }

    public String toString() {
        return "DateTimeField[" + mo16444b() + ']';
    }
}
