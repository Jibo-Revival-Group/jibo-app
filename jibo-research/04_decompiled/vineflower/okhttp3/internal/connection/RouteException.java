package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RouteException extends RuntimeException {
   private static final Method a;
   private IOException b;

   static {
      Method var0;
      try {
         var0 = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
      } catch (Exception var1) {
         var0 = null;
      }

      a = var0;
   }

   public RouteException(IOException var1) {
      super(var1);
      this.b = var1;
   }

   private void a(IOException var1, IOException var2) {
      if (a != null) {
         try {
            a.invoke(var1, var2);
         } catch (InvocationTargetException var3) {
         } catch (IllegalAccessException var4) {
         }
      }
   }

   public IOException a() {
      return this.b;
   }

   public void a(IOException var1) {
      this.a(var1, this.b);
      this.b = var1;
   }
}
