package okio;

import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
final class Util {

    /* JADX INFO: renamed from: a */
    public static final Charset f15699a = Charset.forName(HTTP.UTF_8);

    /* JADX INFO: renamed from: a */
    public static void m16387a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    /* JADX INFO: renamed from: a */
    public static short m16386a(short s) {
        int i = 65535 & s;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    /* JADX INFO: renamed from: a */
    public static int m16385a(int i) {
        return (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8) | ((i & 255) << 24);
    }

    /* JADX INFO: renamed from: a */
    public static void m16388a(Throwable th) throws Throwable {
        m16390b(th);
    }

    /* JADX INFO: renamed from: b */
    private static <T extends Throwable> void m16390b(Throwable th) throws Throwable {
        throw th;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m16389a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
