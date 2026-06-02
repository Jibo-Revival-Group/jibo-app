package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
class JdkWithJettyBootPlatform extends Platform {

    /* JADX INFO: renamed from: a */
    private final Method f15592a;

    /* JADX INFO: renamed from: b */
    private final Method f15593b;

    /* JADX INFO: renamed from: c */
    private final Method f15594c;

    /* JADX INFO: renamed from: d */
    private final Class<?> f15595d;

    /* JADX INFO: renamed from: e */
    private final Class<?> f15596e;

    JdkWithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f15592a = method;
        this.f15593b = method2;
        this.f15594c = method3;
        this.f15595d = cls;
        this.f15596e = cls2;
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: a */
    public void mo16184a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            this.f15592a.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.f15595d, this.f15596e}, new JettyNegoProvider(m16201a(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: b */
    public void mo16192b(SSLSocket sSLSocket) {
        try {
            this.f15594c.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError();
        }
    }

    @Override // okhttp3.internal.platform.Platform
    /* JADX INFO: renamed from: a */
    public String mo16178a(SSLSocket sSLSocket) {
        try {
            JettyNegoProvider jettyNegoProvider = (JettyNegoProvider) Proxy.getInvocationHandler(this.f15593b.invoke(null, sSLSocket));
            if (jettyNegoProvider.f15597a || jettyNegoProvider.f15598b != null) {
                return jettyNegoProvider.f15597a ? null : jettyNegoProvider.f15598b;
            }
            Platform.m16203b().mo16181a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: renamed from: a */
    public static Platform m16191a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            return new JdkWithJettyBootPlatform(cls.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            return null;
        }
    }

    private static class JettyNegoProvider implements InvocationHandler {

        /* JADX INFO: renamed from: a */
        boolean f15597a;

        /* JADX INFO: renamed from: b */
        String f15598b;

        /* JADX INFO: renamed from: c */
        private final List<String> f15599c;

        JettyNegoProvider(List<String> list) {
            this.f15599c = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = Util.f15238b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f15597a = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f15599c;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                List list = (List) objArr[0];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (this.f15599c.contains(list.get(i))) {
                        String str = (String) list.get(i);
                        this.f15598b = str;
                        return str;
                    }
                }
                String str2 = this.f15599c.get(0);
                this.f15598b = str2;
                return str2;
            }
            if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                this.f15598b = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }
}
