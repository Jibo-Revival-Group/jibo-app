package com.google.maps;

import com.google.api.client.http.HttpMethods;
import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.GeolocationPayload;
import com.google.maps.model.GeolocationResult;
import com.google.maps.model.LatLng;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class GeolocationApi {
    private static final Logger LOG = Logger.getLogger(GeolocationApi.class.getName());
    private static final String API_BASE_URL = "https://www.googleapis.com";
    static final ApiConfig GEOLOCATION_API_CONFIG = new ApiConfig("/geolocation/v1/geolocate").hostName(API_BASE_URL).supportsClientId(false).fieldNamingPolicy(FieldNamingPolicy.IDENTITY).requestVerb(HttpMethods.POST);

    private GeolocationApi() {
    }

    public static PendingResult<GeolocationResult> geolocate(GeoApiContext geoApiContext, GeolocationPayload geolocationPayload) {
        return new GeolocationApiRequest(geoApiContext).Payload(geolocationPayload).CreatePayload();
    }

    public static GeolocationApiRequest newRequest(GeoApiContext geoApiContext) {
        return new GeolocationApiRequest(geoApiContext);
    }

    public static class Response implements ApiResponse<GeolocationResult> {
        public int code = 200;
        public String message = "OK";
        public double accuracy = -1.0d;
        public LatLng location = null;
        public String domain = null;
        public String reason = null;
        public String debugInfo = null;

        @Override // com.google.maps.internal.ApiResponse
        public boolean successful() {
            return this.code == 200;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.maps.internal.ApiResponse
        public GeolocationResult getResult() {
            GeolocationResult geolocationResult = new GeolocationResult();
            geolocationResult.accuracy = this.accuracy;
            geolocationResult.location = this.location;
            return geolocationResult;
        }

        @Override // com.google.maps.internal.ApiResponse
        public ApiException getError() {
            if (successful()) {
                return null;
            }
            return ApiException.from(this.reason, this.message);
        }
    }
}
