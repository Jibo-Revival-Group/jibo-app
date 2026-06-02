package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.Proxy.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

public final class RouteSelector {
   private final Address a;
   private final RouteDatabase b;
   private Proxy c;
   private InetSocketAddress d;
   private List<Proxy> e = Collections.emptyList();
   private int f;
   private List<InetSocketAddress> g = Collections.emptyList();
   private int h;
   private final List<Route> i = new ArrayList<>();

   public RouteSelector(Address var1, RouteDatabase var2) {
      this.a = var1;
      this.b = var2;
      this.a(var1.a(), var1.h());
   }

   static String a(InetSocketAddress var0) {
      InetAddress var1 = var0.getAddress();
      String var2;
      if (var1 == null) {
         var2 = var0.getHostName();
      } else {
         var2 = var1.getHostAddress();
      }

      return var2;
   }

   private void a(Proxy var1) throws IOException {
      this.g = new ArrayList<>();
      int var2;
      String var5;
      if (var1.type() != Type.DIRECT && var1.type() != Type.SOCKS) {
         SocketAddress var8 = var1.address();
         if (!(var8 instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + var8.getClass());
         }

         InetSocketAddress var6 = (InetSocketAddress)var8;
         var5 = a(var6);
         var2 = var6.getPort();
      } else {
         var5 = this.a.a().g();
         var2 = this.a.a().h();
      }

      if (var2 >= 1 && var2 <= 65535) {
         if (var1.type() == Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(var5, var2));
         } else {
            List var7 = this.a.b().a(var5);
            if (var7.isEmpty()) {
               throw new UnknownHostException(this.a.b() + " returned no addresses for " + var5);
            }

            int var4 = var7.size();

            for (int var3 = 0; var3 < var4; var3++) {
               InetAddress var9 = (InetAddress)var7.get(var3);
               this.g.add(new InetSocketAddress(var9, var2));
            }
         }

         this.h = 0;
      } else {
         throw new SocketException("No route to " + var5 + ":" + var2 + "; port is out of range");
      }
   }

   private void a(HttpUrl var1, Proxy var2) {
      if (var2 != null) {
         this.e = Collections.singletonList(var2);
      } else {
         List var3 = this.a.g().select(var1.b());
         List var4;
         if (var3 != null && !var3.isEmpty()) {
            var4 = Util.a(var3);
         } else {
            var4 = Util.a(Proxy.NO_PROXY);
         }

         this.e = var4;
      }

      this.f = 0;
   }

   private boolean c() {
      boolean var1;
      if (this.f < this.e.size()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private Proxy d() throws IOException {
      if (!this.c()) {
         throw new SocketException("No route to " + this.a.a().g() + "; exhausted proxy configurations: " + this.e);
      }

      List var2 = this.e;
      int var1 = this.f++;
      Proxy var3 = (Proxy)var2.get(var1);
      this.a(var3);
      return var3;
   }

   private boolean e() {
      boolean var1;
      if (this.h < this.g.size()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private InetSocketAddress f() throws IOException {
      if (!this.e()) {
         throw new SocketException("No route to " + this.a.a().g() + "; exhausted inet socket addresses: " + this.g);
      }

      List var2 = this.g;
      int var1 = this.h++;
      return (InetSocketAddress)var2.get(var1);
   }

   private boolean g() {
      boolean var1;
      if (!this.i.isEmpty()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private Route h() {
      return this.i.remove(0);
   }

   public void a(Route var1, IOException var2) {
      if (var1.b().type() != Type.DIRECT && this.a.g() != null) {
         this.a.g().connectFailed(this.a.a().b(), var1.b().address(), var2);
      }

      this.b.a(var1);
   }

   public boolean a() {
      boolean var1;
      if (!this.e() && !this.c() && !this.g()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public Route b() throws IOException {
      if (!this.e()) {
         if (!this.c()) {
            if (!this.g()) {
               throw new NoSuchElementException();
            }

            Route var3 = this.h();
            return var3;
         }

         this.c = this.d();
      }

      this.d = this.f();
      Route var2 = new Route(this.a, this.c, this.d);
      Route var1 = var2;
      if (this.b.c(var2)) {
         this.i.add(var2);
         var1 = this.b();
      }

      return var1;
   }
}
