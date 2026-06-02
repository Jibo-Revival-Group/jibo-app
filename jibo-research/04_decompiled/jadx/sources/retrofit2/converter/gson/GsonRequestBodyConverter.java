package retrofit2.converter.gson;

import com.google.api.client.json.Json;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import org.apache.http.protocol.HTTP;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes2.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {

    /* JADX INFO: renamed from: a */
    private static final MediaType f16372a = MediaType.m15695a(Json.MEDIA_TYPE);

    /* JADX INFO: renamed from: b */
    private static final Charset f16373b = Charset.forName(HTTP.UTF_8);

    /* JADX INFO: renamed from: c */
    private final Gson f16374c;

    /* JADX INFO: renamed from: d */
    private final TypeAdapter<T> f16375d;

    GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f16374c = gson;
        this.f16375d = typeAdapter;
    }

    @Override // retrofit2.Converter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RequestBody mo17076a(T t) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter jsonWriterM9349a = this.f16374c.m9349a((Writer) new OutputStreamWriter(buffer.m16275d(), f16373b));
        this.f16375d.write(jsonWriterM9349a, t);
        jsonWriterM9349a.close();
        return RequestBody.m15786a(f16372a, buffer.mo16305p());
    }
}
