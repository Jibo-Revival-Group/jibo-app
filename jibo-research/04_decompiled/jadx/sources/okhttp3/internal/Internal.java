package okhttp3.internal;

import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Internal {

    /* JADX INFO: renamed from: a */
    public static Internal f15235a;

    /* JADX INFO: renamed from: a */
    public abstract int mo15732a(Response.Builder builder);

    /* JADX INFO: renamed from: a */
    public abstract Socket mo15733a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation);

    /* JADX INFO: renamed from: a */
    public abstract RealConnection mo15734a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route);

    /* JADX INFO: renamed from: a */
    public abstract RouteDatabase mo15735a(ConnectionPool connectionPool);

    /* JADX INFO: renamed from: a */
    public abstract void mo15736a(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z);

    /* JADX INFO: renamed from: a */
    public abstract void mo15737a(Headers.Builder builder, String str);

    /* JADX INFO: renamed from: a */
    public abstract void mo15738a(Headers.Builder builder, String str, String str2);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo15739a(Address address, Address address2);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo15740a(ConnectionPool connectionPool, RealConnection realConnection);

    /* JADX INFO: renamed from: b */
    public abstract void mo15741b(ConnectionPool connectionPool, RealConnection realConnection);
}
