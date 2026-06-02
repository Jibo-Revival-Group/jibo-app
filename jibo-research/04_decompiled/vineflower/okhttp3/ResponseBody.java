package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;

public abstract class ResponseBody implements Closeable {
   private Reader a;

   public static ResponseBody a(MediaType var0, long var1, BufferedSource var3) {
      if (var3 == null) {
         throw new NullPointerException("source == null");
      } else {
         return new ResponseBody(var0, var1, var3) {
            final MediaType a;
            final long b;
            final BufferedSource c;

            {
               this.a = var1;
               this.b = var2;
               this.c = var4;
            }

            @Override
            public MediaType a() {
               return this.a;
            }

            @Override
            public long b() {
               return this.b;
            }

            @Override
            public BufferedSource c() {
               return this.c;
            }
         };
      }
   }

   public static ResponseBody a(MediaType var0, byte[] var1) {
      Buffer var2 = new Buffer().b(var1);
      return a(var0, var1.length, var2);
   }

   private Charset g() {
      MediaType var1 = this.a();
      Charset var2;
      if (var1 != null) {
         var2 = var1.a(Util.e);
      } else {
         var2 = Util.e;
      }

      return var2;
   }

   public abstract MediaType a();

   public abstract long b();

   public abstract BufferedSource c();

   @Override
   public void close() {
      Util.a(this.c());
   }

   public final byte[] d() throws IOException {
      long var1 = this.b();
      if (var1 > 2147483647L) {
         throw new IOException("Cannot buffer entire body for content length: " + var1);
      }

      BufferedSource var3 = this.c();

      byte[] var4;
      try {
         var4 = var3.t();
      } finally {
         Util.a(var3);
      }

      if (var1 != -1L && var1 != var4.length) {
         throw new IOException("Content-Length (" + var1 + ") and stream length (" + var4.length + ") disagree");
      } else {
         return var4;
      }
   }

   public final Reader e() {
      Reader var1 = this.a;
      if (var1 == null) {
         var1 = new ResponseBody.BomAwareReader(this.c(), this.g());
         this.a = var1;
      }

      return var1;
   }

   public final String f() throws IOException {
      BufferedSource var1 = this.c();

      try {
         return var1.a(Util.a(var1, this.g()));
      } finally {
         Util.a(var1);
      }
   }

   static final class BomAwareReader extends Reader {
      private final BufferedSource a;
      private final Charset b;
      private boolean c;
      private Reader d;

      BomAwareReader(BufferedSource var1, Charset var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public void close() throws IOException {
         this.c = true;
         if (this.d != null) {
            this.d.close();
         } else {
            this.a.close();
         }
      }

      @Override
      public int read(char[] var1, int var2, int var3) throws IOException {
         if (this.c) {
            throw new IOException("Stream closed");
         }

         Reader var5 = this.d;
         Reader var4 = var5;
         if (var5 == null) {
            Charset var6 = Util.a(this.a, this.b);
            var4 = new InputStreamReader(this.a.g(), var6);
            this.d = var4;
         }

         return var4.read(var1, var2, var3);
      }
   }
}
