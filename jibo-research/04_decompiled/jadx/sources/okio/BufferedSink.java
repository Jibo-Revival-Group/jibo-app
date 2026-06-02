package okio;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface BufferedSink extends Sink {
    /* JADX INFO: renamed from: b */
    BufferedSink mo16267b(String str) throws IOException;

    /* JADX INFO: renamed from: b */
    BufferedSink mo16268b(ByteString byteString) throws IOException;

    /* JADX INFO: renamed from: c */
    Buffer mo16271c();

    /* JADX INFO: renamed from: c */
    BufferedSink mo16273c(byte[] bArr) throws IOException;

    /* JADX INFO: renamed from: c */
    BufferedSink mo16274c(byte[] bArr, int i, int i2) throws IOException;

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    /* JADX INFO: renamed from: h */
    BufferedSink mo16288h(int i) throws IOException;

    /* JADX INFO: renamed from: i */
    BufferedSink mo16291i(int i) throws IOException;

    /* JADX INFO: renamed from: j */
    BufferedSink mo16294j(int i) throws IOException;

    /* JADX INFO: renamed from: k */
    BufferedSink mo16298k(int i) throws IOException;

    /* JADX INFO: renamed from: l */
    BufferedSink mo16299l(long j) throws IOException;

    /* JADX INFO: renamed from: m */
    BufferedSink mo16302m(long j) throws IOException;

    /* JADX INFO: renamed from: x */
    BufferedSink mo16313x() throws IOException;
}
