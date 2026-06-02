package okhttp3.internal.http2;

import java.util.concurrent.CountDownLatch;

final class Ping {
   private final CountDownLatch a = new CountDownLatch(1);
   private long b = -1L;
   private long c = -1L;

   void a() {
      if (this.b != -1L) {
         throw new IllegalStateException();
      }

      this.b = System.nanoTime();
   }

   void b() {
      if (this.c == -1L && this.b != -1L) {
         this.c = System.nanoTime();
         this.a.countDown();
      } else {
         throw new IllegalStateException();
      }
   }

   void c() {
      if (this.c == -1L && this.b != -1L) {
         this.c = this.b - 1L;
         this.a.countDown();
      } else {
         throw new IllegalStateException();
      }
   }
}
