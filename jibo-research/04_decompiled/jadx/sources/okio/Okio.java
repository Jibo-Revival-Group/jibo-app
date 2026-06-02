package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class Okio {

    /* JADX INFO: renamed from: a */
    static final Logger f15671a = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    /* JADX INFO: renamed from: a */
    public static BufferedSource m16360a(Source source) {
        return new RealBufferedSource(source);
    }

    /* JADX INFO: renamed from: a */
    public static BufferedSink m16359a(Sink sink) {
        return new RealBufferedSink(sink);
    }

    /* JADX INFO: renamed from: a */
    public static Sink m16362a(OutputStream outputStream) {
        return m16363a(outputStream, new Timeout());
    }

    /* JADX INFO: renamed from: a */
    private static Sink m16363a(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (timeout == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new Sink() { // from class: okio.Okio.1
            @Override // okio.Sink
            /* JADX INFO: renamed from: a_ */
            public void mo15902a_(Buffer buffer, long j) throws IOException {
                Util.m16387a(buffer.f15643b, 0L, j);
                while (j > 0) {
                    timeout.mo16346g();
                    Segment segment = buffer.f15642a;
                    int iMin = (int) Math.min(j, segment.f15686c - segment.f15685b);
                    outputStream.write(segment.f15684a, segment.f15685b, iMin);
                    segment.f15685b += iMin;
                    j -= (long) iMin;
                    buffer.f15643b -= (long) iMin;
                    if (segment.f15685b == segment.f15686c) {
                        buffer.f15642a = segment.m16376a();
                        SegmentPool.m16382a(segment);
                    }
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() throws IOException {
                outputStream.flush();
            }

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                outputStream.close();
            }

            @Override // okio.Sink
            /* JADX INFO: renamed from: a */
            public Timeout mo16013a() {
                return timeout;
            }

            public String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    /* JADX INFO: renamed from: a */
    public static Sink m16364a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        AsyncTimeout asyncTimeoutM16371c = m16371c(socket);
        return asyncTimeoutM16371c.m16238a(m16363a(socket.getOutputStream(), asyncTimeoutM16371c));
    }

    /* JADX INFO: renamed from: a */
    public static Source m16366a(InputStream inputStream) {
        return m16367a(inputStream, new Timeout());
    }

    /* JADX INFO: renamed from: a */
    private static Source m16367a(final InputStream inputStream, final Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (timeout == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new Source() { // from class: okio.Okio.2
            @Override // okio.Source
            /* JADX INFO: renamed from: a */
            public long mo15863a(Buffer buffer, long j) throws IOException {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: " + j);
                }
                if (j == 0) {
                    return 0L;
                }
                try {
                    timeout.mo16346g();
                    Segment segmentM16282f = buffer.m16282f(1);
                    int i = inputStream.read(segmentM16282f.f15684a, segmentM16282f.f15686c, (int) Math.min(j, 8192 - segmentM16282f.f15686c));
                    if (i == -1) {
                        return -1L;
                    }
                    segmentM16282f.f15686c += i;
                    buffer.f15643b += (long) i;
                    return i;
                } catch (AssertionError e) {
                    if (Okio.m16368a(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                inputStream.close();
            }

            @Override // okio.Source
            /* JADX INFO: renamed from: a */
            public Timeout mo15864a() {
                return timeout;
            }

            public String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }

    /* JADX INFO: renamed from: a */
    public static Source m16365a(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return m16366a(new FileInputStream(file));
    }

    /* JADX INFO: renamed from: b */
    public static Sink m16369b(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return m16362a(new FileOutputStream(file));
    }

    /* JADX INFO: renamed from: c */
    public static Sink m16372c(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return m16362a(new FileOutputStream(file, true));
    }

    /* JADX INFO: renamed from: a */
    public static Sink m16361a() {
        return new Sink() { // from class: okio.Okio.3
            @Override // okio.Sink
            /* JADX INFO: renamed from: a_ */
            public void mo15902a_(Buffer buffer, long j) throws IOException {
                buffer.mo16292i(j);
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() throws IOException {
            }

            @Override // okio.Sink
            /* JADX INFO: renamed from: a */
            public Timeout mo16013a() {
                return Timeout.f15695c;
            }

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }
        };
    }

    /* JADX INFO: renamed from: b */
    public static Source m16370b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        AsyncTimeout asyncTimeoutM16371c = m16371c(socket);
        return asyncTimeoutM16371c.m16239a(m16367a(socket.getInputStream(), asyncTimeoutM16371c));
    }

    /* JADX INFO: renamed from: c */
    private static AsyncTimeout m16371c(final Socket socket) {
        return new AsyncTimeout() { // from class: okio.Okio.4
            @Override // okio.AsyncTimeout
            /* JADX INFO: renamed from: a */
            protected IOException mo16125a(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // okio.AsyncTimeout
            /* JADX INFO: renamed from: a */
            protected void mo16126a() {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (Okio.m16368a(e)) {
                        Okio.f15671a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                        return;
                    }
                    throw e;
                } catch (Exception e2) {
                    Okio.f15671a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }
        };
    }

    /* JADX INFO: renamed from: a */
    static boolean m16368a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
