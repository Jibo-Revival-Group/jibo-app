package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes2.dex */
public final class GsonConverterFactory extends Converter.Factory {

    /* JADX INFO: renamed from: a */
    private final Gson f16371a;

    /* JADX INFO: renamed from: a */
    public static GsonConverterFactory m17177a(Gson gson) {
        return new GsonConverterFactory(gson);
    }

    private GsonConverterFactory(Gson gson) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }
        this.f16371a = gson;
    }

    @Override // retrofit2.Converter.Factory
    /* JADX INFO: renamed from: a */
    public Converter<ResponseBody, ?> mo17074a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.f16371a, this.f16371a.m9346a((TypeToken) TypeToken.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    /* JADX INFO: renamed from: a */
    public Converter<?, RequestBody> mo17075a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.f16371a, this.f16371a.m9346a((TypeToken) TypeToken.get(type)));
    }
}
