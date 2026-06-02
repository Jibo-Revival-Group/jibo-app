package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes2.dex */
final class Jdk9Platform extends Platform {

    /* JADX INFO: renamed from: a */
    final Method f15590a;

    /* JADX INFO: renamed from: b */
    final Method f15591b;

    Jdk9Platform(Method method, Method method2) {
        this.f15590a = method;
        this.f15591b = method2;
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: a */
    public void mo16184a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listA = m16201a(list);
            this.f15590a.invoke(sSLParameters, listA.toArray(new String[listA.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError();
        }
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: a */
    public String mo16178a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f15591b.invoke(sSLSocket, new Object[0]);
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError();
        }
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: a */
    public X509TrustManager mo16179a(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }

    /* JADX INFO: renamed from: a */
    public static Jdk9Platform m16190a() {
        try {
            return new Jdk9Platform(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
}
