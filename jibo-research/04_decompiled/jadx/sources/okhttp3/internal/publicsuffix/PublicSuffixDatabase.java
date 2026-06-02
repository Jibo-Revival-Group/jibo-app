package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InputStream;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

/* JADX INFO: loaded from: classes2.dex */
public final class PublicSuffixDatabase {

    /* JADX INFO: renamed from: a */
    private static final byte[] f15605a = {42};

    /* JADX INFO: renamed from: b */
    private static final String[] f15606b = new String[0];

    /* JADX INFO: renamed from: c */
    private static final String[] f15607c = {"*"};

    /* JADX INFO: renamed from: d */
    private static final PublicSuffixDatabase f15608d = new PublicSuffixDatabase();

    /* JADX INFO: renamed from: e */
    private final AtomicBoolean f15609e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f */
    private final CountDownLatch f15610f = new CountDownLatch(1);

    /* JADX INFO: renamed from: g */
    private byte[] f15611g;

    /* JADX INFO: renamed from: h */
    private byte[] f15612h;

    /* JADX INFO: renamed from: a */
    public static PublicSuffixDatabase m16207a() {
        return f15608d;
    }

    /* JADX INFO: renamed from: a */
    public String m16210a(String str) {
        int length;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrM16208a = m16208a(strArrSplit);
        if (strArrSplit.length == strArrM16208a.length && strArrM16208a[0].charAt(0) != '!') {
            return null;
        }
        if (strArrM16208a[0].charAt(0) == '!') {
            length = strArrSplit.length - strArrM16208a.length;
        } else {
            length = strArrSplit.length - (strArrM16208a.length + 1);
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        while (length < strArrSplit2.length) {
            sb.append(strArrSplit2[length]).append('.');
            length++;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private String[] m16208a(String[] strArr) {
        String strM16206a;
        String str;
        String[] strArrSplit;
        String[] strArrSplit2;
        String str2 = null;
        int i = 0;
        if (!this.f15609e.get() && this.f15609e.compareAndSet(false, true)) {
            m16209b();
        } else {
            try {
                this.f15610f.await();
            } catch (InterruptedException e) {
            }
        }
        synchronized (this) {
            if (this.f15611g == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length][];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(Util.f15241e);
        }
        int i3 = 0;
        while (true) {
            if (i3 >= bArr.length) {
                strM16206a = null;
                break;
            }
            strM16206a = m16206a(this.f15611g, bArr, i3);
            if (strM16206a != null) {
                break;
            }
            i3++;
        }
        if (bArr.length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = f15605a;
                String strM16206a2 = m16206a(this.f15611g, bArr2, i4);
                if (strM16206a2 != null) {
                    str = strM16206a2;
                    break;
                }
            }
            str = null;
        } else {
            str = null;
        }
        if (str != null) {
            while (true) {
                if (i >= bArr.length - 1) {
                    break;
                }
                String strM16206a3 = m16206a(this.f15612h, bArr, i);
                if (strM16206a3 != null) {
                    str2 = strM16206a3;
                    break;
                }
                i++;
            }
        }
        if (str2 != null) {
            return ("!" + str2).split("\\.");
        }
        if (strM16206a == null && str == null) {
            return f15607c;
        }
        if (strM16206a != null) {
            strArrSplit = strM16206a.split("\\.");
        } else {
            strArrSplit = f15606b;
        }
        if (str != null) {
            strArrSplit2 = str.split("\\.");
        } else {
            strArrSplit2 = f15606b;
        }
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    /* JADX INFO: renamed from: a */
    private static String m16206a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        int length = bArr.length;
        while (i8 < length) {
            int i9 = (i8 + length) / 2;
            while (i9 > -1 && bArr[i9] != 10) {
                i9--;
            }
            int i10 = i9 + 1;
            int i11 = 1;
            while (bArr[i10 + i11] != 10) {
                i11++;
            }
            int i12 = (i10 + i11) - i10;
            int i13 = 0;
            int i14 = 0;
            boolean z = false;
            int i15 = i;
            while (true) {
                if (z) {
                    i2 = 46;
                    z = false;
                } else {
                    i2 = bArr2[i15][i13] & 255;
                }
                i3 = i2 - (bArr[i10 + i14] & 255);
                if (i3 != 0) {
                    i4 = i14;
                    i5 = i13;
                    break;
                }
                i14++;
                int i16 = i13 + 1;
                if (i14 == i12) {
                    i5 = i16;
                    i4 = i14;
                    break;
                }
                if (bArr2[i15].length == i16) {
                    if (i15 == bArr2.length - 1) {
                        i5 = i16;
                        i4 = i14;
                        break;
                    }
                    i15++;
                    i16 = -1;
                    z = true;
                }
                i13 = i16;
            }
            if (i3 < 0) {
                i7 = i10 - 1;
                i6 = i8;
            } else if (i3 > 0) {
                i6 = i11 + i10 + 1;
                i7 = length;
            } else {
                int i17 = i12 - i4;
                int length2 = bArr2[i15].length - i5;
                for (int i18 = i15 + 1; i18 < bArr2.length; i18++) {
                    length2 += bArr2[i18].length;
                }
                if (length2 < i17) {
                    i7 = i10 - 1;
                    i6 = i8;
                } else if (length2 > i17) {
                    i6 = i11 + i10 + 1;
                    i7 = length;
                } else {
                    return new String(bArr, i10, i12, Util.f15241e);
                }
            }
            length = i7;
            i8 = i6;
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    private void m16209b() {
        byte[] bArr;
        byte[] bArr2 = null;
        InputStream resourceAsStream = PublicSuffixDatabase.class.getClassLoader().getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            BufferedSource bufferedSourceM16360a = Okio.m16360a(new GzipSource(Okio.m16366a(resourceAsStream)));
            try {
                try {
                    byte[] bArr3 = new byte[bufferedSourceM16360a.mo16296k()];
                    bufferedSourceM16360a.mo16260a(bArr3);
                    bArr = new byte[bufferedSourceM16360a.mo16296k()];
                    bufferedSourceM16360a.mo16260a(bArr);
                    Util.m15843a(bufferedSourceM16360a);
                    bArr2 = bArr3;
                } catch (IOException e) {
                    Platform.m16203b().mo16181a(5, "Failed to read public suffix list", e);
                    Util.m15843a(bufferedSourceM16360a);
                    bArr = null;
                }
            } catch (Throwable th) {
                Util.m15843a(bufferedSourceM16360a);
                throw th;
            }
        } else {
            bArr = null;
        }
        synchronized (this) {
            this.f15611g = bArr2;
            this.f15612h = bArr;
        }
        this.f15610f.countDown();
    }
}
