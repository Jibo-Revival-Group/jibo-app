package com.google.maps;

import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiError;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.StringJoin;
import com.google.maps.model.LatLng;
import com.google.maps.model.SnappedPoint;
import com.google.maps.model.SnappedSpeedLimitResponse;
import com.google.maps.model.SpeedLimit;

/* JADX INFO: loaded from: classes.dex */
public class RoadsApi {
    static final String API_BASE_URL = "https://roads.googleapis.com";
    static final ApiConfig SNAP_TO_ROADS_API_CONFIG = new ApiConfig("/v1/snapToRoads").hostName(API_BASE_URL).supportsClientId(false).fieldNamingPolicy(FieldNamingPolicy.IDENTITY);
    static final ApiConfig SPEEDS_API_CONFIG = new ApiConfig("/v1/speedLimits").hostName(API_BASE_URL).supportsClientId(false).fieldNamingPolicy(FieldNamingPolicy.IDENTITY);
    static final ApiConfig NEAREST_ROADS_API_CONFIG = new ApiConfig("/v1/nearestRoads").hostName(API_BASE_URL).supportsClientId(false).fieldNamingPolicy(FieldNamingPolicy.IDENTITY);

    private RoadsApi() {
    }

    public static PendingResult<SnappedPoint[]> snapToRoads(GeoApiContext geoApiContext, LatLng... latLngArr) {
        return geoApiContext.get(SNAP_TO_ROADS_API_CONFIG, RoadsResponse.class, "path", StringJoin.join('|', (StringJoin.UrlValue[]) latLngArr));
    }

    public static PendingResult<SnappedPoint[]> snapToRoads(GeoApiContext geoApiContext, boolean z, LatLng... latLngArr) {
        return geoApiContext.get(SNAP_TO_ROADS_API_CONFIG, RoadsResponse.class, "path", StringJoin.join('|', (StringJoin.UrlValue[]) latLngArr), "interpolate", String.valueOf(z));
    }

    public static PendingResult<SpeedLimit[]> speedLimits(GeoApiContext geoApiContext, LatLng... latLngArr) {
        return geoApiContext.get(SPEEDS_API_CONFIG, SpeedsResponse.class, "path", StringJoin.join('|', (StringJoin.UrlValue[]) latLngArr));
    }

    public static PendingResult<SpeedLimit[]> speedLimits(GeoApiContext geoApiContext, String... strArr) {
        String[] strArr2 = new String[strArr.length * 2];
        int i = 0;
        for (String str : strArr) {
            int i2 = i + 1;
            strArr2[i] = "placeId";
            i = i2 + 1;
            strArr2[i2] = str;
        }
        return geoApiContext.get(SPEEDS_API_CONFIG, SpeedsResponse.class, strArr2);
    }

    public static PendingResult<SnappedSpeedLimitResponse> snappedSpeedLimits(GeoApiContext geoApiContext, LatLng... latLngArr) {
        return geoApiContext.get(SPEEDS_API_CONFIG, CombinedResponse.class, "path", StringJoin.join('|', (StringJoin.UrlValue[]) latLngArr));
    }

    public static PendingResult<SnappedPoint[]> nearestRoads(GeoApiContext geoApiContext, LatLng... latLngArr) {
        return geoApiContext.get(NEAREST_ROADS_API_CONFIG, RoadsResponse.class, "points", StringJoin.join('|', (StringJoin.UrlValue[]) latLngArr));
    }

    private static class RoadsResponse implements ApiResponse<SnappedPoint[]> {
        private ApiError error;
        private SnappedPoint[] snappedPoints;

        private RoadsResponse() {
        }

        @Override // com.google.maps.internal.ApiResponse
        public boolean successful() {
            return this.error == null;
        }

        @Override // com.google.maps.internal.ApiResponse
        public SnappedPoint[] getResult() {
            return this.snappedPoints;
        }

        @Override // com.google.maps.internal.ApiResponse
        public ApiException getError() {
            return ApiException.from(this.error.status, this.error.message);
        }
    }

    private static class SpeedsResponse implements ApiResponse<SpeedLimit[]> {
        private ApiError error;
        private SpeedLimit[] speedLimits;

        private SpeedsResponse() {
        }

        @Override // com.google.maps.internal.ApiResponse
        public boolean successful() {
            return this.error == null;
        }

        @Override // com.google.maps.internal.ApiResponse
        public SpeedLimit[] getResult() {
            return this.speedLimits;
        }

        @Override // com.google.maps.internal.ApiResponse
        public ApiException getError() {
            return ApiException.from(this.error.status, this.error.message);
        }
    }

    private static class CombinedResponse implements ApiResponse<SnappedSpeedLimitResponse> {
        private ApiError error;
        private SnappedPoint[] snappedPoints;
        private SpeedLimit[] speedLimits;

        private CombinedResponse() {
        }

        @Override // com.google.maps.internal.ApiResponse
        public boolean successful() {
            return this.error == null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.maps.internal.ApiResponse
        public SnappedSpeedLimitResponse getResult() {
            SnappedSpeedLimitResponse snappedSpeedLimitResponse = new SnappedSpeedLimitResponse();
            snappedSpeedLimitResponse.snappedPoints = this.snappedPoints;
            snappedSpeedLimitResponse.speedLimits = this.speedLimits;
            return snappedSpeedLimitResponse;
        }

        @Override // com.google.maps.internal.ApiResponse
        public ApiException getError() {
            return ApiException.from(this.error.status, this.error.message);
        }
    }
}
