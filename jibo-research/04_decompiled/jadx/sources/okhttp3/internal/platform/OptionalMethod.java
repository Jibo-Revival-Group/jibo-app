package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
class OptionalMethod<T> {

    /* JADX INFO: renamed from: a */
    private final Class<?> f15600a;

    /* JADX INFO: renamed from: b */
    private final String f15601b;

    /* JADX INFO: renamed from: c */
    private final Class[] f15602c;

    OptionalMethod(Class<?> cls, String str, Class... clsArr) {
        this.f15600a = cls;
        this.f15601b = str;
        this.f15602c = clsArr;
    }

    /* JADX INFO: renamed from: a */
    public boolean m16196a(T t) {
        return m16193a(t.getClass()) != null;
    }

    /* JADX INFO: renamed from: a */
    public Object m16195a(T t, Object... objArr) throws InvocationTargetException {
        Method methodM16193a = m16193a(t.getClass());
        if (methodM16193a == null) {
            return null;
        }
        try {
            return methodM16193a.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public Object m16197b(T t, Object... objArr) {
        try {
            return m16195a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* JADX INFO: renamed from: c */
    public Object m16198c(T t, Object... objArr) throws InvocationTargetException {
        Method methodM16193a = m16193a(t.getClass());
        if (methodM16193a == null) {
            throw new AssertionError("Method " + this.f15601b + " not supported for object " + t);
        }
        try {
            return methodM16193a.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodM16193a);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    /* JADX INFO: renamed from: d */
    public Object m16199d(T t, Object... objArr) {
        try {
            return m16198c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* JADX INFO: renamed from: a */
    private Method m16193a(Class<?> cls) {
        if (this.f15601b == null) {
            return null;
        }
        Method methodM16194a = m16194a(cls, this.f15601b, this.f15602c);
        if (methodM16194a == null || this.f15600a == null || this.f15600a.isAssignableFrom(methodM16194a.getReturnType())) {
            return methodM16194a;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private static Method m16194a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
                return method;
            } catch (NoSuchMethodException e) {
                return method;
            }
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }
}
