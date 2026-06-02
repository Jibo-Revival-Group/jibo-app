package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes2.dex */
final class Http2Reader implements Closeable {

    /* JADX INFO: renamed from: a */
    static final Logger f15520a = Logger.getLogger(Http2.class.getName());

    /* JADX INFO: renamed from: b */
    final Hpack.Reader f15521b;

    /* JADX INFO: renamed from: c */
    private final BufferedSource f15522c;

    /* JADX INFO: renamed from: d */
    private final ContinuationSource f15523d;

    /* JADX INFO: renamed from: e */
    private final boolean f15524e;

    interface Handler {
        /* JADX INFO: renamed from: a */
        void mo16076a();

        /* JADX INFO: renamed from: a */
        void mo16077a(int i, int i2, int i3, boolean z);

        /* JADX INFO: renamed from: a */
        void mo16078a(int i, int i2, List<Header> list) throws IOException;

        /* JADX INFO: renamed from: a */
        void mo16079a(int i, long j);

        /* JADX INFO: renamed from: a */
        void mo16080a(int i, ErrorCode errorCode);

        /* JADX INFO: renamed from: a */
        void mo16081a(int i, ErrorCode errorCode, ByteString byteString);

        /* JADX INFO: renamed from: a */
        void mo16082a(boolean z, int i, int i2);

        /* JADX INFO: renamed from: a */
        void mo16083a(boolean z, int i, int i2, List<Header> list);

        /* JADX INFO: renamed from: a */
        void mo16084a(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        /* JADX INFO: renamed from: a */
        void mo16085a(boolean z, Settings settings);
    }

    Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.f15522c = bufferedSource;
        this.f15524e = z;
        this.f15523d = new ContinuationSource(this.f15522c);
        this.f15521b = new Hpack.Reader(4096, this.f15523d);
    }

