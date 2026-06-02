package org.joda.time.field;

import org.joda.time.Chronology;
import org.joda.time.DateTimeField;

/* JADX INFO: loaded from: classes2.dex */
public final class SkipUndoDateTimeField extends DelegatedDateTimeField {

    /* JADX INFO: renamed from: a */
    private final Chronology f16026a;

    /* JADX INFO: renamed from: b */
    private final int f16027b;

    /* JADX INFO: renamed from: c */
    private transient int f16028c;

    public SkipUndoDateTimeField(Chronology chronology, DateTimeField dateTimeField) {
        this(chronology, dateTimeField, 0);
    }

    public SkipUndoDateTimeField(Chronology chronology, DateTimeField dateTimeField, int i) {
        super(dateTimeField);
        this.f16026a = chronology;
        int iMo16458g = super.mo16458g();
        if (iMo16458g < i) {
            this.f16028c = iMo16458g + 1;
        } else if (iMo16458g == i + 1) {
            this.f16028c = i;
        } else {
            this.f16028c = iMo16458g;
        }
        this.f16027b = i;
    }

    @Override // org.joda.time.field.DelegatedDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16434a(long j) {
        int iMo16434a = super.mo16434a(j);
        if (iMo16434a < this.f16027b) {
            return iMo16434a + 1;
        }
        return iMo16434a;
    }

    @Override // org.joda.time.field.DelegatedDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public long mo16443b(long j, int i) {
        FieldUtils.m16755a(this, i, this.f16028c, mo16460h());
        if (i <= this.f16027b) {
            i--;
        }
        return super.mo16443b(j, i);
    }

    @Override // org.joda.time.field.DelegatedDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public int mo16458g() {
        return this.f16028c;
    }

    private Object readResolve() {
        return mo16442a().mo16509a(this.f16026a);
    }
}
