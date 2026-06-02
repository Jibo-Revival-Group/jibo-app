package retrofit2;

import okhttp3.ResponseBody;

public final class Response<T> {
   private final okhttp3.Response a;
   private final T b;
   private final ResponseBody c;

   private Response(okhttp3.Response var1, T var2, ResponseBody var3) {
      this.a = var1;
      this.b = (T)var2;
      this.c = var3;
   }

   public static <T> Response<T> a(T var0, okhttp3.Response var1) {
      Utils.a(var1, "rawResponse == null");
      if (!var1.d()) {
         throw new IllegalArgumentException("rawResponse must be successful response");
      } else {
         return new Response<>(var1, (T)var0, null);
      }
   }

   public static <T> Response<T> a(ResponseBody var0, okhttp3.Response var1) {
      Utils.a(var0, "body == null");
      Utils.a(var1, "rawResponse == null");
      if (var1.d()) {
         throw new IllegalArgumentException("rawResponse should not be successful response");
      } else {
         return new Response<>(var1, null, var0);
      }
   }

   public boolean a() {
      return this.a.d();
   }

   public T b() {
      return this.b;
   }

   @Override
   public String toString() {
      return this.a.toString();
   }
}
