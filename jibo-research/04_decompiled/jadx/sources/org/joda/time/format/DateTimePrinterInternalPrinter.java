package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;

/* JADX INFO: loaded from: classes2.dex */
class DateTimePrinterInternalPrinter implements InternalPrinter {

    /* JADX INFO: renamed from: a */
    private final DateTimePrinter f16097a;

    /* JADX INFO: renamed from: a */
    static InternalPrinter m16898a(DateTimePrinter dateTimePrinter) {
        if (dateTimePrinter instanceof InternalPrinterDateTimePrinter) {
            return (InternalPrinter) dateTimePrinter;
        }
        if (dateTimePrinter == null) {
            return null;
        }
        return new DateTimePrinterInternalPrinter(dateTimePrinter);
    }

    private DateTimePrinterInternalPrinter(DateTimePrinter dateTimePrinter) {
        this.f16097a = dateTimePrinter;
    }

    @Override // org.joda.time.format.InternalPrinter
    public int estimatePrintedLength() {
        return this.f16097a.estimatePrintedLength();
    }

    @Override // org.joda.time.format.InternalPrinter
    public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
        if (appendable instanceof StringBuffer) {
            this.f16097a.mo16896a((StringBuffer) appendable, j, chronology, i, dateTimeZone, locale);
        } else if (appendable instanceof Writer) {
            this.f16097a.mo16894a((Writer) appendable, j, chronology, i, dateTimeZone, locale);
        } else {
            StringBuffer stringBuffer = new StringBuffer(estimatePrintedLength());
            this.f16097a.mo16896a(stringBuffer, j, chronology, i, dateTimeZone, locale);
            appendable.append(stringBuffer);
        }
    }

    @Override // org.joda.time.format.InternalPrinter
    public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
        if (appendable instanceof StringBuffer) {
            this.f16097a.mo16897a((StringBuffer) appendable, readablePartial, locale);
        } else if (appendable instanceof Writer) {
            this.f16097a.mo16895a((Writer) appendable, readablePartial, locale);
        } else {
            StringBuffer stringBuffer = new StringBuffer(estimatePrintedLength());
            this.f16097a.mo16897a(stringBuffer, readablePartial, locale);
            appendable.append(stringBuffer);
        }
    }
}
