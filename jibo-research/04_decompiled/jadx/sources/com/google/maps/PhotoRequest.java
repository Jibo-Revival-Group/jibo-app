package com.google.maps;

import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.PhotoResult;

/* JADX INFO: loaded from: classes.dex */
public class PhotoRequest extends PendingResultBase<PhotoResult, PhotoRequest, Response> {
    static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/place/photo");

    public PhotoRequest(GeoApiContext geoApiContext) {
        super(geoApiContext, API_CONFIG, Response.class);
    }

    @Override // com.google.maps.PendingResultBase
    protected void validateRequest() {
        if (!params().containsKey("photoreference")) {
            throw new IllegalArgumentException("Request must contain 'photoReference'.");
        }
        if (!params().containsKey("maxheight") && !params().containsKey("maxwidth")) {
            throw new IllegalArgumentException("Request must contain 'maxHeight' or 'maxWidth'.");
        }
    }

    public PhotoRequest photoReference(String str) {
        return param("photoreference", str);
    }

    public PhotoRequest maxHeight(int i) {
        return param("maxheight", String.valueOf(i));
    }

    public PhotoRequest maxWidth(int i) {
        return param("maxwidth", String.valueOf(i));
    }

    public static class Response implements ApiResponse<PhotoResult> {
        private Response() {
        }

        @Override // com.google.maps.internal.ApiResponse
        public boolean successful() {
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.maps.internal.ApiResponse
        public PhotoResult getResult() {
            return null;
        }

        @Override // com.google.maps.internal.ApiResponse
        public ApiException getError() {
            return null;
        }
    }
}
