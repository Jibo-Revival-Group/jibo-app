package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class InflaterSource implements Source {
   private final BufferedSource a;
   private final Inflater b;
   private int c;
   private boolean d;

   InflaterSource(BufferedSource var1, Inflater var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("source == null");
      }

      if (var2 == null) {
         throw new IllegalArgumentException("inflater == null");
      }

      this.a = var1;
      this.b = var2;
   }

   private void c() throws IOException {
      if (this.c != 0) {
         int var1 = this.c - this.b.getRemaining();
         this.c -= var1;
         this.a.i(var1);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public long a(Buffer var1, long var2) throws IOException {
      long var5 = 0L;
      if (var2 < 0L) {
         throw new IllegalArgumentException("byteCount < 0: " + var2);
      }

      if (this.d) {
         throw new IllegalStateException("closed");
      }

      if (var2 == 0L) {
         var2 = var5;
      } else {
         Segment var8;
         while (true) {
            boolean var7 = this.b();

            int var4;
            try {
               var8 = var1.f(1);
               var4 = this.b.inflate(var8.a, var8.c, 8192 - var8.c);
            } catch (DataFormatException var11) {
               throw new IOException(var11);
            }

            if (var4 > 0) {
               try {
                  var8.c += var4;
                  var1.b += var4;
               } catch (DataFormatException var10) {
                  throw new IOException(var10);
               }

               var2 = var4;
               return var2;
            }

            try {
               if (this.b.finished() || this.b.needsDictionary()) {
                  break;
               }
            } catch (DataFormatException var13) {
               throw new IOException(var13);
            }

            if (var7) {
               try {
                  EOFException var14 = new EOFException("source exhausted prematurely");
                  throw var14;
               } catch (DataFormatException var9) {
                  throw new IOException(var9);
               }
            }
         }

         try {
            this.c();
            if (var8.b == var8.c) {
               var1.a = var8.a();
               SegmentPool.a(var8);
            }
         } catch (DataFormatException var12) {
            throw new IOException(var12);
         }

         var2 = -1L;
      }

      return var2;
   }

   @Override
   public Timeout a() {
      return this.a.a();
   }

   public boolean b() throws IOException {
      boolean var1 = false;
      if (this.b.needsInput()) {
         this.c();
         if (this.b.getRemaining() != 0) {
            throw new IllegalStateException("?");
         }

         if (this.a.f()) {
            var1 = true;
         } else {
            Segment var2 = this.a.c().a;
            this.c = var2.c - var2.b;
            this.b.setInput(var2.a, var2.b, this.c);
         }
      }

      return var1;
   }

   @Override
   public void close() throws IOException {
      if (!this.d) {
         this.b.end();
         this.d = true;
         this.a.close();
      }
   }
}
