package org.joda.time.format;

/* JADX INFO: loaded from: classes2.dex */
class InternalParserDateTimeParser implements DateTimeParser, InternalParser {

    /* JADX INFO: renamed from: a */
    private final InternalParser f16158a;

    /* JADX INFO: renamed from: a */
    static DateTimeParser m16976a(InternalParser internalParser) {
        if (internalParser instanceof DateTimeParserInternalParser) {
            return ((DateTimeParserInternalParser) internalParser).m16893a();
        }
        if (internalParser instanceof DateTimeParser) {
            return (DateTimeParser) internalParser;
        }
        if (internalParser == null) {
            return null;
        }
        return new InternalParserDateTimeParser(internalParser);
    }

    private InternalParserDateTimeParser(InternalParser internalParser) {
        this.f16158a = internalParser;
    }

    @Override // org.joda.time.format.DateTimeParser, org.joda.time.format.InternalParser
    public int estimateParsedLength() {
        return this.f16158a.estimateParsedLength();
    }

    @Override // org.joda.time.format.InternalParser
    public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
        return this.f16158a.parseInto(dateTimeParserBucket, charSequence, i);
    }

    @Override // org.joda.time.format.DateTimeParser
    /* JADX INFO: renamed from: a */
    public int mo16859a(DateTimeParserBucket dateTimeParserBucket, String str, int i) {
        return this.f16158a.parseInto(dateTimeParserBucket, str, i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InternalParserDateTimeParser) {
            return this.f16158a.equals(((InternalParserDateTimeParser) obj).f16158a);
        }
        return false;
    }
}
