package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import com.facebook.CustomTabActivity;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class Validate {
   private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
   private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
   private static final String CUSTOM_TAB_REDIRECT_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
   private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
   private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
   private static final String TAG = Validate.class.getName();

   public static void checkCustomTabRedirectActivity(Context var0) {
      checkCustomTabRedirectActivity(var0, true);
   }

   public static void checkCustomTabRedirectActivity(Context var0, boolean var1) {
      if (!hasCustomTabRedirectActivity(var0)) {
         if (var1) {
            throw new IllegalStateException(
               "FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info."
            );
         }

         Log.w(
            TAG,
            "FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info."
         );
      }
   }

   public static void containsNoNullOrEmpty(Collection<String> var0, String var1) {
      notNull(var0, var1);

      for (String var2 : var0) {
         if (var2 == null) {
            throw new NullPointerException("Container '" + var1 + "' cannot contain null values");
         }

         if (var2.length() == 0) {
            throw new IllegalArgumentException("Container '" + var1 + "' cannot contain empty values");
         }
      }
   }

   public static <T> void containsNoNulls(Collection<T> var0, String var1) {
      notNull(var0, var1);
      Iterator var2 = var0.iterator();

      while (var2.hasNext()) {
         if (var2.next() == null) {
            throw new NullPointerException("Container '" + var1 + "' cannot contain null values");
         }
      }
   }

   public static String hasAppID() {
      String var0 = FacebookSdk.getApplicationId();
      if (var0 == null) {
         throw new IllegalStateException("No App ID found, please set the App ID.");
      } else {
         return var0;
      }
   }

   public static String hasClientToken() {
      String var0 = FacebookSdk.getClientToken();
      if (var0 == null) {
         throw new IllegalStateException("No Client Token found, please set the Client Token.");
      } else {
         return var0;
      }
   }

   public static void hasContentProvider(Context var0) {
      notNull(var0, "context");
      String var1 = hasAppID();
      PackageManager var2 = var0.getPackageManager();
      if (var2 != null) {
         var1 = "com.facebook.app.FacebookContentProvider" + var1;
         if (var2.resolveContentProvider(var1, 0) == null) {
            throw new IllegalStateException(
               String.format(
                  "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.",
                  var1
               )
            );
         }
      }
   }

   public static boolean hasCustomTabRedirectActivity(Context var0) {
      boolean var2 = false;
      notNull(var0, "context");
      PackageManager var3 = var0.getPackageManager();
      List var4 = null;
      if (var3 != null) {
         Intent var5 = new Intent();
         var5.setAction("android.intent.action.VIEW");
         var5.addCategory("android.intent.category.DEFAULT");
         var5.addCategory("android.intent.category.BROWSABLE");
         var5.setData(Uri.parse("fb" + FacebookSdk.getApplicationId() + "://authorize"));
         var4 = var3.queryIntentActivities(var5, 64);
      }

      boolean var1;
      if (var4 != null) {
         Iterator var6 = var4.iterator();

         for (var1 = false; var6.hasNext(); var1 = true) {
            var1 = var2;
            if (!((ResolveInfo)var6.next()).activityInfo.name.equals(CustomTabActivity.class.getName())) {
               break;
            }
         }
      } else {
         var1 = false;
      }

      return var1;
   }

   public static void hasFacebookActivity(Context var0) {
      hasFacebookActivity(var0, true);
   }

   public static void hasFacebookActivity(Context var0, boolean var1) {
      notNull(var0, "context");
      PackageManager var4 = var0.getPackageManager();
      Object var3 = null;
      ActivityInfo var2 = (ActivityInfo)var3;
      if (var4 != null) {
         ComponentName var6 = new ComponentName(var0, FacebookActivity.class);

         try {
            var2 = var4.getActivityInfo(var6, 1);
         } catch (NameNotFoundException var5) {
            var2 = (ActivityInfo)var3;
         }
      }

      if (var2 == null) {
         if (var1) {
            throw new IllegalStateException(
               "FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info."
            );
         }

         Log.w(
            TAG,
            "FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info."
         );
      }
   }

   public static void hasInternetPermissions(Context var0) {
      hasInternetPermissions(var0, true);
   }

   public static void hasInternetPermissions(Context var0, boolean var1) {
      notNull(var0, "context");
      if (var0.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
         if (var1) {
            throw new IllegalStateException(
               "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml."
            );
         }

         Log.w(
            TAG,
            "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml."
         );
      }
   }

   public static <T> void notEmpty(Collection<T> var0, String var1) {
      if (var0.isEmpty()) {
         throw new IllegalArgumentException("Container '" + var1 + "' cannot be empty");
      }
   }

   public static <T> void notEmptyAndContainsNoNulls(Collection<T> var0, String var1) {
      containsNoNulls(var0, var1);
      notEmpty(var0, var1);
   }

   public static void notNull(Object var0, String var1) {
      if (var0 == null) {
         throw new NullPointerException("Argument '" + var1 + "' cannot be null");
      }
   }

   public static void notNullOrEmpty(String var0, String var1) {
      if (Utility.isNullOrEmpty(var0)) {
         throw new IllegalArgumentException("Argument '" + var1 + "' cannot be null or empty");
      }
   }

   public static void oneOf(Object var0, String var1, Object... var2) {
      for (Object var5 : var2) {
         if (var5 != null ? var5.equals(var0) : var0 == null) {
            return;
         }
      }

      throw new IllegalArgumentException("Argument '" + var1 + "' was not one of the allowed values");
   }

   public static void runningOnUiThread() {
      if (!Looper.getMainLooper().equals(Looper.myLooper())) {
         throw new FacebookException("This method should be called from the UI thread");
      }
   }

   public static void sdkInitialized() {
      if (!FacebookSdk.isInitialized()) {
         throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
      }
   }
}
