package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public interface CallAdapter<R, T> {
   T a(Call<R> var1);

   Type a();

   abstract class Factory {
      protected static Class<?> a(Type var0) {
         return Utils.a(var0);
      }

      public abstract CallAdapter<?, ?> a(Type var1, Annotation[] var2, Retrofit var3);
   }
}
