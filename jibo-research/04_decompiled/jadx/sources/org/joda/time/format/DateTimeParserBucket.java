package org.joda.time.format;

import java.util.Arrays;
import java.util.Locale;
import org.apache.http.message.TokenParser;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;

/* JADX INFO: loaded from: classes2.dex */
public class DateTimeParserBucket {

    /* JADX INFO: renamed from: a */
    private final Chronology f16074a;

    /* JADX INFO: renamed from: b */
    private final long f16075b;

    /* JADX INFO: renamed from: c */
    private final Locale f16076c;

    /* JADX INFO: renamed from: d */
    private final int f16077d;

    /* JADX INFO: renamed from: e */
    private final DateTimeZone f16078e;

    /* JADX INFO: renamed from: f */
    private final Integer f16079f;

    /* JADX INFO: renamed from: g */
    private DateTimeZone f16080g;

    /* JADX INFO: renamed from: h */
    private Integer f16081h;

    /* JADX INFO: renamed from: i */
    private Integer f16082i;

    /* JADX INFO: renamed from: j */
    private SavedField[] f16083j;

    /* JADX INFO: renamed from: k */
    private int f16084k;

    /* JADX INFO: renamed from: l */
    private boolean f16085l;

    /* JADX INFO: renamed from: m */
    private Object f16086m;

    public DateTimeParserBucket(long j, Chronology chronology, Locale locale, Integer num, int i) {
        Chronology chronologyM16516a = DateTimeUtils.m16516a(chronology);
        this.f16075b = j;
        this.f16078e = chronologyM16516a.mo16407a();
        this.f16074a = chronologyM16516a.mo16408b();
        this.f16076c = locale == null ? Locale.getDefault() : locale;
        this.f16077d = i;
        this.f16079f = num;
        this.f16080g = this.f16078e;
        this.f16082i = this.f16079f;
        this.f16083j = new SavedField[8];
    }

    /* JADX INFO: renamed from: a */
    long m16872a(InternalParser internalParser, CharSequence charSequence) {
        int into = internalParser.parseInto(this, charSequence, 0);
        if (into >= 0) {
            if (into >= charSequence.length()) {
                return m16873a(true, charSequence);
            }
        } else {
            into ^= -1;
        }
        throw new IllegalArgumentException(FormatUtils.m16900a(charSequence.toString(), into));
    }

    /* JADX INFO: renamed from: a */
    public Chronology m16875a() {
        return this.f16074a;
    }

    /* JADX INFO: renamed from: b */
    public Locale m16882b() {
        return this.f16076c;
    }

    /* JADX INFO: renamed from: c */
    public DateTimeZone m16883c() {
        return this.f16080g;
    }

    /* JADX INFO: renamed from: a */
    public void m16880a(DateTimeZone dateTimeZone) {
        this.f16086m = null;
        this.f16080g = dateTimeZone;
    }

    /* JADX INFO: renamed from: d */
    public Integer m16884d() {
        return this.f16081h;
    }

    /* JADX INFO: renamed from: a */
    public void m16876a(Integer num) {
        this.f16086m = null;
        this.f16081h = num;
    }

    /* JADX INFO: renamed from: e */
    public Integer m16885e() {
        return this.f16082i;
    }

    /* JADX INFO: renamed from: a */
    public void m16877a(DateTimeField dateTimeField, int i) {
        m16871g().m16889a(dateTimeField, i);
    }

    /* JADX INFO: renamed from: a */
    public void m16878a(DateTimeFieldType dateTimeFieldType, int i) {
        m16871g().m16889a(dateTimeFieldType.mo16509a(this.f16074a), i);
    }

    /* JADX INFO: renamed from: a */
    public void m16879a(DateTimeFieldType dateTimeFieldType, String str, Locale locale) {
        m16871g().m16890a(dateTimeFieldType.mo16509a(this.f16074a), str, locale);
    }

