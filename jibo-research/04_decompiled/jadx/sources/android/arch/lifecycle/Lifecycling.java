package android.arch.lifecycle;

import com.yalantis.ucrop.util.FileUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Lifecycling {

    /* JADX INFO: renamed from: a */
    private static Map<Class, Integer> f43a = new HashMap();

    /* JADX INFO: renamed from: b */
    private static Map<Class, List<Constructor<? extends GeneratedAdapter>>> f44b = new HashMap();

    /* JADX INFO: renamed from: a */
    static GenericLifecycleObserver m58a(Object obj) {
        int i = 0;
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj);
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (m61b(cls) == 2) {
            List<Constructor<? extends GeneratedAdapter>> list = f44b.get(cls);
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(m57a(list.get(0), obj));
            }
            GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    generatedAdapterArr[i2] = m57a(list.get(i2), obj);
                    i = i2 + 1;
                } else {
                    return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
                }
            }
        } else {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
    }

    /* JADX INFO: renamed from: a */
    private static GeneratedAdapter m57a(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX INFO: renamed from: a */
    private static Constructor<? extends GeneratedAdapter> m60a(Class<?> cls) {
        try {
            Package r1 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r1 != null ? r1.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String strM59a = m59a(canonicalName);
            if (!name.isEmpty()) {
                strM59a = name + FileUtils.HIDDEN_PREFIX + strM59a;
            }
            Constructor declaredConstructor = Class.forName(strM59a).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
                return declaredConstructor;
            }
            return declaredConstructor;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: renamed from: b */
    private static int m61b(Class<?> cls) {
        if (f43a.containsKey(cls)) {
            return f43a.get(cls).intValue();
        }
        int iM62c = m62c(cls);
        f43a.put(cls, Integer.valueOf(iM62c));
        return iM62c;
    }

    /* JADX INFO: renamed from: c */
    private static int m62c(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends GeneratedAdapter> constructorM60a = m60a(cls);
        if (constructorM60a != null) {
            f44b.put(cls, Collections.singletonList(constructorM60a));
            return 2;
        }
        if (ClassesInfoCache.f22a.m25a(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        ArrayList arrayList = null;
        if (m63d(superclass)) {
            if (m61b(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList(f44b.get(superclass));
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (m63d(cls2)) {
                if (m61b(cls2) == 1) {
                    return 1;
                }
                ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                arrayList2.addAll(f44b.get(cls2));
                arrayList = arrayList2;
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f44b.put(cls, arrayList);
        return 2;
    }

    /* JADX INFO: renamed from: d */
    private static boolean m63d(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    /* JADX INFO: renamed from: a */
    public static String m59a(String str) {
        return str.replace(FileUtils.HIDDEN_PREFIX, "_") + "_LifecycleAdapter";
    }
}
