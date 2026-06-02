package okhttp3;

import java.io.IOException;

public interface Authenticator {
   Authenticator a = new Authenticator() {
      @Override
      public Request authenticate(Route var1, Response var2) {
         return null;
      }
   };

   Request authenticate(Route var1, Response var2) throws IOException;
}
