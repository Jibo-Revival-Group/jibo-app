package okhttp3.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public final class Util {

    /* JADX INFO: renamed from: a */
    public static final byte[] f15237a = new byte[0];

    /* JADX INFO: renamed from: b */
    public static final String[] f15238b = new String[0];

    /* JADX INFO: renamed from: c */
    public static final ResponseBody f15239c = ResponseBody.m15822a(null, f15237a);

    /* JADX INFO: renamed from: d */
    public static final RequestBody f15240d = RequestBody.m15787a((MediaType) null, f15237a);

    /* JADX INFO: renamed from: h */
    private static final ByteString f15244h = ByteString.m16320c("efbbbf");

    /* JADX INFO: renamed from: i */
    private static final ByteString f15245i = ByteString.m16320c("feff");

    /* JADX INFO: renamed from: j */
    private static final ByteString f15246j = ByteString.m16320c("fffe");

    /* JADX INFO: renamed from: k */
    private static final ByteString f15247k = ByteString.m16320c("0000ffff");

    /* JADX INFO: renamed from: l */
    private static final ByteString f15248l = ByteString.m16320c("ffff0000");

    /* JADX INFO: renamed from: e */
    public static final Charset f15241e = Charset.forName(HTTP.UTF_8);

    /* JADX INFO: renamed from: m */
    private static final Charset f15249m = Charset.forName("UTF-16BE");

    /* JADX INFO: renamed from: n */
    private static final Charset f15250n = Charset.forName("UTF-16LE");

    /* JADX INFO: renamed from: o */
    private static final Charset f15251o = Charset.forName("UTF-32BE");

    /* JADX INFO: renamed from: p */
    private static final Charset f15252p = Charset.forName("UTF-32LE");

    /* JADX INFO: renamed from: f */
    public static final TimeZone f15242f = TimeZone.getTimeZone("GMT");

    /* JADX INFO: renamed from: g */
    public static final Comparator<String> f15243g = new Comparator<String>() { // from class: okhttp3.internal.Util.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };

    /* JADX INFO: renamed from: q */
    private static final Pattern f15253q = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* JADX INFO: renamed from: a */
    public static void m15842a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m15846a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: renamed from: a */
    public static void m15843a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m15844a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m15845a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m15847a(Source source, int i, TimeUnit timeUnit) {
        try {
            return m15853b(source, i, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m15853b(Source source, int i, TimeUnit timeUnit) throws IOException {
        long jNanoTime = System.nanoTime();
        long jMo16344d = source.mo15864a().mo16348y_() ? source.mo15864a().mo16344d() - jNanoTime : Long.MAX_VALUE;
        source.mo15864a().mo16342a(Math.min(jMo16344d, timeUnit.toNanos(i)) + jNanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.mo15863a(buffer, 8192L) != -1) {
                buffer.m16310u();
            }
            if (jMo16344d == Long.MAX_VALUE) {
                source.mo15864a().mo16345f();
            } else {
                source.mo15864a().mo16342a(jMo16344d + jNanoTime);
            }
            return true;
        } catch (InterruptedIOException e) {
            if (jMo16344d == Long.MAX_VALUE) {
                source.mo15864a().mo16345f();
            } else {
                source.mo15864a().mo16342a(jMo16344d + jNanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (jMo16344d == Long.MAX_VALUE) {
                source.mo15864a().mo16345f();
            } else {
                source.mo15864a().mo16342a(jMo16344d + jNanoTime);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public static <T> List<T> m15839a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* JADX INFO: renamed from: a */
    public static <T> List<T> m15840a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* JADX INFO: renamed from: a */
    public static ThreadFactory m15841a(final String str, final boolean z) {
        return new ThreadFactory() { // from class: okhttp3.internal.Util.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    /* JADX INFO: renamed from: a */
    public static String[] m15848a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) != 0) {
                    i++;
                } else {
                    arrayList.add(str);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m15852b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static String m15837a(HttpUrl httpUrl, boolean z) {
        String strM15654g;
        if (httpUrl.m15654g().contains(":")) {
            strM15654g = "[" + httpUrl.m15654g() + "]";
        } else {
            strM15654g = httpUrl.m15654g();
        }
        if (!z && httpUrl.m15655h() == HttpUrl.m15632a(httpUrl.m15648c())) {
            return strM15654g;
        }
        return strM15654g + ":" + httpUrl.m15655h();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m15845a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public static int m15834a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public static String[] m15849a(String[] strArr, String str) {
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    /* JADX INFO: renamed from: a */
    public static int m15831a(String str, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    break;
                default:
                    return i3;
            }
        }
        return i2;
    }

    /* JADX INFO: renamed from: b */
    public static int m15851b(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    break;
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: c */
    public static String m15854c(String str, int i, int i2) {
        int iM15831a = m15831a(str, i, i2);
        return str.substring(iM15831a, m15851b(str, iM15831a, i2));
    }

    /* JADX INFO: renamed from: a */
    public static int m15833a(String str, int i, int i2, String str2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public static int m15832a(String str, int i, int i2, char c) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) == c) {
                return i3;
            }
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public static String m15835a(String str) {
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (m15856d(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    private static boolean m15856d(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return true;
            }
            if (" #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static int m15850b(String str) {
        int i = 0;
        int length = str.length();
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt > 31 && cCharAt < 127) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m15855c(String str) {
        return f15253q.matcher(str).matches();
    }

    /* JADX INFO: renamed from: a */
    public static String m15836a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* JADX INFO: renamed from: a */
    public static Charset m15838a(BufferedSource bufferedSource, Charset charset) throws IOException {
        if (bufferedSource.mo16261a(0L, f15244h)) {
            bufferedSource.mo16292i(f15244h.mo16336h());
            return f15241e;
        }
        if (bufferedSource.mo16261a(0L, f15245i)) {
            bufferedSource.mo16292i(f15245i.mo16336h());
            return f15249m;
        }
        if (bufferedSource.mo16261a(0L, f15246j)) {
            bufferedSource.mo16292i(f15246j.mo16336h());
            return f15250n;
        }
        if (bufferedSource.mo16261a(0L, f15247k)) {
            bufferedSource.mo16292i(f15247k.mo16336h());
            return f15251o;
        }
        if (bufferedSource.mo16261a(0L, f15248l)) {
            bufferedSource.mo16292i(f15248l.mo16336h());
            return f15252p;
        }
        return charset;
    }
}
