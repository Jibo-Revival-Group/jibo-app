package okhttp3.internal.http;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes2.dex */
public final class RealResponseBody extends ResponseBody {

    /* JADX INFO: renamed from: a */
    private final Headers f15376a;

    /* JADX INFO: renamed from: b */
    private final BufferedSource f15377b;

    public RealResponseBody(Headers headers, BufferedSource bufferedSource) {
        this.f15376a = headers;
        this.f15377b = bufferedSource;
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: a */
    public MediaType mo15511a() {
        String strM15619a = this.f15376a.m15619a("Content-Type");
        if (strM15619a != null) {
            return MediaType.m15695a(strM15619a);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: b */
    public long mo15512b() {
        return HttpHeaders.m15971a(this.f15376a);
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: c */
    public BufferedSource mo15513c() {
        return this.f15377b;
    }
}
