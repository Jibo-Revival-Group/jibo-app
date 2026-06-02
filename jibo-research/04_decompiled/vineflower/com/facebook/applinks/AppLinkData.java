package com.facebook.applinks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLinkData {
   private static final String APPLINK_BRIDGE_ARGS_KEY = "bridge_args";
   private static final String APPLINK_METHOD_ARGS_KEY = "method_args";
   private static final String APPLINK_VERSION_KEY = "version";
   public static final String ARGUMENTS_EXTRAS_KEY = "extras";
   public static final String ARGUMENTS_NATIVE_CLASS_KEY = "com.facebook.platform.APPLINK_NATIVE_CLASS";
   public static final String ARGUMENTS_NATIVE_URL = "com.facebook.platform.APPLINK_NATIVE_URL";
   public static final String ARGUMENTS_REFERER_DATA_KEY = "referer_data";
   public static final String ARGUMENTS_TAPTIME_KEY = "com.facebook.platform.APPLINK_TAP_TIME_UTC";
   private static final String BRIDGE_ARGS_METHOD_KEY = "method";
   private static final String BUNDLE_AL_APPLINK_DATA_KEY = "al_applink_data";
   static final String BUNDLE_APPLINK_ARGS_KEY = "com.facebook.platform.APPLINK_ARGS";
   private static final String DEFERRED_APP_LINK_ARGS_FIELD = "applink_args";
   private static final String DEFERRED_APP_LINK_CLASS_FIELD = "applink_class";
   private static final String DEFERRED_APP_LINK_CLICK_TIME_FIELD = "click_time";
   private static final String DEFERRED_APP_LINK_EVENT = "DEFERRED_APP_LINK";
   private static final String DEFERRED_APP_LINK_PATH = "%s/activities";
   private static final String DEFERRED_APP_LINK_URL_FIELD = "applink_url";
   private static final String EXTRAS_DEEPLINK_CONTEXT_KEY = "deeplink_context";
   private static final String METHOD_ARGS_REF_KEY = "ref";
   private static final String METHOD_ARGS_TARGET_URL_KEY = "target_url";
   private static final String PROMOTION_CODE_KEY = "promo_code";
   private static final String REFERER_DATA_REF_KEY = "fb_ref";
   private static final String TAG = AppLinkData.class.getCanonicalName();
   private Bundle argumentBundle;
   private JSONObject arguments;
   private String promotionCode;
   private String ref;
   private Uri targetUri;

   private AppLinkData() {
   }

   public static AppLinkData createFromActivity(Activity var0) {
      Validate.notNull(var0, "activity");
      Intent var2 = var0.getIntent();
      AppLinkData var1;
      if (var2 == null) {
         var1 = null;
      } else {
         var1 = createFromAlApplinkData(var2);
         AppLinkData var3 = var1;
         if (var1 == null) {
            var3 = createFromJson(var2.getStringExtra("com.facebook.platform.APPLINK_ARGS"));
         }

         var1 = var3;
         if (var3 == null) {
            var1 = createFromUri(var2.getData());
         }
      }

      return var1;
   }

   public static AppLinkData createFromAlApplinkData(Intent var0) {
      AppLinkData var1 = null;
      if (var0 != null) {
         Bundle var2 = var0.getBundleExtra("al_applink_data");
         if (var2 != null) {
            var1 = new AppLinkData();
            var1.targetUri = var0.getData();
            if (var1.targetUri == null) {
               String var4 = var2.getString("target_url");
               if (var4 != null) {
                  var1.targetUri = Uri.parse(var4);
               }
            }

            var1.argumentBundle = var2;
            var1.arguments = null;
            Bundle var5 = var2.getBundle("referer_data");
            if (var5 != null) {
               var1.ref = var5.getString("fb_ref");
            }

            Bundle var6 = var2.getBundle("extras");
            if (var6 != null) {
               String var7 = var6.getString("deeplink_context");
               if (var7 != null) {
                  try {
                     JSONObject var8 = new JSONObject(var7);
                     if (var8.has("promo_code")) {
                        var1.promotionCode = var8.getString("promo_code");
                     }
                  } catch (JSONException var3) {
                     Log.d(TAG, "Unable to parse deeplink_context JSON", var3);
                  }
               }
            }
         }
      }

      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static AppLinkData createFromJson(String var0) {
      Object var1 = null;
      AppLinkData var18;
      if (var0 == null) {
         var18 = (AppLinkData)var1;
      } else {
         JSONObject var2;
         String var3;
         try {
            var2 = new JSONObject(var0);
            var3 = var2.getString("version");
         } catch (JSONException var16) {
            Log.d(TAG, "Unable to parse AppLink JSON", var16);
            Object var23 = var1;
            return (AppLinkData)var23;
         } catch (FacebookException var17) {
            Log.d(TAG, "Unable to parse AppLink JSON", var17);
            Object var22 = var1;
            return (AppLinkData)var22;
         }

         Object var24 = var1;

         try {
            if (!var2.getJSONObject("bridge_args").getString("method").equals("applink")) {
               return (AppLinkData)var24;
            }
         } catch (JSONException var14) {
            Log.d(TAG, "Unable to parse AppLink JSON", var14);
            var24 = var1;
            return (AppLinkData)var24;
         } catch (FacebookException var15) {
            Log.d(TAG, "Unable to parse AppLink JSON", var15);
            var24 = var1;
            return (AppLinkData)var24;
         }

         var24 = var1;

         label97: {
            try {
               if (!var3.equals("2")) {
                  return (AppLinkData)var24;
               }

               var18 = new AppLinkData();
               var18.arguments = var2.getJSONObject("method_args");
               if (var18.arguments.has("ref")) {
                  var18.ref = var18.arguments.getString("ref");
                  break label97;
               }
            } catch (JSONException var12) {
               Log.d(TAG, "Unable to parse AppLink JSON", var12);
               var24 = var1;
               return (AppLinkData)var24;
            } catch (FacebookException var13) {
               Log.d(TAG, "Unable to parse AppLink JSON", var13);
               var24 = var1;
               return (AppLinkData)var24;
            }

            try {
               if (var18.arguments.has("referer_data")) {
                  var2 = var18.arguments.getJSONObject("referer_data");
                  if (var2.has("fb_ref")) {
                     var18.ref = var2.getString("fb_ref");
                  }
               }
            } catch (JSONException var10) {
               Log.d(TAG, "Unable to parse AppLink JSON", var10);
               var24 = var1;
               return (AppLinkData)var24;
            } catch (FacebookException var11) {
               Log.d(TAG, "Unable to parse AppLink JSON", var11);
               var24 = var1;
               return (AppLinkData)var24;
            }
         }

         try {
            if (var18.arguments.has("target_url")) {
               var18.targetUri = Uri.parse(var18.arguments.getString("target_url"));
            }
         } catch (JSONException var8) {
            Log.d(TAG, "Unable to parse AppLink JSON", var8);
            var24 = var1;
            return (AppLinkData)var24;
         } catch (FacebookException var9) {
            Log.d(TAG, "Unable to parse AppLink JSON", var9);
            var24 = var1;
            return (AppLinkData)var24;
         }

         try {
            if (var18.arguments.has("extras")) {
               var2 = var18.arguments.getJSONObject("extras");
               if (var2.has("deeplink_context")) {
                  var2 = var2.getJSONObject("deeplink_context");
                  if (var2.has("promo_code")) {
                     var18.promotionCode = var2.getString("promo_code");
                  }
               }
            }
         } catch (JSONException var6) {
            Log.d(TAG, "Unable to parse AppLink JSON", var6);
            var24 = var1;
            return (AppLinkData)var24;
         } catch (FacebookException var7) {
            Log.d(TAG, "Unable to parse AppLink JSON", var7);
            var24 = var1;
            return (AppLinkData)var24;
         }

         try {
            var18.argumentBundle = toBundle(var18.arguments);
         } catch (JSONException var4) {
            Log.d(TAG, "Unable to parse AppLink JSON", var4);
            var18 = (AppLinkData)var1;
         } catch (FacebookException var5) {
            Log.d(TAG, "Unable to parse AppLink JSON", var5);
            var18 = (AppLinkData)var1;
         }
      }

      return var18;
   }

   private static AppLinkData createFromUri(Uri var0) {
      AppLinkData var2;
      if (var0 == null) {
         var2 = null;
      } else {
         AppLinkData var1 = new AppLinkData();
         var1.targetUri = var0;
         var2 = var1;
      }

      return var2;
   }

   public static void fetchDeferredAppLinkData(Context var0, AppLinkData.CompletionHandler var1) {
      fetchDeferredAppLinkData(var0, null, var1);
   }

   public static void fetchDeferredAppLinkData(Context var0, String var1, AppLinkData.CompletionHandler var2) {
      Validate.notNull(var0, "context");
      Validate.notNull(var2, "completionHandler");
      String var3 = var1;
      if (var1 == null) {
         var3 = Utility.getMetadataApplicationId(var0);
      }

      Validate.notNull(var3, "applicationId");
      var0 = var0.getApplicationContext();
      FacebookSdk.getExecutor().execute(new Runnable(var0, var3, var2) {
         final Context val$applicationContext;
         final String val$applicationIdCopy;
         final AppLinkData.CompletionHandler val$completionHandler;

         {
            this.val$applicationContext = var1;
            this.val$applicationIdCopy = var2x;
            this.val$completionHandler = var3x;
         }

         @Override
         public void run() {
            AppLinkData.fetchDeferredAppLinkFromServer(this.val$applicationContext, this.val$applicationIdCopy, this.val$completionHandler);
         }
      });
   }

   private static void fetchDeferredAppLinkFromServer(Context param0, String param1, AppLinkData.CompletionHandler param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 5
      // 003: aconst_null
      // 004: astore 6
      // 006: new org/json/JSONObject
      // 009: dup
      // 00a: invokespecial org/json/JSONObject.<init> ()V
      // 00d: astore 7
      // 00f: aload 7
      // 011: ldc "event"
      // 013: ldc "DEFERRED_APP_LINK"
      // 015: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      // 018: pop
      // 019: aload 7
      // 01b: aload 0
      // 01c: invokestatic com/facebook/internal/AttributionIdentifiers.getAttributionIdentifiers (Landroid/content/Context;)Lcom/facebook/internal/AttributionIdentifiers;
      // 01f: aload 0
      // 020: invokestatic com/facebook/appevents/AppEventsLogger.getAnonymousAppDeviceGUID (Landroid/content/Context;)Ljava/lang/String;
      // 023: aload 0
      // 024: invokestatic com/facebook/FacebookSdk.getLimitEventAndDataUsage (Landroid/content/Context;)Z
      // 027: invokestatic com/facebook/internal/Utility.setAppEventAttributionParameters (Lorg/json/JSONObject;Lcom/facebook/internal/AttributionIdentifiers;Ljava/lang/String;Z)V
      // 02a: aload 7
      // 02c: invokestatic com/facebook/FacebookSdk.getApplicationContext ()Landroid/content/Context;
      // 02f: invokestatic com/facebook/internal/Utility.setAppEventExtendedDeviceInfoParameters (Lorg/json/JSONObject;Landroid/content/Context;)V
      // 032: aload 7
      // 034: ldc_w "application_package_name"
      // 037: aload 0
      // 038: invokevirtual android/content/Context.getPackageName ()Ljava/lang/String;
      // 03b: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      // 03e: pop
      // 03f: ldc "%s/activities"
      // 041: bipush 1
      // 042: anewarray 4
      // 045: dup
      // 046: bipush 0
      // 047: aload 1
      // 048: aastore
      // 049: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 04c: astore 1
      // 04d: aload 5
      // 04f: astore 0
      // 050: aconst_null
      // 051: aload 1
      // 052: aload 7
      // 054: aconst_null
      // 055: invokestatic com/facebook/GraphRequest.newPostRequest (Lcom/facebook/AccessToken;Ljava/lang/String;Lorg/json/JSONObject;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;
      // 058: invokevirtual com/facebook/GraphRequest.executeAndWait ()Lcom/facebook/GraphResponse;
      // 05b: invokevirtual com/facebook/GraphResponse.getJSONObject ()Lorg/json/JSONObject;
      // 05e: astore 7
      // 060: aload 6
      // 062: astore 1
      // 063: aload 7
      // 065: ifnull 16d
      // 068: aload 5
      // 06a: astore 0
      // 06b: aload 7
      // 06d: ldc "applink_args"
      // 06f: invokevirtual org/json/JSONObject.optString (Ljava/lang/String;)Ljava/lang/String;
      // 072: astore 9
      // 074: aload 5
      // 076: astore 0
      // 077: aload 7
      // 079: ldc "click_time"
      // 07b: ldc2_w -1
      // 07e: invokevirtual org/json/JSONObject.optLong (Ljava/lang/String;J)J
      // 081: lstore 3
      // 082: aload 5
      // 084: astore 0
      // 085: aload 7
      // 087: ldc "applink_class"
      // 089: invokevirtual org/json/JSONObject.optString (Ljava/lang/String;)Ljava/lang/String;
      // 08c: astore 8
      // 08e: aload 5
      // 090: astore 0
      // 091: aload 7
      // 093: ldc "applink_url"
      // 095: invokevirtual org/json/JSONObject.optString (Ljava/lang/String;)Ljava/lang/String;
      // 098: astore 7
      // 09a: aload 6
      // 09c: astore 1
      // 09d: aload 5
      // 09f: astore 0
      // 0a0: aload 9
      // 0a2: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 0a5: ifne 16d
      // 0a8: aload 5
      // 0aa: astore 0
      // 0ab: aload 9
      // 0ad: invokestatic com/facebook/applinks/AppLinkData.createFromJson (Ljava/lang/String;)Lcom/facebook/applinks/AppLinkData;
      // 0b0: astore 5
      // 0b2: lload 3
      // 0b3: ldc2_w -1
      // 0b6: lcmp
      // 0b7: ifeq 0f0
      // 0ba: aload 5
      // 0bc: astore 0
      // 0bd: aload 5
      // 0bf: getfield com/facebook/applinks/AppLinkData.arguments Lorg/json/JSONObject;
      // 0c2: ifnull 0d4
      // 0c5: aload 5
      // 0c7: astore 0
      // 0c8: aload 5
      // 0ca: getfield com/facebook/applinks/AppLinkData.arguments Lorg/json/JSONObject;
      // 0cd: ldc "com.facebook.platform.APPLINK_TAP_TIME_UTC"
      // 0cf: lload 3
      // 0d0: invokevirtual org/json/JSONObject.put (Ljava/lang/String;J)Lorg/json/JSONObject;
      // 0d3: pop
      // 0d4: aload 5
      // 0d6: astore 0
      // 0d7: aload 5
      // 0d9: getfield com/facebook/applinks/AppLinkData.argumentBundle Landroid/os/Bundle;
      // 0dc: ifnull 0f0
      // 0df: aload 5
      // 0e1: astore 0
      // 0e2: aload 5
      // 0e4: getfield com/facebook/applinks/AppLinkData.argumentBundle Landroid/os/Bundle;
      // 0e7: ldc "com.facebook.platform.APPLINK_TAP_TIME_UTC"
      // 0e9: lload 3
      // 0ea: invokestatic java/lang/Long.toString (J)Ljava/lang/String;
      // 0ed: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 0f0: aload 8
      // 0f2: ifnull 12a
      // 0f5: aload 5
      // 0f7: astore 0
      // 0f8: aload 5
      // 0fa: getfield com/facebook/applinks/AppLinkData.arguments Lorg/json/JSONObject;
      // 0fd: ifnull 110
      // 100: aload 5
      // 102: astore 0
      // 103: aload 5
      // 105: getfield com/facebook/applinks/AppLinkData.arguments Lorg/json/JSONObject;
      // 108: ldc "com.facebook.platform.APPLINK_NATIVE_CLASS"
      // 10a: aload 8
      // 10c: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      // 10f: pop
      // 110: aload 5
      // 112: astore 0
      // 113: aload 5
      // 115: getfield com/facebook/applinks/AppLinkData.argumentBundle Landroid/os/Bundle;
      // 118: ifnull 12a
      // 11b: aload 5
      // 11d: astore 0
      // 11e: aload 5
      // 120: getfield com/facebook/applinks/AppLinkData.argumentBundle Landroid/os/Bundle;
      // 123: ldc "com.facebook.platform.APPLINK_NATIVE_CLASS"
      // 125: aload 8
      // 127: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 12a: aload 5
      // 12c: astore 1
      // 12d: aload 7
      // 12f: ifnull 16d
      // 132: aload 5
      // 134: astore 0
      // 135: aload 5
      // 137: getfield com/facebook/applinks/AppLinkData.arguments Lorg/json/JSONObject;
      // 13a: ifnull 14d
      // 13d: aload 5
      // 13f: astore 0
      // 140: aload 5
      // 142: getfield com/facebook/applinks/AppLinkData.arguments Lorg/json/JSONObject;
      // 145: ldc "com.facebook.platform.APPLINK_NATIVE_URL"
      // 147: aload 7
      // 149: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      // 14c: pop
      // 14d: aload 5
      // 14f: astore 1
      // 150: aload 5
      // 152: astore 0
      // 153: aload 5
      // 155: getfield com/facebook/applinks/AppLinkData.argumentBundle Landroid/os/Bundle;
      // 158: ifnull 16d
      // 15b: aload 5
      // 15d: astore 0
      // 15e: aload 5
      // 160: getfield com/facebook/applinks/AppLinkData.argumentBundle Landroid/os/Bundle;
      // 163: ldc "com.facebook.platform.APPLINK_NATIVE_URL"
      // 165: aload 7
      // 167: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 16a: aload 5
      // 16c: astore 1
      // 16d: aload 2
      // 16e: aload 1
      // 16f: invokeinterface com/facebook/applinks/AppLinkData$CompletionHandler.onDeferredAppLinkDataFetched (Lcom/facebook/applinks/AppLinkData;)V 2
      // 174: return
      // 175: astore 0
      // 176: new com/facebook/FacebookException
      // 179: dup
      // 17a: ldc_w "An error occurred while preparing deferred app link"
      // 17d: aload 0
      // 17e: invokespecial com/facebook/FacebookException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 181: athrow
      // 182: astore 0
      // 183: aload 5
      // 185: astore 0
      // 186: getstatic com/facebook/applinks/AppLinkData.TAG Ljava/lang/String;
      // 189: ldc_w "Unable to put tap time in AppLinkData.arguments"
      // 18c: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 18f: pop
      // 190: goto 0f0
      // 193: astore 1
      // 194: getstatic com/facebook/applinks/AppLinkData.TAG Ljava/lang/String;
      // 197: ldc_w "Unable to fetch deferred applink from server"
      // 19a: invokestatic com/facebook/internal/Utility.logd (Ljava/lang/String;Ljava/lang/String;)V
      // 19d: aload 0
      // 19e: astore 1
      // 19f: goto 16d
      // 1a2: astore 0
      // 1a3: aload 5
      // 1a5: astore 0
      // 1a6: getstatic com/facebook/applinks/AppLinkData.TAG Ljava/lang/String;
      // 1a9: ldc_w "Unable to put tap time in AppLinkData.arguments"
      // 1ac: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 1af: pop
      // 1b0: goto 12a
      // 1b3: astore 0
      // 1b4: aload 5
      // 1b6: astore 0
      // 1b7: getstatic com/facebook/applinks/AppLinkData.TAG Ljava/lang/String;
      // 1ba: ldc_w "Unable to put tap time in AppLinkData.arguments"
      // 1bd: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 1c0: pop
      // 1c1: aload 5
      // 1c3: astore 1
      // 1c4: goto 16d
      // try (8 -> 30): 184 org/json/JSONException
      // try (41 -> 49): 199 java/lang/Exception
      // try (55 -> 59): 199 java/lang/Exception
      // try (61 -> 66): 199 java/lang/Exception
      // try (68 -> 72): 199 java/lang/Exception
      // try (74 -> 78): 199 java/lang/Exception
      // try (82 -> 85): 199 java/lang/Exception
      // try (87 -> 90): 199 java/lang/Exception
      // try (96 -> 99): 191 org/json/JSONException
      // try (96 -> 99): 199 java/lang/Exception
      // try (101 -> 107): 191 org/json/JSONException
      // try (101 -> 107): 199 java/lang/Exception
      // try (109 -> 112): 191 org/json/JSONException
      // try (109 -> 112): 199 java/lang/Exception
      // try (114 -> 120): 191 org/json/JSONException
      // try (114 -> 120): 199 java/lang/Exception
      // try (124 -> 127): 206 org/json/JSONException
      // try (124 -> 127): 199 java/lang/Exception
      // try (129 -> 135): 206 org/json/JSONException
      // try (129 -> 135): 199 java/lang/Exception
      // try (137 -> 140): 206 org/json/JSONException
      // try (137 -> 140): 199 java/lang/Exception
      // try (142 -> 147): 206 org/json/JSONException
      // try (142 -> 147): 199 java/lang/Exception
      // try (153 -> 156): 214 org/json/JSONException
      // try (153 -> 156): 199 java/lang/Exception
      // try (158 -> 164): 214 org/json/JSONException
      // try (158 -> 164): 199 java/lang/Exception
      // try (168 -> 171): 214 org/json/JSONException
      // try (168 -> 171): 199 java/lang/Exception
      // try (173 -> 178): 214 org/json/JSONException
      // try (173 -> 178): 199 java/lang/Exception
      // try (194 -> 198): 199 java/lang/Exception
      // try (209 -> 213): 199 java/lang/Exception
      // try (217 -> 221): 199 java/lang/Exception
   }

   private static Bundle toBundle(JSONObject var0) throws JSONException {
      Bundle var2 = new Bundle();
      Iterator var3 = var0.keys();

      while (var3.hasNext()) {
         String var4 = (String)var3.next();
         Object var5 = var0.get(var4);
         if (var5 instanceof JSONObject) {
            var2.putBundle(var4, toBundle((JSONObject)var5));
         } else if (!(var5 instanceof JSONArray)) {
            var2.putString(var4, var5.toString());
         } else {
            JSONArray var8 = (JSONArray)var5;
            if (var8.length() == 0) {
               var2.putStringArray(var4, new String[0]);
            } else {
               Parcelable[] var6 = (Parcelable[])var8.get(0);
               if (var6 instanceof JSONObject) {
                  var6 = new Bundle[var8.length()];

                  for (int var7 = 0; var7 < var8.length(); var7++) {
                     var6[var7] = toBundle(var8.getJSONObject(var7));
                  }

                  var2.putParcelableArray(var4, var6);
               } else {
                  if (var6 instanceof JSONArray) {
                     throw new FacebookException("Nested arrays are not supported.");
                  }

                  String[] var9 = new String[var8.length()];

                  for (int var1 = 0; var1 < var8.length(); var1++) {
                     var9[var1] = var8.get(var1).toString();
                  }

                  var2.putStringArray(var4, var9);
               }
            }
         }
      }

      return var2;
   }

   public Bundle getArgumentBundle() {
      return this.argumentBundle;
   }

   public String getPromotionCode() {
      return this.promotionCode;
   }

   public String getRef() {
      return this.ref;
   }

   public Bundle getRefererData() {
      Bundle var1;
      if (this.argumentBundle != null) {
         var1 = this.argumentBundle.getBundle("referer_data");
      } else {
         var1 = null;
      }

      return var1;
   }

   public Uri getTargetUri() {
      return this.targetUri;
   }

   public interface CompletionHandler {
      void onDeferredAppLinkDataFetched(AppLinkData var1);
   }
}
