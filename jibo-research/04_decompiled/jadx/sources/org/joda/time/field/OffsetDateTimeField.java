package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

/* JADX INFO: loaded from: classes2.dex */
public class OffsetDateTimeField extends DecoratedDateTimeField {

    /* JADX INFO: renamed from: a */
    private final int f16011a;

    /* JADX INFO: renamed from: b */
    private final int f16012b;

    /* JADX INFO: renamed from: c */
    private final int f16013c;

    public OffsetDateTimeField(DateTimeField dateTimeField, int i) {
        this(dateTimeField, dateTimeField == null ? null : dateTimeField.mo16442a(), i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public OffsetDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType, int i) {
        this(dateTimeField, dateTimeFieldType, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public OffsetDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType, int i, int i2, int i3) {
        super(dateTimeField, dateTimeFieldType);
        if (i == 0) {
            throw new IllegalArgumentException("The offset cannot be zero");
        }
        this.f16011a = i;
        if (i2 < dateTimeField.mo16458g() + i) {
            this.f16012b = dateTimeField.mo16458g() + i;
        } else {
            this.f16012b = i2;
        }
        if (i3 > dateTimeField.mo16460h() + i) {
            this.f16013c = dateTimeField.mo16460h() + i;
        } else {
            this.f16013c = i3;
        }
    }

    @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16434a(long j) {
        return super.mo16434a(j) + this.f16011a;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16436a(long j, int i) {
        long jA = super.mo16436a(j, i);
        FieldUtils.m16755a(this, mo16434a(jA), this.f16012b, this.f16013c);
        return jA;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16437a(long j, long j2) {
        long jA = super.mo16437a(j, j2);
        FieldUtils.m16755a(this, mo16434a(jA), this.f16012b, this.f16013c);
        return jA;
    }

    @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public long mo16443b(long j, int i) {
        FieldUtils.m16755a(this, i, this.f16012b, this.f16013c);
        return super.mo16443b(j, i - this.f16011a);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public boolean mo16448b(long j) {
        return m16748i().mo16448b(j);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: f */
    public DurationField mo16457f() {
        return m16748i().mo16457f();
    }

    @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public int mo16458g() {
        return this.f16012b;
    }

    @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public int mo16460h() {
        return this.f16013c;
    }

    @Override // org.joda.time.field.DecoratedDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public long mo16452d(long j) {
        return m16748i().mo16452d(j);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public long mo16454e(long j) {
        return m16748i().mo16454e(j);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: f */
    public long mo16456f(long j) {
        return m16748i().mo16456f(j);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public long mo16459g(long j) {
        return m16748i().mo16459g(j);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public long mo16461h(long j) {
        return m16748i().mo16461h(j);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: i */
    public long mo16462i(long j) {
        return m16748i().mo16462i(j);
    }
}
