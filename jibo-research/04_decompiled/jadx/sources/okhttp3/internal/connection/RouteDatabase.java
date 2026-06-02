package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

/* JADX INFO: loaded from: classes2.dex */
public final class RouteDatabase {

    /* JADX INFO: renamed from: a */
    private final Set<Route> f15339a = new LinkedHashSet();

    /* JADX INFO: renamed from: a */
    public synchronized void m15923a(Route route) {
        this.f15339a.add(route);
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m15924b(Route route) {
        this.f15339a.remove(route);
    }

    /* JADX INFO: renamed from: c */
    public synchronized boolean m15925c(Route route) {
        return this.f15339a.contains(route);
    }
}
