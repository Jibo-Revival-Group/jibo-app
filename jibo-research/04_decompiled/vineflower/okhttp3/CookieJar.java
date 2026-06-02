package okhttp3;

import java.util.Collections;
import java.util.List;

public interface CookieJar {
   CookieJar a = new CookieJar() {
      @Override
      public List<Cookie> a(HttpUrl var1) {
         return Collections.emptyList();
      }

      @Override
      public void a(HttpUrl var1, List<Cookie> var2) {
      }
   };

   List<Cookie> a(HttpUrl var1);

   void a(HttpUrl var1, List<Cookie> var2);
}
