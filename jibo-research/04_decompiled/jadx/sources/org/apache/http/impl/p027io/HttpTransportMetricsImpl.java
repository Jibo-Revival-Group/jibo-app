package org.apache.http.impl.p027io;

import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.p028io.HttpTransportMetrics;

/* JADX INFO: loaded from: classes2.dex */
@NotThreadSafe
public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    private long bytesTransferred = 0;

    @Override // org.apache.http.p028io.HttpTransportMetrics
    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public void setBytesTransferred(long j) {
        this.bytesTransferred = j;
    }

    public void incrementBytesTransferred(long j) {
        this.bytesTransferred += j;
    }

    @Override // org.apache.http.p028io.HttpTransportMetrics
    public void reset() {
        this.bytesTransferred = 0L;
    }
}
