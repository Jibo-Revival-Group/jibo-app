package com.segment.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import com.segment.analytics.internal.Utils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ValueMap implements Map<String, Object> {
    private final Map<String, Object> delegate;

    static <T extends ValueMap> T createValueMap(Map map, Class<T> cls) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(Map.class);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(map);
        } catch (Exception e) {
            throw new AssertionError("Could not create instance of " + cls.getCanonicalName() + ".\n" + e);
        }
    }

    public ValueMap() {
        this.delegate = new LinkedHashMap();
    }

    public ValueMap(int i) {
        this.delegate = new LinkedHashMap(i);
    }

    public ValueMap(Map<String, Object> map) {
        if (map == null) {
            throw new IllegalArgumentException("Map must not be null.");
        }
        this.delegate = map;
    }

    @Override // java.util.Map
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.delegate.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.delegate.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.delegate.entrySet();
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.delegate.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.delegate.keySet();
    }

    @Override // java.util.Map
    public Object put(String str, Object obj) {
        return this.delegate.put(str, obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        this.delegate.putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.delegate.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.delegate.values();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || this.delegate.equals(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.delegate.hashCode();
    }

    public String toString() {
        return this.delegate.toString();
    }

    public ValueMap putValue(String str, Object obj) {
        this.delegate.put(str, obj);
        return this;
    }

    public int getInt(String str, int i) {
        Object obj = get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj).intValue();
            } catch (NumberFormatException e) {
                return i;
            }
        }
        return i;
    }

    public long getLong(String str, long j) {
        Object obj = get(str);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf((String) obj).longValue();
            } catch (NumberFormatException e) {
                return j;
            }
        }
        return j;
    }

    public float getFloat(String str, float f) {
        return Utils.coerceToFloat(get(str), f);
    }

    public double getDouble(String str, double d) {
        Object obj = get(str);
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj).doubleValue();
            } catch (NumberFormatException e) {
                return d;
            }
        }
        return d;
    }

    public char getChar(String str, char c) {
        Object obj = get(str);
        if (obj instanceof Character) {
            return ((Character) obj).charValue();
        }
        if (obj != null && (obj instanceof String) && ((String) obj).length() == 1) {
            return ((String) obj).charAt(0);
        }
        return c;
    }

    public String getString(String str) {
        Object obj = get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    public boolean getBoolean(String str, boolean z) {
        Object obj = get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            return Boolean.valueOf((String) obj).booleanValue();
        }
        return z;
    }

    public <T extends Enum<T>> T getEnum(Class<T> cls, String str) {
        if (cls == null) {
            throw new IllegalArgumentException("enumType may not be null");
        }
        Object obj = get(str);
        if (cls.isInstance(obj)) {
            return (T) obj;
        }
        if (obj instanceof String) {
            return (T) Enum.valueOf(cls, (String) obj);
        }
        return null;
    }

    public ValueMap getValueMap(Object obj) {
        Object obj2 = get(obj);
        if (obj2 instanceof ValueMap) {
            return (ValueMap) obj2;
        }
        if (obj2 instanceof Map) {
            return new ValueMap((Map<String, Object>) obj2);
        }
        return null;
    }

    public <T extends ValueMap> T getValueMap(String str, Class<T> cls) {
        return (T) coerceToValueMap(get(str), cls);
    }

    private <T extends ValueMap> T coerceToValueMap(Object obj, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return (T) obj;
        }
        if (obj instanceof Map) {
            return (T) createValueMap((Map) obj, cls);
        }
        return null;
    }

    public <T extends ValueMap> List<T> getList(Object obj, Class<T> cls) {
        Object obj2 = get(obj);
        if (obj2 instanceof List) {
            List list = (List) obj2;
            try {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ValueMap valueMapCoerceToValueMap = coerceToValueMap(it.next(), cls);
                    if (valueMapCoerceToValueMap != null) {
                        arrayList.add(valueMapCoerceToValueMap);
                    }
                }
                return arrayList;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public JSONObject toJsonObject() {
        return Utils.toJsonObject(this.delegate);
    }

    public Map<String, String> toStringMap() {
        HashMap map = new HashMap();
        for (Map.Entry<String, Object> entry : entrySet()) {
            map.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return map;
    }

    static class Cache<T extends ValueMap> {
        private final Cartographer cartographer;
        private final Class<T> clazz;
        private final String key;
        private final SharedPreferences preferences;
        private T value;

        Cache(Context context, Cartographer cartographer, String str, String str2, Class<T> cls) {
            this.cartographer = cartographer;
            this.preferences = Utils.getSegmentSharedPreferences(context, str2);
            this.key = str;
            this.clazz = cls;
        }

        T get() {
            if (this.value == null) {
                String string = this.preferences.getString(this.key, null);
                if (Utils.isNullOrEmpty(string)) {
                    return null;
                }
                try {
                    this.value = (T) create(this.cartographer.fromJson(string));
                } catch (IOException e) {
                    return null;
                }
            }
            return this.value;
        }

        boolean isSet() {
            return this.preferences.contains(this.key);
        }

        T create(Map<String, Object> map) {
            return (T) ValueMap.createValueMap(map, this.clazz);
        }

        void set(T t) {
            this.value = t;
            this.preferences.edit().putString(this.key, this.cartographer.toJson(t)).apply();
        }

        void delete() {
            this.preferences.edit().remove(this.key).apply();
        }
    }
}
