package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import retrofit2.CallAdapter;

/* JADX INFO: loaded from: classes2.dex */
final class ExecutorCallAdapterFactory extends CallAdapter.Factory {

    /* JADX INFO: renamed from: a */
    final Executor f16242a;

    ExecutorCallAdapterFactory(Executor executor) {
        this.f16242a = executor;
    }

    @Override // retrofit2.CallAdapter.Factory
    /* JADX INFO: renamed from: a */
    public CallAdapter<?, ?> mo17084a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (m17083a(type) != Call.class) {
            return null;
        }
        final Type typeM17176e = Utils.m17176e(type);
        return new CallAdapter<Object, Call<?>>() { // from class: retrofit2.ExecutorCallAdapterFactory.1
            @Override // retrofit2.CallAdapter
            /* JADX INFO: renamed from: a */
            public Type mo17082a() {
                return typeM17176e;
            }

            @Override // retrofit2.CallAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Call<Object> mo17081a(Call<Object> call) {
                return new ExecutorCallbackCall(ExecutorCallAdapterFactory.this.f16242a, call);
            }
        };
    }

    static final class ExecutorCallbackCall<T> implements Call<T> {

        /* JADX INFO: renamed from: a */
        final Executor f16245a;

        /* JADX INFO: renamed from: b */
        final Call<T> f16246b;

        ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.f16245a = executor;
            this.f16246b = call;
        }

        @Override // retrofit2.Call
        /* JADX INFO: renamed from: a */
        public void mo17078a(final Callback<T> callback) {
            Utils.m17162a(callback, "callback == null");
            this.f16246b.mo17078a(new Callback<T>() { // from class: retrofit2.ExecutorCallAdapterFactory.ExecutorCallbackCall.1
                @Override // retrofit2.Callback
                /* JADX INFO: renamed from: a */
                public void mo10472a(Call<T> call, final Response<T> response) {
                    ExecutorCallbackCall.this.f16245a.execute(new Runnable() { // from class: retrofit2.ExecutorCallAdapterFactory.ExecutorCallbackCall.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ExecutorCallbackCall.this.f16246b.mo17079a()) {
                                callback.mo10471a(ExecutorCallbackCall.this, new IOException("Canceled"));
                            } else {
                                callback.mo10472a(ExecutorCallbackCall.this, response);
                            }
                        }
                    });
                }

                @Override // retrofit2.Callback
                /* JADX INFO: renamed from: a */
                public void mo10471a(Call<T> call, final Throwable th) {
                    ExecutorCallbackCall.this.f16245a.execute(new Runnable() { // from class: retrofit2.ExecutorCallAdapterFactory.ExecutorCallbackCall.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.mo10471a(ExecutorCallbackCall.this, th);
                        }
                    });
                }
            });
        }

        @Override // retrofit2.Call
        /* JADX INFO: renamed from: a */
        public boolean mo17079a() {
            return this.f16246b.mo17079a();
        }

        @Override // retrofit2.Call
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Call<T> clone() {
            return new ExecutorCallbackCall(this.f16245a, this.f16246b.clone());
        }
    }
}
