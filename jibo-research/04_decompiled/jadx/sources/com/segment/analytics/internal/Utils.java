package com.segment.analytics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Utils {
    public static final boolean DEFAULT_COLLECT_DEVICE_ID = true;
    public static final int DEFAULT_FLUSH_INTERVAL = 30000;
    public static final int DEFAULT_FLUSH_QUEUE_SIZE = 20;
    public static final String THREAD_PREFIX = "Segment-";

    public static <T> Set<T> newSet(T... tArr) {
        HashSet hashSet = new HashSet(tArr.length);
        Collections.addAll(hashSet, tArr);
        return hashSet;
    }

    public static String toISO8601Date(Date date) {
        return toISO8601String(date);
    }

    public static String toISO8601String(Date date) {
        return Iso8601Utils.format(date);
    }

    public static Date parseISO8601Date(String str) {
        return Iso8601Utils.parse(str);
    }

    public static Date toISO8601Date(String str) throws ParseException {
        return parseISO8601Date(str);
    }

    public static float coerceToFloat(Object obj, float f) {
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        if (obj instanceof String) {
            try {
                return Float.valueOf((String) obj).floatValue();
            } catch (NumberFormatException e) {
                return f;
            }
        }
        return f;
    }

    public static boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean hasFeature(Context context, String str) {
        return context.getPackageManager().hasSystemFeature(str);
    }

    public static <T> T getSystemService(Context context, String str) {
        return (T) context.getSystemService(str);
    }

    public static boolean isNullOrEmpty(CharSequence charSequence) {
        return isEmpty(charSequence) || getTrimmedLength(charSequence) == 0;
    }

    private static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    private static int getTrimmedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) <= ' ') {
            i++;
        }
        while (length > i && charSequence.charAt(length - 1) <= ' ') {
            length--;
        }
        return length - i;
    }

    public static boolean isNullOrEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static <T> boolean isNullOrEmpty(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static boolean isNullOrEmpty(Map map) {
        return map == null || map.size() == 0;
    }

    public static String assertNotNullOrEmpty(String str, String str2) {
        if (isNullOrEmpty(str)) {
            throw new NullPointerException(str2 + " cannot be null or empty");
        }
        return str;
    }

    public static <K, V> Map<K, V> assertNotNullOrEmpty(Map<K, V> map, String str) {
        if (isNullOrEmpty(map)) {
            throw new NullPointerException(str + " cannot be null or empty");
        }
        return map;
    }

    public static <T> T assertNotNull(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str + " == null");
        }
        return t;
    }

    public static <K, V> Map<K, V> immutableCopyOf(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static <T> List<T> immutableCopyOf(List<T> list) {
        return isNullOrEmpty(list) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
    }

    public static String getDeviceId(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (isNullOrEmpty(string) || "9774d56d682e549c".equals(string) || "unknown".equals(string) || "000000000000000".equals(string)) {
            if (!isNullOrEmpty(Build.SERIAL)) {
                return Build.SERIAL;
            }
            if (hasPermission(context, "android.permission.READ_PHONE_STATE") && hasFeature(context, "android.hardware.telephony")) {
                String deviceId = ((TelephonyManager) getSystemService(context, "phone")).getDeviceId();
                if (!isNullOrEmpty(deviceId)) {
                    return deviceId;
                }
            }
            return UUID.randomUUID().toString();
        }
        return string;
    }

    public static SharedPreferences getSegmentSharedPreferences(Context context, String str) {
        return context.getSharedPreferences("analytics-android-" + str, 0);
    }

    public static String getResourceString(Context context, String str) {
        int identifier = getIdentifier(context, "string", str);
        if (identifier != 0) {
            return context.getResources().getString(identifier);
        }
        return null;
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str2, str, context.getPackageName());
    }

    public static boolean isConnected(Context context) {
        if (!hasPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService(context, "connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean isOnClassPath(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static BufferedReader buffer(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public static String readFully(InputStream inputStream) throws IOException {
        return readFully(buffer(inputStream));
    }

    public static String readFully(BufferedReader bufferedReader) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line);
            } else {
                return sb.toString();
            }
        }
    }

    public static InputStream getInputStream(HttpURLConnection httpURLConnection) throws IOException {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException e) {
            return httpURLConnection.getErrorStream();
        }
    }

    public static <T> Map<String, T> transform(Map<String, T> map, Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!map2.containsKey(key)) {
                linkedHashMap.put(key, entry.getValue());
            } else {
                String str = map2.get(key);
                if (!isNullOrEmpty(str)) {
                    linkedHashMap.put(str, entry.getValue());
                }
            }
        }
        return linkedHashMap;
    }

    public static JSONObject toJsonObject(Map<String, ?> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), wrap(entry.getValue()));
            } catch (JSONException e) {
            }
        }
        return jSONObject;
    }

    private static Object wrap(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if (!(obj instanceof JSONArray) && !(obj instanceof JSONObject) && !obj.equals(JSONObject.NULL)) {
            try {
                if (obj instanceof Collection) {
                    return new JSONArray((Collection) obj);
                }
                if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < length; i++) {
                        jSONArray.put(wrap(Array.get(jSONArray, i)));
                    }
                    return jSONArray;
                }
                if (obj instanceof Map) {
                    return toJsonObject((Map) obj);
                }
                if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
                    return obj.toString();
                }
                return obj;
            } catch (Exception e) {
                return JSONObject.NULL;
            }
        }
        return obj;
    }

    public static <T> Map<String, T> createMap() {
        return new NullableConcurrentHashMap();
    }

    public static void createDirectory(File file) throws IOException {
        if (!file.exists() && !file.mkdirs() && !file.isDirectory()) {
            throw new IOException("Could not create directory at " + file);
        }
    }

    public static void copySharedPreferences(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                editorEdit.putString(key, (String) value);
            } else if (value instanceof Set) {
                editorEdit.putStringSet(key, (Set) value);
            } else if (value instanceof Integer) {
                editorEdit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                editorEdit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                editorEdit.putFloat(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
            }
        }
        editorEdit.apply();
    }

    private Utils() {
        throw new AssertionError("No instances");
    }

    public static class AnalyticsNetworkExecutorService extends ThreadPoolExecutor {
        private static final int DEFAULT_THREAD_COUNT = 1;
        private static final int MAX_THREAD_COUNT = 2;

        public AnalyticsNetworkExecutorService() {
            super(1, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new AnalyticsThreadFactory());
        }
    }

    public static class AnalyticsThreadFactory implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new AnalyticsThread(runnable);
        }
    }

    private static class AnalyticsThread extends Thread {
        private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger(1);

        public AnalyticsThread(Runnable runnable) {
            super(runnable, Utils.THREAD_PREFIX + SEQUENCE_GENERATOR.getAndIncrement());
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    public static class NullableConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {
        public NullableConcurrentHashMap() {
        }

        public NullableConcurrentHashMap(Map<? extends K, ? extends V> map) {
            super(map);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            if (k == null || v == null) {
                return null;
            }
            return (V) super.put(k, v);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }
}
