package com.bumptech.glide;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.DrawableCrossFadeFactory;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: classes.dex */
public class DrawableRequestBuilder<ModelType> extends GenericRequestBuilder<ModelType, ImageVideoWrapper, GifBitmapWrapper, GlideDrawable> {
    DrawableRequestBuilder(Context context, Class<ModelType> cls, LoadProvider<ModelType, ImageVideoWrapper, GifBitmapWrapper, GlideDrawable> loadProvider, Glide glide, RequestTracker requestTracker, Lifecycle lifecycle) {
        super(context, cls, loadProvider, GlideDrawable.class, glide, requestTracker, lifecycle);
        m5228c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5222b(ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> resourceDecoder) {
        super.mo5222b((ResourceDecoder) resourceDecoder);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public DrawableRequestBuilder<ModelType> m5205a() {
        return mo5227b(this.f4673c.m5264c());
    }

    /* JADX INFO: renamed from: b */
    public DrawableRequestBuilder<ModelType> m5217b() {
        return mo5227b(this.f4673c.m5265d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5227b(Transformation<GifBitmapWrapper>... transformationArr) {
        super.mo5227b((Transformation[]) transformationArr);
        return this;
    }

    /* JADX INFO: renamed from: c */
    public final DrawableRequestBuilder<ModelType> m5228c() {
        super.m5246a((GlideAnimationFactory) new DrawableCrossFadeFactory());
        return this;
    }

    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5239j() {
        super.mo5239j();
        return this;
    }

    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5235f(int i) {
        super.mo5235f(i);
        return this;
    }

    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5233e(int i) {
        super.mo5233e(i);
        return this;
    }

    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5231d(int i) {
        super.mo5231d(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5224b(RequestListener<? super ModelType, GlideDrawable> requestListener) {
        super.mo5224b((RequestListener) requestListener);
        return this;
    }

    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5223b(DiskCacheStrategy diskCacheStrategy) {
        super.mo5223b(diskCacheStrategy);
        return this;
    }

    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5226b(boolean z) {
        super.mo5226b(z);
        return this;
    }

    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5219b(int i, int i2) {
        super.mo5219b(i, i2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5220b(Encoder<ImageVideoWrapper> encoder) {
        super.mo5220b((Encoder) encoder);
        return this;
    }

    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5240k() {
        super.mo5240k();
        return this;
    }

    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5221b(Key key) {
        super.mo5221b(key);
        return this;
    }

    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5225b(ModelType modeltype) {
        super.mo5225b(modeltype);
        return this;
    }

    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public DrawableRequestBuilder<ModelType> mo5238i() {
        return (DrawableRequestBuilder) super.mo5238i();
    }

    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: a */
    public Target<GlideDrawable> mo5216a(ImageView imageView) {
        return super.mo5216a(imageView);
    }

    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: g */
    void mo5236g() {
        m5217b();
    }

    @Override // com.bumptech.glide.GenericRequestBuilder
    /* JADX INFO: renamed from: h */
    void mo5237h() {
        m5205a();
    }
}
