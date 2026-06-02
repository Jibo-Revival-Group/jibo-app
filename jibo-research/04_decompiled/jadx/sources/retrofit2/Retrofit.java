package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.BuiltInConverters;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.ServiceMethod;

/* JADX INFO: loaded from: classes2.dex */
public final class Retrofit {

    /* JADX INFO: renamed from: a */
    final Call.Factory f16310a;

    /* JADX INFO: renamed from: b */
    final HttpUrl f16311b;

    /* JADX INFO: renamed from: c */
    final List<Converter.Factory> f16312c;

    /* JADX INFO: renamed from: d */
    final List<CallAdapter.Factory> f16313d;

    /* JADX INFO: renamed from: e */
    final Executor f16314e;

    /* JADX INFO: renamed from: f */
    final boolean f16315f;

    /* JADX INFO: renamed from: g */
    private final Map<Method, ServiceMethod<?, ?>> f16316g = new ConcurrentHashMap();

    Retrofit(Call.Factory factory, HttpUrl httpUrl, List<Converter.Factory> list, List<CallAdapter.Factory> list2, Executor executor, boolean z) {
        this.f16310a = factory;
        this.f16311b = httpUrl;
        this.f16312c = Collections.unmodifiableList(list);
        this.f16313d = Collections.unmodifiableList(list2);
        this.f16314e = executor;
        this.f16315f = z;
    }

