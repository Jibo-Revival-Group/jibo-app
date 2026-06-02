package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;

public abstract class RequestBody {
   public static RequestBody a(MediaType var0, String var1) {
      Charset var2 = Util.e;
      MediaType var3 = var0;
      if (var0 != null) {
         Charset var4 = var0.b();
         var2 = var4;
         var3 = var0;
         if (var4 == null) {
            var2 = Util.e;
            var3 = MediaType.a(var0 + "; charset=utf-8");
         }
      }

      return a(var3, var1.getBytes(var2));
   }

   public static RequestBody a(MediaType var0, ByteString var1) {
      return new RequestBody(var0, var1) {
         final MediaType a;
         final ByteString b;

         {
            this.a = var1;
            this.b = var2;
         }

         @Override
         public MediaType a() {
            return this.a;
         }

         @Override
         public void a(BufferedSink var1) throws IOException {
            var1.b(this.b);
         }

         @Override
         public long b() throws IOException {
            return this.b.h();
         }
      };
   }

   public static RequestBody a(MediaType var0, byte[] var1) {
      return a(var0, var1, 0, var1.length);
   }

   public static RequestBody a(MediaType var0, byte[] var1, int var2, int var3) {
      if (var1 == null) {
         throw new NullPointerException("content == null");
      }

      Util.a(var1.length, var2, var3);
      return new RequestBody(var0, var3, var1, var2) {
         final MediaType a;
         final int b;
         final byte[] c;
         final int d;

         {
            this.a = var1;
            this.b = var2x;
            this.c = var3x;
            this.d = var4;
         }

         @Override
         public MediaType a() {
            return this.a;
         }

         @Override
         public void a(BufferedSink var1) throws IOException {
            var1.c(this.c, this.d, this.b);
         }

         @Override
         public long b() {
            return this.b;
         }
      };
   }

   public abstract MediaType a();

   public abstract void a(BufferedSink var1) throws IOException;

   public long b() throws IOException {
      return -1L;
   }
}
