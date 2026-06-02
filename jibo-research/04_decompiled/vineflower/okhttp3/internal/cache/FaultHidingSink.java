package okhttp3.internal.cache;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

class FaultHidingSink extends ForwardingSink {
   private boolean a;

   FaultHidingSink(Sink var1) {
      super(var1);
   }

   protected void a(IOException var1) {
   }

   @Override
   public void a_(Buffer var1, long var2) throws IOException {
      if (this.a) {
         var1.i(var2);
      } else {
         try {
            super.a_(var1, var2);
         } catch (IOException var4) {
            this.a = true;
            this.a(var4);
         }
      }
   }

   @Override
   public void close() throws IOException {
      if (!this.a) {
         try {
            super.close();
         } catch (IOException var2) {
            this.a = true;
            this.a(var2);
         }
      }
   }

   @Override
   public void flush() throws IOException {
      if (!this.a) {
         try {
            super.flush();
         } catch (IOException var2) {
            this.a = true;
            this.a(var2);
         }
      }
   }
}
