package io.fabric.sdk.android.services.network;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkUtils {
    /* JADX INFO: renamed from: a */
    public static final SSLSocketFactory m15408a(PinningInfoProvider pinningInfoProvider) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, new TrustManager[]{new PinningTrustManager(new SystemKeyStore(pinningInfoProvider.mo5892a(), pinningInfoProvider.mo5893b()), pinningInfoProvider)}, null);
        return sSLContext.getSocketFactory();
    }
}
