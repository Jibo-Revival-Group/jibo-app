package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.http.Streaming;

/* JADX INFO: loaded from: classes2.dex */
final class BuiltInConverters extends Converter.Factory {
    BuiltInConverters() {
    }

    @Override // retrofit2.Converter.Factory
    /* JADX INFO: renamed from: a */
    public Converter<ResponseBody, ?> mo17074a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == ResponseBody.class) {
            if (Utils.m17171a(annotationArr, (Class<? extends Annotation>) Streaming.class)) {
                return StreamingResponseBodyConverter.f16236a;
            }
            return BufferingResponseBodyConverter.f16234a;
        }
        if (type == Void.class) {
            return VoidResponseBodyConverter.f16238a;
        }
        return null;
    }

    @Override // retrofit2.Converter.Factory
    /* JADX INFO: renamed from: a */
    public Converter<?, RequestBody> mo17075a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (RequestBody.class.isAssignableFrom(Utils.m17160a(type))) {
            return RequestBodyConverter.f16235a;
        }
        return null;
    }

    static final class VoidResponseBodyConverter implements Converter<ResponseBody, Void> {

        /* JADX INFO: renamed from: a */
        static final VoidResponseBodyConverter f16238a = new VoidResponseBodyConverter();

        VoidResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public Void mo17076a(ResponseBody responseBody) throws IOException {
            responseBody.close();
            return null;
        }
    }

    static final class RequestBodyConverter implements Converter<RequestBody, RequestBody> {

        /* JADX INFO: renamed from: a */
        static final RequestBodyConverter f16235a = new RequestBodyConverter();

        RequestBodyConverter() {
        }

        @Override // retrofit2.Converter
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public RequestBody mo17076a(RequestBody requestBody) throws IOException {
            return requestBody;
        }
    }

    static final class StreamingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {

        /* JADX INFO: renamed from: a */
        static final StreamingResponseBodyConverter f16236a = new StreamingResponseBodyConverter();

        StreamingResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public ResponseBody mo17076a(ResponseBody responseBody) throws IOException {
            return responseBody;
        }
    }

    static final class BufferingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {

        /* JADX INFO: renamed from: a */
        static final BufferingResponseBodyConverter f16234a = new BufferingResponseBodyConverter();

        BufferingResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public ResponseBody mo17076a(ResponseBody responseBody) throws IOException {
            try {
                return Utils.m17167a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    static final class ToStringConverter implements Converter<Object, String> {

        /* JADX INFO: renamed from: a */
        static final ToStringConverter f16237a = new ToStringConverter();

        ToStringConverter() {
        }

        @Override // retrofit2.Converter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String mo17076a(Object obj) {
            return obj.toString();
        }
    }
}
