package com.google.api.client.util;

import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public final class Charsets {
    public static final Charset UTF_8 = Charset.forName(HTTP.UTF_8);
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    private Charsets() {
    }
}
