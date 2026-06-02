package org.apache.http;

import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public final class Consts {

    /* JADX INFO: renamed from: CR */
    public static final int f15700CR = 13;

    /* JADX INFO: renamed from: HT */
    public static final int f15701HT = 9;

    /* JADX INFO: renamed from: LF */
    public static final int f15702LF = 10;

    /* JADX INFO: renamed from: SP */
    public static final int f15703SP = 32;
    public static final Charset UTF_8 = Charset.forName(HTTP.UTF_8);
    public static final Charset ASCII = Charset.forName("US-ASCII");
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    private Consts() {
    }
}
