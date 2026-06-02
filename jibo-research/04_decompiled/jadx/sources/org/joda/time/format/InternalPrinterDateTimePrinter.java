package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;

/* JADX INFO: loaded from: classes2.dex */
class InternalPrinterDateTimePrinter implements DateTimePrinter, InternalPrinter {

    /* JADX INFO: renamed from: a */
    private final InternalPrinter f16159a;

    @Override // org.joda.time.format.DateTimePrinter, org.joda.time.format.InternalPrinter
    public int estimatePrintedLength() {
        return this.f16159a.estimatePrintedLength();
    }

    @Override // org.joda.time.format.DateTimePrinter
    /* JADX INFO: renamed from: a */
    public void mo16896a(StringBuffer stringBuffer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) {
        try {
            this.f16159a.printTo(stringBuffer, j, chronology, i, dateTimeZone, locale);
        } catch (IOException e) {
        }
    }

    @Override // org.joda.time.format.DateTimePrinter
    /* JADX INFO: renamed from: a */
    public void mo16894a(Writer writer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
        this.f16159a.printTo(writer, j, chronology, i, dateTimeZone, locale);
    }

    @Override // org.joda.time.format.InternalPrinter
    public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
        this.f16159a.printTo(appendable, j, chronology, i, dateTimeZone, locale);
    }

    @Override // org.joda.time.format.DateTimePrinter
    /* JADX INFO: renamed from: a */
    public void mo16897a(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale) {
        try {
            this.f16159a.printTo(stringBuffer, readablePartial, locale);
        } catch (IOException e) {
        }
    }

    @Override // org.joda.time.format.DateTimePrinter
    /* JADX INFO: renamed from: a */
    public void mo16895a(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException {
        this.f16159a.printTo(writer, readablePartial, locale);
    }

    @Override // org.joda.time.format.InternalPrinter
    public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
        this.f16159a.printTo(appendable, readablePartial, locale);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InternalPrinterDateTimePrinter) {
            return this.f16159a.equals(((InternalPrinterDateTimePrinter) obj).f16159a);
        }
        return false;
    }
}
