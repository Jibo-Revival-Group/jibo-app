package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public final class Route {

    /* JADX INFO: renamed from: a */
    final Address f15232a;

    /* JADX INFO: renamed from: b */
    final Proxy f15233b;

    /* JADX INFO: renamed from: c */
    final InetSocketAddress f15234c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f15232a = address;
        this.f15233b = proxy;
        this.f15234c = inetSocketAddress;
    }

    /* JADX INFO: renamed from: a */
    public Address m15827a() {
        return this.f15232a;
    }

    /* JADX INFO: renamed from: b */
    public Proxy m15828b() {
        return this.f15233b;
    }

    /* JADX INFO: renamed from: c */
    public InetSocketAddress m15829c() {
        return this.f15234c;
    }

    /* JADX INFO: renamed from: d */
    public boolean m15830d() {
        return this.f15232a.f14836i != null && this.f15233b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Route) && ((Route) obj).f15232a.equals(this.f15232a) && ((Route) obj).f15233b.equals(this.f15233b) && ((Route) obj).f15234c.equals(this.f15234c);
    }

    public int hashCode() {
        return ((((this.f15232a.hashCode() + 527) * 31) + this.f15233b.hashCode()) * 31) + this.f15234c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f15234c + "}";
    }
}
