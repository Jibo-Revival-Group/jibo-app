package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class GsonConverterFactory extends Converter.Factory {
   private final Gson a;

   private GsonConverterFactory(Gson var1) {
      if (var1 == null) {
         throw new NullPointerException("gson == null");
      }

      this.a = var1;
   }

   public static GsonConverterFactory a(Gson var0) {
      return new GsonConverterFactory(var0);
   }

   @Override
   public Converter<ResponseBody, ?> a(Type var1, Annotation[] var2, Retrofit var3) {
      TypeAdapter var4 = this.a.a(TypeToken.get(var1));
      return new GsonResponseBodyConverter(this.a, var4);
   }

   @Override
   public Converter<?, RequestBody> a(Type var1, Annotation[] var2, Annotation[] var3, Retrofit var4) {
      TypeAdapter var5 = this.a.a(TypeToken.get(var1));
      return new GsonRequestBodyConverter(this.a, var5);
   }
}
