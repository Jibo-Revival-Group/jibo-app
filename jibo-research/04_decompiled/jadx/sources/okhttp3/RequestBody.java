package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RequestBody {
    /* JADX INFO: renamed from: a */
    public abstract MediaType mo14283a();

    /* JADX INFO: renamed from: a */
    public abstract void mo14284a(BufferedSink bufferedSink) throws IOException;

    /* JADX INFO: renamed from: b */
    public long mo14285b() throws IOException {
        return -1L;
    }

    /* JADX INFO: renamed from: a */
    public static RequestBody m15785a(MediaType mediaType, String str) {
        Charset charsetM15698b = Util.f15241e;
        if (mediaType != null && (charsetM15698b = mediaType.m15698b()) == null) {
            charsetM15698b = Util.f15241e;
            mediaType = MediaType.m15695a(mediaType + "; charset=utf-8");
        }
        return m15787a(mediaType, str.getBytes(charsetM15698b));
    }

    /* JADX INFO: renamed from: a */
    public static RequestBody m15786a(final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() { // from class: okhttp3.RequestBody.1
            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: a */
            public MediaType mo14283a() {
                return mediaType;
            }

            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: b */
            public long mo14285b() throws IOException {
                return byteString.mo16336h();
            }

            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: a */
            public void mo14284a(BufferedSink bufferedSink) throws IOException {
                bufferedSink.mo16268b(byteString);
            }
        };
    }

    /* JADX INFO: renamed from: a */
    public static RequestBody m15787a(MediaType mediaType, byte[] bArr) {
        return m15788a(mediaType, bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a */
    public static RequestBody m15788a(final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        Util.m15842a(bArr.length, i, i2);
        return new RequestBody() { // from class: okhttp3.RequestBody.2
            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: a */
            public MediaType mo14283a() {
                return mediaType;
            }

            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: b */
            public long mo14285b() {
                return i2;
            }

            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: a */
            public void mo14284a(BufferedSink bufferedSink) throws IOException {
                bufferedSink.mo16274c(bArr, i, i2);
            }
        };
    }
}
