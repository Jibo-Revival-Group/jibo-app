package butterknife;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ButterKnife {

    /* JADX INFO: renamed from: b */
    private static boolean f4637b = false;

    /* JADX INFO: renamed from: a */
    static final Map<Class<?>, Constructor<? extends Unbinder>> f4636a = new LinkedHashMap();

    public interface Action<T extends View> {
    }

    public interface Setter<T extends View, V> {
    }

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    /* JADX INFO: renamed from: a */
    public static Unbinder m5152a(Activity activity) {
        return m5156b(activity, activity.getWindow().getDecorView());
    }

    /* JADX INFO: renamed from: a */
    public static Unbinder m5153a(View view) {
        return m5156b(view, view);
    }

    /* JADX INFO: renamed from: a */
    public static Unbinder m5154a(Object obj, View view) {
        return m5156b(obj, view);
    }

    /* JADX INFO: renamed from: b */
    private static Unbinder m5156b(Object obj, View view) {
        Class<?> cls = obj.getClass();
        if (f4637b) {
            Log.d("ButterKnife", "Looking up binding for " + cls.getName());
        }
        Constructor<? extends Unbinder> constructorM5155a = m5155a(cls);
        if (constructorM5155a == null) {
            return Unbinder.f4638a;
        }
        try {
            return constructorM5155a.newInstance(obj, view);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to invoke " + constructorM5155a, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Unable to invoke " + constructorM5155a, e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unable to create binding instance.", cause);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private static Constructor<? extends Unbinder> m5155a(Class<?> cls) {
        Constructor<? extends Unbinder> constructorM5155a;
        Constructor<? extends Unbinder> constructor = f4636a.get(cls);
        if (constructor != null) {
            if (f4637b) {
                Log.d("ButterKnife", "HIT: Cached in binding map.");
                return constructor;
            }
            return constructor;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.")) {
            if (f4637b) {
                Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
            }
            return null;
        }
        try {
            constructorM5155a = cls.getClassLoader().loadClass(name + "_ViewBinding").getConstructor(cls, View.class);
            if (f4637b) {
                Log.d("ButterKnife", "HIT: Loaded binding class and constructor.");
            }
        } catch (ClassNotFoundException e) {
            if (f4637b) {
                Log.d("ButterKnife", "Not found. Trying superclass " + cls.getSuperclass().getName());
            }
            constructorM5155a = m5155a(cls.getSuperclass());
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Unable to find binding constructor for " + name, e2);
        }
        f4636a.put(cls, constructorM5155a);
        return constructorM5155a;
    }
}
