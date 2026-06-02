package okhttp3;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface Call extends Cloneable {

    public interface Factory {
        /* JADX INFO: renamed from: a */
        Call mo15540a(Request request);
    }

    /* JADX INFO: renamed from: a */
    Request mo15535a();

    /* JADX INFO: renamed from: a */
    void mo15536a(Callback callback);

    /* JADX INFO: renamed from: b */
    Response mo15537b() throws IOException;

    /* JADX INFO: renamed from: c */
    void mo15538c();

    /* JADX INFO: renamed from: d */
    boolean mo15539d();
}
