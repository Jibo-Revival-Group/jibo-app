package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

public final class RouteDatabase {
   private final Set<Route> a = new LinkedHashSet<>();

   public void a(Route var1) {
      synchronized (this) {
         this.a.add(var1);
      }
   }

   public void b(Route var1) {
      synchronized (this) {
         this.a.remove(var1);
      }
   }

   public boolean c(Route var1) {
      synchronized (this) {
         return this.a.contains(var1);
      }
   }
}
