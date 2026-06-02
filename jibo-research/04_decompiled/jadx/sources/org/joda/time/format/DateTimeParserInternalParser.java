package org.joda.time.format;

/* JADX INFO: loaded from: classes2.dex */
class DateTimeParserInternalParser implements InternalParser {

    /* JADX INFO: renamed from: a */
    private final DateTimeParser f16096a;

    /* JADX INFO: renamed from: a */
    static InternalParser m16892a(DateTimeParser dateTimeParser) {
        if (dateTimeParser instanceof InternalParserDateTimeParser) {
            return (InternalParser) dateTimeParser;
        }
        if (dateTimeParser == null) {
            return null;
        }
        return new DateTimeParserInternalParser(dateTimeParser);
    }

    private DateTimeParserInternalParser(DateTimeParser dateTimeParser) {
        this.f16096a = dateTimeParser;
    }

    /* JADX INFO: renamed from: a */
    DateTimeParser m16893a() {
        return this.f16096a;
    }

    @Override // org.joda.time.format.InternalParser
    public int estimateParsedLength() {
        return this.f16096a.estimateParsedLength();
    }

    @Override // org.joda.time.format.InternalParser
    public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
        return this.f16096a.mo16859a(dateTimeParserBucket, charSequence.toString(), i);
    }
}
