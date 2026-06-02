package io.fabric.sdk.android.services.network;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class NetworkUtils {
   public static final SSLSocketFactory a(PinningInfoProvider var0) throws KeyManagementException, NoSuchAlgorithmException {
      SSLContext var1 = SSLContext.getInstance("TLS");
      var1.init(null, new TrustManager[]{new PinningTrustManager(new SystemKeyStore(var0.a(), var0.b()), var0)}, null);
      return var1.getSocketFactory();
   }
}