    /* JADX INFO: renamed from: a */
    public void m16099a(Handler handler) throws IOException {
        if (this.f15524e) {
            if (!m16100a(true, handler)) {
                throw Http2.m16045b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        ByteString byteStringMo16277d = this.f15522c.mo16277d(Http2.f15438a.mo16336h());
        if (f15520a.isLoggable(Level.FINE)) {
            f15520a.fine(Util.m15836a("<< CONNECTION %s", byteStringMo16277d.mo16334f()));
        }
        if (!Http2.f15438a.equals(byteStringMo16277d)) {
            throw Http2.m16045b("Expected a connection header but was %s", byteStringMo16277d.mo16323a());
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m16100a(boolean z, Handler handler) throws IOException {
        try {
            this.f15522c.mo16259a(9L);
            int iM16087a = m16087a(this.f15522c);
            if (iM16087a < 0 || iM16087a > 16384) {
                throw Http2.m16045b("FRAME_SIZE_ERROR: %s", Integer.valueOf(iM16087a));
            }
            byte bMo16290i = (byte) (this.f15522c.mo16290i() & 255);
            if (z && bMo16290i != 4) {
                throw Http2.m16045b("Expected a SETTINGS frame but was %s", Byte.valueOf(bMo16290i));
            }
            byte bMo16290i2 = (byte) (this.f15522c.mo16290i() & 255);
            int iMo16296k = this.f15522c.mo16296k() & Integer.MAX_VALUE;
            if (f15520a.isLoggable(Level.FINE)) {
                f15520a.fine(Http2.m16044a(true, iMo16296k, iM16087a, bMo16290i, bMo16290i2));
            }
            switch (bMo16290i) {
                case 0:
                    m16091b(handler, iM16087a, bMo16290i2, iMo16296k);
                    return true;
                case 1:
                    m16090a(handler, iM16087a, bMo16290i2, iMo16296k);
                    return true;
                case 2:
                    m16092c(handler, iM16087a, bMo16290i2, iMo16296k);
                    return true;
                case 3:
                    m16093d(handler, iM16087a, bMo16290i2, iMo16296k);
                    return true;
                case 4:
                    m16094e(handler, iM16087a, bMo16290i2, iMo16296k);
                    return true;
                case 5:
                    m16095f(handler, iM16087a, bMo16290i2, iMo16296k);
                    return true;
                case 6:
                    m16096g(handler, iM16087a, bMo16290i2, iMo16296k);
                    return true;
                case 7:
                    m16097h(handler, iM16087a, bMo16290i2, iMo16296k);
                    return true;
                case 8:
                    m16098i(handler, iM16087a, bMo16290i2, iMo16296k);
                    return true;
                default:
                    this.f15522c.mo16292i(iM16087a);
                    return true;
            }
        } catch (IOException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m16090a(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.m16045b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        short sMo16290i = (b & 8) != 0 ? (short) (this.f15522c.mo16290i() & 255) : (short) 0;
        if ((b & 32) != 0) {
            m16089a(handler, i2);
            i -= 5;
        }
        handler.mo16083a(z, i2, -1, m16088a(m16086a(i, b, sMo16290i), sMo16290i, b, i2));
    }

    /* JADX INFO: renamed from: a */
    private List<Header> m16088a(int i, short s, byte b, int i2) throws IOException {
        ContinuationSource continuationSource = this.f15523d;
        this.f15523d.f15528d = i;
        continuationSource.f15525a = i;
        this.f15523d.f15529e = s;
        this.f15523d.f15526b = b;
        this.f15523d.f15527c = i2;
        this.f15521b.m16031a();
        return this.f15521b.m16032b();
    }

    /* JADX INFO: renamed from: b */
    private void m16091b(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.m16045b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw Http2.m16045b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short sMo16290i = (b & 8) != 0 ? (short) (this.f15522c.mo16290i() & 255) : (short) 0;
        handler.mo16084a(z, i2, this.f15522c, m16086a(i, b, sMo16290i));
        this.f15522c.mo16292i(sMo16290i);
    }

    /* JADX INFO: renamed from: c */
    private void m16092c(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw Http2.m16045b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw Http2.m16045b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        m16089a(handler, i2);
    }

    /* JADX INFO: renamed from: a */
    private void m16089a(Handler handler, int i) throws IOException {
        int iMo16296k = this.f15522c.mo16296k();
        handler.mo16077a(i, iMo16296k & Integer.MAX_VALUE, (this.f15522c.mo16290i() & 255) + 1, (Integer.MIN_VALUE & iMo16296k) != 0);
    }

    /* JADX INFO: renamed from: d */
    private void m16093d(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.m16045b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw Http2.m16045b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int iMo16296k = this.f15522c.mo16296k();
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(iMo16296k);
        if (errorCodeFromHttp2 == null) {
            throw Http2.m16045b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iMo16296k));
        }
        handler.mo16080a(i2, errorCodeFromHttp2);
    }

    /* JADX INFO: renamed from: e */
    private void m16094e(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw Http2.m16045b("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw Http2.m16045b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            handler.mo16076a();
            return;
        }
        if (i % 6 != 0) {
            throw Http2.m16045b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        Settings settings = new Settings();
        for (int i3 = 0; i3 < i; i3 += 6) {
            short sMo16295j = this.f15522c.mo16295j();
            int iMo16296k = this.f15522c.mo16296k();
            switch (sMo16295j) {
                case 2:
                    if (iMo16296k != 0 && iMo16296k != 1) {
                        throw Http2.m16045b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                    break;
                    break;
                case 3:
                    sMo16295j = 4;
                    break;
                case 4:
                    sMo16295j = 7;
                    if (iMo16296k < 0) {
                        throw Http2.m16045b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                    break;
                    break;
                case 5:
                    if (iMo16296k < 16384 || iMo16296k > 16777215) {
                        throw Http2.m16045b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iMo16296k));
                    }
                    break;
                    break;
            }
            settings.m16158a(sMo16295j, iMo16296k);
        }
        handler.mo16085a(false, settings);
    }

    /* JADX INFO: renamed from: f */
    private void m16095f(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.m16045b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short sMo16290i = (b & 8) != 0 ? (short) (this.f15522c.mo16290i() & 255) : (short) 0;
        handler.mo16078a(i2, this.f15522c.mo16296k() & Integer.MAX_VALUE, m16088a(m16086a(i - 4, b, sMo16290i), sMo16290i, b, i2));
    }

    /* JADX INFO: renamed from: g */
    private void m16096g(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw Http2.m16045b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.m16045b("TYPE_PING streamId != 0", new Object[0]);
        }
        handler.mo16082a((b & 1) != 0, this.f15522c.mo16296k(), this.f15522c.mo16296k());
    }

    /* JADX INFO: renamed from: h */
    private void m16097h(Handler handler, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw Http2.m16045b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.m16045b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int iMo16296k = this.f15522c.mo16296k();
        int iMo16296k2 = this.f15522c.mo16296k();
        int i3 = i - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(iMo16296k2);
        if (errorCodeFromHttp2 == null) {
            throw Http2.m16045b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iMo16296k2));
        }
        ByteString byteStringMo16277d = ByteString.f15647b;
        if (i3 > 0) {
            byteStringMo16277d = this.f15522c.mo16277d(i3);
        }
        handler.mo16081a(iMo16296k, errorCodeFromHttp2, byteStringMo16277d);
    }

    /* JADX INFO: renamed from: i */
    private void m16098i(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.m16045b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long jMo16296k = ((long) this.f15522c.mo16296k()) & 2147483647L;
        if (jMo16296k == 0) {
            throw Http2.m16045b("windowSizeIncrement was 0", Long.valueOf(jMo16296k));
        }
        handler.mo16079a(i2, jMo16296k);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f15522c.close();
    }

    static final class ContinuationSource implements Source {

        /* JADX INFO: renamed from: a */
        int f15525a;

        /* JADX INFO: renamed from: b */
        byte f15526b;

        /* JADX INFO: renamed from: c */
        int f15527c;

        /* JADX INFO: renamed from: d */
        int f15528d;

        /* JADX INFO: renamed from: e */
        short f15529e;

        /* JADX INFO: renamed from: f */
        private final BufferedSource f15530f;

        ContinuationSource(BufferedSource bufferedSource) {
            this.f15530f = bufferedSource;
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: a */
        public long mo15863a(Buffer buffer, long j) throws IOException {
            while (this.f15528d == 0) {
                this.f15530f.mo16292i(this.f15529e);
                this.f15529e = (short) 0;
                if ((this.f15526b & 4) != 0) {
                    return -1L;
                }
                m16101b();
            }
            long jA = this.f15530f.mo15863a(buffer, Math.min(j, this.f15528d));
            if (jA == -1) {
                return -1L;
            }
            this.f15528d = (int) (((long) this.f15528d) - jA);
            return jA;
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: a */
        public Timeout mo15864a() {
            return this.f15530f.mo15864a();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        /* JADX INFO: renamed from: b */
        private void m16101b() throws IOException {
            int i = this.f15527c;
            int iM16087a = Http2Reader.m16087a(this.f15530f);
            this.f15528d = iM16087a;
            this.f15525a = iM16087a;
            byte bMo16290i = (byte) (this.f15530f.mo16290i() & 255);
            this.f15526b = (byte) (this.f15530f.mo16290i() & 255);
            if (Http2Reader.f15520a.isLoggable(Level.FINE)) {
                Http2Reader.f15520a.fine(Http2.m16044a(true, this.f15527c, this.f15525a, bMo16290i, this.f15526b));
            }
            this.f15527c = this.f15530f.mo16296k() & Integer.MAX_VALUE;
            if (bMo16290i != 9) {
                throw Http2.m16045b("%s != TYPE_CONTINUATION", Byte.valueOf(bMo16290i));
            }
            if (this.f15527c != i) {
                throw Http2.m16045b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static int m16087a(BufferedSource bufferedSource) throws IOException {
        return ((bufferedSource.mo16290i() & 255) << 16) | ((bufferedSource.mo16290i() & 255) << 8) | (bufferedSource.mo16290i() & 255);
    }

    /* JADX INFO: renamed from: a */
    static int m16086a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s > i) {
            throw Http2.m16045b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        }
        return (short) (i - s);
    }
}
