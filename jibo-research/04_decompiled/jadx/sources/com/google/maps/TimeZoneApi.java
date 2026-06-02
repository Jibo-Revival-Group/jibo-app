package com.google.maps;

import com.facebook.appevents.AppEventsConstants;
import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.LatLng;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class TimeZoneApi {
    private static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/timezone/json").fieldNamingPolicy(FieldNamingPolicy.IDENTITY);

    private TimeZoneApi() {
    }

    public static PendingResult<TimeZone> getTimeZone(GeoApiContext geoApiContext, LatLng latLng) {
        return geoApiContext.get(API_CONFIG, Response.class, SkillsJsonParser.TYPE_LOCATION, latLng.toString(), "timestamp", AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    private static class Response implements ApiResponse<TimeZone> {
        public String errorMessage;
        public String status;
        private String timeZoneId;

        private Response() {
        }

        @Override // com.google.maps.internal.ApiResponse
        public boolean successful() {
            return "OK".equals(this.status);
        }

        @Override // com.google.maps.internal.ApiResponse
        public TimeZone getResult() {
            if (this.timeZoneId == null) {
                return null;
            }
            return TimeZone.getTimeZone(this.timeZoneId);
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