    /* JADX INFO: renamed from: g */
    private SavedField m16871g() {
        SavedField[] savedFieldArr;
        SavedField savedField;
        SavedField[] savedFieldArr2 = this.f16083j;
        int i = this.f16084k;
        if (i == savedFieldArr2.length || this.f16085l) {
            savedFieldArr = new SavedField[i == savedFieldArr2.length ? i * 2 : savedFieldArr2.length];
            System.arraycopy(savedFieldArr2, 0, savedFieldArr, 0, i);
            this.f16083j = savedFieldArr;
            this.f16085l = false;
        } else {
            savedFieldArr = savedFieldArr2;
        }
        this.f16086m = null;
        SavedField savedField2 = savedFieldArr[i];
        if (savedField2 == null) {
            SavedField savedField3 = new SavedField();
            savedFieldArr[i] = savedField3;
            savedField = savedField3;
        } else {
            savedField = savedField2;
        }
        this.f16084k = i + 1;
        return savedField;
    }

    /* JADX INFO: renamed from: f */
    public Object m16886f() {
        if (this.f16086m == null) {
            this.f16086m = new SavedState();
        }
        return this.f16086m;
    }

    /* JADX INFO: renamed from: a */
    public boolean m16881a(Object obj) {
        if (!(obj instanceof SavedState) || !((SavedState) obj).m16891a(this)) {
            return false;
        }
        this.f16086m = obj;
        return true;
    }

    /* JADX INFO: renamed from: a */
    public long m16874a(boolean z, String str) {
        return m16873a(z, (CharSequence) str);
    }

    /* JADX INFO: renamed from: a */
    public long m16873a(boolean z, CharSequence charSequence) {
        SavedField[] savedFieldArr = this.f16083j;
        int i = this.f16084k;
        if (this.f16085l) {
            savedFieldArr = (SavedField[]) this.f16083j.clone();
            this.f16083j = savedFieldArr;
            this.f16085l = false;
        }
        m16865a(savedFieldArr, i);
        if (i > 0) {
            DurationField durationFieldMo16573a = DurationFieldType.m16569i().mo16573a(this.f16074a);
            DurationField durationFieldMo16573a2 = DurationFieldType.m16566f().mo16573a(this.f16074a);
            DurationField durationFieldMo16453d = savedFieldArr[0].f16087a.mo16453d();
            if (m16860a(durationFieldMo16453d, durationFieldMo16573a) >= 0 && m16860a(durationFieldMo16453d, durationFieldMo16573a2) <= 0) {
                m16878a(DateTimeFieldType.m16504s(), this.f16077d);
                return m16873a(z, charSequence);
            }
        }
        long jM16888a = this.f16075b;
        for (int i2 = 0; i2 < i; i2++) {
            try {
                jM16888a = savedFieldArr[i2].m16888a(jM16888a, z);
            } catch (IllegalFieldValueException e) {
                if (charSequence != null) {
                    e.m16577a("Cannot parse \"" + ((Object) charSequence) + TokenParser.DQUOTE);
                }
                throw e;
            }
        }
        if (z) {
            int i3 = 0;
            while (i3 < i) {
                jM16888a = savedFieldArr[i3].m16888a(jM16888a, i3 == i + (-1));
                i3++;
            }
        }
        long j = jM16888a;
        if (this.f16081h != null) {
            return j - ((long) this.f16081h.intValue());
        }
        if (this.f16080g != null) {
            int iMo16547e = this.f16080g.mo16547e(j);
            long j2 = j - ((long) iMo16547e);
            if (iMo16547e != this.f16080g.mo16543b(j2)) {
                String str = "Illegal instant due to time zone offset transition (" + this.f16080g + ')';
                if (charSequence != null) {
                    str = "Cannot parse \"" + ((Object) charSequence) + "\": " + str;
                }
                throw new IllegalInstantException(str);
            }
            return j2;
        }
        return j;
    }

