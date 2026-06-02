package io.fabric.sdk.android.services.network;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
final class CertificateChainCleaner {
    /* JADX INFO: renamed from: a */
    public static X509Certificate[] m15340a(X509Certificate[] x509CertificateArr, SystemKeyStore systemKeyStore) throws CertificateException {
        boolean z = true;
        LinkedList linkedList = new LinkedList();
        boolean z2 = systemKeyStore.m15416a(x509CertificateArr[0]);
        linkedList.add(x509CertificateArr[0]);
        boolean z3 = z2;
        int i = 1;
        while (i < x509CertificateArr.length) {
            if (systemKeyStore.m15416a(x509CertificateArr[i])) {
                z3 = true;
            }
            if (!m15339a(x509CertificateArr[i], x509CertificateArr[i - 1])) {
                break;
            }
            linkedList.add(x509CertificateArr[i]);
            i++;
        }
        X509Certificate x509CertificateM15417b = systemKeyStore.m15417b(x509CertificateArr[i - 1]);
        if (x509CertificateM15417b != null) {
            linkedList.add(x509CertificateM15417b);
        } else {
            z = z3;
        }
        if (z) {
            return (X509Certificate[]) linkedList.toArray(new X509Certificate[linkedList.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
    }

    /* JADX INFO: renamed from: a */
    private static boolean m15339a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getIssuerX500Principal())) {
            return false;
        }
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            return true;
        } catch (GeneralSecurityException e) {
            return false;
        }
    }
}
