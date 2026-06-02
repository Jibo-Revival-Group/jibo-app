package okhttp3;

import java.io.IOException;

public interface Call extends Cloneable {
   Request a();

   void a(Callback var1);

   Response b() throws IOException;

   void c();

   boolean d();

   interface Factory {
      Call a(Request var1);
   }
}
