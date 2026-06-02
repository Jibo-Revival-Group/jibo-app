package org.joda.time;

import org.joda.time.format.DateTimeFormat;

/* JADX INFO: loaded from: classes2.dex */
public class IllegalInstantException extends IllegalArgumentException {
    public IllegalInstantException(String str) {
        super(str);
    }

    public IllegalInstantException(long j, String str) {
        super(m16578a(j, str));
    }

    /* JADX INFO: renamed from: a */
    private static String m16578a(long j, String str) {
        return "Illegal instant due to time zone offset transition (daylight savings time 'gap'): " + DateTimeFormat.m16769a("yyyy-MM-dd'T'HH:mm:ss.SSS").m16778a(new Instant(j)) + (str != null ? " (" + str + ")" : "");
    }
}
