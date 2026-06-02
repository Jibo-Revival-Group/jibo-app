package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader;
import java.io.InputStream;

public class StreamResourceLoader extends ResourceLoader<InputStream> implements StreamModelLoader<Integer> {
   public StreamResourceLoader(Context var1, ModelLoader<Uri, InputStream> var2) {
      super(var1, var2);
   }

   public static class Factory implements ModelLoaderFactory<Integer, InputStream> {
      @Override
      public ModelLoader<Integer, InputStream> build(Context var1, GenericLoaderFactory var2) {
         return new StreamResourceLoader(var1, var2.buildModelLoader(Uri.class, InputStream.class));
      }

      @Override
      public void teardown() {
      }
   }
}
