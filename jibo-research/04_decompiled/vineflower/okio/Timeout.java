package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class Timeout {
   public static final Timeout c = new Timeout() {
      @Override
      public Timeout a(long var1) {
         return this;
      }

      @Override
      public Timeout a(long var1, TimeUnit var3) {
         return this;
      }

      @Override
      public void g() throws IOException {
      }
   };
   private boolean a;
   private long b;
   private long d;

   public Timeout a(long var1) {
      this.a = true;
      this.b = var1;
      return this;
   }

   public Timeout a(long var1, TimeUnit var3) {
      if (var1 < 0L) {
         throw new IllegalArgumentException("timeout < 0: " + var1);
      }

      if (var3 == null) {
         throw new IllegalArgumentException("unit == null");
      }

      this.d = var3.toNanos(var1);
      return this;
   }

   public long d() {
      if (!this.a) {
         throw new IllegalStateException("No deadline");
      } else {
         return this.b;
      }
   }

   public Timeout f() {
      this.a = false;
      return this;
   }

   public void g() throws IOException {
      if (Thread.interrupted()) {
         throw new InterruptedIOException("thread interrupted");
      }

      if (this.a && this.b - System.nanoTime() <= 0L) {
         throw new InterruptedIOException("deadline reached");
      }
   }

   public long x_() {
      return this.d;
   }

   public boolean y_() {
      return this.a;
   }

   public Timeout z_() {
      this.d = 0L;
      return this;
   }
}
