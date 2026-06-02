package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class GzipSource implements Source {
   private int a = 0;
   private final BufferedSource b;
   private final Inflater c;
   private final InflaterSource d;
   private final CRC32 e = new CRC32();

   public GzipSource(Source var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("source == null");
      }

      this.c = new Inflater(true);
      this.b = Okio.a(var1);
      this.d = new InflaterSource(this.b, this.c);
   }

   private void a(String var1, int var2, int var3) throws IOException {
      if (var3 != var2) {
         throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", var1, var3, var2));
      }
   }

   private void a(Buffer var1, long var2, long var4) {
      Segment var13 = var1.a;

      while (true) {
         Segment var12 = var13;
         long var8 = var2;
         long var10 = var4;
         if (var2 < var13.c - var13.b) {
            while (var10 > 0L) {
               int var6 = (int)(var12.b + var8);
               int var7 = (int)Math.min(var12.c - var6, var10);
               this.e.update(var12.a, var6, var7);
               var10 -= var7;
               var12 = var12.f;
               var8 = 0L;
            }

            return;
         }

         var2 -= var13.c - var13.b;
         var13 = var13.f;
      }
   }

   private void b() throws IOException {
      this.b.a(10L);
      byte var2 = this.b.c().c(3L);
      boolean var1;
      if ((var2 >> 1 & 1) == 1) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (var1) {
         this.a(this.b.c(), 0L, 10L);
      }

      this.a("ID1ID2", 8075, this.b.j());
      this.b.i(8L);
      if ((var2 >> 2 & 1) == 1) {
         this.b.a(2L);
         if (var1) {
            this.a(this.b.c(), 0L, 2L);
         }

         short var3 = this.b.c().l();
         this.b.a(var3);
         if (var1) {
            this.a(this.b.c(), 0L, var3);
         }

         this.b.i(var3);
      }

      if ((var2 >> 3 & 1) == 1) {
         long var4 = this.b.a((byte)0);
         if (var4 == -1L) {
            throw new EOFException();
         }

         if (var1) {
            this.a(this.b.c(), 0L, 1L + var4);
         }

         this.b.i(1L + var4);
      }

      if ((var2 >> 4 & 1) == 1) {
         long var6 = this.b.a((byte)0);
         if (var6 == -1L) {
            throw new EOFException();
         }

         if (var1) {
            this.a(this.b.c(), 0L, 1L + var6);
         }

         this.b.i(1L + var6);
      }

      if (var1) {
         this.a("FHCRC", this.b.l(), (short)this.e.getValue());
         this.e.reset();
      }
   }

   private void c() throws IOException {
      this.a("CRC", this.b.m(), (int)this.e.getValue());
      this.a("ISIZE", this.b.m(), (int)this.c.getBytesWritten());
   }

   @Override
   public long a(Buffer var1, long var2) throws IOException {
      long var4 = 0L;
      if (var2 < 0L) {
         throw new IllegalArgumentException("byteCount < 0: " + var2);
      }

      if (var2 == 0L) {
         var2 = var4;
      } else {
         if (this.a == 0) {
            this.b();
            this.a = 1;
         }

         if (this.a == 1) {
            var4 = var1.b;
            var2 = this.d.a(var1, var2);
            if (var2 != -1L) {
               this.a(var1, var4, var2);
               return var2;
            }

            this.a = 2;
         }

         if (this.a == 2) {
            this.c();
            this.a = 3;
            if (!this.b.f()) {
               throw new IOException("gzip finished without exhausting source");
            }
         }

         var2 = -1L;
      }

      return var2;
   }

   @Override
   public Timeout a() {
      return this.b.a();
   }

   @Override
   public void close() throws IOException {
      this.d.close();
   }
}
