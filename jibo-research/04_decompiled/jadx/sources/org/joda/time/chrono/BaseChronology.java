package org.joda.time.chrono;

import java.io.Serializable;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.ReadablePartial;
import org.joda.time.field.UnsupportedDateTimeField;
import org.joda.time.field.UnsupportedDurationField;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseChronology extends Chronology implements Serializable {
    protected BaseChronology() {
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16402a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        return mo16411e().mo16443b(mo16427u().mo16443b(mo16393C().mo16443b(mo16395E().mo16443b(0L, i), i2), i3), i4);
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16403a(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        return mo16410d().mo16443b(mo16413g().mo16443b(mo16416j().mo16443b(mo16419m().mo16443b(mo16427u().mo16443b(mo16393C().mo16443b(mo16395E().mo16443b(0L, i), i2), i3), i4), i5), i6), i7);
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16404a(long j, int i, int i2, int i3, int i4) throws IllegalArgumentException {
        return mo16410d().mo16443b(mo16413g().mo16443b(mo16416j().mo16443b(mo16419m().mo16443b(j, i), i2), i3), i4);
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16405a(ReadablePartial readablePartial, long j) {
        int iMo16583a = readablePartial.mo16583a();
        for (int i = 0; i < iMo16583a; i++) {
            j = readablePartial.mo16604b(i).mo16509a(this).mo16443b(j, readablePartial.mo16584a(i));
        }
        return j;
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: c */
    public DurationField mo16409c() {
        return UnsupportedDurationField.m16764a(DurationFieldType.m16561a());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: d */
    public DateTimeField mo16410d() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16486a(), mo16409c());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: e */
    public DateTimeField mo16411e() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16487b(), mo16409c());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: f */
    public DurationField mo16412f() {
        return UnsupportedDurationField.m16764a(DurationFieldType.m16562b());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: g */
    public DateTimeField mo16413g() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16488c(), mo16412f());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: h */
    public DateTimeField mo16414h() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16489d(), mo16412f());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: i */
    public DurationField mo16415i() {
        return UnsupportedDurationField.m16764a(DurationFieldType.m16563c());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: j */
    public DateTimeField mo16416j() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16490e(), mo16415i());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: k */
    public DateTimeField mo16417k() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16491f(), mo16415i());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: l */
    public DurationField mo16418l() {
        return UnsupportedDurationField.m16764a(DurationFieldType.m16564d());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: m */
    public DateTimeField mo16419m() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16492g(), mo16418l());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: n */
    public DateTimeField mo16420n() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16493h(), mo16418l());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: o */
    public DurationField mo16421o() {
        return UnsupportedDurationField.m16764a(DurationFieldType.m16565e());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: p */
    public DateTimeField mo16422p() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16494i(), mo16418l());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: q */
    public DateTimeField mo16423q() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16495j(), mo16418l());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: r */
    public DateTimeField mo16424r() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16496k(), mo16421o());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: s */
    public DurationField mo16425s() {
        return UnsupportedDurationField.m16764a(DurationFieldType.m16566f());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: t */
    public DateTimeField mo16426t() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16497l(), mo16425s());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: u */
    public DateTimeField mo16427u() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16498m(), mo16425s());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: v */
    public DateTimeField mo16428v() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16499n(), mo16425s());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: w */
    public DurationField mo16429w() {
        return UnsupportedDurationField.m16764a(DurationFieldType.m16567g());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: x */
    public DateTimeField mo16430x() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16500o(), mo16429w());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: y */
    public DurationField mo16431y() {
        return UnsupportedDurationField.m16764a(DurationFieldType.m16568h());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: z */
    public DateTimeField mo16432z() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16501p(), mo16431y());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: A */
    public DateTimeField mo16391A() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16502q(), mo16431y());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: B */
    public DurationField mo16392B() {
        return UnsupportedDurationField.m16764a(DurationFieldType.m16569i());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: C */
    public DateTimeField mo16393C() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16503r(), mo16392B());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: D */
    public DurationField mo16394D() {
        return UnsupportedDurationField.m16764a(DurationFieldType.m16570j());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: E */
    public DateTimeField mo16395E() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16504s(), mo16394D());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: F */
    public DateTimeField mo16396F() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16505t(), mo16394D());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: G */
    public DateTimeField mo16397G() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16506u(), mo16394D());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: H */
    public DurationField mo16398H() {
        return UnsupportedDurationField.m16764a(DurationFieldType.m16571k());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: I */
    public DateTimeField mo16399I() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16507v(), mo16398H());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: J */
    public DurationField mo16400J() {
        return UnsupportedDurationField.m16764a(DurationFieldType.m16572l());
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: K */
    public DateTimeField mo16401K() {
        return UnsupportedDateTimeField.m16762a(DateTimeFieldType.m16508w(), mo16400J());
    }
}
