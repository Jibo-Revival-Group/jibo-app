package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;

/* JADX INFO: loaded from: classes2.dex */
public interface DateTimePrinter {
    /* JADX INFO: renamed from: a */
    void mo16894a(Writer writer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException;

    /* JADX INFO: renamed from: a */
    void mo16895a(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException;

    /* JADX INFO: renamed from: a */
    void mo16896a(StringBuffer stringBuffer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale);

    /* JADX INFO: renamed from: a */
    void mo16897a(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale);

    int estimatePrintedLength();
}
