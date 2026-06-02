package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

public class OkHttpClient implements Cloneable, Call.Factory {
   static final List<Protocol> a = Util.a(Protocol.HTTP_2, Protocol.HTTP_1_1);
   static final List<ConnectionSpec> b = Util.a(ConnectionSpec.a, ConnectionSpec.c);
   final int A;
   final int B;
   final int C;
   final Dispatcher c;
   final Proxy d;
   final List<Protocol> e;
   final List<ConnectionSpec> f;
   final List<Interceptor> g;
   final List<Interceptor> h;
   final EventListener.Factory i;
   final ProxySelector j;
   final CookieJar k;
   final Cache l;
   final InternalCache m;
   final SocketFactory n;
   final SSLSocketFactory o;
   final CertificateChainCleaner p;
   final HostnameVerifier q;
   final CertificatePinner r;
   final Authenticator s;
   final Authenticator t;
   final ConnectionPool u;
   final Dns v;
   final boolean w;
   final boolean x;
   final boolean y;
   final int z;

   static {
      Internal.a = new Internal() {
         @Override
         public int a(Response.Builder var1) {
            return var1.c;
         }

         @Override
         public Socket a(ConnectionPool var1, Address var2, StreamAllocation var3) {
            return var1.a(var2, var3);
         }

         @Override
         public RealConnection a(ConnectionPool var1, Address var2, StreamAllocation var3, Route var4) {
            return var1.a(var2, var3, var4);
         }

         @Override
         public RouteDatabase a(ConnectionPool var1) {
            return var1.a;
         }

         @Override
         public void a(ConnectionSpec var1, SSLSocket var2, boolean var3) {
            var1.a(var2, var3);
         }

         @Override
         public void a(Headers.Builder var1, String var2) {
            var1.a(var2);
         }

         @Override
         public void a(Headers.Builder var1, String var2, String var3) {
            var1.b(var2, var3);
         }

         @Override
         public boolean a(Address var1, Address var2) {
            return var1.a(var2);
         }

         @Override
         public boolean a(ConnectionPool var1, RealConnection var2) {
            return var1.b(var2);
         }

         @Override
         public void b(ConnectionPool var1, RealConnection var2) {
            var1.a(var2);
         }
      };
   }

   public OkHttpClient() {
      this(new OkHttpClient.Builder());
   }

   OkHttpClient(OkHttpClient.Builder var1) {
      this.c = var1.a;
      this.d = var1.b;
      this.e = var1.c;
      this.f = var1.d;
      this.g = Util.a(var1.e);
      this.h = Util.a(var1.f);
      this.i = var1.g;
      this.j = var1.h;
      this.k = var1.i;
      this.l = var1.j;
      this.m = var1.k;
      this.n = var1.l;
      Iterator var4 = this.f.iterator();
      boolean var2 = false;

      while (var4.hasNext()) {
         ConnectionSpec var3 = (ConnectionSpec)var4.next();
         if (!var2 && !var3.a()) {
            var2 = false;
         } else {
            var2 = true;
         }
      }

      if (var1.m == null && var2) {
         X509TrustManager var5 = this.z();
         this.o = this.a(var5);
         this.p = CertificateChainCleaner.a(var5);
      } else {
         this.o = var1.m;
         this.p = var1.n;
      }

      this.q = var1.o;
      this.r = var1.p.a(this.p);
      this.s = var1.q;
      this.t = var1.r;
      this.u = var1.s;
      this.v = var1.t;
      this.w = var1.u;
      this.x = var1.v;
      this.y = var1.w;
      this.z = var1.x;
      this.A = var1.y;
      this.B = var1.z;
      this.C = var1.A;
   }

   private SSLSocketFactory a(X509TrustManager var1) {
      try {
         SSLContext var2 = SSLContext.getInstance("TLS");
         var2.init(null, new TrustManager[]{var1}, null);
         return var2.getSocketFactory();
      } catch (GeneralSecurityException var3) {
         throw new AssertionError();
      }
   }

   private X509TrustManager z() {
      try {
         TrustManagerFactory var1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
         var1.init((KeyStore)null);
         TrustManager[] var5 = var1.getTrustManagers();
         if (var5.length == 1 && var5[0] instanceof X509TrustManager) {
            return (X509TrustManager)var5[0];
         }

         StringBuilder var2 = new StringBuilder();
         IllegalStateException var3 = new IllegalStateException(var2.append("Unexpected default trust managers:").append(Arrays.toString(var5)).toString());
         throw var3;
      } catch (GeneralSecurityException var4) {
         throw new AssertionError();
      }
   }

   public int a() {
      return this.z;
   }

   @Override
   public Call a(Request var1) {
      return new RealCall(this, var1, false);
   }

   public int b() {
      return this.A;
   }

   public int c() {
      return this.B;
   }

   public Proxy d() {
      return this.d;
   }

   public ProxySelector e() {
      return this.j;
   }

   public CookieJar f() {
      return this.k;
   }

   InternalCache g() {
      InternalCache var1;
      if (this.l != null) {
         var1 = this.l.a;
      } else {
         var1 = this.m;
      }

      return var1;
   }

   public Dns h() {
      return this.v;
   }

   public SocketFactory i() {
      return this.n;
   }

   public SSLSocketFactory j() {
      return this.o;
   }

   public HostnameVerifier k() {
      return this.q;
   }

   public CertificatePinner l() {
      return this.r;
   }

   public Authenticator m() {
      return this.t;
   }

   public Authenticator n() {
      return this.s;
   }

   public ConnectionPool o() {
      return this.u;
   }

   public boolean p() {
      return this.w;
   }

   public boolean q() {
      return this.x;
   }

