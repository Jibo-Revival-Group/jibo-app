package okio;

import java.io.IOException;

public abstract class ForwardingSink implements Sink {
   private final Sink a;

   public ForwardingSink(Sink var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("delegate == null");
      }

      this.a = var1;
   }

   @Override
   public Timeout a() {
      return this.a.a();
   }

   @Override
   public void a_(Buffer var1, long var2) throws IOException {
      this.a.a_(var1, var2);
   }

   @Override
   public void close() throws IOException {
      this.a.close();
   }

   @Override
   public void flush() throws IOException {
      this.a.flush();
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + "(" + this.a.toString() + ")";
   }
}
