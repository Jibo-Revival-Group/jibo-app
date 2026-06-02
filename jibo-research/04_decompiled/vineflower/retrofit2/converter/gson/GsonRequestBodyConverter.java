package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
   private static final MediaType a = MediaType.a("application/json; charset=UTF-8");
   private static final Charset b = Charset.forName("UTF-8");
   private final Gson c;
   private final TypeAdapter<T> d;

   GsonRequestBodyConverter(Gson var1, TypeAdapter<T> var2) {
      this.c = var1;
      this.d = var2;
   }

   public RequestBody b(T var1) throws IOException {
      Buffer var2 = new Buffer();
      OutputStreamWriter var3 = new OutputStreamWriter(var2.d(), b);
      JsonWriter var4 = this.c.a(var3);
      this.d.write(var4, (T)var1);
      var4.close();
      return RequestBody.a(a, var2.p());
   }
}
