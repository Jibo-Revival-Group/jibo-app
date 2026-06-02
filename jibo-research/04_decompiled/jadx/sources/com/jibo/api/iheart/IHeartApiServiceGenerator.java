package com.jibo.api.iheart;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.jibo.api.iheart.model.Genre;
import com.jibo.api.iheart.model.Station;
import com.jibo.aws.integration.helpers.RobotHelper;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes.dex */
public class IHeartApiServiceGenerator {

    /* JADX INFO: renamed from: a */
    private static HashMap<String, String> f9281a = new HashMap<>();

    /* JADX INFO: renamed from: b */
    private static Gson f9282b;

    /* JADX INFO: renamed from: c */
    private static HttpLoggingInterceptor f9283c;

    public interface IHeartStationsApiService {
        @GET(m17183a = "/api/v2/content/liveStations?limit=10000")
        /* JADX INFO: renamed from: a */
        Call<List<Station>> m9884a(@Query(m17199a = RobotHelper.FIELD_COUNTRY_CODE) String str, @Query(m17199a = "genreId") int i);

        @GET(m17183a = "/api/v2/content/liveStations?limit=10000")
        /* JADX INFO: renamed from: a */
        Call<List<Station>> m9885a(@Query(m17199a = RobotHelper.FIELD_COUNTRY_CODE) String str, @Query(m17199a = "zipCode") String str2, @Query(m17199a = "genreId") int i);
    }

    static {
        f9281a.put("US", "https://us.api.iheart.com/");
        f9281a.put("AU", "https://au.api.iheart.com/");
        f9281a.put("CA", "https://ca.api.iheart.com/");
        f9281a.put("NZ", "https://nz.api.iheart.com/");
        f9282b = new GsonBuilder().m9380a(new TypeToken<List<Genre>>() { // from class: com.jibo.api.iheart.IHeartApiServiceGenerator.2
        }.getType(), new DataDeserializer()).m9380a(new TypeToken<List<Station>>() { // from class: com.jibo.api.iheart.IHeartApiServiceGenerator.1
        }.getType(), new DataDeserializer()).m9376a();
        f9283c = new HttpLoggingInterceptor().m16232a(HttpLoggingInterceptor.Level.NONE);
    }

    /* JADX INFO: renamed from: a */
    public static String m9883a(String str) {
        if (f9281a.containsKey(str)) {
            return f9281a.get(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static IHeartStationsApiService m9882a(String str, Interceptor interceptor) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Retrofit.Builder builderM17139a = new Retrofit.Builder().m17135a(str).m17139a(GsonConverterFactory.m17177a(f9282b));
        builder.m15753b(10L, TimeUnit.SECONDS);
        builder.m15751a(f9283c);
        if (interceptor != null) {
            builder.m15751a(interceptor);
        }
        builderM17139a.m17138a(builder.m15752a());
        return (IHeartStationsApiService) builderM17139a.m17140a().m17124a(IHeartStationsApiService.class);
    }

    static class DataDeserializer<T> implements JsonDeserializer<T> {
        DataDeserializer() {
        }

        @Override // com.google.gson.JsonDeserializer
        public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonElement jsonElementM9407c = jsonElement.m9395l().m9407c("hits");
            if (jsonElementM9407c.m9391h()) {
                jsonElementM9407c = jsonElementM9407c.m9396m();
            }
            return (T) new Gson().m9351a(jsonElementM9407c, type);
        }
    }
}
