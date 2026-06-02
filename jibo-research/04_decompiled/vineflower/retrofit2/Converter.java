package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public interface Converter<F, T> {
   T a(F var1) throws IOException;

   abstract class Factory {
      public Converter<ResponseBody, ?> a(Type var1, Annotation[] var2, Retrofit var3) {
         return null;
      }

      public Converter<?, RequestBody> a(Type var1, Annotation[] var2, Annotation[] var3, Retrofit var4) {
         return null;
      }

      public Converter<?, String> b(Type var1, Annotation[] var2, Retrofit var3) {
         return null;
      }
   }
}
