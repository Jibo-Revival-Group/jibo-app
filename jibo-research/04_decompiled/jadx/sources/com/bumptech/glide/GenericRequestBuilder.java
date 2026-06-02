package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.ChildLoadProvider;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.GenericRequest;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.animation.NoAnimation;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.Util;

/* JADX INFO: loaded from: classes.dex */
public class GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {

    /* JADX INFO: renamed from: A */
    private boolean f4668A;

    /* JADX INFO: renamed from: B */
    private Drawable f4669B;

    /* JADX INFO: renamed from: C */
    private int f4670C;

    /* JADX INFO: renamed from: a */
    protected final Class<ModelType> f4671a;

    /* JADX INFO: renamed from: b */
    protected final Context f4672b;

    /* JADX INFO: renamed from: c */
    protected final Glide f4673c;

    /* JADX INFO: renamed from: d */
    protected final Class<TranscodeType> f4674d;

    /* JADX INFO: renamed from: e */
    protected final RequestTracker f4675e;

    /* JADX INFO: renamed from: f */
    protected final Lifecycle f4676f;

    /* JADX INFO: renamed from: g */
    private ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> f4677g;

    /* JADX INFO: renamed from: h */
    private ModelType f4678h;

    /* JADX INFO: renamed from: j */
    private boolean f4680j;

    /* JADX INFO: renamed from: k */
    private int f4681k;

    /* JADX INFO: renamed from: l */
    private int f4682l;

    /* JADX INFO: renamed from: m */
    private RequestListener<? super ModelType, TranscodeType> f4683m;

    /* JADX INFO: renamed from: n */
    private Float f4684n;

    /* JADX INFO: renamed from: o */
    private GenericRequestBuilder<?, ?, ?, TranscodeType> f4685o;

    /* JADX INFO: renamed from: q */
    private Drawable f4687q;

    /* JADX INFO: renamed from: r */
    private Drawable f4688r;

    /* JADX INFO: renamed from: z */
    private boolean f4696z;

    /* JADX INFO: renamed from: i */
    private Key f4679i = EmptySignature.m5570a();

    /* JADX INFO: renamed from: p */
    private Float f4686p = Float.valueOf(1.0f);

    /* JADX INFO: renamed from: s */
    private Priority f4689s = null;

    /* JADX INFO: renamed from: t */
    private boolean f4690t = true;

    /* JADX INFO: renamed from: u */
    private GlideAnimationFactory<TranscodeType> f4691u = NoAnimation.m5547a();

    /* JADX INFO: renamed from: v */
    private int f4692v = -1;

    /* JADX INFO: renamed from: w */
    private int f4693w = -1;

    /* JADX INFO: renamed from: x */
    private DiskCacheStrategy f4694x = DiskCacheStrategy.RESULT;

    /* JADX INFO: renamed from: y */
    private Transformation<ResourceType> f4695y = UnitTransformation.get();

