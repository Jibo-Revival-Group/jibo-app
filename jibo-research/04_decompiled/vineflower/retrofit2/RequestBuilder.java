package retrofit2;

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

final class RequestBuilder {
   private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
   private final String b;
   private final HttpUrl c;
   private String d;
   private HttpUrl.Builder e;
   private final Request.Builder f;
   private MediaType g;
   private final boolean h;
   private MultipartBody.Builder i;
   private FormBody.Builder j;
   private RequestBody k;

   RequestBuilder(String var1, HttpUrl var2, String var3, Headers var4, MediaType var5, boolean var6, boolean var7, boolean var8) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.f = new Request.Builder();
      this.g = var5;
      this.h = var6;
      if (var4 != null) {
         this.f.a(var4);
      }

      if (var7) {
         this.j = new FormBody.Builder();
      } else if (var8) {
         this.i = new MultipartBody.Builder();
         this.i.a(MultipartBody.e);
      }
   }

   private static String a(String var0, boolean var1) {
      int var3 = var0.length();
      int var2 = 0;

      String var5;
      while (true) {
         var5 = var0;
         if (var2 >= var3) {
            break;
         }

         int var4 = var0.codePointAt(var2);
         if (var4 < 32 || var4 >= 127 || " \"<>^`{}|\\?#".indexOf(var4) != -1 || !var1 && (var4 == 47 || var4 == 37)) {
            Buffer var6 = new Buffer();
            var6.a(var0, 0, var2);
            a(var6, var0, var2, var3, var1);
            var5 = var6.q();
            break;
         }

         var2 += Character.charCount(var4);
      }

      return var5;
   }

   private static void a(Buffer var0, String var1, int var2, int var3, boolean var4) {
      Buffer var8 = null;

      while (var2 < var3) {
         int var5;
         Buffer var9;
         label62: {
            var5 = var1.codePointAt(var2);
            if (var4) {
               var9 = var8;
               if (var5 == 9) {
                  break label62;
               }

               var9 = var8;
               if (var5 == 10) {
                  break label62;
               }

               var9 = var8;
               if (var5 == 12) {
                  break label62;
               }

               if (var5 == 13) {
                  var9 = var8;
                  break label62;
               }
            }

            if (var5 < 32 || var5 >= 127 || " \"<>^`{}|\\?#".indexOf(var5) != -1 || !var4 && (var5 == 47 || var5 == 37)) {
               Buffer var7 = var8;
               if (var8 == null) {
                  var7 = new Buffer();
               }

               var7.a(var5);

               while (true) {
                  var9 = var7;
                  if (var7.f()) {
                     break;
                  }

                  int var6 = var7.i() & 255;
                  var0.b(37);
                  var0.b(a[var6 >> 4 & 15]);
                  var0.b(a[var6 & 15]);
               }
            } else {
               var0.a(var5);
               var9 = var8;
            }
         }

         var2 += Character.charCount(var5);
         var8 = var9;
      }
   }

   Request a() {
      HttpUrl.Builder var1 = this.e;
      HttpUrl var2;
      if (var1 != null) {
         var2 = var1.c();
      } else {
         HttpUrl var5 = this.c.c(this.d);
         var2 = var5;
         if (var5 == null) {
            throw new IllegalArgumentException("Malformed URL. Base: " + this.c + ", Relative: " + this.d);
         }
      }

      RequestBody var3 = this.k;
      RequestBody var6 = var3;
      if (var3 == null) {
         if (this.j != null) {
            var6 = this.j.a();
         } else if (this.i != null) {
            var6 = this.i.a();
         } else {
            var6 = var3;
            if (this.h) {
               var6 = RequestBody.a(null, new byte[0]);
            }
         }
      }

      MediaType var4 = this.g;
      var3 = var6;
      if (var4 != null) {
         if (var6 != null) {
            var3 = new RequestBuilder.ContentTypeOverridingRequestBody(var6, var4);
         } else {
            this.f.b("Content-Type", var4.toString());
            var3 = var6;
         }
      }

      return this.f.a(var2).a(this.b, var3).c();
   }

   void a(Object var1) {
      this.d = var1.toString();
   }

   void a(String var1, String var2) {
      if ("Content-Type".equalsIgnoreCase(var1)) {
         MediaType var3 = MediaType.a(var2);
         if (var3 == null) {
            throw new IllegalArgumentException("Malformed content type: " + var2);
         }

         this.g = var3;
      } else {
         this.f.b(var1, var2);
      }
   }

   void a(String var1, String var2, boolean var3) {
      if (this.d == null) {
         throw new AssertionError();
      }

      this.d = this.d.replace("{" + var1 + "}", a(var2, var3));
   }

   void a(Headers var1, RequestBody var2) {
      this.i.a(var1, var2);
   }

   void a(MultipartBody.Part var1) {
      this.i.a(var1);
   }

   void a(RequestBody var1) {
      this.k = var1;
   }

   void b(String var1, String var2, boolean var3) {
      if (this.d != null) {
         this.e = this.c.d(this.d);
         if (this.e == null) {
            throw new IllegalArgumentException("Malformed URL. Base: " + this.c + ", Relative: " + this.d);
         }

         this.d = null;
      }

      if (var3) {
         this.e.b(var1, var2);
      } else {
         this.e.a(var1, var2);
      }
   }

   void c(String var1, String var2, boolean var3) {
      if (var3) {
         this.j.b(var1, var2);
      } else {
         this.j.a(var1, var2);
      }
   }

   private static class ContentTypeOverridingRequestBody extends RequestBody {
      private final RequestBody a;
      private final MediaType b;

      ContentTypeOverridingRequestBody(RequestBody var1, MediaType var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public MediaType a() {
         return this.b;
      }

      @Override
      public void a(BufferedSink var1) throws IOException {
         this.a.a(var1);
      }

      @Override
      public long b() throws IOException {
         return this.a.b();
      }
   }
}
