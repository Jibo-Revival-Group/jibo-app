package com.google.maps.internal;

import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.maps.GeolocationApi;
import com.google.maps.PendingResult;
import com.google.maps.PhotoRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.errors.UnknownErrorException;
import com.google.maps.internal.ApiResponse;
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
import com.jibo.aws.integration.aws.services.media.model.Media;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.http.HttpStatus;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public class GaePendingResult<T, R extends ApiResponse<T>> implements PendingResult<T> {
    private static final Logger LOG = LoggerFactory.m17025a(GaePendingResult.class.getName());
    private static final List<Integer> RETRY_ERROR_CODES = Arrays.asList(500, 503, Integer.valueOf(HttpStatus.SC_GATEWAY_TIMEOUT));
    private Future<HTTPResponse> call;
    private final URLFetchService client;
    private long errorTimeOut;
    private final ExceptionsAllowedToRetry exceptionsAllowedToRetry;
    private final FieldNamingPolicy fieldNamingPolicy;
    private final Integer maxRetries;
    private final HTTPRequest request;
    private final Class<R> responseClass;
    private int retryCounter = 0;
    private long cumulativeSleepTime = 0;

    public GaePendingResult(HTTPRequest hTTPRequest, URLFetchService uRLFetchService, Class<R> cls, FieldNamingPolicy fieldNamingPolicy, long j, Integer num, ExceptionsAllowedToRetry exceptionsAllowedToRetry) {
        this.request = hTTPRequest;
        this.client = uRLFetchService;
        this.responseClass = cls;
        this.fieldNamingPolicy = fieldNamingPolicy;
        this.errorTimeOut = j;
        this.maxRetries = num;
        this.exceptionsAllowedToRetry = exceptionsAllowedToRetry;
        this.call = uRLFetchService.fetchAsync(hTTPRequest);
    }

    @Override // com.google.maps.PendingResult
    public void setCallback(PendingResult.Callback<T> callback) {
        throw new RuntimeException("setCallback not implemented for Google App Engine");
    }

    @Override // com.google.maps.PendingResult
    public T await() throws InterruptedException, IOException, ApiException {
        try {
            return parseResponse(this, this.call.get());
        } catch (ExecutionException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw new UnknownErrorException("Unexpected exception from " + e.getMessage());
        }
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
        this.call.cancel(true);
    }

    /* JADX WARN: Type inference failed for: r0v33, types: [T, com.google.maps.model.PhotoResult] */
    private T parseResponse(GaePendingResult<T, R> gaePendingResult, HTTPResponse hTTPResponse) throws InterruptedException, ApiException, IOException {
        if (shouldRetry(hTTPResponse)) {
            return gaePendingResult.retry();
        }
        byte[] content = hTTPResponse.getContent();
        String value = null;
        for (HTTPHeader hTTPHeader : hTTPResponse.getHeaders()) {
            value = hTTPHeader.getName().equalsIgnoreCase("Content-Type") ? hTTPHeader.getValue() : value;
        }
        if (value != null && value.startsWith(Media.TYPE_IMAGE) && this.responseClass == PhotoRequest.Response.class && hTTPResponse.getResponseCode() == 200) {
            ?? r0 = (T) new PhotoResult();
            r0.contentType = value;
            r0.imageData = content;
            return r0;
        }
        try {
            ApiResponse apiResponse = (ApiResponse) new GsonBuilder().m9380a((Type) DateTime.class, (Object) new DateTimeAdapter()).m9380a((Type) Distance.class, (Object) new DistanceAdapter()).m9380a((Type) Duration.class, (Object) new DurationAdapter()).m9380a((Type) Fare.class, (Object) new FareAdapter()).m9380a((Type) LatLng.class, (Object) new LatLngAdapter()).m9380a((Type) AddressComponentType.class, (Object) new SafeEnumAdapter(AddressComponentType.UNKNOWN)).m9380a((Type) AddressType.class, (Object) new SafeEnumAdapter(AddressType.UNKNOWN)).m9380a((Type) TravelMode.class, (Object) new SafeEnumAdapter(TravelMode.UNKNOWN)).m9380a((Type) LocationType.class, (Object) new SafeEnumAdapter(LocationType.UNKNOWN)).m9380a((Type) PlaceDetails.Review.AspectRating.RatingType.class, (Object) new SafeEnumAdapter(PlaceDetails.Review.AspectRating.RatingType.UNKNOWN)).m9380a((Type) OpeningHours.Period.OpenClose.DayOfWeek.class, (Object) new DayOfWeekAdapter()).m9380a((Type) PriceLevel.class, (Object) new PriceLevelAdapter()).m9380a((Type) Instant.class, (Object) new InstantAdapter()).m9380a((Type) LocalTime.class, (Object) new LocalTimeAdapter()).m9380a((Type) GeolocationApi.Response.class, (Object) new GeolocationResponseAdapter()).m9380a((Type) EncodedPolyline.class, (Object) new EncodedPolylineInstanceCreator("")).m9377a(this.fieldNamingPolicy).m9376a().m9355a(new String(content, "utf8"), (Class) this.responseClass);
            if (apiResponse.successful()) {
                return (T) apiResponse.getResult();
            }
            ApiException error = apiResponse.getError();
            if (shouldRetry(error)) {
                return gaePendingResult.retry();
            }
            throw error;
        } catch (JsonSyntaxException e) {
            if (hTTPResponse.getResponseCode() > 399) {
                throw new IOException(String.format("Server Error: %d %s", Integer.valueOf(hTTPResponse.getResponseCode()), new String(hTTPResponse.getContent(), Charset.defaultCharset())));
            }
            throw e;
        }
    }

    private T retry() throws InterruptedException, IOException, ApiException {
        this.retryCounter++;
        LOG.mo17019a("Retrying request. Retry #{}", Integer.valueOf(this.retryCounter));
        this.call = this.client.fetchAsync(this.request);
        return await();
    }

    private boolean shouldRetry(HTTPResponse hTTPResponse) {
        return RETRY_ERROR_CODES.contains(Integer.valueOf(hTTPResponse.getResponseCode())) && this.cumulativeSleepTime < this.errorTimeOut && (this.maxRetries == null || this.retryCounter < this.maxRetries.intValue());
    }

    private boolean shouldRetry(ApiException apiException) {
        return this.exceptionsAllowedToRetry.contains(apiException.getClass()) && this.cumulativeSleepTime < this.errorTimeOut && (this.maxRetries == null || this.retryCounter < this.maxRetries.intValue());
    }
}
