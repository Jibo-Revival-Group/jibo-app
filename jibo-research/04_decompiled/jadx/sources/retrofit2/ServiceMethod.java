package retrofit2;

import com.google.api.client.http.HttpMethods;
import com.yalantis.ucrop.util.FileUtils;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.apache.http.entity.mime.MIME;
import retrofit2.ParameterHandler;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes2.dex */
final class ServiceMethod<R, T> {

    /* JADX INFO: renamed from: a */
    static final Pattern f16327a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* JADX INFO: renamed from: b */
    static final Pattern f16328b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* JADX INFO: renamed from: c */
    final Call.Factory f16329c;

    /* JADX INFO: renamed from: d */
    final CallAdapter<R, T> f16330d;

    /* JADX INFO: renamed from: e */
    private final HttpUrl f16331e;

    /* JADX INFO: renamed from: f */
    private final Converter<ResponseBody, R> f16332f;

    /* JADX INFO: renamed from: g */
    private final String f16333g;

    /* JADX INFO: renamed from: h */
    private final String f16334h;

    /* JADX INFO: renamed from: i */
    private final Headers f16335i;

    /* JADX INFO: renamed from: j */
    private final MediaType f16336j;

    /* JADX INFO: renamed from: k */
    private final boolean f16337k;

    /* JADX INFO: renamed from: l */
    private final boolean f16338l;

    /* JADX INFO: renamed from: m */
    private final boolean f16339m;

    /* JADX INFO: renamed from: n */
    private final ParameterHandler<?>[] f16340n;

    ServiceMethod(Builder<R, T> builder) {
        this.f16329c = builder.f16341a.m17125a();
        this.f16330d = builder.f16363w;
        this.f16331e = builder.f16341a.m17132b();
        this.f16332f = builder.f16362v;
        this.f16333g = builder.f16353m;
        this.f16334h = builder.f16357q;
        this.f16335i = builder.f16358r;
        this.f16336j = builder.f16359s;
        this.f16337k = builder.f16354n;
        this.f16338l = builder.f16355o;
        this.f16339m = builder.f16356p;
        this.f16340n = builder.f16361u;
    }

