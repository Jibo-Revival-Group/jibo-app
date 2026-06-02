package org.joda.time.format;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadablePartial;
import org.joda.time.field.MillisDurationField;
import org.joda.time.field.PreciseDateTimeField;

/* JADX INFO: loaded from: classes2.dex */
public class DateTimeFormatterBuilder {

    /* JADX INFO: renamed from: a */
    private ArrayList<Object> f16044a = new ArrayList<>();

    /* JADX INFO: renamed from: b */
    private Object f16045b;

    /* JADX INFO: renamed from: a */
    public DateTimeFormatter m16802a() {
        Object objM16801k = m16801k();
        InternalPrinter internalPrinter = m16798b(objM16801k) ? (InternalPrinter) objM16801k : null;
        InternalParser internalParser = m16800c(objM16801k) ? (InternalParser) objM16801k : null;
        if (internalPrinter != null || internalParser != null) {
            return new DateTimeFormatter(internalPrinter, internalParser);
        }
        throw new UnsupportedOperationException("Both printing and parsing not supported");
    }

    /* JADX INFO: renamed from: b */
    public DateTimeParser m16823b() {
        Object objM16801k = m16801k();
        if (m16800c(objM16801k)) {
            return InternalParserDateTimeParser.m16976a((InternalParser) objM16801k);
        }
        throw new UnsupportedOperationException("Parsing is not supported");
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatterBuilder m16814a(DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            throw new IllegalArgumentException("No formatter supplied");
        }
        return m16793a(dateTimeFormatter.m16782a(), dateTimeFormatter.m16790c());
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatterBuilder m16815a(DateTimeParser dateTimeParser) {
        m16799c(dateTimeParser);
        return m16793a((InternalPrinter) null, DateTimeParserInternalParser.m16892a(dateTimeParser));
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatterBuilder m16816a(DateTimePrinter dateTimePrinter, DateTimeParser[] dateTimeParserArr) {
        int i = 0;
        if (dateTimePrinter != null) {
            m16795a(dateTimePrinter);
        }
        if (dateTimeParserArr == null) {
            throw new IllegalArgumentException("No parsers supplied");
        }
        int length = dateTimeParserArr.length;
        if (length == 1) {
            if (dateTimeParserArr[0] == null) {
                throw new IllegalArgumentException("No parser supplied");
            }
            return m16793a(DateTimePrinterInternalPrinter.m16898a(dateTimePrinter), DateTimeParserInternalParser.m16892a(dateTimeParserArr[0]));
        }
        InternalParser[] internalParserArr = new InternalParser[length];
        while (i < length - 1) {
            InternalParser internalParserM16892a = DateTimeParserInternalParser.m16892a(dateTimeParserArr[i]);
            internalParserArr[i] = internalParserM16892a;
            if (internalParserM16892a != null) {
                i++;
            } else {
                throw new IllegalArgumentException("Incomplete parser array");
            }
        }
        internalParserArr[i] = DateTimeParserInternalParser.m16892a(dateTimeParserArr[i]);
        return m16793a(DateTimePrinterInternalPrinter.m16898a(dateTimePrinter), new MatchingParser(internalParserArr));
    }

    /* JADX INFO: renamed from: b */
    public DateTimeFormatterBuilder m16822b(DateTimeParser dateTimeParser) {
        m16799c(dateTimeParser);
        return m16793a((InternalPrinter) null, new MatchingParser(new InternalParser[]{DateTimeParserInternalParser.m16892a(dateTimeParser), null}));
    }

    /* JADX INFO: renamed from: c */
    private void m16799c(DateTimeParser dateTimeParser) {
        if (dateTimeParser == null) {
            throw new IllegalArgumentException("No parser supplied");
        }
    }

    /* JADX INFO: renamed from: a */
    private void m16795a(DateTimePrinter dateTimePrinter) {
        if (dateTimePrinter == null) {
            throw new IllegalArgumentException("No printer supplied");
        }
    }

    /* JADX INFO: renamed from: a */
    private DateTimeFormatterBuilder m16792a(Object obj) {
        this.f16045b = null;
        this.f16044a.add(obj);
        this.f16044a.add(obj);
        return this;
    }

    /* JADX INFO: renamed from: a */
    private DateTimeFormatterBuilder m16793a(InternalPrinter internalPrinter, InternalParser internalParser) {
        this.f16045b = null;
        this.f16044a.add(internalPrinter);
        this.f16044a.add(internalParser);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatterBuilder m16803a(char c) {
        return m16792a(new CharacterLiteral(c));
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatterBuilder m16807a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Literal must not be null");
        }
        switch (str.length()) {
            case 0:
                return this;
            case 1:
                return m16792a(new CharacterLiteral(str.charAt(0)));
            default:
                return m16792a(new StringLiteral(str));
        }
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatterBuilder m16813a(DateTimeFieldType dateTimeFieldType, int i, int i2) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i2 < i) {
            i2 = i;
        }
        if (i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        return i <= 1 ? m16792a(new UnpaddedNumber(dateTimeFieldType, i2, false)) : m16792a(new PaddedNumber(dateTimeFieldType, i2, false, i));
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatterBuilder m16812a(DateTimeFieldType dateTimeFieldType, int i) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("Illegal number of digits: " + i);
        }
        return m16792a(new FixedNumber(dateTimeFieldType, i, false));
    }

    /* JADX INFO: renamed from: b */
    public DateTimeFormatterBuilder m16821b(DateTimeFieldType dateTimeFieldType, int i, int i2) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i2 < i) {
            i2 = i;
        }
        if (i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        return i <= 1 ? m16792a(new UnpaddedNumber(dateTimeFieldType, i2, true)) : m16792a(new PaddedNumber(dateTimeFieldType, i2, true, i));
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatterBuilder m16811a(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        return m16792a(new TextField(dateTimeFieldType, false));
    }

    /* JADX INFO: renamed from: b */
    public DateTimeFormatterBuilder m16820b(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        return m16792a(new TextField(dateTimeFieldType, true));
    }

    /* JADX INFO: renamed from: c */
    public DateTimeFormatterBuilder m16827c(DateTimeFieldType dateTimeFieldType, int i, int i2) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i2 < i) {
            i2 = i;
        }
        if (i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        return m16792a(new Fraction(dateTimeFieldType, i, i2));
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatterBuilder m16805a(int i, int i2) {
        return m16827c(DateTimeFieldType.m16489d(), i, i2);
    }

    /* JADX INFO: renamed from: b */
    public DateTimeFormatterBuilder m16818b(int i, int i2) {
        return m16827c(DateTimeFieldType.m16491f(), i, i2);
    }

    /* JADX INFO: renamed from: c */
    public DateTimeFormatterBuilder m16826c(int i, int i2) {
        return m16827c(DateTimeFieldType.m16492g(), i, i2);
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatterBuilder m16804a(int i) {
        return m16813a(DateTimeFieldType.m16488c(), i, 2);
    }

    /* JADX INFO: renamed from: b */
    public DateTimeFormatterBuilder m16817b(int i) {
        return m16813a(DateTimeFieldType.m16490e(), i, 2);
    }

    /* JADX INFO: renamed from: c */
    public DateTimeFormatterBuilder m16825c(int i) {
        return m16813a(DateTimeFieldType.m16492g(), i, 2);
    }

    /* JADX INFO: renamed from: d */
    public DateTimeFormatterBuilder m16829d(int i) {
        return m16813a(DateTimeFieldType.m16493h(), i, 2);
    }

    /* JADX INFO: renamed from: e */
    public DateTimeFormatterBuilder m16832e(int i) {
        return m16813a(DateTimeFieldType.m16494i(), i, 2);
    }

    /* JADX INFO: renamed from: f */
    public DateTimeFormatterBuilder m16835f(int i) {
        return m16813a(DateTimeFieldType.m16495j(), i, 2);
    }

    /* JADX INFO: renamed from: g */
    public DateTimeFormatterBuilder m16838g(int i) {
        return m16813a(DateTimeFieldType.m16497l(), i, 1);
    }

    /* JADX INFO: renamed from: h */
    public DateTimeFormatterBuilder m16841h(int i) {
        return m16813a(DateTimeFieldType.m16498m(), i, 2);
    }

    /* JADX INFO: renamed from: i */
    public DateTimeFormatterBuilder m16843i(int i) {
        return m16813a(DateTimeFieldType.m16499n(), i, 3);
    }

    /* JADX INFO: renamed from: j */
    public DateTimeFormatterBuilder m16845j(int i) {
        return m16813a(DateTimeFieldType.m16500o(), i, 2);
    }

    /* JADX INFO: renamed from: d */
    public DateTimeFormatterBuilder m16830d(int i, int i2) {
        return m16821b(DateTimeFieldType.m16501p(), i, i2);
    }

    /* JADX INFO: renamed from: k */
    public DateTimeFormatterBuilder m16846k(int i) {
        return m16813a(DateTimeFieldType.m16503r(), i, 2);
    }

    /* JADX INFO: renamed from: e */
    public DateTimeFormatterBuilder m16833e(int i, int i2) {
        return m16821b(DateTimeFieldType.m16504s(), i, i2);
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatterBuilder m16806a(int i, boolean z) {
        return m16792a(new TwoDigitYear(DateTimeFieldType.m16504s(), i, z));
    }

    /* JADX INFO: renamed from: b */
    public DateTimeFormatterBuilder m16819b(int i, boolean z) {
        return m16792a(new TwoDigitYear(DateTimeFieldType.m16501p(), i, z));
    }

    /* JADX INFO: renamed from: f */
    public DateTimeFormatterBuilder m16836f(int i, int i2) {
        return m16813a(DateTimeFieldType.m16505t(), i, i2);
    }

    /* JADX INFO: renamed from: g */
    public DateTimeFormatterBuilder m16839g(int i, int i2) {
        return m16821b(DateTimeFieldType.m16507v(), i, i2);
    }

    /* JADX INFO: renamed from: c */
    public DateTimeFormatterBuilder m16824c() {
        return m16811a(DateTimeFieldType.m16496k());
    }

    /* JADX INFO: renamed from: d */
    public DateTimeFormatterBuilder m16828d() {
        return m16811a(DateTimeFieldType.m16497l());
    }

    /* JADX INFO: renamed from: e */
    public DateTimeFormatterBuilder m16831e() {
        return m16820b(DateTimeFieldType.m16497l());
    }

    /* JADX INFO: renamed from: f */
    public DateTimeFormatterBuilder m16834f() {
        return m16811a(DateTimeFieldType.m16503r());
    }

    /* JADX INFO: renamed from: g */
    public DateTimeFormatterBuilder m16837g() {
        return m16820b(DateTimeFieldType.m16503r());
    }

    /* JADX INFO: renamed from: h */
    public DateTimeFormatterBuilder m16840h() {
        return m16811a(DateTimeFieldType.m16508w());
    }

    /* JADX INFO: renamed from: i */
    public DateTimeFormatterBuilder m16842i() {
        return m16793a(new TimeZoneName(0, null), (InternalParser) null);
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatterBuilder m16810a(Map<String, DateTimeZone> map) {
        TimeZoneName timeZoneName = new TimeZoneName(1, map);
        return m16793a(timeZoneName, timeZoneName);
    }

    /* JADX INFO: renamed from: j */
    public DateTimeFormatterBuilder m16844j() {
        return m16793a(TimeZoneId.INSTANCE, TimeZoneId.INSTANCE);
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatterBuilder m16809a(String str, boolean z, int i, int i2) {
        return m16792a(new TimeZoneOffset(str, str, z, i, i2));
    }

    /* JADX INFO: renamed from: a */
    public DateTimeFormatterBuilder m16808a(String str, String str2, boolean z, int i, int i2) {
        return m16792a(new TimeZoneOffset(str, str2, z, i, i2));
    }

    /* JADX INFO: renamed from: k */
    private Object m16801k() {
        Object composite = this.f16045b;
        if (composite == null) {
            if (this.f16044a.size() == 2) {
                Object obj = this.f16044a.get(0);
                Object obj2 = this.f16044a.get(1);
                if (obj == null) {
                    composite = obj2;
                } else if (obj == obj2 || obj2 == null) {
                    composite = obj;
                }
            }
            if (composite == null) {
                composite = new Composite(this.f16044a);
            }
            this.f16045b = composite;
        }
        return composite;
    }

    /* JADX INFO: renamed from: b */
    private boolean m16798b(Object obj) {
        if (obj instanceof InternalPrinter) {
            if (obj instanceof Composite) {
                return ((Composite) obj).m16849a();
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    private boolean m16800c(Object obj) {
        if (obj instanceof InternalParser) {
            if (obj instanceof Composite) {
                return ((Composite) obj).m16850b();
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    static void m16794a(Appendable appendable, int i) throws IOException {
        while (true) {
            i--;
            if (i >= 0) {
                appendable.append((char) 65533);
            } else {
                return;
            }
        }
    }

    static class CharacterLiteral implements InternalParser, InternalPrinter {

        /* JADX INFO: renamed from: a */
        private final char f16046a;

        CharacterLiteral(char c) {
            this.f16046a = c;
        }

        @Override // org.joda.time.format.InternalPrinter
        public int estimatePrintedLength() {
            return 1;
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(this.f16046a);
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            appendable.append(this.f16046a);
        }

        @Override // org.joda.time.format.InternalParser
        public int estimateParsedLength() {
            return 1;
        }

        @Override // org.joda.time.format.InternalParser
        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            char upperCase;
            char upperCase2;
            if (i >= charSequence.length()) {
                return i ^ (-1);
            }
            char cCharAt = charSequence.charAt(i);
            char c = this.f16046a;
            if (cCharAt != c && (upperCase = Character.toUpperCase(cCharAt)) != (upperCase2 = Character.toUpperCase(c)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return i ^ (-1);
            }
            return i + 1;
        }
    }

    static class StringLiteral implements InternalParser, InternalPrinter {

        /* JADX INFO: renamed from: a */
        private final String f16060a;

        StringLiteral(String str) {
            this.f16060a = str;
        }

        @Override // org.joda.time.format.InternalPrinter
        public int estimatePrintedLength() {
            return this.f16060a.length();
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(this.f16060a);
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            appendable.append(this.f16060a);
        }

        @Override // org.joda.time.format.InternalParser
        public int estimateParsedLength() {
            return this.f16060a.length();
        }

        @Override // org.joda.time.format.InternalParser
        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            return DateTimeFormatterBuilder.m16797b(charSequence, i, this.f16060a) ? this.f16060a.length() + i : i ^ (-1);
        }
    }

    static abstract class NumberFormatter implements InternalParser, InternalPrinter {

        /* JADX INFO: renamed from: a */
        protected final DateTimeFieldType f16056a;

        /* JADX INFO: renamed from: b */
        protected final int f16057b;

        /* JADX INFO: renamed from: c */
        protected final boolean f16058c;

        NumberFormatter(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            this.f16056a = dateTimeFieldType;
            this.f16057b = i;
            this.f16058c = z;
        }

        @Override // org.joda.time.format.InternalParser
        public int estimateParsedLength() {
            return this.f16057b;
        }

        @Override // org.joda.time.format.InternalParser
        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            boolean z;
            int i2;
            int iCharAt;
            char cCharAt;
            int i3 = 0;
            boolean z2 = false;
            int iMin = Math.min(this.f16057b, charSequence.length() - i);
            boolean z3 = false;
            while (i3 < iMin) {
                char cCharAt2 = charSequence.charAt(i + i3);
                if (i3 == 0 && ((cCharAt2 == '-' || cCharAt2 == '+') && this.f16058c)) {
                    z2 = cCharAt2 == '-';
                    z3 = cCharAt2 == '+';
                    if (i3 + 1 >= iMin || (cCharAt = charSequence.charAt(i + i3 + 1)) < '0') {
                        break;
                    }
                    if (cCharAt > '9') {
                        z = z2;
                        break;
                    }
                    i3++;
                    iMin = Math.min(iMin + 1, charSequence.length() - i);
                } else {
                    if (cCharAt2 < '0') {
                        break;
                    }
                    if (cCharAt2 > '9') {
                        z = z2;
                        break;
                    }
                    i3++;
                }
            }
            z = z2;
            if (i3 == 0) {
                return i ^ (-1);
            }
            if (i3 >= 9) {
                if (z3) {
                    i2 = i + i3;
                    iCharAt = Integer.parseInt(charSequence.subSequence(i + 1, i2).toString());
                } else {
                    i2 = i + i3;
                    iCharAt = Integer.parseInt(charSequence.subSequence(i, i2).toString());
                }
            } else {
                int i4 = (z || z3) ? i + 1 : i;
                int i5 = i4 + 1;
                try {
                    int iCharAt2 = charSequence.charAt(i4) - '0';
                    i2 = i + i3;
                    iCharAt = iCharAt2;
                    for (int i6 = i5; i6 < i2; i6++) {
                        iCharAt = (charSequence.charAt(i6) + ((iCharAt << 3) + (iCharAt << 1))) - 48;
                    }
                    if (z) {
                        iCharAt = -iCharAt;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    return i ^ (-1);
                }
            }
            dateTimeParserBucket.m16878a(this.f16056a, iCharAt);
            return i2;
        }
    }

    static class UnpaddedNumber extends NumberFormatter {
        protected UnpaddedNumber(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            super(dateTimeFieldType, i, z);
        }

        @Override // org.joda.time.format.InternalPrinter
        public int estimatePrintedLength() {
            return this.f16057b;
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                FormatUtils.m16901a(appendable, this.f16056a.mo16509a(chronology).mo16434a(j));
            } catch (RuntimeException e) {
                appendable.append((char) 65533);
            }
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            if (readablePartial.mo16589b(this.f16056a)) {
                try {
                    FormatUtils.m16901a(appendable, readablePartial.mo16585a(this.f16056a));
                    return;
                } catch (RuntimeException e) {
                    appendable.append((char) 65533);
                    return;
                }
            }
            appendable.append((char) 65533);
        }
    }

    static class PaddedNumber extends NumberFormatter {

        /* JADX INFO: renamed from: d */
        protected final int f16059d;

        protected PaddedNumber(DateTimeFieldType dateTimeFieldType, int i, boolean z, int i2) {
            super(dateTimeFieldType, i, z);
            this.f16059d = i2;
        }

        @Override // org.joda.time.format.InternalPrinter
        public int estimatePrintedLength() {
            return this.f16057b;
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                FormatUtils.m16902a(appendable, this.f16056a.mo16509a(chronology).mo16434a(j), this.f16059d);
            } catch (RuntimeException e) {
                DateTimeFormatterBuilder.m16794a(appendable, this.f16059d);
            }
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            if (readablePartial.mo16589b(this.f16056a)) {
                try {
                    FormatUtils.m16902a(appendable, readablePartial.mo16585a(this.f16056a), this.f16059d);
                    return;
                } catch (RuntimeException e) {
                    DateTimeFormatterBuilder.m16794a(appendable, this.f16059d);
                    return;
                }
            }
            DateTimeFormatterBuilder.m16794a(appendable, this.f16059d);
        }
    }

    static class FixedNumber extends PaddedNumber {
        protected FixedNumber(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            super(dateTimeFieldType, i, z, i);
        }

        @Override // org.joda.time.format.DateTimeFormatterBuilder.NumberFormatter, org.joda.time.format.InternalParser
        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            int i2;
            char cCharAt;
            int into = super.parseInto(dateTimeParserBucket, charSequence, i);
            if (into >= 0 && into != (i2 = this.f16057b + i)) {
                if (this.f16058c && ((cCharAt = charSequence.charAt(i)) == '-' || cCharAt == '+')) {
                    i2++;
                }
                if (into > i2) {
                    return (i2 + 1) ^ (-1);
                }
                if (into < i2) {
                    return into ^ (-1);
                }
                return into;
            }
            return into;
        }
    }

    static class TwoDigitYear implements InternalParser, InternalPrinter {

        /* JADX INFO: renamed from: a */
        private final DateTimeFieldType f16071a;

        /* JADX INFO: renamed from: b */
        private final int f16072b;

        /* JADX INFO: renamed from: c */
        private final boolean f16073c;

        TwoDigitYear(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            this.f16071a = dateTimeFieldType;
            this.f16072b = i;
            this.f16073c = z;
        }

        @Override // org.joda.time.format.InternalParser
        public int estimateParsedLength() {
            return this.f16073c ? 4 : 2;
        }

        @Override // org.joda.time.format.InternalParser
        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            int i2;
            int iCharAt;
            int i3;
            int length = charSequence.length() - i;
            if (!this.f16073c) {
                if (Math.min(2, length) < 2) {
                    return i ^ (-1);
                }
            } else {
                int i4 = 0;
                boolean z = false;
                boolean z2 = false;
                int i5 = length;
                while (i4 < i5) {
                    char cCharAt = charSequence.charAt(i + i4);
                    if (i4 == 0 && (cCharAt == '-' || cCharAt == '+')) {
                        boolean z3 = cCharAt == '-';
                        if (z3) {
                            i4++;
                            z = z3;
                            z2 = true;
                        } else {
                            i++;
                            z2 = true;
                            i5--;
                            z = z3;
                        }
                    } else {
                        if (cCharAt < '0' || cCharAt > '9') {
                            break;
                        }
                        i4++;
                    }
                }
                if (i4 == 0) {
                    return i ^ (-1);
                }
                if (z2 || i4 != 2) {
                    if (i4 >= 9) {
                        i2 = i + i4;
                        iCharAt = Integer.parseInt(charSequence.subSequence(i, i2).toString());
                    } else {
                        int i6 = z ? i + 1 : i;
                        int i7 = i6 + 1;
                        try {
                            int iCharAt2 = charSequence.charAt(i6) - '0';
                            i2 = i + i4;
                            iCharAt = iCharAt2;
                            for (int i8 = i7; i8 < i2; i8++) {
                                iCharAt = (charSequence.charAt(i8) + ((iCharAt << 3) + (iCharAt << 1))) - 48;
                            }
                            if (z) {
                                iCharAt = -iCharAt;
                            }
                        } catch (StringIndexOutOfBoundsException e) {
                            return i ^ (-1);
                        }
                    }
                    dateTimeParserBucket.m16878a(this.f16071a, iCharAt);
                    return i2;
                }
            }
            char cCharAt2 = charSequence.charAt(i);
            if (cCharAt2 < '0' || cCharAt2 > '9') {
                return i ^ (-1);
            }
            int i9 = cCharAt2 - '0';
            char cCharAt3 = charSequence.charAt(i + 1);
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                return i ^ (-1);
            }
            int i10 = (((i9 << 1) + (i9 << 3)) + cCharAt3) - 48;
            int iIntValue = this.f16072b;
            if (dateTimeParserBucket.m16885e() != null) {
                iIntValue = dateTimeParserBucket.m16885e().intValue();
            }
            int i11 = iIntValue - 50;
            if (i11 >= 0) {
                i3 = i11 % 100;
            } else {
                i3 = ((i11 + 1) % 100) + 99;
            }
            dateTimeParserBucket.m16878a(this.f16071a, (((i10 < i3 ? 100 : 0) + i11) - i3) + i10);
            return i + 2;
        }

        @Override // org.joda.time.format.InternalPrinter
        public int estimatePrintedLength() {
            return 2;
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            int iM16857a = m16857a(j, chronology);
            if (iM16857a < 0) {
                appendable.append((char) 65533);
                appendable.append((char) 65533);
            } else {
                FormatUtils.m16902a(appendable, iM16857a, 2);
            }
        }

        /* JADX INFO: renamed from: a */
        private int m16857a(long j, Chronology chronology) {
            try {
                int iMo16434a = this.f16071a.mo16509a(chronology).mo16434a(j);
                if (iMo16434a < 0) {
                    iMo16434a = -iMo16434a;
                }
                return iMo16434a % 100;
            } catch (RuntimeException e) {
                return -1;
            }
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            int iM16858a = m16858a(readablePartial);
            if (iM16858a < 0) {
                appendable.append((char) 65533);
                appendable.append((char) 65533);
            } else {
                FormatUtils.m16902a(appendable, iM16858a, 2);
            }
        }

        /* JADX INFO: renamed from: a */
        private int m16858a(ReadablePartial readablePartial) {
            if (readablePartial.mo16589b(this.f16071a)) {
                try {
                    int iMo16585a = readablePartial.mo16585a(this.f16071a);
                    if (iMo16585a < 0) {
                        iMo16585a = -iMo16585a;
                    }
                    return iMo16585a % 100;
                } catch (RuntimeException e) {
                }
            }
            return -1;
        }
    }

    static class TextField implements InternalParser, InternalPrinter {

        /* JADX INFO: renamed from: a */
        private static Map<Locale, Map<DateTimeFieldType, Object[]>> f16061a = new ConcurrentHashMap();

        /* JADX INFO: renamed from: b */
        private final DateTimeFieldType f16062b;

        /* JADX INFO: renamed from: c */
        private final boolean f16063c;

        TextField(DateTimeFieldType dateTimeFieldType, boolean z) {
            this.f16062b = dateTimeFieldType;
            this.f16063c = z;
        }

        @Override // org.joda.time.format.InternalPrinter
        public int estimatePrintedLength() {
            return this.f16063c ? 6 : 20;
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                appendable.append(m16853a(j, chronology, locale));
            } catch (RuntimeException e) {
                appendable.append((char) 65533);
            }
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            try {
                appendable.append(m16854a(readablePartial, locale));
            } catch (RuntimeException e) {
                appendable.append((char) 65533);
            }
        }

        /* JADX INFO: renamed from: a */
        private String m16853a(long j, Chronology chronology, Locale locale) {
            DateTimeField dateTimeFieldMo16509a = this.f16062b.mo16509a(chronology);
            return this.f16063c ? dateTimeFieldMo16509a.mo16446b(j, locale) : dateTimeFieldMo16509a.mo16440a(j, locale);
        }

        /* JADX INFO: renamed from: a */
        private String m16854a(ReadablePartial readablePartial, Locale locale) {
            if (readablePartial.mo16589b(this.f16062b)) {
                DateTimeField dateTimeFieldMo16509a = this.f16062b.mo16509a(readablePartial.mo16590c());
                if (this.f16063c) {
                    return dateTimeFieldMo16509a.mo16447b(readablePartial, locale);
                }
                return dateTimeFieldMo16509a.mo16441a(readablePartial, locale);
            }
            return "�";
        }

        @Override // org.joda.time.format.InternalParser
        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        @Override // org.joda.time.format.InternalParser
        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            Map map;
            Map map2;
            int iIntValue;
            Locale localeM16882b = dateTimeParserBucket.m16882b();
            Map<DateTimeFieldType, Object[]> map3 = f16061a.get(localeM16882b);
            if (map3 == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                f16061a.put(localeM16882b, concurrentHashMap);
                map = concurrentHashMap;
            } else {
                map = map3;
            }
            Object[] objArr = (Object[]) map.get(this.f16062b);
            if (objArr == null) {
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(32);
                MutableDateTime.Property propertyM16595a = new MutableDateTime(0L, DateTimeZone.f15751a).m16595a(this.f16062b);
                int iG = propertyM16595a.m16742g();
                int iH = propertyM16595a.m16743h();
                if (iH - iG > 32) {
                    return i ^ (-1);
                }
                iIntValue = propertyM16595a.m16738c(localeM16882b);
                while (iG <= iH) {
                    propertyM16595a.m16600a(iG);
                    concurrentHashMap2.put(propertyM16595a.m16737b(localeM16882b), Boolean.TRUE);
                    concurrentHashMap2.put(propertyM16595a.m16737b(localeM16882b).toLowerCase(localeM16882b), Boolean.TRUE);
                    concurrentHashMap2.put(propertyM16595a.m16737b(localeM16882b).toUpperCase(localeM16882b), Boolean.TRUE);
                    concurrentHashMap2.put(propertyM16595a.m16736a(localeM16882b), Boolean.TRUE);
                    concurrentHashMap2.put(propertyM16595a.m16736a(localeM16882b).toLowerCase(localeM16882b), Boolean.TRUE);
                    concurrentHashMap2.put(propertyM16595a.m16736a(localeM16882b).toUpperCase(localeM16882b), Boolean.TRUE);
                    iG++;
                }
                if ("en".equals(localeM16882b.getLanguage()) && this.f16062b == DateTimeFieldType.m16508w()) {
                    concurrentHashMap2.put("BCE", Boolean.TRUE);
                    concurrentHashMap2.put("bce", Boolean.TRUE);
                    concurrentHashMap2.put("CE", Boolean.TRUE);
                    concurrentHashMap2.put("ce", Boolean.TRUE);
                    iIntValue = 3;
                }
                map.put(this.f16062b, new Object[]{concurrentHashMap2, Integer.valueOf(iIntValue)});
                map2 = concurrentHashMap2;
            } else {
                map2 = (Map) objArr[0];
                iIntValue = ((Integer) objArr[1]).intValue();
            }
            for (int iMin = Math.min(charSequence.length(), iIntValue + i); iMin > i; iMin--) {
                String string = charSequence.subSequence(i, iMin).toString();
                if (map2.containsKey(string)) {
                    dateTimeParserBucket.m16879a(this.f16062b, string, localeM16882b);
                    return iMin;
                }
            }
            return i ^ (-1);
        }
    }

    static class Fraction implements InternalParser, InternalPrinter {

        /* JADX INFO: renamed from: a */
        protected int f16051a;

        /* JADX INFO: renamed from: b */
        protected int f16052b;

        /* JADX INFO: renamed from: c */
        private final DateTimeFieldType f16053c;

        protected Fraction(DateTimeFieldType dateTimeFieldType, int i, int i2) {
            this.f16053c = dateTimeFieldType;
            i2 = i2 > 18 ? 18 : i2;
            this.f16051a = i;
            this.f16052b = i2;
        }

        @Override // org.joda.time.format.InternalPrinter
        public int estimatePrintedLength() {
            return this.f16052b;
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            m16852a(appendable, j, chronology);
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            m16852a(appendable, readablePartial.mo16590c().mo16405a(readablePartial, 0L), readablePartial.mo16590c());
        }

        /* JADX INFO: renamed from: a */
        protected void m16852a(Appendable appendable, long j, Chronology chronology) throws IOException {
            String string;
            DateTimeField dateTimeFieldMo16509a = this.f16053c.mo16509a(chronology);
            int i = this.f16051a;
            try {
                long jMo16462i = dateTimeFieldMo16509a.mo16462i(j);
                if (jMo16462i != 0) {
                    long[] jArrM16851a = m16851a(jMo16462i, dateTimeFieldMo16509a);
                    long j2 = jArrM16851a[0];
                    int i2 = (int) jArrM16851a[1];
                    if ((2147483647L & j2) == j2) {
                        string = Integer.toString((int) j2);
                    } else {
                        string = Long.toString(j2);
                    }
                    int length = string.length();
                    while (length < i2) {
                        appendable.append('0');
                        i--;
                        i2--;
                    }
                    if (i < i2) {
                        while (i < i2 && length > 1 && string.charAt(length - 1) == '0') {
                            i2--;
                            length--;
                        }
                        if (length < string.length()) {
                            for (int i3 = 0; i3 < length; i3++) {
                                appendable.append(string.charAt(i3));
                            }
                            return;
                        }
                    }
                    appendable.append(string);
                    return;
                }
                while (true) {
                    i--;
                    if (i >= 0) {
                        appendable.append('0');
                    } else {
                        return;
                    }
                }
            } catch (RuntimeException e) {
                DateTimeFormatterBuilder.m16794a(appendable, i);
            }
        }

        /* JADX INFO: renamed from: a */
        private long[] m16851a(long j, DateTimeField dateTimeField) {
            int i;
            long j2;
            long jMo16560d = dateTimeField.mo16453d().mo16560d();
            int i2 = this.f16052b;
            while (true) {
                switch (i) {
                    case 1:
                        j2 = 10;
                        break;
                    case 2:
                        j2 = 100;
                        break;
                    case 3:
                        j2 = 1000;
                        break;
                    case 4:
                        j2 = 10000;
                        break;
                    case 5:
                        j2 = 100000;
                        break;
                    case 6:
                        j2 = 1000000;
                        break;
                    case 7:
                        j2 = 10000000;
                        break;
                    case 8:
                        j2 = 100000000;
                        break;
                    case 9:
                        j2 = 1000000000;
                        break;
                    case 10:
                        j2 = 10000000000L;
                        break;
                    case 11:
                        j2 = 100000000000L;
                        break;
                    case 12:
                        j2 = 1000000000000L;
                        break;
                    case 13:
                        j2 = 10000000000000L;
                        break;
                    case 14:
                        j2 = 100000000000000L;
                        break;
                    case 15:
                        j2 = 1000000000000000L;
                        break;
                    case 16:
                        j2 = 10000000000000000L;
                        break;
                    case 17:
                        j2 = 100000000000000000L;
                        break;
                    case 18:
                        j2 = 1000000000000000000L;
                        break;
                    default:
                        j2 = 1;
                        break;
                }
                if ((jMo16560d * j2) / j2 != jMo16560d) {
                    i2 = i - 1;
                } else {
                    return new long[]{(j2 * j) / jMo16560d, i};
                }
            }
        }

        @Override // org.joda.time.format.InternalParser
        public int estimateParsedLength() {
            return this.f16052b;
        }

        @Override // org.joda.time.format.InternalParser
        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            DateTimeField dateTimeFieldMo16509a = this.f16053c.mo16509a(dateTimeParserBucket.m16875a());
            int iMin = Math.min(this.f16052b, charSequence.length() - i);
            long j = 0;
            long jMo16560d = dateTimeFieldMo16509a.mo16453d().mo16560d() * 10;
            int i2 = 0;
            while (i2 < iMin) {
                char cCharAt = charSequence.charAt(i + i2);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i2++;
                jMo16560d /= 10;
                j += ((long) (cCharAt - '0')) * jMo16560d;
            }
            long j2 = j / 10;
            if (i2 == 0) {
                return i ^ (-1);
            }
            if (j2 > 2147483647L) {
                return i ^ (-1);
            }
            dateTimeParserBucket.m16877a(new PreciseDateTimeField(DateTimeFieldType.m16486a(), MillisDurationField.f16010a, dateTimeFieldMo16509a.mo16453d()), (int) j2);
            return i2 + i;
        }
    }

    static class TimeZoneOffset implements InternalParser, InternalPrinter {

        /* JADX INFO: renamed from: a */
        private final String f16066a;

        /* JADX INFO: renamed from: b */
        private final String f16067b;

        /* JADX INFO: renamed from: c */
        private final boolean f16068c;

        /* JADX INFO: renamed from: d */
        private final int f16069d;

        /* JADX INFO: renamed from: e */
        private final int f16070e;

        TimeZoneOffset(String str, String str2, boolean z, int i, int i2) {
            int i3 = 4;
            this.f16066a = str;
            this.f16067b = str2;
            this.f16068c = z;
            if (i <= 0 || i2 < i) {
                throw new IllegalArgumentException();
            }
            if (i > 4) {
                i2 = 4;
            } else {
                i3 = i;
            }
            this.f16069d = i3;
            this.f16070e = i2;
        }

        @Override // org.joda.time.format.InternalPrinter
        public int estimatePrintedLength() {
            int i = (this.f16069d + 1) << 1;
            if (this.f16068c) {
                i += this.f16069d - 1;
            }
            if (this.f16066a != null && this.f16066a.length() > i) {
                return this.f16066a.length();
            }
            return i;
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            if (dateTimeZone != null) {
                if (i == 0 && this.f16066a != null) {
                    appendable.append(this.f16066a);
                    return;
                }
                if (i >= 0) {
                    appendable.append('+');
                } else {
                    appendable.append('-');
                    i = -i;
                }
                int i2 = i / 3600000;
                FormatUtils.m16902a(appendable, i2, 2);
                if (this.f16070e != 1) {
                    int i3 = i - (i2 * 3600000);
                    if (i3 != 0 || this.f16069d > 1) {
                        int i4 = i3 / 60000;
                        if (this.f16068c) {
                            appendable.append(':');
                        }
                        FormatUtils.m16902a(appendable, i4, 2);
                        if (this.f16070e != 2) {
                            int i5 = i3 - (i4 * 60000);
                            if (i5 != 0 || this.f16069d > 2) {
                                int i6 = i5 / 1000;
                                if (this.f16068c) {
                                    appendable.append(':');
                                }
                                FormatUtils.m16902a(appendable, i6, 2);
                                if (this.f16070e != 3) {
                                    int i7 = i5 - (i6 * 1000);
                                    if (i7 != 0 || this.f16069d > 3) {
                                        if (this.f16068c) {
                                            appendable.append('.');
                                        }
                                        FormatUtils.m16902a(appendable, i7, 3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
        }

        @Override // org.joda.time.format.InternalParser
        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        /* JADX WARN: Removed duplicated region for block: B:64:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x012b  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x012d  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0131  */
        @Override // org.joda.time.format.InternalParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int parseInto(org.joda.time.format.DateTimeParserBucket r10, java.lang.CharSequence r11, int r12) {
            /*
                Method dump skipped, instruction units count: 353
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormatterBuilder.TimeZoneOffset.parseInto(org.joda.time.format.DateTimeParserBucket, java.lang.CharSequence, int):int");
        }

        /* JADX INFO: renamed from: a */
        private int m16856a(CharSequence charSequence, int i, int i2) {
            int i3 = 0;
            for (int iMin = Math.min(charSequence.length() - i, i2); iMin > 0; iMin--) {
                char cCharAt = charSequence.charAt(i + i3);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i3++;
            }
            return i3;
        }
    }

    static class TimeZoneName implements InternalParser, InternalPrinter {

        /* JADX INFO: renamed from: a */
        private final Map<String, DateTimeZone> f16064a;

        /* JADX INFO: renamed from: b */
        private final int f16065b;

        TimeZoneName(int i, Map<String, DateTimeZone> map) {
            this.f16065b = i;
            this.f16064a = map;
        }

        @Override // org.joda.time.format.InternalPrinter
        public int estimatePrintedLength() {
            return this.f16065b == 1 ? 4 : 20;
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(m16855a(j - ((long) i), dateTimeZone, locale));
        }

        /* JADX INFO: renamed from: a */
        private String m16855a(long j, DateTimeZone dateTimeZone, Locale locale) {
            if (dateTimeZone == null) {
                return "";
            }
            switch (this.f16065b) {
                case 0:
                    return dateTimeZone.m16544b(j, locale);
                case 1:
                    return dateTimeZone.m16542a(j, locale);
                default:
                    return "";
            }
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
        }

        @Override // org.joda.time.format.InternalParser
        public int estimateParsedLength() {
            return this.f16065b == 1 ? 4 : 20;
        }

        @Override // org.joda.time.format.InternalParser
        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            Map<String, DateTimeZone> map = this.f16064a;
            Map<String, DateTimeZone> mapM16519b = map != null ? map : DateTimeUtils.m16519b();
            String str = null;
            for (String str2 : mapM16519b.keySet()) {
                if (!DateTimeFormatterBuilder.m16796a(charSequence, i, str2) || (str != null && str2.length() <= str.length())) {
                    str2 = str;
                }
                str = str2;
            }
            if (str == null) {
                return i ^ (-1);
            }
            dateTimeParserBucket.m16880a(mapM16519b.get(str));
            return str.length() + i;
        }
    }

    enum TimeZoneId implements InternalParser, InternalPrinter {
        INSTANCE;

        private static final Map<String, List<String>> GROUPED_IDS;
        static final int MAX_LENGTH;
        static final int MAX_PREFIX_LENGTH;
        private static final List<String> BASE_GROUPED_IDS = new ArrayList();
        private static final List<String> ALL_IDS = new ArrayList(DateTimeZone.m16531b());

        static {
            Collections.sort(ALL_IDS);
            GROUPED_IDS = new HashMap();
            int i = 0;
            int iMax = 0;
            for (String str : ALL_IDS) {
                int iIndexOf = str.indexOf(47);
                if (iIndexOf >= 0) {
                    iIndexOf = iIndexOf < str.length() ? iIndexOf + 1 : iIndexOf;
                    int iMax2 = Math.max(i, iIndexOf);
                    String strSubstring = str.substring(0, iIndexOf + 1);
                    String strSubstring2 = str.substring(iIndexOf);
                    if (!GROUPED_IDS.containsKey(strSubstring)) {
                        GROUPED_IDS.put(strSubstring, new ArrayList());
                    }
                    GROUPED_IDS.get(strSubstring).add(strSubstring2);
                    i = iMax2;
                } else {
                    BASE_GROUPED_IDS.add(str);
                }
                iMax = Math.max(iMax, str.length());
            }
            MAX_LENGTH = iMax;
            MAX_PREFIX_LENGTH = i;
        }

        @Override // org.joda.time.format.InternalPrinter
        public int estimatePrintedLength() {
            return MAX_LENGTH;
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(dateTimeZone != null ? dateTimeZone.m16548e() : "");
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
        }

        @Override // org.joda.time.format.InternalParser
        public int estimateParsedLength() {
            return MAX_LENGTH;
        }

        @Override // org.joda.time.format.InternalParser
        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            int length;
            List<String> list;
            List<String> list2 = BASE_GROUPED_IDS;
            int length2 = charSequence.length();
            int iMin = Math.min(length2, MAX_PREFIX_LENGTH + i);
            String string = "";
            int i2 = i;
            while (true) {
                if (i2 >= iMin) {
                    length = i;
                    list = list2;
                    break;
                }
                if (charSequence.charAt(i2) != '/') {
                    i2++;
                } else {
                    string = charSequence.subSequence(i, i2 + 1).toString();
                    length = i + string.length();
                    List<String> list3 = GROUPED_IDS.get(i2 < length2 ? string + charSequence.charAt(i2 + 1) : string);
                    if (list3 == null) {
                        return i ^ (-1);
                    }
                    list = list3;
                }
            }
            String str = null;
            int i3 = 0;
            while (i3 < list.size()) {
                String str2 = list.get(i3);
                if (!DateTimeFormatterBuilder.m16796a(charSequence, length, str2) || (str != null && str2.length() <= str.length())) {
                    str2 = str;
                }
                i3++;
                str = str2;
            }
            if (str != null) {
                dateTimeParserBucket.m16880a(DateTimeZone.m16525a(string + str));
                return str.length() + length;
            }
            return i ^ (-1);
        }
    }

    static class Composite implements InternalParser, InternalPrinter {

        /* JADX INFO: renamed from: a */
        private final InternalPrinter[] f16047a;

        /* JADX INFO: renamed from: b */
        private final InternalParser[] f16048b;

        /* JADX INFO: renamed from: c */
        private final int f16049c;

        /* JADX INFO: renamed from: d */
        private final int f16050d;

        Composite(List<Object> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            m16847a(list, arrayList, arrayList2);
            if (arrayList.contains(null) || arrayList.isEmpty()) {
                this.f16047a = null;
                this.f16049c = 0;
            } else {
                int size = arrayList.size();
                this.f16047a = new InternalPrinter[size];
                int iEstimatePrintedLength = 0;
                for (int i = 0; i < size; i++) {
                    InternalPrinter internalPrinter = (InternalPrinter) arrayList.get(i);
                    iEstimatePrintedLength += internalPrinter.estimatePrintedLength();
                    this.f16047a[i] = internalPrinter;
                }
                this.f16049c = iEstimatePrintedLength;
            }
            if (arrayList2.contains(null) || arrayList2.isEmpty()) {
                this.f16048b = null;
                this.f16050d = 0;
                return;
            }
            int size2 = arrayList2.size();
            this.f16048b = new InternalParser[size2];
            int iEstimateParsedLength = 0;
            for (int i2 = 0; i2 < size2; i2++) {
                InternalParser internalParser = (InternalParser) arrayList2.get(i2);
                iEstimateParsedLength += internalParser.estimateParsedLength();
                this.f16048b[i2] = internalParser;
            }
            this.f16050d = iEstimateParsedLength;
        }

        @Override // org.joda.time.format.InternalPrinter
        public int estimatePrintedLength() {
            return this.f16049c;
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            InternalPrinter[] internalPrinterArr = this.f16047a;
            if (internalPrinterArr == null) {
                throw new UnsupportedOperationException();
            }
            Locale locale2 = locale == null ? Locale.getDefault() : locale;
            for (InternalPrinter internalPrinter : internalPrinterArr) {
                internalPrinter.printTo(appendable, j, chronology, i, dateTimeZone, locale2);
            }
        }

        @Override // org.joda.time.format.InternalPrinter
        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            InternalPrinter[] internalPrinterArr = this.f16047a;
            if (internalPrinterArr == null) {
                throw new UnsupportedOperationException();
            }
            if (locale == null) {
                locale = Locale.getDefault();
            }
            for (InternalPrinter internalPrinter : internalPrinterArr) {
                internalPrinter.printTo(appendable, readablePartial, locale);
            }
        }

        @Override // org.joda.time.format.InternalParser
        public int estimateParsedLength() {
            return this.f16050d;
        }

        @Override // org.joda.time.format.InternalParser
        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            InternalParser[] internalParserArr = this.f16048b;
            if (internalParserArr == null) {
                throw new UnsupportedOperationException();
            }
            int length = internalParserArr.length;
            for (int i2 = 0; i2 < length && i >= 0; i2++) {
                i = internalParserArr[i2].parseInto(dateTimeParserBucket, charSequence, i);
            }
            return i;
        }

        /* JADX INFO: renamed from: a */
        boolean m16849a() {
            return this.f16047a != null;
        }

        /* JADX INFO: renamed from: b */
        boolean m16850b() {
            return this.f16048b != null;
        }

        /* JADX INFO: renamed from: a */
        private void m16847a(List<Object> list, List<Object> list2, List<Object> list3) {
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                Object obj = list.get(i);
                if (obj instanceof Composite) {
                    m16848a(list2, ((Composite) obj).f16047a);
                } else {
                    list2.add(obj);
                }
                Object obj2 = list.get(i + 1);
                if (obj2 instanceof Composite) {
                    m16848a(list3, ((Composite) obj2).f16048b);
                } else {
                    list3.add(obj2);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m16848a(List<Object> list, Object[] objArr) {
            if (objArr != null) {
                for (Object obj : objArr) {
                    list.add(obj);
                }
            }
        }
    }

    static class MatchingParser implements InternalParser {

        /* JADX INFO: renamed from: a */
        private final InternalParser[] f16054a;

        /* JADX INFO: renamed from: b */
        private final int f16055b;

        MatchingParser(InternalParser[] internalParserArr) {
            int iEstimateParsedLength;
            this.f16054a = internalParserArr;
            int i = 0;
            int length = internalParserArr.length;
            while (true) {
                int i2 = length - 1;
                if (i2 >= 0) {
                    InternalParser internalParser = internalParserArr[i2];
                    if (internalParser == null || (iEstimateParsedLength = internalParser.estimateParsedLength()) <= i) {
                        iEstimateParsedLength = i;
                    }
                    i = iEstimateParsedLength;
                    length = i2;
                } else {
                    this.f16055b = i;
                    return;
                }
            }
        }

        @Override // org.joda.time.format.InternalParser
        public int estimateParsedLength() {
            return this.f16055b;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
        
            if (r4 != r13) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
        
            if (r1 == false) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
        
            if (r2 == null) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
        
            r11.m16881a(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
        
            return r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
        
            return r0 ^ (-1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
        
            if (r4 > r13) goto L12;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0058  */
        @Override // org.joda.time.format.InternalParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int parseInto(org.joda.time.format.DateTimeParserBucket r11, java.lang.CharSequence r12, int r13) {
            /*
                r10 = this;
                r5 = 0
                org.joda.time.format.InternalParser[] r7 = r10.f16054a
                int r8 = r7.length
                java.lang.Object r9 = r11.m16886f()
                r2 = 0
                r6 = r5
                r0 = r13
                r4 = r13
            Lc:
                if (r6 >= r8) goto L5b
                r1 = r7[r6]
                if (r1 != 0) goto L23
                if (r4 > r13) goto L15
            L14:
                return r13
            L15:
                r1 = 1
            L16:
                if (r4 > r13) goto L1c
                if (r4 != r13) goto L55
                if (r1 == 0) goto L55
            L1c:
                if (r2 == 0) goto L21
                r11.m16881a(r2)
            L21:
                r13 = r4
                goto L14
            L23:
                int r3 = r1.parseInto(r11, r12, r13)
                if (r3 < r13) goto L4b
                if (r3 <= r4) goto L58
                int r1 = r12.length()
                if (r3 >= r1) goto L3b
                int r1 = r6 + 1
                if (r1 >= r8) goto L3b
                int r1 = r6 + 1
                r1 = r7[r1]
                if (r1 != 0) goto L3d
            L3b:
                r13 = r3
                goto L14
            L3d:
                java.lang.Object r1 = r11.m16886f()
                r2 = r3
            L42:
                r11.m16881a(r9)
                int r3 = r6 + 1
                r6 = r3
                r4 = r2
                r2 = r1
                goto Lc
            L4b:
                if (r3 >= 0) goto L58
                r1 = r3 ^ (-1)
                if (r1 <= r0) goto L58
                r0 = r1
                r1 = r2
                r2 = r4
                goto L42
            L55:
                r13 = r0 ^ (-1)
                goto L14
            L58:
                r1 = r2
                r2 = r4
                goto L42
            L5b:
                r1 = r5
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormatterBuilder.MatchingParser.parseInto(org.joda.time.format.DateTimeParserBucket, java.lang.CharSequence, int):int");
        }
    }

    /* JADX INFO: renamed from: a */
    static boolean m16796a(CharSequence charSequence, int i, String str) {
        int length = str.length();
        if (charSequence.length() - i < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (charSequence.charAt(i + i2) != str.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    static boolean m16797b(CharSequence charSequence, int i, String str) {
        char upperCase;
        char upperCase2;
        int length = str.length();
        if (charSequence.length() - i < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = charSequence.charAt(i + i2);
            char cCharAt2 = str.charAt(i2);
            if (cCharAt != cCharAt2 && (upperCase = Character.toUpperCase(cCharAt)) != (upperCase2 = Character.toUpperCase(cCharAt2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return false;
            }
        }
        return true;
    }
}