    /* JADX INFO: renamed from: a */
    public <T> T m17124a(final Class<T> cls) {
        Utils.m17168a((Class) cls);
        if (this.f16315f) {
            m17123b(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: retrofit2.Retrofit.1

            /* JADX INFO: renamed from: c */
            private final Platform f16319c = Platform.m17102a();

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (this.f16319c.mo17106a(method)) {
                    return this.f16319c.mo17104a(method, cls, obj, objArr);
                }
                ServiceMethod<?, ?> serviceMethodM17131a = Retrofit.this.m17131a(method);
                return serviceMethodM17131a.f16330d.mo17081a(new OkHttpCall(serviceMethodM17131a, objArr));
            }
        });
    }

    /* JADX INFO: renamed from: b */
    private void m17123b(Class<?> cls) {
        Platform platformM17102a = Platform.m17102a();
        for (Method method : cls.getDeclaredMethods()) {
            if (!platformM17102a.mo17106a(method)) {
                m17131a(method);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    ServiceMethod<?, ?> m17131a(Method method) {
        ServiceMethod serviceMethodM17157a = this.f16316g.get(method);
        if (serviceMethodM17157a == null) {
            synchronized (this.f16316g) {
                serviceMethodM17157a = this.f16316g.get(method);
                if (serviceMethodM17157a == null) {
                    serviceMethodM17157a = new ServiceMethod.Builder(this, method).m17157a();
                    this.f16316g.put(method, serviceMethodM17157a);
                }
            }
        }
        return serviceMethodM17157a;
    }

    /* JADX INFO: renamed from: a */
    public Call.Factory m17125a() {
        return this.f16310a;
    }

    /* JADX INFO: renamed from: b */
    public HttpUrl m17132b() {
        return this.f16311b;
    }

    /* JADX INFO: renamed from: a */
    public CallAdapter<?, ?> m17126a(Type type, Annotation[] annotationArr) {
        return m17127a((CallAdapter.Factory) null, type, annotationArr);
    }

    /* JADX INFO: renamed from: a */
    public CallAdapter<?, ?> m17127a(CallAdapter.Factory factory, Type type, Annotation[] annotationArr) {
        Utils.m17162a(type, "returnType == null");
        Utils.m17162a(annotationArr, "annotations == null");
        int iIndexOf = this.f16313d.indexOf(factory) + 1;
        int size = this.f16313d.size();
        for (int i = iIndexOf; i < size; i++) {
            CallAdapter<?, ?> callAdapterMo17084a = this.f16313d.get(i).mo17084a(type, annotationArr, this);
            if (callAdapterMo17084a != null) {
                return callAdapterMo17084a;
            }
        }
        StringBuilder sbAppend = new StringBuilder("Could not locate call adapter for ").append(type).append(".\n");
        if (factory != null) {
            sbAppend.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sbAppend.append("\n   * ").append(this.f16313d.get(i2).getClass().getName());
            }
            sbAppend.append('\n');
        }
        sbAppend.append("  Tried:");
        int size2 = this.f16313d.size();
        while (iIndexOf < size2) {
            sbAppend.append("\n   * ").append(this.f16313d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sbAppend.toString());
    }

    /* JADX INFO: renamed from: a */
    public <T> Converter<T, RequestBody> m17128a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return m17130a(null, type, annotationArr, annotationArr2);
    }

    /* JADX INFO: renamed from: a */
    public <T> Converter<T, RequestBody> m17130a(Converter.Factory factory, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Utils.m17162a(type, "type == null");
        Utils.m17162a(annotationArr, "parameterAnnotations == null");
        Utils.m17162a(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f16312c.indexOf(factory) + 1;
        int size = this.f16312c.size();
        for (int i = iIndexOf; i < size; i++) {
            Converter<T, RequestBody> converter = (Converter<T, RequestBody>) this.f16312c.get(i).mo17075a(type, annotationArr, annotationArr2, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sbAppend = new StringBuilder("Could not locate RequestBody converter for ").append(type).append(".\n");
        if (factory != null) {
            sbAppend.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sbAppend.append("\n   * ").append(this.f16312c.get(i2).getClass().getName());
            }
            sbAppend.append('\n');
        }
        sbAppend.append("  Tried:");
        int size2 = this.f16312c.size();
        while (iIndexOf < size2) {
            sbAppend.append("\n   * ").append(this.f16312c.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sbAppend.toString());
    }

    /* JADX INFO: renamed from: b */
    public <T> Converter<ResponseBody, T> m17133b(Type type, Annotation[] annotationArr) {
        return m17129a((Converter.Factory) null, type, annotationArr);
    }

    /* JADX INFO: renamed from: a */
    public <T> Converter<ResponseBody, T> m17129a(Converter.Factory factory, Type type, Annotation[] annotationArr) {
        Utils.m17162a(type, "type == null");
        Utils.m17162a(annotationArr, "annotations == null");
        int iIndexOf = this.f16312c.indexOf(factory) + 1;
        int size = this.f16312c.size();
        for (int i = iIndexOf; i < size; i++) {
            Converter<ResponseBody, T> converter = (Converter<ResponseBody, T>) this.f16312c.get(i).mo17074a(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sbAppend = new StringBuilder("Could not locate ResponseBody converter for ").append(type).append(".\n");
        if (factory != null) {
            sbAppend.append("  Skipped:");
            for (int i2 = 0; i2 < iIndexOf; i2++) {
                sbAppend.append("\n   * ").append(this.f16312c.get(i2).getClass().getName());
            }
            sbAppend.append('\n');
        }
        sbAppend.append("  Tried:");
        int size2 = this.f16312c.size();
        while (iIndexOf < size2) {
            sbAppend.append("\n   * ").append(this.f16312c.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sbAppend.toString());
    }

    /* JADX INFO: renamed from: c */
    public <T> Converter<T, String> m17134c(Type type, Annotation[] annotationArr) {
        Utils.m17162a(type, "type == null");
        Utils.m17162a(annotationArr, "annotations == null");
        int size = this.f16312c.size();
        for (int i = 0; i < size; i++) {
            Converter<T, String> converter = (Converter<T, String>) this.f16312c.get(i).m17085b(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        return BuiltInConverters.ToStringConverter.f16237a;
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        private final Platform f16320a;

        /* JADX INFO: renamed from: b */
        private Call.Factory f16321b;

        /* JADX INFO: renamed from: c */
        private HttpUrl f16322c;

        /* JADX INFO: renamed from: d */
        private final List<Converter.Factory> f16323d;

        /* JADX INFO: renamed from: e */
        private final List<CallAdapter.Factory> f16324e;

        /* JADX INFO: renamed from: f */
        private Executor f16325f;

        /* JADX INFO: renamed from: g */
        private boolean f16326g;

        Builder(Platform platform) {
            this.f16323d = new ArrayList();
            this.f16324e = new ArrayList();
            this.f16320a = platform;
            this.f16323d.add(new BuiltInConverters());
        }

        public Builder() {
            this(Platform.m17102a());
        }

        /* JADX INFO: renamed from: a */
        public Builder m17138a(OkHttpClient okHttpClient) {
            return m17136a((Call.Factory) Utils.m17162a(okHttpClient, "client == null"));
        }

        /* JADX INFO: renamed from: a */
        public Builder m17136a(Call.Factory factory) {
            this.f16321b = (Call.Factory) Utils.m17162a(factory, "factory == null");
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m17135a(String str) {
            Utils.m17162a(str, "baseUrl == null");
            HttpUrl httpUrlM15645e = HttpUrl.m15645e(str);
            if (httpUrlM15645e == null) {
                throw new IllegalArgumentException("Illegal URL: " + str);
            }
            return m17137a(httpUrlM15645e);
        }

        /* JADX INFO: renamed from: a */
        public Builder m17137a(HttpUrl httpUrl) {
            Utils.m17162a(httpUrl, "baseUrl == null");
            if (!"".equals(httpUrl.m15658k().get(r0.size() - 1))) {
                throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
            }
            this.f16322c = httpUrl;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m17139a(Converter.Factory factory) {
            this.f16323d.add((Converter.Factory) Utils.m17162a(factory, "factory == null"));
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Retrofit m17140a() {
            if (this.f16322c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            Call.Factory okHttpClient = this.f16321b;
            if (okHttpClient == null) {
                okHttpClient = new OkHttpClient();
            }
            Executor executorMo17107b = this.f16325f;
            if (executorMo17107b == null) {
                executorMo17107b = this.f16320a.mo17107b();
            }
            ArrayList arrayList = new ArrayList(this.f16324e);
            arrayList.add(this.f16320a.mo17105a(executorMo17107b));
            return new Retrofit(okHttpClient, this.f16322c, new ArrayList(this.f16323d), arrayList, executorMo17107b, this.f16326g);
        }
    }
}
