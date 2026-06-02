package com.facebook.devicerequests.internal;

import android.annotation.TargetApi;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.net.nsd.NsdManager.RegistrationListener;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceRequestsHelper {
   static final String DEVICE_INFO_DEVICE = "device";
   static final String DEVICE_INFO_MODEL = "model";
   public static final String DEVICE_INFO_PARAM = "device_info";
   static final String SDK_FLAVOR = "android";
   static final String SDK_HEADER = "fbsdk";
   static final String SERVICE_TYPE = "_fb._tcp.";
   private static HashMap<String, RegistrationListener> deviceRequestsListeners = new HashMap<>();

   public static void cleanUpAdvertisementService(String var0) {
      cleanUpAdvertisementServiceImpl(var0);
   }

   @TargetApi(16)
   private static void cleanUpAdvertisementServiceImpl(String var0) {
      RegistrationListener var1 = deviceRequestsListeners.get(var0);
      if (var1 != null) {
         ((NsdManager)FacebookSdk.getApplicationContext().getSystemService("servicediscovery")).unregisterService(var1);
         deviceRequestsListeners.remove(var0);
      }
   }

   public static String getDeviceInfo() {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("device", Build.DEVICE);
         var1.put("model", Build.MODEL);
      } catch (JSONException var2) {
      }

      return var1.toString();
   }

   public static boolean isAvailable() {
      boolean var0;
      if (VERSION.SDK_INT >= 16
         && FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.Enabled)) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   public static boolean startAdvertisementService(String var0) {
      boolean var1;
      if (isAvailable()) {
         var1 = startAdvertisementServiceImpl(var0);
      } else {
         var1 = false;
      }

      return var1;
   }

   @TargetApi(16)
   private static boolean startAdvertisementServiceImpl(String var0) {
      if (!deviceRequestsListeners.containsKey(var0)) {
         String var3 = String.format("%s_%s_%s", "fbsdk", String.format("%s-%s", "android", FacebookSdk.getSdkVersion().replace('.', '|')), var0);
         NsdServiceInfo var2 = new NsdServiceInfo();
         var2.setServiceType("_fb._tcp.");
         var2.setServiceName(var3);
         var2.setPort(80);
         NsdManager var1 = (NsdManager)FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
         RegistrationListener var4 = new RegistrationListener(var3, var0) {
            final String val$nsdServiceName;
            final String val$userCode;

            {
               this.val$nsdServiceName = var1;
               this.val$userCode = var2x;
            }

            public void onRegistrationFailed(NsdServiceInfo var1, int var2x) {
               DeviceRequestsHelper.cleanUpAdvertisementService(this.val$userCode);
            }

            public void onServiceRegistered(NsdServiceInfo var1) {
               if (!this.val$nsdServiceName.equals(var1.getServiceName())) {
                  DeviceRequestsHelper.cleanUpAdvertisementService(this.val$userCode);
               }
            }

            public void onServiceUnregistered(NsdServiceInfo var1) {
            }

            public void onUnregistrationFailed(NsdServiceInfo var1, int var2x) {
            }
         };
         deviceRequestsListeners.put(var0, var4);
         var1.registerService(var2, 1, var4);
      }

      return true;
   }
}
