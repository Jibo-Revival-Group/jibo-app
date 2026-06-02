package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class Utility {
   public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
   private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
   private static final int GINGERBREAD_MR1 = 10;
   private static final String HASH_ALGORITHM_MD5 = "MD5";
   private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
   static final String LOG_TAG = "FacebookSDK";
   private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
   private static final String URL_SCHEME = "https";
   private static final String UTF8 = "UTF-8";
   private static long availableExternalStorageGB = -1L;
   private static String carrierName = "NoCarrier";
   private static String deviceTimeZoneName = "";
   private static String deviceTimezoneAbbreviation = "";
   private static final String noCarrierConstant = "NoCarrier";
   private static int numCPUCores = 0;
   private static long timestampOfLastCheck = -1L;
   private static long totalExternalStorageGB = -1L;

   public static <T> boolean areObjectsEqual(T var0, T var1) {
      boolean var2;
      if (var0 == null) {
         if (var1 == null) {
            var2 = true;
         } else {
            var2 = false;
         }
      } else {
         var2 = var0.equals(var1);
      }

      return var2;
   }

   public static <T> ArrayList<T> arrayList(T... var0) {
      ArrayList var3 = new ArrayList(var0.length);
      int var2 = var0.length;

      for (int var1 = 0; var1 < var2; var1++) {
         var3.add(var0[var1]);
      }

      return var3;
   }

   public static <T> List<T> asListNoNulls(T... var0) {
      ArrayList var3 = new ArrayList();

      for (Object var4 : var0) {
         if (var4 != null) {
            var3.add(var4);
         }
      }

      return var3;
   }

   public static JSONObject awaitGetGraphMeRequestWithCache(String var0) {
      JSONObject var1 = ProfileInformationCache.getProfileInformation(var0);
      JSONObject var2;
      if (var1 != null) {
         var2 = var1;
      } else {
         GraphResponse var3 = getGraphMeRequestWithCache(var0).executeAndWait();
         if (var3.getError() != null) {
            var2 = null;
         } else {
            var2 = var3.getJSONObject();
         }
      }

      return var2;
   }

   public static Uri buildUri(String var0, String var1, Bundle var2) {
      Builder var3 = new Builder();
      var3.scheme("https");
      var3.authority(var0);
      var3.path(var1);
      if (var2 != null) {
         for (String var6 : var2.keySet()) {
            Object var4 = var2.get(var6);
            if (var4 instanceof String) {
               var3.appendQueryParameter(var6, (String)var4);
            }
         }
      }

      return var3.build();
   }

   public static void clearCaches(Context var0) {
      ImageDownloader.clearCache(var0);
   }

   private static void clearCookiesForDomain(Context var0, String var1) {
      CookieSyncManager.createInstance(var0).sync();
      CookieManager var6 = CookieManager.getInstance();
      String var4 = var6.getCookie(var1);
      if (var4 != null) {
         String[] var5 = var4.split(";");
         int var3 = var5.length;

         for (int var2 = 0; var2 < var3; var2++) {
            String[] var7 = var5[var2].split("=");
            if (var7.length > 0) {
               var6.setCookie(var1, var7[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
            }
         }

         var6.removeExpiredCookie();
      }
   }

   public static void clearFacebookCookies(Context var0) {
      clearCookiesForDomain(var0, "facebook.com");
      clearCookiesForDomain(var0, ".facebook.com");
      clearCookiesForDomain(var0, "https://facebook.com");
      clearCookiesForDomain(var0, "https://.facebook.com");
   }

   public static void closeQuietly(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var1) {
         }
      }
   }

   public static String coerceValueIfNullOrEmpty(String var0, String var1) {
      if (!isNullOrEmpty(var0)) {
         var1 = var0;
      }

      return var1;
   }

   private static long convertBytesToGB(double var0) {
      return Math.round(var0 / 1.0737418E9F);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static Map<String, Object> convertJSONObjectToHashMap(JSONObject var0) {
      HashMap var5 = new HashMap();
      JSONArray var4 = var0.names();

      for (int var1 = 0; var1 < var4.length(); var1++) {
         Object var3;
         String var6;
         try {
            var6 = var4.getString(var1);
            var3 = var0.get(var6);
         } catch (JSONException var9) {
            continue;
         }

         Object var2 = var3;

         try {
            if (var3 instanceof JSONObject) {
               var2 = convertJSONObjectToHashMap((JSONObject)var3);
            }
         } catch (JSONException var8) {
            continue;
         }

         try {
            var5.put(var6, var2);
         } catch (JSONException var7) {
         }
      }

      return var5;
   }

   public static int copyAndCloseInputStream(InputStream param0, OutputStream param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1052)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:502)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: new java/io/BufferedInputStream
      // 05: astore 5
      // 07: aload 5
      // 09: aload 0
      // 0a: invokespecial java/io/BufferedInputStream.<init> (Ljava/io/InputStream;)V
      // 0d: sipush 8192
      // 10: newarray 8
      // 12: astore 4
      // 14: aload 5
      // 16: aload 4
      // 18: invokevirtual java/io/BufferedInputStream.read ([B)I
      // 1b: istore 3
      // 1c: iload 3
      // 1d: bipush -1
      // 1e: if_icmpeq 30
      // 21: aload 1
      // 22: aload 4
      // 24: bipush 0
      // 25: iload 3
      // 26: invokevirtual java/io/OutputStream.write ([BII)V
      // 29: iload 2
      // 2a: iload 3
      // 2b: iadd
      // 2c: istore 2
      // 2d: goto 14
      // 30: aload 5
      // 32: ifnull 3a
      // 35: aload 5
      // 37: invokevirtual java/io/BufferedInputStream.close ()V
      // 3a: aload 0
      // 3b: ifnull 42
      // 3e: aload 0
      // 3f: invokevirtual java/io/InputStream.close ()V
      // 42: iload 2
      // 43: ireturn
      // 44: astore 4
      // 46: aconst_null
      // 47: astore 1
      // 48: aload 1
      // 49: ifnull 50
      // 4c: aload 1
      // 4d: invokevirtual java/io/BufferedInputStream.close ()V
      // 50: aload 0
      // 51: ifnull 58
      // 54: aload 0
      // 55: invokevirtual java/io/InputStream.close ()V
      // 58: aload 4
      // 5a: athrow
      // 5b: astore 4
      // 5d: aload 5
      // 5f: astore 1
      // 60: goto 48
      // try (2 -> 7): 37 null
      // try (7 -> 10): 50 null
      // try (10 -> 14): 50 null
      // try (17 -> 22): 50 null
   }

   public static void deleteDirectory(File var0) {
      if (var0.exists()) {
         if (var0.isDirectory()) {
            File[] var3 = var0.listFiles();
            if (var3 != null) {
               int var2 = var3.length;

               for (int var1 = 0; var1 < var2; var1++) {
                  deleteDirectory(var3[var1]);
               }
            }
         }

         var0.delete();
      }
   }

   public static void disconnectQuietly(URLConnection var0) {
      if (var0 != null && var0 instanceof HttpURLConnection) {
         ((HttpURLConnection)var0).disconnect();
      }
   }

   private static boolean externalStorageExists() {
      return "mounted".equals(Environment.getExternalStorageState());
   }

   public static <T> List<T> filter(List<T> var0, Utility.Predicate<T> var1) {
      Object var3 = null;
      if (var0 == null) {
         var0 = (List)var3;
      } else {
         ArrayList var2 = new ArrayList();

         for (Object var6 : var0) {
            if (var1.apply(var6)) {
               var2.add(var6);
            }
         }

         var0 = (List)var3;
         if (var2.size() != 0) {
            var0 = var2;
         }
      }

      return var0;
   }

   public static String generateRandomString(int var0) {
      return new BigInteger(var0 * 5, new Random()).toString(32);
   }

   public static String getActivityName(Context var0) {
      String var1;
      if (var0 == null) {
         var1 = "null";
      } else if (var0 == var0.getApplicationContext()) {
         var1 = "unknown";
      } else {
         var1 = var0.getClass().getSimpleName();
      }

      return var1;
   }

   public static Date getBundleLongAsDate(Bundle var0, String var1, Date var2) {
      Date var6;
      if (var0 == null) {
         var6 = null;
      } else {
         Object var7 = var0.get(var1);
         long var3;
         if (var7 instanceof Long) {
            var3 = (Long)var7;
         } else {
            if (!(var7 instanceof String)) {
               var7 = null;
               return (Date)var7;
            }

            try {
               var3 = Long.parseLong((String)var7);
            } catch (NumberFormatException var5) {
               var7 = null;
               return (Date)var7;
            }
         }

         if (var3 == 0L) {
            var6 = new Date(Long.MAX_VALUE);
         } else {
            var6 = new Date(var3 * 1000L + var2.getTime());
         }
      }

      return var6;
   }

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static long getContentSize(Uri var0) {
      try {
         var12 = FacebookSdk.getApplicationContext().getContentResolver().query(var0, null, null, null, null);
      } catch (Throwable var11) {
         Object var5 = null;
         if (var5 != null) {
            var5.close();
         }

         throw var11;
      }

      long var2;
      try {
         int var1 = var12.getColumnIndex("_size");
         var12.moveToFirst();
         var2 = var12.getLong(var1);
      } finally {
         ;
      }

      if (var12 != null) {
         var12.close();
      }

      return var2;
   }

   private static GraphRequest getGraphMeRequestWithCache(String var0) {
      Bundle var1 = new Bundle();
      var1.putString("fields", "id,name,first_name,middle_name,last_name,link");
      var1.putString("access_token", var0);
      return new GraphRequest(null, "me", var1, HttpMethod.GET, null);
   }

   public static void getGraphMeRequestWithCacheAsync(String var0, Utility.GraphMeRequestWithCacheCallback var1) {
      JSONObject var2 = ProfileInformationCache.getProfileInformation(var0);
      if (var2 != null) {
         var1.onSuccess(var2);
      } else {
         GraphRequest.Callback var4 = new GraphRequest.Callback(var1, var0) {
            final String val$accessToken;
            final Utility.GraphMeRequestWithCacheCallback val$callback;

            {
               this.val$callback = var1;
               this.val$accessToken = var2x;
            }

            @Override
            public void onCompleted(GraphResponse var1) {
               if (var1.getError() != null) {
                  this.val$callback.onFailure(var1.getError().getException());
               } else {
                  ProfileInformationCache.putProfileInformation(this.val$accessToken, var1.getJSONObject());
                  this.val$callback.onSuccess(var1.getJSONObject());
               }
            }
         };
         GraphRequest var3 = getGraphMeRequestWithCache(var0);
         var3.setCallback(var4);
         var3.executeAsync();
      }
   }

   public static String getMetadataApplicationId(Context var0) {
      Validate.notNull(var0, "context");
      FacebookSdk.sdkInitialize(var0);
      return FacebookSdk.getApplicationId();
   }

   public static Method getMethodQuietly(Class<?> var0, String var1, Class<?>... var2) {
      try {
         var4 = var0.getMethod(var1, var2);
      } catch (NoSuchMethodException var3) {
         var4 = null;
      }

      return var4;
   }

   public static Method getMethodQuietly(String var0, String var1, Class<?>... var2) {
      try {
         var4 = getMethodQuietly(Class.forName(var0), var1, var2);
      } catch (ClassNotFoundException var3) {
         var4 = null;
      }

      return var4;
   }

   public static Object getStringPropertyAsJSON(JSONObject var0, String var1, String var2) throws JSONException {
      Object var3 = var0.opt(var1);
      if (var3 != null && var3 instanceof String) {
         var3 = new JSONTokener((String)var3).nextValue();
      }

      if (var3 != null && !(var3 instanceof JSONObject) && !(var3 instanceof JSONArray)) {
         if (var2 == null) {
            throw new FacebookException("Got an unexpected non-JSON object.");
         }

         JSONObject var4 = new JSONObject();
         var4.putOpt(var2, var3);
         var3 = var4;
      }

      return var3;
   }

   public static String getUriString(Uri var0) {
      String var1;
      if (var0 == null) {
         var1 = null;
      } else {
         var1 = var0.toString();
      }

      return var1;
   }

   public static Utility.PermissionsPair handlePermissionResponse(JSONObject var0) throws JSONException {
      JSONArray var6 = var0.getJSONObject("permissions").getJSONArray("data");
      ArrayList var2 = new ArrayList(var6.length());
      ArrayList var4 = new ArrayList(var6.length());

      for (int var1 = 0; var1 < var6.length(); var1++) {
         JSONObject var5 = var6.optJSONObject(var1);
         String var3 = var5.optString("permission");
         if (var3 != null && !var3.equals("installed")) {
            String var7 = var5.optString("status");
            if (var7 != null) {
               if (var7.equals("granted")) {
                  var2.add(var3);
               } else if (var7.equals("declined")) {
                  var4.add(var3);
               }
            }
         }
      }

      return new Utility.PermissionsPair(var2, var4);
   }

   public static boolean hasSameId(JSONObject var0, JSONObject var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if (var0 != null) {
         var2 = var3;
         if (var1 != null) {
            var2 = var3;
            if (var0.has("id")) {
               if (!var1.has("id")) {
                  var2 = var3;
               } else if (var0.equals(var1)) {
                  var2 = true;
               } else {
                  String var4 = var0.optString("id");
                  String var5 = var1.optString("id");
                  var2 = var3;
                  if (var4 != null) {
                     var2 = var3;
                     if (var5 != null) {
                        var2 = var4.equals(var5);
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   private static String hashBytes(MessageDigest var0, byte[] var1) {
      var0.update(var1);
      var1 = var0.digest();
      StringBuilder var5 = new StringBuilder();

      for (byte var4 : var1) {
         var5.append(Integer.toHexString(var4 >> 4 & 15));
         var5.append(Integer.toHexString(var4 >> 0 & 15));
      }

      return var5.toString();
   }

   public static <T> HashSet<T> hashSet(T... var0) {
      HashSet var3 = new HashSet(var0.length);
      int var2 = var0.length;

      for (int var1 = 0; var1 < var2; var1++) {
         var3.add(var0[var1]);
      }

      return var3;
   }

   private static String hashWithAlgorithm(String var0, String var1) {
      return hashWithAlgorithm(var0, var1.getBytes());
   }

   private static String hashWithAlgorithm(String var0, byte[] var1) {
      try {
         var4 = MessageDigest.getInstance(var0);
      } catch (NoSuchAlgorithmException var2) {
         return null;
      }

      return hashBytes(var4, var1);
   }

   public static int[] intersectRanges(int[] var0, int[] var1) {
      int var8 = 0;
      if (var0 != null) {
         if (var1 == null) {
            var1 = var0;
         } else {
            int[] var11 = new int[var0.length + var1.length];
            int var9 = 0;
            int var6 = 0;

            int var2;
            while (true) {
               var2 = var6;
               if (var9 >= var0.length) {
                  break;
               }

               var2 = var6;
               if (var8 >= var1.length) {
                  break;
               }

               int var3 = var0[var9];
               int var10 = var1[var8];
               if (var9 < var0.length - 1) {
                  var2 = var0[var9 + 1];
               } else {
                  var2 = Integer.MAX_VALUE;
               }

               int var7;
               if (var8 < var1.length - 1) {
                  var7 = var1[var8 + 1];
               } else {
                  var7 = Integer.MAX_VALUE;
               }

               int var4;
               int var5;
               if (var3 < var10) {
                  if (var2 > var10) {
                     if (var2 > var7) {
                        var4 = var8 + 2;
                        var3 = var10;
                        var2 = var7;
                        var5 = var9;
                     } else {
                        var5 = var9 + 2;
                        var4 = var8;
                        var3 = var10;
                     }
                  } else {
                     var5 = var9 + 2;
                     var2 = Integer.MAX_VALUE;
                     var3 = Integer.MIN_VALUE;
                     var4 = var8;
                  }
               } else if (var7 > var3) {
                  if (var7 > var2) {
                     var5 = var9 + 2;
                     var4 = var8;
                  } else {
                     var4 = var8 + 2;
                     var5 = var9;
                     var2 = var7;
                  }
               } else {
                  var4 = var8 + 2;
                  var2 = Integer.MAX_VALUE;
                  var3 = Integer.MIN_VALUE;
                  var5 = var9;
               }

               var8 = var4;
               var9 = var5;
               if (var3 != Integer.MIN_VALUE) {
                  var7 = var6 + 1;
                  var11[var6] = var3;
                  if (var2 == Integer.MAX_VALUE) {
                     var2 = var7;
                     break;
                  }

                  var6 = var7 + 1;
                  var11[var7] = var2;
                  var8 = var4;
                  var9 = var5;
               }
            }

            var1 = Arrays.copyOf(var11, var2);
         }
      }

      return var1;
   }

   public static Object invokeMethodQuietly(Object var0, Method var1, Object... var2) {
      Object var3 = null;

      try {
         var0 = var1.invoke(var0, var2);
      } catch (IllegalAccessException var4) {
         var0 = var3;
      } catch (InvocationTargetException var5) {
         var0 = var3;
      }

      return var0;
   }

   public static boolean isContentUri(Uri var0) {
      boolean var1;
      if (var0 != null && "content".equalsIgnoreCase(var0.getScheme())) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean isCurrentAccessToken(AccessToken var0) {
      boolean var1;
      if (var0 != null) {
         var1 = var0.equals(AccessToken.getCurrentAccessToken());
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean isFileUri(Uri var0) {
      boolean var1;
      if (var0 != null && "file".equalsIgnoreCase(var0.getScheme())) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean isNullOrEmpty(String var0) {
      boolean var1;
      if (var0 != null && var0.length() != 0) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static <T> boolean isNullOrEmpty(Collection<T> var0) {
      boolean var1;
      if (var0 != null && var0.size() != 0) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static <T> boolean isSubset(Collection<T> var0, Collection<T> var1) {
      boolean var2 = false;
      if (var1 != null && var1.size() != 0) {
         var1 = new HashSet(var1);
         Iterator var3 = var0.iterator();

         do {
            if (!var3.hasNext()) {
               var2 = true;
               break;
            }
         } while (var1.contains(var3.next()));
      } else if (var0 == null || var0.size() == 0) {
         var2 = true;
      }

      return var2;
   }

   public static boolean isWebUri(Uri var0) {
      boolean var1;
      if (var0 == null
         || !"http".equalsIgnoreCase(var0.getScheme()) && !"https".equalsIgnoreCase(var0.getScheme()) && !"fbstaging".equalsIgnoreCase(var0.getScheme())) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static Set<String> jsonArrayToSet(JSONArray var0) throws JSONException {
      HashSet var2 = new HashSet();

      for (int var1 = 0; var1 < var0.length(); var1++) {
         var2.add(var0.getString(var1));
      }

      return var2;
   }

   public static List<String> jsonArrayToStringList(JSONArray var0) throws JSONException {
      ArrayList var2 = new ArrayList();

      for (int var1 = 0; var1 < var0.length(); var1++) {
         var2.add(var0.getString(var1));
      }

      return var2;
   }

   public static void logd(String var0, Exception var1) {
      if (FacebookSdk.isDebugEnabled() && var0 != null && var1 != null) {
         Log.d(var0, var1.getClass().getSimpleName() + ": " + var1.getMessage());
      }
   }

   public static void logd(String var0, String var1) {
      if (FacebookSdk.isDebugEnabled() && var0 != null && var1 != null) {
         Log.d(var0, var1);
      }
   }

   public static void logd(String var0, String var1, Throwable var2) {
      if (FacebookSdk.isDebugEnabled() && !isNullOrEmpty(var0)) {
         Log.d(var0, var1, var2);
      }
   }

   public static <T, K> List<K> map(List<T> var0, Utility.Mapper<T, K> var1) {
      Object var3 = null;
      if (var0 == null) {
         var0 = (List)var3;
      } else {
         ArrayList var2 = new ArrayList();
         Iterator var6 = var0.iterator();

         while (var6.hasNext()) {
            Object var4 = var1.apply(var6.next());
            if (var4 != null) {
               var2.add(var4);
            }
         }

         var0 = (List)var3;
         if (var2.size() != 0) {
            var0 = var2;
         }
      }

      return var0;
   }

   public static String md5hash(String var0) {
      return hashWithAlgorithm("MD5", var0);
   }

   public static Bundle parseUrlQueryString(String var0) {
      Bundle var3 = new Bundle();
      if (!isNullOrEmpty(var0)) {
         String[] var6 = var0.split("&");
         int var2 = var6.length;

         for (int var1 = 0; var1 < var2; var1++) {
            String[] var4 = var6[var1].split("=");

            try {
               if (var4.length == 2) {
                  var3.putString(URLDecoder.decode(var4[0], "UTF-8"), URLDecoder.decode(var4[1], "UTF-8"));
               } else if (var4.length == 1) {
                  var3.putString(URLDecoder.decode(var4[0], "UTF-8"), "");
               }
            } catch (UnsupportedEncodingException var5) {
               logd("FacebookSDK", var5);
            }
         }
      }

      return var3;
   }

   public static void putCommaSeparatedStringList(Bundle var0, String var1, List<String> var2) {
      if (var2 != null) {
         StringBuilder var3 = new StringBuilder();
         Iterator var4 = var2.iterator();

         while (var4.hasNext()) {
            var3.append((String)var4.next());
            var3.append(",");
         }

         String var5 = "";
         if (var3.length() > 0) {
            var5 = var3.substring(0, var3.length() - 1);
         }

         var0.putString(var1, var5);
      }
   }

   public static boolean putJSONValueInBundle(Bundle var0, String var1, Object var2) {
      if (var2 == null) {
         var0.remove(var1);
      } else if (var2 instanceof Boolean) {
         var0.putBoolean(var1, (Boolean)var2);
      } else if (var2 instanceof boolean[]) {
         var0.putBooleanArray(var1, (boolean[])var2);
      } else if (var2 instanceof Double) {
         var0.putDouble(var1, (Double)var2);
      } else if (var2 instanceof double[]) {
         var0.putDoubleArray(var1, (double[])var2);
      } else if (var2 instanceof Integer) {
         var0.putInt(var1, (Integer)var2);
      } else if (var2 instanceof int[]) {
         var0.putIntArray(var1, (int[])var2);
      } else if (var2 instanceof Long) {
         var0.putLong(var1, (Long)var2);
      } else if (var2 instanceof long[]) {
         var0.putLongArray(var1, (long[])var2);
      } else if (var2 instanceof String) {
         var0.putString(var1, (String)var2);
      } else if (var2 instanceof JSONArray) {
         var0.putString(var1, var2.toString());
      } else {
         if (!(var2 instanceof JSONObject)) {
            return false;
         }

         var0.putString(var1, var2.toString());
      }

      return true;
   }

   public static void putNonEmptyString(Bundle var0, String var1, String var2) {
      if (!isNullOrEmpty(var2)) {
         var0.putString(var1, var2);
      }
   }

   public static void putUri(Bundle var0, String var1, Uri var2) {
      if (var2 != null) {
         putNonEmptyString(var0, var1, var2.toString());
      }
   }

   public static String readStreamToString(InputStream param0) throws IOException {
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
      // 01: astore 3
      // 02: new java/io/BufferedInputStream
      // 05: astore 2
      // 06: aload 2
      // 07: aload 0
      // 08: invokespecial java/io/BufferedInputStream.<init> (Ljava/io/InputStream;)V
      // 0b: new java/io/InputStreamReader
      // 0e: astore 4
      // 10: aload 4
      // 12: aload 2
      // 13: invokespecial java/io/InputStreamReader.<init> (Ljava/io/InputStream;)V
      // 16: new java/lang/StringBuilder
      // 19: astore 0
      // 1a: aload 0
      // 1b: invokespecial java/lang/StringBuilder.<init> ()V
      // 1e: sipush 2048
      // 21: newarray 5
      // 23: astore 3
      // 24: aload 4
      // 26: aload 3
      // 27: invokevirtual java/io/InputStreamReader.read ([C)I
      // 2a: istore 1
      // 2b: iload 1
      // 2c: bipush -1
      // 2d: if_icmpeq 4b
      // 30: aload 0
      // 31: aload 3
      // 32: bipush 0
      // 33: iload 1
      // 34: invokevirtual java/lang/StringBuilder.append ([CII)Ljava/lang/StringBuilder;
      // 37: pop
      // 38: goto 24
      // 3b: astore 0
      // 3c: aload 2
      // 3d: astore 3
      // 3e: aload 4
      // 40: astore 2
      // 41: aload 3
      // 42: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 45: aload 2
      // 46: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 49: aload 0
      // 4a: athrow
      // 4b: aload 0
      // 4c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 4f: astore 0
      // 50: aload 2
      // 51: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 54: aload 4
      // 56: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 59: aload 0
      // 5a: areturn
      // 5b: astore 0
      // 5c: aconst_null
      // 5d: astore 2
      // 5e: goto 41
      // 61: astore 0
      // 62: aconst_null
      // 63: astore 4
      // 65: aload 2
      // 66: astore 3
      // 67: aload 4
      // 69: astore 2
      // 6a: goto 41
      // try (2 -> 7): 53 null
      // try (7 -> 12): 57 null
      // try (12 -> 19): 33 null
      // try (19 -> 23): 33 null
      // try (26 -> 32): 33 null
      // try (44 -> 47): 33 null
   }

   public static Map<String, String> readStringMapFromParcel(Parcel var0) {
      int var2 = var0.readInt();
      HashMap var3;
      if (var2 < 0) {
         var3 = null;
      } else {
         HashMap var4 = new HashMap();
         int var1 = 0;

         while (true) {
            var3 = var4;
            if (var1 >= var2) {
               break;
            }

            var4.put(var0.readString(), var0.readString());
            var1++;
         }
      }

      return var3;
   }

   private static void refreshAvailableExternalStorage() {
      try {
         if (externalStorageExists()) {
            File var3 = Environment.getExternalStorageDirectory();
            StatFs var2 = new StatFs(var3.getPath());
            long var0 = var2.getAvailableBlocks();
            availableExternalStorageGB = var2.getBlockSize() * var0;
         }

         availableExternalStorageGB = convertBytesToGB(availableExternalStorageGB);
      } catch (Exception var4) {
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static int refreshBestGuessNumberOfCPUCores() {
      int var0;
      if (numCPUCores > 0) {
         var0 = numCPUCores;
      } else {
         label24: {
            File[] var5;
            try {
               File var1 = new File("/sys/devices/system/cpu/");
               FilenameFilter var2 = new FilenameFilter() {
                  @Override
                  public boolean accept(File var1, String var2x) {
                     return Pattern.matches("cpu[0-9]+", var2x);
                  }
               };
               var5 = var1.listFiles(var2);
            } catch (Exception var4) {
               break label24;
            }

            if (var5 != null) {
               try {
                  numCPUCores = var5.length;
               } catch (Exception var3) {
               }
            }
         }

         if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
         }

         var0 = numCPUCores;
      }

      return var0;
   }

   private static void refreshCarrierName(Context var0) {
      if (carrierName.equals("NoCarrier")) {
         try {
            carrierName = ((TelephonyManager)var0.getSystemService("phone")).getNetworkOperatorName();
         } catch (Exception var1) {
         }
      }
   }

   private static void refreshPeriodicExtendedDeviceInfo(Context var0) {
      if (timestampOfLastCheck == -1L || System.currentTimeMillis() - timestampOfLastCheck >= 1800000L) {
         timestampOfLastCheck = System.currentTimeMillis();
         refreshTimezone();
         refreshCarrierName(var0);
         refreshTotalExternalStorage();
         refreshAvailableExternalStorage();
      }
   }

   private static void refreshTimezone() {
      try {
         TimeZone var0 = TimeZone.getDefault();
         Date var1 = new Date();
         deviceTimezoneAbbreviation = var0.getDisplayName(var0.inDaylightTime(var1), 0);
         deviceTimeZoneName = var0.getID();
      } catch (Exception var2) {
      }
   }

   private static void refreshTotalExternalStorage() {
      try {
         if (externalStorageExists()) {
            File var2 = Environment.getExternalStorageDirectory();
            StatFs var3 = new StatFs(var2.getPath());
            long var0 = var3.getBlockCount();
            totalExternalStorageGB = var3.getBlockSize() * var0;
         }

         totalExternalStorageGB = convertBytesToGB(totalExternalStorageGB);
      } catch (Exception var4) {
      }
   }

   public static String safeGetStringFromResponse(JSONObject var0, String var1) {
      String var2;
      if (var0 != null) {
         var2 = var0.optString(var1, "");
      } else {
         var2 = "";
      }

      return var2;
   }

   public static void setAppEventAttributionParameters(JSONObject var0, AttributionIdentifiers var1, String var2, boolean var3) throws JSONException {
      boolean var5 = true;
      if (var1 != null && var1.getAttributionId() != null) {
         var0.put("attribution", var1.getAttributionId());
      }

      if (var1 != null && var1.getAndroidAdvertiserId() != null) {
         var0.put("advertiser_id", var1.getAndroidAdvertiserId());
         boolean var4;
         if (!var1.isTrackingLimited()) {
            var4 = true;
         } else {
            var4 = false;
         }

         var0.put("advertiser_tracking_enabled", var4);
      }

      if (var1 != null && var1.getAndroidInstallerPackage() != null) {
         var0.put("installer_package", var1.getAndroidInstallerPackage());
      }

      var0.put("anon_id", var2);
      if (!var3) {
         var3 = var5;
      } else {
         var3 = false;
      }

      var0.put("application_tracking_enabled", var3);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static void setAppEventExtendedDeviceInfoParameters(JSONObject var0, Context var1) throws JSONException {
      JSONArray var10 = new JSONArray();
      var10.put("a2");
      refreshPeriodicExtendedDeviceInfo(var1);
      String var11 = var1.getPackageName();
      int var6 = -1;
      Locale var8 = "";
      int var5 = var6;

      label75: {
         PackageInfo var9;
         try {
            var9 = var1.getPackageManager().getPackageInfo(var11, 0);
         } catch (NameNotFoundException var19) {
            break label75;
         }

         var5 = var6;

         try {
            var6 = var9.versionCode;
         } catch (NameNotFoundException var18) {
            break label75;
         }

         var5 = var6;

         try {
            var31 = var9.versionName;
         } catch (NameNotFoundException var17) {
            break label75;
         }

         var5 = var6;
         var8 = var31;
      }

      var10.put(var11);
      var10.put(var5);
      var10.put(var8);
      var10.put(VERSION.RELEASE);
      var10.put(Build.MODEL);

      try {
         var8 = var1.getResources().getConfiguration().locale;
      } catch (Exception var12) {
         var8 = Locale.getDefault();
      }

      var10.put(var8.getLanguage() + "_" + var8.getCountry());
      var10.put(deviceTimezoneAbbreviation);
      var10.put(carrierName);

      double var2;
      label58: {
         label76: {
            try {
               var20 = (WindowManager)var1.getSystemService("window");
            } catch (Exception var16) {
               var5 = 0;
               var6 = 0;
               break label76;
            }

            if (var20 == null) {
               var2 = 0.0;
               var5 = 0;
               var6 = 0;
               break label58;
            }

            try {
               Display var30 = var20.getDefaultDisplay();
               var21 = new DisplayMetrics();
               var30.getMetrics(var21);
               var5 = var21.widthPixels;
            } catch (Exception var15) {
               var5 = 0;
               var6 = 0;
               break label76;
            }

            try {
               var6 = var21.heightPixels;
            } catch (Exception var14) {
               byte var7 = 0;
               var6 = var5;
               var5 = var7;
               break label76;
            }

            float var4;
            try {
               var4 = var21.density;
            } catch (Exception var13) {
               int var27 = var5;
               var5 = var6;
               var6 = var27;
               break label76;
            }

            var2 = var4;
            int var28 = var6;
            var6 = var5;
            var5 = var28;
            break label58;
         }

         var2 = 0.0;
      }

      var10.put(var6);
      var10.put(var5);
      var10.put(String.format("%.2f", var2));
      var10.put(refreshBestGuessNumberOfCPUCores());
      var10.put(totalExternalStorageGB);
      var10.put(availableExternalStorageGB);
      var10.put(deviceTimeZoneName);
      var0.put("extinfo", var10.toString());
   }

   public static String sha1hash(String var0) {
      return hashWithAlgorithm("SHA-1", var0);
   }

   public static String sha1hash(byte[] var0) {
      return hashWithAlgorithm("SHA-1", var0);
   }

   public static boolean stringsEqualOrEmpty(String var0, String var1) {
      boolean var3 = TextUtils.isEmpty(var0);
      boolean var2 = TextUtils.isEmpty(var1);
      if (var3 && var2) {
         var2 = true;
      } else if (!var3 && !var2) {
         var2 = var0.equals(var1);
      } else {
         var2 = false;
      }

      return var2;
   }

   public static JSONArray tryGetJSONArrayFromResponse(JSONObject var0, String var1) {
      JSONArray var2;
      if (var0 != null) {
         var2 = var0.optJSONArray(var1);
      } else {
         var2 = null;
      }

      return var2;
   }

   public static JSONObject tryGetJSONObjectFromResponse(JSONObject var0, String var1) {
      if (var0 != null) {
         var0 = var0.optJSONObject(var1);
      } else {
         var0 = null;
      }

      return var0;
   }

   public static <T> Collection<T> unmodifiableCollection(T... var0) {
      return Collections.unmodifiableCollection(Arrays.asList((T[])var0));
   }

   public static void writeStringMapToParcel(Parcel var0, Map<String, String> var1) {
      if (var1 == null) {
         var0.writeInt(-1);
      } else {
         var0.writeInt(var1.size());

         for (Entry var2 : var1.entrySet()) {
            var0.writeString((String)var2.getKey());
            var0.writeString((String)var2.getValue());
         }
      }
   }

   public interface GraphMeRequestWithCacheCallback {
      void onFailure(FacebookException var1);

      void onSuccess(JSONObject var1);
   }

   public interface Mapper<T, K> {
      K apply(T var1);
   }

   public static class PermissionsPair {
      List<String> declinedPermissions;
      List<String> grantedPermissions;

      public PermissionsPair(List<String> var1, List<String> var2) {
         this.grantedPermissions = var1;
         this.declinedPermissions = var2;
      }

      public List<String> getDeclinedPermissions() {
         return this.declinedPermissions;
      }

      public List<String> getGrantedPermissions() {
         return this.grantedPermissions;
      }
   }

   public interface Predicate<T> {
      boolean apply(T var1);
   }
}
