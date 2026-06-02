package com.google.maps;

import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.PolylineEncoding;
import com.google.maps.internal.StringJoin;
import com.google.maps.model.ElevationResult;
import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;

/* JADX INFO: loaded from: classes.dex */
public class ElevationApi {
    private static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/elevation/json");

    private ElevationApi() {
    }

    public static PendingResult<ElevationResult[]> getByPoints(GeoApiContext geoApiContext, LatLng... latLngArr) {
        return geoApiContext.get(API_CONFIG, MultiResponse.class, "locations", shortestParam(latLngArr));
    }

    public static PendingResult<ElevationResult[]> getByPath(GeoApiContext geoApiContext, int i, LatLng... latLngArr) {
        return geoApiContext.get(API_CONFIG, MultiResponse.class, "samples", String.valueOf(i), "path", shortestParam(latLngArr));
    }

    public static PendingResult<ElevationResult[]> getByPath(GeoApiContext geoApiContext, int i, EncodedPolyline encodedPolyline) {
        return geoApiContext.get(API_CONFIG, MultiResponse.class, "samples", String.valueOf(i), "path", "enc:" + encodedPolyline.getEncodedPath());
    }

    private static String shortestParam(LatLng[] latLngArr) {
        String strJoin = StringJoin.join('|', (StringJoin.UrlValue[]) latLngArr);
        String str = "enc:" + PolylineEncoding.encode(latLngArr);
        return strJoin.length() < str.length() ? strJoin : str;
    }

    public static PendingResult<ElevationResult> getByPoint(GeoApiContext geoApiContext, LatLng latLng) {
        return geoApiContext.get(API_CONFIG, SingularResponse.class, "locations", latLng.toString());
    }

    private static class SingularResponse implements ApiResponse<ElevationResult> {
        public String errorMessage;
        public ElevationResult[] results;
        public String status;

        private SingularResponse() {
        }

        @Override // com.google.maps.internal.ApiResponse
        public boolean successful() {
            return "OK".equals(this.status);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.maps.internal.ApiResponse
        public ElevationResult getResult() {
            return this.results[0];
        }

        @Override // com.google.maps.internal.ApiResponse
        public ApiException getError() {
            if (successful()) {
                return null;
            }
            return ApiException.from(this.status, this.errorMessage);
        }
    }

    public static PendingResult<ElevationResult[]> getByPoints(GeoApiContext geoApiContext, EncodedPolyline encodedPolyline) {
        return geoApiContext.get(API_CONFIG, MultiResponse.class, "locations", "enc:" + encodedPolyline.getEncodedPath());
    }

    private static class MultiResponse implements ApiResponse<ElevationResult[]> {
        public String errorMessage;
        public ElevationResult[] results;
        public String status;

        private MultiResponse() {
        }

        @Override // com.google.maps.internal.ApiResponse
        public boolean successful() {
            return "OK".equals(this.status);
        }

        @Override // com.google.maps.internal.ApiResponse
        public ElevationResult[] getResult() {
            return this.results;
        }

        @Override // com.google.maps.internal.ApiResponse
        public ApiException getError() {
            if (successful()) {
                return null;
            }
            return ApiException.from(this.status, this.errorMessage);
        }
    }
}
