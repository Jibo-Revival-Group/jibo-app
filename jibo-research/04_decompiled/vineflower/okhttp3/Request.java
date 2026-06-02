package okhttp3;

import java.util.List;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

public final class Request {
   final HttpUrl a;
   final String b;
   final Headers c;
   final RequestBody d;
   final Object e;
   private volatile CacheControl f;

   Request(Request.Builder var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c.a();
      this.d = var1.d;
      Object var2;
      if (var1.e != null) {
         var2 = var1.e;
      } else {
         var2 = this;
      }

      this.e = var2;
   }

   public String a(String var1) {
      return this.c.a(var1);
   }

   public HttpUrl a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public List<String> b(String var1) {
      return this.c.b(var1);
   }

   public Headers c() {
      return this.c;
   }

   public RequestBody d() {
      return this.d;
   }

   public Request.Builder e() {
      return new Request.Builder(this);
   }

   public CacheControl f() {
      CacheControl var1 = this.f;
      if (var1 == null) {
         var1 = CacheControl.a(this.c);
         this.f = var1;
      }

      return var1;
   }

   public boolean g() {
      return this.a.d();
   }

   @Override
   public String toString() {
      StringBuilder var2 = new StringBuilder().append("Request{method=").append(this.b).append(", url=").append(this.a).append(", tag=");
      Object var1;
      if (this.e != this) {
         var1 = this.e;
      } else {
         var1 = null;
      }

      return var2.append(var1).append('}').toString();
   }

   public static class Builder {
      HttpUrl a;
      String b;
      Headers.Builder c;
      RequestBody d;
      Object e;

      public Builder() {
         this.b = "GET";
         this.c = new Headers.Builder();
      }

      Builder(Request var1) {
         this.a = var1.a;
         this.b = var1.b;
         this.d = var1.d;
         this.e = var1.e;
         this.c = var1.c.b();
      }

      public Request.Builder a() {
         return this.a("GET", (RequestBody)null);
      }

      public Request.Builder a(String var1) {
         if (var1 == null) {
            throw new NullPointerException("url == null");
         }

         String var2;
         if (var1.regionMatches(true, 0, "ws:", 0, 3)) {
            var2 = "http:" + var1.substring(3);
         } else {
            var2 = var1;
            if (var1.regionMatches(true, 0, "wss:", 0, 4)) {
               var2 = "https:" + var1.substring(4);
            }
         }

         HttpUrl var3 = HttpUrl.e(var2);
         if (var3 == null) {
            throw new IllegalArgumentException("unexpected url: " + var2);
         } else {
            return this.a(var3);
         }
      }

      public Request.Builder a(String var1, String var2) {
         this.c.c(var1, var2);
         return this;
      }

      public Request.Builder a(String var1, RequestBody var2) {
         if (var1 == null) {
            throw new NullPointerException("method == null");
         }

         if (var1.length() == 0) {
            throw new IllegalArgumentException("method.length() == 0");
         }

         if (var2 != null && !HttpMethod.c(var1)) {
            throw new IllegalArgumentException("method " + var1 + " must not have a request body.");
         }

         if (var2 == null && HttpMethod.b(var1)) {
            throw new IllegalArgumentException("method " + var1 + " must have a request body.");
         }

         this.b = var1;
         this.d = var2;
         return this;
      }

      public Request.Builder a(Headers var1) {
         this.c = var1.b();
         return this;
      }

      public Request.Builder a(HttpUrl var1) {
         if (var1 == null) {
            throw new NullPointerException("url == null");
         }

         this.a = var1;
         return this;
      }

      public Request.Builder a(RequestBody var1) {
         return this.a("POST", var1);
      }

      public Request.Builder b() {
         return this.b(Util.d);
      }

      public Request.Builder b(String var1) {
         this.c.b(var1);
         return this;
      }

      public Request.Builder b(String var1, String var2) {
         this.c.a(var1, var2);
         return this;
      }

      public Request.Builder b(RequestBody var1) {
         return this.a("DELETE", var1);
      }

      public Request c() {
         if (this.a == null) {
            throw new IllegalStateException("url == null");
         } else {
            return new Request(this);
         }
      }
   }
}
