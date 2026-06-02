package okhttp3.internal.platform;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

/* JADX INFO: loaded from: classes2.dex */
public class Platform {

    /* JADX INFO: renamed from: a */
    private static final Platform f15603a = m16202a();

    /* JADX INFO: renamed from: b */
    private static final Logger f15604b = Logger.getLogger(OkHttpClient.class.getName());

    /* JADX INFO: renamed from: b */
    public static Platform m16203b() {
        return f15603a;
    }

    /* JADX INFO: renamed from: c */
    public String m16205c() {
        return "OkHttp";
    }

    /* JADX INFO: renamed from: a */
    public X509TrustManager mo16179a(SSLSocketFactory sSLSocketFactory) {
        try {
            Object objM16200a = m16200a(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (objM16200a == null) {
                return null;
            }
            return (X509TrustManager) m16200a(objM16200a, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo16184a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    /* JADX INFO: renamed from: b */
    public void mo16192b(SSLSocket sSLSocket) {
    }

    /* JADX INFO: renamed from: a */
    public String mo16178a(SSLSocket sSLSocket) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void mo16183a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    /* JADX INFO: renamed from: a */
    public void mo16181a(int i, String str, Throwable th) {
        f15604b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* JADX INFO: renamed from: b */
    public boolean mo16185b(String str) {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public Object mo16177a(String str) {
        if (f15604b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void mo16182a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        mo16181a(5, str, (Throwable) obj);
    }

    /* JADX INFO: renamed from: a */
    public static List<String> m16201a(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public CertificateChainCleaner mo16180a(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(TrustRootIndex.m16227a(x509TrustManager));
    }

    /* JADX INFO: renamed from: a */
    private static Platform m16202a() {
        Platform platformM16176a = AndroidPlatform.m16176a();
        if (platformM16176a == null) {
            Jdk9Platform jdk9PlatformM16190a = Jdk9Platform.m16190a();
            if (jdk9PlatformM16190a == null) {
                Platform platformM16191a = JdkWithJettyBootPlatform.m16191a();
                return platformM16191a == null ? new Platform() : platformM16191a;
            }
            return jdk9PlatformM16190a;
        }
        return platformM16176a;
    }

    /* JADX INFO: renamed from: b */
    static byte[] m16204b(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.mo16298k(protocol.toString().length());
                buffer.mo16267b(protocol.toString());
            }
        }
        return buffer.mo16309t();
    }

    /* JADX INFO: renamed from: a */
    static <T> T m16200a(Object obj, Class<T> cls, String str) {
        Object objM16200a;
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 == null || !cls.isInstance(obj2)) {
                    return null;
                }
                return cls.cast(obj2);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (NoSuchFieldException e2) {
            }
        }
        if (str.equals("delegate") || (objM16200a = m16200a(obj, (Class<Object>) Object.class, "delegate")) == null) {
            return null;
        }
        return (T) m16200a(objM16200a, cls, str);
    }
}
