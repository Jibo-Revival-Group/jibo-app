package com.segment.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.segment.analytics.core.BuildConfig;
import com.segment.analytics.integrations.Logger;
import com.segment.analytics.internal.Utils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public class AnalyticsContext extends ValueMap {
    private static final String APP_BUILD_KEY = "build";
    private static final String APP_KEY = "app";
    private static final String APP_NAMESPACE_KEY = "namespace";
    private static final String APP_NAME_KEY = "name";
    private static final String APP_VERSION_KEY = "version";
    private static final String CAMPAIGN_KEY = "campaign";
    private static final String DEVICE_KEY = "device";
    private static final String LIBRARY_KEY = "library";
    private static final String LIBRARY_NAME_KEY = "name";
    private static final String LIBRARY_VERSION_KEY = "version";
    private static final String LOCALE_KEY = "locale";
    private static final String LOCATION_KEY = "location";
    private static final String NETWORK_BLUETOOTH_KEY = "bluetooth";
    private static final String NETWORK_CARRIER_KEY = "carrier";
    private static final String NETWORK_CELLULAR_KEY = "cellular";
    private static final String NETWORK_KEY = "network";
    private static final String NETWORK_WIFI_KEY = "wifi";
    private static final String OS_KEY = "os";
    private static final String OS_NAME_KEY = "name";
    private static final String OS_VERSION_KEY = "version";
    private static final String REFERRER_KEY = "referrer";
    private static final String SCREEN_DENSITY_KEY = "density";
    private static final String SCREEN_HEIGHT_KEY = "height";
    private static final String SCREEN_KEY = "screen";
    private static final String SCREEN_WIDTH_KEY = "width";
    private static final String TIMEZONE_KEY = "timezone";
    private static final String TRAITS_KEY = "traits";
    private static final String USER_AGENT_KEY = "userAgent";

    static synchronized AnalyticsContext create(Context context, Traits traits, boolean z) {
        AnalyticsContext analyticsContext;
        analyticsContext = new AnalyticsContext(new Utils.NullableConcurrentHashMap());
        analyticsContext.putApp(context);
        analyticsContext.setTraits(traits);
        analyticsContext.putDevice(context, z);
        analyticsContext.putLibrary();
        analyticsContext.put(LOCALE_KEY, (Object) (Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry()));
        analyticsContext.putNetwork(context);
        analyticsContext.putOs();
        analyticsContext.putScreen(context);
        putUndefinedIfNull(analyticsContext, USER_AGENT_KEY, System.getProperty("http.agent"));
        putUndefinedIfNull(analyticsContext, "timezone", TimeZone.getDefault().getID());
        return analyticsContext;
    }

    static void putUndefinedIfNull(Map<String, Object> map, String str, CharSequence charSequence) {
        if (Utils.isNullOrEmpty(charSequence)) {
            map.put(str, "undefined");
        } else {
            map.put(str, charSequence);
        }
    }

    AnalyticsContext(Map<String, Object> map) {
        super(map);
    }

    void attachAdvertisingId(Context context, CountDownLatch countDownLatch, Logger logger) {
        if (Utils.isOnClassPath("com.google.android.gms.ads.identifier.AdvertisingIdClient")) {
            new GetAdvertisingIdTask(this, countDownLatch, logger).execute(context);
        } else {
            logger.debug("Not collecting advertising ID because com.google.android.gms.ads.identifier.AdvertisingIdClient was not found on the classpath.", new Object[0]);
            countDownLatch.countDown();
        }
    }

    @Override // com.segment.analytics.ValueMap
    public AnalyticsContext putValue(String str, Object obj) {
        super.putValue(str, obj);
        return this;
    }

    public AnalyticsContext unmodifiableCopy() {
        return new AnalyticsContext(Collections.unmodifiableMap(new LinkedHashMap(this)));
    }

    void setTraits(Traits traits) {
        put(TRAITS_KEY, (Object) traits.unmodifiableCopy());
    }

    public Traits traits() {
        return (Traits) getValueMap(TRAITS_KEY, Traits.class);
    }

    void putApp(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            Map mapCreateMap = Utils.createMap();
            putUndefinedIfNull(mapCreateMap, "name", packageInfo.applicationInfo.loadLabel(packageManager));
            putUndefinedIfNull(mapCreateMap, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, packageInfo.versionName);
            putUndefinedIfNull(mapCreateMap, APP_NAMESPACE_KEY, packageInfo.packageName);
            mapCreateMap.put(APP_BUILD_KEY, Integer.valueOf(packageInfo.versionCode));
            put(APP_KEY, (Object) mapCreateMap);
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    public AnalyticsContext putCampaign(Campaign campaign) {
        return putValue(CAMPAIGN_KEY, (Object) campaign);
    }

    public Campaign campaign() {
        return (Campaign) getValueMap(CAMPAIGN_KEY, Campaign.class);
    }

    void putDevice(Context context, boolean z) {
        Device device = new Device();
        device.put(ShareConstants.WEB_DIALOG_PARAM_ID, (Object) (z ? Utils.getDeviceId(context) : traits().anonymousId()));
        device.put("manufacturer", (Object) Build.MANUFACTURER);
        device.put("model", (Object) Build.MODEL);
        device.put("name", (Object) Build.DEVICE);
        put(DEVICE_KEY, (Object) device);
    }

    public Device device() {
        return (Device) getValueMap(DEVICE_KEY, Device.class);
    }

    public AnalyticsContext putDeviceToken(String str) {
        device().putDeviceToken(str);
        return this;
    }

    void putLibrary() {
        Map mapCreateMap = Utils.createMap();
        mapCreateMap.put("name", "analytics-android");
        mapCreateMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, BuildConfig.VERSION_NAME);
        put(LIBRARY_KEY, (Object) mapCreateMap);
    }

    public AnalyticsContext putLocation(Location location) {
        return putValue("location", (Object) location);
    }

    public Location location() {
        return (Location) getValueMap("location", Location.class);
    }

    void putNetwork(Context context) {
        ConnectivityManager connectivityManager;
        Map mapCreateMap = Utils.createMap();
        if (Utils.hasPermission(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) Utils.getSystemService(context, "connectivity")) != null) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            mapCreateMap.put(NETWORK_WIFI_KEY, Boolean.valueOf(networkInfo != null && networkInfo.isConnected()));
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(7);
            mapCreateMap.put(NETWORK_BLUETOOTH_KEY, Boolean.valueOf(networkInfo2 != null && networkInfo2.isConnected()));
            NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(0);
            mapCreateMap.put(NETWORK_CELLULAR_KEY, Boolean.valueOf(networkInfo3 != null && networkInfo3.isConnected()));
        }
        TelephonyManager telephonyManager = (TelephonyManager) Utils.getSystemService(context, "phone");
        if (telephonyManager != null) {
            mapCreateMap.put(NETWORK_CARRIER_KEY, telephonyManager.getNetworkOperatorName());
        } else {
            mapCreateMap.put(NETWORK_CARRIER_KEY, "unknown");
        }
        put(NETWORK_KEY, (Object) mapCreateMap);
    }

    void putOs() {
        Map mapCreateMap = Utils.createMap();
        mapCreateMap.put("name", "Android");
        mapCreateMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, Build.VERSION.RELEASE);
        put(OS_KEY, (Object) mapCreateMap);
    }

    public AnalyticsContext putReferrer(Referrer referrer) {
        return putValue(REFERRER_KEY, (Object) referrer);
    }

    void putScreen(Context context) {
        Map mapCreateMap = Utils.createMap();
        Display defaultDisplay = ((WindowManager) Utils.getSystemService(context, "window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        mapCreateMap.put(SCREEN_DENSITY_KEY, Float.valueOf(displayMetrics.density));
        mapCreateMap.put(SCREEN_HEIGHT_KEY, Integer.valueOf(displayMetrics.heightPixels));
        mapCreateMap.put(SCREEN_WIDTH_KEY, Integer.valueOf(displayMetrics.widthPixels));
        put(SCREEN_KEY, (Object) mapCreateMap);
    }

    public static class Campaign extends ValueMap {
        private static final String CAMPAIGN_CONTENT_KEY = "content";
        private static final String CAMPAIGN_MEDIUM_KEY = "medium";
        private static final String CAMPAIGN_NAME_KEY = "name";
        private static final String CAMPAIGN_SOURCE_KEY = "source";
        private static final String CAMPAIGN_TERM_KEY = "term";

        public Campaign() {
        }

        private Campaign(Map<String, Object> map) {
            super(map);
        }

        @Override // com.segment.analytics.ValueMap
        public Campaign putValue(String str, Object obj) {
            super.putValue(str, obj);
            return this;
        }

        public Campaign putName(String str) {
            return putValue("name", (Object) str);
        }

        public String name() {
            return getString("name");
        }

        public Campaign putSource(String str) {
            return putValue("source", (Object) str);
        }

        public String source() {
            return getString("source");
        }

        public Campaign putMedium(String str) {
            return putValue(CAMPAIGN_MEDIUM_KEY, (Object) str);
        }

        public String medium() {
            return getString(CAMPAIGN_MEDIUM_KEY);
        }

        public Campaign putTerm(String str) {
            return putValue(CAMPAIGN_TERM_KEY, (Object) str);
        }

        public String tern() {
            return term();
        }

        public String term() {
            return getString(CAMPAIGN_TERM_KEY);
        }

        public Campaign putContent(String str) {
            return putValue(CAMPAIGN_CONTENT_KEY, (Object) str);
        }

        public String content() {
            return getString(CAMPAIGN_CONTENT_KEY);
        }
    }

    public static class Device extends ValueMap {
        static final String DEVICE_ADVERTISING_ID_KEY = "advertisingId";
        static final String DEVICE_AD_TRACKING_ENABLED_KEY = "adTrackingEnabled";
        static final String DEVICE_ID_KEY = "id";
        static final String DEVICE_MANUFACTURER_KEY = "manufacturer";
        static final String DEVICE_MODEL_KEY = "model";
        static final String DEVICE_NAME_KEY = "name";
        static final String DEVICE_TOKEN_KEY = "token";

        Device() {
        }

        private Device(Map<String, Object> map) {
            super(map);
        }

        @Override // com.segment.analytics.ValueMap
        public Device putValue(String str, Object obj) {
            super.putValue(str, obj);
            return this;
        }

        void putAdvertisingInfo(String str, boolean z) {
            if (z && !Utils.isNullOrEmpty(str)) {
                put(DEVICE_ADVERTISING_ID_KEY, (Object) str);
            }
            put(DEVICE_AD_TRACKING_ENABLED_KEY, (Object) Boolean.valueOf(z));
        }

        public Device putDeviceToken(String str) {
            return putValue(DEVICE_TOKEN_KEY, (Object) str);
        }
    }

    public static class Location extends ValueMap {
        private static final String LOCATION_LATITUDE_KEY = "latitude";
        private static final String LOCATION_LONGITUDE_KEY = "longitude";
        private static final String LOCATION_SPEED_KEY = "speed";

        public Location() {
        }

        private Location(Map<String, Object> map) {
            super(map);
        }

        @Override // com.segment.analytics.ValueMap
        public Location putValue(String str, Object obj) {
            super.putValue(str, obj);
            return this;
        }

        public Location putLatitude(double d) {
            return putValue(LOCATION_LATITUDE_KEY, (Object) Double.valueOf(d));
        }

        public double latitude() {
            return getDouble(LOCATION_LATITUDE_KEY, 0.0d);
        }

        public Location putLongitude(double d) {
            return putValue(LOCATION_LONGITUDE_KEY, (Object) Double.valueOf(d));
        }

        public double longitude() {
            return getDouble(LOCATION_LONGITUDE_KEY, 0.0d);
        }

        public Location putSpeed(double d) {
            return putValue(LOCATION_SPEED_KEY, (Object) Double.valueOf(d));
        }

        public double speed() {
            return getDouble(LOCATION_SPEED_KEY, 0.0d);
        }
    }

    public static class Referrer extends ValueMap {
        private static final String REFERRER_ID_KEY = "id";
        private static final String REFERRER_LINK_KEY = "link";
        private static final String REFERRER_NAME_KEY = "name";
        private static final String REFERRER_TYPE_KEY = "type";
        private static final String REFERRER_URL_KEY = "url";

        public Referrer() {
        }

        public Referrer(Map<String, Object> map) {
            super(map);
        }

        @Override // com.segment.analytics.ValueMap
        public Referrer putValue(String str, Object obj) {
            super.putValue(str, obj);
            return this;
        }

        public Referrer putId(String str) {
            return putValue("id", (Object) str);
        }

        /* JADX INFO: renamed from: id */
        public String m15024id() {
            return getString("id");
        }

        public Referrer putLink(String str) {
            return putValue("link", (Object) str);
        }

        public String link() {
            return getString("link");
        }

        public Referrer putName(String str) {
            return putValue("name", (Object) str);
        }

        public String name() {
            return getString("name");
        }

        public Referrer putType(String str) {
            return putValue("type", (Object) str);
        }

        public String type() {
            return getString("type");
        }

        public Referrer putTerm(String str) {
            return putValue("url", (Object) str);
        }

        public Referrer putUrl(String str) {
            return putValue("url", (Object) str);
        }

        public String url() {
            return getString("url");
        }
    }
}
