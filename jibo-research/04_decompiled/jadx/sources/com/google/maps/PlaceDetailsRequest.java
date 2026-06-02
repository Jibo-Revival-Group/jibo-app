package com.google.maps;

import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.PlaceDetails;

/* JADX INFO: loaded from: classes.dex */
public class PlaceDetailsRequest extends PendingResultBase<PlaceDetails, PlaceDetailsRequest, Response> {
    static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/place/details/json").fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

    public PlaceDetailsRequest(GeoApiContext geoApiContext) {
        super(geoApiContext, API_CONFIG, Response.class);
    }

    public PlaceDetailsRequest placeId(String str) {
        return param("placeid", str);
    }

    @Override // com.google.maps.PendingResultBase
    protected void validateRequest() {
        if (!params().containsKey("placeid")) {
            throw new IllegalArgumentException("Request must contain 'placeId'.");
        }
    }

    public static class Response implements ApiResponse<PlaceDetails> {
        public String errorMessage;
        public String[] htmlAttributions;
        public PlaceDetails result;
        public String status;

        @Override // com.google.maps.internal.ApiResponse
        public boolean successful() {
            return "OK".equals(this.status) || "ZERO_RESULTS".equals(this.status);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.maps.internal.ApiResponse
        public PlaceDetails getResult() {
            if (this.result != null) {
                this.result.htmlAttributions = this.htmlAttributions;
            }
            return this.result;
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
