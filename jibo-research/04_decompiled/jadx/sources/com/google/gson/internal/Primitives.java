package com.google.gson.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class Primitives {

    /* JADX INFO: renamed from: a */
    private static final Map<Class<?>, Class<?>> f8895a;

    /* JADX INFO: renamed from: b */
    private static final Map<Class<?>, Class<?>> f8896b;

    static {
        HashMap map = new HashMap(16);
        HashMap map2 = new HashMap(16);
        m9487a(map, map2, Boolean.TYPE, Boolean.class);
        m9487a(map, map2, Byte.TYPE, Byte.class);
        m9487a(map, map2, Character.TYPE, Character.class);
        m9487a(map, map2, Double.TYPE, Double.class);
        m9487a(map, map2, Float.TYPE, Float.class);
        m9487a(map, map2, Integer.TYPE, Integer.class);
        m9487a(map, map2, Long.TYPE, Long.class);
        m9487a(map, map2, Short.TYPE, Short.class);
        m9487a(map, map2, Void.TYPE, Void.class);
        f8895a = Collections.unmodifiableMap(map);
        f8896b = Collections.unmodifiableMap(map2);
    }

    /* JADX INFO: renamed from: a */
    private static void m9487a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m9488a(Type type) {
        return f8895a.containsKey(type);
    }

    /* JADX INFO: renamed from: a */
    public static <T> Class<T> m9486a(Class<T> cls) {
        Class<T> cls2 = (Class) f8895a.get(C$Gson$Preconditions.m9432a(cls));
        return cls2 == null ? cls : cls2;
    }
}
