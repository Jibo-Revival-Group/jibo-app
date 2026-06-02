package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

final class RealBufferedSource implements BufferedSource {
   public final Buffer a = new Buffer();
   public final Source b;
   boolean c;

   RealBufferedSource(Source var1) {
      if (var1 == null) {
         throw new NullPointerException("source == null");
      }

      this.b = var1;
   }

   @Override
   public long a(byte var1) throws IOException {
      return this.a(var1, 0L, Long.MAX_VALUE);
   }

   public long a(byte var1, long var2, long var4) throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      if (var2 >= 0L && var4 >= var2) {
         while (true) {
            if (var2 < var4) {
               long var6 = this.a.a(var1, var2, var4);
               if (var6 != -1L) {
                  var2 = var6;
                  break;
               }

               var6 = this.a.b;
               if (var6 < var4 && this.b.a(this.a, 8192L) != -1L) {
                  var2 = Math.max(var2, var6);
                  continue;
               }

               var2 = -1L;
               break;
            }

            var2 = -1L;
            break;
         }

         return var2;
      } else {
         throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", var2, var4));
      }
   }

   @Override
   public long a(Buffer var1, long var2) throws IOException {
      long var4 = -1L;
      if (var1 == null) {
         throw new IllegalArgumentException("sink == null");
      }

      if (var2 < 0L) {
         throw new IllegalArgumentException("byteCount < 0: " + var2);
      }

      if (this.c) {
         throw new IllegalStateException("closed");
      }

      if (this.a.b == 0L && this.b.a(this.a, 8192L) == -1L) {
         var2 = var4;
      } else {
         var2 = Math.min(var2, this.a.b);
         var2 = this.a.a(var1, var2);
      }

      return var2;
   }

   @Override
   public long a(Sink var1) throws IOException {
      if (var1 == null) {
         throw new IllegalArgumentException("sink == null");
      }

      long var2 = 0L;

      while (this.b.a(this.a, 8192L) != -1L) {
         long var4 = this.a.h();
         if (var4 > 0L) {
            var2 += var4;
            var1.a_(this.a, var4);
         }
      }

      long var6 = var2;
      if (this.a.b() > 0L) {
         var6 = var2 + this.a.b();
         var1.a_(this.a, this.a.b());
      }

      return var6;
   }

   @Override
   public String a(Charset var1) throws IOException {
      if (var1 == null) {
         throw new IllegalArgumentException("charset == null");
      }

      this.a.a(this.b);
      return this.a.a(var1);
   }

   @Override
   public Timeout a() {
      return this.b.a();
   }

   @Override
   public void a(long var1) throws IOException {
      if (!this.b(var1)) {
         throw new EOFException();
      }
   }

   @Override
   public void a(byte[] var1) throws IOException {
      try {
         this.a(var1.length);
      } catch (EOFException var5) {
         int var2 = 0;

         while (this.a.b > 0L) {
            int var3 = this.a.a(var1, var2, (int)this.a.b);
            if (var3 == -1) {
               throw new AssertionError();
            }

            var2 += var3;
         }

         throw var5;
      }

      this.a.a(var1);
   }

   @Override
   public boolean a(long var1, ByteString var3) throws IOException {
      return this.a(var1, var3, 0, var3.h());
   }

   public boolean a(long var1, ByteString var3, int var4, int var5) throws IOException {
      boolean var8 = false;
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      boolean var7 = var8;
      if (var1 >= 0L) {
         var7 = var8;
         if (var4 >= 0) {
            var7 = var8;
            if (var5 >= 0) {
               if (var3.h() - var4 < var5) {
                  var7 = var8;
               } else {
                  int var6 = 0;

                  while (true) {
                     if (var6 >= var5) {
                        var7 = true;
                        break;
                     }

                     long var9 = var6 + var1;
                     var7 = var8;
                     if (!this.b(1L + var9)) {
                        break;
                     }

                     var7 = var8;
                     if (this.a.c(var9) != var3.a(var4 + var6)) {
                        break;
                     }

                     var6++;
                  }
               }
            }
         }
      }

      return var7;
   }

   @Override
   public boolean b(long var1) throws IOException {
      if (var1 < 0L) {
         throw new IllegalArgumentException("byteCount < 0: " + var1);
      }

      if (this.c) {
         throw new IllegalStateException("closed");
      }

      boolean var3;
      while (true) {
         if (this.a.b < var1) {
            if (this.b.a(this.a, 8192L) != -1L) {
               continue;
            }

            var3 = false;
            break;
         }

         var3 = true;
         break;
      }

      return var3;
   }

   public String c(long var1) throws IOException {
      if (var1 < 0L) {
         throw new IllegalArgumentException("limit < 0: " + var1);
      }

      long var3;
      if (var1 == Long.MAX_VALUE) {
         var3 = Long.MAX_VALUE;
      } else {
         var3 = var1 + 1L;
      }

      long var5 = this.a((byte)10, 0L, var3);
      String var7;
      if (var5 != -1L) {
         var7 = this.a.g(var5);
      } else {
         if (var3 >= Long.MAX_VALUE || !this.b(var3) || this.a.c(var3 - 1L) != 13 || !this.b(1L + var3) || this.a.c(var3) != 10) {
            Buffer var8 = new Buffer();
            this.a.a(var8, 0L, Math.min(32L, this.a.b()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.a.b(), var1) + " content=" + var8.p().f() + '…');
         }

         var7 = this.a.g(var3);
      }

      return var7;
   }

   @Override
   public Buffer c() {
      return this.a;
   }

   @Override
   public void close() throws IOException {
      if (!this.c) {
         this.c = true;
         this.b.close();
         this.a.u();
      }
   }

   @Override
   public ByteString d(long var1) throws IOException {
      this.a(var1);
      return this.a.d(var1);
   }

   @Override
   public boolean f() throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      boolean var1;
      if (this.a.f() && this.b.a(this.a, 8192L) == -1L) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public InputStream g() {
      return new InputStream(this) {
         final RealBufferedSource a;

         {
            this.a = var1;
         }

         @Override
         public int available() throws IOException {
            if (this.a.c) {
               throw new IOException("closed");
            } else {
               return (int)Math.min(this.a.a.b, 2147483647L);
            }
         }

         @Override
         public void close() throws IOException {
            this.a.close();
         }

         @Override
         public int read() throws IOException {
            if (this.a.c) {
               throw new IOException("closed");
            }

            int var1;
            if (this.a.a.b == 0L && this.a.b.a(this.a.a, 8192L) == -1L) {
               var1 = -1;
            } else {
               var1 = this.a.a.i() & 255;
            }

            return var1;
         }

         @Override
         public int read(byte[] var1, int var2, int var3) throws IOException {
            if (this.a.c) {
               throw new IOException("closed");
            }

            Util.a(var1.length, var2, var3);
            if (this.a.a.b == 0L && this.a.b.a(this.a.a, 8192L) == -1L) {
               var2 = -1;
            } else {
               var2 = this.a.a.a(var1, var2, var3);
            }

            return var2;
         }

         @Override
         public String toString() {
            return this.a + ".inputStream()";
         }
      };
   }

   @Override
   public byte[] h(long var1) throws IOException {
      this.a(var1);
      return this.a.h(var1);
   }

   @Override
   public byte i() throws IOException {
      this.a(1L);
      return this.a.i();
   }

   @Override
   public void i(long var1) throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      while (var1 > 0L) {
         if (this.a.b == 0L && this.b.a(this.a, 8192L) == -1L) {
            throw new EOFException();
         }

         long var3 = Math.min(var1, this.a.b());
         this.a.i(var3);
         var1 -= var3;
      }
   }

   @Override
   public short j() throws IOException {
      this.a(2L);
      return this.a.j();
   }

   @Override
   public int k() throws IOException {
      this.a(4L);
      return this.a.k();
   }

   @Override
   public short l() throws IOException {
      this.a(2L);
      return this.a.l();
   }

   @Override
   public int m() throws IOException {
      this.a(4L);
      return this.a.m();
   }

   @Override
   public long n() throws IOException {
      this.a(1L);

      for (int var2 = 0; this.b(var2 + 1); var2++) {
         byte var1 = this.a.c((long)var2);
         if ((var1 < 48 || var1 > 57) && (var2 != 0 || var1 != 45)) {
            if (var2 == 0) {
               throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", var1));
            }
            break;
         }
      }

      return this.a.n();
   }

   @Override
   public long o() throws IOException {
      this.a(1L);

      for (int var2 = 0; this.b(var2 + 1); var2++) {
         byte var1 = this.a.c((long)var2);
         if ((var1 < 48 || var1 > 57) && (var1 < 97 || var1 > 102) && (var1 < 65 || var1 > 70)) {
            if (var2 == 0) {
               throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", var1));
            }
            break;
         }
      }

      return this.a.o();
   }

   @Override
   public ByteString p() throws IOException {
      this.a.a(this.b);
      return this.a.p();
   }

   @Override
   public String r() throws IOException {
      return this.c(Long.MAX_VALUE);
   }

   @Override
   public byte[] t() throws IOException {
      this.a.a(this.b);
      return this.a.t();
   }

   @Override
   public String toString() {
      return "buffer(" + this.b + ")";
   }
}
