package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class GzipSink implements Sink {
   private final BufferedSink a;
   private final Deflater b;
   private final DeflaterSink c;
   private boolean d;
   private final CRC32 e = new CRC32();

   public GzipSink(Sink var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("sink == null");
      }

      this.b = new Deflater(-1, true);
      this.a = Okio.a(var1);
      this.c = new DeflaterSink(this.a, this.b);
      this.b();
   }

   private void b() {
      Buffer var1 = this.a.c();
      var1.c(8075);
      var1.b(8);
      var1.b(0);
      var1.d(0);
      var1.b(0);
      var1.b(0);
   }

   private void b(Buffer var1, long var2) {
      for (Segment var5 = var1.a; var2 > 0L; var5 = var5.f) {
         int var4 = (int)Math.min(var2, var5.c - var5.b);
         this.e.update(var5.a, var5.b, var4);
         var2 -= var4;
      }
   }

   private void c() throws IOException {
      this.a.h((int)this.e.getValue());
      this.a.h((int)this.b.getBytesRead());
   }

   @Override
   public Timeout a() {
      return this.a.a();
   }

   @Override
   public void a_(Buffer var1, long var2) throws IOException {
      if (var2 < 0L) {
         throw new IllegalArgumentException("byteCount < 0: " + var2);
      }

      if (var2 != 0L) {
         this.b(var1, var2);
         this.c.a_(var1, var2);
      }
   }

   @Override
   public void close() throws IOException {
      if (!this.d) {
         Throwable var2 = null;

         try {
            this.c.b();
            this.c();
         } catch (Throwable var4) {
            var2 = var4;
         }

         Throwable var1;
         label36: {
            try {
               this.b.end();
            } catch (Throwable var6) {
               var1 = var6;
               if (var2 != null) {
                  var1 = var2;
               }
               break label36;
            }

            var1 = var2;
         }

         label30: {
            try {
               this.a.close();
            } catch (Throwable var5) {
               var2 = var1;
               if (var1 == null) {
                  var2 = var5;
               }
               break label30;
            }

            var2 = var1;
         }

         this.d = true;
         if (var2 != null) {
            Util.a(var2);
         }
      }
   }

   @Override
   public void flush() throws IOException {
      this.c.flush();
   }
}
