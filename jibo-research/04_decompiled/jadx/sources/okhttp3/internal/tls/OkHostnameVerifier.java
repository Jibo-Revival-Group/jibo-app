package okhttp3.internal.tls;

import com.yalantis.ucrop.util.FileUtils;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class OkHostnameVerifier implements HostnameVerifier {

    /* JADX INFO: renamed from: a */
    public static final OkHostnameVerifier f15621a = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return m16226a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m16226a(String str, X509Certificate x509Certificate) {
        if (Util.m15855c(str)) {
            return m16223b(str, x509Certificate);
        }
        return m16224c(str, x509Certificate);
    }

    /* JADX INFO: renamed from: b */
    private boolean m16223b(String str, X509Certificate x509Certificate) {
        List<String> listM16222a = m16222a(x509Certificate, 7);
        int size = listM16222a.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(listM16222a.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    private boolean m16224c(String str, X509Certificate x509Certificate) {
        String strM16220a;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> listM16222a = m16222a(x509Certificate, 2);
        int size = listM16222a.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (m16225a(lowerCase, listM16222a.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (strM16220a = new DistinguishedNameParser(x509Certificate.getSubjectX500Principal()).m16220a("cn")) == null) {
            return false;
        }
        return m16225a(lowerCase, strM16220a);
    }

    /* JADX INFO: renamed from: a */
    public static List<String> m16221a(X509Certificate x509Certificate) {
        List<String> listM16222a = m16222a(x509Certificate, 7);
        List<String> listM16222a2 = m16222a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listM16222a.size() + listM16222a2.size());
        arrayList.addAll(listM16222a);
        arrayList.addAll(listM16222a2);
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private static List<String> m16222a(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException e) {
            return Collections.emptyList();
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m16225a(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(FileUtils.HIDDEN_PREFIX) || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(FileUtils.HIDDEN_PREFIX) || str2.endsWith("..")) {
            return false;
        }
        if (!str.endsWith(FileUtils.HIDDEN_PREFIX)) {
            str = str + '.';
        }
        if (!str2.endsWith(FileUtils.HIDDEN_PREFIX)) {
            str2 = str2 + '.';
        }
        String lowerCase = str2.toLowerCase(Locale.US);
        if (!lowerCase.contains("*")) {
            return str.equals(lowerCase);
        }
        if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
            return false;
        }
        String strSubstring = lowerCase.substring(1);
        if (!str.endsWith(strSubstring)) {
            return false;
        }
        int length = str.length() - strSubstring.length();
        return length <= 0 || str.lastIndexOf(46, length + (-1)) == -1;
    }
}
