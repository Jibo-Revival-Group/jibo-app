package com.bumptech.glide;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.bumptech.glide.util.Util;

/* JADX INFO: loaded from: classes.dex */
public class RequestManager implements LifecycleListener {

    /* JADX INFO: renamed from: a */
    private final Context f4725a;

    /* JADX INFO: renamed from: b */
    private final Lifecycle f4726b;

    /* JADX INFO: renamed from: c */
    private final RequestManagerTreeNode f4727c;

    /* JADX INFO: renamed from: d */
    private final RequestTracker f4728d;

    /* JADX INFO: renamed from: e */
    private final Glide f4729e;

    /* JADX INFO: renamed from: f */
    private final OptionsApplier f4730f;

    /* JADX INFO: renamed from: g */
    private DefaultOptions f4731g;

    public interface DefaultOptions {
        /* JADX INFO: renamed from: a */
        <T> void m5287a(GenericRequestBuilder<T, ?, ?, ?> genericRequestBuilder);
    }

    public RequestManager(Context context, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode) {
        this(context, lifecycle, requestManagerTreeNode, new RequestTracker(), new ConnectivityMonitorFactory());
    }

    RequestManager(Context context, final Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.f4725a = context.getApplicationContext();
        this.f4726b = lifecycle;
        this.f4727c = requestManagerTreeNode;
        this.f4728d = requestTracker;
        this.f4729e = Glide.m5249a(context);
        this.f4730f = new OptionsApplier();
        ConnectivityMonitor connectivityMonitorM5455a = connectivityMonitorFactory.m5455a(context, new RequestManagerConnectivityListener(requestTracker));
        if (Util.m5596c()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bumptech.glide.RequestManager.1
                @Override // java.lang.Runnable
                public void run() {
                    lifecycle.mo5452a(RequestManager.this);
                }
            });
        } else {
            lifecycle.mo5452a(this);
        }
        lifecycle.mo5452a(connectivityMonitorM5455a);
    }

    /* JADX INFO: renamed from: a */
    public void m5282a(int i) {
        this.f4729e.m5260a(i);
    }

    /* JADX INFO: renamed from: a */
    public void m5281a() {
        this.f4729e.m5266e();
    }

    /* JADX INFO: renamed from: b */
    public void m5283b() {
        Util.m5592a();
        this.f4728d.m5479a();
    }

    /* JADX INFO: renamed from: c */
    public void m5284c() {
        Util.m5592a();
        this.f4728d.m5481b();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        m5284c();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        m5283b();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        this.f4728d.m5483c();
    }

    /* JADX INFO: renamed from: a */
    public <A, T> GenericModelRequest<A, T> m5280a(ModelLoader<A, T> modelLoader, Class<T> cls) {
        return new GenericModelRequest<>(modelLoader, cls);
    }

    /* JADX INFO: renamed from: a */
    public DrawableTypeRequest<String> m5279a(String str) {
        return (DrawableTypeRequest) m5285d().mo5225b(str);
    }

    /* JADX INFO: renamed from: d */
    public DrawableTypeRequest<String> m5285d() {
        return m5270a(String.class);
    }

    /* JADX INFO: renamed from: a */
    public DrawableTypeRequest<Integer> m5278a(Integer num) {
        return (DrawableTypeRequest) m5286e().mo5225b(num);
    }

    /* JADX INFO: renamed from: e */
    public DrawableTypeRequest<Integer> m5286e() {
        return (DrawableTypeRequest) m5270a(Integer.class).mo5221b(ApplicationVersionSignature.m5568a(this.f4725a));
    }

    /* JADX INFO: renamed from: a */
    private <T> DrawableTypeRequest<T> m5270a(Class<T> cls) {
        ModelLoader modelLoaderM5251a = Glide.m5251a(cls, this.f4725a);
        ModelLoader modelLoaderM5255b = Glide.m5255b(cls, this.f4725a);
        if (cls != null && modelLoaderM5251a == null && modelLoaderM5255b == null) {
            throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for which there is a registered ModelLoader, if you are using a custom model, you must first call Glide#register with a ModelLoaderFactory for your custom model class");
        }
        return (DrawableTypeRequest) this.f4730f.m5292a(new DrawableTypeRequest(cls, modelLoaderM5251a, modelLoaderM5255b, this.f4725a, this.f4729e, this.f4728d, this.f4726b, this.f4730f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static <T> Class<T> m5273b(T t) {
        if (t != null) {
            return (Class<T>) t.getClass();
        }
        return null;
    }

    public final class GenericModelRequest<A, T> {

        /* JADX INFO: renamed from: b */
        private final ModelLoader<A, T> f4735b;

        /* JADX INFO: renamed from: c */
        private final Class<T> f4736c;

        GenericModelRequest(ModelLoader<A, T> modelLoader, Class<T> cls) {
            this.f4735b = modelLoader;
            this.f4736c = cls;
        }

        /* JADX INFO: renamed from: a */
        public GenericModelRequest<A, T>.GenericTypeRequest m5290a(A a) {
            return new GenericTypeRequest(a);
        }

        public final class GenericTypeRequest {

            /* JADX INFO: renamed from: b */
            private final A f4738b;

            /* JADX INFO: renamed from: c */
            private final Class<A> f4739c;

            /* JADX INFO: renamed from: d */
            private final boolean f4740d = true;

            GenericTypeRequest(A a) {
                this.f4738b = a;
                this.f4739c = RequestManager.m5273b(a);
            }

            /* JADX INFO: renamed from: a */
            public <Z> GenericTranscodeRequest<A, T, Z> m5291a(Class<Z> cls) {
                GenericTranscodeRequest<A, T, Z> genericTranscodeRequest = (GenericTranscodeRequest) RequestManager.this.f4730f.m5292a(new GenericTranscodeRequest(RequestManager.this.f4725a, RequestManager.this.f4729e, this.f4739c, GenericModelRequest.this.f4735b, GenericModelRequest.this.f4736c, cls, RequestManager.this.f4728d, RequestManager.this.f4726b, RequestManager.this.f4730f));
                if (this.f4740d) {
                    genericTranscodeRequest.mo5225b(this.f4738b);
                }
                return genericTranscodeRequest;
            }
        }
    }

    class OptionsApplier {
        OptionsApplier() {
        }

        /* JADX INFO: renamed from: a */
        public <A, X extends GenericRequestBuilder<A, ?, ?, ?>> X m5292a(X x) {
            if (RequestManager.this.f4731g != null) {
                RequestManager.this.f4731g.m5287a(x);
            }
            return x;
        }
    }

    private static class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {

        /* JADX INFO: renamed from: a */
        private final RequestTracker f4742a;

        public RequestManagerConnectivityListener(RequestTracker requestTracker) {
            this.f4742a = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        /* JADX INFO: renamed from: a */
        public void mo5293a(boolean z) {
            if (z) {
                this.f4742a.m5484d();
            }
        }
    }
}
