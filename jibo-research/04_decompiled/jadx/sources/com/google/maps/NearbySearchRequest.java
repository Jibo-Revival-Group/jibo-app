package com.google.maps;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.StringJoin;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import com.google.maps.model.PriceLevel;
import com.google.maps.model.RankBy;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;

/* JADX INFO: loaded from: classes.dex */
public class NearbySearchRequest extends PendingResultBase<PlacesSearchResponse, NearbySearchRequest, Response> {
    static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/place/nearbysearch/json").fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

    public NearbySearchRequest(GeoApiContext geoApiContext) {
        super(geoApiContext, API_CONFIG, Response.class);
    }

    public NearbySearchRequest location(LatLng latLng) {
        return param(SkillsJsonParser.TYPE_LOCATION, latLng);
    }

    public NearbySearchRequest radius(int i) {
        if (i > 50000) {
            throw new IllegalArgumentException("The maximum allowed radius is 50,000 meters.");
        }
        return param("radius", String.valueOf(i));
    }

    public NearbySearchRequest rankby(RankBy rankBy) {
        return param("rankby", rankBy);
    }

    public NearbySearchRequest keyword(String str) {
        return param("keyword", str);
    }

    public NearbySearchRequest minPrice(PriceLevel priceLevel) {
        return param("minprice", priceLevel);
    }

    public NearbySearchRequest maxPrice(PriceLevel priceLevel) {
        return param("maxprice", priceLevel);
    }

    public NearbySearchRequest name(String str) {
        return param("name", str);
    }

    public NearbySearchRequest openNow(boolean z) {
        return param("opennow", String.valueOf(z));
    }

    public NearbySearchRequest pageToken(String str) {
        return param("pagetoken", str);
    }

    public NearbySearchRequest type(PlaceType placeType) {
        return param(ShareConstants.MEDIA_TYPE, placeType);
    }

    public NearbySearchRequest type(PlaceType... placeTypeArr) {
        return param(ShareConstants.MEDIA_TYPE, StringJoin.join('|', (StringJoin.UrlValue[]) placeTypeArr));
    }

    @Override // com.google.maps.PendingResultBase
    protected void validateRequest() {
        if (!params().containsKey("pagetoken")) {
            if (params().containsKey("rankby") && params().get("rankby").equals(RankBy.DISTANCE.toString()) && params().containsKey("radius")) {
                throw new IllegalArgumentException("Request must not contain radius with rankby=distance");
            }
            if (params().containsKey("rankby") && params().get("rankby").equals(RankBy.DISTANCE.toString()) && !params().containsKey("keyword") && !params().containsKey("name") && !params().containsKey(ShareConstants.MEDIA_TYPE)) {
                throw new IllegalArgumentException("With rankby=distance is specified, then one or more of keyword, name, or type is required");
            }
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
