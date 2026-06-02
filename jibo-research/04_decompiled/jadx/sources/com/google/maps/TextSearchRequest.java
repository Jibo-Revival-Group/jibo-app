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
import com.google.maps.model.RankBy;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;

/* JADX INFO: loaded from: classes.dex */
public class TextSearchRequest extends PendingResultBase<PlacesSearchResponse, TextSearchRequest, Response> {
    static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/place/textsearch/json").fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

    public TextSearchRequest(GeoApiContext geoApiContext) {
        super(geoApiContext, API_CONFIG, Response.class);
    }

    public TextSearchRequest query(String str) {
        return param("query", str);
    }

    public TextSearchRequest location(LatLng latLng) {
        return param(SkillsJsonParser.TYPE_LOCATION, latLng);
    }

    public TextSearchRequest radius(int i) {
        if (i > 50000) {
            throw new IllegalArgumentException("The maximum allowed radius is 50,000 meters.");
        }
        return param("radius", String.valueOf(i));
    }

    public TextSearchRequest minPrice(PriceLevel priceLevel) {
        return param("minprice", priceLevel);
    }

    public TextSearchRequest maxPrice(PriceLevel priceLevel) {
        return param("maxprice", priceLevel);
    }

    public TextSearchRequest name(String str) {
        return param("name", str);
    }

    public TextSearchRequest openNow(boolean z) {
        return param("opennow", String.valueOf(z));
    }

    public TextSearchRequest pageToken(String str) {
        return param("pagetoken", str);
    }

    public TextSearchRequest rankby(RankBy rankBy) {
        return param("rankby", rankBy);
    }

    public TextSearchRequest type(PlaceType placeType) {
        return param(ShareConstants.MEDIA_TYPE, placeType);
    }

    @Override // com.google.maps.PendingResultBase
    protected void validateRequest() {
        if (!params().containsKey("pagetoken")) {
            if (!params().containsKey("query")) {
                throw new IllegalArgumentException("Request must contain 'query' or a 'pageToken'.");
            }
            if (params().containsKey(SkillsJsonParser.TYPE_LOCATION) && !params().containsKey("radius")) {
                throw new IllegalArgumentException("Request must contain 'radius' parameter when it contains a 'location' parameter.");
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
