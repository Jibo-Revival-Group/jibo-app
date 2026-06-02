package com.google.maps.internal;

import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.maps.GeolocationApi;
import com.google.maps.PendingResult;
import com.google.maps.PhotoRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.errors.UnknownErrorException;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.AddressType;
import com.google.maps.model.Distance;
import com.google.maps.model.Duration;
import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.Fare;
import com.google.maps.model.LatLng;
import com.google.maps.model.LocationType;
import com.google.maps.model.OpeningHours;
import com.google.maps.model.PhotoResult;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PriceLevel;
import com.google.maps.model.TravelMode;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GaePendingResult<T, R extends ApiResponse<T>> implements PendingResult<T> {
   private static final Logger LOG = LoggerFactory.a(GaePendingResult.class.getName());
   private static final List<Integer> RETRY_ERROR_CODES = Arrays.asList(500, 503, 504);
   private Future<HTTPResponse> call;
   private final URLFetchService client;
   private long cumulativeSleepTime;
   private long errorTimeOut;
   private final ExceptionsAllowedToRetry exceptionsAllowedToRetry;
   private final FieldNamingPolicy fieldNamingPolicy;
   private final Integer maxRetries;
   private final HTTPRequest request;
   private final Class<R> responseClass;
   private int retryCounter = 0;

   public GaePendingResult(
      HTTPRequest var1, URLFetchService var2, Class<R> var3, FieldNamingPolicy var4, long var5, Integer var7, ExceptionsAllowedToRetry var8
   ) {
      this.cumulativeSleepTime = 0L;
      this.request = var1;
      this.client = var2;
      this.responseClass = var3;
      this.fieldNamingPolicy = var4;
      this.errorTimeOut = var5;
      this.maxRetries = var7;
      this.exceptionsAllowedToRetry = var8;
      this.call = var2.fetchAsync(var1);
   }

   private T parseResponse(GaePendingResult<T, R> var1, HTTPResponse var2) throws IOException, ApiException, InterruptedException {
      Object var8;
      if (this.shouldRetry(var2)) {
         var8 = var1.retry();
      } else {
         byte[] var4 = var2.getContent();
         String var3 = null;

         for (HTTPHeader var6 : var2.getHeaders()) {
            if (var6.getName().equalsIgnoreCase("Content-Type")) {
               var3 = var6.getValue();
            }
         }

         if (var3 != null && var3.startsWith("image") && this.responseClass == PhotoRequest.Response.class && var2.getResponseCode() == 200) {
            var8 = new PhotoResult();
            ((PhotoResult)var8).contentType = var3;
            ((PhotoResult)var8).imageData = var4;
         } else {
            Gson var12 = new GsonBuilder()
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
               .a(EncodedPolyline.class, new EncodedPolylineInstanceCreator(""))
               .a(this.fieldNamingPolicy)
               .a();

            try {
               var3 = new String(var4, "utf8");
               var11 = var12.a(var3, this.responseClass);
            } catch (JsonSyntaxException var7) {
               if (var2.getResponseCode() > 399) {
                  throw new IOException(String.format("Server Error: %d %s", var2.getResponseCode(), new String(var2.getContent(), Charset.defaultCharset())));
               }

               throw var7;
            }

            if (var11.successful()) {
               var8 = var11.getResult();
            } else {
               ApiException var9 = var11.getError();
               if (!this.shouldRetry(var9)) {
                  throw var9;
               }

               var8 = var1.retry();
            }
         }
      }

      return (T)var8;
   }

   private T retry() throws IOException, ApiException, InterruptedException {
      this.retryCounter++;
      LOG.a("Retrying request. Retry #{}", this.retryCounter);
      this.call = this.client.fetchAsync(this.request);
      return this.await();
   }

   private boolean shouldRetry(HTTPResponse var1) {
      boolean var2;
      if (!RETRY_ERROR_CODES.contains(var1.getResponseCode())
         || this.cumulativeSleepTime >= this.errorTimeOut
         || this.maxRetries != null && this.retryCounter >= this.maxRetries) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
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

   @Override
   public T await() throws ApiException, IOException, InterruptedException {
      try {
         return this.parseResponse(this, this.call.get());
      } catch (ExecutionException var2) {
         if (var2.getCause() instanceof IOException) {
            throw (IOException)var2.getCause();
         } else {
            throw new UnknownErrorException("Unexpected exception from " + var2.getMessage());
         }
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
      this.call.cancel(true);
   }

   @Override
   public void setCallback(PendingResult.Callback<T> var1) {
      throw new RuntimeException("setCallback not implemented for Google App Engine");
   }
}