    /* JADX INFO: renamed from: a */
    Request m17144a(Object... objArr) throws IOException {
        RequestBuilder requestBuilder = new RequestBuilder(this.f16333g, this.f16331e, this.f16334h, this.f16335i, this.f16336j, this.f16337k, this.f16338l, this.f16339m);
        ParameterHandler<?>[] parameterHandlerArr = this.f16340n;
        int length = objArr != null ? objArr.length : 0;
        if (length != parameterHandlerArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + parameterHandlerArr.length + ")");
        }
        for (int i = 0; i < length; i++) {
            parameterHandlerArr[i].mo17095a(requestBuilder, objArr[i]);
        }
        return requestBuilder.m17110a();
    }

    /* JADX INFO: renamed from: a */
    R m17143a(ResponseBody responseBody) throws IOException {
        return this.f16332f.mo17076a(responseBody);
    }

    static final class Builder<T, R> {

        /* JADX INFO: renamed from: a */
        final Retrofit f16341a;

        /* JADX INFO: renamed from: b */
        final Method f16342b;

        /* JADX INFO: renamed from: c */
        final Annotation[] f16343c;

        /* JADX INFO: renamed from: d */
        final Annotation[][] f16344d;

        /* JADX INFO: renamed from: e */
        final Type[] f16345e;

        /* JADX INFO: renamed from: f */
        Type f16346f;

        /* JADX INFO: renamed from: g */
        boolean f16347g;

        /* JADX INFO: renamed from: h */
        boolean f16348h;

        /* JADX INFO: renamed from: i */
        boolean f16349i;

        /* JADX INFO: renamed from: j */
        boolean f16350j;

        /* JADX INFO: renamed from: k */
        boolean f16351k;

        /* JADX INFO: renamed from: l */
        boolean f16352l;

        /* JADX INFO: renamed from: m */
        String f16353m;

        /* JADX INFO: renamed from: n */
        boolean f16354n;

        /* JADX INFO: renamed from: o */
        boolean f16355o;

        /* JADX INFO: renamed from: p */
        boolean f16356p;

        /* JADX INFO: renamed from: q */
        String f16357q;

        /* JADX INFO: renamed from: r */
        Headers f16358r;

        /* JADX INFO: renamed from: s */
        MediaType f16359s;

        /* JADX INFO: renamed from: t */
        Set<String> f16360t;

        /* JADX INFO: renamed from: u */
        ParameterHandler<?>[] f16361u;

        /* JADX INFO: renamed from: v */
        Converter<ResponseBody, T> f16362v;

        /* JADX INFO: renamed from: w */
        CallAdapter<T, R> f16363w;

        Builder(Retrofit retrofit, Method method) {
            this.f16341a = retrofit;
            this.f16342b = method;
            this.f16343c = method.getAnnotations();
            this.f16345e = method.getGenericParameterTypes();
            this.f16344d = method.getParameterAnnotations();
        }

        /* JADX INFO: renamed from: a */
        public ServiceMethod m17157a() {
            this.f16363w = m17155b();
            this.f16346f = this.f16363w.mo17082a();
            if (this.f16346f == Response.class || this.f16346f == okhttp3.Response.class) {
                throw m17146a("'" + Utils.m17160a(this.f16346f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
            }
            this.f16362v = m17156c();
            for (Annotation annotation : this.f16343c) {
                m17154a(annotation);
            }
            if (this.f16353m == null) {
                throw m17146a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f16354n) {
                if (this.f16356p) {
                    throw m17146a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.f16355o) {
                    throw m17146a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f16344d.length;
            this.f16361u = new ParameterHandler[length];
            for (int i = 0; i < length; i++) {
                Type type = this.f16345e[i];
                if (Utils.m17175d(type)) {
                    throw m17145a(i, "Parameter type must not include a type variable or wildcard: %s", type);
                }
                Annotation[] annotationArr = this.f16344d[i];
                if (annotationArr == null) {
                    throw m17145a(i, "No Retrofit annotation found.", new Object[0]);
                }
                this.f16361u[i] = m17150a(i, type, annotationArr);
            }
            if (this.f16357q == null && !this.f16352l) {
                throw m17146a("Missing either @%s URL or @Url parameter.", this.f16353m);
            }
            if (!this.f16355o && !this.f16356p && !this.f16354n && this.f16349i) {
                throw m17146a("Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (this.f16355o && !this.f16347g) {
                throw m17146a("Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (this.f16356p && !this.f16348h) {
                throw m17146a("Multipart method must contain at least one @Part.", new Object[0]);
            }
            return new ServiceMethod(this);
        }

        /* JADX INFO: renamed from: b */
        private CallAdapter<T, R> m17155b() {
            Type genericReturnType = this.f16342b.getGenericReturnType();
            if (Utils.m17175d(genericReturnType)) {
                throw m17146a("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            }
            if (genericReturnType == Void.TYPE) {
                throw m17146a("Service methods cannot return void.", new Object[0]);
            }
            try {
                return (CallAdapter<T, R>) this.f16341a.m17126a(genericReturnType, this.f16342b.getAnnotations());
            } catch (RuntimeException e) {
                throw m17148a(e, "Unable to create call adapter for %s", genericReturnType);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m17154a(Annotation annotation) {
            if (annotation instanceof DELETE) {
                m17153a(HttpMethods.DELETE, ((DELETE) annotation).m17179a(), false);
                return;
            }
            if (annotation instanceof GET) {
                m17153a(HttpMethods.GET, ((GET) annotation).m17183a(), false);
                return;
            }
            if (annotation instanceof HEAD) {
                m17153a(HttpMethods.HEAD, ((HEAD) annotation).m17184a(), false);
                if (!Void.class.equals(this.f16346f)) {
                    throw m17146a("HEAD method must use Void as response type.", new Object[0]);
                }
                return;
            }
            if (annotation instanceof PATCH) {
                m17153a(HttpMethods.PATCH, ((PATCH) annotation).m17191a(), true);
                return;
            }
            if (annotation instanceof POST) {
                m17153a(HttpMethods.POST, ((POST) annotation).m17192a(), true);
                return;
            }
            if (annotation instanceof PUT) {
                m17153a(HttpMethods.PUT, ((PUT) annotation).m17193a(), true);
                return;
            }
            if (annotation instanceof OPTIONS) {
                m17153a(HttpMethods.OPTIONS, ((OPTIONS) annotation).m17190a(), false);
                return;
            }
            if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                m17153a(http.m17185a(), http.m17186b(), http.m17187c());
                return;
            }
            if (annotation instanceof retrofit2.http.Headers) {
                String[] strArrM17189a = ((retrofit2.http.Headers) annotation).m17189a();
                if (strArrM17189a.length == 0) {
                    throw m17146a("@Headers annotation is empty.", new Object[0]);
                }
                this.f16358r = m17149a(strArrM17189a);
                return;
            }
            if (annotation instanceof Multipart) {
                if (this.f16355o) {
                    throw m17146a("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f16356p = true;
            } else if (annotation instanceof FormUrlEncoded) {
                if (this.f16356p) {
                    throw m17146a("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f16355o = true;
            }
        }

        /* JADX INFO: renamed from: a */
        private void m17153a(String str, String str2, boolean z) {
            if (this.f16353m != null) {
                throw m17146a("Only one HTTP method is allowed. Found: %s and %s.", this.f16353m, str);
            }
            this.f16353m = str;
            this.f16354n = z;
            if (!str2.isEmpty()) {
                int iIndexOf = str2.indexOf(63);
                if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                    String strSubstring = str2.substring(iIndexOf + 1);
                    if (ServiceMethod.f16327a.matcher(strSubstring).find()) {
                        throw m17146a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                    }
                }
                this.f16357q = str2;
                this.f16360t = ServiceMethod.m17142a(str2);
            }
        }

        /* JADX INFO: renamed from: a */
        private Headers m17149a(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int iIndexOf = str.indexOf(58);
                if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                    throw m17146a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String strSubstring = str.substring(0, iIndexOf);
                String strTrim = str.substring(iIndexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                    MediaType mediaTypeM15695a = MediaType.m15695a(strTrim);
                    if (mediaTypeM15695a == null) {
                        throw m17146a("Malformed content type: %s", strTrim);
                    }
                    this.f16359s = mediaTypeM15695a;
                } else {
                    builder.m15625a(strSubstring, strTrim);
                }
            }
            return builder.m15626a();
        }

        /* JADX INFO: renamed from: a */
        private ParameterHandler<?> m17150a(int i, Type type, Annotation[] annotationArr) {
            ParameterHandler<?> parameterHandler = null;
            for (Annotation annotation : annotationArr) {
                ParameterHandler<?> parameterHandlerM17151a = m17151a(i, type, annotationArr, annotation);
                if (parameterHandlerM17151a != null) {
                    if (parameterHandler != null) {
                        throw m17145a(i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                    parameterHandler = parameterHandlerM17151a;
                }
            }
            if (parameterHandler == null) {
                throw m17145a(i, "No Retrofit annotation found.", new Object[0]);
            }
            return parameterHandler;
        }

        /* JADX INFO: renamed from: a */
        private ParameterHandler<?> m17151a(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof Url) {
                if (this.f16352l) {
                    throw m17145a(i, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.f16350j) {
                    throw m17145a(i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f16351k) {
                    throw m17145a(i, "A @Url parameter must not come after a @Query", new Object[0]);
                }
                if (this.f16357q != null) {
                    throw m17145a(i, "@Url cannot be used with @%s URL", this.f16353m);
                }
                this.f16352l = true;
                if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new ParameterHandler.RelativeUrl();
                }
                throw m17145a(i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof Path) {
                if (this.f16351k) {
                    throw m17145a(i, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f16352l) {
                    throw m17145a(i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f16357q == null) {
                    throw m17145a(i, "@Path can only be used with relative url on @%s", this.f16353m);
                }
                this.f16350j = true;
                Path path = (Path) annotation;
                String strM17197a = path.m17197a();
                m17152a(i, strM17197a);
                return new ParameterHandler.Path(strM17197a, this.f16341a.m17134c(type, annotationArr), path.m17198b());
            }
            if (annotation instanceof Query) {
                Query query = (Query) annotation;
                String strM17199a = query.m17199a();
                boolean zM17200b = query.m17200b();
                Class<?> clsM17160a = Utils.m17160a(type);
                this.f16351k = true;
                if (Iterable.class.isAssignableFrom(clsM17160a)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw m17145a(i, clsM17160a.getSimpleName() + " must include generic type (e.g., " + clsM17160a.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new ParameterHandler.Query(strM17199a, this.f16341a.m17134c(Utils.m17163a(0, (ParameterizedType) type), annotationArr), zM17200b).m17094a();
                }
                if (clsM17160a.isArray()) {
                    return new ParameterHandler.Query(strM17199a, this.f16341a.m17134c(ServiceMethod.m17141a(clsM17160a.getComponentType()), annotationArr), zM17200b).m17096b();
                }
                return new ParameterHandler.Query(strM17199a, this.f16341a.m17134c(type, annotationArr), zM17200b);
            }
            if (annotation instanceof QueryName) {
                boolean zM17202a = ((QueryName) annotation).m17202a();
                Class<?> clsM17160a2 = Utils.m17160a(type);
                this.f16351k = true;
                if (Iterable.class.isAssignableFrom(clsM17160a2)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw m17145a(i, clsM17160a2.getSimpleName() + " must include generic type (e.g., " + clsM17160a2.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new ParameterHandler.QueryName(this.f16341a.m17134c(Utils.m17163a(0, (ParameterizedType) type), annotationArr), zM17202a).m17094a();
                }
                if (clsM17160a2.isArray()) {
                    return new ParameterHandler.QueryName(this.f16341a.m17134c(ServiceMethod.m17141a(clsM17160a2.getComponentType()), annotationArr), zM17202a).m17096b();
                }
                return new ParameterHandler.QueryName(this.f16341a.m17134c(type, annotationArr), zM17202a);
            }
            if (annotation instanceof QueryMap) {
                Class<?> clsM17160a3 = Utils.m17160a(type);
                if (!Map.class.isAssignableFrom(clsM17160a3)) {
                    throw m17145a(i, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type typeM17173b = Utils.m17173b(type, clsM17160a3, Map.class);
                if (!(typeM17173b instanceof ParameterizedType)) {
                    throw m17145a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) typeM17173b;
                Type typeM17163a = Utils.m17163a(0, parameterizedType);
                if (String.class != typeM17163a) {
                    throw m17145a(i, "@QueryMap keys must be of type String: " + typeM17163a, new Object[0]);
                }
                return new ParameterHandler.QueryMap(this.f16341a.m17134c(Utils.m17163a(1, parameterizedType), annotationArr), ((QueryMap) annotation).m17201a());
            }
            if (annotation instanceof Header) {
                String strM17188a = ((Header) annotation).m17188a();
                Class<?> clsM17160a4 = Utils.m17160a(type);
                if (Iterable.class.isAssignableFrom(clsM17160a4)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw m17145a(i, clsM17160a4.getSimpleName() + " must include generic type (e.g., " + clsM17160a4.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new ParameterHandler.Header(strM17188a, this.f16341a.m17134c(Utils.m17163a(0, (ParameterizedType) type), annotationArr)).m17094a();
                }
                if (clsM17160a4.isArray()) {
                    return new ParameterHandler.Header(strM17188a, this.f16341a.m17134c(ServiceMethod.m17141a(clsM17160a4.getComponentType()), annotationArr)).m17096b();
                }
                return new ParameterHandler.Header(strM17188a, this.f16341a.m17134c(type, annotationArr));
            }
            if (annotation instanceof HeaderMap) {
                Class<?> clsM17160a5 = Utils.m17160a(type);
                if (!Map.class.isAssignableFrom(clsM17160a5)) {
                    throw m17145a(i, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type typeM17173b2 = Utils.m17173b(type, clsM17160a5, Map.class);
                if (!(typeM17173b2 instanceof ParameterizedType)) {
                    throw m17145a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) typeM17173b2;
                Type typeM17163a2 = Utils.m17163a(0, parameterizedType2);
                if (String.class != typeM17163a2) {
                    throw m17145a(i, "@HeaderMap keys must be of type String: " + typeM17163a2, new Object[0]);
                }
                return new ParameterHandler.HeaderMap(this.f16341a.m17134c(Utils.m17163a(1, parameterizedType2), annotationArr));
            }
            if (annotation instanceof Field) {
                if (!this.f16355o) {
                    throw m17145a(i, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                Field field = (Field) annotation;
                String strM17180a = field.m17180a();
                boolean zM17181b = field.m17181b();
                this.f16347g = true;
                Class<?> clsM17160a6 = Utils.m17160a(type);
                if (Iterable.class.isAssignableFrom(clsM17160a6)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw m17145a(i, clsM17160a6.getSimpleName() + " must include generic type (e.g., " + clsM17160a6.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new ParameterHandler.Field(strM17180a, this.f16341a.m17134c(Utils.m17163a(0, (ParameterizedType) type), annotationArr), zM17181b).m17094a();
                }
                if (clsM17160a6.isArray()) {
                    return new ParameterHandler.Field(strM17180a, this.f16341a.m17134c(ServiceMethod.m17141a(clsM17160a6.getComponentType()), annotationArr), zM17181b).m17096b();
                }
                return new ParameterHandler.Field(strM17180a, this.f16341a.m17134c(type, annotationArr), zM17181b);
            }
            if (annotation instanceof FieldMap) {
                if (!this.f16355o) {
                    throw m17145a(i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> clsM17160a7 = Utils.m17160a(type);
                if (!Map.class.isAssignableFrom(clsM17160a7)) {
                    throw m17145a(i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type typeM17173b3 = Utils.m17173b(type, clsM17160a7, Map.class);
                if (!(typeM17173b3 instanceof ParameterizedType)) {
                    throw m17145a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) typeM17173b3;
                Type typeM17163a3 = Utils.m17163a(0, parameterizedType3);
                if (String.class != typeM17163a3) {
                    throw m17145a(i, "@FieldMap keys must be of type String: " + typeM17163a3, new Object[0]);
                }
                Converter<T, String> converterM17134c = this.f16341a.m17134c(Utils.m17163a(1, parameterizedType3), annotationArr);
                this.f16347g = true;
                return new ParameterHandler.FieldMap(converterM17134c, ((FieldMap) annotation).m17182a());
            }
            if (annotation instanceof Part) {
                if (!this.f16356p) {
                    throw m17145a(i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                Part part = (Part) annotation;
                this.f16348h = true;
                String strM17194a = part.m17194a();
                Class<?> clsM17160a8 = Utils.m17160a(type);
                if (strM17194a.isEmpty()) {
                    if (Iterable.class.isAssignableFrom(clsM17160a8)) {
                        if (!(type instanceof ParameterizedType)) {
                            throw m17145a(i, clsM17160a8.getSimpleName() + " must include generic type (e.g., " + clsM17160a8.getSimpleName() + "<String>)", new Object[0]);
                        }
                        if (!MultipartBody.Part.class.isAssignableFrom(Utils.m17160a(Utils.m17163a(0, (ParameterizedType) type)))) {
                            throw m17145a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        return ParameterHandler.RawPart.f16291a.m17094a();
                    }
                    if (clsM17160a8.isArray()) {
                        if (!MultipartBody.Part.class.isAssignableFrom(clsM17160a8.getComponentType())) {
                            throw m17145a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        return ParameterHandler.RawPart.f16291a.m17096b();
                    }
                    if (MultipartBody.Part.class.isAssignableFrom(clsM17160a8)) {
                        return ParameterHandler.RawPart.f16291a;
                    }
                    throw m17145a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                Headers headersM15616a = Headers.m15616a(MIME.CONTENT_DISPOSITION, "form-data; name=\"" + strM17194a + "\"", MIME.CONTENT_TRANSFER_ENC, part.m17195b());
                if (Iterable.class.isAssignableFrom(clsM17160a8)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw m17145a(i, clsM17160a8.getSimpleName() + " must include generic type (e.g., " + clsM17160a8.getSimpleName() + "<String>)", new Object[0]);
                    }
                    Type typeM17163a4 = Utils.m17163a(0, (ParameterizedType) type);
                    if (MultipartBody.Part.class.isAssignableFrom(Utils.m17160a(typeM17163a4))) {
                        throw m17145a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new ParameterHandler.Part(headersM15616a, this.f16341a.m17128a(typeM17163a4, annotationArr, this.f16343c)).m17094a();
                }
                if (clsM17160a8.isArray()) {
                    Class<?> clsM17141a = ServiceMethod.m17141a(clsM17160a8.getComponentType());
                    if (MultipartBody.Part.class.isAssignableFrom(clsM17141a)) {
                        throw m17145a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new ParameterHandler.Part(headersM15616a, this.f16341a.m17128a(clsM17141a, annotationArr, this.f16343c)).m17096b();
                }
                if (MultipartBody.Part.class.isAssignableFrom(clsM17160a8)) {
                    throw m17145a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new ParameterHandler.Part(headersM15616a, this.f16341a.m17128a(type, annotationArr, this.f16343c));
            }
            if (annotation instanceof PartMap) {
                if (!this.f16356p) {
                    throw m17145a(i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.f16348h = true;
                Class<?> clsM17160a9 = Utils.m17160a(type);
                if (!Map.class.isAssignableFrom(clsM17160a9)) {
                    throw m17145a(i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type typeM17173b4 = Utils.m17173b(type, clsM17160a9, Map.class);
                if (!(typeM17173b4 instanceof ParameterizedType)) {
                    throw m17145a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) typeM17173b4;
                Type typeM17163a5 = Utils.m17163a(0, parameterizedType4);
                if (String.class != typeM17163a5) {
                    throw m17145a(i, "@PartMap keys must be of type String: " + typeM17163a5, new Object[0]);
                }
                Type typeM17163a6 = Utils.m17163a(1, parameterizedType4);
                if (MultipartBody.Part.class.isAssignableFrom(Utils.m17160a(typeM17163a6))) {
                    throw m17145a(i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                }
                return new ParameterHandler.PartMap(this.f16341a.m17128a(typeM17163a6, annotationArr, this.f16343c), ((PartMap) annotation).m17196a());
            }
            if (annotation instanceof Body) {
                if (this.f16355o || this.f16356p) {
                    throw m17145a(i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                }
                if (this.f16349i) {
                    throw m17145a(i, "Multiple @Body method annotations found.", new Object[0]);
                }
                try {
                    Converter<T, RequestBody> converterM17128a = this.f16341a.m17128a(type, annotationArr, this.f16343c);
                    this.f16349i = true;
                    return new ParameterHandler.Body(converterM17128a);
                } catch (RuntimeException e) {
                    throw m17147a(e, i, "Unable to create @Body converter for %s", type);
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: a */
        private void m17152a(int i, String str) {
            if (!ServiceMethod.f16328b.matcher(str).matches()) {
                throw m17145a(i, "@Path parameter name must match %s. Found: %s", ServiceMethod.f16327a.pattern(), str);
            }
            if (!this.f16360t.contains(str)) {
                throw m17145a(i, "URL \"%s\" does not contain \"{%s}\".", this.f16357q, str);
            }
        }

        /* JADX INFO: renamed from: c */
        private Converter<ResponseBody, T> m17156c() {
            try {
                return this.f16341a.m17133b(this.f16346f, this.f16342b.getAnnotations());
            } catch (RuntimeException e) {
                throw m17148a(e, "Unable to create converter for %s", this.f16346f);
            }
        }

        /* JADX INFO: renamed from: a */
        private RuntimeException m17146a(String str, Object... objArr) {
            return m17148a((Throwable) null, str, objArr);
        }

        /* JADX INFO: renamed from: a */
        private RuntimeException m17148a(Throwable th, String str, Object... objArr) {
            return new IllegalArgumentException(String.format(str, objArr) + "\n    for method " + this.f16342b.getDeclaringClass().getSimpleName() + FileUtils.HIDDEN_PREFIX + this.f16342b.getName(), th);
        }

        /* JADX INFO: renamed from: a */
        private RuntimeException m17147a(Throwable th, int i, String str, Object... objArr) {
            return m17148a(th, str + " (parameter #" + (i + 1) + ")", objArr);
        }

        /* JADX INFO: renamed from: a */
        private RuntimeException m17145a(int i, String str, Object... objArr) {
            return m17146a(str + " (parameter #" + (i + 1) + ")", objArr);
        }
    }

    /* JADX INFO: renamed from: a */
    static Set<String> m17142a(String str) {
        Matcher matcher = f16327a.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    /* JADX INFO: renamed from: a */
    static Class<?> m17141a(Class<?> cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }
}
