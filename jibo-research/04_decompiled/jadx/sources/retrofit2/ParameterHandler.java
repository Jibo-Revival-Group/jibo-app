package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: loaded from: classes2.dex */
abstract class ParameterHandler<T> {
    /* JADX INFO: renamed from: a */
    abstract void mo17095a(RequestBuilder requestBuilder, T t) throws IOException;

    ParameterHandler() {
    }

    /* JADX INFO: renamed from: a */
    final ParameterHandler<Iterable<T>> m17094a() {
        return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.ParameterHandler.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // retrofit2.ParameterHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void mo17095a(RequestBuilder requestBuilder, Iterable<T> iterable) throws IOException {
                if (iterable != null) {
                    Iterator<T> it = iterable.iterator();
                    while (it.hasNext()) {
                        ParameterHandler.this.mo17095a(requestBuilder, it.next());
                    }
                }
            }
        };
    }

    /* JADX INFO: renamed from: b */
    final ParameterHandler<Object> m17096b() {
        return new ParameterHandler<Object>() { // from class: retrofit2.ParameterHandler.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // retrofit2.ParameterHandler
            /* JADX INFO: renamed from: a */
            void mo17095a(RequestBuilder requestBuilder, Object obj) throws IOException {
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i = 0; i < length; i++) {
                        ParameterHandler.this.mo17095a(requestBuilder, Array.get(obj, i));
                    }
                }
            }
        };
    }

    static final class RelativeUrl extends ParameterHandler<Object> {
        RelativeUrl() {
        }

        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: a */
        void mo17095a(RequestBuilder requestBuilder, Object obj) {
            Utils.m17162a(obj, "@Url parameter is null.");
            requestBuilder.m17111a(obj);
        }
    }

    static final class Header<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a */
        private final String f16274a;

        /* JADX INFO: renamed from: b */
        private final Converter<T, String> f16275b;

        Header(String str, Converter<T, String> converter) {
            this.f16274a = (String) Utils.m17162a(str, "name == null");
            this.f16275b = converter;
        }

        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: a */
        void mo17095a(RequestBuilder requestBuilder, T t) throws IOException {
            String strMo17076a;
            if (t != null && (strMo17076a = this.f16275b.mo17076a(t)) != null) {
                requestBuilder.m17112a(this.f16274a, strMo17076a);
            }
        }
    }

    static final class Path<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a */
        private final String f16281a;

        /* JADX INFO: renamed from: b */
        private final Converter<T, String> f16282b;

        /* JADX INFO: renamed from: c */
        private final boolean f16283c;

        Path(String str, Converter<T, String> converter, boolean z) {
            this.f16281a = (String) Utils.m17162a(str, "name == null");
            this.f16282b = converter;
            this.f16283c = z;
        }

        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: a */
        void mo17095a(RequestBuilder requestBuilder, T t) throws IOException {
            if (t == null) {
                throw new IllegalArgumentException("Path parameter \"" + this.f16281a + "\" value must not be null.");
            }
            requestBuilder.m17113a(this.f16281a, this.f16282b.mo17076a(t), this.f16283c);
        }
    }

    static final class Query<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a */
        private final String f16284a;

        /* JADX INFO: renamed from: b */
        private final Converter<T, String> f16285b;

        /* JADX INFO: renamed from: c */
        private final boolean f16286c;

        Query(String str, Converter<T, String> converter, boolean z) {
            this.f16284a = (String) Utils.m17162a(str, "name == null");
            this.f16285b = converter;
            this.f16286c = z;
        }

        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: a */
        void mo17095a(RequestBuilder requestBuilder, T t) throws IOException {
            String strMo17076a;
            if (t != null && (strMo17076a = this.f16285b.mo17076a(t)) != null) {
                requestBuilder.m17117b(this.f16284a, strMo17076a, this.f16286c);
            }
        }
    }

    static final class QueryName<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a */
        private final Converter<T, String> f16289a;

        /* JADX INFO: renamed from: b */
        private final boolean f16290b;

        QueryName(Converter<T, String> converter, boolean z) {
            this.f16289a = converter;
            this.f16290b = z;
        }

        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: a */
        void mo17095a(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                requestBuilder.m17117b(this.f16289a.mo17076a(t), null, this.f16290b);
            }
        }
    }

    static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {

        /* JADX INFO: renamed from: a */
        private final Converter<T, String> f16287a;

        /* JADX INFO: renamed from: b */
        private final boolean f16288b;

        QueryMap(Converter<T, String> converter, boolean z) {
            this.f16287a = converter;
            this.f16288b = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo17095a(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Query map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Query map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Query map contained null value for key '" + key + "'.");
                }
                String strMo17076a = this.f16287a.mo17076a(value);
                if (strMo17076a == null) {
                    throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.f16287a.getClass().getName() + " for key '" + key + "'.");
                }
                requestBuilder.m17117b(key, strMo17076a, this.f16288b);
            }
        }
    }

    static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {

        /* JADX INFO: renamed from: a */
        private final Converter<T, String> f16276a;

        HeaderMap(Converter<T, String> converter) {
            this.f16276a = converter;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo17095a(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Header map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Header map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Header map contained null value for key '" + key + "'.");
                }
                requestBuilder.m17112a(key, this.f16276a.mo17076a(value));
            }
        }
    }

    static final class Field<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a */
        private final String f16269a;

        /* JADX INFO: renamed from: b */
        private final Converter<T, String> f16270b;

        /* JADX INFO: renamed from: c */
        private final boolean f16271c;

        Field(String str, Converter<T, String> converter, boolean z) {
            this.f16269a = (String) Utils.m17162a(str, "name == null");
            this.f16270b = converter;
            this.f16271c = z;
        }

        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: a */
        void mo17095a(RequestBuilder requestBuilder, T t) throws IOException {
            String strMo17076a;
            if (t != null && (strMo17076a = this.f16270b.mo17076a(t)) != null) {
                requestBuilder.m17118c(this.f16269a, strMo17076a, this.f16271c);
            }
        }
    }

    static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {

        /* JADX INFO: renamed from: a */
        private final Converter<T, String> f16272a;

        /* JADX INFO: renamed from: b */
        private final boolean f16273b;

        FieldMap(Converter<T, String> converter, boolean z) {
            this.f16272a = converter;
            this.f16273b = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo17095a(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Field map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Field map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Field map contained null value for key '" + key + "'.");
                }
                String strMo17076a = this.f16272a.mo17076a(value);
                if (strMo17076a == null) {
                    throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.f16272a.getClass().getName() + " for key '" + key + "'.");
                }
                requestBuilder.m17118c(key, strMo17076a, this.f16273b);
            }
        }
    }

    static final class Part<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a */
        private final Headers f16277a;

        /* JADX INFO: renamed from: b */
        private final Converter<T, RequestBody> f16278b;

        Part(Headers headers, Converter<T, RequestBody> converter) {
            this.f16277a = headers;
            this.f16278b = converter;
        }

        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: a */
        void mo17095a(RequestBuilder requestBuilder, T t) {
            if (t != null) {
                try {
                    requestBuilder.m17114a(this.f16277a, this.f16278b.mo17076a(t));
                } catch (IOException e) {
                    throw new RuntimeException("Unable to convert " + t + " to RequestBody", e);
                }
            }
        }
    }

    static final class RawPart extends ParameterHandler<MultipartBody.Part> {

        /* JADX INFO: renamed from: a */
        static final RawPart f16291a = new RawPart();

        private RawPart() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo17095a(RequestBuilder requestBuilder, MultipartBody.Part part) throws IOException {
            if (part != null) {
                requestBuilder.m17115a(part);
            }
        }
    }

    static final class PartMap<T> extends ParameterHandler<Map<String, T>> {

        /* JADX INFO: renamed from: a */
        private final Converter<T, RequestBody> f16279a;

        /* JADX INFO: renamed from: b */
        private final String f16280b;

        PartMap(Converter<T, RequestBody> converter, String str) {
            this.f16279a = converter;
            this.f16280b = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo17095a(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Part map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Part map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                }
                requestBuilder.m17114a(Headers.m15616a(MIME.CONTENT_DISPOSITION, "form-data; name=\"" + key + "\"", MIME.CONTENT_TRANSFER_ENC, this.f16280b), this.f16279a.mo17076a(value));
            }
        }
    }

    static final class Body<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a */
        private final Converter<T, RequestBody> f16268a;

        Body(Converter<T, RequestBody> converter) {
            this.f16268a = converter;
        }

        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: a */
        void mo17095a(RequestBuilder requestBuilder, T t) {
            if (t == null) {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
            try {
                requestBuilder.m17116a(this.f16268a.mo17076a(t));
            } catch (IOException e) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e);
            }
        }
    }
}
