package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes2.dex */
public interface PushObserver {

    /* JADX INFO: renamed from: a */
    public static final PushObserver f15574a = new PushObserver() { // from class: okhttp3.internal.http2.PushObserver.1
        @Override // okhttp3.internal.http2.PushObserver
        /* JADX INFO: renamed from: a */
        public boolean mo16155a(int i, List<Header> list) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        /* JADX INFO: renamed from: a */
        public boolean mo16156a(int i, List<Header> list, boolean z) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        /* JADX INFO: renamed from: a */
        public boolean mo16157a(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
            bufferedSource.mo16292i(i2);
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        /* JADX INFO: renamed from: a */
        public void mo16154a(int i, ErrorCode errorCode) {
        }
    };

    /* JADX INFO: renamed from: a */
    void mo16154a(int i, ErrorCode errorCode);

    /* JADX INFO: renamed from: a */
    boolean mo16155a(int i, List<Header> list);

    /* JADX INFO: renamed from: a */
    boolean mo16156a(int i, List<Header> list, boolean z);

    /* JADX INFO: renamed from: a */
    boolean mo16157a(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException;
}
