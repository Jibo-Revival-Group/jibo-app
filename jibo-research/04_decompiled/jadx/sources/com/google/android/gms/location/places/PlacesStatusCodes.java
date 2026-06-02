package com.google.android.gms.location.places;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public class PlacesStatusCodes extends CommonStatusCodes {
    /* JADX INFO: renamed from: b */
    public static String m8773b(int i) {
        switch (i) {
            case 9000:
                return "PLACES_API_QUOTA_FAILED";
            case 9001:
                return "PLACES_API_USAGE_LIMIT_EXCEEDED";
            case 9002:
                return "PLACES_API_KEY_INVALID";
            case 9003:
                return "PLACES_API_ACCESS_NOT_CONFIGURED";
            case 9004:
                return "PLACES_API_INVALID_ARGUMENT";
            case 9005:
                return "PLACES_API_RATE_LIMIT_EXCEEDED";
            case 9006:
                return "PLACES_API_DEVICE_RATE_LIMIT_EXCEEDED";
            case 9007:
                return "PLACES_API_KEY_EXPIRED";
            case 9008:
                return "PLACES_API_INVALID_APP";
            case 9051:
                return "PLACE_ALIAS_NOT_FOUND";
            case 9101:
                return "PLACE_PROXIMITY_UNKNOWN";
            case 9102:
                return "NEARBY_ALERTS_NOT_AVAILABLE";
            case 9150:
                return "PLACEFENCING_NOT_AVAILABLE";
            case 9201:
                return "PLACES_API_PERSONALIZED_DATA_ACCESS_APPROVED";
            case 9202:
                return "PLACES_API_PERSONALIZED_DATA_ACCESS_REJECTED";
            default:
                return CommonStatusCodes.m6870a(i);
        }
    }

    /* JADX INFO: renamed from: c */
    public static Status m8774c(int i) {
        String strM8773b = m8773b(i);
        zzbq.m7373a(strM8773b);
        return new Status(i, strM8773b);
    }
}
