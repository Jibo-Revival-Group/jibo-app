package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes2.dex */
public interface Converter<F, T> {
    /* JADX INFO: renamed from: a */
    T mo17076a(F f) throws IOException;

    public static abstract class Factory {
        /* JADX INFO: renamed from: a */
        public Converter<ResponseBody, ?> mo17074a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }

        /* JADX INFO: renamed from: a */
        public Converter<?, RequestBody> mo17075a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
            return null;
        }

        /* JADX INFO: renamed from: b */
        public Converter<?, String> m17085b(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }
    }
}
