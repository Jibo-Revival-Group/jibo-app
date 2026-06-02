package android.support.v4.util;

public class Preconditions {
   public static <T> T a(T var0) {
      if (var0 == null) {
         throw new NullPointerException();
      } else {
         return (T)var0;
      }
   }
}
