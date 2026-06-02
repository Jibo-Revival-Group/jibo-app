package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class GenericRequest<A, T, Z, R> implements Request, ResourceCallback, SizeReadyCallback {

    /* JADX INFO: renamed from: a */
    private static final Queue<GenericRequest<?, ?, ?, ?>> f4934a = Util.m5591a(0);

    /* JADX INFO: renamed from: A */
    private Resource<?> f4935A;

    /* JADX INFO: renamed from: B */
    private Engine.LoadStatus f4936B;

    /* JADX INFO: renamed from: C */
    private long f4937C;

    /* JADX INFO: renamed from: D */
    private Status f4938D;

    /* JADX INFO: renamed from: b */
    private final String f4939b = String.valueOf(hashCode());

    /* JADX INFO: renamed from: c */
    private Key f4940c;

    /* JADX INFO: renamed from: d */
    private Drawable f4941d;

    /* JADX INFO: renamed from: e */
    private int f4942e;

    /* JADX INFO: renamed from: f */
    private int f4943f;

    /* JADX INFO: renamed from: g */
    private int f4944g;

    /* JADX INFO: renamed from: h */
    private Context f4945h;

    /* JADX INFO: renamed from: i */
    private Transformation<Z> f4946i;

    /* JADX INFO: renamed from: j */
    private LoadProvider<A, T, Z, R> f4947j;

    /* JADX INFO: renamed from: k */
    private RequestCoordinator f4948k;

    /* JADX INFO: renamed from: l */
    private A f4949l;

    /* JADX INFO: renamed from: m */
    private Class<R> f4950m;

    /* JADX INFO: renamed from: n */
    private boolean f4951n;

    /* JADX INFO: renamed from: o */
    private Priority f4952o;

    /* JADX INFO: renamed from: p */
    private Target<R> f4953p;

    /* JADX INFO: renamed from: q */
    private RequestListener<? super A, R> f4954q;

    /* JADX INFO: renamed from: r */
    private float f4955r;

    /* JADX INFO: renamed from: s */
    private Engine f4956s;

    /* JADX INFO: renamed from: t */
    private GlideAnimationFactory<R> f4957t;

    /* JADX INFO: renamed from: u */
    private int f4958u;

    /* JADX INFO: renamed from: v */
    private int f4959v;

    /* JADX INFO: renamed from: w */
    private DiskCacheStrategy f4960w;

    /* JADX INFO: renamed from: x */
    private Drawable f4961x;

    /* JADX INFO: renamed from: y */
    private Drawable f4962y;

    /* JADX INFO: renamed from: z */
    private boolean f4963z;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    /* JADX INFO: renamed from: a */
    public static <A, T, Z, R> GenericRequest<A, T, Z, R> m5503a(LoadProvider<A, T, Z, R> loadProvider, A a, Key key, Context context, Priority priority, Target<R> target, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, RequestListener<? super A, R> requestListener, RequestCoordinator requestCoordinator, Engine engine, Transformation<Z> transformation, Class<R> cls, boolean z, GlideAnimationFactory<R> glideAnimationFactory, int i4, int i5, DiskCacheStrategy diskCacheStrategy) {
        GenericRequest<A, T, Z, R> genericRequest = (GenericRequest) f4934a.poll();
        if (genericRequest == null) {
            genericRequest = new GenericRequest<>();
        }
        genericRequest.m5509b(loadProvider, a, key, context, priority, target, f, drawable, i, drawable2, i2, drawable3, i3, requestListener, requestCoordinator, engine, transformation, cls, z, glideAnimationFactory, i4, i5, diskCacheStrategy);
        return genericRequest;
    }

    private GenericRequest() {
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: a */
    public void mo5517a() {
        this.f4947j = null;
        this.f4949l = null;
        this.f4945h = null;
        this.f4953p = null;
        this.f4961x = null;
        this.f4962y = null;
        this.f4941d = null;
        this.f4954q = null;
        this.f4948k = null;
        this.f4946i = null;
        this.f4957t = null;
        this.f4963z = false;
        this.f4936B = null;
        f4934a.offer(this);
    }

    /* JADX INFO: renamed from: b */
    private void m5509b(LoadProvider<A, T, Z, R> loadProvider, A a, Key key, Context context, Priority priority, Target<R> target, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, RequestListener<? super A, R> requestListener, RequestCoordinator requestCoordinator, Engine engine, Transformation<Z> transformation, Class<R> cls, boolean z, GlideAnimationFactory<R> glideAnimationFactory, int i4, int i5, DiskCacheStrategy diskCacheStrategy) {
        this.f4947j = loadProvider;
        this.f4949l = a;
        this.f4940c = key;
        this.f4941d = drawable3;
        this.f4942e = i3;
        this.f4945h = context.getApplicationContext();
        this.f4952o = priority;
        this.f4953p = target;
        this.f4955r = f;
        this.f4961x = drawable;
        this.f4943f = i;
        this.f4962y = drawable2;
        this.f4944g = i2;
        this.f4954q = requestListener;
        this.f4948k = requestCoordinator;
        this.f4956s = engine;
        this.f4946i = transformation;
        this.f4950m = cls;
        this.f4951n = z;
        this.f4957t = glideAnimationFactory;
        this.f4958u = i4;
        this.f4959v = i5;
        this.f4960w = diskCacheStrategy;
        this.f4938D = Status.PENDING;
        if (a != null) {
            m5508a("ModelLoader", loadProvider.mo5495a(), "try .using(ModelLoader)");
            m5508a("Transcoder", loadProvider.mo5498b(), "try .as*(Class).transcode(ResourceTranscoder)");
            m5508a("Transformation", transformation, "try .transform(UnitTransformation.get())");
            if (diskCacheStrategy.cacheSource()) {
                m5508a("SourceEncoder", loadProvider.getSourceEncoder(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                m5508a("SourceDecoder", loadProvider.getSourceDecoder(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (diskCacheStrategy.cacheSource() || diskCacheStrategy.cacheResult()) {
                m5508a("CacheDecoder", loadProvider.getCacheDecoder(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (diskCacheStrategy.cacheResult()) {
                m5508a("Encoder", loadProvider.getEncoder(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5508a(String str, Object obj, String str2) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(" must not be null");
            if (str2 != null) {
                sb.append(", ");
                sb.append(str2);
            }
            throw new NullPointerException(sb.toString());
        }
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: b */
    public void mo5519b() {
        this.f4937C = LogTime.m5581a();
        if (this.f4949l == null) {
            onException(null);
            return;
        }
        this.f4938D = Status.WAITING_FOR_SIZE;
        if (Util.m5593a(this.f4958u, this.f4959v)) {
            mo5518a(this.f4958u, this.f4959v);
        } else {
            this.f4953p.getSize(this);
        }
        if (!mo5524g() && !m5527j() && m5514o()) {
            this.f4953p.onLoadStarted(m5512m());
        }
        if (Log.isLoggable("GenericRequest", 2)) {
            m5507a("finished run method in " + LogTime.m5580a(this.f4937C));
        }
    }

    /* JADX INFO: renamed from: c */
    void m5520c() {
        this.f4938D = Status.CANCELLED;
        if (this.f4936B != null) {
            this.f4936B.cancel();
            this.f4936B = null;
        }
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: d */
    public void mo5521d() {
        Util.m5592a();
        if (this.f4938D != Status.CLEARED) {
            m5520c();
            if (this.f4935A != null) {
                m5504a(this.f4935A);
            }
            if (m5514o()) {
                this.f4953p.onLoadCleared(m5512m());
            }
            this.f4938D = Status.CLEARED;
        }
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: e */
    public void mo5522e() {
        mo5521d();
        this.f4938D = Status.PAUSED;
    }

    /* JADX INFO: renamed from: a */
    private void m5504a(Resource resource) {
        this.f4956s.release(resource);
        this.f4935A = null;
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: f */
    public boolean mo5523f() {
        return this.f4938D == Status.RUNNING || this.f4938D == Status.WAITING_FOR_SIZE;
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: g */
    public boolean mo5524g() {
        return this.f4938D == Status.COMPLETE;
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: h */
    public boolean mo5525h() {
        return mo5524g();
    }

    @Override // com.bumptech.glide.request.Request
    /* JADX INFO: renamed from: i */
    public boolean mo5526i() {
        return this.f4938D == Status.CANCELLED || this.f4938D == Status.CLEARED;
    }

    /* JADX INFO: renamed from: j */
    public boolean m5527j() {
        return this.f4938D == Status.FAILED;
    }

    /* JADX INFO: renamed from: k */
    private Drawable m5510k() {
        if (this.f4941d == null && this.f4942e > 0) {
            this.f4941d = this.f4945h.getResources().getDrawable(this.f4942e);
        }
        return this.f4941d;
    }

    /* JADX INFO: renamed from: a */
    private void m5506a(Exception exc) {
        if (m5514o()) {
            Drawable drawableM5510k = this.f4949l == null ? m5510k() : null;
            if (drawableM5510k == null) {
                drawableM5510k = m5511l();
            }
            if (drawableM5510k == null) {
                drawableM5510k = m5512m();
            }
            this.f4953p.onLoadFailed(exc, drawableM5510k);
        }
    }

    /* JADX INFO: renamed from: l */
    private Drawable m5511l() {
        if (this.f4962y == null && this.f4944g > 0) {
            this.f4962y = this.f4945h.getResources().getDrawable(this.f4944g);
        }
        return this.f4962y;
    }

    /* JADX INFO: renamed from: m */
    private Drawable m5512m() {
        if (this.f4961x == null && this.f4943f > 0) {
            this.f4961x = this.f4945h.getResources().getDrawable(this.f4943f);
        }
        return this.f4961x;
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    /* JADX INFO: renamed from: a */
    public void mo5518a(int i, int i2) {
        if (Log.isLoggable("GenericRequest", 2)) {
            m5507a("Got onSizeReady in " + LogTime.m5580a(this.f4937C));
        }
        if (this.f4938D == Status.WAITING_FOR_SIZE) {
            this.f4938D = Status.RUNNING;
            int iRound = Math.round(this.f4955r * i);
            int iRound2 = Math.round(this.f4955r * i2);
            DataFetcher<T> resourceFetcher = this.f4947j.mo5495a().getResourceFetcher(this.f4949l, iRound, iRound2);
            if (resourceFetcher == null) {
                onException(new Exception("Failed to load model: '" + this.f4949l + "'"));
                return;
            }
            ResourceTranscoder<Z, R> resourceTranscoderMo5498b = this.f4947j.mo5498b();
            if (Log.isLoggable("GenericRequest", 2)) {
                m5507a("finished setup for calling load in " + LogTime.m5580a(this.f4937C));
            }
            this.f4963z = true;
            this.f4936B = this.f4956s.load(this.f4940c, iRound, iRound2, resourceFetcher, this.f4947j, this.f4946i, resourceTranscoderMo5498b, this.f4952o, this.f4951n, this.f4960w, this);
            this.f4963z = this.f4935A != null;
            if (Log.isLoggable("GenericRequest", 2)) {
                m5507a("finished onSizeReady in " + LogTime.m5580a(this.f4937C));
            }
        }
    }

    /* JADX INFO: renamed from: n */
    private boolean m5513n() {
        return this.f4948k == null || this.f4948k.mo5528a(this);
    }

    /* JADX INFO: renamed from: o */
    private boolean m5514o() {
        return this.f4948k == null || this.f4948k.mo5529b(this);
    }

    /* JADX INFO: renamed from: p */
    private boolean m5515p() {
        return this.f4948k == null || !this.f4948k.mo5531c();
    }

    /* JADX INFO: renamed from: q */
    private void m5516q() {
        if (this.f4948k != null) {
            this.f4948k.mo5530c(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    public void onResourceReady(Resource<?> resource) {
        if (resource == null) {
            onException(new Exception("Expected to receive a Resource<R> with an object of " + this.f4950m + " inside, but instead got null."));
            return;
        }
        Object obj = resource.get();
        if (obj == null || !this.f4950m.isAssignableFrom(obj.getClass())) {
            m5504a(resource);
            onException(new Exception("Expected to receive an object of " + this.f4950m + " but instead got " + (obj != null ? obj.getClass() : "") + "{" + obj + "} inside Resource{" + resource + "}." + (obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.")));
        } else if (!m5513n()) {
            m5504a(resource);
            this.f4938D = Status.COMPLETE;
        } else {
            m5505a(resource, obj);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5505a(Resource<?> resource, R r) {
        boolean zM5515p = m5515p();
        this.f4938D = Status.COMPLETE;
        this.f4935A = resource;
        if (this.f4954q == null || !this.f4954q.mo5533a(r, this.f4949l, this.f4953p, this.f4963z, zM5515p)) {
            this.f4953p.onResourceReady(r, this.f4957t.mo5540a(this.f4963z, zM5515p));
        }
        m5516q();
        if (Log.isLoggable("GenericRequest", 2)) {
            m5507a("Resource ready in " + LogTime.m5580a(this.f4937C) + " size: " + (((double) resource.getSize()) * 9.5367431640625E-7d) + " fromCache: " + this.f4963z);
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void onException(Exception exc) {
        if (Log.isLoggable("GenericRequest", 3)) {
            Log.d("GenericRequest", "load failed", exc);
        }
        this.f4938D = Status.FAILED;
        if (this.f4954q == null || !this.f4954q.mo5532a(exc, this.f4949l, this.f4953p, m5515p())) {
            m5506a(exc);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5507a(String str) {
        Log.v("GenericRequest", str + " this: " + this.f4939b);
    }
}
