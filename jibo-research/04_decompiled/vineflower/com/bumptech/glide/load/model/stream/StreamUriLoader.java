package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.UriLoader;
import java.io.InputStream;

public class StreamUriLoader extends UriLoader<InputStream> implements StreamModelLoader<Uri> {
   public StreamUriLoader(Context var1, ModelLoader<GlideUrl, InputStream> var2) {
      super(var1, var2);
   }

   @Override
   protected DataFetcher<InputStream> getAssetPathFetcher(Context var1, String var2) {
      return new StreamAssetPathFetcher(var1.getApplicationContext().getAssets(), var2);
   }

   @Override
   protected DataFetcher<InputStream> getLocalUriFetcher(Context var1, Uri var2) {
      return new StreamLocalUriFetcher(var1, var2);
   }

   public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
      @Override
      public ModelLoader<Uri, InputStream> build(Context var1, GenericLoaderFactory var2) {
         return new StreamUriLoader(var1, var2.buildModelLoader(GlideUrl.class, InputStream.class));
      }

      @Override
      public void teardown() {
      }
   }
}
