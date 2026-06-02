package com.facebook.internal;

import android.net.Uri;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class FetchedAppSettings {
   private boolean automaticLoggingEnabled;
   private boolean customTabsEnabled;
   private Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> dialogConfigMap;
   private FacebookRequestErrorClassification errorClassification;
   private String nuxContent;
   private boolean nuxEnabled;
   private int sessionTimeoutInSeconds;
   private String smartLoginBookmarkIconURL;
   private String smartLoginMenuIconURL;
   private EnumSet<SmartLoginOption> smartLoginOptions;
   private boolean supportsImplicitLogging;

   public FetchedAppSettings(
      boolean var1,
      String var2,
      boolean var3,
      boolean var4,
      int var5,
      EnumSet<SmartLoginOption> var6,
      Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> var7,
      boolean var8,
      FacebookRequestErrorClassification var9,
      String var10,
      String var11
   ) {
      this.supportsImplicitLogging = var1;
      this.nuxContent = var2;
      this.nuxEnabled = var3;
      this.customTabsEnabled = var4;
      this.dialogConfigMap = var7;
      this.errorClassification = var9;
      this.sessionTimeoutInSeconds = var5;
      this.automaticLoggingEnabled = var8;
      this.smartLoginOptions = var6;
      this.smartLoginBookmarkIconURL = var10;
      this.smartLoginMenuIconURL = var11;
   }

   public static FetchedAppSettings.DialogFeatureConfig getDialogFeatureConfig(String var0, String var1, String var2) {
      Object var3;
      if (!Utility.isNullOrEmpty(var1) && !Utility.isNullOrEmpty(var2)) {
         FetchedAppSettings var4 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(var0);
         if (var4 != null) {
            Map var5 = var4.getDialogConfigurations().get(var1);
            if (var5 != null) {
               FetchedAppSettings.DialogFeatureConfig var6 = (FetchedAppSettings.DialogFeatureConfig)var5.get(var2);
               return var6;
            }
         }

         var3 = null;
      } else {
         var3 = null;
      }

      return (FetchedAppSettings.DialogFeatureConfig)var3;
   }

   public boolean getAutomaticLoggingEnabled() {
      return this.automaticLoggingEnabled;
   }

   public boolean getCustomTabsEnabled() {
      return this.customTabsEnabled;
   }

   public Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> getDialogConfigurations() {
      return this.dialogConfigMap;
   }

   public FacebookRequestErrorClassification getErrorClassification() {
      return this.errorClassification;
   }

   public String getNuxContent() {
      return this.nuxContent;
   }

   public boolean getNuxEnabled() {
      return this.nuxEnabled;
   }

   public int getSessionTimeoutInSeconds() {
      return this.sessionTimeoutInSeconds;
   }

   public String getSmartLoginBookmarkIconURL() {
      return this.smartLoginBookmarkIconURL;
   }

   public String getSmartLoginMenuIconURL() {
      return this.smartLoginMenuIconURL;
   }

   public EnumSet<SmartLoginOption> getSmartLoginOptions() {
      return this.smartLoginOptions;
   }

   public boolean supportsImplicitLogging() {
      return this.supportsImplicitLogging;
   }

   public static class DialogFeatureConfig {
      private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "\\|";
      private static final String DIALOG_CONFIG_NAME_KEY = "name";
      private static final String DIALOG_CONFIG_URL_KEY = "url";
      private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
      private String dialogName;
      private Uri fallbackUrl;
      private String featureName;
      private int[] featureVersionSpec;

      private DialogFeatureConfig(String var1, String var2, Uri var3, int[] var4) {
         this.dialogName = var1;
         this.featureName = var2;
         this.fallbackUrl = var3;
         this.featureVersionSpec = var4;
      }

      public static FetchedAppSettings.DialogFeatureConfig parseDialogConfig(JSONObject var0) {
         Object var2 = null;
         String var3 = null;
         String var1 = var0.optString("name");
         FetchedAppSettings.DialogFeatureConfig var6;
         if (Utility.isNullOrEmpty(var1)) {
            var6 = var3;
         } else {
            String[] var5 = var1.split("\\|");
            var6 = var3;
            if (var5.length == 2) {
               String var4 = var5[0];
               String var9 = var5[1];
               var6 = var3;
               if (!Utility.isNullOrEmpty(var4)) {
                  var6 = var3;
                  if (!Utility.isNullOrEmpty(var9)) {
                     var3 = var0.optString("url");
                     Uri var7 = (Uri)var2;
                     if (!Utility.isNullOrEmpty(var3)) {
                        var7 = Uri.parse(var3);
                     }

                     var6 = new FetchedAppSettings.DialogFeatureConfig(var4, var9, var7, parseVersionSpec(var0.optJSONArray("versions")));
                  }
               }
            }
         }

         return var6;
      }

      private static int[] parseVersionSpec(JSONArray var0) {
         int[] var5 = null;
         if (var0 != null) {
            int var4 = var0.length();
            var5 = new int[var4];

            for (int var2 = 0; var2 < var4; var2++) {
               int var3 = var0.optInt(var2, -1);
               int var1 = var3;
               if (var3 == -1) {
                  String var6 = var0.optString(var2);
                  var1 = var3;
                  if (!Utility.isNullOrEmpty(var6)) {
                     try {
                        var1 = Integer.parseInt(var6);
                     } catch (NumberFormatException var7) {
                        Utility.logd("FacebookSDK", var7);
                        var1 = -1;
                     }
                  }
               }

               var5[var2] = var1;
            }
         }

         return var5;
      }

      public String getDialogName() {
         return this.dialogName;
      }

      public Uri getFallbackUrl() {
         return this.fallbackUrl;
      }

      public String getFeatureName() {
         return this.featureName;
      }

      public int[] getVersionSpec() {
         return this.featureVersionSpec;
      }
   }
}
