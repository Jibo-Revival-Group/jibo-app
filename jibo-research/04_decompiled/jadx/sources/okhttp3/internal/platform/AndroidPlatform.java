package okhttp3.internal.platform;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;

/* JADX INFO: loaded from: classes2.dex */
class AndroidPlatform extends Platform {

    /* JADX INFO: renamed from: a */
    private final Class<?> f15579a;

    /* JADX INFO: renamed from: b */
    private final OptionalMethod<Socket> f15580b;

    /* JADX INFO: renamed from: c */
    private final OptionalMethod<Socket> f15581c;

    /* JADX INFO: renamed from: d */
    private final OptionalMethod<Socket> f15582d;

    /* JADX INFO: renamed from: e */
    private final OptionalMethod<Socket> f15583e;

    /* JADX INFO: renamed from: f */
    private final CloseGuard f15584f = CloseGuard.m16187a();

    AndroidPlatform(Class<?> cls, OptionalMethod<Socket> optionalMethod, OptionalMethod<Socket> optionalMethod2, OptionalMethod<Socket> optionalMethod3, OptionalMethod<Socket> optionalMethod4) {
        this.f15579a = cls;
        this.f15580b = optionalMethod;
        this.f15581c = optionalMethod2;
        this.f15582d = optionalMethod3;
        this.f15583e = optionalMethod4;
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: a */
    public void mo16183a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!Util.m15845a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (SecurityException e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: a */
    public X509TrustManager mo16179a(SSLSocketFactory sSLSocketFactory) {
        Object objA;
        Object objA2 = m16200a(sSLSocketFactory, this.f15579a, "sslParameters");
        if (objA2 == null) {
            try {
                objA = m16200a(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException e) {
                return super.mo16179a(sSLSocketFactory);
            }
        } else {
            objA = objA2;
        }
        X509TrustManager x509TrustManager = (X509TrustManager) m16200a(objA, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) m16200a(objA, X509TrustManager.class, "trustManager");
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: a */
    public void mo16184a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f15580b.m16197b(sSLSocket, true);
            this.f15581c.m16197b(sSLSocket, str);
        }
        if (this.f15583e != null && this.f15583e.m16196a(sSLSocket)) {
            this.f15583e.m16199d(sSLSocket, m16204b(list));
        }
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: a */
    public String mo16178a(SSLSocket sSLSocket) {
        if (this.f15582d == null || !this.f15582d.m16196a(sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.f15582d.m16199d(sSLSocket, new Object[0]);
        return bArr != null ? new String(bArr, Util.f15241e) : null;
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: a */
    public void mo16181a(int i, String str, Throwable th) {
        int iMin;
        int i2 = i == 5 ? 5 : 3;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int iIndexOf = str.indexOf(10, i3);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i3 = iMin;
                }
            }
            i3 = iMin + 1;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: a */
    public Object mo16177a(String str) {
        return this.f15584f.m16188a(str);
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: a */
    public void mo16182a(String str, Object obj) {
        if (!this.f15584f.m16189a(obj)) {
            mo16181a(5, str, (Throwable) null);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: b */
    public boolean mo16185b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), str)).booleanValue();
        } catch (ClassNotFoundException e) {
            return super.mo16185b(str);
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        } catch (IllegalArgumentException e3) {
            throw new AssertionError();
        } catch (NoSuchMethodException e4) {
            return super.mo16185b(str);
        } catch (InvocationTargetException e5) {
            throw new AssertionError();
        }
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: a */
    public CertificateChainCleaner mo16180a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new AndroidCertificateChainCleaner(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception e) {
            return super.mo16180a(x509TrustManager);
        }
    }

    /* JADX INFO: renamed from: a */
    public static Platform m16176a() {
        Class<?> cls;
        OptionalMethod optionalMethod;
        OptionalMethod optionalMethod2;
        OptionalMethod optionalMethod3;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException e) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            OptionalMethod optionalMethod4 = new OptionalMethod(null, "setUseSessionTickets", Boolean.TYPE);
            OptionalMethod optionalMethod5 = new OptionalMethod(null, "setHostname", String.class);
            try {
                Class.forName("android.net.Network");
                optionalMethod = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            } catch (ClassNotFoundException e2) {
                optionalMethod = null;
            }
            try {
                optionalMethod2 = new OptionalMethod(null, "setAlpnProtocols", byte[].class);
                optionalMethod3 = optionalMethod;
            } catch (ClassNotFoundException e3) {
                optionalMethod2 = null;
                optionalMethod3 = optionalMethod;
            }
            return new AndroidPlatform(cls, optionalMethod4, optionalMethod5, optionalMethod3, optionalMethod2);
        } catch (ClassNotFoundException e4) {
            return null;
        }
    }

    static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {

        /* JADX INFO: renamed from: a */
        private final Object f15585a;

        /* JADX INFO: renamed from: b */
        private final Method f15586b;

        AndroidCertificateChainCleaner(Object obj, Method method) {
            this.f15585a = obj;
            this.f15586b = method;
        }

        @Override // okhttp3.internal.tls.CertificateChainCleaner
        /* JADX INFO: renamed from: a */
        public List<Certificate> mo16186a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f15586b.invoke(this.f15585a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof AndroidCertificateChainCleaner;
        }

        public int hashCode() {
            return 0;
        }
    }

    static final class CloseGuard {

        /* JADX INFO: renamed from: a */
        private final Method f15587a;

        /* JADX INFO: renamed from: b */
        private final Method f15588b;

        /* JADX INFO: renamed from: c */
        private final Method f15589c;

        CloseGuard(Method method, Method method2, Method method3) {
            this.f15587a = method;
            this.f15588b = method2;
            this.f15589c = method3;
        }

        /* JADX INFO: renamed from: a */
        Object m16188a(String str) {
            if (this.f15587a != null) {
                try {
                    Object objInvoke = this.f15587a.invoke(null, new Object[0]);
                    this.f15588b.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception e) {
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: a */
        boolean m16189a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f15589c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        /* JADX INFO: renamed from: a */
        static CloseGuard m16187a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method2 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod("open", String.class);
                method3 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception e) {
                method = null;
                method2 = null;
            }
            return new CloseGuard(method2, method, method3);
        }
    }
}
