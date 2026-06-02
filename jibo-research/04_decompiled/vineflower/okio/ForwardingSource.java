package okio;

import java.io.IOException;

public abstract class ForwardingSource implements Source {
   private final Source a;

   public ForwardingSource(Source var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("delegate == null");
      }

      this.a = var1;
   }

   @Override
   public long a(Buffer var1, long var2) throws IOException {
      return this.a.a(var1, var2);
   }

   @Override
   public Timeout a() {
      return this.a.a();
   }

   @Override
   public void close() throws IOException {
      this.a.close();
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + "(" + this.a.toString() + ")";
   }
}
