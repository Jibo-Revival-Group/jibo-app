package com.segment.analytics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings.Secure;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class Utils {
   public static final boolean DEFAULT_COLLECT_DEVICE_ID = true;
   public static final int DEFAULT_FLUSH_INTERVAL = 30000;
   public static final int DEFAULT_FLUSH_QUEUE_SIZE = 20;
   public static final String THREAD_PREFIX = "Segment-";

   private Utils() {
      throw new AssertionError("No instances");
   }

   public static <T> T assertNotNull(T var0, String var1) {
      if (var0 == null) {
         throw new NullPointerException(var1 + " == null");
      } else {
         return (T)var0;
      }
   }

   public static String assertNotNullOrEmpty(String var0, String var1) {
      if (isNullOrEmpty(var0)) {
         throw new NullPointerException(var1 + " cannot be null or empty");
      } else {
         return var0;
      }
   }

   public static <K, V> Map<K, V> assertNotNullOrEmpty(Map<K, V> var0, String var1) {
      if (isNullOrEmpty(var0)) {
         throw new NullPointerException(var1 + " cannot be null or empty");
      } else {
         return var0;
      }
   }

   public static BufferedReader buffer(InputStream var0) {
      return new BufferedReader(new InputStreamReader(var0));
   }

   public static void closeQuietly(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var1) {
         }
      }
   }

   public static float coerceToFloat(Object var0, float var1) {
      float var2;
      if (var0 instanceof Float) {
         var2 = (Float)var0;
      } else if (var0 instanceof Number) {
         var2 = ((Number)var0).floatValue();
      } else {
         var2 = var1;
         if (var0 instanceof String) {
            try {
               var2 = Float.valueOf((String)var0);
            } catch (NumberFormatException var3) {
               var2 = var1;
            }
         }
      }

      return var2;
   }

   public static void copySharedPreferences(SharedPreferences var0, SharedPreferences var1) {
      Editor var5 = var1.edit();

      for (Entry var3 : var0.getAll().entrySet()) {
         String var2 = (String)var3.getKey();
         Object var6 = var3.getValue();
         if (var6 instanceof String) {
            var5.putString(var2, (String)var6);
         } else if (var6 instanceof Set) {
            var5.putStringSet(var2, (Set)var6);
         } else if (var6 instanceof Integer) {
            var5.putInt(var2, (Integer)var6);
         } else if (var6 instanceof Long) {
            var5.putLong(var2, (Long)var6);
         } else if (var6 instanceof Float) {
            var5.putFloat(var2, (Float)var6);
         } else if (var6 instanceof Boolean) {
            var5.putBoolean(var2, (Boolean)var6);
         }
      }

      var5.apply();
   }

   public static void createDirectory(File var0) throws IOException {
      if (!var0.exists() && !var0.mkdirs() && !var0.isDirectory()) {
         throw new IOException("Could not create directory at " + var0);
      }
   }

   public static <T> Map<String, T> createMap() {
      return new Utils.NullableConcurrentHashMap<>();
   }

   public static String getDeviceId(Context var0) {
      String var1 = Secure.getString(var0.getContentResolver(), "android_id");
      String var2;
      if (!isNullOrEmpty(var1) && !"9774d56d682e549c".equals(var1) && !"unknown".equals(var1) && !"000000000000000".equals(var1)) {
         var2 = var1;
      } else if (!isNullOrEmpty(Build.SERIAL)) {
         var2 = Build.SERIAL;
      } else {
         if (hasPermission(var0, "android.permission.READ_PHONE_STATE") && hasFeature(var0, "android.hardware.telephony")) {
            var1 = getSystemService(var0, "phone").getDeviceId();
            String var4 = var1;
            if (!isNullOrEmpty(var1)) {
               return var4;
            }
         }

         var2 = UUID.randomUUID().toString();
      }

      return var2;
   }

   private static int getIdentifier(Context var0, String var1, String var2) {
      return var0.getResources().getIdentifier(var2, var1, var0.getPackageName());
   }

   public static InputStream getInputStream(HttpURLConnection var0) throws IOException {
      InputStream var1;
      try {
         var1 = var0.getInputStream();
      } catch (IOException var2) {
         return var0.getErrorStream();
      }

      return var1;
   }

   public static String getResourceString(Context var0, String var1) {
      int var2 = getIdentifier(var0, "string", var1);
      String var3;
      if (var2 != 0) {
         var3 = var0.getResources().getString(var2);
      } else {
         var3 = null;
      }

      return var3;
   }

   public static SharedPreferences getSegmentSharedPreferences(Context var0, String var1) {
      return var0.getSharedPreferences("analytics-android-" + var1, 0);
   }

   public static <T> T getSystemService(Context var0, String var1) {
      return (T)var0.getSystemService(var1);
   }

   private static int getTrimmedLength(CharSequence var0) {
      int var3 = var0.length();
      int var1 = 0;

      int var2;
      while (true) {
         var2 = var3;
         if (var1 >= var3) {
            break;
         }

         var2 = var3;
         if (var0.charAt(var1) > ' ') {
            break;
         }

         var1++;
      }

      while (var2 > var1 && var0.charAt(var2 - 1) <= ' ') {
         var2--;
      }

      return var2 - var1;
   }

   public static boolean hasFeature(Context var0, String var1) {
      return var0.getPackageManager().hasSystemFeature(var1);
   }

   public static boolean hasPermission(Context var0, String var1) {
      boolean var2;
      if (var0.checkCallingOrSelfPermission(var1) == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public static <T> List<T> immutableCopyOf(List<T> var0) {
      if (isNullOrEmpty(var0)) {
         var0 = Collections.emptyList();
      } else {
         var0 = Collections.unmodifiableList(new ArrayList<>(var0));
      }

      return var0;
   }

   public static <K, V> Map<K, V> immutableCopyOf(Map<K, V> var0) {
      return Collections.unmodifiableMap(new LinkedHashMap<>(var0));
   }

   public static boolean isConnected(Context var0) {
      boolean var1 = true;
      if (hasPermission(var0, "android.permission.ACCESS_NETWORK_STATE")) {
         NetworkInfo var2 = getSystemService(var0, "connectivity").getActiveNetworkInfo();
         if (var2 != null && var2.isConnectedOrConnecting()) {
            var1 = true;
         } else {
            var1 = false;
         }
      }

      return var1;
   }

   private static boolean isEmpty(CharSequence var0) {
      boolean var1;
      if (var0 != null && var0.length() != 0) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean isNullOrEmpty(CharSequence var0) {
      boolean var1;
      if (!isEmpty(var0) && getTrimmedLength(var0) != 0) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean isNullOrEmpty(Collection var0) {
      boolean var1;
      if (var0 != null && var0.size() != 0) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean isNullOrEmpty(Map var0) {
      boolean var1;
      if (var0 != null && var0.size() != 0) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static <T> boolean isNullOrEmpty(T[] var0) {
      boolean var1;
      if (var0 != null && var0.length != 0) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean isOnClassPath(String var0) {
      try {
         Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         return false;
      }

      return true;
   }

   public static <T> Set<T> newSet(T... var0) {
      HashSet var1 = new HashSet(var0.length);
      Collections.addAll(var1, var0);
      return var1;
   }

   public static Date parseISO8601Date(String var0) {
      return Iso8601Utils.parse(var0);
   }

   public static String readFully(BufferedReader var0) throws IOException {
      StringBuilder var1 = new StringBuilder();

      while (true) {
         String var2 = var0.readLine();
         if (var2 == null) {
            return var1.toString();
         }

         var1.append(var2);
      }
   }

   public static String readFully(InputStream var0) throws IOException {
      return readFully(buffer(var0));
   }

   public static String toISO8601Date(Date var0) {
      return toISO8601String(var0);
   }

   public static Date toISO8601Date(String var0) throws ParseException {
      return parseISO8601Date(var0);
   }

   public static String toISO8601String(Date var0) {
      return Iso8601Utils.format(var0);
   }

   public static JSONObject toJsonObject(Map<String, ?> var0) {
      JSONObject var1 = new JSONObject();

      for (Entry var2 : var0.entrySet()) {
         Object var3 = wrap(var2.getValue());

         try {
            var1.put((String)var2.getKey(), var3);
         } catch (JSONException var4) {
         }
      }

      return var1;
   }

   public static <T> Map<String, T> transform(Map<String, T> var0, Map<String, String> var1) {
      LinkedHashMap var2 = new LinkedHashMap(var0.size());

      for (Entry var5 : var0.entrySet()) {
         String var4 = (String)var5.getKey();
         if (!var1.containsKey(var4)) {
            var2.put(var4, var5.getValue());
         } else {
            var4 = (String)var1.get(var4);
            if (!isNullOrEmpty(var4)) {
               var2.put(var4, var5.getValue());
            }
         }
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static Object wrap(Object var0) {
      Object var3;
      if (var0 == null) {
         var3 = JSONObject.NULL;
      } else {
         var3 = var0;
         if (!(var0 instanceof JSONArray)) {
            var3 = var0;
            if (!(var0 instanceof JSONObject)) {
               var3 = var0;
               if (!var0.equals(JSONObject.NULL)) {
                  try {
                     if (var0 instanceof Collection) {
                        var3 = new JSONArray((Collection)var0);
                        return var3;
                     }
                  } catch (Exception var16) {
                     var3 = JSONObject.NULL;
                     return var3;
                  }

                  label144: {
                     int var2;
                     try {
                        if (!var0.getClass().isArray()) {
                           break label144;
                        }

                        var2 = Array.getLength(var0);
                        var17 = new JSONArray();
                     } catch (Exception var15) {
                        var3 = JSONObject.NULL;
                        return var3;
                     }

                     int var1 = 0;

                     while (true) {
                        var3 = var17;
                        if (var1 >= var2) {
                           return var3;
                        }

                        try {
                           var17.put(wrap(Array.get(var17, var1)));
                        } catch (Exception var14) {
                           var3 = JSONObject.NULL;
                           return var3;
                        }

                        var1++;
                     }
                  }

                  try {
                     if (var0 instanceof Map) {
                        var3 = toJsonObject((Map<String, ?>)var0);
                        return var3;
                     }
                  } catch (Exception var13) {
                     var3 = JSONObject.NULL;
                     return var3;
                  }

                  var3 = var0;

                  try {
                     if (var0 instanceof Boolean) {
                        return var3;
                     }
                  } catch (Exception var12) {
                     var3 = JSONObject.NULL;
                     return var3;
                  }

                  var3 = var0;

                  try {
                     if (var0 instanceof Byte) {
                        return var3;
                     }
                  } catch (Exception var11) {
                     var3 = JSONObject.NULL;
                     return var3;
                  }

                  var3 = var0;

                  try {
                     if (var0 instanceof Character) {
                        return var3;
                     }
                  } catch (Exception var10) {
                     var3 = JSONObject.NULL;
                     return var3;
                  }

                  var3 = var0;

                  try {
                     if (var0 instanceof Double) {
                        return var3;
                     }
                  } catch (Exception var9) {
                     var3 = JSONObject.NULL;
                     return var3;
                  }

                  var3 = var0;

                  try {
                     if (var0 instanceof Float) {
                        return var3;
                     }
                  } catch (Exception var8) {
                     var3 = JSONObject.NULL;
                     return var3;
                  }

                  var3 = var0;

                  try {
                     if (var0 instanceof Integer) {
                        return var3;
                     }
                  } catch (Exception var7) {
                     var3 = JSONObject.NULL;
                     return var3;
                  }

                  var3 = var0;

                  try {
                     if (var0 instanceof Long) {
                        return var3;
                     }
                  } catch (Exception var6) {
                     var3 = JSONObject.NULL;
                     return var3;
                  }

                  var3 = var0;

                  try {
                     if (var0 instanceof Short) {
                        return var3;
                     }
                  } catch (Exception var5) {
                     var3 = JSONObject.NULL;
                     return var3;
                  }

                  var3 = var0;

                  try {
                     if (!(var0 instanceof String)) {
                        var3 = var0.toString();
                     }
                  } catch (Exception var4) {
                     var3 = JSONObject.NULL;
                  }
               }
            }
         }
      }

      return var3;
   }

   public static class AnalyticsNetworkExecutorService extends ThreadPoolExecutor {
      private static final int DEFAULT_THREAD_COUNT = 1;
      private static final int MAX_THREAD_COUNT = 2;

      public AnalyticsNetworkExecutorService() {
         super(1, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new Utils.AnalyticsThreadFactory());
      }
   }

   private static class AnalyticsThread extends Thread {
      private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger(1);

      public AnalyticsThread(Runnable var1) {
         super(var1, "Segment-" + SEQUENCE_GENERATOR.getAndIncrement());
      }

      @Override
      public void run() {
         Process.setThreadPriority(10);
         super.run();
      }
   }

   public static class AnalyticsThreadFactory implements ThreadFactory {
      @Override
      public Thread newThread(Runnable var1) {
         return new Utils.AnalyticsThread(var1);
      }
   }

   public static class NullableConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {
      public NullableConcurrentHashMap() {
      }

      public NullableConcurrentHashMap(Map<? extends K, ? extends V> var1) {
         super(var1);
      }

      @Override
      public V put(K var1, V var2) {
         if (var1 != null && var2 != null) {
            var1 = super.put((K)var1, (V)var2);
         } else {
            var1 = null;
         }

         return (V)var1;
      }

      @Override
      public void putAll(Map<? extends K, ? extends V> var1) {
         for (Entry var3 : var1.entrySet()) {
            this.put((K)var3.getKey(), (V)var3.getValue());
         }
      }
   }
}
