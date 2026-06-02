package org.joda.time.field;

import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.ReadablePartial;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseDateTimeField extends DateTimeField {

    /* JADX INFO: renamed from: a */
    private final DateTimeFieldType f15995a;

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public abstract int mo16434a(long j);

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public abstract long mo16443b(long j, int i);

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public abstract long mo16452d(long j);

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public abstract DurationField mo16453d();

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public abstract int mo16460h();

    protected BaseDateTimeField(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The type must not be null");
        }
        this.f15995a = dateTimeFieldType;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public final DateTimeFieldType mo16442a() {
        return this.f15995a;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public final String mo16444b() {
        return this.f15995a.m16510x();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: c */
    public final boolean mo16451c() {
        return true;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public String mo16440a(long j, Locale locale) {
        return mo16439a(mo16434a(j), locale);
    }

    /* JADX INFO: renamed from: a */
    public String m16744a(ReadablePartial readablePartial, int i, Locale locale) {
        return mo16439a(i, locale);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public final String mo16441a(ReadablePartial readablePartial, Locale locale) {
        return m16744a(readablePartial, readablePartial.mo16585a(mo16442a()), locale);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public String mo16439a(int i, Locale locale) {
        return Integer.toString(i);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public String mo16446b(long j, Locale locale) {
        return mo16445b(mo16434a(j), locale);
    }

    /* JADX INFO: renamed from: b */
    public String m16745b(ReadablePartial readablePartial, int i, Locale locale) {
        return mo16445b(i, locale);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public final String mo16447b(ReadablePartial readablePartial, Locale locale) {
        return m16745b(readablePartial, readablePartial.mo16585a(mo16442a()), locale);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public String mo16445b(int i, Locale locale) {
        return mo16439a(i, locale);
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
    /* JADX INFO: renamed from: a */
    public long mo16438a(long j, String str, Locale locale) {
        return mo16443b(j, mo16682a(str, locale));
    }

    /* JADX INFO: renamed from: a */
    protected int mo16682a(String str, Locale locale) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalFieldValueException(mo16442a(), str);
        }
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public boolean mo16448b(long j) {
        return false;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: f */
    public DurationField mo16457f() {
        return null;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: c */
    public int mo16449c(long j) {
        return mo16460h();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16435a(Locale locale) {
        int iMo16460h = mo16460h();
        if (iMo16460h >= 0) {
            if (iMo16460h < 10) {
                return 1;
            }
            if (iMo16460h < 100) {
                return 2;
            }
            if (iMo16460h < 1000) {
                return 3;
            }
        }
        return Integer.toString(iMo16460h).length();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public long mo16454e(long j) {
        long jMo16452d = mo16452d(j);
        if (jMo16452d != j) {
            return mo16436a(jMo16452d, 1);
        }
        return j;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: f */
    public long mo16456f(long j) {
        long jMo16452d = mo16452d(j);
        long jMo16454e = mo16454e(j);
        return j - jMo16452d <= jMo16454e - j ? jMo16452d : jMo16454e;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public long mo16459g(long j) {
        long jMo16452d = mo16452d(j);
        long jMo16454e = mo16454e(j);
        return jMo16454e - j <= j - jMo16452d ? jMo16454e : jMo16452d;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public long mo16461h(long j) {
        long jMo16452d = mo16452d(j);
        long jMo16454e = mo16454e(j);
        long j2 = j - jMo16452d;
        long j3 = jMo16454e - j;
        if (j2 < j3) {
            return jMo16452d;
        }
        return (j3 >= j2 && (mo16434a(jMo16454e) & 1) != 0) ? jMo16452d : jMo16454e;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: i */
    public long mo16462i(long j) {
        return j - mo16452d(j);
    }

    public String toString() {
        return "DateTimeField[" + mo16444b() + ']';
    }
}
