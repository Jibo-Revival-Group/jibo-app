package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public interface BufferedSource extends Source {
    /* JADX INFO: renamed from: a */
    long mo16248a(byte b) throws IOException;

    /* JADX INFO: renamed from: a */
    long mo16250a(Sink sink) throws IOException;

    /* JADX INFO: renamed from: a */
    String mo16253a(Charset charset) throws IOException;

    /* JADX INFO: renamed from: a */
    void mo16259a(long j) throws IOException;

    /* JADX INFO: renamed from: a */
    void mo16260a(byte[] bArr) throws IOException;

    /* JADX INFO: renamed from: a */
    boolean mo16261a(long j, ByteString byteString) throws IOException;

    /* JADX INFO: renamed from: b */
    boolean mo16269b(long j) throws IOException;

    /* JADX INFO: renamed from: c */
    Buffer mo16271c();

    /* JADX INFO: renamed from: d */
    ByteString mo16277d(long j) throws IOException;

    /* JADX INFO: renamed from: f */
    boolean mo16283f() throws IOException;

    /* JADX INFO: renamed from: g */
    InputStream mo16284g();

    /* JADX INFO: renamed from: h */
    byte[] mo16289h(long j) throws IOException;

    /* JADX INFO: renamed from: i */
    byte mo16290i() throws IOException;

    /* JADX INFO: renamed from: i */
    void mo16292i(long j) throws IOException;

    /* JADX INFO: renamed from: j */
    short mo16295j() throws IOException;

    /* JADX INFO: renamed from: k */
    int mo16296k() throws IOException;

    /* JADX INFO: renamed from: l */
    short mo16300l() throws IOException;

    /* JADX INFO: renamed from: m */
    int mo16301m() throws IOException;

    /* JADX INFO: renamed from: n */
    long mo16303n() throws IOException;

    /* JADX INFO: renamed from: o */
    long mo16304o() throws IOException;

    /* JADX INFO: renamed from: p */
    ByteString mo16305p() throws IOException;

    /* JADX INFO: renamed from: r */
    String mo16307r() throws IOException;

    /* JADX INFO: renamed from: t */
    byte[] mo16309t() throws IOException;
}
