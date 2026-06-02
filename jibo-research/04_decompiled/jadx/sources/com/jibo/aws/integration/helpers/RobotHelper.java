package com.jibo.aws.integration.helpers;

import android.location.Location;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.util.DateTimeUtils;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class RobotHelper {
    public static final String FIELD_ADDRESS_LINE = "addressLine";
    public static final String FIELD_AVATAR = "avatar";
    public static final String FIELD_CITY = "city";
    public static final String FIELD_CONNECTED_AT = "connectedAt";
    public static final String FIELD_COUNTRY = "country";
    public static final String FIELD_COUNTRY_CODE = "countryCode";
    public static final String FIELD_LATITUDE = "lat";
    public static final String FIELD_LOCATION_OVERRIDE_OBJECT = "locationOverride";
    public static final String FIELD_LONGITUDE = "lng";
    public static final String FIELD_PLATFORM = "platform";
    public static final String FIELD_REMOTE_ENABLED = "remoteEnabled";
    public static final String FIELD_SERIAL_NUMBER = "serialNumber";
    public static final String FIELD_SSID = "SSID";
    public static final String FIELD_STATE = "state";
    public static final String FIELD_STATE_ABBR = "stateAbbr";
    public static final String FIELD_TIMEZONE = "timezone";
    public static final String FIELD_ZIPCODE = "zipcode";

    public static String getAddressLine(Robot robot) {
        if (robot == null || !robot.getPayload().m9406b(FIELD_LOCATION_OVERRIDE_OBJECT)) {
            return null;
        }
        try {
            JsonObject jsonObjectM9409e = robot.getPayload().m9409e(FIELD_LOCATION_OVERRIDE_OBJECT);
            if (jsonObjectM9409e == null || !jsonObjectM9409e.m9406b(FIELD_ADDRESS_LINE)) {
                return null;
            }
            return jsonObjectM9409e.m9407c(FIELD_ADDRESS_LINE).mo9385c();
        } catch (Exception e) {
            return null;
        }
    }

    public static int getAvatar(Robot robot) {
        if (robot == null || !robot.getPayload().m9406b(FIELD_AVATAR)) {
            return 0;
        }
        try {
            return robot.getPayload().m9407c(FIELD_AVATAR).mo9388f();
        } catch (Exception e) {
            return 0;
        }
    }

    public static String getCountryCode(Robot robot) {
        if (robot == null || !robot.getPayload().m9406b(FIELD_LOCATION_OVERRIDE_OBJECT)) {
            return null;
        }
        try {
            JsonObject jsonObjectM9409e = robot.getPayload().m9409e(FIELD_LOCATION_OVERRIDE_OBJECT);
            if (jsonObjectM9409e == null || !jsonObjectM9409e.m9406b(FIELD_COUNTRY_CODE)) {
                return null;
            }
            return jsonObjectM9409e.m9407c(FIELD_COUNTRY_CODE).mo9385c();
        } catch (Exception e) {
            return null;
        }
    }

    public static Location getLatLon(Robot robot) {
        if (robot != null && robot.getPayload().m9406b(FIELD_LOCATION_OVERRIDE_OBJECT)) {
            Location location = new Location("JIBO_LOCATION");
            try {
                JsonObject jsonObjectM9409e = robot.getPayload().m9409e(FIELD_LOCATION_OVERRIDE_OBJECT);
                if (jsonObjectM9409e != null && jsonObjectM9409e.m9406b(FIELD_LATITUDE)) {
                    location.setLatitude(jsonObjectM9409e.m9407c(FIELD_LATITUDE).mo9386d());
                }
                if (jsonObjectM9409e == null || !jsonObjectM9409e.m9406b(FIELD_LONGITUDE)) {
                    return location;
                }
                location.setLongitude(jsonObjectM9409e.m9407c(FIELD_LONGITUDE).mo9386d());
                return location;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static String getLocation(Robot robot) {
        if (robot == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        JsonObject jsonObjectM9409e = null;
        if (robot.getPayload().m9406b(FIELD_LOCATION_OVERRIDE_OBJECT)) {
            try {
                jsonObjectM9409e = robot.getPayload().m9409e(FIELD_LOCATION_OVERRIDE_OBJECT);
            } catch (Exception e) {
                return sb.toString();
            }
        }
        if (jsonObjectM9409e == null) {
            return sb.toString();
        }
        if (jsonObjectM9409e.m9406b(FIELD_CITY)) {
            sb.append(jsonObjectM9409e.m9407c(FIELD_CITY).mo9385c());
        }
        if (jsonObjectM9409e.m9406b("state")) {
            sb.append(", ").append(jsonObjectM9409e.m9407c("state").mo9385c());
        }
        if (jsonObjectM9409e.m9406b(FIELD_COUNTRY)) {
            sb.append(", ").append(jsonObjectM9409e.m9407c(FIELD_COUNTRY).mo9385c());
        }
        return sb.toString();
    }

    public static String getRobotOS(Robot robot) {
        if (robot == null) {
            return "";
        }
        if (robot.getPayload().m9406b(FIELD_PLATFORM)) {
            return robot.getPayload().m9407c(FIELD_PLATFORM).mo9385c();
        }
        return null;
    }

    public static String getRobotSerialName(Robot robot) {
        if (robot == null) {
            return "";
        }
        if (robot.getPayload().m9406b(FIELD_SERIAL_NUMBER)) {
            return robot.getPayload().m9407c(FIELD_SERIAL_NUMBER).mo9385c();
        }
        return null;
    }

    public static String getTimeZone(Robot robot) {
        if (robot == null) {
            return "";
        }
        if (robot.getPayload().m9406b(FIELD_TIMEZONE)) {
            return robot.getPayload().m9407c(FIELD_TIMEZONE).mo9385c();
        }
        return null;
    }

    public static String getTimeZoneFriendly(String str, String str2) {
        TimeZone timeZone = TextUtils.isEmpty(str) ? null : TimeZone.getTimeZone(str);
        StringBuilder sb = new StringBuilder();
        if (timeZone != null) {
            sb.append(timeZone.getDisplayName()).append(" (GMT ").append(DateTimeUtils.getHourOffset(timeZone.getRawOffset())).append(")");
        } else {
            sb.append(str2);
        }
        return sb.toString();
    }

    public static String getWifiName(Robot robot) {
        return (robot != null && robot.getPayload().m9406b(FIELD_SSID)) ? robot.getPayload().m9407c(FIELD_SSID).mo9385c() : "";
    }

    public static String getZipcode(Robot robot) {
        if (robot == null || !robot.getPayload().m9406b(FIELD_LOCATION_OVERRIDE_OBJECT)) {
            return null;
        }
        try {
            JsonObject jsonObjectM9409e = robot.getPayload().m9409e(FIELD_LOCATION_OVERRIDE_OBJECT);
            if (jsonObjectM9409e == null || !jsonObjectM9409e.m9406b(FIELD_ZIPCODE)) {
                return null;
            }
            return jsonObjectM9409e.m9407c(FIELD_ZIPCODE).mo9385c();
        } catch (Exception e) {
            return null;
        }
    }
}
