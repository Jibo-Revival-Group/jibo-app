package okhttp3;

import java.nio.charset.Charset;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class Credentials {
    /* JADX INFO: renamed from: a */
    public static String m15588a(String str, String str2) {
        return m15589a(str, str2, Charset.forName("ISO-8859-1"));
    }

    /* JADX INFO: renamed from: a */
    public static String m15589a(String str, String str2, Charset charset) {
        return "Basic " + ByteString.m16318a((str + ":" + str2).getBytes(charset)).mo16330b();
    }
}
