package okhttp3;

import java.io.Closeable;

public final class Response implements Closeable {
   final Request a;
   final Protocol b;
   final int c;
   final String d;
   final Handshake e;
   final Headers f;
   final ResponseBody g;
   final Response h;
   final Response i;
   final Response j;
   final long k;
   final long l;
   private volatile CacheControl m;

   Response(Response.Builder var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.e = var1.e;
      this.f = var1.f.a();
      this.g = var1.g;
      this.h = var1.h;
      this.i = var1.i;
      this.j = var1.j;
      this.k = var1.k;
      this.l = var1.l;
   }

   public String a(String var1) {
      return this.a(var1, null);
   }

   public String a(String var1, String var2) {
      var1 = this.f.a(var1);
      if (var1 != null) {
         var2 = var1;
      }

      return var2;
   }

   public Request a() {
      return this.a;
   }

   public Protocol b() {
      return this.b;
   }

   public int c() {
      return this.c;
   }

   @Override
   public void close() {
      this.g.close();
   }

   public boolean d() {
      boolean var1;
      if (this.c >= 200 && this.c < 300) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public String e() {
      return this.d;
   }

   public Handshake f() {
      return this.e;
   }

   public Headers g() {
      return this.f;
   }

   public ResponseBody h() {
      return this.g;
   }

   public Response.Builder i() {
      return new Response.Builder(this);
   }

   public Response j() {
      return this.h;
   }

   public CacheControl k() {
      CacheControl var1 = this.m;
      if (var1 == null) {
         var1 = CacheControl.a(this.f);
         this.m = var1;
      }

      return var1;
   }

   public long l() {
      return this.k;
   }

   public long m() {
      return this.l;
   }

   @Override
   public String toString() {
      return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.a() + '}';
   }

   public static class Builder {
      Request a;
      Protocol b;
      int c = -1;
      String d;
      Handshake e;
      Headers.Builder f;
      ResponseBody g;
      Response h;
      Response i;
      Response j;
      long k;
      long l;

      public Builder() {
         this.f = new Headers.Builder();
      }

      Builder(Response var1) {
         this.a = var1.a;
         this.b = var1.b;
         this.c = var1.c;
         this.d = var1.d;
         this.e = var1.e;
         this.f = var1.f.b();
         this.g = var1.g;
         this.h = var1.h;
         this.i = var1.i;
         this.j = var1.j;
         this.k = var1.k;
         this.l = var1.l;
      }

      private void a(String var1, Response var2) {
         if (var2.g != null) {
            throw new IllegalArgumentException(var1 + ".body != null");
         }

         if (var2.h != null) {
            throw new IllegalArgumentException(var1 + ".networkResponse != null");
         }

         if (var2.i != null) {
            throw new IllegalArgumentException(var1 + ".cacheResponse != null");
         }

         if (var2.j != null) {
            throw new IllegalArgumentException(var1 + ".priorResponse != null");
         }
      }

      private void d(Response var1) {
         if (var1.g != null) {
            throw new IllegalArgumentException("priorResponse.body != null");
         }
      }

      public Response.Builder a(int var1) {
         this.c = var1;
         return this;
      }

      public Response.Builder a(long var1) {
         this.k = var1;
         return this;
      }

      public Response.Builder a(String var1) {
         this.d = var1;
         return this;
      }

      public Response.Builder a(String var1, String var2) {
         this.f.c(var1, var2);
         return this;
      }

      public Response.Builder a(Handshake var1) {
         this.e = var1;
         return this;
      }

      public Response.Builder a(Headers var1) {
         this.f = var1.b();
         return this;
      }

      public Response.Builder a(Protocol var1) {
         this.b = var1;
         return this;
      }

      public Response.Builder a(Request var1) {
         this.a = var1;
         return this;
      }

      public Response.Builder a(Response var1) {
         if (var1 != null) {
            this.a("networkResponse", var1);
         }

         this.h = var1;
         return this;
      }

      public Response.Builder a(ResponseBody var1) {
         this.g = var1;
         return this;
      }

      public Response a() {
         if (this.a == null) {
            throw new IllegalStateException("request == null");
         } else if (this.b == null) {
            throw new IllegalStateException("protocol == null");
         } else if (this.c < 0) {
            throw new IllegalStateException("code < 0: " + this.c);
         } else if (this.d == null) {
            throw new IllegalStateException("message == null");
         } else {
            return new Response(this);
         }
      }

      public Response.Builder b(long var1) {
         this.l = var1;
         return this;
      }

      public Response.Builder b(String var1, String var2) {
         this.f.a(var1, var2);
         return this;
      }

      public Response.Builder b(Response var1) {
         if (var1 != null) {
            this.a("cacheResponse", var1);
         }

         this.i = var1;
         return this;
      }

      public Response.Builder c(Response var1) {
         if (var1 != null) {
            this.d(var1);
         }

         this.j = var1;
         return this;
      }
   }
}
