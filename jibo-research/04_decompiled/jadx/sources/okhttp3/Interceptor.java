package okhttp3;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface Interceptor {

    public interface Chain {
        /* JADX INFO: renamed from: a */
        Request mo15692a();

        /* JADX INFO: renamed from: a */
        Response mo15693a(Request request) throws IOException;

        /* JADX INFO: renamed from: b */
        Connection mo15694b();
    }

    /* JADX INFO: renamed from: a */
    Response mo12243a(Chain chain) throws IOException;
}
