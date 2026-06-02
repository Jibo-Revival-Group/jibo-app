package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DecoratedDateTimeField extends BaseDateTimeField {

    /* JADX INFO: renamed from: a */
    private final DateTimeField f15997a;

    protected DecoratedDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType) {
        super(dateTimeFieldType);
        if (dateTimeField == null) {
            throw new IllegalArgumentException("The field must not be null");
        }
        if (!dateTimeField.mo16451c()) {
            throw new IllegalArgumentException("The field must be supported");
        }
        this.f15997a = dateTimeField;
    }

    /* JADX INFO: renamed from: i */
    public final DateTimeField m16748i() {
        return this.f15997a;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16434a(long j) {
        return this.f15997a.mo16434a(j);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public long mo16443b(long j, int i) {
        return this.f15997a.mo16443b(j, i);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public DurationField mo16453d() {
        return this.f15997a.mo16453d();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public DurationField mo16455e() {
        return this.f15997a.mo16455e();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public int mo16458g() {
        return this.f15997a.mo16458g();
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public int mo16460h() {
        return this.f15997a.mo16460h();
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public long mo16452d(long j) {
        return this.f15997a.mo16452d(j);
    }
}
