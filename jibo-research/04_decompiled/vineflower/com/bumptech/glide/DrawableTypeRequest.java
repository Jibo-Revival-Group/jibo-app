package com.bumptech.glide;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.ImageVideoModelLoader;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.provider.FixedLoadProvider;
import java.io.InputStream;

public class DrawableTypeRequest<ModelType> extends DrawableRequestBuilder<ModelType> {
   private final ModelLoader<ModelType, InputStream> g;
   private final ModelLoader<ModelType, ParcelFileDescriptor> h;
   private final RequestManager.OptionsApplier i;

   DrawableTypeRequest(
      Class<ModelType> var1,
      ModelLoader<ModelType, InputStream> var2,
      ModelLoader<ModelType, ParcelFileDescriptor> var3,
      Context var4,
      Glide var5,
      RequestTracker var6,
      Lifecycle var7,
      RequestManager.OptionsApplier var8
   ) {
      super(var4, var1, a(var5, var2, var3, GifBitmapWrapper.class, GlideDrawable.class, null), var5, var6, var7);
      this.g = var2;
      this.h = var3;
      this.i = var8;
   }

   private static <A, Z, R> FixedLoadProvider<A, ImageVideoWrapper, Z, R> a(
      Glide var0, ModelLoader<A, InputStream> var1, ModelLoader<A, ParcelFileDescriptor> var2, Class<Z> var3, Class<R> var4, ResourceTranscoder<Z, R> var5
   ) {
      FixedLoadProvider var8;
      if (var1 == null && var2 == null) {
         var8 = null;
      } else {
         ResourceTranscoder var6 = var5;
         if (var5 == null) {
            var6 = var0.a(var3, var4);
         }

         DataLoadProvider var7 = var0.b(ImageVideoWrapper.class, var3);
         var8 = new FixedLoadProvider<>(new ImageVideoModelLoader<>(var1, var2), var6, var7);
      }

      return var8;
   }
}
