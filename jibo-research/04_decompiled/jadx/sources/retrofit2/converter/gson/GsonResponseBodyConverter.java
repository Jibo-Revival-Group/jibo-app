package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes2.dex */
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    /* JADX INFO: renamed from: a */
    private final Gson f16376a;

    /* JADX INFO: renamed from: b */
    private final TypeAdapter<T> f16377b;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f16376a = gson;
        this.f16377b = typeAdapter;
    }

    @Override // retrofit2.Converter
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public T mo17076a(ResponseBody responseBody) throws IOException {
        try {
            return this.f16377b.read(this.f16376a.m9348a(responseBody.m15825e()));
        } finally {
            responseBody.close();
        }
    }
}
