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

public class IHeartApiServiceGenerator {
   private static HashMap<String, String> a = new HashMap<>();
   private static Gson b = new GsonBuilder()
      .a((new TypeToken<List<Genre>>() {}).getType(), new IHeartApiServiceGenerator.DataDeserializer())
      .a((new TypeToken<List<Station>>() {}).getType(), new IHeartApiServiceGenerator.DataDeserializer())
      .a();
   private static HttpLoggingInterceptor c = new HttpLoggingInterceptor().a(HttpLoggingInterceptor.Level.NONE);

   static {
      a.put("US", "https://us.api.iheart.com/");
      a.put("AU", "https://au.api.iheart.com/");
      a.put("CA", "https://ca.api.iheart.com/");
      a.put("NZ", "https://nz.api.iheart.com/");
   }

   public static IHeartApiServiceGenerator.IHeartStationsApiService a(String var0, Interceptor var1) {
      IHeartApiServiceGenerator.IHeartStationsApiService var4;
      if (!TextUtils.isEmpty(var0)) {
         OkHttpClient.Builder var2 = new OkHttpClient.Builder();
         Retrofit.Builder var3 = new Retrofit.Builder().a(var0).a(GsonConverterFactory.a(b));
         var2.b(10L, TimeUnit.SECONDS);
         var2.a(c);
         if (var1 != null) {
            var2.a(var1);
         }

         var3.a(var2.a());
         var4 = var3.a().a(IHeartApiServiceGenerator.IHeartStationsApiService.class);
      } else {
         var4 = null;
      }

      return var4;
   }

   public static String a(String var0) {
      if (a.containsKey(var0)) {
         var0 = a.get(var0);
      } else {
         var0 = null;
      }

      return var0;
   }

   static class DataDeserializer<T> implements JsonDeserializer<T> {
      @Override
      public T deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonElement var5 = var1.l().c("hits");
         var1 = var5;
         if (var5.h()) {
            var1 = var5.m();
         }

         return new Gson().a(var1, var2);
      }
   }

   public interface IHeartStationsApiService {
      @GET(a = "/api/v2/content/liveStations?limit=10000")
      Call<List<Station>> a(@Query(a = "countryCode") String var1, @Query(a = "genreId") int var2);

      @GET(a = "/api/v2/content/liveStations?limit=10000")
      Call<List<Station>> a(@Query(a = "countryCode") String var1, @Query(a = "zipCode") String var2, @Query(a = "genreId") int var3);
   }
}
