package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.Util;
import okio.ByteString;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes2.dex */
public final class Http2 {

    /* JADX INFO: renamed from: a */
    static final ByteString f15438a = ByteString.m16317a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: renamed from: d */
    private static final String[] f15441d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: b */
    static final String[] f15439b = new String[64];

    /* JADX INFO: renamed from: c */
    static final String[] f15440c = new String[256];

    static {
        for (int i = 0; i < f15440c.length; i++) {
            f15440c[i] = Util.m15836a("%8s", Integer.toBinaryString(i)).replace(TokenParser.f15715SP, '0');
        }
        f15439b[0] = "";
        f15439b[1] = "END_STREAM";
        int[] iArr = {1};
        f15439b[8] = "PADDED";
        for (int i2 : iArr) {
            f15439b[i2 | 8] = f15439b[i2] + "|PADDED";
        }
        f15439b[4] = "END_HEADERS";
        f15439b[32] = "PRIORITY";
        f15439b[36] = "END_HEADERS|PRIORITY";
        for (int i3 : new int[]{4, 32, 36}) {
            for (int i4 : iArr) {
                f15439b[i4 | i3] = f15439b[i4] + '|' + f15439b[i3];
                f15439b[i4 | i3 | 8] = f15439b[i4] + '|' + f15439b[i3] + "|PADDED";
            }
        }
        for (int i5 = 0; i5 < f15439b.length; i5++) {
            if (f15439b[i5] == null) {
                f15439b[i5] = f15440c[i5];
            }
        }
    }

    private Http2() {
    }

    /* JADX INFO: renamed from: a */
    static IllegalArgumentException m16042a(String str, Object... objArr) {
        throw new IllegalArgumentException(Util.m15836a(str, objArr));
    }

    /* JADX INFO: renamed from: b */
    static IOException m16045b(String str, Object... objArr) throws IOException {
        throw new IOException(Util.m15836a(str, objArr));
    }

    /* JADX INFO: renamed from: a */
    static String m16044a(boolean z, int i, int i2, byte b, byte b2) {
        String strM15836a = b < f15441d.length ? f15441d[b] : Util.m15836a("0x%02x", Byte.valueOf(b));
        String strM16043a = m16043a(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = strM15836a;
        objArr[4] = strM16043a;
        return Util.m15836a("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* JADX INFO: renamed from: a */
    static String m16043a(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        switch (b) {
            case 2:
            case 3:
            case 7:
            case 8:
                return f15440c[b2];
            case 4:
            case 6:
                return b2 == 1 ? "ACK" : f15440c[b2];
            case 5:
            default:
                String str = b2 < f15439b.length ? f15439b[b2] : f15440c[b2];
                if (b == 5 && (b2 & 4) != 0) {
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
                if (b == 0 && (b2 & 32) != 0) {
                    return str.replace("PRIORITY", "COMPRESSED");
                }
                return str;
        }
    }
}
