package okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1Codec implements HttpCodec {
   final OkHttpClient a;
   final StreamAllocation b;
   final BufferedSource c;
   final BufferedSink d;
   int e = 0;

   public Http1Codec(OkHttpClient var1, StreamAllocation var2, BufferedSource var3, BufferedSink var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   private Source b(Response var1) throws IOException {
      Source var4;
      if (!HttpHeaders.d(var1)) {
         var4 = this.b(0L);
      } else if ("chunked".equalsIgnoreCase(var1.a("Transfer-Encoding"))) {
         var4 = this.a(var1.a().a());
      } else {
         long var2 = HttpHeaders.a(var1);
         if (var2 != -1L) {
            var4 = this.b(var2);
         } else {
            var4 = this.f();
         }
      }

      return var4;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public Response.Builder a(boolean var1) throws IOException {
      if (this.e != 1 && this.e != 3) {
         throw new IllegalStateException("state: " + this.e);
      }

      Response.Builder var7;
      StatusLine var8;
      try {
         var8 = StatusLine.a(this.c.r());
         var7 = new Response.Builder();
         var7 = var7.a(var8.a).a(var8.b).a(var8.c).a(this.d());
      } catch (EOFException var5) {
         IOException var3 = new IOException("unexpected end of stream on " + this.b);
         var3.initCause(var5);
         throw var3;
      }

      if (var1) {
         try {
            if (var8.b == 100) {
               return null;
            }
         } catch (EOFException var6) {
            IOException var9 = new IOException("unexpected end of stream on " + this.b);
            var9.initCause(var6);
            throw var9;
         }
      }

      try {
         this.e = 4;
         return var7;
      } catch (EOFException var4) {
         IOException var10 = new IOException("unexpected end of stream on " + this.b);
         var10.initCause(var4);
         throw var10;
      }
   }

   @Override
   public ResponseBody a(Response var1) throws IOException {
      Source var2 = this.b(var1);
      return new RealResponseBody(var1.g(), Okio.a(var2));
   }

   public Sink a(long var1) {
      if (this.e != 1) {
         throw new IllegalStateException("state: " + this.e);
      }

      this.e = 2;
      return new Http1Codec.FixedLengthSink(this, var1);
   }

   @Override
   public Sink a(Request var1, long var2) {
      Sink var4;
      if ("chunked".equalsIgnoreCase(var1.a("Transfer-Encoding"))) {
         var4 = this.e();
      } else {
         if (var2 == -1L) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
         }

         var4 = this.a(var2);
      }

      return var4;
   }

   public Source a(HttpUrl var1) throws IOException {
      if (this.e != 4) {
         throw new IllegalStateException("state: " + this.e);
      }

      this.e = 5;
      return new Http1Codec.ChunkedSource(this, var1);
   }

   @Override
   public void a() throws IOException {
      this.d.flush();
   }

   public void a(Headers var1, String var2) throws IOException {
      if (this.e != 0) {
         throw new IllegalStateException("state: " + this.e);
      }

      this.d.b(var2).b("\r\n");
      int var3 = 0;

      for (int var4 = var1.a(); var3 < var4; var3++) {
         this.d.b(var1.a(var3)).b(": ").b(var1.b(var3)).b("\r\n");
      }

      this.d.b("\r\n");
      this.e = 1;
   }

   @Override
   public void a(Request var1) throws IOException {
      String var2 = RequestLine.a(var1, this.b.b().a().b().type());
      this.a(var1.c(), var2);
   }

   void a(ForwardingTimeout var1) {
      Timeout var2 = var1.a();
      var1.a(Timeout.c);
      var2.f();
      var2.z_();
   }

   public Source b(long var1) throws IOException {
      if (this.e != 4) {
         throw new IllegalStateException("state: " + this.e);
      }

      this.e = 5;
      return new Http1Codec.FixedLengthSource(this, var1);
   }

   @Override
   public void b() throws IOException {
      this.d.flush();
   }

   @Override
   public void c() {
      RealConnection var1 = this.b.b();
      if (var1 != null) {
         var1.c();
      }
   }

   public Headers d() throws IOException {
      Headers.Builder var2 = new Headers.Builder();

      while (true) {
         String var1 = this.c.r();
         if (var1.length() == 0) {
            return var2.a();
         }

         Internal.a.a(var2, var1);
      }
   }

   public Sink e() {
      if (this.e != 1) {
         throw new IllegalStateException("state: " + this.e);
      }

      this.e = 2;
      return new Http1Codec.ChunkedSink(this);
   }

   public Source f() throws IOException {
      if (this.e != 4) {
         throw new IllegalStateException("state: " + this.e);
      }

      if (this.b == null) {
         throw new IllegalStateException("streamAllocation == null");
      }

      this.e = 5;
      this.b.d();
      return new Http1Codec.UnknownLengthSource(this);
   }

   private abstract class AbstractSource implements Source {
      protected final ForwardingTimeout a;
      protected boolean b;
      final Http1Codec c;

      private AbstractSource(Http1Codec var1) {
         this.c = var1;
         this.a = new ForwardingTimeout(this.c.c.a());
      }

      @Override
      public Timeout a() {
         return this.a;
      }

      protected final void a(boolean var1) throws IOException {
         if (this.c.e != 6) {
            if (this.c.e != 5) {
               throw new IllegalStateException("state: " + this.c.e);
            }

            this.c.a(this.a);
            this.c.e = 6;
            if (this.c.b != null) {
               StreamAllocation var2 = this.c.b;
               if (!var1) {
                  var1 = true;
               } else {
                  var1 = false;
               }

               var2.a(var1, this.c);
            }
         }
      }
   }

   private final class ChunkedSink implements Sink {
      final Http1Codec a;
      private final ForwardingTimeout b;
      private boolean c;

      ChunkedSink(Http1Codec var1) {
         this.a = var1;
         this.b = new ForwardingTimeout(this.a.d.a());
      }

      @Override
      public Timeout a() {
         return this.b;
      }

      @Override
      public void a_(Buffer var1, long var2) throws IOException {
         if (this.c) {
            throw new IllegalStateException("closed");
         }

         if (var2 != 0L) {
            this.a.d.l(var2);
            this.a.d.b("\r\n");
            this.a.d.a_(var1, var2);
            this.a.d.b("\r\n");
         }
      }

      @Override
      public void close() throws IOException {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
         //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
         //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
         //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
         //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
         //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
         //
         // Bytecode:
         // 00: aload 0
         // 01: monitorenter
         // 02: aload 0
         // 03: getfield okhttp3/internal/http1/Http1Codec$ChunkedSink.c Z
         // 06: istore 1
         // 07: iload 1
         // 08: ifeq 0e
         // 0b: aload 0
         // 0c: monitorexit
         // 0d: return
         // 0e: aload 0
         // 0f: bipush 1
         // 10: putfield okhttp3/internal/http1/Http1Codec$ChunkedSink.c Z
         // 13: aload 0
         // 14: getfield okhttp3/internal/http1/Http1Codec$ChunkedSink.a Lokhttp3/internal/http1/Http1Codec;
         // 17: getfield okhttp3/internal/http1/Http1Codec.d Lokio/BufferedSink;
         // 1a: ldc "0\r\n\r\n"
         // 1c: invokeinterface okio/BufferedSink.b (Ljava/lang/String;)Lokio/BufferedSink; 2
         // 21: pop
         // 22: aload 0
         // 23: getfield okhttp3/internal/http1/Http1Codec$ChunkedSink.a Lokhttp3/internal/http1/Http1Codec;
         // 26: aload 0
         // 27: getfield okhttp3/internal/http1/Http1Codec$ChunkedSink.b Lokio/ForwardingTimeout;
         // 2a: invokevirtual okhttp3/internal/http1/Http1Codec.a (Lokio/ForwardingTimeout;)V
         // 2d: aload 0
         // 2e: getfield okhttp3/internal/http1/Http1Codec$ChunkedSink.a Lokhttp3/internal/http1/Http1Codec;
         // 31: bipush 3
         // 32: putfield okhttp3/internal/http1/Http1Codec.e I
         // 35: goto 0b
         // 38: astore 2
         // 39: aload 0
         // 3a: monitorexit
         // 3b: aload 2
         // 3c: athrow
         // try (2 -> 5): 29 null
         // try (10 -> 28): 29 null
      }

      @Override
      public void flush() throws IOException {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
         //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
         //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
         //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
         //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
         //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
         //
         // Bytecode:
         // 00: aload 0
         // 01: monitorenter
         // 02: aload 0
         // 03: getfield okhttp3/internal/http1/Http1Codec$ChunkedSink.c Z
         // 06: istore 1
         // 07: iload 1
         // 08: ifeq 0e
         // 0b: aload 0
         // 0c: monitorexit
         // 0d: return
         // 0e: aload 0
         // 0f: getfield okhttp3/internal/http1/Http1Codec$ChunkedSink.a Lokhttp3/internal/http1/Http1Codec;
         // 12: getfield okhttp3/internal/http1/Http1Codec.d Lokio/BufferedSink;
         // 15: invokeinterface okio/BufferedSink.flush ()V 1
         // 1a: goto 0b
         // 1d: astore 2
         // 1e: aload 0
         // 1f: monitorexit
         // 20: aload 2
         // 21: athrow
         // try (2 -> 5): 15 null
         // try (10 -> 14): 15 null
      }
   }

   private class ChunkedSource extends Http1Codec.AbstractSource {
      final Http1Codec d;
      private final HttpUrl e;
      private long f;
      private boolean g;

      ChunkedSource(Http1Codec var1, HttpUrl var2) {
         super(var1);
         this.d = var1;
         this.f = -1L;
         this.g = true;
         this.e = var2;
      }

      private void b() throws IOException {
         if (this.f != -1L) {
            this.d.c.r();
         }

         try {
            this.f = this.d.c.o();
            String var1 = this.d.c.r().trim();
            if (this.f < 0L || !var1.isEmpty() && !var1.startsWith(";")) {
               StringBuilder var2 = new StringBuilder();
               ProtocolException var3 = new ProtocolException(
                  var2.append("expected chunk size and optional extensions but was \"").append(this.f).append(var1).append("\"").toString()
               );
               throw var3;
            }
         } catch (NumberFormatException var4) {
            throw new ProtocolException(var4.getMessage());
         }

         if (this.f == 0L) {
            this.g = false;
            HttpHeaders.a(this.d.a.f(), this.e, this.d.d());
            this.a(true);
         }
      }

      @Override
      public long a(Buffer var1, long var2) throws IOException {
         long var4 = -1L;
         if (var2 < 0L) {
            throw new IllegalArgumentException("byteCount < 0: " + var2);
         }

         if (this.b) {
            throw new IllegalStateException("closed");
         }

         if (this.g) {
            if (this.f == 0L || this.f == -1L) {
               this.b();
               if (!this.g) {
                  return var4;
               }
            }

            var4 = this.d.c.a(var1, Math.min(var2, this.f));
            if (var4 == -1L) {
               this.a(false);
               throw new ProtocolException("unexpected end of stream");
            }

            this.f -= var4;
         }

         return var4;
      }

      @Override
      public void close() throws IOException {
         if (!this.b) {
            if (this.g && !Util.a(this, 100, TimeUnit.MILLISECONDS)) {
               this.a(false);
            }

            this.b = true;
         }
      }
   }

   private final class FixedLengthSink implements Sink {
      final Http1Codec a;
      private final ForwardingTimeout b;
      private boolean c;
      private long d;

      FixedLengthSink(Http1Codec var1, long var2) {
         this.a = var1;
         this.b = new ForwardingTimeout(this.a.d.a());
         this.d = var2;
      }

      @Override
      public Timeout a() {
         return this.b;
      }

      @Override
      public void a_(Buffer var1, long var2) throws IOException {
         if (this.c) {
            throw new IllegalStateException("closed");
         }

         Util.a(var1.b(), 0L, var2);
         if (var2 > this.d) {
            throw new ProtocolException("expected " + this.d + " bytes but received " + var2);
         }

         this.a.d.a_(var1, var2);
         this.d -= var2;
      }

      @Override
      public void close() throws IOException {
         if (!this.c) {
            this.c = true;
            if (this.d > 0L) {
               throw new ProtocolException("unexpected end of stream");
            }

            this.a.a(this.b);
            this.a.e = 3;
         }
      }

      @Override
      public void flush() throws IOException {
         if (!this.c) {
            this.a.d.flush();
         }
      }
   }

   private class FixedLengthSource extends Http1Codec.AbstractSource {
      final Http1Codec d;
      private long e;

      FixedLengthSource(Http1Codec var1, long var2) throws IOException {
         super(var1);
         this.d = var1;
         this.e = var2;
         if (this.e == 0L) {
            this.a(true);
         }
      }

      @Override
      public long a(Buffer var1, long var2) throws IOException {
         long var4 = -1L;
         if (var2 < 0L) {
            throw new IllegalArgumentException("byteCount < 0: " + var2);
         }

         if (this.b) {
            throw new IllegalStateException("closed");
         }

         if (this.e == 0L) {
            var2 = var4;
         } else {
            var2 = this.d.c.a(var1, Math.min(this.e, var2));
            if (var2 == -1L) {
               this.a(false);
               throw new ProtocolException("unexpected end of stream");
            }

            this.e -= var2;
            if (this.e == 0L) {
               this.a(true);
            }
         }

         return var2;
      }

      @Override
      public void close() throws IOException {
         if (!this.b) {
            if (this.e != 0L && !Util.a(this, 100, TimeUnit.MILLISECONDS)) {
               this.a(false);
            }

            this.b = true;
         }
      }
   }

   private class UnknownLengthSource extends Http1Codec.AbstractSource {
      final Http1Codec d;
      private boolean e;

      UnknownLengthSource(Http1Codec var1) {
         super(var1);
         this.d = var1;
      }

      @Override
      public long a(Buffer var1, long var2) throws IOException {
         long var4 = -1L;
         if (var2 < 0L) {
            throw new IllegalArgumentException("byteCount < 0: " + var2);
         }

         if (this.b) {
            throw new IllegalStateException("closed");
         }

         if (this.e) {
            var2 = var4;
         } else {
            var2 = this.d.c.a(var1, var2);
            if (var2 == -1L) {
               this.e = true;
               this.a(true);
               var2 = var4;
            }
         }

         return var2;
      }

      @Override
      public void close() throws IOException {
         if (!this.b) {
            if (!this.e) {
               this.a(false);
            }

            this.b = true;
         }
      }
   }
}
