package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Http2Reader implements Closeable {
   static final Logger a = Logger.getLogger(Http2.class.getName());
   final Hpack.Reader b;
   private final BufferedSource c;
   private final Http2Reader.ContinuationSource d;
   private final boolean e;

   Http2Reader(BufferedSource var1, boolean var2) {
      this.c = var1;
      this.e = var2;
      this.d = new Http2Reader.ContinuationSource(this.c);
      this.b = new Hpack.Reader(4096, this.d);
   }

   static int a(int var0, byte var1, short var2) throws IOException {
      int var3 = var0;
      if ((var1 & 8) != 0) {
         var3 = var0 - 1;
      }

      if (var2 > var3) {
         throw Http2.b("PROTOCOL_ERROR padding %s > remaining length %s", var2, var3);
      } else {
         return (short)(var3 - var2);
      }
   }

   static int a(BufferedSource var0) throws IOException {
      return (var0.i() & 0xFF) << 16 | (var0.i() & 0xFF) << 8 | var0.i() & 0xFF;
   }

   private List<Header> a(int var1, short var2, byte var3, int var4) throws IOException {
      Http2Reader.ContinuationSource var5 = this.d;
      this.d.d = var1;
      var5.a = var1;
      this.d.e = var2;
      this.d.b = var3;
      this.d.c = var4;
      this.b.a();
      return this.b.b();
   }

   private void a(Http2Reader.Handler var1, int var2) throws IOException {
      int var3 = this.c.k();
      boolean var4;
      if ((-2147483648 & var3) != 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      var1.a(var2, var3 & 2147483647, (this.c.i() & 255) + 1, var4);
   }

   private void a(Http2Reader.Handler var1, int var2, byte var3, int var4) throws IOException {
      short var5 = 0;
      if (var4 == 0) {
         throw Http2.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
      }

      boolean var7;
      if ((var3 & 1) != 0) {
         var7 = true;
      } else {
         var7 = false;
      }

      if ((var3 & 8) != 0) {
         var5 = (short)(this.c.i() & 0xFF);
      }

      int var6 = var2;
      if ((var3 & 32) != 0) {
         this.a(var1, var4);
         var6 = var2 - 5;
      }

      var1.a(var7, var4, -1, this.a(a(var6, var3, var5), var5, var3, var4));
   }

   private void b(Http2Reader.Handler var1, int var2, byte var3, int var4) throws IOException {
      boolean var6 = true;
      short var5 = 0;
      if (var4 == 0) {
         throw Http2.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
      }

      boolean var7;
      if ((var3 & 1) != 0) {
         var7 = true;
      } else {
         var7 = false;
      }

      if ((var3 & 32) == 0) {
         var6 = false;
      }

      if (var6) {
         throw Http2.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
      }

      if ((var3 & 8) != 0) {
         var5 = (short)(this.c.i() & 0xFF);
      }

      var2 = a(var2, var3, var5);
      var1.a(var7, var4, this.c, var2);
      this.c.i(var5);
   }

   private void c(Http2Reader.Handler var1, int var2, byte var3, int var4) throws IOException {
      if (var2 != 5) {
         throw Http2.b("TYPE_PRIORITY length: %d != 5", var2);
      }

      if (var4 == 0) {
         throw Http2.b("TYPE_PRIORITY streamId == 0");
      }

      this.a(var1, var4);
   }

   private void d(Http2Reader.Handler var1, int var2, byte var3, int var4) throws IOException {
      if (var2 != 4) {
         throw Http2.b("TYPE_RST_STREAM length: %d != 4", var2);
      }

      if (var4 == 0) {
         throw Http2.b("TYPE_RST_STREAM streamId == 0");
      }

      var2 = this.c.k();
      ErrorCode var5 = ErrorCode.fromHttp2(var2);
      if (var5 == null) {
         throw Http2.b("TYPE_RST_STREAM unexpected error code: %d", var2);
      }

      var1.a(var4, var5);
   }

   private void e(Http2Reader.Handler var1, int var2, byte var3, int var4) throws IOException {
      if (var4 != 0) {
         throw Http2.b("TYPE_SETTINGS streamId != 0");
      }

      if ((var3 & 1) != 0) {
         if (var2 != 0) {
            throw Http2.b("FRAME_SIZE_ERROR ack frame should be empty!");
         }

         var1.a();
      } else {
         if (var2 % 6 != 0) {
            throw Http2.b("TYPE_SETTINGS length %% 6 != 0: %s", var2);
         }

         Settings var7 = new Settings();

         for (byte var9 = 0; var9 < var2; var9 += 6) {
            short var5 = this.c.j();
            int var6 = this.c.k();
            var3 = var5;
            switch (var5) {
               case 1:
               case 6:
                  break;
               case 2:
                  var3 = var5;
                  if (var6 != 0) {
                     var3 = var5;
                     if (var6 != 1) {
                        throw Http2.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                     }
                  }
                  break;
               case 3:
                  var3 = 4;
                  break;
               case 4:
                  var3 = 7;
                  if (var6 < 0) {
                     throw Http2.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                  }
                  break;
               case 5:
                  if (var6 < 16384) {
                     throw Http2.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", var6);
                  }

                  var3 = var5;
                  if (var6 > 16777215) {
                     throw Http2.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", var6);
                  }
                  break;
               default:
                  var3 = var5;
            }

            var7.a(var3, var6);
         }

         var1.a(false, var7);
      }
   }

   private void f(Http2Reader.Handler var1, int var2, byte var3, int var4) throws IOException {
      short var5 = 0;
      if (var4 == 0) {
         throw Http2.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
      }

      if ((var3 & 8) != 0) {
         var5 = (short)(this.c.i() & 0xFF);
      }

      var1.a(var4, this.c.k() & 2147483647, this.a(a(var2 - 4, var3, var5), var5, var3, var4));
   }

   private void g(Http2Reader.Handler var1, int var2, byte var3, int var4) throws IOException {
      boolean var5 = true;
      if (var2 != 8) {
         throw Http2.b("TYPE_PING length != 8: %s", var2);
      }

      if (var4 != 0) {
         throw Http2.b("TYPE_PING streamId != 0");
      }

      var2 = this.c.k();
      var4 = this.c.k();
      if ((var3 & 1) == 0) {
         var5 = false;
      }

      var1.a(var5, var2, var4);
   }

   private void h(Http2Reader.Handler var1, int var2, byte var3, int var4) throws IOException {
      if (var2 < 8) {
         throw Http2.b("TYPE_GOAWAY length < 8: %s", var2);
      }

      if (var4 != 0) {
         throw Http2.b("TYPE_GOAWAY streamId != 0");
      }

      var4 = this.c.k();
      var3 = this.c.k();
      var2 -= 8;
      ErrorCode var6 = ErrorCode.fromHttp2(var3);
      if (var6 == null) {
         throw Http2.b("TYPE_GOAWAY unexpected error code: %d", var3);
      }

      ByteString var5 = ByteString.b;
      if (var2 > 0) {
         var5 = this.c.d(var2);
      }

      var1.a(var4, var6, var5);
   }

   private void i(Http2Reader.Handler var1, int var2, byte var3, int var4) throws IOException {
      if (var2 != 4) {
         throw Http2.b("TYPE_WINDOW_UPDATE length !=4: %s", var2);
      }

      long var5 = this.c.k() & 2147483647L;
      if (var5 == 0L) {
         throw Http2.b("windowSizeIncrement was 0", var5);
      }

      var1.a(var4, var5);
   }

   public void a(Http2Reader.Handler var1) throws IOException {
      if (this.e) {
         if (!this.a(true, var1)) {
            throw Http2.b("Required SETTINGS preface not received");
         }
      } else {
         ByteString var2 = this.c.d(Http2.a.h());
         if (a.isLoggable(Level.FINE)) {
            a.fine(Util.a("<< CONNECTION %s", new Object[]{var2.f()}));
         }

         if (!Http2.a.equals(var2)) {
            throw Http2.b("Expected a connection header but was %s", var2.a());
         }
      }
   }

   public boolean a(boolean var1, Http2Reader.Handler var2) throws IOException {
      boolean var7 = true;

      try {
         this.c.a(9L);
      } catch (IOException var8) {
         return false;
      }

      int var5 = a(this.c);
      if (var5 < 0 || var5 > 16384) {
         throw Http2.b("FRAME_SIZE_ERROR: %s", var5);
      }

      byte var4 = (byte)(this.c.i() & 0xFF);
      if (var1 && var4 != 4) {
         throw Http2.b("Expected a SETTINGS frame but was %s", var4);
      }

      byte var3 = (byte)(this.c.i() & 0xFF);
      int var6 = this.c.k() & 2147483647;
      if (a.isLoggable(Level.FINE)) {
         a.fine(Http2.a(true, var6, var5, var4, var3));
      }

      switch (var4) {
         case 0:
            this.b(var2, var5, var3, var6);
            var1 = var7;
            break;
         case 1:
            this.a(var2, var5, var3, var6);
            var1 = var7;
            break;
         case 2:
            this.c(var2, var5, var3, var6);
            var1 = var7;
            break;
         case 3:
            this.d(var2, var5, var3, var6);
            var1 = var7;
            break;
         case 4:
            this.e(var2, var5, var3, var6);
            var1 = var7;
            break;
         case 5:
            this.f(var2, var5, var3, var6);
            var1 = var7;
            break;
         case 6:
            this.g(var2, var5, var3, var6);
            var1 = var7;
            break;
         case 7:
            this.h(var2, var5, var3, var6);
            var1 = var7;
            break;
         case 8:
            this.i(var2, var5, var3, var6);
            var1 = var7;
            break;
         default:
            this.c.i(var5);
            var1 = var7;
      }

      return var1;
   }

   @Override
   public void close() throws IOException {
      this.c.close();
   }

   static final class ContinuationSource implements Source {
      int a;
      byte b;
      int c;
      int d;
      short e;
      private final BufferedSource f;

      ContinuationSource(BufferedSource var1) {
         this.f = var1;
      }

      private void b() throws IOException {
         int var2 = this.c;
         int var3 = Http2Reader.a(this.f);
         this.d = var3;
         this.a = var3;
         byte var1 = (byte)(this.f.i() & 0xFF);
         this.b = (byte)(this.f.i() & 0xFF);
         if (Http2Reader.a.isLoggable(Level.FINE)) {
            Http2Reader.a.fine(Http2.a(true, this.c, this.a, var1, this.b));
         }

         this.c = this.f.k() & 2147483647;
         if (var1 != 9) {
            throw Http2.b("%s != TYPE_CONTINUATION", var1);
         }

         if (this.c != var2) {
            throw Http2.b("TYPE_CONTINUATION streamId changed");
         }
      }

      @Override
      public long a(Buffer var1, long var2) throws IOException {
         long var4 = -1L;

         while (true) {
            if (this.d != 0) {
               long var6 = this.f.a(var1, Math.min(var2, this.d));
               var2 = var4;
               if (var6 != -1L) {
                  this.d = (int)(this.d - var6);
                  var2 = var6;
               }
               break;
            }

            this.f.i(this.e);
            this.e = 0;
            if ((this.b & 4) != 0) {
               var2 = var4;
               break;
            }

            this.b();
         }

         return var2;
      }

      @Override
      public Timeout a() {
         return this.f.a();
      }

      @Override
      public void close() throws IOException {
      }
   }

   interface Handler {
      void a();

      void a(int var1, int var2, int var3, boolean var4);

      void a(int var1, int var2, List<Header> var3) throws IOException;

      void a(int var1, long var2);

      void a(int var1, ErrorCode var2);

      void a(int var1, ErrorCode var2, ByteString var3);

      void a(boolean var1, int var2, int var3);

      void a(boolean var1, int var2, int var3, List<Header> var4);

      void a(boolean var1, int var2, BufferedSource var3, int var4) throws IOException;

      void a(boolean var1, Settings var2);
   }
}
