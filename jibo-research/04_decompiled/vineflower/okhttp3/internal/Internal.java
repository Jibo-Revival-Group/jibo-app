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

public abstract class Internal {
   public static Internal a;

   public abstract int a(Response.Builder var1);

   public abstract Socket a(ConnectionPool var1, Address var2, StreamAllocation var3);

   public abstract RealConnection a(ConnectionPool var1, Address var2, StreamAllocation var3, Route var4);

   public abstract RouteDatabase a(ConnectionPool var1);

   public abstract void a(ConnectionSpec var1, SSLSocket var2, boolean var3);

   public abstract void a(Headers.Builder var1, String var2);

   public abstract void a(Headers.Builder var1, String var2, String var3);

   public abstract boolean a(Address var1, Address var2);

   public abstract boolean a(ConnectionPool var1, RealConnection var2);

   public abstract void b(ConnectionPool var1, RealConnection var2);
}
