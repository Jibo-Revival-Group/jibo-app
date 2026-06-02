package okhttp3.internal.cache;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public interface InternalCache {
    /* JADX INFO: renamed from: a */
    Response mo15503a(Request request) throws IOException;

    /* JADX INFO: renamed from: a */
    CacheRequest mo15504a(Response response) throws IOException;

    /* JADX INFO: renamed from: a */
    void mo15505a();

    /* JADX INFO: renamed from: a */
    void mo15506a(Response response, Response response2);

    /* JADX INFO: renamed from: a */
    void mo15507a(CacheStrategy cacheStrategy);

    /* JADX INFO: renamed from: b */
    void mo15508b(Request request) throws IOException;
}
