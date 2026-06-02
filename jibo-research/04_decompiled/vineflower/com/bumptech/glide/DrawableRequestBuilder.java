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
import com.bumptech.glide.request.target.Target;

public class DrawableRequestBuilder<ModelType> extends GenericRequestBuilder<ModelType, ImageVideoWrapper, GifBitmapWrapper, GlideDrawable> {
   DrawableRequestBuilder(
      Context var1,
      Class<ModelType> var2,
      LoadProvider<ModelType, ImageVideoWrapper, GifBitmapWrapper, GlideDrawable> var3,
      Glide var4,
      RequestTracker var5,
      Lifecycle var6
   ) {
      super(var1, var2, var3, GlideDrawable.class, var4, var5, var6);
      this.c();
   }

   public DrawableRequestBuilder<ModelType> a() {
      return this.a(this.c.c());
   }

   public DrawableRequestBuilder<ModelType> a(int var1) {
      super.f(var1);
      return this;
   }

   public DrawableRequestBuilder<ModelType> a(int var1, int var2) {
      super.b(var1, var2);
      return this;
   }

   public DrawableRequestBuilder<ModelType> a(Encoder<ImageVideoWrapper> var1) {
      super.b(var1);
      return this;
   }

   public DrawableRequestBuilder<ModelType> a(Key var1) {
      super.b(var1);
      return this;
   }

   public DrawableRequestBuilder<ModelType> a(ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> var1) {
      super.b(var1);
      return this;
   }

   public DrawableRequestBuilder<ModelType> a(DiskCacheStrategy var1) {
      super.b(var1);
      return this;
   }

   public DrawableRequestBuilder<ModelType> a(RequestListener<? super ModelType, GlideDrawable> var1) {
      super.b(var1);
      return this;
   }

   public DrawableRequestBuilder<ModelType> a(ModelType var1) {
      super.b((ModelType)var1);
      return this;
   }

   public DrawableRequestBuilder<ModelType> a(boolean var1) {
      super.b(var1);
      return this;
   }

   public DrawableRequestBuilder<ModelType> a(Transformation<GifBitmapWrapper>... var1) {
      super.b(var1);
      return this;
   }

   @Override
   public Target<GlideDrawable> a(ImageView var1) {
      return super.a(var1);
   }

   public DrawableRequestBuilder<ModelType> b() {
      return this.a(this.c.d());
   }

   public DrawableRequestBuilder<ModelType> b(int var1) {
      super.e(var1);
      return this;
   }

   public final DrawableRequestBuilder<ModelType> c() {
      super.a(new DrawableCrossFadeFactory());
      return this;
   }

   public DrawableRequestBuilder<ModelType> c(int var1) {
      super.d(var1);
      return this;
   }

   public DrawableRequestBuilder<ModelType> d() {
      super.j();
      return this;
   }

   public DrawableRequestBuilder<ModelType> e() {
      super.k();
      return this;
   }

   public DrawableRequestBuilder<ModelType> f() {
      return (DrawableRequestBuilder<ModelType>)super.i();
   }

   @Override
   void g() {
      this.b();
   }

   @Override
   void h() {
      this.a();
   }
}
