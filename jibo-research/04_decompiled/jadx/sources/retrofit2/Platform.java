package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import retrofit2.CallAdapter;

/* JADX INFO: loaded from: classes2.dex */
class Platform {

    /* JADX INFO: renamed from: a */
    private static final Platform f16292a = m17103c();

    Platform() {
    }

    /* JADX INFO: renamed from: a */
    static Platform m17102a() {
        return f16292a;
    }

    /* JADX INFO: renamed from: c */
    private static Platform m17103c() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new Android();
            }
        } catch (ClassNotFoundException e) {
        }
        try {
            Class.forName("java.util.Optional");
            return new Java8();
        } catch (ClassNotFoundException e2) {
            return new Platform();
        }
    }

    /* JADX INFO: renamed from: b */
    Executor mo17107b() {
        return null;
    }

    /* JADX INFO: renamed from: a */
    CallAdapter.Factory mo17105a(Executor executor) {
        return executor != null ? new ExecutorCallAdapterFactory(executor) : DefaultCallAdapterFactory.f16239a;
    }

    /* JADX INFO: renamed from: a */
    boolean mo17106a(Method method) {
        return false;
    }

    /* JADX INFO: renamed from: a */
    Object mo17104a(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    static class Java8 extends Platform {
        Java8() {
        }

        @Override // retrofit2.Platform
        /* JADX INFO: renamed from: a */
        boolean mo17106a(Method method) {
            return method.isDefault();
        }

        @Override // retrofit2.Platform
        /* JADX INFO: renamed from: a */
        Object mo17104a(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    static class Android extends Platform {
        Android() {
        }

        @Override // retrofit2.Platform
        /* JADX INFO: renamed from: b */
        public Executor mo17107b() {
            return new MainThreadExecutor();
        }

        @Override // retrofit2.Platform
        /* JADX INFO: renamed from: a */
        CallAdapter.Factory mo17105a(Executor executor) {
            if (executor == null) {
                throw new AssertionError();
            }
            return new ExecutorCallAdapterFactory(executor);
        }

        static class MainThreadExecutor implements Executor {

            /* JADX INFO: renamed from: a */
            private final Handler f16293a = new Handler(Looper.getMainLooper());

            MainThreadExecutor() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f16293a.post(runnable);
            }
        }
    }
}
