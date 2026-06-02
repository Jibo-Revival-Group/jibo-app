package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;

/* JADX INFO: loaded from: classes2.dex */
final class DefaultCallAdapterFactory extends CallAdapter.Factory {

    /* JADX INFO: renamed from: a */
    static final CallAdapter.Factory f16239a = new DefaultCallAdapterFactory();

    DefaultCallAdapterFactory() {
    }

    @Override // retrofit2.CallAdapter.Factory
    /* JADX INFO: renamed from: a */
    public CallAdapter<?, ?> mo17084a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (m17083a(type) != Call.class) {
            return null;
        }
        final Type typeM17176e = Utils.m17176e(type);
        return new CallAdapter<Object, Call<?>>() { // from class: retrofit2.DefaultCallAdapterFactory.1
            @Override // retrofit2.CallAdapter
            /* JADX INFO: renamed from: a */
            public Type mo17082a() {
                return typeM17176e;
            }

            @Override // retrofit2.CallAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Call<Object> mo17081a(Call<Object> call) {
                return call;
            }
        };
    }
}
