package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.UrlLoader;
import java.io.InputStream;
import java.net.URL;

public class StreamUrlLoader extends UrlLoader<InputStream> {
   public StreamUrlLoader(ModelLoader<GlideUrl, InputStream> var1) {
      super(var1);
   }

   public static class Factory implements ModelLoaderFactory<URL, InputStream> {
      @Override
      public ModelLoader<URL, InputStream> build(Context var1, GenericLoaderFactory var2) {
         return new StreamUrlLoader(var2.buildModelLoader(GlideUrl.class, InputStream.class));
      }

      @Override
      public void teardown() {
      }
   }
}
