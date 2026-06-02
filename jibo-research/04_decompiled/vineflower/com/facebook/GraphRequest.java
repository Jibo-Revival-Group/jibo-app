package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GraphRequest {
   private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
   public static final String ACCESS_TOKEN_PARAM = "access_token";
   private static final String ATTACHED_FILES_PARAM = "attached_files";
   private static final String ATTACHMENT_FILENAME_PREFIX = "file";
   private static final String BATCH_APP_ID_PARAM = "batch_app_id";
   private static final String BATCH_BODY_PARAM = "body";
   private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
   private static final String BATCH_ENTRY_NAME_PARAM = "name";
   private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
   private static final String BATCH_METHOD_PARAM = "method";
   private static final String BATCH_PARAM = "batch";
   private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
   private static final String CAPTION_PARAM = "caption";
   private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
   private static final String CONTENT_TYPE_HEADER = "Content-Type";
   private static final String DEBUG_KEY = "__debug__";
   private static final String DEBUG_MESSAGES_KEY = "messages";
   private static final String DEBUG_MESSAGE_KEY = "message";
   private static final String DEBUG_MESSAGE_LINK_KEY = "link";
   private static final String DEBUG_MESSAGE_TYPE_KEY = "type";
   private static final String DEBUG_PARAM = "debug";
   private static final String DEBUG_SEVERITY_INFO = "info";
   private static final String DEBUG_SEVERITY_WARNING = "warning";
   public static final String FIELDS_PARAM = "fields";
   private static final String FORMAT_JSON = "json";
   private static final String FORMAT_PARAM = "format";
   private static final String GRAPH_PATH_FORMAT = "%s/%s";
   private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
   public static final int MAXIMUM_BATCH_SIZE = 50;
   private static final String ME = "me";
   private static final String MIME_BOUNDARY = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
   private static final String MY_FRIENDS = "me/friends";
   private static final String MY_PHOTOS = "me/photos";
   private static final String PICTURE_PARAM = "picture";
   private static final String SDK_ANDROID = "android";
   private static final String SDK_PARAM = "sdk";
   private static final String SEARCH = "search";
   public static final String TAG = GraphRequest.class.getSimpleName();
   private static final String USER_AGENT_BASE = "FBAndroidSDK";
   private static final String USER_AGENT_HEADER = "User-Agent";
   private static final String VIDEOS_SUFFIX = "/videos";
   private static String defaultBatchApplicationId;
   private static volatile String userAgent;
   private static Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
   private AccessToken accessToken;
   private String batchEntryDependsOn;
   private String batchEntryName;
   private boolean batchEntryOmitResultOnSuccess = true;
   private GraphRequest.Callback callback;
   private JSONObject graphObject;
   private String graphPath;
   private HttpMethod httpMethod;
   private String overriddenURL;
   private Bundle parameters;
   private boolean skipClientToken = false;
   private Object tag;
   private String version;

   public GraphRequest() {
      this(null, null, null, null, null);
   }

   public GraphRequest(AccessToken var1, String var2) {
      this(var1, var2, null, null, null);
   }

   public GraphRequest(AccessToken var1, String var2, Bundle var3, HttpMethod var4) {
      this(var1, var2, var3, var4, null);
   }

   public GraphRequest(AccessToken var1, String var2, Bundle var3, HttpMethod var4, GraphRequest.Callback var5) {
      this(var1, var2, var3, var4, var5, null);
   }

   public GraphRequest(AccessToken var1, String var2, Bundle var3, HttpMethod var4, GraphRequest.Callback var5, String var6) {
      this.accessToken = var1;
      this.graphPath = var2;
      this.version = var6;
      this.setCallback(var5);
      this.setHttpMethod(var4);
      if (var3 != null) {
         this.parameters = new Bundle(var3);
      } else {
         this.parameters = new Bundle();
      }

      if (this.version == null) {
         this.version = FacebookSdk.getGraphApiVersion();
      }
   }

   GraphRequest(AccessToken var1, URL var2) {
      this.accessToken = var1;
      this.overriddenURL = var2.toString();
      this.setHttpMethod(HttpMethod.GET);
      this.parameters = new Bundle();
   }

   private void addCommonParameters() {
      if (this.accessToken != null) {
         if (!this.parameters.containsKey("access_token")) {
            String var1 = this.accessToken.getToken();
            Logger.registerAccessToken(var1);
            this.parameters.putString("access_token", var1);
         }
      } else if (!this.skipClientToken && !this.parameters.containsKey("access_token")) {
         String var3 = FacebookSdk.getApplicationId();
         String var2 = FacebookSdk.getClientToken();
         if (!Utility.isNullOrEmpty(var3) && !Utility.isNullOrEmpty(var2)) {
            var3 = var3 + "|" + var2;
            this.parameters.putString("access_token", var3);
         } else {
            Log.d(TAG, "Warning: Request without access token missing application ID or client token.");
         }
      }

      this.parameters.putString("sdk", "android");
      this.parameters.putString("format", "json");
      if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
         this.parameters.putString("debug", "info");
      } else if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
         this.parameters.putString("debug", "warning");
      }
   }

   private String appendParametersToBaseUrl(String var1) {
      Builder var3 = Uri.parse(var1).buildUpon();

      for (String var5 : this.parameters.keySet()) {
         Object var2 = this.parameters.get(var5);
         Object var6 = var2;
         if (var2 == null) {
            var6 = "";
         }

         if (isSupportedParameterType(var6)) {
            var3.appendQueryParameter(var5, parameterToString(var6).toString());
         } else if (this.httpMethod == HttpMethod.GET) {
            throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", var6.getClass().getSimpleName()));
         }
      }

      return var3.toString();
   }

   private static HttpURLConnection createConnection(URL var0) throws IOException {
      HttpURLConnection var1 = (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(var0.openConnection()));
      var1.setRequestProperty("User-Agent", getUserAgent());
      var1.setRequestProperty("Accept-Language", Locale.getDefault().toString());
      var1.setChunkedStreamingMode(0);
      return var1;
   }

   public static GraphRequest createOpenGraphObject(ShareOpenGraphObject var0) throws FacebookException {
      String var1 = var0.getString("type");
      if (var1 == null) {
         var1 = var0.getString("og:type");
      }

      if (var1 == null) {
         throw new FacebookException("Open graph object type cannot be null");
      }

      try {
         OpenGraphJSONUtility.PhotoJSONProcessor var2 = new OpenGraphJSONUtility.PhotoJSONProcessor() {
            @Override
            public JSONObject toJSONObject(SharePhoto var1) {
               Uri var4 = var1.getImageUrl();
               JSONObject var2x = new JSONObject();

               try {
                  var2x.put("url", var4.toString());
                  return var2x;
               } catch (Exception var3) {
                  throw new FacebookException("Unable to attach images", var3);
               }
            }
         };
         JSONObject var7 = (JSONObject)OpenGraphJSONUtility.toJSONValue(var0, var2);
         Bundle var5 = new Bundle();
         var5.putString("object", var7.toString());
         Locale var8 = Locale.ROOT;
         StringBuilder var3 = new StringBuilder();
         var1 = String.format(var8, "%s/%s", "me", var3.append("objects/").append(var1).toString());
         return new GraphRequest(AccessToken.getCurrentAccessToken(), var1, var5, HttpMethod.POST);
      } catch (JSONException var4) {
         throw new FacebookException(var4.getMessage());
      }
   }

   public static GraphResponse executeAndWait(GraphRequest var0) {
      List var1 = executeBatchAndWait(var0);
      if (var1 != null && var1.size() == 1) {
         return (GraphResponse)var1.get(0);
      } else {
         throw new FacebookException("invalid state: expected a single response");
      }
   }

   public static List<GraphResponse> executeBatchAndWait(GraphRequestBatch param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 2
      // 02: aload 0
      // 03: ldc_w "requests"
      // 06: invokestatic com/facebook/internal/Validate.notEmptyAndContainsNoNulls (Ljava/util/Collection;Ljava/lang/String;)V
      // 09: aload 2
      // 0a: astore 1
      // 0b: aload 0
      // 0c: invokestatic com/facebook/GraphRequest.toHttpConnection (Lcom/facebook/GraphRequestBatch;)Ljava/net/HttpURLConnection;
      // 0f: astore 3
      // 10: aload 3
      // 11: astore 2
      // 12: aload 2
      // 13: astore 1
      // 14: aload 2
      // 15: aload 0
      // 16: invokestatic com/facebook/GraphRequest.executeConnectionAndWait (Ljava/net/HttpURLConnection;Lcom/facebook/GraphRequestBatch;)Ljava/util/List;
      // 19: astore 0
      // 1a: aload 2
      // 1b: invokestatic com/facebook/internal/Utility.disconnectQuietly (Ljava/net/URLConnection;)V
      // 1e: aload 0
      // 1f: areturn
      // 20: astore 4
      // 22: aload 2
      // 23: astore 1
      // 24: aload 0
      // 25: invokevirtual com/facebook/GraphRequestBatch.getRequests ()Ljava/util/List;
      // 28: astore 3
      // 29: aload 2
      // 2a: astore 1
      // 2b: new com/facebook/FacebookException
      // 2e: astore 5
      // 30: aload 2
      // 31: astore 1
      // 32: aload 5
      // 34: aload 4
      // 36: invokespecial com/facebook/FacebookException.<init> (Ljava/lang/Throwable;)V
      // 39: aload 2
      // 3a: astore 1
      // 3b: aload 3
      // 3c: aconst_null
      // 3d: aload 5
      // 3f: invokestatic com/facebook/GraphResponse.constructErrorResponses (Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
      // 42: astore 3
      // 43: aload 2
      // 44: astore 1
      // 45: aload 0
      // 46: aload 3
      // 47: invokestatic com/facebook/GraphRequest.runCallbacks (Lcom/facebook/GraphRequestBatch;Ljava/util/List;)V
      // 4a: aconst_null
      // 4b: invokestatic com/facebook/internal/Utility.disconnectQuietly (Ljava/net/URLConnection;)V
      // 4e: aload 3
      // 4f: astore 0
      // 50: goto 1e
      // 53: astore 0
      // 54: aload 1
      // 55: invokestatic com/facebook/internal/Utility.disconnectQuietly (Ljava/net/URLConnection;)V
      // 58: aload 0
      // 59: athrow
      // try (7 -> 10): 22 java/lang/Exception
      // try (7 -> 10): 54 null
      // try (14 -> 18): 54 null
      // try (25 -> 28): 54 null
      // try (30 -> 32): 54 null
      // try (34 -> 37): 54 null
      // try (39 -> 44): 54 null
      // try (46 -> 49): 54 null
   }

   public static List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> var0) {
      return executeBatchAndWait(new GraphRequestBatch(var0));
   }

   public static List<GraphResponse> executeBatchAndWait(GraphRequest... var0) {
      Validate.notNull(var0, "requests");
      return executeBatchAndWait(Arrays.asList(var0));
   }

   public static GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch var0) {
      Validate.notEmptyAndContainsNoNulls(var0, "requests");
      GraphRequestAsyncTask var1 = new GraphRequestAsyncTask(var0);
      var1.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
      return var1;
   }

   public static GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> var0) {
      return executeBatchAsync(new GraphRequestBatch(var0));
   }

   public static GraphRequestAsyncTask executeBatchAsync(GraphRequest... var0) {
      Validate.notNull(var0, "requests");
      return executeBatchAsync(Arrays.asList(var0));
   }

   public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection var0, GraphRequestBatch var1) {
      List var3 = GraphResponse.fromHttpConnection(var0, var1);
      Utility.disconnectQuietly(var0);
      int var2 = var1.size();
      if (var2 != var3.size()) {
         throw new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", var3.size(), var2));
      }

      runCallbacks(var1, var3);
      AccessTokenManager.getInstance().extendAccessTokenIfNeeded();
      return var3;
   }

   public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection var0, Collection<GraphRequest> var1) {
      return executeConnectionAndWait(var0, new GraphRequestBatch(var1));
   }

   public static GraphRequestAsyncTask executeConnectionAsync(Handler var0, HttpURLConnection var1, GraphRequestBatch var2) {
      Validate.notNull(var1, "connection");
      GraphRequestAsyncTask var3 = new GraphRequestAsyncTask(var1, var2);
      var2.setCallbackHandler(var0);
      var3.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
      return var3;
   }

   public static GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection var0, GraphRequestBatch var1) {
      return executeConnectionAsync(null, var0, var1);
   }

   private static String getBatchAppId(GraphRequestBatch var0) {
      String var2;
      if (!Utility.isNullOrEmpty(var0.getBatchApplicationId())) {
         var2 = var0.getBatchApplicationId();
      } else {
         Iterator var1 = var0.iterator();

         while (true) {
            if (!var1.hasNext()) {
               if (!Utility.isNullOrEmpty(defaultBatchApplicationId)) {
                  var2 = defaultBatchApplicationId;
               } else {
                  var2 = FacebookSdk.getApplicationId();
               }
               break;
            }

            AccessToken var3 = ((GraphRequest)var1.next()).accessToken;
            if (var3 != null) {
               var2 = var3.getApplicationId();
               if (var2 != null) {
                  break;
               }
            }
         }
      }

      return var2;
   }

   public static final String getDefaultBatchApplicationId() {
      return defaultBatchApplicationId;
   }

   private static String getDefaultPhotoPathIfNull(String var0) {
      String var1 = var0;
      if (var0 == null) {
         var1 = "me/photos";
      }

      return var1;
   }

   private String getGraphPathWithVersion() {
      String var1;
      if (versionPattern.matcher(this.graphPath).matches()) {
         var1 = this.graphPath;
      } else {
         var1 = String.format("%s/%s", this.version, this.graphPath);
      }

      return var1;
   }

   private static String getMimeContentType() {
      return String.format("multipart/form-data; boundary=%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
   }

   private static String getUserAgent() {
      if (userAgent == null) {
         userAgent = String.format("%s.%s", "FBAndroidSDK", "4.20.0");
         String var0 = InternalSettings.getCustomUserAgent();
         if (!Utility.isNullOrEmpty(var0)) {
            userAgent = String.format(Locale.ROOT, "%s/%s", userAgent, var0);
         }
      }

      return userAgent;
   }

   private static boolean hasOnProgressCallbacks(GraphRequestBatch var0) {
      Iterator var2 = var0.getCallbacks().iterator();

      boolean var1;
      while (true) {
         if (var2.hasNext()) {
            if (!((GraphRequestBatch.Callback)var2.next() instanceof GraphRequestBatch.OnProgressCallback)) {
               continue;
            }

            var1 = true;
            break;
         }

         Iterator var3 = var0.iterator();

         while (var3.hasNext()) {
            if (((GraphRequest)var3.next()).getCallback() instanceof GraphRequest.OnProgressCallback) {
               var1 = true;
               return var1;
            }
         }

         var1 = false;
         break;
      }

      return var1;
   }

   private static boolean isGzipCompressible(GraphRequestBatch var0) {
      Iterator var5 = var0.iterator();

      boolean var1;
      label20:
      while (true) {
         if (var5.hasNext()) {
            GraphRequest var3 = (GraphRequest)var5.next();
            Iterator var4 = var3.parameters.keySet().iterator();

            String var2;
            do {
               if (!var4.hasNext()) {
                  continue label20;
               }

               var2 = (String)var4.next();
            } while (!isSupportedAttachmentType(var3.parameters.get(var2)));

            var1 = false;
            break;
         }

         var1 = true;
         break;
      }

      return var1;
   }

   private static boolean isMeRequest(String var0) {
      boolean var2 = true;
      Matcher var3 = versionPattern.matcher(var0);
      if (var3.matches()) {
         var0 = var3.group(1);
      }

      boolean var1 = var2;
      if (!var0.startsWith("me/")) {
         if (var0.startsWith("/me/")) {
            var1 = var2;
         } else {
            var1 = false;
         }
      }

      return var1;
   }

   private static boolean isSupportedAttachmentType(Object var0) {
      boolean var1;
      if (!(var0 instanceof Bitmap)
         && !(var0 instanceof byte[])
         && !(var0 instanceof Uri)
         && !(var0 instanceof ParcelFileDescriptor)
         && !(var0 instanceof GraphRequest.ParcelableResourceWithMimeType)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private static boolean isSupportedParameterType(Object var0) {
      boolean var1;
      if (!(var0 instanceof String) && !(var0 instanceof Boolean) && !(var0 instanceof Number) && !(var0 instanceof Date)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken var0, Context var1, GraphRequest.Callback var2) {
      return newCustomAudienceThirdPartyIdRequest(var0, var1, null, var2);
   }

   public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken var0, Context var1, String var2, GraphRequest.Callback var3) {
      if (var2 == null && var0 != null) {
         var2 = var0.getApplicationId();
      }

      String var4 = var2;
      if (var2 == null) {
         var4 = Utility.getMetadataApplicationId(var1);
      }

      if (var4 == null) {
         throw new FacebookException("Facebook App ID cannot be determined");
      }

      String var5 = var4 + "/custom_audience_third_party_id";
      AttributionIdentifiers var6 = AttributionIdentifiers.getAttributionIdentifiers(var1);
      Bundle var8 = new Bundle();
      if (var0 == null) {
         if (var6 == null) {
            throw new FacebookException("There is no access token and attribution identifiers could not be retrieved");
         }

         if (var6.getAttributionId() != null) {
            var2 = var6.getAttributionId();
         } else {
            var2 = var6.getAndroidAdvertiserId();
         }

         if (var6.getAttributionId() != null) {
            var8.putString("udid", var2);
         }
      }

      if (FacebookSdk.getLimitEventAndDataUsage(var1) || var6 != null && var6.isTrackingLimited()) {
         var8.putString("limit_event_usage", "1");
      }

      return new GraphRequest(var0, var5, var8, HttpMethod.GET, var3);
   }

   public static GraphRequest newDeleteObjectRequest(AccessToken var0, String var1, GraphRequest.Callback var2) {
      return new GraphRequest(var0, var1, null, HttpMethod.DELETE, var2);
   }

   public static GraphRequest newGraphPathRequest(AccessToken var0, String var1, GraphRequest.Callback var2) {
      return new GraphRequest(var0, var1, null, null, var2);
   }

   public static GraphRequest newMeRequest(AccessToken var0, GraphRequest.GraphJSONObjectCallback var1) {
      return new GraphRequest(var0, "me", null, null, new GraphRequest.Callback(var1) {
         final GraphRequest.GraphJSONObjectCallback val$callback;

         {
            this.val$callback = var1;
         }

         @Override
         public void onCompleted(GraphResponse var1) {
            if (this.val$callback != null) {
               this.val$callback.onCompleted(var1.getJSONObject(), var1);
            }
         }
      });
   }

   public static GraphRequest newMyFriendsRequest(AccessToken var0, GraphRequest.GraphJSONArrayCallback var1) {
      return new GraphRequest(var0, "me/friends", null, null, new GraphRequest.Callback(var1) {
         final GraphRequest.GraphJSONArrayCallback val$callback;

         {
            this.val$callback = var1;
         }

         @Override
         public void onCompleted(GraphResponse var1) {
            if (this.val$callback != null) {
               JSONObject var2 = var1.getJSONObject();
               JSONArray var3;
               if (var2 != null) {
                  var3 = var2.optJSONArray("data");
               } else {
                  var3 = null;
               }

               this.val$callback.onCompleted(var3, var1);
            }
         }
      });
   }

   public static GraphRequest newPlacesSearchRequest(AccessToken var0, Location var1, int var2, int var3, String var4, GraphRequest.GraphJSONArrayCallback var5) {
      if (var1 == null && Utility.isNullOrEmpty(var4)) {
         throw new FacebookException("Either location or searchText must be specified.");
      }

      Bundle var6 = new Bundle(5);
      var6.putString("type", "place");
      var6.putInt("limit", var3);
      if (var1 != null) {
         var6.putString("center", String.format(Locale.US, "%f,%f", var1.getLatitude(), var1.getLongitude()));
         var6.putInt("distance", var2);
      }

      if (!Utility.isNullOrEmpty(var4)) {
         var6.putString("q", var4);
      }

      GraphRequest.Callback var7 = new GraphRequest.Callback(var5) {
         final GraphRequest.GraphJSONArrayCallback val$callback;

         {
            this.val$callback = var1;
         }

         @Override
         public void onCompleted(GraphResponse var1) {
            if (this.val$callback != null) {
               JSONObject var2x = var1.getJSONObject();
               JSONArray var3x;
               if (var2x != null) {
                  var3x = var2x.optJSONArray("data");
               } else {
                  var3x = null;
               }

               this.val$callback.onCompleted(var3x, var1);
            }
         }
      };
      return new GraphRequest(var0, "search", var6, HttpMethod.GET, var7);
   }

   public static GraphRequest newPostRequest(AccessToken var0, String var1, JSONObject var2, GraphRequest.Callback var3) {
      GraphRequest var4 = new GraphRequest(var0, var1, null, HttpMethod.POST, var3);
      var4.setGraphObject(var2);
      return var4;
   }

   public static GraphRequest newUploadPhotoRequest(AccessToken var0, String var1, Bitmap var2, String var3, Bundle var4, GraphRequest.Callback var5) {
      String var6 = getDefaultPhotoPathIfNull(var1);
      Bundle var7 = new Bundle();
      if (var4 != null) {
         var7.putAll(var4);
      }

      var7.putParcelable("picture", var2);
      if (var3 != null && !var3.isEmpty()) {
         var7.putString("caption", var3);
      }

      return new GraphRequest(var0, var6, var7, HttpMethod.POST, var5);
   }

   public static GraphRequest newUploadPhotoRequest(AccessToken var0, String var1, Uri var2, String var3, Bundle var4, GraphRequest.Callback var5) throws FileNotFoundException {
      String var6 = getDefaultPhotoPathIfNull(var1);
      GraphRequest var7;
      if (Utility.isFileUri(var2)) {
         var7 = newUploadPhotoRequest(var0, var6, new File(var2.getPath()), var3, var4, var5);
      } else {
         if (!Utility.isContentUri(var2)) {
            throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
         }

         Bundle var8 = new Bundle();
         if (var4 != null) {
            var8.putAll(var4);
         }

         var8.putParcelable("picture", var2);
         if (var3 != null && !var3.isEmpty()) {
            var8.putString("caption", var3);
         }

         var7 = new GraphRequest(var0, var6, var8, HttpMethod.POST, var5);
      }

      return var7;
   }

   public static GraphRequest newUploadPhotoRequest(AccessToken var0, String var1, File var2, String var3, Bundle var4, GraphRequest.Callback var5) throws FileNotFoundException {
      var1 = getDefaultPhotoPathIfNull(var1);
      ParcelFileDescriptor var8 = ParcelFileDescriptor.open(var2, 268435456);
      Bundle var6 = new Bundle();
      if (var4 != null) {
         var6.putAll(var4);
      }

      var6.putParcelable("picture", var8);
      if (var3 != null && !var3.isEmpty()) {
         var6.putString("caption", var3);
      }

      return new GraphRequest(var0, var1, var6, HttpMethod.POST, var5);
   }

   private static String parameterToString(Object var0) {
      if (var0 instanceof String) {
         var0 = var0;
      } else if (!(var0 instanceof Boolean) && !(var0 instanceof Number)) {
         if (!(var0 instanceof Date)) {
            throw new IllegalArgumentException("Unsupported parameter type.");
         }

         var0 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(var0);
      } else {
         var0 = var0.toString();
      }

      return var0;
   }

   private static void processGraphObject(JSONObject var0, String var1, GraphRequest.KeyValueSerializer var2) throws IOException {
      boolean var9;
      if (isMeRequest(var1)) {
         var9 = var1.indexOf(":");
         int var4 = var1.indexOf("?");
         if (var9 <= 3 || var4 != -1 && var9 >= var4) {
            var9 = 0;
         } else {
            var9 = 1;
         }
      } else {
         var9 = 0;
      }

      Iterator var7 = var0.keys();

      while (var7.hasNext()) {
         var1 = (String)var7.next();
         Object var6 = var0.opt(var1);
         boolean var5;
         if (var9 && var1.equalsIgnoreCase("image")) {
            var5 = true;
         } else {
            var5 = false;
         }

         processGraphObjectProperty(var1, var6, var2, var5);
      }
   }

   private static void processGraphObjectProperty(String var0, Object var1, GraphRequest.KeyValueSerializer var2, boolean var3) throws IOException {
      Class var6 = var1.getClass();
      if (JSONObject.class.isAssignableFrom(var6)) {
         JSONObject var8 = (JSONObject)var1;
         if (var3) {
            Iterator var11 = var8.keys();

            while (var11.hasNext()) {
               String var7 = (String)var11.next();
               processGraphObjectProperty(String.format("%s[%s]", var0, var7), var8.opt(var7), var2, var3);
            }
         } else if (var8.has("id")) {
            processGraphObjectProperty(var0, var8.optString("id"), var2, var3);
         } else if (var8.has("url")) {
            processGraphObjectProperty(var0, var8.optString("url"), var2, var3);
         } else if (var8.has("fbsdk:create_object")) {
            processGraphObjectProperty(var0, var8.toString(), var2, var3);
         }
      } else if (JSONArray.class.isAssignableFrom(var6)) {
         JSONArray var9 = (JSONArray)var1;
         int var5 = var9.length();

         for (int var4 = 0; var4 < var5; var4++) {
            processGraphObjectProperty(String.format(Locale.ROOT, "%s[%d]", var0, var4), var9.opt(var4), var2, var3);
         }
      } else if (String.class.isAssignableFrom(var6) || Number.class.isAssignableFrom(var6) || Boolean.class.isAssignableFrom(var6)) {
         var2.writeString(var0, var1.toString());
      } else if (Date.class.isAssignableFrom(var6)) {
         Date var10 = (Date)var1;
         var2.writeString(var0, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(var10));
      }
   }

   private static void processRequest(GraphRequestBatch var0, Logger var1, int var2, URL var3, OutputStream var4, boolean var5) throws IOException, JSONException {
      GraphRequest.Serializer var13 = new GraphRequest.Serializer(var4, var1, var5);
      if (var2 == 1) {
         GraphRequest var6 = var0.get(0);
         HashMap var10 = new HashMap();

         for (String var9 : var6.parameters.keySet()) {
            Object var7 = var6.parameters.get(var9);
            if (isSupportedAttachmentType(var7)) {
               var10.put(var9, new GraphRequest.Attachment(var6, var7));
            }
         }

         if (var1 != null) {
            var1.append("  Parameters:\n");
         }

         serializeParameters(var6.parameters, var13, var6);
         if (var1 != null) {
            var1.append("  Attachments:\n");
         }

         serializeAttachments(var10, var13);
         if (var6.graphObject != null) {
            processGraphObject(var6.graphObject, var3.getPath(), var13);
         }
      } else {
         String var11 = getBatchAppId(var0);
         if (Utility.isNullOrEmpty(var11)) {
            throw new FacebookException("App ID was not specified at the request or Settings.");
         }

         var13.writeString("batch_app_id", var11);
         HashMap var12 = new HashMap();
         serializeRequestsAsJSON(var13, var0, var12);
         if (var1 != null) {
            var1.append("  Attachments:\n");
         }

         serializeAttachments(var12, var13);
      }
   }

   static void runCallbacks(GraphRequestBatch var0, List<GraphResponse> var1) {
      int var3 = var0.size();
      ArrayList var4 = new ArrayList();

      for (int var2 = 0; var2 < var3; var2++) {
         GraphRequest var5 = var0.get(var2);
         if (var5.callback != null) {
            var4.add(new Pair(var5.callback, var1.get(var2)));
         }
      }

      if (var4.size() > 0) {
         Runnable var7 = new Runnable(var4, var0) {
            final ArrayList val$callbacks;
            final GraphRequestBatch val$requests;

            {
               this.val$callbacks = var1;
               this.val$requests = var2;
            }

            @Override
            public void run() {
               for (Pair var1x : this.val$callbacks) {
                  ((GraphRequest.Callback)var1x.first).onCompleted((GraphResponse)var1x.second);
               }

               Iterator var3x = this.val$requests.getCallbacks().iterator();

               while (var3x.hasNext()) {
                  ((GraphRequestBatch.Callback)var3x.next()).onBatchCompleted(this.val$requests);
               }
            }
         };
         Handler var6 = var0.getCallbackHandler();
         if (var6 == null) {
            var7.run();
         } else {
            var6.post(var7);
         }
      }
   }

   private static void serializeAttachments(Map<String, GraphRequest.Attachment> var0, GraphRequest.Serializer var1) throws IOException {
      for (String var4 : var0.keySet()) {
         GraphRequest.Attachment var3 = (GraphRequest.Attachment)var0.get(var4);
         if (isSupportedAttachmentType(var3.getValue())) {
            var1.writeObject(var4, var3.getValue(), var3.getRequest());
         }
      }
   }

   private static void serializeParameters(Bundle var0, GraphRequest.Serializer var1, GraphRequest var2) throws IOException {
      for (String var4 : var0.keySet()) {
         Object var5 = var0.get(var4);
         if (isSupportedParameterType(var5)) {
            var1.writeObject(var4, var5, var2);
         }
      }
   }

   private static void serializeRequestsAsJSON(GraphRequest.Serializer var0, Collection<GraphRequest> var1, Map<String, GraphRequest.Attachment> var2) throws JSONException, IOException {
      JSONArray var3 = new JSONArray();
      Iterator var4 = var1.iterator();

      while (var4.hasNext()) {
         ((GraphRequest)var4.next()).serializeToBatch(var3, var2);
      }

      var0.writeRequestsAsJson("batch", var3, var1);
   }

   private void serializeToBatch(JSONArray var1, Map<String, GraphRequest.Attachment> var2) throws JSONException, IOException {
      JSONObject var3 = new JSONObject();
      if (this.batchEntryName != null) {
         var3.put("name", this.batchEntryName);
         var3.put("omit_response_on_success", this.batchEntryOmitResultOnSuccess);
      }

      if (this.batchEntryDependsOn != null) {
         var3.put("depends_on", this.batchEntryDependsOn);
      }

      String var4 = this.getRelativeUrlForBatchedRequest();
      var3.put("relative_url", var4);
      var3.put("method", this.httpMethod);
      if (this.accessToken != null) {
         Logger.registerAccessToken(this.accessToken.getToken());
      }

      ArrayList var6 = new ArrayList();

      for (String var7 : this.parameters.keySet()) {
         Object var8 = this.parameters.get(var7);
         if (isSupportedAttachmentType(var8)) {
            var7 = String.format(Locale.ROOT, "%s%d", "file", var2.size());
            var6.add(var7);
            var2.put(var7, new GraphRequest.Attachment(this, var8));
         }
      }

      if (!var6.isEmpty()) {
         var3.put("attached_files", TextUtils.join(",", var6));
      }

      if (this.graphObject != null) {
         ArrayList var9 = new ArrayList();
         processGraphObject(this.graphObject, var4, new GraphRequest.KeyValueSerializer(this, var9) {
            final GraphRequest this$0;
            final ArrayList val$keysAndValues;

            {
               this.this$0 = var1;
               this.val$keysAndValues = var2x;
            }

            @Override
            public void writeString(String var1, String var2x) throws IOException {
               this.val$keysAndValues.add(String.format(Locale.US, "%s=%s", var1, URLEncoder.encode(var2x, "UTF-8")));
            }
         });
         var3.put("body", TextUtils.join("&", var9));
      }

      var1.put(var3);
   }

   static final void serializeToUrlConnection(GraphRequestBatch param0, HttpURLConnection param1) throws IOException, JSONException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 000: new com/facebook/internal/Logger
      // 003: dup
      // 004: getstatic com/facebook/LoggingBehavior.REQUESTS Lcom/facebook/LoggingBehavior;
      // 007: ldc_w "Request"
      // 00a: invokespecial com/facebook/internal/Logger.<init> (Lcom/facebook/LoggingBehavior;Ljava/lang/String;)V
      // 00d: astore 7
      // 00f: aload 0
      // 010: invokevirtual com/facebook/GraphRequestBatch.size ()I
      // 013: istore 3
      // 014: aload 0
      // 015: invokestatic com/facebook/GraphRequest.isGzipCompressible (Lcom/facebook/GraphRequestBatch;)Z
      // 018: istore 4
      // 01a: iload 3
      // 01b: bipush 1
      // 01c: if_icmpne 0a6
      // 01f: aload 0
      // 020: bipush 0
      // 021: invokevirtual com/facebook/GraphRequestBatch.get (I)Lcom/facebook/GraphRequest;
      // 024: getfield com/facebook/GraphRequest.httpMethod Lcom/facebook/HttpMethod;
      // 027: astore 5
      // 029: aload 1
      // 02a: aload 5
      // 02c: invokevirtual com/facebook/HttpMethod.name ()Ljava/lang/String;
      // 02f: invokevirtual java/net/HttpURLConnection.setRequestMethod (Ljava/lang/String;)V
      // 032: aload 1
      // 033: iload 4
      // 035: invokestatic com/facebook/GraphRequest.setConnectionContentType (Ljava/net/HttpURLConnection;Z)V
      // 038: aload 1
      // 039: invokevirtual java/net/HttpURLConnection.getURL ()Ljava/net/URL;
      // 03c: astore 8
      // 03e: aload 7
      // 040: ldc_w "Request:\n"
      // 043: invokevirtual com/facebook/internal/Logger.append (Ljava/lang/String;)V
      // 046: aload 7
      // 048: ldc_w "Id"
      // 04b: aload 0
      // 04c: invokevirtual com/facebook/GraphRequestBatch.getId ()Ljava/lang/String;
      // 04f: invokevirtual com/facebook/internal/Logger.appendKeyValue (Ljava/lang/String;Ljava/lang/Object;)V
      // 052: aload 7
      // 054: ldc_w "URL"
      // 057: aload 8
      // 059: invokevirtual com/facebook/internal/Logger.appendKeyValue (Ljava/lang/String;Ljava/lang/Object;)V
      // 05c: aload 7
      // 05e: ldc_w "Method"
      // 061: aload 1
      // 062: invokevirtual java/net/HttpURLConnection.getRequestMethod ()Ljava/lang/String;
      // 065: invokevirtual com/facebook/internal/Logger.appendKeyValue (Ljava/lang/String;Ljava/lang/Object;)V
      // 068: aload 7
      // 06a: ldc "User-Agent"
      // 06c: aload 1
      // 06d: ldc "User-Agent"
      // 06f: invokevirtual java/net/HttpURLConnection.getRequestProperty (Ljava/lang/String;)Ljava/lang/String;
      // 072: invokevirtual com/facebook/internal/Logger.appendKeyValue (Ljava/lang/String;Ljava/lang/Object;)V
      // 075: aload 7
      // 077: ldc "Content-Type"
      // 079: aload 1
      // 07a: ldc "Content-Type"
      // 07c: invokevirtual java/net/HttpURLConnection.getRequestProperty (Ljava/lang/String;)Ljava/lang/String;
      // 07f: invokevirtual com/facebook/internal/Logger.appendKeyValue (Ljava/lang/String;Ljava/lang/Object;)V
      // 082: aload 1
      // 083: aload 0
      // 084: invokevirtual com/facebook/GraphRequestBatch.getTimeout ()I
      // 087: invokevirtual java/net/HttpURLConnection.setConnectTimeout (I)V
      // 08a: aload 1
      // 08b: aload 0
      // 08c: invokevirtual com/facebook/GraphRequestBatch.getTimeout ()I
      // 08f: invokevirtual java/net/HttpURLConnection.setReadTimeout (I)V
      // 092: aload 5
      // 094: getstatic com/facebook/HttpMethod.POST Lcom/facebook/HttpMethod;
      // 097: if_acmpne 0ae
      // 09a: bipush 1
      // 09b: istore 2
      // 09c: iload 2
      // 09d: ifne 0b3
      // 0a0: aload 7
      // 0a2: invokevirtual com/facebook/internal/Logger.log ()V
      // 0a5: return
      // 0a6: getstatic com/facebook/HttpMethod.POST Lcom/facebook/HttpMethod;
      // 0a9: astore 5
      // 0ab: goto 029
      // 0ae: bipush 0
      // 0af: istore 2
      // 0b0: goto 09c
      // 0b3: aload 1
      // 0b4: bipush 1
      // 0b5: invokevirtual java/net/HttpURLConnection.setDoOutput (Z)V
      // 0b8: new java/io/BufferedOutputStream
      // 0bb: astore 6
      // 0bd: aload 6
      // 0bf: aload 1
      // 0c0: invokevirtual java/net/HttpURLConnection.getOutputStream ()Ljava/io/OutputStream;
      // 0c3: invokespecial java/io/BufferedOutputStream.<init> (Ljava/io/OutputStream;)V
      // 0c6: aload 6
      // 0c8: astore 1
      // 0c9: iload 4
      // 0cb: ifeq 0e0
      // 0ce: aload 6
      // 0d0: astore 5
      // 0d2: new java/util/zip/GZIPOutputStream
      // 0d5: astore 1
      // 0d6: aload 6
      // 0d8: astore 5
      // 0da: aload 1
      // 0db: aload 6
      // 0dd: invokespecial java/util/zip/GZIPOutputStream.<init> (Ljava/io/OutputStream;)V
      // 0e0: aload 1
      // 0e1: astore 5
      // 0e3: aload 0
      // 0e4: invokestatic com/facebook/GraphRequest.hasOnProgressCallbacks (Lcom/facebook/GraphRequestBatch;)Z
      // 0e7: ifeq 170
      // 0ea: aload 1
      // 0eb: astore 5
      // 0ed: new com/facebook/ProgressNoopOutputStream
      // 0f0: astore 6
      // 0f2: aload 1
      // 0f3: astore 5
      // 0f5: aload 6
      // 0f7: aload 0
      // 0f8: invokevirtual com/facebook/GraphRequestBatch.getCallbackHandler ()Landroid/os/Handler;
      // 0fb: invokespecial com/facebook/ProgressNoopOutputStream.<init> (Landroid/os/Handler;)V
      // 0fe: aload 1
      // 0ff: astore 5
      // 101: aload 0
      // 102: aconst_null
      // 103: iload 3
      // 104: aload 8
      // 106: aload 6
      // 108: iload 4
      // 10a: invokestatic com/facebook/GraphRequest.processRequest (Lcom/facebook/GraphRequestBatch;Lcom/facebook/internal/Logger;ILjava/net/URL;Ljava/io/OutputStream;Z)V
      // 10d: aload 1
      // 10e: astore 5
      // 110: aload 6
      // 112: invokevirtual com/facebook/ProgressNoopOutputStream.getMaxProgress ()I
      // 115: istore 2
      // 116: aload 1
      // 117: astore 5
      // 119: aload 6
      // 11b: invokevirtual com/facebook/ProgressNoopOutputStream.getProgressMap ()Ljava/util/Map;
      // 11e: astore 9
      // 120: aload 1
      // 121: astore 5
      // 123: new com/facebook/ProgressOutputStream
      // 126: astore 6
      // 128: aload 1
      // 129: astore 5
      // 12b: aload 6
      // 12d: aload 1
      // 12e: aload 0
      // 12f: aload 9
      // 131: iload 2
      // 132: i2l
      // 133: invokespecial com/facebook/ProgressOutputStream.<init> (Ljava/io/OutputStream;Lcom/facebook/GraphRequestBatch;Ljava/util/Map;J)V
      // 136: aload 6
      // 138: astore 1
      // 139: aload 0
      // 13a: aload 7
      // 13c: iload 3
      // 13d: aload 8
      // 13f: aload 1
      // 140: iload 4
      // 142: invokestatic com/facebook/GraphRequest.processRequest (Lcom/facebook/GraphRequestBatch;Lcom/facebook/internal/Logger;ILjava/net/URL;Ljava/io/OutputStream;Z)V
      // 145: aload 1
      // 146: ifnull 14d
      // 149: aload 1
      // 14a: invokevirtual java/io/OutputStream.close ()V
      // 14d: aload 7
      // 14f: invokevirtual com/facebook/internal/Logger.log ()V
      // 152: goto 0a5
      // 155: astore 0
      // 156: aconst_null
      // 157: astore 5
      // 159: aload 5
      // 15b: ifnull 163
      // 15e: aload 5
      // 160: invokevirtual java/io/OutputStream.close ()V
      // 163: aload 0
      // 164: athrow
      // 165: astore 0
      // 166: goto 159
      // 169: astore 0
      // 16a: aload 1
      // 16b: astore 5
      // 16d: goto 159
      // 170: goto 139
      // try (86 -> 92): 168 null
      // try (98 -> 100): 177 null
      // try (102 -> 105): 177 null
      // try (107 -> 110): 177 null
      // try (112 -> 114): 177 null
      // try (116 -> 120): 177 null
      // try (122 -> 129): 177 null
      // try (131 -> 134): 177 null
      // try (136 -> 139): 177 null
      // try (141 -> 143): 177 null
      // try (145 -> 152): 177 null
      // try (154 -> 161): 179 null
   }

   private static void setConnectionContentType(HttpURLConnection var0, boolean var1) {
      if (var1) {
         var0.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         var0.setRequestProperty("Content-Encoding", "gzip");
      } else {
         var0.setRequestProperty("Content-Type", getMimeContentType());
      }
   }

   public static final void setDefaultBatchApplicationId(String var0) {
      defaultBatchApplicationId = var0;
   }

   static final boolean shouldWarnOnMissingFieldsParam(GraphRequest var0) {
      boolean var1 = true;
      String var2 = var0.getVersion();
      if (!Utility.isNullOrEmpty(var2)) {
         String var3 = var2;
         if (var2.startsWith("v")) {
            var3 = var2.substring(1);
         }

         String[] var4 = var3.split("\\.");
         if ((var4.length < 2 || Integer.parseInt(var4[0]) <= 2) && (Integer.parseInt(var4[0]) < 2 || Integer.parseInt(var4[1]) < 4)) {
            var1 = false;
         } else {
            var1 = true;
         }
      }

      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static HttpURLConnection toHttpConnection(GraphRequestBatch var0) {
      validateFieldsParamForGetRequests(var0);

      URL var3;
      label41: {
         try {
            if (var0.size() == 1) {
               var3 = new URL(var0.get(0).getUrlForSingleRequest());
               break label41;
            }
         } catch (MalformedURLException var9) {
            throw new FacebookException("could not construct URL for request", var9);
         }

         try {
            var3 = new URL(ServerProtocol.getGraphUrlBase());
         } catch (MalformedURLException var6) {
            throw new FacebookException("could not construct URL for request", var6);
         }
      }

      HttpURLConnection var1 = null;
      Object var2 = null;

      label45: {
         try {
            var12 = createConnection(var3);
         } catch (IOException var7) {
            var10 = var7;
            break label45;
         } catch (JSONException var8) {
            var10 = var8;
            var1 = (HttpURLConnection)var2;
            break label45;
         }

         var2 = var12;
         var1 = var12;

         try {
            serializeToUrlConnection(var0, var12);
            return var12;
         } catch (IOException var4) {
            var10 = var4;
         } catch (JSONException var5) {
            var10 = var5;
            var1 = (HttpURLConnection)var2;
         }
      }

      Utility.disconnectQuietly(var1);
      throw new FacebookException("could not construct request body", (Throwable)var10);
   }

   public static HttpURLConnection toHttpConnection(Collection<GraphRequest> var0) {
      Validate.notEmptyAndContainsNoNulls(var0, "requests");
      return toHttpConnection(new GraphRequestBatch(var0));
   }

   public static HttpURLConnection toHttpConnection(GraphRequest... var0) {
      return toHttpConnection(Arrays.asList(var0));
   }

   static final void validateFieldsParamForGetRequests(GraphRequestBatch var0) {
      for (GraphRequest var1 : var0) {
         if (HttpMethod.GET.equals(var1.getHttpMethod()) && shouldWarnOnMissingFieldsParam(var1)) {
            Bundle var3 = var1.getParameters();
            if (!var3.containsKey("fields") || Utility.isNullOrEmpty(var3.getString("fields"))) {
               Logger.log(
                  LoggingBehavior.DEVELOPER_ERRORS,
                  5,
                  "Request",
                  "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.",
                  var1.getGraphPath()
               );
            }
         }
      }
   }

   public final GraphResponse executeAndWait() {
      return executeAndWait(this);
   }

   public final GraphRequestAsyncTask executeAsync() {
      return executeBatchAsync(this);
   }

   public final AccessToken getAccessToken() {
      return this.accessToken;
   }

   public final String getBatchEntryDependsOn() {
      return this.batchEntryDependsOn;
   }

   public final String getBatchEntryName() {
      return this.batchEntryName;
   }

   public final boolean getBatchEntryOmitResultOnSuccess() {
      return this.batchEntryOmitResultOnSuccess;
   }

   public final GraphRequest.Callback getCallback() {
      return this.callback;
   }

   public final JSONObject getGraphObject() {
      return this.graphObject;
   }

   public final String getGraphPath() {
      return this.graphPath;
   }

   public final HttpMethod getHttpMethod() {
      return this.httpMethod;
   }

   public final Bundle getParameters() {
      return this.parameters;
   }

   final String getRelativeUrlForBatchedRequest() {
      if (this.overriddenURL != null) {
         throw new FacebookException("Can't override URL for a batch request");
      }

      String var1 = String.format("%s/%s", ServerProtocol.getGraphUrlBase(), this.getGraphPathWithVersion());
      this.addCommonParameters();
      Uri var2 = Uri.parse(this.appendParametersToBaseUrl(var1));
      return String.format("%s?%s", var2.getPath(), var2.getQuery());
   }

   public final Object getTag() {
      return this.tag;
   }

   final String getUrlForSingleRequest() {
      String var1;
      if (this.overriddenURL != null) {
         var1 = this.overriddenURL.toString();
      } else {
         if (this.getHttpMethod() == HttpMethod.POST && this.graphPath != null && this.graphPath.endsWith("/videos")) {
            var1 = ServerProtocol.getGraphVideoUrlBase();
         } else {
            var1 = ServerProtocol.getGraphUrlBase();
         }

         var1 = String.format("%s/%s", var1, this.getGraphPathWithVersion());
         this.addCommonParameters();
         var1 = this.appendParametersToBaseUrl(var1);
      }

      return var1;
   }

   public final String getVersion() {
      return this.version;
   }

   public final void setAccessToken(AccessToken var1) {
      this.accessToken = var1;
   }

   public final void setBatchEntryDependsOn(String var1) {
      this.batchEntryDependsOn = var1;
   }

   public final void setBatchEntryName(String var1) {
      this.batchEntryName = var1;
   }

   public final void setBatchEntryOmitResultOnSuccess(boolean var1) {
      this.batchEntryOmitResultOnSuccess = var1;
   }

   public final void setCallback(GraphRequest.Callback var1) {
      if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)
         && !FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
         this.callback = var1;
      } else {
         this.callback = new GraphRequest.Callback(this, var1) {
            final GraphRequest this$0;
            final GraphRequest.Callback val$callback;

            {
               this.this$0 = var1;
               this.val$callback = var2;
            }

            @Override
            public void onCompleted(GraphResponse var1) {
               JSONObject var3 = var1.getJSONObject();
               if (var3 != null) {
                  var3 = var3.optJSONObject("__debug__");
               } else {
                  var3 = null;
               }

               JSONArray var4;
               if (var3 != null) {
                  var4 = var3.optJSONArray("messages");
               } else {
                  var4 = null;
               }

               if (var4 != null) {
                  for (int var2 = 0; var2 < var4.length(); var2++) {
                     JSONObject var6 = var4.optJSONObject(var2);
                     String var9;
                     if (var6 != null) {
                        var9 = var6.optString("message");
                     } else {
                        var9 = null;
                     }

                     String var5;
                     if (var6 != null) {
                        var5 = var6.optString("type");
                     } else {
                        var5 = null;
                     }

                     String var11;
                     if (var6 != null) {
                        var11 = var6.optString("link");
                     } else {
                        var11 = null;
                     }

                     if (var9 != null && var5 != null) {
                        LoggingBehavior var7 = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                        if (var5.equals("warning")) {
                           var7 = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                        }

                        var5 = var9;
                        if (!Utility.isNullOrEmpty(var11)) {
                           var5 = var9 + " Link: " + var11;
                        }

                        Logger.log(var7, GraphRequest.TAG, var5);
                     }
                  }
               }

               if (this.val$callback != null) {
                  this.val$callback.onCompleted(var1);
               }
            }
         };
      }
   }

   public final void setGraphObject(JSONObject var1) {
      this.graphObject = var1;
   }

   public final void setGraphPath(String var1) {
      this.graphPath = var1;
   }

   public final void setHttpMethod(HttpMethod var1) {
      if (this.overriddenURL != null && var1 != HttpMethod.GET) {
         throw new FacebookException("Can't change HTTP method on request with overridden URL.");
      }

      if (var1 == null) {
         var1 = HttpMethod.GET;
      }

      this.httpMethod = var1;
   }

   public final void setParameters(Bundle var1) {
      this.parameters = var1;
   }

   public final void setSkipClientToken(boolean var1) {
      this.skipClientToken = var1;
   }

   public final void setTag(Object var1) {
      this.tag = var1;
   }

   public final void setVersion(String var1) {
      this.version = var1;
   }

   @Override
   public String toString() {
      StringBuilder var2 = new StringBuilder().append("{Request: ").append(" accessToken: ");
      Object var1;
      if (this.accessToken == null) {
         var1 = "null";
      } else {
         var1 = this.accessToken;
      }

      return var2.append(var1)
         .append(", graphPath: ")
         .append(this.graphPath)
         .append(", graphObject: ")
         .append(this.graphObject)
         .append(", httpMethod: ")
         .append(this.httpMethod)
         .append(", parameters: ")
         .append(this.parameters)
         .append("}")
         .toString();
   }

   private static class Attachment {
      private final GraphRequest request;
      private final Object value;

      public Attachment(GraphRequest var1, Object var2) {
         this.request = var1;
         this.value = var2;
      }

      public GraphRequest getRequest() {
         return this.request;
      }

      public Object getValue() {
         return this.value;
      }
   }

   public interface Callback {
      void onCompleted(GraphResponse var1);
   }

   public interface GraphJSONArrayCallback {
      void onCompleted(JSONArray var1, GraphResponse var2);
   }

   public interface GraphJSONObjectCallback {
      void onCompleted(JSONObject var1, GraphResponse var2);
   }

   private interface KeyValueSerializer {
      void writeString(String var1, String var2) throws IOException;
   }

   public interface OnProgressCallback extends GraphRequest.Callback {
      void onProgress(long var1, long var3);
   }

   public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
      public static final Creator<GraphRequest.ParcelableResourceWithMimeType> CREATOR = new Creator<GraphRequest.ParcelableResourceWithMimeType>() {
         public GraphRequest.ParcelableResourceWithMimeType createFromParcel(Parcel var1) {
            return new GraphRequest.ParcelableResourceWithMimeType(var1);
         }

         public GraphRequest.ParcelableResourceWithMimeType[] newArray(int var1) {
            return new GraphRequest.ParcelableResourceWithMimeType[var1];
         }
      };
      private final String mimeType;
      private final RESOURCE resource;

      private ParcelableResourceWithMimeType(Parcel var1) {
         this.mimeType = var1.readString();
         this.resource = (RESOURCE)var1.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
      }

      public ParcelableResourceWithMimeType(RESOURCE var1, String var2) {
         this.mimeType = var2;
         this.resource = (RESOURCE)var1;
      }

      public int describeContents() {
         return 1;
      }

      public String getMimeType() {
         return this.mimeType;
      }

      public RESOURCE getResource() {
         return this.resource;
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeString(this.mimeType);
         var1.writeParcelable(this.resource, var2);
      }
   }

   private static class Serializer implements GraphRequest.KeyValueSerializer {
      private boolean firstWrite = true;
      private final Logger logger;
      private final OutputStream outputStream;
      private boolean useUrlEncode = false;

      public Serializer(OutputStream var1, Logger var2, boolean var3) {
         this.outputStream = var1;
         this.logger = var2;
         this.useUrlEncode = var3;
      }

      private RuntimeException getInvalidTypeError() {
         return new IllegalArgumentException("value is not a supported type.");
      }

      public void write(String var1, Object... var2) throws IOException {
         if (!this.useUrlEncode) {
            if (this.firstWrite) {
               this.outputStream.write("--".getBytes());
               this.outputStream.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
               this.outputStream.write("\r\n".getBytes());
               this.firstWrite = false;
            }

            this.outputStream.write(String.format(var1, var2).getBytes());
         } else {
            this.outputStream.write(URLEncoder.encode(String.format(Locale.US, var1, var2), "UTF-8").getBytes());
         }
      }

      public void writeBitmap(String var1, Bitmap var2) throws IOException {
         this.writeContentDisposition(var1, var1, "image/png");
         var2.compress(CompressFormat.PNG, 100, this.outputStream);
         this.writeLine("");
         this.writeRecordBoundary();
         if (this.logger != null) {
            this.logger.appendKeyValue("    " + var1, "<Image>");
         }
      }

      public void writeBytes(String var1, byte[] var2) throws IOException {
         this.writeContentDisposition(var1, var1, "content/unknown");
         this.outputStream.write(var2);
         this.writeLine("");
         this.writeRecordBoundary();
         if (this.logger != null) {
            this.logger.appendKeyValue("    " + var1, String.format(Locale.ROOT, "<Data: %d>", var2.length));
         }
      }

      public void writeContentDisposition(String var1, String var2, String var3) throws IOException {
         if (!this.useUrlEncode) {
            this.write("Content-Disposition: form-data; name=\"%s\"", var1);
            if (var2 != null) {
               this.write("; filename=\"%s\"", var2);
            }

            this.writeLine("");
            if (var3 != null) {
               this.writeLine("%s: %s", "Content-Type", var3);
            }

            this.writeLine("");
         } else {
            this.outputStream.write(String.format("%s=", var1).getBytes());
         }
      }

      public void writeContentUri(String var1, Uri var2, String var3) throws IOException {
         String var7 = var3;
         if (var3 == null) {
            var7 = "content/unknown";
         }

         this.writeContentDisposition(var1, var1, var7);
         int var4;
         if (this.outputStream instanceof ProgressNoopOutputStream) {
            long var5 = Utility.getContentSize(var2);
            ((ProgressNoopOutputStream)this.outputStream).addProgress(var5);
            var4 = 0;
         } else {
            var4 = Utility.copyAndCloseInputStream(FacebookSdk.getApplicationContext().getContentResolver().openInputStream(var2), this.outputStream) + 0;
         }

         this.writeLine("");
         this.writeRecordBoundary();
         if (this.logger != null) {
            this.logger.appendKeyValue("    " + var1, String.format(Locale.ROOT, "<Data: %d>", var4));
         }
      }

      public void writeFile(String var1, ParcelFileDescriptor var2, String var3) throws IOException {
         String var5 = var3;
         if (var3 == null) {
            var5 = "content/unknown";
         }

         this.writeContentDisposition(var1, var1, var5);
         int var4;
         if (this.outputStream instanceof ProgressNoopOutputStream) {
            ((ProgressNoopOutputStream)this.outputStream).addProgress(var2.getStatSize());
            var4 = 0;
         } else {
            var4 = Utility.copyAndCloseInputStream(new AutoCloseInputStream(var2), this.outputStream) + 0;
         }

         this.writeLine("");
         this.writeRecordBoundary();
         if (this.logger != null) {
            this.logger.appendKeyValue("    " + var1, String.format(Locale.ROOT, "<Data: %d>", var4));
         }
      }

      public void writeLine(String var1, Object... var2) throws IOException {
         this.write(var1, var2);
         if (!this.useUrlEncode) {
            this.write("\r\n");
         }
      }

      public void writeObject(String var1, Object var2, GraphRequest var3) throws IOException {
         if (this.outputStream instanceof RequestOutputStream) {
            ((RequestOutputStream)this.outputStream).setCurrentRequest(var3);
         }

         if (GraphRequest.isSupportedParameterType(var2)) {
            this.writeString(var1, GraphRequest.parameterToString(var2));
         } else if (var2 instanceof Bitmap) {
            this.writeBitmap(var1, (Bitmap)var2);
         } else if (var2 instanceof byte[]) {
            this.writeBytes(var1, (byte[])var2);
         } else if (var2 instanceof Uri) {
            this.writeContentUri(var1, (Uri)var2, null);
         } else if (var2 instanceof ParcelFileDescriptor) {
            this.writeFile(var1, (ParcelFileDescriptor)var2, null);
         } else {
            if (!(var2 instanceof GraphRequest.ParcelableResourceWithMimeType)) {
               throw this.getInvalidTypeError();
            }

            GraphRequest.ParcelableResourceWithMimeType var5 = (GraphRequest.ParcelableResourceWithMimeType)var2;
            Parcelable var4 = var5.getResource();
            String var6 = var5.getMimeType();
            if (var4 instanceof ParcelFileDescriptor) {
               this.writeFile(var1, (ParcelFileDescriptor)var4, var6);
            } else {
               if (!(var4 instanceof Uri)) {
                  throw this.getInvalidTypeError();
               }

               this.writeContentUri(var1, (Uri)var4, var6);
            }
         }
      }

      public void writeRecordBoundary() throws IOException {
         if (!this.useUrlEncode) {
            this.writeLine("--%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
         } else {
            this.outputStream.write("&".getBytes());
         }
      }

      public void writeRequestsAsJson(String var1, JSONArray var2, Collection<GraphRequest> var3) throws IOException, JSONException {
         if (!(this.outputStream instanceof RequestOutputStream)) {
            this.writeString(var1, var2.toString());
         } else {
            RequestOutputStream var5 = (RequestOutputStream)this.outputStream;
            this.writeContentDisposition(var1, null, null);
            this.write("[");
            Iterator var6 = var3.iterator();

            for (int var4 = 0; var6.hasNext(); var4++) {
               GraphRequest var8 = (GraphRequest)var6.next();
               JSONObject var7 = var2.getJSONObject(var4);
               var5.setCurrentRequest(var8);
               if (var4 > 0) {
                  this.write(",%s", var7.toString());
               } else {
                  this.write("%s", var7.toString());
               }
            }

            this.write("]");
            if (this.logger != null) {
               this.logger.appendKeyValue("    " + var1, var2.toString());
            }
         }
      }

      @Override
      public void writeString(String var1, String var2) throws IOException {
         this.writeContentDisposition(var1, null, null);
         this.writeLine("%s", var2);
         this.writeRecordBoundary();
         if (this.logger != null) {
            this.logger.appendKeyValue("    " + var1, var2);
         }
      }
   }
}
