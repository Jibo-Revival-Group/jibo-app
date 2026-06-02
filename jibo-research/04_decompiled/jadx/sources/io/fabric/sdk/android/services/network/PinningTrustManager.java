package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.Fabric;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
class PinningTrustManager implements X509TrustManager {

    /* JADX INFO: renamed from: a */
    private static final X509Certificate[] f14707a = new X509Certificate[0];

    /* JADX INFO: renamed from: b */
    private final TrustManager[] f14708b;

    /* JADX INFO: renamed from: c */
    private final SystemKeyStore f14709c;

    /* JADX INFO: renamed from: d */
    private final long f14710d;

    /* JADX INFO: renamed from: e */
    private final List<byte[]> f14711e = new LinkedList();

    /* JADX INFO: renamed from: f */
    private final Set<X509Certificate> f14712f = Collections.synchronizedSet(new HashSet());

    public PinningTrustManager(SystemKeyStore systemKeyStore, PinningInfoProvider pinningInfoProvider) {
        this.f14708b = m15413a(systemKeyStore);
        this.f14709c = systemKeyStore;
        this.f14710d = pinningInfoProvider.mo5895d();
        for (String str : pinningInfoProvider.mo5894c()) {
            this.f14711e.add(m15412a(str));
        }
    }

    /* JADX INFO: renamed from: a */
    private TrustManager[] m15413a(SystemKeyStore systemKeyStore) {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(systemKeyStore.f14713a);
            return trustManagerFactory.getTrustManagers();
        } catch (KeyStoreException e) {
            throw new AssertionError(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m15411a(X509Certificate x509Certificate) throws CertificateException {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            Iterator<byte[]> it = this.f14711e.iterator();
            while (it.hasNext()) {
                if (Arrays.equals(it.next(), bArrDigest)) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchAlgorithmException e) {
            throw new CertificateException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m15410a(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        for (TrustManager trustManager : this.f14708b) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m15409a(X509Certificate[] x509CertificateArr) throws CertificateException {
        if (this.f14710d != -1 && System.currentTimeMillis() - this.f14710d > 15552000000L) {
            Fabric.m15085h().mo15070d("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.f14710d) + " millis vs 15552000000 millis) falling back to system trust.");
            return;
        }
        for (X509Certificate x509Certificate : CertificateChainCleaner.m15340a(x509CertificateArr, this.f14709c)) {
            if (m15411a(x509Certificate)) {
                return;
            }
        }
        throw new CertificateException("No valid pins found in chain!");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (!this.f14712f.contains(x509CertificateArr[0])) {
            m15410a(x509CertificateArr, str);
            m15409a(x509CertificateArr);
            this.f14712f.add(x509CertificateArr[0]);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return f14707a;
    }

    /* JADX INFO: renamed from: a */
    private byte[] m15412a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
