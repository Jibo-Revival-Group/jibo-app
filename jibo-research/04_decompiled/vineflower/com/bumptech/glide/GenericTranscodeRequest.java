package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.FixedLoadProvider;
import com.bumptech.glide.provider.LoadProvider;

public class GenericTranscodeRequest<ModelType, DataType, ResourceType> extends GenericRequestBuilder<ModelType, DataType, ResourceType, ResourceType> {
   private final ModelLoader<ModelType, DataType> g;
   private final Class<DataType> h;
   private final Class<ResourceType> i;
   private final RequestManager.OptionsApplier j;

   GenericTranscodeRequest(
      Context var1,
      Glide var2,
      Class<ModelType> var3,
      ModelLoader<ModelType, DataType> var4,
      Class<DataType> var5,
      Class<ResourceType> var6,
      RequestTracker var7,
      Lifecycle var8,
      RequestManager.OptionsApplier var9
   ) {
      super(var1, var3, a(var2, var4, var5, var6, UnitTranscoder.get()), var6, var2, var7, var8);
      this.g = var4;
      this.h = var5;
      this.i = var6;
      this.j = var9;
   }

   private static <A, T, Z, R> LoadProvider<A, T, Z, R> a(Glide var0, ModelLoader<A, T> var1, Class<T> var2, Class<Z> var3, ResourceTranscoder<Z, R> var4) {
      return new FixedLoadProvider<>(var1, var4, var0.b(var2, var3));
   }
}