    /* JADX INFO: renamed from: a */
    private static void m16865a(SavedField[] savedFieldArr, int i) {
        if (i > 10) {
            Arrays.sort(savedFieldArr, 0, i);
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = i2; i3 > 0 && savedFieldArr[i3 - 1].compareTo(savedFieldArr[i3]) > 0; i3--) {
                SavedField savedField = savedFieldArr[i3];
                savedFieldArr[i3] = savedFieldArr[i3 - 1];
                savedFieldArr[i3 - 1] = savedField;
            }
        }
    }

    class SavedState {

        /* JADX INFO: renamed from: a */
        final DateTimeZone f16091a;

        /* JADX INFO: renamed from: b */
        final Integer f16092b;

        /* JADX INFO: renamed from: c */
        final SavedField[] f16093c;

        /* JADX INFO: renamed from: d */
        final int f16094d;

        SavedState() {
            this.f16091a = DateTimeParserBucket.this.f16080g;
            this.f16092b = DateTimeParserBucket.this.f16081h;
            this.f16093c = DateTimeParserBucket.this.f16083j;
            this.f16094d = DateTimeParserBucket.this.f16084k;
        }

        /* JADX INFO: renamed from: a */
        boolean m16891a(DateTimeParserBucket dateTimeParserBucket) {
            if (dateTimeParserBucket == DateTimeParserBucket.this) {
                dateTimeParserBucket.f16080g = this.f16091a;
                dateTimeParserBucket.f16081h = this.f16092b;
                dateTimeParserBucket.f16083j = this.f16093c;
                if (this.f16094d < dateTimeParserBucket.f16084k) {
                    dateTimeParserBucket.f16085l = true;
                }
                dateTimeParserBucket.f16084k = this.f16094d;
                return true;
            }
            return false;
        }
    }

    static class SavedField implements Comparable<SavedField> {

        /* JADX INFO: renamed from: a */
        DateTimeField f16087a;

        /* JADX INFO: renamed from: b */
        int f16088b;

        /* JADX INFO: renamed from: c */
        String f16089c;

        /* JADX INFO: renamed from: d */
        Locale f16090d;

        SavedField() {
        }

        /* JADX INFO: renamed from: a */
        void m16889a(DateTimeField dateTimeField, int i) {
            this.f16087a = dateTimeField;
            this.f16088b = i;
            this.f16089c = null;
            this.f16090d = null;
        }

        /* JADX INFO: renamed from: a */
        void m16890a(DateTimeField dateTimeField, String str, Locale locale) {
            this.f16087a = dateTimeField;
            this.f16088b = 0;
            this.f16089c = str;
            this.f16090d = locale;
        }

        /* JADX INFO: renamed from: a */
        long m16888a(long j, boolean z) {
            long jMo16438a;
            if (this.f16089c == null) {
                jMo16438a = this.f16087a.mo16450c(j, this.f16088b);
            } else {
                jMo16438a = this.f16087a.mo16438a(j, this.f16089c, this.f16090d);
            }
            if (z) {
                return this.f16087a.mo16452d(jMo16438a);
            }
            return jMo16438a;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(SavedField savedField) {
            DateTimeField dateTimeField = savedField.f16087a;
            int iM16860a = DateTimeParserBucket.m16860a(this.f16087a.mo16455e(), dateTimeField.mo16455e());
            return iM16860a != 0 ? iM16860a : DateTimeParserBucket.m16860a(this.f16087a.mo16453d(), dateTimeField.mo16453d());
        }
    }

    /* JADX INFO: renamed from: a */
    static int m16860a(DurationField durationField, DurationField durationField2) {
        if (durationField == null || !durationField.mo16558b()) {
            if (durationField2 == null || !durationField2.mo16558b()) {
                return 0;
            }
            return -1;
        }
        if (durationField2 == null || !durationField2.mo16558b()) {
            return 1;
        }
        return -durationField.compareTo(durationField2);
    }
}
