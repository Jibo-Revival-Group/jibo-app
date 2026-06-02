package com.google.maps;

import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.StringJoin;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.GeocodedWaypoint;

/* JADX INFO: loaded from: classes.dex */
public class DirectionsApi {
    static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/directions/json");

    private DirectionsApi() {
    }

    public static DirectionsApiRequest newRequest(GeoApiContext geoApiContext) {
        return new DirectionsApiRequest(geoApiContext);
    }

    public static DirectionsApiRequest getDirections(GeoApiContext geoApiContext, String str, String str2) {
        return new DirectionsApiRequest(geoApiContext).origin(str).destination(str2);
    }

    static class Response implements ApiResponse<DirectionsResult> {
        public String errorMessage;
        public GeocodedWaypoint[] geocodedWaypoints;
        public DirectionsRoute[] routes;
        public String status;

        Response() {
        }

        @Override // com.google.maps.internal.ApiResponse
        public boolean successful() {
            return "OK".equals(this.status) || "ZERO_RESULTS".equals(this.status);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.maps.internal.ApiResponse
        public DirectionsResult getResult() {
            DirectionsResult directionsResult = new DirectionsResult();
            directionsResult.geocodedWaypoints = this.geocodedWaypoints;
            directionsResult.routes = this.routes;
            return directionsResult;
        }

        @Override // com.google.maps.internal.ApiResponse
        public ApiException getError() {
            if (successful()) {
                return null;
            }
            return ApiException.from(this.status, this.errorMessage);
        }
    }

    public enum RouteRestriction implements StringJoin.UrlValue {
        TOLLS("tolls"),
        HIGHWAYS("highways"),
        FERRIES("ferries");

        private final String restriction;

        RouteRestriction(String str) {
            this.restriction = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.restriction;
        }

        @Override // com.google.maps.internal.StringJoin.UrlValue
        public String toUrlValue() {
            return this.restriction;
        }
    }
}
