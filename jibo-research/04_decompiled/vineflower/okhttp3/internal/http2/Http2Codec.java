package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Http2Codec implements HttpCodec {
   private static final ByteString b = ByteString.a("connection");
   private static final ByteString c = ByteString.a("host");
   private static final ByteString d = ByteString.a("keep-alive");
   private static final ByteString e = ByteString.a("proxy-connection");
   private static final ByteString f = ByteString.a("transfer-encoding");
   private static final ByteString g = ByteString.a("te");
   private static final ByteString h = ByteString.a("encoding");
   private static final ByteString i = ByteString.a("upgrade");
   private static final List<ByteString> j = Util.a(b, c, d, e, g, f, h, i, Header.c, Header.d, Header.e, Header.f);
   private static final List<ByteString> k = Util.a(b, c, d, e, g, f, h, i);
   final StreamAllocation a;
   private final OkHttpClient l;
   private final Http2Connection m;
   private Http2Stream n;

   public Http2Codec(OkHttpClient var1, StreamAllocation var2, Http2Connection var3) {
      this.l = var1;
      this.a = var2;
      this.m = var3;
   }

   public static Response.Builder a(List<Header> var0) throws IOException {
      Headers.Builder var3 = new Headers.Builder();
      int var2 = var0.size();
      int var1 = 0;
      StatusLine var4 = null;

      while (var1 < var2) {
         Header var6 = (Header)var0.get(var1);
         if (var6 == null) {
            if (var4 != null && var4.b == 100) {
               var3 = new Headers.Builder();
               var4 = null;
            }
         } else {
            ByteString var5 = var6.g;
            String var7 = var6.h.a();
            if (var5.equals(Header.b)) {
               var4 = StatusLine.a("HTTP/1.1 " + var7);
            } else if (!k.contains(var5)) {
               Internal.a.a(var3, var5.a(), var7);
            }
         }

         var1++;
      }

      if (var4 == null) {
         throw new ProtocolException("Expected ':status' header not present");
      } else {
         return new Response.Builder().a(Protocol.HTTP_2).a(var4.b).a(var4.c).a(var3.a());
      }
   }

   public static List<Header> b(Request var0) {
      Headers var3 = var0.c();
      ArrayList var4 = new ArrayList(var3.a() + 4);
      var4.add(new Header(Header.c, var0.b()));
      var4.add(new Header(Header.d, RequestLine.a(var0.a())));
      String var5 = var0.a("Host");
      if (var5 != null) {
         var4.add(new Header(Header.f, var5));
      }

      var4.add(new Header(Header.e, var0.a().c()));
      int var1 = 0;

      for (int var2 = var3.a(); var1 < var2; var1++) {
         ByteString var6 = ByteString.a(var3.a(var1).toLowerCase(Locale.US));
         if (!j.contains(var6)) {
            var4.add(new Header(var6, var3.b(var1)));
         }
      }

      return var4;
   }

   @Override
   public Response.Builder a(boolean var1) throws IOException {
      Response.Builder var3 = a(this.n.d());
      Response.Builder var2 = var3;
      if (var1) {
         var2 = var3;
         if (Internal.a.a(var3) == 100) {
            var2 = null;
         }
      }

      return var2;
   }

   @Override
   public ResponseBody a(Response var1) throws IOException {
      Http2Codec.StreamFinishingSource var2 = new Http2Codec.StreamFinishingSource(this, this.n.g());
      return new RealResponseBody(var1.g(), Okio.a(var2));
   }

   @Override
   public Sink a(Request var1, long var2) {
      return this.n.h();
   }

   @Override
   public void a() throws IOException {
      this.m.b();
   }

   @Override
   public void a(Request var1) throws IOException {
      if (this.n == null) {
         boolean var2;
         if (var1.d() != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         List var3 = b(var1);
         this.n = this.m.a(var3, var2);
         this.n.e().a(this.l.b(), TimeUnit.MILLISECONDS);
         this.n.f().a(this.l.c(), TimeUnit.MILLISECONDS);
      }
   }

   @Override
   public void b() throws IOException {
      this.n.h().close();
   }

   @Override
   public void c() {
      if (this.n != null) {
         this.n.b(ErrorCode.CANCEL);
      }
   }

   class StreamFinishingSource extends ForwardingSource {
      final Http2Codec a;

      StreamFinishingSource(Http2Codec var1, Source var2) {
         super(var2);
         this.a = var1;
      }

      @Override
      public void close() throws IOException {
         this.a.a.a(false, this.a);
         super.close();
      }
   }
}
