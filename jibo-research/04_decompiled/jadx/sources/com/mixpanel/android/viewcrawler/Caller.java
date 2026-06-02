package com.mixpanel.android.viewcrawler;

import android.view.View;
import com.mixpanel.android.util.MPLog;
import com.yalantis.ucrop.util.FileUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class Caller {

    /* JADX INFO: renamed from: a */
    private final String f12091a;

    /* JADX INFO: renamed from: b */
    private final Object[] f12092b;

    /* JADX INFO: renamed from: c */
    private final Class<?> f12093c;

    /* JADX INFO: renamed from: d */
    private final Class<?> f12094d;

    /* JADX INFO: renamed from: e */
    private final Method f12095e;

    public Caller(Class<?> cls, String str, Object[] objArr, Class<?> cls2) throws NoSuchMethodException {
        this.f12091a = str;
        this.f12092b = objArr;
        this.f12093c = cls2;
        this.f12095e = m12039b(cls);
        if (this.f12095e == null) {
            throw new NoSuchMethodException("Method " + cls.getName() + FileUtils.HIDDEN_PREFIX + this.f12091a + " doesn't exit");
        }
        this.f12094d = this.f12095e.getDeclaringClass();
    }

    public String toString() {
        return "[Caller " + this.f12091a + "(" + this.f12092b + ")]";
    }

    /* JADX INFO: renamed from: a */
    public Object[] m12043a() {
        return this.f12092b;
    }

    /* JADX INFO: renamed from: a */
    public Object m12040a(View view) {
        return m12041a(view, this.f12092b);
    }

    /* JADX INFO: renamed from: a */
    public Object m12041a(View view, Object[] objArr) {
        if (this.f12094d.isAssignableFrom(view.getClass())) {
            try {
                return this.f12095e.invoke(view, objArr);
            } catch (IllegalAccessException e) {
                MPLog.m12031e("MixpanelABTest.Caller", "Method " + this.f12095e.getName() + " appears not to be public", e);
            } catch (IllegalArgumentException e2) {
                MPLog.m12031e("MixpanelABTest.Caller", "Method " + this.f12095e.getName() + " called with arguments of the wrong type", e2);
            } catch (InvocationTargetException e3) {
                MPLog.m12031e("MixpanelABTest.Caller", "Method " + this.f12095e.getName() + " threw an exception", e3);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public boolean m12042a(Object[] objArr) {
        Class<?>[] parameterTypes = this.f12095e.getParameterTypes();
        if (objArr.length != parameterTypes.length) {
            return false;
        }
        for (int i = 0; i < objArr.length; i++) {
            Class<?> clsM12038a = m12038a(parameterTypes[i]);
            if (objArr[i] == null) {
                if (clsM12038a == Byte.TYPE || clsM12038a == Short.TYPE || clsM12038a == Integer.TYPE || clsM12038a == Long.TYPE || clsM12038a == Float.TYPE || clsM12038a == Double.TYPE || clsM12038a == Boolean.TYPE || clsM12038a == Character.TYPE) {
                    return false;
                }
            } else if (!clsM12038a.isAssignableFrom(m12038a(objArr[i].getClass()))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static Class<?> m12038a(Class<?> cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        return cls;
    }

    /* JADX INFO: renamed from: b */
    private Method m12039b(Class<?> cls) {
        Class[] clsArr = new Class[this.f12092b.length];
        for (int i = 0; i < this.f12092b.length; i++) {
            clsArr[i] = this.f12092b[i].getClass();
        }
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (name.equals(this.f12091a) && parameterTypes.length == this.f12092b.length && m12038a(this.f12093c).isAssignableFrom(m12038a(method.getReturnType()))) {
                boolean zIsAssignableFrom = true;
                for (int i2 = 0; i2 < parameterTypes.length && zIsAssignableFrom; i2++) {
                    zIsAssignableFrom = m12038a(parameterTypes[i2]).isAssignableFrom(m12038a((Class<?>) clsArr[i2]));
                }
                if (zIsAssignableFrom) {
                    return method;
                }
            }
        }
        return null;
    }
}
