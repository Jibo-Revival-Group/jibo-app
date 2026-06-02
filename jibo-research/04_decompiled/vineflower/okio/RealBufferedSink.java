package okio;

import java.io.IOException;

final class RealBufferedSink implements BufferedSink {
   public final Buffer a = new Buffer();
   public final Sink b;
   boolean c;

   RealBufferedSink(Sink var1) {
      if (var1 == null) {
         throw new NullPointerException("sink == null");
      }

      this.b = var1;
   }

   @Override
   public Timeout a() {
      return this.b.a();
   }

   @Override
   public void a_(Buffer var1, long var2) throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      this.a.a_(var1, var2);
      this.x();
   }

   @Override
   public BufferedSink b(String var1) throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      this.a.a(var1);
      return this.x();
   }

   @Override
   public BufferedSink b(ByteString var1) throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      this.a.a(var1);
      return this.x();
   }

   @Override
   public Buffer c() {
      return this.a;
   }

   @Override
   public BufferedSink c(byte[] var1) throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      this.a.b(var1);
      return this.x();
   }

   @Override
   public BufferedSink c(byte[] var1, int var2, int var3) throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      this.a.b(var1, var2, var3);
      return this.x();
   }

   @Override
   public void close() throws IOException {
      if (!this.c) {
         Throwable var2 = null;
         Throwable var1 = var2;

         label31: {
            try {
               if (this.a.b <= 0L) {
                  break label31;
               }

               this.b.a_(this.a, this.a.b);
            } catch (Throwable var5) {
               var1 = var5;
               break label31;
            }

            var1 = var2;
         }

         label25: {
            try {
               this.b.close();
            } catch (Throwable var4) {
               var2 = var1;
               if (var1 == null) {
                  var2 = var4;
               }
               break label25;
            }

            var2 = var1;
         }

         this.c = true;
         if (var2 != null) {
            Util.a(var2);
         }
      }
   }

   @Override
   public void flush() throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      if (this.a.b > 0L) {
         this.b.a_(this.a, this.a.b);
      }

      this.b.flush();
   }

   @Override
   public BufferedSink h(int var1) throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      this.a.e(var1);
      return this.x();
   }

   @Override
   public BufferedSink i(int var1) throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      this.a.d(var1);
      return this.x();
   }

   @Override
   public BufferedSink j(int var1) throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      this.a.c(var1);
      return this.x();
   }

   @Override
   public BufferedSink k(int var1) throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      this.a.b(var1);
      return this.x();
   }

   @Override
   public BufferedSink l(long var1) throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      this.a.k(var1);
      return this.x();
   }

   @Override
   public BufferedSink m(long var1) throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      this.a.j(var1);
      return this.x();
   }

   @Override
   public String toString() {
      return "buffer(" + this.b + ")";
   }

   @Override
   public BufferedSink x() throws IOException {
      if (this.c) {
         throw new IllegalStateException("closed");
      }

      long var1 = this.a.h();
      if (var1 > 0L) {
         this.b.a_(this.a, var1);
      }

      return this;
   }
}
