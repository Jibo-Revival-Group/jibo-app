package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class Buffer implements Cloneable, BufferedSink, BufferedSource {
   private static final byte[] c = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
   Segment a;
   long b;

   public int a(byte[] var1, int var2, int var3) {
      Util.a(var1.length, var2, var3);
      Segment var4 = this.a;
      if (var4 == null) {
         var2 = -1;
      } else {
         var3 = Math.min(var3, var4.c - var4.b);
         System.arraycopy(var4.a, var4.b, var1, var2, var3);
         var4.b += var3;
         this.b -= var3;
         var2 = var3;
         if (var4.b == var4.c) {
            this.a = var4.a();
            SegmentPool.a(var4);
            var2 = var3;
         }
      }

      return var2;
   }

   @Override
   public long a(byte var1) {
      return this.a(var1, 0L, Long.MAX_VALUE);
   }

   public long a(byte var1, long var2, long var4) {
      if (var2 >= 0L && var4 >= var2) {
         long var10 = var4;
         if (var4 > this.b) {
            var10 = this.b;
         }

         if (var2 == var10) {
            var2 = -1L;
         } else {
            Segment var13 = this.a;
            if (var13 == null) {
               var2 = -1L;
            } else {
               Segment var12;
               if (this.b - var2 < var2) {
                  long var18 = this.b;

                  while (true) {
                     var4 = var18;
                     var12 = var13;
                     if (var18 <= var2) {
                        break;
                     }

                     var13 = var13.g;
                     var18 -= var13.c - var13.b;
                  }
               } else {
                  var4 = 0L;

                  while (true) {
                     long var8 = var13.c - var13.b + var4;
                     var12 = var13;
                     if (var8 >= var2) {
                        break;
                     }

                     var13 = var13.f;
                     var4 = var8;
                  }
               }

               long var19 = var2;

               while (var4 < var10) {
                  byte[] var20 = var12.a;
                  int var7 = (int)Math.min(var12.c, var12.b + var10 - var4);

                  for (int var6 = (int)(var12.b + var19 - var4); var6 < var7; var6++) {
                     if (var20[var6] == var1) {
                        return var6 - var12.b + var4;
                     }
                  }

                  var4 = var12.c - var12.b + var4;
                  var12 = var12.f;
                  var2 = var4;
                  var19 = var4;
                  var4 = var2;
               }

               var2 = -1L;
            }
         }

         return var2;
      } else {
         throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", this.b, var2, var4));
      }
   }

   @Override
   public long a(Buffer var1, long var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("sink == null");
      }

      if (var2 < 0L) {
         throw new IllegalArgumentException("byteCount < 0: " + var2);
      }

      long var4;
      if (this.b == 0L) {
         var4 = -1L;
      } else {
         var4 = var2;
         if (var2 > this.b) {
            var4 = this.b;
         }

         var1.a_(this, var4);
      }

      return var4;
   }

   @Override
   public long a(Sink var1) throws IOException {
      long var2 = this.b;
      if (var2 > 0L) {
         var1.a_(this, var2);
      }

      return var2;
   }

   public long a(Source var1) throws IOException {
      if (var1 == null) {
         throw new IllegalArgumentException("source == null");
      }

      long var2 = 0L;

      while (true) {
         long var4 = var1.a(this, 8192L);
         if (var4 == -1L) {
            return var2;
         }

         var2 += var4;
      }
   }

   public String a(long var1, Charset var3) throws EOFException {
      Util.a(this.b, 0L, var1);
      if (var3 == null) {
         throw new IllegalArgumentException("charset == null");
      }

      if (var1 > 2147483647L) {
         throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + var1);
      }

      String var6;
      if (var1 == 0L) {
         var6 = "";
      } else {
         Segment var5 = this.a;
         if (var5.b + var1 > var5.c) {
            var6 = new String(this.h(var1), var3);
         } else {
            String var4 = new String(var5.a, var5.b, (int)var1, var3);
            var5.b = (int)(var5.b + var1);
            this.b -= var1;
            var6 = var4;
            if (var5.b == var5.c) {
               this.a = var5.a();
               SegmentPool.a(var5);
               var6 = var4;
            }
         }
      }

      return var6;
   }

   @Override
   public String a(Charset var1) {
      try {
         return this.a(this.b, var1);
      } catch (EOFException var2) {
         throw new AssertionError(var2);
      }
   }

   public Buffer a(int var1) {
      if (var1 < 128) {
         this.b(var1);
      } else if (var1 < 2048) {
         this.b(var1 >> 6 | 192);
         this.b(var1 & 63 | 128);
      } else if (var1 < 65536) {
         if (var1 >= 55296 && var1 <= 57343) {
            this.b(63);
         } else {
            this.b(var1 >> 12 | 224);
            this.b(var1 >> 6 & 63 | 128);
            this.b(var1 & 63 | 128);
         }
      } else {
         if (var1 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(var1));
         }

         this.b(var1 >> 18 | 240);
         this.b(var1 >> 12 & 63 | 128);
         this.b(var1 >> 6 & 63 | 128);
         this.b(var1 & 63 | 128);
      }

      return this;
   }

   public Buffer a(String var1) {
      return this.a(var1, 0, var1.length());
   }

   public Buffer a(String var1, int var2, int var3) {
      if (var1 == null) {
         throw new IllegalArgumentException("string == null");
      }

      if (var2 < 0) {
         throw new IllegalArgumentException("beginIndex < 0: " + var2);
      }

      if (var3 < var2) {
         throw new IllegalArgumentException("endIndex < beginIndex: " + var3 + " < " + var2);
      }

      if (var3 > var1.length()) {
         throw new IllegalArgumentException("endIndex > string.length: " + var3 + " > " + var1.length());
      }

      while (var2 < var3) {
         char var7 = var1.charAt(var2);
         if (var7 < 128) {
            Segment var9 = this.f(1);
            byte[] var8 = var9.a;
            int var5 = var9.c - var2;
            int var6 = Math.min(var3, 8192 - var5);
            int var11 = var2 + 1;
            var8[var5 + var2] = (byte)var7;

            for (var2 = var11; var2 < var6; var2++) {
               char var12 = var1.charAt(var2);
               if (var12 >= 128) {
                  break;
               }

               var8[var2 + var5] = (byte)var12;
            }

            var11 = var2 + var5 - var9.c;
            var9.c += var11;
            this.b += var11;
         } else if (var7 < 2048) {
            this.b(var7 >> 6 | 192);
            this.b(var7 & 63 | 128);
            var2++;
         } else if (var7 >= '\ud800' && var7 <= '\udfff') {
            char var4;
            if (var2 + 1 < var3) {
               var4 = var1.charAt(var2 + 1);
            } else {
               var4 = 0;
            }

            if (var7 <= '\udbff' && var4 >= 56320 && var4 <= 57343) {
               var4 = (var4 & -56321 | (var7 & -55297) << 10) + 65536;
               this.b(var4 >> 18 | 240);
               this.b(var4 >> 12 & 63 | 128);
               this.b(var4 >> 6 & 63 | 128);
               this.b(var4 & 63 | 128);
               var2 += 2;
            } else {
               this.b(63);
               var2++;
            }
         } else {
            this.b(var7 >> '\f' | 224);
            this.b(var7 >> 6 & 63 | 128);
            this.b(var7 & 63 | 128);
            var2++;
         }
      }

      return this;
   }

   public Buffer a(Buffer var1, long var2, long var4) {
      if (var1 == null) {
         throw new IllegalArgumentException("out == null");
      }

      Util.a(this.b, var2, var4);
      if (var4 != 0L) {
         var1.b += var4;
         Segment var10 = this.a;

         while (true) {
            Segment var11 = var10;
            long var6 = var2;
            long var8 = var4;
            if (var2 < var10.c - var10.b) {
               while (var8 > 0L) {
                  var10 = new Segment(var11);
                  var10.b = (int)(var10.b + var6);
                  var10.c = Math.min(var10.b + (int)var8, var10.c);
                  if (var1.a == null) {
                     var10.g = var10;
                     var10.f = var10;
                     var1.a = var10;
                  } else {
                     var1.a.g.a(var10);
                  }

                  var8 -= var10.c - var10.b;
                  var11 = var11.f;
                  var6 = 0L;
               }
               break;
            }

            var2 -= var10.c - var10.b;
            var10 = var10.f;
         }
      }

      return this;
   }

   public Buffer a(ByteString var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("byteString == null");
      }

      var1.a(this);
      return this;
   }

   @Override
   public Timeout a() {
      return Timeout.c;
   }

   @Override
   public void a(long var1) throws EOFException {
      if (this.b < var1) {
         throw new EOFException();
      }
   }

   @Override
   public void a(byte[] var1) throws EOFException {
      int var2 = 0;

      while (var2 < var1.length) {
         int var3 = this.a(var1, var2, var1.length - var2);
         if (var3 == -1) {
            throw new EOFException();
         }

         var2 += var3;
      }
   }

   @Override
   public boolean a(long var1, ByteString var3) {
      return this.a(var1, var3, 0, var3.h());
   }

   public boolean a(long var1, ByteString var3, int var4, int var5) {
      boolean var8 = false;
      boolean var7 = var8;
      if (var1 >= 0L) {
         var7 = var8;
         if (var4 >= 0) {
            var7 = var8;
            if (var5 >= 0) {
               var7 = var8;
               if (this.b - var1 >= var5) {
                  if (var3.h() - var4 < var5) {
                     var7 = var8;
                  } else {
                     int var6 = 0;

                     while (true) {
                        if (var6 >= var5) {
                           var7 = true;
                           break;
                        }

                        var7 = var8;
                        if (this.c(var6 + var1) != var3.a(var4 + var6)) {
                           break;
                        }

                        var6++;
                     }
                  }
               }
            }
         }
      }

      return var7;
   }

   @Override
   public void a_(Buffer var1, long var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("source == null");
      }

      if (var1 == this) {
         throw new IllegalArgumentException("source == this");
      }

      Util.a(var1.b, 0L, var2);

      while (var2 > 0L) {
         if (var2 < var1.a.c - var1.a.b) {
            Segment var7;
            if (this.a != null) {
               var7 = this.a.g;
            } else {
               var7 = null;
            }

            if (var7 != null && var7.e) {
               long var5 = var7.c;
               int var4;
               if (var7.d) {
                  var4 = 0;
               } else {
                  var4 = var7.b;
               }

               if (var5 + var2 - var4 <= 8192L) {
                  var1.a.a(var7, (int)var2);
                  var1.b -= var2;
                  this.b += var2;
                  break;
               }
            }

            var1.a = var1.a.a((int)var2);
         }

         Segment var11 = var1.a;
         long var10 = var11.c - var11.b;
         var1.a = var11.a();
         if (this.a == null) {
            this.a = var11;
            Segment var8 = this.a;
            var11 = this.a;
            Segment var9 = this.a;
            var11.g = var9;
            var8.f = var9;
         } else {
            this.a.g.a(var11).b();
         }

         var1.b -= var10;
         this.b += var10;
         var2 -= var10;
      }
   }

   public long b() {
      return this.b;
   }

   public Buffer b(int var1) {
      Segment var3 = this.f(1);
      byte[] var4 = var3.a;
      int var2 = var3.c++;
      var4[var2] = (byte)var1;
      this.b++;
      return this;
   }

   public Buffer b(byte[] var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("source == null");
      } else {
         return this.b(var1, 0, var1.length);
      }
   }

   public Buffer b(byte[] var1, int var2, int var3) {
      if (var1 == null) {
         throw new IllegalArgumentException("source == null");
      }

      Util.a(var1.length, var2, var3);
      int var4 = var2 + var3;

      while (var2 < var4) {
         Segment var6 = this.f(1);
         int var5 = Math.min(var4 - var2, 8192 - var6.c);
         System.arraycopy(var1, var2, var6.a, var6.c, var5);
         var2 += var5;
         var6.c += var5;
      }

      this.b += var3;
      return this;
   }

   @Override
   public boolean b(long var1) {
      boolean var3;
      if (this.b >= var1) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public byte c(long var1) {
      Util.a(this.b, var1, 1L);
      Segment var4 = this.a;

      while (true) {
         int var3 = var4.c - var4.b;
         if (var1 < var3) {
            return var4.a[var4.b + (int)var1];
         }

         var1 -= var3;
         var4 = var4.f;
      }
   }

   @Override
   public Buffer c() {
      return this;
   }

   public Buffer c(int var1) {
      Segment var5 = this.f(2);
      byte[] var4 = var5.a;
      int var2 = var5.c;
      int var3 = var2 + 1;
      var4[var2] = (byte)(var1 >>> 8 & 0xFF);
      var4[var3] = (byte)(var1 & 0xFF);
      var5.c = var3 + 1;
      this.b += 2L;
      return this;
   }

   @Override
   public void close() {
   }

   public OutputStream d() {
      return new OutputStream(this) {
         final Buffer a;

         {
            this.a = var1;
         }

         @Override
         public void close() {
         }

         @Override
         public void flush() {
         }

         @Override
         public String toString() {
            return this.a + ".outputStream()";
         }

         @Override
         public void write(int var1) {
            this.a.b((byte)var1);
         }

         @Override
         public void write(byte[] var1, int var2, int var3) {
            this.a.b(var1, var2, var3);
         }
      };
   }

   public Buffer d(int var1) {
      Segment var4 = this.f(4);
      byte[] var5 = var4.a;
      int var3 = var4.c;
      int var2 = var3 + 1;
      var5[var3] = (byte)(var1 >>> 24 & 0xFF);
      var3 = var2 + 1;
      var5[var2] = (byte)(var1 >>> 16 & 0xFF);
      var2 = var3 + 1;
      var5[var3] = (byte)(var1 >>> 8 & 0xFF);
      var5[var2] = (byte)(var1 & 0xFF);
      var4.c = var2 + 1;
      this.b += 4L;
      return this;
   }

   @Override
   public ByteString d(long var1) throws EOFException {
      return new ByteString(this.h(var1));
   }

   public String e(long var1) throws EOFException {
      return this.a(var1, Util.a);
   }

   public Buffer e() {
      return this;
   }

   public Buffer e(int var1) {
      return this.d(Util.a(var1));
   }

   @Override
   public boolean equals(Object var1) {
      long var5 = 0L;
      boolean var9;
      if (this == var1) {
         var9 = true;
      } else if (!(var1 instanceof Buffer)) {
         var9 = false;
      } else {
         var1 = var1;
         if (this.b != var1.b) {
            var9 = false;
         } else if (this.b == 0L) {
            var9 = true;
         } else {
            Segment var11 = this.a;
            Segment var13 = var1.a;
            int var3 = var11.b;
            int var2 = var13.b;

            while (var5 < this.b) {
               long var7 = Math.min(var11.c - var3, var13.c - var2);

               for (int var4 = 0; var4 < var7; var3++) {
                  if (var11.a[var3] != var13.a[var2]) {
                     return false;
                  }

                  var4++;
                  var2++;
               }

               int var15 = var3;
               Segment var10 = var11;
               if (var3 == var11.c) {
                  var10 = var11.f;
                  var15 = var10.b;
               }

               var3 = var2;
               var11 = var13;
               if (var2 == var13.c) {
                  var11 = var13.f;
                  var3 = var11.b;
               }

               var5 += var7;
               var2 = var3;
               var3 = var15;
               var13 = var11;
               var11 = var10;
            }

            var9 = true;
         }
      }

      return var9;
   }

   public String f(long var1) throws EOFException {
      long var3 = Long.MAX_VALUE;
      if (var1 < 0L) {
         throw new IllegalArgumentException("limit < 0: " + var1);
      }

      if (var1 != Long.MAX_VALUE) {
         var3 = var1 + 1L;
      }

      long var5 = this.a((byte)10, 0L, var3);
      String var7;
      if (var5 != -1L) {
         var7 = this.g(var5);
      } else {
         if (var3 >= this.b() || this.c(var3 - 1L) != 13 || this.c(var3) != 10) {
            Buffer var8 = new Buffer();
            this.a(var8, 0L, Math.min(32L, this.b()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.b(), var1) + " content=" + var8.p().f() + '…');
         }

         var7 = this.g(var3);
      }

      return var7;
   }

   Segment f(int var1) {
      if (var1 >= 1 && var1 <= 8192) {
         Segment var2;
         if (this.a == null) {
            this.a = SegmentPool.a();
            Segment var4 = this.a;
            Segment var3 = this.a;
            var2 = this.a;
            var3.g = var2;
            var4.f = var2;
         } else {
            Segment var5 = this.a.g;
            if (var5.c + var1 <= 8192) {
               var2 = var5;
               if (var5.e) {
                  return var2;
               }
            }

            var2 = var5.a(SegmentPool.a());
         }

         return var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @Override
   public boolean f() {
      boolean var1;
      if (this.b == 0L) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public void flush() {
   }

   @Override
   public InputStream g() {
      return new InputStream(this) {
         final Buffer a;

         {
            this.a = var1;
         }

         @Override
         public int available() {
            return (int)Math.min(this.a.b, 2147483647L);
         }

         @Override
         public void close() {
         }

         @Override
         public int read() {
            int var1;
            if (this.a.b > 0L) {
               var1 = this.a.i() & 255;
            } else {
               var1 = -1;
            }

            return var1;
         }

         @Override
         public int read(byte[] var1, int var2, int var3) {
            return this.a.a(var1, var2, var3);
         }

         @Override
         public String toString() {
            return this.a + ".inputStream()";
         }
      };
   }

   String g(long var1) throws EOFException {
      String var3;
      if (var1 > 0L && this.c(var1 - 1L) == 13) {
         var3 = this.e(var1 - 1L);
         this.i(2L);
      } else {
         var3 = this.e(var1);
         this.i(1L);
      }

      return var3;
   }

   public ByteString g(int var1) {
      ByteString var2;
      if (var1 == 0) {
         var2 = ByteString.b;
      } else {
         var2 = new SegmentedByteString(this, var1);
      }

      return var2;
   }

   public long h() {
      long var3 = this.b;
      long var1;
      if (var3 == 0L) {
         var1 = 0L;
      } else {
         Segment var5 = this.a.g;
         var1 = var3;
         if (var5.c < 8192) {
            var1 = var3;
            if (var5.e) {
               var1 = var3 - (var5.c - var5.b);
            }
         }
      }

      return var1;
   }

   @Override
   public byte[] h(long var1) throws EOFException {
      Util.a(this.b, 0L, var1);
      if (var1 > 2147483647L) {
         throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + var1);
      }

      byte[] var3 = new byte[(int)var1];
      this.a(var3);
      return var3;
   }

   @Override
   public int hashCode() {
      Segment var5 = this.a;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         int var3 = 1;

         Segment var6;
         do {
            int var2 = var5.b;
            int var4 = var5.c;
            var1 = var3;

            while (var2 < var4) {
               byte var7 = var5.a[var2];
               var2++;
               var1 = var7 + var1 * 31;
            }

            var6 = var5.f;
            var3 = var1;
            var5 = var6;
         } while (var6 != this.a);
      }

      return var1;
   }

   @Override
   public byte i() {
      if (this.b == 0L) {
         throw new IllegalStateException("size == 0");
      }

      Segment var5 = this.a;
      int var3 = var5.b;
      int var2 = var5.c;
      byte[] var6 = var5.a;
      int var4 = var3 + 1;
      byte var1 = var6[var3];
      this.b--;
      if (var4 == var2) {
         this.a = var5.a();
         SegmentPool.a(var5);
      } else {
         var5.b = var4;
      }

      return var1;
   }

   @Override
   public void i(long var1) throws EOFException {
      while (var1 > 0L) {
         if (this.a == null) {
            throw new EOFException();
         }

         int var3 = (int)Math.min(var1, this.a.c - this.a.b);
         this.b -= var3;
         long var4 = var1 - var3;
         Segment var6 = this.a;
         var6.b += var3;
         var1 = var4;
         if (this.a.b == this.a.c) {
            var6 = this.a;
            this.a = var6.a();
            SegmentPool.a(var6);
            var1 = var4;
         }
      }
   }

   public Buffer j(long var1) {
      Buffer var7;
      if (var1 == 0L) {
         var7 = this.b(48);
      } else {
         boolean var4;
         if (var1 < 0L) {
            var1 = -var1;
            if (var1 < 0L) {
               var7 = this.a("-9223372036854775808");
               return var7;
            }

            var4 = true;
         } else {
            var4 = false;
         }

         byte var3;
         if (var1 < 100000000L) {
            if (var1 < 10000L) {
               if (var1 < 100L) {
                  if (var1 < 10L) {
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }
               } else if (var1 < 1000L) {
                  var3 = 3;
               } else {
                  var3 = 4;
               }
            } else if (var1 < 1000000L) {
               if (var1 < 100000L) {
                  var3 = 5;
               } else {
                  var3 = 6;
               }
            } else if (var1 < 10000000L) {
               var3 = 7;
            } else {
               var3 = 8;
            }
         } else if (var1 < 1000000000000L) {
            if (var1 < 10000000000L) {
               if (var1 < 1000000000L) {
                  var3 = 9;
               } else {
                  var3 = 10;
               }
            } else if (var1 < 100000000000L) {
               var3 = 11;
            } else {
               var3 = 12;
            }
         } else if (var1 < 1000000000000000L) {
            if (var1 < 10000000000000L) {
               var3 = 13;
            } else if (var1 < 100000000000000L) {
               var3 = 14;
            } else {
               var3 = 15;
            }
         } else if (var1 < 100000000000000000L) {
            if (var1 < 10000000000000000L) {
               var3 = 16;
            } else {
               var3 = 17;
            }
         } else if (var1 < 1000000000000000000L) {
            var3 = 18;
         } else {
            var3 = 19;
         }

         int var5 = var3;
         if (var4) {
            var5 = var3 + 1;
         }

         Segment var11 = this.f(var5);
         byte[] var8 = var11.a;
         var3 = var11.c + var5;

         while (var1 != 0L) {
            int var6 = (int)(var1 % 10L);
            var8[--var3] = c[var6];
            var1 /= 10L;
         }

         if (var4) {
            var8[var3 - 1] = 45;
         }

         var11.c += var5;
         var1 = this.b;
         this.b = var5 + var1;
         var7 = this;
      }

      return var7;
   }

   @Override
   public short j() {
      if (this.b < 2L) {
         throw new IllegalStateException("size < 2: " + this.b);
      }

      Segment var6 = this.a;
      int var4 = var6.b;
      int var2 = var6.c;
      short var1;
      if (var2 - var4 < 2) {
         var1 = (short)((this.i() & 255) << 8 | this.i() & 0xFF);
      } else {
         byte[] var7 = var6.a;
         int var3 = var4 + 1;
         byte var9 = var7[var4];
         int var5 = var3 + 1;
         byte var8 = var7[var3];
         this.b -= 2L;
         if (var5 == var2) {
            this.a = var6.a();
            SegmentPool.a(var6);
         } else {
            var6.b = var5;
         }

         var1 = (short)((var9 & 255) << 8 | var8 & 0xFF);
      }

      return var1;
   }

   @Override
   public int k() {
      if (this.b < 4L) {
         throw new IllegalStateException("size < 4: " + this.b);
      }

      Segment var8 = this.a;
      int var1 = var8.b;
      int var2 = var8.c;
      if (var2 - var1 < 4) {
         var1 = (this.i() & 255) << 24 | (this.i() & 255) << 16 | (this.i() & 255) << 8 | this.i() & 255;
      } else {
         byte[] var7 = var8.a;
         int var3 = var1 + 1;
         byte var10 = var7[var1];
         int var4 = var3 + 1;
         byte var11 = var7[var3];
         int var5 = var4 + 1;
         byte var6 = var7[var4];
         var4 = var5 + 1;
         var1 = (var10 & 255) << 24 | (var11 & 255) << 16 | (var6 & 255) << 8 | var7[var5] & 255;
         this.b -= 4L;
         if (var4 == var2) {
            this.a = var8.a();
            SegmentPool.a(var8);
         } else {
            var8.b = var4;
         }
      }

      return var1;
   }

   public Buffer k(long var1) {
      Buffer var6;
      if (var1 == 0L) {
         var6 = this.b(48);
      } else {
         int var5 = Long.numberOfTrailingZeros(Long.highestOneBit(var1)) / 4 + 1;
         Segment var9 = this.f(var5);
         byte[] var7 = var9.a;
         int var3 = var9.c + var5 - 1;

         for (int var4 = var9.c; var3 >= var4; var3--) {
            var7[var3] = c[(int)(15L & var1)];
            var1 >>>= 4;
         }

         var9.c += var5;
         var1 = this.b;
         this.b = var5 + var1;
         var6 = this;
      }

      return var6;
   }

   @Override
   public short l() {
      return Util.a(this.j());
   }

   @Override
   public int m() {
      return Util.a(this.k());
   }

   @Override
   public long n() {
      if (this.b == 0L) {
         throw new IllegalStateException("size == 0");
      }

      long var10 = 0L;
      int var5 = 0;
      int var6 = 0;
      boolean var1 = false;
      long var12 = -7L;

      while (true) {
         Segment var15 = this.a;
         byte[] var14 = var15.a;
         int var3 = var15.b;
         int var7 = var15.c;
         long var8 = var10;
         int var2 = var5;
         boolean var4 = (boolean)var6;
         var10 = var12;

         while (true) {
            label71: {
               byte var16 = var1;
               if (var3 < var7) {
                  var16 = var14[var3];
                  if (var16 >= 48 && var16 <= 57) {
                     var6 = 48 - var16;
                     if (var8 < -922337203685477580L || var8 == -922337203685477580L && var6 < var10) {
                        Buffer var20 = new Buffer().j(var8).b(var16);
                        if (!var4) {
                           var20.i();
                        }

                        throw new NumberFormatException("Number too large: " + var20.q());
                     }

                     var8 = var8 * 10L + var6;
                     break label71;
                  }

                  if (var16 == 45 && var2 == 0) {
                     var4 = true;
                     var10--;
                     break label71;
                  }

                  if (var2 == 0) {
                     throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(var16));
                  }

                  var16 = 1;
               }

               if (var3 == var7) {
                  this.a = var15.a();
                  SegmentPool.a(var15);
               } else {
                  var15.b = var3;
               }

               if (!var16) {
                  var12 = var10;
                  var1 = (boolean)var16;
                  var6 = var4;
                  var5 = var2;
                  var10 = var8;
                  if (this.a != null) {
                     break;
                  }
               }

               this.b -= var2;
               if (!var4) {
                  var8 = -var8;
               }

               return var8;
            }

            var3++;
            var2++;
         }
      }
   }

   @Override
   public long o() {
      if (this.b == 0L) {
         throw new IllegalStateException("size == 0");
      }

      long var9 = 0L;
      int var1 = 0;
      boolean var2 = false;

      int var4;
      long var7;
      do {
         Segment var11 = this.a;
         byte[] var12 = var11.a;
         int var3 = var11.b;
         int var5 = var11.c;
         var7 = var9;
         var4 = var1;

         while (true) {
            var13 = var2;
            if (var3 >= var5) {
               break;
            }

            byte var6 = var12[var3];
            if (var6 >= 48 && var6 <= 57) {
               var1 = var6 - 48;
            } else if (var6 >= 97 && var6 <= 102) {
               var1 = var6 - 97 + 10;
            } else {
               if (var6 < 65 || var6 > 70) {
                  if (var4 == 0) {
                     throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(var6));
                  }

                  var13 = true;
                  break;
               }

               var1 = var6 - 65 + 10;
            }

            if ((-1152921504606846976L & var7) != 0L) {
               Buffer var16 = new Buffer().k(var7).b(var6);
               throw new NumberFormatException("Number too large: " + var16.q());
            }

            var9 = var1;
            var4++;
            var3++;
            var7 = var9 | var7 << 4;
         }

         if (var3 == var5) {
            this.a = var11.a();
            SegmentPool.a(var11);
         } else {
            var11.b = var3;
         }

         if (var13) {
            break;
         }

         var2 = var13;
         var1 = var4;
         var9 = var7;
      } while (this.a != null);

      this.b -= var4;
      return var7;
   }

   @Override
   public ByteString p() {
      return new ByteString(this.t());
   }

   public String q() {
      try {
         return this.a(this.b, Util.a);
      } catch (EOFException var2) {
         throw new AssertionError(var2);
      }
   }

   @Override
   public String r() throws EOFException {
      return this.f(Long.MAX_VALUE);
   }

   public int s() throws EOFException {
      if (this.b == 0L) {
         throw new EOFException();
      }

      int var4 = this.c(0L);
      int var1;
      int var2;
      byte var3;
      if ((var4 & 128) == 0) {
         var2 = 0;
         var1 = var4 & 127;
         var3 = 1;
      } else if ((var4 & 224) == 192) {
         var1 = var4 & 31;
         var3 = 2;
         var2 = 128;
      } else if ((var4 & 240) == 224) {
         var1 = var4 & 15;
         var3 = 3;
         var2 = 2048;
      } else {
         if ((var4 & 248) != 240) {
            this.i(1L);
            char var7 = '�';
            return var7;
         }

         var1 = var4 & 7;
         var3 = 4;
         var2 = 65536;
      }

      if (this.b < var3) {
         throw new EOFException("size < " + var3 + ": " + this.b + " (to read code point prefixed 0x" + Integer.toHexString(var4) + ")");
      }

      var4 = 1;

      while (true) {
         if (var4 >= var3) {
            this.i(var3);
            if (var1 > 1114111) {
               var1 = 65533;
            } else if (var1 >= 55296 && var1 <= 57343) {
               var1 = 65533;
            } else if (var1 < var2) {
               var1 = 65533;
            }
            break;
         }

         byte var5 = this.c((long)var4);
         if ((var5 & 192) != 128) {
            this.i((long)var4);
            var1 = 65533;
            break;
         }

         var4++;
         var1 = var5 & 63 | var1 << 6;
      }

      return var1;
   }

   @Override
   public byte[] t() {
      try {
         return this.h(this.b);
      } catch (EOFException var2) {
         throw new AssertionError(var2);
      }
   }

   @Override
   public String toString() {
      return this.w().toString();
   }

   public void u() {
      try {
         this.i(this.b);
      } catch (EOFException var2) {
         throw new AssertionError(var2);
      }
   }

   public Buffer v() {
      Buffer var2 = new Buffer();
      if (this.b != 0L) {
         var2.a = new Segment(this.a);
         Segment var4 = var2.a;
         Segment var1 = var2.a;
         Segment var3 = var2.a;
         var1.g = var3;
         var4.f = var3;

         for (Segment var5 = this.a.f; var5 != this.a; var5 = var5.f) {
            var2.a.g.a(new Segment(var5));
         }

         var2.b = this.b;
      }

      return var2;
   }

   public ByteString w() {
      if (this.b > 2147483647L) {
         throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
      } else {
         return this.g((int)this.b);
      }
   }
}
