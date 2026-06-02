package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionSpecSelector {

    /* JADX INFO: renamed from: a */
    private final List<ConnectionSpec> f15321a;

    /* JADX INFO: renamed from: b */
    private int f15322b = 0;

    /* JADX INFO: renamed from: c */
    private boolean f15323c;

    /* JADX INFO: renamed from: d */
    private boolean f15324d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f15321a = list;
    }

    /* JADX INFO: renamed from: a */
    public ConnectionSpec m15904a(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        int i = this.f15322b;
        int size = this.f15321a.size();
        int i2 = i;
        while (true) {
            if (i2 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f15321a.get(i2);
            if (!connectionSpec.m15565a(sSLSocket)) {
                i2++;
            } else {
                this.f15322b = i2 + 1;
                break;
            }
        }
        if (connectionSpec == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f15324d + ", modes=" + this.f15321a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.f15323c = m15903b(sSLSocket);
        Internal.f15235a.mo15736a(connectionSpec, sSLSocket, this.f15324d);
        return connectionSpec;
    }

    /* JADX INFO: renamed from: a */
    public boolean m15905a(IOException iOException) {
        this.f15324d = true;
        if (!this.f15323c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return (iOException instanceof SSLHandshakeException) || (iOException instanceof SSLProtocolException);
    }

    /* JADX INFO: renamed from: b */
    private boolean m15903b(SSLSocket sSLSocket) {
        int i = this.f15322b;
        while (true) {
            int i2 = i;
            if (i2 < this.f15321a.size()) {
                if (!this.f15321a.get(i2).m15565a(sSLSocket)) {
                    i = i2 + 1;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
    }
}
