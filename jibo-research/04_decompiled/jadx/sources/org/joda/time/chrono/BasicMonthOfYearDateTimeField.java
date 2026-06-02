package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.ImpreciseDateTimeField;

/* JADX INFO: loaded from: classes2.dex */
class BasicMonthOfYearDateTimeField extends ImpreciseDateTimeField {

    /* JADX INFO: renamed from: a */
    private final BasicChronology f15900a;

    /* JADX INFO: renamed from: c */
    private final int f15901c;

    /* JADX INFO: renamed from: d */
    private final int f15902d;

    BasicMonthOfYearDateTimeField(BasicChronology basicChronology, int i) {
        super(DateTimeFieldType.m16503r(), basicChronology.mo16634V());
        this.f15900a = basicChronology;
        this.f15901c = this.f15900a.m16631S();
        this.f15902d = i;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16434a(long j) {
        return this.f15900a.m16644b(j);
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16436a(long j, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (i != 0) {
            long jM16662h = this.f15900a.m16662h(j);
            int iM16637a = this.f15900a.m16637a(j);
            int iMo16638a = this.f15900a.mo16638a(j, iM16637a);
            int i7 = (iMo16638a - 1) + i;
            if (iMo16638a <= 0 || i7 >= 0) {
                i2 = iM16637a;
            } else {
                if (Math.signum(this.f15901c + i) == Math.signum(i)) {
                    i5 = iM16637a - 1;
                    i6 = this.f15901c + i;
                } else {
                    i5 = iM16637a + 1;
                    i6 = i - this.f15901c;
                }
                int i8 = i6 + (iMo16638a - 1);
                i2 = i5;
                i7 = i8;
            }
            if (i7 >= 0) {
                i3 = i2 + (i7 / this.f15901c);
                i4 = (i7 % this.f15901c) + 1;
            } else {
                i3 = (i2 + (i7 / this.f15901c)) - 1;
                int iAbs = Math.abs(i7) % this.f15901c;
                if (iAbs == 0) {
                    iAbs = this.f15901c;
                }
                i4 = (this.f15901c - iAbs) + 1;
                if (i4 == 1) {
                    i3++;
                }
            }
            int iM16639a = this.f15900a.m16639a(j, iM16637a, iMo16638a);
            int iMo16643b = this.f15900a.mo16643b(i3, i4);
            if (iM16639a <= iMo16643b) {
                iMo16643b = iM16639a;
            }
            return this.f15900a.m16641a(i3, i4, iMo16643b) + jM16662h;
        }
        return j;
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16437a(long j, long j2) {
        long j3;
        long j4;
        int i = (int) j2;
        if (i == j2) {
            return mo16436a(j, i);
        }
        long jM16662h = this.f15900a.m16662h(j);
        int iM16637a = this.f15900a.m16637a(j);
        int iMo16638a = this.f15900a.mo16638a(j, iM16637a);
        long j5 = ((long) (iMo16638a - 1)) + j2;
        if (j5 >= 0) {
            j3 = ((long) iM16637a) + (j5 / ((long) this.f15901c));
            j4 = (j5 % ((long) this.f15901c)) + 1;
        } else {
            long j6 = (((long) iM16637a) + (j5 / ((long) this.f15901c))) - 1;
            int iAbs = (int) (Math.abs(j5) % ((long) this.f15901c));
            if (iAbs == 0) {
                iAbs = this.f15901c;
            }
            long j7 = (this.f15901c - iAbs) + 1;
            if (j7 == 1) {
                j3 = 1 + j6;
                j4 = j7;
            } else {
                j3 = j6;
                j4 = j7;
            }
        }
        if (j3 < this.f15900a.mo16629Q() || j3 > this.f15900a.mo16630R()) {
            throw new IllegalArgumentException("Magnitude of add amount is too large: " + j2);
        }
        int i2 = (int) j3;
        int i3 = (int) j4;
        int iM16639a = this.f15900a.m16639a(j, iM16637a, iMo16638a);
        int iMo16643b = this.f15900a.mo16643b(i2, i3);
        if (iM16639a <= iMo16643b) {
            iMo16643b = iM16639a;
        }
        return this.f15900a.m16641a(i2, i3, iMo16643b) + jM16662h;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public long mo16443b(long j, int i) {
        FieldUtils.m16755a(this, i, 1, this.f15901c);
        int iM16637a = this.f15900a.m16637a(j);
        int iM16645b = this.f15900a.m16645b(j, iM16637a);
        int iMo16643b = this.f15900a.mo16643b(iM16637a, i);
        if (iM16645b <= iMo16643b) {
            iMo16643b = iM16645b;
        }
        return this.f15900a.m16641a(iM16637a, i, iMo16643b) + ((long) this.f15900a.m16662h(j));
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public DurationField mo16455e() {
        return this.f15900a.mo16394D();
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public boolean mo16448b(long j) {
        int iM16637a = this.f15900a.m16637a(j);
        return this.f15900a.mo16656e(iM16637a) && this.f15900a.mo16638a(j, iM16637a) == this.f15902d;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: f */
    public DurationField mo16457f() {
        return this.f15900a.mo16425s();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public int mo16458g() {
        return 1;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public int mo16460h() {
        return this.f15901c;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public long mo16452d(long j) {
        int iM16637a = this.f15900a.m16637a(j);
        return this.f15900a.m16640a(iM16637a, this.f15900a.mo16638a(j, iM16637a));
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: i */
    public long mo16462i(long j) {
        return j - mo16452d(j);
    }
}
