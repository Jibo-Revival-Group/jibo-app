package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class RouteSelector {

    /* JADX INFO: renamed from: a */
    private final Address f15342a;

    /* JADX INFO: renamed from: b */
    private final RouteDatabase f15343b;

    /* JADX INFO: renamed from: c */
    private Proxy f15344c;

    /* JADX INFO: renamed from: d */
    private InetSocketAddress f15345d;

    /* JADX INFO: renamed from: f */
    private int f15347f;

    /* JADX INFO: renamed from: h */
    private int f15349h;

    /* JADX INFO: renamed from: e */
    private List<Proxy> f15346e = Collections.emptyList();

    /* JADX INFO: renamed from: g */
    private List<InetSocketAddress> f15348g = Collections.emptyList();

    /* JADX INFO: renamed from: i */
    private final List<Route> f15350i = new ArrayList();

    public RouteSelector(Address address, RouteDatabase routeDatabase) {
        this.f15342a = address;
        this.f15343b = routeDatabase;
        m15931a(address.m15482a(), address.m15490h());
    }

    /* JADX INFO: renamed from: a */
    public boolean m15939a() {
        return m15934e() || m15932c() || m15936g();
    }

    /* JADX INFO: renamed from: b */
    public Route m15940b() throws IOException {
        if (!m15934e()) {
            if (!m15932c()) {
                if (!m15936g()) {
                    throw new NoSuchElementException();
                }
                return m15937h();
            }
            this.f15344c = m15933d();
        }
        this.f15345d = m15935f();
        Route route = new Route(this.f15342a, this.f15344c, this.f15345d);
        if (this.f15343b.m15925c(route)) {
            this.f15350i.add(route);
            return m15940b();
        }
        return route;
    }

    /* JADX INFO: renamed from: a */
    public void m15938a(Route route, IOException iOException) {
        if (route.m15828b().type() != Proxy.Type.DIRECT && this.f15342a.m15489g() != null) {
            this.f15342a.m15489g().connectFailed(this.f15342a.m15482a().m15647b(), route.m15828b().address(), iOException);
        }
        this.f15343b.m15923a(route);
    }

    /* JADX INFO: renamed from: a */
    private void m15931a(HttpUrl httpUrl, Proxy proxy) {
        if (proxy != null) {
            this.f15346e = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.f15342a.m15489g().select(httpUrl.m15647b());
            this.f15346e = (listSelect == null || listSelect.isEmpty()) ? Util.m15840a(Proxy.NO_PROXY) : Util.m15839a(listSelect);
        }
        this.f15347f = 0;
    }

    /* JADX INFO: renamed from: c */
    private boolean m15932c() {
        return this.f15347f < this.f15346e.size();
    }

    /* JADX INFO: renamed from: d */
    private Proxy m15933d() throws IOException {
        if (!m15932c()) {
            throw new SocketException("No route to " + this.f15342a.m15482a().m15654g() + "; exhausted proxy configurations: " + this.f15346e);
        }
        List<Proxy> list = this.f15346e;
        int i = this.f15347f;
        this.f15347f = i + 1;
        Proxy proxy = list.get(i);
        m15930a(proxy);
        return proxy;
    }

    /* JADX INFO: renamed from: a */
    private void m15930a(Proxy proxy) throws IOException {
        int iM15655h;
        String str;
        this.f15348g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            String strM15654g = this.f15342a.m15482a().m15654g();
            iM15655h = this.f15342a.m15482a().m15655h();
            str = strM15654g;
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            String strM15929a = m15929a(inetSocketAddress);
            iM15655h = inetSocketAddress.getPort();
            str = strM15929a;
        }
        if (iM15655h < 1 || iM15655h > 65535) {
            throw new SocketException("No route to " + str + ":" + iM15655h + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f15348g.add(InetSocketAddress.createUnresolved(str, iM15655h));
        } else {
            List<InetAddress> listMo15602a = this.f15342a.m15484b().mo15602a(str);
            if (listMo15602a.isEmpty()) {
                throw new UnknownHostException(this.f15342a.m15484b() + " returned no addresses for " + str);
            }
            int size = listMo15602a.size();
            for (int i = 0; i < size; i++) {
                this.f15348g.add(new InetSocketAddress(listMo15602a.get(i), iM15655h));
            }
        }
        this.f15349h = 0;
    }

    /* JADX INFO: renamed from: a */
    static String m15929a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    /* JADX INFO: renamed from: e */
    private boolean m15934e() {
        return this.f15349h < this.f15348g.size();
    }

    /* JADX INFO: renamed from: f */
    private InetSocketAddress m15935f() throws IOException {
        if (!m15934e()) {
            throw new SocketException("No route to " + this.f15342a.m15482a().m15654g() + "; exhausted inet socket addresses: " + this.f15348g);
        }
        List<InetSocketAddress> list = this.f15348g;
        int i = this.f15349h;
        this.f15349h = i + 1;
        return list.get(i);
    }

    /* JADX INFO: renamed from: g */
    private boolean m15936g() {
        return !this.f15350i.isEmpty();
    }

    /* JADX INFO: renamed from: h */
    private Route m15937h() {
        return this.f15350i.remove(0);
    }
}
