package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import java.io.InputStream;

public class HttpUrlGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {
   private final ModelCache<GlideUrl, GlideUrl> modelCache;

   public HttpUrlGlideUrlLoader() {
      this(null);
   }

   public HttpUrlGlideUrlLoader(ModelCache<GlideUrl, GlideUrl> var1) {
      this.modelCache = var1;
   }

   public DataFetcher<InputStream> getResourceFetcher(GlideUrl var1, int var2, int var3) {
      GlideUrl var4 = var1;
      if (this.modelCache != null) {
         var4 = this.modelCache.get(var1, 0, 0);
         if (var4 == null) {
            this.modelCache.put(var1, 0, 0, var1);
            var4 = var1;
         }
      }

      return new HttpUrlFetcher(var4);
   }

   public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
      private final ModelCache<GlideUrl, GlideUrl> modelCache = new ModelCache<>(500);

      @Override
      public ModelLoader<GlideUrl, InputStream> build(Context var1, GenericLoaderFactory var2) {
         return new HttpUrlGlideUrlLoader(this.modelCache);
      }

      @Override
      public void teardown() {
      }
   }
}
