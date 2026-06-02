package com.google.maps.internal;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.maps.GeolocationApi;
import com.google.maps.PendingResult;
import com.google.maps.PhotoRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiResponse;
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
import com.jibo.aws.integration.aws.services.media.model.Media;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpStatus;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public class OkHttpPendingResult<T, R extends ApiResponse<T>> implements PendingResult<T>, Callback {
    private static final Logger LOG = LoggerFactory.m17025a(OkHttpPendingResult.class.getName());
    private static final List<Integer> RETRY_ERROR_CODES = Arrays.asList(500, 503, Integer.valueOf(HttpStatus.SC_GATEWAY_TIMEOUT));
    private Call call;
    private PendingResult.Callback<T> callback;
    private final OkHttpClient client;
    private long errorTimeOut;
    private ExceptionsAllowedToRetry exceptionsAllowedToRetry;
    private final FieldNamingPolicy fieldNamingPolicy;
    private final Integer maxRetries;
    private final Request request;
    private final Class<R> responseClass;
    private int retryCounter = 0;
    private long cumulativeSleepTime = 0;

    public OkHttpPendingResult(Request request, OkHttpClient okHttpClient, Class<R> cls, FieldNamingPolicy fieldNamingPolicy, long j, Integer num, ExceptionsAllowedToRetry exceptionsAllowedToRetry) {
        this.request = request;
        this.client = okHttpClient;
        this.responseClass = cls;
        this.fieldNamingPolicy = fieldNamingPolicy;
        this.errorTimeOut = j;
        this.maxRetries = num;
        this.exceptionsAllowedToRetry = exceptionsAllowedToRetry;
        this.call = okHttpClient.mo15540a(request);
    }

    @Override // com.google.maps.PendingResult
    public void setCallback(PendingResult.Callback<T> callback) {
        this.callback = callback;
        FirebasePerfOkHttpClient.enqueue(this.call, this);
    }

    private class QueuedResponse {

        /* JADX INFO: renamed from: e */
        private final IOException f9070e;
        private final OkHttpPendingResult<T, R> request;
        private final Response response;

        public QueuedResponse(OkHttpPendingResult<T, R> okHttpPendingResult, Response response) {
            this.request = okHttpPendingResult;
            this.response = response;
            this.f9070e = null;
        }

        public QueuedResponse(OkHttpPendingResult<T, R> okHttpPendingResult, IOException iOException) {
            this.request = okHttpPendingResult;
            this.response = null;
            this.f9070e = iOException;
        }
    }

    @Override // com.google.maps.PendingResult
    public T await() throws InterruptedException, IOException, ApiException {
        if (this.retryCounter > 0) {
            long jPow = (long) (Math.pow(1.5d, this.retryCounter - 1) * 0.5d * (Math.random() + 0.5d) * 1000.0d);
            LOG.mo17018a(String.format("Sleeping between errors for %dms (retry #%d, already slept %dms)", Long.valueOf(jPow), Integer.valueOf(this.retryCounter), Long.valueOf(this.cumulativeSleepTime)));
            this.cumulativeSleepTime += jPow;
            try {
                Thread.sleep(jPow);
            } catch (InterruptedException e) {
            }
        }
        final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        FirebasePerfOkHttpClient.enqueue(this.call, new Callback() { // from class: com.google.maps.internal.OkHttpPendingResult.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                arrayBlockingQueue.add(new QueuedResponse(this, iOException));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                arrayBlockingQueue.add(new QueuedResponse(this, response));
            }
        });
        QueuedResponse queuedResponse = (QueuedResponse) arrayBlockingQueue.take();
        if (queuedResponse.response != null) {
            return parseResponse(queuedResponse.request, queuedResponse.response);
        }
        throw queuedResponse.f9070e;
    }

    @Override // com.google.maps.PendingResult
    public T awaitIgnoreError() {
        try {
            return await();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.google.maps.PendingResult
    public void cancel() {
        this.call.mo15538c();
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        if (this.callback != null) {
            this.callback.onFailure(iOException);
        }
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) throws IOException {
        if (this.callback != null) {
            try {
                this.callback.onResult(parseResponse(this, response));
            } catch (Exception e) {
                this.callback.onFailure(e);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v32, types: [T, com.google.maps.model.PhotoResult] */
    private T parseResponse(OkHttpPendingResult<T, R> okHttpPendingResult, Response response) throws InterruptedException, IOException, ApiException {
        if (shouldRetry(response)) {
            return okHttpPendingResult.retry();
        }
        byte[] bArrM15824d = response.m15798h().m15824d();
        String strM15789a = response.m15789a("Content-Type");
        if (strM15789a != null && strM15789a.startsWith(Media.TYPE_IMAGE) && this.responseClass == PhotoRequest.Response.class && response.m15793c() == 200) {
            ?? r0 = (T) new PhotoResult();
            r0.contentType = strM15789a;
            r0.imageData = bArrM15824d;
            return r0;
        }
        try {
            ApiResponse apiResponse = (ApiResponse) new GsonBuilder().m9380a((Type) DateTime.class, (Object) new DateTimeAdapter()).m9380a((Type) Distance.class, (Object) new DistanceAdapter()).m9380a((Type) Duration.class, (Object) new DurationAdapter()).m9380a((Type) Fare.class, (Object) new FareAdapter()).m9380a((Type) LatLng.class, (Object) new LatLngAdapter()).m9380a((Type) AddressComponentType.class, (Object) new SafeEnumAdapter(AddressComponentType.UNKNOWN)).m9380a((Type) AddressType.class, (Object) new SafeEnumAdapter(AddressType.UNKNOWN)).m9380a((Type) TravelMode.class, (Object) new SafeEnumAdapter(TravelMode.UNKNOWN)).m9380a((Type) LocationType.class, (Object) new SafeEnumAdapter(LocationType.UNKNOWN)).m9380a((Type) PlaceDetails.Review.AspectRating.RatingType.class, (Object) new SafeEnumAdapter(PlaceDetails.Review.AspectRating.RatingType.UNKNOWN)).m9380a((Type) OpeningHours.Period.OpenClose.DayOfWeek.class, (Object) new DayOfWeekAdapter()).m9380a((Type) PriceLevel.class, (Object) new PriceLevelAdapter()).m9380a((Type) Instant.class, (Object) new InstantAdapter()).m9380a((Type) LocalTime.class, (Object) new LocalTimeAdapter()).m9380a((Type) GeolocationApi.Response.class, (Object) new GeolocationResponseAdapter()).m9377a(this.fieldNamingPolicy).m9376a().m9355a(new String(bArrM15824d, "utf8"), (Class) this.responseClass);
            if (apiResponse.successful()) {
                return (T) apiResponse.getResult();
            }
            ApiException error = apiResponse.getError();
            if (shouldRetry(error)) {
                return okHttpPendingResult.retry();
            }
            throw error;
        } catch (JsonSyntaxException e) {
            if (!response.m15794d()) {
                throw new IOException(String.format("Server Error: %d %s", Integer.valueOf(response.m15793c()), response.m15795e()));
            }
            throw e;
        }
    }

    private T retry() throws InterruptedException, ApiException, IOException {
        this.retryCounter++;
        LOG.mo17023b("Retrying request. Retry #" + this.retryCounter);
        this.call = this.client.mo15540a(this.request);
        return await();
    }

    private boolean shouldRetry(Response response) {
        return RETRY_ERROR_CODES.contains(Integer.valueOf(response.m15793c())) && this.cumulativeSleepTime < this.errorTimeOut && (this.maxRetries == null || this.retryCounter < this.maxRetries.intValue());
    }

    private boolean shouldRetry(ApiException apiException) {
        return this.exceptionsAllowedToRetry.contains(apiException.getClass()) && this.cumulativeSleepTime < this.errorTimeOut && (this.maxRetries == null || this.retryCounter < this.maxRetries.intValue());
    }
}
