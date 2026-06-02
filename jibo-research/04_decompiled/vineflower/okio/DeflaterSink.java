package okio;

import java.io.IOException;
import java.util.zip.Deflater;

public final class DeflaterSink implements Sink {
   private final BufferedSink a;
   private final Deflater b;
   private boolean c;

   DeflaterSink(BufferedSink var1, Deflater var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("source == null");
      }

      if (var2 == null) {
         throw new IllegalArgumentException("inflater == null");
      }

      this.a = var1;
      this.b = var2;
   }

   private void a(boolean var1) throws IOException {
      Buffer var4 = this.a.c();

      while (true) {
         Segment var3 = var4.f(1);
         int var2;
         if (var1) {
            var2 = this.b.deflate(var3.a, var3.c, 8192 - var3.c, 2);
         } else {
            var2 = this.b.deflate(var3.a, var3.c, 8192 - var3.c);
         }

         if (var2 > 0) {
            var3.c += var2;
            var4.b += var2;
            this.a.x();
         } else if (this.b.needsInput()) {
            if (var3.b == var3.c) {
               var4.a = var3.a();
               SegmentPool.a(var3);
            }

            return;
         }
      }
   }

   @Override
   public Timeout a() {
      return this.a.a();
   }

   @Override
   public void a_(Buffer var1, long var2) throws IOException {
      Util.a(var1.b, 0L, var2);

      while (var2 > 0L) {
         Segment var5 = var1.a;
         int var4 = (int)Math.min(var2, var5.c - var5.b);
         this.b.setInput(var5.a, var5.b, var4);
         this.a(false);
         var1.b -= var4;
         var5.b += var4;
         if (var5.b == var5.c) {
            var1.a = var5.a();
            SegmentPool.a(var5);
         }

         var2 -= var4;
      }
   }

   void b() throws IOException {
      this.b.finish();
      this.a(false);
   }

   @Override
   public void close() throws IOException {
      if (!this.c) {
         Throwable var1 = null;

         try {
            this.b();
         } catch (Throwable var4) {
            var1 = var4;
         }

         Throwable var2;
         label36: {
            try {
               this.b.end();
            } catch (Throwable var6) {
               var2 = var6;
               if (var1 != null) {
                  var2 = var1;
               }
               break label36;
            }

            var2 = var1;
         }

         label30: {
            try {
               this.a.close();
            } catch (Throwable var5) {
               var1 = var2;
               if (var2 == null) {
                  var1 = var5;
               }
               break label30;
            }

            var1 = var2;
         }

         this.c = true;
         if (var1 != null) {
            Util.a(var1);
         }
      }
   }

   @Override
   public void flush() throws IOException {
      this.a(true);
      this.a.flush();
   }

   @Override
   public String toString() {
      return "DeflaterSink(" + this.a + ")";
   }
}
