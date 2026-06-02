package okhttp3.internal.http;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Sink;

/* JADX INFO: loaded from: classes2.dex */
public interface HttpCodec {
    /* JADX INFO: renamed from: a */
    Response.Builder mo15958a(boolean z) throws IOException;

    /* JADX INFO: renamed from: a */
    ResponseBody mo15959a(Response response) throws IOException;

    /* JADX INFO: renamed from: a */
    Sink mo15960a(Request request, long j);

    /* JADX INFO: renamed from: a */
    void mo15961a() throws IOException;

    /* JADX INFO: renamed from: a */
    void mo15962a(Request request) throws IOException;

    /* JADX INFO: renamed from: b */
    void mo15963b() throws IOException;

    /* JADX INFO: renamed from: c */
    void mo15964c();
}