    GenericRequestBuilder(Context context, Class<ModelType> cls, LoadProvider<ModelType, DataType, ResourceType, TranscodeType> loadProvider, Class<TranscodeType> cls2, Glide glide, RequestTracker requestTracker, Lifecycle lifecycle) {
        this.f4672b = context;
        this.f4671a = cls;
        this.f4674d = cls2;
        this.f4673c = glide;
        this.f4675e = requestTracker;
        this.f4676f = lifecycle;
        this.f4677g = loadProvider != null ? new ChildLoadProvider<>(loadProvider) : null;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        }
        if (cls != null && loadProvider == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    /* JADX INFO: renamed from: b */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5222b(ResourceDecoder<DataType, ResourceType> resourceDecoder) {
        if (this.f4677g != null) {
            this.f4677g.m5497a(resourceDecoder);
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5220b(Encoder<DataType> encoder) {
        if (this.f4677g != null) {
            this.f4677g.m5496a(encoder);
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5223b(DiskCacheStrategy diskCacheStrategy) {
        this.f4694x = diskCacheStrategy;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5227b(Transformation<ResourceType>... transformationArr) {
        this.f4696z = true;
        if (transformationArr.length == 1) {
            this.f4695y = transformationArr[0];
        } else {
            this.f4695y = new MultiTransformation(transformationArr);
        }
        return this;
    }

    /* JADX INFO: renamed from: k */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5240k() {
        return mo5227b((Transformation[]) new Transformation[]{UnitTransformation.get()});
    }

    /* JADX INFO: renamed from: j */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5239j() {
        return m5246a(NoAnimation.m5547a());
    }

    /* JADX INFO: renamed from: a */
    GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> m5246a(GlideAnimationFactory<TranscodeType> glideAnimationFactory) {
        if (glideAnimationFactory == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.f4691u = glideAnimationFactory;
        return this;
    }

    /* JADX INFO: renamed from: f */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5235f(int i) {
        this.f4681k = i;
        return this;
    }

    /* JADX INFO: renamed from: e */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5233e(int i) {
        this.f4670C = i;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5231d(int i) {
        this.f4682l = i;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5224b(RequestListener<? super ModelType, TranscodeType> requestListener) {
        this.f4683m = requestListener;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5226b(boolean z) {
        this.f4690t = !z;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5219b(int i, int i2) {
        if (!Util.m5593a(i, i2)) {
            throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
        }
        this.f4693w = i;
        this.f4692v = i2;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5221b(Key key) {
        if (key == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.f4679i = key;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5225b(ModelType modeltype) {
        this.f4678h = modeltype;
        this.f4680j = true;
        return this;
    }

    @Override // 
    /* JADX INFO: renamed from: i */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo5238i() {
        try {
            GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> genericRequestBuilder = (GenericRequestBuilder) super.clone();
            genericRequestBuilder.f4677g = this.f4677g != null ? this.f4677g.clone() : null;
            return genericRequestBuilder;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public <Y extends Target<TranscodeType>> Y m5247a(Y y) {
        Util.m5592a();
        if (y == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        }
        if (!this.f4680j) {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
        Request request = y.getRequest();
        if (request != null) {
            request.mo5521d();
            this.f4675e.m5482b(request);
            request.mo5517a();
        }
        Request requestM5245b = m5245b((Target) y);
        y.setRequest(requestM5245b);
        this.f4676f.mo5452a(y);
        this.f4675e.m5480a(requestM5245b);
        return y;
    }

    /* JADX INFO: renamed from: a */
    public Target<TranscodeType> mo5216a(ImageView imageView) {
        Util.m5592a();
        if (imageView == null) {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (!this.f4696z && imageView.getScaleType() != null) {
            switch (C03512.f4697a[imageView.getScaleType().ordinal()]) {
                case 1:
                    mo5237h();
                    break;
                case 2:
                case 3:
                case 4:
                    mo5236g();
                    break;
            }
        }
        return m5247a(this.f4673c.m5259a(imageView, this.f4674d));
    }

    /* JADX INFO: renamed from: com.bumptech.glide.GenericRequestBuilder$2 */
    static /* synthetic */ class C03512 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f4697a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f4697a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4697a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4697a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4697a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: renamed from: h */
    void mo5237h() {
    }

    /* JADX INFO: renamed from: g */
    void mo5236g() {
    }

    /* JADX INFO: renamed from: a */
    private Priority m5242a() {
        if (this.f4689s == Priority.LOW) {
            return Priority.NORMAL;
        }
        if (this.f4689s == Priority.NORMAL) {
            return Priority.HIGH;
        }
        return Priority.IMMEDIATE;
    }

    /* JADX INFO: renamed from: b */
    private Request m5245b(Target<TranscodeType> target) {
        if (this.f4689s == null) {
            this.f4689s = Priority.NORMAL;
        }
        return m5244a(target, null);
    }

    /* JADX INFO: renamed from: a */
    private Request m5244a(Target<TranscodeType> target, ThumbnailRequestCoordinator thumbnailRequestCoordinator) {
        if (this.f4685o != null) {
            if (this.f4668A) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            if (this.f4685o.f4691u.equals(NoAnimation.m5547a())) {
                this.f4685o.f4691u = this.f4691u;
            }
            if (this.f4685o.f4689s == null) {
                this.f4685o.f4689s = m5242a();
            }
            if (Util.m5593a(this.f4693w, this.f4692v) && !Util.m5593a(this.f4685o.f4693w, this.f4685o.f4692v)) {
                this.f4685o.mo5219b(this.f4693w, this.f4692v);
            }
            ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(thumbnailRequestCoordinator);
            Request requestM5243a = m5243a(target, this.f4686p.floatValue(), this.f4689s, thumbnailRequestCoordinator2);
            this.f4668A = true;
            Request requestM5244a = this.f4685o.m5244a(target, thumbnailRequestCoordinator2);
            this.f4668A = false;
            thumbnailRequestCoordinator2.m5537a(requestM5243a, requestM5244a);
            return thumbnailRequestCoordinator2;
        }
        if (this.f4684n != null) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator3 = new ThumbnailRequestCoordinator(thumbnailRequestCoordinator);
            thumbnailRequestCoordinator3.m5537a(m5243a(target, this.f4686p.floatValue(), this.f4689s, thumbnailRequestCoordinator3), m5243a(target, this.f4684n.floatValue(), m5242a(), thumbnailRequestCoordinator3));
            return thumbnailRequestCoordinator3;
        }
        return m5243a(target, this.f4686p.floatValue(), this.f4689s, thumbnailRequestCoordinator);
    }

    /* JADX INFO: renamed from: a */
    private Request m5243a(Target<TranscodeType> target, float f, Priority priority, RequestCoordinator requestCoordinator) {
        return GenericRequest.m5503a(this.f4677g, this.f4678h, this.f4679i, this.f4672b, priority, target, f, this.f4687q, this.f4681k, this.f4688r, this.f4682l, this.f4669B, this.f4670C, this.f4683m, requestCoordinator, this.f4673c.m5262b(), this.f4695y, this.f4674d, this.f4690t, this.f4691u, this.f4693w, this.f4692v, this.f4694x);
    }
}
