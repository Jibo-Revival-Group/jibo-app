package org.joda.time.format;

import java.io.IOException;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;

/* JADX INFO: loaded from: classes2.dex */
public class DateTimeFormatter {

    /* JADX INFO: renamed from: a */
    private final InternalPrinter f16036a;

    /* JADX INFO: renamed from: b */
    private final InternalParser f16037b;

    /* JADX INFO: renamed from: c */
    private final Locale f16038c;

    /* JADX INFO: renamed from: d */
    private final boolean f16039d;

    /* JADX INFO: renamed from: e */
    private final Chronology f16040e;

    /* JADX INFO: renamed from: f */
    private final DateTimeZone f16041f;

    /* JADX INFO: renamed from: g */
    private final Integer f16042g;

    /* JADX INFO: renamed from: h */
    private final int f16043h;

    DateTimeFormatter(InternalPrinter internalPrinter, InternalParser internalParser) {
        this.f16036a = internalPrinter;
        this.f16037b = internalParser;
        this.f16038c = null;
        this.f16039d = false;
        this.f16040e = null;
        this.f16041f = null;
        this.f16042g = null;
        this.f16043h = 2000;
    }

    private DateTimeFormatter(InternalPrinter internalPrinter, InternalParser internalParser, Locale locale, boolean z, Chronology chronology, DateTimeZone dateTimeZone, Integer num, int i) {
        this.f16036a = internalPrinter;
        this.f16037b = internalParser;
        this.f16038c = locale;
        this.f16039d = z;
        this.f16040e = chronology;
        this.f16041f = dateTimeZone;
        this.f16042g = num;
        this.f16043h = i;
    }

    /* JADX INFO: renamed from: a */
    InternalPrinter m16782a() {
        return this.f16036a;
    }

    /* JADX INFO: renamed from: b */
    public DateTimeParser m16788b() {
        return InternalParserDateTimeParser.m16976a(this.f16037b);
    }

    /* JADX INFO: renamed from: c */
    InternalParser m16790c() {
        return this.f16037b;
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatter m16780a(Chronology chronology) {
        return this.f16040e == chronology ? this : new DateTimeFormatter(this.f16036a, this.f16037b, this.f16038c, this.f16039d, chronology, this.f16041f, this.f16042g, this.f16043h);
    }

    /* JADX INFO: renamed from: d */
    public DateTimeFormatter m16791d() {
        return m16781a(DateTimeZone.f15751a);
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatter m16781a(DateTimeZone dateTimeZone) {
        return this.f16041f == dateTimeZone ? this : new DateTimeFormatter(this.f16036a, this.f16037b, this.f16038c, false, this.f16040e, dateTimeZone, this.f16042g, this.f16043h);
    }

    /* JADX INFO: renamed from: a */
    public void m16784a(Appendable appendable, ReadableInstant readableInstant) throws IOException {
        m16773a(appendable, DateTimeUtils.m16514a(readableInstant), DateTimeUtils.m16520b(readableInstant));
    }

    /* JADX INFO: renamed from: a */
    public void m16786a(StringBuffer stringBuffer, long j) {
        try {
            m16783a((Appendable) stringBuffer, j);
        } catch (IOException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    public void m16783a(Appendable appendable, long j) throws IOException {
        m16773a(appendable, j, null);
    }

    /* JADX INFO: renamed from: a */
    public void m16785a(Appendable appendable, ReadablePartial readablePartial) throws IOException {
        InternalPrinter internalPrinterM16775e = m16775e();
        if (readablePartial == null) {
            throw new IllegalArgumentException("The partial must not be null");
        }
        internalPrinterM16775e.printTo(appendable, readablePartial, this.f16038c);
    }

    /* JADX INFO: renamed from: a */
    public String m16778a(ReadableInstant readableInstant) {
        StringBuilder sb = new StringBuilder(m16775e().estimatePrintedLength());
        try {
            m16784a(sb, readableInstant);
        } catch (IOException e) {
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public String m16779a(ReadablePartial readablePartial) {
        StringBuilder sb = new StringBuilder(m16775e().estimatePrintedLength());
        try {
            m16785a(sb, readablePartial);
        } catch (IOException e) {
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private void m16773a(Appendable appendable, long j, Chronology chronology) throws IOException {
        InternalPrinter internalPrinterM16775e = m16775e();
        Chronology chronologyM16774b = m16774b(chronology);
        DateTimeZone dateTimeZoneMo16407a = chronologyM16774b.mo16407a();
        int iMo16543b = dateTimeZoneMo16407a.mo16543b(j);
        long j2 = ((long) iMo16543b) + j;
        if ((j ^ j2) < 0 && (((long) iMo16543b) ^ j) >= 0) {
            dateTimeZoneMo16407a = DateTimeZone.f15751a;
            iMo16543b = 0;
            j2 = j;
        }
        internalPrinterM16775e.printTo(appendable, j2, chronologyM16774b.mo16408b(), iMo16543b, dateTimeZoneMo16407a, this.f16038c);
    }

    /* JADX INFO: renamed from: e */
    private InternalPrinter m16775e() {
        InternalPrinter internalPrinter = this.f16036a;
        if (internalPrinter == null) {
            throw new UnsupportedOperationException("Printing not supported");
        }
        return internalPrinter;
    }

    /* JADX INFO: renamed from: a */
    public long m16777a(String str) {
        return new DateTimeParserBucket(0L, m16774b(this.f16040e), this.f16038c, this.f16042g, this.f16043h).m16872a(m16776f(), str);
    }

    /* JADX INFO: renamed from: b */
    public LocalTime m16787b(String str) {
        return m16789c(str).m16592d();
    }

    /* JADX INFO: renamed from: c */
    public LocalDateTime m16789c(String str) {
        InternalParser internalParserM16776f = m16776f();
        Chronology chronologyMo16408b = m16774b((Chronology) null).mo16408b();
        DateTimeParserBucket dateTimeParserBucket = new DateTimeParserBucket(0L, chronologyMo16408b, this.f16038c, this.f16042g, this.f16043h);
        int into = internalParserM16776f.parseInto(dateTimeParserBucket, str, 0);
        if (into >= 0) {
            if (into >= str.length()) {
                long jM16874a = dateTimeParserBucket.m16874a(true, str);
                if (dateTimeParserBucket.m16884d() != null) {
                    chronologyMo16408b = chronologyMo16408b.mo16406a(DateTimeZone.m16524a(dateTimeParserBucket.m16884d().intValue()));
                } else if (dateTimeParserBucket.m16883c() != null) {
                    chronologyMo16408b = chronologyMo16408b.mo16406a(dateTimeParserBucket.m16883c());
                }
                return new LocalDateTime(jM16874a, chronologyMo16408b);
            }
        } else {
            into ^= -1;
        }
        throw new IllegalArgumentException(FormatUtils.m16900a(str, into));
    }

    /* JADX INFO: renamed from: f */
    private InternalParser m16776f() {
        InternalParser internalParser = this.f16037b;
        if (internalParser == null) {
            throw new UnsupportedOperationException("Parsing not supported");
        }
        return internalParser;
    }

    /* JADX INFO: renamed from: b */
    private Chronology m16774b(Chronology chronology) {
        Chronology chronologyM16516a = DateTimeUtils.m16516a(chronology);
        if (this.f16040e != null) {
            chronologyM16516a = this.f16040e;
        }
        if (this.f16041f != null) {
            return chronologyM16516a.mo16406a(this.f16041f);
        }
        return chronologyM16516a;
    }
}
