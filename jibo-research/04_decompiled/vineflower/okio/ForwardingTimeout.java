package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ForwardingTimeout extends Timeout {
   private Timeout a;

   public ForwardingTimeout(Timeout var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("delegate == null");
      }

      this.a = var1;
   }

   public final ForwardingTimeout a(Timeout var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("delegate == null");
      }

      this.a = var1;
      return this;
   }

   public final Timeout a() {
      return this.a;
   }

   @Override
   public Timeout a(long var1) {
      return this.a.a(var1);
   }

   @Override
   public Timeout a(long var1, TimeUnit var3) {
      return this.a.a(var1, var3);
   }

   @Override
   public long d() {
      return this.a.d();
   }

   @Override
   public Timeout f() {
      return this.a.f();
   }

   @Override
   public void g() throws IOException {
      this.a.g();
   }

   @Override
   public long x_() {
      return this.a.x_();
   }

   @Override
   public boolean y_() {
      return this.a.y_();
   }

   @Override
   public Timeout z_() {
      return this.a.z_();
   }
}
