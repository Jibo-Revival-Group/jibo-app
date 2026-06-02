package com.segment.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.segment.analytics.integrations.Logger;
import com.segment.analytics.internal.Utils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;

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

   AnalyticsContext(Map<String, Object> var1) {
      super(var1);
   }

   static AnalyticsContext create(Context var0, Traits var1, boolean var2) {
      AnalyticsContext var3;
      synchronized (AnalyticsContext.class) {
         Utils.NullableConcurrentHashMap var4 = new Utils.NullableConcurrentHashMap();
         var3 = new AnalyticsContext(var4);
         var3.putApp(var0);
         var3.setTraits(var1);
         var3.putDevice(var0, var2);
         var3.putLibrary();
         StringBuilder var7 = new StringBuilder();
         var3.put("locale", var7.append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry()).toString());
         var3.putNetwork(var0);
         var3.putOs();
         var3.putScreen(var0);
         putUndefinedIfNull(var3, "userAgent", System.getProperty("http.agent"));
         putUndefinedIfNull(var3, "timezone", TimeZone.getDefault().getID());
      }

      return var3;
   }

   static void putUndefinedIfNull(Map<String, Object> var0, String var1, CharSequence var2) {
      if (Utils.isNullOrEmpty(var2)) {
         var0.put(var1, "undefined");
      } else {
         var0.put(var1, var2);
      }
   }

   void attachAdvertisingId(Context var1, CountDownLatch var2, Logger var3) {
      if (Utils.isOnClassPath("com.google.android.gms.ads.identifier.AdvertisingIdClient")) {
         new GetAdvertisingIdTask(this, var2, var3).execute(new Context[]{var1});
      } else {
         var3.debug("Not collecting advertising ID because com.google.android.gms.ads.identifier.AdvertisingIdClient was not found on the classpath.");
         var2.countDown();
      }
   }

   public AnalyticsContext.Campaign campaign() {
      return this.getValueMap("campaign", AnalyticsContext.Campaign.class);
   }

   public AnalyticsContext.Device device() {
      return this.getValueMap("device", AnalyticsContext.Device.class);
   }

   public AnalyticsContext.Location location() {
      return this.getValueMap("location", AnalyticsContext.Location.class);
   }

   void putApp(Context var1) {
      try {
         PackageManager var2 = var1.getPackageManager();
         PackageInfo var3 = var2.getPackageInfo(var1.getPackageName(), 0);
         Map var5 = Utils.createMap();
         putUndefinedIfNull(var5, "name", var3.applicationInfo.loadLabel(var2));
         putUndefinedIfNull(var5, "version", var3.versionName);
         putUndefinedIfNull(var5, "namespace", var3.packageName);
         var5.put("build", var3.versionCode);
         this.put("app", var5);
      } catch (NameNotFoundException var4) {
      }
   }

   public AnalyticsContext putCampaign(AnalyticsContext.Campaign var1) {
      return this.putValue("campaign", var1);
   }

   void putDevice(Context var1, boolean var2) {
      AnalyticsContext.Device var3 = new AnalyticsContext.Device();
      String var4;
      if (var2) {
         var4 = Utils.getDeviceId(var1);
      } else {
         var4 = this.traits().anonymousId();
      }

      var3.put("id", var4);
      var3.put("manufacturer", Build.MANUFACTURER);
      var3.put("model", Build.MODEL);
      var3.put("name", Build.DEVICE);
      this.put("device", var3);
   }

   public AnalyticsContext putDeviceToken(String var1) {
      this.device().putDeviceToken(var1);
      return this;
   }

   void putLibrary() {
      Map var1 = Utils.createMap();
      var1.put("name", "analytics-android");
      var1.put("version", "4.3.1");
      this.put("library", var1);
   }

   public AnalyticsContext putLocation(AnalyticsContext.Location var1) {
      return this.putValue("location", var1);
   }

   void putNetwork(Context var1) {
      boolean var3 = true;
      Map var4 = Utils.createMap();
      if (Utils.hasPermission(var1, "android.permission.ACCESS_NETWORK_STATE")) {
         ConnectivityManager var5 = Utils.getSystemService(var1, "connectivity");
         if (var5 != null) {
            NetworkInfo var6 = var5.getNetworkInfo(1);
            boolean var2;
            if (var6 != null && var6.isConnected()) {
               var2 = true;
            } else {
               var2 = false;
            }

            var4.put("wifi", var2);
            var6 = var5.getNetworkInfo(7);
            if (var6 != null && var6.isConnected()) {
               var2 = true;
            } else {
               var2 = false;
            }

            var4.put("bluetooth", var2);
            NetworkInfo var10 = var5.getNetworkInfo(0);
            if (var10 != null && var10.isConnected()) {
               var2 = var3;
            } else {
               var2 = false;
            }

            var4.put("cellular", var2);
         }
      }

      TelephonyManager var7 = Utils.getSystemService(var1, "phone");
      if (var7 != null) {
         var4.put("carrier", var7.getNetworkOperatorName());
      } else {
         var4.put("carrier", "unknown");
      }

      this.put("network", var4);
   }

   void putOs() {
      Map var1 = Utils.createMap();
      var1.put("name", "Android");
      var1.put("version", VERSION.RELEASE);
      this.put("os", var1);
   }

   public AnalyticsContext putReferrer(AnalyticsContext.Referrer var1) {
      return this.putValue("referrer", var1);
   }

   void putScreen(Context var1) {
      Map var2 = Utils.createMap();
      Display var3 = Utils.<WindowManager>getSystemService(var1, "window").getDefaultDisplay();
      DisplayMetrics var4 = new DisplayMetrics();
      var3.getMetrics(var4);
      var2.put("density", var4.density);
      var2.put("height", var4.heightPixels);
      var2.put("width", var4.widthPixels);
      this.put("screen", var2);
   }

   public AnalyticsContext putValue(String var1, Object var2) {
      super.putValue(var1, var2);
      return this;
   }

   void setTraits(Traits var1) {
      this.put("traits", var1.unmodifiableCopy());
   }

   public Traits traits() {
      return this.getValueMap("traits", Traits.class);
   }

   public AnalyticsContext unmodifiableCopy() {
      return new AnalyticsContext(Collections.unmodifiableMap(new LinkedHashMap<>(this)));
   }

   public static class Campaign extends ValueMap {
      private static final String CAMPAIGN_CONTENT_KEY = "content";
      private static final String CAMPAIGN_MEDIUM_KEY = "medium";
      private static final String CAMPAIGN_NAME_KEY = "name";
      private static final String CAMPAIGN_SOURCE_KEY = "source";
      private static final String CAMPAIGN_TERM_KEY = "term";

      public Campaign() {
      }

      private Campaign(Map<String, Object> var1) {
         super(var1);
      }

      public String content() {
         return this.getString("content");
      }

      public String medium() {
         return this.getString("medium");
      }

      public String name() {
         return this.getString("name");
      }

      public AnalyticsContext.Campaign putContent(String var1) {
         return this.putValue("content", var1);
      }

      public AnalyticsContext.Campaign putMedium(String var1) {
         return this.putValue("medium", var1);
      }

      public AnalyticsContext.Campaign putName(String var1) {
         return this.putValue("name", var1);
      }

      public AnalyticsContext.Campaign putSource(String var1) {
         return this.putValue("source", var1);
      }

      public AnalyticsContext.Campaign putTerm(String var1) {
         return this.putValue("term", var1);
      }

      public AnalyticsContext.Campaign putValue(String var1, Object var2) {
         super.putValue(var1, var2);
         return this;
      }

      public String source() {
         return this.getString("source");
      }

      public String term() {
         return this.getString("term");
      }

      public String tern() {
         return this.term();
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

      private Device(Map<String, Object> var1) {
         super(var1);
      }

      void putAdvertisingInfo(String var1, boolean var2) {
         if (var2 && !Utils.isNullOrEmpty(var1)) {
            this.put("advertisingId", var1);
         }

         this.put("adTrackingEnabled", var2);
      }

      public AnalyticsContext.Device putDeviceToken(String var1) {
         return this.putValue("token", var1);
      }

      public AnalyticsContext.Device putValue(String var1, Object var2) {
         super.putValue(var1, var2);
         return this;
      }
   }

   public static class Location extends ValueMap {
      private static final String LOCATION_LATITUDE_KEY = "latitude";
      private static final String LOCATION_LONGITUDE_KEY = "longitude";
      private static final String LOCATION_SPEED_KEY = "speed";

      public Location() {
      }

      private Location(Map<String, Object> var1) {
         super(var1);
      }

      public double latitude() {
         return this.getDouble("latitude", 0.0);
      }

      public double longitude() {
         return this.getDouble("longitude", 0.0);
      }

      public AnalyticsContext.Location putLatitude(double var1) {
         return this.putValue("latitude", var1);
      }

      public AnalyticsContext.Location putLongitude(double var1) {
         return this.putValue("longitude", var1);
      }

      public AnalyticsContext.Location putSpeed(double var1) {
         return this.putValue("speed", var1);
      }

      public AnalyticsContext.Location putValue(String var1, Object var2) {
         super.putValue(var1, var2);
         return this;
      }

      public double speed() {
         return this.getDouble("speed", 0.0);
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

      public Referrer(Map<String, Object> var1) {
         super(var1);
      }

      public String id() {
         return this.getString("id");
      }

      public String link() {
         return this.getString("link");
      }

      public String name() {
         return this.getString("name");
      }

      public AnalyticsContext.Referrer putId(String var1) {
         return this.putValue("id", var1);
      }

      public AnalyticsContext.Referrer putLink(String var1) {
         return this.putValue("link", var1);
      }

      public AnalyticsContext.Referrer putName(String var1) {
         return this.putValue("name", var1);
      }

      public AnalyticsContext.Referrer putTerm(String var1) {
         return this.putValue("url", var1);
      }

      public AnalyticsContext.Referrer putType(String var1) {
         return this.putValue("type", var1);
      }

      public AnalyticsContext.Referrer putUrl(String var1) {
         return this.putValue("url", var1);
      }

      public AnalyticsContext.Referrer putValue(String var1, Object var2) {
         super.putValue(var1, var2);
         return this;
      }

      public String type() {
         return this.getString("type");
      }

      public String url() {
         return this.getString("url");
      }
   }
}
