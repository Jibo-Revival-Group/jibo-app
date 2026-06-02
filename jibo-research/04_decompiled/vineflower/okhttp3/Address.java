package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.Util;

public final class Address {
   final HttpUrl a;
   final Dns b;
   final SocketFactory c;
   final Authenticator d;
   final List<Protocol> e;
   final List<ConnectionSpec> f;
   final ProxySelector g;
   final Proxy h;
   final SSLSocketFactory i;
   final HostnameVerifier j;
   final CertificatePinner k;

   public Address(
      String var1,
      int var2,
      Dns var3,
      SocketFactory var4,
      SSLSocketFactory var5,
      HostnameVerifier var6,
      CertificatePinner var7,
      Authenticator var8,
      Proxy var9,
      List<Protocol> var10,
      List<ConnectionSpec> var11,
      ProxySelector var12
   ) {
      HttpUrl.Builder var14 = new HttpUrl.Builder();
      String var13;
      if (var5 != null) {
         var13 = "https";
      } else {
         var13 = "http";
      }

      this.a = var14.a(var13).d(var1).a(var2).c();
      if (var3 == null) {
         throw new NullPointerException("dns == null");
      }

      this.b = var3;
      if (var4 == null) {
         throw new NullPointerException("socketFactory == null");
      }

      this.c = var4;
      if (var8 == null) {
         throw new NullPointerException("proxyAuthenticator == null");
      }

      this.d = var8;
      if (var10 == null) {
         throw new NullPointerException("protocols == null");
      }

      this.e = Util.a(var10);
      if (var11 == null) {
         throw new NullPointerException("connectionSpecs == null");
      }

      this.f = Util.a(var11);
      if (var12 == null) {
         throw new NullPointerException("proxySelector == null");
      }

      this.g = var12;
      this.h = var9;
      this.i = var5;
      this.j = var6;
      this.k = var7;
   }

   public HttpUrl a() {
      return this.a;
   }

   boolean a(Address var1) {
      boolean var2;
      if (this.b.equals(var1.b)
         && this.d.equals(var1.d)
         && this.e.equals(var1.e)
         && this.f.equals(var1.f)
         && this.g.equals(var1.g)
         && Util.a(this.h, var1.h)
         && Util.a(this.i, var1.i)
         && Util.a(this.j, var1.j)
         && Util.a(this.k, var1.k)
         && this.a().h() == var1.a().h()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public Dns b() {
      return this.b;
   }

   public SocketFactory c() {
      return this.c;
   }

   public Authenticator d() {
      return this.d;
   }

   public List<Protocol> e() {
      return this.e;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof Address && this.a.equals(((Address)var1).a) && this.a((Address)var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public List<ConnectionSpec> f() {
      return this.f;
   }

   public ProxySelector g() {
      return this.g;
   }

   public Proxy h() {
      return this.h;
   }

   @Override
   public int hashCode() {
      int var4 = 0;
      int var9 = this.a.hashCode();
      int var6 = this.b.hashCode();
      int var7 = this.d.hashCode();
      int var5 = this.e.hashCode();
      int var10 = this.f.hashCode();
      int var8 = this.g.hashCode();
      int var1;
      if (this.h != null) {
         var1 = this.h.hashCode();
      } else {
         var1 = 0;
      }

      int var2;
      if (this.i != null) {
         var2 = this.i.hashCode();
      } else {
         var2 = 0;
      }

      int var3;
      if (this.j != null) {
         var3 = this.j.hashCode();
      } else {
         var3 = 0;
      }

      if (this.k != null) {
         var4 = this.k.hashCode();
      }

      return (var3 + (var2 + (var1 + ((((((var9 + 527) * 31 + var6) * 31 + var7) * 31 + var5) * 31 + var10) * 31 + var8) * 31) * 31) * 31) * 31 + var4;
   }

   public SSLSocketFactory i() {
      return this.i;
   }

   public HostnameVerifier j() {
      return this.j;
   }

   public CertificatePinner k() {
      return this.k;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder().append("Address{").append(this.a.g()).append(":").append(this.a.h());
      if (this.h != null) {
         var1.append(", proxy=").append(this.h);
      } else {
         var1.append(", proxySelector=").append(this.g);
      }

      var1.append("}");
      return var1.toString();
   }
}
