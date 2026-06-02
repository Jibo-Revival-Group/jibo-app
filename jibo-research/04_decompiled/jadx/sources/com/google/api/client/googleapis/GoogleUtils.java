package com.google.api.client.googleapis;

import com.google.api.client.util.SecurityUtils;
import com.yalantis.ucrop.util.FileUtils;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleUtils {
    public static final String VERSION;
    static KeyStore certTrustStore;
    public static final Integer MAJOR_VERSION = 1;
    public static final Integer MINOR_VERSION = 23;
    public static final Integer BUGFIX_VERSION = 0;

    static {
        String strValueOf = String.valueOf(String.valueOf(MAJOR_VERSION));
        String strValueOf2 = String.valueOf(String.valueOf(MINOR_VERSION));
        String strValueOf3 = String.valueOf(String.valueOf(BUGFIX_VERSION));
        VERSION = new StringBuilder(strValueOf.length() + 2 + strValueOf2.length() + strValueOf3.length()).append(strValueOf).append(FileUtils.HIDDEN_PREFIX).append(strValueOf2).append(FileUtils.HIDDEN_PREFIX).append(strValueOf3).toString().toString();
    }

    public static synchronized KeyStore getCertificateTrustStore() throws GeneralSecurityException, IOException {
        if (certTrustStore == null) {
            certTrustStore = SecurityUtils.getJavaKeyStore();
            SecurityUtils.loadKeyStore(certTrustStore, GoogleUtils.class.getResourceAsStream("google.jks"), "notasecret");
        }
        return certTrustStore;
    }

    private GoogleUtils() {
    }
}