   public boolean r() {
      return this.y;
   }

   public Dispatcher s() {
      return this.c;
   }

   public List<Protocol> t() {
      return this.e;
   }

   public List<ConnectionSpec> u() {
      return this.f;
   }

   public List<Interceptor> v() {
      return this.g;
   }

   public List<Interceptor> w() {
      return this.h;
   }

   EventListener.Factory x() {
      return this.i;
   }

   public OkHttpClient.Builder y() {
      return new OkHttpClient.Builder(this);
   }

   public static final class Builder {
      int A;
      Dispatcher a;
      Proxy b;
      List<Protocol> c;
      List<ConnectionSpec> d;
      final List<Interceptor> e = new ArrayList<>();
      final List<Interceptor> f = new ArrayList<>();
      EventListener.Factory g;
      ProxySelector h;
      CookieJar i;
      Cache j;
      InternalCache k;
      SocketFactory l;
      SSLSocketFactory m;
      CertificateChainCleaner n;
      HostnameVerifier o;
      CertificatePinner p;
      Authenticator q;
      Authenticator r;
      ConnectionPool s;
      Dns t;
      boolean u;
      boolean v;
      boolean w;
      int x;
      int y;
      int z;

      public Builder() {
         this.a = new Dispatcher();
         this.c = OkHttpClient.a;
         this.d = OkHttpClient.b;
         this.g = EventListener.a(EventListener.a);
         this.h = ProxySelector.getDefault();
         this.i = CookieJar.a;
         this.l = SocketFactory.getDefault();
         this.o = OkHostnameVerifier.a;
         this.p = CertificatePinner.a;
         this.q = Authenticator.a;
         this.r = Authenticator.a;
         this.s = new ConnectionPool();
         this.t = Dns.a;
         this.u = true;
         this.v = true;
         this.w = true;
         this.x = 10000;
         this.y = 10000;
         this.z = 10000;
         this.A = 0;
      }

      Builder(OkHttpClient var1) {
         this.a = var1.c;
         this.b = var1.d;
         this.c = var1.e;
         this.d = var1.f;
         this.e.addAll(var1.g);
         this.f.addAll(var1.h);
         this.g = var1.i;
         this.h = var1.j;
         this.i = var1.k;
         this.k = var1.m;
         this.j = var1.l;
         this.l = var1.n;
         this.m = var1.o;
         this.n = var1.p;
         this.o = var1.q;
         this.p = var1.r;
         this.q = var1.s;
         this.r = var1.t;
         this.s = var1.u;
         this.t = var1.v;
         this.u = var1.w;
         this.v = var1.x;
         this.w = var1.y;
         this.x = var1.z;
         this.y = var1.A;
         this.z = var1.B;
         this.A = var1.C;
      }

      private static int a(String var0, long var1, TimeUnit var3) {
         if (var1 < 0L) {
            throw new IllegalArgumentException(var0 + " < 0");
         } else if (var3 == null) {
            throw new NullPointerException("unit == null");
         } else {
            long var4 = var3.toMillis(var1);
            if (var4 > 2147483647L) {
               throw new IllegalArgumentException(var0 + " too large.");
            } else if (var4 == 0L && var1 > 0L) {
               throw new IllegalArgumentException(var0 + " too small.");
            } else {
               return (int)var4;
            }
         }
      }

      public OkHttpClient.Builder a(long var1, TimeUnit var3) {
         this.x = a("timeout", var1, var3);
         return this;
      }

      public OkHttpClient.Builder a(Proxy var1) {
         this.b = var1;
         return this;
      }

      public OkHttpClient.Builder a(List<ConnectionSpec> var1) {
         this.d = Util.a(var1);
         return this;
      }

      public OkHttpClient.Builder a(SSLSocketFactory var1) {
         if (var1 == null) {
            throw new NullPointerException("sslSocketFactory == null");
         }

         X509TrustManager var2 = Platform.b().a(var1);
         if (var2 == null) {
            throw new IllegalStateException("Unable to extract the trust manager on " + Platform.b() + ", sslSocketFactory is " + var1.getClass());
         }

         this.m = var1;
         this.n = CertificateChainCleaner.a(var2);
         return this;
      }

      public OkHttpClient.Builder a(SSLSocketFactory var1, X509TrustManager var2) {
         if (var1 == null) {
            throw new NullPointerException("sslSocketFactory == null");
         }

         if (var2 == null) {
            throw new NullPointerException("trustManager == null");
         }

         this.m = var1;
         this.n = CertificateChainCleaner.a(var2);
         return this;
      }

      public OkHttpClient.Builder a(Authenticator var1) {
         if (var1 == null) {
            throw new NullPointerException("proxyAuthenticator == null");
         }

         this.q = var1;
         return this;
      }

      public OkHttpClient.Builder a(Cache var1) {
         this.j = var1;
         this.k = null;
         return this;
      }

      public OkHttpClient.Builder a(Dispatcher var1) {
         if (var1 == null) {
            throw new IllegalArgumentException("dispatcher == null");
         }

         this.a = var1;
         return this;
      }

      public OkHttpClient.Builder a(Interceptor var1) {
         this.e.add(var1);
         return this;
      }

      public OkHttpClient a() {
         return new OkHttpClient(this);
      }

      public OkHttpClient.Builder b(long var1, TimeUnit var3) {
         this.y = a("timeout", var1, var3);
         return this;
      }

      public OkHttpClient.Builder b(Interceptor var1) {
         this.f.add(var1);
         return this;
      }

      public OkHttpClient.Builder c(long var1, TimeUnit var3) {
         this.z = a("timeout", var1, var3);
         return this;
      }
   }
}
