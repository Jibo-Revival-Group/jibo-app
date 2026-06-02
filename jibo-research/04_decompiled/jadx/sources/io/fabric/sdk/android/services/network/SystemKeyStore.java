package io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
class SystemKeyStore {

    /* JADX INFO: renamed from: a */
    final KeyStore f14713a;

    /* JADX INFO: renamed from: b */
    private final HashMap<Principal, X509Certificate> f14714b;

    public SystemKeyStore(InputStream inputStream, String str) {
        KeyStore keyStoreM15414a = m15414a(inputStream, str);
        this.f14714b = m15415a(keyStoreM15414a);
        this.f14713a = keyStoreM15414a;
    }

    /* JADX INFO: renamed from: a */
    public boolean m15416a(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = this.f14714b.get(x509Certificate.getSubjectX500Principal());
        return x509Certificate2 != null && x509Certificate2.getPublicKey().equals(x509Certificate.getPublicKey());
    }

    /* JADX INFO: renamed from: b */
    public X509Certificate m15417b(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = this.f14714b.get(x509Certificate.getIssuerX500Principal());
        if (x509Certificate2 != null && !x509Certificate2.getSubjectX500Principal().equals(x509Certificate.getSubjectX500Principal())) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (GeneralSecurityException e) {
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private HashMap<Principal, X509Certificate> m15415a(KeyStore keyStore) {
        try {
            HashMap<Principal, X509Certificate> map = new HashMap<>();
            Enumeration<String> enumerationAliases = keyStore.aliases();
            while (enumerationAliases.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(enumerationAliases.nextElement());
                if (x509Certificate != null) {
                    map.put(x509Certificate.getSubjectX500Principal(), x509Certificate);
                }
            }
            return map;
        } catch (KeyStoreException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: renamed from: a */
    private KeyStore m15414a(InputStream inputStream, String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance("BKS");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                keyStore.load(bufferedInputStream, str.toCharArray());
                return keyStore;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException e) {
            throw new AssertionError(e);
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new AssertionError(e3);
        } catch (CertificateException e4) {
            throw new AssertionError(e4);
        }
    }
}
