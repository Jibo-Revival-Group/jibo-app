package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
   private final Gson a;
   private final TypeAdapter<T> b;

   GsonResponseBodyConverter(Gson var1, TypeAdapter<T> var2) {
      this.a = var1;
      this.b = var2;
   }

   public T a(ResponseBody var1) throws IOException {
      JsonReader var2 = this.a.a(var1.e());

      try {
         return this.b.read(var2);
      } finally {
         var1.close();
      }
   }
}
