package com.google.maps;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import com.google.maps.model.PriceLevel;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;

/* JADX INFO: loaded from: classes.dex */
public class RadarSearchRequest extends PendingResultBase<PlacesSearchResponse, RadarSearchRequest, Response> {
    static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/place/radarsearch/json").fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

    protected RadarSearchRequest(GeoApiContext geoApiContext) {
        super(geoApiContext, API_CONFIG, Response.class);
    }

    public RadarSearchRequest location(LatLng latLng) {
        return param(SkillsJsonParser.TYPE_LOCATION, latLng);
    }

    public RadarSearchRequest radius(int i) {
        if (i > 50000) {
            throw new IllegalArgumentException("The maximum allowed radius is 50,000 meters.");
        }
        return param("radius", String.valueOf(i));
    }

    public RadarSearchRequest keyword(String str) {
        return param("keyword", str);
    }

    public RadarSearchRequest minPrice(PriceLevel priceLevel) {
        return param("minprice", priceLevel);
    }

    public RadarSearchRequest maxPrice(PriceLevel priceLevel) {
        return param("maxprice", priceLevel);
    }

    public RadarSearchRequest name(String str) {
        return param("name", str);
    }

    public RadarSearchRequest openNow(boolean z) {
        return param("opennow", String.valueOf(z));
    }

    public RadarSearchRequest type(PlaceType placeType) {
        return param(ShareConstants.MEDIA_TYPE, placeType);
    }

    @Override // com.google.maps.PendingResultBase
    protected void validateRequest() {
        if (!params().containsKey("keyword") && !params().containsKey("name") && !params().containsKey(ShareConstants.MEDIA_TYPE)) {
            throw new IllegalArgumentException("Request must contain 'keyword', 'name' or 'type'.");
        }
    }

    public static class Response implements ApiResponse<PlacesSearchResponse> {
        public String errorMessage;
        public String[] htmlAttributions;
        public String nextPageToken;
        public PlacesSearchResult[] results;
        public String status;

        @Override // com.google.maps.internal.ApiResponse
        public boolean successful() {
            return "OK".equals(this.status) || "ZERO_RESULTS".equals(this.status);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.maps.internal.ApiResponse
        public PlacesSearchResponse getResult() {
            PlacesSearchResponse placesSearchResponse = new PlacesSearchResponse();
            placesSearchResponse.htmlAttributions = this.htmlAttributions;
            placesSearchResponse.results = this.results;
            placesSearchResponse.nextPageToken = this.nextPageToken;
            return placesSearchResponse;
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
