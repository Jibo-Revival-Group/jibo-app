package com.google.maps;

import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.StringJoin;
import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.ComponentFilter;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceAutocompleteType;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;

/* JADX INFO: loaded from: classes.dex */
public class PlaceAutocompleteRequest extends PendingResultBase<AutocompletePrediction[], PlaceAutocompleteRequest, Response> {
    static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/place/autocomplete/json").fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

    protected PlaceAutocompleteRequest(GeoApiContext geoApiContext) {
        super(geoApiContext, API_CONFIG, Response.class);
    }

    public PlaceAutocompleteRequest input(String str) {
        return param("input", str);
    }

    public PlaceAutocompleteRequest offset(int i) {
        return param("offset", String.valueOf(i));
    }

    public PlaceAutocompleteRequest location(LatLng latLng) {
        return param(SkillsJsonParser.TYPE_LOCATION, latLng);
    }

    public PlaceAutocompleteRequest radius(int i) {
        return param("radius", String.valueOf(i));
    }

    public PlaceAutocompleteRequest type(PlaceAutocompleteType placeAutocompleteType) {
        return param("types", placeAutocompleteType);
    }

    public PlaceAutocompleteRequest components(ComponentFilter... componentFilterArr) {
        return param("components", StringJoin.join('|', (StringJoin.UrlValue[]) componentFilterArr));
    }

    @Override // com.google.maps.PendingResultBase
    protected void validateRequest() {
        if (!params().containsKey("input")) {
            throw new IllegalArgumentException("Request must contain 'input'.");
        }
    }

    public static class Response implements ApiResponse<AutocompletePrediction[]> {
        public String errorMessage;
        public AutocompletePrediction[] predictions;
        public String status;

        @Override // com.google.maps.internal.ApiResponse
        public boolean successful() {
            return "OK".equals(this.status) || "ZERO_RESULTS".equals(this.status);
        }

        @Override // com.google.maps.internal.ApiResponse
        public AutocompletePrediction[] getResult() {
            return this.predictions;
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
