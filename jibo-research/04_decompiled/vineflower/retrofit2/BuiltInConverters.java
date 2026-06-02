package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Streaming;

final class BuiltInConverters extends Converter.Factory {
   @Override
   public Converter<ResponseBody, ?> a(Type var1, Annotation[] var2, Retrofit var3) {
      Converter var4;
      if (var1 == ResponseBody.class) {
         if (Utils.a(var2, Streaming.class)) {
            var4 = BuiltInConverters.StreamingResponseBodyConverter.a;
         } else {
            var4 = BuiltInConverters.BufferingResponseBodyConverter.a;
         }
      } else if (var1 == Void.class) {
         var4 = BuiltInConverters.VoidResponseBodyConverter.a;
      } else {
         var4 = null;
      }

      return var4;
   }

   @Override
   public Converter<?, RequestBody> a(Type var1, Annotation[] var2, Annotation[] var3, Retrofit var4) {
      BuiltInConverters.RequestBodyConverter var5;
      if (RequestBody.class.isAssignableFrom(Utils.a(var1))) {
         var5 = BuiltInConverters.RequestBodyConverter.a;
      } else {
         var5 = null;
      }

      return var5;
   }

   static final class BufferingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {
      static final BuiltInConverters.BufferingResponseBodyConverter a = new BuiltInConverters.BufferingResponseBodyConverter();

      public ResponseBody a(ResponseBody var1) throws IOException {
         try {
            return Utils.a(var1);
         } finally {
            var1.close();
         }
      }
   }

   static final class RequestBodyConverter implements Converter<RequestBody, RequestBody> {
      static final BuiltInConverters.RequestBodyConverter a = new BuiltInConverters.RequestBodyConverter();

      public RequestBody a(RequestBody var1) throws IOException {
         return var1;
      }
   }

   static final class StreamingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {
      static final BuiltInConverters.StreamingResponseBodyConverter a = new BuiltInConverters.StreamingResponseBodyConverter();

      public ResponseBody a(ResponseBody var1) throws IOException {
         return var1;
      }
   }

   static final class ToStringConverter implements Converter<Object, String> {
      static final BuiltInConverters.ToStringConverter a = new BuiltInConverters.ToStringConverter();

      public String b(Object var1) {
         return var1.toString();
      }
   }

   static final class VoidResponseBodyConverter implements Converter<ResponseBody, Void> {
      static final BuiltInConverters.VoidResponseBodyConverter a = new BuiltInConverters.VoidResponseBodyConverter();

      public Void a(ResponseBody var1) throws IOException {
         var1.close();
         return null;
      }
   }
}
