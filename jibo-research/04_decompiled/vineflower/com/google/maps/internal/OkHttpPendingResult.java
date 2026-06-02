package com.google.maps.internal;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.maps.GeolocationApi;
import com.google.maps.PendingResult;
import com.google.maps.PhotoRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.AddressType;
import com.google.maps.model.Distance;
import com.google.maps.model.Duration;
import com.google.maps.model.Fare;
import com.google.maps.model.LatLng;
import com.google.maps.model.LocationType;
import com.google.maps.model.OpeningHours;
import com.google.maps.model.PhotoResult;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PriceLevel;
import com.google.maps.model.TravelMode;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OkHttpPendingResult<T, R extends ApiResponse<T>> implements PendingResult<T>, okhttp3.Callback {
   private static final Logger LOG = LoggerFactory.a(OkHttpPendingResult.class.getName());
   private static final List<Integer> RETRY_ERROR_CODES = Arrays.asList(500, 503, 504);
   private Call call;
   private PendingResult.Callback<T> callback;
   private final OkHttpClient client;
   private long cumulativeSleepTime;
   private long errorTimeOut;
   private ExceptionsAllowedToRetry exceptionsAllowedToRetry;
   private final FieldNamingPolicy fieldNamingPolicy;
   private final Integer maxRetries;
   private final Request request;
   private final Class<R> responseClass;
   private int retryCounter = 0;

   public OkHttpPendingResult(Request var1, OkHttpClient var2, Class<R> var3, FieldNamingPolicy var4, long var5, Integer var7, ExceptionsAllowedToRetry var8) {
      this.cumulativeSleepTime = 0L;
      this.request = var1;
      this.client = var2;
      this.responseClass = var3;
      this.fieldNamingPolicy = var4;
      this.errorTimeOut = var5;
      this.maxRetries = var7;
      this.exceptionsAllowedToRetry = var8;
      this.call = var2.a(var1);
   }

   private T parseResponse(OkHttpPendingResult<T, R> var1, Response var2) throws ApiException, InterruptedException, IOException {
      Object var7;
      if (this.shouldRetry(var2)) {
         var7 = var1.retry();
      } else {
         byte[] var3 = var2.h().d();
         String var4 = var2.a("Content-Type");
         if (var4 != null && var4.startsWith("image") && this.responseClass == PhotoRequest.Response.class && var2.c() == 200) {
            var7 = new PhotoResult();
            ((PhotoResult)var7).contentType = var4;
            ((PhotoResult)var7).imageData = var3;
         } else {
            Gson var5 = new GsonBuilder()
               .a(DateTime.class, new DateTimeAdapter())
               .a(Distance.class, new DistanceAdapter())
               .a(Duration.class, new DurationAdapter())
               .a(Fare.class, new FareAdapter())
               .a(LatLng.class, new LatLngAdapter())
               .a(AddressComponentType.class, new SafeEnumAdapter<>(AddressComponentType.UNKNOWN))
               .a(AddressType.class, new SafeEnumAdapter<>(AddressType.UNKNOWN))
               .a(TravelMode.class, new SafeEnumAdapter<>(TravelMode.UNKNOWN))
               .a(LocationType.class, new SafeEnumAdapter<>(LocationType.UNKNOWN))
               .a(PlaceDetails.Review.AspectRating.RatingType.class, new SafeEnumAdapter<>(PlaceDetails.Review.AspectRating.RatingType.UNKNOWN))
               .a(OpeningHours.Period.OpenClose.DayOfWeek.class, new DayOfWeekAdapter())
               .a(PriceLevel.class, new PriceLevelAdapter())
               .a(Instant.class, new InstantAdapter())
               .a(LocalTime.class, new LocalTimeAdapter())
               .a(GeolocationApi.Response.class, new GeolocationResponseAdapter())
               .a(this.fieldNamingPolicy)
               .a();

            try {
               var4 = new String(var3, "utf8");
               var9 = var5.a(var4, this.responseClass);
            } catch (JsonSyntaxException var6) {
               if (!var2.d()) {
                  throw new IOException(String.format("Server Error: %d %s", var2.c(), var2.e()));
               }

               throw var6;
            }

            if (var9.successful()) {
               var7 = var9.getResult();
            } else {
               ApiException var8 = var9.getError();
               if (!this.shouldRetry(var8)) {
                  throw var8;
               }

               var7 = var1.retry();
            }
         }
      }

      return (T)var7;
   }

   private T retry() throws ApiException, InterruptedException, IOException {
      this.retryCounter++;
      LOG.b("Retrying request. Retry #" + this.retryCounter);
      this.call = this.client.a(this.request);
      return this.await();
   }

   private boolean shouldRetry(ApiException var1) {
      boolean var2;
      if (!this.exceptionsAllowedToRetry.contains(var1.getClass())
         || this.cumulativeSleepTime >= this.errorTimeOut
         || this.maxRetries != null && this.retryCounter >= this.maxRetries) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   private boolean shouldRetry(Response var1) {
      boolean var2;
      if (!RETRY_ERROR_CODES.contains(var1.c())
         || this.cumulativeSleepTime >= this.errorTimeOut
         || this.maxRetries != null && this.retryCounter >= this.maxRetries) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public T await() throws ApiException, IOException, InterruptedException {
      if (this.retryCounter > 0) {
         long var1 = (long)(Math.pow(1.5, this.retryCounter - 1) * 0.5 * (Math.random() + 0.5) * 1000.0);
         LOG.a(String.format("Sleeping between errors for %dms (retry #%d, already slept %dms)", var1, this.retryCounter, this.cumulativeSleepTime));
         this.cumulativeSleepTime += var1;

         try {
            Thread.sleep(var1);
         } catch (InterruptedException var4) {
         }
      }

      ArrayBlockingQueue var3 = new ArrayBlockingQueue(1);
      FirebasePerfOkHttpClient.enqueue(this.call, new okhttp3.Callback(this, var3, this) {
         final OkHttpPendingResult this$0;
         final OkHttpPendingResult val$parent;
         final BlockingQueue val$waiter;

         {
            this.this$0 = var1;
            this.val$waiter = var2;
            this.val$parent = var3x;
         }

         @Override
         public void onFailure(Call var1, IOException var2) {
            this.val$waiter.add(this.this$0.new QueuedResponse(this.this$0, this.val$parent, var2));
         }

         @Override
         public void onResponse(Call var1, Response var2) throws IOException {
            this.val$waiter.add(this.this$0.new QueuedResponse(this.this$0, this.val$parent, var2));
         }
      });
      OkHttpPendingResult.QueuedResponse var5 = (OkHttpPendingResult.QueuedResponse)var3.take();
      if (var5.response != null) {
         return this.parseResponse(var5.request, var5.response);
      } else {
         throw var5.e;
      }
   }

   @Override
   public T awaitIgnoreError() {
      Object var1;
      try {
         var1 = this.await();
      } catch (Exception var2) {
         var1 = null;
      }

      return (T)var1;
   }

   @Override
   public void cancel() {
      this.call.c();
   }

   @Override
   public void onFailure(Call var1, IOException var2) {
      if (this.callback != null) {
         this.callback.onFailure(var2);
      }
   }

   @Override
   public void onResponse(Call var1, Response var2) throws IOException {
      if (this.callback != null) {
         try {
            this.callback.onResult(this.parseResponse(this, var2));
         } catch (Exception var3) {
            this.callback.onFailure(var3);
         }
      }
   }

   @Override
   public void setCallback(PendingResult.Callback<T> var1) {
      this.callback = var1;
      FirebasePerfOkHttpClient.enqueue(this.call, this);
   }

   private class QueuedResponse {
      private final IOException e;
      private final OkHttpPendingResult<T, R> request;
      private final Response response;
      final OkHttpPendingResult this$0;

      public QueuedResponse(OkHttpPendingResult<T, R> var1, OkHttpPendingResult var2, IOException var3) {
         this.this$0 = var1;
         this.request = var2;
         this.response = null;
         this.e = var3;
      }

      public QueuedResponse(OkHttpPendingResult<T, R> var1, OkHttpPendingResult var2, Response var3) {
         this.this$0 = var1;
         this.request = var2;
         this.response = var3;
         this.e = null;
      }
   }
}
