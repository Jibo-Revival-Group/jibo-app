package io.fabric.sdk.android.services.network;

import com.facebook.internal.Utility;
import com.google.api.client.http.HttpMethods;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;
import org.apache.http.entity.mime.MIME;
import org.apache.http.message.TokenParser;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public class HttpRequest {

    /* JADX INFO: renamed from: b */
    private static final String[] f14688b = new String[0];

    /* JADX INFO: renamed from: c */
    private static ConnectionFactory f14689c = ConnectionFactory.f14705a;

    /* JADX INFO: renamed from: a */
    public final URL f14690a;

    /* JADX INFO: renamed from: e */
    private final String f14692e;

    /* JADX INFO: renamed from: f */
    private RequestOutputStream f14693f;

    /* JADX INFO: renamed from: g */
    private boolean f14694g;

    /* JADX INFO: renamed from: k */
    private String f14698k;

    /* JADX INFO: renamed from: l */
    private int f14699l;

    /* JADX INFO: renamed from: d */
    private HttpURLConnection f14691d = null;

    /* JADX INFO: renamed from: h */
    private boolean f14695h = true;

    /* JADX INFO: renamed from: i */
    private boolean f14696i = false;

    /* JADX INFO: renamed from: j */
    private int f14697j = Utility.DEFAULT_STREAM_BUFFER_SIZE;

    public interface ConnectionFactory {

        /* JADX INFO: renamed from: a */
        public static final ConnectionFactory f14705a = new ConnectionFactory() { // from class: io.fabric.sdk.android.services.network.HttpRequest.ConnectionFactory.1
            @Override // io.fabric.sdk.android.services.network.HttpRequest.ConnectionFactory
            /* JADX INFO: renamed from: a */
            public HttpURLConnection mo15404a(URL url) throws IOException {
                return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            }

            @Override // io.fabric.sdk.android.services.network.HttpRequest.ConnectionFactory
            /* JADX INFO: renamed from: a */
            public HttpURLConnection mo15405a(URL url, Proxy proxy) throws IOException {
                return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection(proxy)));
            }
        };

        /* JADX INFO: renamed from: a */
        HttpURLConnection mo15404a(URL url) throws IOException;

        /* JADX INFO: renamed from: a */
        HttpURLConnection mo15405a(URL url, Proxy proxy) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public static String m15359f(String str) {
        return (str == null || str.length() <= 0) ? HTTP.UTF_8 : str;
    }

    /* JADX INFO: renamed from: a */
    private static StringBuilder m15351a(String str, StringBuilder sb) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            sb.append('/');
        }
        return sb;
    }

    /* JADX INFO: renamed from: b */
    private static StringBuilder m15354b(String str, StringBuilder sb) {
        int iIndexOf = str.indexOf(63);
        int length = sb.length() - 1;
        if (iIndexOf == -1) {
            sb.append('?');
        } else if (iIndexOf < length && str.charAt(length) != '&') {
            sb.append('&');
        }
        return sb;
    }

    public static class HttpRequestException extends RuntimeException {
        protected HttpRequestException(IOException iOException) {
            super(iOException);
        }

        @Override // java.lang.Throwable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    protected static abstract class Operation<V> implements Callable<V> {
        /* JADX INFO: renamed from: b */
        protected abstract V mo15402b() throws HttpRequestException, IOException;

        /* JADX INFO: renamed from: c */
        protected abstract void mo15403c() throws IOException;

        protected Operation() {
        }

        @Override // java.util.concurrent.Callable
        public V call() throws Throwable {
            boolean z = true;
            try {
                try {
                    try {
                        V vMo15402b = mo15402b();
                        try {
                            mo15403c();
                            return vMo15402b;
                        } catch (IOException e) {
                            throw new HttpRequestException(e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            mo15403c();
                        } catch (IOException e2) {
                            if (!z) {
                                throw new HttpRequestException(e2);
                            }
                        }
                        throw th;
                    }
                } catch (HttpRequestException e3) {
                    throw e3;
                }
            } catch (IOException e4) {
                throw new HttpRequestException(e4);
            } catch (Throwable th2) {
                th = th2;
                z = false;
                mo15403c();
                throw th;
            }
        }
    }

    protected static abstract class CloseOperation<V> extends Operation<V> {

        /* JADX INFO: renamed from: a */
        private final Closeable f14703a;

        /* JADX INFO: renamed from: b */
        private final boolean f14704b;

        protected CloseOperation(Closeable closeable, boolean z) {
            this.f14703a = closeable;
            this.f14704b = z;
        }

        @Override // io.fabric.sdk.android.services.network.HttpRequest.Operation
        /* JADX INFO: renamed from: c */
        protected void mo15403c() throws IOException {
            if (this.f14703a instanceof Flushable) {
                ((Flushable) this.f14703a).flush();
            }
            if (this.f14704b) {
                try {
                    this.f14703a.close();
                } catch (IOException e) {
                }
            } else {
                this.f14703a.close();
            }
        }
    }

    public static class RequestOutputStream extends BufferedOutputStream {

        /* JADX INFO: renamed from: a */
        private final CharsetEncoder f14706a;

        public RequestOutputStream(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f14706a = Charset.forName(HttpRequest.m15359f(str)).newEncoder();
        }

        /* JADX INFO: renamed from: a */
        public RequestOutputStream m15407a(String str) throws IOException {
            ByteBuffer byteBufferEncode = this.f14706a.encode(CharBuffer.wrap(str));
            super.write(byteBufferEncode.array(), 0, byteBufferEncode.limit());
            return this;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m15349a(CharSequence charSequence) throws HttpRequestException {
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String aSCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int iIndexOf = aSCIIString.indexOf(63);
                if (iIndexOf > 0 && iIndexOf + 1 < aSCIIString.length()) {
                    return aSCIIString.substring(0, iIndexOf + 1) + aSCIIString.substring(iIndexOf + 1).replace("+", "%2B");
                }
                return aSCIIString;
            } catch (URISyntaxException e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m15350a(CharSequence charSequence, Map<?, ?> map) {
        String string = charSequence.toString();
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder(string);
            m15351a(string, sb);
            m15354b(string, sb);
            Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
            Map.Entry<?, ?> next = it.next();
            sb.append(next.getKey().toString());
            sb.append('=');
            Object value = next.getValue();
            if (value != null) {
                sb.append(value);
            }
            while (it.hasNext()) {
                sb.append('&');
                Map.Entry<?, ?> next2 = it.next();
                sb.append(next2.getKey().toString());
                sb.append('=');
                Object value2 = next2.getValue();
                if (value2 != null) {
                    sb.append(value2);
                }
            }
            return sb.toString();
        }
        return string;
    }

    /* JADX INFO: renamed from: b */
    public static HttpRequest m15352b(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, HttpMethods.GET);
    }

    /* JADX INFO: renamed from: a */
    public static HttpRequest m15348a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String strM15350a = m15350a(charSequence, map);
        if (z) {
            strM15350a = m15349a((CharSequence) strM15350a);
        }
        return m15352b((CharSequence) strM15350a);
    }

    /* JADX INFO: renamed from: c */
    public static HttpRequest m15355c(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, HttpMethods.POST);
    }

    /* JADX INFO: renamed from: b */
    public static HttpRequest m15353b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String strM15350a = m15350a(charSequence, map);
        if (z) {
            strM15350a = m15349a((CharSequence) strM15350a);
        }
        return m15355c((CharSequence) strM15350a);
    }

    /* JADX INFO: renamed from: d */
    public static HttpRequest m15356d(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, HttpMethods.PUT);
    }

    /* JADX INFO: renamed from: e */
    public static HttpRequest m15357e(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, HttpMethods.DELETE);
    }

    public HttpRequest(CharSequence charSequence, String str) throws HttpRequestException {
        try {
            this.f14690a = new URL(charSequence.toString());
            this.f14692e = str;
        } catch (MalformedURLException e) {
            throw new HttpRequestException(e);
        }
    }

    /* JADX INFO: renamed from: q */
    private Proxy m15360q() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.f14698k, this.f14699l));
    }

    /* JADX INFO: renamed from: r */
    private HttpURLConnection m15361r() {
        HttpURLConnection httpURLConnectionMo15404a;
        try {
            if (this.f14698k != null) {
                httpURLConnectionMo15404a = f14689c.mo15405a(this.f14690a, m15360q());
            } else {
                httpURLConnectionMo15404a = f14689c.mo15404a(this.f14690a);
            }
            httpURLConnectionMo15404a.setRequestMethod(this.f14692e);
            return httpURLConnectionMo15404a;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String toString() {
        return m15400p() + TokenParser.f15715SP + m15399o();
    }

    /* JADX INFO: renamed from: a */
    public HttpURLConnection m15375a() {
        if (this.f14691d == null) {
            this.f14691d = m15361r();
        }
        return this.f14691d;
    }

    /* JADX INFO: renamed from: b */
    public int m15376b() throws HttpRequestException {
        try {
            m15395k();
            return m15375a().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m15382c() throws HttpRequestException {
        return 200 == m15376b();
    }

    /* JADX INFO: renamed from: d */
    protected ByteArrayOutputStream m15385d() {
        int iM15394j = m15394j();
        return iM15394j > 0 ? new ByteArrayOutputStream(iM15394j) : new ByteArrayOutputStream();
    }

    /* JADX INFO: renamed from: a */
    public String m15374a(String str) throws HttpRequestException {
        ByteArrayOutputStream byteArrayOutputStreamM15385d = m15385d();
        try {
            m15364a(m15390f(), byteArrayOutputStreamM15385d);
            return byteArrayOutputStreamM15385d.toString(m15359f(str));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* JADX INFO: renamed from: e */
    public String m15387e() throws HttpRequestException {
        return m15374a(m15392h());
    }

    /* JADX INFO: renamed from: f */
    public BufferedInputStream m15390f() throws HttpRequestException {
        return new BufferedInputStream(m15391g(), this.f14697j);
    }

    /* JADX INFO: renamed from: g */
    public InputStream m15391g() throws HttpRequestException {
        InputStream inputStream;
        if (m15376b() < 400) {
            try {
                inputStream = m15375a().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        } else {
            inputStream = m15375a().getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = m15375a().getInputStream();
                } catch (IOException e2) {
                    throw new HttpRequestException(e2);
                }
            }
        }
        if (!this.f14696i || !"gzip".equals(m15393i())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e3) {
            throw new HttpRequestException(e3);
        }
    }

    /* JADX INFO: renamed from: a */
    public HttpRequest m15363a(int i) {
        m15375a().setConnectTimeout(i);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public HttpRequest m15366a(String str, String str2) {
        m15375a().setRequestProperty(str, str2);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public HttpRequest m15372a(Map.Entry<String, String> entry) {
        return m15366a(entry.getKey(), entry.getValue());
    }

    /* JADX INFO: renamed from: b */
    public String m15378b(String str) throws HttpRequestException {
        m15396l();
        return m15375a().getHeaderField(str);
    }

    /* JADX INFO: renamed from: c */
    public int m15380c(String str) throws HttpRequestException {
        return m15362a(str, -1);
    }

    /* JADX INFO: renamed from: a */
    public int m15362a(String str, int i) throws HttpRequestException {
        m15396l();
        return m15375a().getHeaderFieldInt(str, i);
    }

    /* JADX INFO: renamed from: b */
    public String m15379b(String str, String str2) {
        return m15381c(m15378b(str), str2);
    }

    /* JADX INFO: renamed from: c */
    protected String m15381c(String str, String str2) {
        int i;
        int i2;
        String strTrim;
        int length;
        if (str == null || str.length() == 0) {
            return null;
        }
        int length2 = str.length();
        int iIndexOf = str.indexOf(59) + 1;
        if (iIndexOf == 0 || iIndexOf == length2) {
            return null;
        }
        int iIndexOf2 = str.indexOf(59, iIndexOf);
        if (iIndexOf2 == -1) {
            i = iIndexOf;
            i2 = length2;
        } else {
            i = iIndexOf;
            i2 = iIndexOf2;
        }
        while (i < i2) {
            int iIndexOf3 = str.indexOf(61, i);
            if (iIndexOf3 != -1 && iIndexOf3 < i2 && str2.equals(str.substring(i, iIndexOf3).trim()) && (length = (strTrim = str.substring(iIndexOf3 + 1, i2).trim()).length()) != 0) {
                if (length > 2 && '\"' == strTrim.charAt(0) && '\"' == strTrim.charAt(length - 1)) {
                    return strTrim.substring(1, length - 1);
                }
                return strTrim;
            }
            int i3 = i2 + 1;
            int iIndexOf4 = str.indexOf(59, i3);
            if (iIndexOf4 == -1) {
                iIndexOf4 = length2;
            }
            int i4 = iIndexOf4;
            i = i3;
            i2 = i4;
        }
        return null;
    }

    /* JADX INFO: renamed from: h */
    public String m15392h() {
        return m15379b("Content-Type", "charset");
    }

    /* JADX INFO: renamed from: a */
    public HttpRequest m15373a(boolean z) {
        m15375a().setUseCaches(z);
        return this;
    }

    /* JADX INFO: renamed from: i */
    public String m15393i() {
        return m15378b("Content-Encoding");
    }

    /* JADX INFO: renamed from: d */
    public HttpRequest m15383d(String str) {
        return m15384d(str, null);
    }

    /* JADX INFO: renamed from: d */
    public HttpRequest m15384d(String str, String str2) {
        return (str2 == null || str2.length() <= 0) ? m15366a("Content-Type", str) : m15366a("Content-Type", str + HTTP.CHARSET_PARAM + str2);
    }

    /* JADX INFO: renamed from: j */
    public int m15394j() {
        return m15380c("Content-Length");
    }

    /* JADX INFO: renamed from: a */
    protected HttpRequest m15364a(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        return new CloseOperation<HttpRequest>(inputStream, this.f14695h) { // from class: io.fabric.sdk.android.services.network.HttpRequest.6
            @Override // io.fabric.sdk.android.services.network.HttpRequest.Operation
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HttpRequest mo15402b() throws IOException {
                byte[] bArr = new byte[HttpRequest.this.f14697j];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        outputStream.write(bArr, 0, i);
                    } else {
                        return HttpRequest.this;
                    }
                }
            }
        }.call();
    }

    /* JADX INFO: renamed from: k */
    protected HttpRequest m15395k() throws IOException {
        if (this.f14693f != null) {
            if (this.f14694g) {
                this.f14693f.m15407a("\r\n--00content0boundary00--\r\n");
            }
            if (this.f14695h) {
                try {
                    this.f14693f.close();
                } catch (IOException e) {
                }
            } else {
                this.f14693f.close();
            }
            this.f14693f = null;
        }
        return this;
    }

    /* JADX INFO: renamed from: l */
    protected HttpRequest m15396l() throws HttpRequestException {
        try {
            return m15395k();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* JADX INFO: renamed from: m */
    protected HttpRequest m15397m() throws IOException {
        if (this.f14693f == null) {
            m15375a().setDoOutput(true);
            this.f14693f = new RequestOutputStream(m15375a().getOutputStream(), m15381c(m15375a().getRequestProperty("Content-Type"), "charset"), this.f14697j);
        }
        return this;
    }

    /* JADX INFO: renamed from: n */
    protected HttpRequest m15398n() throws IOException {
        if (!this.f14694g) {
            this.f14694g = true;
            m15383d("multipart/form-data; boundary=00content0boundary00").m15397m();
            this.f14693f.m15407a("--00content0boundary00\r\n");
        } else {
            this.f14693f.m15407a("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    protected HttpRequest m15368a(String str, String str2, String str3) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"").append(str);
        if (str2 != null) {
            sb.append("\"; filename=\"").append(str2);
        }
        sb.append(TokenParser.DQUOTE);
        m15389f(MIME.CONTENT_DISPOSITION, sb.toString());
        if (str3 != null) {
            m15389f("Content-Type", str3);
        }
        return m15388f("\r\n");
    }

    /* JADX INFO: renamed from: e */
    public HttpRequest m15386e(String str, String str2) {
        return m15377b(str, (String) null, str2);
    }

    /* JADX INFO: renamed from: b */
    public HttpRequest m15377b(String str, String str2, String str3) throws HttpRequestException {
        return m15371a(str, str2, (String) null, str3);
    }

    /* JADX INFO: renamed from: a */
    public HttpRequest m15371a(String str, String str2, String str3, String str4) throws HttpRequestException {
        try {
            m15398n();
            m15368a(str, str2, str3);
            this.f14693f.m15407a(str4);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public HttpRequest m15365a(String str, Number number) throws HttpRequestException {
        return m15367a(str, (String) null, number);
    }

    /* JADX INFO: renamed from: a */
    public HttpRequest m15367a(String str, String str2, Number number) throws HttpRequestException {
        return m15377b(str, str2, number != null ? number.toString() : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0020 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.fabric.sdk.android.services.network.HttpRequest m15369a(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.io.File r7) throws java.lang.Throwable {
        /*
            r3 = this;
            r2 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.io.IOException -> L15 java.lang.Throwable -> L28
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.io.IOException -> L15 java.lang.Throwable -> L28
            r0.<init>(r7)     // Catch: java.io.IOException -> L15 java.lang.Throwable -> L28
            r1.<init>(r0)     // Catch: java.io.IOException -> L15 java.lang.Throwable -> L28
            io.fabric.sdk.android.services.network.HttpRequest r0 = r3.m15370a(r4, r5, r6, r1)     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L2b
            if (r1 == 0) goto L14
            r1.close()     // Catch: java.io.IOException -> L24
        L14:
            return r0
        L15:
            r0 = move-exception
            r1 = r2
        L17:
            io.fabric.sdk.android.services.network.HttpRequest$HttpRequestException r2 = new io.fabric.sdk.android.services.network.HttpRequest$HttpRequestException     // Catch: java.lang.Throwable -> L1d
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L1d
            throw r2     // Catch: java.lang.Throwable -> L1d
        L1d:
            r0 = move-exception
        L1e:
            if (r1 == 0) goto L23
            r1.close()     // Catch: java.io.IOException -> L26
        L23:
            throw r0
        L24:
            r1 = move-exception
            goto L14
        L26:
            r1 = move-exception
            goto L23
        L28:
            r0 = move-exception
            r1 = r2
            goto L1e
        L2b:
            r0 = move-exception
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.network.HttpRequest.m15369a(java.lang.String, java.lang.String, java.lang.String, java.io.File):io.fabric.sdk.android.services.network.HttpRequest");
    }

    /* JADX INFO: renamed from: a */
    public HttpRequest m15370a(String str, String str2, String str3, InputStream inputStream) throws HttpRequestException {
        try {
            m15398n();
            m15368a(str, str2, str3);
            m15364a(inputStream, this.f14693f);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* JADX INFO: renamed from: f */
    public HttpRequest m15389f(String str, String str2) throws HttpRequestException {
        return m15388f((CharSequence) str).m15388f(": ").m15388f((CharSequence) str2).m15388f("\r\n");
    }

    /* JADX INFO: renamed from: f */
    public HttpRequest m15388f(CharSequence charSequence) throws HttpRequestException {
        try {
            m15397m();
            this.f14693f.m15407a(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* JADX INFO: renamed from: o */
    public URL m15399o() {
        return m15375a().getURL();
    }

    /* JADX INFO: renamed from: p */
    public String m15400p() {
        return m15375a().getRequestMethod();
    }
}
