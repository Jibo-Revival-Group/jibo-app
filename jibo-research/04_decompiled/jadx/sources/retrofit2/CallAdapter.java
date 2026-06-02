package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public interface CallAdapter<R, T> {
    /* JADX INFO: renamed from: a */
    T mo17081a(Call<R> call);

    /* JADX INFO: renamed from: a */
    Type mo17082a();

    public static abstract class Factory {
        /* JADX INFO: renamed from: a */
        public abstract CallAdapter<?, ?> mo17084a(Type type, Annotation[] annotationArr, Retrofit retrofit);

        /* JADX INFO: renamed from: a */
        protected static Class<?> m17083a(Type type) {
            return Utils.m17160a(type);
        }
    }
}
