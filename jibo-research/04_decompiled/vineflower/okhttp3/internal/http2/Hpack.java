package okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class Hpack {
   static final Header[] a = new Header[]{
      new Header(Header.f, ""),
      new Header(Header.c, "GET"),
      new Header(Header.c, "POST"),
      new Header(Header.d, "/"),
      new Header(Header.d, "/index.html"),
      new Header(Header.e, "http"),
      new Header(Header.e, "https"),
      new Header(Header.b, "200"),
      new Header(Header.b, "204"),
      new Header(Header.b, "206"),
      new Header(Header.b, "304"),
      new Header(Header.b, "400"),
      new Header(Header.b, "404"),
      new Header(Header.b, "500"),
      new Header("accept-charset", ""),
      new Header("accept-encoding", "gzip, deflate"),
      new Header("accept-language", ""),
      new Header("accept-ranges", ""),
      new Header("accept", ""),
      new Header("access-control-allow-origin", ""),
      new Header("age", ""),
      new Header("allow", ""),
      new Header("authorization", ""),
      new Header("cache-control", ""),
      new Header("content-disposition", ""),
      new Header("content-encoding", ""),
      new Header("content-language", ""),
      new Header("content-length", ""),
      new Header("content-location", ""),
      new Header("content-range", ""),
      new Header("content-type", ""),
      new Header("cookie", ""),
      new Header("date", ""),
      new Header("etag", ""),
      new Header("expect", ""),
      new Header("expires", ""),
      new Header("from", ""),
      new Header("host", ""),
      new Header("if-match", ""),
      new Header("if-modified-since", ""),
      new Header("if-none-match", ""),
      new Header("if-range", ""),
      new Header("if-unmodified-since", ""),
      new Header("last-modified", ""),
      new Header("link", ""),
      new Header("location", ""),
      new Header("max-forwards", ""),
      new Header("proxy-authenticate", ""),
      new Header("proxy-authorization", ""),
      new Header("range", ""),
      new Header("referer", ""),
      new Header("refresh", ""),
      new Header("retry-after", ""),
      new Header("server", ""),
      new Header("set-cookie", ""),
      new Header("strict-transport-security", ""),
      new Header("transfer-encoding", ""),
      new Header("user-agent", ""),
      new Header("vary", ""),
      new Header("via", ""),
      new Header("www-authenticate", "")
   };
   static final Map<ByteString, Integer> b = a();

   private static Map<ByteString, Integer> a() {
      LinkedHashMap var1 = new LinkedHashMap(a.length);

      for (int var0 = 0; var0 < a.length; var0++) {
         if (!var1.containsKey(a[var0].g)) {
            var1.put(a[var0].g, var0);
         }
      }

      return Collections.unmodifiableMap(var1);
   }

   static ByteString a(ByteString var0) throws IOException {
      int var1 = 0;

      for (int var2 = var0.h(); var1 < var2; var1++) {
         byte var3 = var0.a(var1);
         if (var3 >= 65 && var3 <= 90) {
            throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + var0.a());
         }
      }

      return var0;
   }

   static final class Reader {
      Header[] a;
      int b;
      int c;
      int d;
      private final List<Header> e = new ArrayList<>();
      private final BufferedSource f;
      private final int g;
      private int h;

      Reader(int var1, int var2, Source var3) {
         this.a = new Header[8];
         this.b = this.a.length - 1;
         this.c = 0;
         this.d = 0;
         this.g = var1;
         this.h = var2;
         this.f = Okio.a(var3);
      }

      Reader(int var1, Source var2) {
         this(var1, var1, var2);
      }

      private int a(int var1) {
         int var2 = 0;
         byte var3 = 0;
         if (var1 > 0) {
            int var4 = this.a.length - 1;
            var2 = var1;
            var1 = var3;

            for (int var7 = var4; var7 >= this.b && var2 > 0; var7--) {
               var2 -= this.a[var7].i;
               this.d = this.d - this.a[var7].i;
               this.c--;
               var1++;
            }

            System.arraycopy(this.a, this.b + 1, this.a, this.b + 1 + var1, this.c);
            this.b += var1;
            var2 = var1;
         }

         return var2;
      }

      private void a(int var1, Header var2) {
         this.e.add(var2);
         int var4 = var2.i;
         int var3 = var4;
         if (var1 != -1) {
            var3 = var4 - this.a[this.c(var1)].i;
         }

         if (var3 > this.h) {
            this.e();
         } else {
            var4 = this.a(this.d + var3 - this.h);
            if (var1 == -1) {
               if (this.c + 1 > this.a.length) {
                  Header[] var6 = new Header[this.a.length * 2];
                  System.arraycopy(this.a, 0, var6, this.a.length, this.a.length);
                  this.b = this.a.length - 1;
                  this.a = var6;
               }

               var1 = this.b--;
               this.a[var1] = var2;
               this.c++;
            } else {
               int var5 = this.c(var1);
               this.a[var4 + var5 + var1] = var2;
            }

            this.d += var3;
         }
      }

      private void b(int var1) throws IOException {
         if (this.g(var1)) {
            Header var3 = Hpack.a[var1];
            this.e.add(var3);
         } else {
            int var2 = this.c(var1 - Hpack.a.length);
            if (var2 < 0 || var2 > this.a.length - 1) {
               throw new IOException("Header index too large " + (var1 + 1));
            }

            this.e.add(this.a[var2]);
         }
      }

      private int c(int var1) {
         return this.b + 1 + var1;
      }

      private void d() {
         if (this.h < this.d) {
            if (this.h == 0) {
               this.e();
            } else {
               this.a(this.d - this.h);
            }
         }
      }

      private void d(int var1) throws IOException {
         ByteString var3 = this.f(var1);
         ByteString var2 = this.c();
         this.e.add(new Header(var3, var2));
      }

      private void e() {
         Arrays.fill(this.a, null);
         this.b = this.a.length - 1;
         this.c = 0;
         this.d = 0;
      }

      private void e(int var1) throws IOException {
         this.a(-1, new Header(this.f(var1), this.c()));
      }

      private ByteString f(int var1) {
         ByteString var2;
         if (this.g(var1)) {
            var2 = Hpack.a[var1].g;
         } else {
            var2 = this.a[this.c(var1 - Hpack.a.length)].g;
         }

         return var2;
      }

      private void f() throws IOException {
         ByteString var2 = Hpack.a(this.c());
         ByteString var1 = this.c();
         this.e.add(new Header(var2, var1));
      }

      private void g() throws IOException {
         this.a(-1, new Header(Hpack.a(this.c()), this.c()));
      }

      private boolean g(int var1) {
         boolean var2;
         if (var1 >= 0 && var1 <= Hpack.a.length - 1) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      private int h() throws IOException {
         return this.f.i() & 0xFF;
      }

      int a(int var1, int var2) throws IOException {
         var1 &= var2;
         if (var1 >= var2) {
            byte var5 = 0;

            while (true) {
               int var3 = this.h();
               if ((var3 & 128) == 0) {
                  var1 = (var3 << var5) + var2;
                  break;
               }

               var2 += (var3 & 127) << var5;
               var5 += 7;
            }
         }

         return var1;
      }

      void a() throws IOException {
         while (!this.f.f()) {
            int var1 = this.f.i() & 255;
            if (var1 == 128) {
               throw new IOException("index == 0");
            }

            if ((var1 & 128) == 128) {
               this.b(this.a(var1, 127) - 1);
            } else if (var1 == 64) {
               this.g();
            } else if ((var1 & 64) == 64) {
               this.e(this.a(var1, 63) - 1);
            } else if ((var1 & 32) == 32) {
               this.h = this.a(var1, 31);
               if (this.h < 0 || this.h > this.g) {
                  throw new IOException("Invalid dynamic table size update " + this.h);
               }

               this.d();
            } else if (var1 != 16 && var1 != 0) {
               this.d(this.a(var1, 15) - 1);
            } else {
               this.f();
            }
         }
      }

      public List<Header> b() {
         ArrayList var1 = new ArrayList<>(this.e);
         this.e.clear();
         return var1;
      }

      ByteString c() throws IOException {
         int var2 = this.h();
         boolean var1;
         if ((var2 & 128) == 128) {
            var1 = true;
         } else {
            var1 = false;
         }

         var2 = this.a(var2, 127);
         ByteString var3;
         if (var1) {
            var3 = ByteString.a(Huffman.a().a(this.f.h(var2)));
         } else {
            var3 = this.f.d(var2);
         }

         return var3;
      }
   }

   static final class Writer {
      int a;
      int b;
      Header[] c;
      int d;
      int e;
      int f;
      private final Buffer g;
      private final boolean h;
      private int i = Integer.MAX_VALUE;
      private boolean j;

      Writer(int var1, boolean var2, Buffer var3) {
         this.c = new Header[8];
         this.d = this.c.length - 1;
         this.e = 0;
         this.f = 0;
         this.a = var1;
         this.b = var1;
         this.h = var2;
         this.g = var3;
      }

      Writer(Buffer var1) {
         this(4096, true, var1);
      }

      private void a() {
         Arrays.fill(this.c, null);
         this.d = this.c.length - 1;
         this.e = 0;
         this.f = 0;
      }

      private void a(Header var1) {
         int var3 = var1.i;
         if (var3 > this.b) {
            this.a();
         } else {
            this.b(this.f + var3 - this.b);
            if (this.e + 1 > this.c.length) {
               Header[] var4 = new Header[this.c.length * 2];
               System.arraycopy(this.c, 0, var4, this.c.length, this.c.length);
               this.d = this.c.length - 1;
               this.c = var4;
            }

            int var2 = this.d--;
            this.c[var2] = var1;
            this.e++;
            this.f += var3;
         }
      }

      private int b(int var1) {
         int var2 = 0;
         byte var3 = 0;
         if (var1 > 0) {
            int var4 = this.c.length - 1;
            var2 = var1;
            var1 = var3;

            for (int var7 = var4; var7 >= this.d && var2 > 0; var7--) {
               var2 -= this.c[var7].i;
               this.f = this.f - this.c[var7].i;
               this.e--;
               var1++;
            }

            System.arraycopy(this.c, this.d + 1, this.c, this.d + 1 + var1, this.e);
            Arrays.fill(this.c, this.d + 1, this.d + 1 + var1, null);
            this.d += var1;
            var2 = var1;
         }

         return var2;
      }

      private void b() {
         if (this.b < this.f) {
            if (this.b == 0) {
               this.a();
            } else {
               this.b(this.f - this.b);
            }
         }
      }

      void a(int var1) {
         this.a = var1;
         var1 = Math.min(var1, 16384);
         if (this.b != var1) {
            if (var1 < this.b) {
               this.i = Math.min(this.i, var1);
            }

            this.j = true;
            this.b = var1;
            this.b();
         }
      }

      void a(int var1, int var2, int var3) {
         if (var1 < var2) {
            this.g.b(var3 | var1);
         } else {
            this.g.b(var3 | var2);

            for (var1 -= var2; var1 >= 128; var1 >>>= 7) {
               this.g.b(var1 & 127 | 128);
            }

            this.g.b(var1);
         }
      }

      void a(List<Header> var1) throws IOException {
         if (this.j) {
            if (this.i < this.b) {
               this.a(this.i, 31, 32);
            }

            this.j = false;
            this.i = Integer.MAX_VALUE;
            this.a(this.b, 31, 32);
         }

         int var8 = var1.size();

         for (int var4 = 0; var4 < var8; var4++) {
            int var2;
            int var3;
            ByteString var10;
            Header var11;
            ByteString var12;
            var11 = (Header)var1.get(var4);
            var12 = var11.g.g();
            var10 = var11.h;
            Integer var13 = Hpack.b.get(var12);
            label51:
            if (var13 != null) {
               var3 = var13 + 1;
               if (var3 > 1 && var3 < 8) {
                  if (Util.a(Hpack.a[var3 - 1].h, var10)) {
                     var2 = var3;
                     break label51;
                  }

                  if (Util.a(Hpack.a[var3].h, var10)) {
                     var2 = var3 + 1;
                     break label51;
                  }
               }

               var2 = -1;
            } else {
               var3 = -1;
               var2 = -1;
            }

            int var6 = var3;
            int var7 = var2;
            if (var2 == -1) {
               int var5 = this.d + 1;
               int var9 = this.c.length;

               while (true) {
                  var6 = var3;
                  var7 = var2;
                  if (var5 >= var9) {
                     break;
                  }

                  var6 = var3;
                  if (Util.a(this.c[var5].g, var12)) {
                     if (Util.a(this.c[var5].h, var10)) {
                        var7 = var5 - this.d + Hpack.a.length;
                        var6 = var3;
                        break;
                     }

                     var6 = var3;
                     if (var3 == -1) {
                        var6 = var5 - this.d + Hpack.a.length;
                     }
                  }

                  var5++;
                  var3 = var6;
               }
            }

            if (var7 != -1) {
               this.a(var7, 127, 128);
            } else if (var6 == -1) {
               this.g.b(64);
               this.a(var12);
               this.a(var10);
               this.a(var11);
            } else if (var12.a(Header.a) && !Header.f.equals(var12)) {
               this.a(var6, 15, 0);
               this.a(var10);
            } else {
               this.a(var6, 63, 64);
               this.a(var10);
               this.a(var11);
            }
         }
      }

      void a(ByteString var1) throws IOException {
         if (this.h && Huffman.a().a(var1) < var1.h()) {
            Buffer var2 = new Buffer();
            Huffman.a().a(var1, var2);
            var1 = var2.p();
            this.a(var1.h(), 127, 128);
            this.g.a(var1);
         } else {
            this.a(var1.h(), 127, 0);
            this.g.a(var1);
         }
      }
   }
}
