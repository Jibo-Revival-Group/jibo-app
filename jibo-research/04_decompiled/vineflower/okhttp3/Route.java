package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public final class Route {
   final Address a;
   final Proxy b;
   final InetSocketAddress c;

   public Route(Address var1, Proxy var2, InetSocketAddress var3) {
      if (var1 == null) {
         throw new NullPointerException("address == null");
      }

      if (var2 == null) {
         throw new NullPointerException("proxy == null");
      }

      if (var3 == null) {
         throw new NullPointerException("inetSocketAddress == null");
      }

      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public Address a() {
      return this.a;
   }

   public Proxy b() {
      return this.b;
   }

   public InetSocketAddress c() {
      return this.c;
   }

   public boolean d() {
      boolean var1;
      if (this.a.i != null && this.b.type() == Type.HTTP) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof Route && ((Route)var1).a.equals(this.a) && ((Route)var1).b.equals(this.b) && ((Route)var1).c.equals(this.c)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return ((this.a.hashCode() + 527) * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
   }

   @Override
   public String toString() {
      return "Route{" + this.c + "}";
   }
}
